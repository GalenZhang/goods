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

import com.sofans.constant.Constatnt;
import com.sofans.entity.PageCondition;
import com.sofans.entity.PageResult;
import com.sofans.entity.Result;
import com.sofans.entity.SofansSysEmployee;
import com.sofans.service.IServiceBase;
import com.sofans.service.ISofansSysEmployeeServices;
import com.sofans.util.Pagehelper;

@Controller
public class SufansSysEmployeeController {

	private static final Log log = LogFactory
			.getLog(SufansSysEmployeeController.class);

	@Autowired
	IServiceBase commonService;
	
	@Autowired
	ISofansSysEmployeeServices sofansSysEmployeeServiceImpl;

	@RequestMapping(value = "/admin/sys/employee/list", method = RequestMethod.GET)
	@ResponseBody
	public PageResult list(int pageIndex) {
		PageCondition pageCondition = new PageCondition();
		pageCondition.setStart(Pagehelper.getInstance().getStart(pageIndex));
		pageCondition.setConditions(null);
		pageCondition.setLimit(Constatnt.PAGE_SIZE);
		PageResult page = null;
		try {
			page = commonService.page(pageCondition, SofansSysEmployee.class);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		return page;
	}
	
	@RequestMapping(value="/admin/sys/employee/load",method=RequestMethod.GET)
	@ResponseBody
	public List<SofansSysEmployee> list(){
		List<SofansSysEmployee> list = null;
		try {
			list = commonService.findAll(SofansSysEmployee.class);
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

	@RequestMapping(value = "/admin/sys/employee/save", method = RequestMethod.POST)
	public @ResponseBody
	Result save(@RequestBody SofansSysEmployee model, int pageIndex) {
		if (model.getId() != null
				&& !StringUtils.isEmpty(String.valueOf(model.getId()))
				&& model.getId() > 0) {
			try {
				commonService.merge(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
		} else {
			int id;
			try {
				model.setWorkerNum(sofansSysEmployeeServiceImpl.employeeNumber());
				id = commonService.save(model);
			} catch (Exception e) {
				log.error(e);
				return new Result(false, "保存失败！");
			}
			model.setId(id);
		}
		return new Result(true, "保存成功！", list(pageIndex));
	}

	@RequestMapping(value = "/admin/sys/employee/remove", method = RequestMethod.GET)
	public @ResponseBody
	Result remove(String id, int pageIndex) {
		SofansSysEmployee t = new SofansSysEmployee();
		t.setId(Integer.valueOf(id));
		try {
			commonService.remove(t);
		} catch (Exception e) {
			log.error(e);
			return new Result(false, "删除失败！");
		}

		return new Result(true, "删除成功！", list(pageIndex));
	}


	
	

}
