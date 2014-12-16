package com.sofans.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.SofansSysEmployee;
import com.sofans.service.CommonService;
import com.sofans.service.ISofansSysEmployeeServices;

@Service
public class SofansSysEmployeeServiceImpl extends CommonService implements ISofansSysEmployeeServices{
//public class SofansSysEmployeeServiceImpl extends CommonService{
	
	@Autowired
	CommonDAO commonDAO;
	

	/**
	 * 
	 * @return employee number
	 */
	public String employeeNumber(){
		String maxNumber = new Integer(commonDAO.infoCount(SofansSysEmployee.class)).toString();
		StringBuffer ss = new StringBuffer( "SS");
		String zero = "0";
		for(int i=0;i< (4-maxNumber.length());i++){
			ss.append(zero);
		}	
		ss.append(maxNumber);
		System.out.println(ss);
		return ss.toString();
	}
	

}
