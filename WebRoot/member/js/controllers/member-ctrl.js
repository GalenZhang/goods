/**
 * 
 */

APP.controller("memberCtrl", function($rootScope, $scope, memberService) {
	$scope.pageID = 1;//default selected;
	$scope.pageSelect = function(pageID)
	{
		$scope.pageID = pageID;
	};
	

	/*

	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
		alert('$stateChangeStart');
	});
	$rootScope.$on('$stateNotFound', function(event, toState, toParams, fromState, fromParams){
	});
	 */
/*	$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
		alert('stateChangeSuccess');
	});
	$rootScope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams){
		alert('stateChangeError');
	});


	$rootScope.$on('$viewContentLoading', function(event, viewConfig){
		alert('$viewContentLoading');
	});

 */

/*	$rootScope.$on('$viewContentLoaded', function(event){
		alert('viewContentLoaded');
	});
*/
	
});