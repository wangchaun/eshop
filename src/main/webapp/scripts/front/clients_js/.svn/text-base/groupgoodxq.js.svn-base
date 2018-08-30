 $(document).ready(function(){
	goodEvaluation('0','1');
	dateValid();
});
 
 
 //修改规格样式
 function upstyle(obj,i,value){
	var put = document.getElementsByTagName("a");
	for(j=0;j<put.length;j++){
		if(put[j].name==('SpecificationVal'+i)){
			put[j].id='';
		}
	}
	obj.id="details01visited";
	$('#goodSpecification'+i).val(value);
}
 
 //修改数量
 function subtraction(str){
 	var subtractionVal=Number($('#changeNumber').val());
 	var goodnumber=Number($('#goodnumber').val());
 	if(str=='1'){
 		if(subtractionVal>1){
 			subtractionVal=subtractionVal-1;
 		}
 	}
 	if(str=='2'){
	 	if(subtractionVal<goodnumber){
	 		subtractionVal=subtractionVal+1;
	 	}else{
	 		alert('购买数量已经达到库存最大数');
	 	}
 	}
 	$('#changeNumber').val(subtractionVal);
 }
 
//查询商品评价
function goodEvaluation(type,pageIndex){
	$('#apptypes').val('wareComment');
	$('#wareCommenttype').val(type);
	var groupgoodId=$('#goodId').val();
	var url=ctx+"/getgoodComment.do?wareComment.wareId="+groupgoodId;
	if(type!='0'){
		url+="&wareComment.type="+type;
	}
	if(pageIndex!=null&&pageIndex!=''){
		url +="&pageInfo.pageIndex="+pageIndex;
	}
	var htmlText="";
	$('#con_three_'+Number(type+1)).empty();
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
			url: url,
			success : function(returnData){
				rows=eval(returnData).rows;
				pageInfo=eval(returnData).pageInfo;
				if(type=='0'){
					$('#three1').empty();
					$('#three1').append("全部评价("+pageInfo.count+")");
				}
				var totlelevel="";
				for(i=0;i<rows.length;i++){
					var wareComment=rows[i];
					totlelevel=Number(totlelevel+wareComment.level);
					htmlText+="<div class='evaluationlist'><div class='evaluationlist01'><div class='evaluationlist01_img'>";
					htmlText+="<h1><img src='"+ctx+"/Images/images/img12.jpg' /></h1>";
					htmlText+="<h2>"+wareComment.creatorName+"</h2></div>";
					htmlText+="<div class='evaluationlist01_text'><div class='evaluationlist01_text01'>";
					htmlText+="<span><img src='"+ctx+"/Images/images/pu1"+Number(5-wareComment.level)+".jpg'/></span>";
					htmlText+="<samp>"+wareComment.level+"</samp>";
					htmlText+="<h1>评价时间："+wareComment.createTime+"</h1></div>";
					htmlText+="<div class='evaluationlist01_text02'>"+wareComment.content+"</div>";
					htmlText+="</div></div></div>";
				}
				var tels=totlelevel/rows.length;
				var telspath="/Images/images/pu1";
				if(tels>4.5){
					tels=5;
					telspath+=(5-tels);
				}else if(tels>4){
					tels=4.5;
				}else if(tels>3.5){
					tels=4;
					telspath+=(5-tels);
				}else if(tels>3){
					tels=3.5;
				}else if(tels>2.5){
					tels=3;
					telspath+=(5-tels);
				}else if(tels>2){
					tels=2.5;
				}else if(tels>1.5){
					tels=2;
					telspath+=(5-tels);
				}else if(tels>1){
					tels=1.5;
				}else{
					tels=1;
					telspath+=(5-tels);
				}
				if(rows.length>0){
					$("#eval1").empty();
					$("#eval2").empty();
					var html="<h1><span>平均评分</span><samp>"+tels+"</samp></h1><h2><img src='"+ctx;
	 					html+=telspath+".jpg";
	 					html+=" '/></h2>";
					$("#eval1").append(html);
					$("#eval2").append("<h1 class='positon"+Number(11-tels/0.5)+"'><span class='stand'>"+tels.toFixed(1)+"</span></h1>");
				}	
				$('#con_three_'+Number(type+1)).append(htmlText);	
				//设置分页参数
				$('#count').val(pageInfo.count);
				$('#pageSize').val(pageInfo.pageSize);
				$('#pageCount').val(pageInfo.pageCount);
				$('#pageIndex').val(pageInfo.pageIndex);
				init(pageInfo.pageIndex)
				if(pageInfo.count>0)$('#pagerBot').css('display','block');
				if(pageInfo.count<1)$('#pagerBot').css('display','none');
			},
			error : function(){
				alert('系统错误!');
			}
		});
}

