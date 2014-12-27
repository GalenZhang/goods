package com.sofans.controller.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.constant.Constant;
import com.sofans.dao.ILoginService;
import com.sofans.entity.Result;
import com.sofans.entity.UserSession;

@Controller
public class LoginController {
	private static Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	ILoginService loginServiceImpl;
	
	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse res, String username, String password) {
		
		UserSession login = null;
		try {
			login = loginServiceImpl.login(username, password);
		} catch (Exception e1) {
			log.error("登陆失败!");
			return;
		}
		//login fail and no authority.
		if (login == null || CollectionUtils.isEmpty(login.getMenus()))
		{
			log.info("There isn't the user.");
			 try {
				 res.sendRedirect(request.getContextPath()+"/login/login.html");
				 return;
			} catch (IOException e) {
				log.error(e);
			}
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute(Constant.USER_OBJ, login);
		try {
			res.sendRedirect(request.getContextPath()+"/admin/tables.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/login/getmenu", method = RequestMethod.GET)
	@ResponseBody
	public Result getmenu(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserSession userSession = (UserSession)session.getAttribute(Constant.USER_OBJ);
		if (userSession.getMenus() == null || userSession.getMenus().isEmpty())
		{
			return null;
		}
		return new Result(true, "load menu seccussful", userSession);
	}
	
	@RequestMapping(value = "/login/loginout", method = RequestMethod.POST)
	public void loginout(HttpServletRequest request, HttpServletResponse res) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.USER_OBJ);
		session = null;
		if (request.getAttribute("loginout") != null)
		{
			return;
		}
		request.setAttribute("loginout", true);
		
		try {
			res.sendRedirect(request.getContextPath()+"/login/login.html");
		} catch (IOException e) {
			log.error(e);
		}
		return;
	}
	
}
