package com.sofans.util;

import org.json.simple.JSONObject;

import com.sofans.entity.Result;

public class ResultUtil {
	
	public static String UPDATE_ERROR = "更新出错！";
	
	public static String LOAD_ERROR = "加载出错！";
	
	public static String ADD_ERROR = "添加出错！";
	
	public static String REMOVE_ERROR = "删除出错！";
	
	public static String OPERATION_SECCESS = "操作成功!";

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
	public static JSONObject getJSONObject(int rs, String desc){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("message", desc);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static String getResult(int rs, String key, String desc){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put(key, desc);
		return obj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject getJSONObject(int rs, String key, String desc){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put(key, desc);
		return obj;
	}
}
