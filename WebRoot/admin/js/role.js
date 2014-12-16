
sofansAPP.controller('roleController', function($scope, $rootScope, $http,
		$element, $compile,roleService, globalValue) {
	
	var backRole_uid = loginUserID;
	
	//role list.
	roleService.loadRole($scope);
	$scope.$on('roleList',function(event,data){
		$scope.tableItems =data;
	});
//	$http.get('sys/role/list.do').success(function(data){
//		$scope.tableItems =data;
//	}).error(function(data){
//		alert('error');
//	});

	//module
	//initial the module and user.
	roleService.loadModuld($scope);
	$scope.$on('modeldList',function(event,data){
		$scope.modules = data.modules;//module
		$scope.users = data.users;//user
	},function(data){
		alert('error');
	});
//	$http.get('sys/role/moduleuser.do').success(function(data){
//		$scope.modules = data.modules;//module
//		$scope.users = data.users;//user
//	}).error(function(data){
//		alert('error');
//	});
	
//	//通过 roleid来获取此role在module下的 curd 操作     (new : yl--ad)
//
//	$http.get('sys/role/getModuleActionByUid.do?uid='+backRole_uid).success(function(data){
//		
//	}).error(function(data){
//		alert('roleModuleActions error');
//	});
//	
	$scope.remove = function(id)
	{
		if (!confirm("确定要删除吗？")) return false;
		roleService.removeRole($scope,id);
		$scope.$on('removeRoledata',function(event,data) {
			if(data.result)
			{
				$scope.tableItems = data.obj;
				alert('删除成功！');
			}
		});
//		var url = 'sys/role/remove.do?id='+id;
//		$http.get(url).success(function(data){
//			if(data.result)
//			{
//				$scope.tableItems = data.obj;
//				alert('删除成功！');
//			}
//		}).error(function(data){
//			alert('error');
//		});
	};
	
	$scope.update = function(id)
	{
		roleService.updateRole($scope, id);
		$scope.$on('updateRoleData',function(event,data){
            $scope.role = data.sufansSysRole;
			
			var modules = data.sufansSysModules;//module
			var moduleIDs = {};
			angular.forEach(modules, function(module){
				moduleIDs[module.id] = module.id;
			});
			
			var ms = $scope.modules;
			angular.forEach(ms, function(module){
				if (moduleIDs[module.id])
				{
					module.checked = true;
				}
				else
				{
					module.checked = false;
				}
			});
			
			var users = data.sufansSysUsers;//user
			var userIDs = {};
			
				angular.forEach(users, function(user){
					if(user == null){
						alert('此角色下面暂无用户！您可以勾选用户添加到此角色下面');
						return;
					}
					userIDs[user.id] = user.id;
				});
			

			//update the user status.
			var us = $scope.users;
			angular.forEach(us, function(user){
				if (userIDs[user.id])
				{
					user.checked = true;
				}
				else
				{
					user.checked = false;
				}
			});

		});
		$('#roleModal').modal('toggle');
//		$http.get('sys/role/query.do?id='+id).success(function(data){
//			$scope.role = data.sufansSysRole;
//			
//			var modules = data.sufansSysModules;//module
//			var moduleIDs = {};
//			angular.forEach(modules, function(module){
//				moduleIDs[module.id] = module.id;
//			});
//			
//			var ms = $scope.modules;
//			angular.forEach(ms, function(module){
//				if (moduleIDs[module.id])
//				{
//					module.checked = true;
//				}
//				else
//				{
//					module.checked = false;
//				}
//			});
//			
//			var users = data.sufansSysUsers;//user
//			var userIDs = {};
//			angular.forEach(users, function(user){
//				userIDs[user.id] = user.id;
//			});
//
//			//update the user status.
//			var us = $scope.users;
//			angular.forEach(us, function(user){
//				if (userIDs[user.id])
//				{
//					user.checked = true;
//				}
//				else
//				{
//					user.checked = false;
//				}
//			});
//
//			$('#roleModal').modal('toggle');
//		}).error(function(data){
//			alert('error');
//		});
		
	};
	
	$scope.add = function()
	{
		init();
		$('#roleModal').modal('toggle');
	};

	$scope.save = function(){
		
		/*
		 * action
		 */
		
		
		var role = $scope.role;
		if (angular.isUndefined(role.rolename))
		{
			alert('请输入角色名称！');
			return;
		}
		else
		{
			//create module
			var sufansSysModules = [];
			angular.forEach($scope.modules, function(module){
				if (module.checked)
				{
					var m = {id: module.id};
					sufansSysModules.push(m);
				}
			});
			
			
			//action 根据module id来获取 此module下面的action id   （ 保存为： {moduleId : value,actionId : value} ）
			var sufansSysModelActions = [];
			angular.forEach(sufansSysModules,function(moduleID){
				$('input[name='+moduleID.id+']:checked').each(function(){
					alert($(this).val());
					var a = {moduleid: moduleID.id ,actionid: $(this).val()};
					sufansSysModelActions.push(a);
				});
				
			});
			
//			angular.forEach(sufansSysModelActions,function(ma){
//				alert("mID:"+ma.moduleid+" , aID"+ma.actionid);
//			});
			
			
			//create user;
			var sufansSysUsers = [];
			angular.forEach($scope.users, function(user){
				if (user.checked)
				{
					var u = {id: user.id};
					sufansSysUsers.push(u);
				}
			});
			
			if (role.id > 0)//update
			{
				//if the property does not match the bean, it will throw 400 exception.
				var tmpObj = {rolename: role.rolename, id: role.id};
				role = tmpObj;
			}
			var roleUserModule = {};
			roleUserModule.sufansSysRole = role;
			roleUserModule.sufansSysUsers = sufansSysUsers;
			roleUserModule.sufansSysModules = sufansSysModules;
			/*
			 *   1
			 */
			roleUserModule.sufansSysModelActions = sufansSysModelActions;
//			roleService.saveRole($scope,roleUserModule);
//			$scope.$on('saveRoleData',function(event,data){
//				if(data.result)
//				{
//					$scope.tableItems = data.obj;
//					alert("保存成功！");
//				}
//				//clear the data from the form.
//				init();
//			});
			$http({
				    method: 'POST',
				    url: 'sys/role/save.do',
				    dataType: 'json', 
		            contentType: "application/json; charset=utf-8",  
		            data:JSON.stringify(roleUserModule)
			}).success(function(data){
				if(data.result)
				{
					$scope.tableItems = data.obj;
					alert("保存成功！");
				}
				//clear the data from the form.
				init();
				
			}).error(function(data){
				alert('error');
			});
			
		}
	};
	
	function init(){
		$scope.role = {id: '', rolename: ''};
		var ms = $scope.modules;
		angular.forEach(ms, function(module){
			module.checked = false;
		});

		//update the user status.
		var us = $scope.users;
		angular.forEach(us, function(user){
			user.checked = false;
		});
		
	}
});