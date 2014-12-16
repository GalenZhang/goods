package com.sofans.entity;

import java.util.List;


public class RoleUserModule implements IBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3985085495783991582L;

	private SofansSysRole sufansSysRole;
	
	private List<SofansSysUser> sufansSysUsers;
	
	private List<SofansSysModule> sufansSysModules;
	
	// new : the  module,role and action
	private List<SofansSysModuleAction> sufansSysModelActions;

	public SofansSysRole getSufansSysRole() {
		return sufansSysRole;
	}

	public void setSufansSysRole(SofansSysRole sufansSysRole) {
		this.sufansSysRole = sufansSysRole;
	}

	public List<SofansSysUser> getSufansSysUsers() {
		return sufansSysUsers;
	}

	public void setSufansSysUsers(List<SofansSysUser> sufansSysUsers) {
		this.sufansSysUsers = sufansSysUsers;
	}

	public List<SofansSysModule> getSufansSysModules() {
		return sufansSysModules;
	}

	public void setSufansSysModules(List<SofansSysModule> sufansSysModules) {
		this.sufansSysModules = sufansSysModules;
	}

	public List<SofansSysModuleAction> getSufansSysModelActions() {
		return sufansSysModelActions;
	}

	public void setSufansSysModelActions(
			List<SofansSysModuleAction> sufansSysModelActions) {
		this.sufansSysModelActions = sufansSysModelActions;
	}

	
	
	
}
