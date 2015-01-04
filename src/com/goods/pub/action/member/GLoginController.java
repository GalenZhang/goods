package com.goods.pub.action.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.constant.Constant;
import com.sofans.dao.ILoginService;
import com.sofans.entity.Result;
import com.sofans.entity.goods.User;

@Controller
public class GLoginController {
	
	private static final Log log = LogFactory.getLog(GLoginController.class);

	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	@RequestMapping(value = "/pub/member/login", method = RequestMethod.POST)
	public @ResponseBody Result login(@RequestBody User u, HttpServletRequest request) {
		User user = null;
		try {
			user = goodsLoginServiceImpl.goodsLogin(u.getUsername(), u.getPassword());
			user.setPassword("");
			request.getSession().setAttribute(Constant.USER, user);
		} catch (Exception e) {
			log.error(e);
			return new Result(false, "登陆的败!");
		}
		
		return new Result(true, "登陆成功！", user.getIsAdmin());
	}
	
	@RequestMapping(value = "/pub/member/getuser", method = RequestMethod.GET)
	public @ResponseBody Result getUser(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constant.USER);
		if (user != null)
		{
			return new Result(true, "读取用户数据成功！", user);
		}
		return new Result(false, "读取用户数据失败！");
	}
	
	@RequestMapping(value = "/pub/member/loginout", method = RequestMethod.GET)
	public @ResponseBody Result loginOut(HttpServletRequest request){
		request.getSession().removeAttribute(Constant.USER);
		return new Result(true, "成功退出！");
	}
	
}
