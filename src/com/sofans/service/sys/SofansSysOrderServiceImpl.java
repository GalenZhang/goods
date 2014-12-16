package com.sofans.service.sys;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdicons.json.model.JSONArray;
import com.sdicons.json.model.JSONValue;
import com.sofans.dao.sys.SofansOrderTabCusDAO;
import com.sofans.entity.SofansSysCustomer;
import com.sofans.entity.SofansSysTablet;
import com.sofans.service.CommonService;
import com.sofans.service.ISofansSysOrderServices;

@SuppressWarnings("rawtypes")

@Service
public class SofansSysOrderServiceImpl extends CommonService implements ISofansSysOrderServices{

	@Autowired
	SofansOrderTabCusDAO sofansOrderTabCusDAO;
	

	/**
	 * 
	 * @return Order_number
	 */
	public String orderNumber(){
		
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		String timeStr = df.format(new Date());
		String orderNumber = "SN"+timeStr;
		for(int i=0; i < 5 ; i++){
			String randNum = String.valueOf((new Random()).nextInt(9));
			orderNumber += randNum;
		}
		return orderNumber;
	}
	

	//public Map<SofansSysTablet, SofansSysCustomer> loadOrderTabCus(int id){
		public List loadOrderTabCus(int id){

		List list = new ArrayList();;
		try {
			
			//此处返回的list，形式如 list( list(tablet, customer)  )  ,list里面包含的是list，里面的list存储了两个值，一个是平板信息，
			                                        //                             另外一个是于此平板对应的激活码信息
			 list = sofansOrderTabCusDAO.findBySQLById(id);

			System.out.println("list size :"+list.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
/*
 * 
 * ---------------------test 
 * 	
 */
	
	
	
	//测试使用 ： 生成模拟激活码
	public void intiNUMPWD(){
		int c = 0;
		for(int i=1;i <= 1000;i++){
			int len =String.valueOf(i).length();
			String zeroStr = "";
			for(int m = 1; m<= 6-len;m++){
				zeroStr += "0";
			}
			
			String pwd = "";
			for(int pLen = 0; pLen<8; pLen++){
				String ran = String.valueOf((new Random()).nextInt(9));
				pwd += ran;
			}
			
			c++;
			
			if(c == 4){
				System.out.println("("+i+",'SS"+zeroStr+i+"','"+pwd+"',1),");
				c=0;
			}else{
				System.out.print("("+i+",'SS"+zeroStr+i+"','"+pwd+"',1),");
			}
			
		}
	}
	
	//测试
	public void getTimestamp(){
		Timestamp time1 = new Timestamp(System.currentTimeMillis()); 
		System.out.println(time1);
	}
	
	//测试
	public void getSuperClz(){
		SofansSysOrderServiceImpl sofansSysOrderServiceImpl = new SofansSysOrderServiceImpl();
		 System.out.println((sofansSysOrderServiceImpl.getClass().getSuperclass()).getName());
		 
	}
	
	public static void main(String[] args) {
		//SofansSysOrderServiceImpl impl = new SofansSysOrderServiceImpl();
		//impl.intiNUMPWD();
		//impl.getTimestamp();
		//impl.getSuperClz();
	}

}
