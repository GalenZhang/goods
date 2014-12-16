sofansAPP.controller('dataController', function($scope, $http, $element, $compile, $rootScope, globalValue) {
	var menus = globalValue.menus;
	$scope.username = globalValue.username;
	$scope.currentID = 1;//used by comparing current page and update the selected color.
	$scope.switchPage = function(id)
	{
		$scope.currentID = id;	
		$scope.openURL = '../'+menus[id].url;
	};
	
	$scope.getName = function(id)
	{
		if (angular.isUndefined(menus[id]))
			return "";
		return menus[id].modulename;
	};
	
	$scope.show = function(id)
	{
		if (!angular.isUndefined(menus[id]))
		{
			return true;
		}
		else
		{
			return false;
		}
	};
	
	var menuOrder = [3, 4, 1, 2,5,6];
	
	//default open URL.
	angular.forEach(menuOrder, function(menuID){
		var menu = menus[menuID];
		if (angular.isUndefined($scope.openURL) && angular.isDefined(menu))
		{
			$scope.openURL = '../' + menu.url;
			$scope.currentID = menuID;
		}
	});
});

sofansAPP.controller('downloadController', function($scope, $rootScope, $http, $element, $compile, globalValue) {
	$http.get('sys/download.do').success(function(data){
		$rootScope.tableItems =data;
	}).error(function(data){
		alert('error');
	});
	
	$scope.username = globalValue.username;
	
	$scope.remove = function(id)
	{
		if (!confirm("确定要删除吗？")) return false;

		var url = 'sys/download/remove.do?id='+id;
		$http.get(url).success(function(data){
			if(data)
			{
				$rootScope.tableItems = data;
			}
			else
			{
				$rootScope.tableItems = [];
			}
			alert('删除成功！');
		}).error(function(data){
			alert('error');
		});
	};
	
	$scope.add = function()
	{
		$rootScope.uploadObj = {
				name: '',
				explanation:'',
				url: ''
			};
		$('#myModal').modal('toggle');
	};
	
});


sofansAPP.controller('uploadController', function($scope, $rootScope, $http, $element, $compile, globalValue) {
	$scope.uploadObj = {
		name: '',
		explanation:'',
		url: ''
	};
	
	$scope.initUploadFile = function()
	{
		$(function() {
		    $("#dropbox, #sufansFileName").html5Uploader({
		        name: "sufans-file-upload",
		        postUrl: "sys/download/upload.do",
		        onServerReadyStateChange: function(e,file){
		        	var xmlHttpRequest = e.srcElement;
		        	if(xmlHttpRequest.status == 200 && xmlHttpRequest.responseText)
		        	{
		        		var rs = angular.fromJson(xmlHttpRequest.responseText);
		        		$('#file-name').val(rs.obj);
		        		$scope.uploadObj.url = rs.obj;
		        	}
		        
		        }
		    });  
		}); 
	};
	
	$scope.saveUpload = function(){
		if (globalValue.isUndefinedOrNull($scope.uploadObj.name))
		{
			alert('请输入名称！');
			return;
		}
		if (globalValue.isUndefinedOrNull($scope.uploadObj.url))
		{
			alert('请输入文件名称！');
			return;
		}
		else
		{
			$http({
				    method: 'POST',
				    url: 'sys/download/save.do',
				    dataType: 'json', 
		            contentType: "application/json; charset=utf-8",  
		            data:  JSON.stringify($scope.uploadObj)
			}).success(function(data){
				if(data.result)
				{
					var ds = $rootScope.tableItems;
					if (!ds)
						ds = [];
					ds.push(data.obj);
					$rootScope.tableItems = ds;
					alert("保存成功！");
					$scope.uploadObj = {
							name: '',
							explanation:'',
							url: ''
						};
					$('#sufansFileName').val('');
				}
			}).error(function(data){
				alert('error');
			});
			
		}
	};
});
