var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标
$(document).ready(function(){
	$('#warehouseMoveWareForm').submit(function(){
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
			text:'添加商品',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addWareRow(true);
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
	
    return opt;	
}

//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'wareId',width:0,align:'left'},
		{field:'fwarehousePositionId',width:0,align:'left'},
		{field:'swarehousePositionId',width:0,align:'left'},
		{field:'fwarehousePositionName',title:'发货仓位',width:30,align:'left',editor:'fwarehousePositionName'},
		{field:'code',title:'商品编号',width:25,align:'left'},
		{field:'wareName',title:'调库商品',width:25,align:'left',editor:'fwareName'},
		{field:'swarehousePositionName',title:'收货仓位',width:30,align:'left',editor:'swarehousePositionName'},
		{field:'moveNum',title:'调库数量',width:20,editor:{type:'moveNum',options:{precision:'0'}}},
		{field:'priceOut',title:'调出单价',width:20,editor:{type:'priceOut',options:{precision:'2'}}},
		{field:'moneyOut',title:'调出金额',width:20},
		{field:'priceIn',title:'调入单价',width:20,editor:{type:'priceIn',options:{precision:'2'}}},
		{field:'moneyIn',title:'调入金额',width:20},
		{field:'priceSale',title:'销售单价',width:20,editor:{type:'priceSale',options:{precision:'2'}}},
		{field:'moneySale',title:'销售金额',width:20}
		
	];
	return opt;
}


//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url = ctx+'/WarehouseMoveWare_json!listJson.do?1=1&warehouseMoveWare.warehouseMoveId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//确认调库
function comfirmMove(){
	$('#state').val('s');
	submitSaveForm();
}

//提交warehouseMoveWareForm表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
	
		var warehouseMoveWareArr = $(gId).datagrid('getData').rows;//获取json数据集合
		if(warehouseMoveWareArr){
			var htmlAll = '';
		
			var length = warehouseMoveWareArr.length;
			}
		for(var i=0;i<length;i++){
				var warehouseMoveWare = warehouseMoveWareArr[i];
				var fwarehousePositionId = warehouseMoveWare.fwarehousePositionId ;
				if(fwarehousePositionId && '' != fwarehousePositionId){
					var moveNumHtml = '<input type="hidden" name="moveNumArr" value="'+warehouseMoveWare.moveNum+'" />'; 														//调度数量
					var fwarehousePositionIdHtml = '<input type="hidden" name="fwarehousePositionIdArr" value="'+warehouseMoveWare.fwarehousePositionId+'" />'; 				//发货仓位ID
					var fwarehousePositionNameHtml = '<input type="hidden" name="fwarehousePositionNameArr" value="'+warehouseMoveWare.fwarehousePositionName+'" />'; 			//发货仓位名称
					var wareIdHtml = '<input type="hidden" name="wareIdArr" value="'+warehouseMoveWare.wareId+'" />'; 															//发货货物ID
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+warehouseMoveWare.wareName+'" />'; 													//发货货物名称
					var swarehousePositionIdHtml = '<input type="hidden" name="swarehousePositionIdArr" value="'+warehouseMoveWare.swarehousePositionId+'" />'; 				//收货仓位ID
					var swarehousePositionNameHtml = '<input type="hidden" name="swarehousePositionNameArr" value="'+warehouseMoveWare.swarehousePositionName+'" />'; 			//收货仓位名称
					var priceOutHtml = '<input type="hidden" name="priceOutArr" value="'+warehouseMoveWare.priceOut+'"/>';
					var moneyOutHtml = '<input type="hidden" name="moneyOutArr" value="'+warehouseMoveWare.moneyOut+'"/>';
					var priceInHtml = '<input type="hidden" name="priceInArr" value="'+warehouseMoveWare.priceIn+'"/>';
					var moneyInHtml = '<input type="hidden" name="moneyInArr" value="'+warehouseMoveWare.moneyIn+'"/>';
					var priceSaleHtml = '<input type="hidden" name="priceSaleArr" value="'+warehouseMoveWare.priceSale+'"/>';
					var moneySaleHtml = '<input type="hidden" name="moneySaleArr" value="'+warehouseMoveWare.moneySale+'"/>';
					htmlAll += '<tr>'+ moveNumHtml + fwarehousePositionIdHtml + fwarehousePositionNameHtml +
					wareIdHtml + wareNameHtml + swarehousePositionIdHtml + swarehousePositionNameHtml +
					priceOutHtml + moneyOutHtml + priceInHtml + moneyInHtml + priceSaleHtml + moneySaleHtml+'</tr>'; 
				}
			}
			var warehouseMoveWareTable = $('#warehouseMoveWareTable');//调度单数据区
			warehouseMoveWareTable.html(htmlAll);
		
		var options = {
			url : ctx+'/warehouseMove!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('调库单',ctx+'/warehouseMove!list.do'); //保存成功后返回调库单列表
				}else{
					alert('保存失败');
				}
			},
			error : function(){
				alert('保存失败');
			}
		};
		$('#warehouseMoveWareForm').ajaxSubmit(options);
	}
}	
function checkForm(){

	//发货仓库
	var swarehouseName = $('#swarehouseName').val();
	if(swarehouseName == ''){
		alert('请选择发货仓库');
		$('#swarehouseName').focus();
		return false;
	}
	//收货仓库
	var fwarehouseName = $('#fwarehouseName').val();
	if(fwarehouseName == ''){
		alert('请选择收货仓库');
		$('#fwarehouseName').focus();
		return false;
	}
	return true;
}

