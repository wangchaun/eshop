var gId = '#dataGrid';
var orderInserts='#orderInserts';
var orderDeletes='#orderDeletes';
var orderSelects='#orderSelects';
var orderUpdates='#orderUpdates';
$(document).ready(function(){
	//列表
	$(gId).datagrid({
		url:getUrlOpt(),
		idField:'id',
		fitColumns:true,
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
		    getTableHeadOpt(),
			getColumnsOpt()
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:'数据装载中...',
		toolbar:getToolBarOpt()
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '';
	opt.push({title:'基本信息',colspan:8});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					var iscancel = rowData.iscancel;
					
					if(rowData.orderState == 1 && $(orderSelects).val()=='1' || iscancel == '1'){
						operate = '查看';
					}else if(rowData.orderState != 1 && $(orderUpdates).val()=='1' && iscancel == '0')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(orderSelects).val()=='1' || $(orderUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData.orderState != 1 && $(orderDeletes).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
						}
						if(rowData.deliveryState == 1 && $(orderSelects).val()=='1' && iscancel == '0'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="viewSaleDelivery(\''+rowData.id+'\');">出货单</a>';
						}
					}					
					return html;
				}
			}			
		);		
	}
   return opt;		
}
//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'code',title:'订单编号',width:25,align:'left'},
		{field:'customerName',title:'客户名称',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'orderMoney',title:'订单金额',width:25,align:'left',formatter:moneyFormat},
	    //{field:'deliveryDate',title:'取货时间',width:20,align:'left',formatter:deliveryDateFormat},
		{field:'orderState',title:'订单状态',width:20,align:'left',formatter:stateFormat},
		{field:'deliveryState',title:'送货状态',width:20,align:'left',formatter:deliveryStateFormat},
		{field:'paymentState',title:'收款状态',width:20,align:'left',formatter:paymentStateFormat},
		{field:'iscancel',title:'是否取消',width:20,align:'left',formatter:iscancelFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(orderInserts).val()=='1')
	{
			 opt = [
				 {	
					text:'新增',
			 		iconCls:'icon-add',
			 		handler:function(){
			 			editData('');
		 			}
				},'-',{
			     text:'删除',
			     iconCls:'icon-remove',
			     handler:function(){
			        deleteData();
			     }
		 		}
				];
		}
    return opt;		
}

//格式化金额显示方式
function moneyFormat(value,rowData,rowIndex){
	var orderMoney = rowData.orderMoney;
	if(orderMoney){
		orderMoney = orderMoney.toFixed(2);
	}
	return orderMoney;
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
//格式化订单状态
function stateFormat(value,rowData,rowIndex){
	var result = '待确认';
	var orderState = rowData.orderState;
	if('1' == orderState){
		result = "已确认";
	}
	return result;
}
//格式化送货状态
function deliveryStateFormat(value,rowData,rowIndex){
	var result = '未发货';
	var deliveryState = rowData.deliveryState;
	if('1' == deliveryState){
		result = '已发货';
	}
	return result;
}
//格式化送货时间
function deliveryDateFormat(value,rowData,rowIndex){
	var result = '用户未取货';
 
	var deliveryDate = rowData.deliveryDate;
	if('1' == deliveryDate){
		result = rowData.deliveryTime;
	}
	return result;
}
//格式化收款状态
function paymentStateFormat(value,rowData,rowIndex){
	var result = '未收款';
	var paymentState = rowData.paymentState;
	if('1' == paymentState){
		result = '已收款';
	}
	return result;
}
//格式化订单是否取消
function iscancelFormat(value,rowData,rowIndex){
	var result = '否';
	var iscancel = rowData.iscancel;
	if('0' == iscancel){
		result = '否';
	}
	if('1' == iscancel){
		result = "<font color='red'>是</font>";
	}
	return result;
}


//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/SaleOrder_json!listJson.do';
	return url;
}	
//编辑数据
function editData(id){
   
	var url = ctx+'/saleOrder!edit.do?1=1';
	var title = '新增销售订单';
	if(id != ''){
	 
		url += '&saleOrder.id='+id;
		title = '编辑销售订单';
	}
	window.parent.addTab(title,url);
}

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//搜索功能
function searchData(){
	var orderCode = $("#orderCode").val(); 
	var customerName = $('#customerName').val();
	var orderState = $("#orderState").val(); 
	var warehouseId = $('#warehouseId').val();
    realoadGrid(orderCode,customerName,orderState,warehouseId);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 $('#customerName').val('');
	 $("#orderState").val('');
	 $("#warehouseId").val('');
	 $("#warehouseName").val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode,customerName,orderState,warehouseId){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleOrder.code":orderCode,"saleOrder.customerName":customerName,"saleOrder.orderState":orderState,"saleOrder.warehouseId":warehouseId};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//删除订单
function deleteData(id){
	if(confirm('你确定要删除吗?')){
	var ids = [];
	var rows = $(gId).datagrid('getSelections');
	if(rows &&  rows.length>0){
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		var id = ids.join(',');
		$.ajax({
			  type: "POST",
			  async: false, //同步
			  cache: false,
			  url: ctx+"/saleOrder!delete.do",
			  data: "saleOrder.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else {
						alert('删除失败!');
					}
				},
			  error : function(){
					alert('系统错误!');
			  } 
		});
	}
  }
}
//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
//查看出货单
function viewSaleDelivery(orderId){
	if(orderId != ''){
		var url = ctx + '/saleDelivery!edit.do?saleOrder.id='+orderId;
		window.parent.addTab("查看销售出货单",url);
	}
}
