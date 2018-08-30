<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/orderDetails_pages.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/ordersPay.js"></script>
<script>
function changeDiv(tag,method){
  
  document.getElementById(tag).style.display = method;
}
function wait(){
  
  window.location.href="${ctx}/wait.jsp";
}
</script>
</head>

<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>订单详情中间<![endif]-->
<div class="content">
<div class="coupon">
<div  class="orderDetails"><samp><a href="${ctx }/customersManage.do">我的商城</a></samp><span>></span><span class="ordys"><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0">未付款订单</a></span><span>></span><span id="ordysn1">订单详情</span></div>
<!--[if !IE]>订单详情<![endif]-->
<div class="orderDetails2">
<div class="orderDetails201">
<h1>订单号：${saleOrder.code }</h1>
	<h2 style="display:none;">状态:
 
		<span>
			<c:if test="${saleOrder.orderState=='0'&&saleOrder.paymentState=='0'&&saleOrder.deliveryState=='0'&&saleOrder.iscancel=='0' }">待审核</c:if>
			<c:if test="${(saleOrder.paymentState=='0' || saleOrder.paymentState=='1')&&saleOrder.orderState=='1'&&saleOrder.deliveryState=='0'&&saleOrder.iscancel=='0'}">等待付款</c:if>
			<c:if test="${saleOrder.deliveryState=='0'&&saleOrder.iscancel=='0'}">未发货</c:if>
			<c:if test="${saleOrder.deliveryState=='1'&& saleOrder.orderState=='1'&& saleOrder.paymentState!='2'&&saleOrder.iscancel=='0'}">已发货</c:if>
			<c:if test="${saleOrder.deliveryState=='2'&&saleOrder.iscancel=='0'}">上门自提</c:if>
			<c:if test="${saleOrder.iscancel=='1'}">已取消</c:if>
			<c:if test="${saleOrder.orderState=='1' && saleOrder.paymentState=='2' && (saleOrder.deliveryState=='1'||saleOrder.deliveryState=='2')}">已完成</c:if>
		</span>
	</h2>
<h3>申请时间：<fmt:formatDate value="${saleOrder.createTime }" pattern="yyyy-MM-dd"/></h3>
<h4>
	<c:if test="${saleOrder.paymentState=='0' && saleOrder.iscancel=='0'}">
		<!-- <input name="" type="button"  class="orderDetails201btn" value="支付"/> -->
		<c:if test="${saleOrder.bankCode!='card'}">
		<!--
		<a href="javascript:void(0);" onclick="odpy('ordpaly','fade')"><input name="" value="支付" type="button" class="orderDetails201btn" onclick="bankPay('${saleOrder.id}','${saleOrder.bankCode}')"/></a>
	     -->
	     <a href="javascript:void(0);" onclick="odpy('ordpaly','fade')"><input name="" value="支付" type="button" class="orderDetails201btn" onclick="wait"/></a>
	    </c:if>
	    <c:if test="${saleOrder.bankCode=='card'}">
		 <!-- 
		<a href="javascript:void(0);" onclick="odpy('ordpaly','fade')"><input name="" value="支付" type="button" class="orderDetails201btn" onclick="paycard('${saleOrder.id}')"/></a>
	     -->
	    </c:if>
	     
	</c:if>
	
</h4>
<h4><c:if test="${saleOrder.orderState=='1' && saleOrder.paymentState=='2' && (saleOrder.deliveryState=='1'||saleOrder.deliveryState=='2')}"><input name="" type="button"  class="orderDetails201btn" value="确认收货"/></c:if></h4>
</div>
<div class="orderDetails202">
尊敬的客户，我们还未收到此订单的款项，请您尽快付款（在线支付帮助），如果您已经付款
，请您务必填写付款确认。<br/>
该订单会为您保留48小时（从下单之日算起），48小时之后如果还未付款，系统将自动取消该

