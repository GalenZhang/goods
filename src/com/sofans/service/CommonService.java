package com.sofans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.IBean;
import com.sofans.entity.PageCondition;
import com.sofans.entity.PageResult;

@Service("commonService")
public class CommonService implements IServiceBase{

	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public <T extends IBean> void remove(T t) throws Exception {
		commonDAO.delete(t);
	}
	
	@Override
	public void removeByFK(String propertyName, Object value, Class<?> clazz) throws Exception
	{
		commonDAO.deleteByProperty(propertyName, value, clazz);
	}
	
	@Override
	public void removeByFK(Object value) throws Exception
	{
	}

	
	@Override
	public <T extends IBean> int save(T t) throws Exception
	{
		return commonDAO.save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IBean> List<T> findAll(Class<T> clazz) throws Exception
	{
		return commonDAO.findAll(clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IBean> List<T> findByProperty(String propertyName, Object value, Class<T> clazz) throws Exception
	{
		return (List<T>) commonDAO.findByProperty(propertyName, value, clazz);
	}
	
	@Override
	public PageResult page(PageCondition pageCondition, Class<?> clazz) throws Exception 
	{
		return commonDAO.page(clazz, pageCondition);
	}

	@Override
	public <T extends IBean> void merge(T t) throws Exception
	{
		commonDAO.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IBean> T findById(Integer id, Class<T> clazz) throws Exception
	{
		return (T) commonDAO.findById(id, clazz);
	}

	public <T extends IBean> List<T> findByFK(java.lang.Integer id) throws Exception
	{
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IBean> List<T> findNotInProperty(String propertyName, Object value, Class<T> clazz) throws Exception
	{
		return commonDAO.findNotInProperty(propertyName, value, clazz);
	}
	
	@Override
	public void removeByID(int id, Class<?> clazz) throws Exception
	{
		commonDAO.deleteByProperty("id", id, clazz);
	}

	@Override
	public void removeByID(int[] ids, Class<?> clazz) throws Exception
	{
		for (int id : ids)
		{
			commonDAO.deleteByProperty("id", id, clazz);	
		}
	}
	
	public int countByFK(String propertyName, Object value, Class<?> clazz) throws Exception
	{
		return commonDAO.count(propertyName, value, clazz);
	}
	
	public int countByFK(Object value) throws Exception
	{
		return 0;
	}
	

	@Override
	public <T extends IBean> T findBySQL(Object value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IBean> void updata(T t) throws Exception {
		commonDAO.update(t);
		
	}

	@Override
	public <T extends IBean> void meger(T t) throws Exception {
		commonDAO.meger(t);
		
	}
	
	@Override
	public void changePassword(int id, String oldpwd, String newpwd) throws Exception {
		// TODO Auto-generated method stub
		
	}









}
