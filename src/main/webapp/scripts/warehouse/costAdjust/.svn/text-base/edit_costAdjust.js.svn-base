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
			var state = $('#state').val();
			if(state == 'c'){
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
			}
		},
		//行编辑前的响应事件
		onBeforeEdit:function(rowIndex, rowData){
			rowData.isEditing = true;//标示该行正在编辑
		},
		//行编辑完成后的响应事件
		onAfterEdit:function(rowIndex, rowData, changes){
			rowData.isEditing = false;
		}
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});
//工具条
function getToolBarOpt(){
	var opt = [];
	var state = $('#state').val();
	if(state == 'c'){
		opt = [
		{	
			text:'添加商品',
	 		iconCls:'icon-add',
	 		handler:function(){
				addWare(true);
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
			}
		}
		];
	}
    return opt;	
}

//获取列头参数
function getColumnsOpt(){
	var type = $('#type').val();
	var opt = [
		{field:'wareId',width:0,align:'left'},
		{field:'warecode',title:'商品编号',width:20,align:'left'},
		{field:'wareName',title:'商品名称',width:25,align:'left'},
		{field:'stock',title:'库存',width:25,align:'left'},
		{field:'costCurrent',title:'调整前成本 ',width:20,formatter:costCurrentFormat},
		{field:'costAdjust',title:'调整后成本',width:20,formatter:costAdjustFormat,editor:{type:'costAdjust',options:{precision:'2'}}},
		{field:'remark',title:'备注',width:20,editor:'remark'}
	
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url += ctx+'/CostAdjustWare_json!listJson.do?costAdjust.orderId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//格式化调整前价格
function costCurrentFormat(rowIndex,rowData,value){
	var costCurrent = rowData.costCurrent;
	if(costCurrent){
		costCurrent = costCurrent.toFixed(2);
	}
	return costCurrent;
}
//格式化调整后价格
function costAdjustFormat(rowIndex,rowData,value){
	var costAdjust = rowData.costAdjust;
	if(costAdjust){
		costAdjust = costAdjust.toFixed(2);
	}
	return costAdjust;
}
//确认订单
function confirmsaleAdjustment(){
	$('#adjustState').val('1');
	submitSaveForm();
}
//提交orderForm表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
	
		var wareArr = $(gId).datagrid('getData').rows;//获取json数据集合
		if(wareArr){
			var htmlAll = '';
		
			var length = wareArr.length;
			for(var i=0;i<length;i++){
				var ware = wareArr[i];
				var wareId = ware.wareId;
				if(wareId && '' != wareId){
					var wareIdHtml = '<input type="hidden" name="wareIdArr" value="'+wareId+'" />'; 							//商品id
					var wareCodeHtml = '<input type="hidden" name="wareCodeArr" value="'+ware.wareCode+'" />';
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+ware.wareName+'" />'; 					//商品名
					var costCurrentHtml = '<input type="hidden" name="costCurrentArr" value="'+ware.costCurrent+'" />'; 		//调整前价格
					var costAdjustHtml = '<input type="hidden" name="costAdjustArr" value="'+ware.costAdjust+'" />'; 		//调整后价格
					var stockHtml = '<input type="hidden" name="stockArr" value="'+ware.stock+'" />'; 		//调整后价格
					var remarkHtml = '<input type="hidden" name="remarkArr" value="'+ware.remark+'" />'; 		//调整后价格
					
					htmlAll += '<tr>'+ wareCodeHtml+ wareIdHtml + wareNameHtml + costCurrentHtml + costAdjustHtml + stockHtml+ remarkHtml+'</tr>'; 
				}
			}
			var wareTable = $('#wareTable');//订单商品项数据区
			wareTable.html(htmlAll);
		}
		var title = '成本调价单';
		var url = ctx+'/costAdjust!list.do';
		var options = {
			url : ctx+'/costAdjust!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab(title,url);
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
function checkForm(){
	return true;
}
//获取一个新的空订单商品项
function buildCostAdjustWare(){
	var costAdjustWare = {};//商品
	return costAdjustWare;
}

//添加商品空行
function addGoodRow(more){
	var lastEditRowIndex;
	var costAdjustWare = buildCostAdjustWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',costAdjustWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',costAdjustWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = costAdjustWare;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//订单商品
function addWare(more){
	var dataArr = new Array();
	var warehouseId = $('#warehouseId').val();
	if(warehouseId == ''){
		alert('请选择仓库');
	}else{
		dataArr = common.getWarehouseWare(true,warehouseId);
		if(dataArr && more){
			var rows = $(gId).datagrid('getRows'); //所有行
			var dataLen = dataArr.length;
			for(var i=0;i<dataLen;i++){
				var data = dataArr[i];
				var goodCode = data.wareCode;//商品编码
				var isExist = isGoodExist(goodCode);//商品是否已存在
				if(isExist){
					alert('商品已存在，商品编号:'+data.wareCode);
				}else{
					var rowData = {};		//增加的行对象数组
					var row;				//行对象
					var rowIndex;			//行对象索引
					var addRowflag = false;	//加行标志
					var beginflag = 0;
					if(rows.length >0){
						for(var j = 0;j < rows.length;j++){
							if(rows[j].wareId == null || rows[j].wareId == ''){
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
						rowData = addGoodRow(more);	//增加行
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
						row.wareId = data.id;//商品id
						row.warecode = data.wareCode;
						var wareName = data.wareName;//商品名称
						if(wareName){
							row.wareName = wareName;
						}
						row.stock = data.wareCount;
						var costCurrent = data.averageCostInventory;			//当前成本价
						if(costCurrent){
							row.costCurrent = costCurrent;
						}
						$(gId).datagrid('endEdit',rowIndex);
						$(gId).datagrid('selectRow',rowIndex);
					}
				}
			}
		}
	}
}
//重写列编辑的事件
var editorView = $.extend($.fn.datagrid.defaults.editors, {
    //重写调整后价格的编辑展示
	costAdjust: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="costAdjust"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	var costAdjust = input.val();
            	if(costAdjust && ''!=costAdjust){
            		costAdjust = Number(costAdjust);
            	}else{
            		costDiscount = 0;
            	}
            	var row = getEditingRow();//当前编辑行
            	var rowData = row.rowData;
            	var rowIndex = row.rowIndex;
            	rowData.costAdjust = costAdjust;
            	reEdit(rowIndex);
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
//		alert("i:"+i +";isEditing"+data.isEditing);
		if(data.isEditing){
			editingRow = {};
			editingRow.rowData = data;
			editingRow.rowIndex = i;
			break;
		}
	}
	
	return editingRow;
}
//商品是否已存在
function isGoodExist(goodCode){
	var isExist = false;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		//alert("i:"+i +";isEditing:"+data.isEditing);
		if(!data.isEditing){
			//alert('goodCode:'+goodCode +";data.goodsCode:"+data.goodCode)
			if(goodCode == data.code){
				isExist = true;
				break;
			}
		}
	}
	return isExist;
}
//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
