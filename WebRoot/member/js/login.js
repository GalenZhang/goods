$(function() {

	$("#error_msg").hide();
	
	$("#tijiao").click(
			function() {
				$("#error_msg").html("");
				var username = $("input[name='username']").val().replace(/\ +/g,"");
				var password = $("input[name='password']").val().replace(/\ +/g,"");

				if(username=="" || password==""){
					$("#error_msg").css("color","green");
					$("#error_msg").html("提示  : 请输入账号和密码！");
					$("#error_msg").show();
					return;
				}
				
				
				var url = getRootPath()+"/login/login.action?username=" + username + "&password="
						+ password;
				/*
				 * 
				 * struts + ajax : 不能正常跳转页面问题
				 *    处理: 直接返回data后在ajax里面来重定向。
				 * 
				 */
				$.get(url, null, function(data) {
					
					var msg = data.valueOf();
					var str = msg.substring(0,2);
					if(str == "错误"){
						$("#error_msg").css("color","red");
						$("#error_msg").html(data.valueOf());
						$("#error_msg").show();
					}else{
						window.location = getRootPath()+"/goods.action";
					}
					
					
				});
			});

});

/*
 * 获取更目录  
 */
function getRootPath() {
    var strFullPath = window.document.location.href;
    var strPath = window.document.location.pathname;
    var pos = strFullPath.indexOf(strPath);
    var prePath = strFullPath.substring(0, pos);
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    return (prePath + postPath);
}
