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
				flushMoney();
			}
		}
		];
    return opt;	
}

//获取列头参数
function getColumnsOpt(){
	var opt = [
		{field:'wareId',align:'left',hidden:'true'},
		{field:'code',title:'商品编号',width:20,align:'left'},
		{field:'name',title:'商品名称',width:25,align:'left'},
		{field:'goodTypeName',title:'类别',width:20,align:'left'},
		{field:'wareSpecificationVal',title:'规格',width:20,align:'left'},
		{field:'goodPrice',title:'单价',width:20,formatter:priceFormat},
		{field:'orderNumber',title:'退货数量',width:20,editor:{type:'orderNumber',options:{precision:'0'}}},
		{field:'priceDiscount',title:'优惠金额',width:20,align:'left',formatter:priceDiscountFormat,editor:{type:'priceDiscount',options:{precision:'2'}}},
		{field:'money',title:'总价',width:20,align:'left',formatter:moneyFormat}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	 
	var orderId = $('#orderId').val();
	 
	var url = ctx+'/SaleWare_json!listJson.do?1=1';
	if(orderId != ''){
		url += '&saleWare.saleId='+orderId;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}
//格式化价格
function priceFormat(rowIndex,rowData,value){
	var goodPrice = rowData.goodPrice;
	if(goodPrice){
		goodPrice = goodPrice.toFixed(2);
	}
	return goodPrice;
}
//格式化优惠金额
function priceDiscountFormat(rowIndex,rowData,value){
	var priceDiscount = rowData.priceDiscount;
	
	if(priceDiscount!=''){
		priceDiscount = Number(priceDiscount);
		priceDiscount = priceDiscount.toFixed(2);
	}
	if(priceDiscount==''|| priceDiscount==null){
		priceDiscount=0;
	}
	return priceDiscount;
}
//格式化单项商品总金额
function moneyFormat(rowIndex,rowData,value){
	var money = rowData.money;
	if(money){
		money = money.toFixed(2);
	}
	return money;
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
					var wareIdHtml = '<input type="hidden" name="wareIdArr" value="'+wareId+'" />'; 						//商品id
					var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+ware.name+'" />';
					var numberHtml = '<input type="hidden" name="orderNumberArr" value="'+ware.orderNumber+'" />'; 				//订购数量
					var priceHtml = '<input type="hidden" name="goodPriceArr" value="'+ware.goodPrice+'" />'; 					//价格
					var moneyHtml = '<input type="hidden" name="moneyArr" value="'+ware.money+'" />'; 						//总价
					var priceDiscountHtml = '<input type="hidden" name="priceDiscountArr" value="'+ware.priceDiscount+'" />';	//优惠金额
					
					htmlAll += '<tr>'+ wareIdHtml +wareNameHtml+ numberHtml + priceHtml + moneyHtml + priceDiscountHtml + '</tr>'; 
				}
			}
			var wareTable = $('#wareTable');//订单商品项数据区
			wareTable.html(htmlAll);
		} 
		var options = {   
			url : ctx+'/saleReturn!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('销售退货单',ctx+'/saleReturn!list.do');
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
	//联系方式
	var mobile = $('#mobile').val();
	var telephone = $('#telephone').val();
	if(mobile == '' && telephone == ''){
		alert('手机和固定电话至少要填一个');
		return false;
	}
	//地址
	var areaNames = $('#areaNames').val();
	if(areaNames == ''){
		alert('请输入地区');
		$('#street').focus();
		return false;
	}
	var street = $('#street').val();
	if(street == ''){
		alert('请输入详细街道地址');
		$('#street').focus();
		return false;
	}
	return true;
}

//获取一个新的空订单商品项
function buildSaleWare(){
	var saleWare = {};//商品
	saleWare.id = '';
	saleWare.wareId = '';
	saleWare.code = '';
	saleWare.name = '';
	saleWare.goodTypeName = '';
	saleWare.wareSpecificationVal = '';
	saleWare.goodPrice = '';
	saleWare.orderNumber = '';
	saleWare.priceDiscount = '';
	saleWare.money = '';
	return saleWare;
}

