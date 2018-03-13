package com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CartDao;
import com.model.Cart;

@SuppressWarnings("deprecation")
@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public CartDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> findCartById(String userId) {
		Session session = sessionFactory.openSession();
		List<Cart> cartList=null;
		try{
		session.beginTransaction();
		cartList=(List<Cart>)session.createQuery("FROM Cart where userMailId=:email ").setString("email", userId).list();
		session.getTransaction().commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cartList;
	}

	
	@Override
	public Cart getCartById(int cartId, String email) {
		Session session = sessionFactory.openSession();
		Cart cart=null;
		session.beginTransaction();
		cart=(Cart)session.createQuery("FROM Cart where email=:email and cartProductId=:id").setString("email", email).setInteger("id",cartId).uniqueResult();
		session.getTransaction().commit();
		return cart;
	}

	@Override
	public void deleteCart(int cartId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class,cartId);
		session.delete(cr);
		session.getTransaction().commit();
	}

	@Override
	public void update(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();
	}

}
