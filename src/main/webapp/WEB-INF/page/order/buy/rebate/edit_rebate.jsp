<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑供应商返利</title>
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
	<script type="text/javascript" src="${ctx }/scripts/order/buy/rebate/edit_rebate.js"></script>
	
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
				<form action="" id="rebateForm" method="post">
					<s:hidden name="rebate.id" id="id" />
					<s:hidden name="rebate.creatorId" />
					<s:hidden name="rebate.createTime" />
					<s:hidden name="rebate.createName" />
					<s:hidden name="rebate.modifierId" />
					<s:hidden name="rebate.modifierName" />
					<s:hidden name="rebate.modifyTime" />
					<s:hidden name="rebate.state" id="state" />
			   		
			   		<table width="98%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
					  <tr>
							<td class='gridtitle' >返利单号</td>
						    <td class='gridbody' >
						    	<s:textfield name="rebate.code" id="code"  readonly="true"/>
						    </td>
						    <td class='gridtitle' >经手人</td>
						    <td class='gridbody' >
						    	<s:hidden id="handlerId" name="rebate.handlerId" /> 
						      	<s:textfield id="handlerName" name="rebate.handlerName" readonly="true" />
						    </td>
						</tr>
						<tr>
						    <td class='gridtitle'>开始日期</td>
						    <td class='gridbody'>
						    	<input type="text" name="rebate.startTime" id="startTime" readonly="true"
						    	onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate value="${rebate.startTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						    <td class='gridtitle'>结束日期</td>
						    <td class='gridbody'>
						    	<input name="rebate.endTime" id="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
						    	readonly="true" value="<fmt:formatDate value="${rebate.endTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						</tr>
						<tr></tr>
					  	<tr>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="3">
					    		<s:textarea id="remark" name="rebate.remark" cols="55" rows="4"></s:textarea>
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

