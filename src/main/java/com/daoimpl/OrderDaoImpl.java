package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.OrderDao;
import com.model.Cart;
import com.model.Order;
@SuppressWarnings("deprecation")
@Repository("OrderDaoImpl")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public OrderDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderById(String orderId) {
		Session session = sessionFactory.openSession();
		List<Order> order=null;
		try{
		session.beginTransaction();
		order=(List<Order>)session.createQuery("FROM Cart where userMailId=:email ").setString("email", orderId).list();
		session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return order;
	}

	
	@Override
	public Order getOrderById(int orderId, String email) {
		Session session = sessionFactory.openSession();
		Order order=null;
		session.beginTransaction();
		order=(Order)session.createQuery("FROM Cart where email=:email and cartProductId=:id").setString("email", email).setInteger("id",orderId).uniqueResult();
		session.getTransaction().commit();
		return order;
	}

	@Override
	public void deleteOrder(int orderId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class,orderId);
		session.delete(cr);
		session.getTransaction().commit();
	}

	@Override
	public void update(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
	}


}
