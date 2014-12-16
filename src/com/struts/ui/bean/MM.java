package com.struts.ui.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "mm", tldTagClass = "com.tag.MMTag", description = "MM")
public class MM extends UIBean {
	private String message;

	public MM(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return "mm";
	}

	@StrutsTagAttribute(description = "set message", type = "String")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	protected void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (null != message) {
			addParameter("message", findString(message));
		}
	}
	
}
