var introEditor = '';
var introWholesaleEditor = '';
var introDeliveryEditor = '';
var introafterSaleEditor = '';
var intropracticeGuidelinesFAQSEditor = '';

$(document).ready(function(){
//	updateTable();
	introEditor = CKEDITOR.replace('intro', addUploadButton(this));
	introWholesaleEditor = CKEDITOR.replace('introWholesale');
	introDeliveryEditor = CKEDITOR.replace('introDelivery');
	introafterSaleEditor = CKEDITOR.replace('afterSale');
	intropracticeGuidelinesFAQSEditor = CKEDITOR.replace('practiceGuidelinesFAQS');
	
	$('#goodForm').submit(function(){
		submitSaveForm();
		return false; 
	});
	//为图片路径绑定事件
	$('.picPath').bind({
		propertychange:function(event){
			var obj = event.currentTarget;
			showPic(obj);
		}
	});
	
	showAttr($('#goodKind'));
});
//提交表单
function submitSaveForm(){
	if(checkForm()){
		//获取图片id
		var appIds = [];
		//获取图片绝对路径;
		//产品详情
		var intro = $('#intro');//textarea对象
		var introHtml = introEditor.document.getBody().getHtml();
		intro.val(introHtml);
		//规格参数
		var introWholesale = $('#introWholesale');
		var introWholesaleHtml = introWholesaleEditor.document.getBody().getHtml();
		introWholesale.val(introWholesaleHtml);
		//包装清单
		var introDelivery  = $('#introDelivery');
		var introDeliveryHtml = introDeliveryEditor.document.getBody().getHtml();
		introDelivery.val(introDeliveryHtml)
		//售后保障
		var afterSale  = $('#afterSale');
		var introafterSaleEditorHtml = introafterSaleEditor.document.getBody().getHtml();
		afterSale.val(introafterSaleEditorHtml)
		//售后保障
		var practiceGuidelinesFAQS = $('#practiceGuidelinesFAQS');
		var intropracticeGuidelinesFAQSEditorHtml = intropracticeGuidelinesFAQSEditor.document.getBody().getHtml();
		practiceGuidelinesFAQS.val(intropracticeGuidelinesFAQSEditorHtml)
		
		totalHtml = introHtml + introWholesaleHtml + introDeliveryHtml + intropracticeGuidelinesFAQSEditorHtml;
		
		var htmlObj = $(totalHtml).find('img');
		
		$(htmlObj).each(function(){
			var imgSrc = this.src;
			var lastIndex1 = imgSrc.lastIndexOf('.');
			var lastIndex2 = imgSrc.lastIndexOf('/');
			var appId = imgSrc.substring((lastIndex2+1),lastIndex1);
			appIds.push(appId);
		});
		
		var price=$('#price').val();
		if(price==''){
			if (confirm("此商品未填写销售价格，是否要返回修改?")){
				return false;
			}
		}
		var priceMarket=$('#priceMarket').val();
		if(priceMarket==''){
			if (confirm("此商品未填写市场价格，是否要返回修改?")){
				return false;
			}
		}
		
		var isInventory=$('#isInventory').val();
		var priceGroupBuy=$('#priceGroupBuy').val();  
		if(isInventory!='0'){
			if(priceGroupBuy=='' || priceGroupBuy=='0.00'){
				if (confirm("此商品未填写团购/抢购/秒杀价格，是否要返回修改?")){
					return false;
				}
			}
			var beginTime=$('#beginTime').val();
			var endTime=$('#endTime').val();
			if(beginTime==''){
				if (confirm("此商品未填写此活动商品开始时间，是否要返回修改?")){
					return false;
				}
			}else if(endTime==''){
				if (confirm("此商品未填写此活动商品结束时间，是否要返回修改?")){
					return false;
				}
			}
		}
		var codeVal = $("#code").val();
		if(codeVal==''){
			if (confirm("此商品编号未填写，是否要返回修改?")){
				return false;
			}
		}
		
		var imgIdStr = appIds.join(',');
		$('#imgIdStr').val(imgIdStr);

		var options = {
			url : ctx+'/good!save.do',
			async: false,
			cache: false,
			type : 'POST', 
			//timeout : 10000,
			success : function(returnData){
			   
				if(returnData == 'true'){
					alert('保存成功!');
					window.parent.addTab('商品列表',ctx+'/good!list.do');
				}else{
					alert(returnData+'保存失败!');
				}
			},
			error : function(){
				alert('系统错误!');
			} 
		};
		$('#goodForm').ajaxSubmit(options); 
		return false;
	}

}
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
/*
//删除图片
function deletePic(obj){
	var pic = $("#pic"+obj)[0].src;
	//如果存在图片就删除
	if(pic != ''){
		$("#pic"+obj).remove();
	}
	$("#pic"+obj).remove();
	$("#fileUploadId"+obj).val('');
	$("#picPath"+obj).val('');
}*/


