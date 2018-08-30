$(document).ready(function(){
	initForm();
	
	saveFormRewrite();
});

//初始化表单元素
function initForm(){
	if('' != $("#id").val()){
		var code = $('#code');
		code.hide();
		var codeValue = code.val();
		code.after(codeValue);	
		$('#name').focus();
	}else{
		$('#code').focus();
	}
}

//重写form的submit方法
function saveFormRewrite(){
	$('#saveForm').submit(function(){
		return submitForm();
	}); 
}

//提交表单
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var options = { 
		url : ctx+'/SysUser!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				parent.closePopWindow();
				parent.reloadDataGrid();
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误,保存失败!');
		} 
	};
	$('#saveForm').ajaxSubmit(options); 
	return false; 
}

//检查表单
function checkForm(){
	var codeObj = $("#code");
	var nameObj = $("#name");
	var pwdObj = $("#pwd");
	var telphoneObj = $("#telphone");
	var roleIdObj = $('#roleId');
	var deptIdObj=$('#deptId');
	var regionIdObj = $('#regionId');
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var emailObj = $('#email');
	var rePwdObj = $('#rePwd');
	var companyObj = $('#company');
	var addressObj = $('#address');
	
	var codeVal = codeObj.val();
	if(!codeVal.match(codeExp)){
		alert('用户名只能输入字母、数字和下划线!');
		codeObj.focus();
		return false;
	}
	if(codeVal.length < 3 ){
		alert('用户名至少需要3位字符!');
		codeObj.focus();
		return false;
	}	
	if('' == nameObj.val()){
		alert('请输入姓名!');
		nameObj.focus();
		return false;
	}	
	if('' == pwdObj.val()){
		alert('请输入密码!');
		pwdObj.focus();
		return false;
	}
	if(''==rePwdObj.val()){
		alert('请确认密码!');
		rePwdObj.focus();
		return;
	}
	if(pwdObj.val()!=rePwdObj.val()){
		alert('两次输入的密码不一致!');
		rePwdObj.focus();
		return;
	}
	//手机
	var mobileObj = $('#mobile');
	//固话
	var telephoneObj = $('#telphone');
	if('admin'==$('#roleCode').val()){
		if (''==mobileObj.val()){
	        alert("请输入手机号码!");
	        mobileObj.foucs();
	        return false;
	    }
		if (telephoneObj.val()==""){
	        alert("请输入固定电话号码!");
	        telephoneObj.focus();
	        return false;
	    }
	}
    if(''!=mobileObj.val() && isNaN(mobileObj.val())){
        alert("Phone number format error, please enter the correct！");
        mobileObj.foucs();
        return false;
    }
	if('' == roleIdObj.val()){
		alert('请选择一个角色!');
		roleIdObj.focus();
		return false;
	}
	if(''==deptIdObj.val())
	{
		alert('请选择部门');
		deptIdObj.focus();
		return false;
	}	
	
	//邮箱验证
	var emailObj = $('#email');
//	if(''!=emailObj.val() && !common.checkIsEmail(emailObj.val())){
//		emailObj.focus();
//		return false;
//	}
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(emailObj.val())){
		alert('邮箱地址格式不正确');
		emailObj.val('');
		emailObj.focus();
		return false;
	}
	if(''==regionIdObj.val()){
		alert('Please select an User Role!');
		regionIdObj.focus();
		return false;
	}
	return true;
}

//根据账号，判断用户是否已存在
function isCodeExisted(){
	var flag = true;

	var id = $("#id").val(); 
	var code = $("#code").val();
	if(''==code){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/SysUser!isCodeExisted.do",
			  data: "sysUser.id="+id +"&sysUser.code=" + code,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('Check whether the user already exists fail!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}

//账户检查
function codeCheck(){
	if(isCodeExisted()){
		alert("用户已经存在!");
		$("#code").focus();
	}
}

//选择代理商
function selectAgent(){
	var sysUser = common.getRegion();
	if(sysUser){
		$('#regionId').val(sysUser.id);
		$('#regionName').val(sysUser.name);
	}
}

//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
//选择用户角色类型
function selectUserType(){
	var roleId = $('#roleId').val();
	if(roleId){
		$.ajax({
			url:ctx+'/SysRole!getRoleCode.do',
			type:'post',
			async:false,
			cache:false,
			data:'sysRole.id='+roleId,
			success:function(returnData){
				if(returnData==false){
					alert('query Role Code Failed!');
				}else{
					$('#roleCode').val(returnData);
					if(returnData=='region'){
						$('#fntMobile').html('');
						$('#fntTelephone').html('');
					}else{
						$('#fntMobile').html('*');
						$('#fntTelephone').html('*');
					}
				}
			},
			error:function(){
				alert('System error,query Role Code Failed!');
			}
		});
	}
}

