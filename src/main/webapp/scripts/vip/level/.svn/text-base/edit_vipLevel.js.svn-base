$(document).ready(function(){
	$('#vipLevelForm').submit(function(){
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
		url :ctx+'/vipLevel!save.do',
		async :false,
		type :'post',
		data : 'vipLevel.id='+id,
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
	$('#vipLevelForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var name = $('#name').val();
	if(name == ''){
		alert('请输入等级名称');
		$('#name').focus();
		return false;
	}
	var money = $('#requiredConsumptionAmount').val();
	if(money == ''){
		alert('消费金额不能为空');
		$('#requiredConsumptionAmount').focus();
		return false;
	}else if(parseFloat(money) <= 0){
		alert('金额要大于0');
		$('#requiredConsumptionAmount').focus();
		return false;
	}
	return true;
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











