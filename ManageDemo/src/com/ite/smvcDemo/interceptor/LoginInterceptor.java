package com.ite.smvcDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String[] IGNORE_URI = { "/login", "/home" };

	private static final String[] TEACH_URI = { "/teacher", "/logout", "/student", "/grade", "/ti","/charP" };

	private static final String[] STU_URI = { "/stuSubject", "/logout", "/stuGrade", "/exam" };

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isUser = false;
		boolean isTea = false;
		boolean isStu = false;
		String currentUrl = request.getRequestURL().toString();

		// 排除下面url不需要拦截
		for (String url : IGNORE_URI) {
			if (currentUrl.contains(url)) {
				isUser = true;
				break;
			}
		}

		if (!isUser) {
			String role = (String) request.getSession().getAttribute("role");
			if (role != null) {
				if (role.equals("teacher")) {
					for (String url : TEACH_URI) {
						if (currentUrl.contains(url)) {
							isTea = true;
							break;
						}
					}
					if (!isTea) {
						response.sendRedirect(request.getContextPath() + "/teacher/Teacher");
					}
				}

				if (role.equals("student")){
					for (String url : STU_URI) {
						if (currentUrl.contains(url)) {
							isStu = true;
							break;
						}
					}
					if (!isStu) {
						response.sendRedirect(request.getContextPath() + "/stuSubject/StuGradeFind");
					}
				}
				isUser = true;
				
				
				
				
				
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
			}

		}
		return isUser;
	}
}
