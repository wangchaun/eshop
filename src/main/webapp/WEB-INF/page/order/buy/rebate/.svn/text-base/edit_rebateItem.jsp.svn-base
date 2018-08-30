<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑供应商返利</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/order/buy/rebate/edit_rebateItem.js"></script>
</head>
<body>
	<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
		<tr>
			<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form action="" id="rebateItemForm" method="post">
						<s:hidden name="rebateItem.id" id="id" />
						<s:hidden name="rebateItem.rebateId" id="rebateId" />
						<s:hidden name="rebateItem.creatorId" />
						<s:hidden name="rebateItem.createTime" />
						<s:hidden name="rebateItem.modifierId" />
						<s:hidden name="rebateItem.modifierName" />
						<s:hidden name="rebateItem.modifyTime" />
						<s:hidden name="rebateItem.state" id="state" />
						<s:hidden name="rebate.startTime" id="startTime" />
						<s:hidden name="rebate.endTime" id="endTime" />
						
						<table width="98%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
							<tr>
								<td class='gridtitle'>供应商名称</td>
								<td class='gridbody'>
									<s:hidden id="supplierId" name="rebateItem.supplierId"/>
									<s:textfield id="supplierName" name="rebateItem.supplierName" readonly="true"  cssClass="inputTextBorder"/>
								</td>
								<td class='gridtitle' >经手人</td>
								<td class='gridbody' >
									<s:textfield id="creatorName" name="rebateItem.creatorName" readonly="true" />
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td class='gridtitle'>期间销售金额</td>
								<td class='gridbody'>
									<s:textfield id="saleMoney" name="rebateItem.saleMoney" cssClass="inputTextBorder" readonly="true"/>
								</td>
								<td class='gridtitle'>返利率</td>
								<td class='gridbody'> 
									<s:textfield id="rebateRate" name="rebateItem.rebateRate" cssClass="inputTextBorder" onchange="rebateItem.rebateRate(this);"></s:textfield>	
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>应返利金额</td>
								<td class='gridbody'>
									<s:textfield id="rebateAmount" name="rebateItem.rebateAmount" readonly="true" cssClass="inputTextBorder" />
								</td>
								<td class='gridtitle'>实际返利金额</td>
								<td class='gridbody'>
									<s:textfield id="actualRebate" name="rebateItem.actualRebate" cssClass="inputTextBorder" onchange="common.checkNumber(this);"/>
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td class='gridtitle'>备注</td>
								<td class='gridbody'colspan="3" >
									<s:textarea id="remark" name="rebateItem.remark" cols="60" rows="4" ></s:textarea>
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

