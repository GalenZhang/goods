APP.controller("loginCtrl", function($scope, loginService) {
	
	$scope.user = {username: '', password : ''};
	
	$scope.$on("login", function(event, data){
		if(data.result)
		{
			window.location.href = "index.html";
		}
		else
		{
			alert('登陆失败！');
			return;
		}
	});
	
	$scope.login = function(){
		loginService.login($scope, $scope.user);
	};
	
	$scope.updateJpg = function(Verify){
		$(Verify).attr("src","../pic/securityCode.action?timestamp="+new Date().getTime());
	};
	
});