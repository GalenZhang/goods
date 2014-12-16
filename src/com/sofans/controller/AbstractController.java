package com.sofans.controller;

import com.sofans.entity.PageResult;
import com.sofans.entity.Result;

public class AbstractController<Serializable> implements IController<Serializable> {

	@Override
	public Result save(Serializable entity) {
		return null;
	}

	@Override
	public Result removeByEntity(Serializable entity) {
		return null;
	}

	@Override
	public Result removeById(int id) {
		return null;
	}

	@Override
	public Result findById(int id) {
		return null;
	}

	@Override
	public Result findByProperty(String property, String value) {
		return null;
	}

	@Override
	public Result merge(Serializable entity) {
		return null;
	}

	@Override
	public PageResult page() {
		return null;
	}

}
