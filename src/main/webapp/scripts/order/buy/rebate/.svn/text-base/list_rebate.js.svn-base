var gId = '#dataGrid';
var marketInserts='#marketInserts';
var marketDeletes='#marketDeletes';
var marketSelects='#marketSelects';
var marketUpdates='#marketUpdates';
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
	opt.push({title:'基本信息',colspan:6});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' && $(marketSelects).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="showData(\''+rowData.id+'\');">查看</a>';
					}else if(rowData._state != 's' && $(marketUpdates).val()=='1')
					{
						html = '<a href="javascript:void(0)" onclick="auditData(\''+rowData.id+'\');">审核</a>';
						html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">返利子项</a>';
					}
					if('' == todo){
						if(rowData._state != 's' && $(marketDeletes).val()=='1'){
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
		{field:'code',title:'返利编号',width:25,align:'left'},
		{field:'startTime',title:'开始时间',width:20,align:'left',formatter:startStateFormat },
		{field:'endTime',title:'结束时间',width:20,align:'left' ,formatter:endStateFormat},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'state',title:'状态',width:25,align:'left',formatter:stateFormat},
		{field:'remark',title:'备注',width:25,align:'left'}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(marketInserts).val()=='1')
	{
			opt = [{	
			text:'返利单',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addData('');
			}
		}];
	}
    return opt;		
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Rebate_json!listJosn.do';
	return url;
}

//编辑数据
function editData(id){
	var url = ctx+'/rebate!itemEdit.do?1=1';
	var title = '返利项管理';
	if(id != ''){
		url += '&rebate.id='+id;
	}
	window.parent.addTab(title,url);
}	

//查看
function showData(id){
	var url = ctx+'/rebate!itemShow.do?1=1';
	var title = '查看返利单';
	if(id != ''){
		url += '&rebate.id='+id;
	}
	window.parent.addTab(title,url);
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
	var code = $("#Code").val(); 
	var handlerName = $("#handlerName").val();
    realoadGrid(code,handlerName);
}


//清空
function cancelSearch(){
	 $("#Code").val('');
	 $("#handlerName").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(code,handlerName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"rebate.code":code,"rebate.handlerName":handlerName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}


//格式化状态
function stateFormat(value,rowData,rowIndex){
	var result = '未审核';
	var state = rowData._state;
	if('s' == state){
		result = '已审核';
	}
	return result;
}

//开始日期格式化
function startStateFormat(value,rowData,rowIndex){
	var startTime = rowData.startTime;
	return dateFormat(startTime);
}

//结束日期格式化
function endStateFormat(value,rowData,rowIndex){
	var endTime = rowData.endTime;
	return dateFormat(endTime);
}

//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}

//删除返利单
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/rebate!delete.do",
			  data: "rebate.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else {
						alert('删除失败!');
					}
			  },
			  error : function(){
					alert('系统错误!');
			  } 
		});
	}
}

//新增
function addData(id){
	var url = ctx+'/rebate!edit.do?1=1';
    //弹出框
	$('#edit').dialog({
		title:"新增返利单",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnAudit',
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.submitForm();
	        }
	    }]
	});
	$('#edit').window('open');
	$('#editDataPage').attr('src',url);
}

//审核
function auditData(id){
	var url = ctx+'/rebate!edit.do?1=1';
	if(id != ''){
		url += '&rebate.id='+id;
	}
    //弹出框
	$('#edit').dialog({
		title:"审核返利单",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnAudit',
	        text:'审核',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.auditForm();
	        }
	    }]
	});
	$('#edit').window('open');
	$('#editDataPage').attr('src',url);
}




