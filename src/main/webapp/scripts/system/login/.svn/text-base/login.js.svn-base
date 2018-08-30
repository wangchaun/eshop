$(document).ready(function(){
	checkParent();
	showcheck();
	var errorInfo = $('#errorInfo').val();
	if(''!=errorInfo){
		alert(errorInfo);
	}
	$('#UserName').focus();
});

//随机验证码
function showcheck() {
	if(document.getElementById("showcheckA")!=undefined){
	    document.getElementById("showcheckA").innerHTML=String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9)) + String(Math.ceil(Math.random()*9));
	}
}

//检查父页面
function checkParent(){
	if(window.parent.length>0){ 
		window.parent.location = ctx + '/admin';
    }
}

//提交检查
function checkForm(){
	if(''==$('#UserName').val()){
		alert('请输入用户名!');
		$('#UserName').focus();
		return false;
	}else if(''==$('#password').val()){
		alert('请输入密码!');
		$('#password').focus();
		return false;
	}else if(''==$('#code').val()){
		alert('请输入验证码!');
		$('#code').focus();
		return false;
	}else if($('#showcheckA').text()!=$('#code').val()){
		alert('验证码错误');
		$('#code').focus();
		return false;
	}
	return true;
}

//清除表单
function cleanForm(){
	$('#code').val();
	$('#pwd').val();
	$('#code').focus();
}
