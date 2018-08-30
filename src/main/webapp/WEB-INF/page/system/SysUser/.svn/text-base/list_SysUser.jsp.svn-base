﻿<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>User Information</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/system/SysUser/list_SysUser.js"></script>

</head> 

<body>
	<input type="hidden"  id="systemInserts" value="${userpowermap['inserts_system']}" />
	<input type="hidden"  id="systemDeletes" value="${userpowermap['deletes_system']}" />
	<input type="hidden"  id="systemSelects" value="${userpowermap['selects_system']}" />
	<input type="hidden"  id="systemUpdates" value="${userpowermap['updates_system']}" />
	<s:hidden name="sysUser.roleCode" id="roleCode"></s:hidden>
	<table id="dataGrid"></table>
	
	<div id="edit">
		<iframe frameborder="0" id="editDataPage" width="600px" height="200px"></iframe>
	</div>
	<div id="search">
		<table border="0" cellpadding="0" cellspacing="0" width="240px" height="60px" style="font-size: 12px;">
			<tr>
				<td>用户编号：</td>
				<td><input type="text" id="userCode" onkeydown="checkKey()"/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="userName" onkeydown="checkKey()"/></td>
			</tr>
			<tr>
				<td>部门：</td>
				<td><input type="text" id="deptName" onkeydown="checkKey()"/></td>
			</tr>
		</table>
	</div>
</body>

</html>