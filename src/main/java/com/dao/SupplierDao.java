package com.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Supplier;

@Component

public interface SupplierDao {
	Supplier get(int id);

	List<Supplier> getAllSuppliers();

	boolean insertSupp(Supplier supp);

	boolean updateSupp(Supplier supp);

	boolean deleteSupp(int i);

}
