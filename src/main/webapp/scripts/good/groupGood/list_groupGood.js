var gId = '#dataGrid';
var goodInserts='#goodInserts';
var goodDeletes='#goodDeletes';
var goodSelects='#goodSelects';
var goodUpdates='#goodUpdates';
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
	//弹出框
	$('#edit').dialog({
		title:"文件上传",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false
	});
});
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:8});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:20,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if('' == todo){
						if($(goodUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						}	
						if('s'==rowData._state && $(goodUpdates).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="updateState(\''+rowData.id+'\',\'c\');">下架</a>';
						}else if('c'==rowData._state && $(goodUpdates).val()=='1'){
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="updateState(\''+rowData.id+'\',\'s\');">上架</a>';
						}
						if($(goodDeletes).val()=='1')
						{
							html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteGood(\''+rowData.id+'\');">删除</a>';
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
		{field:'code',title:'编号',width:15,align:'left'},
		{field:'name',title:'品名',width:40,align:'left'},
		{field:'goodTypeName',title:'类别',width:15,align:'left'},
		{field:'brandName',title:'品牌',width:15,align:'left'},
		{field:'price',title:'价格',width:15,align:'left'},
		{field:'priceMarket',title:'市场价',width:15,align:'left'},
		{field:'dailyNetSales',title:'日均销量(DNS)',width:15,align:'left'},
		{field:'beginSaleTime',title:'上架时间',width:15,align:'left',formatter:beginSaleTimeFormat}
	];
	return opt;
}
//添加工具条
function getToolBarOpt(){
	var opt = '';
	if('' == todo && $(goodInserts).val()=='1'){
		opt =[
			{	
				text:'添加商品',
			    iconCls:'icon-add',
			    handler:function(){
					editData('');
			 	}
			},'-',{
		     text:'删除',
		     iconCls:'icon-remove',
		     handler:function(){
		        deleteGood();
		     }
		 },
			{	
				text:'Excel数据导入',
			    iconCls:'icon-add',
			    handler:function(){
					getExcelPath();
			 	}
			}];
	}
	 
	 if('show' == todo){
	 	opt = [{
	      text:'选择',
	      iconCls:'icon-ok',
	      handler:function(){
	      	var rowArr = $(gId).datagrid('getSelections');
	      	if(rowArr && rowArr.length){
     			window.returnValue = rowArr;
     			window.close();
	        }else{
	       		alert('请选择');
	        }
	      }	    	
	 	}];		
	 }
   return opt;		
}

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/GroupGood_json!listJson.do?1=1';
	var isInventory=$('#isInventory').val(); 
//	if(isInventory!=''||isInventory!=null){
//		url+='&groupgood.isInventory='+isInventory;
//	}
	var state=$('#state').val();
	if(state!=null||state!=""){
		url+='&groupgood.state='+state;
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
function beginSaleTimeFormat(value,rowData,rowIndex){
	var beginSaleTime = rowData.beginSaleTime;
	return dateFormat(beginSaleTime);
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
	var url = ctx+'/groupGood!edit.do?1=1';
	var isInventory=$('#isInventory').val(); 
	var title = '添加商品';
	if(id){
		url += '&groupgood.id='+id;
		var title = '编辑商品';
	}
	if(isInventory!=''||isInventory!=null){
		url+='&groupgood.isInventory='+isInventory;
	}
	window.parent.addTab(title,url);
}

//搜索功能
function searchData(){

	var goodCode = $("#goodCode").val(); 
	var goodName = $('#goodName').val();
	var goodTypeName = $('#goodTypeName').val();
    realoadGrid(goodCode,goodName,goodTypeName);
}
function cancelSearch(){
	 $("#goodCode").val('');
	 $('#goodName').val('');
	 $('#goodTypeName').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(goodCode,goodName,goodTypeName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"good.code":goodCode,"good.name":goodName,"good.goodTypeName":goodTypeName};
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
function deleteGood(id){
	if(confirm('你确定要删除吗?')){
	var ids = [];
	var rows = $(gId).datagrid('getSelections');
	if(rows &&  rows.length>0){
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		var id = ids.join(',');
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/groupGood!delete.do",
			  data: "groupgood.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else if(returnData == 'orderGood'){
						alert('该商品已被订购，不能删除，您可以下架该商品!');
					}
				},
				error : function(){
					alert('系统错误!');
			 	} 
		});
	  }
	}
}
//冻结、激活商品
function updateState(id,state){
	var optInfo = '';
	var succInfo = '';
	var errorInfo = '';
	
	if('c'==state){
		optInfo = '你要下架这个商品吗?';
		succInfo = '商品已下架';
		errorInfo = '商品下架失败';
	}else if('s'==state){
		optInfo = '你要上架这个商品吗?';
		succInfo = '商品已上架';
		errorInfo = '商品上架失败';
	}
	if(confirm(optInfo)){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/groupGood!updateState.do",
			  data: "groupgood.id=" + id +'&groupgood.state='+state,
			  success : function(returnData){
					if(returnData == 'true'){
						alert(succInfo);
						reloadDataGrid();
					}else{
						alert(errorInfo);
					}
				},
				error : function(){
					alert('系统错误');
			 	} 
		});
	}
}
//选择商品类别弹出窗
function selectType(obj){
	var obj = $(obj);
	var dataArr = window.showModalDialog(ctx+"/goodType!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		$(obj).val(dataArr.typeName);
		$(obj).focus();
	}
}
function getExcelPath(){
	var url = ctx+'/good!editExcelDate.do';
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}
