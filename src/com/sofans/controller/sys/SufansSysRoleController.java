package com.sofans.controller.sys;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.entity.Result;
import com.sofans.entity.RoleUserModule;
import com.sofans.entity.SofansSysModule;
import com.sofans.entity.SofansSysRole;
import com.sofans.entity.SofansSysUser;
import com.sofans.entity.SofansSysUserRole;
import com.sofans.entity.UserModule;
import com.sofans.service.IServiceBase;

@Controller
public class SufansSysRoleController {

	private static final Log log = LogFactory
			.getLog(SufansSysRoleController.class);

	@Autowired
	IServiceBase sofansSysRoleUserModuleServiceImpl;

	@Autowired
	IServiceBase commonService;

	@Autowired
	IServiceBase sofansSysUserServiceImpl;

	// @RequestMapping(value = "/admin/sys/role/getModuleActionByUid", method =
	// RequestMethod.GET)
	// public @ResponseBody
	// List<SofansSysModuleAction> getModuleActionByUid(String id) {
	// List<SofansSysModuleAction> listURM = null;
	// try {
	// List<SofansSysUserRole> list = sofansSysRoleUserModuleServiceImpl
	// .findByProperty("userid", Integer.valueOf(id),
	// SofansSysUserRole.class);
	// int roleId = list.get(0).getRoleid();
	// /*
	// *
	// */
	// System.out.println("------------roleid------------>"+roleId);
	// listURM =
	// sofansSysRoleUserModuleServiceImpl.findByProperty("userid",roleId,SofansSysModuleAction.class);
	// /*
	// *
	// */
	// System.out.println("------------listURM.size------------>"+listURM.size());
	//
	// } catch (Exception e) {
	// log.error(e);
	// }
	//
	// return listURM;
	// }

	@RequestMapping(value = "/admin/sys/role/moduleuser", method = RequestMethod.GET)
	@ResponseBody
	public UserModule userModule() {
		List<SofansSysModule> modules;
		List<SofansSysUser> users = null;
		try {
			modules = commonService.findAll(SofansSysModule.class);
			users = commonService.findNotInProperty("id", 1,
					SofansSysUser.class);
		} catch (Exception e) {
			log.error(e);
			return null;
		}

		UserModule userModule = new UserModule();
		userModule.setModules(modules);
		userModule.setUsers(users);

		return userModule;
	}

	@RequestMapping(value = "/admin/sys/role/list", method = RequestMethod.GET)
	@ResponseBody
	public List<SofansSysRole> list() {
		try {
			return commonService.findAll(SofansSysRole.class);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	/*
	 * 1. query role. 2. query user-role. 3. query role-module.
	 */
	@RequestMapping(value = "/admin/sys/role/save", method = RequestMethod.POST)
	public @ResponseBody
	Result save(@RequestBody RoleUserModule model) {
		SofansSysRole sufansSysRole = model.getSufansSysRole();
		if (sufansSysRole.getId() != null
				&& !StringUtils.isEmpty(String.valueOf(sufansSysRole.getId()))
				&& sufansSysRole.getId() > 0) {
			try {
				sofansSysRoleUserModuleServiceImpl.merge(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
		} else {
			int id;
			try {
				id = sofansSysRoleUserModuleServiceImpl.save(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
			sufansSysRole.setId(id);
		}
		return new Result(true, "保存成功！", list());
	}

	@RequestMapping(value = "/admin/sys/role/remove", method = RequestMethod.GET)
	public @ResponseBody
	Result remove(String id) {
		try {
			sofansSysRoleUserModuleServiceImpl.removeByID(Integer.valueOf(id),
					null);
		} catch (NumberFormatException e) {
			log.error(e);
			return new Result(false, "保存失败！");
		} catch (Exception e) {
			log.error(e);
			return new Result(false, "保存失败！");
		}

		return new Result(true, "删除成功！", list());
	}

	/*
	 * 1. query role. 2. query user-role. 3. query role-module.
	 */
	@RequestMapping(value = "/admin/sys/role/query", method = RequestMethod.GET)
	public @ResponseBody
	RoleUserModule query(String id) {
		RoleUserModule findById;
		try {
			findById = sofansSysRoleUserModuleServiceImpl.findById(
					Integer.valueOf(id), null);
		} catch (NumberFormatException e) {
			log.error(e);
			return null;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		return findById;
	}

	@RequestMapping(value = "/admin/sys/role/loadRoleId", method = RequestMethod.GET)
	public @ResponseBody
	List<SofansSysUserRole> loadRoleId(String id) {
		List<SofansSysUserRole> list = null;
		try {
			list = sofansSysRoleUserModuleServiceImpl.findByProperty("userid",
					Integer.valueOf(id), SofansSysUserRole.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
