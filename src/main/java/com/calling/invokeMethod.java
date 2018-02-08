package com.calling;


import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
import com.model.User;

public class invokeMethod {
public static void main(String[] args) {
	UserDao user=new UserDaoImpl();
	for(User u: user.getAllUsers()){
		System.out.println("\tName: "+u.getName()+"\n\tpassword: "+u.getPassword()+"\n\tAddress: "+u.getAddress()+"\n\tPhone: "+u.getPhone()+"\n\tEmal id: "+u.getEmail()+"\n\tCountry:"+u.getCountry());
	
	}
}
}
