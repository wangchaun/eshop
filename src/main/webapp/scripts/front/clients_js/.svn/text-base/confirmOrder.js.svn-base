//修改我的信息页面中省市Jsion数据
function selectCity(obj,id,ibc){
	if(ibc=='0'){
		$("#selectTest1").html('');
		$("#selectTest2").html('');
	}
	if(ibc=='1'){
		$("#selectTest2").html('');
	}
	var areaId = $(obj).val();
	var checkText=$(obj).find("option:selected").text();
	$('#selectTest'+ibc).html(checkText);
	var url=ctx+"/selectCityJson.do?1=1&area.parentId="+areaId;
	var htmlText=""; 
	if(id!=''){
		$.ajax({   
				type: "POST",
				async: false,
				cache: false,
				url: url,
				success : function(returnData){ 
					$("#"+id).empty(); 
					rows=eval(returnData).rows;
					htmlText+="<option value=''>请选择</option>";
					for(i=0;i<rows.length;i++){ 
						var city=rows[i];
						htmlText+="<option value='"+city.id+"'>"+city.name+"</option>";
					}
					$("#"+id).append(htmlText);	 
				},
				error : function(){
					alert('系统错误!');
				}
			});
	}	
}
//基本信息验证
function checkForm_1(){
	var linkManVal = $("#con_linkman").val();			// 收货人
	var streetVal = $("#con_street").val();				// 街道地址
	var selectTest0 = $("#address1").val();			//省
	var selectTest1 = $("#address2").val();			//市
	var selectTest2 = $("#address3").val();			//区
	var zipCode = $("#con_zipCode").val();				// 邮编
	var mobileVal = $("#con_mobile").val();				// 手机
	var phone=$("#con_phone").val();
	if(linkManVal == ''){
		alert('请输入收货人');
		$("#con_linkMan").focus();
		return false;
	}
	if(linkManVal.length>5){
		alert('收货人字数不能超过5个');
		$("#con_linkMan").focus();
		return false;
	}
	if(selectTest0 == ''||selectTest0 == '请选择'){
		alert('请选择省');
		return false;
	}
	if(selectTest1 == ''||selectTest1 == '请选择'){
		alert('请选择市');
		return false;
	}
	if(selectTest2 == ''||selectTest2 == '请选择'){
		alert('请选择区');
		return false;
	}
	if(streetVal == ''){
		alert('请输入街道地址');
		$("#con_street").focus();
		return false;
	}
	if(zipCode == ''){
		alert('请输入邮编');
		$("#con_zipCode").focus();
		return false;
	}
	var reg =/^[1-9][0-9]{5}$/;
	if(!reg.test(zipCode)){
		alert('邮编格式不正确');
		$("#con_zipCode").val('');
		$("#con_zipCode").focus();
		return false;
	}
	if(mobileVal == ''){
		alert('请输入手机号码');
		$("#mobile").focus();
		return false;
	}
	var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if(mobileVal.search(reg) == -1){
	    alert('手机号码格式不正确');
	    $("#con_mobile").val('');
		$("#con_mobile").focus();
	    return false;
	}
	return true;
}

//加载基本信息
function setinformation(){   
	var linkManVal = $("#con_linkman").val();			// 收货人
	var streetVal = $("#con_street").val();				// 街道地址
	var selectTest0 = $("#address1").val();			//省
	var selectTest1 = $("#address2").val();			//市
	var selectTest2 = $("#address3").val();			//区
	var zipCode = $("#con_zipCode").val();					// 邮编
	var mobileVal = $("#con_mobile").val();
	var phone=$("#con_phone").val();
	var addressVal=	selectTest0+"-"+selectTest1+"-"+selectTest2; 
	if(checkForm_1()){
		var url = 'customerAddress.name='+linkManVal+'&customerAddress.address='+addressVal+'&customerAddress.street='+streetVal+'&customerAddress.zipCode='+zipCode+'&customerAddress.mobile='+mobileVal+'&customerAddress.whetherordrer=0'+'&customerAddress.phone='+phone;
	 
		var customerAddressId=$('#customerAddressId').val();
		if($('#radio_area_2').attr('checked')==false){
			url+="&customerAddress.id="+customerAddressId;
		}
		$.ajax({ 
			url : ctx+'/setinformation.do',
			data: url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
			    
				if(returnData == 'true'){
					if($('#radio_area_1').attr('checked')){
						alert('修改成功!');
					}else{
						alert('保存成功!');
					}	
					window.location.reload();
				}else if(returnData == 'error'){
					alert('您已保存有10个地址，不能再继续保存！');
				}else{
					if($('#radio_area_1').attr('checked')){
						alert('修改失败!');
					}else{
						alert('保存失败!');
					}
				}
			},
			error : function(){
				alert('系统错误,保存失败!');
			}
		})
	}	
}

