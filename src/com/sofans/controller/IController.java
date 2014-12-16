package com.sofans.controller;

import com.sofans.entity.PageResult;
import com.sofans.entity.Result;

public interface IController<Serializable> {

	public Result save(Serializable entity);
	
	public Result removeByEntity(Serializable entity);
	
	public Result removeById(int id);
	
	public Result findById(int id);
	
	public Result findByProperty(String property, String value);
	
	public Result merge(Serializable entity);
	
	public PageResult page();
	
}
