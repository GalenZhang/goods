package com.sofans.entity;

import java.util.Map;

import com.sofans.constant.Constant;

public class PageCondition {
	private int start;

	private int limit;
	
	private String sort;

	private String dir;//directory
	
	private Map<String, Object> conditions;//condition

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		if (limit == 0)
			return Constant.PAGE_SIZE;
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Map<String, Object> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Object> conditions) {
		this.conditions = conditions;
	}
}
