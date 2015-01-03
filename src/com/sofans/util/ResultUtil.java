package com.sofans.util;

import org.json.simple.JSONObject;

import com.sofans.entity.Result;

public class ResultUtil {

	public static Result getResult(boolean rs, String desc){
		return new Result(rs, desc);
	}
	
	public static Result getResult(boolean rs, String desc, Object obj){
		return new Result(rs, desc, obj);
	}
	
	@SuppressWarnings("unchecked")
	public static String getResult(int rs, String desc){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("message", desc);
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static String getResult(int rs, String key, String desc){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put(key, desc);
		return obj.toJSONString();
	}
}
