package com.sofans.util;

import com.sofans.constant.Constant;

public class Pagehelper {

	private Pagehelper(){};
	private static Pagehelper instance = new Pagehelper();
	
	public static Pagehelper getInstance(){
		return instance;
	}
	
	public int getStart(int pageIndex){
		return pageIndex * Constant.PAGE_SIZE;
	}
}
