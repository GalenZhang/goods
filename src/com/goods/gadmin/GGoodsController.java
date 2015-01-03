package com.goods.gadmin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofans.entity.PageCondition;
import com.sofans.entity.PageResult;
import com.sofans.entity.Result;
import com.sofans.entity.goods.Goods;
import com.sofans.service.CommonService;
import com.sofans.service.IServiceBase;
import com.sofans.service.gadmin.IGoodsService;
import com.sofans.util.ResultUtil;

@Controller
public class GGoodsController {
	
	private static final Log log = LogFactory.getLog(GGoodsController.class);

	@Autowired
	private IGoodsService goodsServiceImpl;
	
	@RequestMapping(value = "/gadmin/goods/list", method = RequestMethod.GET)
	public @ResponseBody Result getList(PageCondition pageCondition){
		PageResult page = null;
		try {
			IServiceBase goodsServiceImpl2 = (IServiceBase)goodsServiceImpl;
			page = goodsServiceImpl2.page(pageCondition, Goods.class);
		} catch (Exception e) {
			log.error(e);
			return ResultUtil.getResult(false, "获取失败！");
		}
		
		return ResultUtil.getResult(true, "获取成功！", page);
	}
	
	@RequestMapping(value = "/goods/add", method = RequestMethod.GET)
	public @ResponseBody Result add(Goods goods){
		int id = 0;
		try {
			id = goodsServiceImpl.addGoods(goods);
		} catch (Exception e) {
			log.error(e);
			return ResultUtil.getResult(false, "添加产品出错!");
		}
		
		return ResultUtil.getResult(true, "添加成功！", id);
	}
	
	@RequestMapping(value = "/goods/remove", method = RequestMethod.GET)
	public @ResponseBody Result add(int[] ids) {
		try {
			((CommonService)goodsServiceImpl).removeByID(ids, Goods.class);
		} catch (Exception e) {
			log.error(e);
			return ResultUtil.getResult(false, "添加产品出错!");
		}
		
		return ResultUtil.getResult(true, "删除成功！");
	}
	

	@RequestMapping(value = "/goods/update", method = RequestMethod.GET)
	public @ResponseBody Result update(Goods goods) {
		try {
			((CommonService)goodsServiceImpl).merge(goods);
		} catch (Exception e) {
			log.error(e);
			return ResultUtil.getResult(false, "更新出错!");
		}
		
		return ResultUtil.getResult(true, "更新成功！");
	}
	
}
