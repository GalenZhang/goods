<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
    <script type="text/javascript">
    
    function validate(){
      
      var pwd = document.getElementById("password").value;
       var pwd2 = document.getElementById("passwordtwo").value;
       
       if(pwd == pwd2) return true;
       else{
       alert("密码不一致。");
       return false;
       }
      
    };
    
    </script>

  </head>

  
  <body>
    <form action="user/reg.action" method="post" onsubmit="return validate();" >
				<fieldset>
					<div class="control-group">
						<label for="username">账号</label>
						<div class="controls">
							<input type="text" class="" id="username" name="username"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input type="password" class="" id="password" name="password"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input type="password" class="" id="passwordtwo" name="passwordtwo"/>
						</div>
					</div>
				</fieldset>

				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
					&nbsp; 注 册 &nbsp;
					</button>
				</div>
		</form>
  </body>
</html>
