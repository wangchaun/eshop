<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>促销栏位列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/store/promotecolumn/list_Promotecolumn.js"></script>

</head> 

<body>
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<input type="hidden" name="loginUser.roleName" id="loginname" value="${loginUser.roleName}"/>
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>编号：</td>
				<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>促销栏位名称：</td>
				<td class='gridbody'><input type="text" id="name" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	<div id="edit">
		<iframe frameborder="0" id="editDataPage" width="700px" height="250px"></iframe>
	</div>
	
</body>

</html>