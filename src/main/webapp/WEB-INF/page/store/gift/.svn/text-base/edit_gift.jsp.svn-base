
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑礼品包</title>
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
	<script type="text/javascript" src="${ctx }/scripts/store/gift/edit_gift.js"></script>
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
					<form action="" id="giftGoodForm" >
				   	    <s:hidden name="gift.id" id="id" />		   	 
				   		<s:hidden name="gift.modifierId" />
				   		<s:hidden name="gift.modifierName" />
				   		<s:hidden name="gift.modifyTime" />
				   		<s:hidden name="gift.state" id="state" />
				   		<s:hidden name="imgIdStr" id="imgIdStr"/>
				   		<s:hidden name="gift.creatorId" />
			            <s:hidden name="gift.creatorName" />
			            <s:hidden name="gift.createTime" />
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						    <tr>
							  	<td class='gridtitle' width="10%">编号</td>
							    <td class='gridbody' >
							    	<s:textfield name="gift.code" id="code"  readonly="true"/>
							    </td>
							    <td class='gridtitle' width="10%">礼品包名称</td>
							    <td class='gridbody' >
							    	<s:textfield name="gift.giftName" id="giftName" />
							    </td>
						    </tr>
						   <tr>
						    <td class='gridtitle' >活动时间</td>
					    	<td class='gridbody' colspan="5">
					    	<input name="gift.startTime" id="startTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${gift.startTime}" pattern="yyyy-MM-dd"/>" />至
					    	<input name="gift.endTime" id="endTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${gift.endTime}" pattern="yyyy-MM-dd"/>" />
					   		 </td>
						  </tr>
						  <tr>
						  	<td class='gridtitle'>订单赠送最低价格</td>
						    <td class='gridbody' colspan="5">
						    	￥<s:textfield name="gift.orderMoney" id="orderMoney" />
						    </td>
						  </tr>
						  <tr>
						  	<td class='gridtitle'>每人限兑换数量</td>
						    <td class='gridbody' colspan="5">
						    	<s:textfield name="gift.amount" id="amount" />
						    </td>
						  </tr>
						  <tr>
						  	<td class='gridtitle'>兑换所需积分</td>
						    <td class='gridbody' colspan="5">
						    	<s:textfield name="gift.credits" id="credits" />
						    </td>
						  </tr>
						  <tr>
							<td class='gridtitle'>允许兑换的会员等级</td>
							<td class='gridbody' colspan="5">
								<c:forEach items="${vipLevelList}" var="vipLevel">
           						<input type="checkbox" name="vipLevelIdArr"  value="${vipLevel.id}" 
           						<c:if test="${fn:indexOf(gift.vipLevelId,vipLevel.id)!= -1}">checked</c:if> >${vipLevel.name }</input><br>
           						</c:forEach> 
							</td>	
						  </tr>
						  
						  <tr>
								<td class='gridtitle'>上传礼品包缩略图:</td>
								<td class='gridbody' colspan="5">
									<a href="javascript:void(0);" onclick="upload.open(this,'gift')">选择图片</a>
									<c:if test="${gift.pic != null && gifg.pic != ''}">
										<img id="pic" border="0" src="${ctx}${gift.pic }" width="130px" height="130px"/>
										&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
									</c:if>
									<input type="hidden" name="picId" id="fileUploadId" value="${gift.picId}" /><%-- name必须为fileUploadId --%>
									<input type="hidden" name="gift.pic" id="picPath"  class="picPath" value="${gift.pic }" >
								</td>
						  </tr>
						  <tr>			
						    <td class='gridtitle'>礼品包赠送详情</td>
					    	<td class='gridbody' colspan="30">
					    		<textarea id="intro" name="gift.intro" cols="60" rows="10">${gift.intro}&nbsp;</textarea>
					    	</td>
						  </tr>
						</table>
						
						<div class="clearfloat"></div>
						<div>
							<table id="giftGoodTable" style="display: none;"></table><%-- 促销商品 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						
						<div>
							<center>
								<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${gift.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
								<input type="button" value="审核" onclick="javascript:confirmpromote();" <c:if test="${gift.state == 's' }">disabled="disabled"</c:if>/>&nbsp;&nbsp;
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

