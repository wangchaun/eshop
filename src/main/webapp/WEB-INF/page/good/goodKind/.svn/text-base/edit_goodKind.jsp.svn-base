<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/goodKind/edit_goodKind.js"></script>
</head>
<body>

    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="goodKind.id" id="id" />
			    		<s:hidden name="goodKind.code" />
			    		<s:hidden name="goodKind.creatorId" />
			    		<s:hidden name="goodKind.creatorName" />
			    		<s:hidden name="goodKind.createTime" />
			    		<s:hidden name="goodKind.modifierId" />
			    		<s:hidden name="goodKind.modifierName" />
			    		<s:hidden name="goodKind.modifyTime" />
			    		<s:hidden name="goodKind.state" />
				    	
				    	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
					    	<tr>
								<td class='gridtitle'>种类编号：</td>
								<td class='gridbody'>
									<s:textfield id="code" name="goodKind.code" disabled="true"/>				
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>种类名称：</td>
								<td class='gridbody'>
									<s:textfield id="name" name="goodKind.name" />	
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>匹配系列：</td>
								<td class='gridbody'>
									<s:select id="goodtypeId" name="goodKind.goodtypeId" list="goodTypeList" listKey="id"  listValue="name" 
										headerKey="0" headerValue="--请为此种类匹配商品类型--"/>
								</td>
							</tr>
							<s:hidden id="sort" name="goodKind.sort"/>
							<!-- 
								<tr>
								<td class='gridtitle'>序号：</td>
								<td class='gridbody'>
									<s:textfield id="sort" name="goodKind.sort"/>	
								</td>
							</tr>
							 -->
							<tr>
								<td class='gridtitle'>备注：</td>
								<td class='gridbody'>
									<s:textfield id="remark" name="goodKind.remark"/>
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

