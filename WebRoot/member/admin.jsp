<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:include value="../public/header.html" />

<div class="space20"></div>
<!--main-->
<div class="row clearfix"  ng-controller="adminCtrl">
    <!--left-->
    <div class="member_left">
    	<div class="member_pic"><img src="../public/images/sample3.jpg" /></div>
        <div class="member_name">TSMER934984</div>
        <dl class="member_nav">
        	 <dt>管理员</dt>
            <dd ng-class="{'cur': pageID == 1}"><a href="#/manageProduce" ng-click="pageSelect(1)">产品管理</a></dd>
            <dd ng-class="{'cur': pageID == 2}"><a href="#/judgeCriticism" ng-click="pageSelect(2)">评论管理</a></dd>
            
        </dl>
    </div>
    <!--/left-->
    <!--right-->
    <div class="member_right">
    	
        <div class="space20"></div>
        
		<div ng-view></div>
        
        
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

<SCRIPT src="js/admin-route.js"></SCRIPT>

<!-- service -->
<SCRIPT src="js/services/admin-service.js"></SCRIPT>
<SCRIPT src="js/services/manage-product-service.js"></SCRIPT>
<SCRIPT src="js/services/judge-criticism-service.js"></SCRIPT>
<!-- service -->

<!-- controller -->
<SCRIPT src="js/controllers/admin-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/manage-produce-ctrl.js"></SCRIPT>
<SCRIPT src="js/controllers/judge-criticism-ctrl.js"></SCRIPT>
<!-- controller -->

</html>
