package com.dao;

import java.util.List;

import com.model.Cart;



public interface CartDao {
	public void insert(Cart cart);
	public List<Cart> findCartById(int userId);
	Cart getCartById(int cartId,String email);
    void deleteCart(int cartId);
    void update(Cart cart);
}
