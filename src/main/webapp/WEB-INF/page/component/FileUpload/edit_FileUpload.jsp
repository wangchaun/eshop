<%@ page contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<title>文件上传</title>
		<%@ include file="/commons/taglibs.jsp"%>
		<%@ include file="/commons/meta.jsp" %>
		
		<link href="${ctx}/scripts/framework/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
		<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	
		<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
		<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
		<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
		<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
		<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
		<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
		<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/jquery.uploadify.v2.1.4.min.js"></script>



	
		<script type="text/javascript">
			$(function() {
				var appType = $('#appType').val();
				var url = ctx + '/FileUpload!save.do?appType='+appType;
				var fileDesc = '';
				var fileExt = '';
				if(appType == 'magazine'){
					fileDesc = '支持格式：doc/docx/pdf/rar/zip/txt.';
					fileExt = '*.doc;*.docx;*.pdf;*.rar;*.zip;*.txt';
				}else{
					fileDesc = '支持格式:jpg/gif/jpeg/png/bmp.';
					fileExt = '*.jpg;*.gif;*.jpeg;*.png;*.bmp';
				}
				$("#fileupload").uploadify({
					'uploader'       : ctx + '/scripts/framework/uploadify/uploadify.swf',
					'script'         : url,											//servlet的路径或者.jsp 
					'cancelImg'      : ctx + '/scripts/framework/uploadify/cancel.png',
					'fileDataName' 	: 'fileupload',									//必须
					'queueID'        : 'fileQueue',
					'auto'           : false, 										//选定文件后是否自动上传，默认false
					'multi'          : false, 										//是否允许同时上传多文件，默认false
					'simUploadLimit' : 1, 											//一次同步上传的文件数目  
					'sizeLimit'      : 2000000, 									//设置单个文件大小限制，单位为byte  
					'queueSizeLimit' : 5, 											//限制在一次队列中的次数（可选定几个文件）。默认值= 999，而一次可传几个文件有 simUploadLimit属性决定。
					'fileDesc'       : fileDesc, 									//如果配置了以下的'fileExt'属性，那么这个属性是必须的  
					'fileExt'        : fileExt,										//允许的格式
					onComplete: function (event, queueID, fileObj, response, data) {
						var arrTemp = response.split(',');
					 	var idStr = arrTemp[0];
					 	var picPath = arrTemp[1];
					 	if('false'==idStr){
					 		idStr = '';
					 		alert("文件:" + fileObj.name + "上传失败");
					 	}else{
					 		alert("文件:" + fileObj.name + "上传成功");
					 		
					 		if('Good'== appType || 'GoodAlbum' == appType || 'magazine' == appType || 'Packaging' == appType || 'Promote' == appType || 'promotionActivity'==appType || 'gift'==appType || 'AdvertisePic'==appType ||'goodType' ==appType ||'GoodBrand'==appType || 'User'==appType || 'costomer'==appType || 'Ware' == appType){
								parent.upload.close(idStr,picPath);
							}else if('GoodExtend' == appType || 'Advertise' == appType || 'magazinePic' == appType || 'Information' == appType|| 'GreetingCard' == appType|| 'promotePic' == appType || 'promotionActivityPic' == appType || 'StoreSet' == appType || 'giftPic' == appType ){
								window.returnValue = picPath;
								window.close();
							}
					 	}
					},  
					onError: function(event, queueID, fileObj) {
						alert("文件:" + fileObj.name + "上传失败");
					},  
					onCancel: function(event, queueID, fileObj){
						//alert("取消了" + fileObj.name);  
					} 
				});	  
			 
			});
		</script>
	</head>

	<body>
		<s:hidden name="appType" id="appType" />
		<div id="aaa" align="center">
			<div id="fileQueue"></div>
			<input id="fileupload" name="fileupload" type="file" />
			<p>
				<a href="javascript:$('#fileupload').uploadifyUpload()">开始上传</a>&nbsp;
				<a href="javascript:$('#fileupload').uploadifyClearQueue()">取消所有上传</a>
			</p>		
		</div>
	</body>
</html>