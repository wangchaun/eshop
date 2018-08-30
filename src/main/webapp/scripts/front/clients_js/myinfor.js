

$(document).ready(function(){
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
		$(obj).siblings("#fileUploadId").val('');
	}
	$(obj).remove();
}


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
   var url = ctx+"/FileUpload!edit.do?appType=GoodExtend";
   var relativeUrl = window.showModalDialog(url);  //这是我自己的处理文件/图片上传的页面URL
   //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
   //更多window.showModalDialog的使用方法参考
   var urlObj = document.getElementById(theURLElementId);
   if(relativeUrl){
   		urlObj.value = ctx+relativeUrl;
   }
   urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
}

    //保存头像  
    function saveHeadImg(){
    	var fileUploadId=$('#fileUploadId').val();
    	var picPath=$('#picPath').val();
    	if(fileUploadId != '' && picPath != ''){
			if (confirm("您确定要保存此头像吗?")){
				$.ajax({
				  type: "POST",
				  async: false,
				  cache: false,
				  url: ctx+"/saveHeadImg.do?picId="+fileUploadId+"&pic="+picPath,
				  success : function(returnDatas){
						if(returnDatas == 'true'){
							alert("保存成功！");
							$('#xgtx_td').hide();
							$('#xgtx_td1').hide();
							window.location.reload();
						}else if(returnDatas=='false'){
							alert("保存失败！");
						}
					},
					error : function(){
						alert('系统有误');
				 	} 
				});
			}
		}
     }
