//获取一个新的空货物项
function buildMoveWare(){
	var warehouseMoveWare = {};//商品
	warehouseMoveWare.id = '';
	warehouseMoveWare.fwarehousePositionName = '';
	warehouseMoveWare.fwarehousePositionId = '';
	warehouseMoveWare.swarehousePositionId = '';
	warehouseMoveWare.swarehousePositionName = '';
	warehouseMoveWare.wareName = '';
	warehouseMoveWare.wareId = '';
	warehouseMoveWare.code = '';
	warehouseMoveWare.moveNum = 0;
	warehouseMoveWare.priceOut = '';
	warehouseMoveWare.moneyOut = 0;
	warehouseMoveWare.priceIn = '';
	warehouseMoveWare.moneyIn = 0;
	warehouseMoveWare.priceSale = '';
	warehouseMoveWare.moneySale = 0;
	return warehouseMoveWare;
}

//添加商品空行
function addWareRow(more){
	var lastEditRowIndex;
	var warehouseMoveWare = buildMoveWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',warehouseMoveWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',warehouseMoveWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = warehouseMoveWare;
	rowData.rowIndex = lastEditRowIndex;
	$(gId).datagrid('endEdit',lastEditRowIndex);
	return rowData;
}

//重写列编辑的事件
var editorView = $.extend($.fn.datagrid.defaults.editors, {
    //重写数量字段的编辑展示
    moveNum: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){   
        	var html = '<input type="text" class="datagrid-editable-input" name="moveNum"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney(input.val(),'','','');
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
    } ,
    
     //重写发货仓位字段的编辑展示
    fwarehousePositionName: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="fwarehousePositionName"/>';
            var input = $(html).appendTo(container);
        	input.click(function(){
        		selectFPosition(input);
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
    //重写发货仓位字段的编辑展示
    swarehousePositionName: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="swarehousePositionName"/>';
            var input = $(html).appendTo(container);
        	input.click(function(){
        		selectSPosition(input);
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
    } ,
    //重写发货货物字段的编辑展示
    fwareName: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="fwareName"/>';
            var input = $(html).appendTo(container);
        	input.click(function(){
        		selectFwareName(input);
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
    //重写收货货物字段的编辑展示
    swareName: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="swareName"/>';
            var input = $(html).appendTo(container);
        	input.click(function(){
        		selectSwareName(input);
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
    //重写调出单价字段的编辑展示
    priceOut: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){   
        	var html = '<input type="text" class="datagrid-editable-input" name="priceOut"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney('',input.val(),'','');
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
  //重写调入单价字段的编辑展示
    priceIn: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){   
        	var html = '<input type="text" class="datagrid-editable-input" name="priceIn"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney('','',input.val(),'');
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
  //重写销售单价字段的编辑展示
    priceSale: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){   
        	var html = '<input type="text" class="datagrid-editable-input" name="priceSale"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney('','','',input.val());
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
    }
});

//选择收货仓库
function selectSwarehouseName(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		var fwarehouseId = $('#fwarehouseId').val();
		if(warehouse.id == fwarehouseId){
			alert('发货仓库和收货仓库不能为同一仓库');
		}else{
			$('#swarehouseId').val(warehouse.id);
			$('#swarehouseName').val(warehouse.name);
		}
	}
	
}

//选择发货仓库
function selectFwarehouseName(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		var swarehouseId = $('#swarehouseId').val();
		if(warehouse.id == swarehouseId){
			alert('发货仓库和收货仓库不能为同一仓库');
		}else{
			$('#fwarehouseId').val(warehouse.id);
			$('#fwarehouseName').val(warehouse.name);
		}
	}
	
}

//选择发货仓位
function selectFPosition(obj){
	var fwarehouseId = $('#fwarehouseId').val();
	if(fwarehouseId != ''){
		var url = ctx +'/warehousePosition!list.do?todo=show&warehousePosition.warehouseId='+fwarehouseId;
		var dataArr = 
			window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length > 1){
			alert('只能选择一个仓位');
		}else if(dataArr && dataArr.length == 1 ){
			var warehousePosition = dataArr[0];
			var row = getEditingRow();//当前编辑行
			var rowData = row.rowData;
			var rowIndex = row.rowIndex;
			if(warehousePosition != null){
				rowData.fwarehousePositionId = warehousePosition.id;
				$(obj).val(warehousePosition.name);
				reEdit(rowIndex);
			}
		}
	}else{
		alert('请选择发货仓库');
	}
}

//选择收货仓位
function selectSPosition(obj){
	var swarehouseId = $('#swarehouseId').val();
	if(swarehouseId != ''){
		var url = ctx +'/warehousePosition!list.do?todo=show&warehousePosition.warehouseId='+swarehouseId;
		var dataArr = 
			window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length > 1){
			alert('只能选择一个仓位');
		}else if(dataArr && dataArr.length == 1 ){
			var warehousePosition = dataArr[0];
			var row = getEditingRow();//当前编辑行
			var rowData = row.rowData;
			var rowIndex = row.rowIndex;
			if(warehousePosition != null){
				rowData.swarehousePositionId = warehousePosition.id;
				$(obj).val(warehousePosition.name);
				reEdit(rowIndex);
			}
		}
	}else{
		alert('请选择收获仓库');
	}
}
//选择发货商品
function selectFwareName(obj){
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	var fwarehousePositionId = rowData.fwarehousePositionId;
	if(fwarehousePositionId != ''){
		var url = ctx +'/warehousePositionWare!list.do?todo=show&warehousePositionWare.warehousePositionId='+fwarehousePositionId;
		var dataArr = 
			window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length > 1){
			alert('只能选择一个商品');
		}else if(dataArr && dataArr.length == 1 ){
			var warehousePositionWare = dataArr[0];
			if(warehousePositionWare != null){
				rowData.wareId = warehousePositionWare.wareId;
				rowData.code = warehousePositionWare.wareCode;
				$(obj).val(warehousePositionWare.wareName);
				reEdit(rowIndex);
			}
		}
	}else{
		alert('请选择发货仓位');
	}
}

//获取正在编辑的行
function getEditingRow(){
	var editingRow;

	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
	//	alert("i:"+i +";isEditing"+data.isEditing);
		if(data.isEditing){
			editingRow = {};
			editingRow.rowData = data;
			editingRow.rowIndex = i;
			break;
		}
	}
	
	return editingRow;
}
//重新编辑
function reEdit(rowIndex){
	$(gId).datagrid('endEdit',rowIndex);
	$(gId).datagrid('beginEdit',rowIndex);	
}

//计算金额
function calMoney(moveNum,priceOut,priceIn,priceSale){
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	if(moveNum == ''){
		moveNum = rowData.moveNum;
	}
	if(priceOut == ''){
		priceOut = rowData.priceOut;
	}
	if(priceIn == ''){
		priceIn = rowData.priceIn;
	}
	if(priceSale == ''){
		priceSale = rowData.priceSale;
	}
	var moneyOut = priceOut * moveNum;
	var moneyIn = priceIn * moveNum;
	var moneySale = priceSale * moveNum;
	rowData.moneyOut = moneyOut.toFixed(2);
	rowData.moneyIn = moneyIn.toFixed(2);
	rowData.moneySale = moneySale.toFixed(2);
	reEdit(rowIndex);
}