//删除图片
function deletePic(obj){
	var pic = $(obj).siblings("#pic");
	//如果存在图片就删除
	if($(pic) != ''){
		$(pic).remove();
		$(obj).siblings("#fileUploadId").val('');
	}
	$(obj).remove();
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
function selectWarehousePosition(){
	var warehouseName=$('#warehouseName').val();
	if(warehouseName==null||warehouseName=='')alert('请选择仓库');
	else WarehousePosition();
}
 
//仓位
function WarehousePosition(){	
	var warehousePosition = common.getWarehousePosition();
	if(warehousePosition){
		$('#warehousePositionId').val(warehousePosition.id);
		$('#warehousePositionName').val(warehousePosition.name);
	}
}

//检查表单
function checkForm(){
	var nameVal = $("#name").val();
	if(nameVal == ''){
		alert('请输入商品名!');
		$("#name").focus();
		return false;
	}
	var goodTypeNameVal = $("#goodTypeName").val();
	if(goodTypeNameVal == ''){
		alert('请选择商品类别!');
		 $("#goodTypeName").click();
		return false;
	}
	var priceVal = $("#price").val();
	if(priceVal == ''){
		alert('请输入销售价!');
		$("#price").focus();
		return false;
	}
	var initialNum = $('#initialNum').val();
	if(initialNum == ''){
		alert('请输入初始数量!');
		$('#initialNum').focus();
		return false;
	}
	
	return true;
}

//选择商品类别弹出窗
function selectType(obj){
    var url = ctx+'/goodType!list.do?todo=show';
	var obj = $(obj);
	var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		$(obj).val(dataArr.typeName);
		$("#goodTypeId").val(dataArr.typeId);
		$(obj).focus();
	}
}
//选择商品品牌
function selectBrand(obj){
	var goodTypeId=$('#goodTypeId').val();
	if(goodTypeId != ''){
		var obj = $(obj);
		var url = ctx+'/goodBrand!list.do?todo=show&goodBrand.id='+goodTypeId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr!=null){
			$(obj).val(dataArr.brandName);
			$("#brandId").val(dataArr.brandId);
			$(obj).focus();
		}
	}else{
		alert('请先选择商品类型！');
		return;
	}
}

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
   var url = ctx+"/FileUpload!edit.do?appType=GoodExtend";
   var relativeUrl = window.showModalDialog(url);  //这是我自己的处理文件/图片上传的页面URL
   //在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
   //更多window.showModalDialog的使用方法参考
   var urlObj = document.getElementById(theURLElementId);
   if(relativeUrl){
   		urlObj.value = ctx+relativeUrl;
   }
   urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片
}
//其他价格设置的前台显示复选框
function clickBox(obj){
	//获取同辈input框
	var stateObj = $(obj).siblings("input[name='stateArr']");
	if($(stateObj).val() == '0'){
		$(stateObj).val('1');
	}else{
		$(stateObj).val('0');
	}
}
//种类属性设置
function showAttr(obj){
	var kindId = $(obj).val();
	$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/goodAttr!getAttrList.do",
			  data: "goodAttr.goodKindId=" + kindId,
			  success : function(returnData){ 
					if(returnData == 'false'){
						alert('加载属性列表错误');
					}else{
						var returnText = returnData.split('------');
						$('#attrList').empty();
						$('#attrList').append(returnText[0]);
						
						//为日期类型添加点击事件
						var dateTypeIdStr = returnText[1];
						var dateTypeIds = dateTypeIdStr.split(",");
						var i = 0;
						for(i in dateTypeIds){
							if(dateTypeIds[i] != ''){
								$("#"+dateTypeIds[i]).bind({
									click:function(event){
										WdatePicker({dateFmt:'yyyy-MM-dd'});
									}
								});
							}
						}
						showAttrValue();
					}
				},
				error : function(){
					alert('系统错误!');
			 	} 
		});
}
//属性值
function showAttrValue(){
	var attrIdStr = $('#goodAttrIdStr').val();
	if(attrIdStr != ''){
		var attrIds = new Array();
		attrIds = attrIdStr.split(',');
		var i = 0;
		for(i in attrIds){
			if(attrIds[i] != ''){
				var attrVal = $('#hidden'+attrIds[i]).val();
				$('#'+attrIds[i]).val(attrVal);
			}
		}
	}
}
//选择商品属性值
function selectattrValueArr(value){
	var str='';
	var a=$('#goodAttrValStr').val();
	if(a==''){
		str =value;
	}else{
		str +=a+','+value;
	}
	$('#goodAttrValStr').val(str);
}

