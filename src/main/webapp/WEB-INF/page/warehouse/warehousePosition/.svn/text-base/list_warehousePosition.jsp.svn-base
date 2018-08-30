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
	<script type="text/javascript" src="${ctx }/scripts/warehouse/warehousePosition/list_warehousePosition.js"></script>

</head> 

<body>
	<input type="hidden"  id="warehouseInserts" value="${userpowermap['inserts_warehouse']}" />
	<input type="hidden"  id="warehouseDeletes" value="${userpowermap['deletes_warehouse']}" />
	<input type="hidden"  id="warehouseSelects" value="${userpowermap['selects_warehouse']}" />
	<input type="hidden"  id="warehouseUpdates" value="${userpowermap['updates_warehouse']}" />
	<s:hidden name="warehouseId" id="warehouseId"/><!-- 仓库的id -->
	<table id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="300px" height="150px"></iframe>
	</div>
	
	<div id="list" closed="true">
		<iframe frameborder="0" id="listDataPage" width="720px" height="400px"></iframe>
	</div>
</body>

</html>