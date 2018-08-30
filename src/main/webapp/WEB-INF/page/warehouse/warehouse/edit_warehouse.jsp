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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/warehouse/warehouse/edit_warehouse.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="warehouse.id" id="id" />
			    		<s:hidden name="warehouse.code" />
			    		<s:hidden name="warehouse.creatorId" />
			    		<s:hidden name="warehouse.creatorName" />
			    		<s:hidden name="warehouse.createTime" />
			    		<s:hidden name="warehouse.modifierId" />
			    		<s:hidden name="warehouse.modifierName" />
			    		<s:hidden name="warehouse.modifyTime" />
			    		<s:hidden name="warehouse.state" />
				    	
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
					    	<tr>
								<td class='gridtitle'>仓库编号：</td>
								<td class='gridbody'>
									<s:textfield id="code" name="warehouse.code" disabled="true"/>				
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>仓库名称：</td>
								<td class='gridbody'>
									<s:textfield id="name" name="warehouse.name" />	
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>地区：</td>
								<td class='gridbody'>
								<s:hidden name="warehouse.areaId" id="areaIds"/>
								<s:textfield name="warehouse.areaName" id="areaNames" onclick="selectArea()"/>
							</td>
						</tr>
							<!-- 
								<tr>
								<td class='gridtitle'>序号：</td>
								<td class='gridbody'>
									<s:textfield id="sort" name="warehouse.sort"/>	
								</td>
							</tr>
							 -->
							<tr>
								<td class='gridtitle'>备注：</td>
								<td class='gridbody'>
									<s:textfield id="remark" name="warehouse.remark"/>
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

