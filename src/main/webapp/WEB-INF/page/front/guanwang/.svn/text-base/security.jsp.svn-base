<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/security_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>云岗网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">云岗网上商城</a></div>
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
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0">待付款订单<span>(<samp>${payment }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=1">已取消订单<span>(<samp>${cancelOrder }</samp>)</span></a></li>
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
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14></samp></A></div>
          <div class="couponleft_text02" id=LM3 >
            <ul>
              <li><a href="${ctx }/myFavorite.do">我的收藏<span>(<samp>${favolist }</samp>)</span></a></li>
              <li id="bor" style="display:none;"><a href="${ctx }/myCoupon.do" >我的优惠券<span>(<samp>${couponList }</samp>)</span></a></li>
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
              <li><a href="${ctx }/tuihuan.do">退货</a></li>
              <li><a href="${ctx }/myMessage.do">我的咨询</a></li>
              <li id="bor"><a href="${ctx }/myComment.do">我的评价</a></li>
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
          <div class="courht_title"> <span>安全设置</span> </div>
           <div class="security">
		   <div class="security01">
		   <h1>您目前的</h1>
		   <h2>安全级别较</h2>
		   <h3>
		   	   <c:if test="${customer.isPinlessmobile=='0' && customer.isPinlessemail=='0' }">低</c:if>
		   	   <c:if test="${customer.isPinlessmobile=='1' || customer.isPinlessemail=='1' }">中</c:if>
		   	   <c:if test="${customer.isPinlessmobile=='1' && customer.isPinlessemail=='1' }">高</c:if>
		   </h3>
		   <h4>，为了您的账户安全赶快去验证吧！</h4>
		   </div>
		   <div class="security02">
		   <h1>
		   <samp><img src="${ctx}/Images/images/wan9.jpg" /></samp>
		   <span>强度高</span>
		   </h1>
		   <h2>登录密码</h2>
		   <h3><img src="${ctx}/Images/images/wan8.jpg" /></h3>
		   <h4>安全性高的密码可以使账户更安全，建议您定期更换密码。</h4>
		   <h5><input name="" type="button" class="person04btn"  value="修改" onclick="window.open('${ctx }/password.do')"/></h5>
		   </div>
		   
		   <div class="security02">
			   <h1>
				   <samp>
				   	   <c:if test="${customer.isPinlessemail=='0'}"><img src="${ctx}/Images/images/wan10.jpg" /></c:if><c:if test="${customer.isPinlessemail=='1'}"><img src="${ctx}/Images/images/wan9.jpg" /></c:if>
				   </samp>
				   <span><c:if test="${customer.isPinlessemail=='0'}">未验证</c:if><c:if test="${customer.isPinlessemail=='1'}">已验证</c:if></span>
			   </h1>
			   <h2>邮箱验证</h2>
			   <h3><img src="${ctx}/Images/images/wan8.jpg" /></h3>
			   <h4>验证后可用于邮箱找回密码、接收订单提醒等，保障您的账户更加安全。</h4>
			   <h5><input name="" type="button" class="person04btn"  value="修改" onclick="window.open('${ctx }/mail.do')"/></h5>
		   </div>
		   
		   <div class="security02">
			   <h1>
				   <samp>
				   	   <c:if test="${customer.isPinlessmobile=='0'}"><img src="${ctx}/Images/images/wan10.jpg" /></c:if><c:if test="${customer.isPinlessmobile=='1'}"><img src="${ctx}/Images/images/wan9.jpg" /></c:if>
				   </samp>
				   <span><c:if test="${customer.isPinlessmobile=='0'}">未验证</c:if><c:if test="${customer.isPinlessmobile=='1'}">已验证</c:if></span>
			   </h1>
			   <h2>绑定手机</h2>
			   <h3><img src="${ctx}/Images/images/wan8.jpg" /></h3>
			   <h4>绑定后可用于手机找回密码、接收手机动态验证码等，保证您的账户更加安全。</h4>
			   <h5><input name="" type="button" class="person04btn"  value="修改" onclick="window.open('${ctx }/updatePhone.do')"/></h5>
		   </div>
		   </div>
        </div>
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
  </div>
  <!--[if !IE]>待付款订单完成<![endif]-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
