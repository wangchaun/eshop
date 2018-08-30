<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>银行账户管理</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/bankAccount/edit_bankAccount.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    <tr>
    	<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px;">
		    	<form id="saveForm" method="post" action="">
		    	    <s:hidden name="bankAccount.id" id="id" />
		    		<s:hidden name="bankAccount.creatorId" />
		    		<s:hidden name="bankAccount.creatorName" />
		    		<s:hidden name="bankAccount.createTime" />
		    		<s:hidden name="bankAccount.modifierId" />
		    		<s:hidden name="bankAccount.modifierName" />
		    		<s:hidden name="bankAccount.modifyTime" />
		    		<s:hidden name="bankAccount.state" />
		    		
 					<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
				    	<tr>
							<td class='gridtitle'>账户编号</td>
							<td class='gridbody'>
								<input name="bankAccount.code" id="code" value="${bankAccount.code}"
								<c:if test="${bankAccount.id != null}">disabled="disabled"</c:if>/><c:if test="${bankAccount.id == null}"><font color="red">*</font></c:if>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>账户名称</td>
							<td class='gridbody'>
								<s:textfield name="bankAccount.name" id="name" /><font color="red">*</font>
							</td>
						</tr>
				    	<tr>
							<td class='gridtitle'>账号</td>
							<td class='gridbody'>
								<s:textfield name="bankAccount.account" id="account"  onkeyup="value=value.replace(/[^\d]/g,'')" /><font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>请确认账号</td>
							<td class='gridbody'>
								<s:textfield name="" id="reaccount" /><font color="red">*</font>
							</td>
						</tr>
						<!-- 
							<tr>
							<td class='gridtitle'>账户金额</td>
							<td class='gridbody'>
								<s:textfield name="bankAccount.money" id="money" onchange="common.checkNumber(this);"/><font color="red">*</font>
							</td>
						</tr>
						 -->
						<tr>
							<td class='gridtitle'>开户人</td>
							<td class='gridbody'>
								<s:textfield name="bankAccount.accountHolder" id="accountHolder" /><font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>开户行</td>
							<td class='gridbody'>
								<s:textfield name="bankAccount.bank" id="bank"/><font color="red">*</font>
							</td>
						</tr>				
						<tr>
							<td class='gridtitle'>备注</td>
							<td class='gridbody'>
								<s:textarea name="bankAccount.remark" id="remark" cols="45" rows="3"></s:textarea>
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

