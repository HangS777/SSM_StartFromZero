package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("Login Interceptor afterCompletion");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("Login Interceptor postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		
		if (url.indexOf("/toLogin") >= 0) {
			return true;
		}
		
		if (url.indexOf("/login") >= 0) {
			return true;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user_session");
		if (user != null) {
			return true;
		}
		request.setAttribute("msg", "Please Login First!");
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
