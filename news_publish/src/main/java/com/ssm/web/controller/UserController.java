package com.ssm.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.Role;
import com.ssm.po.User;
import com.ssm.service.RoleService;
import com.ssm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	/**
	 * Search User by id
	 */
	@RequestMapping(value = "/findUserList.action")
	public String findUserById(String keywords, Integer userListRoleId, Model model) {
		List<Role> roleList = roleService.findRoleList();
		model.addAttribute("roleList", roleList);

		List<User> userList = userService.findUserList(keywords, userListRoleId);
		model.addAttribute("userList", userList);
		model.addAttribute("keywords", keywords);
		model.addAttribute("userListRoleId", userListRoleId);
		return "user/user_list";
	}

	/**
	 * Jump to add user
	 */
	@RequestMapping(value = "/toAddUser.action")
	public String toAddUser(Model model) {
		List<Role> roleList = roleService.findRoleList();
		model.addAttribute("roleList", roleList);
		return "user/add_user";
	}

	/**
	 * Check user login
	 */
	@RequestMapping(value = "/checkLoginName.action")
	@ResponseBody
	public User checkLoginName(@RequestBody User user, Model model) {
		User checkUser = userService.getUserByLoginName(user.getLoginName());
		if (checkUser != null) {
			return checkUser;
		} else {
			checkUser = new User();
			checkUser.setUserId(0);
			return checkUser;
		}
	}

	/**
	 * Add user
	 */
	@RequestMapping(value = "/addUser.action", method = RequestMethod.POST)
	public String addUser(User user, Model model) {
		List<Role> roleList = roleService.findRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("user", user);

		User checkUser = userService.getUserByLoginName(user.getLoginName());
		if (checkUser != null) {
			model.addAttribute("checkUserLoginNameMsg", "The login account already exists!");
			return "user/add_user";
		} else {
			Date date = new Date();
			user.setRegisterTime(date);
			user.setStatus("2");
			int rows = userService.addUser(user);
			if (rows > 0) {
				return "redirect:findUserList.action";
			} else {
				return "user/add_user";
			}
		}
	}

	/**
	 * Jump to Edit user
	 */
	@RequestMapping(value = "/toEditUser.action")
	public String toEditUser(Integer userId, Model model) {
		User user = userService.getUserByUserId(userId);
		if (user != null) {
			model.addAttribute("user", user);
			List<Role> roleList = roleService.findRoleList();
			model.addAttribute("roleList", roleList);
			return "user/edit_user";
		} else {
			return "redirect:findUserList.action";
		}
	}

	/**
	 * Edit User
	 */
	@RequestMapping(value = "/editUser.action", method = RequestMethod.POST)
	public String editUser(User user, Model model) {
		Date date = new Date();
		user.setRegisterTime(date);
		user.setStatus("2");
		int rows = userService.editUser(user);
		if (rows > 0) {
			return "redirect:findUserList.action";
		} else {
			List<Role> roleList = roleService.findRoleList();
			model.addAttribute("roleList", roleList);
			model.addAttribute("user", user);
			return "user/edit_user";
		}
	}
	
	/**
	 * Delete User（invoke this by AJAX in front end )
	 */
	@RequestMapping(value = "/delUser.action")
	@ResponseBody
	public User delUser(@RequestBody User user, Model model) {
		int rows = userService.delUser(user.getUserId());
		if (rows > 0) {
			return user;
		} else {
			user.setUserId(0);
			return user;
		}
	}

	/**
	 * Disable User（set status to '3'，invoke this by AJAX in front end）
	 */
	@RequestMapping(value = "/disableUser.action")
	@ResponseBody
	public User disableUser(@RequestBody User user, Model model) {
		int rows = userService.setUserStatus(user);
		if (rows > 0) {
			return user;
		} else {
			user.setUserId(0);
			return user;
		}
	}

	/**
	 * Activate User（set status to '2'，invoke this by AJAX in front end）
	 */
	@RequestMapping(value = "/enableUser.action")
	@ResponseBody
	public User enableUser(@RequestBody User user, Model model) {
		int rows = userService.setUserStatus(user);
		if (rows > 0) {
			return user;
		} else {
			user.setUserId(0);
			return user;
		}
	}

	/**
	 * User Login
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String loginName, String password, Model model, HttpSession session) {

		User user = userService.findUser(loginName, password);
		if (user != null) {
			if (user.getStatus().equals("2")) {
				session.setAttribute("login_user", user);
				System.out.println("here!!!! " + user);
				return "main";
			} else {
				// account disabled
				model.addAttribute("msg", "This account being disabled, please contact manager！");
				return "../../login";
			}
		}
		model.addAttribute("msg", "Account or password incorrect, please tryagain！");
		return "../../login";
	}

	/**
	 * Logout
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
		// clear session
		session.invalidate();
		return "../../login";
	}
}
