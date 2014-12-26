package com.struts.action.login;

import java.io.ByteArrayInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sofans.dao.ILoginService;
import com.sofans.entity.goods.User;
import com.sofans.util.AjaxReturnData;
import com.struts.action.util.ActionConstant;
import com.struts.action.util.SecurityCode;
import com.struts.action.util.SecurityImage;

/*
 *   @Action(value="employeeJson",
 *   results={
 *   @Result(name="success",params={"root","employeeList","noCache","true","enableGZIP","true","excludeNullProperties","true"},
 *   type="json")})
 */

@ParentPackage(value="json-default")
@Namespace(value="/login")
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 3625158696331593140L;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	
	private User user= null;
	private String username;
	private String password;
	
	private ByteArrayInputStream imageStream;

	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	@Action(value="login",results={
			@Result(name="login_success",location="/index.jsp")		
	})
	public String login() {
		HttpServletRequest re = ServletActionContext.getRequest();
		HttpSession session = re.getSession();
		
		Map<String, String[]> parameterMap = re.getParameterMap();
		
		try {
			user = goodsLoginServiceImpl.goodsLogin(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			log.error(e);
		}
		if (user != null) {
			session.setAttribute("name", user.getUsername());
			session.setAttribute("role", user.getIs_admin());
			return ActionConstant.LOGIN_SUCESS;
		}
		log.debug("login success after =====");
		return AjaxReturnData.ajax("错误 : 用户名或密码有误!", "text/html");
	}

	// <result type="json" />
	@Action(value="securityCode",results={
			@Result(name="sucess", type="stream", 
					params={"contentType", "image/jpeg", "inputName", "imageStream", "bufferSize", "2048"})
	})
	 public String securityCode() throws Exception {
	        //如果开启Hard模式，可以不区分大小写
		 	//String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
	        
		 	HttpServletRequest re = ServletActionContext.getRequest();
			HttpSession session = re.getSession();
	        //获取默认难度和长度的验证码
	        String securityCode = SecurityCode.getSecurityCode();
	        imageStream = SecurityImage.getImageAsInputStream(securityCode);
	        //放入session中
	        session.setAttribute("SESSION_SECURITY_CODE", securityCode);
	        return ActionConstant.SUCCESS;
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

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	
}
