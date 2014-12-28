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
        	 <dt>管理员</dt>
            <dd ng-class="{'cur': pageID == 1}"><a href="#/account" ng-click="pageSelect(1)">管理产品</a></dd>
            
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

<s:include value="../public/member-footer.html" /><br />


</html>
