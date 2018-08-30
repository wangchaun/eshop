<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑贺卡</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/store/greetingCard/edit_GreetingCard.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="greetingCardForm" method="post" action="">
			    		<s:hidden name="greetingCard.id" id="id" />
			    		<s:hidden name="greetingCard.modifierId" />
			    		<s:hidden name="greetingCard.modifierName" />
			    		<s:hidden name="greetingCard.modifyTime" />
			    		<s:hidden name="greetingCard.state" id="state"/>
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		<s:hidden name="greetingCard.creatorId"/>
			    		<s:hidden name="greetingCard.creatorName"/>
			    		<s:hidden name="greetingCard.createTime"/>
			    		
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
						
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	   <tr>
										<td class='gridtitle' width="15%">贺卡编号:</td>
										<td class='gridbody'>
											<s:textfield name="greetingCard.code" disabled="true"/>
										</td> 
										<td class='gridtitle' width="15%">赠送会员:</td>
										<td class='gridbody'>
										    <s:hidden name="greetingCard.customerId" id="customerId"/>
											<s:textfield name="greetingCard.customerName" id="customerName"  onclick="selectCustomer()"/>
										</td>    
									</tr>
									<tr>
										<td  class='gridtitle'>贺卡名字:</td>
										<td class='gridbody' colspan="3">
											<s:textfield name="greetingCard.name" id="name" size="60" /><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>贺卡内容:</td>
										<td class='gridbody' colspan="3">
											<textarea id="content" name="greetingCard.content" cols="60" rows="10">${greetingCard.content}&nbsp;</textarea>
										</td>
									</tr>
								</table>
				
						</div>
						<center>
							<input type="button" value="保存" onclick="javascript:submitSaveForm();" <c:if test="${greetingCard.state == 's' }">disabled="disabled"</c:if>/>
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
	
</body>

</html>


