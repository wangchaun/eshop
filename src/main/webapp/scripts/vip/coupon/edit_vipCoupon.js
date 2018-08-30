var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标

/**
 *加载所有数据
 */
$(document).ready(function(){
	$('#vipCouponForm').submit(function(){
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
			text:'新增货物',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addVipCouponWare(true);
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
		{field:'wareId',title:'商品编号',width:5,align:'left'},
		{field:'wareName',title:'商品名称',width:15,align:'left'}
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#code").val();
	var url = '';
	if(id != ''){
		url = ctx+'/VipCouponWare_json!listJson.do?vipCouponWare.vipCouponId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//确认订单
function confirmPay(){
	$('#state').val('s');
	submitSaveForm();
}

//提交Form表单
function submitSaveForm(){
	if(checkForm()){
		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
		var vipCouponWareArr = $(gId).datagrid('getData').rows;//获取json数据集合
		
		if(vipCouponWareArr){
			var htmlAll = '';
			var length = vipCouponWareArr.length;
			for(var i=0;i<length;i++){
				var vipCouponWare = vipCouponWareArr[i];
				var wareIdHtml = '<input type="hidden" name="wareIdArr" value="'+vipCouponWare.wareId+'" />';
				var wareNameHtml = '<input type="hidden" name="wareNameArr" value="'+vipCouponWare.wareName+'" />'; 							
				htmlAll += '<tr>' + wareIdHtml + wareNameHtml +'</tr>'; 
			}
		}
		var vipCouponWareTable = $('#vipCouponWareTable');//订单商品项数据区
		vipCouponWareTable.html(htmlAll);
		var options = {
			url : ctx+'/vipCoupon!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('会员优惠劵',ctx+'/vipCoupon!list.do');
				}else{
					alert('保存失败');
				}
			},
			error : function(){
				alert('保存失败');
			}
		};
		$('#vipCouponForm').ajaxSubmit(options);
	}
}
//表单验证
function checkForm(){
	var vipLevelId = $('#vipLevelId').val();
	if(vipLevelId == ''){
		alert('请选择会员等级');
		return false;
	}
	
	var name = $('#name').val();
	if(name == ''){
		alert('请输入优惠劵名称');
		$('#name').focus();
		return false;
	}
	var money = $('#money').val();
	if(money == ''){
		alert('请输入优惠劵面值');
		$('#money').focus();
		return false;
	}
	var count = $('#count').val();
	if(count == ''){
		alert('请输入优惠劵数量');
		$('#money').focus();
		return false;
	}
	var startTime = $('#startTime').val();
	if(startTime == ''){
		alert('请选择活动的开始时间');
		$('#startTime').focus();
		return false;
	}
	var endTime = $('#endTime').val();
	if(endTime == ''){
		alert('请选择活动的结束时间');
		$('#endTime').focus();
		return false;
	}
	return true;
}

//获取一个新的空费用清单
function buildVipCouponWare(){
	var VipCouponWare = {};    	//清单
	
	VipCouponWare.id = '';				//优惠劵清单Id
	VipCouponWare.wareId = '';			//货物Id
	VipCouponWare.wareName = '';	    //货物名称
	return VipCouponWare;
}

//添加货物空行
function addVipCouponRow(more){
	var lastEditRowIndex;
	var VipCouponWare = buildVipCouponWare();//获取一个新的空商品项
	if(more){
		$(gId).datagrid('appendRow',VipCouponWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
		$(gId).datagrid('beginEdit', lastEditRowIndex);
	}else{
		$(gId).datagrid('endEdit', lastEditRowIndex);
		$(gId).datagrid('appendRow',VipCouponWare);
		lastEditRowIndex = $(gId).datagrid('getRows').length-1;
		$(gId).datagrid('selectRow', lastEditRowIndex);
	}
	var rowData = {};
	rowData.row = VipCouponWare;
	rowData.rowIndex = lastEditRowIndex;
	return rowData;
}

//付款清单
function addVipCouponWare(more){
	var dataArr = new Array();
	dataArr = common.getWare(true);
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];
			var id = data.id;
			var code = data.code;		   //货物编号
			var isExist = isWareExist(id);//货物编号是否已存在
			if(isExist){
				alert('货物已存在，id:'+data.id);
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
					rowData = addVipCouponRow(more);	//增加行
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
					var wareName = data.goodName;    //货物名称
					if(wareName){
						row.wareName = wareName;
					}
					var wareId = data.code;		//货物Id
					if(wareId){
						row.wareId = wareId;
					}
					$(gId).datagrid('endEdit',rowIndex);
					$(gId).datagrid('selectRow',rowIndex);
				}
			}
		}
	}
}

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
function isWareExist(id){
	var isExist = false;
	var rows = $(gId).datagrid('getRows');//末行的下标
	var rowLen = rows.length;
	for(var i=0;i<rowLen;i++){
		var data = rows[i];
		if(!data.isEditing){
			if(id == data.wareId){
				isExist = true;
				break;
			}
		}
	}
	return isExist;
}

// 选择客户
function selectCustomer(){
	var vipLevelId = $("#vipLevelId").val();
	var data;
	if(vipLevelId != null && vipLevelId !=""){
		var url = ctx+"/customers!list.do?todo=show&customer.vipLevelId="+vipLevelId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('只能选择一个客户!');
			}else{
				data = dataArr[0];
			}
		}
	}
	if(data){
		$('#customerId').val(data.id);
		$('#customerName').val(data.name);
	}
}

