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
		url : ctx+'/supplier!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				//window.parent.$('#tab_area').tabs("close",window.parent.$('#tab_area').tabs('getSelected').panel('options').title);
				//window.parent.addTab('供应商',ctx+'/supplier!list.do');
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
	var addressObj = $("#address");
	var payablesObj = $("#payables");
	var receivablesObj = $("#receivables");
	var linkmanObj = $("#linkman");
	var telphoneObj = $("#telphone");
	var mobileObj = $("#mobile");
	var emailObj = $("#email");
	var zipCodeObj = $("#zipCode");
	var paymentFeeObj = $("#paymentFee");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var pCode = $('#pCode').val();

/*	
	if(''==codeObj.val()){
		alert('请输入供应商编号！');
		codeObj.focus();
		return false;
	}
	
	if(!codeObj.val().match(codeExp)){
		alert('供应商编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}
*/	
	if('' == nameObj.val()){
		alert('请输入供应商名称！');
		nameObj.focus();
		return false;
	}
	if('' == addressObj.val()){
		alert('请输入供应商地址！');
		addressObj.focus();
		return false;
	}	
	if('' == payablesObj.val()){
		alert('请输入应付款！');
		payablesObj.focus();
		return false;
	}	
	if('' == receivablesObj.val()){
		alert('请输入应收款！');
		receivablesObj.focus();
		return false;
	}
	if('' == linkmanObj.val()){
		alert('请输入联系人！');
		linkmanObj.focus();
		return false;
	}
	if('' == telphoneObj.val()){
		alert('请输入固定电话！');
		telphoneObj.focus();
		return false;
	}
	//验证手机
	if(''!=mobileObj.val() && isNaN(mobileObj.val())){
		alert("手机号码格式错误");
		mobileObj.focus();
		return false;
	}
	//邮箱验证
/* 
	if(''!=emailObj.val() && !common.checkIsEmail(emailObj.val())){
		alert("邮箱地址格式错误");
		emailObj.focus();
		return false;
	}
*/	
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的供应商编号");
		codeObj.focus();
		return false;
	}	
	//验证价格  
	 var reg = /^[0-9]+(\.[0-9]+)?$/;  
	 if(!reg.test(payablesObj.val())){  
	      alert('所填必须为有效的金额！');  
	      payablesObj.val('');
	      payablesObj.focus();  
	      return false;  
    }
    if(!reg.test(receivablesObj.val())){  
	      alert('所填必须为有效的金额！');  
	      receivablesObj.val('');
	      receivablesObj.focus();  
	      return false;  
    }
	return true;
}

//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaIds').val(area.id);
		$('#areaNames').val(area.name);
	}
}

//根据编号，判断供应商是否已存在
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
			  url: ctx+"/supplier!isCodeExisted.do",
			  data: "supplier.code="+code+'&supplier.id='+id,
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

//编号检查
function codeCheck(){
	if(isCodeExisted()){
		alert("该编号已经存在！请使用新的供应商编号");
		$("#code").focus();
	}
}
//温馨提示
function SCtate(op,supplierName){ 
	if(op.value=='2'){
		window.confirm('由于合作方式或产品质量需协调沟通；业务人员必须对暂停状态的厂商在30天内作出处理（恢复正常合作），否则30天后该商品直接进入停止合作状态，如库存为0则直接进入已删除厂商状态（不可逆向恢复）')
	}else if(op.value=='3'){
		window.confirm('由于停止与厂商'+supplierName+'的合作，不再经销该商家的产品!');
	
}
}