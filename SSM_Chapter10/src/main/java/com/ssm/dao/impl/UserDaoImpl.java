package com.ssm.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ssm.dao.UserDao;
import com.ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(Integer id) {
		return this.getSqlSession().selectOne("com.ssm.mapper.UserMapper.findUserById", id);
	}

	
}
