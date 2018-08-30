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
	 			addCombinedWare(true);
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
	var type = $('#type').val();
	var countName = '单品组合所需数量';
	if(type == '1'){
		countName = '单品拆分数量';
	}
	var opt = [
		{field:'wareId',width:0,align:'left'},
		{field:'code',title:'商品编号',width:20,align:'left'},
		{field:'wareName',title:'商品名称',width:25,align:'left'},
		{field:'wareCount',title:countName,width:20,editor:{type:'wareCount',options:{precision:'0'}}}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url = ctx+'/CombinedWare_json!listJson.do?combinedWare.orderId='+id;
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
					var wareIdHtml = '<input type="hidden" name="wareIdArr" value="'+wareId+'" />'; 				//商品id
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+ware.wareName+'" />'; 		//商品名
					var wareCountHtml = '<input type="hidden" name="wareCountArr" value="'+ware.wareCount+'" />'; 	//数量
					htmlAll += '<tr>'+ wareIdHtml + wareNameHtml  + wareCountHtml + '</tr>'; 
				}
			}
			var wareTable = $('#wareTable');//订单商品项数据区
			wareTable.html(htmlAll);
		}
		var type = $('#type').val();
		var title = '';
		if(type == '0'){
			title = '商品组装单';
		}else if(type == '1'){
			title = '商品拆分单';
		}
		var options = {
			url : ctx+'/combined!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab(title,ctx+'/combined!list.do?combined.type='+type);
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
	var wareCount = $('#wareCount').val();
	if(wareCount == ''){
		alert('请输入数量');
		$('#wareCount').focus();
	}
	return true;
}

//获取一个新的空商品项
function buildCombinedWare(){
	var combinedWare = {};//商品
	return combinedWare;
}

//添加商品空行
function addGoodRow(more){
	var lastEditRowIndex;
	var combinedWare = buildCombinedWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',combinedWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',combinedWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = combinedWare;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//订单商品
function addCombinedWare(more){
	var dataArr = new Array();
	var type = $('#type').val();
	if(type == '0'){
		var warehouseId = $('#warehouseId').val();
		if(warehouseId == ''){
			alert('请选择仓库');
		}else{
			dataArr = common.getWarehouseWare(true,warehouseId);
		}
	}else if(type == '1'){
		dataArr = common.getWare(true);
	}
	
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];
			var goodCode = '';//商品编码
			var wareId = '';//商品id
			var wareName = '';//商品名称
			if(type == '0'){
				goodCode = data.wareCode;
				wareId = data.wareId;
				wareName = data.wareName;
			}else if(type == '1'){
				goodCode = data.code;
				wareId = data.id;
				wareName = data.goodName;
			}
			var isExist = isGoodExist(goodCode);//商品是否已存在
			if(isExist){
				alert('商品已存在，商品编号:'+goodCode);
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
					row.wareId = wareId;//商品id
//					alert(wareId)
					row.code = goodCode;
					row.wareName = wareName;
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
	wareCount: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="wareCount"/>';
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

//要拆分或组合的商品
function selectCombinedWare(){
	var warehouseId = $('#warehouseId').val();
	var type = $('#type').val();
	var ware = {};
	var wareId = '';
	var wareName = '';
	if(type == '0'){
		ware = common.getWare(false);
		if(ware){
			wareId = ware.id;
			wareName = ware.goodName;
		}
	}else if(type == '1'){
		if(warehouseId == ''){
			alert('请选择仓库');
		}else{
			ware = common.getWarehouseWare(false,warehouseId);
		}
		if(ware){
			wareId = ware.wareId;
			wareName = ware.wareName;
		}
	}
//	alert(wareId+'------'+wareName);
	if(wareId != ''){
		$('#wareId').val(wareId);
		$('#wareName').val(wareName);
	}
}
