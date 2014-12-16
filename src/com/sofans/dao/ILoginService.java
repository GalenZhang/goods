package com.sofans.dao;

import com.sofans.entity.UserSession;

public interface ILoginService {

	UserSession login(String userName, String password) throws Exception;
	
}
