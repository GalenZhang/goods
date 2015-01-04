/**
 * 
 */
APP.service('brandService', ['httpService', function(httpService){
	
	return {
		
		getBrand: function(){
			this.brand = [{name: '大鱼', id: '1'}, {name: '中鱼', id: '2'}, {name: '小鱼', id: '3'}, {name: '特产鱼', id: '4'}];
			return this.brand;
		}
		
	};
}]);