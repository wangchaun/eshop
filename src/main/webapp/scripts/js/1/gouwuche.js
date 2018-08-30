/**
 * 添加商品到购物车
 * @param {Object} id
 */
function addGoodToCart(){
	// 商品Id
	var wareId = $("#wareid").val();
	var goodId = $("#goodid").val();
	//var wareSpecificationVal = $("#selectSpecificationVal").val();
	// 购买数量
	var number = $("#changeNumber").val();
	if(number == ''){
		alert('请输入商品数量');
		$("#changeNumber").focus();
	}
	if(wareId != ''){//&ware.wareSpecificationVal="+wareSpecificationVal
		var url = ctx +"/addGoodToCart.do?good.id="+goodId+"&number="+number+"&ware.id="+wareId;
		url = encodeURI(encodeURI(url));
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				if(returnData=='true'){
					window.location.href = ctx+'/ShoppingCar.do';
				}else{
					alert('添加购物车失败!');
				}
			},
			error : function(){
				alert('系统错误，添入如购物车失败!');
		 	}
		});
	}else{
		alert('请选择商品规格');
	}
}

//小计商品价格
function changeNumber(number){
	var number = $(number).val();
	//var price = $("#price").val();
	var reg = /^[1-9]*[1-9][0-9]*$/ ; 
	//var selectWareprice = $("#selectWareprice").val()
	
    if(number != "" && !reg.test(number)){  
        alert('非法字符,只能输入正整数');
        $("#changeNumber").val('');
        return false;  
    }

}

//小计商品价格
function changeNumber(number){
	var number = $(number).val();
	//var price = $("#price").val();
	var reg = /^[1-9]*[0-9]*$/ ; 
	//var selectWareprice = $("#selectWareprice").val()
	
    if(number != "" && !reg.test(number)){  
        alert('非法字符,只能输入正整数');
        $("#changeNumber").val(1);
        return false;  
    }
    if(number >99){
    alert('最大为99件');
    $("#changeNumber").val(1);
    return false;  
    }

}
//添加数量
function addNumber(){
 var number = $('#changeNumber').val();
 if(number <99){
 number++;
 $('#changeNumber').val(number);
 }else{
   alert('数量最大99');
 }
}

//减少商品数量
function reduceNumber(){
   var number = $('#changeNumber').val();
    if(number >=2){
    number--;
    $('#changeNumber').val(number);
 }else{
   alert('数量最小1');
 }
}

