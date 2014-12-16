

sofansAPP.controller("orderController", function($scope, $rootScope, $http,
		$element, $compile,orderService,employeeService,agentService, globalValue) {
	
	var v = loginUserID;
	var backRoleIdByUid = loginUserID;
	if (v > 1) {
		if(v == 3){
			orderService.listByIdForJiShu($scope);
			$scope.$on('orderListByIdForJiShu',function(event,data){
				$rootScope.tableOrderItems = data;
				loadRoleId(backRoleIdByUid,$rootScope);
			});
//			$http({
//				method : 'GET',
//				async: false, //取消异步执行
//				url : 'sys/order/listByIdForJiShu.do',
//				dataType : 'json',
//				contentType : 'application/json; charset=utf-8',           
//			}).success(function(data) {
//				$rootScope.tableOrderItems = data;
//				loadRoleId(backRoleIdByUid,$rootScope);
//			});
		}else{
			orderService.orderListById($scope, v);
			$scope.$on('orders_ListById',function(event,data){
				$rootScope.tableOrderItems = data;
				loadRoleId(backRoleIdByUid,$rootScope);
			});
//			$http({
//				method : 'GET',
//				async: false, //取消异步执行
//				url : 'sys/order/listById.do?id=' + v,
//				dataType : 'json',
//				contentType : 'application/json; charset=utf-8',           
//			}).success(function(data) {
//				$rootScope.tableOrderItems = data;
//				loadRoleId(backRoleIdByUid,$rootScope);
//			});
		}
	} else {
		orderService.ordersList($scope);
		$scope.$on('orders_List',function(event,data){
			$rootScope.tableOrderItems = data;
			loadRoleId(backRoleIdByUid,$rootScope);
		});
//		$http({
//			method : 'GET',
//			async: false,
//			url : 'sys/order/list.do',
//			dataType : 'json',
//			contentType : 'application/json; charset=utf-8',           
//		}).success(function(data) {
//			$rootScope.tableOrderItems = data;
//			loadRoleId(backRoleIdByUid,$rootScope);
//		});
		
	}	
	/*
	 * 通过UserId获取roleId  ( 一个用户只能属于一个角色 )
	 */
	function loadRoleId(backRoleIdByUid,roots){
		orderService.loadRidByUid($scope,backRoleIdByUid);
		$scope.$on('loadRidByUids',function(event,data){
			var RoleByUidItems = data;
			roots.roleid = RoleByUidItems[0].roleid;
			rID = RoleByUidItems[0].roleid;
			hideOrShowEl(rID,$rootScope.tableOrderItems);
		});
//		$http.get('sys/role/loadRoleId.do?id=' + backRoleIdByUid,{async: false}).success(function(data) {
//			var RoleByUidItems = data;
//			roots.roleid = RoleByUidItems[0].roleid;
//			rID = RoleByUidItems[0].roleid;
//			hideOrShowEl(rID,$rootScope.tableOrderItems);
//		}).error(function(data) {
//			alert('error');
//		});
	};
	   /*
	    * 订单的 remove操作,update操作 : order.state = 1 ,状态为 进行中，业务员和技术人员都不能对此订单进行删除和修改。技术人员能对其update（提交完成动作）
	    * order.state = 2 ,状态为 完成，业务员和技术人员也不能对起进行操作。
	    * 1 - superadmin;  2 - 业务员; 3 - 技术
	    */

	function hideOrShowEl(rid ,tableOrderItems){
		var isOpenOrderItems = tableOrderItems;
		var orderSaveBtnIsDisabled = [];
		for(var i = 0; i < isOpenOrderItems.length; i++){
			
			if(isOpenOrderItems[i].state != 2)
			{
				$("#loadTablet"+isOpenOrderItems[i].id).html("");
			}	
			//superadmin
			if(rid == 1)
			{
				//superadmin 有所有的权限，可以执行所有的操作
			}
			//业务员
			if(rid == 2)
			{
				if(isOpenOrderItems[i].state > 0){
					$('#'+isOpenOrderItems[i].id).html('');
					//$("#orderBut_save").hide();
					orderSaveBtnIsDisabled.push(isOpenOrderItems[i].id);
				}
			}
			//技术
			if(rid == 3)
			{
				$("#addOrder_btn").hide();
				if(isOpenOrderItems[i].state == 1){
					$('#'+isOpenOrderItems[i].id).html('');	
				}
				if(isOpenOrderItems[i].state == 2){
					$('#'+isOpenOrderItems[i].id).html('');	
					//
					orderSaveBtnIsDisabled.push(isOpenOrderItems[i].id);
				}
			}
		}
		$rootScope.orderSaveBtnIsDisabled = orderSaveBtnIsDisabled;		
	}
	/*
	 * select标签 绑定销售经理 的加载数据
	 * 
	 */
	employeeService.loadAllEmp($scope);
	$scope.$on('loadAllemps',function(event,data){
		var tableEmployeeItems = data;
		var employeeValues = [];
		angular.forEach(tableEmployeeItems, function(employee) {
			employeeValues.push({
				empID : employee.id,
				empName : employee.name
			});
		});
		$rootScope.Orderemployees = employeeValues;		
	});
//	$http.get('sys/employee/load.do').success(function(data) {
//		var tableEmployeeItems = data;
//		var employeeValues = [];
//		angular.forEach(tableEmployeeItems, function(employee) {
//			employeeValues.push({
//				empID : employee.id,
//				empName : employee.name
//			});
//		});
//		$rootScope.Orderemployees = employeeValues;
//	}).error(function(data) {
//		alert('error');
//	});	
	/*
	 * select标签 绑定代理商的加载数据
	 */
	agentService.loadAngents($scope);
	$scope.$on('agentsList',function(event,data){
		var tableAngentItems = data;
		var angentValues = [];
		angular.forEach(tableAngentItems, function(angent) {
			angentValues.push({
				angentID : angent.id,
				angentName : angent.name
			});
		});
		$rootScope.OrdereAngents = angentValues;		
	});
//	$http.get('sys/agent/list.do').success(function(data) {
//		var tableAngentItems = data;
//		var angentValues = [];
//		angular.forEach(tableAngentItems, function(angent) {
//			angentValues.push({
//				angentID : angent.id,
//				angentName : angent.name
//			});
//		});
//		$rootScope.OrdereAngents = angentValues;
//	}).error(function(data) {
//		alert('error');
//	});
	/*
	 *  -------the order ---> all tablets
	 *  id :  order ID
	 */
	$scope.loadTabletInfo = function(id){
		
//		orderService.loadTabletByOrder($scope, id);
//		$scope.$on('allTabByOrId', function(event,data){
//			var tableCusItems = data;
//			window.showModalDialog("order_tablets.html",tableCusItems,"dialogWidth=820px;dialogHeight=480px;center:yes;scroll:yes;");
//		});
		$http.get('sys/order/listTabletCus.do?id='+id,{async: false}).success(function(data) {
			var tableCusItems = data;
			window.showModalDialog("order_tablets.html",tableCusItems,"dialogWidth=820px;dialogHeight=480px;center:yes;scroll:yes;");
		}).error(function(data) {
			alert('error');
		});		
	};
	/*
	 *   --------add
	 */
	$scope.add = function() {
		$rootScope.sufansSysOrder = {
				empId : '',
				angentId : '',
				quantity : '',
				description : '',
				state : '',
				createtime : '',
				orderNumber : '',
				id : 0
		};
		$('#orderinfoModal').modal('toggle');
		$("#empName").show();
		$("#empNametwo").hide();
		$("#angentName").show();
		$("#angentNametwo").hide();
		$("#createtimeDiv").hide();
		$("#orderSDIV").hide();	
		//update更新的时候，会把btnState按钮禁用掉，当再添加新的order的时候，这个保存的按钮会处于禁用的状态。 这时需要移除它的disabled属性
		$("#btnState").removeAttr("disabled");
	};
	/*
	 *   --------remove
	 */
	$scope.remove = function(id) {
		if (!confirm("确定要删除吗？"))
			return false;
		orderService.removeOrder($scope,id,v);
		$scope.$on('removeOrderBackData',function(event,data){
			if (data.result) {
				$scope.tableOrderItems = data.obj;
				alert('删除成功！');
			}			
		});
//		var url = 'sys/order/remove.do?id=' + id+'&v='+v;
//		$http.get(url).success(function(data) {
//			if (data.result) {
//				$scope.tableOrderItems = data.obj;
//				alert('删除成功！');
//			}
//		}).error(function(data) {
//			alert('error');
//		});
	};
	/*
	 * ----- print
	 */
	$scope.orderPrint = function(id,orderNumber,empId,angentId,quantity,createtime){
		//window.open ('print.html?id='+id+'&orderNumber='+orderNumber+'&empId='+empId+'&angentId='+angentId+'&quantity='+quantity+'&createtime='+createtime, 'wb', 'height=600, width=700, top=+((window.screen.height-600)/2)+', left='+((window.screen.width-700)/2)+', 'toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no') ;
	};
	
	/*
	 * ---- update
	 */
	$scope.update = function(id) {
		var tableOrderItems = $rootScope.tableOrderItems;
		var orderSaveBtnIsDisabled = $rootScope.orderSaveBtnIsDisabled;
		var updateObj = {};
		for (var i = 0; i < tableOrderItems.length; i++) {
			if (tableOrderItems[i].id == id) {
				updateObj = tableOrderItems[i];
				break;
			};
		}	
		if(updateObj.state == 0) {
			$("#orderSDIV").html("<p style='display:block;padding:5px;border:1px solid #ccc; color: red;'>状态 : 审核中...</p>");
			$scope.stateTxt = '审核中';
		}
		if(updateObj.state == 1) {
			$("#orderSDIV").html("<p style='display:block;padding:5px;border:1px solid #ccc; color: #ff6600;'>状态 : 进行中...</p>");
			$scope.stateTxt = '进行中';
		}
		if(updateObj.state == 2) {
			$("#orderSDIV").html("<p style='display:block;padding:5px;border:1px solid #ccc; color: green;'>状态 : 完成 ！</p>");
			$scope.stateTxt = '完成';
		}
		$rootScope.sufansSysOrder = updateObj;	
		$('#orderinfoModal').modal('toggle');
		$("#empName").hide();
		$("#empNametwo").show();
		$("#angentName").hide();
		$("#angentNametwo").show();
		$("#createtimeDiv").show();
		$("#orderSDIV").show();
		for(var m = 0; m < orderSaveBtnIsDisabled.length; m++){
			if(updateObj.id == orderSaveBtnIsDisabled[m]){
				$("#btnState").attr("disabled","disabled");
				return;
			}else{
				$("#btnState").removeAttr("disabled");
			}
		}		
	};
});
/*
 * 
 */
