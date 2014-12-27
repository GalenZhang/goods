package com.sofans.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sofans.constant.Constant;

public class SecurityFilter implements Filter {

	private Set<String> suffixSet = new HashSet<String>();
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		 	HttpServletRequest req = (HttpServletRequest) arg0;  
		    HttpServletResponse res = (HttpServletResponse) arg1;  
		  
		    String currentURL = req.getRequestURI();

		   // String targetURL = currentURL.substring(currentURL.lastIndexOf("/"));
		    
		    if(currentURL.endsWith("/") || currentURL.indexOf("goods/index.html") >= 0)
		    {
		    	res.sendRedirect(req.getContextPath()+
		    			"/public/index.html");
		    	return;
		    }
		    
		    if (currentURL.indexOf("public") > 0 || currentURL.indexOf("pub") > 0)
		    {
		    	arg2.doFilter(req, res);
		    	return;
		    }
		    
		    String suffix = currentURL.substring(currentURL.lastIndexOf(".") + 1);
		    if (suffixSet.contains(suffix))
		    {
		    	arg2.doFilter(req, res);
		    	return;
		    }
		    
		    HttpSession session = req.getSession(); 
		    if (session.getAttribute(Constant.USER_ID) == null) {
		    	res.sendRedirect(req.getContextPath()+"/public/login.html");
		    	 return;
		    }
		    
		    arg2.doFilter(req, res); 
		   
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		suffixSet.add("jpg");
		suffixSet.add("png");
		suffixSet.add("gif");
		suffixSet.add("css");
		suffixSet.add("js");
		suffixSet.add("rar");
		suffixSet.add("zip");
		suffixSet.add("apk");
		suffixSet.add("ico");
		suffixSet.add("login.do");
	}

}
