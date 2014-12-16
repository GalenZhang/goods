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
import com.sofans.entity.SofansSysUser;
import com.sofans.service.IServiceBase;

@Controller
public class SufansSysUserController {

	private static final Log log = LogFactory.getLog(SufansSysUserController.class);
	
	@Autowired
	IServiceBase sofansSysUserServiceImpl;

	@RequestMapping(value = "/admin/sys/user/list", method = RequestMethod.GET)
	@ResponseBody
	public List<SofansSysUser> list() {

		List<SofansSysUser> list = null;
		try {
			list = sofansSysUserServiceImpl.findAll(SofansSysUser.class);
		} catch (Exception e) {
			log.error(e);
		}

		return list;
	}
	

	@RequestMapping(value = "/admin/sys/user/save", method = RequestMethod.POST)
	public @ResponseBody
	Result save(@RequestBody SofansSysUser model) {
		if (model.getId() != null
				&& !StringUtils.isEmpty(String.valueOf(model.getId()))
				&& model.getId() > 0)
		{
			try {
				sofansSysUserServiceImpl.merge(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
		}
		else
		{
			int id;
			try {
				id = sofansSysUserServiceImpl.save(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
			model.setId(id);
		}
		return new Result(true, "保存成功！", model);
	}

	@RequestMapping(value = "/admin/sys/user/remove", method = RequestMethod.GET)
	public @ResponseBody
	Result remove(String id) {
		SofansSysUser t = new SofansSysUser();
		t.setId(Integer.valueOf(id));
		try {
			sofansSysUserServiceImpl.remove(t);
		} catch (Exception e) {
			log.error(e);
			return new Result(false, "删除失败！");
		}

		return new Result(true, "删除成功！", list());
	}


	
}
