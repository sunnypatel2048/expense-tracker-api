package com.sunny.expensetracker.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.expensetracker.domain.Category;
import com.sunny.expensetracker.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public String getAllCategories(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		return "Authenticated! UserId: " + userId;
	}
	
	@PostMapping("")
	public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap) {
		int userId = (Integer) request.getAttribute("userId");
		String title = (String) categoryMap.get("title");
		String description = (String) categoryMap.get("description");
		Category category = categoryService.addCategory(userId, title, description);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

}
