package com.sunny.expensetracker.services;

import com.sunny.expensetracker.domain.User;
import com.sunny.expensetracker.exceptions.EtAuthException;

public interface UserService {
	User validateUser(String email, String password) throws EtAuthException;
	
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