sofansAPP.filter('orderStateFilter',function(){
	return function(tableOrderItem){
		if(this.tableOrderItem.state == 0){
			return "审核中";
		}
		if(this.tableOrderItem.state == 1){
			return "进行中";
		}
		if(this.tableOrderItem.state == 2){
			return "完成";
		}
	};
});
/*
 * 把代理商的emp_id过滤成与emp_id对应的员工名
 * 
 * 此处有一个问题 ： 不知道为何要循环双倍的次数，导致过滤后的数据又清空了。用 name = this.tableAngentItem.emp_id
 * 来控制清空
 * 
 */
var rootorderEmployee = loadorderEmp();
var rootorderAngent = loadorderAngent();
sofansAPP.filter('orderempNameFilter', function() {
	return function(tableOrderItem) {
		
		var employeeValues = rootorderEmployee;
		var id = this.tableOrderItem.empId;
		var name = this.tableOrderItem.empId;
		var keepGoing = true;
		angular.forEach(employeeValues, function(emp) {
			if (keepGoing) {
				if (emp.empID == id) {
					name = emp.empName;
					keepGoing = false;
				}
			}
		});
		return this.tableOrderItem.empId = name;
	};
});

sofansAPP.filter('orderangentNameFilter', function() {
	return function(tableOrderItem) {

		var angentValues = rootorderAngent;
		var id = this.tableOrderItem.angentId;
		var name = this.tableOrderItem.angentId;
		var keepGoing = true;
		angular.forEach(angentValues, function(angent) {

			if (keepGoing) {
				if (angent.angentID == id) {
					name = angent.angentName;
					keepGoing = false;
				}
			}
		});
		return this.tableOrderItem.angentId = name;
	};
});

