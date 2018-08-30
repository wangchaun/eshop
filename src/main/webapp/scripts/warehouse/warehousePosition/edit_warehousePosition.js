$(document).ready(function(){
	$('#saveForm').submit(function(){
		submitForm();
	});
});

function submitForm(){
	if(checkForm()){
		var options = {
			url :ctx+'/warehousePosition!save.do',
			async :false,
			type :'post',
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
	}
	$('#saveForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var nameObj = $("#name");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var sortObj = $('#sort');
	
	if(''==nameObj.val()){
		alert('请输入仓位名称！');
		valueObj.focus();
		return false;
	}
	if(''==sortObj.val()){
		alert('请填写序号！');
		sortObj.focus();
		return false;
	}
	if(isNaN(sortObj.val())){
		alert('序号只能是数字！');
		sortObj.focus();
		return false;
	}
	return true;
}
