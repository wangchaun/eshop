var gId = '#dataGrid';
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
	
	 //弹出框
	$('#edit').dialog({
		title:"添加或编辑栏位",
		iconCls:'icon-edit',
		closed:true,
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'保存',
	        iconCls:'icon-save',
	        handler:function(){
	            editDataPage.submitForm();
	        }
	    }]
	});
});

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '';
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:25,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					operate = '编辑';
					if('' == todo){
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';							
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
		{field:'columnNo',title:'栏位编号',width:20,align:'left'},
		{field:'name',title:'栏位名称',width:25,align:'left'},
		{field:'describes',title:'栏位描述',width:25,align:'left'},
		{field:'remark',title:'备注',width:25,align:'left'}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Promotecolumn_json!listJosn.do';
	return url;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($("#loginname").val()=='Admin'&&todo=='')
	{
		opt = [{	
			text:'新增',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			editData('');
			}
		}];
	}
	 if('show' == todo){
	    	opt = [{
		        text:'选择',
		        iconCls:'icon-ok',
		        handler:function(){
		        	var rowArrs = $(gId).datagrid('getSelections');
		        	if(rowArrs){
						window.returnValue = rowArrs[0];
	        			window.close(); 		        		
			        }else{
			        	alert('请选择');
			        }
		        }	    	
	    	}];
	    }	
	
    return opt;		
}
//编辑数据
function editData(id){
	var title='';
	var url = ctx+'/promotecolumn!edit.do?1=1';
	if(id != ''){
		url += '&promotecolumn.id='+id;
	}
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
				  type: "POST",
				  async: false,
				  cache: false,
				  url: ctx+"/promotecolumn!delete.do?1=1",
				  data: "promotecolumn.id=" + id,
				  success : function(returnData){ 
						if(returnData == 'true'){
							alert('删除成功!');
							reloadDataGrid();
						}else{
							alert('删除失败!');
						}
					},
					error : function(){
						alert('系统错误!');
				 	} 
			});
	}		
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
	var code = $("#code").val(); 
	var name = $("#name").val();
    realoadGrid(code,name);
}

//清空
function cancelSearch(){
	 $("#code").val('');
	 $("#name").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(code,name){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"promotecolumn.columnNo":code,"promotecolumn.name":name};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
