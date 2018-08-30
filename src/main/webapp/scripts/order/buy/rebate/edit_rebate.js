$(document).ready(function(){
	$('#rebateForm').submit(function(){
		submitForm();
	});
});

//保存
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var id = $('id').val();
	var options = {
		url :ctx+'/rebate!save.do',
		async :false,
		type :'post',
		data : 'rebate.id='+id,
		success:function(returnData){
			if(returnData=='true'){
				alert('保存成功！');
				window.parent.location.reload();
				window.close();
			}else if(returnData=='id'){
				alert('返利子项为空！');
			}else if(returnData=='state'){
				alert('有返利子项没被审核！');
			}else{
				alert('保存失败！');
			}
		},
		error:function(){
			alert('保存失败！');
		}
	};
	$('#rebateForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var startTime = $('#startTime').val();
	if(startTime == ''){
		alert('请选择返利的开始时间');
		$('#startTime').focus();
		return false;
	}
	var endTime = $('#endTime').val();
	if(endTime == ''){
		alert('请选择返利的结束时间');
		$('#endTime').focus();
		return false;
	}
	return true;
}

//审核
function auditForm(){
	$('#state').val('s');
	submitForm();
}
