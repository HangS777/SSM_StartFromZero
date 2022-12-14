package com.ssm.po;

public class Student {
	
	private Integer id;
	private String name;
	private String sex;
	private StudentIdCard studentIdCard;
	
	
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
	public StudentIdCard getStudentIdCard() {
		return studentIdCard;
	}
	public void setStudentIdCard(StudentIdCard studentIdCard) {
		this.studentIdCard = studentIdCard;
	}
	
	public String toString() {
		return "Student [id =" + id + ", name=" + name + ", sex=" + sex + ", studentIdCard=" + studentIdCard + "]";
	}
	
}
