<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/information/edit_Information.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="informationForm" method="post" action="">
			    		<s:hidden name="information.id" id="id" />
			    		<s:hidden name="information.modifierId" />
			    		<s:hidden name="information.modifierName" />
			    		<s:hidden name="information.modifyTime" />
			    		<s:hidden name="information.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		<s:hidden name="information.type" id="type"/>
			    		
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
							
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	   <tr>
										<td class='gridtitle' width="15%">编号:</td>
										<td class='gridbody'>
											<s:textfield name="information.code" id="code"  readonly="true"/>
										</td>
										<td  class='gridtitle'>创建人:</td>
										<td class='gridbody'>
											<s:hidden name="information.creatorId" />
											<s:textfield name="information.creatorName" id="creatorName" />
										</td>
										<td  class='gridtitle'>创建时间:</td>
										<td class='gridbody'>
											<input type="text" name="information.createTime" id="createTime" readonly="true" 
											onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${information.createTime}" />"/>
										</td> 
									          
									</tr>
									<tr></tr>
									<tr>
										<td  class='gridtitle'>所属地区:</td>
										<td class='gridbody' colspan="10">
											<s:hidden name="information.areaId" id="areaId"/>
											<s:textfield name="information.areaName" id="areaName" size="60" onclick="selectArea()"/>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>标题:</td>
										<td class='gridbody' colspan="10">
											<s:textfield name="information.title" id="title" size="60" />
										</td>
										
									</tr>
									<c:if test="${information.type == '9'}">
									<tr>
									<td  class='gridtitle'>规则类型:</td>
											<td class='gridbody'>
											<select name="information.regulationType" id="regulationType" onkeydown="checkKey()">
								                <option value="0" <c:if test="${information.regulationType == '0'}">selected</c:if> >团购规则</option>
								                <option value="1" <c:if test="${information.regulationType == '1'}">selected</c:if> >抢购规则</option>
								                <option value="2" <c:if test="${information.regulationType == '2'}">selected</c:if> >秒杀规则</option>
								                <option value="3" <c:if test="${information.regulationType == '3'}">selected</c:if> >优惠劵规则</option>
								            </select>
										</td>
									</tr>
									</c:if>
									<tr>
										<td  class='gridtitle'>内容:</td>
										<td class='gridbody' colspan="30" >
											<textarea id="content" name="information.content" cols="60" rows="10">${information.content}&nbsp;</textarea>
										</td>
									</tr>
								</table>
							
						</div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" /><!-- <c:if test="${information.state == 's' }">disabled="disabled"</c:if> -->
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


