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
			var adjustState = $('#adjustState').val();
			if(adjustState == '0'){
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
	var adjustState = $('#adjustState').val();
	if(adjustState == '0'){
		opt = [
		{	
			text:'添加商品',
	 		iconCls:'icon-add',
	 		handler:function(){
				addSaleWare(true);
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
		{field:'code',title:'商品编号',width:20,align:'left'},
		{field:'wareName',title:'商品名称',width:25,align:'left'},
		{field:'goodTypeName',title:'类别',width:20,align:'left'},
		{field:'wareSpecificationVal',title:'规格',width:20,align:'left'}
		
	];
	if(type != '2'){
		opt.push(
				{field:'priceCost',title:'成本价',width:20,formatter:priceCostFormat}
				);
	}
	opt.push(
			{field:'priceCurrent',title:'调整前价格',width:20,formatter:priceCurrentFormat},
			{field:'priceAdjust',title:'调整后价格',width:20,formatter:priceAdjustFormat,editor:{type:'priceAdjust',options:{precision:'2'}}}
			);
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url += ctx+'/PriceAdjustWare_json!listJson.do?priceAdjust.orderId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//格式化成本价格
function priceCostFormat(rowIndex,rowData,value){
	var priceCost = rowData.priceCost;
	if(priceCost){
		priceCost = priceCost.toFixed(2);
	}
	return priceCost;
}
//格式化调整前价格
function priceCurrentFormat(rowIndex,rowData,value){
	var priceCurrent = rowData.priceCurrent;
	if(priceCurrent){
		priceCurrent = priceCurrent.toFixed(2);
	}
	return priceCurrent;
}
//格式化调整后价格
function priceAdjustFormat(rowIndex,rowData,value){
	var priceAdjust = rowData.priceAdjust;
	if(priceAdjust){
		priceAdjust = priceAdjust.toFixed(2);
	}
	return priceAdjust;
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
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+ware.wareName+'" />'; 					//商品名
					var priceCurrentHtml = '<input type="hidden" name="priceCurrentArr" value="'+ware.priceCurrent+'" />'; 		//调整前价格
					var priceAdjustHtml = '<input type="hidden" name="priceAdjustArr" value="'+ware.priceAdjust+'" />'; 		//调整后价格
					
					htmlAll += '<tr>'+ wareIdHtml + wareNameHtml + priceCurrentHtml + priceAdjustHtml + '</tr>'; 
				}
			}
			var wareTable = $('#wareTable');//订单商品项数据区
			wareTable.html(htmlAll);
		}
		var type = $('#type').val();
		var title = '';
		var url = ctx+'/priceAdjust!list.do?priceAdjust.type='+type;
		if(type == '0'){
			title = '普通调价单';
		}else if(type == '1'){
			title = '促销调价单';
		}else if(type == '2'){
			title = '采购调价单';
		}
		var options = {
			url : ctx+'/priceAdjust!save.do',
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
	var startTime = $('#startTime').val();
	if(startTime == ''){
		alert('请选择调价开始时间');
		return false;
	}
	var type = $('#type').val();
	if(type == '1'){
		var endTime = $('#endTime').val();
		if(endTime == ''){
			alert('请选择调价结束时间');
			return false;
		}
	}
	return true;
}
//获取一个新的空订单商品项
function buildPriceAdjustWare(){
	var costAdjustWare = {};//商品
	return costAdjustWare;
}

//添加商品空行
function addGoodRow(more){
	var lastEditRowIndex;
	var costAdjustWare = buildPriceAdjustWare();//获取一个新的空商品项
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
function addSaleWare(more){
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
					var wareName = data.goodName;//商品名称
					if(wareName){
						row.wareName = wareName;
					}
					var goodTypeName = data.goodTypeName;//商品类别
					if(goodTypeName){
						row.goodTypeName = goodTypeName;
					}
					var wareSpecificationVal = data.wareSpecificationVal;//商品规格
					if(wareSpecificationVal){
						row.wareSpecificationVal = wareSpecificationVal;
					}else{
						row.wareSpecificationVal = '无规格';
					}
					var type = $('#type').val();
					//采购调价单
					if(type == '2'){
						var purchasePrice = data.purchasePrice;
						if(purchasePrice){
							row.priceCurrent = purchasePrice;
						}
					}else{
						//普通调价单和促销调价单
						var priceCost = data.averageCostInventory;			//成本价
						if(priceCost){
							row.priceCost = priceCost;
						}
						var goodPrice = data.price;							//当前价格
						if(goodPrice){
							row.priceCurrent = goodPrice;
						}
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
    //重写调整后价格的编辑展示
	priceAdjust: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="priceAdjust"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	var priceAdjust = input.val();
            	if(priceAdjust && ''!=priceAdjust){
            		priceAdjust = Number(priceAdjust);
            	}else{
            		priceDiscount = 0;
            	}
            	var row = getEditingRow();//当前编辑行
            	var rowData = row.rowData;
            	var rowIndex = row.rowIndex;
            	rowData.priceAdjust = priceAdjust;
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

