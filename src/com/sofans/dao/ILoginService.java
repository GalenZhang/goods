package com.sofans.dao;

import com.sofans.entity.UserSession;
import com.sofans.entity.goods.User;

public interface ILoginService {

	UserSession login(String userName, String password) throws Exception;
	
	User goodsLogin(String userName, String password) throws Exception;
	
}
