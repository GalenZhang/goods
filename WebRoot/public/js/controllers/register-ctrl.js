APP.controller("registerCtrl", function($scope, $http, registerService) {

	var user = $scope.user = {
		username : '',
		password : ''
	};

	$scope.$on("register", function(event, data) {
		user.username = "";
		user.password = "";
		$("#repassword").val("");
		alert(data);
	});

	var ischeck = false;
	$("#username").blur(function() {

		registerService.checkName($scope, $scope.user.username);
		$scope.$on("checkName", function(event, data) {
			if (data.length > 0) {
				ischeck = true;
				$("#name_msg").html("错误 : 该帐号名已被注册!!");
			}else{
				ischeck = false;
				$("#name_msg").html("");
			}
		});
	});

	$scope.register = function() {

		

		var repassword = $("#repassword").val();
		var remember = $("#remember").is(':checked');
		
		if (ischeck) {
			return;
		}

		if (user.username.length > 20 || user.username.length < 8) {
			$("#name_msg").html("错误 : 账号应该为8-20位的数字或字母!");

			return;
		}

		if (!/^(\d|[a-zA-Z])+$/.test(user.username)) {
			$("#name_msg").html("错误 : 账号应该为8-20位的数字或字母!");
			return;
		}
		

		if (user.password == '') {
			$("#pwd_msg").html("提示 : 请输入密码!");
			return;
		}

		if (user.password != repassword) {
			$("#pwd_msg").html("提示 : 密码不一致!");
			return;
		}



		if (!remember) {
			return;
		}
		registerService.register($scope, $scope.user);

	};

});
