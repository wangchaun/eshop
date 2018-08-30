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
	opt.push({title:'基本信息',colspan:8});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:40,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '';
					if(rowData._state == 's' || rowData._state == 'd'){
						if($(customerSelects).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">查看</a>';
						}
					}else{
						if($(customerUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">启用</a>';
						}			
					}
					if('' == todo){
						if(rowData._state != 's' || rowData._state == 'd'){
							if($(customerDeletes).val()=='1')
							{
								html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
							}
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
		{field:'name',title:'优惠劵名称',width:25,align:'left'},
		{field:'id',title:'优惠劵号',width:35,align:'left'},
		{field:'customerName',title:'使用会员',width:15,align:'left'},
		{field:'money',title:'面值',width:15,align:'left',formatter:moneyFormat},
		{field:'minBuy',title:'最低消费金额',width:15,align:'left',formatter:minBuyFormat},
		{field:'startTime',title:'开始日期',width:20,align:'left',formatter:startTimeFormat},
		{field:'endTime',title:'结束日期',width:20,align:'left',formatter:endTimeFormat},
		{field:'state',title:'状态',width:15,align:'left',formatter:stateFormat}
	];
	return opt;
}

//添加工具条
function getToolBarOpt(){
	var opt=[];
	if($(customerInserts).val()=='1')
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
	var url = ctx+'/VipCoupon_json!listJosn.do';
	return url;
}	

//编辑数据
function editData(id){
	var url = ctx+'/vipCoupon!edit.do?1=1';
	var title = '新增优惠劵';
	if(id != ''){
		url += '&vipCoupon.id='+id;
		title = '编辑优惠劵';
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
	var name = $("#Name").val();
    realoadGrid(code,name);
}

//清空
function cancelSearch(){
	 $("#Code").val('');
	 $("#Name").val('');
	 searchData();
}

//确定搜索时重新加载datagrid
function realoadGrid(code,name){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"vipCoupon.id":code,"vipCoupon.name":name};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}

//删除优惠劵
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/vipCoupon!delete.do",
			  data: "vipCoupon.id=" + id,
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
	var result = '未启用';
	var state = rowData._state;
	if('s' == state){
		result = '启用';
	}if('d' == state){
		result = '已使用';
	}
	return result;
}

//面值
function moneyFormat(value,rowData,rowIndex){
	var money = rowData.money;
	if(money){
		money = money.toFixed(2);
	}
	return money;
}

//开始时间
function startTimeFormat(value,rowData,rowIndex){
	var startTime = rowData.startTime;
	return dateFormat(startTime);
}

//结束时间
function endTimeFormat(value,rowData,rowIndex){
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
//最低购买金额
function minBuyFormat(value,rowData,rowIndex){
	var minBuy = rowData.minBuy;
	if(minBuy){
		minBuy = minBuy.toFixed(2);
	}
	return minBuy;
}
