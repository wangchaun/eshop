<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>


<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/scripts/front/common/common.js?version=${version}"></script>
<script type="text/javascript" src="${ctx}/scripts/front/customer/cusLogin.js?version=${version}"></script>
<script type="text/javascript" src="${ctx}/scripts/front/customer/yc.js"></script>

<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/register_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2.css" />

<script type="text/javascript" >
	function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>


</head>
<body onload="showcheck()">
<!-- 跳转的页面 -->
<input type="hidden" id="localurl" value="${url }"/>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>方向<![endif]-->
    <div class="instructions"><a href="${ctx }/index.do">首页</a>&nbsp; >&nbsp;<span>用户注册</span></div>
	<div class="register1">
	<form action="" name="registerForm" id="registerForm" method="post">
		<div class="register_left">
	<div class="register01">商城会员注册</div>
	<div class="login0202_text1">
  <h1>登录账号：</h1>
  <h2><input onfocus="dlzh('zcyc1','','show')" onblur="dlzh('zcyc1','','hidden')" name="customer.code" type="text"  class="login0202_text1input" id="usercode" /></h2>
  <h3>*</h3>
  <h4 id="zcyc1" style="display: none;">用户名的长度只能在4到20字符之间！</h4>
  <h5 id="zcyc11" style="display: none;"><span><img src="${ctx}/Images/images/pass9.jpg" /></span></h5>
  </div>
   <div class="login0202_text1">
  <h1>密&nbsp;&nbsp;&nbsp;&nbsp;码：</h1>
  <h2><input onfocus="mmzh('acyc2','','show')" onblur="mmzh('zcyc2','','hidden')" name="customer.pwd" type="password"  class="login0202_text1input" id="userpwd"/></h2>
  <h3>*</h3>
  <h4 id="zcyc2" style="display:none;">6-24位字符，由字母，数字，下划线组成！</h4>
  <h5 id="zcyc21" style="display: none; color: steelblue;"><span><img src="${ctx}/Images/images/pass10.jpg" /></span>密码过于简单建议加强</h5>
  <div id="pwd_strength" class="forgotpassword02_text03" style="display:none;"><h1 style="float: left;text-align: center;width: 57px;">低</h1><h2>中</h2><h3>高</h3></div>
  

  
  </div>
    <div class="login0202_text1">
  <h1>重复密码：</h1>
  <h2><input onfocus="ccmm('zcyc3','','show')" onblur="ccmm('zcyc3','','hidden')" name="" type="password"  class="login0202_text1input" id="checkPwd"/></h2>
  <h3>*</h3>
    <h4 id="zcyc3" style="display:none;">请重复上面密码</h4>
    <h5 id="zcyc31" style="display: none;"><span><img src="${ctx}/Images/images/pass9.jpg" /></span>两次输入密码不一样</h5>
  </div>
    <div class="login0202_text1">
  <h1>邮箱地址：</h1>
  <h2><input onfocus="yydz('zcyc4','','show')" onblur="yydz('zcyc4','','hidden')" name="customer.email" type="text"  class="login0202_text1input" id="email"/></h2>
  <h3>*</h3>
  <h4 id="zcyc4" style="display:none;">请输入常用邮箱，用于找回密码！</h4>
  <h5 id="zcyc41" style="display: none;"><span><img src="${ctx}/Images/images/pass9.jpg" /></span>请输入正确格式的邮箱</h5>
  </div>
    <div class="login0202_text1">
  <h1>验&nbsp;证&nbsp;码：</h1>
  <h2><input onfocus="yzm('zcyc5','','show')" onblur="yzm('zcyc5','','hidden')" name="verifyCode" id="checkA" type="text"  class="login0202_text1input1"/></h2>
  <h3>*</h3>
<!--   <h2><img src="${ctx}/Images/images/y30.jpg" /></h2>-->
	<h2><div id="verifyImage" onclick="changeImage()">
	<img src="${ctxaccount }/account/getValidatePicture" id="Image"  style="cursor:pointer;" alt="看不清，换一张"/></div></h2>
	<h4 id="zcyc5" style="display:none; margin-left:23px;">请输入验证码，不区分大小写</h4>
	<h5 id="zcyc51" style="display: none;" ><span><img src="${ctx}/Images/images/pass8.jpg" /></span></h5>
  </div>
  <div class="login0202_text2">
   <div class="login0202_text201">
   <input style="cursor:text" id="agreeRegister" disabled="true" name="" type="button"  class="login0202_text1btn" value="同意协议并注册" onclick="submitRegisterForm()"/></div>
  <div class="login0202_text202">
  <h3><span><input name="" type="checkbox" value="" id="read"/></span><samp>我已经阅读并同意</samp></h3>
  <h2><a href="javascript:void(0)" onclick="chgb()">《麦芽网上商城用户协议书》</a></h2>
  </div>
  </div>
  <div id="szd" class="Agreement" style="display:none;">
  <div class="Agreement01">
  <span> 麦芽网上商城用户注册协议</span>
  本协议是您与麦芽网上商城所有者之间就京东商城网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击“同意以下协议，提交”按钮后，本协议即构成对双方有约束力的法律文件。<br />
  第1条 本站服务条款的确认和接纳<br />
  1.1本站的各项电子服务的所有权和运作权归京东商城所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。<br />
1.2用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。<br />
12.3本协议内容中以黑体、加粗、下划线、斜体等方式显著标识的条款，请用户着重阅读。<br />
12.4您点击本协议上方的“同意以下协议，提交”按钮即视为您完全接受本协议，在点击之前请您再次确认已知悉并完全理解本协议的全部内容。

  </div>
  </div>
	</div>
	</form>
	<div class="register_right">
	<div class="register02_right02">已有商城账号，请直接<a href="${ctx }/frontLogin.do">登录</a></div>
	 
	 
	<div style="padding-bottom:37px; float:left; height:37px;"></div>
	</div>
	</div>
  <!--[if !IE]>中间登录结束<![endif]--> 
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>


</body>
</html>
