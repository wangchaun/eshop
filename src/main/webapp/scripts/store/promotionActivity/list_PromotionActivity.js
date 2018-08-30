var gId = '#dataGrid';
var buyInserts='#buyInserts';
var buyDeletes='#buyDeletes';
var buySelects='#buySelects';
var buyUpdates='#buyUpdates';
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
			{field:'opt',title:'操作',width:25,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' && $(buySelects).val()=='1'){
						operate = '查看';
					}else if(rowData._state != 's' && $(buyUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(buySelects).val()=='1' || $(buyUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData._state != 's' && $(buyDeletes).val()=='1'){
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
		{field:'code',title:'编号',width:20,align:'left'},
		{field:'name',title:'优惠活动主题',width:25,align:'left'},
		{field:'creatorName',title:'创建人',width:25,align:'left'},
		{field:'createTime',title:'创建时间',width:20,align:'left',formatter:beginSaleTimeFormat},
		{field:'type',title:'首页显示位置',width:25,align:'left'}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(buyInserts).val()=='1')
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
	var url = ctx+'/PromotionActivity_json!listJosn.do';
	return url;
}	

//编辑数据
function editData(id){
	var url = ctx+'/promotionActivity!edit.do?1=1';
	var title = '新增优惠活动';
	if(id != ''){
		url += '&promotionActivity.id='+id;
		title = '编辑优惠活动';
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
	queryParams={"promotionActivity.code":code,"promotionActivity.name":name};
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
			  url: ctx+"/promotionActivity!delete.do",
			  data: "promotionActivity.id=" + id,
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


function beginSaleTimeFormat(value,rowData,rowIndex){
	var createTime = rowData.createTime;
	return dateFormat(createTime);
}

//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
