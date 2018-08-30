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
				[
					{field:'code',title:'编号',width:80,align:'left'},
					{field:'name',title:'仓库名称',width:80,align:'left'},
					{field:'areaName',title:'地区',width:80,align:'left'},
					{field:'totalCostInventory',title:'库存成本',width:40,align:'left',formatter:totalCostInventoryFormat},
					{field:'remark',title:'备注',width:80,align:'left'}
//					{field:'sort',title:'序号',width:50,align:'left'}
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
   	
    //弹出框
	$('#edit').dialog({
		title:"仓库",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'保存',
	        iconCls:'icon-save',
	        handler:function(){
	           editDataPage.contentWindow.submitForm();
	        }
	    }]
	});
});

//获取url参数
function getUrlOpt(){
	var url = ctx+'/Warehouse_json!listJson.do';
	
	return url;
}

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:5});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:60,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo){
						if($(warehouseUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						}
						if($(warehouseSelects).val()=='1')
						{
							html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="listWarehousePosition(\''+rowData.id+'\',\''+rowData.name+'\');">查看仓位</a>';
						}
					}
					return html;
				}
			}			
		);		
	}

   return opt;		
}	

//获取工具条参数
function getToolBarOpt(){
	var opt=[];
	if($(warehouseInserts).val()=='1' && $(warehouseDeletes).val()=='1')
	{
			 opt = [{
		     text:'新增',
		     iconCls:'icon-add',
		     handler:function(){
		         editData();
		     }
		 },'-',{
		     text:'删除',
		     iconCls:'icon-remove',
		     handler:function(){
		        deleteData();
		     }
		 }];
	 }
	  if($(warehouseInserts).val()=='1' && $(warehouseDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(warehouseDeletes).val()=='1' && $(warehouseInserts).val()!='1')
	 {
	 	opt=[{
		     text:'删除',
		     iconCls:'icon-remove',
		     handler:function(){
		        deleteData();
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
//格式化金额显示方式
function totalCostInventoryFormat(value,rowData,rowIndex){
	var totalCostInventory = rowData.totalCostInventory;
	if(totalCostInventory){
		totalCostInventory = totalCostInventory.toFixed(2);
	}
	return totalCostInventory;
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
	var name = $("#name").val();
    realoadGrid(code,name);
}
//取消搜索
function cancelSearch(){
	$("#code").val('');
	$("#name").val('');
	realoadGrid('','');
}
//确定搜索时重新加载datagrid
function realoadGrid(code,name){
	var queryParams = $(gId).datagrid('options').queryParams;
	
	queryParams={"warehouse.code":code,"warehouse.name":name};
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
	var url = ctx+'/warehouse!edit.do?1=1';
	if(id){
		url += '&warehouse.id='+id;
	}
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

//删除数据
function deleteData(id){
	if (!confirm("您确定要删除吗？")){
		return;
	}
	var ids = [];
	var rows = $(gId).datagrid('getSelections');
	if(rows &&  rows.length>0){
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		var id = ids.join(',');
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/warehouse!delete.do",
			  data: "warehouse.id=" + id,
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
function listWarehousePosition(id,name){
	var url = ctx+'/warehousePosition!list.do?1=1';
	if(id){
		url += '&warehousePosition.warehouseId='+id;
	}
	var title = name +"仓位"
	window.parent.addTab(title,url);
    
}