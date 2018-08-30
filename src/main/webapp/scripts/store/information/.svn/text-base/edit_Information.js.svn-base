var contentEditor = '';
$(document).ready(function(){
	contentEditor = CKEDITOR.replace('content', addUploadButton(this));
	$('#informationForm').submit(function(){
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
   var url = ctx+"/FileUpload!edit.do?appType=Information";
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
		alert('请输入标题!');
		$("#title").focus();
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
		alert('请输入详情!');
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
//	var regulationType = $('#regulationType').val();
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
	
	var type = $('#type').val();
		var title = '';
		if(type == '0'){
			title = '公告管理';
		}else if(type == '1'){
			title = '新闻管理';
		}else if(type == '2'){
			title = '购物资讯';
		}else if(type == '3'){
			title = '新手上路';
		}else if(type == '4'){
			title = '付款方式';
		}else if(type == '5'){
			title = '会员服务';
		}else if(type == '6'){
			title = '帮助中心';
		}else if(type == '7'){
			title = '消费者保障';
		}else if(type == '8'){
			title = '下部导航';
		}else if(type == '9'){
			title = '规则设置';
		}
		
	var options = {
		url : ctx+'/information!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('保存成功!');
				window.parent.addTab(title,ctx+'/information!list.do?information.type='+type);
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#informationForm').ajaxSubmit(options); 
	return false;
}


//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaId').val(area.id);
		$('#areaName').val(area.name);
	}
}





