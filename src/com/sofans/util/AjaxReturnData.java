package com.sofans.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/*
 *  struts2 action 与  ajax异步交互 ， action需要返回data数据。 
 */
public class AjaxReturnData {

	public String ajax(String content, String type) {
		try {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(type + ";charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().write(content);
		response.getWriter().flush();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return null;
		} 
}
