package com.sofans.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.SofansSysUser;
import com.sofans.entity.SofansSysUserRole;
import com.sofans.service.CommonService;
import com.sofans.util.MD5Util;
import com.sofans.entity.goods.User;

@Service
public class GoodsSysUserServiceImpl extends CommonService{
	
	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public <T extends IBean> int save(T t) throws Exception{
		try {
			User u = (User)t;
			u.setPassword(MD5Util.salt(u.getUsername(), u.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonDAO.save(t);
	}

	public void remove(SofansSysUser t) throws Exception {
		//remove user-role
		commonDAO.deleteByProperty("userid", t.getId(), SofansSysUserRole.class);
		//remove user;
		commonDAO.delete(t);
	}

	public <T extends IBean> void merge(T t) throws Exception {
		SofansSysUser u = (SofansSysUser)t;
		u.setPassword(MD5Util.salt(u.getName(), u.getPassword()));
		commonDAO.merge(t);
	}

	
	
}
