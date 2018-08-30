$(document).ready(function(){
	$('#goodBrandForm').submit(function(){
		submitForm();
	});
	//为图片路径绑定事件
	$('.picPath').bind({
		propertychange:function(event){
			var obj = event.currentTarget;
			if($(obj).val() != ''){
				showPic(obj);
			}
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
	$(parent).append('<img id="pic" border="0" src="'+ctx+picPath+'" width="150px" height="150px"/> &nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">Remove</a>');
}
//删除图片
function deletePic(obj){
	var pic = $(obj).siblings("img[id='pic']");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
		//清空id
		$(obj).siblings("#picId").val('');
		$(obj).siblings("#picPath").val('');
	}
	$(obj).remove();
}

function submitForm(){
	var parentId = $('parentId').val();
	var options = {
			url :ctx+'/groupGoodBrand!save.do',
			async :false,
			type :'post',
			data : 'goodBrand.parentId='+parentId,
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
		$('#goodBrandForm').ajaxSubmit(options); 
		return false;
}
function saveGoodsType(){
	if(checkForm()){
		submitForm();
	}
}
//检查表单
function checkForm(){
	var nameObj = $("#brandName");
	if(''==nameObj.val()){
		alert('请输入商品品牌名称！');
		nameObj.focus();
		return false;
	}
	return true;
}
//检查编号是否存在
function isCodeExist(){
	var code = $('#code').val();
	$.ajax( {
		url:ctx+'/groupGoodBrand!checkCode.do',
		async:false,
		type:"post",
		data:'goodBrand.code='+code,
		success:function(returnData){
			if(returnData == 'false'){
				alert('编号已存在，请输入其他的编号');
				$('#code').val('');
				$('#code').focus();
			}
		},
		error:function(){
			alert('系统错误');
		}
	});
}

