var sofansAPP = angular.module('sofansAPP', ['ui.bootstrap']);

sofansAPP.constant('globalValue', {
	isUndefinedOrNull : function(obj) {
		return !angular.isDefined(obj) || obj === null || '' == obj;
	}
});



