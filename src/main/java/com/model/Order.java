package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "CartDetails")
public class Order {
		@Id
		@GeneratedValue
		private int OrderId;

		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "email")
		private User cartUserDetails;

		private Double total;
		public Order(int orderId, User cartUserDetails, Double total, String email, String payment) {
			super();
			OrderId = orderId;
			this.cartUserDetails = cartUserDetails;
			this.total = total;
			this.email = email;
			this.payment = payment;
		}
		private String email;
		private String payment;
		public Order() {
		}

		
		public int getOrderId() {
			return OrderId;
		}
		public void setOrderId(int orderId) {
			OrderId = orderId;
		}
		public User getCartUserDetails() {
			return cartUserDetails;
		}
		public void setCartUserDetails(User cartUserDetails) {
			this.cartUserDetails = cartUserDetails;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPayment() {
			return payment;
		}
		public void setPayment(String payment) {
			this.payment = payment;
		}

		
}
