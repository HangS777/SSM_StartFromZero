package com.ssm.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ssm.aspectj.UserDao;

public class TestAnnotation {
	public static void main(String[] args) {
		String xmlPath="com/ssm/aspectj/annotation/applicationContext.xml";
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.addUser();
	}
}
