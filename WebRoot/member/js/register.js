$(function(){
	
	$("input[name='tijiao']").click(function(){
		$("#name_msg").html("*请输入8-20位字母或数字");
		$("#pwd_msg").html("*");
		if(checkReg()){
			$("#reg_form").attr("action",getRootPath()+"/user/reg.action").submit();
		}
		return false;
	});
	
});

function checkReg()
{
	var username = $("#username").val();
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	var remember = $("#remember").is(':checked');
	
	if(username.length>20 || username.length <8){
		$("#name_msg").html("错误 : 账号应该为8-20位的数字或字母!");
		
		return false;
	}
		
	if(!/^(\d|[a-zA-Z])+$/.test(username)){
		$("#name_msg").html("错误 : 账号应该为8-20位的数字或字母!");
		return false;
	}
	
	if(password ==''){
		$("#pwd_msg").html("提示 : 请输入密码!");
	}
		
	if(password != repassword ){
		$("#pwd_msg").html("提示 : 密码不一致!");
		return false;
	}
	
	if(!remember){
		return false;
	}
		
	
	return true;
	
	
	
}

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