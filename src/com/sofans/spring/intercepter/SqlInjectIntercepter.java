package com.sofans.spring.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SqlInjectIntercepter implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)throws Exception {
		
	}
	 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		
	}
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			/*for (int i = 0; i < values.length; i++) {
				if(Utility.hasAttackStr(values[i])){
					if(!(values[i].equals("DELETE") && name.equals("_method")) ){
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().print("请不要尝试注入<br><a href=’#’ onclick=’history.go(-1)’>返回</a>");
						return false;
					}
				}
			}*/
		}
		return true;
	}

}
