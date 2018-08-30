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
	var operate = '编辑';
	opt.push({title:'基本信息',colspan:7});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:20,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if(rowData.paymentState == 1 && $(orderSelects).val()=='1'){
						operate = '查看';
					}
					if('' == todo){
						if(rowData.paymentState == 1 && $(orderSelects).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData.paymentState != 1 && $(orderDeletes).val()=='1'){
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
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'moneyAccount',title:'总金额',width:25,align:'left',formatter:moneyFormat},
		{field:'linkman',title:'联系人',width:25,align:'left'},
		{field:'paymentName',title:'支付方式',width:25,align:'left'},
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
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
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
//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/SaleCollection_json!listJson.do';
	return url;
}	
//编辑数据
function editData(id){
	var url = ctx+'/saleCollection!edit.do?1=1';
	var title = '新增销售收款单';
	if(id != ''){
		url += '&saleCollection.id='+id;
		title = '编辑销售收款单';
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
    realoadGrid(orderCode,customerName);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 $('#customerName').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode,customerName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleCollection.code":orderCode,"saleCollection.customerName":customerName};
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
			  url: ctx+"/saleCollection!delete.do",
			  data: "saleCollection.id=" + id,
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