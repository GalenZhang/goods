var loginUserID;

sofansAPP.service('menuService', ['$http', 'globalValue', function($http, globalValue) {
	var service = {
		getMenu: function(){
			
			$.ajax({
                url : '../login/getmenu.do',
                async : false,
                type : "get",
                success : function (data){
                	if (data.result)
    				{
    					globalValue.menus = data.obj.menus;
    					globalValue.username = data.obj.username;
    					loginUserID = data.obj.userID;

    				}
                },
                error: function(){
                	alert('error..');
                	
                }
            });
		}
	};
	
	return service;	
}]);

//initial menus.
sofansAPP.run(function(menuService) {
	menuService.getMenu();
});


