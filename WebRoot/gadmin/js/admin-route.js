APP.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/manageProduce', {
    	templateUrl: 'manage_product.html',
    	controller: 'manageProductCtrl'
    })
    .when('/categoryManagement', {
        templateUrl: 'category_management.html',
        controller: 'categoryManagementCtrl'
    })
    .when('/judgeCriticism',{
        templateUrl: 'judge_criticism.html',
        controller: 'judgeCriticismCtrl'    	
    })
    .otherwise({
      redirectTo: '/manageProduce'
    });
}]);