var gId = '#dataGrid';
var baseinfoInserts='#baseinfoInserts';
var baseinfoDeletes='#baseinfoDeletes';
var baseinfoSelects='#baseinfoSelects';
var baseinfoUpdates='#baseinfoUpdates';
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
					{field:'code',title:'字典编号',width:130,align:'left'},
					{field:'name',title:'字典目录名称',width:100,align:'left'},
					{field:'_state',title:'数据状态',width:100,align:'left',formatter:stateFormat},
					{field:'sort',title:'序号',width:50,align:'left'}
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
					selectOrg(rowData.id,rowData.name);
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
		title:"数据字典",
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
	 //弹出框
	$('#list').dialog({
		title:"数据字典子项",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[]
	});
});

//获取url参数
function getUrlOpt(){
	var url = ctx+'/Dictionary_json!listJson.do?1=1';
	
	return url;
}	
//格式化数据状态
function stateFormat(value,rowData,rowIndex){
	var state = rowData._state;
	var result = '';
	if('c'==state){
		result = '草稿';
	}
	return result;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo){
						if($(baseinfoUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						}
						if($(baseinfoSelects).val()=='1')
						{
							html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="listDictionaryItem(\''+rowData.id+'\');">查看</a>';
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
	if($(baseinfoInserts).val()=='1' && $(baseinfoDeletes).val()=='1')
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
	  if($(baseinfoInserts).val()=='1' && $(baseinfoDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(baseinfoDeletes).val()=='1' && $(baseinfoInserts).val()!='1')
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
	
	queryParams={"dictionary.code":code,"dictionary.name":name};
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
function selectOrg(id,name){
	if(todo == 'show'){
		window.returnValue = {'id':id,'name':name};
		window.close();
	}
}

//编辑数据
function editData(id){
	var url = ctx+'/Dictionary!edit.do?1=1';
	if(id){
		url += '&dictionary.id='+id;
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
			  url: ctx+"/Dictionary!delete.do",
			  data: "dictionary.id=" + id,
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
function listDictionaryItem(id){
	var url = ctx+'/DictionaryItem!list.do?1=1';
	if(id){
		url += '&dictionaryItem.dictionaryId='+id;
	}
    $('#list').window('open');
    $('#listDataPage').attr('src',url);
}