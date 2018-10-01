<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/forgotPassword3_page.css" rel="stylesheet" type="text/css" />
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
<iframe width="100%" height=191 frameborder=0 scrolling=no src="header.htm" style="z-index:1000"></iframe> 
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>忘记密码1<![endif]-->
  <div class="forgotpassword">
  <div class="forgotpassword01">
  <h1>1、输入用户名</h1>
  <h2>2、账户验证及密码重置     </h2>
  <h3>3、密码修改成功</h3>
  </div>
    <div class="forgotpassword02">
	<div class="forgotpassword02_text">
	<div class="forgotpassword02_text01">您的邮箱是：<span>123***456@126.com</span>。我们已经发送一封确认信到您的邮箱中，请在收到确认信后，点击信中的链接进行验证。</div>
	<div class="forgotpassword02_text02"><input name="" type="button"  class="forgotpasswordbutton" onclick="window.open('forgotPassword4.html')"/></div>
	<div class="forgotpassword02_text03">收到不到邮箱验证？</div>
	<div class="forgotpassword02_text04">
	<ul>
	<li>验证码邮件可能在垃圾邮箱中，请仔细查找。</li>
	<li>由于网络原因，可能会有延迟，如果您10分钟没有收到邮件，请<span><a href="#">重新发送</a></span>。</li>
	</ul>
	</div>
	</div>
	
	</div>
  </div>
   <!--[if !IE]>忘记密码1<![endif]-->
  </div>
  
  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" style="padding-top:20px;"></iframe>
</div>


</body>
</html>
