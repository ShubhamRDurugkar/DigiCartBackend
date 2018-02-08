package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(String email);

	User getUserById(int id);

	List<User> getAllUsers();

	User getEmail(String email);

}
