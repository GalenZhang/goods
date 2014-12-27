/**
 * 
 */
APP.service('loginService', ['httpService', function(httpService){
	
	return {
		login: function(scope, user){
			/*
			httpService.jpost(scope, '../login/login.action?username=1'
                    , {"user.username": '22',"user.password": '11'} 
                    ,function(data){
                        alert(111);
                    }).then(function(data){
                    	alert(data);
                    });
            */

			httpService.post(scope,'../g/login.do', user).then(function(data) {
				alert(data);
				//scope.$broadcast('saveAngent', data);
			},function(data) {
				alert('error');
			});
		}
		
	};
}]);