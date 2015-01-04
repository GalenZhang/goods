/**
 * 
 */
APP.service('accountService', ['httpService', function(httpService){
	
	return {
		
		getUserInfo:function(scope){
			httpService.get(scope, '../member/userinfo.do').then(function(data) {
				scope.$broadcast('getUserInfo', data);
			},function(data) {
				alert('error');
			});
		},
		
		saveUserInfo:function(scope,user){
			httpService.post(scope, '../member/updateuser.do',user).then(function(data) {
				scope.$broadcast('saveUserInfo', data);
			},function(data) {
				alert('error');
			});
		}
		
	};
}]);