//清空商品属性值
function removeProp(){
	$('#goodAttrValStr').val('');
	alert('清除成功！');
	
}



//规格列表
function showSpecification(){
	url = ctx +'/good!listSpecification.do';
	var returnVal =window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:400px");
	if(returnVal && returnVal != ''){
		$('#wareList').empty();
		$('#wareList').append(returnVal);
	}
	$('.deleteWare').bind({
		click:function(event){
			deleteWare(this);
		}
	});
	
}

//增加的规格列表
	function showSpecification2(){
	url = ctx +'/good!listSpecification.do';
	var returnVal =window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:400px");
	if(returnVal && returnVal != ''){
		$('#wareList2').empty();
		$('#wareList2').append(returnVal);
	}
	$('.deleteWare').bind({
		click:function(event){
			deleteWare(this);
		}
	});
	
}
//删除货物
function deleteWare(obj){
	var trObj = $(obj).parent().parent();
	$(trObj).remove();
}
//相关商品
function addGoodRelate(){
	var dataArr = new Array();
	dataArr = common.getGoods(true);
	if(dataArr){
		var html = '';
		var goodId = $('#id').val();
		//已经存在商品的id
		var goodRelateIdStr = $('#goodRelateIdStr').val();
		var goodRelateIds = new Array(); 
		goodRelateIds = goodRelateIdStr.split(',');
		
		for(var i=0;i < dataArr.length;i++){
			var isExist = false;
			for(var j=0;j < goodRelateIds.length;j++){
				if(dataArr[i].id == goodRelateIds[j]){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				if(goodId != dataArr[i].id){
					html +=  '<tr>';
					var goodIdHtml = '<input type="hidden" name="goodRelateIdArr" value="'+dataArr[i].id+'" />';
					var addHtml = '<td class="gridbody" style="text-align: center;">' +
							'<a href="javascript:void(0);" onclick="deleteGoodRelate(this)">删除</a></td>'
					var codeHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].code+'</td>';
					var nameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].name+'</td>';
					var goodTypeNameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].goodTypeName+'</td>';
					var brandNameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].brandName+'</td>';
					var priceHtml =  '<td class="gridbody" style="text-align: center;">'+dataArr[i].price+'</td>';
					html = html + goodIdHtml + addHtml + codeHtml + nameHtml + goodTypeNameHtml + brandNameHtml + priceHtml;
					html += '</tr>'; 
					goodRelateIdStr += ',' +dataArr[i].id;
					$('#goodRelateIdStr').val(goodRelateIdStr);
				}else{
					alert("不能关联自己")
				}
			}else{
				alert('商品已存在，商品编号：'+dataArr[i].code);
			}
		}
		$('#goodRelateList').append(html);
	}
}
//组合商品
function addGoodCompose(){
	var dataArr = new Array();
	dataArr = common.getGoods(true);
	if(dataArr){
		var html = '';
		var goodId = $('#id').val();
		//已经存在商品的id
		var goodComposeIdStr = $('#goodComposeIdStr').val();
		var goodComposeIds = new Array(); 
		goodComposeIds = goodComposeIdStr.split(',');
		
		for(var i=0;i < dataArr.length;i++){
			var isExist = false;
			for(var j=0;j < goodComposeIds.length;j++){
				if(dataArr[i].id == goodComposeIds[j]){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				if(goodId != dataArr[i].id){
					html +=  '<tr>';
					var goodIdHtml = '<input type="hidden" name="goodComposeIdArr" value="'+dataArr[i].id+'" />';
					var addHtml = '<td class="gridbody" style="text-align: center;">' +
							'<a href="javascript:void(0);" onclick="deleteGoodCompose(this)">删除</a></td>'
					var codeHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].code+'</td>';
					var nameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].name+'</td>';
					var goodTypeNameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].goodTypeName+'</td>';
					var brandNameHtml = '<td class="gridbody" style="text-align: center;">'+dataArr[i].brandName+'</td>';
					var priceHtml =  '<td class="gridbody" style="text-align: center;">'+dataArr[i].price+'</td>';
					var priceDiscountHtml =  '<td class="gridbody" ><input type="text" style="text-align: center;" size="10" name="goodComposePriceDisArr"/></td>'; 
					html = html + goodIdHtml + addHtml + codeHtml + nameHtml + goodTypeNameHtml + brandNameHtml + priceHtml + priceDiscountHtml;
					html += '</tr>';
					goodComposeIdStr += ',' +dataArr[i].id;
					$('#goodComposeIdStr').val(goodComposeIdStr);
				}else{
					alert("不能组合自己")
				}
			}else{
				alert('商品已存在，商品编号：'+dataArr[i].code);
			}
		}
		$('#goodComposeList').append(html);
	}
}
//删除商品
function deleteGoodRelate(obj){
	//获取父级元素
	var parentObj = $(obj).parent().parent();
	//获取关联商品id
	var relateGoodId = $(parentObj).find("input[name='goodRelateIdArr']").val();
	//已经存在商品的id
	var goodRelateIdStr = $('#goodRelateIdStr').val();
	//去掉关联商品的id
	goodRelateIdStr = goodRelateIdStr.replace(relateGoodId,'');
	$('#goodRelateIdStr').val(goodRelateIdStr);
	
	$(parentObj).remove();
}
//删除组合商品
function deleteGoodCompose(obj){
	//获取父级元素
	var parentObj = $(obj).parent().parent();
	//获取组合商品id
	var composeGoodId = $(parentObj).find("input[name='goodComposeIdArr']").val();
	//已经存在商品的id
	var goodComposeIdStr = $('#goodComposeIdStr').val();
	//去掉组合商品的id
	goodComposeIdStr = goodComposeIdStr.replace(composeGoodId,'');
	$('#goodComposeIdStr').val(goodComposeIdStr);
	
	$(parentObj).remove();
}


