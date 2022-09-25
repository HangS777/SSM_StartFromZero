package com.ssm.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

public class TransactionTest {
	
	@Test
	public void xmlTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.transferPoints("zhangsan", "lisi", 100);
		
		System.out.println("Transfer points success.");
	}
	
	@Test
	public void annotationTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.transferPoints("zhangsan", "lisi", 100);
		
		System.out.println("Transfer points success.");
	}
	
	

}
