var gId = '#dataGrid';
var buyInserts='#buyInserts';
var buyDeletes='#buyDeletes';
var buySelects='#buySelects';
var buyUpdates='#buyUpdates';
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
	opt.push({title:'基本信息',colspan:6});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:15,align:'left', rowspan:3,
				formatter:function(value,rowData,rowIndex){
					
					var html = '';	
					html = '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showPic(\''+rowData.id+'\');">图片预览</a>';	
					if(rowData._state == 's' && $(buySelects).val()=='1'){
						operate = '查看';
					}else if(rowData._state != 's' && $(buyUpdates).val()=='1')
					{
						operate = '编辑';
					}
					
					if('' == todo){
						if($(buySelects).val()=='1' || $(buyUpdates).val()=='1')
						{
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData._state != 's' && $(buyDeletes).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deletePackaging(\''+rowData.id+'\');">删除</a>';
						}
						
					}
				
					
					return html;
				}
			}			
		);		
	}
   return opt;		
}

//图片预览
function showPic(id){

	var url = ctx+'/packaging!showPic.do';

	if(id){
		url += '?packaging.id='+id;
	}
    //弹出框
	$('#edit').dialog({
		title:"图片预览",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false
	});
	$('#edit').window('open');
	$('#editDataPage').attr('src',url);
}

function showPic1(obj){

	var picPath = $(obj).val();
	var parent = $(obj).parent();
	//父类的同辈元素
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
	}
	$(parent).append('<img id="pic" border="0" src="'+ctx+picPath+'" width="130px" height="130px"/> &nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>');
}

//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'code',title:'编号',width:10,align:'left'},
		{field:'name',title:'商品包装名称',width:20,align:'left'},
		{field:'packagingFee',title:'包装费用',width:15,align:'left'},
		{field:'minForFree',title:'免费额度',width:15,align:'left'},
		{field:'state',title:'数据状态',width:10,align:'left',formatter:stateFormat},
		{field:'packageDescription',title:'包装描述',width:25,align:'left'}
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
	if('' == todo && $(buyInserts).val()=='1'){
		opt =[
			{	
				text:'添加',
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
	var url = ctx+'/Packaging_json!listJson.do';
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
	var url = ctx+'/packaging!edit.do';
	var title = '添加商品包装';
	if(id){
		url += '?packaging.id='+id;
		var title = '编辑商品包装';
	}
	window.parent.addTab(title,url);
}

//搜索功能
function searchData(){

	var code = $("#code").val(); 
	var name = $('#name').val();
	var creatorName = $('#creatorName').val();
    realoadGrid(code,name,creatorName);
}
function cancelSearch(){
	 $("#code").val('');
	 $('#name').val('');
	 $('#creatorName').val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(code,name,creatorName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"packaging.code":code,"packaging.name":name,"packaging.creatorName":creatorName};
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
function deletePackaging(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/packaging!delete.do",
			  data: "packaging.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else if(returnData == 'orderGood'){
						alert('已被发布，不能删除，您可以取消该发布!');
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