<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"member/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>Login</title>
<link href="style/global.css" rel="stylesheet" type="text/css" />
<link href="style/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../vendor/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>

<div id="member_head" class="member_row">
	<div class="mem_headtitle">会员登录</div>
</div>

<div class="member_row">
    <div id="login" class="clearfix">
        <div id="mem_arr"></div>
        <div class="right">
        	<div class="title"><a href="register.jsp">注册新帐号</a></div>
            <div class="form">
            	<div class="line" id="username"><input type="text" name="username" value="" class="log_txt" /></div>
                <div class="line" id="password"><input type="password" name="password" value="" class="log_txt" /></div>
                <span id="error_msg"></span>
                <div class="line"><span><a href="" class="blue">忘记密码，点这里</a></span><input type="checkbox" name="remember" id="remember" value="1" /> <label for="remember" class="blue">记住密码</label></div>
                <div class="line"><input id="tijiao" name="tijiao" value="登陆" class="log_btn" /></div>
                <div class="line center" id="oath"><a href=""><img src="images/weibo.jpg" alt="微博登陆" /></a><a href=""><img src="images/qq.jpg" alt="QQ登陆" /></a></div>
            </div>
        </div>
        <div class="left">
        <img src="images/login_ad.jpg" />
        </div>
    </div>
</div>
<div class="space20"></div>

<div id="footer" class="member_row center">
    <a href="" title="">关于精英食品</a> |　<a href="" title="">客服中心</a> | <a href="" title="">联系我们</a>　| <a href="" title="">友情链接</a><br />
    &copy; 2014 www.infoyu.com 精英食品有限公司<br />
    增值电信经营许可证号:粤B2-20110495  网站备案号:粤B2-20030128号<br />    
    <img src="images/unionpay.gif" /><img src="images/govIcon.gif" /><img src="images/xfz.gif" /><img src="images/VieID_140_50.png" />
</div>

</body>
</html>
