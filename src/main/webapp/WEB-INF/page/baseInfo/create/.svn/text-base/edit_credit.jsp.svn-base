<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>积分配置</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/baseInfo/create/edit_credit.js"></script>
</head>

<body>

	<table border="0" width="450px" cellspacing="0" cellpadding="0" class="gdcn-table-E">
      <tr>
   		<td class="gdcn-table-D">
			<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
				<form id="creditForm" method="post" action="">
		    	    <s:hidden name="credit.id" id="id" />
		    		<s:hidden name="credit.memo" id="memo"/>
                    <s:if test="credit.memo==1">
                     <table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">						
						<tr>
							<td class='gridtitle'>金额数：</td>
							<td class='gridbody'>
								<s:textfield name="credit.minMoney" id="minMoney" maxlength="15"/> 
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>积分数：</td>
							<td class='gridbody'>
								<s:textfield name="credit.creditNum" id="creditNum" maxlength="10"/> 
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>备注：</td>
							<td class='gridbody'>
							   ${credit.creditNum }积分等于${credit.minMoney}元
							</td>
						</tr>
					</table>
                    </s:if>
                    <s:else>
                      <table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">						
						<tr>
							<td class='gridtitle'>订单金额范围：</td>
							<td class='gridbody'>
								<s:textfield name="credit.minMoney" id="minMoney" maxlength="15"/>到
							</td>
							 
							<td class='gridbody'>
								<s:textfield name="credit.maxMoney" id="maxMoney" maxlength="15"/>
							</td>
						</tr>
						<tr>
							<td class='gridtitle'>积分数：</td>
							<td class='gridbody' colspan="2">
								<s:textfield name="credit.creditNum" id="creditNum" maxlength="10"/> 
							</td>
						</tr>
						 
					</table>
                    </s:else>

					
				</form>
			</div>
    	</td>
    </tr>
  </table>
</body>

</html>

