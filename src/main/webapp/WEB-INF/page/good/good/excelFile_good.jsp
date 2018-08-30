<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>excel导入</title>
    <%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
  	<script type="text/javascript">
    function sleep(numberMillis) { 
	   var now = new Date();
	   var exitTime = now.getTime() + numberMillis;  
	   while (true) { 
	       now = new Date(); 
	       if (now.getTime() > exitTime)    return;
	    }
    }
	function getExcelDate() {
		var realpath = $('#fileBrowser').val();
	     $("#datefile").hide();
	     $("#loading").show();
		if(confirm("你确定要导入吗")){
			$.ajax({
				  type: "POST",
				  async: false,
				  cache: false,
				  url: ctx+"/good!getExcelDate.do",
				  data: "fileBrowser=" + realpath,
				  success : function(returnData){
						if(returnData == 'true'){
							$("#loading").html('<img src="${ctx}/styles/success.jpg"/><br/><br/><br/><span style="color:red;font-size:16px;">导 入 成 功</span>');
							sleep(3000);
							window.parent.location.href = ctx+"/good!list.do";
						
						}else{
							$("#loading").html('<img src="${ctx}/styles/error.jpg"/><br/><br/><br/><span style="color:red;font-size:16px;">导入失败，请重新操作</span>');
						}
				  },
				  error : function(){
						$("#loading").html('<img src="${ctx}/styles/error.jpg"/><br/><br/><br/><span style="color:red;font-size:16px;">系 统 有 误</span>');
				  } 
			});
		}
	}
  	</script>
  </head>
  
  <body>
  		<br/><br/>
  		<div id="datefile" align="center" style="height:100px;border:1px">
	    		<input type="hidden" id="fileBrowser" name="fileBrowser" size="30" value="${topath}" />
	    		<input type="hidden" id="isok" name="isok" value="${isOk}"/>
	    		<c:if test="${isOk==true}">
	    			<h2 style="color: red;">${fileName}文件上传成功,请导入</h2><br/>
	    			<input type="button" name="button" id="savebtn" size="30" value="确定导入" onclick="getExcelDate()" />
	    		</c:if>
	    		<c:if test="${isOk==false}">
	    			<h2 style="color: red;">${fileName}文件上传失败,请重新上传</h2>
	    		</c:if>
    	</div>
    	<div id="loading" align="center" style="display:none">
    		<img src="${ctx}/styles/04.gif"/><br/><br/><br/><span style="color:red;font-size:16px;">数据在导入,请耐心等待</span>
    	</div>
  </body>
</html>
