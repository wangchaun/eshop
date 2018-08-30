
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
		}
		return opt;
	}
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
   	
    //弹出框
	$('#edit').dialog({
		title:"仓位",
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
	            $('#editDataPage')[0].contentWindow.submitForm('save');
	        }
	    }]
	});
});

//获取url参数
function getUrlOpt(){
	var warehouseId = $('#warehouseId').val();
	var url = ctx+'/WarehousePosition_json!listJson.do?1=1&warehousePosition.warehouseId='+warehouseId;
	
	return url;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:3});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:30,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if('' == todo){
						if($(warehouseSelects).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="listWarehousePositionWare(\''+rowData.id+'\',\''+rowData.name+'\');">查看仓位货品</a>';
						}
						if($(warehouseUpdates).val()=='1')
						{
							html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						}
						if($(warehouseDeletes).val()=='1')
						{
							html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
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
	if($(warehouseInserts).val()=='1')
	{
			opt = [{
		     text:'新增',
		     iconCls:'icon-add',
		     handler:function(){
		         editData('');
		     }
		 }];
	 } 
	if(todo == 'show'){
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
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//关闭弹出窗
function closePopWindow(){
	$('#edit').window('close');
}

//编辑数据
function editData(id){
	var url = ctx+'/warehousePosition!edit.do?1=1';
	if(id){
		url += '&warehousePosition.id='+id;
	}else{
		var warehouseId = $('#warehouseId').val();
		url += '&warehouseId='+warehouseId;
	}
	
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

//删除数据
function deleteData(id){
	if (confirm("您确定要删除吗？")){
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/warehousePosition!delete.do",
		  data: "warehousePosition.id=" + id,
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
function listWarehousePositionWare(id,name){
	var url = ctx+'/warehousePositionWare!list.do?1=1';
	if(id){
		url += '&warehousePositionWare.warehousePositionId='+id;
	}
	var title = name +"货品"
	 //弹出框
	$('#list').dialog({
		title:title,
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[]
	});
    $('#list').window('open');
    $('#listDataPage').attr('src',url);
}
