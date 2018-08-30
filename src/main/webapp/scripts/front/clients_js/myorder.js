
$(document).ready(function(){
  //回调查询商品的方法
  saleOrderJson();
});




//显示我的订单数据
function saleOrderJson(){ 
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
			url: ctx+"/saleOrderJsion.do",
			data : url,
			success : function(returnData){    
				rows=eval(returnData).rows;
				htmlText+="<table width='962' border='0' cellspacing='0' cellpadding='0' align='center'>";
				for(i=0;i<rows.length;i++){  
					var order=rows[i];
					try{
						htmlText+="<tr><td width='100' align='center' valign='middle' class='leftborder tahlebottom'>"+order.code+"</td>";
						htmlText+="<td width='727' valign='top' class='tahlebottom'>";
						htmlText+="<table  width='727' border='0' cellspacing='0' cellpadding='0' class='tahlef1'>";
						for(j=0;j<order.warelist.length;j++){
							htmlText+="<tr><td width='312' height='45' align='left' valign='middle'>";
							htmlText+="<div class='phlist'>";
							htmlText+="<h2><a href='"+ctx+"/cpxq.do?good.id="+order.warelist[j].goodId+"'><img src='"+ctx+order.warelist[j].goodPic+"' border='0' /></a></h2>";
							htmlText+="<h3><a href='"+ctx+"/cpxq.do?good.id="+order.warelist[j].goodId+"'>"+order.warelist[j].goodName+"</a></h3>";
							htmlText+="</div></td>";
						    htmlText+="<td width='95' align='center' valign='middle'>"+order.customerName+"</td>";
						    htmlText+="<td width='90' align='center' valign='middle'><span class='ys1'><span>¥</span>"+order.warelist[j].money+"<br />"+order.paymentName+"</span></td>";
						    htmlText+="<td width='90' align='center' valign='middle'><div class='ys3'>"+order.createTime+"</div></td>";
						    htmlText+="<td width='90' align='center' valign='middle'>";
						    if(order.paymentState=='1'&&order.deliveryState=='0'){
								htmlText+="已付款";
							}else if(order.paymentState=='1'&&order.deliveryState=='1'){
								htmlText+="已完成";
							}else if(order.paymentState=='0'&&order.iscancel=='0'){
								htmlText+="待付款";
							}else if(order.iscancel=='1'){
								htmlText+="已取消";
							}else{
							}
						    htmlText+="</td>";
							htmlText+="<td width='50' align='center' valign='middle'><div class='ys2'>";
							if(order.orderState=='1' && order.paymentState=='2' && (order.deliveryState=='1'||order.deliveryState=='2')){
								htmlText+="<a href='"+ctx+"/pingjiaPage.do?wareComment.code="+order.code+"&wareComment.wareId="+order.goodlist[j].id+"'>评价</a>";
							}
							htmlText+="</div></td></tr>";
						}
						
						htmlText+="</table></td>";
						htmlText+="<td width='135' align='center' valign='middle' class='tahlebottom'>";
						htmlText+="<div class='ys2'><a href='"+ctx+"/showOrder.do?saleOrder.id="+order.id+"'>查看</a><br />"; 
						if(order.orderState=='1' && order.paymentState=='2' && (order.deliveryState=='1'||order.deliveryState=='2')){
							htmlText+="<a href='"+ctx+"/application.do?saleOrder.id="+order.id+"'>申请返修/退换货</a>";
						}
						htmlText+="</div></td></tr>";
					}catch (e){
						break;
					}
				}
				htmlText+="</table>";  
				$('#table2').append(htmlText);	
			},
			error : function(){
				alert('系统错误!');
			}
		});
}