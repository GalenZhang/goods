APP.controller("loginCtrl", function($scope, loginService) {
	
	var user = $scope.user = {username: '', password : ''};
	
	$scope.changeState = function(){
		if ($scope.isLogin)
		{
			loginService.loginout($scope);
		}
		else
		{
			window.location.href = "login.html";
		}
	};
	
	
	
	$scope.$on("login", function(event, data){
		if(data.result)
		{
			if (data.obj == 1)
			{
				window.location.href = "../member/admin.html";
			}
			else
			{
				window.location.href = "../member/member.jsp";
			}
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
			$scope.username = '';
			$scope.isLogin = false;
			$scope.loginWord = ' 登录';
			window.location.href = "/goods/public/index.html";
		}
		else
		{
			alert('退出失败！');
		}
	});
	
	$scope.loginout = function(){
		loginService.loginout($scope);
	};
	
	$scope.$on("getUser", function(event, data){
		if(data)
		{
			//update the value on the top of page. login out -> login
			if (data.result)
			{
				$scope.username = data.obj;
				$scope.isLogin = true;
				$scope.loginWord = ' 退出';
			}
			else
			{
				$scope.username = '';
				$scope.isLogin = false;
				$scope.loginWord = ' 登录';
			}
		}
		else
		{
			return;
		}
	});
	
	$scope.getUser = function(){
		loginService.getUser($scope);
	};
	
	
	$(function(){
		loginService.getUser($scope);
	});
	

	
});