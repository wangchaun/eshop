<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>广告列表</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/store/advertise/list_Advertise.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>

</head> 

<body>
	<input type="hidden"  id="marketInserts" value="${userpowermap['inserts_market']}" />
	<input type="hidden"  id="marketDeletes" value="${userpowermap['deletes_market']}" />
	<input type="hidden"  id="marketSelects" value="${userpowermap['selects_market']}" />
	<input type="hidden"  id="marketUpdates" value="${userpowermap['updates_market']}" />
	<div style="margin-top: 10px; margin-bottom: 5px;">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="100%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>广告编号：</td>
				<td class='gridbody'><input type="text" id="code" onkeydown="checkKey()"/></td>
				<td class='gridtitle'>广告主题：</td>
				<td class='gridbody'><input type="text" id="subject" onkeydown="checkKey()"/></td>
				
				<td><td class='gridtitle'>显示位置</td>
					<td class='gridbody' colspan="5">
						<select name="advertise.placeId" id="placeId"  onchange="selectAdvertise(this.value)">
							    <option value="0"> --  显示位置  -- </option>
												
							    <option value="分类焦点1" <c:if test="${advertise.placeId=='分类焦点1'}">selected="selected"</c:if> >分类焦点1</option>
								<option value="分类焦点2" <c:if test="${advertise.placeId=='分类焦点2'}">selected="selected"</c:if> >分类焦点2</option>
							    <option value="分类焦点3" <c:if test="${advertise.placeId=='分类焦点3'}">selected="selected"</c:if> >分类焦点3</option>
								<option value="分类焦点4" <c:if test="${advertise.placeId=='分类焦点4'}">selected="selected"</c:if> >分类焦点4</option>
												
												
												
								<option value="横幅banner" <c:if test="${advertise.placeId=='横幅banner'}">selected="selected"</c:if>>横幅banner</option>
												
								<option value="首页焦点1" <c:if test="${advertise.placeId=='首页焦点1'}">selected="selected"</c:if> >首页焦点1</option>
								<option value="首页焦点2" <c:if test="${advertise.placeId=='首页焦点2'}">selected="selected"</c:if> >首页焦点2</option>
								<option value="首页焦点3" <c:if test="${advertise.placeId=='首页焦点3'}">selected="selected"</c:if> >首页焦点3</option>
								<option value="首页焦点4" <c:if test="${advertise.placeId=='首页焦点4'}">selected="selected"</c:if> >首页焦点4</option>
												
								<option value="首页促销1" <c:if test="${advertise.placeId=='首页促销1'}">selected="selected"</c:if> >首页促销1</option>
								<option value="首页促销2" <c:if test="${advertise.placeId=='首页促销2'}">selected="selected"</c:if> >首页促销2</option>
								<option value="首页促销3" <c:if test="${advertise.placeId=='首页促销3'}">selected="selected"</c:if> >首页促销3</option>
								<option value="首页促销4" <c:if test="${advertise.placeId=='首页促销4'}">selected="selected"</c:if> >首页促销4</option>
								<option value="首页促销5" <c:if test="${advertise.placeId=='首页促销5'}">selected="selected"</c:if> >首页促销5</option>
											
											
								<option value="全国焦点1" <c:if test="${advertise.placeId=='全国焦点1'}">selected="selected"</c:if> >全国焦点1</option>
								<option value="全国焦点2" <c:if test="${advertise.placeId=='全国焦点2'}">selected="selected"</c:if> >全国焦点2</option>
								<option value="全国焦点3" <c:if test="${advertise.placeId=='全国焦点3'}">selected="selected"</c:if> >全国焦点3</option>
								<option value="全国焦点4" <c:if test="${advertise.placeId=='全国焦点4'}">selected="selected"</c:if> >全国焦点4</option>
								<option value="全国促销1" <c:if test="${advertise.placeId=='全国促销1'}">selected="selected"</c:if> >全国促销1</option>
								<option value="全国促销2" <c:if test="${advertise.placeId=='全国促销2'}">selected="selected"</c:if> >全国促销2</option>
								<option value="全国促销3" <c:if test="${advertise.placeId=='全国促销3'}">selected="selected"</c:if> >全国促销3</option>
												
								<option value="团购专题1" <c:if test="${advertise.placeId=='团购专题1'}">selected="selected"</c:if> >团购专题1</option>
								<option value="团购专题2" <c:if test="${advertise.placeId=='团购专题2'}">selected="selected"</c:if> >团购专题2</option>
								<option value="团购专题3" <c:if test="${advertise.placeId=='团购专题3'}">selected="selected"</c:if> >团购专题3</option>
											
												
								<option value="联盟焦点1" <c:if test="${advertise.placeId=='联盟焦点1'}">selected="selected"</c:if> >联盟焦点1</option>
								<option value="联盟焦点2" <c:if test="${advertise.placeId=='联盟焦点2'}">selected="selected"</c:if> >联盟焦点2</option>
								<option value="联盟焦点3" <c:if test="${advertise.placeId=='联盟焦点3'}">selected="selected"</c:if> >联盟焦点3</option>
								<option value="联盟焦点4" <c:if test="${advertise.placeId=='联盟焦点4'}">selected="selected"</c:if> >联盟焦点4</option>
								<option value="联盟焦点5" <c:if test="${advertise.placeId=='联盟焦点5'}">selected="selected"</c:if> >联盟焦点5</option>
								<option value="1F专题1" <c:if test="${advertise.placeId=='1F专题1'}">selected="selected"</c:if> >1F专题1</option>
								<option value="1F专题2" <c:if test="${advertise.placeId=='1F专题2'}">selected="selected"</c:if> >1F专题2</option>
								<option value="1F专题3" <c:if test="${advertise.placeId=='1F专题3'}">selected="selected"</c:if> >1F专题3</option>
								<option value="1F专题4" <c:if test="${advertise.placeId=='1F专题4'}">selected="selected"</c:if> >1F专题4</option>
								<option value="2F专题1" <c:if test="${advertise.placeId=='2F专题1'}">selected="selected"</c:if> >2F专题1</option>
								<option value="2F专题2" <c:if test="${advertise.placeId=='2F专题2'}">selected="selected"</c:if> >2F专题2</option>
								<option value="2F专题3" <c:if test="${advertise.placeId=='2F专题3'}">selected="selected"</c:if> >2F专题3</option>
								<option value="2F专题4" <c:if test="${advertise.placeId=='2F专题4'}">selected="selected"</c:if> >2F专题4</option>
								<option value="3F专题1" <c:if test="${advertise.placeId=='3F专题1'}">selected="selected"</c:if> >3F专题1</option>
								<option value="3F专题2" <c:if test="${advertise.placeId=='3F专题2'}">selected="selected"</c:if> >3F专题2</option>
								<option value="3F专题3" <c:if test="${advertise.placeId=='3F专题3'}">selected="selected"</c:if> >3F专题3</option>
								<option value="3F专题4" <c:if test="${advertise.placeId=='3F专题4'}">selected="selected"</c:if> >3F专题4</option>
								<option value="4F专题1" <c:if test="${advertise.placeId=='4F专题1'}">selected="selected"</c:if> >4F专题1</option>
								<option value="4F专题2" <c:if test="${advertise.placeId=='4F专题2'}">selected="selected"</c:if> >4F专题2</option>
								<option value="4F专题3" <c:if test="${advertise.placeId=='4F专题3'}">selected="selected"</c:if> >4F专题3</option>
								<option value="4F专题4" <c:if test="${advertise.placeId=='4F专题4'}">selected="selected"</c:if> >4F专题4</option>
																							
								<option value="资讯专题1" <c:if test="${advertise.placeId=='资讯专题1'}">selected="selected"</c:if> >资讯专题1</option>
								<option value="资讯专题2" <c:if test="${advertise.placeId=='资讯专题2'}">selected="selected"</c:if> >资讯专题2</option>
								<option value="资讯专题3" <c:if test="${advertise.placeId=='资讯专题3'}">selected="selected"</c:if> >资讯专题3</option>
												
								<option value="资讯头条1" <c:if test="${advertise.placeId=='资讯头条1'}">selected="selected"</c:if> >资讯头条1</option>
								<option value="资讯头条2" <c:if test="${advertise.placeId=='资讯头条2'}">selected="selected"</c:if> >资讯头条2</option>
								<option value="资讯头条3" <c:if test="${advertise.placeId=='资讯头条3'}">selected="selected"</c:if> >资讯头条3</option>
						   </select>
					</td>
			
				
				
				<td class='gridtitle'>
					<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">搜索</a>&nbsp;&nbsp;&nbsp;
	  				<a id="btnAudit" href="javascript:;" class="easyui-linkbutton" iconCls="icon-reload" onclick="cancelSearch()">清空</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataGrid"></table>
</body>

</html>