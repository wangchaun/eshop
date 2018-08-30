
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>查看评论</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/vip/wareComment/show_wareComment.js"></script>
	<style type="text/css">
		.tabtop {
			height:40px;
			font-size:12px;
		}
		.tabtop .title {
			font-size:14px;
			font-weight:bold;
		}
		.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
			clear:both;
   			height:0;
    		font-size: 1px;
    		line-height: 0px;
		}
		.border {
			font-size:12px;
    		border:1px solid #90B9DE;
		}
		.bordertd {
			font-size:12px;
		}
	</style>
</head>
<body>
	 <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px;">
					<form action="" id="saveForm" name="saveForm">
				   	    <s:hidden name="wareComment.id" id="id" />
				   	    <s:hidden name="wareComment.creatorId" />
				   	    <s:hidden name="wareComment.code" />
				   	    <s:hidden name="wareComment.state" id="state"/>
				   		<table width="98%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridbody'style="padding-left:50px" >
						    	评论时间:&nbsp;&nbsp;<fmt:formatDate value="${wareComment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						    </td>
						  </tr>
						  <tr>
						    <td class='gridbody'style="padding-left:50px" >
						    	评论商品:&nbsp;&nbsp;${wareComment.goodName}
						    </td>
						  </tr>
						  <tr>
						    <td class='gridbody'style="padding-left:50px" >
						    	评 论 人:&nbsp;&nbsp;${wareComment.creatorName}
						    </td>
						  </tr>
						  <tr>
					    	<td class='gridbody'style="padding-left:50px" >
					    		评论内容:&nbsp;&nbsp;${wareComment.content}
					    	</td>
						  </tr>
						  <tr></tr>
						  <tr>
						  	<td class='gridbody'>
						  		<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="gdcn-table-bgcolor">
					  				<c:forEach items="${wareCommentList}" var="revoverys">
								  	  <tr>
								  		<td class='gridbody' style="text-align:right;padding-right:20px">
								  			回复人：${revoverys.creatorName}
								  			&nbsp;&nbsp;&nbsp;&nbsp;
								  			回复时间：<fmt:formatDate value="${revoverys.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
								  		</td>
									  </tr>
									  <tr>
								  		<td class='gridbody'>
								  			&nbsp;&nbsp;&nbsp;${revoverys.content}
								  		</td>
									  </tr>
								  </c:forEach>
						  		</table>
						  	</td>
						  </tr>
						</table>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

