<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>仓库</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/warehouse/warehouse/list_warehouseWare.js"></script>
</head> 

<body>
	<s:hidden name="warehouseWare.warehouseId" id="warehouseId"/>
	<div style="margin-top: 10px; margin-bottom: 5px;margin-left: 10px">
		<table id="search" border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>仓库编号：</td>
				<td class='gridbody'><input type="text" id="wareCode" onkeydown="checkKey()" size="10"/></td>
				<td class='gridtitle'>仓库名称：</td>
				<td class='gridbody'><input type="text" id="warehouseName" onkeydown="checkKey()" size="10"/></td>
				<td class='gridtitle'>货物名称：</td>
				<td class='gridbody'><input type="text" id="wareName" onkeydown="checkKey()" size="10"/></td>
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