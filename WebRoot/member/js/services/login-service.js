/**
 * 
 */
APP.service('loginService', ['httpService', function(httpService){
	
	return {
		login: function(scope, user){
			httpService.post(scope,'../login/login.action', user).then(function(data) {
				alert(data);
				//scope.$broadcast('saveAngent', data);
			},function(data) {
				alert('error');
			});
		}
		
	};
}]);