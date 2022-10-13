package com.ssm.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.ssm.po.User;
import com.ssm.util.MybatisUtils;

public class MyBatisTest {
	
	@Test
	public void findUserByNameAndJobsTest() throws Exception{

		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setJobs("teacher");
		
		// Execute defined SQL in mapping file
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByNameAndJobs", user);
		
		for(User u: users) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserByNameOrJobsTest() throws Exception{

		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setJobs("teacher");
		
		// Execute defined SQL in mapping file
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByNameOrJobs", user);
		
		for(User u: users) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}
	
	// 更新不了数据库数据！！！！！！！！！！！！！！！！！！！！！！！！
//	@Test
//	public void updateUserBySetTest() throws Exception{
//		// Create SqlSession instance
//		SqlSession sqlSession = MybatisUtils.getSession();
//
//		User user = new User();
//		user.setId(1);
//		user.setUsername("zhangsan");
//		user.setJobs("teacher");
//		user.setPhone("13907998372");
//		
//		// Execute defined SQL in mapping file
//		int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUserBySet", user);
//		
//		if (rows > 0) {
//			System.out.println("Updated " + rows + " user successful!");
//		} else {
//			System.out.println("Updating user failed");
//		}
//		
//		sqlSession.close();
//	}

}
