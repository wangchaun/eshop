$(document).ready(function(){
	var primaryKeyId = $('#id').val();
	var isUpdate = ''!=primaryKeyId;//是否是更新操作
	if(isUpdate){
		var code = $('#code');
		code.hide();
		var codeValue = code.val();
		code.after(codeValue);		
	}

	$('#name').focus();
	rewriteSaveForm();
});

//重写saveForm
function rewriteSaveForm(){
	$('#saveForm').submit(function(){
		return submitForm();
	});
}
 
//提交表单
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var options = { 
		url : ctx+'/SysRole!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				parent.closePopWindow();
				parent.reloadDataGrid();
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('System error,保存失败!');
		} 
	};
	$('#saveForm').ajaxSubmit(options);
	return false;	
} 
 
//表单验证
function checkForm(){
	var name = $('#name');
	var code = $('#code');
	if($.trim(name.val()).length == 0){
		alert('请输入角色名称!');
		name.focus();
		return false;
	}
	if($.trim(code.val()).length == 0){
		alert('请输入角色编号!');
		code.focus();
		return false;
	}
	if(isCodeExisted()){
		return false;
	}	
	return true;
}

//角色代码是否重复
function isCodeExisted() {
	var flag = true;

	var id = $("#id").val();
	var code = $("#code").val();
	if(''==code){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/SysRole!isCodeExisted.do",
			  data: "sysRole.id="+id +"&sysRole.code="+code,
			  success : function(returnData){ 
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('检查编号失败!');
			 	} 
		});		
	}
	
	if(flag){
		alert("编号:"+code+'已经存在，请使用其他编号!');
		$("#code").focus();
	}
	return flag;
}
