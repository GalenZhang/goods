/**
 * 
 */
APP.controller("changepwdCtrl", function($rootScope, $scope, changepwdService, memberService) {
	
	$scope.password = {};
	$rootScope.pageID = 7;
	
	$scope.$on('changePassword', function(event, data){
		alert(data.desc);
	});
	
	$scope.changePassword = function(){
		if (!$scope.password.newpassword)
		{
			alert('新密码不能为空！');
			return;
		}
		if (!$scope.password.oldpassword)
		{
			alert('旧密码不能为空！');
			return;
		}
		if ($scope.password.newpassword != $scope.password.newpassword2)
		{
			alert('两次输入密码不一至！');
			return;
		}
		
		if ($scope.password.newpassword.length < 6)
		{
			alert("新密码不能小6位");
			return;
		}		
		var user = memberService.getUser();
		$scope.password.id = user.id;
		changepwdService.changePassword($scope, $scope.password);
	};
});