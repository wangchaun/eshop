$(document).ready(function(){
	initForm();
	saveFormRewrite();
});

//初始化表单元素
function initForm(){
	$('#code').focus();
}

//重写form的submit方法
function saveFormRewrite(){
	$('#saveForm').submit(function(){
		return submitForm(false);
	});
}
//提交表单
function submitForm(isConfirm){
 
	if(!checkForm()){
		return false;
	}
	//审核时更新数据状态
	var stateObj = $('#state');
	if(isConfirm){
		if('s'==stateObj.val()){
			alert('此信息已被审核,无需再次审核!');
			return;
		}
		stateObj.val('s');
	}else{
		if(''==stateObj.val()){
			$('#state').val('c');
		}
	}
	var options = { 
		url : ctx+'/customers!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			var succInfo = '';
			var errorInfo = '';
			if(!isConfirm){
				info = '保存成功';
				errorInfo = '保存失败';
			}else{
				info = '审核成功';
				errorInfo = '审核失败';
			}
			if(returnData == 'true'){
				alert(info);
				parent.closePopWindow();
				parent.reloadDataGrid();
			}else{
				alert(errorInfo);
			}
		},
		error : function(){
			alert('系统错误');
		} 
	};
	$('#saveForm').ajaxSubmit(options); 
	return false; 
}
//检查表单
function checkForm(){

	var codeObj = $("#code");
	var codeVal = codeObj.val();
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	if(''==codeVal){
		alert('请输入账号');
		codeObj.focus();
		return false;
	}
	if(!codeVal.match(codeExp)){
		alert('账号只能使用数字、字母和下划线');
		codeObj.focus();
		return false;
	}
	if(''==$('#id').val() && isCodeExisted()){
		var code = codeObj.val();
		alert(code+"已经存在,请输入其他账号");
		codeObj.focus();
		return false;
	}
	
	var nameObj = $("#name");
	if(nameObj.val()==''){
		alert('请输入用户姓名');
		nameObj.focus();
		return false;
	}
	
	var linkManObj = $("#linkman");
	if(''==linkManObj.val()){
		alert("请输入联系人");
		linkManObj.focus();
		return false;
	}
	//验证密码
	var pwdObj = $("#pwd");
	if('' == pwdObj.val()){
		alert('请输入密码');
		pwdObj.focus();
		return false;
	}
	var rePwdObj = $('#rePwd');
	if(''==rePwdObj.val()){
		alert('请确认密码');
		rePwdObj.focus();
		return;
	}
	if(pwdObj.val()!=rePwdObj.val()){
		alert('两次输入的密码不匹配');
		rePwdObj.focus();
		return;
	}
	//邮箱验证
	var emailObj = $('#email');
	if(''==emailObj.val() && !common.checkIsEmail(emailObj)){
		emailObj.focus();
		return false;
	}
	//验证地区
	var areaNameObj = $('#areaNames');
	if(''==areaNameObj.val()){
		alert('请选择地区');
		areaNameObj.focus();
		return false;
	}
	var warehouseNameObj = $("#warehouseName");
	if(''==warehouseNameObj.val()){
		alert('请选择会员所属社区');
		warehouseNameObj.focus();
		return false;
	}
	
//	//验证手机
//	if('' == mobileObj.val()){
//		alert("请输入手机号码");
//		mobileObj.focus();
//		return false;
//	}
//	if(''==$('#id').val() && isMobileExisted()){
//		alert("手机号码已经存在!");
//		mobileObj.focus();
//		return false;
//	}
//	if(''==cardObj.val())
//	{
//		alert('请输入卡号');
//		cardObj.focus();
//		return false;
//	}
//	if(!cardVal.match(cardExp)){
//		alert('卡号必须以CD开头,长度在8到18位!');
//		cardObj.focus();
//		return false;
//	}
//	if(cardObj.val()==codeVal)
//	{
//		alert('卡号和帐号不能相同！');
//		return false;
//	}
	
	return true;
}
//仓库
//function selectWarehouse(){
//	var warehouse = common.getWarehouse();
//	if(warehouse){
//		$('#warehouseId').val(warehouse.id);
//		$('#warehouseName').val(warehouse.name);
//	}
//}
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
			  url: ctx+"/customers!checkCodeIsExists.do",
			  data: "customer.id="+id +"&customer.code=" + code,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('系统错误!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}

function checkmobile()
{
	var mobileObj = $('#mobile');
	if(isMobileExisted())
	{
		alert("手机号码已经存在!");
		mobileObj.focus();
		return false;
	}
	return true;
}

//根据账号，判断手机号码是否已存在
function isMobileExisted(){
	var flag = true;
	
	var id = $("#id").val(); 
	var mobile = $("#mobile").val();
	if(''==mobile){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/customers!checkMobileIsExists.do",
			  data: "customer.id="+id +"&customer.mobile=" + mobile,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('系统错误!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}
//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaIds').val(area.id);
		$('#areaNames').val(area.name);
	}
}
//验证价格
function checkprice(obj){  
 	var reg = /^[0-9]+(\.[0-9]+)?$/;
 	if(obj!=""&&!reg.test(obj)){  
       return false;
    }
    return true;
}
