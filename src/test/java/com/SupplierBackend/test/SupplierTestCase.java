package com.SupplierBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SupplierDao;
import com.model.Supplier;

public class SupplierTestCase {
	private static AnnotationConfigApplicationContext context;
	private static SupplierDao supplierDAO;
	private Supplier supplier;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDAO = (SupplierDao) context.getBean("supplierDAO");
	}

//	@Test
//	public void testAddSupplier() {
//		supplier = new Supplier();
//		supplier.setName("Akash");
//		assertEquals("Successfully added a supplier details into the table", true, supplierDAO.insertSupp(supplier));
//	}

	@Test
	 public void testGetSupplier(){
	 supplier=supplierDAO.get(1);
	 assertEquals("Successfully fetched a supplier details from the table","Shubham", supplier.getName());
	 }

	@Test
	 public void testUpdateSupplier(){
	 supplier=supplierDAO.get(2);
	 supplier.setName("Omkar");
	 assertEquals("Successfully updated a supplier details from the table",true, supplierDAO.updateSupp(supplier));
	 }

	@Test
	public void testDeleteSupplier() {
		assertEquals("Successfully deleted supplier details from the table", true, supplierDAO.deleteSupp(7));
	}
	@Test
	public void testGetAllSupplier() {
		assertEquals("Successfully fetched all supplier details from the table",3, supplierDAO.getAllSuppliers().size());
	}
}
