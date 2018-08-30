<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>角色用户列表</title>
    <link href="${ctx }/styles/skin.css" rel="stylesheet" type="text/css">
    <script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
    <script type="text/javascript" src="${ctx }/scripts/system/SysAdvPower/list_role_user.js"></script>
  </head>
  
  <body>
 	<table border="0">
 	<tr height="510" valign="top">
	 		<td height="100%" valign="top">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <c:forEach var="lists" items="${requestScope.userRolelist}"  varStatus="i">
			    	<tr valign="top" height="10">
			    		<td valign="top"><a style="font-size: 14;text-decoration:none;" id="${i}" href="javascript:void(0)"  onclick="selectPower('${lists.id}')">${lists.name}</a></td>
			    	</tr>
			    	<c:forEach items="${lists.userlist}" var="userlist"  >
			    		<tr valign="top" height="10">
			    			<td valign="top"><li><a href="javascript:void(0)" onclick="selectPower('${userlist.roleId}')" >${userlist.name}</a></li></td>
			    		</tr>
			    	</c:forEach>
			    </c:forEach>
			    </table>
		    </td>
		    <td>&nbsp;&nbsp;</td>
		    <td height="100%" valign="top">
				  	<div id="select" >
						<iframe frameborder="0" id="selectDataPage" width="700px" height="750px"></iframe>
					</div>
		    </td>
	    </tr>
    </table>
  </body>
</html>
