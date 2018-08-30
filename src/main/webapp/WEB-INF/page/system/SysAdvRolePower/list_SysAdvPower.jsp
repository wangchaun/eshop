<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>组织架构</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/system/SysAdvPower/list_SysAdvPower.js"></script>

</head> 

<body>
	<!-- 最大级别 -->
	<input id="maxLevel" type="hidden" name="maxLevel" value="${maxLevel }">
	<table width="700" id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="450px" height="300px"></iframe>
	</div>		
	
</body>

</html>