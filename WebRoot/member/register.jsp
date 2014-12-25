<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
System.out.print("path : -> "+ path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"member/";
System.out.print("basePath : -> "+ basePath);
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
<title>Register</title>
<link href="style/global.css" rel="stylesheet" type="text/css" />
<link href="style/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<SCRIPT type="text/javascript" src="js/register.js"></SCRIPT>
</head>

<body>

<div id="member_head" class="member_row">
	<div class="mem_headtitle">会员注册</div>
</div>

<div class="member_row">
    <div id="register" class="clearfix">
        <div class="left">
        	<div class="title"><img src="images/reg.gif" /></div>
            <div class="form">
            <form action="" id="reg_form">
            	<div class="line">
            	
                <label for="username" class="f14 dis">设置帐号</label>
                <input type="text" name="username" id="username" value="" class="reg_txt" />
                <span class="form_alert" id="name_msg">*请输入8-20位字母或数字</span>
                </div>
                <div class="line">
                <label for="password" class="f14 dis">设置密码</label>
                <input type="password" name="password" id="password" value="" class="reg_txt" />
                <span class="form_alert" id="pwd_msg">*</span>
                </div>
                <div class="line">
                <label for="repassword" class="f14 dis">确认密码</label>
                <input type="password" name="repassword" id="repassword" value="" class="reg_txt" />
                <span class="form_alert">*</span>
                </div>
                <div class="line" id="l_capcha">
                <label for="capcha" class="f14 dis">验证码</label>
                <input type="text" name="capcha" id="capcha" value="" class="reg_txt" />
                <span class="form_alert">*</span>
                </div>
                <div class="line" id="l_capcha_p">
                <label class="f14 dis">换一张</label>
                <div><img src="images/capcha.gif" /></div>
                </div>
                
                <div class="clear"></div>
                <div class="line"><input type="checkbox" name="remember" id="remember" value="1" /> <label for="remember" class="blue">我已阅读并同意《会员注册协议》</label></div>
                <div class="line"><input type="submit" name="tijiao" value="注册" class="reg_btn" /></div>
            </form> 
            </div>
        </div>
        
        <div class="right">
        	<div class="reg_login"><a href="login.jsp"></a></div>
            <div class="reg_rule">
            	<div class="center f14">用户注册协议</div>
                <div class="reg_rule_c">
                本协议是您与名物汇网站（简称"本站"，网址：www.mwhui.com）所有者（以下简称为"名物汇"）之间就名物汇网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您勾选"阅读并同意"选项并点击"注册"成功后，本协议即构成对双方有约束力的法律文件。

第1条 本站服务条款的确认和接纳

1.1本站的各项电子服务的所有权和运作权归名物汇所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。

1.2用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。

1.3如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本站。

1.4名物汇保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。

第2条 本站服务

2.1名物汇通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。

2.2用户必须自行准备如下设备和承担如下开支：（1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；（2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。

第3条 用户依法言行义务

本协议依据国家相关法律法规规章制定，用户同意严格遵守以下义务：

（1）不得传输或发表：煽动抗拒、破坏宪法和法律、行政法规实施的言论，煽动颠覆国家政权，推翻社会主义制度的言论，煽动分裂国家、破坏国家统一的的言论，煽动民族仇恨、民族歧视、破坏民族团结的言论；

（2）从中国大陆向境外传输资料信息时必须符合中国有关法规；

（3）不得利用本站从事洗钱、窃取商业秘密、窃取个人信息等违法犯罪活动；

（4）不得干扰本站的正常运转，不得侵入本站及国家计算机信息系统；

（5）不得传输或发表任何违法犯罪的、骚扰性的、中伤他人的、辱骂性的、恐吓性的、伤害性的、庸俗的，淫秽的、不文明的等信息资料；

（6）不得传输或发表损害国家社会公共利益和涉及国家安全的信息资料或言论；

（7）不得教唆他人从事本条所禁止的行为；

（8）不得利用在本站注册的账户进行牟利性经营活动；

（9）不得发布任何侵犯他人著作权、商标权等知识产权或合法权利的内容；

用户应不时关注并遵守本站不时公布或修改的各类合法规则规定。

本站保有删除站内各类不符合法律政策或不真实的信息内容而无须通知用户的权利。

若用户未遵守以上规定的，本站有权作出独立判断并采取暂停或关闭用户帐号等措施。用户须对自己在网上的言论和行为承担法律责任。

第4条 商品信息

本站上的商品价格、数量、是否有货等商品信息随时都有可能发生变动，本站不作特别通知。由于网站上商品信息的数量极其庞大，虽然本站会尽最大努力保证您所浏览商品信息的准确性，但由于众所周知的互联网技术因素等客观原因存在，本站网页显示的信息可能会有一定的滞后性或差错，对此情形您知悉并理解；名物汇欢迎纠错，并会视情况给予纠错者一定的奖励。

为表述便利，商品和服务简称为"商品"或"货物"。
                </div>
            </div>
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
