package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.RoleDao;
import com.ssm.po.Role;
import com.ssm.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findRoleList() {
		List<Role> roleList = roleDao.selectRoleList();
		return roleList;
	}

}
