APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	$stateProvider.state('manageProduce', {
		name: 'manageProduce',
		url: '/manageProduce',
	    templateUrl: 'manage_product.html',
	    controller: 'manageProductCtrl'
	  })
	  .state('categoryManagement', {
		  name: 'categoryManagement',
		  url: '/categoryManagement',
		  templateUrl: 'category_management.html',
		  controller: 'categoryManagementCtrl'
	  })
	  .state('judgeCriticism', {
		  name: 'judgeCriticism',
		  url: '/judgeCriticism',
		  templateUrl: 'judge_criticism.html',
		  controller: 'judgeCriticismCtrl'
	  });
	
	 $urlRouterProvider.otherwise('/manageProduce');
}]);