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
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var options = { 
		url : ctx+'/payment!save.do',
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
//检查表单
function checkForm(){
	var codeObj = $("#code");
	var nameObj = $("#name");
//	var paymentFeeObj = $("#paymentFee");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var pCode = $('#pCode').val();
	
	if(''==codeObj.val()){
		alert('请输入结算方式编号！');
		codeObj.focus();
		return false;
	}
	if(!codeObj.val().match(codeExp)){
		alert('结算方式编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}
	if('' == nameObj.val()){
		alert('请输入结算方式名称！');
		nameObj.focus();
		return false;
	}	
//	if('' == paymentFeeObj.val()){
//		alert('请输入结算金额！');
//		paymentFeeObj.focus();
//		return false;
//	}
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的结算方式编号");
		codeObj.focus();
		return false;
	}	
//	//验证价格  
//	 var reg = /^[0-9]+(\.[0-9]+)?$/;  
//	 if(!reg.test(paymentFeeObj.val())){  
//	      alert('所填必须为有效的金额！');  
//	      paymentFeeObj.val('');
//	      paymentFeeObj.focus();  
//	      return false;  
//    }
	return true;
}

//根据账号，判断配送方式是否已存在
function isCodeExisted(){
	var flag = true;
	var code = $("#code").val(); 
	var id = $("#id").val();
	if(''==code){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/payment!isCodeExisted.do",
			  data: "payment.code="+code+'&payment.id='+id,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('校验编号是否存在失败!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}

//账户检查
function codeCheck(){
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的结算方式编号");
		$("#code").focus();
	}
}