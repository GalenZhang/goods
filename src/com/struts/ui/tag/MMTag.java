package com.struts.ui.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;
import com.struts.ui.bean.MM;

public class MMTag extends AbstractUITag {
	
	private String message;
	
	private static final long serialVersionUID = 5750167003208377206L;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		 return new MM(stack, request, response); 
	}

	@Override
	protected void populateParams(){
		super.populateParams();
		MM mm= (MM)component;
		mm.setMessage(message);
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
}
