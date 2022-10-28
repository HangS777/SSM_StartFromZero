package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.po.Banji;
import com.ssm.po.Student;
import com.ssm.po.User;
import com.ssm.vo.UserVo;

@Controller
public class UserController {


	/**
	 * http://localhost:8080/SSM_Chapter12/selectUser?user_id=1
	 */
	@RequestMapping(value="/selectUser")
	public String selectUser(@RequestParam(value="user_id") Integer id) {
		System.out.println("id=" +id);
		return "success";
	}
	
	@RequestMapping(value="/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping(value="/registerUser")
	public String registerUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		return "success";
	}
	
	@RequestMapping(value="/tofindStudentWithBanji")
	public String tofindStudentWithBanji() {
		return "student";
	}
	
	@RequestMapping(value="/findStudentWithBanji")
	public String findStudentWithBanji(Student student) {
		Integer stu_id = student.getStu_id();
		Banji banji = student.getBanji();
		String banji_name = banji.getBanji_name();
		System.out.println("stu_id = " + stu_id);
		System.out.println("banji_name = " + banji_name);
		return "success";
	}
	
	@RequestMapping("/toCourse")
	public String toCourse() {
		return "course";
	}
	
	@RequestMapping("/deleteCourse")
	public String deleteCourse(Integer[] ids) {
		if (ids != null) {
			for (Integer i: ids) {
				System.out.println("Deleted course with id = " + i);
			}
		} else {
			System.out.println("ids = null");
		}
		return "success";
	}
	
	@RequestMapping("/toUserEdit")
	public String toUserEdit() {
		return "user_edit";
	}
	
	@RequestMapping("/editUsers")
	public String editUsers(UserVo userList) {
		List<User> users = userList.getUsers();
		for (User user: users) {
			if (user.getId() != null) {
				System.out.println("Edited user with id = " + user.getId() + " and username = " + user.getUsername());
			}
		}
		return "success";
	}
}
