package com.sunny.expensetracker.repositories;

import com.sunny.expensetracker.domain.User;
import com.sunny.expensetracker.exceptions.EtAuthException;

public interface UserRepository {
	
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	
	User findByEmailAndPassword(String email, String password) throws EtAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer userId);
}
