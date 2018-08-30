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
	var opt = [
		{	
			text:'添加商品',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addIntoWare(true);
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
		{field:'wareId',width:0,align:'left',hidden:'true'},
		{field:'warehousePositionId',width:0,align:'left',hidden:'true'},
		{field:'code',title:'商品编号',width:20,align:'left'},
		{field:'wareName',title:'商品名称',width:25,align:'left'},
		{field:'warehousePositionName',title:'入库仓位',width:20,editor:'warehosePositionName'},
		{field:'intoNum',title:'入库数量',width:20,editor:{type:'intoNum',options:{precision:'0'}}},
		{field:'priceIn',title:'入库价格',width:20,editor:{type:'priceIn',options:{precision:'2'}}},
		{field:'moneyIn',title:'入库金额',width:20}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var type = $('#type').val();
	var orderId = $('#orderId').val();
	var url = '';
	if(id != ''){
		url = ctx+'/WarehouseIntoWare_json!listJson.do?warehouseIntoWare.warehouseIntoId='+id;
	}else if(type == '0' && orderId != ''){
		url = ctx+'/BuyWare_json!listWarehouseIntoWareJson.do?buyWare.buyId='+orderId;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//确认订单
function confirmOrder(){
	$('#state').val('s');
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
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+ware.wareName+'" />'; 						//商品名
					var warehousePositionIdHtml = '<input type="hidden" name="warehousePositionIdArr" value="'+ware.warehousePositionId+'" />'; //仓位id
					var warehousePositionNameHtml = '<input type="hidden" name="warehousePositionNameArr" value="'+ware.warehousePositionName+'" />';//仓位名
					var intoNumHtml = '<input type="hidden" name="intoNumArr" value="'+ware.intoNum+'" />'; 							//入库数量
					var priceInHtml = '<input type="hidden" name="priceInArr" value="'+ware.priceIn+'" />';
					var moneyInHtml = '<input type="hidden" name="moneyInArr" value="'+ware.moneyIn+'" />'; 
					htmlAll += '<tr>'+ wareIdHtml + wareNameHtml  + warehousePositionIdHtml + warehousePositionNameHtml + intoNumHtml + priceInHtml + moneyInHtml + '</tr>'; 
				}
			}
			var wareTable = $('#wareTable');//订单商品项数据区
			wareTable.html(htmlAll);
		}
		var type = $('#type').val();
		var title = '';
		if(type == '0'){
			title = '商品入库单';
		}else if(type == '1'){
			title = '赠品入库单';
		}else if(type == '2'){
			title = '其他入库单';
		}
		var options = {
			url : ctx+'/warehouseInto!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab(title,ctx+'/warehouseInto!list.do?warehouseInto.type='+type);
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

//获取一个新的空商品项
function buildIntoWare(){
	var intoWare = {};//商品
	intoWare.id = '';
	intoWare.wareId = '';
	intoWare.code = '';
	intoWare.wareName = '';
	intoWare.warehousePositionId = '';
	intoWare.warehousePositionName = '';
	intoWare.intoNumber = '';
	intoWare.priceIn = '';
	intoWare.moneyIn = 0;
	return intoWare;
}

//添加商品空行
function addGoodRow(more){
	var lastEditRowIndex;
	var intoWare = buildIntoWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',intoWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',intoWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = intoWare;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//订单商品
function addIntoWare(more){
	var dataArr = new Array();
	dataArr = common.getWare(true);
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];
			var goodCode = data.code;//商品编码
			var isExist = isGoodExist(goodCode);//商品是否已存在
			if(isExist){
				alert('商品已存在，商品编号:'+data.code);
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
					row.code = data.code;
					var goodName = data.goodName;//商品名称
					if(goodName){
						row.wareName = goodName;
					}
					var goodTypeName = data.goodTypeName;//商品类别
					if(goodTypeName){
						row.goodTypeName = goodTypeName;
					}
					var wareSpecificationVal = data.wareSpecificationVal;//商品规格
					if(wareSpecificationVal){
						row.wareSpecificationVal = wareSpecificationVal;
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
    //重写数量字段的编辑展示
	intoNum: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="intoNum"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney(input.val(),'');
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
    //重写入库价格字段的编辑展示
	priceIn: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="priceIn"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	calMoney('',input.val());
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
    //重写仓位字段的编辑展示
    warehosePositionName: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="warehosePositionName"/>';
            var input = $(html).appendTo(container);
        	input.click(function(){
        		selectPosition(input);
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

//计算金额
function calMoney(intoNum,priceIn){
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	if(intoNum == ''){
		intoNum = rowData.intoNum;
	}
	if(priceIn == ''){
		priceIn = rowData.priceIn;
	}
	var moneyIn = priceIn * intoNum;
	rowData.moneyIn = moneyIn.toFixed(2);
	reEdit(rowIndex);
}

//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
//选择仓位
function selectPosition(obj){
	var warehouseId = $('#warehouseId').val();
	if(warehouseId != ''){
		var url = ctx +'/warehousePosition!list.do?todo=show&warehousePosition.warehouseId='+warehouseId;
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
				rowData.warehousePositionId = warehousePosition.id;
				$(obj).val(warehousePosition.name);
				reEdit(rowIndex);
			}
		}
	}else{
		alert('请选择仓库');
	}
}
