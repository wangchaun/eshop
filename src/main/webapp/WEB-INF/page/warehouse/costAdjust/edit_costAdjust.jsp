<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑调价单</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/warehouse/costAdjust/edit_costAdjust.js"></script>
	<style type="text/css">
		.tabtop {
			height:40px;
			font-size:12px;
		}
		.tabtop .title {
			font-size:14px;
			font-weight:bold;
		}
		.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
			clear:both;
   			height:0;
    		font-size: 1px;
    		line-height: 0px;
		}
		.border {
			font-size:12px;
    		border:1px solid #90B9DE;
		}
		.bordertd {
			font-size:12px;
		}
	</style>
</head>
<body>
	 <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px;">
					<form action="" id="orderForm">
				   	    <s:hidden name="costAdjust.id" id="id" />
				   		<s:hidden name="costAdjust.modifierId" />
				   		<s:hidden name="costAdjust.modifierName" />
				   		<s:hidden name="costAdjust.modifyTime" />
				   		<s:hidden name="costAdjust.state" id="state"/>
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridtitle'>订单编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="costAdjust.code" id="orderCode"  readonly="true"/>
						    </td>
						    <td class='gridtitle'>开单日期</td>
						    <td class='gridbody'>
						    	<input name="costAdjust.createTime" id="createTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" value="<fmt:formatDate value="${costAdjust.createTime}" pattern="yyyy-MM-dd"/>" />
						    </td>
						   	<td class='gridtitle'>经手人</td>
						    <td class='gridbody' >
						      	<s:hidden id="creatorId" name="costAdjust.creatorId" /> 
						      	<s:textfield id="creatorName" name="costAdjust.creatorName" readonly="true" />
						    </td>
						  </tr>
						  <tr>
						  	<td class='gridtitle'>仓库</td>
						    <td class='gridbody'>
						      <s:hidden id="warehouseId" name="costAdjust.warehouseId"/>
						      <s:textfield id="warehouseName" name="costAdjust.warehouseName" onclick="selectWarehouse()" cssClass="inputTextBorder" readonly="true" />
						    </td>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="3">
					    		<s:textarea id="remark" name="costAdjust.remark" cols="55" rows="2"></s:textarea>
					    	</td>
						  </tr>
						</table>
						<div class="clearfloat"></div>
						<div>
							<table id="wareTable" style="display: none;"></table><%-- 货品数据区 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						<div>
							<center>
								<c:if test="${costAdjust.state == 'c' }">
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" onclick="submitSaveForm()">保存</a>&nbsp;&nbsp;
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="confirmOrder()">审核</a>&nbsp;&nbsp;
								</c:if>
							</center>
						</div>
					</form>
				</div>
				</td>
			</tr>
		</table>
</body>
</html>

