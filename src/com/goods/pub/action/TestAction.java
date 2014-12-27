package com.goods.pub.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sofans.dao.ILoginService;

@ParentPackage(value = "defaultpackage")  //表示继承的父包  
@Namespace(value="/test") //表示当前Action所在命名空间  
public class TestAction extends ActionSupport{

	@Autowired
	ILoginService loginServiceImpl;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4762917352000176085L;

	 private String str;     
	 private TestBean testBean;
	 private List<TestBean> checklist;
	    
	    @Actions({@Action(value="login1", params={"str","这是已经注入的了！"}, 
	    		results={@Result(name="sucess", location="/success.jsp")}), 
	    		@Action(value="login2", 
	    		results={@Result(name="tag", location="/tag.jsp")})})
	    public String login(){
	    	
	    	HttpServletRequest request = ServletActionContext.getRequest();
	    	request.setAttribute("username", "zhangsan");
	    	
	    	ActionContext actionContext = ActionContext.getContext();
	    	Map<String, Object> session = actionContext.getSession();
	    	session.put("age", 555);
	    	
	       return "tag";     
	    }
	    
	    //goods/user/ggg.action
	    @Action(value="ggg", 
	    	results={  //表示结果跳转  
               	@Result(name="success", location="/success.jsp"),  
               	@Result(name="login", location="/login.jsp",type="redirect"),  
               	@Result(name="error", location="/error.jsp",type="redirect")  
        	},
        	interceptorRefs={ //表示拦截器引用  
               @InterceptorRef("defaultStack"),
               @InterceptorRef("timer")
        	},
        	exceptionMappings={  //映射映射声明  
	    	   @ExceptionMapping(exception="java.lang.Exception",result="error")  
        })
	    public String abc(){
	    	
	    	testBean = new TestBean();
	    	testBean.setName("ray");
	    	
	    	List<TestBean> list = new ArrayList<TestBean>();
	    	TestBean t1 = new TestBean();
	    	t1.setId("1");
	    	t1.setName("n1");
	    	list.add(t1);

	    	TestBean t2 = new TestBean();
	    	t2.setId("2");
	    	t2.setName("n2");
	    	list.add(t2);

	    	TestBean t3 = new TestBean();
	    	t3.setId("3");
	    	t3.setName("n3");
	    	list.add(t3);
	    	
	    	this.checklist = list;
	    	
	       return "success";
	    }
	    
	    public String getStr() {
	       return str;
	    }
	    
	    public void setStr(String str) {
	       this.str = str;
	    }
		public TestBean getTestBean() {
			return testBean;
		}
		public void setTestBean(TestBean testBean) {
			this.testBean = testBean;
		}
		public List<TestBean> getChecklist() {
			return checklist;
		}
		public void setChecklist(List<TestBean> checklist) {
			this.checklist = checklist;
		}

}
