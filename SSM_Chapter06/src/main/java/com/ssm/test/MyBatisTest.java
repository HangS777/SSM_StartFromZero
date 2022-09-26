package com.ssm.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.ssm.po.User;

public class MyBatisTest {
	
	@Test
	public void findUserByIdTest() throws Exception{
		// 1. read configure file
		String resource = "mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 2. Build SqlSessionFactory instance
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3. Create SqlSession instance
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 4.Execute defined SQL in mapping file
		User user = sqlSession.selectOne("com.ssm.mapper.UserMapper.findUserById", 1);
		System.out.println(user.toString());
		
		sqlSession.close();
	}
	
	@Test
	public void findUserByNameTest() throws Exception{
		// 1. read configure file
		String resource = "mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 2. Build SqlSessionFactory instance
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3. Create SqlSession instance
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 4.Execute defined SQL in mapping file
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByName", "g");
		
		for(User user: users) {
			System.out.println(user.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void addUserTest() throws Exception{
		// 1. read configure file
		String resource = "mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 2. Build SqlSessionFactory instance
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3. Create SqlSession instance
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("tom");
		user.setJobs("engineer");
		user.setPhone("13624589654");
		
		// 4.Execute defined SQL in mapping file
		int rows = sqlSession.insert("com.ssm.mapper.UserMapper.addUser", user);
		
		if (rows > 0) {
			System.out.println("Add " + rows + " user successful!");
		} else {
			System.out.println("Add user failed");
		}
		
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void updateUserTest() throws Exception{
		// 1. read configure file
		String resource = "mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 2. Build SqlSessionFactory instance
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3. Create SqlSession instance
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(4);
		user.setUsername("tom");
		user.setJobs("manager");
		user.setPhone("13624589654");
		
		// 4.Execute defined SQL in mapping file
		int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUser", user);
		
		if (rows > 0) {
			System.out.println("Updated " + rows + " user successful!");
		} else {
			System.out.println("Updating user failed");
		}
		
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() throws Exception{
		// 1. read configure file
		String resource = "mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 2. Build SqlSessionFactory instance
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3. Create SqlSession instance
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(4);
		user.setUsername("tom");
		user.setJobs("manager");
		user.setPhone("13624589654");
		
		// 4.Execute defined SQL in mapping file
		int rows = sqlSession.delete("com.ssm.mapper.UserMapper.deleteUser", 4);
		
		if (rows > 0) {
			System.out.println("Deleted " + rows + " user successful!");
		} else {
			System.out.println("Deleting user failed");
		}
		
		sqlSession.commit();
		
		sqlSession.close();
	}
}
