
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑优惠活动</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/swfobject.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/framework/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/store/promotionActivity/edit_PromotionActivity.js"></script>
	<style type="text/css">
		.tabtop {
			height:40px;
			font-size:12px;
		}
		.tabtop .title {
			font-size:14px;
			font-weight:bold;
		}
		.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
			clear:both;
   			height:0;
    		font-size: 1px;
    		line-height: 0px;
		}
		.border {
			font-size:12px;
    		border:1px solid #90B9DE;
		}
		.bordertd {
			font-size:12px;
		}
	</style>
</head>
<body>
	 <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px;">
					<form action="" id="promoteGoodForm" >
				   	    <s:hidden name="promotionActivity.id" id="id" />			   	 
				   		<s:hidden name="promotionActivity.modifierId" />
				   		<s:hidden name="promotionActivity.modifierName" />
				   		<s:hidden name="promotionActivity.modifyTime" />
				   		<s:hidden name="promotionActivity.state" id="state" />
				   		<s:hidden name="imgIdStr" id="imgIdStr"/>
			
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						  	<td class='gridtitle' width="10%">编号</td>
						    <td class='gridbody' width="20%">
						    	<s:textfield name="promotionActivity.code" id="code"  readonly="true"/>
						    </td>
						    <td class='gridtitle' width="10%">创建日期</td>
						    <td class='gridbody' width="30%">
						    	<input name="promotionActivity.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true"  value="<fmt:formatDate value="${promotionActivity.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						    <td class='gridtitle' width="10%">创建人</td>
						    <td class='gridbody' width="20%">
						    	<s:hidden name="promotionActivity.creatorId" /> 
						      	<s:textfield id="creatorName" name="promotionActivity.creatorName" readonly="true" />
						    </td>
						  </tr>
						    <tr>
						    <td class='gridtitle'>优惠活动主题</td>
						    <td class='gridbody' colspan="10">
						    	<s:textfield id="name" name="promotionActivity.name" size="60" />
						    </td>
						  </tr>
						   <tr>
						    <td class='gridtitle' >优惠活动时间</td>
					    	<td class='gridbody' colspan="5">
					    	<input name="promotionActivity.startTime" id="startTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${promotionActivity.startTime}" pattern="yyyy-MM-dd"/>" />至
					    	<input name="promotionActivity.endTime" id="endTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${promotionActivity.endTime}" pattern="yyyy-MM-dd"/>" />
					   		 </td>
						  </tr>
						  <tr>
							<td class='gridtitle'>选择会员等级</td>
							<td class='gridbody' colspan="5">
								<c:forEach items="${vipLevelList}" var="vipLevel">
           						<input type="checkbox" name="vipLevelIdArr"  value="${vipLevel.id}" 
           						<c:if test="${fn:indexOf(promotionActivity.vipLevelId,vipLevel.id)!= -1}">checked</c:if> >${vipLevel.name }</input><br>
           						</c:forEach> 
							</td>	
						  </tr>
						  <tr>
							<td class='gridtitle'>图片首页显示位置</td>
							<td class='gridbody' colspan="5">													
								<select name="promotionActivity.type" id="type">
									<option value="" <c:if test="${promotionActivity.type == null }"  >selected</c:if>>---请选择---</option>
									<option value="首页方块一" <c:if test="${promotionActivity.type == '首页方块一' }"  >selected</c:if>>首页方块一</option>
									<option value="首页方块二" <c:if test="${promotionActivity.type == '首页方块二' }"  >selected</c:if>>首页方块二</option>
									<option value="首页方块三" <c:if test="${promotionActivity.type == '首页方块三' }"  >selected</c:if>>首页方块三</option>
									<option value="首页方块四" <c:if test="${promotionActivity.type == '首页方块四' }"  >selected</c:if>>首页方块四</option>
									<option value="首页方块五" <c:if test="${promotionActivity.type == '首页方块五' }"  >selected</c:if>>首页方块五</option>
								</select>
							</td>	
						</tr>
						  <tr>
								<td class='gridtitle'>上传优惠活动缩略图:</td>
								<td class='gridbody' colspan="5">
									<a href="javascript:void(0);" onclick="upload.open(this,'promotionActivity')">选择图片</a>
									<c:if test="${promotionActivity.pic != null && promotionActivity.pic != ''}">
										<img id="pic" border="0" src="${ctx}${promotionActivity.pic }" width="130px" height="130px"/>
										&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
									</c:if>
									<input type="hidden" name="picId" id="fileUploadId" value="${promotionActivity.picId}" /><%-- name必须为fileUploadId --%>
									<input type="hidden" name="promotionActivity.pic" id="picPath"  class="picPath" value="${promotionActivity.pic }" >
								</td>
						  </tr>
						  <tr>			
						    <td class='gridtitle'>优惠活动详情</td>
					    	<td class='gridbody' colspan="30">
					    		<textarea id="intro" name="promotionActivity.intro" cols="60" rows="10">${promotionActivity.intro}&nbsp;</textarea>
					    	</td>
						  </tr>
						</table>
						
						<div class="clearfloat"></div>
						<div>
							<table id="promoteGoodTable" style="display: none;"></table><%-- 促销商品 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						
						<div>
							<center>
								<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${promotionActivity.state == 's' }">disabled="disabled"</c:if>/>
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

