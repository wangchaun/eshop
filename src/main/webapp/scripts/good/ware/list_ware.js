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
			getColumnsOpt()
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:'数据装载中......',
		onClickRow:function(rowIndex){
			if (lastIndex != rowIndex){
				$(gId).datagrid('endEdit', lastIndex);
				$(gId).datagrid('beginEdit', rowIndex);
			}
			lastIndex = rowIndex;
		},
		toolbar:getToolBarOpt()
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:7});
   return opt;		
}
//获取列头参数
function getColumnsOpt(){

	var opt = [
		{field:'code',title:'编号',width:20,align:'left'},
		{field:'goodName',title:'名称',width:30,align:'left'},
		{field:'goodTypeName',title:'类别',width:20,align:'left'},
		{field:'price',title:'销售价格',width:20,align:'left',formatter:priceFormat},
		{field:'purchasePrice',title:'参考进价',width:20,align:'left',formatter:purchasePriceFormat},
		{field:'averageCostInventory',title:'库存成本',width:20,align:'left',formatter:averageCostInventoryFormat},
		{field:'wareSpecificationVal',title:'规格',width:20,align:'left'}
	];
	return opt;
}
//格式化销售价格显示方式
function priceFormat(value,rowData,rowIndex){
	var price = rowData.price;
	if(price){
		price = price.toFixed(2);
	}
	return price;
}
//格式化参考进价显示方式
function purchasePriceFormat(value,rowData,rowIndex){
	var purchasePrice = rowData.purchasePrice;
	if(purchasePrice){
		purchasePrice = purchasePrice.toFixed(2);
	}
	return purchasePrice;
}
//格式化库存成本显示方式
function averageCostInventoryFormat(value,rowData,rowIndex){
	var averageCostInventory = rowData.averageCostInventory;
	if(averageCostInventory){
		averageCostInventory = averageCostInventory.toFixed(2);
	}
	return averageCostInventory;
}
//添加工具条
function getToolBarOpt(){
	var opt = '';
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

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Ware_json!listJson.do';
	return url;
}	
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}

//搜索功能
function searchData(){
	var goodCode = $("#goodCode").val(); 
	var goodName = $('#goodName').val();
	var goodTypeName = $('#goodTypeName').val();
    realoadGrid(goodCode,goodName,goodTypeName);
}
function cancelSearch(){
	 $("#goodCode").val('');
	 $('#goodName').val('');
	 $('#goodTypeName').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(goodCode,goodName,goodTypeName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"ware.code":goodCode,"ware.goodName":goodName,"ware.goodTypeName":goodTypeName};
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

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
