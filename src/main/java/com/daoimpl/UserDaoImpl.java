package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
import com.dao.UserDao;
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
@Autowired
private SessionFactory sessionFactory;
	private static List<User> list = new ArrayList<User>();
	static {
		User user = new User();
		user.setName("Shubham");
		user.setPassword("shubham123");
		user.setEmail("shubham123@gmail.com");
		user.setAddress("Ghatkopar,Mumbai");
		user.setPhone("8978546612");
		user.setCountry("India");
		list.add(user);
	}

  public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

public UserDaoImpl(SessionFactory sf) {
	// TODO Auto-generated constructor stub
}

@Transactional
	public boolean insert(User user) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
	}
public void insertUser(User user) {
	
}
public void updateUser(User user) {
	
}
public void deleteUser(User user) {
	
}
public User getUserById(int id) {
	return null;
}
public List<User> getAllUsers() {
	return list;
}

}
