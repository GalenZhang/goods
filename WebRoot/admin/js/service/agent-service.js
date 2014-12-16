sofansAPP.service('agentService', ['httpService', function(httpService){
	var service = {};
	
	/* Angular Js 说明 :
	 *   注: 
	 *      1. 通过$broadcast或$emit来定义一个变量，在父，子controller里面通过$on来获取
	 * 
	 * 
	 */
	
	/*
	 * select标签 绑定销售经理 的加载数据
	 */
	service.loadDatas = function(scope){
		httpService.get(scope, 'sys/employee/load.do').then(function(data) {
			 scope.$broadcast('agents', data);
		}, function(data) {
			alert('error');
		});
	};
	
	/*
	 * 通过id加载所有代理商信息
	 */
	service.loadAngentsByID = function(scope, id){
		httpService.get(scope,'sys/agent/listById.do?id='+id).then(function(data) {
			scope.$broadcast('agentsByIdList', data);
		},function(data) {
			alert('error');
		});
	};
	
	service.loadAngents = function(scope){
		httpService.get(scope,'sys/agent/list.do').then(function(data) {
			scope.$broadcast('agentsList', data);
		},function(data) {
			alert('error');
		});
	};
	
	service.removeAngentByID = function(scope, id, v){
		httpService.get(scope,'sys/agent/remove.do?id='+id+'&v='+v).then(function(data) {
			scope.$broadcast('removeAngentl', data);
		},function(data) {
			alert('error');
		});
	};
	
	/*
	 * save angent
	 */
	service.saveAngent = function(scope, postData){
		httpService.post(scope,'sys/agent/save.do',postData).then(function(data) {
			scope.$broadcast('saveAngent', data);
		},function(data) {
			alert('error');
		});
	};
	
	
	return service;
}]);