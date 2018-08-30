<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>结算方式管理</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/payment/edit_payment.js"></script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    <tr>
    	<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px;">
		    	<form id="saveForm" method="post" action="">
		    	    <s:hidden name="payment.id" id="id" />
		    		<s:hidden name="payment.creatorId" />
		    		<s:hidden name="payment.creatorName" />
		    		<s:hidden name="payment.createTime" />
		    		<s:hidden name="payment.modifierId" />
		    		<s:hidden name="payment.modifierName" />
		    		<s:hidden name="payment.modifyTime" />
		    		<s:hidden name="payment.state" />
		    		
			    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
				    	<tr>
							<td class='gridtitle'> 编号 </td>
							<td class='gridbody'>
								<input type="text" name="payment.code" id="code" value="${payment.code}"  onchange="codeCheck()"
								<c:if test="${payment.id != null}"> disabled="disabled"</c:if>/><c:if test="${payment.id == null}"><font color="red">*</font></c:if>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'> 名称 </td>
							<td class='gridbody'> 
								<s:textfield name="payment.name" id="name" /><font color="red">*</font>
							</td>
						</tr>
				    	<!-- <tr>
							<td class='gridtitle'> 支付费用</td>
							<td class='gridbody'>
								<s:textfield name="payment.paymentFee" id="paymentFee" /><font color="red">*</font>
							</td>
						</tr>	 -->			
						<tr>
							<td class='gridtitle'> 备注 </td>
							<td class='gridbody'>
								<s:textarea name="payment.remark" id="remark" cols="45" rows="6"></s:textarea>
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

