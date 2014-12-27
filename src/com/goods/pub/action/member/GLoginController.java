package com.goods.pub.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofans.constant.Constant;
import com.sofans.dao.ILoginService;
import com.sofans.entity.goods.User;

@Controller
public class GLoginController {
	
	private static final Log log = LogFactory.getLog(GLoginController.class);

	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	@RequestMapping(value = "/goods/pub/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse res, @RequestBody User u) {
		try {
			User user = goodsLoginServiceImpl.goodsLogin(u.getUsername(), u.getPassword());
			request.getSession().setAttribute(Constant.USER_ID, user.getId());
			request.getSession().setAttribute(Constant.USER_ROLE, user.getIs_admin());
		} catch (Exception e) {
			log.error(e);
		}
	}
}
