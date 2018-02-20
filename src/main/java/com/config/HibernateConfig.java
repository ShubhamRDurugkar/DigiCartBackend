package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.daoimpl.CategoryDaoImpl;
import com.daoimpl.ProductDaoImpl;
import com.daoimpl.SupplierDaoImpl;
import com.daoimpl.UserDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class HibernateConfig {

	private final static String database_URL = "jdbc:h2:tcp://localhost/~/DigiCart";
	private final static String database_driver = "org.h2.Driver";
	private final static String database_dialect = "org.hibernate.dialect.H2Dialect";
	private final static String database_username = "sa";
	private final static String database_password = "";

	@Bean(name = "datasource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(database_driver);
		dataSource.setUrl(database_URL);
		dataSource.setUsername(database_username);
		dataSource.setPassword(database_password);
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		System.out.println("Session Object created..");
		builder.addProperties(getHibernateProperties());

		System.out.println("Properties added");

		builder.addAnnotatedClass(User.class);
		builder.addAnnotatedClass(Supplier.class);
		builder.addAnnotatedClass(Category.class);
		builder.addAnnotatedClass(Product.class);
		// builder.addAnnotatedClass(Order.class);
		// builder.addAnnotatedClass(Cart.class);

		System.out.println("All classes added");
		return builder.buildSessionFactory();
	}

	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", database_dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate properties created");
		return properties;
	}

	@Autowired
	@Bean(name = "supplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sf) {
		return new SupplierDaoImpl(sf);
	}

	@Autowired
	@Bean(name = "categoryDaoImpl")
	public CategoryDaoImpl getCategoryData(SessionFactory sf) {
		return new CategoryDaoImpl(sf);
	}

	@Autowired
	@Bean(name = "userDaoImpl")
	public UserDaoImpl getUserData(SessionFactory sf) {
		return new UserDaoImpl(sf);
	}

	@Autowired
	@Bean(name = "productDaoImpl")
	public ProductDaoImpl getProductData(SessionFactory sf) {
		return new ProductDaoImpl(sf);
	}

	// @Autowired
	// @Bean(name = "orderDaoImpl")
	// public OrderDaoImpl getOrderData(SessionFactory sf) {
	// return new OrderDaoImpl(sf);
	// }
	// @Autowired
	// @Bean(name = "cartDaoImpl")
	// public cartDaoImpl getCartData(SessionFactory sf) {
	// return new CartDaoImpl(sf);
	// }
	// transactionManager
	@Autowired
	@Bean(name = ("transactionManager"))
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		return transactionManager;

	}
}
