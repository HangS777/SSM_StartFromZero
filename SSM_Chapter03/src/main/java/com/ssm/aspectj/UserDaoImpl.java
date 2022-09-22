package com.ssm.aspectj;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	public void addUser() {
		//int i = 10/0;
		System.out.println("Add user");
	}
	
	public void deleteUser() {
		System.out.println("Delete user");
	}
}
