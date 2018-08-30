<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>供应商管理</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/supplier/edit_supplier.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    <tr>
    	<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
		    	<form id="saveForm" method="post" action="">
		    	    <s:hidden name="supplier.id" id="id" />
		    		<s:hidden name="supplier.creatorId" />
		    		<s:hidden name="supplier.creatorName" />
		    		<s:hidden name="supplier.createTime" />
		    		<s:hidden name="supplier.modifierId" />
		    		<s:hidden name="supplier.modifierName" />
		    		<s:hidden name="supplier.modifyTime" />
		    		<s:hidden name="supplier.state" />
		    		
			    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
			    	
				    	<tr>
							<td class='gridtitle'> 编号 </td>
							<td class='gridbody'>
								<input type="text" name="supplier.code" id="code" value="${supplier.code}" disabled="true" />
							</td>
						
							<td class='gridtitle'> 名称 </td>
							<td class='gridbody'> 
								<s:textfield name="supplier.name" id="name" /><font color="red">*</font>
							</td>
						</tr>
						
				    	<tr>
							<td class='gridtitle'> 应收款 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.receivables" id="receivables" /><font color="red">*</font>
							</td>

							<td class='gridtitle'> 应付款 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.payables" id="payables"></s:textfield><font color="red">*</font>
							</td>
						</tr>
						
						<tr>
							<td class='gridtitle'> 供应商地址 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.address" id="address" /><font color="red">*</font>
							</td>

							<td class='gridtitle'> 联系人 </td>
							<td class='gridbody'> 
								<s:textfield name="supplier.linkman" id="linkman" /><font color="red">*</font>
							</td>
						</tr>
						
				    	<tr>
							<td class='gridtitle'> 手机 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.mobile" id="mobile" onchange="common.checkIsMobile(this);"/>
							</td>
	
							<td class='gridtitle'> 固话 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.telphone" id="telphone" onchange="common.checkIsTelephone(this);"></s:textfield><font color="red">*</font>
							</td>
						</tr>
						
						<tr>
							<td class='gridtitle'> 电子邮件 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.email" id="email" onchange="common.checkIsEmail(this);"/>
							</td>
	
							<td class='gridtitle'>地区</td>
							<td class='gridbody'>
							<s:hidden name="supplier.areaIds" id="areaIds"/>
							<s:textfield name="supplier.areaNames" id="areaNames" onclick="selectArea()"/>
							</td>
						</tr>	 
								
						<tr>
							<td class='gridtitle'> 具体街道 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.street" id="street"></s:textfield>
							</td>

							<td class='gridtitle'> 邮编 </td>
							<td class='gridbody'>
								<s:textfield name="supplier.zipCode" id="zipCode" onchange="common.checkPostCodeFormat(this);"></s:textfield>
							</td>
						</tr>
						<tr>
						
						<td class='gridtitle'> 合作状态</td>
						
							<td class='gridbody'>
							
							
							<select name="supplier.cooperationState" id="cooperationState" onchange="SCtate(this,'${supplier.name }')">
		               
		                <option value="1" <c:if test="${supplier.cooperationState == '1'}">selected</c:if> >合作</option>
		                <option value="2" <c:if test="${supplier.cooperationState == '2'}">selected</c:if> >暂停</option>
		                <option value="3" <c:if test="${supplier.cooperationState == '3'}">selected</c:if> >停止</option>
		                <!-- <option value="4" <c:if test="${supplier.cooperationState == '4'}">selected</c:if> >已删除厂商</option> -->
		            </select>
							</td>
							<td class='gridtitle'>供应商属性</td>
							<td class='gridbody'><s:textfield name="supplier.warehouseRemark" id="warehouseRemark"></s:textfield></td>
							</tr>
					</table>
				</form>
			</div>
		</td>
	</tr>
</table>
</body>

</html>

