/*APP.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/order', {
      templateUrl: 'order.html',
      controller: 'orderCtrl'
    })
    .when('/criticism', {
        templateUrl: 'criticism.html',
        controller: 'criticismCtrl'
    })
    .when('/collect', {
  	  templateUrl: 'collect.html',
        controller: 'collectCtrl'
    })
    .when('/change', {//余额
        templateUrl: 'change.html',
        controller: 'changeCtrl'
    })
    .when('/coupon', {//优惠
        templateUrl: 'coupon.html',
        controller: 'couponCtrl'
    })
    .when('/account', {
        templateUrl: 'account.html',
        controller: 'accountCtrl'
    })
    .when('/changepwd', {
        templateUrl: 'changepwd.html',
        controller: 'changepwdCtrl'
    })
    .when('/receivedaddress', {
        templateUrl: 'receivedaddress.html',
        controller: 'receivedaddressCtrl'
    })
    .otherwise({
      redirectTo: '/order'
    });
}]);*/

APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	$stateProvider.state('order', {
		name: 'order',
		url: '/order',
	    templateUrl: 'order.html',
	    controller: 'orderCtrl'
	  })
	  .state('criticism', {
		name: 'criticism',
		url: '/criticism',
	    templateUrl: 'criticism.html',
	    controller: 'criticismCtrl'
	  })
	  .state('collect', {
		name: 'collect',
		url: '/collect',
	    templateUrl: 'collect.html',
	    controller: 'collectCtrl'
	  })
	  .state('change', {
		name: 'change',
		url: '/change',
	    templateUrl: 'change.html',
	    controller: 'changeCtrl'
	  })
	  .state('coupon', {
		name: 'coupon',
		url: '/coupon',
	    templateUrl: 'coupon.html',
	    controller: 'couponCtrl'
	  })
	  .state('account', {
		name: 'account',
		url: '/account',
	    templateUrl: 'account.html',
	    controller: 'accountCtrl'
	  })
	  .state('changepwd', {
		name: 'changepwd',
		url: '/changepwd',
	    templateUrl: 'changepwd.html',
	    controller: 'changepwdCtrl'
	  })
	  .state('receivedaddress', {
		name: 'receivedaddress',
		url: '/receivedaddress',
	    templateUrl: 'receivedaddress.html',
	    controller: 'receivedaddressCtrl'
	  })
	  ;
	//$urlRouterProvider.otherwise('/order');
	
}]);

