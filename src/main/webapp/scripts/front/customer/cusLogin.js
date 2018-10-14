//页面onload事件
$(document).ready(function(){
	showcheck();
});  

//验证码随机数
function showcheck() {
	if(document.getElementById("showcheckA")!=undefined){
	    document.getElementById("showcheckA").innerHTML=String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9));
	}
}
//document.getElementById('boldStuff').innerHTML = 'Fred Flinstone';   js即时改变div内的文字


//注册提交检查
function checkRegisterForm(){
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	var codeObj = $("#usercode").val();
	var pwd = $('#userpwd').val();
	if(''==codeObj){
		alert('请输入注册账户!');
		codeObj.focus();
		return false;
	}
	if(!codeObj.match(codeExp)){
		alert('账号只能使用数字、字母和下划线');
		$('#registerName').focus();
		return false;
	}
	if(codeObj.length <= 4){
		alert('账号不能小于4位!');
		codeObj.val('');
		return false;
	}
	
	if(''==pwd){
		alert('请输入注册密码!');
		pwd.focus();
		return false;
	}
	if(pwd.length <= 5){
		alert('密码不能小于6位!');
		pwd.val('');
		return false;
	}
	if(pwd.length >= 15){
		alert('密码不能大于14位!');
		pwd.val('');
		return false;
	}
	if(''==$('#checkPwd').val()){
		alert('请确认密码!');
		$('#checkPwd').focus();
		return false;
	}
	if($('#checkPwd').val() != pwd){
	 	alert('确认密码与密码不符合!');
		$('#checkPwd').focus();
		return false;
	}
	
	var email=$('#email').val();
	if(email==''){
		alert('请输入邮箱!');
		email.focus();
		return false;
	}
	//对电子邮件的验证
   var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
   if(!myreg.test(email)){
      alert('请输入有效的E_mail！');
      email.focus();
      return false;
   }	
//	if(''==$('#checkA').val()){
//		alert('请输入验证码!');
//		$('#checkA').focus();
//		return false;
//	}
	
//    if($('#showcheckA').text()!=$('#checkA').val()){
//		alert('验证码错误');
//		$('#checkA').focus();
//		return false;
//	}
	return true;
}
//提交注册表单
function submitRegisterForm(){
         
		var codeObj = $("#usercode").val();
		var pwd = $('#userpwd').val();
		var email=$('#email').val();
		var url='code='+codeObj+'&pwd='+pwd+'&email='+email;

        MaskUtil.mask();
		$.ajax({ 
		url : ctxaccount+'/account/register',
		data:url,
		async: false,
		cache: false,
		type : 'POST',
		beforeSend:function(xhr){
			xhr.withCredentials=true;
		},
		success : function(returnData){
            MaskUtil.unmask();
			if(returnData == 'true'){
			    window.location.href = ctx+'/index.do';
			}else{
				alert('注册失败!');
			}
		},
		error : function(){
			alert('System error,Registered Failed!');
		}
	});
	
}

//提交接口表单
function submitRegisterForm1(){
	if(!checkRegisterForm()){
		return false;
	}else{
		var codeObj = $("#usercode").val();
		var pwd = $('#userpwd').val();
		var email=$('#email').val();
		var url=ctx+'/registers.do?customer.code='+codeObj+'&customer.pwd='+pwd+'&customer.email='+email;
//		alert(url);
		$.ajax({ 
		url : url,
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('提交成功!');
				window.location.href = ctx+'/index.do';
			}else{
				alert('提交失败!');
			}
		},
		error : function(){
			alert('System error,Registered Failed!');
		}
	});
	  
	}
}


//验证帐号唯一
	function checkCodes(codeObj){
		var url=ctx+'/checkCodes.do?1=1';
		if(codeObj!=''){
			url +='&customer.code='+codeObj;
		}
		if(emailObj!=''){
			url +='&customer.email='+emailObj;
		}
		$.ajax({ 
		url : url,
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('已注册过的用户名！重新填写');
//				document.getElementById('zcyc2').innerHTML = '已注册过的用户名或邮箱！重新填写';   //js即时改变div内的文字
				return false;  //修改样式
			}
		},
		error : function(){
			alert('系统错误!');
		}
	});
}


//验证帐号唯一
	function checkEmail(emailObj){
		var url=ctx+'/checkEmail.do?1=1';
		if(emailObj!=''){
			url +='&customer.email='+emailObj;
		}
		$.ajax({ 
		url : url,
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('已注册过的邮箱！重新填写');
//				document.getElementById('zcyc2').innerHTML = '已注册过的用户名或邮箱！重新填写';   //js即时改变div内的文字
				return false;  //修改样式
			}
		},
		error : function(){
			alert('系统错误!');
		}
	});
}













