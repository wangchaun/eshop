<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>仓位</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/warehouse/warehousePosition/show_warehousePosition.js"></script>

</head> 

<body>
	<s:hidden name="warehousePosition.warehouseId" id="warehouseId"/><!-- 仓库的id -->
	<s:hidden name="warehousePosition.wareId" id="wareId"/><!-- 货物的id -->
	<table id="dataGrid"></table>
</body>

</html>