//查询商品咨询信息
function goodmession(type,pageIndex){
	$('#apptypes').val('getGoodMessage');
	$('#wareCommenttype').val(type);
	var goodId=$('#goodId').val();
	var url=ctx+"/getGoodMessage.do?message.goodId="+goodId;
	if(type!='all'){
		url+="&message.type="+type;
	}
	if(pageIndex!=null&&pageIndex!=''){
		url +="&pageInfo.pageIndex="+pageIndex;
	}
	var htmlText="";
	$('#consulting'+type).empty();
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
			url: url,
			success : function(returnData){
				rows=eval(returnData).rows;
				pageInfo=eval(returnData).pageInfo;
				for(i=0;i<rows.length;i++){
					var message=rows[i];
					htmlText+="<div class='consulting1_listtext'><div class='consulting1_listtext01'>";
					htmlText+="<h1><span>"+message.creatorName+"</span><samp>发布咨询</samp>"+message.content+"</h1>";
					if(message.list!=null){
						for(j=0;j<message.list.length;j++){
							htmlText+="<h2><span><img src='"+ctx+"/Images/images/img18.jpg' /></span><samp>"+message.list[j].content+"</samp></h2>";
						}
					}
					htmlText+="</div><div class='consulting1_listtext02'>"+message.createTime+"</div></div>";
				}
				$('#consulting'+type).append(htmlText);	
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


//显示我要咨询
function HiddenConsulting(){
	var type=$('#wareCommenttype').val();
	var divstyle="";
	if(type=='all'){
		divstyle=document.getElementById("four_di_1").style.display;
		if(divstyle=='none'){
			$("#four_di_1").show();
		}else {
			document.getElementById("four_di_1").style.display='none';
		}
	}
	if(type=='0'){
		divstyle=document.getElementById("four_di_2").style.display;
		if(divstyle=='none'){
			$("#four_di_2").show();
		}else {
			document.getElementById("four_di_2").style.display='none';
		}
	}	
	if(type=='1'){
		divstyle=document.getElementById("four_di_3").style.display;
		if(divstyle=='none'){
			$("#four_di_3").show();
		}else {
			document.getElementById("four_di_3").style.display='none';
		}
	}
	if(type=='2'){
		divstyle=document.getElementById("four_di_4").style.display;
		if(divstyle=='none'){
			$("#four_di_4").show();
		}else {
			document.getElementById("four_di_4").style.display='none';
		}
	}
}

//隐藏分页组件
function hiddenDiv(){
	$('#pagerBot').css('display','none')
}

//倒计时
function changeDateFormat(cellval) {
  var date = new Date();
  date.setTime(cellval);
  var hours=date.getDate()*24+date.getHours();
  return hours+'时'+date.getMinutes()+'分'+date.getSeconds()+'秒';
//  return date.getDate()+'天'+date.getHours()+'时'+date.getMinutes()+'分'+date.getSeconds()+'秒';
}

function dateValid(){ 	
	var beginDate =  new Date();
	var beginTime=beginDate.getTime();
	var endTime = Date.parse(document.getElementById("endTime").value.replace(/-/g,"/"));
//	if(beginTime>=endTime){   
//		var endTime=document.getElementById("endTime").value;
//		endTime = endTime.substring(0,11);
//		$('#endTimes').html("距离结束时间：0时0分0秒");
//	}else{
		$('#endTimes').html("距离结束时间："+changeDateFormat(endTime-beginTime));
//	}	
	setTimeout("dateValid()",1000);
}

 
 //添加商品到购物车
 function addGroupGoodToCart(id){
	// 商品Id
	var wareId = $("#wareId").val();
	var goodId = $("#goodId").val();
	var wareSpecificationVal = $("#selectSpecificationVal").val();
	// 购买数量
	var number = $("#changeNumber").val();
	if(number == ''||number<1){
		alert('请输入商品数量');
		$("#changeNumber").focus();
		return;
	}
	if(wareId != ''){
		var url = ctx +"/addGroupGoodToCart.do?good.id="+goodId+"&number="+number+"&ware.id="+wareId+"&ware.wareSpecificationVal="+wareSpecificationVal;
		url = encodeURI(encodeURI(url));
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				if(returnData=='true'){
					if(id=='1'){
//						alert('我要抢成功!');
//						window.location.href = ctx+'/jiesuan.do';
						
						//验证登陆
						var checkLogin=validationLogin();
						if(checkLogin=='false'){
							$("#geturl").val('/jiesuan.do');
							ShowDiv('MyDiv','fade');
						}else{
							window.location.href=ctx+"/jiesuan.do";
						}	
					}
					if(id=='2'){
						alert('添加购物车成功!');
						shoppingCar();
					}
				}
				if(returnData=='false'){
					if(id=='1'){
						alert('我要抢失败!');
					}
					if(id=='2'){
						alert('添加购物车失败')
					}
				}
				if(returnData!='true'&&returnData!='false'){
					alert('请登录')
				}
			},
			error : function(){
				if(id=='1'){
					alert('系统错误，我要抢失败!');
				}
				if(id=='2'){
					alert('系统错误，添加购物车失败')
				}
		 	}
		});
	}else{
		alert('请选择商品规格');
	}
}

//查询规格商品
function selectWareId(id){
	var goodSpecificationnumber=$('#goodSpecificationnumber').val();
	var selectSpecificationVal="";
	for(i=0;i<goodSpecificationnumber;i++){
		var specification=$('#goodSpecification'+i).val();
		if(specification!=''){
			selectSpecificationVal+=specification;
			if(i!=goodSpecificationnumber-1){
				selectSpecificationVal+=",";
			}
		}else{
			alert("请选择商品规格");
			return;
		}	
	}
	$('#selectSpecificationVal').val(selectSpecificationVal);
	
	var goodnumber=$('goodnumber').val();

	var goodId=$('#goodId').val();
	$.ajax({
			type: "POST",
			async: false,
			cache: false,
		  	url: ctx+"/getWareSpecification.do",
		  	data:"goodSpecification.goodId="+goodId+"&goodSpecification.value="+selectSpecificationVal,
		  	success : function(returnData){
				$("#wareId").val(eval(returnData).wareId);
			},
			error : function(){
				alert('系统错误!');
			}
	});
	addGroupGoodToCart(id);	
}

//改变地区
function changeArea(obj){
	areaId=$(obj).val();
	window.location.href=ctx+"/index.do?area.id="+areaId;
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
