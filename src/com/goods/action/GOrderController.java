package com.goods.action;

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
public class GOrderController {
	
	private static final Log log = LogFactory.getLog(GOrderController.class);

	@Autowired
	private ILoginService goodsLoginServiceImpl;
	
	@RequestMapping(value = "/member/order", method = RequestMethod.POST)
	public @ResponseBody Result getOrder(HttpServletRequest request, HttpServletResponse res) {
		
		return new Result(true, "登陆成功！");
	}
	
}
