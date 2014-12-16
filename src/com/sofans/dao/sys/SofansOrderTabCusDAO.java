package com.sofans.dao.sys;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sofans.entity.SofansSysCustomer;
import com.sofans.entity.SofansSysOrder;
import com.sofans.entity.SofansSysTablet;

@Repository("sofansOrderTabCusDAO")
@Transactional
public class SofansOrderTabCusDAO {
	private static final Log log = LogFactory
			.getLog(SofansOrderTabCusDAO.class);

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List findBySQLById(int param) throws Exception {
		String sql = "select * from (select * from sofans_op_tablet as tab where tab.order_id =?) as a left join sofans_sys_customer as cus on a.code_id = cus.id";
		SQLQuery query = getCurrentSession().createSQLQuery(sql)
				.addEntity("a", SofansSysTablet.class)
				.addEntity("cus", SofansSysCustomer.class);
		query.setParameter(0, param);
		
		 List list = query.list();
		 

		return list;

	}

}
