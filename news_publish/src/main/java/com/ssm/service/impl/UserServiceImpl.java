package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UserDao;
import com.ssm.po.User;
import com.ssm.service.UserService;

@Service("userService") // @service indicates the service level implementation
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findUserList(String keywords, Integer userListRoleId) {
		List<User> userList = this.userDao.selectUserList(keywords, userListRoleId);
		return userList;
	}

	@Override
	public User findUser(String loginName, String password) {
		User user = this.userDao.findUser(loginName, password);
		return user;
	}

	@Override
	public User getUserByUserId(Integer userId) {
		User user = this.userDao.getUserByUserId(userId);
		return user;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		User user = this.userDao.getUserByLoginName(loginName);
		return user;
	}

	@Override
	public int editUser(User user) {
		return this.userDao.updateUser(user);
	}

	@Override
	public int addUser(User user) {
		return this.userDao.addUser(user);
	}

	@Override
	public int delUser(Integer userId) {
		return this.userDao.delUser(userId);
	}

	@Override
	public int setUserStatus(User user) {
		return this.userDao.setUserStatus(user);
	}


}
