/**
 * 
 */

var APP = angular.module('APP', ['ui.router', 'ui.bootstrap']);
APP.constant('JSUtil', {
	isEmpty : function(obj) {
		return !angular.isDefined(obj) || obj === null || '' == obj;
	},
	
	isEmail: function(emailStr){
		return emailStr.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
	},
	
	isMobile: function(mobile){
		return mobile.match(/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/);
	}
});


