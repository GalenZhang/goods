<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta name="robots" content="noindex, nofollow">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/includes/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="/includes/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="/includes/kindeditor/lang/zh_CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="t_info"]', {
			resizeType : 1,
			allowPreviewEmoticons : true,
			uploadJson : '/includes/kindeditor/php/upload_json.php',	//上传组件，设定上传目录等
			fileManagerJson : '/includes/kindeditor/php/file_manager_json.php',	//文件管理组件
			allowFileManager : true,
			items : [	//需要的项目按钮
				'source', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'table','emoticons', 'image', 'link', 'fullscreen']
		});
	});
</script>
</head>
<body class="main_body">

<div id="main">

    <form method="post" action="#" name="formPost" onsubmit="return check();">
    	<table class="space" width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td width="120" align="right">模板名称：</td>
                <td><input type="text" name="t_name" class="inputBg"  value="" ><span class="red"> *</span></td>
            </tr>
            <tr>
            	<td align="right">模板内容：</td>
                <td style="padding-top:15px;"><textarea name="t_info" style="width:850px; height:300px;visibility:hidden;"></textarea></td>
            </tr>
            <tr>
            	<td></td>
                <td style="padding-top:30px;"><input type="submit" name="submit" class="submit" value="确 认" /><input type="reset" name="reset"  />
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
<script type="text/javascript">
function check()
{
  var frm  = document.forms['formPost'];
  var tName  = Utils.trim(frm.elements['t_name'].value);
  var tInfo  = Utils.trim(frm.elements['t_info'].value);

  // 检查输入
  if (tName.length == 0)
  {
    alert('请填写模板名称！');
    return false;
  }
  else if (KE.count('t_info','text')==0)
  {
    alert('请填写模板内容！');
    return false;
  }
  else
  {
    return true;
  }
}

</script>