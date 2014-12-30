APP.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/manageProduce', {
        templateUrl: 'manage_product.html',
        controller: 'manageProductCtrl'
    })
    .when('/judgeCriticism',{
        templateUrl: 'judge_criticism.html',
        controller: 'judgeCriticismCtrl'    	
    })
    .otherwise({
      redirectTo: '/manageProduce'
    });
}]);