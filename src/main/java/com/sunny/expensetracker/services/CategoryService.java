package com.sunny.expensetracker.services;

import java.util.List;

import com.sunny.expensetracker.domain.Category;
import com.sunny.expensetracker.exceptions.EtBadRequestException;
import com.sunny.expensetracker.exceptions.EtResourceNotFoundException;

public interface CategoryService {

	List<Category> fetchAllCategories(Integer userId);
	
	Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
	
	Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;
	
	void updateCategory (Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
	
	void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}
