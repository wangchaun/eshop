$(document).ready(function(){
	$('#saveForm').submit(function(){
		submitForm();
	});
	var inputType = $('#inputType').val();
	if(inputType == '4'){
		$('#selectValue').show();
	}else{
		$('#selectValue').hide();
	}
});

function submitForm(){
	if(!checkForm()){
		return;
	}
	var options = {
			url :ctx+'/goodAttr!save.do',
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
		$('#saveForm').ajaxSubmit(options); 
		return false;
}

//检查表单
function checkForm(){
	var nameObj = $("#name");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var sortObj = $('#sort');
	
	if(''==nameObj.val()){
		alert('请输入属性名称！');
		nameObj.focus();
		return false;
	}
//	if(''==sortObj.val()){
//		alert('请填写序号！');
//		sortObj.focus();
//		return false;
//	}
//	if(isNaN(sortObj.val())){
//		alert('序号只能是数字！');
//		sortObj.focus();
//		return false;
//	}
	return true;
}
//控制单选值的显示与隐藏
function controlDiv(obj){
	var val = $(obj).val();
	if(val == '4'){
		$('#selectValue').show();
	}else{
		$('#selectValue').hide();
	}
}
//将中文逗号替换成英文逗号
function replaceComma(obj){
	var valueVal = $(obj).val();
	valueVal = valueVal.replace(/，/g,","); 
	$(obj).val(valueVal);
}