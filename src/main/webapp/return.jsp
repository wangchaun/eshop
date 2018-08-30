<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>壹万店深圳站-网购电视,空调价格,家电导购,深圳家电网购全城最低价</title>


<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/customer/cusLogin.js"></script>

<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/register_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2.css" />

<script type="text/javascript" >
	function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>


</head>
<body onload="showcheck()">
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>方向<![endif]-->
    <div class="instructions"><a href="${ctx }/index.do">首页</a>&nbsp; >&nbsp;<span>用户注册</span></div>
	<div class="register1">
	<form action="" name="registerForm" id="registerForm" method="post">
		<div class="register_left">
	<div class="register01">壹万店会员注册</div>
	<div class="login0202_text1">
  <h1>登录账号：</h1>
  <h2><input name="customer.code" type="text"  class="login0202_text1input" id="usercode"/></h2>
  <h3>*</h3>
  <h4>用户名的长度只能在4到20字符之间！</h4>
  </div>
   <div class="login0202_text1">
  <h1>密&nbsp;&nbsp;&nbsp;&nbsp;码：</h1>
  <h2><input name="customer.pwd" type="password"  class="login0202_text1input" id="userpwd"/></h2>
  <h3>*</h3>
  <h4>6-24位字符，由字母，数字，下划线组成！</h4>
  </div>
    <div class="login0202_text1">
  <h1>重复密码：</h1>
  <h2><input name="" type="password"  class="login0202_text1input" id="checkPwd"/></h2>
  <h3>*</h3>
  </div>
    <div class="login0202_text1">
  <h1>邮箱地址：</h1>
  <h2><input name="customer.email" type="text"  class="login0202_text1input" id="email"/></h2>
  <h3>*</h3>
  </div>
    <div class="login0202_text1">
  <h1>验&nbsp;证&nbsp;码：</h1>
  <h2><input name="checkA" id="checkA" type="text"  class="login0202_text1input1"/></h2>
  <h3>*</h3>
<!--   <h2><img src="${ctx}/Images/images/y30.jpg" /></h2>-->
	<div class=""><span id="showcheckA" style="font-size:16px;" onclick="showcheck()"></span></div>
  </div>
  <div class="login0202_text2">
   <div class="login0202_text201"><input name="" type="button"  class="login0202_text1btn" value="提交" onclick="submitRegisterForm1()"/></div>

  
  </div>

	</div>
	</form>
	<div class="register_right">
	<div class="register02_right02">已有壹万店账号，请直接<a href="${ctx }/frontLogin.do">登录</a></div>
	<div class="register02_right01">其他登录方式</div>
	<div class="register02_right01"><a href="#"><img src="${ctx}/Images/images/lon1.jpg" border="0" alt="QQ登录" /></a></div>
<!--	<span id="qqLoginBtn"></span> -->
	<div class="register02_right01"><a href="#"><img src="${ctx}/Images/images/lon3.jpg" border="0"  alt="支付宝登录"/></a></div>
	<div class="register02_right01"><a href="#"><img src="${ctx}/Images/images/lon2.jpg" id="wb_connect_btn" border="0"  alt="新浪微博登录"/></a></div>
<!--	<span sid="wb_connect_btn"></span>-->
	</div>
	<div style="padding-bottom:37px; float:left; height:37px;"></div>
	</div>
	</div>
  <!--[if !IE]>中间登录结束<![endif]--> 
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>


</body>
</html>
