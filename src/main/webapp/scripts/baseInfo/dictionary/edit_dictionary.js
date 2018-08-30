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
			url :ctx+'/Dictionary!save.do',
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

//删除数据字典
function deleteDictionary(id){
	if(confirm('您确定要删除吗？')){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/Dictionary!delete.do",
		  data: "dictionary.id=" + id,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功');
					window.location.href = ctx+"/Dictionary!list.action";
				}else{
					alert('删除失败');
				}
			},
			error : function(){
				alert('删除失败');
		 	} 
		});
	}
}

//检查表单
function checkForm(){
	var codeObj = $("#code");
	var nameObj = $("#name");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var sortObj = $('#sort');
	
	if(''==codeObj.val()){
		alert('请输入字典编号！');
		codeObj.focus();
		return false;
	}
	if(!codeObj.val().match(codeExp)){
		alert('字典编号只能输入字母、数字或下划线！');
		codeObj.focus();
		return false;
	}
	if(''==nameObj.val()){
		alert('请输入数据字典名称！');
		nameObj.focus();
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

//根据编号，判断数据字段是否已存在
function isCodeExisted(){
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
			  url: ctx+"/Dictionary!isCodeExisted.do",
			  data: "dictionary.id="+id +"&dictionary.code=" + code,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('校验字典编号失败!');
					flag = true;
			 	} 
		});
	}
	return flag;
}

//编号检查
function codeCheck(){
	if(isCodeExisted()){
		alert("该字典编号已经存在!");
		$("#code").val('');
		$("#code").focus();
	}
}
