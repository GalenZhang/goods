APP.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,  $urlRouterProvider){
	$stateProvider.state('orderdetail', {
		url: '/order/:id',
	    controller: 'orderCtrl',
	    views: {
	    	'top': {
	    		templateUrl: 'order/top.html'
	    	},
			'orderinfo': {
				resolve:{
					waitingforpayObj: function(waitingforpayService){
						
					},
					sendingObj: function(sendingService){
						
					},
					waitingforcriticismObj: function(waitingforcriticismService){
						
					}
				},
				templateUrl: function($stateParams){
					if($stateParams.id == 1)
						return 'order/waitingforpay.html';
					else if($stateParams.id == 2)
						return 'order/sending.html';
					else if($stateParams.id == 3)
						return 'order/waitingforcriticism.html';
					else
						return 'order/waitingforpay.html';
				},
				controller: function($scope, $stateParams){
					$scope.$parent.selected = $stateParams.id;
				}
				
			},
			'bottom': {
				templateUrl: 'order/bottom.html'
			}}
	  })
	  .state('criticism', {
		url: '/criticism',
	    templateUrl: 'criticism.html',
	    controller: 'criticismCtrl'
	  })
	  .state('collect', {
		url: '/collect',
	    templateUrl: 'collect.html',
	    controller: 'collectCtrl'
	  })
	  .state('change', {
		url: '/change',
	    templateUrl: 'change.html',
	    controller: 'changeCtrl'
	  })
	  .state('coupon', {
		url: '/coupon',
	    templateUrl: 'coupon.html',
	    controller: 'couponCtrl'
	  })
	  .state('account', {
		url: '/account',
	    templateUrl: 'account.html',
	    controller: 'accountCtrl'
	  })
	  .state('changepwd', {
		url: '/changepwd',
	    templateUrl: 'changepwd.html',
	    controller: 'changepwdCtrl'
	  })
	  .state('receivedaddress', {
		url: '/receivedaddress',
	    templateUrl: 'receivedaddress.html',
	    controller: 'receivedaddressCtrl'
	  })
	  ;
	$urlRouterProvider.otherwise('/order/1');
	
}]);

