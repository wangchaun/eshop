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
		rownumbers:false,
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
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'销售排行榜',colspan:8});
	
   return opt;		
}
//计算总计
function getTotal()
{
	var op=[
		{field:'sumtotalSales',title:'总销量总计',hidden:true,align:'left',formatter:totalFormat},
		{field:'sumpurchaseNum',title:'进货数量总计',hidden:true,align:'left'}
	];
	return op;
}
//格式化总计
function totalFormat(value,rowData,rowIndex){
	var sumtotalSales = rowData.sumtotalSales;
	var sumpurchaseNum=rowData.sumpurchaseNum;
	$("#totaltab").show();
	$("#sale").html(sumtotalSales);
	$("#num").html(sumpurchaseNum);
	return sumtotalSales;
}
//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'code',title:'编号',width:15,align:'left'},
		{field:'name',title:'品名',width:40,align:'left'},
		{field:'goodTypeName',title:'类别',width:15,align:'left'},
		{field:'brandName',title:'品牌',width:15,align:'left'},
		{field:'price',title:'价格',width:15,align:'left'},
		{field:'purchaseNum',title:'进货数量',width:15,align:'left'},
		{field:'totalSales',title:'总销量',width:15,align:'left'},
		{field:'beginSaleTime',title:'上架时间',width:15,align:'left',formatter:beginSaleTimeFormat}
	];
	return opt;
}


//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Salerise_json!listJson.do?1=1';
	return url;
}	
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//格式化beginSaleTime
function beginSaleTimeFormat(value,rowData,rowIndex){
	var beginSaleTime = rowData.beginSaleTime;
	return dateFormat(beginSaleTime);
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}

//搜索功能
function searchData(){

	var goodCode = $("#goodCode").val(); 
	var goodName = $('#goodName').val();
	var goodTypeName = $('#goodTypeName').val();
	var begin = $('#begin').val();
	var end = $('#end').val();
    realoadGrid(goodCode,goodName,goodTypeName,begin,end);
}
function cancelSearch(){
	 $("#goodCode").val('');
	 $('#goodName').val('');
	 $('#goodTypeName').val('');
	 $('#begin').val('');
	 $('#end').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(goodCode,goodName,goodTypeName,begin,end){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"good.code":goodCode,"good.name":goodName,"good.goodTypeName":goodTypeName,"good.begin":begin,"good.end":end};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//点击行
function clickRow(id,name){ 
	var openObj = window.dialogArguments;
	if('open' == openObj){
		var data = {'id':id ,'name':name};
		window.returnValue = data; 
		window.close(); 		
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
