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
	if('show' == todo){
		$('#search').attr('width','100%');
	}
});
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '编辑';
	opt.push({title:'基本信息',colspan:9});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:20,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if(rowData.deliveryState == 1 && $(orderSelects).val()=='1'){
						operate = '查看';
					}
					if('' == todo){
						if(rowData.deliveryState == 1 && $(orderSelects).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData.deliveryState != 1 && $(orderDeletes).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
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
		{field:'handlerName',title:'经手人',width:20,align:'left'},
		{field:'moneyAccount',title:'总金额',width:10,align:'left',formatter:moneyFormat},
		{field:'moneyReceived',title:'收款金额',width:20,align:'left',formatter:moneyReceivedFormat},
		{field:'linkman',title:'联系人',width:15,align:'left'},
		{field:'deliveryName',title:'配送方式',width:20,align:'left'},
		{field:'deliveryState',title:'取货时间',width:30,align:'left',formatter:deliveryStateFormat},
		{field:'paymentState',title:'收款状态',width:20,align:'left',formatter:paymentStateFormat}
		
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
			}
		];
	}
	if('show' == todo){
		opt = [{
		      text:'选择',
		      iconCls:'icon-ok',
		      handler:function(){
		      	var rowArr = $(gId).datagrid('getSelections');
		      	if(rowArr && rowArr.length){
	     			window.returnValue = rowArr;
	     			window.close();
		        }else{
		       		alert('请选择');
		        }
		      }	    	
		 	}];	
	}
    return opt;		
}

//格式化金额显示方式
function moneyFormat(value,rowData,rowIndex){
	var moneyAccount = rowData.moneyAccount;
	if(moneyAccount){
		moneyAccount = moneyAccount.toFixed(2);
	}
	return moneyAccount;
}
//格式化收款金额
function moneyReceivedFormat(value,rowData,rowIndex){
	var moneyReceived = rowData.moneyReceived;
	if(moneyReceived == null){
		moneyReceived = 0;
	}
	moneyReceived = moneyReceived.toFixed(2);
	return moneyReceived;
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
//格式化送货状态
function deliveryStateFormat(value,rowData,rowIndex){
	 
	var  result = rowData.createTime;
	return result;
}
//收款状态
function paymentStateFormat(value,rowData,rowIndex){
	var result = '未收款';
	var paymentState = rowData.paymentState;
	if('1' == paymentState){
		result = '已收款';
	}
	return result;
}
//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/SaleDelivery_json!listJson.do?';
	var paymentState = $('#paymentState').val();
	if(paymentState != ''){
		url += 'saleDelivery.paymentState=1';
	}
	var customerId = $('#customerId').val();
	if(customerId != ''){
		url += '&saleDelivery.customerId='+customerId;
	}
	return url;
}	
//编辑数据
function editData(id){
	var url = ctx+'/saleDelivery!edit.do?1=1';
	var title = '新增销售出货单';
	if(id != ''){
		url += '&saleDelivery.id='+id;
		title = '编辑销售出货单';
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
	var warehouseId = $("#warehouseId").val(); 
	var mobile = $('#mobile').val();
    realoadGrid(orderCode,customerName,warehouseId,mobile);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 $('#customerName').val('');
	 $("#warehouseId").val(''); 
	 $('#mobile').val('');
	 $('#warehouseName').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode,customerName,warehouseId,mobile){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleDelivery.code":orderCode,"saleDelivery.customerName":customerName,"saleDelivery.warehouseId":warehouseId,"saleDelivery.mobile":mobile};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//删除订单
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/saleDelivery!delete.do",
			  data: "saleDelivery.id=" + id,
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
//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}