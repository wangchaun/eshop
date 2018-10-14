<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/forgotPassword_page.css" rel="stylesheet" type="text/css" />
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
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>忘记密码1<![endif]-->
  <div class="forgotpassword">
  <div class="forgotpassword01">
  <h1>1、输入用户名</h1>
  <h2>2、账户验证及密码重置  </h2>
  <h3>3、密码修改成功</h3>
  </div>
    <div class="forgotpassword02">
	<div class="forgotpassword0201">
	<div class="forgotpassword0201_text">
	<h1>账户名：</h1>
	<h2><input name="" type="text"  class="forgotpasswordinput" value="用户名/邮箱/已验证手机"/></h2>
	</div>
	<div class="forgotpassword0201_text">
	<h1>验证码：</h1>
	<h2><input name="" type="text"  class="forgotpasswordinput1"/></h2>
	<h3><img src="${ctx}/Images/images/pass3.jpg" /></h3>
	<h3>看不清楚，</h3>
	<h4><a href="#">换一张</a></h4>
	</div>
	<div class="forgotpassword0201_text">
	<h1></h1>
	<h6>
	<span><input name="" type="button"  class="forgotpasswordbutton" onclick="window.open('forgotPassword2.html')"/></span>
	<samp><a href="#">返回首页</a></samp>
	</h6>
	</div>
	</div>
	
	</div>
  </div>
   <!--[if !IE]>忘记密码1<![endif]-->
  </div>

  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>


</body>
</html>
