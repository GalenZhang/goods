/*
 *  register 
 */
APP.service("registerService",['httpService',function(httpService){
	
	return{
		
		checkName:function(scope,username){
			httpService.get(scope, '../pub/member/checkName.do?username='+ username).then(function(data) {
				scope.$broadcast('checkName', data);
			},function(data) {
				alert('error');
			});
		},
		
		register:function(scope,user){
			httpService.post(scope, '../pub/member/register.do', user).then(function(data) {
				scope.$broadcast('register', data);
			},function(data) {
				alert('error');
			});
		},
		

	};
}]);