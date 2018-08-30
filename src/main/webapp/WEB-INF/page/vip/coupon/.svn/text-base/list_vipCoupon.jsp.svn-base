<%--
	会员优惠劵列表页面
	@author 航天通信专网三院云岗网上商城,lp
	@since Oct 21, 2011 3:12:10 PM
 --%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>会员优惠劵列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/vip/coupon/list_vipCoupon.js"></script>

</head> 

<body>
	<input type="hidden"  id="customerInserts" value="${userpowermap['inserts_customer']}" />
	<input type="hidden"  id="customerDeletes" value="${userpowermap['deletes_customer']}" />
	<input type="hidden"  id="customerSelects" value="${userpowermap['selects_customer']}" />
	<input type="hidden"  id="customerUpdates" value="${userpowermap['updates_customer']}" />
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>优惠劵号：</td>
				<td class='gridbody'><input type="text" id="Code" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>优惠劵名称：</td>
				<td class='gridbody'><input type="text" id="Name" onkeydown="checkKey()" /></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
</body>

</html>