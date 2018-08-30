<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
	<head>
		<title>错误页面</title>
		<script language="javascript">
		function showDetail()
		{
			$('detail_error_msg').toggle();
		}
		function checkParent(){
			if(window.parent.length>0){ 
               	window.parent.parent.location="${ctx}"; 
           	}else{
           		window.location="${ctx}";
           	}
           	
		}
	</script>
	</head>

	<body>

		<div id="content">
			<%
				//Exception from JSP didn't log yet ,should log it here.
				//String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
				//LogFactory.getLog(requestUri).error(exception.getMessage(), exception);
			%>

			<h5>
				抱歉！系统内部发生错误，请联系相关人员处理！<a href="javascript:checkParent();">回到首页</a>
			</h5>

			<!--	<p><a href="#" onclick="showDetail();">Administrator click here to get the detail.</a></p>-->

			<!--	<div id="detail_error_msg" style="display:none">-->
			<!--		<pre><%exception.printStackTrace(new java.io.PrintWriter(out));%></pre>-->
			<!--	</div>-->
		</div>
	</body>
</html>