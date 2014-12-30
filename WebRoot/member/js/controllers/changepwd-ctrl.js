/**
 * 
 */
APP.controller("changepwdCtrl", function($scope, changepwdService, accountService) {
	
	accountService.getUserInfo($scope);
	$scope.$on("getUserInfo", function(event, data) {
		if (data != null) {
			user = data[0];
			$scope.id = user.id;
		}

	});
	
	$("#password_saveBtn").click(function(){
		
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		var renewpassword = $("#renewpassword").val();
		var id = $("#changePwd_id").val();
		
		if($.trim(oldpassword) == ''|| $.trim(newpassword) == ''){
			$("#change_password_msg").html("<font color='red'>密码不能为空！</font>");
			return;
		}
		
		if(!newpassword == renewpassword){
			$("#change_password_msg").html("<font color='red'>新密码输入不一致！</font>");
			return;
		}
		
		changepwdService.changePassword($scope,oldpassword,newpassword,id);
		$scope.$on("changePassword",function(event,data){
			$("#change_password_msg").html("<font color='green'>"+data+"</font>");
			$("#oldpassword").val('');
			$("#newpassword").val('');
			$("#renewpassword").val('');
		});
		
	});
	
	
	
	
	
});