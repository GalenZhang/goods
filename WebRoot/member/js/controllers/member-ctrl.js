/**
 * 
 */

APP.controller("memberCtrl", function($scope, memberService) {
	$scope.pageID = 1;//default selected;
	$scope.pageSelect = function(pageID)
	{
		$scope.pageID = pageID;
	};
	
	
});