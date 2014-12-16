sofansAPP.controller("angentController", function($scope, $rootScope, $http,
		$element, $compile, agentService, globalValue) {

	var v = loginUserID;

	if (v > 1) {
		agentService.loadAngentsByID($scope,v);
		$scope.$on('agentsByIdList',function(event,data){
			$rootScope.tableAngentItems = data;
		});


	} else {
		agentService.loadAngents($scope);
		$scope.$on('agentsList',function(event,data){
			$rootScope.tableAngentItems = data;
		});
	}
	
	

	/*
	 * select标签 绑定销售经理 的加载数据
	 */
	agentService.loadDatas($scope);
	$scope.$on('agents', function(event, data){
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

	$scope.add = function() {
		$rootScope.sufansSysAngent = {
			name : '',
			sex : '',
			age : '',
			phone : '',
			tel : '',
			company : '',
			address : '',
			agentTppeId : '',
			emp_id : '',
			id : 0
		};
		$('#angentModal').modal('toggle');
		$("#empName").show();
		$("#empNametwo").hide();
	};

	$scope.remove = function(id) {
		if (!confirm("确定要删除吗？"))
			return false;
		agentService.removeAngentByID($scope, id, v);
		$scope.$on('removeAngentl',function(event, data){
			if (data.result) {
				$rootScope.tableAngentItems = data.obj;
				alert('删除成功！');
			}
		});
	};

	$scope.update = function(id) {

		var tableAngentItems = $rootScope.tableAngentItems;
		var updateObj = {};
		for (var i = 0; i < tableAngentItems.length; i++) {
			if (tableAngentItems[i].id == id) {
				updateObj = tableAngentItems[i];
				break;
			}
			;
		}

		$rootScope.sufansSysAngent = updateObj;
		$('#angentModal').modal('toggle');
		$("#empName").hide();
		$("#empNametwo").show();
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

sofansAPP.filter('empNameFilter', function() {
	return function(tableAngentItem) {

		var employeeValues = rootEmployee;
		var id = this.tableAngentItem.emp_id;
		var name = this.tableAngentItem.emp_id;
		var keepGoing = true;
		angular.forEach(employeeValues, function(emp) {

			if (keepGoing) {
				if (emp.empID == id) {
					name = emp.empName;
					keepGoing = false;
				}
			}
		});
		return this.tableAngentItem.emp_id = name;
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

/*
 * sexFilter : 性别过滤器，在数据库里 1 代表男性 0 代表女性。
 */
sofansAPP.filter('sexFilter', function() {
	return function(tableAngentItem) {
		return this.tableAngentItem.sex ? '男' : '女';

	};
});

sofansAPP.filter('angentTypeFilter', function() {
	return function(tableAngentItem) {

		if (this.tableAngentItem.agentTppeId == 1) {
			return "华中地区总代";
		}
		if (this.tableAngentItem.agentTppeId == 2) {
			return "华南地区总代";
		}
		if (this.tableAngentItem.agentTppeId == 3) {
			return "华北地区总代";
		}
		if (this.tableAngentItem.agentTppeId == 4) {
			return "省级总代";
		}
		if (this.tableAngentItem.agentTppeId == 5) {
			return "市级总代";
		}

	};
});

/*
 * 
 */

/*
 * 添加代理商信息
 * 
 */

sofansAPP.controller('updateAngentController', function($scope, $rootScope,
		$http, $element, $compile, agentService,globalValue) {
	$rootScope.sufansSysAngent = {
		name : '',
		sex : '',
		age : '',
		phone : '',
		tel : '',
		company : '',
		address : '',
		agentTppeId : '',
		emp_id : '',
		id : 0
	};

	
	var rootScope = $rootScope;

	$scope.save = function() {

		if (globalValue.isUndefinedOrNull(rootScope.sufansSysAngent.emp_id)) {
			alert("与此代理商绑定的销售经理不能为空！");
			return;
		}
		if (isNull(rootScope.sufansSysAngent.name)) {
			alert('姓名只能为中文且不能为空！');
			return;
		}
		if (rootScope.sufansSysAngent.sex == '' && rootScope.sufansSysAngent.sex != 0 && rootScope.sufansSysAngent.sex != 1) {
			alert('请输入性别！');
			return;
		}
		if (!checkAge(rootScope.sufansSysAngent.age)) {
			alert("年龄不能为空或输入有误");
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysAngent.phone
				&& checkMobile(rootScope.sufansSysAngent.phone))) {
			alert("手机号码格式错误或为空！");
			return;
		}
		if (checkTel(rootScope.sufansSysAngent.tel)) {
			alert("座机号码填写有误！");
			return;
		}
		if (checkTxt(rootScope.sufansSysAngent.company, 50)) {
			alert("公司名称不能超过50个字节！");
			return;
		}
		if (checkTxt(rootScope.sufansSysAngent.address, 100)) {
			alert("详细地址不能超过100个字节！");
			return;
		}
		if (globalValue
				.isUndefinedOrNull(rootScope.sufansSysAngent.agentTppeId)) {
			alert('请输入代理商类型！');
			return;
		}

		else {
			var sufansSysAngent = rootScope.sufansSysAngent;

			/*
			 * update ： 由于前面用filter来过滤了数据，显示的emp_id替换成了中文名字。 现在在添加的之前来替换回来。
			 */
			var atEmps = $rootScope.Angentemployees;
			for (var i = 0; i < atEmps.length; i++) {
				if (sufansSysAngent.emp_id == atEmps[i].empName) {
					sufansSysAngent.emp_id = atEmps[i].empID;
					break;
				}
			}

			var isUpdate = false;
			if (sufansSysAngent.id > 0)// update
			{
				var tmpObj = {
					name : sufansSysAngent.name,
					sex : sufansSysAngent.sex,
					age : sufansSysAngent.age,
					phone : sufansSysAngent.phone,
					tel : sufansSysAngent.tel,
					company : sufansSysAngent.company,
					address : sufansSysAngent.address,
					agentTppeId : sufansSysAngent.agentTppeId,
					emp_id : sufansSysAngent.emp_id,
					id : sufansSysAngent.id
				};
				sufansSysAngent = tmpObj;
				isUpdate = true;
			}
			agentService.saveAngent($scope, sufansSysAngent);
			$scope.$on('saveAngent',function(event,data){
				if (data.result && !isUpdate) {
					var ds = $rootScope.tableAngentItems;
					ds.push(data.obj);
					$rootScope.tableAngentItems = ds;
					alert("保存成功！");
				} else {
					alert("保存成功！");
				}
				// clear the data from the form.
				rootScope.sufansSysAngent = {
					name : '',
					sex : '',
					age : '',
					phone : '',
					tel : '',
					company : '',
					address : '',
					agentTppeId : '',
					emp_id : '',
					id : 0
				};
			});


		}
	};


});
