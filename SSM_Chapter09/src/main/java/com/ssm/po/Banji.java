package com.ssm.po;

import java.util.List;


public class Banji {

	private Integer id;
	private String name;
	private List<Student2> studentList;

	public Integer getIdInteger() {
		return id;
	}

	public void setIdInteger(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student2> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student2> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", studentList=" + studentList + "]";
	}

}
