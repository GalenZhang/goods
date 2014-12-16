package com.sofans.entity;

public class Result {

	private boolean result;
	
	private String desc;
	
	private Object obj;

	public Result(boolean result, String desc)
	{
		this.result = result;
		this.desc = desc;
	}
	
	public Result(boolean result, String desc, Object obj){
		this.result = result;
		this.desc = desc;
		this.obj = obj;
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
