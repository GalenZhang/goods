package com.goods.filter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sofans.constant.Constant;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -1246219947586303195L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// 获取ActionContext  
        ActionContext actionContext = arg0.getInvocationContext();
        // 获取sessionMap  
        Map<String, Object> session = actionContext.getSession();
          
        String user=(String) session.get("user");
          
        //如果用户名存在，程序继续执行，否则跳转到登录页面  
        if(user != null){
            //继续执行  
            return arg0.invoke();
        }
        //向HttpServletRequest中添加属性，即request.setAttribute(msg,...)
        actionContext.put("msg", "还没有登陆!");
        //返回LOGIN逻辑视图  
        return Constant.LOGIN_OUT;
	}

}
