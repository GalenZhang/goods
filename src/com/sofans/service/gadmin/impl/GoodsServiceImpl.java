package com.sofans.service.gadmin.impl;

import org.springframework.stereotype.Service;

import com.sofans.entity.goods.Goods;
import com.sofans.service.CommonService;
import com.sofans.service.gadmin.IGoodsService;

@Service("goodsServiceImpl")
public class GoodsServiceImpl extends CommonService implements IGoodsService {

	@Override
	public int addGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
