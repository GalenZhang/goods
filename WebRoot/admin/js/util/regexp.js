	function isCardNo(card)  
	{  
	   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
	   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	   return (reg.test(card));  
	}	
    /*
	 * 
	 */
	function checkTel(tel) {
		if (tel != "") {
			var regexp = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
			var re = new RegExp(regexp);
			return !re.test(tel);
		}
		return false;
	}

	/**
	 * 用途：限制文本框输入的字节总数 txtStr: 输入的文本 len : 要限定的长度
	 */
	function checkTxt(txtStr, len) {
		var val = txtStr;
		var valLength = 0;
		for (var ii = 0; ii < val.length; ii++) {
			var word = val.substring(ii, 1);
			if (/[^\x00-\xff]/g.test(word)) {
				valLength += 2;
			} else {
				valLength++;
			}
		}
		if (valLength > len) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 
	 * 用途：验证年龄，年龄不能超过一百岁，且不能为负数 输入：age
	 */
	function checkAge(str) {
		var reNum = /^[1-9][0-9]?$/;
		return (reNum.test(str));
	}

	/*
	 * 用途：检查输入字符串是否为空或者全部都是空格 输入：str 返回： 如果全是空返回true,否则返回false
	 */
	function isNull(str) {
		if (str == "")
			return true;
		var regu = /[^\u4e00-\u9fa5]/g;
		var re = new RegExp(regu);
		return re.test(str);
	}
	;

	/*
	 * 用途：检查输入手机号码是否正确 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
	 * 
	 */
	function checkMobile(s) {
		var regu = /^\s*(14[0-9]\d{8}|15\d{9}|13[0-9]\d{8})\s*$/;
		var re = new RegExp(regu);
		if (re.test(s)) {
			return true;
		} else {
			return false;
		}
		;
	}
	;

	/*
	 * 用途：检查输入对象的值是否符合E-Mail格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
	 */
	function isEmail(str) {
		var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
		if (myReg.test(str))
			return true;
		return false;
	}
	;
	function checkPassword(pwd){
		var regu =/[^\d|chun]/g;
		if (pwd.length < 6) return false;
		if (regu.test(pwd)) {
			return true;
		} else {
			return false;
		}
		;
	};
