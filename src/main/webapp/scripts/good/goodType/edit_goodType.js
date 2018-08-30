var contentEditor = '';
$(document).ready(function(){
    contentEditor = CKEDITOR.replace('remark', addUploadButton(this));
	$('#goodTypeForm').submit(function(){
		submitForm();
		return false;
	});
	
	
		//为图片路径绑定事件
	//$('.picPath').bind({
	//	propertychange:function(event){
	//		var obj = event.currentTarget;
	//		showPic(obj);
	//	}
	//});
	
});

function submitForm(){
    //获取图片id
	var appIds = [];
	//备注详情
	var remark = $('#remark');//textarea对象
	var contentHtml = contentEditor.document.getBody().getHtml();
	remark.val(contentHtml);
	totalHtml = contentHtml ;
	var htmlObj = $(totalHtml).find('img');
		$(htmlObj).each(function(){
			var imgSrc = this.src;
			var lastIndex1 = imgSrc.lastIndexOf('.');
			var lastIndex2 = imgSrc.lastIndexOf('/');
			var appId = imgSrc.substring((lastIndex2+1),lastIndex1);
			appIds.push(appId);
		});
		var imgIdStr = appIds.join(',');
		$('#imgIdStr').val(imgIdStr);
		
	var parentId = $('parentId').val();
	var options = {
			url :ctx+'/goodType!save.do',
			async :false,
			type :'post',
			data : 'goodType.parentId='+parentId,
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
		$('#goodTypeForm').ajaxSubmit(options); 
		return false;
}
function saveGoodsType(){
	if(checkForm()){
		submitForm();
	}
}
//检查表单
function checkForm(){
	var nameObj = $("#typeName");
	var deliveryObj= $("#deliveryName");
	if(''==nameObj.val()){
		alert('请输入商品类别名称！');
		nameObj.focus();
		return false;
	}
	if(''==deliveryObj.val()){
		alert('请选择配送方式！');
		deliveryObj.focus();
		return false;
	}
	return true;
}
//检查编号是否存在
function isCodeExist(){
	var code = $('#code').val();
	$.ajax( {
		url:ctx+'/goodType!checkCode.do',
		async:false,
		type:"post",
		data:'goodType.code='+code,
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
		$(obj).siblings("#fileUploadId").val('');
	}
	$(obj).remove();
}

//选择支付方式
function getpayment(){
	url = ctx +'/payment!list.do?todo=show';
	var returnVal =window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:400px");
	var paymentId=""; 
	var paymentName="";
	for(i=0;i<returnVal.length;i++){
		paymentId+=returnVal[i].id+",";
		paymentName+=returnVal[i].name+",";
	}
	$('#paymentId').val(paymentId);
	$('#paymentName').val(paymentName);
}


//选择配送方式
function getdelivery(){
	url = ctx +'/delivery!list.do?todo=show';
	var returnVal =window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:400px");
	var deliveryId=""; 
	var deliveryName="";
	for(i=0;i<returnVal.length;i++){
		deliveryId+=returnVal[i].id+",";
		deliveryName+=returnVal[i].name+",";
	}
	$('#deliveryId').val(deliveryId);
	$('#deliveryName').val(deliveryName);
}

//清空支付或配送
function qktext(obj){
	$('#'+obj+"Id").val('');
	$('#'+obj+"Name").val('');		
}
//上传图片hqf
function addUploadButton(editor){
   CKEDITOR.on('dialogDefinition', function(ev){
       var dialogName = ev.data.name;
       var dialogDefinition = ev.data.definition;
       if ( dialogName == 'image' ){
           var infoTab = dialogDefinition.getContents('info');
           infoTab.add({
               type : 'button',
               id : 'upload_image',
               align : 'center',
               label : '上传',
               onClick : function(evt){
                   var thisDialog = this.getDialog();
                   var txtUrlObj = thisDialog.getContentElement('info', 'txtUrl');
                   var txtUrlId = txtUrlObj.getInputElement().$.id;
                   addUploadImage(txtUrlId);
               }
           }, 'browse'); //place front of the browser button
       }
   });
}
function addUploadImage(theURLElementId){
   var url = ctx+"/FileUpload!edit.do?appType=Advertise";
   var relativeUrl = window.showModalDialog(url);  //这是我自己的处理文件/图片上传的页面URL
   //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
   //更多window.showModalDialog的使用方法参考
   var urlObj = document.getElementById(theURLElementId);
   if(relativeUrl){
   		urlObj.value = ctx+relativeUrl;
   }
   urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
}

