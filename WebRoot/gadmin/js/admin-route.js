APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	$stateProvider.state('manageProduce', {
		name: 'manageProduce',
		url: '/manageProduce',
	    templateUrl: 'goods.html',
	    controller: 'goodsCtrl'
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