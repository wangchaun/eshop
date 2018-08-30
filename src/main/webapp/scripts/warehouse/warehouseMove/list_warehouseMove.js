var gId = '#dataGrid';
var warehouseInserts='#warehouseInserts';
var warehouseDeletes='#warehouseDeletes';
var warehouseSelects='#warehouseSelects';
var warehouseUpdates='#warehouseUpdates';
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
				getColumnsOpt()
			],
			pageSize:20,
			rownumbers:true,
			pagination:true,
			loadMsg:'数据装载中......',
			onDblClickRow:function(rowIndex,rowData){
				if('' == todo){
					editData(rowData.id);
				}
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
}) ;	
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '';
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:30,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if(rowData._state != 's' && $(warehouseUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if(rowData._state == 's' && $(warehouseSelects).val()=='1'){
						operate = '查看';
					}	
					if('' == todo){
						if($(warehouseUpdates).val()=='1' || $(warehouseSelects).val()=='1')
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
		{field:'code',title:'编号',width:25,align:'left'},
		{field:'fwarehouseName',title:'发货仓库',width:25,align:'left'},
		{field:'swarehouseName',title:'收货仓库',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:20,align:'left'}
	];
	return opt;
}
//获取url参数
function getUrlOpt(){
	var url = ctx+'/WarehouseMove_json!listJson.do?1=1';
	return url;
}

//获取工具条参数
function getToolBarOpt(){
	var opt=[];
	if($(warehouseInserts).val()=='1')
	{
			 opt = [{
		     text:'新增',
		     iconCls:'icon-add',
		     handler:function(){
		         editData();
		     }
		 }]; 
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
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//搜索功能
function searchData(){
	var code = $("#code").val();
	var fwarehouseName = $("#fwarehouseName").val();
	var swarehouseName = $("#swarehouseName").val();
    realoadGrid(code,fwarehouseName,swarehouseName);
}
//取消搜索
function cancelSearch(){
	$("#code").val('');
	$("#fwarehouseName").val('');
	$("#swarehouseName").val('');
	realoadGrid('','','');
}
//确定搜索时重新加载datagrid
function realoadGrid(code,fwarehouseName,swarehouseName){
	var queryParams = $(gId).datagrid('options').queryParams;
	
	queryParams={"warehouseMove.code":code,"warehouseMove.fwarehouseName":fwarehouseName,"warehouseMove.swarehouseName":swarehouseName};
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
//编辑数据
function editData(id){

	var url = ctx+'/warehouseMove!edit.do?1=1';
	var title = '添加调库单' ;
	if(id){
		url += '&warehouseMove.id='+id;
		var title = '编辑调库单';
	}
	window.parent.addTab(title,url);
}

//删除数据
function deleteData(id){
	if (confirm("您确定要删除吗？")){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/warehouseMove!delete.do",
			  data: "warehouseMove.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功！');
						reloadDataGrid();
					}else{
						alert('删除失败！');
					}
				},
				error : function(){
					alert('系统错误，删除失败！');
			 	} 
		});
	}
}
//格式化时间createTime
function createTimeFormat(value,rowData,rowIndex){
	var createTime = rowData.createTime;
	return dateFormat(createTime);
}
//格式化时间modifyTime
function modifyTimeFormat(value,rowData,rowIndex){
	var modifyTime = rowData.modifyTime;
	return dateFormat(modifyTime);
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
    

