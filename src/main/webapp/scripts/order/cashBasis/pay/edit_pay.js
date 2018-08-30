var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标

/**
 *加载所有数据
 */
$(document).ready(function(){
	$('#cashItemForm').submit(function(){
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
	var opt = [
		{	
			text:'添加清单',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addCaseItem(true);
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
					}
				}
				flushMoney();//计算总金额
			}
		}
		];
    return opt;
}

//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'bankAccountId',width:0,align:'left'},
		{field:'account',width:0,align:'left'},
		{field:'bank',width:0,align:'left'},
		{field:'accountHolder',width:0,align:'left'},
		{field:'bankAccountCode',title:'付款账户编号',width:15,align:'left'},
		{field:'bankAccountName',title:'付款账户名称',width:15,align:'left'},
		{field:'money',title:'金额',width:10,align:'left',editor:'money',formatter:moneyFormat},
		{field:'remark',title:'备注',width:15,align:'left',editor:'remark'}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url = ctx+'/CashItem_json!listJson.do?cashItem.orderId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//格式化费用金额
function moneyFormat(rowIndex,rowData,value){
	var money = rowData.money;
	if(money){
		money = Number(money);
		money = money.toFixed(2);
	}
	return money;
}

//确认订单
function confirmPay(){
	$('#state').val('s');
	submitSaveForm();
}


//提交orderForm表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
		var cashItemArr = $(gId).datagrid('getData').rows;//获取json数据集合
		
		if(cashItemArr){
			var htmlAll = '';
			var length = cashItemArr.length;
			for(var i=0;i<length;i++){
				var cashItem = cashItemArr[i];
				var bankAccountIdHtml = '<input type="hidden" name="bankAccountIdArr" value="'+cashItem.bankAccountId+'" />'; 							
				var accountHtml = '<input type="hidden" name="accountArr" value="'+cashItem.account+'" />';
				var bankHtml = '<input type="hidden" name="bankArr" value="'+cashItem.bank+'" />'; 							
				var accountHolderHtml = '<input type="hidden" name="accountHolderArr" value="'+cashItem.accountHolder+'" />';
				var bankAccountCodeHtml = '<input type="hidden" name="bankAccountCodeArr" value="'+cashItem.bankAccountCode+'" />'; 							
				var bankAccountNameHtml = '<input type="hidden" name="bankAccountNameArr" value="'+cashItem.bankAccountName+'" />';
				var moneyHtml = '<input type="hidden" name="moneyArr" value="'+cashItem.money+'" />'; 							
				var remarkHtml = '<input type="hidden" name="remarkArr" value="'+cashItem.remark+'" />';
				htmlAll += '<tr>' + bankHtml + accountHolderHtml + bankAccountCodeHtml + bankAccountNameHtml + bankAccountIdHtml + moneyHtml + accountHtml + remarkHtml +'</tr>'; 
			}
		}
		var cashItemTable = $('#cashItemTable');//订单商品项数据区
		cashItemTable.html(htmlAll);
		var options = {
			url : ctx+'/pay!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('付款单',ctx+'/pay!list.do');
				}else{
					alert('保存失败');
				}
			},
			error : function(){
				alert('保存失败');
			}
		};
		$('#cashItemForm').ajaxSubmit(options);
	}
}
//表单验证
function checkForm(){
	//客户
	var customer = $('#customerName').val();
	if(customer == ''){
		alert('请选择付款单位');
		$('#customerName').focus();
		return false;
	}

	//实付金额
	var outOfPocket = $('#moneyPayment').val();
	if(outOfPocket == '' ){
		alert('实付金额不能为空');
		$('#moneyPayment').focus();
		return false;
	}else if(parseInt(outOfPocket) <= 0){
		alert('实付金额要大于0');
		$('#moneyPayment').focus();
		return false;
	}
	
	/**
	//应付金额
	var moneyAccount = $('#moneyAccount').val();
	if(moneyAccount == ''){
		alert('应付金额不能为空');
		$('#moneyAccount').focus();
		return false;
	}else if(moneyAccount == 0){
		alert('应付金额要大于0');
		$('#moneyAccount').focus();
		return false;
	}
	//判断大小
	if(parseFloat(moneyAccount)<parseFloat(outOfPocket)) {
	  alert('实付金额不能大于应付金额！');
	  return false;
    }*/
	return true;
}

