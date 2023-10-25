package com.sunny.expensetracker.resources;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.expensetracker.Constants;
import com.sunny.expensetracker.domain.User;
import com.sunny.expensetracker.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
		String firstName = (String) userMap.get("firstName");
		String lastName = (String) userMap.get("lastName");
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		
		User user = userService.registerUser(firstName, lastName, email, password);
		return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		User user = userService.validateUser(email, password);
		return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
	}
	
	private Map<String, String> generateJWTToken(User user) {
		long timestamp = System.currentTimeMillis();
		Key key = Keys.hmacShaKeyFor(Constants.API_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
		
		String token = Jwts.builder().signWith(key)
				.issuedAt(new Date(timestamp))
				.expiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
				.claim("userId", user.getUserId())
				.claim("email", user.getEmail())
				.claim("firstName", user.getFirstName())
				.claim("lastName", user.getLastName())
				.compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		return map;
	}
}
