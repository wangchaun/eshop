var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标

/**
 *加载所有数据
 */
$(document).ready(function(){
	$('#feeItemForm').submit(function(){
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
	 			addFeeItem(true);
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
		{field:'code',title:'费用项目编号',width:10,align:'left'},
		{field:'name',title:'费用项目名称',width:15,align:'left',editor:'name'},
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
		url = ctx+'/FeeItem_json!listJson.do?feeItem.orderId='+id;
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
function confirmFee(){
	$('#state').val('s');
	submitSaveForm();
}


//提交orderForm表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
		var documentItemArr = $(gId).datagrid('getData').rows;//获取json数据集合
		
		if(documentItemArr){
			var htmlAll = '';
			var length = documentItemArr.length;
			for(var i=0;i<length;i++){
				var documentItem = documentItemArr[i];
				var nameHtml = '<input type="hidden" name="nameArr" value="'+documentItem.name+'" />'; 						
				var moneyHtml = '<input type="hidden" name="moneyArr" value="'+documentItem.money+'" />'; 							
				var codeHtml = '<input type="hidden" name="codeArr" value="'+documentItem.code+'" />'; 						
				var remarkHtml = '<input type="hidden" name="remarkArr" value="'+documentItem.remark+'" />';
				htmlAll += '<tr>' + nameHtml + moneyHtml + codeHtml + remarkHtml +'</tr>'; 
			}
		}
		var feeItemTable = $('#feeItemTable');//订单商品项数据区
		feeItemTable.html(htmlAll);
		var options = {
			url : ctx+'/fee!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('费用单',ctx+'/fee!list.do');
				}else{
					alert('保存失败');
				}
			},
			error : function(){
				alert('保存失败');
			}
		};
		$('#feeItemForm').ajaxSubmit(options);
	}
}
//表单验证
function checkForm(){
	//收款账户
	var bankAccountId = $('#bankAccountId').val();
	if(bankAccountId == ''){
		alert('请选择收款账户');
		return false;
	}
	//客户
	var customer = $('#customerName').val();
	if(customer == ''){
		alert('请选择客户');
		$('#customerName').focus();
		return false;
	}
	return true;
}

//获取一个新的空费用清单
function buildFeeItem(){
	var feeItem = {};    	//清单
	
	feeItem.id = '';		//费用清单Id
	feeItem.remark = '';	//备注
	feeItem.name = '';		//名称
	feeItem.code = '';		//编号
	feeItem.money = '';	//金额
	return feeItem;
}

//添加商品空行
function addFeeRow(more){
	var lastEditRowIndex;
	var feeItem = buildFeeItem();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',feeItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',feeItem);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = feeItem;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//费用清单
function addFeeItem(more){
	var dataArr = new Array();
	dataArr = common.getlistDictionaryItem(true,'fee');
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];
			var code = data.code;//费用项目编号
			var isExist = isFeeExist(code);//费用项目编号是否已存在
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
						if(rows[j].code == null || rows[j].code == ''){
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
					rowData = addFeeRow(more);	//增加行
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
					row.code = data.code;
					var name = data.name;//商品名称
					if(name){
						row.name = name;
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
//清单是否已存在
function isFeeExist(code){
	var isExist = false;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(!data.isEditing){
			if(code == data.code){
				isExist = true;
				break;
			}
		}
	}
	return isExist;
}

//选择客户
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
	}
}

//供应商
function selectSupplier(){
	var data = common.getSupplier();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
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
	$('#moneyAccount').val(orderMoney);
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