//查询优惠劵
function srachCoupon(){
	$('#surch').css('display','block');
	var url=ctx+"/srachCoupons.do"; 
	var htmlText="";
	$("#layer_yh").empty();
	$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
				rows=eval(returnData).rows;
				if(rows.length>0){
					htmlText="";
					for(i=0;i<rows.length;i++){
						if(i<4){	
							htmlText+="<div class='layer02_text') onclick=srachyhq('"+rows[i].code+"','"+rows[i].money+"')><span>有现金券使用：</span><samp>"+rows[i].money+"</samp></div>";
						}
					}
				}else{
					htmlText="没有现金券可用";
				}
				$("#layer_yh").append(htmlText);
			},
			error : function(){
				alert('系统错误，请联系管理员!');
		 	}
		});
}

//使用优惠券
function srachyhq(code,money){
	$('#srachcode').val(code);
	$('#surmony').html("<span style='padding-right:5px;'>-</span><samp>¥</samp>"+money);
	var totalMoney=$('#totalMoney').val();
	if(totalMoney-money>0){
		$('#surmeryt').html("<span>¥</span>"+(totalMoney-money)+"</h4>");
	}else{
		$('#surmeryt').html("<span>¥</span>0.00</h4>");
	}
}


//关闭优惠券选择框
function closesrach(){
	$('#surch').css('display','none');
}

//获取单选框的值
function getRedio(obj){
  var value="";  
  var radio=document.getElementsByName(obj);  
  	for(var i=0;i<radio.length;i++){	
  		if(radio[i].checked==true){	  
	  		value=radio[i].value;	  
	  		break;	
  		}  
  	}  
  return value;
 }
 //获取配送运费
 function selectdeliveryfee(values){
 	if(values!=''){ 
		$('#fontDIV').text(values); 	
		
		var totalMoney = $('#totalMoney2').val();
		var money = Number(values) + Number(totalMoney);
		$('#money1DIV').html("<h1>合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计：</h1><h2><samp>¥</samp>"+money+"</h2>");
		$('#money2DIV').html("<h1>&nbsp;应付总额：</h1><h4 id='surmeryt'><span>¥</span>"+money+"</h4>");
		$('#totalMoney').val(money);
 	}
 }
 //验证表单
 function checkOrder(){
 	var deliveryId=getRedio("saleOrder.deliveryId");	//获取配送方式
	var deliveryDate=getRedio("saleOrder.deliveryDate");//获取送货时间
	var paymentId=getRedio("saleOrder.paymentId");		//获取支付方式
	var areaclick=getRedio("areaclick");
	var invoiceType=$("#invoiceType").val();
	var invoicePayable=$("#invoicePayable").val();
	var invoiceContent=$("#invoiceContent").val();
 
	if(areaclick=='2'||areaclick==''){
		alert("请选择收货地址")
		return false;
	}				
	 
	 
	if(deliveryId==null||deliveryId==''){
		alert("请选择配送方式");
		return false;
	}
	
	if(deliveryDate==null||deliveryDate==''){
		alert("请选择配送日期");
		return false;
	}	
	
	
	if(paymentId==null||paymentId==''){
	    alert("请选择支付方式");
		return false;
	}
	
//	if(invoiceType==null||invoiceType==''){
//		alert("请选择发票类型");
//		return false;
//	}
//	if(invoicePayable==null||invoicePayable==''){
//		alert("请输入发票抬头");
//		return false;
//	}
//	if(invoiceContent==null||invoiceContent==''){
//		alert("请选择内容");
//		return false;
//	}
	return true;
 }
 
