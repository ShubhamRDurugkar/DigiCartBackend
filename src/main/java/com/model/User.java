package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", country=" + country + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int uid;
	private String name;
	private String password;
	@Id
	private String email;
	private String address;
	private String phone;
	private String country;
	private String role;
	private boolean enabled;
	


	public User() {
		super();
	}
//
//	public int getId() {
//		return uid;
//	}
//
//	public void setId(int id) {
//		this.uid = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
