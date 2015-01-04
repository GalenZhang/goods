/**
 * 
 */
APP.service('categoryService', ['httpService', function(httpService){
	
	return {
		
		getCategory: function(type){
			this.category = [{name: '大鱼', id: '1'}, {name: '中鱼', id: '2'}, {name: '小鱼', id: '3'}, {name: '特产鱼', id: '4'}];
			return this.category;
		}
		
	};
}]);