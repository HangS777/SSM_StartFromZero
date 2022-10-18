package com.ssm.test;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.ssm.po.Banji;
import com.ssm.po.Course;
import com.ssm.po.Student;
import com.ssm.util.MybatisUtils;

public class MyBatisAssociatedTest {
	
	/**
	 * Nested Select 嵌套查询 && Nested Result 嵌套结果
	 */
	@Test
	public void findStudnetByIdTest() throws Exception{
		System.out.println("========================= findStudnetByIdTest() ========================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();
		
		//Student student = sqlSession.selectOne("com.ssm.mapper.StudentMapper.findStudentById", 1);
		Student student = sqlSession.selectOne("com.ssm.mapper.StudentMapper.findStudentById2", 1);

		System.out.println(student.toString());
	
		sqlSession.close();
	}
	
	
	/**
	 * One to Many mapping test
	 */
	@Test
	public void findBanjiTest() throws Exception{
		System.out.println("========================= findBanjiTest() ========================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();
		
		Banji banji = sqlSession.selectOne("com.ssm.mapper.BanjiMapper.findBanjiWithStudent", 1);

		System.out.println(banji.toString());
	
		sqlSession.close();
	}
	
	/**
	 * Many to Many mapping test
	 */
	@Test
	public void findCourseByIdTest() throws Exception{
		System.out.println("========================= findCourseByIdTest() ========================");
		// Create SqlSession instance
		SqlSession sqlSession = MybatisUtils.getSession();
		
		Course course = sqlSession.selectOne("com.ssm.mapper.CourseMapper.findCourseWithStudent", 2);

		System.out.println(course.toString());
	
		sqlSession.close();
	}
	


}
