APP.controller("loginCtrl", function($scope, loginService) {
	
	var user = $scope.user = {username: '', password : ''};
	
	$scope.$on("login", function(event, data){
		if(data.result)
		{
			window.location.href = "../member/member.html";
		}
		else
		{
			alert('登陆失败！');
			return;
		}
	});
	
	$scope.login = function(){
		if (angular.isUndefined(user.username) || !user.username)
		{
			alert('请输入用户名!');
			return;
		}
		if (angular.isUndefined(user.password) || !user.password)
		{
			alert('请输入密码!');
			return;
		}
		loginService.login($scope, $scope.user);
		
	};
	
	$scope.updateJpg = function(Verify){
		$(Verify).attr("src","../pic/securityCode.action?timestamp="+new Date().getTime());
	};
	
});