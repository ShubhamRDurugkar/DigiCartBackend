package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(String email);

	List<User> getAllUsers();

	User getUserByEmail(String name);

}
