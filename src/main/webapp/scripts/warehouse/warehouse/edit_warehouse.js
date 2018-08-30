$(document).ready(function(){
	$('#saveForm').submit(function(){
		submitForm();
	});
});

function submitForm(){
   
	if(!checkForm()){
		return;
	}
	var options = {
			url :ctx+'/warehouse!save.do',
			async :false,
			type :'post',
			success:function(returnData){
				if(returnData=='true'){
					alert('保存成功');
					window.parent.location.reload();
					window.close();
				}else{
					alert('保存失败');
				}
			},
			error:function(){
				alert('保存失败');
			}
		};
		$('#saveForm').ajaxSubmit(options); 
		return false;
}

//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaIds').val(area.id);
		$('#areaNames').val(area.name);
	}
}

//检查表单
function checkForm(){
	var nameObj = $("#name");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"

	if(''==nameObj.val()){
		alert('请输入仓库名称！');
		nameObj.focus();
		return false;
	}

	return true;
}

