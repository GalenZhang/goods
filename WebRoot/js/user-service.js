/**
 * 
 */
APP.service('userService', [function(){
	
	var user = null;
	
	function getUserInfo(){
		
	}
	
	return {
		
		
		getUser: function(){
			return user;
		},
		
		setUser: function(u){
			user = u;
		}
		
	};
}]);