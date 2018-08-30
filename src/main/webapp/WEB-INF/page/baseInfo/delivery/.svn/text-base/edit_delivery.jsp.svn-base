<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>配送方式管理</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/delivery/edit_delivery.js"></script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    <tr>
    	<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px;">
		    	<form id="saveForm" method="post" action="">
		    	    <s:hidden name="delivery.id" id="id" />
		    		<s:hidden name="delivery.creatorId" />
		    		<s:hidden name="delivery.creatorName" />
		    		<s:hidden name="delivery.createTime" />
		    		<s:hidden name="delivery.modifierId" />
		    		<s:hidden name="delivery.modifierName" />
		    		<s:hidden name="delivery.modifyTime" />
		    		<s:hidden name="delivery.state" />
		    		
 					<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
				    	<tr>
							<td class='gridtitle'> 编号</td>
							<td class='gridbody'>
								<input name="delivery.code" id="code" onchange="codeCheck()" value="${delivery.code}"
								<c:if test="${delivery.id != null}">disabled="disabled"</c:if>/><c:if test="${delivery.id == null}"><font color="red">*</font></c:if>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'> 名称</td>
							<td class='gridbody'>
								<s:textfield name="delivery.name" id="name" onchange="isNameExisted()"/><font color="red">*</font>
							</td>
						</tr>
				    	
				    		<tr>
							<td class='gridtitle'> 配送费用</td>
							<td class='gridbody'>
								<s:textfield name="delivery.deliveryFee" id="deliveryFee" /><font color="red">*</font>
							</td>
						</tr>	
				    			
						<tr>
							<td class='gridtitle'> 备注</td>
							<td class='gridbody'>
								<s:textarea name="delivery.remark" id="remark" cols="45" rows="6"></s:textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</td>
	</tr>
</table>
</body>

</html>

