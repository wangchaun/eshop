<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>客户列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/customer/list_customer.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
</head> 

<body>
	<s:hidden name="loginManRole" id="loginManRole"></s:hidden><!-- 登陆人角色 -->
	<s:hidden name="type" id="type"></s:hidden>
	<input type="hidden"  id="customerInserts" value="${userpowermap['inserts_customer']}" />
	<input type="hidden"  id="customerDeletes" value="${userpowermap['deletes_customer']}" />
	<input type="hidden"  id="customerSelects" value="${userpowermap['selects_customer']}" />
	<input type="hidden"  id="customerUpdates" value="${userpowermap['updates_customer']}" />
	<s:hidden name="customer.vipLevelId" id="vipLevelId"></s:hidden>
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>会员编号：</td>
				<td class='gridbody'><input type="text" id="customerCode" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>会员名称：</td>
				<td class='gridbody'><input type="text" id="customerName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>联系人：</td>
				<td class='gridbody'><input type="text" id="linkman" onkeydown="checkKey()"/></td>
				<td class='gridtitle' rowspan="2">
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
			<tr>
				<td class='gridtitle'>电话：</td>
				<td class='gridbody'><input type="text" id="telephone" onkeydown="checkKey()" onchange="common.checkIsTelephone(this);"/></td>
				<td class='gridtitle'>手机：</td>
				<td class='gridbody'><input type="text" id="mobile" onkeydown="checkKey()" onchange="common.checkIsMobile(this);"/></td>
				<td class='gridtitle'>公司：</td>
				<td class='gridbody'><input type="text" id="companyName" onkeydown="checkKey()"/></td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	<div id="edit">
		<iframe frameborder="0" id="editDataPage" width="700px" height="400px"></iframe>
	</div>
</body>

</html>