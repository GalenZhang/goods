package com.goods.pub.action.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;
import com.sofans.entity.goods.User;
import com.sofans.service.IServiceBase;

@Controller
public class RegisterController extends ActionSupport {

	private static final long serialVersionUID = -5459663962849612793L;

	@Autowired
	private IServiceBase goodsSysUserServiceImpl;

	@RequestMapping(value = "/pub/member/register.do", method = RequestMethod.POST)
	public @ResponseBody
	String regUser(@RequestBody User user) {
		int id = 0;
		try {
			user.setState(1);
			user.setIsAdmin(0);
			id = goodsSysUserServiceImpl.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (id > 0)
			return "恭喜您注册成功！";
		else
			return "注册失败！";
	}
	
	@RequestMapping(value = "/pub/member/checkName.do")
	public @ResponseBody List<User> checkName(String username){

		List<User> list = new ArrayList<User>();
		try {
			list = goodsSysUserServiceImpl.findByProperty("username", username, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value= "/pub/member/returnNumber.do")
	public @ResponseBody String returnCheckNumber(String n){
		
		HttpServletRequest re = ServletActionContext.getRequest();
		HttpSession session = re.getSession();
		String number = (String) session.getAttribute("SESSION_SECURITY_CODE");
		return number;
	}

	public IServiceBase getGoodsSysUserServiceImpl() {
		return goodsSysUserServiceImpl;
	}

	public void setGoodsSysUserServiceImpl(IServiceBase goodsSysUserServiceImpl) {
		this.goodsSysUserServiceImpl = goodsSysUserServiceImpl;
	}
	


}
