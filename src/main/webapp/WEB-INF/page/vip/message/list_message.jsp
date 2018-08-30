<%--
	留言列表页面
	@author 航天通信专网三院云岗网上商城,lp
	@since NOV 4, 2011 3:12:10 PM
 --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>留言列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/vip/message/list_message.js"></script>
</head> 
<body>
	<input type="hidden"  id="customerInserts" value="${userpowermap['inserts_customer']}" />
	<input type="hidden"  id="customerDeletes" value="${userpowermap['deletes_customer']}" />
	<input type="hidden"  id="customerSelects" value="${userpowermap['selects_customer']}" />
	<input type="hidden"  id="customerUpdates" value="${userpowermap['updates_customer']}" />
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>姓名：</td>
				<td class='gridbody'><input type="text" id="creatorName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<s:hidden name="state" id="state"/>
	<table id="dataGrid"></table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="700px" height="250px"></iframe>
	</div>
	<div id="revovery" closed="true">
		<iframe frameborder="0" id="revoveryDataPage" width="600px" height="250px"></iframe>
	</div>
</body>
</html>