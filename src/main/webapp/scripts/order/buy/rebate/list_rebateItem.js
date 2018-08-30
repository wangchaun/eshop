var gId = '#dataGrid';
$(document).ready(function(){
	$('#rebatesForm').submit(function(){
		submitSaveForm('');
		return false; 
	});
	
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
		    [
		    	{field:'sort',title:'序号',width:10,align:'left'},
				{field:'supplierName',title:'供应商',width:25,align:'left'},
				{field:'saleMoney',title:'期间销售金额',width:25,align:'left',formatter:saleMoneyFormat},
				{field:'rebateRate',title:'返利率',width:15,align:'left',formatter:rebateRateFormat},
				{field:'rebateAmount',title:'应返利',width:15,align:'left',formatter:rebateAmountFormat},
				{field:'actualRebate',title:'实际返利',width:15,align:'left',formatter:actualRebateFormat},
				{field:'modifyTime',title:'审核日期',width:20,align:'left',formatter:modifyTimeFormat},
				{field:'remark',title:'备注',width:25,align:'left'}
			]
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:'数据装载中...',
		onDblClickRow:function(rowIndex,rowData){
			editData(rowData.id);
		},
		toolbar:getToolBarOpt()
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
						if(rowData._state == 's'){
							html = '<a href="javascript:void(0)" onclick="showData(\''+rowData.id+'\');">查看</a>';
						}else{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">审核</a>';
						}
						if('' == todo){
							if(rowData._state != 's'){
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
	//获取工具条参数
   	function getToolBarOpt(){
   		var opt = [];
	    return opt;
   	}
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/RebateItem_json!listJosn.do?1=1';
	var rebateId =$('#id').val();
	if(rebateId != ''){
		url += '&rebateItem.rebateId='+rebateId;
	}
	return url;
}


//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

// 格式化状态
function stateFormat(value,rowData,rowIndex){
	var result = '未审核';
	var state = rowData._state;
	if('s' == state){
		result = '已审核';
	}
	return result;
}
// 格式化金额
function rebateAmountFormat(value,rowData,rowIndex){
	var rebateAmount = rowData.rebateAmount;
	if(rebateAmount){
		rebateAmount = rebateAmount.toFixed(2);
	}
	return rebateAmount;
}

//查看数据
function showData(id){
	var url = ctx+'/rebateItem!show.do?1=1';
	if(id != ''){
		url += '&rebateItem.id='+id;
		title = '查看';
	}
	 //弹出框
	$('#edit').dialog({
		title:"查看返利项",
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
	var url = ctx+'/rebateItem!edit.do?1=1';
	var startTime = $('#startTime').val();
	var endTime = $('#endTime').val();
	if(id != ''){
		url += '&rebateItem.id='+id+'&rebate.startTime='+startTime+'&rebate.endTime='+endTime;
	}
    //弹出框
	$('#edit').dialog({
		title:"供应商",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnAudit',
	        text:'审核',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.auditingForm();
	        }
	    }]
	});
	$('#edit').window('open');
	$('#editDataPage').attr('src',url);
}

//编辑数据
function addData(){
	var url = ctx+'/rebateItem!edit.do?1=1';
	var rebateId = $('#id').val();
	var startTime = $('#startTime').val();
	var endTime = $('#endTime').val();
	if(rebateId != ''){
		url += '&rebateItem.rebateId='+rebateId+'&rebate.startTime='+startTime+'&rebate.endTime='+endTime;
	}
    //弹出框
	$('#edit').dialog({
		title:"供应商",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnAudit',
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.submitForm();
	        }
	    }]
	});
	$('#edit').window('open');
	$('#editDataPage').attr('src',url);
}


//删除返利单
function deleteData(id){
	if(confirm('你确定要删除吗?')){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/rebateItem!delete.do",
			  data: "rebateItem.id=" + id,
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

// 结束日期格式化
function modifyTimeFormat(value,rowData,rowIndex){
	var modifyTime = rowData.modifyTime;
	return dateFormat(modifyTime);
}

// 格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}
				
//期间销售金额
function saleMoneyFormat(value,rowData,rowIndex){
	var saleMoney = rowData.saleMoney;
	if(saleMoney){
		saleMoney = saleMoney.toFixed(2);
	}
	return saleMoney;
}

//应返利
function rebateAmountFormat(value,rowData,rowIndex){
	var rebateAmount = rowData.rebateAmount;
	if(rebateAmount){
		rebateAmount = rebateAmount.toFixed(2);
	}
	return rebateAmount;
}

//实际返利
function actualRebateFormat(value,rowData,rowIndex){
	var actualRebate = rowData.actualRebate;
	if(actualRebate){
		actualRebate = actualRebate.toFixed(2);
	}
	return actualRebate;
}

//返利率
function rebateRateFormat(value,rowData,rowIndex){
	var rebateRate = rowData.rebateRate;
	if(rebateRate){
		rebateRate = rebateRate.toFixed(2);
	}
	return rebateRate;
}

//保存
function submitSaveForm(){
	var id = $('id').val();
	var options = {
		url :ctx+'/rebate!save.do',
		async :false,
		type :'post',
		data : 'rebate.id='+id,
		success:function(returnData){
			if(returnData=='true'){
				alert('审核成功！');
			}else if(returnData=='id'){
				alert('返利子项为空！');
			}else if(returnData=='state'){
				alert('有返利子项没被审核！');
			}else{
				alert('审核失败！');
			}
		},
		error:function(){
			alert('系统错误！');
		}
	};
	$('#rebatesForm').ajaxSubmit(options); 
}

//审核
function auditForm(){
	$('#state').val('s');
	alert("ttttt");
	submitSaveForm();
}




