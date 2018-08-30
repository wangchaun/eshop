<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>角色权限</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link href="${ctx}/styles/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<link href="${ctx }/styles/skin.css" rel="stylesheet" type="text/css">	
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/system/SysRolePower/edit_SysRolePower.js"></script>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" bgcolor="#F7F8F9">
    	<form id="saveForm" method="post" action="">
    		<s:hidden name="sysRole.id" />
	    	<table border="0">
				<tr valign="top">
					<td valign="center"><c:out value="${sysRole.name}"></c:out>：</td>
					<td width="330px"> 
						<table width="100%" height="100%" border="1">
							<thead>
								<tr>
									<td>功能模块</td>
									<td colspan="2">权限操作</td>
								</tr>
							</thead>
							<tbody id="sysRolePowerList">
								<c:forEach items="${sysRolePowerList}" var="o" varStatus="i">
								<tr>
									<td width="80px"><c:out value="${o.powerName}" />&nbsp;<input type="hidden" name="powerIdArr" value="${o.powerId }" /></td>
									<td width="210px">
										增加:<select name="inserts">
											<option  value="0">未赋予</option>
											<option <c:if test="${o.inserts=='1'}">selected</c:if> value="1">赋予</option>
										</select>
										删除:<select name="deletes" >
											<option  value="0">未赋予</option>
											<option <c:if test="${o.deletes=='1'}">selected</c:if> value="1">赋予</option>
										</select><br/>
										查读:<select name="selects" >
											<option  value="0">未赋予</option>
											<option <c:if test="${o.selects=='1'}">selected</c:if> value="1">赋予</option>
										</select>
										修改:<select name="updates" >
											<option  value="0">未赋予</option>
											<option <c:if test="${o.updates=='1'}">selected</c:if> value="1">赋予</option>
										</select>
									</td>
									<td width="40"><a href="javascript:void(0)" ><span onclick="deleteData(this)">删除</span></a></td>
								</tr>					
								</c:forEach>
							</tbody>
						</table>
						<p />
						<c:if test="${loginUser.roleName=='Admin'}">
							<a href="javascript:void(0)" id="selectData" onclick="showPowerList()">选择权限</a>&nbsp;&nbsp;
							<a href="javascript:void(0)" id="sumbitData" onclick="submitForm()">确认保存</a>&nbsp;&nbsp;
						</c:if>
						<!--  
						<a href="javascript:void(0)" id="all" onclick="selectAll()">全选</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="notall" onclick="selectnotAll()">全不选</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" id="cancel" onclick="cancelselect()">反选</a>
						-->
					</td>
				</tr>				
			</table>
		</form>

 </td>
    <td background="${ctx}/imgs/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>

</html>

