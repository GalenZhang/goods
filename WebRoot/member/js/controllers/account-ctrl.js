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

		debugger;
		
		accountService.saveUserInfo($scope, account);
		$scope.$on("saveUserInfo", function(event, data) {
			alert(data.desc);
		});
	};

});
function checkSubmitEmail() {
	if ($("#email").val() == "") {
		$("#confirmMsg").html("<font color='red'>邮箱地址不能为空！</font>");

		$("#email").focus();
		return false;
	}
	if (!$("#email")
			.val()
			.match(
					/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {

		$("#confirmMsg").html("<font color='red'>邮箱格式不正确！请重新输入！</font>");
		$("#email").focus();
		return false;
	}
	return true;
}
function checkSubmitMobil() {
	if ($("#phone").val() == "") {
		 $("#moileMsg").html("<font color='red'>手机号码不能为空！</font>");
		$("#phone").focus();
		return false;
	}

	if (!$("#phone").val().match(/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/)) {
		$("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>");
		$("#phone").focus();
		return false;
	}
	return true;
}