//供应商
function selectSupplier(){
	var supplier = common.getSupplier();
	if(supplier){
		$('#supplierId').val(supplier.id);
		$('#supplierName').val(supplier.name);
	}
}

//判断是否限时抢购商品
function ChekeisQgGood(){
    
    var names= "'yyyy-MM-dd'";
  
    var name= 'onclick="WdatePicker({dateFmt:'+names+'})"';
  
   var html = "	<td  class='gridtitle'>下架时间:</td><td class='gridbody' colspan='3'><input type='text' readonly='true' name='good.endSaleTime' id='endSaleTime' "+name+" /></td>";
   
   if($('#property').val() == "6"){
   
     $('#hideTr').html(html);
   }else{

     $('#hideTr').html('');
   }

}

//根据地区设置不同价格
//function AreaOfPrice(){
//	var htmlText="<tr><td class='gridtitle'  width='10%'>区域</td><td class='gridbody'>";
//		htmlText+="<input type='hidden' name='areaIdArr'/><input type='text' name='areaNameArr' onclick='selectArea()'/>";
//		htmlText+="</td><td  class='gridtitle'  width='10%'>价格</td><td class='gridbody'>";
//		htmlText+="<input type='text' name='priceArr'/></td>";
//		htmlText+="<td class='gridtitle' width='10%'>属性</td>";
//		htmlText+="<td class='gridbody'><select name='propertyArr'>"
//		htmlText+="<option value=''>-- 请选择商品属性 --</option>";
//		//htmlText+="<option value='1'>疯狂抢购</option>";
//		htmlText+="<option value='2'>热卖商品</option>";
//		htmlText+="<option value='3'>热评商品</option>";
//		htmlText+="<option value='4'>新品上架</option>";
//		htmlText+="<option value='5'>猜您喜欢</option>";
//		//htmlText+="<option value='6'>限时抢购</option>";
//		htmlText+="<option value='7'>自定义商品</option>";
//		htmlText+="<option value='8'>最新降价</option>";
//		htmlText+="<option value='9'>今日推荐</option>";
//		htmlText+="</select></td><td class='gridtitle' width='10%'>自定义标签</td>";
//		htmlText+="<td class='gridbody'><input type='text' name='tagArr' />";
//		htmlText+="</td><input type='hidden' name='stateArr' value='s'/><td class='gridtitle' width='10%'>";
//		htmlText+="<a href='javascript:void(0)' onclick='removeRow(this.parentNode.parentNode)'>删除</a></td></tr>";
//	$('#pricetab').append(htmlText);	
//	updateTable();
//}

