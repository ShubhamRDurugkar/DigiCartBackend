package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.model.Category;

@Repository("categoryDao")
@Service

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	public boolean insertCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public boolean updateCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean deleteCategory(int cid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, cid);
		try {
			if (null != category) {
				session.delete(category);
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

	public Category getCategory(String cid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = (Category) session.get(Category.class, cid);
		session.getTransaction().commit();
		session.close();
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		List<Category> catList = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Category> query = session.createQuery("FROM Category");
		catList = query.list();
		session.getTransaction().commit();
		session.close();
		return catList;
	}

}
