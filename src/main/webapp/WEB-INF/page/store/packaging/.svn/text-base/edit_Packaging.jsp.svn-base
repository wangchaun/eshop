<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑商品包装</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/packaging/edit_Packaging.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="packagingForm" method="post" action="">
			    		<s:hidden name="packaging.id" id="id" />
			    		<s:hidden name="packaging.modifierId" />
			    		<s:hidden name="packaging.modifierName" />
			    		<s:hidden name="packaging.modifyTime" />
			    		<s:hidden name="packaging.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>	
			    		<s:hidden name="packaging.createTime"/>
			    		<s:hidden name="packaging.creatorId"/>
			    		<s:hidden name="packaging.creatorName"/>
			    		
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:350px;width:300px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	   <tr>
										<td class='gridtitle' width="15%">商品包装编号:</td>
										<td class='gridbody'>
											<s:textfield name="packaging.code" disabled="true"/>
										</td>
									</tr>
									<tr>	
										<td class='gridtitle' width="15%">商品包装名称:</td>
										<td class='gridbody'>
											<s:textfield name="packaging.name" id="name" />
										</td>
									</tr>
									<tr>	
										<td  class='gridtitle'>包装费用:</td>
										<td class='gridbody' >
											<s:textfield name="packaging.packagingFee" id="packagingFee"  />
										</td>
									          
									</tr>
							
									<tr>
										
										<td  class='gridtitle'>免费额度:</td>
										<td class='gridbody'>
											<s:textfield name="packaging.minForFree" id="minForFree"  />
										</td>
							
									</tr>
									
									<tr>
										<td  class='gridtitle'>包装描述:</td>

										<td class='gridbody'colspan="5" >
						    				<s:textarea id="packageDescription" name="packaging.packageDescription" cols="55" rows="3" />
						    			</td>
									</tr>
									<tr>
										<td class='gridtitle'>上传商品缩略图:</td>
										<td class='gridbody' colspan="5">
											<a href="javascript:void(0);" onclick="upload.open(this,'Packaging')">选择图片</a>
											<c:if test="${packaging.pic != null && packaging.pic != ''}">
												<img id="pic" border="0" src="${ctx}${packaging.pic }" width="130px" height="130px"/>
												&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
											</c:if>
											<input type="hidden" name="picId" id="fileUploadId" value="${packaging.picId}" /><%-- name必须为fileUploadId --%>
											<input type="hidden" name="packaging.pic" id="picPath"  class="picPath" value="${packaging.pic }" >
										</td>
									</tr>
								</table>
						
						</div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${packaging.state == 's' }">disabled="disabled"</c:if>/>
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


