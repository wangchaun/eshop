<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>Edit Password</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/system/SysUser/edit_password.js"></script>
</head>

<body>

	<table border="0" width="450px" cellspacing="0" cellpadding="0" class="gdcn-table-E">
      <tr>
   		<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
				<form id="saveForm" method="post" action="">
		    	    <s:hidden name="sysUser.id" id="id" />
				
					<table width="40%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">						
						<tr>
							<td class='gridtitle'>旧密码：</td>
							<td class='gridbody'>
								<input type="password" name="sysUser.pwd" id="oldPwd" /><font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>新密码：</td>
							<td class='gridbody'>
								<input type="password" name="sysUser.newPwd" id="newPwd"/><font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>确认密码：</td>
							<td class='gridbody'>
								<input type="password" name="rePwd" id="rePwd"/><font color="red">*</font>
							</td>
						</tr>
					</table>
					<br />
						<div style="margin-left: 10%;">
							<input type="submit" value="提交"/>&nbsp;&nbsp;
							<input type="reset" value="重置"/>	
						</div>					
				</form>
			</div>
    	</td>
    </tr>
  </table>
</body>

</html>

