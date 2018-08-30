<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>商品规格值</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/good/goodKind/list_goodKingVal.js"></script>

</head> 

<body>
	<s:hidden name="goodKingId" id="goodKingId"/>
	<table id="dataGrid"></table>
	
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="300px" height="150px"></iframe>
	</div>
</body>

</html>