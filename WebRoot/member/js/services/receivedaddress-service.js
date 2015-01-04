/**
 * 
 */
APP.service('receivedaddressService', ['httpService', function(httpService){
	
	return {
		addressInfo:function(scope){
			httpService.get(scope, '../member/addressInfo.do').then(function(data) {
				scope.$broadcast('addressInfo', data);
			},function(data) {
				alert('error');
			});
		},
		saveAddress:function(scope,deliverAddress){
			httpService.post(scope, '../member/saveAddress.do', deliverAddress).then(function(data) {
				scope.$broadcast('saveAddress', data);
			},function(data) {
				alert('error');
			});
		},
	
	
	};
}]);