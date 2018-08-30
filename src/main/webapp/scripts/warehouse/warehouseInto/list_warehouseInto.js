var gId = '#dataGrid';
var warehouseInserts='#warehouseInserts';
var warehouseDeletes='#warehouseDeletes';
var warehouseSelects='#warehouseSelects';
var warehouseUpdates='#warehouseUpdates';
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
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:30,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' && $(warehouseSelects).val()=='1'){
						operate = '查看';
					}else if(rowData._state != 's' && $(warehouseUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(warehouseSelects).val()=='1' || $(warehouseUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData._state != 's' && $(warehouseDeletes).val()=='1'){
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
		{field:'warehouseName',title:'仓库',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'state',title:'入库状态',width:20,align:'left',formatter:stateFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var type = $('#type').val();
	var opt = [];
	if(type != '0' && $(warehouseInserts).val()=='1'){
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
//格式化送货状态
function stateFormat(value,rowData,rowIndex){
	var result = '未入库';
	var state = rowData._state;
	if('s' == state){
		result = '已入库';
	}
	return result;
}
//格式化收货时间
function deliveryTimeFormat(value,rowData,rowIndex){
	var deliveryTime = rowData.deliveryTime;
	var deliveryTimeStr = '';
	if(deliveryTime && deliveryTime!=null && deliveryTime!=''){
		deliveryTimeStr = deliveryTime.substring(0,10);
	}
	return deliveryTimeStr;
}
//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/WarehouseInto_json!listJson.do?1=1';
	var type = $('#type').val();
	if(type != ''){
		url += '&warehouseInto.type='+type;
	}
	return url;
}	
//编辑数据
function editData(id){
	var url = ctx+'/warehouseInto!edit.do?1=1';
	var title = '';
	var type = $('#type').val();
	if(id != ''){
		url += '&warehouseInto.id='+id;
		if(type =='0'){
			title = '编辑商品入库单';
		}
		if(type =='1'){
			title = '编辑赠品入库单';
		}
		if(type =='2'){
			title = '编辑其他入库单';
		}
	}else{
		if(type =='0'){
			title = '新增商品入库单';
		}
		if(type =='1'){
			title = '新增赠品入库单';
		}
		if(type =='2'){
			title = '新增其他入库单';
		}
		if(type=='3'){
			title = '新增其他出库单';
		}
	}
	if(type != ''){
		url += '&warehouseInto.type='+type;
	}
	window.parent.addTab(title,url);
}

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode == '13'){
		searchData();
	}
}
//搜索功能
function searchData(){
	var orderCode = $("#orderCode").val(); 
	var warehouseName = $('#warehouseName').val();
    realoadGrid(orderCode,warehouseName);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 $('#warehouseName').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode,warehouseName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"warehouseInto.code":orderCode,"warehouseInto.warehouseName":warehouseName};
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
			  url: ctx+"/warehouseInto!delete.do",
			  data: "warehouseInto.id=" + id,
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
