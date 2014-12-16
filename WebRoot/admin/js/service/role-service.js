sofansAPP.service('roleService', ['httpService', function(httpService){
	service = {};
	
	service.loadRole = function(scope){
		httpService.get(scope,'sys/role/list.do').then(function(data) {
			scope.$broadcast('roleList',data);
		},function(data){
			alert('error');
		});
	};
	
	service.loadModuld = function(scope){
		httpService.get(scope,'sys/role/moduleuser.do').then(function(data) {
			scope.$broadcast('modeldList',data);
		},function(data){
			alert('error');
		});
	};
	
	service.removeRole = function(scope, id){
		httpService.get(scope,'sys/role/remove.do?id='+id).then(function(data) {
			scope.$broadcast('removeRoledata',data);
		},function(data){
			alert('error');
		});
	};
	
	service.updateRole = function(scope, id){
		httpService.get(scope,'sys/role/query.do?id='+id).then(function(data) {
			scope.$broadcast('updateRoleData',data);
		},function(data){
			alert('error');
		});
	};
	
	service.saveRole = function(scope,postData){
		httpService.post(scope,'sys/role/save.do',postData).then(function(data) {
			scope.$broadcast('saveRoleData',data);
		},function(data){
			alert('error');
		});
	};
	
	
	return service;
}]);