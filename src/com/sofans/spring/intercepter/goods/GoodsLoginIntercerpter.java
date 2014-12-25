package com.sofans.spring.intercepter.goods;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class GoodsLoginIntercerpter extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2546156651905643002L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        
		return null;
	}

}
