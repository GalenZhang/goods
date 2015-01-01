package com.sofans.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.goods.Order;
import com.sofans.service.CommonService;
import com.sofans.service.member.IGOrderService;

@Service
public class GOrderServiceImpl extends CommonService implements IGOrderService{

	@Autowired
	CommonDAO commonDAO;

	@Override
	public List<Order> getOrder(int userID) throws Exception{
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>)commonDAO.findByProperty("userId", userID, Order.class);
		return orders;
	}


	@Override
	public void cancelOrder(int id) throws Exception {
		
	}

}
