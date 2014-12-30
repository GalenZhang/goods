/**
 * 
 */
APP.service('changepwdService', ['httpService', function(httpService){
	
	return {
		changePassword:function(scope,pwd,pwd2,id){
			httpService.get(scope, '../pub/member/updatePassword.do?pwd='+pwd+'&pwd2='+pwd2+'&id='+id).then(function(data) {
				scope.$broadcast('changePassword', data);
			},function(data) {
				alert('error');
			});
		}
	};
}]);