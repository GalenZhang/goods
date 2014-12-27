package com.goods.pub.action.member;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.goods.util.ActionConstant;
import com.goods.util.SecurityCode;
import com.goods.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

/*
 *   @Action(value="employeeJson",
 *   results={
 *   @Result(name="success",params={"root","employeeList","noCache","true","enableGZIP","true","excludeNullProperties","true"},
 *   type="json")})
 */

@ParentPackage(value = "json-default")
@Namespace(value = "/pic")
public class SecurityPicAction extends ActionSupport {
	private static final long serialVersionUID = 3625158696331593140L;

	private ByteArrayInputStream imageStream;

	// <result type="json" />
	@Action(value = "securityCode", results = { @Result(name = "sucess", type = "stream", params = {
			"contentType", "image/jpeg", "inputName", "imageStream",
			"bufferSize", "2048" }) })
	public String securityCode() throws Exception {
		// 如果开启Hard模式，可以不区分大小写
		// String securityCode =
		// SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard,
		// false).toLowerCase();

		HttpServletRequest re = ServletActionContext.getRequest();
		HttpSession session = re.getSession();
		// 获取默认难度和长度的验证码
		String securityCode = SecurityCode.getSecurityCode();
		imageStream = SecurityImage.getImageAsInputStream(securityCode);
		// 放入session中
		session.setAttribute("SESSION_SECURITY_CODE", securityCode);
		return ActionConstant.SUCCESS;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

}
