//加入收藏
function addGoodToFavorite(wareId){
     // 商品Id
    //var goodId = $("#goodId").val();
	if(wareId != ''){
		var url = ctx +"/addGoodToFavorite.do?favorite.wareId="+wareId;
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
					alert("您已经收藏过该商品，不用再收藏了！");
					return;
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

//退出登陆
function loginOut(){
	if (confirm("您确定要退出吗?")){
		window.location.href=ctx+"/loginOut.do";
	}
}

// 删除购物车中的商品
function deleteGood(wareId){
	if (confirm("您确定要删除吗?")){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/deleteGoodFromCar.do",
			  data: "id=" + wareId,
			  success : function(returnData){ 
					if(returnData == 'true'){
						 
						window.location.href = ctx+"/ShoppingCar.do";
					
					}else{
						alert('删除失败');
					}
				},
				error : function(){
					alert('删除失败');
			 	} 
		});
	}
}

//清空购物车
function clearCar(){
	if (confirm("您确定要清空吗?")){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/clearShoppingCar.do",
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('购物车已清空');
						window.location.href = ctx+"/ShoppingCar.do";
					}else{
						alert('购物车清空失败');
					}
				}
		});
	}
}

//	验证修改数量
function checkNumber(obj){ 

	var reg =  /^\d+$/;
	if(obj!="" && !reg.test(obj)){
		return false;
    }
    return true;
}

// 修改购买数量
function changeNum(obj,i){
	var count = $("#count"+i).val();
    
	if(obj=='1'&&count>1){
		count=Number(count)-1;
	}	
	if(obj=='2'){
		count=Number(count)+1;
	}
	 
	if(checkNumber(count)){
		var price = $("#price"+i).html();	// 获取商品单价
		var newMoney = price * $("#count"+i).val();		// 计算单个商品的总金额
		goodId = $("#id"+i).val();			// 获取商品Id
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/changeNum.do?goodId="+goodId+"&count="+count,
		  success : function(returnData){
				if(returnData=='true'){
					$("#count"+i).val(count);
					recount(obj);
				}
				if(returnData != 'true'&&returnData != 'false'){
					$("#count"+i).val(returnData);
					$("#Whethergoods"+i).html("<font color='red'>当前只有"+returnData+"件库存</font>");
				}
			}
		});
		recount();
	}else{
		alert("请输入合理数字!");
		$("#count"+i).val('1');
	}
}
//修改总金额
function cutMoney(index){
	var totalMoney=$("#totalMoney").html();
	var money='';
	var totalNum=$("#totalNumber").html();
	var totalNumber='';
	
	var price=$("#price" + index).html();
	var number=$("#count"+ index).val();
	var itemMoney=number*Number(price); 
	
	if($("#chkb"+index).attr("checked")){
		money=Number(totalMoney) + Number(itemMoney);
		totalNumber=Number(totalNum) + Number(number);	
	}else{
		money=Number(totalMoney) - Number(itemMoney);
		totalNumber=Number(totalNum) - Number(number);  
	}
	$("#totalNumber").html(totalNumber);
	$("#totalMoney").text(money.toFixed(2));
	$("#totalMoneys").text(money.toFixed(2));
}
//统计金额
function recount(){
	var totalNum = 0;			// 总数量
	var totalMoney = 0;			// 总金额
	var isNumber = true;
	for (j = 0; j < 50; j++) {
		if($("#chkb"+j).attr("checked")){
			var goodidVal = $("#id" +j).val();
			if(goodidVal != null){
				var num = $("#count"+ j).val();
				if(!checkNumber(num)){
					isNumber = false;
					break;
				}
				totalNum = totalNum + Number(num);
				var price= $("#price" + j).html();
				totalMoney +=num*Number(price);
			}
		}		
	}
	if(isNumber){
		$("#totalNumber").html(totalNum);
		$("#totalMoney").html(totalMoney.toFixed(2));
		$("#totalMoneys").html(totalMoney.toFixed(2));
	}
}


//结算前判断
function jiesuanJ(){
		//验证登陆
	var checkLogin=validationLogin();
	if(checkLogin=='false'){
		$("#geturl").val('/jiesuan.do');
		ShowDiv('MyDiv','fade');
	}else{		
		jiesuan();
	}
}

// 商品结算
function jiesuan(){
	
		var isOk = true;
		var index = 0;
		for(var i = 0;i < 20; i++){
			var numVal = $('#count'+i).html();
			if(numVal){
				if(parseInt(numVal) == 0){
					index = i;
					isOk = false;
					break;
				}
			}
		}
		if(isOk){
			//判断购物车是否为空
			$.ajax({
				url:ctx+'/isNotEmptyCart.do',
				type:'POST',
				async:false,
				success:function(returnData){
				if(returnData=='true'){
					var arrChk="";
					//$($("[name='check111'][checked]")).each(function(){arrChk+=this.value + ',';});
					var checkedbox=document.getElementsByName("check111");
					for(var i=0; i<checkedbox.length; i++){        
						if(checkedbox[i].checked == true){      //获取复选框的值        
							arrChk += checkedbox[i].value+",";  //求和          
						}        
					}	
//					alert(arrChk);
											
					window.location.href = ctx+"/jiesuan.do?checked="+arrChk+"";
				}else{
					alert('您的购物车是空的，请购买商品！');
				}
				},
				error : function(){
					alert('系统有误,结算失败');
		 		} 
			});
		}else{
			alert('请输入订购商品的数量');
			$('#count'+index).focus();
		}
		
}

//“加入购物车”跳到商品详情页面
function Todetail(goodId){
	window.location.href=ctx+"/cpxq.do?good.id="+goodId;
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
					alert("您已经收藏过该商品，不用再收藏了！");
					return;
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

//修改服务
function updateFW(wareId){
    var goodsIncarselect=$('#goodsIncarselect').val();	//获取服务
	if(wareId != ''&&goodsIncarselect!=''){
		var url = ctx +"/XGSpecification.do?wareId="+wareId+"&goodsIncarselect="+goodsIncarselect;
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,  
		  	success : function(returnData){ 
				if(returnData=='true'||returnData){
					window.location.reload();
				}else{
					alert("修改失败");
				}
			},
			error : function(){
				alert('系统错误，修改服务错误!');
		 	}
		});
	}else{
		alert("修改失败");
	}
}



