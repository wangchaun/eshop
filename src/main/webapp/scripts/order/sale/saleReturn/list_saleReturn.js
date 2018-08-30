var gId = '#dataGrid';
var orderInserts='#orderInserts';
var orderDeletes='#orderDeletes';
var orderSelects='#orderSelects';
var orderUpdates='#orderUpdates';
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
	var operate = '编辑';
	opt.push({title:'基本信息',colspan:7});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:20,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if(rowData.returnState == 1 && $(orderSelects).val()=='1'){
						operate = '查看';
					}
					if(rowData._state=='c'){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">审核</a>';
					}else{
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
					}
					if('' == todo){
						if(rowData.returnState == 1 && $(orderSelects).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">'+operate+'</a>';
						}
						if(rowData.returnState != 1 && $(orderDeletes).val()=='1'){
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
		{field:'code',title:'订单编号',width:25,align:'left'},
		{field:'customerName',title:'客户名称',width:25,align:'left'},
		{field:'handlerName',title:'经手人',width:25,align:'left'},
		{field:'moneyAccount',title:'总金额',width:25,align:'left',formatter:moneyFormat},
		{field:'linkman',title:'联系人',width:25,align:'left'},
		{field:'deliveryName',title:'退货时间',width:25,align:'left',formatter:returnState},
		{field:'returnState',title:'退货状态',width:20,align:'left',formatter:returnStateFormat}
		
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
				}];
	}
    return opt;		
}

//格式化金额显示方式
function moneyFormat(value,rowData,rowIndex){
	var moneyAccount = rowData.moneyAccount;
	if(moneyAccount){
		moneyAccount = moneyAccount.toFixed(2);
	}
	return moneyAccount;
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
//格式化退货时间
function returnState(value,rowData,rowIndex){
 var result="";
 var returnState=rowData.returnState;
 if(returnState==='1'){
   result="还未退货";
 }else{
   result=rowData.modifyTime; 
 }
 return result;
}
//格式化送货状态
function returnStateFormat(value,rowData,rowIndex){
	var result = '未退货';
	var returnState = rowData.returnState;
	if('2' == returnState){
		result = "<font color='red'>已退货</font>";
	}
	return result;
}
//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/SaleReturn_json!listJson.do';
	return url;
}	
//编辑数据
function editData(id){
	var url = ctx+'/saleReturn!edit.do?temp=1';
	var title = '编辑销售退货单';
	if(id != ''){
		url += '&saleReturn.id='+id;
		title = '编辑销售退货单';
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
	var customerName = $('#customerName').val();
	var remark = $('#remark').val();
    realoadGrid(orderCode,customerName,remark);
}
function cancelSearch(){
	 $("#orderCode").val('');
	 $('#customerName').val('');
	 $('#remark').val('');
	 searchData();
}
//确定搜索时重新加载datagrid
function realoadGrid(orderCode,customerName,remark){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"saleReturn.code":orderCode,"saleReturn.customerName":customerName,"saleReturn.remark":remark};
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
			  url: ctx+"/saleReturn!delete.do",
			  data: "saleReturn.id=" + id,
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