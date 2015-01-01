package com.sofans.service.member;

import java.util.List;

import com.sofans.entity.goods.Order;

public interface IGOrderService {

	public List<Order> getOrder(int userID) throws Exception;
	
	public void cancelOrder(int id) throws Exception;
}
