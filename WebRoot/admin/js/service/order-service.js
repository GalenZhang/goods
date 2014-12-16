sofansAPP.service('orderService', ['httpService', function(httpService){
	var service = {};
	
	service.listByIdForJiShu = function(scope){
		httpService.get(scope,'sys/order/listByIdForJiShu.do').then(function(data){
			scope.$broadcast('orderListByIdForJiShu', data);
		},function(data){
			alert('error');
		});
	};
	
	service.orderListById = function(scope, id){
		httpService.get(scope,'sys/order/listById.do?id='+id).then(function(data){
			scope.$broadcast('orders_ListById', data);
		},function(data){
			alert('error');
		});
	};
	
	service.ordersList = function(scope){
		httpService.get(scope,'sys/order/list.do').then(function(data){
			scope.$broadcast('orders_List', data);
		},function(data){
			alert('error');
		});
	};
	
	service.loadRidByUid = function(scope, id){
		httpService.get(scope,'sys/role/loadRoleId.do?id='+id).then(function(data){
			scope.$broadcast('loadRidByUids',data);
		},function(data){
			alert('error');
		});
	};
	
	service.loadTabletByOrder = function(scope, id){
		httpService.get(scope,'sys/order/listTabletCus.do?id='+id).then(function(data) {
			scope.$broadcast('allTabByOrId',data);
		},function(data){
			alert('error');
		});
	};
	
	service.saveOrder = function(scope, postData){
		httpService.post(scope,'sys/order/save.do',postData).then(function(data) {
			scope.$broadcast('saveOrd',data);
		},function(data){
			alert('error');
		});
	};
	
	service.removeOrder = function(scope, id, v){
		httpService.get(scope,'sys/order/remove.do?id='+id+'&v='+v).then(function(data) {
			scope.$broadcast('removeOrderBackData',data);
		},function(data){
			alert('error');
		});
	};
	
	/*
	 * 注意： 此处必须要返回service,不然前面会报错-->' 没有这个函数'
	 */
	return service;
	
	
}]);