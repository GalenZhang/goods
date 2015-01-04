/**
 * 
 */
APP.service('changepwdService', ['httpService', function(httpService){
	
	return {
		changePassword:function(scope, password){
			httpService.post(scope, '/goods/member/updatePassword.do?a=1', password).then(function(data) {
				scope.$broadcast('changePassword', data);
			},function(data) {
				alert('error');
			});
		}
	};
}]);