//提交订单
function sumbitOrder(){	
	//获取配送方式
	var deliveryId=getRedio("saleOrder.deliveryId");
	//获取送货时间
	var deliveryDate=getRedio("saleOrder.deliveryDate");
	//获取支付方式  非网上支付
	var paymentId=getRedio("saleOrder.paymentId");
	
//	//获取支付方式  网上支付
//	var paymentId2=getRedio("saleOrder.paymentId2");
	
	//获取特殊的支付方式
	//获取优惠券code
	var srachcode=$("#srachcode").val();
	var invoiceType=$("#invoiceType").val();
	var invoicePayable=$("#invoicePayable").val();
	var invoiceContent=$("#invoiceContent").val();
	
	if(checkOrder()){
		
		var areaclick=getRedio("areaclick");
		
		var url="saleOrder.deliveryId="+deliveryId+"&saleOrder.deliveryDate="+deliveryDate+"&saleOrder.address="+areaclick;
		if(srachcode!=''){
			url+="&vipCoupon.code="+srachcode;
		}
		if(invoiceType!=''){
			url+="&saleOrder.invoiceType="+invoiceType+"&saleOrder.invoicePayable="+invoicePayable+"&saleOrder.invoiceContent="+invoiceContent;
		} 
		if(paymentId !=''){
			var bankCode=getRedio("bank_code");
			url+="&saleOrder.paymentId="+paymentId+"&saleOrder.bankCode="+bankCode;
		}		 
		$.ajax({
				type: "POST",
			  	async: false,
			  	cache: false,
			  	url: ctx+"/createOrder.do",
			  	data:url,
			  	success : function(returnData){
					if(returnData=='true'){
						window.location.href = ctx+"/successOrder.do";
					}else if(returnData=='ok'){
					   window.location.href = ctx+"/success.jsp";
					}else{
						alert('您的订单中还没有数据，请先去购买商品！');
						return;
					}
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){
				    alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
					alert('购买失败，请联系管理员!');
			 	}
			});
	
	}

}
//新地址
function newAddress(){
	$("#con_linkman").val('');			// 	收货人
//		$("#selectTest0").html('');		//	省
//		$("#selectTest1").html('');			//	市
//		$("#selectTest2").html('');			//	区
		$("#con_street").val('');			// 	街道地址
		$("#con_zipCode").val('');			// 	邮编
		$("#con_mobile").val('');
		$("#con_phone").val('');
		$("#customerAddressId").val('');
		$("#newAdress").css('display','block');
}
//瘾藏地址层
function hiddenAddress(){
	$("#newAdress").css('display','none');
}
//显示隐藏新地址
function newDisplayAdress(id,name,address,street,zipCode,mobile,phone){
		var str=address.split('-');

		$("#con_linkman").val(name);			// 	收货人
//		$("#selectTest0").html(str[0]);		//	省
//		$("#selectTest1").html(str[1]);			//	市
//		$("#selectTest2").html(str[2]);			//	区
		$("#con_street").val(street);			// 	街道地址
		$("#con_zipCode").val(zipCode);			// 	邮编
		$("#con_mobile").val(mobile);
		$("#con_phone").val(phone);
		$("#customerAddressId").val(id);
		$("#newAdress").css('display','block');
}

//删除订单地址
function delectAdress(addressId){
	//var customerAddressId=$('#customerAddressId').val();
		
	if(addressId!=''){
		var url="customerAddress.id="+addressId;
		$.ajax({
				type: "POST",
				async: false,
				cache: false,
				url: ctx+"/delectcustomerAddress.do",
				data:url,
				success : function(returnData){
					if(returnData=='true'){
						alert("删除成功");
						window.location.reload();
					}
					if(returnData=='false'){
						alert("删除失败");
					}
				},
				error : function(){
					alert('系统错误，删除失败!');
				}
		});
	}else{
		alert("不存在地址，删除失败");
	}	
}

//发票
function setinvoice(){
	var invoiceType=$("#con_invoiceType").val();
	var invoicePayable=$("#con_invoicePayable").val();
	var invoiceContent=$("#con_invoiceContent").val();
	if(invoicePayable==''){
		alert('请填写发票抬头')
		return;
	}
	$("#invoiceType").val(invoiceType);
	$("#invoicePayable").val(invoicePayable);
	$("#invoiceContent").val(invoiceContent);
	$("#iInvoices").css('display','none');
	$("#invoiceid").attr('checked','checked');
}

//弹出发票层
function invoiceDiv(obj){
	var invoiceType=$("#invoiceType").val();
	var invoicePayable=$("#invoicePayable").val();
	var invoiceContent=$("#invoiceContent").val();
	if(obj=='1'){
		$("#con_invoiceType").val(invoiceType);
		$("#con_invoicePayable").val(invoicePayable);
		$("#con_invoiceContent").val(invoiceContent);
	}else{
		$("#con_invoicePayable").val('');
	}
	$("#iInvoices").css('display','block');
}

//删除发票信息
function Delinvoice(){
	$("#invoiceType").val('');
	$("#invoicePayable").val('');
	$("#invoiceContent").val('');
}

//支付宝
function getbank_code(){
	var code=getRedio("bank_code");
//	alert(code);
}
//邮编6位限制
function zipCheck(){
	var invoiceType=$("#con_zipCode").val();
	if((invoiceType.length>5||event.keyCode<48||event.keyCode>57)&&event.keyCode!=8){
		event.cancelBubble=true;
		event.returnValue=false;
		return false;
	}
}
//退出登录
function loginOut(){
	if (confirm("您确定要退出吗?")){
		window.location.href=ctx+"/loginOut.do";
	}
}