订单.
</div>
</div>
<div  class="orderDetails3">
<div class="orderDetails301" style="display:none;">
	<c:if test="${saleOrder.orderState=='0'&&saleOrder.paymentState=='0'&&saleOrder.deliveryState=='0'}"><img src="${ctx }/Images/images/pue1.jpg" /></c:if>
	<c:if test="${(saleOrder.paymentState=='0' || saleOrder.paymentState=='1')&&saleOrder.orderState=='1'&&saleOrder.deliveryState=='0'}"><img src="${ctx }/Images/images/pu7.jpg" /></c:if>
	<c:if test="${saleOrder.deliveryState=='1'&& saleOrder.orderState=='1'&& saleOrder.paymentState!='2'}"><img src="${ctx }/Images/images/pue4.jpg" /></c:if>
	<!-- <c:if test="${saleOrder.deliveryState=='1'}"><img src="${ctx }/Images/images/pu7.jpg" />4</c:if> -->
	<c:if test="${saleOrder.orderState=='1' && saleOrder.paymentState=='2' && (saleOrder.deliveryState=='1'||saleOrder.deliveryState=='2')}"><img src="${ctx }/Images/images/pu6.jpg" /></c:if>
</div> 
<div class="orderDetails302"style="display:none;">
	<h1>提交订单</h1>
	<h2>等待付款</h2>
	<h3>商品出库</h3>
	<h4>等待收货</h4>
	<h5>完成</h5>
</div>
<div class="orderDetails303" style="display:none;">
	<span><fmt:formatDate value="${saleOrder.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
</div> 
</div>
<!--[if !IE]>订单跟踪处理<![endif]-->
<div class="orderDetails4"style="display:none;">
<span>订单跟踪</span>
</div>
<!--[if !IE]>订单跟踪处理列表<![endif]-->
<div class="orderDetails5" style="display:none;">
<table width="934" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="227" height="30" align="left" valign="middle" class="tableborder">处理时间</td>
    <td width="240" align="left" valign="middle" class="tableborder">处理信息</td>
	<td width="240" align="left" valign="middle" class="tableborder">配送方式</td>
    <td width="227" align="left" valign="middle" class="tableborder">操作人</td>
  </tr>
  <tr class="tablefont">
    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td width="240" height="35" align="left" valign="middle">提交申请成功</td>
	<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
    <td width="227" height="35" align="left" valign="middle">${customer.name }</td>
  </tr>
  <c:if test="${saleOrder.orderState=='1'}">
  	 <tr class="tablefont">
	    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.orderstateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    <td width="240" height="35" align="left" valign="middle">审核成功</td>
		<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
	    <td width="227" height="35" align="left" valign="middle">${saleOrder.modifierName }</td>
	  </tr>
  </c:if>
  <c:if test="${saleOrder.paymentState=='2'}">
  	 <tr class="tablefont">
	    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.paymentTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    <td width="240" height="35" align="left" valign="middle">付款成功</td>
		<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
	    <td width="227" height="35" align="left" valign="middle">${customer.name }</td>
	  </tr>
  </c:if>
  <c:if test="${saleOrder.deliveryState=='2'}">
  	 <tr class="tablefont">
	    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.deliveryTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    <td width="240" height="35" align="left" valign="middle">发货成功，物流配送中。</td>
		<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
	    <td width="227" height="35" align="left" valign="middle">${saleOrder.modifierName }</td>
	  </tr>
  </c:if>
  <c:if test="${saleOrder.orderState=='1' && saleOrder.paymentState=='2' && (saleOrder.deliveryState=='1'||saleOrder.deliveryState=='2')}">
  	 <tr class="tablefont">
	    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.deliveryTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    <td width="240" height="35" align="left" valign="middle">订单已完成。</td>
		<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
	    <td width="227" height="35" align="left" valign="middle">${saleOrder.modifierName }</td>
	  </tr>
  </c:if>
  <c:if test="${saleOrder.iscancel=='1'}">
  	<tr class="tablefont">
	    <td width="227" height="35" align="left" valign="middle"><fmt:formatDate value="${saleOrder.cancelTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    <td width="240" height="35" align="left" valign="middle">订单已取消</td>
		<td width="240" height="35" align="left" valign="middle">${saleOrder.deliveryName }</td>
	    <td width="227" height="35" align="left" valign="middle">${customer.name }</td>
	  </tr>
  </c:if>
