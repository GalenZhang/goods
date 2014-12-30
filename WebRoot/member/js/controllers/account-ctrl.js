/**
 * 
 */

APP.controller("accountCtrl", function($scope, accountService) {

	accountService.getUserInfo($scope);
	$scope.$on("getUserInfo", function(event, data) {
		if (data != null) {
			user = data[0];
			$scope.username = user.username;
			$scope.id = user.id;
			$scope.email = user.email;
			$scope.phone = user.phone;
		}

	});

	$scope.margeUser = function() {
		$("#confirmMsg").html('');
		$("#moileMsg").html('');
		if(!checkSubmitEmail()) return; 
		if(!checkSubmitMobil()) return;
		
		var email = document.getElementById("email").value;
		var phone = document.getElementById("phone").value;

		var user = {
			id : $scope.id,
			username : $scope.username,
			email : email,
			phone : phone,

		};

		accountService.saveUserInfo($scope, user);
		$scope.$on("saveUserInfo", function(event, data) {
			alert(data);
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