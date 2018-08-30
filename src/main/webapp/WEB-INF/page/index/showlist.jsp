<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
<html>
  <head>
    <title>报表中心</title>

	<link href="${ctx}/styles/skin.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/styles/show.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/index/showlist.js"></script>
  </head>
  
  <body>
  		<table height="30px">
  			<tr>
  				<td>&nbsp;</td>
  				<td>&nbsp;</td>
  				<td>&nbsp;</td>
  			</tr>
  		</table>
  		<!-- 销售报表 -->
  		<c:if test="${type=='order'}">
  			<table width="80%" align="center" border="0" cellpadding="10" cellspacing="10">
  				<tr>
  					<td>
	  					<table border="0">
	  							<tr><td><a href="javascript:void(0)" onclick="addTab('销售汇总表','${ctx}/salesummary!list.do')"><img  src="${ctx }/formImg/202.gif" alt="销售汇总表" width="60" height="58" /></a></td></tr>
	  							<tr><td><a href="javascript:void(0)" onclick="addTab('销售汇总表','${ctx}/salesummary!list.do')">销售汇总表</a></td></tr>
	  					</table>
  					</td>
  					<td>
  						<table border="0">
		  					<tr><td><a href="javascript:void(0)" onclick="addTab('销售明细表','${ctx}/saledetail!list.do')"><img  src="${ctx }/formImg/302.gif" alt="销售明细表" width="60" height="58" /></a></td></tr>
		  					<tr><td><a href="javascript:void(0)" onclick="addTab('销售明细表','${ctx}/saledetail!list.do')">销售明细表</a></td></tr>
	  					</table>
  					</td>
  					<td>
  						<table border="0">
	  					<tr><td><a href="javascript:void(0)" onclick="addTab('销售排行榜','${ctx}/salerise!list.do')"><img  src="${ctx }/formImg/301.gif" alt="销售排行榜" width="60" height="58" /></a></td></tr>
	  					<tr><td><a href="javascript:void(0)" onclick="addTab('销售排行榜','${ctx}/salerise!list.do')">销售排行榜</a></td></tr>
	  					</table>
  					</td>
  				</tr>
  		</c:if>
  </body>
</html>
