package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SupplierDao;
import com.model.Supplier;

@Repository("supplierDAO")
@Transactional

public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sf) {
		// TODO Auto-generated constructor stub
	}

	public boolean insertSupp(Supplier supp) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Updating details
	 */
	public boolean updateSupp(Supplier supp) {
		try {
			sessionFactory.getCurrentSession().update(supp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSupp(int id) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, id);
		try {
			if (null != supplier) {
				this.sessionFactory.getCurrentSession().delete(supplier);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Getting single supplier details by id
	public Supplier get(int sid) {
		return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(sid));
	}

	@SuppressWarnings({ "unchecked" })
	public List<Supplier> getAllSuppliers() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}

}
