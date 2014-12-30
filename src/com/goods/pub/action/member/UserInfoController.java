package com.goods.pub.action.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.constant.Constant;
import com.sofans.entity.goods.User;
import com.sofans.service.IServiceBase;

@Controller
public class UserInfoController {
	
	private static final Log log = LogFactory.getLog(UserInfoController.class);
	
	@Autowired
	private IServiceBase goodsSysUserServiceImpl;
	
	
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
		return null;
	}
	
	@RequestMapping(value="/pub/member/updatePassword.do",method = RequestMethod.GET)
	public @ResponseBody String changePassword(String pwd, String pwd2, int id){
		try {
			goodsSysUserServiceImpl.changePassword(id, pwd, pwd2);
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败！";
		}
		
		return "修改成功！";
	};
	
	@RequestMapping(value="/pub/member/updateuser.do",method=RequestMethod.POST)
	public @ResponseBody String saveUserInfo( @RequestBody User user){
		List<User> list = new ArrayList<User>();
		try {
			list = goodsSysUserServiceImpl.findByProperty("id", user.getId(), User.class);
			User user2 = list.get(0);
			user2.setEmail(user.getEmail());
			user2.setPhone(user.getPhone());
			//
			System.out.println(user.getEmail()+','+user.getPhone());
			goodsSysUserServiceImpl.updata(user2);
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败！";
		}
		return "保存成功！";
	}

}
