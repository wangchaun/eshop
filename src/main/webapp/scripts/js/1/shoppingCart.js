// 删除购物车中的商品
function deleteGood(i){
    alert(i);
	if (confirm("您确定要删除吗?")){
		var goodId = $("#id"+i).val();
         
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/deleteGoodFromCar.do",
			  data: "id=" + goodId,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功');
						window.location.href = ctx+"/myShoppingCar.do";
					
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
    
	if (confirm("您确定12312要清空吗?")){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/clearShoppingCar.do",
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('购物车已清空');
						window.location.href = ctx+"/myShoppingCar.do";
					}else{
						alert('购物车清空失败');
					}
				}
		});
	}
}
// 修改购买数量
function changeNum(i){
	var count = $("#count"+i).val();
	if(checkNumber(count)){
		var price = replaceStr($("#price"+i).text());	// 获取商品单价
		var credits = $("#credits"+i).val();			// 获取单个积分
		var newMoney = price * $("#count"+i).val();		// 计算单个商品的总金额
		var newCredits = credits * $("#count"+i).val();	// 计算单个商品的总积分
		
		$("#money"+i).text('￥'+newMoney.toFixed(2));
		$("#allCredit"+i).text(newCredits);
		countVal = $("#count"+i).val(); 	// 获取商品数量
		goodId = $("#id"+i).val();			// 获取商品Id
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/changeNum.do?goodId="+goodId+"&count="+countVal,
		  success : function(returnData){ 
				if(returnData == 'true'){
					recount();
				}
			}
		});
	}else{
		alert("请输入合理数字!");
		$("#count"+i).val('1');
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
//统计金额
function recount(){
	var totalNum = 0;			// 总数量
	var totalMoney = 0;			// 总金额
	var totalCredits = 0;		// 总积分
	var isNumber = true;
	
	for ( var j = 0; j < 50; j++) {
		var goodidVal = $("#id" +j).val();
		
		if(goodidVal != null){
			var num = $("#count"+ j).val();
			if(!checkNumber($("#count"+ j))){
				isNumber = false;
				break;
			}
			totalNum = totalNum + Number(num);
			var money = replaceStr($("#money" + j).text());
			var allCredit =  $("#allCredit" + j).text();
			totalMoney = totalMoney + Number(money);
			totalCredits = totalCredits + Number(allCredit);
		}
	}
	if(isNumber){
		//$("#totalNum").text(totalNum);
		//$("#totalCredits").text(totalCredits);	
		$("#finalPrice").text('¥'+totalMoney.toFixed(2));
	}
}

//去掉金钱符号和元
function replaceStr(str){
	str = str.replace("¥","");
	str = str.replace("元","");
	return str;
}

// 商品结算
function jiesuan(){
	var isOk = true;
	var index = 0;
	for(var i = 0;i < 20; i++){
		var numVal = $('#count'+i).val();
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
					window.location.href = ctx+'/jiesuan.do';
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

// 减少购买数量
function changeNumJian(i){

	var count = $("#count"+i).val();
	if(checkNumber(count)&& count >1){
	
	   var counts = --count;
	
		var price = replaceStr($("#price"+i).text());	// 获取商品单价
		var credits = $("#credits"+i).val();			// 获取单个积分
		var newMoney = price * counts;		// 计算单个商品的总金额
		var newCredits = credits * counts;	// 计算单个商品的总积分
		var beforemoney = replaceStr($("#finalPrice").text());  //当前总金额
	   	var finalPrice = Number(beforemoney) - Number(price);	
	   	var beforeCount = $("#totalNum").text();      //当前商品数量
	   	var totalNum = beforeCount - 1;

		
		//$("#money"+i).text('￥'+newMoney.toFixed(2));
		$("#finalPrice").text('¥'+finalPrice.toFixed(2));	 
		$("#totalmoney").text('¥'+finalPrice.toFixed(2));
		$("#allCredit"+i).text(newCredits);
		$("#count"+i).val(counts);
		$("#totalNum").text(totalNum);
		countVal = $("#count"+i).val(); 	// 获取商品数量
		goodId = $("#id"+i).val();			// 获取商品Id
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/changeNum.do?goodId="+goodId+"&count="+countVal,
		  success : function(returnData){ 
				if(returnData == 'true'){
					//recount();
				}
			}
		});
	}else{
		alert("最少为1个数量!");
		$("#count"+i).val('1');
	}
}


// 添加购买数量
function changeNumJia(i){

	var count = $("#count"+i).val();

	if(checkNumber(count)&& count <99){
	    
	    var counts = ++count;
	
	   
	 
		var price = replaceStr($("#price"+i).text());	// 获取商品单价

		var credits = $("#credits"+i).text();			// 获取单个积分

		var newMoney = price * counts;		// 计算单个商品的总金额

		var newCredits = credits * counts;	// 计算单个商品的总积分
		
	    var beforemoney = replaceStr($("#finalPrice").text());  //当前总金额		
		var finalPrice = Number(beforemoney) + Number(price);	
	    var beforeCount = $("#totalNum").text();      //当前商品数量
	   	var totalNum = Number(beforeCount) + 1;       
		
		$("#finalPrice").text('¥'+finalPrice.toFixed(2));
		$("#totalmoney").text('¥'+finalPrice.toFixed(2));
		//$("#credits"+i).text(newCredits);
		$("#totalNum").text(totalNum);
		$("#count"+i).val(counts);
		countVal = $("#count"+i).val(); 	// 获取商品数量
		goodId = $("#id"+i).val();			// 获取商品Id
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/changeNum.do?goodId="+goodId+"&count="+countVal,
		  success : function(returnData){ 
				if(returnData == 'true'){
					//recount();
				}
			}
		});
	}else{
		alert("最多99个数量!");
		$("#count"+i).val('99');
	}
}

