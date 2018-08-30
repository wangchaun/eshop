var total =0;    //数据总数量
$(document).ready(function(){

//getGroupGood();


  page();

});

function page(){
var initPagination = function() {  
             Count();   
         // 创建分页  
         $("#Pagination").pagination(total, {  
             num_edge_entries: 1, //边缘页数  
             num_display_entries: 6, //主体页数  
             callback: pageselectCallback,  
             items_per_page:3 //每页显示多少条数据
         });
        //$("#Pagination1").append($("#Pagination").clone());
      }();

     function pageselectCallback(page_index, jq){  
         getGroupGood(page_index+1);   //请求方法
        return false;  
    }


}


function getGroupGood(page_index){

     $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getgroupgoodJosn.do?page="+page_index,
		  success : function(returnData){ 
		        var data = eval(returnData);
			    $('#group_id').empty();
	            for(var i=0; i< data.rows.length; i++){
	            
	               var good = data.rows[i];
	               var textHtml = " <div class='product'><div class='title'> <span></span> <a href='' title='"+good.name+"'>"+good.name+"</a> </div> <div class='pic'> <a href='tuangxq.html' ><img data-img='1' src='"+ctx+good.pic+"' width='278' height='185' alt='"+good.name+"'/></a> </div> <div class='price'> <span><font>1056</font>人已购买</span> 原价：<font>"+good.price+"元</font><font class='zhe'>"+discount(good.price,good.priceGroupBuy)+"折</font> </div> <div class='buy'> <span>"+good.priceGroupBuy+"</span> <span class='tg'><a href='' title=''></a></span> </div> </div>";
	               
	                $('#group_id').append(textHtml);
	            }
        
	                        
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");

}

function Count(){

 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getgroupgoodJosn.do",
		  success : function(returnData){ 
		        var data = eval(returnData);
		        total = data.total;     		             
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");


}


function discount(price,priceGroupBuy){
  var beginPrice = 0;
  if(price!=""&&priceGroupBuy!=""){
  var beginPrice = priceGroupBuy / price * 10;  
  
  }
   return beginPrice.toFixed(2);
}
