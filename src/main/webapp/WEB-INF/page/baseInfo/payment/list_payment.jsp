<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>支付方式列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	
	<script type="text/javascript" src="${ctx }/scripts/baseInfo/payment/list_payment.js"></script>

</head> 

<body>
	<input type="hidden"  id="baseinfoInserts" value="${userpowermap['inserts_baseinfo']}" />
	<input type="hidden"  id="baseinfoDeletes" value="${userpowermap['deletes_baseinfo']}" />
	<input type="hidden"  id="baseinfoSelects" value="${userpowermap['selects_baseinfo']}" />
	<input type="hidden"  id="baseinfoUpdates" value="${userpowermap['updates_baseinfo']}" />
	<table id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="500px" height="300px"></iframe>
	</div>
</body>

</html>