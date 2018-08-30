var contentEditor = '';
$(document).ready(function(){
	contentEditor = CKEDITOR.replace('instruction', addUploadButton(this));
	$('#magazineForm').submit(function(){
		submitSaveForm();
		return false; 
	});
});


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
   var url = ctx+"/FileUpload!edit.do?appType=magazinePic";
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
	var titleVal = $("#title").val();
	if(titleVal == ''){
		alert('请输入杂志标题!');
		$("#title").focus();
		return false;
	}
	var creatorNameVal = $("#creatorName").val();
	if(creatorNameVal == ''){
		alert('请输入杂志创建人!');
		 $("#creatorName").focus();
		return false;
	}

	var creatorNameVal = $("#picPath").val();
	if(creatorNameVal == ''){
		alert('请输选择上传文件!');
		 $("#picPath").focus();
		return false;
	}
	return true;
	
}
function adconform(){
	$("#state").val('s');
	submitSaveForm();
}

//提交表单
function submitSaveForm(){
	if(!checkForm()){
		return false;
	}
	//获取图片id
	var appIds = [];
	//产品详情
	var content = $('#instruction');//textarea对象
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
		url : ctx+'/magazine!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('保存成功!');
				window.parent.addTab('杂志列表',ctx+'/magazine!list.do');
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#magazineForm').ajaxSubmit(options); 
	return false;
}


