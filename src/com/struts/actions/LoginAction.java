package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sofans.dao.ILoginService;
import com.sofans.entity.goods.User;


@ParentPackage("struts-default")
@Namespace(value="/login")
public class LoginAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3625158696331593140L;
	
	private String username;
	private String password;

	private HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Action(value="login",results={
			@Result(name="login_fail",location="/login_reg.jsp"),
			@Result(name="login_success",location="/goodsIndex.jsp")
	})
	public String login(){
		
		HttpServletRequest re = httpServletRequest;
		HttpSession session = re.getSession();
		User user = new User();
		
		try {
			user = goodsLoginServiceImpl.goodsLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(user != null){
			session.setAttribute("name", user.getUsername());
			/**
			 * session.setAttribute("role", user.getRole());
			 *    分析： 应该把admin表和user表合在一起， 用一个字段来标注是否为管理员
			 */
			return "login_success";
			
		}
		this.addFieldError("login_error", "用户名账号或密码错误!");
		return "login_fail";
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
