package com.sofans.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.goods.User;
import com.sofans.exception.CommonException;
import com.sofans.service.CommonService;
import com.sofans.util.MD5Util;

@Service
public class GoodsSysUserServiceImpl extends CommonService {

	@Autowired
	CommonDAO commonDAO;

	@Override
	public <T extends IBean> int save(T t) throws Exception {
		try {
			User u = (User) t;
			u.setPassword(MD5Util.salt(u.getUsername(), u.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonDAO.save(t);
	}

	@Override
	public void changePassword(int id, String oldpwd, String newpwd) throws Exception {
		User user = (User) commonDAO.findById(id, User.class);

		if (MD5Util.verify(user.getPassword(), user.getUsername(), oldpwd)) {
			user.setPassword(MD5Util.salt(user.getUsername(), newpwd));
			commonDAO.update(user);
			return;
		}
		throw new CommonException("旧密码错误");
	}

}
