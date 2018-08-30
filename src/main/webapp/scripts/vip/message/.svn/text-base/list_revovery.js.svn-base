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
		loadMsg:'数据装载中...'
		//toolbar:getToolBarOpt()
	});
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});


//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var operate = '';
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if('' == todo){
						html = '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showRevoveryData(\''+rowData.id+'\');">查看信息</a>';
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
		{field:'creatorName',title:'回复人',width:15,align:'left'},
		{field:'content',title:'回复内容',width:25,align:'left'},
		{field:'createTime',title:'回复时间',width:20,align:'left'}
	];
	return opt;
}

//添加工具条
/*function getToolBarOpt(){
	var opt = [{	
	}];
    return opt;		
}*/

//Json加载数据路径
function getUrlOpt(){
	var messageId = $("#messageId").val();
	var url = ctx+'/Message_json!listJosn.do?message.state=s&message.messageId='+messageId;
	return url;
}	

//查看信息
function showRevoveryData(id){
	var url = ctx+'/message!viewRevoveryEdit.do?1=1';
	if(id != ''){
		url += '&message.id='+id;
		title = '查看';
	}
	 //弹出框
	$('#edit').dialog({
		title:"查看回复信息",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'返回',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.backtrack();
	        }
	    }]
	});
	
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

function backtrack(){
	window.parent.location.reload();
	window.close();
}
