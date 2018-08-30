
$(document).ready(function(){
  hiddens();
  selectGoods('','','','1');  //调用查询方法
  //selectGoods2('','','','1');  //调用查询方法
});


function hiddens(){
	$('#button2 ').hide();
}

//改变价格图片按钮样式
 function chgb(){	
   	 if(document.getElementById("ph1").className=="contr"){		
	   	document.getElementById("ph1").className="contr2"	
	   	changeSort('recommend');
	  }else{		
	   	document.getElementById("ph1").className="contr";
	   	changeSort('ascPrice');
	  }
   }

//改变被选中商品属性的css
function upstyle(obj,i,value,str){  //参数value的值即为选择的属性值
	document.getElementsByName(str)[0].id="";  
	var arrVal='';
	var brandVal='';
	var to='';
	var tobrand='';
	if(obj.id=="current"){  //取消  
		if(str!='brand'){   //非品牌
			obj.id="";
			var str=$('#proptStr').val();
			var arr = new Array();
			arr = str.split(",");
			for(a=0;a<arr.length;a++){
				if(value!=arr[a]){
					if(arr[a]!='')
					arrVal+=arr[a]+',';
				}
			}
			$('#proptStr').val(arrVal);	
		}else{      //品牌类
			obj.id="";
			var str=$('#brandStr').val();
			var arr = new Array();
			arr = str.split(",");
			for(a=0;a<arr.length;a++){
				if(value!=arr[a]){
					if(arr[a]!='')
					brandVal+=arr[a]+',';
				}
			}
			$('#brandStr').val(brandVal);	
		}
		selectGoods('','','','1');  //调用查询方法
	}else{     //选中
		if(str!='brand'){
			obj.id="current";
			var str=$('#proptStr').val();
			to +=str+value+',';
			$('#proptStr').val(to);
		}else{
			obj.id="current";
			var str=$('#brandStr').val();
			tobrand +=str+value+',';
			$('#brandStr').val(tobrand);
		}
		selectGoods('','','','1');  //调用查询方法
	}
}
function selectAlltype(obj,str){ 
	obj.id="current2";
	if(str=='goodbrand'){
		$('#brandStr').val('');	
	}
	if(str=='goodprop'){
		$('#proptStr').val('');
	}

	for(i=0;i<document.getElementsByName(str).length;i++){
			document.getElementsByName(str)[i].id="";  
		}
	selectGoods('','','','1');  //调用查询方法
}

//取值
function changeSort(values){
	var a = $('#apptypes').val();  
	if(values!=null){
		$('#proptes').val(values);
		if(a == 'tuxing'){
			selectGoods('','','','1');  //调用查询方法
		} else {
			selectGoods2('','','','1');  //调用查询方法
		}
	}
}

//商品以图片形式展示
function selectGoods(a,b,c,pageIndex){  
	var typeid=$('#typeid').val();  //用于第一次访问
	var apptypes=$('#apptypes').val();
	var url="good.typesId="+typeid+"&pageInfo.pageIndex="+pageIndex;  
	
	var a=$('#proptStr').val();	
	if(a!=''){
		url +='&good.files='+a;
	}
	var b=$('#brandStr').val();	
	if(b!=''){
		url +='&good.brandsea='+b; 
	}
	var proptes=$('#proptes').val();
	if(proptes!=''){
		url+='&good.sortVal='+proptes;
	}

	var apptypes=$('#apptypes').val();
	if(proptes!=''){
		url+='&good.apptypes='+apptypes;
	}
	
	var htmlText="";
	$('#tupian').empty();
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
			url: ctx+'/productPage2Json.do',
			data:url,
			success : function(returnData){  
				rows=eval(returnData).rows;
				pageInfo=eval(returnData).pageInfo;

				for(i=0;i<rows.length;i++){
					var good=rows[i];
					htmlText+="<li><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'><img id='img1154"+i+"' src='"+ctx+good.pic+"' /></a>";
					htmlText+="<p><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"+good.name+"<span>"+good.introBrief+"</span></a></p>";
					htmlText+="<h1>¥"+good.price+"<span>市场价：</span><samp><span class='font'>¥</span>"+good.priceMarket+"</samp></h1>";
					htmlText+="<h2><span><img src='"+ctx+"/Images/images/photo9.jpg' /></span><samp><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>(已有";
					if(good.commentCount==null){
						htmlText+="0";
					}
					if(good.commentCount!=null){
						htmlText+=good.commentCount;
					}
					htmlText+="人评价)</a></samp></h2>";
                    if(good.isView!='1'){
                     htmlText+="<h3><span><a href=javascript:addGoodToCart('"+good.id+"') id='1154"+i+"' class='listcart'>加入购物车</a></span><a href='javascript:void(0);' onclick=addGoodToFavorite('"+good.id+"')>收藏</a></h3>";
                    }else{
                     htmlText+="<h3><span><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>加入购物车</a></span></h3>";
                    }
                    htmlText+="</li>";				
				}
				$('#tupian').append(htmlText);	 
				//设置分页参数
				$('#count').val(pageInfo.count);    
				$('#pageSize').val(pageInfo.pageSize);
				$('#pageCount').val(pageInfo.pageCount);
				$('#pageIndex').val(pageInfo.pageIndex);
				
				$('#page1').text(pageInfo.pageIndex);
				$('#page2').text(pageInfo.pageCount);
				init(pageInfo.pageIndex);
				if(pageInfo.count>0)$('#pagerBot').css('display','block');
				if(pageInfo.count<1)$('#pagerBot').css('display','none');
			},
			error : function(){
				alert('系统错误!');
			}
		});
}


