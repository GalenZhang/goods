APP.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    .when('/waitingforpay', {
      templateUrl: 'waitingforpay.html',
      controller: 'waitingforpayCtrl'
    })
    .when('/sending', {
      templateUrl: 'sending.html',
      controller: 'sendingCtrl'
    })
    .when('/waitingforcriticism', {
      templateUrl: 'waitingforcriticism.html',
      controller: 'waitingforcriticismCtrl'
    })
    .otherwise({
      redirectTo: '/waitingforpay'
    });
}]);