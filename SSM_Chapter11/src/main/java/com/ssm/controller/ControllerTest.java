package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/controll")
public class ControllerTest {


	@RequestMapping(value="/annotationController")
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1, Model model) {
		model.addAttribute("msg","My first Spring MVC program!");
		return "welcome";
	}
}
