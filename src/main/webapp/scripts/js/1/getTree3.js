$(document).ready(function(){
		$('#warehouse').val('');
		$('#goodtypes').val('');
		$('#brands').val('');
		$('#selvalprice').val('');
		$('#minprice').val('');
		$('#maxprice').val('');
		getWarehouse();
		saveconditions('');
		var pageIndex = $('#pageIndex').val();
		init(pageIndex);
	}
);
/**
 * 分页
 * 默认加载
 * @param {Object} pagenumber
 */
function init(pagenumber){
	var pagecount = $("#pageCount").val();//总页数
	var totalcount = $("#count").val();//记录数
	var data = {'pagecount':pagecount,'totalcount':totalcount};
	//底部分页
	$("#pagerBot").pager({ pagenumber: pagenumber, pagecount:data.pagecount,totalcount:data.totalcount, buttonClickCallback: PageClick});
}
/**
 * 回调函数
 * @param {Object} pageclickednumber
 */
PageClick = function(pageclickednumber) {
	init(pageclickednumber);
	var apptype = $("#apptype").val();
	saveconditions(pageclickednumber);
}

//
function selware(){
	
}

//显示仓库
//function getWarehouse(){
// var num= 1;
// var textHtml = "<a onclick=lookCK('','');>全部</a>&nbsp;&nbsp;&nbsp;&nbsp;";
// $.ajax({
//		  type: "POST",
//		  dataType:"json",   //返回数据类型是JSON数据格式 
//		  async: false,
//		  cache: false,
//		  url: ctx+"/getWarehouseList.do",
//		  success : function(returnData){ 
//		  	  $('#WarehouseHtml').empty();
//		      $.each(returnData,function(Warehouse,warehouse){
//		      if(num <=10){
//		      	textHtml+= "<a onclick=lookCK('"+warehouse.id+"','"+warehouse.name+"');>"+warehouse.name+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";
//			    num++;
//		      }
//		      });
//		      $('#WarehouseHtml').append(textHtml);
//			},
//			error : function(){
//				alert('系统繁忙!');
//		 	}
//	},"json");
//}

//专属三级页面类别的显示与隐藏
function getsearchlog(TypeTree){
  	var Type=$('#'+TypeTree).attr("class");
  	if(Type=="item fore hover"){
  		$('#'+TypeTree).attr("class","item");
  	}else{
  		$('#'+TypeTree).attr("class","item fore hover");
  	}
}

function salPrice(){
	var salmin=$('#salmin').val();
	var salmax=$('#salmax').val();
	searselect('minprice',salmin);
	searselect('maxprice',salmax);
}

function lookCK(valueId,valueName){
	$('#warehouse').val(valueId);
	$('#ckss').empty();
	if(valueName==null||valueName==''){
		valueName="全部";
	}	
	$('#ckss').append(valueName);
	saveconditions('');
}


function searselect(id,value){  alert(id+'                '+value);
	if(id!=''&&id!='selvalprice'){
		$('#'+id).val(value);
	}
	if(id=='goodtypes'){
		$('#goodTypeId').val('');
	}
	if(id!=''&&id=='selvalprice'){
		if(value=='0'){
			$('#minprice').val(0);
			$('#maxprice').val(150);
		}
		if(value=='151'){
			$('#minprice').val(151);
			$('#maxprice').val(860);
		}
		if(value=='861'){
			$('#minprice').val(861);
			$('#maxprice').val(5000);
		}
		if(value=='5001'){
			$('#minprice').val(5001);
			$('#maxprice').val(10000);
		}
		if(value=='10001'){
			$('#minprice').val(10001);
			$('#maxprice').val('');
		}
		if(value==''){
			$('#minprice').val('');
			$('#maxprice').val('');
		}
	}
//	saveconditions('');
	
}

function getUrl(pageIndex){
	var brands=$('#brands').val();
	var goodtypes=$('#goodtypes').val();
	var goodTypeId=$('#goodTypeId').val();
	var selvalprice=$('#selvalprice').val();
	var minprice=$('#minprice').val();
	var maxprice=$('#maxprice').val();
	var warehouse=$('#warehouse').val();
	var sorter=$('#sorter').val();
	var url=ctx+'/product.do?1=1';
	if(brands!=''){
		url+='&good.brandId='+brands;
	}
	if(goodtypes==''||goodTypeId!=''){
		url+='&good.goodTypeId='+goodTypeId;
	}
	if(goodtypes!=''){
		url+='&good.goodTypeId='+goodtypes;
	}
	if(minprice!=''){
		url+='&good.minprice='+minprice;
	}
	if(maxprice!=''){
		url+='&good.maxprice='+maxprice;
	}
	if(warehouse!=''){
		url+='&good.warehouseId='+warehouse;
	}
	if(sorter!=''){
		url+='&good.'+sorter+'=str';
	}
	if(pageIndex!=''){
		url +="&pageInfo.pageIndex="+pageIndex;
	}
	return url;
}

