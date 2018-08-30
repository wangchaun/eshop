<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑设置</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/storeSet/edit_storeSet.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="storeSetForm" method="post" action="">
			    		<s:hidden name="storeSet.id" id="id" />
			    		<s:hidden name="storeSet.modifierId" />
			    		<s:hidden name="storeSet.modifierName" />
			    		<s:hidden name="storeSet.modifyTime" />
			    		<s:hidden name="storeSet.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
						
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	   <tr>
										<td class='gridtitle' width="15%">商城设置编号:</td>
										<td class='gridbody'>
											<s:textfield name="storeSet.code" disabled="true"/>
										</td>
										<td  class='gridtitle'>创建人:</td>
										<td class='gridbody'>
											<s:hidden name="storeSet.creatorId" />
											<s:textfield name="storeSet.creatorName" id="creatorName" readonly="true"/>
										</td>
										<td  class='gridtitle'>创建时间:</td>
										<td class='gridbody'>
											<input type="text" name="storeSet.createTime" id="createTime" readonly="true" 
											onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${storeSet.createTime}" />"/>
										</td> 
									          
									</tr>
									<tr></tr>
									<tr>
										<td  class='gridtitle'>商城设置题:</td>
										<td class='gridbody' colspan="10">
											<s:textfield name="storeSet.subject" id="subject" size="60" /><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>商城设置详情:</td>
										<td class='gridbody' colspan="30" >
											<textarea id="content" name="storeSet.content" cols="60" rows="10">${storeSet.content}&nbsp;</textarea>
										</td>
									</tr>
								</table>
				
						</div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${storeSet.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							<input type="button" value="审核" onclick="javascript:adconform();" <c:if test="${storeSet.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