</table>
</div>
<div class="orderDetails4">
<span>付款信息</span>
</div>
<div class="orderDetails7">
<ul>
<li>付款方式：${saleOrder.paymentName }</li>
<li>商品金额：<span class="font">¥</span>${saleOrder.orderMoney }<span class="spanys">运费金额：<span class="font">¥</span>${saleOrder.deliveryCost }</span></li>
<li>优惠金额：<span class="font">¥</span>${saleOrder.priceDiscount }</li>
<li>应支付金额：<span class="font">¥</span>${saleOrder.orderMoney+saleOrder.deliveryCost }</li>
</ul>
</div>
<div class="orderDetails4">
<span>订单信息</span>
</div>
<div class="orderDetails7">
<ul>
<li id="orderys">收货人信息：</li>
<li>收货人：${saleOrder.customerName }</li>
<li>地址：${saleOrder.address }</li>
<li>固定电话：${saleOrder.telephone}</li>
<li>手机号码：${saleOrder.mobile}</li>
<li>电子邮件：${saleOrder.email}</li>
<li id="orderys">支付方式</li>
<li>支付方式：${saleOrder.paymentName }</li>
<li>运费：<span class="font">¥</span>${saleOrder.deliveryCost }</li>
<li id="orderys" style="display:none;">发票信息</li>
<li style="display:none;">发票类型：<c:if test="${saleOrder.invoiceType=='0'}">普通发票</c:if><c:if test="${saleOrder.invoiceType=='1'}">增值税发票</c:if></li>
<li style="display:none;">发票抬头：${saleOrder.invoicePayable }</li>
<li style="display:none;">发票内容：${saleOrder.invoiceContent }</li>
<c:if test="${saleOrder.remark!=null}">
<li id="orderys">卡号信息:</li>
<li>${saleOrder.remark}</li>
</c:if>
</ul>
</div>
<div class="orderDetails4">
<span>商品清单</span>
</div>
<div class="orderDetails8">
<table width="1198" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="fff5f4">
    <td width="120" height="39" align="center" valign="middle" class="orderDetails8border">商品编号</td> 
    <td width="448" align="center" valign="middle" class="orderDetails8border">商品名称</td> 
	 <td width="110" align="center" valign="middle" class="orderDetails8border"></td>
    <td width="120" align="center" valign="middle" class="orderDetails8border">购买价</td>
    <!-- <td width="100" align="center" valign="middle" class="orderDetails8border">已优惠</td> -->
   <td width="100" align="center" valign="middle" class="orderDetails8border">规格</td>
    <td width="100" align="center" valign="middle" class="orderDetails8border">商品数量</td>
    <td width="100" align="center" valign="middle" class="orderDetails8border">库存状态</td>
  </tr>
  <c:forEach items="${saleWareList}" var="good">
	   <tr bgcolor="ffffff">
	    <td width="120" height="39" align="center" valign="middle">${good.goodCode }</td> 
	    <td width="448" align="center" valign="middle">${good.goodName }</td> 
		<td width="110" align="center" valign="middle"></td>
	    <td width="120" align="center" valign="middle" ><span><span class="font">¥</span>${good.goodPrice }</span></td>
	    <!-- <td width="100" align="center" valign="middle" >0.00</td> -->
	    <td width="100" align="center" valign="middle" >${good.wareSpecification }</td>
	    <td width="100" align="center" valign="middle">${good.orderNumber }</td>
	    <td width="100" align="center" valign="middle" >现存</td>
	  </tr>
   </c:forEach>
  
</table>

</div>
<div class="orderDetails9">
<div class="orderDetails901">
<div class="orderDetails901_con">
<div class="orderDetails901_text"><h1>商品总金额：</h1><h2><span class="font">¥</span>${saleOrder.orderMoney}</h2></div>
<div class="orderDetails901_text"><h1>+运费：</h1><h2><span class="font">¥</span>${saleOrder.deliveryCost }</h2></div>
<div class="orderDetails901_text"><h1>-优惠：</h1><h2><span class="font">¥</span>${saleOrder.priceDiscount }</h2></div>
</div>
<div class="orderDetails901_text1">订单支付金额：<span><span class="font">¥</span>${saleOrder.orderMoney+saleOrder.deliveryCost-saleOrder.priceDiscount }</span></div>
</div>
</div>
</div>
</div>
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
  </div>
</body>
</html>

