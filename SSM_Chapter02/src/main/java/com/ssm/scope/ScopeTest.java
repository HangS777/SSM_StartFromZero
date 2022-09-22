package com.ssm.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScopeTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(applicationContext.getBean("scope"));
		System.out.println(applicationContext.getBean("scope"));
	}
	

}
