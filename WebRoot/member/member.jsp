<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:include value="../public/header.html" />

<div class="space20"></div>
<!--main-->
<div class="row clearfix"  ng-controller="memberCtrl">
    <!--left-->
    <div class="member_left">
    	<div class="member_pic"><img src="../public/images/sample3.jpg" /></div>
        <div class="member_name">TSMER934984</div>
        <dl class="member_nav">
        	<dt>交易管理</dt>
            <dd ng-class="{'cur': pageID == 1}"><a href="#/order" ng-click="pageSelect(1)">我的订单</a></dd>
            <dd ng-class="{'cur': pageID == 2}"><a href="#/criticism" ng-click="pageSelect(2)">商品评论</a></dd>
            <dd ng-class="{'cur': pageID == 3}"><a href="#/collect" ng-click="pageSelect(3)">我的收藏</a></dd>
            <dd ng-class="{'cur': pageID == 4}"><a href="#/change" ng-click="pageSelect(4)">帐户余额</a></dd>
            <!--<dd><a href="">我的积分</a></dd>-->
            <dd ng-class="{'cur': pageID == 5}"><a href="#/coupon" ng-click="pageSelect(5)">我的优惠券</a></dd>
            <dt>会员信息</dt>
            <dd ng-class="{'cur': pageID == 6}"><a href="#/account" ng-click="pageSelect(6)">帐户信息</a></dd>
            <dd ng-class="{'cur': pageID == 7}"><a href="#/changepwd" ng-click="pageSelect(7)">修改密码</a></dd>
            <dd ng-class="{'cur': pageID == 8}"><a href="#/receivedaddress" ng-click="pageSelect(8)">收货地址</a></dd>
            
        </dl>
    </div>
    <!--/left-->
    <!--right-->
    <div class="member_right">
    	<div class="member_info clearfix">
            <span class="account_alert">优惠券<br /><span><span class="f12">¥</span>5.00</span></span>
            <span class="account_alert">余额<br /><span><span class="f12">¥</span>0.0</span></span>
            <span class="account_alert">积分<br /><span>10000</span></span>
            <span class="member_ico"></span>
            <span class="member_grade">TSMER934984  (rae_dong@163.com)<br />
            普通会员  目前安全级别 低 <span class="safe_l"></span><!--中级/高级<span class="safe_m"></span><span class="safe_h"></span>-->
            </span>
        </div>
        <div class="space20"></div>
        
		<div ui-view></div>
		<div ui-view="orderdeail" ng-controller="orderCtrl">
			<div ui-view="top"></div>
			<div ui-view="orderinfo"></div>
			<!-- <div ui-view="sending"></div>
			<div ui-view="waitingforcriticism"></div> -->
			<div ui-view="bottom"></div>
		</div>
		
		
    </div>
    <!--/right-->
</div>
<!--/main-->
<div class="space20"></div>

<div id="bottom">
	<div class="row">
    
    </div>
</div>

<s:include value="../public/footer.html" /><br />
<SCRIPT src="js/route.js"></SCRIPT>
<!-- 
<script src="order/js/order-route.js"></script>
 -->

<!-- service -->
<SCRIPT src="js/services/member-service.js"></SCRIPT>
<SCRIPT src="js/services/account-service.js"></SCRIPT>
<SCRIPT src="js/services/change-service.js"></SCRIPT>
<SCRIPT src="js/services/changepwd-service.js"></SCRIPT>
<SCRIPT src="js/services/collect-service.js"></SCRIPT>
<SCRIPT src="js/services/coupon-service.js"></SCRIPT>
<SCRIPT src="js/services/criticism-service.js"></SCRIPT>
<SCRIPT src="js/services/order-service.js"></SCRIPT>
<SCRIPT src="js/services/receivedaddress-service.js"></SCRIPT>
<script src="order/js/services/waitingforpay-service.js"></script>
<script src="order/js/services/sending-service.js"></script>
<script src="order/js/services/waitingforcriticism-service.js"></script>
        
<!-- service -->

<!-- controller -->
<SCRIPT src="js/controllers/member-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/account-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/change-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/changepwd-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/collect-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/coupon-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/criticism-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/order-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/receivedaddress-ctrl.js"></SCRIPT>
<script src="order/js/controllers/waitingforpay-ctrl.js"></script>
<script src="order/js/controllers/sending-ctrl.js"></script>
<script src="order/js/controllers/waitingforcriticism-ctrl.js"></script>
<!-- controller -->

</html>
