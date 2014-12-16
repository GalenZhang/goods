sofansAPP.service('userService', ['httpService', function(httpService){
	var service = {};
	
	service.loadUser = function(scope){
		httpService.get(scope,'sys/user/list.do').then(function(data){
			scope.$broadcast('loadUserData', data);
		},function(data){
			alert('error');
		});
	};
	
	service.removeUser = function(scope, id){
		httpService.get(scope,'sys/user/remove.do?id='+id).then(function(data){
			scope.$broadcast('removeUserData', data);
		},function(data){
			alert('error');
		});
	};
	
	service.saveUser = function(scope,postData){
		httpService.post(scope, 'sys/user/save.do',postData).then(function(data){
			scope.$broadcast('saveUserData',data);
		},function(data){
			alert('error');
		});
	};
	
	return service;
}]);