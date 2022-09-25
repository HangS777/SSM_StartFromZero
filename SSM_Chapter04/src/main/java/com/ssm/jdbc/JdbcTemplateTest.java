package com.ssm.jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		
		jdbcTemplate.execute("create table user(" +
							 "id int primary key auto_increment," +
							 "username varchar(40)," +
							 "password varchar(40))");
	}
	
	@Test
	public void addUserTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		
		User user = new User();
		user.setUserName("zhangsan");
		user.setPassword("123456");
		
		int num = userDao.addUser(user);
		if (num > 0) {
			System.out.println("Inserted " + num + " data successful.");
		} else {
			System.out.println("Insertion Failed.");
		}
	}
	
	@Test
	public void updateUserTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		
		User user = new User();
		user.setUserName("lisi");
		user.setPassword("123654");
		user.setId(3);
		
		int num = userDao.updateUser(user);
		if (num > 0) {
			System.out.println("Updated " + num + " data successful.");
		} else {
			System.out.println("Updating Failed.");
		}
	}
	
	@Test
	public void deleteUserTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		
		int num = userDao.deleteUser(4);
		if (num > 0) {
			System.out.println("Deleted " + num + " data successful.");
		} else {
			System.out.println("Deletion Failed.");
		}
	}
	
	@Test
	public void findUserByIdTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		
		User user = userDao.findUserById(1);
		System.out.print(user);
	}

	@Test
	public void findAllUserTest() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		
		List<User> list = userDao.findAllUser();
		for (User user: list) {
			System.out.println(user);
		}
	}
}
