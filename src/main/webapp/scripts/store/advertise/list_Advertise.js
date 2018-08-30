var gId = '#dataGrid';
var marketInserts='#marketInserts';
var marketDeletes='#marketDeletes';
var marketSelects='#marketSelects';
var marketUpdates='#marketUpdates';
var lastIndex;
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
		loadMsg:'数据装载中......',
		onClickRow:function(rowIndex){
			if (lastIndex != rowIndex){
				$(gId).datagrid('endEdit', lastIndex);
				$(gId).datagrid('beginEdit', rowIndex);
			}
			lastIndex = rowIndex;
		},
		toolbar:getToolBarOpt()
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:5});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:10,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' && $(marketSelects).val()=='1'){
						operate = '查看';
					}else if(rowData._state != 's' && $(marketUpdates).val()=='1')
					{
						operate = '编辑';
					}
					if('' == todo){
						if($(marketSelects).val()=='1' || $(marketUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData._state != 's' && $(marketDeletes).val()=='1'){
								html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteAdvertise(\''+rowData.id+'\');">删除</a>';
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
		{field:'code',title:'广告编号',width:20,align:'left'},
		{field:'subject',title:'广告主题',width:30,align:'left'},
		{field:'placeId',title:'显示页面',width:20,align:'left'},
		{field:'creatorName',title:'创建人',width:10,align:'left'},
		{field:'areaName',title:'所属地区',width:40,align:'left'},
		{field:'createTime',title:'创建时间',width:20,align:'left',formatter:beginSaleTimeFormat}
	];
	return opt;
}


//格式化数据状态
function stateFormat(value,rowData,rowIndex){
	var state = rowData._state;
	var result = '';
	if('c'==state){
		result = '未审核';
	}
	if('s'==state){
		result = '已审核';
	}
	return result;
}

//添加工具条
function getToolBarOpt(){
	var opt = '';
	if('' == todo && $(marketInserts).val()=='1'){
		opt =[
			{	
				text:'添加广告',
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
	var url = ctx+'/Advertise_json!listJson.do';
	return url;
}	
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//格式化beginSaleTime
function createTimeFormat(value,rowData,rowIndex){
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


//编辑数据
function editData(id){
	var url = ctx+'/advertise!edit.do';
	var title = '添加广告';
	if(id){
		url += '?advertise.id='+id;
		var title = '编辑广告';
	}
	window.parent.addTab(title,url);
}

//搜索功能
function searchData(){
	var code = $("#code").val(); 
	var subject = $('#subject').val();
	var place = $('#placeId').val(); 
	if(place == '0'){
		var place = '';
	}
    realoadGrid(code,subject,place);
}
function cancelSearch(){
	 $("#code").val('');
	 $('#subject').val('');
	 $('#placeId').val('0');
	 searchData('','','');
}


//确定搜索时重新加载datagrid
function realoadGrid(code,subject,place){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"advertise.code":code,"advertise.subject":subject,"advertise.place":place};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}


//点击行
function clickRow(id,name){ 
	var openObj = window.dialogArguments;
	if('open' == openObj){
		var data = {'id':id ,'name':name};
		window.returnValue = data; 
		window.close(); 		
	}
}


//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//删除数据
function deleteAdvertise(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/advertise!delete.do",
			  data: "advertise.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else if(returnData == 'orderGood'){
						alert('该广告已被发布，不能删除，您可以取消该广告发布!');
					}
				},
				error : function(){
					alert('系统错误!');
			 	} 
		});
	}
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

//选择地区
function selectArea(){
	var area = common.getArea();
	if(area){
		$('#areaId').val(area.id);
		$('#areaName').val(area.name);
	}
}


//选择广告类型
function selectAdvertise(values){
	if(values=='商品父类频道广告'){
		$('#ad').show();
	}else{
		$('#ad').hide();
	}
}