package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;
@Service
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	private static List<User> userList = new ArrayList<User>();
    
   @Autowired
	public UserDaoImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	public boolean insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean deleteUser(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) sessionFactory.getCurrentSession().load(User.class, email);
		try {
			if (null != user) {
				this.sessionFactory.getCurrentSession().delete(user);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("FROM User");
		userList = query.list();
		session.getTransaction().commit();
		session.close();
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, email);
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
