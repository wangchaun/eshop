<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/phone1_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="pro_dropdown_2/pro_dropdown_2.css" />
<script src="js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/index20110925_mini.js"></script>
<script language="javascript" src="js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="js/jquery1.js"></SCRIPT>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
  <iframe width="100%" height=191 frameborder=0 scrolling=no src="header1.htm" style="z-index:1000"></iframe>
  <!--[if !IE]>待付款订单<![endif]-->
  <div class="content">
    <div class="coupon">
      <!--[if !IE]>左侧<![endif]-->
      <div class="coupon_left">
<div class="couponleft_title"><a href="myshop.html">麦芽网上商城</a></div>
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
        //treePic.src = 'images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = 'images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = 'images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>订单中心</span><samp><IMG id="pic1" 
                  height=14 src="images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM1>
<ul>
<li><a href="myOrder.html" id="visited">我的订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="payOrder.html" >待付款订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="#" >已取消订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="shippedGoods.html" >已发货商品<span>(<samp>2</samp>)</span></a></li>
<li><a href="#" >未发货商品<span>(<samp>2</samp>)</span></a></li>
<li id="bor"><a href="pingjia2.html" >待评价商品<span>(<samp>2</samp>)</span></a></li>
</ul>
</div>
</div>
<!--[if !IE]>交易中心<![endif]-->
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>交易中心</span><samp><IMG id="pic2" 
                  height=14 src="images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM2>
<ul>
<li><a href="myFavorites.html">我的收藏<span>(<samp>2</samp>)</span></a></li>
<li id="bor"><a href="coupon.html" >我的优惠券<span>(<samp>2</samp>)</span></a></li>
</ul>
</div>
</div>
<!--[if !IE]>客户服务<![endif]-->
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>客户服务</span><samp><IMG id="pic3" 
                  height=14 src="images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM3>
<ul>
<li><a href="tuihuan.html">返修/退换货</a></li>
<li><a href="zixun.html">我的咨询</a></li>
<li id="bor"><a href="mycomment.html" >我的评价</a></li>
</ul>
</div>
</div>
<!--[if !IE]>个人中心<![endif]-->
<div class="couponleft_text">
<div class="couponleft_text01"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>个人中心</span><samp><IMG id="pic4" 
                  height=14 src="images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02" id=LM4>
<ul>
<li><a href="information.html">个人信息</a></li>
<li><a href="security.html">安全设置</a></li>
<li id="bor"><a href="address.html" >地址管理</a></li>
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
		   <h1>1、验证原绑定手机     </h1>
		   <h2>2、验证新绑定手机   </h2>
		   <h3>3、修改成功</h3>
		   </div>
		   <div class="modify1">
		   <div class="modify101">
		   <h1><span>*</span>输入新手机号码：</h1>
		   <h3><input name="" type="text"  class="pickinput1" /></h3>
		   <h4><input name="" type="button"  class="forgotpasswordbutton2" /></h4>
		   <h4><input name="" type="button"  class="forgotpasswordbutton1" /></h4>
		   </div>
		   <div class="modify103">
		   <h1><img src="images/sec5.jpg" /></h1>
		   <h2>验证码已发出，请注意查收短信，如果没有收到，您可以在<span>60</span>秒后点击获取按钮重新发送。</h2>
		   </div>
		     <div class="modify101">
		   <h1><span>*</span>验证码：</h1>
		   <h2><input name="" type="input"  class="pickinput"/></h2>
		   <h3>验证码是6位数字或字母</h3>
		   </div>
		   <div class="modify104"><input name="" type="button"  class="forgotpasswordbutton" onclick="window.open('phone2.html')"/></div>
		   </div>
        </div>
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>

  
  <!--[if !IE]>待付款订单完成<![endif]-->
  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" style="padding-top:20px;"></iframe>
</div>
</body>
</html>
