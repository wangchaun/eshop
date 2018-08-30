<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑退货单</title>
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
	<script type="text/javascript" src="${ctx }/scripts/order/sale/saleReturn/edit_saleReturn.js"></script>
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
				   	    <s:hidden name="saleReturn.id" id="id" />
				   	    <s:hidden name="saleReturn.orderId" id="orderId"/>
				   		<s:hidden name="saleReturn.creatorId" />
				   		<s:hidden name="saleReturn.creatorName" />
				   		<s:hidden name="saleReturn.modifierId" />
				   		<s:hidden name="saleReturn.modifierName" />
				   		<s:hidden name="saleReturn.modifyTime" />
				   		<s:hidden name="saleReturn.state" id="state" />
				   		<s:hidden name="saleReturn.returnState" id="returnState"/>
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridtitle'>订单编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="saleReturn.code" id="orderCode" readonly="true"/>
						    </td>
						    <td class='gridtitle'>开单日期</td>
						    <td class='gridbody'>
						    	<input name="saleReturn.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="<fmt:formatDate value="${saleReturn.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						   	<td class='gridtitle'>经手人</td>
						    <td class='gridbody' >
						      	<s:hidden id="handlerId" name="saleReturn.handlerId" /> 
						      	<s:textfield id="handlerName" name="saleReturn.handlerName" readonly="true" />
						    </td>
						    <td class='gridtitle'>部门</td>
						    <td class='gridbody' >
						    	<s:hidden id="deptId" name="saleReturn.deptId"/> 
						     	<s:textfield id="deptName" name="saleReturn.deptName" readonly="true" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>客户</td>
						    <td class='gridbody'>
						      <s:hidden id="customerId" name="saleReturn.customerId"/>
						      <s:textfield id="customerName" name="saleReturn.customerName" onclick="selectCustomer()" cssClass="inputTextBorder" readonly="true"/>
						    </td>
						    <td class='gridtitle'>联系人</td>
						    <td class='gridbody'>
						   		<s:textfield id="linkman" name="saleReturn.linkman" cssClass="inputTextBorder"></s:textfield>
						    </td>
						    <td class='gridtitle'>手机</td>
						    <td class='gridbody' colspan="3">
						    	<s:textfield id="mobile" name="saleReturn.mobile" cssClass="inputTextBorder"></s:textfield>
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						    <td class='gridtitle'>总金额</td>
						    <td class='gridbody'>
						   		<s:textfield id="moneyAccount" name="saleReturn.moneyAccount" cssClass="inputTextBorder" readonly="true"/>
						    </td>
						   	<td class='gridtitle'>银行账户</td>
						    <td class='gridbody'>
						    	<s:select list="bankAccountList"  listValue="name" listKey="id" name="saleReturn.bankAccountId" id="bankAccountId"
             							headerKey="" headerValue=" -- 请选择收款账户  -- " value="saleReturn.bankAccountId"></s:select>  
						    </td>
						    <td class='gridtitle'>配送方式</td>
						    <td class='gridbody'>
						    	<s:select list="deliveryList"  listValue="name" listKey="id" name="saleReturn.deliveryId" id="deliveryId"
             							headerKey="" headerValue=" -- 请选择配送方式  -- " value="saleReturn.deliveryId" onchange="selectDeliveryFee(this)"></s:select> 
             					<c:forEach items="${deliveryList}" var="delivery">
             						<input type="hidden" id="${delivery.id}" value="${delivery.deliveryFee}"/>
             					</c:forEach> 
						    </td>
						    <td class='gridtitle'>配送费用</td>
						    <td class='gridbody'>
						    	<s:textfield id="deliveryCost" name="saleReturn.deliveryCost" readonly="true"/>
						    </td>
						  </tr>
						  <tr>
						  	<td class='gridtitle'>发货仓库</td>
						    <td class='gridbody'>
						      <s:hidden id="warehouseId" name="saleReturn.warehouseId"/>
						      <s:textfield id="warehouseName" name="saleReturn.warehouseName" onclick="selectWarehouse()" cssClass="inputTextBorder" readonly="true" />
						    </td>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="5">
					    		<s:textarea id="remark" name="saleReturn.remark" cols="60" rows="2"></s:textarea>
					    	</td>
						  </tr>
						</table>
						<div class="clearfloat"></div>
						<div>
							<table id="wareTable" style="display: none;"></table><%-- 货品数据区 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						<div>
							<center>
								<c:if test="${saleReturn.returnState == '1' && saleReturn.state == 'c'}">
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" onclick="comfirmState()">审核</a>&nbsp;&nbsp;
								</c:if>
								<c:if test="${saleReturn.state == 'c' && saleReturn.returnState == '0'}">
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-undo" onclick="comfirmReturn()">退货</a>&nbsp;&nbsp;
								</c:if>
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

