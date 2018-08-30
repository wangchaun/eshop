<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>编辑调度单</title>
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
	<script type="text/javascript" src="${ctx }/scripts/warehouse/warehouseMove/edit_warehouseMove.js"></script>
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
					<form action="" id="warehouseMoveWareForm">
				   	    <s:hidden name="warehouseMove.id" id="id" />
				   	    <s:hidden name="warehouseMove.fwarehouseId" id="fwarehouseId" />
				   	    <s:hidden name="warehouseMove.swarehouseId" id="swarehouseId" />
				   	    <s:hidden name="warehouseMove.handlerId" id="handlerId" />
				   	    <s:hidden name="warehouseMove.deptId" id="deptId" />
				   	    <s:hidden name="warehouseMove.creatorId" id="creatorId" />
				   	    <s:hidden name="warehouseMove.modifierId" id="modifierId" />
				   	    <s:hidden name="warehouseMove.modifierName" id="modifierName" />
				   	    <s:hidden name="warehouseMove.modifyTime" id="modifyTime" />
				   	    <s:hidden name="warehouseMove.state" id="state" />
				   		
				   		<table width="96%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
						  <tr>
						    <td class='gridtitle'>编号</td>
						    <td class='gridbody'>
						    	<s:textfield name="warehouseMove.code" id="code"  readonly="true" cssClass="inputTextBorder"/>
						    </td>
						   
						    <td class='gridtitle'>开单时间</td>
						    <td class='gridbody'>
						    	<input name="warehouseMove.createTime" id="createTime"  readonly="true" cssClass="inputTextBorder" value="<fmt:formatDate value="${warehouseMove.createTime}" pattern="yyyy-MM-dd HH:mm"/>" />
						    </td>
						    <td class='gridtitle'>经手人</td>
						    <td class='gridbody'>
						    	<s:textfield name="warehouseMove.handlerName" id="handlerName" readonly="true" cssClass="inputTextBorder"/>
						    </td>
						    <td class='gridtitle'>部门</td>
						    <td class='gridbody'>
						    	<s:textfield name="warehouseMove.deptName" id="deptName" readonly="true" cssClass="inputTextBorder"/>
						    </td>
						    <tr>
						    <td class='gridtitle'>发货仓库</td>
						    <td class='gridbody'>
						    	<s:textfield name="warehouseMove.fwarehouseName" id="fwarehouseName" onclick="selectFwarehouseName()" readonly="true" cssClass="inputTextBorder"/>
						    </td>
						    <td class='gridtitle'>收货仓库</td>
						    <td class='gridbody'>
						    	<s:textfield name="warehouseMove.swarehouseName" id="swarehouseName" onclick="selectSwarehouseName()" readonly="true" cssClass="inputTextBorder"/>
						    </td>
					  		<td class='gridtitle'>备注</td>
					    	<td class='gridbody' colspan="3">
					    		<s:textarea id="remark" name="warehouseMove.remark" cols="55" rows="2"></s:textarea>
					    	</td>
						  </tr>
						</table>
						<div class="clearfloat"></div>
						<div>
							<table id="warehouseMoveWareTable" style="display: none;"></table><%-- 调度货物数据区 --%>
						    <table id="dataGrid" ></table>
						</div>
						<div class="clear"></div><br>
						<div>
							<center>
								<c:if test="${warehouseMove.state == 'c' }">
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" onclick="submitSaveForm()">保存</a>&nbsp;&nbsp;
									<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="comfirmMove()">审核</a>&nbsp;&nbsp;
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

