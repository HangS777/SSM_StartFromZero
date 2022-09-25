package com.ssm.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addUser(User user) {
		String sql = "insert into user(username, password) value(?,?)";
		Object[] obj = new Object[] {
				user.getUserName(),
				user.getPassword()
		};
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	
	public int updateUser(User user) {
		String sql = "update user set username=?, password=? where id=?";
		Object[] obj = new Object[] {
				user.getUserName(),
				user.getPassword(),
				user.getId()
		};
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	
	public int deleteUser(int id) {
		String sql = "delete from user where id=?";
		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}
	
	public User findUserById(int id) {
		String sql = "select * from user where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	
	public List<User> findAllUser(){
		String sql = "select * from user";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
