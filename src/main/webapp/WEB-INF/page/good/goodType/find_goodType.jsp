<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>商品类别搜索</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
				    	<table width="100%"  border="0" cellpadding="10" cellspacing="10" >
				    	   <tr>
								<td >商品类别编号</td>
								<td >商品类别名称</td>
								<td >商品类别级别</td>
							</tr>
							<c:forEach items="${goodTypeList}" var="typelist">
								<tr>
									<td >${typelist.code}</td>
									<td >${typelist.name}</td>
									<td >${typelist.level}</td>
								</tr>
							</c:forEach>
							<c:if test="${totalRows == 0}">
								<tr align="center"><td colspan="3" style="color: red;">对不起,没有相关信息</td></tr>
							</c:if>
						</table>
				</div>
	    	</td>
	    </tr>
	</table>

</body>
</html>

