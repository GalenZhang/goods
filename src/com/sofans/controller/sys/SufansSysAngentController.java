package com.sofans.controller.sys;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.entity.Result;
import com.sofans.entity.SofansSysAngent;
import com.sofans.entity.SofansSysUser;
import com.sofans.service.IServiceBase;

@Controller
public class SufansSysAngentController {
	
	private static final Log log = LogFactory.getLog(SufansSysAngentController.class);
	
	@Autowired
	IServiceBase commonService;
	
	/*
	 * responsebody表示该方法的返回结果直接写入HTTP response body中一般在异步获取数据时使用
	 */
	
	@RequestMapping(value="/admin/sys/agent/list",method=RequestMethod.GET)
	@ResponseBody
	@Cacheable(value="DEFAULT_CACHE", key="\"agents\"")
	public List<SofansSysAngent> list(){
		List<SofansSysAngent> list = null;
		try {
			list = commonService.findAll(SofansSysAngent.class);
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
	
	
	
	
	
	@RequestMapping(value="/admin/sys/agent/listById",method=RequestMethod.GET)
	public @ResponseBody
	List<SofansSysAngent> listById(String id){
		int uid = Integer.valueOf(id);
		int empid = 0;
		List<SofansSysAngent> list = null;
		try {
			SofansSysUser sofansSysUser = commonService.findById(uid, SofansSysUser.class);
			empid = sofansSysUser.getEmp_id();
			list = commonService.findByProperty("emp_id", empid, SofansSysAngent.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	
	@RequestMapping(value = "/admin/sys/agent/save", method = RequestMethod.POST)
	public @ResponseBody
	@CacheEvict(value = "DEFAULT_CACHE", key="\"agents\"", beforeInvocation = true)  
	Result save(@RequestBody SofansSysAngent model) {
		if (model.getId() != null
				&& !StringUtils.isEmpty(String.valueOf(model.getId()))
				&& model.getId() > 0)
		{
			try {
				commonService.merge(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
		}
		else
		{
			int id;
			try {
				id = commonService.save(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
			model.setId(id);
		}
		return new Result(true, "保存成功！", model);
	}
	
	@RequestMapping(value = "/admin/sys/agent/remove", method = RequestMethod.GET)
	public @ResponseBody
	Result remove(String id, String v) {
		SofansSysAngent t = new SofansSysAngent();
		t.setId(Integer.valueOf(id));
		try {
			commonService.remove(t);
		} catch (Exception e) {
			log.error(e);
			return new Result(false, "删除失败！");
		}
		if(Integer.valueOf(v) > 1){
			return new Result(true, "删除成功！", listById(v));
		}else{
			return new Result(true, "删除成功！", list());
		}
		
	}

}
