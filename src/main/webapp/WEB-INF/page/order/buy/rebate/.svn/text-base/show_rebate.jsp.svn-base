<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>返利列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/order/buy/rebate/list_rebateItem.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head> 
<body>
	<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px;">
				   	   	<s:hidden name="rebate.id" id="id" />
					    <s:hidden name="rebate.creatorId" />
						<s:hidden name="rebate.creatorName" />
						<s:hidden name="rebate.createTime" />
						<s:hidden name="rebate.modifierId" />
						<s:hidden name="rebate.modifierName" />
						<s:hidden name="rebate.modifyTime" />
						<s:hidden name="rebate.state" id="state" /> 
						<s:hidden id="handlerId" name="rebate.handlerId" />
						
						<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  	<tr>
								<td class='gridtitle' width="20%">返利单号</td>
							    <td class='gridbody' width="30%">
							    	${rebate.code}
							    </td>
							    <td class='gridtitle'>经手人</td>
							    <td class='gridbody'>
							    	 ${rebate.handlerName}
							    </td>
							</tr>
							<tr>
							    <td class='gridtitle'>开始日期</td>
							    <td class='gridbody'>
							    	<fmt:formatDate value="${rebate.startTime}" pattern="yyyy-MM-dd"/>
							    </td>
							    <td class='gridtitle'>结束日期</td>
							    <td class='gridbody'>
							    	<fmt:formatDate value="${rebate.endTime}" pattern="yyyy-MM-dd"/>
							    </td>
							</tr>
							<tr></tr>
						  	<tr>
						  		<td class='gridtitle'>备注</td>
						    	<td class='gridbody' colspan="3">
						    		<s:textarea id="remark" name="rebate.remark"  disabled="true" cols="60" rows="4"></s:textarea>
						    	</td>
						  	</tr>
						</table>
						<div class="clearfloat"></div>
						<div>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
				</div>
			</td>
		</tr>
	</table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="700px" height="300px"></iframe>
	</div>
</body>
</html>