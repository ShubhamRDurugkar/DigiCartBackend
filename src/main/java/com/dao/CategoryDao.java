package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao {
	boolean insertCategory(Category category);

	boolean updateCategory(Category category);

	boolean deleteCategory(int cid);

	Category getCategory(String id);

	List<Category> getAllCategories();

}
