<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>销售明细报表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/print.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/formcenter/orderform/saledetail/list_saledetail.js"></script>

</head> 

<body>
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>商品编号：</td>
				<td class='gridbody'><input type="text" id="goodCode" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>商品名称：</td>
				<td class='gridbody'><input type="text" id="goodName" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>日期 从：</td>
				<td class='gridbody'><input type="text" id="begin" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
				<td class='gridtitle'>到</td>
				<td class='gridbody'><input type="text" id="end"  readonly="readonly"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
	<table width="100%" style="font-size: 12"  border="0" cellpadding="0" cellspacing="0">
		<tr align="left">
			<td>&nbsp;</td>
			<td>数量总计:<span id="num" style="color: red;"></span></td>
			<td>金额总计:<span id="money" style="color: red;"></span></td>
		</tr>
	</table>
	<div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="400px" height="200px"></iframe>
	</div>
	<div align="center">
		<a id="btnAudit" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-print" onclick="printit()">打印</a>
	</div>
</body>

</html>