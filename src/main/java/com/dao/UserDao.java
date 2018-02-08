package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	
	//boolean insert(User user);

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User getUserById(int id);

	List<User> getAllUsers();

}
