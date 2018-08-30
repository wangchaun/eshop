var uploadDivHtml;//上传弹出框区html
$(document).ready(function(){
	uploadDivHtml = '<div id="uploadDiv">'
		 + '<iframe frameborder="0" id="uploadFrame" name="uploadFrame" width="400px" height="200px"></iframe>'
		 + '</div>';
	$('body').append(uploadDivHtml);
});

//上传
var upload = {  
	fileUploadIdObj:'',
	picPathObj:'',
	open:function(obj,appType){ 
		var hrefObj = $(obj);
		var fileUploadIdObj = hrefObj.siblings('input[id=fileUploadId]')[0];
		var picPathObj = hrefObj.siblings('input[id=picPath]')[0];
		this.fileUploadIdObj = $(fileUploadIdObj);
		this.picPathObj = $(picPathObj);         
	    var url = ctx + '/frontedit.do?1=1';
	    if(appType){  
	    	url += '&appType='+appType;
	    }
	  
	    window.frames["uploadFrame"].document.body.innerText = "";

		     //弹出框
		$('#uploadDiv').dialog({  
			title:"上传文件",
			iconCls:'icon-edit',
			closed:true,
		    modal:true,
		    draggable:true,
		    minimizable:false,
		    maximizable:false,
		    resizable:false
		});
	    $('#uploadDiv').window('open');//弹出框
	    $('#uploadFrame').attr('src',url);
	},
	close:function(fileUploadId,picPath){  
		if(fileUploadId && ''!=fileUploadId){
			this.fileUploadIdObj.val(fileUploadId);
		}  
		if(picPath && ''!=picPath){
			this.picPathObj.val(picPath);
		}
		$('#picimg').html('');
		$('#picimg2').html('');
		$('#picimg').append('<img id="pic" border="0" src="'+ctx+picPath+'" width="130px" height="130px"/> &nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>');
		$('#picimg2').append('<img id="pic" border="0" src="'+ctx+picPath+'" width="130px" height="130px"/>');
		$('#uploadDiv').window('close');
	}
};
