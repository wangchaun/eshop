$(document).ready(function(){
	//添加地区信息表单提交
	$('#creditForm').submit(function(){
		submitForm();
	});
});
function submitForm(){
    var flag=checkForm();
	if(!flag)return false;
	var options = {
		url : ctx+'/credit!save.do',
		async : false,
		type : 'post',
		success : function(returnData){
			if(returnData=='true'){
				alert('保存成功!');
				window.parent.location.reload();
				window.close();
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误,保存失败!');
		}
	};
	$('#creditForm').ajaxSubmit(options);
	return false;
}
function saveArea(){
	if(checkForm()){
		submitForm();
	}
}
//检查表单
function checkForm(){
	
	var minObj = $("#minMoney");
	var numberObj = $("#creditNum");
	var maxObj=$("#maxMoney");
	
	var codeExp = "^[0-9]{1,}$"
	if(''==minObj.val()){
		alert('请输入金额！');
		minObj.focus();
		return false;
	}
	if(''==maxObj.val()){
		alert('请输入金额！');
		maxObj.focus();
		return false;
	}
	if(!numberObj.val().match(codeExp)){
		alert('编号只能输入数字!');
		numberObj.focus();
		return false;
	}
	
	return true;
}