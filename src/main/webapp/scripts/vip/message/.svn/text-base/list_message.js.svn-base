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
	opt.push({title:'基本信息',colspan:8});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if('' == todo && $(customerSelects).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="showData(\''+rowData.id+'\',\''+(rowData.goodId)+'\');">查看咨询</a>';
						if(rowData.replyState != '1' && $(customerUpdates).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="revoveryData(\''+rowData.id+'\',\''+(rowData.goodId)+'\');">回复</a>';
						}
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
		{field:'goodId',align:'left',hidden:'true'},
		{field:'goodName',title:'咨询商品',width:25,align:'left'},
		{field:'goodCode',title:'商品编号',width:25,align:'left'},
		{field:'creatorName',title:'咨询人',width:25,align:'left'},
		{field:'content',title:'咨询内容',width:25,align:'left'},
		{field:'type',title:'咨询类型',width:20,align:'left',formatter:typeFormat},
		{field:'createTime',title:'咨询时间',width:25,align:'left'},
		{field:'replyState',title:'状态',width:25,align:'left',formatter:stateFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){

	var opt=[];
	if($(customerInserts).val()=='1')
	{
			opt = [{	
			text:'',
	 		//iconCls:'icon-add',
	 		handler:function(){
	 			//editData('');
			}
		}];
	}
    return opt;		
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Message_json!listJosn.do?message.state=c';
	return url;
}	



//编辑数据
function editData(id){
	var url = ctx+'/message!edit.do?1=1';
	if(id != ''){
		url += '&message.id='+id;
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
	           $('#editDataPage')[0].contentWindow.submitForm(true);
	        }
	    }]
	});
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//查看留言
function showData(id,goodId){
	var url = ctx+'/message!showMessage.do?1=1';
	if(id != ''){
		url += '&message.id='+id;
	}
	if(goodId != ''){
		url += '&message.goodId='+goodId;
	}
	 //弹出框
	$('#edit').dialog({
		title:"查看咨询信息",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true, 
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{text:'返回',
	        iconCls:'icon-ok',
	        handler:function(){
	            $('#editDataPage')[0].contentWindow.backtrack();
	        }
	    }]
	});
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//回复留言
function revoveryData(id,goodId){
	var url = ctx+'/message!revoveryEdit.do?1=1';
	if(id != ''){
		url += '&message.id='+id;
	}
	if(goodId != ''){
		url += '&message.goodId='+goodId;
	}
	 //弹出框
	$('#revovery').dialog({
		title:"回复咨询",
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
	        $('#revoveryDataPage')[0].contentWindow.submitForm(true);
	        }
	    }]
	});
	$('#revoveryDataPage').attr('src',url);
    $('#revovery').window('open');
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
	var creatorName = $("#creatorName").val();
    realoadGrid(creatorName);
}

//清空
function cancelSearch(){
	 $("#creatorName").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(creatorName){
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
		  url: ctx+"/message!delete.do",
		  data: "message.id=" + id,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功!');
					$('#totalMoney').val('');
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
//格式化送货状态
function stateFormat(value,rowData,rowIndex){
	var result = '未回复';
	var replyState = rowData.replyState;
	if('1' == replyState){
		result = '已回复';
	}
	return result;
}

function typeFormat(value,rowData,rowIndex){
	var result = '';
	var type = rowData.type;  
	if('0' == type){
		result = '商品咨询';
	}else if('1' == type){
		result = '配送/支付';
	}else if('2' == type){
		result = '发票/安装保修';
	}
	return result;
}














