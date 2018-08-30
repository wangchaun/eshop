var gId = '#dataGrid';
var currentSelectRowIndex;//当前选中行下标
var lastEditRowIndex;//最后编辑的行下标
var contentEditor = '';


/**
 *加载所有数据
 */
$(document).ready(function(){
	contentEditor = CKEDITOR.replace('intro', addUploadButton(this));
	$('#promoteGoodForm').submit(function(){
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
	//为图片路径绑定事件
	$('.picPath').bind({
		propertychange:function(event){
			var obj = event.currentTarget;
			showPic(obj);
		}
	});
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
	

});

//显示图片
function showPic(obj){
	var picPath = $(obj).val();
	var parent = $(obj).parent();
	//父类的同辈元素
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
	}
	$(parent).append('<img id="pic" border="0" src="'+ctx+picPath+'" width="130px" height="130px"/> &nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>');
}
//删除图片
function deletePic(obj){
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
	}
	$(obj).remove();
}


//上传图片
function addUploadButton(editor){
   CKEDITOR.on('dialogDefinition', function(ev){
       var dialogName = ev.data.name;
       var dialogDefinition = ev.data.definition;
       if ( dialogName == 'image' ){
           var infoTab = dialogDefinition.getContents('info');
           infoTab.add({
               type : 'button',
               id : 'upload_image',
               align : 'center',
               label : '上传',
               onClick : function(evt){
                   var thisDialog = this.getDialog();
                   var txtUrlObj = thisDialog.getContentElement('info', 'txtUrl');
                   var txtUrlId = txtUrlObj.getInputElement().$.id;
                   addUploadImage(txtUrlId);
               }
           }, 'browse'); //place front of the browser button
       }
   });
}
function addUploadImage(theURLElementId){
   var url = ctx+"/FileUpload!edit.do?appType=promotePic";
   var relativeUrl = window.showModalDialog(url);  //这是我自己的处理文件/图片上传的页面URL
   //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
   //更多window.showModalDialog的使用方法参考
   var urlObj = document.getElementById(theURLElementId);
   if(relativeUrl){
   		urlObj.value = ctx+relativeUrl;
   }
   urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
}

