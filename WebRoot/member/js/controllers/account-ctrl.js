/**
 * 
 */

APP.controller("accountCtrl", function($rootScope, $scope, accountService, memberService, JSUtil) {

	$rootScope.pageID = 6;
	var account = $scope.account={};
	$rootScope.$watch('user', function(to, from){
		var user = memberService.getUser();
		if (angular.isUndefined(user))
		{
			return;
		}
		$scope.account.username = user.username;
		$scope.account.email = user.email;
		$scope.account.phone = user.phone;
		$scope.account.id = user.id;
		$scope.account.isAdmin = user.isAdmin;
	});

	$scope.margeUser = function() {
		if (!JSUtil.isEmail(account.email))
		{
			alert('非法邮箱');
			return;
		}
		
		if (!JSUtil.isMobile(account.phone))
		{
			alert('非法手机号');
			return;
		}

		accountService.saveUserInfo($scope, account);
		$scope.$on("saveUserInfo", function(event, data) {
			alert(data.desc);
		});
	};

});
