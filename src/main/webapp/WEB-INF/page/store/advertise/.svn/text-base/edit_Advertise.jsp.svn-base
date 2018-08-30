<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑广告</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/advertise/edit_Advertise.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="advertiseForm" method="post" action="">
			    		<s:hidden name="advertise.id" id="id" />
			    		<s:hidden name="advertise.modifierId" />
			    		<s:hidden name="advertise.modifierName" />
			    		<s:hidden name="advertise.modifyTime" />
			    		<s:hidden name="advertise.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
						
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	   <tr>
										<td class='gridtitle' width="15%">广告编号:</td>
										<td class='gridbody'>
											<s:textfield name="advertise.code" disabled="true"/>
										</td>
										<td  class='gridtitle'>创建人:</td>
										<td class='gridbody'>
											<s:hidden name="advertise.creatorId" />
											<s:textfield name="advertise.creatorName" id="creatorName" readonly="true"/>
										</td>
										<td  class='gridtitle'>创建时间:</td>
										<td class='gridbody'>
											<input type="text" name="advertise.createTime" id="createTime" readonly="true" 
											onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${advertise.createTime}" />"/>
										</td> 
									          
									</tr>
									<tr></tr>
									<tr>
										<td  class='gridtitle'>广告主题:</td>
										<td class='gridbody' colspan="10">
											<s:textfield name="advertise.subject" id="subject" size="60" /><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td class='gridtitle'>上传广告缩略图:<br/></td>
										<td class='gridbody' colspan="5">
											<a href="javascript:;" onclick="upload.open(this,'AdvertisePic')">选择图片</a>
											<span id="picimg"></span>
											<c:if test="${advertise.pic != null && advertise.pic != ''}">
												<img id="pic" border="0" src="${ctx}${advertise.pic }" width="130px" height="130px"/>
												&nbsp;&nbsp;<a href="javascript:;" onclick="deletePic(this)">删除</a>
											</c:if>
											<input type="hidden" name="picId" id="fileUploadId" value="${advertise.picId}" /><%-- name必须为fileUploadId --%>
											<input type="hidden" name="advertise.pic"  id="picPath" class="picPath" value="${advertise.pic }" >
										
										</td>
						  		    </tr>
						  		   <tr>
										<td class='gridtitle'>显示位置</td>
										<td class='gridbody' colspan="5">
										 
											<!-- <s:select list="goodTypeList"  listValue="name" listKey="id" name="advertise.placeId" id="placeId"
		             							headerKey="" headerValue=" -- 请选择显示位置  -- " value="advertise.placeId"></s:select> -->
											<select name="advertise.placeId" id="placeId"  onchange="selectAdvertise(this.value)">
												<option value=""> -- 请选择显示位置  -- </option>
												<option value="LOG" <c:if test="${advertise.placeId=='LOG'}">selected="selected"</c:if> >LOG</option>
												<option value="分类焦点1" <c:if test="${advertise.placeId=='分类焦点1'}">selected="selected"</c:if> >分类焦点1</option>
												<option value="分类焦点2" <c:if test="${advertise.placeId=='分类焦点2'}">selected="selected"</c:if> >分类焦点2</option>
												<option value="分类焦点3" <c:if test="${advertise.placeId=='分类焦点3'}">selected="selected"</c:if> >分类焦点3</option>
												<option value="分类焦点4" <c:if test="${advertise.placeId=='分类焦点4'}">selected="selected"</c:if> >分类焦点4</option>
												
												
												
												<option value="横幅banner" <c:if test="${advertise.placeId=='横幅banner'}">selected="selected"</c:if>>横幅banner</option>
												
												<option value="首页焦点1" <c:if test="${advertise.placeId=='首页焦点1'}">selected="selected"</c:if> >首页焦点1</option>
												<option value="首页焦点2" <c:if test="${advertise.placeId=='首页焦点2'}">selected="selected"</c:if> >首页焦点2</option>
												<option value="首页焦点3" <c:if test="${advertise.placeId=='首页焦点3'}">selected="selected"</c:if> >首页焦点3</option>
												<option value="首页焦点4" <c:if test="${advertise.placeId=='首页焦点4'}">selected="selected"</c:if> >首页焦点4</option>
												
												<option value="首页促销1" <c:if test="${advertise.placeId=='首页促销1'}">selected="selected"</c:if> >首页促销1</option>
												<option value="首页促销2" <c:if test="${advertise.placeId=='首页促销2'}">selected="selected"</c:if> >首页促销2</option>
												<option value="首页促销3" <c:if test="${advertise.placeId=='首页促销3'}">selected="selected"</c:if> >首页促销3</option>
												<option value="首页促销4" <c:if test="${advertise.placeId=='首页促销4'}">selected="selected"</c:if> >首页促销4</option>
												<option value="首页促销5" <c:if test="${advertise.placeId=='首页促销5'}">selected="selected"</c:if> >首页促销5</option>
											    <option value="首页促销6" <c:if test="${advertise.placeId=='首页促销6'}">selected="selected"</c:if> >首页促销6</option>
											    <option value="商城用户广告1" <c:if test="${advertise.placeId=='商城用户广告1'}">selected="selected"</c:if> >商城用户广告1</option>
												<option value="商城用户广告2" <c:if test="${advertise.placeId=='商城用户广告2'}">selected="selected"</c:if> >商城用户广告2</option>
												<option value="商城用户广告3" <c:if test="${advertise.placeId=='商城用户广告3'}">selected="selected"</c:if> >商城用户广告3</option>
												<option value="商城用户广告4" <c:if test="${advertise.placeId=='商城用户广告4'}">selected="selected"</c:if> >商城用户广告4</option>
												<!-- 
													<option value="全国焦点1" <c:if test="${advertise.placeId=='全国焦点1'}">selected="selected"</c:if> >全国焦点1</option>
													<option value="全国焦点2" <c:if test="${advertise.placeId=='全国焦点2'}">selected="selected"</c:if> >全国焦点2</option>
													<option value="全国焦点3" <c:if test="${advertise.placeId=='全国焦点3'}">selected="selected"</c:if> >全国焦点3</option>
													<option value="全国焦点4" <c:if test="${advertise.placeId=='全国焦点4'}">selected="selected"</c:if> >全国焦点4</option>
													<option value="全国促销1" <c:if test="${advertise.placeId=='全国促销1'}">selected="selected"</c:if> >全国促销1</option>
													<option value="全国促销2" <c:if test="${advertise.placeId=='全国促销2'}">selected="selected"</c:if> >全国促销2</option>
													<option value="全国促销3" <c:if test="${advertise.placeId=='全国促销3'}">selected="selected"</c:if> >全国促销3</option>
												 -->
												
												<option value="团购专题1" <c:if test="${advertise.placeId=='团购专题1'}">selected="selected"</c:if> >团购专题1</option>
												<option value="团购专题2" <c:if test="${advertise.placeId=='团购专题2'}">selected="selected"</c:if> >团购专题2</option>
												<option value="团购专题3" <c:if test="${advertise.placeId=='团购专题3'}">selected="selected"</c:if> >团购专题3</option>
											
												
												<!-- 
													<option value="联盟焦点1" <c:if test="${advertise.placeId=='联盟焦点1'}">selected="selected"</c:if> >联盟焦点1</option>
													<option value="联盟焦点2" <c:if test="${advertise.placeId=='联盟焦点2'}">selected="selected"</c:if> >联盟焦点2</option>
													<option value="联盟焦点3" <c:if test="${advertise.placeId=='联盟焦点3'}">selected="selected"</c:if> >联盟焦点3</option>
													<option value="联盟焦点4" <c:if test="${advertise.placeId=='联盟焦点4'}">selected="selected"</c:if> >联盟焦点4</option>
													<option value="联盟焦点5" <c:if test="${advertise.placeId=='联盟焦点5'}">selected="selected"</c:if> >联盟焦点5</option>
													<option value="1F专题1" <c:if test="${advertise.placeId=='1F专题1'}">selected="selected"</c:if> >1F专题1</option>
												    <option value="1F专题2" <c:if test="${advertise.placeId=='1F专题2'}">selected="selected"</c:if> >1F专题2</option>
													<option value="1F专题3" <c:if test="${advertise.placeId=='1F专题3'}">selected="selected"</c:if> >1F专题3</option>
													<option value="1F专题4" <c:if test="${advertise.placeId=='1F专题4'}">selected="selected"</c:if> >1F专题4</option>
													<option value="2F专题1" <c:if test="${advertise.placeId=='2F专题1'}">selected="selected"</c:if> >2F专题1</option>
												    <option value="2F专题2" <c:if test="${advertise.placeId=='2F专题2'}">selected="selected"</c:if> >2F专题2</option>
													<option value="2F专题3" <c:if test="${advertise.placeId=='2F专题3'}">selected="selected"</c:if> >2F专题3</option>
													<option value="2F专题4" <c:if test="${advertise.placeId=='2F专题4'}">selected="selected"</c:if> >2F专题4</option>
													<option value="3F专题1" <c:if test="${advertise.placeId=='3F专题1'}">selected="selected"</c:if> >3F专题1</option>
												    <option value="3F专题2" <c:if test="${advertise.placeId=='3F专题2'}">selected="selected"</c:if> >3F专题2</option>
													<option value="3F专题3" <c:if test="${advertise.placeId=='3F专题3'}">selected="selected"</c:if> >3F专题3</option>
													<option value="3F专题4" <c:if test="${advertise.placeId=='3F专题4'}">selected="selected"</c:if> >3F专题4</option>
													<option value="4F专题1" <c:if test="${advertise.placeId=='4F专题1'}">selected="selected"</c:if> >4F专题1</option>
													<option value="4F专题2" <c:if test="${advertise.placeId=='4F专题2'}">selected="selected"</c:if> >4F专题2</option>
													<option value="4F专题3" <c:if test="${advertise.placeId=='4F专题3'}">selected="selected"</c:if> >4F专题3</option>
													<option value="4F专题4" <c:if test="${advertise.placeId=='4F专题4'}">selected="selected"</c:if> >4F专题4</option>
												 -->
																							
												<option value="资讯专题1" <c:if test="${advertise.placeId=='资讯专题1'}">selected="selected"</c:if> >资讯专题1</option>
												<option value="资讯专题2" <c:if test="${advertise.placeId=='资讯专题2'}">selected="selected"</c:if> >资讯专题2</option>
												<option value="资讯专题3" <c:if test="${advertise.placeId=='资讯专题3'}">selected="selected"</c:if> >资讯专题3</option>
												
												<option value="资讯头条1" <c:if test="${advertise.placeId=='资讯头条1'}">selected="selected"</c:if> >资讯头条1</option>
												<option value="资讯头条2" <c:if test="${advertise.placeId=='资讯头条2'}">selected="selected"</c:if> >资讯头条2</option>
												<option value="资讯头条3" <c:if test="${advertise.placeId=='资讯头条3'}">selected="selected"</c:if> >资讯头条3</option>
											
											
											</select>
											
											
										</td>
										    
									</tr>
									<%-- <tr>
										    <td  class='gridtitle'>所属地区:</td>
											      <td class='gridbody' colspan="10">
											 	     <s:hidden name="advertise.areaId" id="areaId"/>
												     <s:textfield name="advertise.areaName" id="areaName" size="60" onclick="selectArea()"/>
											</td>
										</tr> 
									--%>
									<tr id="ads">
											<td class='gridtitle'>请选择广告的类型</td>
											<td class='gridbody' colspan="5">
												<select name="advertise.isGoodTypeId" id="isGoodTypeId">
													<option value="" > -- 请选择广告的类型  -- </option>
													<c:forEach items="${goodTypeList}" var="type">
														<option value="${type.id }" <c:if test="${advertise.isGoodTypeId == type.id }">selected="selected"</c:if> >${type.name }</option>
													</c:forEach>
												</select>
											</td>
										</tr>
									<!-- <c:if test="${advertise.id!=null}"> -->
										
									<!-- </c:if> -->
									<!-- 
										<tr id="ad" style="display:none;">
										<td class='gridtitle'>请选择广告的类型</td>
										<td class='gridbody' colspan="5">
											<select name="isGoodTypeId" id="isGoodTypeId">
												<option value="" selected="selected"> -- 请选择广告的类型  -- </option>
												<c:forEach items="${goodTypeList1}" var="type">
													<option value="${type.id }">${type.name }</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									 -->
									<tr>
									<td class='gridtitle'>URL:</td>
									<td class='gridbody' colspan="5"><input type="text" name="advertise.url" value="${advertise.url}"/></td>
									</tr>
									
									<tr>
										<td  class='gridtitle'>广告详情:</td>
										<td class='gridbody' colspan="30" >
											<textarea id="content" name="advertise.content" cols="60" rows="10">${advertise.content}&nbsp;</textarea>
										</td>
									</tr>
								</table>
				
						</div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${advertise.state == 's' }">disabled="disabled"</c:if>/>
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


