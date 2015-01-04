/**
 * 
 */

APP.controller("goodsCtrl", function($scope, goodsService, categoryService, brandService, JSUtil) {
	
	$scope.$on('loaded', function(event, data){
		$scope.list = data.list;
	});
	
	goodsService.list($scope, {start: 0});
	
	$scope.add = function() {
		if (JSUtil.isEmpty(categoryService.getCategory()))
		{
			alert('加载分类出错！');
			return;
		}
		$scope.categories = categoryService.getCategory();
		$scope.brands = brandService.getBrand();
		$scope.goods = {}
		$('#goodsModal').modal('toggle');
	};
	
	$scope.selected = function(){
	};
	
	
});