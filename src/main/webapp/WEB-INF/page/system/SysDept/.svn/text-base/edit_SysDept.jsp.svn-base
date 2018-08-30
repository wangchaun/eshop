<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>Role Information</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript"  src="${ctx}/scripts/system/SysDept/edit_SysDept.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="saveForm" method="post" action="">
			    	    <s:hidden name="sysDept.id" id="id" />
			    		<s:hidden name="sysDept.creatorId" />
			    		<s:hidden name="sysDept.creatorName" />
			    		<s:hidden name="sysDept.createTime" />
			    		<s:hidden name="sysDept.modifierId" />
			    		<s:hidden name="sysDept.modifierName" />
			    		<s:hidden name="sysDept.modifyTime" />
			    		<s:hidden name="sysDept.state" />
			    		
						<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">						
							<tr>
								<td class='gridtitle'>部门名称</td>
								<td class='gridbody'>
									<s:textfield name="sysDept.name" id="name" /><font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>部门编号</td>
								<td class='gridbody'>
									<s:textfield name="sysDept.code" id="code" onblur="isCodeExisted()" /><font color="red">*</font>
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

