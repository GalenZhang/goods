/**
 * 
 */
APP.controller("testOrderCtrl", function($rootScope, $scope) {

	

	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
		alert('$stateChangeStart');
	});
	 
	$rootScope.$on('$stateNotFound', function(event, toState, toParams, fromState, fromParams){
		alert(1411);
	});
	$rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
		alert('stateChangeSuccess');
	});

	$rootScope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams){
		alert('stateChangeError');
	});


	$rootScope.$on('$viewContentLoading', function(event, viewConfig){
		alert('$viewContentLoading');
	});


	$rootScope.$on('$viewContentLoaded', function(event){

	});

	
});