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
	if(!checkForm()){
		return false;
	}
	var options = { 
		url : ctx+'/delivery!save.do',
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
	var deliveryFeeObj = $("#deliveryFee");
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	
	if(''==codeObj.val()){
		alert('请输入配送方式编号！');
		codeObj.focus();
		return false;
	}
	if(!codeObj.val().match(codeExp)){
		alert('配送方式编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}
	if('' == nameObj.val()){
		alert('请输入配送方式名称！');
		nameObj.focus();
		return false;
	}	
//	if('' == deliveryFeeObj.val()){
//		alert('请输入配送费用！');
//		deliveryFeeObj.focus();
//		return false;
//	}
//	//验证价格  
//	 var reg = /^[0-9]+(\.[0-9]+)?$/;  
//	 if(!reg.test(deliveryFeeObj.val())){  
//	      alert('所填必须为有效的价格！');  
//	      deliveryFeeObj.val('');
//	      deliveryFeeObj.focus();  
//	      return false;  
//    }
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的配送方式编号");
		$("#code").val('');
		return false;
	}

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
			  url: ctx+"/delivery!isCodeExisted.do",
			  data: "delivery.code="+code+'&delivery.id='+id,
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
//根据名字，判断配送方式是否已存在
function isNameExisted(){
	var flag = true;
	var code = $("#name").val(); 
	if(''==code){
		alert('请输入配送方式名称！');
		return false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/delivery!isNameExisted.do",
			  data: "delivery.name="+code,
			  success : function(returnData){ 
					if(returnData == 'false'){
						alert("该配送方式已经存在！请使用新的配送方式名称");
						$("#name").val(''); 
						return false;
					}
				},
				error : function(){
					alert('校验账号是否存在失败!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}

//账户检查
function codeCheck(){
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的配送方式编号");
		$("#code").focus();
	}
}