<%@ page contentType="text/html;charset=UTF-8"%>

	
<html>
<head>
	<title>图片预览</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/packaging/edit_Packaging.js"></script>

</head> 

<body>		
	<div style="text-align: center; ">
			<img id="pic" border="0" src="${ctx}${packaging.pic }" width="500px" height="380px"/>
			<input type="hidden" name="packaging.pic" id="picPath"  class="picPath" value="${packaging.pic }" >
		
	</div>
</body>
</html>