//一卡通付款
function paycard(orderId){
 
 //首先验证支付表单
 $.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: ctx+"/getZfbPayError.do",
		data: "orderId="+orderId,
		success : function(returnData){
					if(returnData == 'true'){
						window.open(ctx + '/paycard.do?orderId='+orderId);
					}else{
						alert("系统错误");
					}
				},
		error : function(){
			alert('系统错误!');
		} 
	});
}

$(document).ready(function(){
  //回调查询商品的方法
  saleReturnJson();
});


//显示退货商品数据
function saleReturnJson(){   
	var time=$('#createTime').val()
	var search=$('#search').val();
	var url=''; 
	if(time!=''){ 
		url +="&saleOrder.data="+time;
	}
	if(search!=''){ 
		url +="&saleOrder.search="+search;
	}
	
	var htmlText=""; 
	$('#table2').empty();
	$.ajax({   
			type: "POST",
			async: false,
			cache: false,
			url: ctx+"/tuihuanJsion.do",
			data : url,
			success : function(returnData){    
				rows=eval(returnData).rows;
				htmlText+="<table width='962' border='0' cellspacing='0' cellpadding='0' align='center'>";
				for(i=0;i<rows.length;i++){ 
					var order=rows[i];
					htmlText+="<tr><td width='110'  align='center' valign='middle' class='leftborder'>"+order.code+"</td>";
				    htmlText+="<td width='345' align='left' valign='middle'>";
				    for(j=0;j<order.warelist.length;j++){
					    htmlText+="<div class='phlist'>";
						htmlText+="<h1><input name='checkboxgood' type='checkbox' value='"+order.warelist[j].id+"'/></h1>";
						htmlText+="<h2><a href='"+ctx+"/cpxq.do?good.id="+order.warelist[j].goodId+"'><img src='"+order.warelist[j].goodPic+"' border='0' /></a></h2>";
					    htmlText+="<h3><a href='"+ctx+"/cpxq.do?good.id="+order.warelist[j].goodId+"'>"+order.warelist[j].goodName+"</a></h3></div>";
					}
					htmlText+="</td>";
				    htmlText+="<td width='302' align='center' valign='middle'></td>";
				    htmlText+="<td width='137' align='center' valign='middle'></td>";
				    htmlText+="<td width='90' align='left' valign='middle'><span class='cotrol'>2012-12-20 15:50</span></td>";
				    htmlText+="<td width='115' align='center' valign='middle'><input name='' type='button' class='applyfirstbtn1' onclick=applications('"+order.id+"')></td></tr>";
				}
				htmlText+="</table>"; 
				$('#table2').append(htmlText);	
			},
			error : function(){
				alert('系统错误!');
			}
		});
}

//跳转到退换货页面
function applications(id){
	var str=document.getElementsByName("checkboxgood");
	var objarray=str.length;
	var chestr="";
	for (i=0;i<objarray;i++)
	{
	  if(str[i].checked == true)
	  {
	   chestr+=str[i].value+",";
	  }
	}
	var url=ctx+"/application.do?saleOrder.id="+id;
	if(chestr!=''){
		url +="&saleWare.chestr="+chestr;
	}
	window.open(url);
}
//被选中的复选框 onclick=checkBox('"+order.goodlist[j].id+"')




//取消订单
function updateOrderState(id){
	if(id!=''){
		if (confirm("您确定要取消此订单吗?")){
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/updateOrderState.do",
			  data: "saleOrder.id="+id,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("取消订单成功！");
						window.location.reload();
					}else if(returnDatas=='false'){
						alert("取消订单失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});
		}
	}
}
//确认退换货
function updateReturnSate(id){
	if(id!=''){
		if (confirm("您确定要进行此操作吗?")){
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/updateReturnSate.do",
			  data: "saleReturn.id="+id,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("确认成功！");
						window.location.reload();
					}else if(returnDatas=='false'){
						alert("确认订单失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});
		}
	}
}





//银行付款		
function bankPay(orderId,bankCode){
	var url="";
	
	if(bankCode=='ZFB'){
		url=ctx+"/getZfbPayError.do";
	}else{
	
		url=ctx+"/getZfbPayError2.do";
	}
	$.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: url,
		data: "orderId="+orderId+"&bankCode="+bankCode,
		success : function(returnData){
					if(returnData == 'true'){
						if(bankCode=='ZFB'){
							window.open(ctx + '/alipayto.do?orderId='+orderId);
						}else{
							window.open(ctx + '/alipayto2.do?orderId='+orderId+"&bankCode="+bankCode);
						}
						
					}else{
						alert(returnData);
					}
				},
		error : function(){
			alert('系统错误!');
		} 
	});
}

//添加商品到购物车
 function addGoodToCart(id){
    
	if(id != ''){
		var url = ctx +"/addGoodseewareToCart.do?good.id="+id;
		url = encodeURI(encodeURI(url));
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				if(returnData=='true'){
				    alert("添加成功");
					shoppingCar(); 
				}
			},
			error : function(){
				alert('系统错误，添入如购物车失败!');
		 	}
		});
	}
}

//查询购物车层
function shoppingCar(){
     
	var htmlText="";
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
			url: ctx+"/getshoppingcar.do",
			success : function(returnData){
				var rowssize=eval(returnData).rowssize;
			    $('.ys3').html('<a href="'+ctx+'/ShoppingCar.do">购物车'+rowssize+'件</a>  | <a href="${ctx}/infor.do?information.type=6" >售后服务</a>   | <a href="${ctx}/infor.do?information.type=7">企业采购</a>	| <a href="${ctx}/infor.do?information.type=3">购物指南</a>');
			},
			error : function(){
				alert('系统错误!');
			}
		});
}
















