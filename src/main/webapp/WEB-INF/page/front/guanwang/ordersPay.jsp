<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/ordersPay_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/ordersPay.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
function wait(){
  window.location.href="${ctx}/wait.jsp";
}
</script>
</head>
<body>
<!--[if !IE]>这个页面和支付订单中的货到付款，支付订单中得入网选号的样式是一样的！<![endif]-->
<div class="box">
  <!--[if !IE]>头部<![endif]-->
  <div class="ctop">
    <div class="top_con">
      <div class="top_ctext">您好 ，欢迎您！<span id="top_ctextys"><c:if test="${loginCustomer!=null }">${loginCustomer.code }</c:if></span></div>
      <div class="top_ctext1">
        <input name="" type="button" class="subbmit" onclick="loginOut()" value="退出" />
      </div>
      <div class="top_ctext2">
      <span class="ys1">
     	<c:if test="${loginCustomer!=null }"><a href="${ctx }/customersManage.do" target="_blank">我的商城</a> |</c:if>
      	<c:if test="${loginCustomer==null }"><a href="javascript:void(0);" onclick="myShops()">我的商城</a> |</c:if>
      </span>
      <span class="ys2"><img src="${ctx }/Images/images/a1.jpg" /></span>
       <span class="ys3"><a href="${ctx}/ShoppingCar.do">购物车<c:if test="${shoppingCarSize==null}">0</c:if>${shoppingCarSize }件</a> 
        | <a href="${ctx}/infor.do?information.type=7" >帮助中心</a>
      	</span>
       </div>
    </div>
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
      <div class="topf">
        <div class="logo">
         <div class="logo01">
          <c:forEach items="${advertiseList}" var="promotionActivity">
          <c:if test="${promotionActivity.placeId=='LOG'}"> 
	      <a href="${ctx }/index.do"><img src="${ctx}${promotionActivity.pic }" /></a>
	      </c:if>
 	      </c:forEach>
          </div>
          <div class="logo03" style="display:none;"  onmouseout="changeDiv('layer1','none')" onmouseover="changeDiv('layer1','block')">
		  <!--
		  <span id="tys"><c:if test="${areasId==null}">全国站</c:if><c:if test="${areasId!=null}">${areasName}站</c:if></span>
		  <samp id="tys1">【切换城市】</samp>
		    <div  id="layer1" class="tanlay">
			<div  class="tanlay01">
			<div id="fy">
                   	<c:forEach items="${areaList}" var="area1">
                   		<div id="fy1"><span>${area1.name}</span>
		                   	<c:forEach items="${area1.areaList}" var="area2">
		                   		 <a href="${ctx }/index.do?area.id=${area2.id }">${area2.name}</a>
		                   	</c:forEach>
                   		</div>		
                   	</c:forEach>
                    <div id="fy2"></div>
			</div>
			</div>
			<iframe frameborder="0" class="b1"></iframe>
		  </div>  
		  -->
        </div>
         
        </div>
        <!--[if !IE]>购物车步骤<![endif]-->
        <div class="shopcart">
          <h1>1、我的购物车</h1>
          <h2>2、填写核对订单信息 </h2>
          <h3>3、成功提交订单</h3>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
 
  <div class="orderpay">
   <div class="orderpay01">
   <div class="orderpay01_text">
   <h1><img src="${ctx }/Images/images/shopcart12.jpg" /></h1>
   <h2>订单提交成功，请您尽快去付款！</h2>
   </div>
   <div class="orderpay01_text2">
   <span>收货信息：</span>${customerAddress.name }&nbsp;${customerAddress.address }&nbsp;${customerAddress.street }&nbsp;${customerAddress.zipCode }&nbsp;${customerAddress.mobile }&nbsp; 
   </div>
    <div class="orderpay01_text2">
   <span>送货时间：</span>
	<c:if test="${saleOrder.deliveryDate=='0'}">工作日送</c:if>
	<c:if test="${saleOrder.deliveryDate=='1'}">作日、双休及节假日都可以送</c:if>
	<c:if test="${saleOrder.deliveryDate=='2'}">双休日、节假日送</c:if>
   </div>
    <div class="orderpay01_text2">
   <span>应付金额：</span><samp><span class="fonys">¥</span>${saleOrder.orderMoney}</samp>
   </div>
   </div>
  </div>
  <div class="orderpay1">
  <div class="orderpay1_content">
   <!--[if !IE]>网上银行选择<![endif]-->
  <div class="orderpay1_title">
 
 
   <h1>
  支付方式：
  </h1>
  	<h2><img  src="${ctx }/Images/bank/${saleOrder.bankCode}.jpg" /></h2>
  	  <h3><a href="${ctx }/orderpay.do?orderId=${saleOrder.id}&addressId=${customerAddress.id }"><!-- 重新选择 --></a></h3>

  </div>
   <!--[if !IE]>确认提交按钮<![endif]-->
      
      <c:if test="${saleOrder.bankCode!='card'}">
 	  <div class="orderpay1_tsaleOrder.bankCode" >
	  	<!-- 
	  	<a href="#" onclick="odpy('ordpaly','fade')"><input name="" type="button" class="orderpay1btn" onclick="bankPay('${saleOrder.id}','${saleOrder.bankCode}')"/></a>
	  	 -->
	  	<a href="#" onclick="odpy('ordpaly','fade')"><input name="" type="button" class="orderpay1btn" onclick="wait()"/></a>
	  </div>
      </c:if>
      <c:if test="${saleOrder.bankCode=='card'}">
 	  <div class="orderpay1_tsaleOrder.bankCode" >
 	    <!-- 
 	    <a href="#" onclick="odpy('ordpaly','fade')"><input name="" type="button" class="orderpay1btn" onclick="paycard('${saleOrder.id}')"/></a>
 	    -->
	  	<a href="#" onclick="odpy('ordpaly','fade')"><input name="" type="button" class="orderpay1btn" onclick="wait()"/></a>
	  </div>
      </c:if>
   
  </div>
  </div>
  </div>
<!--[if !IE]>中间完成<![endif]--> 
<!--[if !IE]>支付订单弹出层开始<![endif]-->
<div id="fade" class="black_overlay"></div>
<div id="ordpaly" class="ordersPaylayer" style="display: none"> 
	<div class="ordersPaylayer01">
		<h1>请付款</h1>
		<h2 onclick="gbpdpy('ordpaly','fade')"><span><a href="#" onclick="gbpdpy('ordpaly','fade')">关闭</a></span><samp><input name="" type="button"  class="Popuplogin01btn"/></samp></h2>
	</div>
	<div class="ordersPaylayer02">
		<div class="ordersPaylayer02_text">
		<h1><img src="${ctx }/Images/images/lay7.jpg" /></h1>
		<h2>请您在新打开的页面上完成付款!</h2>
		</div>
		<div class="ordersPaylayer02_text1">
			<h1>付款前请不要关闭此窗口<br />
			完成付款后请根据您的情况点击以下按钮</h1>
			<h2><span><a class="personlayer020301" href="${ctx }/orderManage.do">已完成付款</a></span><span style="display:none;"><a class="personlayer020302" href="${ctx }/infor.do?information.id=EE3098CA8B9E60E2AF53960B3DF763E0">付款遇到问题</a></span></h2>
			<h3 style="display:none;">》<a href="${ctx }/orderpay.do?orderId=${saleOrder.id}&addressId=${customerAddress.id }">返回选择其他付款方式</a></h3>
		</div>
	</div>
</div>
<!--[if !IE]>支付订单弹出层结束<![endif]--> 

<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
 
<!--  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" style="padding-top:0px;"></iframe>-->
</div>

</body>
</html>