//删除地区价格
//function removeRow(obj){
//	var Node = obj.parentNode;
//	Node.removeChild(obj);
//	updateTable();
//}

//选择地区
function selectArea(obj){
	var data = common.getArea();
	if(data){
		var objId=$(obj).attr('id');
		var iq=$(obj).attr('id').substring(6);
		var id=Number(iq-1);
		$("#price_"+id).val(data.id);
		$(obj).val(data.name);
	}
}

//改变地区价格中table元素id
//function updateTable(){
//	var objs=document.getElementById("pricetab").getElementsByTagName("input"); 
//	for(i=0;i<objs.length;i++){
//		objs[i].id="price_"+i;
//	}
//}

//改变活动商品的文本框状态
function changeValue(vals){ 
	if(vals!=''){   
		if(vals=='0' || vals=='4'){   //普通是则禁用
			$('#priceGroupBuy').attr("disabled",true);
			$('#totalNum').attr("disabled",true);
			$('#beginTime').attr("disabled",true);
			$('#endTime').attr("disabled",true);
		}else {     //活动商品则启用
			 $('#priceGroupBuy').removeAttr("disabled");
			 $('#totalNum').removeAttr("disabled");
			 $('#beginTime').removeAttr("disabled");
			 $('#endTime').removeAttr("disabled");
//			 document.getElementById("groupBuy").style.display='block';
//			 $("groupBuy").css("display","block");
			 
		}
	}
}

function checkeCode(vals){
	if(vals!=''){
		var options = {
			url : ctx+'/good!checkeCode.do?good.code='+vals,
			async: false,
			cache: false,
			type : 'POST', 
			//timeout : 10000,
			success : function(returnData){
				if(returnData == 'true'){
					return;
				}else{
					alert('此商品编号已存在，请重新输入!');
					$('#code').val('');
					return false;
				}
			},
			error : function(){
				alert('系统错误!');
			} 
		};
	}
}