//工具条
function getToolBarOpt(){
	var opt = [
		{	
			text:'添加优惠商品',
	 		iconCls:'icon-add',
	 		handler:function(){
	 			addPromoteGood(true);
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
		{field:'goodId',title:'商品编号',width:10,align:'left'},
		{field:'id',title:'',width:0,align:'left'},
		{field:'goodName',title:'商品名称',width:15,align:'left',editor:'goodName'},
		{field:'priceMarket',title:'市场价',width:10,align:'left',editor:'priceMarket'},
		{field:'pricePromote',title:'促销价',width:10,align:'left',editor:'pricePromote'}	
	];
	return opt;
}

//Json加载数据路径
function getUrlOpt(){
	var id = $("#id").val();
	var url = '';
	if(id != ''){
		url = ctx+'/PromoteGood_json!listJson.do?promoteGood.promoteId='+id;
	}
	return url;
}	
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}


//确认
function confirmpromote(){
	$('#state').val('s');
	submitSaveForm();
}


//提交orderForm表单
function submitSaveForm(){
	//获取图片id
	var appIds = [];
	//产品详情
	var content = $('#intro');//textarea对象
	var contentHtml = contentEditor.document.getBody().getHtml();
	content.val(contentHtml);
	totalHtml = contentHtml ;
	var htmlObj = $(totalHtml).find('img');
	$(htmlObj).each(function(){
		var imgSrc = this.src;
		var lastIndex1 = imgSrc.lastIndexOf('.');
		var lastIndex2 = imgSrc.lastIndexOf('/');
		var appId = imgSrc.substring((lastIndex2+1),lastIndex1);
		appIds.push(appId);
	});
	var imgIdStr = appIds.join(',');
	$('#imgIdStr').val(imgIdStr);
	
	if(checkForm()){

		$(gId).datagrid('acceptChanges');//提交修改到json数据集合
		var promoteGoodArr = $(gId).datagrid('getData').rows;//获取json数据集合
		
		if(promoteGoodArr){
			var htmlAll = '';
			var length = promoteGoodArr.length;
			for(var i=0;i<length;i++){
				var promoteGood = promoteGoodArr[i];
				var goodIdHtml = '<input type="hidden" name="goodIdArr" value="'+promoteGood.goodId+'" />'; 						
				var goodNameHtml = '<input type="hidden" name="goodNameArr" value="'+promoteGood.goodName+'" />'; 							
				var priceMarketHtml = '<input type="hidden" name="priceMarketArr" value="'+promoteGood.priceMarket+'" />'; 						
				var pricePromoteHtml = '<input type="hidden" name="pricePromoteArr" value="'+promoteGood.pricePromote+'" />';
				htmlAll += '<tr>' + goodIdHtml + goodNameHtml + priceMarketHtml + pricePromoteHtml + '</tr>'; 
			}
		}
		var promoteGoodTable = $('#promoteGoodTable');//订单商品项数据区
		promoteGoodTable.html(htmlAll);
		var options = {
			url : ctx+'/promote!save.do',
			async : false,
			type : 'post',
			success : function(returnData){
				if(returnData=='true'){
					alert('保存成功!');
					window.parent.addTab('促销单',ctx+'/promote!list.do');
				}else{
					alert('保存失败');
				}
			},
			
			error : function(){
				alert('系统错误');
			}
		};
		$('#promoteGoodForm').ajaxSubmit(options);
	}
}
//表单验证
function checkForm(){
	var titleVal = $("#subject").val();
	if(titleVal == ''){
		alert('请输入专题主题!');
		$("#subject").focus();
		return false;
	}
	var creatorNameVal = $("#pricePromote").val();
	if(creatorNameVal == ''){
		alert('请输入促销价!');
		 $("#pricePromote").focus();
		return false;
	}
	return true;
}

//获取一个新的
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

//
function addPromoteGood(more){
	var dataArr = new Array();
	dataArr = common.getGoods(true);
	if(dataArr && more){
		var rows = $(gId).datagrid('getRows'); //所有行
		var dataLen = dataArr.length;
		for(var i=0;i<dataLen;i++){
			var data = dataArr[i];	
			var code = data.code;//商品编码
			var isExist = isGoodExist(code);//商品是否已存在	
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
						if(rows[j].goodId == null || rows[j].goodId == ''){
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
					var id = data.id;		//商品Id
					if(id){
						row.id = id;
					}
					var goodName = data.name;    //商品名称
					if(goodName){
						row.goodName = goodName;
					}
					var goodId = data.id;		//商品Id
					if(goodId){
						row.goodId = goodId;
					}
					var priceMarket = data.priceMarket;					//账号
					if(priceMarket){
						row.priceMarket = priceMarket;
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
	pricePromote: {
    	//列由显示转编辑时的初始化方法
        init: function(container, options){        
        	var html = '<input type="text" class="datagrid-editable-input" name="pricePromote"/>';
        
            var input = $(html).appendTo(container);
            input.numberbox(options);
            input.change(function(){
            	var pricePromote = input.val();
            	if(pricePromote && ''!=pricePromote){
            		pricePromote = Number(pricePromote);
            	}else{
            		priceDiscount = 0;
            	}
            	var row = getEditingRow();//当前编辑行
            	var rowData = row.rowData;
            	var rowIndex = row.rowIndex;
            	rowData.pricePromote = pricePromote;
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
function isGoodExist(code){
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

//选择栏位
function fun(){
	var dateArr=window.showModalDialog(ctx+"/promotecolumn!list.do?todo=show",'',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dateArr!=null){
		$("#columnNo").val(dateArr.columnNo);
		$("#columnName").val(dateArr.name);
		$("#describes").val(dateArr.describes);
		$(obj).focus();
	}else{
		alert('请选择一个栏位');
	}
}

//选择商品类别弹出窗
function selectType(){
    var url = ctx+'/goodType!list.do?todo=show';
	var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		if(dataArr.level=="1"){
			$("#goodTypeName").val(dataArr.typeName);
			$("#goodTypeId").val(dataArr.typeId);
			$(obj).focus();
		}else{
			alert("请选择商品大类");
		}
	}
}