//获取一个新的空费用清单
function buildCashItem(){
	var cashItem = {};    	//清单
	
	cashItem.id = '';				//费用清单Id
	cashItem.bankAccountId = '';	//付款账户Id
	cashItem.account = '';	    	//账号
	cashItem.accountHolder = '';	//开户人
	cashItem.bankAccountCode = '';	//付款账户编号
	cashItem.bankAccountName = '';	//付款账户名称
	cashItem.bank = '';	    		//开户行
	cashItem.remark = '';			//备注
	cashItem.money = '';	    	//金额
	return cashItem;
}

//添加商品空行
function addPayRow(more){
	var lastEditRowIndex;
	var cashItem = buildCashItem();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',cashItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',cashItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = cashItem;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//付款清单
function addCaseItem(more){
	var dataArr = new Array();
	dataArr = common.getlistBlank(true);
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];
			var code = data.code;		   //付款项目编号
			var isExist = isPayExist(code);//付款项目编号是否已存在
			if(isExist){
				alert('费用单已存在，编号:'+data.code);
			}else{
				var rowData = {};		//增加的行对象数组
				var row;				//行对象
				var rowIndex;			//行对象索引
				var addRowflag = false;	//加行标志
				var beginflag = 0;
				if(rows.length >0){
					for(var j = 0;j < rows.length;j++){
						if(rows[j].bankAccountCode == null || rows[j].bankAccountCode == ''){
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
					rowData = addPayRow(more);	//增加行
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
					row.bankAccountCode = data.code;	//银行编号
					var bankAccountName = data.name;    //银行名称
					if(bankAccountName){
						row.bankAccountName = bankAccountName;
					}
					var bankAccountId = data.id;		//银行Id
					if(bankAccountId){
						row.bankAccountId = bankAccountId;
					}
					var account = data.account;					//账号
					if(account){
						row.account = account;
					}
					var accountHolder = data.accountHolder;		//开户人
					if(accountHolder){
						row.accountHolder = accountHolder;
					}
					var bank = data.bank;						//开户行
					if(bank){
						row.bank = bank;
					}
					$(gId).datagrid('endEdit',rowIndex);
					$(gId).datagrid('selectRow',rowIndex);
				}
			}
		}
	}
}

//重写列编辑的事件
var editorView = $.extend($.fn.datagrid.defaults.editors, {
    //重写金额的编辑展示
    money:  {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="money"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
        	input.keydown(function(e){
				if(e.keyCode==13){
					warePrice(input);
				}
        	});
        	input.change(function(){
        		warePrice(input);
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

//获取正在编辑的行
function getEditingRow(){
	var editingRow;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(data.isEditing){
			editingRow = {}
			editingRow.rowData = data;
			editingRow.rowIndex = i;
			break;
		}
	}
	return editingRow;
}
//账号是否已存在
function isPayExist(code){
	var isExist = false;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(!data.isEditing){
			if(code == data.bankAccountCode){
				isExist = true;
				break;
			}
		}
	}
	return isExist;
}
/*
//选择客户
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
		$('#moneyAccount').val(data.receivables);
		
	}
}*/

//供应商
function selectSupplier(){
	var data = common.getSupplier();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
		$('#moneyAccount').val(data.receivables);
	}
}

//刷新商品总金额、订单总金额
function flushMoney(){
	var orderMoney = 0;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(data.money != null){
			orderMoney += data.money;
		}
	}
	orderMoney = Number(orderMoney);
	orderMoney = orderMoney.toFixed(2);
	$('#moneyPayment').val(orderMoney);
}

//输入采购价后计算
function warePrice(obj){
	var money = obj.val();
	if(money && '' != money){
		money = Number(money);
	}else{
		money = 0;
	}
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	
	var money = money // 金额
	rowData.money = money;
	reEdit(rowIndex);
	flushMoney();
}