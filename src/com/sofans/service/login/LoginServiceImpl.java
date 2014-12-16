package com.sofans.service.login;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.ILoginService;
import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.SofansSysModule;
import com.sofans.entity.SofansSysModuleAction;
import com.sofans.entity.SofansSysUser;
import com.sofans.entity.SofansSysUserRole;
import com.sofans.entity.UserSession;
import com.sofans.service.CommonService;
import com.sofans.util.MD5Util;

@SuppressWarnings("unchecked")
@Service
public class LoginServiceImpl extends CommonService implements ILoginService{
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);
	
	@Autowired
	CommonDAO commonDAO;
	
	//cache menu id, menu name
	//{1=admin/download.html, 2=admin/user.html, 3=admin/role.html, 4=admin/chat.html, 5=admin/order.html}
	private static Map<Integer, SofansSysModule> menuMap = new HashMap<Integer, SofansSysModule>(10);
	
	@Override
	public UserSession login(String userName, String password) throws Exception {
		List<IBean> list = (List<IBean>)commonDAO.findByProperty("name", userName, SofansSysUser.class);
		initMenu();
		if(CollectionUtils.isEmpty(list))
		{
			return null;
		}
		SofansSysUser user = (SofansSysUser)list.get(0);
		if (!MD5Util.verify(user.getPassword(), userName, password))
		{
			return null;
		}
		
		
		return getUserSerssion(user);
	}

	
	private UserSession getUserSerssion(SofansSysUser user) throws Exception
	{
		//login successful
		//1. get role
		
		List<IBean> roles = commonDAO.findByProperty("userid", user.getId(), SofansSysUserRole.class);
		Set<Integer> accessModuleIDs = new HashSet<Integer>();
		//get the module id by role id.
		for (IBean role : roles)
		{
			List<IBean> sufansSysModuleActions = commonDAO.findByProperty("roleid", ((SofansSysUserRole)role).getRoleid(), SofansSysModuleAction.class);
			
			for (IBean bean : sufansSysModuleActions)
			{
				accessModuleIDs.add(((SofansSysModuleAction)bean).getModuleid());
			}
			
		}
		
		//get the module name by the module id.
		Map<String, SofansSysModule> menus = new HashMap<String, SofansSysModule>();
		for (int moduleid : accessModuleIDs)
		{
			//beside the superadmin can visit the user and role manager menu.
			/*2-user, 3-role*/
			if (!user.getName().equals("superadmin"))
			{
				if (moduleid == 2 || moduleid == 3)
				{
					continue;
				}
			}
			menus.put(String.valueOf(moduleid), menuMap.get(moduleid));
		}
		
		return new UserSession(menus, user.getName(), user.getId());
	}
	
	private void initMenu() throws Exception
	{
		if (menuMap.isEmpty())
		{
			List<IBean> modules = commonDAO.findAll(SofansSysModule.class);
			for (IBean module : modules)
			{
				menuMap.put(((SofansSysModule)module).getId(), (SofansSysModule)module);
			}
		}
	}
	
	public int save(SofansSysUser t) throws Exception {
		return (Integer)commonDAO.save(t);
	}

	
}