//商品以列表形式展示
function selectGoods2(a,b,c,pageIndex){ 
	var typeid=$('#typeid').val();  //用于第一次访问
	var apptypes=$('#apptypes').val();
	var url="good.typesId="+typeid+"&pageInfo.pageIndex="+pageIndex; 
	
	var a=$('#proptStr').val();	
	if(a!=''){
		url +='&good.files='+a;
	}
	var b=$('#brandStr').val();	
	if(b!=''){
		url +='&good.brandsea='+b; 
	}
	var proptes=$('#proptes').val();
	if(proptes!=''){
		url+='&good.sortVal='+proptes; 
	}
	

	var htmlText="";
	$('#con_one_2').empty();
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
			url: ctx+'/productPage2Json.do',
			data:url,
			success : function(returnData){  
				rows=eval(returnData).rows;
				pageInfo=eval(returnData).pageInfo;

				for(i=0;i<rows.length;i++){
					var good=rows[i];
					htmlText+="<div class='wantedList'><div class='wantedList01'>";
                    htmlText+="<div class='wantedList01_text'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'><img id='img1154"+i+"' src='"+ctx+good.pic+"' /></a></div>";
                    htmlText+="<div class='wantedList01_text1'>"; 
					htmlText+="<p><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"+good.name+"<span class='wancolor'>"+good.introBrief+"</span></a></P>";
					htmlText+="<samp>¥"+good.price+"</samp>";
                    htmlText+="<h1><span><img src='"+ctx+"/Images/images/photo9.jpg' /></span><samp><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>(已有";
                    if(good.commentCount==null){
						htmlText+="0";
					}
					if(good.commentCount!=null){
						htmlText+=good.commentCount;
					}
                    if(good.isView!='1'){
                        htmlText+="<div class='wantedList02'><a href=javascript:addGoodToCart('"+good.id+"') id='1154"+i+"' class='listcart'>加入购物车</a><span><a href='javascript:void(0);' onclick=addGoodToFavorite('"+good.id+"')>收藏</a></span></div>";
                    }else{
                        htmlText+="<div class='wantedList02'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>加入购物车</a></div>";
                    }
	                   	htmlText+="</div>";
				}
				$('#con_one_2').append(htmlText);	 
				//设置分页参数
				$('#count').val(pageInfo.count);
				$('#pageSize').val(pageInfo.pageSize);
				$('#pageCount').val(pageInfo.pageCount);
				$('#pageIndex').val(pageInfo.pageIndex);
				init(pageInfo.pageIndex);
				if(pageInfo.count>0)$('#pagerBot').css('display','block');
				if(pageInfo.count<1)$('#pagerBot').css('display','none');
			},
			error : function(){
				alert('系统错误!');
			}
		});
}


//加入收藏
function addGoodToFavorite(goodId){
    // 商品Id
	if(goodId != ''){
		var url = ctx +"/addGoodToFavorite.do?favorite.goodId="+goodId;
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
				}else if(returnData=='error'){
					alert('您已经收藏过此商品，不用再收藏!');
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
				var shoppingCar=eval(returnData).rows;
				$('#cartItem').empty();
				var count=0; 
				for(i=0;i<shoppingCar.length;i++){
					if(i<5){			//最多取5条
						goodInCar=shoppingCar[i];
						htmlText+="<div id='cartItem_"+goodInCar.id+"' class='shoppingCart1_text'>";
						htmlText+="<div class='shoppingCart1_text01'>";
						htmlText+="<a href='"+ctx+"/cpxq.do?good.wareId="+goodInCar.id+"'><img src='"+ctx+goodInCar.pic+"' border='0' title='"+goodInCar.name+"' /></a></div>";
        				htmlText+="<div class='shoppingCart1_text02'>";
          				htmlText+="<h1>¥"+goodInCar.price+"</h1>";
						htmlText+="<h2><img src='"+ctx+"/Images/images/img23.jpg'/></h2>";
						htmlText+="<h3>"+goodInCar.count+"</h3>";
						htmlText+="<h4>件</h4>";
				       
						htmlText+="</div>";
						htmlText+="<div class='shoppingCart1_text03'><a class='delCartItem' name='"+goodInCar.id+"'><img src='"+ctx+"/Images/images/img21.jpg' border='0' /></a></div></div>";
					    count=count+goodInCar.count;
					}
				}
				var rowssize=eval(returnData).rowssize;
				 
				htmlText+="<input type='hidden' value='"+rowssize+"' id='rowssize'/>"
				$('#cartItem').append(htmlText);
			    $('.ys3').html('<a href="'+ctx+'/ShoppingCar.do">购物车'+rowssize+'件</a>  | <a href="${ctx}/infor.do?information.type=6" >售后服务</a>   | <a href="${ctx}/infor.do?information.type=7">企业采购</a>	| <a href="${ctx}/infor.do?information.type=3">购物指南</a>');
			},
			error : function(){
				alert('系统错误!');
			}
		});
}
  
