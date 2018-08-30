$(document).ready(function(){
	$('#saveForm').submit(function(){
		return submitForm();
	});
});

//提交表单
function submitForm(){
	if(!checkForm()){
		return false;
	}
	var options = { 
		url : ctx+'/promotecolumn!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){
			alert(returnData);
			window.parent.location.reload();
			window.close();
		},
		error : function(){
			alert('系统错误！！！');
		} 
	};
	$('#saveForm').ajaxSubmit(options); 
	return false;	
}

function checkForm(){
	var name=$('#name').val();
	var columnNo=$('#columnNo').val();
	var describes=$('#describes').val();
	if(name==''){
		alert('请填写栏位名称');
		return false;		
	}
	if(columnNo==''){
		alert('请填写栏位编号');
		return false;
	}
	if(describes==''){
		alert('请填写栏位描述');
		return false;
	}

	return true;
}