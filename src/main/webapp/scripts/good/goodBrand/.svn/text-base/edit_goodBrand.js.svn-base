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
	var id = $('#id').val(); 
//	if(id == '' || id == null){
		document.getElementById("selected1").disabled=true;
		document.getElementById("selected2").disabled=true;
//	}
	
});

function selectShowType(values){
	if(values == '首页品牌展示'){
		document.getElementById("selected1").disabled=false;
		document.getElementById("selected2").disabled=false;
	}else{
		document.getElementById("selected1").disabled=true;
		document.getElementById("selected2").disabled=true;
		document.getElementById("selected1").checked=false;
		document.getElementById("selected2").checked=false;
	}
}

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
	var select = getRadioValue();
	var url=ctx+"/goodBrand!save.do?goodBrand.isSele="+select;
	var options = {
			url :url,
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
		url:ctx+'/goodBrand!checkCode.do',
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

//获取单选框选中的value
function getRadioValue(){

var radioes = document.getElementsByName('Selected');
for(var i=0;i<radioes.length;i++)

{
     if(radioes[i].checked){

      return radioes[i].value;

     }

}

return false;

}
