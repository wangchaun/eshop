var gId = '#dataGrid';
var receiptPayInserts='#receiptPayInserts';
var receiptPayDeletes='#receiptPayDeletes';
var receiptPaySelects='#receiptPaySelects';
var receiptPayUpdates='#receiptPayUpdates';
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
					if(rowData._state == 's' && $(receiptPaySelects).val()=='1'){
						operate = '查看';
					}else if(rowData._state != 's' && $(receiptPayUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(receiptPaySelects).val()=='1' || $(receiptPayUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData._state != 's' && $(receiptPayDeletes).val()=='1'){
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
		{field:'code',title:'单据编号',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'moneyAccount',title:'总金额',width:25,align:'left',formatter:moneyAccountFormat},
		{field:'customerName',title:'往来单位',width:25,align:'left'},
		{field:'state',title:'费用单状态',width:25,align:'left',formatter:stateFormat},
		{field:'remark',title:'备注',width:25,align:'left'}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(receiptPayInserts).val()=='1')
	{
			opt = [{	
			text:'新增',
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
	var url = ctx+'/Fee_json!listJosn.do';
	return url;
}	

//编辑数据
function editData(id){
	var url = ctx+'/fee!edit.do?1=1';
	var title = '新增费用清单';
	if(id != ''){
		url += '&fee.id='+id;
		title = '编辑费用清单';
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
	var Code = $("#Code").val(); 
	var customerName = $("#customerName").val();
    realoadGrid(Code,customerName);
}

//清空
function cancelSearch(){
	 $("#Code").val('');
	 $("#customerName").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(Code,customerName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"fee.code":Code,"fee.customerName":customerName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}

//删除订单
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/fee!delete.do",
			  data: "fee.id=" + id,
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
//格式化送货状态
function stateFormat(value,rowData,rowIndex){
	var result = '未审核';
	var state = rowData._state;
	if('s' == state){
		result = '已审核';
	}
	return result;
}
function moneyAccountFormat(value,rowData,rowIndex){
	var moneyAccount = rowData.moneyAccount;
	if(moneyAccount){
		moneyAccount = moneyAccount.toFixed(2);
	}
	return moneyAccount;
}
