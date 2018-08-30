$(document).ready(function(){
	initForm();
	
	submitForm();
});

//初始化表单元素
function initForm(){
	$('#oldPwd').focus();
}

//提交表单
function submitForm(){
	$('#saveForm').submit(function(){
		if(!checkForm()){
			return false;
		}
		var options = { 
			url : ctx+'/SysUser!modifyPassword.do',
			async: false,
			cache: false,
			type : 'POST', 
			//timeout : 10000,
			success : function(returnData){ 
				if(returnData == 'true'){
					alert('修改成功!');
				}else{
					alert('修改失败!');
				}
			},
			error : function(){
				alert('修改失败!');
			} 
		};
		$('#saveForm').ajaxSubmit(options); 
		return false; 
	});
}

//检查表单
function checkForm(){
	var oldPwdObj = $('#oldPwd');
	var newPwdObj = $("#newPwd");
	var rePwdObj = $('#rePwd');
	
	if(''==oldPwdObj.val()){
		alert('请输入密码');
		oldPwdObj.focus();
		return false;
	}
	if('' == newPwdObj.val()){
		alert('请输入新密码');
		newPwdObj.focus();
		return false;
	}
	if(''==rePwdObj.val()){
		alert('请输入确认密码');
		rePwdObj.focus();
		return false;
	}
	if(newPwdObj.val()!=rePwdObj.val()){
		alert('两次输入的密码不一致');
		rePwdObj.focus();
		return false;
	}
	if(!isPwdRightInput()){
		alert('旧密码不正确');
		$('#oldPwd').val('');
		$('#oldPwd').focus();
		return false;
	}
	return true;
}

//确认旧密码是否输入正确
function isPwdRightInput(){
	var flag = true;
	var id = $("#id").val();
	var pwd = $("#oldPwd").val();
	if(''==pwd){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/SysUser!isPwdRightInput.do",
			  data: "sysUser.id="+id +"&sysUser.pwd=" + pwd,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('Check the old password is correct failure!');
					flag = false;
			 	}
		});	
	}
	return flag;
}