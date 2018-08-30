var contentEditor = '';
$(document).ready(function(){
	contentEditor = CKEDITOR.replace('content', addUploadButton(this));
	$('#advertiseForm').submit(function(){
		submitSaveForm();
		return false; 
	});
	//为图片路径绑定事件
	//$('.picPath').bind({
	//	oninput:function(event){
	//	alert('进来了');
	//		var obj = event.target;		
	//		alert('ddddd');	
	//		showPic(obj);
	//	}
	//});
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

//上传图片
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

//检查表单
function checkForm(){
	var subjectVal = $("#subject").val();
	if(subjectVal == ''){
		alert('请输入主题!');
		$("#subject").focus();
		return false;
	}
	var creatorNameVal = $("#creatorName").val();
	if(creatorNameVal == ''){
		alert('请输入创建人!');
		 $("#creatorName").focus();
		return false;
	}
	var creatorNameVal = $("#contentHtml").val();
	if(creatorNameVal == ''){
		alert('请输入广告详情!');
		 $("#contentHtml").focus();
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
	if(checkForm()){
	
	//获取图片id
	var appIds = [];
	//产品详情
	var content = $('#content');//textarea对象
	var contentHtml = contentEditor.document.getBody().getHtml();
	content.val(contentHtml);
	
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

	var options = {
		url : ctx+'/advertise!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('保存成功!');
				window.parent.addTab('广告列表',ctx+'/advertise!list.do');
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#advertiseForm').ajaxSubmit(options); 
	return false;
	}
}


//选择广告类型
function selectAdvertise(values){
	if(values=='商品父类频道广告'){
		$('#ad').show();
	}else{
		$('#ad').hide();
	}
}

//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaId').val(area.id);
		$('#areaName').val(area.name);
	}
}



