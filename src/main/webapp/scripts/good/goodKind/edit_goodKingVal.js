
var contentEditor = '';

$(document).ready(function(){
	contentEditor = CKEDITOR.replace('remark', addUploadButton(this));
	$('#saveForm').submit(function(){
		submitForm();
		return false;
	});
});

function submitForm(){
	if(checkForm()){
	var content = $('#remark');//textarea对象
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
		
		var options = {
			url :ctx+'/goodKingVal!save.do',
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
	}
	$('#saveForm').ajaxSubmit(options); 
	return false;
}

//检查表单
function checkForm(){
	var valueObj = $("#value");
	var codeExp = "^[a-zA-Z0-9_]{1,}$"
	var sortObj = $('#sort');
	
	if(''==valueObj.val()){
		alert('请输入值名称！');
		valueObj.focus();
		return false;
	}
//	if(''==sortObj.val()){
//		alert('请填写序号！');
//		sortObj.focus();
//		return false;
//	}
//	if(isNaN(sortObj.val())){
//		alert('序号只能是数字！');
//		sortObj.focus();
//		return false;
//	}
	return true;
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
