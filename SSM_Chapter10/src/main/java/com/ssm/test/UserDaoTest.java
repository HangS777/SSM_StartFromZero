package com.ssm.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.dao.UserDao;
import com.ssm.mapper.UserMapper;
import com.ssm.po.User;

public class UserDaoTest {

	@Test
	public void findUserByIdDaoTest() {
		System.out.println("========================= findUserByIdDaoTest() ========================");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}
	
	@Test
	public void findUserByIdMapperTest() {
		System.out.println("========================= findUserByIdMapperTest() ========================");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		
		User user = userMapper.findUserById(2);
		
		System.out.println(user);
	}
}
