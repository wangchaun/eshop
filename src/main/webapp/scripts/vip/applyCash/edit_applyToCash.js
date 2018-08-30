$(document).ready(function(){
	$('#applyToCashForm').submit(function(){
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
		url :ctx+'/applyToCash!save.do',
		async :false,
		type :'post',
		data : 'applyToCash.id='+id,
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
	$('#applyToCashForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var customer = $('#customerName').val();
	if(customer == ''){
		alert('请选择提现客户');
		$('#customerName').focus();
		return false;
	}
	
	var toCashAmount = $("#toCashAmount").val();
	var money = $("#money").val();
	if(toCashAmount == ''){
		alert('请输入提现金额');
		$('#toCashAmount').focus();
		return false;
	}else if(parseFloat(toCashAmount) <= 0){
		alert('金额要大于0');
		$('#toCashAmount').focus();
		return false;
	}else if(parseFloat(toCashAmount)>parseFloat(money)){
		alert('提现金额大于会员余额，会员余额为:'+money);
		$('#toCashAmount').focus();
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
		$('#money').val(data.payables);
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











