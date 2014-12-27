package com.goods.pub.action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public @ResponseBody Result login(HttpServletRequest request, HttpServletResponse res, @RequestBody User u) {
		User user = null;
		try {
			//user = goodsLoginServiceImpl.goodsLogin(u.getUsername(), u.getPassword());
			request.getSession().setAttribute(Constant.USER_ID, 11);
			request.getSession().setAttribute(Constant.USER_ROLE, 1);
		} catch (Exception e) {
			log.error(e);
		}
		
		//login fault
		if (u == null)
		{
			try {
				res.sendRedirect(request.getContextPath()+"/public/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//login successful
		/*try {
			res.sendRedirect(request.getContextPath()+"/public/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return new Result(true, "登陆成功！");
	}
}
