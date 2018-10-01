<%--
	会员优惠劵编辑页面  <增加和修改>
	@author 麦芽网上商城,lp
	@since Oct 31, 2011 3:12:10 PM
 --%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑会员优惠劵</title>
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
	<script type="text/javascript" src="${ctx }/scripts/vip/coupon/edit_vipCoupon.js"></script>
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
				<form action="" id="vipCouponForm">
			   	    <s:hidden name="vipCoupon.id" id="id" />
			   	    <s:hidden name="vipCoupon.creatorId" />
			   		<s:hidden name="vipCoupon.creatorName" />
			   		<s:hidden name="vipCoupon.modifierId" />
			   		<s:hidden name="vipCoupon.modifierName" />
			   		<s:hidden name="vipCoupon.modifyTime" />
			   		<s:hidden name="vipCoupon.state" id="state" />
			   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
					  <tr>
					  	<td class='gridtitle' >优惠劵编号</td>
					    <td class='gridbody' >
					    	<s:textfield name="vipCoupon.code" id="code"  readonly="true" disabled="true"/>
					    </td>
					    <td class='gridtitle' >优惠劵名称</td>
					    <td class='gridbody' >
					    	<s:textfield name="vipCoupon.name" id="name" />&nbsp;<font color="red">*</font>
					    </td>
					    <td class='gridtitle' >开单日期</td>
					    <td class='gridbody' >
					    	<input name="vipCoupon.createTime" id="createTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${vipCoupon.createTime}" pattern="yyyy-MM-dd"/>" />
					    </td>
					  </tr>
					  <tr></tr>
					  <tr>
					  	<td class='gridtitle' >面值</td>
					    <td class='gridbody' >
					    	<s:textfield name="vipCoupon.money" id="money" />&nbsp;<font color="red">*</font>
					    </td>
					    <td class='gridtitle' >数量</td>
					    <td class='gridbody' >
					    	<s:textfield name="vipCoupon.count" id="count" onchange="common.number(this);"/>&nbsp;<font color="red">*</font>
					    </td>
					    <td class='gridtitle' >会员等级</td>
					    <td class='gridbody' >
					    	<s:select list="vipLevelList"  listValue="name" listKey="id" name="vipCoupon.vipLevelId" id="vipLevelId"
             							headerKey="" headerValue=" -- 请选择会员  -- " value="vipCoupon.vipLevelId"></s:select>&nbsp;<font color="red">*</font>
					    </td>
					  </tr>
					  <tr></tr>
					  <tr>
					  	<td class='gridtitle' >最低购买金额</td>
					    <td class='gridbody' >
					    	<s:textfield name="vipCoupon.minBuy" id="minBuy" />&nbsp;<font color="red">*</font>
					    </td>
					  	<td class='gridtitle' >活动时间</td>
					    <td class='gridbody' colspan="3">
					    	<input name="vipCoupon.startTime" id="startTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${vipCoupon.startTime}" pattern="yyyy-MM-dd"/>" />至
					    	<input name="vipCoupon.endTime" id="endTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${vipCoupon.endTime}" pattern="yyyy-MM-dd"/>" />&nbsp;<font color="red">*</font>
					    </td>
					  </tr>
					  <c:if test="${vipCoupon.state != 'd'}">
					  <tr>
					  	<td class='gridtitle' >分配会员</td>
					    <td class='gridbody' colspan="5">
				    		<s:hidden id="customerId" name="vipCoupon.customerId"/>
						    <s:textfield id="customerName" name="vipCoupon.customerName"  cssClass="inputTextBorder" readonly="true" onclick="selectCustomer()"/>
					    </td>
					  </tr>
					  </c:if>
					  <tr></tr>
					  <tr>
				  		<td class='gridtitle'>备注</td>
				    	<td class='gridbody' colspan="5">
				    		<s:textarea id="remark" name="vipCoupon.remark" cols="55" rows="2"></s:textarea>
				    	</td>
					  </tr>
					</table>
					<div class="clearfloat"></div>
					<div>
						<table id="vipCouponWareTable" style="display: none;"></table>
						<%-- 数据区 --%>
					    <table id="dataGrid" ></table>
					</div>
					<div class="clear"></div><br>
					<div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${vipCoupon.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							<input type="button" value="审核" onclick="javascript:confirmPay();" <c:if test="${vipCoupon.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
						</center>
					</div>
				</form>
			</div>
		</td>
	</tr>
</table>
</body>
</html>

