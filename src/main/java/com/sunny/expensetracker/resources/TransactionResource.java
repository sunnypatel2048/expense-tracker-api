package com.sunny.expensetracker.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.expensetracker.domain.Transaction;
import com.sunny.expensetracker.services.TransactionService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionResource {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("")
	public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request, 
												@PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		List<Transaction> transactions = transactionService.fetchAllTransactions(userId, categoryId);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request,
															@PathVariable("categoryId") Integer categoryId,
															@PathVariable("transactionId") Integer transactionId) {
		int userId = (Integer) request.getAttribute("userId");
		Transaction transaction = transactionService.fetchTransactionById(userId, categoryId, transactionId);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Transaction> addTransaction(HttpServletRequest request, 
														@PathVariable("categoryId") Integer categoryId,
														@RequestBody Map<String, Object> transactionMap) {
		int userId = (Integer) request.getAttribute("userId");
		double amount = Double.parseDouble(transactionMap.get("amount").toString());
		String note = (String) transactionMap.get("note");
		long transactionDate = Long.parseLong(transactionMap.get("transactionDate").toString());
		Transaction transaction = transactionService.addTransaction(userId, categoryId, amount, note, transactionDate);
		return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	}
	
	@PutMapping("/{transactionId}")
	public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request,
																	@RequestBody Transaction transaction,
																	@PathVariable("categoryId") Integer categoryId,
																	@PathVariable("transactionId") Integer transactionId) {
		int userId = (Integer) request.getAttribute("userId");
		transactionService.updateTransaction(userId, categoryId, transactionId, transaction);
		Map<String, Boolean> map = new HashMap<>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/{transactionId}")
	public ResponseEntity<Map<String, Boolean>> deteteTransaction(HttpServletRequest request, 
																	@PathVariable("categoryId") Integer categoryId, 
																	@PathVariable("transactionId") Integer transactionId) {
		int userId = (Integer) request.getAttribute("userId");
		transactionService.removeTransaction(userId, categoryId, transactionId);
		Map<String, Boolean> map = new HashMap<>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
