<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>调度单</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/warehouse/warehouseMove/list_warehouseMove.js"></script>
</head> 

<body>
	<input type="hidden"  id="warehouseInserts" value="${userpowermap['inserts_warehouse']}" />
	<input type="hidden"  id="warehouseDeletes" value="${userpowermap['deletes_warehouse']}" />
	<input type="hidden"  id="warehouseSelects" value="${userpowermap['selects_warehouse']}" />
	<input type="hidden"  id="warehouseUpdates" value="${userpowermap['updates_warehouse']}" />
	<div style="margin-top: 10px; margin-bottom: 5px;margin-left: 10px">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>编号：</td>
				<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>发货仓库：</td>
				<td class='gridbody'><input type="text" id="fwarehouseName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>收货仓库：</td>
				<td class='gridbody'><input type="text" id="swarehouseName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
</body>

</html>