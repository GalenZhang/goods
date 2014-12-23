package com.struts.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sofans.service.IServiceBase;
import com.struts.entity.User;

@ParentPackage("struts-default")
@Namespace(value="/user")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	@Autowired
	private IServiceBase goodsSysUserServiceImpl;
	private User user = new User();

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
		
		user.setUsername("user001");
		user.setPassword("123");
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

	@Override
	public User getModel() {	
		return user;
	}

}
