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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/goodAttr/edit_goodAttr.js"></script>
</head>
<body>

    <table border="0" height="50%" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="goodAttr.id" id="id" />
			    		<s:hidden name="goodAttr.state" />
			    		<s:hidden name="goodAttr.goodKindId"/>
				    	<s:hidden name="goodAttr.code"/>
				    	<s:hidden id="inputType" name="goodAttr.inputType" value="0"/>
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
					    	<tr>
								<td class='gridtitle' width="20%">属性编号：</td>
								<td class='gridbody'>
									<s:textfield name="goodAttr.code" disabled="true" />					
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>属性名称：</td>
								<td class='gridbody'>
									<s:textfield id="name" name="goodAttr.name"/>&nbsp;<font color="red">*</font>
								</td>
							</tr>
							<!-- 
								<tr>
									<td class='gridtitle'>输入类型：</td>
									<td class='gridbody'>
										<select name="goodAttr.inputType" onchange="controlDiv(this)" id="inputType">
											<option value="0" <c:if test="${goodAttr.inputType == '0'}"> selected="selected"</c:if>>字符串</option>
											<option value="1" <c:if test="${goodAttr.inputType == '1'}"> selected="selected"</c:if>>日期</option>
											<option value="2" <c:if test="${goodAttr.inputType == '2'}"> selected="selected"</c:if>>整型</option>
											<option value="3" <c:if test="${goodAttr.inputType == '3'}"> selected="selected"</c:if>>双精度</option>
											<option value="4" <c:if test="${goodAttr.inputType == '4'}"> selected="selected"</c:if>>单选</option>
										</select>
									</td>
								</tr>
								<tr id="selectValue">
								<td class='gridtitle'>单选值：</td>
								<td class='gridbody'>
									<s:textarea id="value" name="goodAttr.value" cols="30" rows="3" onchange="replaceComma(this)"/><br/>
									<font color="red">每个值之间用英文逗号(,)隔开</font>
								</td>
								</tr>
								<tr>
									<td class='gridtitle'>序号：</td>
									<td class='gridbody'>
										<s:textfield id="sort" name="goodAttr.sort"/>
									</td>
								</tr>
							 -->
							<tr>
								<td class='gridtitle'>备注：</td>
								<td class='gridbody'>
									<s:textarea id="sort" name="goodAttr.remark" rows="2" cols="20"/>
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

