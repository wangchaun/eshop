<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>文件上传</title>
    <%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
  	<script type="text/javascript">
	function getExcelPath(fileBrowser){
		if (navigator.userAgent.indexOf("MSIE")!=-1){ 
	        readFileIE(fileBrowser);   
	    }else if (navigator.userAgent.indexOf("Firefox")!=-1 || navigator.userAgent.indexOf("Mozilla")!=-1){
	        readFileFirefox(fileBrowser);
	    }else{
	        alert("Not IE or Firefox (userAgent=" + navigator.userAgent + ")"); 
	    }
	}   
	function readFileFirefox(fileBrowser) {
	    try {   
	        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");   
	    } catch (e) {   
	           
	        return;
	    }   
	    var fileName=fileBrowser.value;   
	    var file = Components.classes["@mozilla.org/file/local;1"].createInstance(Components.interfaces.nsILocalFile);   
	    try {   
	        file.initWithPath( fileName.replace(/\//g, "\\\\") );   
	    }catch(e) {   
	        if (e.result!=Components.results.NS_ERROR_FILE_UNRECOGNIZED_PATH) throw e;   
	        return;   
	    }   
	    if ( file.exists() == false ) {   
	        alert("File '" + fileName + "' not found.");   
	        return;   
	    }   
	    //alert(file.path);
	}
	function readFileIE(fileBrowser) {
	    //alert(document.getElementById("fileBrowser").value);   
	}
	function getExcelDate() {
		var realpath = $('#fileupload').val();
		var reg = /[^\.](\.xls)$/;   
        if(!reg.test(realpath)){
        	alert("你上传文件格式不对,请上传Excel文件");
        	return false;
        }
     }
	
  	</script>
  </head>
  
  <body>
  		<br/><br/>
  		<div align="center">
	  		<form action="${ctx}/good!upload.do" method="post" onsubmit="return getExcelDate()"  enctype="multipart/form-data">
			    	<input type="file"  name="fileupload" id="fileupload" onchange="getExcelPath(this)"><br/>
			    	<br/><br/>
		    		<span style="color:red">(此处只能上传.xls结尾的文件)</span>
		    		<br/><br/>
			    	<input type="submit" value="上传">
	   		 </form>
   		 </div>
  </body>
</html>
