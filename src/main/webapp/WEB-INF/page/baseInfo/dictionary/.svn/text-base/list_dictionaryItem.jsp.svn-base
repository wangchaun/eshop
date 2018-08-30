<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>数据字典</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/baseInfo/dictionary/list_dictionaryItem.js"></script>

</head> 

<body>
	<input type="hidden"  id="baseinfoInserts" value="${userpowermap['inserts_baseinfo']}" />
	<input type="hidden"  id="baseinfoDeletes" value="${userpowermap['deletes_baseinfo']}" />
	<input type="hidden"  id="baseinfoSelects" value="${userpowermap['selects_baseinfo']}" />
	<input type="hidden"  id="baseinfoUpdates" value="${userpowermap['updates_baseinfo']}" />
	<s:hidden name="dictionary.id" id="dictionaryId"/>
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>编号：</td>
				<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>值：</td>
				<td class='gridbody'><input type="text" id="name" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="300px" height="150px"></iframe>
	</div>
</body>

</html>