package com.sofans.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.goods.DeliverAddress;
import com.sofans.service.CommonService;

@Service
public class UserAddressServiceImpl extends CommonService{

	@Autowired
	CommonDAO commonDAO;
	
	
	@Override
	public <T extends IBean> int save(T t) throws Exception {
		DeliverAddress deliverAddress = (DeliverAddress) t;
		return commonDAO.save(deliverAddress);
	}
}
