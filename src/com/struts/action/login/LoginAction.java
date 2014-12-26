package com.struts.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sofans.dao.ILoginService;
import com.sofans.entity.goods.User;
import com.sofans.util.AjaxReturnData;


@ParentPackage("struts-default")
@Namespace(value="/login")
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 3625158696331593140L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	
	private String username;
	private String password;

	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	@Action(value="login",results={
			@Result(name="login_success",location="/goodsIndex.jsp")		
	})
	public String login() {
		HttpServletRequest re = ServletActionContext.getRequest();
		HttpSession session = re.getSession();
		User user = new User();
		try {
			user = goodsLoginServiceImpl.goodsLogin(username, password);
		} catch (Exception e) {
			log.error(e);
		}
		if (user != null) {
			session.setAttribute("name", user.getUsername());
			session.setAttribute("role", user.getIs_admin());
			return "login_success";
		}
		log.debug("login success after =====");
		return AjaxReturnData.ajax("错误 : 用户名或密码有误!", "text/html");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
