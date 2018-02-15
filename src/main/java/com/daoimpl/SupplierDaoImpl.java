package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.SupplierDao;
import com.model.Supplier;


@Repository("supplierDAO")
@Service

public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sf) {
		super();
		this.sessionFactory=sf;
	}

	public boolean insertSupp(Supplier supp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(supp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	/*
	 * Updating details
	 */
	public boolean updateSupp(Supplier supp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(supp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public boolean deleteSupp(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, id);
		try {
			if (null != supplier) {
				session.delete(supplier);
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

	// Getting single supplier details by id
	public Supplier get(int sid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier = (Supplier) session.get(Supplier.class, sid);
		session.getTransaction().commit();
		session.close();
		return supplier;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppList = new ArrayList<Supplier>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Supplier> query = session.createQuery("FROM Supplier");
		suppList = query.list();
		session.getTransaction().commit();
		session.close();
		return suppList;

	}

}
