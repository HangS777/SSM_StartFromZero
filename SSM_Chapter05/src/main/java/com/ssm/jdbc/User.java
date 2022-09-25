package com.ssm.jdbc;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer points;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String toString() {
		return "User [id=" + id + ", username=" + username+", password=" + password + "]";
	}
}
