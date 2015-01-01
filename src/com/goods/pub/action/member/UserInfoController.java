package com.goods.pub.action.member;

import java.util.ArrayList;
import java.util.List;

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
import com.sofans.entity.goods.DeliverAddress;
import com.sofans.entity.goods.User;
import com.sofans.service.IServiceBase;

@Controller
public class UserInfoController {
	
	private static final Log log = LogFactory.getLog(UserInfoController.class);
	
	@Autowired
	private IServiceBase goodsSysUserServiceImpl;
	@Autowired
	private IServiceBase userAddressServiceImpl;
	
	@RequestMapping(value="/pub/member/saveAddress.do",method=RequestMethod.POST )
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
	
	
	@RequestMapping(value="/pub/member/userinfo.do")
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
	
	@RequestMapping(value="/pub/member/addressInfo.do")
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
	
	@RequestMapping(value="/pub/member/updatePassword.do",method = RequestMethod.GET)
	public @ResponseBody String changePassword(String pwd, String pwd2, int id){
		ActionContext ct= ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ct.get(
		    ServletActionContext.HTTP_REQUEST); 
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId != null){
			try {
				goodsSysUserServiceImpl.changePassword(id, pwd, pwd2);
			} catch (Exception e) {
				e.printStackTrace();
				return "修改失败！";
			}
			
			return "修改成功！";
		}
		request.getSession().removeAttribute(Constant.USER_ID);
		return "请重新登陆！";
	};
	
	@RequestMapping(value="/pub/member/updateuser.do",method=RequestMethod.POST)
	public @ResponseBody String saveUserInfo( @RequestBody User user){
		List<User> list = new ArrayList<User>();
		ActionContext ct= ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ct.get(
		    ServletActionContext.HTTP_REQUEST); 
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId != null){
			try {
				list = goodsSysUserServiceImpl.findByProperty("id", user.getId(), User.class);
				User user2 = list.get(0);
				user2.setEmail(user.getEmail());
				user2.setPhone(user.getPhone());
				goodsSysUserServiceImpl.updata(user2);
			} catch (Exception e) {
				e.printStackTrace();
				return "保存失败！";
			}
			return "保存成功！";
		}
		request.getSession().removeAttribute(Constant.USER_ID);
		return "请重新登陆！";
		
	}

}
