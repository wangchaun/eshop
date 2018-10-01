<%--
	回复列表页面
	@author 麦芽网上商城,lp
	@since NOV 4, 2011 3:12:10 PM
 --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>回复列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/vip/message/list_revovery.js"></script>
</head> 
<body>
	<input id="messageId" type="hidden" name="messageId" value="${messageId }">
	<table id="dataGrid"></table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="600px" height="250px"></iframe>
	</div>
</body>
</html>