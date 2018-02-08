package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	void insertProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Product product);

	Product getProduct(int id);

	List<Product> getAllProducts();
}
