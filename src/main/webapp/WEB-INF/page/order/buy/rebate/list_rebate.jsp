<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>返利列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/order/buy/rebate/list_rebate.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>

</head> 
	<body>
	<input type="hidden"  id="marketInserts" value="${userpowermap['inserts_market']}" />
	<input type="hidden"  id="marketDeletes" value="${userpowermap['deletes_market']}" />
	<input type="hidden"  id="marketSelects" value="${userpowermap['selects_market']}" />
	<input type="hidden"  id="marketUpdates" value="${userpowermap['updates_market']}" />
		<div style="margin-top: 10px; margin-bottom: 5px;">
			<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
				<tr>
					<td class='gridtitle'>返利编号：</td>
					<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>经手人：</td>
					<td class='gridbody'><input type="text" id="handlerName" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>
						<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
		  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
					</td>
				</tr>
			</table>
		</div>
		<table id="dataGrid"></table>
		
		<div id="edit" closed="true">
			<iframe frameborder="0" id="editDataPage" width="600px" height="250px"></iframe>
		</div>
		<div id="list" closed="true">
			<iframe frameborder="0" id="listDataPage" width="700px" height="400px"></iframe>
		</div>
	</body>
</html>