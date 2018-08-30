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
		rownumbers:true,
		pagination:false,
		loadMsg:'数据装载中......',
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
	var opt=[
		{field:'totalSalesmoney',title:'出货金额总计',hidden:true,align:'left',formatter:totalFormat},
		{field:'totalCostmoney',title:'成本金额总计',hidden:true,align:'left'},
		{field:'totalOrderNum',title:'出货数量总计',hidden:true,align:'left'}
	];
	return opt;
}
//格式化总计
function totalFormat(value,rowData,rowIndex){
	var totalSalesmoney = rowData.totalSalesmoney;
	var totalCostmoney=rowData.totalCostmoney;
	var totalOrderNum=rowData.totalOrderNum;
	$("#num").html(totalOrderNum);
	$("#sale").html(totalSalesmoney);
	$("#cost").html(totalCostmoney);
	return totalSalesmoney;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'销售汇总报表',colspan:11});
   return opt;		
}
//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'goodCode',title:'商品编号',width:15,align:'left'},
		{field:'goodTypeName',title:'商品类别',width:10,align:'left'},
		{field:'goodName',title:'商品名',width:30,align:'left'},
		{field:'unit',title:'单位',width:10,align:'left'},
		{field:'purchasePrice',title:'进货价',width:15,align:'left'},
		{field:'goodPrice',title:'销售单价',width:15,align:'left'},
		{field:'taxRate',title:'商品税率',width:15,align:'left'},
		{field:'orderNumber',title:'销售数量',width:20,align:'left'},
		{field:'taxDueSum',title:'销售税金',width:15,align:'left',formatter:taxDueSumFormat},
		{field:'salesmoney',title:'不含税销售金额',width:20,align:'left'},
		{field:'costmoney',title:'成本金额',width:20,align:'left'}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Salesummary_json!listJson.do?1=1';
	return url;
}	
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//格式化销售税金显示方式
function taxDueSumFormat(value,rowData,rowIndex){
	var taxDueSum = rowData.taxDueSum;
	if(taxDueSum){
		taxDueSum = taxDueSum.toFixed(2);
	}
	return taxDueSum;
}
//搜索功能
function searchData(){

	var goodTypeName = $('#goodTypeName').val(); 
	var goodName = $('#goodName').val();
	var begin = $('#begin').val();
	var end = $('#end').val();
	var brandName=$('#brandName').val();
	var positionName=$('#warehousePositionName').val();
    realoadGrid(goodTypeName,goodName,begin,end,brandName,positionName);
}
function cancelSearch(){
	 $('#goodTypeName').val('');
	 $('#goodName').val('');
	 $('#begin').val('');
	 $('#end').val('');
	 $('#brandName').val('');
	 $('#warehouseName').val('');
	 $('#warehousePositionName').val(''); 
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(goodTypeName,goodName,begin,end,brandName,positionName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleWare.goodTypeName":goodTypeName,"saleWare.goodName":goodName,"saleWare.begin":begin,"saleWare.end":end,"saleWare.brandName":brandName,"saleWare.warehousePositionName":positionName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
//选择仓库
function selectWarehousePosition(){
	var warehouseName=$('#warehouseName').val();
	if(warehouseName==null||warehouseName=='')
	{
		alert('请选择仓库');
	}
	else
	{
	   WarehousePosition();
	}
}
 
//仓位
function WarehousePosition(){	
	var warehousePosition = common.getWarehousePosition();
	if(warehousePosition){
		$('#warehousePositionName').val(warehousePosition.name);
	}
}
//选择商品品牌
function selectBrand(obj){
	var obj = $(obj);
	var dataArr = window.showModalDialog(ctx+"/goodBrand!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		$(obj).val(dataArr.brandName);
		$("#brandId").val(dataArr.brandId);
		$(obj).focus();
	}
}
//选择商品类别弹出窗
function selectType(obj){
	var obj = $(obj);
	var dataArr = window.showModalDialog(ctx+"/goodType!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		$(obj).val(dataArr.typeName);
		$(obj).focus();
	}
}

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
