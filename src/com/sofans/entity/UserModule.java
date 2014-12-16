package com.sofans.entity;

import java.util.List;

public class UserModule implements IBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5754314253767485569L;

	List<SofansSysModule> modules;

	List<SofansSysUser> users;

	public List<SofansSysModule> getModules() {
		return modules;
	}

	public void setModules(List<SofansSysModule> modules) {
		this.modules = modules;
	}

	public List<SofansSysUser> getUsers() {
		return users;
	}

	public void setUsers(List<SofansSysUser> users) {
		this.users = users;
	}

}
