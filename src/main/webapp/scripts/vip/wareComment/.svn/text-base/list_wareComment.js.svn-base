var gId = '#dataGrid';
var customerInserts='#customerInserts';
var customerDeletes='#customerDeletes';
var customerSelects='#customerSelects';
var customerUpdates='#customerUpdates';
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
});


//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '';
	opt.push({title:'基本信息',colspan:5});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if('' == todo && $(customerSelects).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="showData(\''+rowData.id+'\');">查看评论</a>';
						if($(customerDeletes).val()=='1')
						{
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
		{field:'wareId',width:0,align:'left'},
		{field:'goodName',title:'评论商品',width:25,align:'left'},
		{field:'content',title:'评论内容',width:25,align:'left'},
		{field:'createTime',title:'评论时间',width:25,align:'left'},
		{field:'level',title:'评论等级',width:25,align:'left',formatter:stateFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt = [{	
 		handler:function(){
 			editData('');
		}
	}];
    return opt;		
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/WareComment_json!listJosn.do';
	return url;
}	

//编辑数据
function editData(id){
	var url = ctx+'/wareComment!edit.do?1=1';
	if(id != ''){
		url += '&wareComment.id='+id;
		title = '编辑';
	}
	 //弹出框
	$('#edit').dialog({
		title:"咨询管理",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnSave',
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.submitForm();
	        }
	    }]
	});
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//查看评论
function showData(id){
	var url = ctx+'/wareComment!showWareComment.do?1=1';
	if(id != ''){
		url += '&wareComment.id='+id;
	}
	 //弹出框
	$('#edit').dialog({
		title:"查看评论信息",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[
	        {   text:'返回',
		        iconCls:'icon-ok',
		        handler:function(){
		            $('#editDataPage')[0].contentWindow.backtrack();
	            }
	        },
	        {
		    	id:'btnAudit',
		    	text:'审核',
		    	iconCls:'icon-ok',
		    	handler:function(){
	    		$('#editDataPage')[0].contentWindow.submitForm(true);
	    	    }
	        }
	 ]
	});
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
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
	var id = $("#id").val();
    realoadGrid(id);
}

//清空
function cancelSearch(){
	 $("#id").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(id){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"message.creatorName":creatorName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}

//删除留言
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/wareComment!delete.do",
		  data: "wareComment.id=" + id,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功!');
					reloadDataGrid();
				}else {
					alert('删除失败!');
				}
			},
		  error: function(){
				alert('系统错误!');
		  } 
	});
	}
}
//格式化评价状态
function stateFormat(value,rowData,rowIndex){
	var result = '';
	var replyState = rowData.level;
	if('1' == replyState){
		result = '很差';
	}else if('2' == replyState){
		result = '不满意';
	}else if('3' == replyState){
		result = '一般';
	}else if('4' == replyState){
		result = '满意';
	}else if('5' == replyState){
		result = '非常满意';
	}
	return result;
}

