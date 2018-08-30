<%--
	会员充值编辑页面  <增加和修改>
	@author 航天通信专网三院云岗网上商城,lp
	@since Oct 21, 2011 3:12:10 PM
 --%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑会员充值</title>
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
	<script type="text/javascript" src="${ctx }/scripts/vip/prepaid/edit_prepaid.js"></script>
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
					<form action="" id="prepaidForm" method="post">
				   	    <s:hidden name="prepaid.id" id="id" />
				   	    <s:hidden name="prepaid.creatorId" />
				   		<s:hidden name="prepaid.creatorName" />
				   		<s:hidden name="prepaid.modifierId" />
				   		<s:hidden name="prepaid.modifierName" />
				   		<s:hidden name="prepaid.modifyTime" />
				   		<s:hidden name="prepaid.state" id="state" />
				   		<table width="98%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						  	<td class='gridtitle' >充值编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="prepaid.code" id="code"  readonly="true"/>
						    </td>
						    <td class='gridtitle'>充值日期</td>
						    <td class='gridbody'>
						    	<input name="prepaid.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="<fmt:formatDate value="${prepaid.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						  </tr>
						  <tr></tr>
						  <tr>
						    <td class='gridtitle'>充值金额</td>
						    <td class='gridbody'>
						    	<s:textfield id="prepaidMoney" name="prepaid.prepaidMoney" cssClass="inputTextBorder" onchange="common.checkNumber(this);"/>&nbsp;<font color="red">*</font>
						    </td>
						    <td class='gridtitle'>会员名称</td>
							  <td class='gridbody'>
							   	<s:hidden id="customerId" name="prepaid.customerId"/>
							    <s:textfield id="customerName" name="prepaid.customerName"  cssClass="inputTextBorder" readonly="true" onclick="selectCustomer()"/>&nbsp;<font color="red">*</font>
							  </td>
						  </tr>
						  <tr></tr>
						  <tr>
						    <td class='gridtitle'>经手人</td>
						    <td class='gridbody' colspan="3" >
						    	<s:hidden id="handlerId" name="prepaid.handlerId" /> 
						      	<s:textfield id="handlerName" name="prepaid.handlerName" readonly="true" />
						    </td>
						  </tr>
						  <tr>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody'colspan="3" >
					    		<s:textarea id="remark" name="prepaid.remark" cols="55" rows="3" ></s:textarea>
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

