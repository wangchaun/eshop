var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标
$(document).ready(function(){
	$('#orderForm').submit(function(){
		submitSaveForm('');
		return false; 
	});
	//列表
	$(gId).datagrid({
		idField:'id',
		url:getUrlOpt(),
		fitColumns:true,
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
			getColumnsOpt()
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:getLoadMsg(),
		toolbar:getToolBarOpt(),
		onClickRow:function(rowIndex){
			if(!currentSelectRowIndex){
				currentSelectRowIndex = rowIndex;
				lastEditRowIndex = rowIndex;
				$(gId).datagrid('beginEdit', rowIndex);
			}else{
				lastEditRowIndex = currentSelectRowIndex;
				currentSelectRowIndex = rowIndex;
				if (lastEditRowIndex != rowIndex){
					$(gId).datagrid('endEdit', lastEditRowIndex);
					$(gId).datagrid('beginEdit', rowIndex);
				}
			}
		},
		//行编辑前的响应事件
		onBeforeEdit:function(rowIndex, rowData){
			//alert('开始编辑：'+rowData.goodsCode)
			rowData.isEditing = true;//标示该行正在编辑
		},
		//行编辑完成后的响应事件
		onAfterEdit:function(rowIndex, rowData, changes){
			//alert('结束编辑：'+rowData.goodsCode)
			rowData.isEditing = false;
		}
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});
//工具条
function getToolBarOpt(){
	var opt = [];
	var orderId = $('#orderId').val();
	if(orderId == ''){
		opt = [
				{	
					text:'添加订单数据',
			 		iconCls:'icon-add',
			 		handler:function(){
			 			addCollectionItem(true);
		 			}
				},'-',{
					text:'删除',
					iconCls:'icon-cancel',
					handler:function(){
						var row = $(gId).datagrid('getSelected');
						if (row){
							if(row.length <= 0){
								alert('请选择');
							}else if(row.length > 1){
								alert('一次只能删除一个');
							}else{
								var index = $(gId).datagrid('getRowIndex', row);
								$(gId).datagrid('deleteRow', index);
								calTotalMoney();
								$('#customerId').val('');
								$('#customerName').val('');
							}
						}
						flushMoney();
					}
				}
				];
	}
    return opt;	
}

//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'orderId',width:0,align:'left'},
		{field:'code',title:'单据号',width:20,align:'left'},
		{field:'moneyAccount',title:'单据金额',width:20,align:'left',formatter:moneyAccountFormat},
		{field:'moneyAlreadyReceived',title:'已收金额',width:20,align:'left',formatter:moneyAlreadyReceivedFormat},
		{field:'moneyCurrentReceived',title:'本次收款金额',width:20,align:'left',formatter:moneyCurrentReceivedFormat,editor:{type:'moneyCurrentReceived',options:{precision:'2'}}},
		{field:'remark',title:'备注',width:50,editor:'remark'}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var orderId = $('#orderId').val();
	var url = '';
	if(id != ''){
		url += ctx+'/SaleCollectionItem_json!listJson.do?saleCollectionItem.collectionId='+id;
	}else if(orderId != ''){
		url += ctx+'/SaleCollectionItem_json!listJson.do?saleDelivery.id='+orderId;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//格式化总金额
function moneyAccountFormat(rowIndex,rowData,value){
	var moneyAccount = rowData.moneyAccount;
	if(moneyAccount){
		moneyAccount = moneyAccount.toFixed(2);
	}
	return moneyAccount;
}
//格式化已收金额
function moneyAlreadyReceivedFormat(rowIndex,rowData,value){
	var moneyAlreadyReceived = rowData.moneyAlreadyReceived;
	if(!moneyAlreadyReceived || moneyAlreadyReceived == null){
		moneyAlreadyReceived = 0;
	}
	moneyAlreadyReceived = moneyAlreadyReceived.toFixed(2);
	return moneyAlreadyReceived;
}
//格式化本次收取金额
function moneyCurrentReceivedFormat(rowIndex,rowData,value){
	var moneyCurrentReceived = rowData.moneyCurrentReceived;
	if(moneyCurrentReceived){
		moneyCurrentReceived = moneyCurrentReceived.toFixed(2);
	}
	return moneyCurrentReceived;
}
//提交orderForm表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
		var collectionItemArr = $(gId).datagrid('getData').rows;//获取json数据集合
		if(collectionItemArr){
			var htmlAll = '';
			var length = collectionItemArr.length;
			for(var i=0;i<length;i++){
				var collectionItem = collectionItemArr[i];
				var orderId = collectionItem.orderId;
				if(orderId && '' != orderId){
					var orderIdHtml = '<input type="hidden" name="orderIdArr" value="'+orderId+'" />'; 						
					var moneyAccountHtml = '<input type="hidden" name="moneyAccountArr" value="'+collectionItem.moneyAccount+'" />'; 				
					var moneyAlreadyReceivedHtml = '<input type="hidden" name="moneyAlreadyReceivedArr" value="'+collectionItem.moneyAlreadyReceived+'" />'; 					
					var moneyCurrentReceivedHtml = '<input type="hidden" name="moneyCurrentReceivedArr" value="'+collectionItem.moneyCurrentReceived+'" />'; 						
					var remarkHtml = '<input type="hidden" name="remarkArr" value="'+collectionItem.remark+'" />';	

					htmlAll += '<tr>'+ orderIdHtml + moneyAccountHtml + moneyAlreadyReceivedHtml + moneyCurrentReceivedHtml + remarkHtml + '</tr>'; 
				}
			}
			var collectionItemTable = $('#collectionItemTable');//子项数据区
			collectionItemTable.html(htmlAll);
		}
		var options = {
			url : ctx+'/saleCollection!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('销售收款单',ctx+'/saleCollection!list.do');
				}else{
					alert('保存失败');
				}
			},
			error : function(){
				alert('保存失败');
			}
		};
		$('#orderForm').ajaxSubmit(options);
	}
}

