package com.goods.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionContext;
import com.sofans.constant.Constant;
import com.sofans.entity.Result;
import com.sofans.entity.goods.DeliverAddress;
import com.sofans.entity.goods.User;
import com.sofans.service.IServiceBase;
import com.sofans.util.ResultUtil;

@Controller
public class UserInfoController {
	
	private static final Log log = LogFactory.getLog(UserInfoController.class);
	
	@Autowired
	private IServiceBase goodsSysUserServiceImpl;
	@Autowired
	private IServiceBase userAddressServiceImpl;
	
	@RequestMapping(value="/member/saveAddress",method=RequestMethod.POST )
	public @ResponseBody String addAddressInfo(@RequestBody DeliverAddress deliverAddress){
		
		ActionContext ct= ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ct.get(
		    ServletActionContext.HTTP_REQUEST); 
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		
		try {
			Integer id = (goodsSysUserServiceImpl.findByProperty("username", userId, User.class)).get(0).getId();
			deliverAddress.setUserId(id);
			userAddressServiceImpl.save(deliverAddress);
			return "添加成功!";
		} catch (Exception e) {
			log.error("添加地址出错： "+e);
		}
		return "添加失败!";
		
	}
	
	
	@RequestMapping(value="/member/userinfo")
	public @ResponseBody List<User> loadUserInfo(HttpServletRequest request, HttpServletResponse res){
		
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId != null){
			List<User> list = new ArrayList<User>();
			try {
				list = goodsSysUserServiceImpl.findByProperty("username", userId, User.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		request.getSession().removeAttribute(Constant.USER_ID);
		return null;
	}
	
	@RequestMapping(value="/member/addressInfo")
	public@ResponseBody List<DeliverAddress> loadAddressInfo(HttpServletRequest request, HttpServletResponse res){
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId!= null){
			List<User> list = new ArrayList<User>();
			List<DeliverAddress> list2 = new ArrayList<DeliverAddress>();
			try {
				list = goodsSysUserServiceImpl.findByProperty("username", userId, User.class);
				System.out.println("list :" +list.size());
				User user = list.get(0);
				System.out.println("userId :"+user.getId());
				list2 = goodsSysUserServiceImpl.findByProperty("userId", user.getId(), DeliverAddress.class);
				System.out.println(list2.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list2;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/member/updatePassword",method = RequestMethod.POST)
	public @ResponseBody Result changePassword(@RequestBody Map jsonObj){
		String oldPassword = (String)jsonObj.get("oldpassword");
		String newPassword = (String)jsonObj.get("newpassword");
		int id = (int)jsonObj.get("id");
		try {
			goodsSysUserServiceImpl.changePassword(id, oldPassword, newPassword);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.getResult(false, e.getMessage());
		}
		return ResultUtil.getResult(true, ResultUtil.OPERATION_SECCESS);
	};
	
	@RequestMapping(value="/member/updateuser",method=RequestMethod.POST)
	public @ResponseBody Result saveUserInfo(HttpServletRequest request, @RequestBody User user0) {
		try {
			User u = goodsSysUserServiceImpl.findById(user0.getId(), User.class);
			u.setPhone(user0.getPhone());
			u.setEmail(user0.getEmail());
			goodsSysUserServiceImpl.meger(u);
			request.getSession().setAttribute(Constant.USER, u);
		} catch (Exception e) {
			log.error(e);
			return ResultUtil.getResult(false, "更新出错！");
		}
		return ResultUtil.getResult(true, ResultUtil.OPERATION_SECCESS);
	}

}
