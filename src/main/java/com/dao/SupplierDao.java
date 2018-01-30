package com.dao;



import java.util.List;

import com.model.Supplier;
public interface SupplierDao {
Supplier get(int id);
List<Supplier> getAllSuppliers();
boolean insertSupp(Supplier supp);
boolean updateSupp(Supplier supp);
boolean deleteSupp(int  i);
}
