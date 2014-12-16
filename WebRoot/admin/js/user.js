sofansAPP.controller('userController', function($scope, $rootScope, $http,
		$element, $compile, userService,employeeService, globalValue) {

	userService.loadUser($scope);
	$scope.$on('loadUserData', function(event, data) {
		$rootScope.tableItems = data;
	});
	// $http.get('sys/user/list.do').success(function(data){
	// $rootScope.tableItems =data;
	// }).error(function(data){
	// alert('error');
	// });

	/*
	 * select标签 绑定销售经理 的加载数据
	 */
	employeeService.loadAllEmp($scope);
	$scope.$on('loadAllemps',function(event,data){
		var tableEmployeeItems = data;
		var employeeValues = [];
		angular.forEach(tableEmployeeItems, function(employee) {
			employeeValues.push({
				empID : employee.id,
				empName : employee.name
			});
		});
		$rootScope.Angentemployees = employeeValues;
	});
//	$http.get('sys/employee/load.do').success(function(data) {
//		var tableEmployeeItems = data;
//		var employeeValues = [];
//		angular.forEach(tableEmployeeItems, function(employee) {
//			employeeValues.push({
//				empID : employee.id,
//				empName : employee.name
//			});
//		});
//		$rootScope.Angentemployees = employeeValues;
//	}).error(function(data) {
//		alert('error');
//	});

	
	
	$scope.remove = function(id) {
		if (!confirm("确定要删除吗？"))
			return false;
		userService.removeUser($scope, id);
		$scope.$on('removeUserData',function(event,data){
			if (data.result) {
				$scope.tableItems = data.obj;
				alert('删除成功！');
			}
		});
//		var url = 'sys/user/remove.do?id=' + id;
//		$http.get(url).success(function(data) {
//			if (data.result) {
//				$scope.tableItems = data.obj;
//				alert('删除成功！');
//			}
//		}).error(function(data) {
//			alert('error');
//		});
	};

	$scope.update = function(id) {
		var tableItems = $rootScope.tableItems;
		var updateObj = {};
		for (var i = 0; i < tableItems.length; i++) {
			if (tableItems[i].id == id) {
				updateObj = tableItems[i];
				break;
			}
		}
		updateObj.password = '';
		$rootScope.sufansSysUser = updateObj;
		$('#userModal').modal('toggle');
		$("#empName").hide();
		$("#empNametwo").show();
	};

	$scope.add = function() {
		$rootScope.sufansSysUser = {
			name : '',
			password : '',
			email : '',
			phone : '',
			enabled : 1,
			emp_id : '',
			id : 0
		};
		$('#userModal').modal('toggle');
		$("#empName").show();
		$("#empNametwo").hide();
	};
});

/*
 * 把代理商的emp_id过滤成与emp_id对应的员工名
 * 
 * 此处有一个问题 ： 不知道为何要循环双倍的次数，导致过滤后的数据又清空了。用 name = this.tableAngentItem.emp_id
 * 来控制清空
 * 
 */
var rootEmployee = loadEmp();

sofansAPP.filter('empNameFilterByuser', function() {
	return function(tableItem) {

		var employeeValues = rootEmployee;
		var id = this.tableItem.emp_id;
		var name = this.tableItem.emp_id;
		var keepGoing = true;
		angular.forEach(employeeValues, function(emp) {

			if (keepGoing) {
				if (emp.empID == id) {
					name = emp.empName;
					keepGoing = false;
				}
			}
		});
		return this.tableItem.emp_id = name;
	};
});

function loadEmp() {
	var employeeValues = [];
	$.get('sys/employee/load.do').success(function(data) {
		var tableEmployeeItems = data;
		angular.forEach(tableEmployeeItems, function(employee) {
			employeeValues.push({
				empID : employee.id,
				empName : employee.name
			});
		});
	}).error(function(data) {
		alert('error');
	});
	return employeeValues;

}

/*******************************************************************************
 * *
 ******************************************************************************/

sofansAPP.controller('updateUserController', function($scope, $rootScope,
		$http, $element, $compile, userService,globalValue) {
	$rootScope.sufansSysUser = {
		name : '',
		password : '',
		email : '',
		phone : '',
		enabled : 1,
		emp_id : '',
		id : 0
	};
	var rootScope = $rootScope;

	$scope.save = function() {

		if (globalValue.isUndefinedOrNull(rootScope.sufansSysUser.name)
				&& !!checkPassword(rootScope.sufansSysUser.name)) {
			alert('登陆名只能为数字或字母且不能为空！');
			return;
		}
		if (!checkPassword(rootScope.sufansSysUser.password)
				&& globalValue
						.isUndefinedOrNull(rootScope.sufansSysUser.password)) {
			alert('密码只能为数字或字母且不能为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysUser.phone)
				|| !checkMobile(rootScope.sufansSysUser.phone)) {
			alert("手机号码填写错误！");
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysUser.name)
				|| !isEmail(rootScope.sufansSysUser.email)) {
			alert('邮箱格式错误且不能为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysUser.emp_id)) {
			alert('创建的账号必须绑定一名员工！');
			return;
		} else {
			var sufansSysUser = rootScope.sufansSysUser;

			/*
			 * update ： 由于前面用filter来过滤了数据，显示的emp_id替换成了中文名字。 现在在添加的之前来替换回来。
			 */
			var atEmps = $rootScope.Angentemployees;
			for (var i = 0; i < atEmps.length; i++) {
				if (sufansSysUser.emp_id == atEmps[i].empName) {
					sufansSysUser.emp_id = atEmps[i].empID;
					break;
				}
			}

			var isUpdate = false;
			if (sufansSysUser.id > 0)// update
			{
				var tmpObj = {
					name : sufansSysUser.name,
					password : sufansSysUser.password,
					email : sufansSysUser.email,
					phone : sufansSysUser.phone,
					enabled : 1,
					id : sufansSysUser.id,
					emp_id : sufansSysUser.emp_id
				};
				sufansSysUser = tmpObj;
				isUpdate = true;
			}
//			userService.saveUser($scope,sufansSysUser);
//			$scope.$on('saveUserData',function(event,data){
//				if (data.result && !isUpdate) {
//					var ds = $rootScope.tableItems;
//					ds.push(data.obj);
//					$rootScope.tableItems = ds;
//					alert("保存成功！");
//				} else {
//					alert("保存成功！");
//				}
//				// clear the data from the form.
//				rootScope.sufansSysUser = {
//					name : '',
//					password : '',
//					email : '',
//					phone : '',
//					emp_id : '',
//					enabled : 1
//				};
//			});
			$http({
				method : 'POST',
				url : 'sys/user/save.do',
				dataType : 'json',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(sufansSysUser)
			}).success(function(data) {
				if (data.result && !isUpdate) {
					var ds = $rootScope.tableItems;
					ds.push(data.obj);
					$rootScope.tableItems = ds;
					alert("保存成功！");
				} else {
					alert("保存成功！");
				}
				// clear the data from the form.
				rootScope.sufansSysUser = {
					name : '',
					password : '',
					email : '',
					phone : '',
					emp_id : '',
					enabled : 1
				};
			}).error(function(data) {
				alert('error');
			});

		}
	};
});
