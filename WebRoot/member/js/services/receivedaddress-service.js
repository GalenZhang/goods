/**
 * 
 */
APP.service('receivedaddressService', ['httpService', function(httpService){
	
	return {
		addressInfo:function(scope){
			httpService.get(scope, '../pub/member/addressInfo.do').then(function(data) {
				scope.$broadcast('addressInfo', data);
			},function(data) {
				alert('error');
			});
		},
		saveAddress:function(scope,deliverAddress){
			httpService.post(scope, '../pub/member/saveAddress.do', deliverAddress).then(function(data) {
				scope.$broadcast('saveAddress', data);
			},function(data) {
				alert('error');
			});
		},
	
	
	};
}]);