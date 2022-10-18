package com.ssm.po;

import java.util.List;

public class Student2 {

	private Integer id;
	private String name;
	private String sex;
	//private List<Course> courseList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

//	public List<Course> getCourseList() {
//		return courseList;
//	}
//
//	public void setCourseList(List<Course> courseList) {
//		this.courseList = courseList;
//	}
	
	public String toString() {
		return "Student [id =" + id + ", name=" + name + ", sex=" + sex + "]";
	}
}
