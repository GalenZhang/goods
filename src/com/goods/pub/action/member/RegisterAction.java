package com.goods.pub.action.member;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sofans.entity.goods.User;
import com.sofans.service.IServiceBase;

@ParentPackage("struts-default")
@Namespace(value="/user")
public class RegisterAction extends ActionSupport{
	
	@Autowired
	private IServiceBase goodsSysUserServiceImpl;
	private User user = new User();
	private String username;
	private String password;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5459663962849612793L;
	
	/*
	 *  user 注册
	 */
	@Action(value="reg",results={
			@Result(name="success",location="/reg_success.jsp"),
			@Result(name="fail",location="/reg_fail.jsp",type="")
	})
	public String regUser(){
		
		user.setUsername(username);
		user.setPassword(password);
		user.setIs_admin(0);
		user.setState(1);
		int id = 0;
		try {
			id = goodsSysUserServiceImpl.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("id="+id);
		if(id>0)
		return "success";
		else
		return "fail";
	}

	public IServiceBase getGoodsSysUserServiceImpl() {
		return goodsSysUserServiceImpl;
	}

	public void setGoodsSysUserServiceImpl(IServiceBase goodsSysUserServiceImpl) {
		this.goodsSysUserServiceImpl = goodsSysUserServiceImpl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
