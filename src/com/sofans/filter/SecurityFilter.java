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

import com.sofans.constant.Constatnt;

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

		    String targetURL = currentURL.substring(currentURL.lastIndexOf("/"));
		    
		    String suffix = currentURL.substring(currentURL.lastIndexOf(".") + 1);
		    
		    if (!"/login.html".equals(targetURL) && !suffixSet.contains(suffix) && !"/login.do".equals(targetURL))
		    {
			    HttpSession session = req.getSession(); 
			    System.out.println("/");
			    if ("/".equals(targetURL))
			    {
			    	session.removeAttribute(Constatnt.USER_OBJ);
			    	 res.sendRedirect(req.getContextPath()+"/login/login.html");  
			    }
			    else if (session.getAttribute(Constatnt.USER_OBJ) != null) {
			        arg2.doFilter(req, res); 
			        return;
			    } else {
			        res.sendRedirect(req.getContextPath()+"/login/login.html");  
			    }  
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
	}

}
