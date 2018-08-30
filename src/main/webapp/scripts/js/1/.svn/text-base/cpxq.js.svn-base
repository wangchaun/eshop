 $(document).ready(function(){

   //根据商品查  类别和品牌
   getGoodTypeOrGoodBrand($('#goodTypeId').val(),'');   
   getGoodTypeOrGoodBrand('',$('#brandId').val());
   
   //热卖商品
    Rxgood();
    //商品的相关商品,组合商品
   xgsp($('#goodid').val());
   
   //获取仓库
   getWarehouse();
   
   //获取评论
   getWareComment('comment-00','','qbpjTotal','Pagination-0');  //参数1  评论数据显示id名称   参数2  区分好评 中评 差评   参数3 数据总数显示id名称   参数4分页id名称
   
   showPic('spxqgg');    //商品详情广告图片
});

//根据商品类别ID获取相关类别
function getGoodTypeOrGoodBrand(goodTypeId,brandId){
   
  
    if(goodTypeId!=""){
     var num =1;
     $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getGoodtypeOrGoodBrand.do?good.goodTypeId="+goodTypeId,
		  success : function(returnData){ 
			    //$('#XSQGshow').empty();
		      $.each(returnData,function(GoodType,goodType){
		      if(num <=12){
		      var textHtml= "<li><a href='#'>"+goodType.name+"</a></li>";

		       $('#xgflHtml').append(textHtml);
		      
		      num++;
		      }
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}

    if(brandId!=""){
     var num =1;
     $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getGoodtypeOrGoodBrand.do?good.brandId="+brandId,
		  success : function(returnData){ 
			    //$('#XSQGshow').empty();
		      $.each(returnData,function(GoodBrand,goodBrand){
		      if(num <=24){
	   
		      var textHtml= "<li><a href='#'>"+goodBrand.name+"</a></li>";

		       $('#xgppHtml').append(textHtml);
		      
		      num++;
		      }
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}

}

function Rxgood(){   //热卖商品
 
 var num =1;
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getpropertyAllGood.do?good.property=2",
		  success : function(returnData){ 
			   
		      $.each(returnData,function(Good,good){
		      if(num <= 10 ){
		      
		      var textHtml= "<li class='fore1'><div class='p-img'> <a href='"+ctx+"/cpxq.do?good.id="+good.id+"'><img width='100' height='100' src='"
		      +ctx+good.pic+"' /></a> </div>  <div class='p-name'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"
		      +good.name+"</a> </div> <div class='p-price'><strong> ￥"
		      +good.price.toFixed(2)+"</strong></div></li>";

		       $('#rmspHtml').append(textHtml);
		      
		      num++;
		      }
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
  
}

function xgsp(goodid){

var num= 1;
var number= 1;

if(goodid!=""){
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getXgspList.do?good.id="+goodid,
		  success : function(returnData){ 			   
		      $.each(returnData,function(Good,good){

		      if(num <=20){
	         
	          if(good.priceDiscount==null){  //等于空就是相关商品	   
	          if(number==1){     
	          $('#xgspHtml').empty();  
	          number++;
	             }  
		      var textHtml= "<li><div class='p-img'> <a href='"
		      +ctx+"/cpxq.do?good.id="
		      +good.id+"'><img width='130' height='130' src='"
		      +ctx+good.pic+"' /></a> </div> <div class='p-name'> <a href='"
		      +ctx+"/cpxq.do?good.id="
		      +good.id+"'>"
		      +good.name+"</a> </div> <div class='p-comm'> <span class='star sa5'></span><br /> <a href='' >(已有104人评价)</a> </div><div class='p-price'><strong>￥"
		      +good.price.toFixed(2)+"</strong> </div></li>";
		       $('#xgspHtml').append(textHtml);
		      }else{//组合商品
		        //alert( good.priceDiscount.toFixed(2));
		        if(good.rangeStr != ""){		        
		        var textHtml= "<li data-cat='1049' class=''> <div class='p-img'> <a  href='"
		        +ctx+"/cpxq.do?good.id="
		        +good.id+"'><img height='100' skuidth='100' src='"
		        +ctx+good.pic+"' /></a> </div> <div class='p-name'> <a  href=''>"
		        +good.name+"</a> </div><div class='choose'><input type='checkbox' onclick='changeMoney(this)' value='"+good.priceDiscount.toFixed(2)+"'/><label class='p-price' for='inp_436329'> <strong>￥"
		        +good.priceDiscount.toFixed(2)+"</strong> </label></div> </li>";
		       $('#zhspHtml').append(textHtml);
		       }else{
		          var textHtml= "<li data-cat='1049' class=''> <s></s> <div class='p-img'> <a  href='"
		        +ctx+"/cpxq.do?good.id="
		        +good.id+"'><img height='100' skuidth='100' src='"
		        +ctx+good.pic+"' /></a> </div> <div class='p-name'> <a  href=''>"
		        +good.name+"</a> </div><div class='choose'><input type='checkbox' onclick='changeMoney(this)' value='"+good.priceDiscount.toFixed(2)+"'/><label class='p-price' for='inp_436329'> <strong>￥"
		        +good.priceDiscount.toFixed(2)+"</strong> </label></div> </li>";
		      
		       $('#zhspHtml').append(textHtml);
		       }		      
		        
		      }
		      num++;
		      }
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
	}
}

function getWarehouse(){
 var num= 1;
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getWarehouseList.do",
		  success : function(returnData){ 
			   
		      $.each(returnData,function(Warehouse,warehouse){
		      if(num <=10){
	       
		      var textHtml= "<a>"+warehouse.name+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";


		       $('#WarehouseHtml').append(textHtml);
		      
		      num++;
		      }
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}
function getWareComment(showid,type,Totalid,pageid){

var id = $('#goodid').val();
 if(id!=""){
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getwareCommentJson.do?good.id="+ id + "&good.appType=" +type,
		  success : function(returnData){ 
		      $('#Searchresult').empty();
			  var data = eval(returnData);
			  var total = data.total;    //数量

		      for(i=0;i< data.rows.length;i++){
	           var wareComment = data.rows[i];
		      var textHtml= "<li><div class='item'><div class='user'><div class='u-icon'> <a target='_blank' href='#'> <img width='50' height='50' src='http://misc.360buyimg.com/lib/img/u/60.gif' upin='非与非寻-非也' /> </a> </div><div class='u-name'> <a target='_blank' href='#'></a></div><span class='u-level'><span style='color:#000000'> 铜牌会员 </span></span><div class='u-address'> (浙江) </div><div class='date-buy'>购买日期<br />"
		      +beginSaleTimeFormat(wareComment.createTime)+"</div></div>        <div class='i-item'><div class='o-topic'> <strong class='topic'><a target='_blank' href='#'>喜爱这个产品</a></strong> <span class='star sa5'></span> <span class='date-comment'>"
		      +beginSaleTimeFormat(wareComment.createTime)+"</span> </div><div class='comment-content'><dl><dt>优点：</dt><dd> 小巧轻便,清晰度挺高.</dd></dl><dl><dt>不足：</dt><dd> 缺点是少盖,有就更完美了</dd></dl><dl><dt>使用心得：</dt><dd> 体积小重量轻亮度够,使用方便，效果还可以！</dd></dl></div><div class='btns'><div id='97e6b9d2-da03-4e20-a4a8-0c63ca0f0608' class='useful'> <span>此评价对我</span> <a href='#' name='agree' class='btn-agree' id='agree'>有用(0)</a> <a href='#' name='oppose' class='btn-oppose' id='oppose'>没用(0)</a> </div><a target='_blank' href='#' class='btn-reply'>回复</a> </div></div><div class='corner tl'> </div></div></li>";              
		       $('#Searchresult').append(textHtml);
		      }
		      //$('#'+pageid).append();
		      		      
		 var initPagination = function() {     
         // 创建分页  
         $("#"+pageid).pagination(total, {  
             num_edge_entries: 1, //边缘页数  
             num_display_entries: 6, //主体页数  
             callback: pageselectCallback,  
             items_per_page:7 //每页显示多少条数据
         });  
      }();
         function pageselectCallback(page_index, jq){  
         var max_elem = Math.min((page_index+1) *7, total);      
         $("#"+showid +" li").remove();       
         for(var i=page_index*7;i<max_elem;i++){  
            var new_content = $("#Searchresult li:eq("+i+")").clone();  
            $("#"+showid).append(new_content); //装载对应分页的内容          
         }
         //$("#"+showid).append("<div class='clearfix'><div id='Pagination' class='pagin fr'></div></div>");
        return false;  
    }      
		      $('#'+Totalid).html("("+total+")");
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
	
	}
}
function showPic(parameter){

 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getadvertiseJson.do?advertise.place="+parameter,
		  success : function(returnData){ 
			    var data = eval(returnData);
			    $('#picggHtml').empty();
			    for(i = 0; i< data.rows.length; i++){
			    if(i <=1){
			    var datastr = data.rows[i];		
			    var textHtml = "<div class='m'><a herf='"+datastr.url+"'><img width='211' height='261' src='"+ctx+datastr.pic+"' /></a></div>";
			    $('#picggHtml').append(textHtml);	  
                  }
			    }
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}


// 加入收藏
function addGoodToFavorite(){
    // 商品Id
	var goodId = $("#goodid").val();
	if(goodId != ''){
		var url = ctx +"/addGoodToFavorite.do?favorite.goodId="+goodid;
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				if(returnData=='true'){
					alert("收藏成功");
				}else if(returnData=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else{
					alert('加入收藏失败!');
				}
			},
			error : function(){
				alert('系统错误，加入收藏失败!');
		 	}
		});
	}else{
		alert('你选择的商品不存在 ');
	}
}


 
 //格式化beginSaleTime
function beginSaleTimeFormat(beginSaleTime){
	var beginSaleTime = beginSaleTime;
	return dateFormat(beginSaleTime);
}
//格式化日期
function dateFormat(date){
	var dateStr = '';
	if(date && date!=null && date!=''){
		dateStr = date.substring(0,10);
	}
	return dateStr;
}




