//package com.DigiCartBackend.test;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.dao.CategoryDao;
//import com.model.Category;
//
//public class CategoryTestCase {
//
//	private static AnnotationConfigApplicationContext context;
//	private static CategoryDao categoryDao;
//	private Category category;
//
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com");
//		context.refresh();
//		categoryDao = (CategoryDao) context.getBean("categoryDao");
//	}
//
////	@Test
////	public void testAddCategory() {
////		category = new Category();
////		category.setCname("Electronics");
////		assertEquals("Successfully added a supplier details into the table", true, categoryDao.insertCategory(category));
////	}
//
//	@Test
//	 public void testGetSupplier(){
//	 category=categoryDao.get(6);
//	 assertEquals("Successfully fetched a supplier details from the table","Electronics",category.getCname());
//	 }
//
////	@Test
////	 public void testUpdateSupplier(){
////		category=categoryDao.get(1);
//	
////		category.setCname("Mobiles");
////	 assertEquals("Successfully updated a supplier details from the table",true, categoryDao.updateCategory(category));
////	 }
////
////	@Test
////	public void testDeleteSupplier() {
////		assertEquals("Successfully deleted supplier details from the table", true, categoryDao.deleteCategory(1));
////	}
////	@Test
////	public void testGetAllSupplier() {
////		assertEquals("Successfully fetched all supplier details from the table",1, categoryDao.getAllCategories().size());
////	}
//}
