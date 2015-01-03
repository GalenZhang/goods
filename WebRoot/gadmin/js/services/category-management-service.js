/**
 * 
 */
APP.service('categoryManagementService', ['httpService', function(httpService){
	
	return {
		
		getCategory: function(type){
			return [{'大鱼': '1'}, {'中鱼': '2'}, {'小鱼': '3'}, {'特产鱼': '4'}];
		}
		
	};
}]);