package com.struts.action.login;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace(value="/")
public class ToIndexPageAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3296355716711038181L;
	
	@Action(value="goods",results={
			@Result(name="success",location="/goodsIndex.jsp")
	})
	public String toIndex(){
		return "success";
	}

}
