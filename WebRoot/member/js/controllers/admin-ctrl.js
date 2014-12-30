/**
 * 
 */

APP.controller("adminCtrl", function($scope, adminService) {
	$scope.pageID = 1;//default selected;
	$scope.pageSelect = function(pageID)
	{
		$scope.pageID = pageID;
	};
	
	
});