APP.controller("loginCtrl", function($scope, loginService) {
	
	$scope.user = {username: '', password : ''};
	$scope.login = function(){
		loginService.login($scope, $scope.user);
	};
	
	$scope.updateJpg = function(Verify){
		$(Verify).attr("src","../pic/securityCode.action?timestamp="+new Date().getTime());
	};
	
});