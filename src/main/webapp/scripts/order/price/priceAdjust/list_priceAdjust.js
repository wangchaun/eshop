var gId = '#dataGrid';
var orderInserts='#orderInserts';
var orderDeletes='#orderDeletes';
var orderSelects='#orderSelects';
var orderUpdates='#orderUpdates';
var endTimeWidth = 0;
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
			{field:'opt',title:'操作',width:20,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if(rowData.adjustState == 1 && $(orderSelects).val()=='1'){
						operate = '查看';
					}else if(rowData.adjustState != 1 && $(orderUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(orderSelects).val()=='1' || $(orderUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData.adjustState != 1 && $(orderDeletes).val()=='1'){
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
	var type = $('#type').val();
	if(type == '1'){
		endTimeWidth = 20;
	}
	var opt = [
		{field:'code',title:'订单编号',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'startTime',title:'开始时间',width:20,align:'left',formatter:dateFormat},
		{field:'endTime',title:'结束时间',width:endTimeWidth,align:'left',formatter:dateFormat},
		{field:'adjustState',title:'调整状态',width:20,align:'left',formatter:stateFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(orderInserts).val()=='1')
	{
		 opt = [
			 {	
				text:'新增',
		 		iconCls:'icon-add',
		 		handler:function(){
		 			editData('');
	 			}
			}
		];
	}
    return opt;		
}

//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
//格式化订单状态
function stateFormat(value,rowData,rowIndex){
	var result = '待确认';
	var adjustState = rowData.adjustState;
	if('1' == adjustState){
		result = '已确认';
	}
	return result;
}
//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/PriceAdjust_json!listJson.do?1=1';
	var type = $('#type').val();
	if(type != ''){
		url += '&priceAdjust.type='+type;
	}
	return url;
}	
//编辑数据
function editData(id){
	var url = ctx+'/priceAdjust!edit.do?1=1';
	var title = '';
	var type = $('#type').val();
	if(id != ''){
		url += '&priceAdjust.id='+id;
		if(type == '0'){
			title = '编辑普通调价单';
		}else if(type == '1'){
			title = '编辑促销调价单';
		}else if(type == '2'){
			title = '编辑采购调价单';
		}
	}else{
		if(type == '0'){
			title = '新增普通调价单';
		}else if(type == '1'){
			title = '新增促销调价单';
		}else if(type == '2'){
			title = '新增采购调价单';
		}
		url += '&priceAdjust.type='+type;
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
	var orderCode = $("#orderCode").val(); 
    realoadGrid(orderCode);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"priceAdjust.code":orderCode};
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
			  url: ctx+"/priceAdjust!delete.do",
			  data: "priceAdjust.id=" + id,
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
