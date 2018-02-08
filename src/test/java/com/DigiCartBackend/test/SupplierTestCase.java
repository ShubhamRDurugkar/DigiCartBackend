package com.DigiCartBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SupplierDao;
import com.model.Supplier;

public class SupplierTestCase {
	private static AnnotationConfigApplicationContext context;
	private static SupplierDao supplierDao;
	private Supplier supplier;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDAO");
	}
//
//	@Test
//	public void testAddSupplier() {
//		supplier = new Supplier();
//		//supplier.setSid(sid);
//		supplier.setSname("Akash");
//		assertEquals("Successfully added a supplier details into the table", true, supplierDao.insertSupp(supplier));
//	}

//	@Test
//	 public void testGetSupplier(){
//	 supplier=supplierDao.get(1);
//	 assertEquals("Successfully fetched a supplier details from the table","xyz", supplier.getSname());
//	 }
//
//	@Test
//	 public void testUpdateSupplier(){
//	 supplier=supplierDao.get(1);
//	 supplier.setSname("xyz");
//	 assertEquals("Successfully updated a supplier details from the table",true, supplierDao.updateSupp(supplier));
//	 }

//	@Test
//	public void testDeleteSupplier() {
//		assertEquals("Successfully deleted supplier details from the table", true, supplierDao.deleteSupp(7));
//	}
	@Test
	public void testGetAllSupplier() {
		assertEquals("Successfully fetched all supplier details from the table",3, supplierDao.getAllSuppliers().size());
	}
}
