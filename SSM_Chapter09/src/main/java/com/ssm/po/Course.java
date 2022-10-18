package com.ssm.po;

import java.util.List;

public class Course {

	private Integer id;
	private String name;
	private String code;
	private List<Student2> studentList;

	public Integer getIdInteger() {
		return id;
	}

	public void setIdInteger(Integer id) {
		this.id = id;
	}

	public String getNameString() {
		return name;
	}

	public void setNameString(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Student2> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student2> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		return "Course [id =" + id + ", name=" + name + ", code=" + code + ", studentList=" + studentList + "]";
	}
}
