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
					{field:'wareCode',title:'货物编号',width:80,align:'left'},
					{field:'wareName',title:'货物名称',width:80,align:'left'},
					{field:'wareSpecificationVal',title:'货物规格',width:80,align:'left'},
					{field:'warehouseName',title:'仓库名称',width:80,align:'left'},
					{field:'wareCount',title:'货物数量',width:50,align:'left'},
					{field:'sort',title:'序号',width:50,align:'left'}
				]
			],
			pageSize:20,
			rownumbers:true,
			pagination:true,
			onDblClickRow:function(rowIndex,rowData){
				if('show' == todo){
					selectKind(rowData.id,rowData.name);
				}
			},
		    toolbar:getToolBarOpt()
		}
		return opt;
	}
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
  
});

//获取url参数
function getUrlOpt(){
	var id = $('#warehousePositionId').val();
	var url = ctx+'/WarehousePositionWare_json!listJson.do?1=1';
	if(id){
		url += '&warehousePositionWare.warehousePositionId='+id;
	}
	return url;
}

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:6});
   return opt;		
}	

//获取工具条参数
function getToolBarOpt(){
	var opt = [];
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
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//搜索功能
function searchData(){

	var wareCode = $("#wareCode").val();
	var warehouseName = $("#warehouseName").val();
	var wareName = $("#wareName").val();
    realoadGrid(wareCode,warehouseName,wareName);
}
//取消搜索
function cancelSearch(){
	$("#wareCode").val('');
	$("#warehouseName").val('');
	$("#wareName").val('');
	realoadGrid('','','');
}
//确定搜索时重新加载datagrid
function realoadGrid(wareCode,warehouseName,wareName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"warehouseWare.wareCode":wareCode,"warehouseWare.warehouseName":warehouseName,"warehouseWare.wareName":wareName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//关闭弹出窗
function closePopWindow(){
	$('#edit').window('close');
}

//选择
function selectKind(id,name){
	window.returnValue = {'id':id,'name':name};
	window.close();
}
