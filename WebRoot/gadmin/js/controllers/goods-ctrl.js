/**
 * 
 */

APP.controller("goodsCtrl", function($scope, goodsService) {
	
	$scope.$on('loaded', function(event, data){
		$scope.list = data.list;
	});
	
	goodsService.list($scope, {start: 0});
	
	$scope.add = function() {
		$scope.goods = {}
		$('#goodsModal').modal('toggle');
	};
	
});