$(document).ready(function(){
	$('#messageForm').submit(function(){
		submitForm();
	});
});

//提交表单
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var tt = $('#tt').val();
	var id = $('id').val();
	var options = {
		url :ctx+'/message!save.do',
		async :false,
		type :'post',
		data : 'message.id='+id,
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
	$('#messageForm').ajaxSubmit(options); 
	return false;
}

// 检查表单
function checkForm(){
	var contentObj = $("#content");
	if("" == contentObj.val()){
		alert('请输入咨询内容');
		$('#customerName').focus();
		return false;
	}
	return true;
}
// 返回
function backtrack(){
	window.parent.location.reload();
	window.close();
}
// 审核
function auditingForm(){
	$('#state').val('s');
	submitForm();
}










