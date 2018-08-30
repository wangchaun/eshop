<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/warehouse/warehousePosition/edit_warehousePosition.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="warehousePosition.id" id="id" />
			    		<s:hidden name="warehousePosition.creatorId" />
			    		<s:hidden name="warehousePosition.creatorName" />
			    		<s:hidden name="warehousePosition.createTime" />
			    		<s:hidden name="warehousePosition.modifierId" />
			    		<s:hidden name="warehousePosition.modifierName" />
			    		<s:hidden name="warehousePosition.modifyTime" />
			    		<s:hidden name="warehousePosition.state" />
			    		<s:hidden name="warehousePosition.warehouseId"/>
			    		<s:hidden name="warehousePosition.warehouseName"/>
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
				    		<tr>
								<td class='gridtitle'>仓位编号：</td>
								<td class='gridbody'>
									<s:textfield id="value" name="warehousePosition.code"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>仓位名称：</td>
								<td class='gridbody'>
									<s:textfield id="value" name="warehousePosition.name"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>序号：</td>
								<td class='gridbody'>
									<s:textfield id="sort" name="warehousePosition.sort"/>
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

