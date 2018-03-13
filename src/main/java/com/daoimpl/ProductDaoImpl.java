package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.model.Product;

@Repository
@Service
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		session.close();
	}

	public void updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();

	}

	public void deleteProduct(int pid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, pid);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}

	
	public Product getProductById(int pid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, pid);
		session.getTransaction().commit();
		session.close();
		return product;
	}

	public List<Product> retrieveProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Product> query = session.createQuery("FROM Product");
		List<Product> productsList = query.list();
		return productsList;
	}

	public List<Product> getProductByCid(String cid){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Product> query = session.createQuery("FROM Product where cid="+cid);
		List<Product> productsList = query.list();
		return productsList;
	}
}
