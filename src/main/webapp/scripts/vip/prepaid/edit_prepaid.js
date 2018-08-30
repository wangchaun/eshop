$(document).ready(function(){
	$('#prepaidForm').submit(function(){
		submitForm();
	});
});
//提交表单
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var id = $('id').val();
	var options = {
		url :ctx+'/prepaid!save.do',
		async :false,
		type :'post',
		data : 'prepaid.id='+id,
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
	$('#prepaidForm').ajaxSubmit(options); 
	return false;
}
//检查表单
function checkForm(){
	var customer = $('#customerName').val();
	if(customer == ''){
		alert('请选择充值客户');
		$('#customerName').focus();
		return false;
	}
	var prepaidMoney = $('#prepaidMoney').val();
	if(prepaidMoney == ''){
		alert('充值金额不能为空');
		$('#prepaidMoney').focus();
		return false;
	}else if(parseFloat(prepaidMoney) <= 0){
		alert('充值金额要大于0');
		$('#prepaidMoney').focus();
		return false;
	}
	return true;
}
//选择会员
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
	}
}

//返回
function backtrack(){
	window.parent.location.reload();
	window.close();
}

//审核
function auditingForm(){
	$('#state').val('s');
	submitForm();
}