//校验表单
function checkForm(){
	//客户
	var customer = $('#customerName').val();
	if(customer == ''){
		alert('请选择客户');
		$('#customerName').focus();
		return false;
	}
	//收款账户
	var bankAccountId = $('#bankAccountId').val();
	if(bankAccountId == ''){
		alert('请选择收款账户');
		return false;
	}
	//支付方式
	var paymentId = $('#paymentId').val();
	if(paymentId == ''){
		alert('请选择支付方式');
		return false;
	}
	return true;
}

//获取一个新的空项
function buildCollectionItem(){
	var collectionItem = {};//商品
	collectionItem.id = '';
	collectionItem.orderId = '';
	collectionItem.code = '';
	collectionItem.moneyAccount = '';
	collectionItem.moneyAlreadyReceived = '';
	collectionItem.moneyCurrentReceived = '';
	collectionItem.remark = '';
	return collectionItem;
}

//添加空项
function addCollectionItemRow(more){
	var lastEditRowIndex;
	var collectionItem = buildCollectionItem();//获取一个新的空项
	if(more){
		$(gId).datagrid('appendRow',collectionItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',collectionItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = collectionItem;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}
//添加
function addCollectionItem(more){
	var dataArr = new Array();
	var customerId = $('#customerId').val();
	if(!customerId ){
		alert('请先选择客户');
		$('#customerName').focus();
	}else{
		dataArr = common.getSaleDelivery(more,customerId);
		if(dataArr && dataArr.length >0){
			var rows = $(gId).datagrid('getRows'); //所有行
			var dataLen = dataArr.length;
			for(var i=0;i<dataLen;i++){
				var data = dataArr[i];
				var code = data.code;//单据id编码
				var isExist = isOrderExist(code);//商品是否已存在
				if(isExist){
					alert('单据已存在，单据编号:'+data.code);
				}else{
					var rowData = {};		//增加的行对象数组
					var row;				//行对象
					var rowIndex;			//行对象索引
					var addRowflag = false;	//加行标志
					var beginflag = 0;
					if(rows.length >0){
						for(var j = 0;j < rows.length;j++){
							if(rows[j].orderId == null || rows[j].orderId == ''){
								beginflag = j;
								addRowflag =false;
								break;
							}else{
								addRowflag =true;
							}
						}
					}else{
						addRowflag =true;
					}
					if(addRowflag){
						rowData = addCollectionItemRow(more);	//增加行
					}else{
						rowData.row = rows[beginflag];
						rowData.rowIndex = beginflag;
						$(gId).datagrid('selectRow', beginflag);
						$(gId).datagrid('beginEdit', beginflag);
					} 
				}
				if(!isExist){
					var row = rowData.row;
					var rowIndex = rowData.rowIndex;
					if(row){	//设置页面显示的值
						
						row.orderId = data.id;		//单据id
						row.code = data.code;
						var moneyAccount = data.moneyAccount;	//单据金额
						if(moneyAccount){
							row.moneyAccount = moneyAccount;
						}
						var moneyAlreadyReceived = data.moneyReceived;	//已收金额
						if(moneyAlreadyReceived){
							row.moneyAlreadyReceived = moneyAlreadyReceived;
						}
						$(gId).datagrid('endEdit',rowIndex);
						$(gId).datagrid('selectRow',rowIndex);
					}
				}
			}
		}
	}
}
//单据是否已存在
function isOrderExist(code){
	var isExist = false;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		//alert("i:"+i +";isEditing:"+data.isEditing);
		if(!data.isEditing){
			//alert('goodCode:'+goodCode +";data.goodsCode:"+data.goodCode)
			if(code == data.code){
				isExist = true;
				break;
			}
		}
	}
	return isExist;
}

//重写列编辑的事件
var editorView = $.extend($.fn.datagrid.defaults.editors, {
    //重写当前收取金额字段的编辑展示
	moneyCurrentReceived: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){    
        	var html = '<input type="text" class="datagrid-editable-input" name="moneyCurrentReceived"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
        	input.change(function(){
        		calMoneyCurrentReceived(input);
        	});        	
            return input;
        },
        //列将要由编辑转成显示时，从编辑框获取值
        getValue: function(target){
        	target = $(target);
            return target.val();
        },
        setValue: function(target, value){
        	target = $(target);
            target.val(value);
        },
        resize: function(target, width){
            var input = $(target);
            if ($.boxModel == true){
                input.width(width - (input.outerWidth() - input.width()));
            } else {
                input.width(width);
            }
        }
    },
     //重写备注字段的编辑展示
    remark: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="remark"/>';
            var input = $(html).appendTo(container);
            return input;
        },
        //列将要由编辑转成显示时，从编辑框获取值
        getValue: function(target){
        	target = $(target);
            return target.val();
        },
        setValue: function(target, value){
        	target = $(target);
            target.val(value);
        },
        resize: function(target, width){
            var input = $(target);
            if ($.boxModel == true){
                input.width(width - (input.outerWidth() - input.width()));
            } else {
                input.width(width);
            }
        }
    }
});
//重新编辑
function reEdit(rowIndex){
	$(gId).datagrid('endEdit',rowIndex);
	$(gId).datagrid('beginEdit',rowIndex);	
}
//输入金额
function calMoneyCurrentReceived(obj){
	var moneyCurrentReceived = $(obj).val();
	if(moneyCurrentReceived && ''!=moneyCurrentReceived){
		moneyCurrentReceived = Number(moneyCurrentReceived);
	}else{
		moneyCurrentReceived = 0;
	}
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	var moneyAccount = rowData.moneyAccount;
	var moneyAlreadyReceived = rowData.moneyAlreadyReceived;
	if(moneyAlreadyReceived+moneyCurrentReceived > moneyAccount){
		alert('本次收款金额与已收金额之和超过订单金额');
	}else{
		rowData.moneyCurrentReceived = moneyCurrentReceived;
	}
	reEdit(rowIndex);
	calTotalMoney();
}

//计算总金额
function calTotalMoney(){
	var totalMoney = 0;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(data.moneyCurrentReceived != null){
			totalMoney += data.moneyCurrentReceived;
		}
	}
	totalMoney = totalMoney.toFixed(2);
	$('#moneyAccount').val(totalMoney);
}
//获取正在编辑的行
function getEditingRow(){
	var editingRow;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
//		alert("i:"+i +";isEditing"+data.isEditing);
		if(data.isEditing){
			editingRow = {}
			editingRow.rowData = data;
			editingRow.rowIndex = i;
			break;
		}
	}
	
	return editingRow;
}
//选择客户
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
		$('#linkman').val(data.linkman);
		$('#mobile').val(data.mobile);
	}
}

//确认收款
function confirmCollection(){
	$('#paymentState').val('1');
	submitSaveForm();
}
