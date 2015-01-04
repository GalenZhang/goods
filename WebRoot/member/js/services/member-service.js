/**
 * 
 */
APP.service('memberService', ['httpService', function(httpService){
	
	return {
		
		getUser: function(){
			return this.user;
		}
	};
}]);