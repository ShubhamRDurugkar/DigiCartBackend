package com.dao;

import java.util.List;

import com.model.Order;

public interface OrderDao {
		public void insert(Order order);
		Order getOrderById(int orderId,String email);
	    void deleteOrder(int orderId);
	    void update(Order order);
		List<Order> findOrderById(String orderId);
	
}
