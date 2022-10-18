package com.ssm.po;

public class StudentIdCard {

	private Integer id;	
	private String code;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString() {
		return "StudentIdCard [id =" + id + ", code=" + code +"]";
	}
	
}
