package com.sofans.service;

import java.util.List;

import com.sofans.entity.IBean;
import com.sofans.entity.PageCondition;
import com.sofans.entity.PageResult;


public interface IServiceBase {
	
	<T extends IBean> void remove(T t) throws Exception;

	void removeByFK(String property, Object value, Class<?> clazz) throws Exception; 
	
	void removeByFK(Object value) throws Exception;  
	
	<T extends IBean> int save(T t) throws Exception;
	
	<T extends IBean> List<T> findAll(Class<T> clazz) throws Exception;
	
	<T extends IBean> List<T> findByProperty(String propertyName, Object value, Class<T> clazz) throws Exception;
	
	<T extends IBean> List<T> findNotInProperty(String propertyName, Object value, Class<T> clazz) throws Exception;
	
	<T extends IBean> void merge(T t) throws Exception;
	
	<T extends IBean> T findById(java.lang.Integer id, Class<T> clazz) throws Exception;
	
	<T extends IBean> List<T> findByFK(java.lang.Integer id) throws Exception;
	
	PageResult page(PageCondition pageCondition, Class<?> clazz) throws Exception;
	
	void removeByID(int id, Class<?> clazz) throws Exception;
	
	void removeByID(int[] ids, Class<?> clazz) throws Exception;
	
	int countByFK(Object value) throws Exception;
	
	int countByFK(String propertyName, Object value, Class<?> clazz) throws Exception;
	
	<T extends IBean> T findBySQL(Object value) throws Exception;
	
	<T extends IBean>void updata(T t)throws Exception;
	/*
	 * 
	 */
//	String employeeNumber();
//	String orderNumber();


	void changePassword(int id, String oldpwd, String newpwd) throws Exception;


	
}
