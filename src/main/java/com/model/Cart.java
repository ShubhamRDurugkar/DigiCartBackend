package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Component
@Table(name = "CartDetails")
public class Cart {
	@Id
	@GeneratedValue
	private int cartId;

	private int cartProductId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	private User cartUserDetails;

	private Double cartPrice;
	private int cartQuantity;
	private String cartImage;
	private String cartProductName;

	public Cart() {
	}

	public Cart(int cartId, int cartProductId, User cartUserDetails, Double cartPrice, int cartQuantity) {
		this.cartId = cartId;
		this.cartPrice = cartPrice;
		this.cartProductId = cartProductId;
		this.cartUserDetails = cartUserDetails;
		this.cartQuantity = cartQuantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
}
