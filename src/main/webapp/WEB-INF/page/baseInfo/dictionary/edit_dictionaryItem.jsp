<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>数据字典条目添加</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/dictionary/edit_dictionaryItem.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="dictionaryItem.id" id="id" />
			    		<s:hidden name="dictionaryItem.state" />
				    	
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
					    	<tr>
								<td class='gridtitle'>编号：</td>
								<td class='gridbody'>					
									<input type="text" id="code" name="dictionaryItem.code" maxlength="20" value="${dictionaryItem.code}" onchange="codeCheck()" /><font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>值：</td>
								<td class='gridbody'>
									<input type="text" id="name" name="dictionaryItem.name" maxlength="20" value="${dictionaryItem.name}"/><font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>业务类型：</td>
								<td class='gridbody'>
									<input type="text" id="dictionaryName" name="" maxlength="20" value="${dictionary.name}" disabled="disabled"/>
									<input type="hidden" id="dictionaryId" name="dictionaryItem.dictionaryId" maxlength="20" value="${dictionary.id}"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>序号：</td>
								<td class='gridbody'>
									<input type="text" id="sort" name="dictionaryItem.sort" maxlength="20" value="${dictionaryItem.sort}"/><font color="red">*</font>
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

