<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/password1_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <!--[if !IE]>待付款订单<![endif]-->
  <div class="content">
    <div class="coupon">
      <!--[if !IE]>左侧<![endif]-->
      <div class="coupon_left">
<div class="couponleft_title"><a href="myshop.html">云岗网上商城</a></div>
<!--[if !IE]>订单中心<![endif]-->
<div class="couponleft_text">
<script language=javascript id=clientEventHandlersJS>
<!--
var number=0;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = '${ctx}/Images/images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = '${ctx}/Images/images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = '${ctx}/Images/images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>订单中心</span><samp><IMG id="pic1" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
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
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>交易中心</span><samp><IMG id="pic2" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM2>
<ul>
<li><a href="myFavorite.do">我的收藏<span>(<samp>2</samp>)</span></a></li>
<li id="bor" style="display:none;"><a href="coupon.html" >我的优惠券<span>(<samp>2</samp>)</span></a></li>
</ul>
</div>
</div>
<!--[if !IE]>客户服务<![endif]-->
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>客户服务</span><samp><IMG id="pic3" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM3>
            <ul>
              <li><a href="${ctx }/tuihuan.do">返修/退换货</a></li>
              <li><a href="${ctx }/myMessage.do">我的咨询</a></li>
              <li id="bor"><a href="${ctx }/myComment.do" >我的评价</a></li>
            </ul>
</div>
</div>
<!--[if !IE]>个人中心<![endif]-->
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>个人中心</span><samp><IMG id="pic4" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM4>
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
          <div class="modify">
            <h1>1、密码修改 </h1>
            <h2>2、修改成功</h2>
          </div>
          <div class="modify1">
           
		   <div class="forgotpassword02_text">
	<div class="forgotpassword02_text01">
	<h1><img src="${ctx}/Images/images/pass13.jpg" /></h1>
	<h2>恭喜您，密码修改成功！</h2>
	</div>
	<div class="forgotpassword02_text02">
	您可以<span><a href="${ctx }/frontLogin.do">立即登录</a></span>，或返回<span><a href="${ctx }/index.do">官网首页</a></span>
	</div>
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
