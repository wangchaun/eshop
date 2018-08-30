$(document).ready(function(){
	$('#revoveryForm').submit(function(){
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
		url :ctx+'/message!revoverySave.do',
		async :false,
		type :'post',
		data : 'message.id='+id,
		success:function(returnData){
			if(returnData=='true'){
				alert('回复成功！');
				window.parent.location.reload();
				window.close();
			}else{
				alert('回复失败！');
			}
		},
		error:function(){
			alert('回复失败！');
		}
	};
	$('#revoveryForm').ajaxSubmit(options); 
	return false;
}

// 检查表单
function checkForm(){
	var content =$('#content').val();
	if(content == ''){
		alert('请输入回复内容');
		$('#content').focus();
		return false;
	}
	return true;
}

function backtrack(){
	window.parent.location.reload();
	window.close();
}












