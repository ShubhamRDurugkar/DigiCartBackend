package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;
@Repository("userDao")
@Transactional
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


public boolean insertUser(User user) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
}
public boolean updateUser(User user) {
	try {
		sessionFactory.getCurrentSession().update(user);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
public boolean deleteUser(String email) {
	User user = (User) sessionFactory.getCurrentSession().load(User.class, email);
	try {
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
public User getUserById(int id) {
	return null;
}
@SuppressWarnings("unchecked")
public List<User> getAllUsers() {
	return sessionFactory.getCurrentSession().createQuery("from User").list();

}

public User getEmail(String email) {
	return sessionFactory.getCurrentSession().get(User.class, String.valueOf(email));
}



}
