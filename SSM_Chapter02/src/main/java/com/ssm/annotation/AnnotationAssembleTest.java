package com.ssm.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		
		String xmlPath = "com/ssm/annotation/beans1.xml";
		
		applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserController userController =
				(UserController)applicationContext.getBean("userController");
		
		userController.save();
	}
}
