var gId = '#dataGrid';
var informationInserts='#informationInserts';
var informationDeletes='#informationDeletes';
var informationSelects='#informationSelects';
var informationUpdates='#informationUpdates';
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
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:10,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
//					if(rowData._state == 's' && $(informationSelects).val()=='1'){
//						operate = '查看';
//					}else if(rowData._state != 's' && $(informationUpdates).val()=='1')
//					{
						operate = '编辑';
//					}
					if('' == todo){
						if($(informationSelects).val()=='1' || $(informationUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
//						}
//						if(rowData._state != 's' && $(informationDeletes).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteInformation(\''+rowData.id+'\');">删除</a>';
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
		{field:'title',title:'标题',width:30,align:'left'},
//		{field:'state',title:'数据状态',width:10,align:'left',formatter:stateFormat},
		{field:'creatorName',title:'创建人',width:15,align:'left'},
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
	var type = $('#type').val();
	var opt = [];
	if($(informationInserts).val()=='1')
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

//编辑数据
function editData(id){
	var type = $('#type').val();
	var url = ctx+'/information!edit.do?1=1';
	var title='';

	if(id != ''){
		url += '&information.id='+id;	
		if(type =='0'){
			title = '编辑公告';
		}else
		if(type =='1'){
			title = '编辑新闻';
		}else
		if(type =='2'){
			title = '编辑资讯';
		}else
		if(type =='3'){
			title = '编辑新手上路';
		}else
		if(type =='4'){
			title = '编辑付款方式';
		}else
		if(type =='5'){
			title = '编辑会员服务';
		}else
		if(type =='6'){
			title = '编辑帮助中心';
		}else
		if(type =='7'){
			title = '编辑消费者保障';
		}else
		if(type =='8'){
			title = '编辑下部导航';
		}
		else
		if(type =='9'){
			title = '编辑规则';
		}
	}else{
		if(type =='0'){
			title = '新增公告';
		}else
		if(type =='1'){
			title = '新增新闻';
		}else
		if(type =='2'){
			title = '新增资讯';
		}else
		if(type =='3'){
			title = '新增新手上路';
		}else
		if(type =='4'){
			title = '新增付款方式';
		}else
		if(type =='5'){
			title = '新增会员服务';
		}else
		if(type =='6'){
			title = '新增帮助中心';
		}else
		if(type =='7'){
			title = '新增消费者保障';
		}else
		if(type =='8'){
			title = '新增下部导航';
		}
		else
		if(type =='9'){
			title = '新增规则';
		}
		url += '&information.type='+type;
	}
	window.parent.addTab(title,url);
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/Information_json!listJson.do?1=1';
	var type = $('#type').val();
	if(type != ''){
		url += '&information.type='+type;
	}
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


//搜索功能
function searchData(){

	var code = $("#code").val(); 
	var title = $('#title').val();
	var creatorName = $('#creatorName').val();
    realoadGrid(code,title,creatorName);
}
function cancelSearch(){
	 $("#code").val('');
	 $('#title').val('');
	 $('#creatorName').val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(code,title,creatorName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"information.code":code,"information.title":title,"information.creatorName":creatorName};
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
function deleteInformation(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/information!delete.do",
			  data: "information.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else if(returnData == 'orderGood'){
						alert('该消息已被发布，不能删除，您可以取消该消息发布!');
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