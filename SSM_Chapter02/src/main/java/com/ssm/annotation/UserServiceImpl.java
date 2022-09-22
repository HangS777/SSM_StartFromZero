package com.ssm.annotation;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;

	public void save() {
		this.userDao.save();
		System.out.println("Execute userService.save()");
		
	}

}
