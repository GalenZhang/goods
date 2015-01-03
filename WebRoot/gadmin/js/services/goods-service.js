/**
 * 
 */
APP.service('goodsService', ['httpService', function(httpService){
	
	return {
		list: function(scope, pageCondition){
			httpService.get(scope, 'goods/list.do', pageCondition).then(function(data){
				scope.$broadcast('loaded', data);
			},function(data){
				alert('error');
			});
		},
		
		add: function(goods){
			httpService.get(scope,'/goods/add.do', goods).then(function(data){
				scope.$broadcast('orders_List', data);
			},function(data){
				alert('error');
			});
		},
		
		remove: function(ids){
			httpService.get(scope,'/goods/remove.do', ids).then(function(data){
				scope.$broadcast('orders_List', data);
			},function(data){
				alert('error');
			});
		},
		
		update: function(ids){
			httpService.get(scope,'/goods/update.do', goods).then(function(data){
				scope.$broadcast('orders_List', data);
			},function(data){
				alert('error');
			});
		}
		
		
	};
}]);