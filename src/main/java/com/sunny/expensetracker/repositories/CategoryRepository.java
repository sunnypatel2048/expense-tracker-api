package com.sunny.expensetracker.repositories;

import java.util.List;

import com.sunny.expensetracker.domain.Category;
import com.sunny.expensetracker.exceptions.EtBadRequestException;
import com.sunny.expensetracker.exceptions.EtResourceNotFoundException;

public interface CategoryRepository {

	List<Category> findAll(Integer userId) throws EtResourceNotFoundException;
	
	Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
	
	Integer create(Integer userId, String title, String description) throws EtBadRequestException;
	
	void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
	
	void removeById(Integer userId, Integer categoryId);
}
