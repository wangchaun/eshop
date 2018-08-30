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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/goodKind/edit_goodKingVal.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
</head>
<body>

    <table width="500px"  border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					
					<form id="saveForm" method="post" action="">
			    		<s:hidden name="goodKingVal.id" id="id" />
			    		<s:hidden name="goodKingVal.goodKingId"/>
				    	<table width="500px"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
							<tr>
								<td class='gridtitle'>值名称：</td>
								<td class='gridbody'>
									<s:textfield id="value" name="goodKingVal.value"/>
								</td>
							</tr>
							<tr>
								<td class='gridtitle'>序号：</td>
								<td class='gridbody'>
									<s:textfield id="sort" name="goodKingVal.sort"/>
								</td>
							</tr>
							<tr>
										<td  class='gridtitle'>备注:</td>
										<td class='gridbody' >
											<textarea id="remark" name="goodKingVal.remark" cols="60" rows="10">${goodKingVal.remark}&nbsp;</textarea>
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

