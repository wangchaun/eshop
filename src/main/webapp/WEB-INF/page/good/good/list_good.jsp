<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>产品列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<!-- <script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script> -->
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/good/good/list_good.js"></script>

</head> 

<body>
	<input type="hidden"  id="goodInserts" value="${userpowermap['inserts_good']}" />
	<input type="hidden"  id="goodDeletes" value="${userpowermap['deletes_good']}" />
	<input type="hidden"  id="goodSelects" value="${userpowermap['selects_good']}" />
	<input type="hidden"  id="goodUpdates" value="${userpowermap['updates_good']}" />
	<input type="hidden" id="isInventory"  value="${good.isInventory }">
	<input type="hidden" id="state"  value="${good.state}">
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>商品编号：</td>
				<td class='gridbody'><input type="text" id="goodCode" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>商品名称：</td>
				<td class='gridbody'><input type="text" id="goodName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>商品类别：</td>
				<td class='gridbody'><input type="text" id="goodTypeName" onclick="selectType(this)"/></td>
				<td class='gridtitle'>商品类型：</td>
				<td class='gridbody'>
					<select name="goodState" id="goodState">
		                <option value="" <c:if test="${good.isInventory == ''}">selected</c:if> >商品类型</option>
		               	<option value="0" <c:if test="${good.isInventory == 0}">selected</c:if> >普通商品</option>
						<option value="1" <c:if test="${good.isInventory == 1}">selected</c:if> >团购商品</option>
						<option value="2" <c:if test="${good.isInventory == 1}">selected</c:if> >抢购商品</option>
						<option value="3" <c:if test="${good.isInventory == 1}">selected</c:if> >秒杀商品</option>
		            </select>
				</td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="400px" height="200px"></iframe>
	</div>
</body>

</html>