package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.User;

@Controller
public class UserController {

	/**
	 * To login page
	 */
	// @GetMapping("/toLogin") error
	@RequestMapping(value="/toLogin", method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	/**
	 * User Login
	 */
	// @PostMapping("/login") error
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, Model model, HttpSession session) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (username != null && username.equals("wujie")) {
			if (password != null && password.equals("123")) {
				session.setAttribute("user_session", user);
				return "redirect:main";
			}
		}
		
		model.addAttribute("msg", "User Inputs incorrect!");
		return "login";
	}
	
	/**
	 * To Main page
	 */
	@RequestMapping(value="/main")
	public String toMain() {
		return "main";
	}
	
	/**
	 * Logout
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:toLogin";
	}
}
