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
	opt.push({title:'基本信息',colspan:7});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' && $(customerSelects).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="showData(\''+rowData.id+'\');">查看</a>';
					}else if(rowData._state != 's' && $(customerUpdates).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="auditData(\''+rowData.id+'\');">审核</a>';
					}
					if('' == todo){
						if(rowData._state != 's' && $(customerDeletes).val()=='1'){
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
		{field:'customerName',title:'提现人',width:25,align:'left'},
		{field:'toCashAmount',title:'提现金额',width:25,align:'left',formatter:toCashAmountFormat},
		{field:'createTime',title:'提现申请时间',width:25,align:'left'},
		{field:'bankAccount',title:'银行账号',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'state',title:'状态',width:25,align:'left',formatter:stateFormat},
		{field:'remark',title:'备注',width:25,align:'left'}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(customerInserts).val()=='1')
	{
			opt = [{	
			text:'提现申请',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			editData('');
			}
		}];
	}
    return opt;		
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/ApplyToCash_json!listJosn.do';
	return url;
}	

//查看数据
function showData(id){
	var url = ctx+'/applyToCash!edit.do?1=1';
	if(id != ''){
		url += '&applyToCash.id='+id;
		title = '查看';
	}
	 //弹出框
	$('#edit').dialog({
		title:"提现申请管理",
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

//编辑数据
function editData(id){
	var url = ctx+'/applyToCash!edit.do?1=1';
	if(id != ''){
		url += '&applyToCash.id='+id;
		title = '新增';
	}
	 //弹出框
	$('#edit').dialog({
		title:"新增提现申请",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnSave',
	        text:'提交',
	        iconCls:'icon-save',
	        handler:function(){
	            editDataPage.submitForm();
	        }
	    }]
	});
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//编辑数据
function auditData(id){
	var url = ctx+'/applyToCash!edit.do?1=1';
	if(id != ''){
		url += '&applyToCash.id='+id;
		title = '审核';
	}
	 //弹出框
	$('#edit').dialog({
		title:"审核提现申请",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnAudit',
	        text:'确认',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.auditingForm();
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

//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}

//搜索功能
function searchData(){
	var customerName = $('#customerName').val();
    realoadGrid(customerName);
}

//清空
function cancelSearch(){
	 $('#customerName').val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(customerName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"applyToCash.customerName":customerName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}

//删除
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/applyToCash!delete.do",
		  data: "applyToCash.id=" + id,
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
	var result = '未审核';
	var state = rowData._state;
	if('s' == state){
		result = '已审核';
	}
	return result;
}
//格式化提现金额
function toCashAmountFormat(value,rowData,rowIndex){
	var toCashAmount = rowData.toCashAmount;
	if(toCashAmount){
		toCashAmount = toCashAmount.toFixed(2);
	}
	return toCashAmount;
}
