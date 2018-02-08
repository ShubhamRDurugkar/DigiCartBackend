package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao {
	void insertCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(Category category);

	Category getCategory(String id);

	List<Category> getAllCategories();
}