function loadorderEmp() {
	var employeeValues = [];
	
	$.get('sys/employee/load.do').success(function(data) {
		var tableEmployeeItems = data;
		angular.forEach(tableEmployeeItems, function(employee) {
			employeeValues.push({
				empID : employee.id,
				empName : employee.name
			});
		});
	}).error(function(data) {
		alert('error');
	});
	
	return employeeValues;

}
function loadorderAngent(agentService,scope) {
	var angentValues = [];

	$.get('sys/agent/list.do').success(function(data) {
		var tableAngentItems = data;
		angular.forEach(tableAngentItems, function(angent) {
			angentValues.push({
				angentID : angent.id,
				angentName : angent.name
			});
		});
	}).error(function(data) {
		alert('error');
	});
	
	return angentValues;

}
/*
 * 添加订单信息
 * 
 */
sofansAPP.controller('updateOrderController', function($scope, $rootScope,
		$http, $element, $compile, orderService,globalValue) {
	$rootScope.sufansSysOrder = {
			empId : '',
			angentId : '',
			quantity : '',
			description : '',
			state : '',
			createtime : '',  //创建时间
			orderNumber : '', //自动生成订单编号
			id : 0
	};
	var rootScope = $rootScope;
	$scope.save = function() {	
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysOrder.empId)) {
			alert("下单业务员不能为空！");
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysOrder.angentId)) {
			alert("下单业务员不能为空！");
			return;
		}
		if (globalValue.isUndefinedOrNull(rootScope.sufansSysOrder.description)) {
			alert("订单详细描述业务员不能为空！");
			return;
		}
		if (checkTxt(rootScope.sufansSysOrder.description, 300)) {
			alert("订单详细描述不能超过300个字节！");
			return;
		}
		else {
			var sufansSysOrder = rootScope.sufansSysOrder;

			/*
			 * update ： 由于前面用filter来过滤了数据，显示的emp_id替换成了中文名字。 现在在添加的之前来替换回来。
			 */
			var atEmps = $rootScope.Orderemployees;
			if(atEmps != null){
			for (var i = 0; i < atEmps.length; i++) {
				if (sufansSysOrder.empId == atEmps[i].empName) {
					sufansSysOrder.empId = atEmps[i].empID;
					break;
				}
			}
			}
			var atAngents = $rootScope.OrdereAngents;
			if(atAngents != null){
			for (var i = 0; i < atAngents.length; i++) {
				if (sufansSysOrder.angentId == atAngents[i].angentName) {
					sufansSysOrder.angentId = atAngents[i].angentID;
					break;
				}
			}
			}
			var isUpdate = false;
			if (sufansSysOrder.id > 0)// update
			{
				/*
				 * 
				 * 这个地方写死了。   如果role id == 2 业务员 ,保存订单的状态就是 审核中
				 *            如果role id == 3 技术 ,保存订单的状态就是 进行中  
				 * state :  0-审核 ； 1-进行； 2-完成          
				 * */
				var orderSta = 0;
				//roleid ==1 ,如果是超级管理员，每次的更新操作，都会改变一次订单的状态
				if($rootScope.roleid==1){
					sufansSysOrder.state += 1;
					if(sufansSysOrder.state > 2){
						sufansSysOrder.state = 2;
					}
					orderSta = sufansSysOrder.state;
				}
				if($rootScope.roleid==2){
					if(sufansSysOrder.state > 0){
						orderSta = sufansSysOrder.state;
					}	
				}
	            if($rootScope.roleid==3){
	            	if(sufansSysOrder.state >= 1){
	            		orderSta = sufansSysOrder.state + 1;
	            		if(orderSta > 2)
	            		{
	            			orderSta = 2;
	            		}
	            	}
	            	orderSta = 1;
				}
	            if($rootScope.roleid==4){
	            	orderSta = 2;
	            }
	            
				var tmpObj = {
						empId : sufansSysOrder.empId,
						angentId : sufansSysOrder.angentId,
						quantity : sufansSysOrder.quantity,
						description : sufansSysOrder.description,
						//如果是进来到update，则此处的状态应该是由谁操作而决定的。
						state : sufansSysOrder.state,
						createtime : sufansSysOrder.createtime,
						orderNumber : sufansSysOrder.orderNumber,
						id : sufansSysOrder.id
				};
				sufansSysOrder = tmpObj;
				sufansSysOrder.state = orderSta;
				isUpdate = true;	
			}else{
				sufansSysOrder.orderNumber = null;
				sufansSysOrder.createtime = null;
				//这个地方设置状态为 0 : 因为每次添加新的订单，状态必须为审核中的一个状态
				sufansSysOrder.state = 0;			
			}
			orderService.saveOrder($scope,sufansSysOrder);
			$scope.$on('saveOrd',function(event, data){
				if (data.result && !isUpdate) {
					var ds = $rootScope.tableOrderItems;
					ds.push(data.obj);
					$rootScope.tableOrderItems = ds;
					alert("保存成功！");
				} else {
					alert("保存成功！");
				}
				// clear the data from the form.
				rootScope.sufansSysOrder = {
						empId : '',
						angentId : '',
						quantity : '',
						description : '',
						state : '',
						createtime : '',
						orderNumber : '',
						id : 0
				};
			});
//			$http({
//				method : 'POST',
//				url : ' sys/order/save.do',
//				dataType : 'json',
//				contentType : 'application/json; charset=utf-8',
//				data : JSON.stringify(sufansSysOrder)            
//			}).success(function(data) {
//				if (data.result && !isUpdate) {
//					var ds = $rootScope.tableOrderItems;
//					ds.push(data.obj);
//					$rootScope.tableOrderItems = ds;
//					alert("保存成功！");
//				} else {
//					alert("保存成功！");
//				}
//				// clear the data from the form.
//				rootScope.sufansSysOrder = {
//						empId : '',
//						angentId : '',
//						quantity : '',
//						description : '',
//						state : '',
//						createtime : '',
//						orderNumber : '',
//						id : 0
//				};
//			}).error(function(data) {
//				alert('back error');
//			});

		}
	};
//
//	/**
//	 * 用途：限制文本框输入的字节总数 txtStr: 输入的文本 len : 要限定的长度
//	 */
//	function checkTxt(txtStr, len) {
//		var val = txtStr;
//		var valLength = 0;
//		for (var ii = 0; ii < val.length; ii++) {
//			var word = val.substring(ii, 1);
//			if (/[^\x00-\xff]/g.test(word)) {
//				valLength += 2;
//			} else {
//				valLength++;
//			}
//		}
//		if (valLength > len) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	/*
//	 * 用途：检查输入字符串是否为空或者全部都是空格 输入：str 返回： 如果全是空返回true,否则返回false
//	 */
//	function isNull(str) {
//		if (str == "")
//			return true;
//		var regu = /[^\u4e00-\u9fa5]/g;
//		var re = new RegExp(regu);
//		return re.test(str);
//	};
//	
//	function backVal(rid){
//		return rid;
//	}

});
