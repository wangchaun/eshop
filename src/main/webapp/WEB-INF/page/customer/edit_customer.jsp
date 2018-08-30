<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>客户管理</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/customer/edit_customer.js"></script>
</head>

<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="saveForm" method="post" action="">
			    	    <s:hidden name="customer.id" id="id" />
			    	    <s:hidden name="customer.type" />
			    		<s:hidden name="customer.creatorId" />
			    		<s:hidden name="customer.creatorName" />
			    		<s:hidden name="customer.createTime" />
			    		<s:hidden name="customer.modifierId" />
			    		<s:hidden name="customer.modifierName" />
			    		<s:hidden name="customer.modifyTime" />
			    		<s:hidden name="customer.state" id="state"/>
					
						<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">						
							<tr>
								<td class='gridtitle'>账号</td>
								<td class='gridbody'>
									<input name="customer.code" id="code" value="${customer.code }" <c:if test="${customer.id != null}">disabled="true"</c:if>/>&nbsp;<font color="red">*</font>
								</td>
								<td class='gridtitle'>姓名</td>
								<td class='gridbody'>
									<s:textfield name="customer.name" id="name" maxlength="64" />&nbsp;<font color="red">*</font>
								</td>
							</tr>
							<!-- 
								<tr>
								<td class='gridtitle'>会员卡号</td>
								<td class='gridbody' >
									<input name="customer.cardNumber" id="cardNumber" value="${customer.cardNumber}" />&nbsp;<font color="red">*</font>
								</td>
								
								<td class='gridtitle'>提示:</td>
								<td class='gridbody' >
									<font color="red">请确保卡号的唯一性!以'CD'开头</font>
								</td>
							</tr>	
							 -->
							<tr>
								<td class='gridtitle'>密码</td>
								<td class='gridbody'>
									<input type="password" name="customer.pwd" id="pwd" size="21" value="${customer.pwd}" />&nbsp;<font color="red">*</font>
								</td>
								<td class='gridtitle'>确认密码</td>
								<td class='gridbody'>
									<input type="password" name="rePwd" id="rePwd" size="21" value="${customer.pwd}" />&nbsp;<font color="red">*</font>
								</td>					
							</tr>
							
							<tr>
								<td class='gridtitle'>性别</td>
								<td class='gridbody'>
									&nbsp;
									<input type="radio" name="customer.sex" value="m" <c:if test="${customer.sex == 'm'}">checked="checked"</c:if>>男&nbsp;&nbsp;
									<input type="radio" name="customer.sex" value="w" <c:if test="${customer.sex == 'w'}">checked="checked"</c:if>>女 
								</td>
								<td class='gridtitle'>会员类型</td>
								<td class='gridbody'>
									<select>
										<option value=""> -- 请选择会员类型  -- </option>
										<option value="普通会员" <c:if test="${customer.type=='普通会员'}">selected="selected"</c:if> >普通会员</option>
										<option value="联盟店会员" <c:if test="${customer.type=='联盟店会员'}">selected="selected"</c:if> >联盟店会员</option>
										<option value="企业会员" <c:if test="${customer.type=='企业会员'}">selected="selected"</c:if> >企业会员</option> 
									</select>									
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>联系人</td>
								<td class='gridbody'>
									<s:textfield name="customer.linkman" id="linkman" maxlength="64" />&nbsp;<font color="red">*</font>
								</td>
								<td class='gridtitle'>邮箱</td>
								<td class='gridbody'>
									<s:textfield name="customer.email" id="email"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>固定电话</td>
								<td class='gridbody'>
									<s:textfield name="customer.telephone" id="telephone" maxlength="50" onchange="common.checkIsTelephone(this);"/>
								</td>	
								<td class='gridtitle'>手机</td>
								<td class='gridbody'>
									<s:textfield name="customer.mobile" id="mobile" maxlength="50" onchange="common.checkIsMobile(this);checkmobile()" />
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td class='gridtitle'>邮编</td>
								<td class='gridbody'>
									<s:textfield name="customer.zipCode" id="zipCode" />
								</td>
								<td class='gridtitle'>会员等级</td>
								<td class='gridbody'>
									<s:select list="vipLevelList"  listValue="name" listKey="id" name="customer.vipLevelId" id="vipLevelId"
             							headerKey="" headerValue=" -- 请选择会员  -- " value="customer.vipLevelId"></s:select>
								</td>
							</tr>
	
							<tr>
								<td class='gridtitle'>单位名称</td>
								<td class='gridbody'>
									<s:textfield name="customer.companyName" id="companyName" />
								</td>	
								<td class='gridtitle'>单位地址</td>
								<td class='gridbody'>
									<s:textfield name="customer.companyAddress" id="companyAddress" />
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>地区</td>
								<td class='gridbody'>
									<s:hidden name="customer.areaIds" id="areaIds"/>
									<s:textfield name="customer.areaNames" id="areaNames" onclick="selectArea()"/>&nbsp;<font color="red">*</font>
								</td>
								<td class='gridtitle'>街道</td>
								<td class='gridbody'>
									<s:textfield name="customer.street" id="street"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle' colspan="3">备注</td>
								<td class='gridbody'>
									<s:textfield name="customer.remark" id="remark"/>
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

