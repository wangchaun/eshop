<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑收款单</title>
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
	<script type="text/javascript" src="${ctx }/scripts/order/sale/saleCollection/edit_saleCollection.js"></script>
	<style type="text/css">
		.tabtop {
			height:40px;
			font-size:12px;
		}
		.tabtop .title {
			font-size:14px;
			font-weight:bold;
		}
		.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
			clear:both;
   			height:0;
    		font-size: 1px;
    		line-height: 0px;
		}
		.border {
			font-size:12px;
    		border:1px solid #90B9DE;
		}
		.bordertd {
			font-size:12px;
		}
	</style>
</head>
<body>
	 <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px;">
					<form action="" id="orderForm">
				   	    <s:hidden name="saleCollection.id" id="id" />
				   	    <s:hidden name="saleCollection.orderId" id="orderId"/>
				   		<s:hidden name="saleCollection.creatorId" />
				   		<s:hidden name="saleCollection.creatorName" />
				   		<s:hidden name="saleCollection.modifierId" />
				   		<s:hidden name="saleCollection.modifierName" />
				   		<s:hidden name="saleCollection.modifyTime" />
				   		<s:hidden name="saleCollection.state" id="state" />
				   		<s:hidden name="saleCollection.paymentState" id="paymentState"/>
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridtitle'>订单编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="saleCollection.code" id="orderCode" readonly="true"/>
						    </td>
						    <td class='gridtitle'>开单日期</td>
						    <td class='gridbody'>
						    	<input name="saleCollection.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="<fmt:formatDate value="${saleCollection.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						   	<td class='gridtitle'>经手人</td>
						    <td class='gridbody' >
						      	<s:hidden id="handlerId" name="saleCollection.handlerId" /> 
						      	<s:textfield id="handlerName" name="saleCollection.handlerName" readonly="true" />
						    </td>
						    <td class='gridtitle'>部门</td>
						    <td class='gridbody' >
						    	<s:hidden id="deptId" name="saleCollection.deptId"/> 
						     	<s:textfield id="deptName" name="saleCollection.deptName" readonly="true" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>客户</td>
						    <td class='gridbody'>
						      <s:hidden id="customerId" name="saleCollection.customerId"/>
						      <s:textfield id="customerName" name="saleCollection.customerName" onclick="selectCustomer()" cssClass="inputTextBorder" readonly="true"/>
						    </td>
						    <td class='gridtitle'>联系人</td>
						    <td class='gridbody'>
						   		<s:textfield id="linkman" name="saleCollection.linkman" cssClass="inputTextBorder"></s:textfield>
						    </td>
						   	<td class='gridtitle'>手机</td>
						    <td class='gridbody' colspan="3">
						    	<s:textfield id="mobile" name="saleCollection.mobile" cssClass="inputTextBorder"></s:textfield>
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						    <td class='gridtitle'>总金额</td>
						    <td class='gridbody'>
						   		<s:textfield id="moneyAccount" name="saleCollection.moneyAccount" cssClass="inputTextBorder" readonly="true"/>
						    </td>
						   	<td class='gridtitle'>银行账户</td>
						    <td class='gridbody'>
						    	<s:select list="bankAccountList"  listValue="name" listKey="id" name="saleCollection.bankAccountId" id="bankAccountId"
             							headerKey="" headerValue=" -- 请选择收款账户  -- " value="saleCollection.bankAccountId"></s:select>  
						    </td>
						     <td class='gridtitle'>支付方式</td>
						    <td class='gridbody' colspan="3">
						    	<s:select list="paymentList"  listValue="name+'—费用：'+paymentFee" listKey="id" name="saleCollection.paymentId" id="paymentId"
             							headerKey="" headerValue=" -- 请选择支付方式  -- " value="saleCollection.paymentId"></s:select>  
						    </td>
						  </tr>
						  <tr>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="7">
					    		<s:textarea id="remark" name="saleCollection.remark" cols="80" rows="2"></s:textarea>
					    	</td>
						  </tr>
						</table>
						<div class="clearfloat"></div>
						<div>
							<table id="collectionItemTable" style="display: none;"></table><%-- 货品数据区 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						<div>
							<center>
								<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${saleCollection.paymentState == 1 }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
								<input type="button" value="审核" onclick="javascript:confirmCollection();" <c:if test="${saleCollection.paymentState == 1 }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

