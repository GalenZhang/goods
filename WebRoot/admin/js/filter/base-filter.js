sofansAPP.filter("checkNameFilter", function() { 
	 var fn = function(username) {
		 if ('superadmin' == username)
		 {
		 	return true;
		 }
		 else
		 {
		 	return false;
		 }
	 };
	 return fn;
});

sofansAPP.filter("sexFilter", function() {
	 var fn = function(value) {
		 if (1 == value)
		 {
		 	return '男';
		 }
		 else if(2 == value)
		 {
		 	return '女';
		 }
		 else
		 {
			 return "未知";
		 }
	 };
	 return fn;
});




/*
 * 
 */
sofansAPP.filter('deptFilter', function() {
	return function(tableEmployeeItem) {

		if (this.tableEmployeeItem.deptId == 1) {
			return "人事部";
		}
		if (this.tableEmployeeItem.deptId == 2) {
			return "技术部";
		}
		if (this.tableEmployeeItem.deptId == 3) {
			return "市场部";
		}
		if (this.tableEmployeeItem.deptId == 4) {
			return "研发部";
		}
		if (this.tableEmployeeItem.deptId == 5) {
			return "董事会";
		}

	};
});

sofansAPP.filter('postFilter', function() {
	return function(tableEmployeeItem) {

		if (this.tableEmployeeItem.postId == 1) {
			return "人事总监";
		}
		if (this.tableEmployeeItem.postId == 2) {
			return "人事总监助理";
		}
		if (this.tableEmployeeItem.postId == 3) {
			return "技术总监";
		}
		if (this.tableEmployeeItem.postId == 4) {
			return "技术支持";
		}
		if (this.tableEmployeeItem.postId == 5) {
			return "销售总监";
		}
		if (this.tableEmployeeItem.postId == 6) {
			return "销售经理";
		}
	};
});
