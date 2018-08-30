<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑杂志</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	

	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link href="${ctx}/scripts/framework/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/magazine/edit_Magazine.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/swfobject.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
	
	
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="magazineForm" method="post" action="">
			    		<s:hidden name="magazine.id" id="id" />
			    		<s:hidden name="magazine.modifierId" />
			    		<s:hidden name="magazine.modifierName" />
			    		<s:hidden name="magazine.modifyTime" />
			    		<s:hidden name="magazine.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		
						<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
				    	   <tr>
								<td class='gridtitle' width="15%">杂志编号:</td>
								<td class='gridbody'>
									<s:textfield name="magazine.code" disabled="true"/>
								</td>
						  </tr>
						  <tr>	
								<td  class='gridtitle'>创建人:</td>
								<td class='gridbody'>
									<s:hidden name="magazine.creatorId" />
									<s:textfield name="magazine.creatorName" id="creatorName" readonly="true"/>
								</td>
						  </tr>	
							
						  <tr>	
								<td  class='gridtitle'>创建时间:</td>
								<td class='gridbody'>
									<input type="text" name="magazine.createTime" id="createTime" readonly="true" 
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${magazine.createTime}" />"/>
								</td>
						  </tr>
							
							<tr>
								<td  class='gridtitle'>杂志标题:</td>
								<td class='gridbody' >
									<s:textfield name="magazine.title" id="title" size="60" />
								</td>
							</tr>									
							<tr>
								<td class='gridtitle'>杂志简介：</td>
								<td class='gridbody' colspan="30">
									<textarea name="magazine.instruction" id="instruction" cols="60" rows="10">${magazine.instruction}&nbsp;</textarea>
								</td>
							</tr>
					
							<tr>
								
								<s:hidden name="appType" id="appType" />
								<td class='gridtitle'>上传文件：</td>
								<td class='gridbody'>
									<input type="hidden" name="fileUploadId" id="fileUploadId"  /><%-- name必须为fileUploadId --%>
									<input type="text" name="magazine.documentName" id="picPath"  class="picPath" value="${magazine.documentName}">
									<a href="javascript:void(0);" onclick="upload.open(this,'magazine')">上传</a>
								</td>		
							</tr>
						</table>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${magazine.state == 's' }">disabled="disabled"</c:if>/>
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


