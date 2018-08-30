
$(document).ready(function(){
  //回调查询商品的方法
  saleUnionOrderJson();
});


//显示退货商品数据
function saleUnionOrderJson(){ 
	var time=$('#createTime').val()
	var begin=$('#createTime1').val()
	var end=$('#createTime2').val()
	
	
	var url=''; 
	if(time!=''){ 
		url +="&saleOrder.data="+time;
	}
	if(begin!=''){
		url +="&saleOrder.begintime="+begin;
	}
	if(end!=''){
		url +="&saleOrder.endtime="+end;
	}
	

	var htmlText="";
	$('#table1').empty();
	$.ajax({   
			type: "POST",
			async: false,
			cache: false,
			url: ctx+"/saleUnionOrderJson.do",
			data : url,
			success : function(returnData){    
				rows=eval(returnData).rows;
				htmlText+="<table width='962' border='0' cellspacing='0' cellpadding='0' align='center'>";
				for(i=0;i<rows.length;i++){ 
					var order=rows[i];
					htmlText+="<tr><td width='140' align='center' valign='middle' class='leftborder' height='45'>"+order.code+"</td>";
					htmlText+="<td width='135' align='center' valign='middle'>";
					for(j=0;j<order.warelist.length;j++){	
						htmlText+="<span class='font'>¥</span>"+order.warelist[j].money+'<br/>';
					}
					htmlText+="</td>";
					htmlText+="<td width='27' align='center' valign='middle'> </td>";
				    htmlText+="<td width='135' align='center' valign='middle'>";
				    for(j=0;j<order.warelist.length;j++){	
						htmlText+="<span class='fys'>"+order.createTime+"</span><br/>";
					}
				    htmlText+="</td>";
					htmlText+="<td width='27' align='center' valign='middle'> </td>";
					htmlText+="<td width='100' align='center' valign='middle'>";
					for(j=0;j<order.warelist.length;j++){	
						htmlText+="<span class='font'>¥</span>"+order.warelist[j].returnRate+'<br/>';
					}
					htmlText+="</td>";
					htmlText+="<td width='197' align='center' valign='middle'><span class='font'>¥</span>2.00</td>";
					htmlText+="<td width='27' align='center' valign='middle'></td>";
					htmlText+="<td width='174'  align='left' valign='middle'>";
					if(order.orderState=='1' && order.deliveryState=='1' && order.paymentState=='2' && order.iscancel=='0'){
						htmlText+="返点成功";
					}else{
						htmlText+="订单未完成";
					}
					if(order.iscancel=='2'){
						htmlText+="返点失败"
					}
					htmlText+="</td></tr>";
				}
				htmlText+="</table>";
				$('#table1').append(htmlText);	
			},
			error : function(){
				alert('系统错误!');
			}
		});
}