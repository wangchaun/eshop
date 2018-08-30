<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>供应商列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	
	<script type="text/javascript" src="${ctx }/scripts/baseInfo/supplier/list_supplier.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head> 

<body>
	<input type="hidden"  id="baseinfoInserts" value="${userpowermap['inserts_baseinfo']}" />
	<input type="hidden"  id="baseinfoDeletes" value="${userpowermap['deletes_baseinfo']}" />
	<input type="hidden"  id="baseinfoSelects" value="${userpowermap['selects_baseinfo']}" />
	<input type="hidden"  id="baseinfoUpdates" value="${userpowermap['updates_baseinfo']}" />
		<div style="margin-top: 10px; margin-bottom: 5px;">
			<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="95%" style="font-size: 12px;">
				<tr>
					<td class='gridtitle'>供应商名称：</td>
					<td class='gridbody'><input type="text" id="supplierName" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>联系人：</td>
					<td class='gridbody'><input type="text" id="linkMan" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>手机：</td>
					<td class='gridbody'><input type="text" id="mobile" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>电话：</td>
					<td class='gridbody'><input type="text" id="telphone" onkeydown="checkKey()"/></td>
					<td class='gridtitle'>
						<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
		  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
					</td>
				</tr>
			</table>
		</div>
	
	<table id="dataGrid"></table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="600px" height="300px"></iframe>
	</div>
</body>
</html>