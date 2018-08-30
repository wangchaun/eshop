<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑促销栏位</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/store/promotecolumn/edit_Promotecolumn.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="saveForm" method="post" action="">
						<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
							<s:hidden name="promotecolumn.id" id="id"/>	
							<tr>
								<td class='gridtitle' width="15%">编号</td>
						    	<td class='gridbody' width="35%">
						    		<s:textfield name="promotecolumn.code" id="code"  readonly="true"/>
						    	</td>
						    	<td class='gridtitle' width="15%">栏位名称</td>
						    	<td class='gridbody' width="35%">
						    		<s:textfield name="promotecolumn.name" id="name"/>
						    	</td>
							</tr>
							<tr>
								<td class='gridtitle'>栏位编号</td>
						    	<td class='gridbody'">
						    		<s:textfield name="promotecolumn.columnNo" id="columnNo"/>
						    	</td>
							
						    	<td class='gridtitle'>栏位描述</td>
						    	<td class='gridbody'>
						    		<s:textfield name="promotecolumn.describes" id="describes"/>
						    	</td>
						    </tr>
							<tr>	
								<td class='gridtitle'>备注</td>
						    	<td class='gridbody' colspan="3">
						    		<s:textarea name="promotecolumn.remark" id="remark" cols="60" rows="3"/>
						    	</td>
							</tr>
						</table>
			    	</form>
			    </div>	
	    </tr>
	</table>
</body>
</html>
