package com.sunny.expensetracker.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunny.expensetracker.domain.Transaction;
import com.sunny.expensetracker.exceptions.EtBadRequestException;
import com.sunny.expensetracker.exceptions.EtResourceNotFoundException;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Transaction> findAll(Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
			throws EtBadRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
			throws EtBadRequestException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException {
		// TODO Auto-generated method stub

	}

}
