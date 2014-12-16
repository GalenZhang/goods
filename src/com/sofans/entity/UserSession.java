package com.sofans.entity;

import java.util.Map;


public class UserSession {

	private Map<String, SofansSysModule> menus;
	
	private String username;
	
	private int userID;
	
	public UserSession(Map<String, SofansSysModule> menus, String username, int userID)
	{
		this.menus = menus;
		this.username = username;
		this.userID = userID;
	}

	public Map<String, SofansSysModule> getMenus() {
		return menus;
	}

	public void setMenus(Map<String, SofansSysModule> menus) {
		this.menus = menus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
