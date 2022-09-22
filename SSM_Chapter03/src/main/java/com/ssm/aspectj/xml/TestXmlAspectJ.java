package com.ssm.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ssm.aspectj.UserDao;

public class TestXmlAspectJ {
	
	public static void main(String[] args) {
		String xmlPath="com/ssm/aspectj/xml/applicationContext.xml";
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.addUser();
	}

}
