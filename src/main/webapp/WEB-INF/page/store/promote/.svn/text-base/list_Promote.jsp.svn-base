<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>促销专题列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/store/promote/list_Promote.js"></script>

</head> 

<body>
	<input type="hidden"  id="buyInserts" value="${userpowermap['inserts_buy']}" />
	<input type="hidden"  id="buyDeletes" value="${userpowermap['deletes_buy']}" />
	<input type="hidden"  id="buySelects" value="${userpowermap['selects_buy']}" />
	<input type="hidden"  id="buyUpdates" value="${userpowermap['updates_buy']}" />
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>编号：</td>
				<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>专题主题：</td>
				<td class='gridbody'><input type="text" id="subject" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>所属商品类别</td>
				<td class='gridbody' colspan="10">
					<s:textfield id="goodTypeName" onclick="selectType()"/>
					<s:hidden id="goodTypeId" />
				</td>
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