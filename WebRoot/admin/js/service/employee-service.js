sofansAPP.service('employeeService', ['httpService', function(httpService){
	var service = {};
	
	service.loadEmpList = function(scope, pageIndex){
		httpService.get(scope,'sys/employee/list.do?pageIndex='+pageIndex).then(function(data) {
			scope.$broadcast('employeesByPage', data);
		},function(data){
			alert('error');
		});
	};
	
	service.removeEmp = function(scope, id, pageIndex){
		httpService.get(scope,'sys/employee/remove.do?id='+id+'&&pageIndex='+pageIndex).then(function(data) {
			scope.$broadcast('removeReturnEmp',data);
		},function(data){
			alert('error');
		});
	};
	
	service.saveEmplo = function(scope, pageIndex,postData){
		httpService.post(scope,'sys/employee/save.do?pageIndex='+pageIndex ,postData).then(function(data) {
			scope.$broadcast('savaEmplo',data);
		},function(data){
			alert('error');
		});
	};
	
	service.loadAllEmp = function(scope){
		httpService.get(scope,'sys/employee/load.do').then(function(data) {
			scope.$broadcast('loadAllemps',data);
		},function(data){
			alert('error');
		});
	};

	
	return service;
	
}]);

	