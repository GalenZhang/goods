APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	
	$stateProvider.state('inbox', 
			{
		url: '/inbox',
		views: {
			'filters': 	{
				template: '<h4>Filter inbox</h4>'
			},
			'mailbox': {
				template: '<h4>Priority inbox</h4>'
			}, 
			'priority': {
				template: '<h4>Priority inbox</h4>'
			}}});
		$urlRouterProvider.otherwise('/inbox');
}]);



/*APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	
	$stateProvider.state('orderdetail', {
		views:{
			'waitingforpay': {
				url: '/waitingforpay',
				templateUrl: 'order/waitingforpay.html',
				controller: 'waitingforpayCtrl'
			},
			'sending': {
				url: '/sending',
				templateUrl: 'order/sending.html',
				controller: 'sendingCtrl'
			},
			'waitingforcriticism': {
				url: '/waitingforcriticism',
				templateUrl: 'order/waitingforcriticism.html',
				controller: 'waitingforcriticismCtrl'
			}
		}
	  });
	$urlRouterProvider.otherwise('/waitingforpay');
}]);
*/

/*APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	$stateProvider.state('waitingforpay', {
				url: '/waitingforpay',
				templateUrl: 'order/waitingforpay.html',
				controller: 'waitingforpayCtrl'
			})
	.state('sending', {
		url: '/sending',
		templateUrl: 'order/sending.html',
		controller: 'sendingCtrl'
	})
	.state('waitingforcriticism', {
		url: '/waitingforcriticism',
		templateUrl: 'order/waitingforcriticism.html',
		controller: 'waitingforcriticismCtrl'
	});
			 
//	$urlRouterProvider.otherwise('/waitingforpay');
}]);
*/