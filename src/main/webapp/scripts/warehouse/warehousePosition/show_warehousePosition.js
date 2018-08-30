var gId = '#dataGrid';
$(document).ready(function(){
	$(gId).datagrid(getGridOpt());//列表
	
	//获取列表参数
	function getGridOpt(){
		var opt = {
			url:getUrlOpt(),
			idField:'id',
			fitColumns:true,
			frozenColumns:[[
	               {field:'ck',checkbox:true}
	        ]],
			columns:[
				getTableHeadOpt(),
				[
					{field:'code',title:'编号',width:30,align:'left'},
					{field:'name',title:'名称',width:40,align:'left'},
					{field:'sort',title:'序号',width:20,align:'left'}
				]
			],
			pageSize:20,
			rownumbers:true,
			pagination:true,
			loadMsg:'数据装载中......',
			onDblClickRow:function(rowIndex,rowData){
				if('' == todo){
					editData(rowData.id);
				}
			},
		    toolbar:getToolBarOpt()
		};
		return opt;
	}
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
});

//获取url参数
function getUrlOpt(){
	var warehouseId = $('#warehouseId').val();
	var wareId = $('#wareId').val();
	var url = ctx+'/WarehousePosition_json!showJson.do?1=1&warehouseId='+warehouseId+'&wareId='+wareId;
	return url;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:3});
   return opt;		
}	

//获取工具条参数
function getToolBarOpt(){
	var opt = [{
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
	 return opt;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
