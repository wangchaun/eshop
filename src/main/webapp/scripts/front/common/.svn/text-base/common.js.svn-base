//用json包装的公共方法
var common = {
	//验证只能为数字 
	checkNumber:function(obj){  
	    var reg = /^[0-9]+(\.[0-9]+)?$/; 
	    if(obj.value!=""&&!reg.test(obj.value)){  
	        alert('非法字符，只能输入数字和小数点');  
	        $(obj).val('');
			$(obj).focus(); 
	        return false;  
	    }  
	},
	//验证只能为正整数
	number:function(obj){  
	    var reg = /^[0-9]*[1-9][0-9]*$/ ; 
	    if(obj.value!=""&&!reg.test(obj.value)){  
	        alert('非法字符,只能输入正整数');  
	        $(obj).val('');
			$(obj).focus(); 
	        return false;  
	    }  
	},
	//验证邮件格式
	checkIsEmail:function(obj){
		var email = $(obj).val();
		//对电子邮件的验证
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!myreg.test(email)){
			alert('邮箱地址格式不正确');
			$(obj).val('');
			$(obj).focus();
			return false;
		}
		return true;
	},
	//验证手机格式
	checkIsMobile:function(obj){
		var mobile = $(obj).val();
	    var reg = /^[1]\d{10}$/;
	    if(!reg.test(mobile))
	    {
	    	alert('手机号码格式不正确');
	    	$(obj).val('');
			$(obj).focus();
	        return false;
	    }
	    return true;
	},
	//验证固话格式
	checkIsTelephone:function(obj){
		var telephone = $(obj).val();
	    var reg = /^\d{3}-\d{8}|^\d{4}-\d{7}/;
	    if(!reg.test(telephone))
	    {
	    	alert('固定电话号码格式不正确');
	    	$(obj).val('');
			$(obj).focus();
	        return false;
	    }
	    return true;
	},
	//日期验证
	checkDateFormat:function(dateData){
		var reg = /^\d{4}-((0{0,1}[1-9]{1})|(1[0-2]{1}))-((0{0,1}[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))$/;  
		if(!reg.test(dateData)){
			return false;
		}
		return true;
	},
	//邮编验证--中国
	checkPostCodeFormat:function(obj){
		var postCode = $(obj).val(); 
		var reg = /[1-9]\d{5}(?!\d)/;
		if(!reg.test(postCode)){
			alert('邮编格式不正确');
			$(obj).val('');
			$(obj).focus();
			return false;
		}
		return true;
	},
	//传真验证
	checkFaxFormat:function(fax){
		var reg = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
		if(!reg.test(fax)){
			return false;
		}
		return true;
	},
	//验证网址
	checkUrlFormat:function(website){
		var regExp = /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/;
		if(!regExp.test(website)){
			return false;
		}
		return true;
	}
};
