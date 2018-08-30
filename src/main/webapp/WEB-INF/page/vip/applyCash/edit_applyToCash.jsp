<%--
	提现编辑页面  <增加和修改>
	@author 航天通信专网三院云岗网上商城,lp
	@since Oct 21, NOV 9:12:10 PM
 --%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑提现</title>
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
	<script type="text/javascript" src="${ctx }/scripts/vip/applyCash/edit_applyToCash.js"></script>
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
					<form action="" id="applyToCashForm" method="post">
				   	    <s:hidden name="applyToCash.id" id="id" />
				   	    <s:hidden name="applyToCash.creatorId" />
				   		<s:hidden name="applyToCash.creatorName" />
				   		<s:hidden name="applyToCash.modifierId" />
				   		<s:hidden name="applyToCash.modifierName" />
				   		<s:hidden name="applyToCash.modifyTime" />
				   		<s:hidden name="applyToCash.state" id="state" />
				   		
				   		<table width="98%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						  	<td class='gridtitle'>经手人</td>
						    <td class='gridbody'>
						    	<s:hidden id="handlerId" name="applyToCash.handlerId" /> 
						      	<s:textfield id="handlerName" name="applyToCash.handlerName" readonly="true" />
						    </td>
						    <td class='gridtitle'>提现日期</td>
						    <td class='gridbody'>
						    	<input name="applyToCash.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" readonly="true" value="<fmt:formatDate value="${applyToCash.createTime}" pattern="yyyy-MM-dd HH:ss:mm"/>" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						    <td class='gridtitle'>提现金额</td>
						    <td class='gridbody'>
						    	<s:textfield id="toCashAmount" name="applyToCash.toCashAmount" cssClass="inputTextBorder" onchange="common.checkNumber(this);"/>&nbsp;<font color="red">*</font>
						    </td>
						    <td class='gridtitle'>提现人</td>
							  <td class='gridbody'>
							   	<s:hidden id="customerId" name="applyToCash.customerId"/>
							   	<s:hidden id="money" name="money"/>
							    <s:textfield id="customerName" name="applyToCash.customerName"  cssClass="inputTextBorder" readonly="true" onclick="selectCustomer()"/>&nbsp;<font color="red">*</font>
							</td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>银行名称</td>
						    <td class='gridbody'>
						    	<s:textfield id="bankName" name="applyToCash.bankName" cssClass="inputTextBorder" />
						    </td>
						    <td class='gridtitle'>开户人</td>
						    <td class='gridbody'>
						    	<s:textfield id="accountHolder" name="applyToCash.accountHolder" cssClass="inputTextBorder" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridtitle'>银行账号</td>
						    <td class='gridbody' colspan="3">
						    	<s:textfield id="bankAccount" name="applyToCash.bankAccount" cssClass="inputTextBorder" onchange="common.number(this);"/>
						    </td>
						  </tr>
						  <tr>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody'colspan="3" >
					    		<s:textarea id="remark" name="applyToCash.remark" cols="55" rows="4" ></s:textarea>
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

