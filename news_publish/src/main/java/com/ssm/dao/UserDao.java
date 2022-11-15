package com.ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ssm.po.User;

/*
 * User DAO layer interface
 */
public interface UserDao {
	// Search All users
	public List<User> selectUserList(@Param("keywords") String keywords,
			@Param("userListRoleId") Integer userListRoleId);

	// Search User by loginname and password
	public User findUser(@Param("loginName") String loginName, @Param("password") String password);

	public User getUserByUserId(Integer userId);

	public User getUserByLoginName(String loginName);

	public int addUser(User user);

	public int updateUser(User user);

	public int delUser(Integer userId);

	public int setUserStatus(User user);
}