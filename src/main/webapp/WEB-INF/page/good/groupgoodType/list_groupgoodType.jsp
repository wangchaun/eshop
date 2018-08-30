<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>组织架构</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	
	<script type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/good/goodType/list_goodType.js"></script>
</head> 

<body>
	<input type="hidden"  id="goodInserts" value="${userpowermap['inserts_good']}" />
	<input type="hidden"  id="goodDeletes" value="${userpowermap['deletes_good']}" />
	<input type="hidden"  id="goodSelects" value="${userpowermap['selects_good']}" />
	<input type="hidden"  id="goodUpdates" value="${userpowermap['updates_good']}" />
    <input type="hidden" id="IsInventory" value="${goodType.isInventory }"/>

	<!-- 最大级别 -->
	<input id="maxLevel" type="hidden" name="maxLevel" value="${maxLevel }">
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>类别编号：</td>
				<td class='gridbody'><input type="text" id="goodCode" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>类别名称：</td>
				<td class='gridbody'><input type="text" id="goodName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="550px" height="300px"></iframe>
	</div>
	<div id="search" closed="true">
		<iframe frameborder="0" id="getType" width="650px" height="300px"></iframe>
	</div>	
</body>

</html>