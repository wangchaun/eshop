var contentEditor = '';
$(document).ready(function(){
	contentEditor = CKEDITOR.replace('content', addUploadButton(this));
	$('#greetingCardForm').submit(function(){
		submitSaveForm();
		return false; 
	});
});

//上传flash
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

   var url = ctx+"/FileUpload!edit.do?appType=GreetingCard";
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
	var nameVal = $("#name").val();
	if(nameVal == ''){
		alert('请输入贺卡名字!');
		$("#name").focus();
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
		alert('请输入贺卡内容!');
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

	if(!checkForm()){
		return false;
	}
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
		url : ctx+'/greetingCard!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('保存成功!');
				window.parent.addTab('贺卡列表',ctx+'/greetingCard!list.do');
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#greetingCardForm').ajaxSubmit(options); 
	return false;
}

//选择客户
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
	}
}







