<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login_reg.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="../login/login.css" rel="stylesheet" />
<link rel="shortcut icon" href="../img/logo.ico">
<script src="../vendor/jquery/jquery-1.10.2.js"></script>

<script>
	function open_regPage() {
		window.open("reg.jsp");
	}
	
	function validate(){
	return true;
	}
	
</script>

</head>

<body>
	<div id="login-container">


		<div id="login-header">

			<h3>GOODS</h3>

		</div>
		<!-- /login-header -->



		<div id="login-content" class="clearfix">


			<form action="login/login.action" method="post" onsubmit="return validate();">
				<fieldset>
					<div class="control-group">
						<label for="username">账号</label>
						<div class="controls">
							<input type="text" class="" id="username" name="username" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input type="password" class="" id="password" name="password" />
						</div>
					</div>
					
				</fieldset>

				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
						&nbsp; 登 录 &nbsp;</button>
					<button type="button" id="reg_btn" name="reg_btn"
						onclick="open_regPage()" class="btn btn-warning btn-large">
						&nbsp; 注 册 &nbsp;</button>
				</div>
			</form>

		</div>

	</div>
</body>
</html>
