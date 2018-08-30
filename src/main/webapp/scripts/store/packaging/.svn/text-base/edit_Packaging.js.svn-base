$(document).ready(function(){
	$('#packagingForm').submit(function(){
		submitSaveForm();
		return false; 
	});
	//为图片路径绑定事件
	$('.picPath').bind({
		propertychange:function(event){
			var obj = event.currentTarget;
			showPic(obj);
		}
	});
});

//显示图片
function showPic(obj){

	var picPath = $(obj).val();
	var parent = $(obj).parent();
	//父类的同辈元素
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
	}
	$(parent).append('<img id="pic" border="0" src="'+ctx+picPath+'" width="130px" height="130px"/> &nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>');
}
//删除图片
function deletePic(obj){
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
	}
	$(obj).remove();
}

//检查表单
function checkForm(){
	var subjectVal = $("#name").val();
	if(subjectVal == ''){
		alert('请输入商品包装名称!');
		$("#name").focus();
		return false;
	}
	var creatorNameVal = $("#packagingFee").val();
	if(creatorNameVal == ''){
		alert('请输入包装费用!');
		 $("#packagingFee").focus();
		return false;
	}
	var creatorNameVal = $("#minForFree").val();
	if(creatorNameVal == ''){
		alert('请输入免费额度!');
		 $("#minForFree").focus();
		return false;
	}
	return true;
}
//审核
function adconform(){
	$("#state").val('s');
	submitSaveForm();
}

//提交表单
function submitSaveForm(){
	if(!checkForm()){
		return false;
	}
	var options = {
		url : ctx+'/packaging!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('保存成功!');
				window.parent.addTab('商品包装列表',ctx+'/packaging!list.do');
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#packagingForm').ajaxSubmit(options); 
	return false;
}








