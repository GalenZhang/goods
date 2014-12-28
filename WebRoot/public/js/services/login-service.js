/**
 * 
 */
APP.service('loginService', ['httpService', function(httpService){
	
	return {
		login: function(scope, user){
			httpService.post(scope, '../pub/member/login.do', user).then(function(data) {
				scope.$broadcast('login', data);
			},function(data) {
				alert('error');
			});
		},
		loginout: function(scope){
			httpService.get(scope, '../pub/member/loginout.do').then(function(data){
				scope.$broadcast('loginout', data);
			});
		},
		getUser: function(){
			httpService.get(scope, '..//pub/member/getuser.do').then(function(data){
				scope.$broadcast('getUser', data);
			});
		}
	};
}]);