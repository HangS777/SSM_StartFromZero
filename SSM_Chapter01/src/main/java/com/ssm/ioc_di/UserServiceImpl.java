package com.ssm.ioc_di;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void login() {
		this.userDao.login();
		System.out.println("UserService Login");
	}
}
