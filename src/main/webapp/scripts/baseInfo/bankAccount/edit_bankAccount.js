$(document).ready(function(){
	saveFormRewrite();
});

//初始化表单元素
function initForm(){
	if('' != $("#id").val()){
		var code = $('#code');
		code.hide();
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
//表单提交
function submitForm(){
	//帐号编号
	var codeObj = $("#code").val();
	//账户名称
	var nameObj = $("#name").val();
	//帐号
	var accountObj = $("#account").val();
	//开户人
	var accountHolderObj = $("#accountHolder").val();
	//开户银行
	var bankObj = $("#bank").val();
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	var reaccount=$('#reaccount').val();
	if(''==codeObj){
		alert('请输入帐号编号！');
		codeObj.focus();
		return false;
	}else if(!codeObj.match(codeExp)){
		alert('帐号编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}else if('' == nameObj){
		alert('请输入帐号名称！');
		nameObj.focus();
		return false;
	}else if('' == accountObj){
		alert('请输入帐号！');
		accountObj.focus();
		return false;
	}else if(accountObj.length>21 || accountObj.length<16){
		alert('请输入正确的帐号！');
		accountObj.focus();
		return false;
	}else if(reaccount==''){
		alert('请输入确认账号！');
		reaccount.focus();
		return false;
	}else if(reaccount!='' && accountObj!=reaccount){
		alert('两次输入账号不正确，请重新输入！');
		reaccount.select();
		return false;
	}else if('' == accountHolderObj){
		alert('请输入开户人！');
		accountHolderObj.focus();
		return false;
	}else if('' == bankObj){
		alert('请输入开户银行！');
		bankObj.focus();
		return false;
	}else{
		var options = { 
			url : ctx+'/bankAccount!save.do',
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
				alert('保存失败!');
			} 
		};
		$('#saveForm').ajaxSubmit(options); 
		return false; 	
	}
}
//验证账号的唯一
function checkAccount(accountObj){
	if(accountObj!=''){
		var options = { 
			url : ctx+'/bankAccount!checkAccount.do?bankAccount.account='+accountObj,
			async: false,
			cache: false,
			type : 'POST', 
			//timeout : 10000,
			success : function(returnData){ 
				if(returnData == 'true'){
					return;
				}else{
					alert('账号已存在!');
					$('#account').val('');
					return false;
				}
			},
			error : function(){
				alert('保存失败!');
			} 
		};
	}
	
}

//检查表单
function checkForm(){
	//帐号编号
	var codeObj = $("#code").val();
	//账户名称
	var nameObj = $("#name").val();
	//帐号
	var accountObj = $("#account").val();
	//开户人
	var accountHolderObj = $("#accountHolder").val();
	//开户银行
	var bankObj = $("#bank").val();
//	var moneyObj = $("#money");
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	
	if(''==codeObj){
		alert('请输入帐号编号！');
		codeObj.focus();
		return false;
	}
	if(!codeObj.match(codeExp)){
		alert('帐号编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}
	if('' == nameObj){
		alert('请输入帐号名称！');
		nameObj.focus();
		return false;
	}	
	if('' == accountObj){
		alert('请输入帐号！');
		accountObj.focus();
		return false;
	}	
	if(accountObj.length>21){
		alert('请输入正确的帐号！');
		accountObj.focus();
		return false;
	}
	
	var reaccount=$('#reaccount').val();
	if(accountObj!=reaccount){
		alert('两次输入账号不正确，请重新输入！');
		reaccount.select();
		return false;
	}
	
//	if(''==moneyObj.val()){
//		alert('请输入帐号金额！');
//		moneyObj.focus();
//		return false;
//	}
	if('' == accountHolderObj){
		accountHolderObj.focus();
		return false;
	}
	if('' == bankObj){
		alert('请输入开户银行！');
		bankObj.focus();
		return false;
	}
	return true;
}
