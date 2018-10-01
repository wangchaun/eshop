<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/paidOrder.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/tuihuan.js"></script> 
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>

<body>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>麦芽网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">我的商城</a></div>
        <!--[if !IE]>订单中心<![endif]-->
        <script language=javascript id=clientEventHandlersJS>
<!--
var number=0;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = '${ctx }/Images/images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = '${ctx }/Images/images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = '${ctx }/Images/images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>订单中心</span><samp><IMG id="pic1" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM1>
            <ul>
<li><a href="${ctx }/orderManage.do">我的订单<span>(<samp>${total }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0" id="<c:if test="${iscancel=='0' }">visited</c:if>">待付款订单<span>(<samp>${payment }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=1" id="<c:if test="${iscancel=='1' }">visited</c:if>">已取消订单<span>(<samp>${cancelOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=1">已发货商品<span>(<samp>${deliveryOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=0">未发货商品<span>(<samp>${deliveryOrder2 }</samp>)</span></a></li>
<li id="bor"><a href="${ctx }/pingjiaTwo.do" >待评价商品<span>(<samp>${commentOrder}</samp>)</span></a></li>
</ul>
          </div>
        </div>
		 <!--[if !IE]>交易中心<![endif]-->
         <c:if test="${customer.type == '1'}">
         	 <div class="couponleft_text">
	          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>销售中心</span><samp><IMG id="pic2" 
	                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
	                 ></samp></A></div>
	          <div class="couponleft_text02" id=LM2 >
	            <ul>
	              <li><a href="sales.html">销售/收入</a></li>
	              <li id="bor"><a href="salesAnalysis.html" >销售/收入分析</a></li>
	            </ul>
	          </div>
	        </div>
         </c:if>
        <!--[if !IE]>交易中心<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>交易中心</span><samp><IMG id="pic3" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM3 >
            <ul>
              <li><a href="${ctx }/tuihuan.do">退货</a></li>
              <li><a href="${ctx }/myMessage.do">我的咨询</a></li>
              <li id="bor"><a href="${ctx }/myComment.do">我的评价</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>客户服务<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>客户服务</span><samp><IMG id="pic4" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM4>
            <ul>
<li><a href="${ctx }/myMessage.do">我的咨询</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>个人中心<![endif]-->
        <div class="couponleft_text" >
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(5)" href="javascript:void(null)" ><span>个人中心</span><samp><IMG id="pic5" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM5>
            <ul>
            <li><a href="${ctx }/myinfor.do">个人信息</a></li>
            <li><a href="${ctx }/security.do" id="visited">安全设置</a></li>
            <li id="bor"><a href="${ctx }/myaddress.do" >地址管理</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>end<![endif]-->
      </div>  
<!--[if !IE]>右侧<![endif]-->
<div class="coupon_right">
<div class="courht">
<div class="courht_title">
<span><c:if test="${iscancel == '0' }">待付款订单</c:if><c:if test="${iscancel == '1' }">取消订单</c:if></span>
</div>
<!--[if !IE]>待付款订单列表<![endif]-->
<div class="courht_text2">
<div class="table">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="100" height="32" align="center" valign="middle">订单号</td>

    <td width="293" align="center" valign="middle">商品</td>
    <td width="95" align="center" valign="middle">收货人</td>
    <td width="116" align="center" valign="middle">金额（元）</td>
    <td width="110" align="center" valign="middle">下单时间</td>
    <td width="103" align="center" valign="middle">订单状态 </td>
	<td width="135" align="center" valign="middle">操作</td>
  </tr>
</table>
</div>
<div class="table1">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <c:forEach items="${saleOrderList}" var="order">
	  <tr>
	    <td width="100" height="45" align="center" valign="middle" class="leftborder">${order.code }</td>
	    <td width="293" align="left" valign="middle">
		<c:forEach items="${order.goodlist}" var="good">
			<div class="phlist">
			<h2><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx }${good.pic }" border="0" /></a></h2>
			<h3><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }</a></h3>
			</div>
		</c:forEach>
		</td>
	    <td width="95" align="center" valign="middle">${order.customerName }</td>
	    <td width="116" align="center" valign="middle"><span class="ys1"><span>¥</span>${order.orderMoney }<br />${order.paymentName }</span></td>
	    <td width="110" align="center" valign="middle"><div class="ys1"><fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd"/></div></td>
	    <td width="103" align="center" valign="middle">
	    	<c:if test="${order.paymentState=='0' && iscancel == '0'}">等待付款</c:if>
	    	<c:if test="${iscancel == '1'}">订单已取消</c:if>
	    </td>
		<td width="135" align="center" valign="middle">
		<div class="ys2">
			<c:if test="${iscancel == '0' }">
			    <!-- 乾付宝支付按钮 onclick="bankPay('${order.id }','${order.bankCode }')"-->
			    <c:if test="${order.bankCode!='card'}">
				<a href="${ctx}/wait.jsp" >立即支付</a><br /> 
				</c:if>
				<!-- 一卡通支付按钮 
			    <c:if test="${order.bankCode=='card'}">
				<a href="javascript:void(0);" onclick="paycard('${saleOrder.id}')">立即支付</a><br /> 
				</c:if>
				-->
				<a href="${ctx }/showOrder.do?saleOrder.id=${order.id }">查看</a>
				<span class="middlesev">|</span>
				<a href="javascript:void(0);" onclick="updateOrderState('${order.id }')">取消</a>
			</c:if>
			<c:if test="${iscancel == '1' }">
				<a href="${ctx }/showOrder.do?saleOrder.id=${order.id }">查看</a>
			    <c:forEach items="${order.goodlist}" var="good">
				 
				<h2><a href="javascript:void(0);" onclick="addGoodToCart('${good.id }')">加入购物车</a></h2>
				</c:forEach>
			</c:if>
		</div>
		</td>
	  </tr>
  </c:forEach>
  
</table>
</div>
</div>
<!--[if !IE]>列表结束<![endif]-->
<!--[if !IE]>您可能感兴趣的商品<![endif]-->
<div class="courht_title1">
<span>您可能感兴趣的商品</span>
</div>
<div class="courht_photo">
<div class="photolist02">
                    <ul>
                      <!--[if !IE]>第一个产品<![endif]-->
                     <c:forEach items="${goodList1}" var="good" begin="0" end="3">
	                      <li> <a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx }${good.pic }" /></a>
	                        <p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<span>${good.introBrief }</span></a></p>
	                        <h1><span class="font2">¥${good.price }</span><span>市场价：</span><samp><span class="font">¥</span>${good.priceMarket }</samp></h1>  
	                      </li>
                      </c:forEach>

                      <!--[if !IE]>第一个产品<![endif]-->

                    </ul>
            </div>
		  </div>
				  <!--[if !IE]>你可能感兴趣的产品结束<![endif]-->
</div>
</div><!--[if !IE]>右侧结束<![endif]-->
</div>
</div>
<!--[if !IE]>待付款订单完成<![endif]-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
  </div>
</body>
</html>

