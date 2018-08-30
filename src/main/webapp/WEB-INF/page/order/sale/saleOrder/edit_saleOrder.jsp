<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑订单</title>
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
	<script type="text/javascript" src="${ctx }/scripts/order/sale/saleOrder/edit_saleOrder.js"></script>
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
				   	    <s:hidden name="saleOrder.id" id="id" />
				   	    <s:hidden name="saleOrder.type" />
				   		<s:hidden name="saleOrder.creatorId" />
				   		<s:hidden name="saleOrder.creatorName" />
				   		<s:hidden name="saleOrder.modifierId" />
				   		<s:hidden name="saleOrder.modifierName" />
				   		<s:hidden name="saleOrder.modifyTime" />
				   		<s:hidden name="saleOrder.state" id="state" />
				   		<s:hidden name="saleOrder.orderState" id="orderState"/>
				   		<s:hidden name="saleOrder.deliveryState" />
				   		<s:hidden name="saleOrder.paymentState" />
				   		<s:hidden name="saleOrder.iscancel" id="iscancel"/>
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridtitle'>订单编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="saleOrder.code" id="orderCode"  readonly="true"/>
						    </td>
						    <td class='gridtitle'>开单日期</td>
						    <td class='gridbody'>
						    	<input name="saleOrder.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="<fmt:formatDate value="${saleOrder.createTime}" pattern="yyyy-MM-dd"/>" />
						    	
						    </td>
						   	<td class='gridtitle'>经手人</td>
						    <td class='gridbody' >
						      <s:hidden id="handlerId" name="saleOrder.handlerId" /> 
						      <s:textfield id="handlerName" name="saleOrder.handlerName" readonly="true" />
						    </td>
						    <td class='gridtitle'>部门</td>
						    <td class='gridbody' >
						    	<s:hidden id="deptId" name="saleOrder.deptId"/> 
						     	<s:textfield id="deptName" name="saleOrder.deptName" readonly="true" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>仓库</td>
						    <td class='gridbody'>
						      <s:hidden id="warehouseId" name="saleOrder.warehouseId"/>
						      <s:textfield id="warehouseName" name="saleOrder.warehouseName" onclick="selectWarehouse()" cssClass="inputTextBorder" readonly="true" />
						    </td>
						  	<td class='gridtitle'>客户</td>
						    <td class='gridbody'>
						      <s:hidden id="customerId" name="saleOrder.customerId"/>
						      <s:textfield id="customerName" name="saleOrder.customerName"  cssClass="inputTextBorder" readonly="true" onclick="selectCustomer()"/>
						    </td>
						    <td class='gridtitle'>联系人</td>
						    <td class='gridbody'>
						   		<s:textfield id="linkman" name="saleOrder.linkman" cssClass="inputTextBorder"></s:textfield>
						    </td>
						    <td class='gridtitle'>手机</td>
						    <td class='gridbody' >
						    	<s:textfield id="mobile" name="saleOrder.mobile" cssClass="inputTextBorder" onchange="common.checkIsMobile(this);"></s:textfield>
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						   	<td class='gridtitle'>银行账户</td>
						    <td class='gridbody'>
             					<!-- 
             						<s:select list="bankAccountList"  listValue="name" listKey="id" name="saleOrder.bankAccountId" id="bankAccountId"
             						headerKey="" headerValue=" -- 请选择收款账户  -- " value="saleOrder.bankAccountId"></s:select> 	
             					 -->
             					<select>
             						<c:if test="${saleOrder.paymentCode == 'payonline' || saleOrder.paymentCode == 'alipay'}">
	             						<option value="EF1FF3B6F9F569D67892327C3C78520C" selected="selected">网上银行</option>
	             						<option value="1DE6A2DA900F17C564C339C050890FC3">现金</option>
	             					</c:if>
	             					<c:if test="${saleOrder.paymentCode != 'payonline' && saleOrder.paymentCode != 'alipay'}">
	             					<option value="EF1FF3B6F9F569D67892327C3C78520C">网上银行</option>
	             						<option value="1DE6A2DA900F17C564C339C050890FC3" selected="selected">现金</option>
	             					</c:if>
	             					<c:forEach items="${bankAccountList}" var="banlist">
	             						<c:if test="${banlist.id != 'EF1FF3B6F9F569D67892327C3C78520C' && banlist.id != '1DE6A2DA900F17C564C339C050890FC3'}">
	             							<option value="${banlist.id }">${banlist.name }</option>
	             						</c:if>
								    </c:forEach>
							    </select>	
             						 
						    </td>
						    <td class='gridtitle'>支付方式</td>
						    <td class='gridbody'>
						    	<!-- 
						    		<select>
							    	 	<c:forEach items="${paymentList}" var="paymentList">
								    	 	<option value="${paymentList.id }" <c:if test="${paymentList.id == saleOrder.paymentId }">selected="selected"</c:if> >${paymentList.name }</option>
								    	</c:forEach>
							    	</select>	
             					-->	
             					<s:select list="paymentList"  listValue="name" listKey="id" name="saleOrder.paymentId" id="paymentId"
             						headerKey="" headerValue=" -- 请选择支付方式  -- " value="saleOrder.paymentId"></s:select> 	
						    </td>
						    <td class='gridtitle'>配送方式</td>
						    <td class='gridbody'>
						    	<s:select list="deliveryList"  listValue="name" listKey="id" name="saleOrder.deliveryId" id="deliveryId"
             							headerKey="" headerValue=" -- 请选择配送方式  -- " value="saleOrder.deliveryId" onchange="selectDeliveryFee(this)"></s:select> 
             					<c:forEach items="${deliveryList}" var="delivery">
             						<input type="hidden" id="${delivery.id}" value="${delivery.deliveryFee}"/>
             					</c:forEach> 
						    </td>
						    <td class='gridtitle'>配送费用</td>
						    <td class='gridbody'>
						    	<s:textfield id="deliveryCost" name="saleOrder.deliveryCost" readonly="true"/>
						    </td>
						  </tr>
						  <tr>
						  <td class='gridtitle'>订单金额</td>
						    <td class='gridbody'>
						   		<s:textfield id="orderMoney" name="saleOrder.orderMoney" cssClass="inputTextBorder" readonly="true"/>
						    </td>
						    <td class='gridtitle'>优惠金额</td>
						    <td class='gridbody'>
						   		<s:textfield id="priceDiscount" name="saleOrder.priceDiscount" cssClass="inputTextBorder" onchange="common.checkNumber(this);flushMoney()"/>
						    </td>
						    <td class='gridtitle'>收款金额</td>
						    <td class='gridbody'>
						   		<s:textfield id="paymentMoney" name="saleOrder.paymentMoney" cssClass="inputTextBorder" onchange="common.checkNumber(this);"/>
						    </td>
						    <td class='gridtitle'>配送时间</td>
						    <td class='gridbody'>
						    	<select name="saleOrder.deliveryDate">
						    		<option value="0" <c:if test="${saleOrder.deliveryDate == 0}">selected="selected"</c:if>>工作日和休息日</option>
						    		<option value="1" <c:if test="${saleOrder.deliveryDate == 1}">selected="selected"</c:if>>仅工作日</option>
						    		<option value="2" <c:if test="${saleOrder.deliveryDate == 2}">selected="selected"</c:if>>仅休息日</option>
						    	</select>
						    </td>
						  </tr>
						  <tr>
							   <td class='gridtitle'>是否含税</td>
							    <td class='gridbody'>
							    	是<input name="commit" id="commit" type="radio" onclick="flushMoney('y');" />否<input type="radio" onclick="flushMoney('n');" checked="checked" name="commit" id="commit"/>
							    </td>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="5">
					    		<s:textarea id="remark" name="saleOrder.remark" cols="80" rows="2"></s:textarea>
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
							<c:if test="${saleOrder.orderState == '0' && saleOrder.iscancel == '0'}">
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" onclick="submitSaveForm()">保存</a>&nbsp;&nbsp;
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="confirmOrder()">审核</a>&nbsp;&nbsp;
							</c:if>
							<c:if test="${saleOrder.orderState == '1' && saleOrder.deliveryState == '0' }">
								<a href="${ctx }/downloadPdf!downloadPdf.do?saleOrder.id=${saleOrder.id}&type=CustomInvoice" class="easyui-linkbutton" iconCls="icon-print">订单打印</a>&nbsp;&nbsp;
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-redo" onclick="delivery()">发货</a>&nbsp;&nbsp;
							</c:if>
							<c:if test="${saleOrder.deliveryState == '1'&&saleOrder.paymentState=='1' }">
								<a href="${ctx }/downloadPdf!downloadPdf.do?saleOrder.id=${saleOrder.id}&type=CustomInvoice" class="easyui-linkbutton" iconCls="icon-print">订单打印</a>&nbsp;&nbsp;
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-undo" onclick="saleReturn()">退货</a>&nbsp;&nbsp;
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

