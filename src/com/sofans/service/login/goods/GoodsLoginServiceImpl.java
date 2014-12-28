package com.sofans.service.login.goods;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.ILoginService;
import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.UserSession;
import com.sofans.entity.goods.User;
import com.sofans.service.CommonService;
import com.sofans.util.MD5Util;

@SuppressWarnings("unchecked")
@Service
public class GoodsLoginServiceImpl extends CommonService implements ILoginService{
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(GoodsLoginServiceImpl.class);
	
	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public User goodsLogin(String userName, String password) throws Exception {
		
		List<IBean> list = (List<IBean>)commonDAO.findByProperty("username", userName, User.class);

		if(CollectionUtils.isEmpty(list))
		{
			return null;
		}
		User user = (User)list.get(0);
		if (!MD5Util.verify(user.getPassword(), userName, password))
		{
			return null;
		}
		
		return user;
	}

	@Override
	public UserSession login(String userName, String password) throws Exception {
		
		return null;
	}


	


	
}
