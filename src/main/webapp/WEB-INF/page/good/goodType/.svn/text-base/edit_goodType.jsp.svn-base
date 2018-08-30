<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>商品类别添加</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/goodType/edit_goodType.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
</head>
<body>
    <table border="0" width="100%"  height="100%" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="goodTypeForm" method="post" action="">
			    		<s:hidden name="goodType.id" id="id" />
			    		<s:hidden name="goodType.parentId" />
			    		<s:hidden name="goodType.level" />
			    		<s:hidden name="goodType.creatorId" />
			    		<s:hidden name="goodType.creatorName" />
			    		<s:hidden name="goodType.createTime" />
			    		<s:hidden name="goodType.modifierId" />
			    		<s:hidden name="goodType.modifierName" />
			    		<s:hidden name="goodType.modifyTime" />
			    		<s:hidden name="goodType.state" />
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		<s:hidden name="goodType.isParent" />
				    	
				    	<table width="100%px"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
				    	   <tr>
								<td class='gridtitle' width="10%">商品类别编号：</td>
								<td class='gridbody'>
									<c:if test="${goodType.level == '1'}">
										<s:textfield name="goodType.code" id="code" onchange="isCodeExist()"/>(编号为空则自动生成)
									</c:if>
									<c:if test="${goodType.level != '1'}">
										<s:textfield name="goodType.code" readonly="true"/>
									</c:if>
								</td>
							</tr>
							<c:if test="${parentName!=null}">
					    	<tr>
								<td class='gridtitle'>商品父类：</td>
								<td class='gridbody'>					
									<input type="text" id="parentName" name="parentName" disabled="disabled" maxlength="20" value="${parentName}"/>
								</td>
							</tr>
							</c:if>
							<tr>
								<td class='gridtitle'>商品类别名称：</td>
								<td class='gridbody'>
									<s:textfield name="goodType.name" id="typeName" maxlength="30" />&nbsp;<font color="red">*</font>
								</td>
							</tr>
							<c:if test="${goodType.level=='1'}">
							<tr>
								<td class='gridtitle'>是否首页排榜：</td>
								<td class='gridbody'>
									&nbsp;&nbsp;
									是<input type="radio" name="goodType.listShow" id="listShow" value="1" <c:if test="${goodType.listShow == '1'}">checked="checked"</c:if>/> 
									&nbsp;&nbsp;									
									否<input type="radio" name="goodType.listShow" id="listShow" value="0" <c:if test="${goodType.listShow == '0'||goodType.listShow == null}">checked="checked"</c:if>/>
								</td>
							</tr>
							</c:if>
							<c:if test="${goodType.level=='2'}">
							<tr>
								<td class='gridtitle'>是否是选号商品类别：</td>
								<td class='gridbody'>
									&nbsp;&nbsp;
									是<input type="radio" name="goodType.isInventories" id="isInventories" value="1" <c:if test="${goodType.isInventories == '1'}">checked="checked"</c:if>/> 
									&nbsp;&nbsp;									
									否<input type="radio" name="goodType.isInventories" id="isInventories" value="0" <c:if test="${goodType.isInventories == '0'||goodType.isInventories == null}">checked="checked"</c:if>/>
								</td>
							</tr>
							</c:if>
							<tr>
							<td  class='gridtitle'>支付方式:</td>
								<td class='gridbody'>
									<s:hidden id="paymentId" name="goodType.paymentId"/>
									<s:textfield  name="goodType.paymentName" id="paymentName" onclick="getpayment()"/>
									<a href="javascript:void(0)" onclick="qktext('payment')">清空</a>
								</td>
							</tr>
							<tr>		
								<td  class='gridtitle'>配送方式:</td>
								<s:hidden id="deliveryId" name="goodType.deliveryId"/>
								<td class='gridbody'>
									<s:textfield  name="goodType.deliveryName" id="deliveryName" onclick="getdelivery()"/>
									<a href="javascript:void(0)" onclick="qktext('delivery')">清空</a>
								</td>
							</tr>
							
							<c:if test="${Level== '1'}">
								<tr>
								<td class='gridtitle'>上传类别图片：</td>

								<td class='gridbody'>
									<a href="javascript:void(0);" onclick="upload.open(this,'goodType')">上传</a>
									<span id="picimg"></span>					
									<c:if test="${goodType.pic != null && goodType.pic != ''}">
										<img id="pic" border="0" src="${ctx}${goodType.pic }" width="150px" height="150px"/>
										&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
									</c:if>
									<input type="hidden" name="picId" id="fileUploadId" value="${goodType.picId}" /><%-- name必须为fileUploadId --%>
									<input type="hidden" name="pic" id="picPath" value="${goodType.pic }" class="picPath">
								</td>	
							</tr>
							</c:if>
							<!-- 
							<tr>
							    <td class='gridtitle'>根据序号排序：</td>
							    <td class='gridbody'>
							  onchange="isSortExit()" 
							        <input type= "text" id="sort" name="goodTyep.sort" value="${goodType.sort }" />
							    </td>
							</tr> -->
							<tr>
								<td class='gridtitle'>备注：</td>
								<td class='gridbody' colspan="30">
									<textarea id="remark" name="goodType.remark" cols="600" rows="10">${goodType.remark}</textarea>
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

