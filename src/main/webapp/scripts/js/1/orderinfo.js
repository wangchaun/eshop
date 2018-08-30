

$(document).ready(function(){
	saveFormRewrite();
});

//重写form的submit方法
function saveFormRewrite(){
	$('#saveForm').submit(function(){
		if(!checkForm()){
			return false;
		}
		var options = { 
				url : ctx+'/createOrder.do',
				async: false,
				cache: false,
				type : 'POST', 
				success : function(returnData){ 
					if(returnData == 'true'){
						window.location.href = ctx+"/successOrder.do";
					}else{
						alert('下单失败!');
					}
				},
				error : function(){
					alert('系统错误，下单失败!');
				} 
			};
		$('#saveForm').ajaxSubmit(options); 
		return false; 	
	}); 
}

//检查表单
function checkForm(){
	var linkManVal = $("#linkMan").val();				// 收货人
	var addressVal = $("#address").val();				// 收货地址
	var telephoneVal = $("#telephone").val();			// 电话
	var mobileVal = $("#mobile").val();					// 手机
	var emailVal = $("#email").val();					// 电子邮箱
	var paymentIdVar = $("#paymentId").val();			// 支付方式
	var deliveryIdVar = $("#deliveryId").val();			// 配送方式
	var deliveryDateVar = $("#deliveryDate").val();		// 配送时间
	if(linkManVal == ''){
		alert('请输入收货人');
		$("#linkMan").focus();
		return false;
	}
	if(addressVal == ''){
		alert('请输入详细地址');
		$("#address").focus();
		return false;
	}
	if(mobileVal == '' && telephoneVal==''){
		alert('请输入联系电话或手机');
		return false;
	}
	if(emailVal == ''){
		alert('请输入电子邮箱');
		return false;
	}
	if(paymentIdVar == ''){
		alert('请选择支付方式');
		return false;
	}
	if(deliveryIdVar == ''){
		alert('请选择配送方式');
		return false;
	}
	if(emailVal == ''){
		alert('');
		return false;
	}
	return true;
}

// 配送费用
function selectDeliveryFee(obj){
	var deliveryId = $(obj).val();
	
	//var money = $('#money').text();	
	if(deliveryId != ''){
		var deliveryFee = $('#'+deliveryId).val();
		deliveryFee = parseFloat(deliveryFee);
		deliveryFee = deliveryFee.toFixed(2);
		var imoney = 0;
		//if(money < 98){
			$('#deliveryCost').text('¥'+deliveryFee);
			$('#totalCost').text(deliveryFee);
		//}else{
		//	$('#deliveryCost').val(imoney.toFixed(2));
		//	$('#totalCost').text(imoney.toFixed(2));
		//}
		
	}else{
		$('#deliveryCost').text('¥0.00');
		$('#totalCost').text('0.00');
	}
	flushMoney();
}

// 计算总金额
function flushMoney(){
	var money = replaceStr($('#money').text());				// 商品金额
	var totalCost = $('#totalCost').text();		// 运费
	var coupon = $('#coupon').text();			// 优惠券
	
	var totalMoney = Number(money) + Number(totalCost) - Number(coupon);
	$('#totalmoney').text('¥'+totalMoney.toFixed(2));
	$('#orderMoney').val(totalMoney.toFixed(2));
}

//使用优惠券抵消部分总额
function addToCoupon(){
	$("#addToCoupon").show('slow');
}

//查找优惠劵
function srachCoupon(){
	var couponCode=$("#couponCode").val();
	if(couponCode != ''){
		var url = ctx +"/srachCoupon.do?vipCoupon.id="+couponCode;
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				if(returnData == 'false'){
					alert("使用优惠劵是出现错误");
				}else{
					var str = returnData;
			  		var arr = new Array();
					arr = str.split(",");
					if(arr.length > 1){
						var couponId = arr[0];
						var couponName = arr[1];
						var couponMinBuy = arr[2];
						var couponMoney = arr[3];
					}
					$("#couponId").text(couponId);
					$("#couponName").text(couponName);
					$("#couponMoney").text(couponMoney);
					$("#couponMinbuy").text(couponMinBuy);
					$("#couponinfor").show('slow');
					$("#addToCoupon").hide();
				}
			},
			error : function(){
				alert('系统错误，请联系管理员!');
		 	}
		});
	}else{
		alert("请输入优惠劵号");
	}
}

//使用
function employCoupon(){
	var money = $('#money').text();
	var couponMinbuy = $('#couponMinbuy').text();
	var couponMoney = $('#couponMoney').text();
	var couponId = $('#couponId').text();
	if(money < couponMinbuy){
		alert("你的消费余额不足"+couponMinbuy);
	}else{
		$('#coupon').text(couponMoney);
		$('#priceDiscount').val(couponMoney);
		$('#employcouponId').val(couponId);
		flushMoney();
		$("#couponinfor").hide();
	}
}

//取消
function abolishCoupon(){
	$("#couponinfor").hide();
}

//去掉金钱符号和元
function replaceStr(str){
	str = str.replace("¥","");
	str = str.replace("元","");
	return str;
}