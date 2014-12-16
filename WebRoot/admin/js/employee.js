
sofansAPP.controller("employeeController", function($scope,$rootScope, $http,
		$element, $compile,employeeService, globalValue) {
	
	$scope.currentpage = 0;
	var pagesize = 20;
	var _pageIndex = 0;
	
	function loadDatas(pageIndex){
		if (angular.isUndefined(pageIndex))
		{
			pageIndex = 0;
		}
		_pageIndex = pageIndex;
		employeeService.loadEmpList($scope, pageIndex);
		$scope.$on('employeesByPage',function(event,data){
			$scope.tableEmployeeItems = data.list;
			$scope.pagecount = data.pages;
			pagesize = data.pagesize;
		});
	}
	loadDatas(0);

	$scope.$watch('currentpage', function(to, from){
		loadDatas(to);
	});
	
	
	//row index.
	$scope.getIndex = function(index){
		return (pagesize * _pageIndex) + index + 1;
	};
	
	$scope.refresh = function(){
		loadDatas(_pageIndex);
	};
	
	$scope.add = function()
	{
		$("#workernumberDiv").hide();
		$scope.sufansSysEmployee = initEmployee();
		$('#employeeinfoModal').modal('toggle');
	};	

	$scope.remove = function(id) {
		if (!confirm("确定要删除吗？"))
			return false;
		employeeService.removeEmp($scope, id, _pageIndex);
		$scope.$on('removeReturnEmp', function(event,data){
			if (data.result) {
				$scope.tableEmployeeItems = data.obj.list;
				$scope.pagecount = data.obj.pages;
				pagesize = data.obj.pagesize;
				alert('删除成功！');
			}
		});
	};

	$scope.update = function(id) {
		$("#workernumberDiv").show();
		var tableEmployeeItems = $scope.tableEmployeeItems;
		var updateObj = {};
		for (var i = 0; i < tableEmployeeItems.length; i++) {
			if (tableEmployeeItems[i].id == id) {
				updateObj = tableEmployeeItems[i];
				break;
			}
		}
		$scope.sufansSysEmployee = updateObj;
		
		$('#employeeinfoModal').modal('toggle');
//		$("input[name=sex]:eq(0)").attr("checked",'checked');
	};
	
	$scope.departments = [{value: '1', label: '人事部'}, {value: '2', label: '技术部'}, {value: '3', label: '市场部'}];

	
	$scope.$watch('sufansSysEmployee.deptId', function(to, from){
		if(to == 1){
			$scope.positions = [{value: '1', label: '人事总监'}, {value: '2', label: '人事总监助理'}];
		}
		else if(to == 2){
			$scope.positions = [{value: '3', label: '技术总监'}, {value: '4',	 label: '技术支持'}];
		}
		else if(to == 3){
			$scope.positions = [{value: '5', 	label: '销售总监'	}, {value: '6', label: '销售经理'}];
		}
		else{
			$scope.positions = [{value: '1', label: '人事总监'}, {value: '2', label: '人事总监助理'}, {value: '3', label: '技术总监'}, {value: '4',	label: '技术支持'}, {value: '5', 	label: '销售总监'	}, {value: '6', label: '销售经理'}];
		}
	});
	
/*
 * 添加信息
 * 
 */
	
	function initEmployee(){
		return {
				postId : '',
				deptId : '',
				workerNum : '',
				name : '',
				sex : '',
				age : '',
				idCard : '',
				birthday : '',
				education : '',
				hometowAddress : '',
				address : '',
				phone : '',
				email : '',
				entryWorktime : new Date(),
				id : 0
		};
	};


	$scope.today = function() {
		  $scope.sufansSysEmployee.entryWorktime = new Date();
	  };

	  $scope.clear = function () {
		  $scope.sufansSysEmployee.entryWorktime = null;
	  };

	  // Disable weekend selection
	  $scope.disabled = function(date, mode) {
	    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	  };

	  $scope.toggleMin = function() {
	    $scope.minDate = $scope.minDate ? null : new Date();
	  };
	  $scope.toggleMin();

	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();

	    $scope.opened = true;
	  };

	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };

	  $scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	  $scope.format = $scope.formats[0];

	  $scope.sufansSysEmployee = initEmployee();
	  
	$scope.save = function() {

		if (isNull($scope.sufansSysEmployee.name)) {
			alert('姓名必须为中文且不能为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.deptId)) {
			alert('部门不能为空！');
			return;
		}
		if (checkPost($scope.sufansSysEmployee.postId)) {
			alert('职位不能为空！');
			return;
		}
		if ($scope.sufansSysEmployee.sex == '' && $scope.sufansSysEmployee.sex != 0 && $scope.sufansSysEmployee.sex != 1) {
			alert('请选择性别！');
			return;
		}
		if (!checkAge($scope.sufansSysEmployee.age)) {
			alert("年龄不能为空或输入有误");
			return;
		}
		if(!isCardNo($scope.sufansSysEmployee.idCard)){
			alert("身份证输入不合法");  
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.education)) {
			alert('学历不能为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.hometowAddress)) {
			alert('户籍填写错误或为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.address)) {
			alert('现住址不能为空！');
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.phone
				&& checkMobile($scope.sufansSysEmployee.phone))) {
			alert("手机号码格式错误或为空！");
			return;
		} 
		if(!isEmail($scope.sufansSysEmployee.email)){
			alert("email格式不正确！");
			return;
			
		}if (globalValue.isUndefinedOrNull($scope.sufansSysEmployee.entryWorktime)) {
			alert('入职时间不能为空！');
			return;
		}else {
			var sufansSysEmployee = $scope.sufansSysEmployee;
			var isUpdate = false;
			if (sufansSysEmployee.id > 0)// update
			{
				var tmpObj = {
					name : sufansSysEmployee.name,
					postId : sufansSysEmployee.postId,
					deptId : sufansSysEmployee.deptId,
					workerNum : sufansSysEmployee.workerNum,
					sex : sufansSysEmployee.sex,
					age : sufansSysEmployee.age,
					idCard : sufansSysEmployee.idCard,
					birthday : sufansSysEmployee.birthday,
					education : sufansSysEmployee.education,
					hometowAddress : sufansSysEmployee.hometowAddress,
					address : sufansSysEmployee.address,
					phone : sufansSysEmployee.phone,
					email : sufansSysEmployee.email,
					entryWorktime : sufansSysEmployee.entryWorktime,
					id : sufansSysEmployee.id
				};
				sufansSysEmployee = tmpObj;
				isUpdate = true;
			}
			employeeService.saveEmplo($scope, _pageIndex, sufansSysEmployee);
			$scope.$on('savaEmplo', function(event,data){
				if (data.result && !isUpdate) {
					$scope.tableEmployeeItems = data.obj.list;
					$scope.pagecount = data.obj.pages;
					pagesize = data.obj.pagesize;
					alert("保存成功！");
				} else {
					if (!data.result)
					{
						alert("保存失败！");
						return;
					}
					else
					{
						alert("保存成功！");	
					}
						
				}
				// clear the data from the form.
				$scope.sufansSysEmployee = initEmployee();
			});

		}
	};
	

	
	/*
	 * 
	 */
	function checkPost(postid){
		var v = postid;
		if(v == 0)
			return true;
		else 
			return false;
		if(v == null)
			return true;
		else
			return false;
	}


});


