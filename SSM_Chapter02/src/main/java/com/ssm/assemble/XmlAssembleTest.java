package com.ssm.assemble;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAssembleTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(applicationContext.getBean("user1"));
		System.out.println(applicationContext.getBean("user2"));
	}
}
