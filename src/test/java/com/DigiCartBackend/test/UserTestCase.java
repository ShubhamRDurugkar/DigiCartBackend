package com.DigiCartBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.UserDao;
import com.model.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
	}

	//@Test
//	public void testAddUser() {
//		user = new User();
//		//supplier.setSid(sid);
//		user.setName("Shubham");
//		user.setEmail("shubham341.@gmail.com");
//		user.setAddress("Ghatkopar,Mumbai");
//		user.setCountry("India");
//		user.setEnabled(true);
//		user.setPassword("shubham123");
//		user.setRole("TM");
//		user.setPhone("8427932723");
//		assertEquals("Successfully added a supplier details into the table", true, userDao.insertUser(user));
//	}
//
	@Test
	 public void testGetUser(){
	 user=userDao.getEmail("shubham341.@gmail.com");
	 assertEquals("Successfully fetched a supplier details from the table","Shubham R Durugkar", user.getName());
	 }

//	@Test
//	 public void testUpdateUser(){
//	 user=userDao.getEmail("shubham341.@gmail.com");
//	 user.setName("Shubham R Durugkar");
//	// user.setEmail("shubham341.rd@gmail.com");
//	 assertEquals("Successfully updated a supplier details from the table",true, userDao.updateUser(user));
//	 }

//	@Test
//	public void testDeleteSupplier() {
//		assertEquals("Successfully deleted supplier details from the table", true, supplierDao.deleteSupp(7));
//	}
//	@Test
//	public void testGetAllUser() {
//		assertEquals("Successfully fetched all supplier details from the table",1, userDao.getAllUsers().size());
//	}

}
