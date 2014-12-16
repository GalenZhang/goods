package com.sofans.service.sys;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.RoleUserModule;
import com.sofans.entity.SofansSysModule;
import com.sofans.entity.SofansSysModuleAction;
import com.sofans.entity.SofansSysRole;
import com.sofans.entity.SofansSysUser;
import com.sofans.entity.SofansSysUserRole;
import com.sofans.service.CommonService;

@Service
public class SofansSysRoleUserModuleServiceImpl extends CommonService{
	
	@Autowired
	CommonDAO commonDAO;
	
	/*
	 * 1. role.
	 * 2. user-role.
	 * 3. role-module.
	 * 4. role-module-action.  ( new : yl---add  )
	 * */
	@Override
	public <T extends IBean> int save(T k) throws Exception {
		
		RoleUserModule t = (RoleUserModule)k;
		
		SofansSysRole sufansSysRole = t.getSufansSysRole();
		List<SofansSysUser> sufansSysUsers = t.getSufansSysUsers();
		List<SofansSysModule> sufansSysModules = t.getSufansSysModules();
		/*
		 *  yl ---  add
		 */
		List<SofansSysModuleAction> sufansSysModuleActions = t.getSufansSysModelActions();
		
		//save role.
		Integer roleid = (Integer)commonDAO.save(sufansSysRole);
		
		//save user-role.
		if (!CollectionUtils.isEmpty(sufansSysUsers))
		{
			for (SofansSysUser user : sufansSysUsers)
			{
				SofansSysUserRole sufansSysUserRole = new SofansSysUserRole();
				sufansSysUserRole.setRoleid(roleid);
				sufansSysUserRole.setUserid(user.getId());
				commonDAO.save(sufansSysUserRole);
			}
		}
//		
//		//save module-role
//		if (!CollectionUtils.isEmpty(sufansSysModules))
//		{
//			for (SofansSysModule module : sufansSysModules)
//			{
//				SofansSysModuleAction sufansSysModuleAction = new SofansSysModuleAction();
//				sufansSysModuleAction.setRoleid(roleid);
//				sufansSysModuleAction.setModuleid(module.getId());
//				sufansSysModuleAction.setActionid(0);
//				commonDAO.save(sufansSysModuleAction);
//			}
//		}
		
		//save module-role-action  (new : yl--add)
		if(!CollectionUtils.isEmpty(sufansSysModuleActions))
		{
			for(SofansSysModuleAction actionMod : sufansSysModuleActions)
			{
				SofansSysModuleAction sufansSysModuleAction = new SofansSysModuleAction();
				sufansSysModuleAction.setRoleid(roleid);
				sufansSysModuleAction.setModuleid(actionMod.getModuleid());
				sufansSysModuleAction.setActionid(actionMod.getActionid());
				commonDAO.save(sufansSysModuleAction);
				
			}
		}
		
		return roleid;
	}

	@Override
	public void removeByID(int roleID, Class<?> clazz) throws Exception {
		//module-role
		commonDAO.deleteByProperty("roleid", roleID, SofansSysModuleAction.class);
		
		//user-role
		commonDAO.deleteByProperty("roleid", roleID, SofansSysModuleAction.class);
		
		//role
		SofansSysRole sufansSysRole = new SofansSysRole();
		sufansSysRole.setId(roleID);
		commonDAO.delete(sufansSysRole);
	}

	/*
	 * 1. role.
	 * 2. user.
	 * 3. module.
	 * */
	@SuppressWarnings("unchecked")
	public <T extends IBean> T findById(Integer roleID, Class<T> clazz) throws Exception {
		
		//find role-module
		List<SofansSysModuleAction> sufansSysModuleActions = (List<SofansSysModuleAction>) commonDAO
				.findByProperty("roleid", roleID,
						SofansSysModuleAction.class);
		
		
		//find role-user
		List<SofansSysUserRole> sufansSysUserRoles = commonDAO.findByProperty("roleid", roleID, SofansSysUserRole.class);
		//find role
		SofansSysRole sufansSysRole = (SofansSysRole)commonDAO.findById(roleID, SofansSysRole.class);
		
		RoleUserModule roleUserModule = new RoleUserModule();
		roleUserModule.setSufansSysRole(sufansSysRole);
		
		//user
		List<SofansSysUser> users = new ArrayList<SofansSysUser>();
		for (SofansSysUserRole userRole : sufansSysUserRoles)
		{
			users.add((SofansSysUser)commonDAO.findById(userRole.getUserid(), SofansSysUser.class));
		}
		roleUserModule.setSufansSysUsers(users);
		
		//module
		List<SofansSysModule> modules = new ArrayList<SofansSysModule>();
		for (SofansSysModuleAction moduleRole : sufansSysModuleActions)
		{
			modules.add((SofansSysModule)commonDAO.findById(moduleRole.getModuleid(), SofansSysModule.class));
		}
		roleUserModule.setSufansSysModules(modules);
		
		return (T) roleUserModule;
	}

	public <T extends IBean> void merge(T k) throws Exception {
		RoleUserModule t = (RoleUserModule)k;
		SofansSysRole sufansSysRole = t.getSufansSysRole();
		List<SofansSysUser> sufansSysUsers = t.getSufansSysUsers();
		List<SofansSysModule> sufansSysModules = t.getSufansSysModules();
		
		Integer roleid = sufansSysRole.getId();
		//remove the role-user relationship first.
		commonDAO.deleteByProperty("roleid", roleid, SofansSysUserRole.class);
		//merge user-role.
		if (!CollectionUtils.isEmpty(sufansSysUsers))
		{
			for (SofansSysUser user : sufansSysUsers)
			{
				SofansSysUserRole sufansSysUserRole = new SofansSysUserRole();
				sufansSysUserRole.setRoleid(roleid);
				sufansSysUserRole.setUserid(user.getId());
				commonDAO.save(sufansSysUserRole);
			}
		}
		
		//remove the role-module relationship first.
		commonDAO.deleteByProperty("roleid", roleid, SofansSysModuleAction.class);
		//merge module-role
		if (!CollectionUtils.isEmpty(sufansSysModules))
		{
			for (SofansSysModule module : sufansSysModules)
			{
				SofansSysModuleAction sufansSysModuleAction = new SofansSysModuleAction();
				sufansSysModuleAction.setRoleid(roleid);
				sufansSysModuleAction.setModuleid(module.getId());
				sufansSysModuleAction.setActionid(0);
				commonDAO.save(sufansSysModuleAction);
			}
		}
		
		//merge role.
		commonDAO.merge(sufansSysRole);
	}

	
	
}
