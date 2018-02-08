package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.model.Category;

@Repository("categoryDao")
@Transactional

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sf) {
		// TODO Auto-generated constructor stub
	}

	public boolean insertCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(int cid) {
		Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, cid);
		try {
			if (null != category) {
				this.sessionFactory.getCurrentSession().delete(category);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Category getCategory(String cid) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(cid));
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(int cid) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(cid));
	}

}
