<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>商品品牌添加</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/goodBrand/edit_groupgoodBrand.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="goodBrandForm" method="post" action="">
			    		<s:hidden name="goodBrand.id" id="id" />
			    		<s:hidden name="goodBrand.parentId" />
			    		<s:hidden name="goodBrand.level" />
			    		<s:hidden name="goodBrand.creatorId" />
			    		<s:hidden name="goodBrand.creatorName" />
			    		<s:hidden name="goodBrand.createTime" />
			    		<s:hidden name="goodBrand.modifierId" />
			    		<s:hidden name="goodBrand.modifierName" />
			    		<s:hidden name="goodBrand.modifyTime" />
			    		<s:hidden name="goodBrand.state" />
			    		<input type="hidden" name="goodBrand.isInventory" id="isInventory"/>
				    	
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
				    	   <tr>
								<td class='gridtitle'>品牌编号：</td>
								<td class='gridbody'>
									<s:textfield name="goodBrand.code" id="code" onchange="isCodeExist()"/>(编号为空则自动生成)
								</td>
							</tr>
							<c:if test="${parentName!=null}">
					    	<tr>
								<td class='gridtitle'>品牌种类：</td>
								<td class='gridbody'>					
									<input type="text" id="parentName" name="parentName" disabled="disabled" maxlength="20" value="${parentName}"/>
								</td>
							</tr>
							</c:if>
							<tr>
								<td class='gridtitle'>品牌名称：</td>
								<td class='gridbody'>
									<s:textfield name="goodBrand.name" id="brandName" maxlength="30" />&nbsp;<font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>品牌图片：</td>
								<td class='gridbody'>
									<a href="javascript:void(0);" onclick="upload.open(this,'GoodBrand')">Upload</a>
					
									<c:if test="${goodBrand.pic != null && goodBrand.pic != ''}">
										<img id="pic" border="0" src="${ctx}${goodBrand.pic }" width="150px" height="150px"/>
										&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">Remove</a>
									</c:if>
									<input type="hidden" name="goodBrand.picId" id="fileUploadId" value="${goodBrand.picId}" /><%-- name必须为fileUploadId --%>
									<input type="hidden" name="goodBrand.pic" id="picPath" value="${goodBrand.pic }" class="picPath">	
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>备注：</td>
								<td class='gridbody'>
									<s:textarea name="goodBrand.remark" cols="45" rows="5" />
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

