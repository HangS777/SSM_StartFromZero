package com.ssm.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.ssm.po.User;
import com.ssm.util.MybatisUtils;

public class MyBatisTest {
	
	@Test
	public void findUserByNameAndJobsTest() throws Exception{
		System.out.println("==================== findUserByNameAndJobsTest() ====================");
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
		System.out.println("==================== findUserByNameOrJobsTest() ====================");
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
	
	// 更新不了数据库数据问题！！！！！！！！！！！！！！！！！！！！！！！！
	// 解决：
	// 在执行sqlSession.insert()和sqlSession.update()后需要进行 sqlSession.commit()，
	// 否则数据库不会插入数据，而且自增长id的情况下，在下一次成功的时候，会将未commit的数据id跳过。
	@Test
	public void updateUserBySetTest() throws Exception{
		System.out.println("==================== updateUserBySetTest() ====================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();

		User user = new User();
		user.setId(1);
		user.setUsername("zhangsan");
		user.setJobs("teacher");
		user.setPhone("13907998372");
		
		// Execute defined SQL in mapping file
		int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUserBySet", user);
		
		if (rows > 0) {
			System.out.println("Updated " + rows + " user successful!");
		} else {
			System.out.println("Updating user failed");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void findUserByIdTest() throws Exception{
		System.out.println("==================== findUserByIdTest() ====================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();

		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByIds", ids);
		
		for (User u: users) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void findUserByName2Test() throws Exception{
		System.out.println("==================== findUserByName2Test() ====================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();

		User user = new User();
		user.setUsername("s");
		
		List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByName2", user);
		
		for (User u: users) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}

}
