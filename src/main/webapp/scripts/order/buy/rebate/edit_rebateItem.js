$(document).ready(function(){
	$('#rebateItemForm').submit(function(){
		submitForm();
	});
	
});

//审核
function auditingForm(){
	$('#state').val('s');
	submitForm();
}

//保存
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var id = $('id').val();
	var options = {
		url :ctx+'/rebateItem!save.do',
		async :false,
		type :'post',
		data : 'rebateItem.id='+id,
		success:function(returnData){
			if(returnData=='true'){
				alert('保存成功！');
				window.parent.location.reload();
				window.close();
			}else{
				alert('保存失败！');
			}
		},
		error:function(){
			alert('保存失败！');
		}
	};
	$('#rebateItemForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var supplierName = $('#supplierName').val();
	if(supplierName == ''){
		alert('请选择供应商');
		$('#supplierName').focus();
		return false;
	}
	
	// 返利率
	var rebateRate = $('#rebateRate').val();
	if(rebateRate == ''){
		alert('请输入返利率');
		$('#rebateRate').focus();
		return false;
	}
	
	// 实际返利金额
	var actualRebate = $('#actualRebate').val();
	if(actualRebate == ''){
		alert('请输入返利率');
		$('#actualRebate').focus();
		return false;
	}
	return true;
}

//验证返利率
var rebateItem = {
	//验证只能为数字 
	rebateRate:function(obj){  
	    var reg = /^[0-9]+(\.[0-9]+)?$/; 
	    if(obj.value!=""&&!reg.test(obj.value)){  
	        alert('非法字符，只能输入数字和小数点');  
	        $(obj).val('');
			$(obj).focus(); 
	        return false;  
	    }else{
	    	var rebateRate = obj.value;
	    	var saleMoney = $("#saleMoney").val();
	    	if(saleMoney == ""){
	    		alert('请选择供应商');
	    		$(obj).val('');
				$(obj).focus();
	    		return false;
	    	}
	    	var rebateAmount = rebateRate * saleMoney;
	    	rebateAmount = rebateAmount.toFixed(2);
	    	$("#rebateAmount").val(rebateAmount);
	    	return true;
	    }
	}
}
//返回
function backtrack(){
	window.parent.location.reload();
	window.close();
}

