var gId = '#dataGrid';
var lastIndex;
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
			getColumnsOpt(),
			getTotal()
		],
		pageSize:20,
		rownumbers:true,
		pagination:false,
		loadMsg:'数据装载中......',
		onDblClickRow:function(rowIndex,rowData){
				editData(rowData.saleId);
		},
		onClickRow:function(rowIndex){
			if (lastIndex != rowIndex){
				$(gId).datagrid('endEdit', lastIndex);
				$(gId).datagrid('beginEdit', rowIndex);
			}
			lastIndex = rowIndex;
		}
	});

});

//计算总计
function getTotal()
{
	var op=[
		{field:'totalOrderNum',title:'数量总计',hidden:true,align:'left',formatter:totalFormat},
		{field:'totalSalesmoney',title:'金额总计',hidden:true,align:'left'}
	];
	return op;
}
//格式化总计
function totalFormat(value,rowData,rowIndex){
	var totalOrderNum = rowData.totalOrderNum;
	var totalSalesmoney=rowData.totalSalesmoney;
	$("#num").html(totalOrderNum);
	$("#money").html(totalSalesmoney);
	return totalOrderNum;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'销售明细报表',colspan:8});
   return opt;		
}
//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'createTime',title:'日期',width:20,align:'left',formatter:createTimeFormat},
		{field:'orderCode',title:'订单编号',width:15,align:'left'},
		{field:'goodCode',title:'商品编号',width:15,align:'left'},
		{field:'goodName',title:'商品名',width:40,align:'left'},
		{field:'goodPrice',title:'单价',width:15,align:'left'},
		{field:'unit',title:'单位',width:15,align:'left'},
		{field:'orderNumber',title:'数量',width:15,align:'left'},
		{field:'money',title:'金额',width:15,align:'left',formatter:moneyFormat}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Saledetail_json!listJson.do?1=1';
	return url;
}	
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}

//格式化createTime
function createTimeFormat(value,rowData,rowIndex){
	var createTime = rowData.createTime;
	return dateFormat(createTime);
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
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

//格式化金额显示方式
function moneyFormat(value,rowData,rowIndex){
	var money = rowData.money;
	if(money){
		money = money.toFixed(2);
	}
	return money;
}
//搜索功能
function searchData(){

	var goodCode = $("#goodCode").val(); 
	var goodName = $('#goodName').val();
	var begin = $('#begin').val();
	var end = $('#end').val();
    realoadGrid(goodCode,goodName,begin,end);
}
function cancelSearch(){
	 $("#goodCode").val('');
	 $('#goodName').val('');
	 $('#begin').val('');
	  $('#end').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(goodCode,goodName,begin,end){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleWare.goodCode":goodCode,"saleWare.goodName":goodName,"saleWare.begin":begin,"saleWare.end":end};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}


//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
