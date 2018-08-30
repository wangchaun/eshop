$(document).ready(function(){
	//添加地区信息表单提交
	$('#areaForm').submit(function(){
		submitForm();
	});
});
function submitForm(){
	var nameObj = $("#areaName");
	
	if(''==nameObj.val()){
		alert('请输入地区名称！');
		nameObj.focus();
		return false;
	}
//	if(!isCodeExisted()){
//		alert('此地区已经存在，请重新输入！');
//		$("#areaName").val('');
//		return false;
//	}
	var parentId = $('parentId').val();
	var options = {
		url : ctx+'/area!save.do',
		async : false,
		type : 'post',
		data : 'area.parentId='+parentId,
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
	$('#areaForm').ajaxSubmit(options);
	return false;
}
function saveArea(){
	if(checkForm()){
		submitForm();
	}
}
//根据名称验证地区
function checkAreaName(value){
	if(value!=''){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/area!checkAreaName.do?1=1",
		  data: '&area.name='+value,
		  success : function(returnData){ 
				if(returnData == 'false'){
					alert('此地区已经存在，请重新输入!');
					$("#areaName").val('');
					return false;
				}
			},
			error : function(){
				alert('系统错误!');
		 	} 
		});
	}
}


//删除地区信息
function deleteAreaInfo(id,level){
	if(confirm('你确定要删除吗?')){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/area!delete.do",
		  data: "area.id="+ id+'&area.level='+level,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功!');
					window.location.href = ctx+"/area!list.do";
				}else{
					alert('删除失败!');
				}
			},
			error : function(){
				alert('删除失败!');
		 	} 
		});
	}
}
//地区信息编辑弹出窗
function editPage(typeId,parentId,level){
	$('#editDataPage').attr('src','area!edit.do?area.id='+typeId+'&parentId='+parentId+'&level='+level);
	$('#edit').window('open');
}
//检查表单
function checkForm(){
	var codeObj = $("#areaCode");
	var nameObj = $("#areaName");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	
	if(''==codeObj.val()){
		alert('请输入编号！');
		codeObj.focus();
		return false;
	}
	if(!codeObj.val().match(codeExp)){
		alert('编号只能输入字母、数字或下划线!');
		codeObj.focus();
		return false;
	}
	if(''==nameObj.val()){
		alert('请输入地区名称！');
		nameObj.focus();
		return false;
	}
//	if(''==$('#id').val()){
//		if(isCodeExisted()){
//			alert("Number already exists in the region! Please use another number");
//			codeObj.focus();
//			return false;
//		}
//	}
	return true;
}

//根据编号，判断地区信息是否已存在
function isCodeExisted(){
	var flag = true;
	var id = $("#id").val(); 
	var code = $("#areaName").val();  alert(code);
	if(''==code){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/area!isCodeExisted.do1=1",
			  data: "&area.id="+id +"&area.name=" + code,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('系统错误!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}


//编号检查
function codeCheck(){
	if(isCodeExisted()){
		alert("Number already exists in the region！");
		$("#code").focus();
	}
}
