package com.ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ssm.po.Role;

/*
 * Role DAO Layer Interface
 */
public interface RoleDao {
	// Search All roles in DB
	public List<Role> selectRoleList();

	// Search role and it's related user by role id
	public Role selectRoleWithUsers(@Param("roleId") Integer roleId);
}