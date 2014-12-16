package com.sofans.controller.sys;

import java.sql.Timestamp;
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
import com.sofans.entity.SofansSysOrder;
import com.sofans.entity.SofansSysUser;
import com.sofans.service.IServiceBase;
import com.sofans.service.ISofansSysOrderServices;
@SuppressWarnings("rawtypes")
@Controller
public class SufansSysOrderController {
	
	private static final Log log = LogFactory.getLog(SufansSysOrderController.class);
	
	@Autowired
	IServiceBase commonService;
	
	@Autowired
	ISofansSysOrderServices sofansSysOrderServiceImpl;

	
	
	/*
	 * responsebody表示该方法的返回结果直接写入HTTP response body中一般在异步获取数据时使用
	 */
	
	
	@RequestMapping(value="/admin/sys/order/listTabletCus",method=RequestMethod.GET)
	public @ResponseBody
	List listTabletCus(String id){
		int orderid = Integer.valueOf(id);
		List list = null;
		try {
			list = sofansSysOrderServiceImpl.loadOrderTabCus(orderid);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/admin/sys/order/list",method=RequestMethod.GET)
	@ResponseBody
	public List<SofansSysOrder> list(){
		List<SofansSysOrder> list = null;
		try {
			list = commonService.findAll(SofansSysOrder.class);
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
	
	@RequestMapping(value="/admin/sys/order/listByIdForJiShu",method=RequestMethod.GET)
	@ResponseBody
	public List<SofansSysOrder> listByIdForJiShu(){
		List<SofansSysOrder> list = null;
		try {
			list = commonService.findNotInProperty("state", 0, SofansSysOrder.class);
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}
	
	
	@RequestMapping(value="/admin/sys/order/listById",method=RequestMethod.GET)
	public @ResponseBody
	List<SofansSysOrder> listById(String id){
		int uid = Integer.valueOf(id);
		int empid = 0;
		List<SofansSysOrder> list = null;
		try {
			SofansSysUser sofansSysUser = commonService.findById(uid, SofansSysUser.class);
			empid = sofansSysUser.getEmp_id();
			list = commonService.findByProperty("empId", empid, SofansSysOrder.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	
	@RequestMapping(value = "/admin/sys/order/save", method = RequestMethod.POST)
	public @ResponseBody
	Result save(@RequestBody SofansSysOrder model) {
		System.out.println(" -----------order save-------------- ");
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
			model.setCreatetime(new Timestamp(System.currentTimeMillis()));
			model.setOrderNumber(sofansSysOrderServiceImpl.orderNumber());
			//model.setState(0);
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
	
	@RequestMapping(value = "/admin/sys/order/remove", method = RequestMethod.GET)
	public @ResponseBody
	Result remove(String id, String v) {
		SofansSysOrder t = new SofansSysOrder();
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
