<%--
	付款单编辑页面  <增加和修改>
	@author 航天通信专网三院云岗网上商城,lp
	@since Oct 21, 2011 3:12:10 PM
 --%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑付款单</title>
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
	<script type="text/javascript" src="${ctx }/scripts/order/cashBasis/pay/edit_pay.js"></script>
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
					<form action="" id="cashItemForm">
				   	    <s:hidden name="pay.id" id="id" />
				   	    <s:hidden name="pay.creatorId" />
				   		<s:hidden name="pay.creatorName" />
				   		<s:hidden name="pay.modifierId" />
				   		<s:hidden name="pay.modifierName" />
				   		<s:hidden name="pay.modifyTime" />
				   		<s:hidden name="pay.state" id="state" />
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						  	<td class='gridtitle' >付款单号</td>
						    <td class='gridbody' >
						    	<s:textfield name="pay.code" id="Code"  readonly="true"/>
						    </td>
						    <td class='gridtitle' >开单日期</td>
						    <td class='gridbody' >
						    	<input name="pay.createTime" id="createTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${pay.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						    <td class='gridtitle' >经手人</td>
						    <td class='gridbody' >
						    	<s:hidden id="handlerId" name="pay.handlerId" /> 
						      	<s:textfield id="handlerName" name="pay.handlerName" readonly="true" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>收款单位</td>
						    <td class='gridbody' >
						    	<s:hidden id="customerId" name="pay.customerId"/>
						        <s:textfield id="customerName" name="pay.customerName"  cssClass="inputTextBorder" readonly="true" />
							   <!-- 
							    <input type="button" value="客  户" onclick="javascript:selectCustomer();" <c:if test="${pay.state == 's' }">disabled="disabled"</c:if>/>&nbsp; -->
							    <input type="button" value="供应商" onclick="javascript:selectSupplier();" <c:if test="${pay.state == 's' }">disabled="disabled"</c:if>/>
						    </td>
						    <td class='gridtitle'>总金额</td>
						    <td class='gridbody'>
						    	<s:textfield id="moneyAccount" name="pay.moneyAccount" cssClass="inputTextBorder" readonly="true" onchange="common.checkNumber(this);" />
						    </td>
						    <td class='gridtitle'>实付金额</td>
						    <td class='gridbody'>
						        <s:textfield id="moneyPayment" name="pay.moneyPayment"  cssClass="inputTextBorder" readonly="true"  onchange="common.checkNumber(this);"/>
							</td>
						  </tr>
						  <tr></tr>
						  <tr>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="5">
					    		<s:textarea id="remark" name="pay.remark" cols="55" rows="3"></s:textarea>
					    	</td>
						  </tr>
						</table>
						<div class="clearfloat"></div>
						<div>
							<table id="cashItemTable" style="display: none;"></table><%-- 货品数据区 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						<!-- 
						 -->
						<div>
							<center>
								<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${pay.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
								<input type="button" value="审核" onclick="javascript:confirmPay();" <c:if test="${pay.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

