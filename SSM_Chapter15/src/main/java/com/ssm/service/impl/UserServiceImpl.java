package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UserDao;
import com.ssm.po.User;
import com.ssm.service.UserService;

@Service // @service indicates the service level implementation
@Transactional // @Transactional indicates all methods in this class be managed by Spring Transaction Manager
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findUserById(Integer id) {
		return this.userDao.findUserById(id);
	}

}
