APP.config(['$routeProvider', function ($routeProvider) {
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
}]);