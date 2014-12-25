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
<title>member center</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="style/global.css" rel="stylesheet" type="text/css" />
<link href="style/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<SCRIPT type="text/javascript" src="js/lrscroll.js"></SCRIPT>
</head>

<body>
	<!--top ad-->
	<div id="top_ad" class="center" style="background-color:#EB1521">
		<a href=""><img src="images/sample1.jpg" /></a>
	</div>
	<!--/top ad-->


	<div id="bread">
		<div class="row">
			<div class="left">
				<a href="" class="addfavor">收藏</a><a href="" class="sina">关注</a>
			</div>
			<div class="right">
				你好， 欢迎来到精英食品！[<a href="login.jsp">登录</a>][<a href="register.jsp">注册</a>]
				<a class="line cart">购物车0件</a><a class="line order">我的订单</a>
			</div>
		</div>
	</div>
	<!--head-->
	<div class="row clearfix">
		<div id="logo">
			<a href="index.html"><img src="images/logo.jpg" /></a>
		</div>
		<div id="search">
			<div class="search_box">
				<input type="text" name="keyword" value="" />
			</div>
			<div class="search_btn">
				<input type="submit" name="search" value="搜索" />
			</div>
			<div class="search_keywords">
				<a href="" class="key_btn">热门搜索</a>
				<ul>
					<li><a href="">阿克苏苹果</a></li>
					<li><a href="">葡萄酒</a></li>
					<li><a href="">蜂蜜</a></li>
					<li><a href="">奶粉</a></li>
				</ul>
			</div>
		</div>
		<div id="head_right">
			<img src="images/img1.jpg" />
		</div>
	</div>
	<!--/head-->

	<div id="nav">
		<div class="row">
			<div class="nav_category">
				<div class="nav_cate_all">
					<a href="">全部商品分类</a>
				</div>
			</div>
			<ul class="nav">
				<li class="cur"><a href="">首 页</a></li>
				<li><a href="">海 鲜</a></li>
				<li><a href="">特 产</a></li>
				<li><a href="">红 酒</a></li>
				<li><a href="">团 购</a></li>
				<li><a href="">品牌街</a></li>
				<li><a href="">海洋食品文化中心</a></li>
			</ul>
		</div>
	</div>

	<div class="space20"></div>
	<!--main-->
	<div class="row clearfix">
		<!--left-->
		<div class="member_left">
			<div class="member_pic">
				<img src="images/sample3.jpg" />
			</div>
			<div class="member_name">TSMER934984</div>
			<dl class="member_nav">
				<dt>交易管理</dt>
				<dd class="cur">
					<a href="">我的订单</a>
				</dd>
				<dd>
					<a href="">商品评论</a>
				</dd>
				<dd>
					<a href="">我的收藏</a>
				</dd>
				<dd>
					<a href="">帐户余额</a>
				</dd>
				<dd>
					<a href="">我的积分</a>
				</dd>
				<dd>
					<a href="">我的优惠券</a>
				</dd>
				<dt>会员信息</dt>
				<dd>
					<a href="">帐户信息</a>
				</dd>
				<dd>
					<a href="">修改密码</a>
				</dd>
				<dd>
					<a href="">收货地址</a>
				</dd>
			</dl>
		</div>
		<!--/left-->
		<!--right-->
		<div class="member_right">
			<div class="member_info clearfix">
				<span class="account_alert">优惠券<br />
				<span><span class="f12">¥</span>5.00</span></span> <span
					class="account_alert">余额<br />
				<span><span class="f12">¥</span>0.0</span></span> <span
					class="account_alert">积分<br />
				<span>10000</span></span> <span class="member_ico"></span> <span
					class="member_grade">TSMER934984 (rae_dong@163.com)<br />
					普通会员 目前安全级别 低 <span class="safe_l"></span>
				<!--中级/高级<span class="safe_m"></span><span class="safe_h"></span>-->
				</span>
			</div>
			<div class="space20"></div>

			<!--order list-->
			<div class="member_title">
				<h5>我的订单</h5>
				<ul class="member_t_lab">
					<li id="atb_1" class="main_labels"><a href=""
						onMouseover="hoverLi(1,3,'a');">待付款<span class="red">(3)</span></a></li>
					<li id="atb_2"><a href="" onMouseover="hoverLi(2,3,'a');">已发货</a></li>
					<li id="atb_3"><a href="" onMouseover="hoverLi(3,3,'a');">待评论<span
							class="red">(3)</span></a></li>
				</ul>
			</div>
			<div class="space10"></div>
			<div class="order_list">
				<div id="atbc_1">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<th colspan="6">&nbsp;&nbsp;2014-11-29&nbsp;&nbsp;&nbsp;&nbsp;订单号：877760253737436</th>
						</tr>
						<tr>
							<td width="100" align="center" class="first"><div
									class="order_list_p">
									<a href=""><img src="images/sample2.jpg" /></a>
								</div></td>
							<td><a href="">深都优选长荡湖大闸蟹壹对 2.4-2.0两公蟹*2只1.8-1.5两母蟹*2只</a></td>
							<td width="100" align="center"><span class="price"><span>¥</span>168.00</span></td>
							<td width="100" align="center" class="border_r">1</td>
							<td width="150" align="center" rowspan="2" class="border_r"><span
								class="price"><span>¥</span>237.00</span></td>
							<td width="150" align="center" rowspan="2" class="border_r"><a
								href="">订单详情</a></td>
						</tr>
						<tr>
							<td align="center" class="first"><div class="order_list_p">
									<a href=""><img src="images/sample2.jpg" /></a>
								</div></td>
							<td><a href="">深都优选长荡湖大闸蟹壹对 2.4-2.0两公蟹*2只1.8-1.5两母蟹*2只</a><br />
								<span class="gray">保罗玛斯酒庄 乡野绅士干红葡萄酒 750ml*4</span></td>
							<td align="center"><span class="price"><span>¥</span>168.00</span></td>
							<td align="center" class="border_r">1</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<th colspan="6">&nbsp;&nbsp;2014-11-29&nbsp;&nbsp;&nbsp;&nbsp;订单号：877760253737436</th>
						</tr>
						<tr>
							<td width="100" align="center" class="first"><div
									class="order_list_p">
									<a href=""><img src="images/sample2.jpg" /></a>
								</div></td>
							<td><a href="">深都优选长荡湖大闸蟹壹对 2.4-2.0两公蟹*2只1.8-1.5两母蟹*2只</a></td>
							<td width="100" align="center"><span class="price"><span>¥</span>168.00</span></td>
							<td width="100" align="center" class="border_r">1</td>
							<td width="150" align="center" class="border_r"><span
								class="price"><span>¥</span>237.00</span></td>
							<td width="150" align="center" class="border_r"><a href="">订单详情</a></td>
						</tr>
					</table>
				</div>
				<div id="atbc_2" class="undis">
					<table width="100%" border="0" cellspacing="0" cellpadding="5">
						<tr>
							<th colspan="6">&nbsp;&nbsp;2014-11-29&nbsp;&nbsp;&nbsp;&nbsp;订单号：877760253737436</th>
						</tr>
						<tr>
							<td width="100" align="center" class="first"><div
									class="order_list_p">
									<a href=""><img src="images/sample2.jpg" /></a>
								</div></td>
							<td><a href="">深都优选长荡湖大闸蟹壹对 2.4-2.0两公蟹*2只1.8-1.5两母蟹*2只</a></td>
							<td width="100" align="center"><span class="price"><span>¥</span>168.00</span></td>
							<td width="100" align="center" class="border_r">1</td>
							<td width="150" align="center" class="border_r"><span
								class="price"><span>¥</span>237.00</span></td>
							<td width="150" align="center" class="border_r"><a href="">订单详情</a></td>
						</tr>
					</table>
				</div>
				<div id="atbc_3" class="undis"></div>
			</div>
			<!--/order list-->
			<div class="space20"></div>

			<div class="member_title">
				<h5>
					<span class="f16">猜您喜欢</span>
				</h5>
				<a href="javascript:void();" class="refresh">换一组</a>
			</div>
			<div class="space10"></div>
			<div class="goods_list" id="botton-scroll">
				<ul class="clearfix">
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample2.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample4.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample2.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample4.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample2.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample2.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample4.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
					<li>
						<div class="goods_p">
							<a href=""><img src="images/sample2.jpg" /></a>
						</div>
						<div class="goods_t">
							<a href="">野生鳗鱼干 小鳗鲞 鳗鱼鲞海鲜干货咸鱼干特产干货500克2-3条真</a>
						</div>
						<div class="goods_price">
							<span>¥</span>35.00
						</div>
						<div class="goods_btn">
							<a href=""><img src="images/buy1.png" /></a>
						</div>
					</li>
				</ul>
			</div>

		</div>
		<!--/right-->
	</div>
	<!--/main-->
	<div class="space20"></div>

	<div id="bottom">
		<div class="row"></div>
	</div>

	<div id="guarantee">
		<img src="images/guarantee.gif" />
	</div>

	<div id="footer" class="member_row center">
		<a href="" title="">关于精英食品</a> | <a href="" title="">客服中心</a> | <a
			href="" title="">联系我们</a> | <a href="" title="">友情链接</a><br />
		&copy; 2014 www.infoyu.com 精英食品有限公司<br /> 增值电信经营许可证号:粤B2-20110495
		网站备案号:粤B2-20030128号<br /> <img src="images/unionpay.gif" /><img
			src="images/govIcon.gif" /><img src="images/xfz.gif" /><img
			src="images/VieID_140_50.png" />
	</div>

</body>
</html>

<script>
	function g(tab) {
		return document.getElementById(tab);
	}
	function hoverLi(n, nm, c) {
		for (var i = 1; i <= nm; i++) { //如果有N个标签,就将i<=N; 
			g(c + 'tb_' + i).className = '';
			g(c + 'tbc_' + i).className = 'undis';
		}
		g(c + 'tbc_' + n).className = 'dis';
		g(c + 'tb_' + n).className = 'main_labels';
	}

	
</script>