function saveconditions(pageIndex){
 	var num= 1;
 	var textHtml="";
	$.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: getUrl(pageIndex),
		  success : function(returnData){ 
		  	  var data=returnData.pageInfo;
		  	  $('#count').val(data.count);
		  	  $('#pageSize').val(data.pageSize);
		  	  $('#pageCount').val(data.pageCount);
		  	  
		  	  $('#totle').empty();
		  	  $('#dnf1').empty();
		  	  $('#dnf2').empty();
		  	  $('#dfedd').empty();
		  	  $('#goodLists').empty();
		  	  
		  	  $('#totle').append("<span>共<strong>"+data.count+"</strong>个商品</span>" );
		  	  $('#pageIndex').val(data.pageIndex);
		  	  
		  	  textHtml="全部结果&nbsp;&gt;&nbsp;<strong>"+returnData.goodTypeName+"</strong>";
		  	  $('#dnf1').append(textHtml);
		  	  
		  	  if(returnData.rows.length>0){
		  	  
		  	  textHtml="<h1>"+returnData.goodTypeName+"<strong>找到"+returnData.rows.length+"件相关商品</strong></h1>";
		  	  $('#dnf2').append(textHtml);
		  	  
		  	  textHtml="<span class='text'>";
		  	  textHtml+=data.pageIndex+"/"+data.pageCount+"</span>"
		  	  if(data.pageIndex<2){
		  	  	textHtml+="<span class='prev-disabled'>上一页<b></b></span>";
		  	  }else{
		  	  	textHtml+="<a onclick='saveconditions("+(data.pageIndex-1)+");' href='#' class='next'>上一页<b></b></a>";
		  	  }
		  	  if(data.pageIndex<data.pageCount){
				textHtml+="<a onclick='saveconditions("+(data.pageIndex+1)+");' href='#' class='next'>下一页<b></b></a>";
		  	  }else{
		  	  	textHtml+="<span class='prev-disabled'>下一页<b></b></span>";
		  	  }
		  	  $('#dfedd').append(textHtml);
		  	  textHtml="";
		  	  
		      $.each(returnData.rows,function(good,good){
		      if(num <=32){
		      	textHtml+="<li sku='655535'>";
          		textHtml+="<div class='p-img'><a target='_blank' href="+ctx+"/cpxq.do?good.id="+good.id+"><img width='160' height='160' data-img='1' src='"+ctx+good.pic+"'/></a></div>";
          		textHtml+="<div class='p-name'><a target='_blank' href="+ctx+"/cpxq.do?good.id="+good.id+"> <font class='skcolor_ljg'>"+good.brandName+"</font>"+good.name+"<font style='color:#ff0000' class='adwords' name='655535'>"+good.remark+"</font></a></div>";
          		textHtml+="<div class='p-price'><em></em><strong>"+good.price+"</strong><span id='p655535'></span></div>";
          		textHtml+="<div class='extra'><span class='star'><span class='star-white'><span class='star-yellow h4'>&nbsp;</span></span></span> <a target='_blank' href='cpxq.html' onclick='searchlog(1,655535,0,3)'>已有2538人评价</a> <span class='reputation'>(89%好评)</span> </div>";
          		textHtml+="<div class='btns'><a href='cpxq.html' target='_blank' class='btn-buy' onclick='seClick('SEO',QUERY_KEYWORD,'buy655535');searchlog(1,655535,0,4)'>加入购物车</a> <a id='coll655535' class='btn-coll' onclick='searchlog(1,655535,0,5)'>关注</a> <a class='btn-compare btn-compare-s' id='comp_655535' skuid='655535' onclick='searchlog(1,655535,0,6)'><span>对比</span></a> </div>";
        		textHtml+="</li>";
			    num++;
		      }
		      });
		      }
		      if(returnData.rows.length==0){
		      	textHtml="<h3 align='center'><font color='red'>没有找到您要搜索的商品</font></h3>";
		      }
		      $('#goodLists').append(textHtml);
		      	var pageIndex = $('#pageIndex').val();
				init(pageIndex);
		      
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");

}
 
function selware(){
	
}
