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
	
	$scope.$on("loginout", function(event, data){
		if(data.result)
		{
			//update the value on the top of page. login out -> login
		}
		else
		{
			alert('退出失败！');
			return;
		}
	});
	
	$scope.loginout = function(){
		loginService.login($scope);
	};
	
	$scope.$on("getUser", function(event, data){
		if(data.result)
		{
			//update the value on the top of page. login out -> login
		}
		else
		{
			return;
		}
	});
	
	$scope.getUser = function(){
		loginService.getUser($scope);
	}
	
	$scope.updateJpg = function(Verify){
		$(Verify).attr("src","../pic/securityCode.action?timestamp="+new Date().getTime());
	};
	
});