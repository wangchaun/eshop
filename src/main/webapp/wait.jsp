<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>待开发</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <script language="JavaScript" type="text/javascript">
	function delayURL(url) {
		var delay = document.getElementById("tag").innerHTML;
		if(delay > 0) {
			delay--;
			document.getElementById("tag").innerHTML = delay;
		} else {
			window.top.location.href = url;
		}
		setTimeout("delayURL('" + url + "')", 1000);
	}
  </script>
  <body>
     <div style="border:1px solid #ddd;width:400px;height:200px;margin-left:200px;margin-top:100px;">
      <div style="width:400px;height:100px; "></div>
      <span>目前暂时只能用一卡通来支付!</span>
      <span id="tag" style="color: red;font-size: 25">3</span>  秒钟之后,自动跳转
      <span>网上支付。。。正在开发</span>
     </div> 
  </body>
  <script type="text/javascript">
  delayURL("<%=basePath%>customersManage.do");
  </script>
</html>
