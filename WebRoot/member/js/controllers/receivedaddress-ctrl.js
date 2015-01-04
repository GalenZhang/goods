/**
 * 
 */
APP.controller("receivedaddressCtrl", function($rootScope, $scope, receivedaddressService, memberService,JSUtil) {
	
	$rootScope.pageID = 8;
	receivedaddressService.addressInfo($scope);
	$scope.$on("addressInfo",function(event,data){
		if(data == ''){
			$("#address_msg").html("您还没有添加地址！");
		}else{
			$scope.addressItems = data;
			
		
		}
		
	});
	
	/*
	 * 问题。 不知道为何会出发两次点击时间， 数据库也会有两条 insert数据，相同的数据
	 */
	
	$scope.saveAddress=function(){
		
		$("#saveAddress_msg").html('');
		var a = $("#receiver_name").val();
		var b = $("#receiver_phone").val();
		var c = $("#address").val();
		
		if(a=='' || c==''){
			alert('联系人和地址不能为空！');
			return;
		}
		if (!JSUtil.isMobile(b))
		{
			alert('非法手机号');
			return;
		}
		//alert(a+','+c+','+b);		
		var deliverAddress = {
				address:c,
			receiverName:a,
			receiverPhone:b
		};
		
		
		receivedaddressService.saveAddress($scope,deliverAddress);
		$scope.$on("saveAddress",function(event,data){

			$("#saveAddress_msg").html(data);
			$("#receiver_name").val('');
			$("#receiver_phone").val('');
			$("#address").val('');
		});
	};

	$('a[rel*=leanModal]').leanModal({ top: 100, closeButton: ".modal_close" });
});