//添加商品空行
function addGoodRow(more){
	var lastEditRowIndex;
	var saleWare = buildSaleWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',saleWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',saleWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = saleWare;
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
					var goodName = data.goodName;//商品名称
					if(goodName){
						row.name = goodName;
					}
					var goodTypeName = data.goodTypeName;//商品类别
					if(goodTypeName){
						row.goodTypeName = goodTypeName;
					}
					var wareSpecificationVal = data.wareSpecificationVal;//商品规格
					if(wareSpecificationVal){
						row.wareSpecificationVal = wareSpecificationVal;
					}
					var goodPrice = data.price;//商品价格
					if(goodPrice){
						row.goodPrice = goodPrice;
					}
					var money = data.money;//商品总价
					if(money){
						row.money = money;
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
    orderNumber: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="orderNumber"/>';
            var input = $(html).appendTo(container);
            input.numberbox(options);
        	input.keydown(function(e){
				if(e.keyCode==13){
				   computeMoney(input);
				}
        	});
        	input.change(function(){
				computeMoney(input);
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
     //重写优惠金额字段的编辑展示
    priceDiscount: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" />';
            var input = $(html).appendTo(container);
            input.numberbox(options);
        	input.keydown(function(e){
				if(e.keyCode==13){
					warePriceDiscount(input);
				}
        	});
        	input.change(function(){
        		warePriceDiscount(input);
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
	//配送费用
	var deliveryFee = $('#deliveryCost').val();
	if(deliveryFee !=''){
		orderMoney = parseFloat(orderMoney) + parseFloat(deliveryFee);
	}
	orderMoney = orderMoney.toFixed(2);
	$('#moneyAccount').val(orderMoney);
}
//计算金额
function computeMoney(obj){
	//获取datagrid的数据变化
	//$(gId).datagrid('acceptChanges');
	var number = obj.val();
	if(number && ''!=number){
		number = Number(number);
	}else{
		number = 0;
	}
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	//总价 = 单价 ×数量
	var goodPrice = rowData.goodPrice;//单价
	if(goodPrice && ''!=goodPrice){
		goodPrice = Number(goodPrice);
	}else{
		goodPrice = 0;
	}
	var priceDiscount = rowData.priceDiscount;
	if(priceDiscount && ''!=priceDiscount){
		priceDiscount = Number(priceDiscount);
	}else{
		priceDiscount = 0;
	}
	rowData.priceDiscount = priceDiscount;
	var money = number * goodPrice - priceDiscount;//金额
	rowData.money = money;
	reEdit(rowIndex);
	flushMoney();
}
//计算单个货品的优惠金额
function warePriceDiscount(obj){
	var priceDiscount = $(obj).val();
	if(priceDiscount && ''!=priceDiscount){
		priceDiscount = Number(priceDiscount);
	}else{
		priceDiscount = 0;
	}
	var row = getEditingRow();//当前编辑行
	var rowData = row.rowData;
	var rowIndex = row.rowIndex;
	var money = rowData.goodPrice * rowData.orderNumber;//总价
	if(money && ''!=money){
		money = Number(money);
	}else{
		money = 0;
	}
	money = money - priceDiscount;
	rowData.money = money;
	rowData.priceDiscount = priceDiscount;
	reEdit(rowIndex);
	flushMoney();
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

//选择客户
function selectCustomer(){
	var data = common.getCustomer();
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
		$('#linkman').val(data.linkman);
		$('#mobile').val(data.mobile);
		$('#telephone').val(data.telephone);
		$('#areaIds').val(data.areaIds);
		$('#areaNames').val(data.areaNames);
		$('#street').val(data.street);
		$('#zipCode').val(data.zipCode);
		$('#email').val(data.email);
	}
}

//配送费用
function selectDeliveryFee(obj){
	var deliveryId = $(obj).val();
	if(deliveryId != ''){
		var deliveryFee = $('#'+deliveryId).val();
		deliveryFee = parseFloat(deliveryFee);
		deliveryFee = deliveryFee.toFixed(2);
		$('#deliveryCost').val(deliveryFee);
	}else{
		$('#deliveryCost').val('');
	}
	flushMoney();
}
//仓库
function selectWarehouse(){
	var warehouse = common.getWarehouse();
	if(warehouse){
		$('#warehouseId').val(warehouse.id);
		$('#warehouseName').val(warehouse.name);
	}
}
//确认退货
function comfirmReturn(){
	$("#returnState").val('1');
	submitSaveForm();
	return;
	//后面的不确定功能，暂略
	var id=$('#id').val();
	if (confirm("您确定要执行此操作吗?")){
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/saleReturn!updateReturnSate.do",
			  data: "saleReturn.id="+id,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("操作成功！");
						window.parent.addTab('销售退货单',ctx+'/saleReturn!list.do');
					}else if(returnDatas=='false'){
						alert("操作失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});
		}


}

//审核
function comfirmState(){
    if(confirm("确认退货吗?")){
	 $("#state").val('s');
	 $("#returnState").val('2');
	 submitSaveForm();
	}
}
