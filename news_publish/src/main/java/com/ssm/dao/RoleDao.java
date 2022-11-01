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

	// 根据角色ID获取角色及其关联的用户
	//public Role selectRoleWithUsers(@Param("roleId") Integer roleId);
}