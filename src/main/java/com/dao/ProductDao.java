package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	void insertProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int pid);

	Product getProductById(int id);

	List<Product> retrieveProducts();
}
