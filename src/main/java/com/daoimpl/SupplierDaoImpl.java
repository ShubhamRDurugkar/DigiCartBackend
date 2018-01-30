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

	public boolean insertSupp(Supplier supp) {
		try {
			sessionFactory.getCurrentSession().persist(supp);
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
	public Supplier get(int id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(id));
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Supplier> getAllSuppliers() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}

}
