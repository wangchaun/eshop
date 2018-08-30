<%@page import="java.util.ArrayList"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<%@page import="com.sinokj.code.util.CreditUtil" %>  
<% String bean=(String)request.getSession().getAttribute("jd2");
   String cardmoney=(String)request.getSession().getAttribute("cardmoney2");
   ArrayList<String>cards=(ArrayList<String>)session.getAttribute("cards2");
   int temp=(int)CreditUtil.getMinMoney();
   double jd=0;
   if(bean==null){
	   jd=0;
   }else{
	   jd=Double.valueOf(bean);
   }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/confirmOrder_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />

<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/confirmOrder1.js"></script>

<script type="text/javascript" src="${ctx }/scripts/front/customer/jquery.provincesCity.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/provincesdata.js"></script>
<%if(jd==0.0){%>
<script type="text/javascript">
$(document).ready(function(){
   $(".bs-t").css("display","block");
   $(".bs-mm").css("display","block");
   $(".bs-m").css("display","none");
   $('#money1DIVjd').css("display","none");
    
})
</script>
<%}else{ %>
<script type="text/javascript">
$(document).ready(function(){
   $(".bs-t").css("display","none");
   $(".bs-m").css("display","block");
   $(".bs-mm").css("display","none"); 
   $('#money1DIVjd').css("display","block");
})
</script>
<%}%>
<%if(cards==null){%>
<script type="text/javascript">
$(document).ready(function(){
   $("#money1DIVcard").css("display","none");
   for(i=1;i<=5;i++){
     cancel(i);
     $("#use-"+i).html("");
   } 
})
</script>
<%}else{ %>
<script type="text/javascript">
$(document).ready(function(){
   
   $("#money1DIVcard").css("display","block");
   <% ArrayList<String>cardss=(ArrayList<String>)session.getAttribute("cardmoneys2");%>
   <% for(int i=0,j=1;i<cards.size();j++,i++){%>

	     <% String[] card=cards.get(i).split(",");String cardMoney=cardss.get(i);%>
	     $("#lpkKeyPressFirst"+"-"+<%=j%>).val('<%=card[0]%>');
	     $("#lpkKeyPressSecond"+"-"+<%=j%>).val('<%=card[1]%>');
	     use(<%=j%>);
	     $("#use-"+<%=j%>).html('卡内余额:<%=cardMoney%>元');
   <%}%>	   
})
</script>
<%}%>
<script>
$(document).ready(function(){
  $("#test").ProvinceCity();
  
  $("#usedBeans").keyup(function(){
       
      var credit=$(this).val();
      var money=credit/<%=temp%>;
      if(credit==''){
          $(".bs-t").addClass("failure");
          $("#error").css('display','block');
          $("#error").html('请输入正常的数字');
          $(".append").html(''); 
         return;
      }
      //检验输入的是否是整数
      if(/\D/.test(credit)){
           $(".bs-t").addClass("failure");
           $("#error").css('display','block');
           $("#error").html('请输入正常的数字');
           return;
      }
      $("#error").html('');
      $(".bs-t").removeClass("failure");
      $.ajax({
        type: "POST",
		async: false,
		cache: false,
		url: ctx+"/searchCreadit.do",
	    data: {credit:credit},
		success : function(returnData){
		 
		 if(returnData!='true'){
		   $(".bs-t").addClass("failure");
           $("#error").css('display','block');
           $("#error").html('您本次最多可以使用'+returnData+'积分');  
		   return ;
		 }
		 $(".append").html(",使用<s>"+credit+"</s>积分，折合人民币￥<b>"+(money).toFixed(2)+"</b>元");
		},
		error : function(){
			alert('系统错误!');
		} 
  }); 
  });
   
});
/*使用积分支付*/
function userBean(){
  var bean=$('#usedBeans').val();
  if(bean==''){
         return false;
   }
  $('#showUsedJdBean').css("display","block"); 
  $.ajax({
        type: "POST",
		async: false,
		cache: false,
		url: ctx+"/userBeanTwo.do",
	    data: {credit:bean},
		success : function(returnData){
	     
		 if(returnData=='false'){
		     return ;
		 }
		 if(returnData=='ok'){
		     alert("应付金额为0,不需要再使用积分.");
		     return;
		 }
		 if(returnData=='more'){
		     alert("使用积分过多,请重新输入!");
		     return;
		 }
		 var result=returnData.split(",");
		 $("#money1DIVjd").css("display","block");
	 	 
		 $("#usedJd").html("-¥"+result[0]);
		 $("#surmeryt1").html("<span>¥</span>"+result[1]); 
		 $("#surmeryt").html("<span>¥</span>"+result[1]);
		 $(".bs-t").css("display","none");	 
		 $(".bs-m").css("display","block");
		 $(".bs-mm").css("display","none");
		 $(".append").html("");
		 $('#usedBeans').val("");
		 $('#usedJdBean').html("本次使用<s>"+bean+"</s>个积分支付，折合人民币<b>￥"+result[0]+"</b>元<a onclick=\"return beanCancal();\" class=\"a-link\" href=\"javascript:void(0);\">取消使用</a>"); 
	 	 },
		error : function(){
			alert('系统错误!');
		} 
     }); 
   
}
/*取消积分支付*/
function beanCancal(){
   
    $.ajax({
        type: "POST",
		async: false,
		cache: false,
		url: ctx+"/CancelBean2.do",
		success : function(returnData){
		  
		 $(".bs-t").css("display","block");
         $(".bs-m").css("display","none");
         $(".bs-mm").css("display","block");
         $("#money1DIVjd").css("display","none");
         $("#surmeryt").html("<span>¥</span>"+returnData);
         $("#surmeryt1").html("<span>¥</span>"+returnData);  
	 	 },
		error : function(){
			alert('系统错误!');
		} 
     }); 
}
/*显示或隐藏积分兑换*/
function showOrHideJdBean(){
   var classname= $("#orderBeanItem").attr("class");
    
   if(classname=='item'){
    $("#jdBeans").css("display","block");
    $("#orderBeanItem").removeClass("item");
    $("#orderBeanItem").addClass(" toggle-active");
   }else{
    $("#jdBeans").css("display","none");
    $("#orderBeanItem").removeClass(" toggle-active");
    $("#orderBeanItem").addClass("item");
    $('#usedBeans').val('');
    $('.append').html('');
    $('#error').html('');  
   }
}
/*隐藏或显示卡号*/
function query_giftCards(){
   var classname=$("#orderECardItem").attr("class");
    
   if(classname=='item'){
    $("#eCardId").css("display","block");
    $("#orderECardItem").removeClass("item");
    $("#orderECardItem").addClass(" toggle-active");
    
   }else{
    $("#eCardId").css("display","none");
    $("#orderECardItem").removeClass(" toggle-active");
    $("#orderECardItem").addClass("item");
   }
}
/*使用卡号*/
function userCard(obj,giftCardType,flag){
    if ($("#lpkKeyPressFirst"+"-"+giftCardType).val() == ""
			|| $("#lpkKeyPressSecond"+"-"+giftCardType).val() == "") {
		alert("请输入卡号帐号或密码");
		return;
	}
	var key = $("#lpkKeyPressFirst"+"-"+giftCardType).val()+","+ $("#lpkKeyPressSecond"+"-"+giftCardType).val();
	
	useOrCancelGiftCard(key,giftCardType,flag);
}
/*使用或隐藏按钮*/
function cancel(giftCardType){
    
   $("#cancel-"+giftCardType).css("visibility","hidden");
   $("#btnadd-"+giftCardType).css("visibility","visible");
   $('input[id=lpkKeyPressFirst-'+giftCardType+']').removeAttr("disabled"); 
   $('input[id=lpkKeyPressSecond-'+giftCardType+']').removeAttr("disabled"); 
}
function use(giftCardType){
   $("#cancel-"+giftCardType).css("visibility","visible");
   $("#btnadd-"+giftCardType).css("visibility","hidden");
   $('input[id=lpkKeyPressFirst-'+giftCardType+']').attr("disabled","disabled"); 
   $('input[id=lpkKeyPressSecond-'+giftCardType+']').attr("disabled","disabled");
}
/*使用或取消*/
function useOrCancelGiftCard(key,giftCardType,flag) {

	var param ="giftCardKey=" + key;
    if(flag==0){
      url=ctx+"/cancelMaterialGiftCard2.do";
      jQuery.ajax( {
		type : "POST",
		url : url,
		data : param,
		async : true,
		cache : false,
		success : function(result) {
			if(result=="false"){
			   alert("false");
				return;
			}else if(result=="error"){
			    alert("违法行为...");
			    return;
			}else{
			    var count=result.split(",");  
			    cancel(giftCardType);
			    $("#use-"+giftCardType).html("");
			    if(count[0]=='0'){
			      $("#money1DIVcard").css("display","none");
			      $('#lpk_count').html(0);
			      $('#lpk_discount').html(0);
			    }else{
			     $('#lpk_count').html(count[0]);
			     $('#lpk_discount').html(count[2]);
		         $('#money1DIVcard').html("<h1>一卡通&nbsp;&nbsp;&nbsp;：</h1><h2><span class='price' id='usedJd'>-¥"+count[2]+"</span></h2>"); 
			    }
			    $("#surmeryt").html('<span>¥</span>'+count[3]);
			    $("#surmeryt1").html('<span>¥</span>'+count[3]);
			} 
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
              alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
              alert( '系统错误!');
        } 
		
	  });
       
    }else{
        url=ctx+"/useMaterialGiftCard2.do"; 
	    jQuery.ajax( {
		type : "POST",
		url : url,
		data : param,
		async : true,
		cache : false,
		success : function(result) {
		     
			if(result=="false"){
				alert("密码或卡号错误");
				return;
			}else if(result=="ok"){
			    alert("已经不需要再使用一卡通");
			    return;
			}else{
			    var count=result.split(",");  
			    use(giftCardType);
			    $("#money1DIVcard").css("display","block");
			    $("#use-"+giftCardType).html("卡内余额:"+count[1]+"元");
			    $('#lpk_count').html(count[0]);
			    $('#lpk_discount').html(count[2]);
			    $("#surmeryt").html('<span>¥</span>'+count[3]);
			    $("#surmeryt1").html('<span>¥</span>'+count[3]);
		        $('#money1DIVcard').html("<h1>一卡通&nbsp;&nbsp;&nbsp;：</h1><h2><span class='price' id='usedJd'>-¥"+count[2]+"</span></h2>");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
              alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
              alert( '系统错误!');
        } 
	});
	}
}
/**校验卡号是否重复**/
$(document).ready(function(){
    var  key1,key2,key3,key4,key5;
    
    $("#lpkKeyPressFirst"+"-"+1).keyup(function(){
      key1=$("#lpkKeyPressFirst"+"-"+1).val();
      inputKey(key1,0);
    });
    $("#lpkKeyPressFirst"+"-"+2).keyup(function(){
      key2=$("#lpkKeyPressFirst"+"-"+2).val();
      inputKey(key2,1);
    });
    $("#lpkKeyPressFirst"+"-"+3).keyup(function(){
      key3=$("#lpkKeyPressFirst"+"-"+3).val();
      inputKey(key3,2);
    });
    $("#lpkKeyPressFirst"+"-"+4).keyup(function(){
      key4=$("#lpkKeyPressFirst"+"-"+4).val();
      inputKey(key4,3);
    });
    $("#lpkKeyPressFirst"+"-"+5).keyup(function(){
      key5=$("#lpkKeyPressFirst"+"-"+5).val();
      inputKey(key5,4);
    });
     
    
});
/*校验卡信息..*/
function inputKey(key,flag){
      
     if(key==''){
       return;
     }
     var keys=new Array();
     for(i=0,j=1;i<=5;i++,j++){
       keys[i]=$("#lpkKeyPressFirst"+"-"+j).val(); 
     }
     
     for(i=0;i<5;i++){
        if(i==flag){
         continue;
        }
        if(keys[flag]==keys[i]){
         var temp=flag+1;
         alert("卡号重复...");
         $("#lpkKeyPressFirst"+"-"+temp).val("");
         break;
        }
     }
      　
}
</script>
<script>
//完成下拉框选择时的模拟行为
function changeSelect(formV,toV){
    document.getElementById(toV).innerHTML = formV.options[formV.selectedIndex].text;
}
function changeDiv(tag,method){
  document.getElementById(tag).style.display = method;
}
</script>

</head>
<body>
<div class="box">
<!--[if !IE]>和确认订单中的加盟店长是一样的<![endif]-->
  <!--[if !IE]>头部<![endif]-->
  <div class="ctop">
    <div class="top_con">
     <div class="top_ctext">您好 ，欢迎您！<span id="top_ctextys"><c:if test="${loginCustomer!=null }">${loginCustomer.code }</c:if></span></div>
      <div class="top_ctext1">
        <input name="" type="button" class="subbmit" onclick="loginOut()" value="退出" />
      </div>
     <div class="top_ctext2"><span class="ys1">
		<c:if test="${loginCustomer!=null }"><a href="${ctx }/customersManage.do" target="_blank">我的商城</a> |</c:if>
      <c:if test="${loginCustomer==null }"><a href="javascript:void(0);" onclick="myShops()">我的商城</a> |</c:if>
	</span><span class="ys2"><img src="${ctx}/Images/images/a1.jpg" /></span>
	<span class="ys3"><a href="${ctx}/ShoppingCar.do">购物车<c:if test="${shoppingCarSize==null}">0</c:if>${shoppingCarSize }件</a> 
      	
        | <a href="${ctx}/infor.do?information.type=7" >帮助中心</a>
      	</span>
      	</div>
    </div>
     
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
      <div class="topf">
        <div class="logo">
           <div class="logo01">
           <c:forEach items="${advertiseList}" var="promotionActivity">
           <c:if test="${promotionActivity.placeId=='LOG'}"> 
	       <a href="${ctx }/index.do"><img src="${ctx}${promotionActivity.pic }" /></a>
	       </c:if>
	       </c:forEach>
           </div>
        <!--[if !IE]>购物车步骤<![endif]-->
        <div class="shopcart">
          <h1>1、我的购物车</h1>
          <h2>2、填写核对订单信息 </h2>
          <h3>3、成功提交订单</h3>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>收货信息 <![endif]-->
    <div class="lookproduct"><span>收货信息 </span></div>
    <!--[if !IE]>收货信息 <![endif]-->
    <input id="linkman" type="hidden" value="$"/>
    <input id="province" type="hidden" value=""/>
    <input id="city" type="hidden" value=""/>
    <input id="region" type="hidden" value=""/>
    <input id="street" type="hidden" value=""/>
    <input id="zipCode" type="hidden" value=""/>
    <input id="mobile" type="hidden" value=""/>
    <input id="customerAdds" type="hidden" value=""/>

    <div class="confirm">
    	<c:forEach items="${customerAddressList}" var="cusAddress">
	      <div class="confirm_text">
	        <h1>
	          <input name="areaclick" type="radio" onclick="hiddenAddress()" id="radio_area_1" value="${cusAddress.id }"  <c:if test="${cusAddress.whetherordrer=='0' }">checked="checked"</c:if>/>
	        </h1>
	        <h2>${cusAddress.name }&nbsp;${cusAddress.address }&nbsp;${cusAddress.street }&nbsp;${cusAddress.zipCode }&nbsp;${cusAddress.mobile }&nbsp;</h2>
	        <h3><a href="javascript:newDisplayAdress('${cusAddress.id }','${cusAddress.name }','${cusAddress.address }','${cusAddress.street }','${cusAddress.zipCode }','${cusAddress.mobile }','${cusAddress.phone }')">修改</a> | <a href="javascript:delectAdress('${cusAddress.id }')">删除</a></h3>
	      </div>	      
      	</c:forEach>
      	<input type="hidden" id="customerAddressId" value=""/>
      <div class="confirm_text">
        <h1>
          <input name="areaclick" type="radio" onclick="newAddress()" id="radio_area_2" value="2" <c:if test="${customerAddressList==null}">checked="checked"</c:if> />
        </h1>
        <h2>新地址</h2>
      </div>
      <div id="newAdress" <c:if test="${customerAddressList!=null}">style="display: none"</c:if>>
		<div class="confirm_text1">
		    <h1><span>*</span>收件人姓名：</h1>
		    <h2>
		       <input id="con_linkman" type="text"  class="confirminput" value="${customerAddress.name }"/>
		    </h2>
	    </div>
	     
      	<div class="confirm_text1">
	       	<h3><span>*</span>省市区：</h3>
			
			<div id="test"></div>
		</div>
		<div class="confirm_text1" >
	        <h1></h1>
	        <h2>
	          <input type="hidden" name="" id="address1" type="text"  />
              <input type="hidden" name="" id="address2" type="text"  />
              <input type="hidden" name="" id="address3" type="text"  />  
	        </h2>
		</div>
      	
		<div class="confirm_text1">
	        <h1><span>*</span>街道地址：</h1>
	        <h2>
	          <input id="con_street" type="text"  class="confirminput1" value="${customerAddress.street }"/>
	        </h2>
		</div>
		<div class="confirm_text1">
	        <h1><span>*</span>邮政编码：</h1>
	        <h2>
	          <input id="con_zipCode" type="text"  class="confirminput" value="${customerAddress.zipCode }"/><!-- onkeydown="zipCheck()" -->
	        </h2>
		</div>
		<div class="confirm_text1">
	        <h1><span>*</span>手机号码：</h1>
	        <h2>
	          <input id="con_mobile" type="text"  class="confirminput" value="${customerAddress.mobile }"/>
	        </h2>
		</div>
		<div class="confirm_text1">
	        <h1><span>*</span>电话号码：</h1>
	        <h2>
	          <input id="con_phone" type="text"  class="confirminput" value="${customerAddress.phone }"/>
	        </h2>
		</div>
		<div class="confirm_text1">
	        <h4>
			<!--[if !IE]>收获信息确认按钮<![endif]-->
	          <input type="button"  class="confirmbtn" onclick="setinformation()"/>
	        </h4>
		</div>
	   </div>			
    </div>
    <!--[if !IE]>配送方式<![endif]-->
    <div class="lookproduct"><span>配送方式</span></div>
    <div class="confirm">
      <c:forEach items="${deliveryList}" var="delivery" varStatus="i">
	      <div class="confirm_text">
	        <h1>
	          <input name="saleOrder.deliveryId" type="radio" value="${delivery.id }" <c:if test="${i.index=='0' }">checked="checked"</c:if> onclick="selectdeliveryfee('${delivery.deliveryFee}')"/>
	        </h1>
	        <h5>${delivery.name}</h5>
	        <!-- 
	        <h5>${delivery.deliveryFee}</h5>
	        
	        <h3><a href="${ctx }/infor.do?information.id=3B74DAD74177D1635FD0DD0B85567AC7" target="_blank">查看商城配送的适用范围</a></h3>
	        -->
	      </div>
      </c:forEach>
      <div class="confirm_text">
        <h4>取货时间</h4>
      </div>
      <div class="confirm_text">
        <h1>
          <input name="saleOrder.deliveryDate" type="radio" value="0"  checked="checked"/>
        </h1>
        <h2>周一到周五9:00-17:00</h2>
      </div>
      <!-- 
      <div class="confirm_text">
        <h1>
          <input name="saleOrder.deliveryDate" type="radio" value="1"/>
        </h1>
        <h2>作日、双休及节假日都可以取</h2>
      </div>
      <div class="confirm_text">
        <h1>
          <input name="saleOrder.deliveryDate" type="radio" value="2"/>
        </h1>
        <h2>双休日、节假日取</h2>
      </div>
       -->
    </div>
    <!--[if !IE]>支付方式<![endif]-->
    <div class="lookproduct1"><span>支付方式</span><span style="margin-left:30px;color:red;">《《一卡通能抵扣商品金额》》</span></div>
    
    <div class="confirm">
    
    <c:forEach items="${paymentList}" var="payment">
             <div class="confirm_text2">
                <c:if test="${payment.code=='card'}">
		        <h1>
		          <input name="saleOrder.paymentId" type="radio" value="${payment.id }" checked="checked"/>
		        </h1>
		        </c:if>
		        <c:if test="${payment.code!='card'}">
		        <h1>
		          <input name="saleOrder.paymentId" type="radio" value="${payment.id }" checked="checked"/>
		        </h1>
		        </c:if>
		        <h2>${payment.name }</h2>
		        <h4>备注:${payment.remark } </h4>
		      </div>
     </c:forEach>
   
      
      <!--[if !IE]>网上银行<![endif]-->
      <div class="Payment">
         
        <div class="Payment03">乾付宝</div>
        <div class="Payment02">
          <ul>
            <li>
              <h1>
                <input name="bank_code" type="radio" value="qfb" checked="checked" />
              </h1>
              <h2><img src="${ctx }/Images/bank/qfb.jpg" /></h2>
            </li>
          </ul>
        </div>
       
      </div>
      <!--[if !IE]>网上银行结束<![endif]-->
    </div>
    
   
    <!--[if !IE]>商品清单<![endif]-->
    <div class="lookproduct5"><span>商品清单</span><samp><a href="${ctx }/ShoppingCar.do">返回购物车修改</a></samp></div>
    <!--[if !IE]>商品清单列表<![endif]-->
    <div class="itemList">
      <table width="1199" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="itemListborder" height="42" width="33"></td>
          <td width="627" align="left" valign="middle" class="itemListborder">产品</td>
          <td width="100" align="center" valign="middle" class="itemListborder">数量</td>
          <!-- <td width="100" align="center" valign="middle" class="itemListborder">服务</td> -->
           
          <td width="100" align="center" valign="middle" class="itemListborder">价格</td>
          <td width="139" align="center" valign="middle" class="itemListbg1">小计 </td>
         </tr>
		 <tr>
	          <td width="33" height="42" align="center" valign="middle" class="itemListborder1"></td>
	          <td width="627" align="left" valign="middle" class="itemListborder1"><div class="phlist">
	              <h2><a href="${ctx }/cpxq.do?good.id=${good.id}" target="_blank"><img src="${ctx }${good.pic }" border="0" /></a></h2>
	              <h3><a href="${ctx }/cpxq.do?good.id=${good.id}" target="_blank">${good.name }</a></h3>
	          </div></td>
	          <td width="100" align="center" valign="middle" class="itemListborder1"><span class="itemListys">1</span></td> 
	          <td width="100" align="center" valign="middle" class="itemListborder1"><span class="font">¥<span>${good.price }</td>
	          <td width="139" align="center" valign="middle" class="itemListbg"><span class="font">¥<span>${good.price}</td>
	     </tr>
      </table>
    </div>
	<!--[if !IE]>订单结算<![endif]-->
	<div class="itemList2">
	 
	<!--[if !IE]>总运算<![endif]-->
	<div class="itemList202">
	<div class="itemList20201" id="money1DIV"><h1>合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计：</h1><h2><samp>¥</samp>${good.price }</h2></div>	
	<div class="itemList20201" id="money1DIVjd"><h1>积&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分：</h1><h2><span class="price" id="usedJd">-¥<%=jd%></span></h2></div>
	<c:if test="${good.price-jd2-cardmoney2>0}">
	<div class="itemList20201" id="money1DIVcard"><h1>一卡通&nbsp;&nbsp;&nbsp;：</h1><h2><span class="price" id="usedJd">-¥<%=cardmoney%></span></h2></div>
	</c:if>
	<c:if test="${good.price-jd2-cardmoney2<=0}">
	<div class="itemList20201" id="money1DIVcard"><h1>一卡通&nbsp;&nbsp;&nbsp;：</h1><h2><span class="price" id="usedJd">-¥${good.price-jd2}</span></h2></div>
	</c:if>
	<c:if test="${good.price-jd2-cardmoney2>0}">
	 <div class="itemList20201" id="money2DIV"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt"><span>¥</span> ${good.price-jd2-cardmoney2}</h4></div>
	</c:if>
	<c:if test="${good.price-jd2-cardmoney2<=0}">
	  <div class="itemList20201" id="money2DIV"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt"><span>¥</span> 0.00</h4></div>
	</c:if>
	<c:if test="${jd2==0.0&&cardmoney2==0.0}">
	 <div class="itemList20201" id="money2DIV"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt"><span>¥</span> ${good.price}</h4></div> 
	</c:if>
	<!--[if !IE]>总运算结束<![endif]-->
	</div>
	 <!-- 积分支付开始 -->
	 <div class="itemList20203">
	 <div class="item" id="orderBeanItem">
		<div class="toggle-title"><a class="toggler" href="javascript:void(0)" onclick="showOrHideJdBean()"><b></b>使用积分兑换</a></div>
		<div class="toggle-wrap" id="jdBeans" style="display: none;">
		<div class="cbox" id="">
 	    <div class="beans">
		<!-- 未使用过积分 -->
		 
		<div class="bs-t">
			<span>本次使用</span>
			<input  class="bs-num" id="usedBeans" type="text">
			<span>积分支付</span>
			<input  value="使用" class="btn-add" type="button" onclick="return userBean();"/>
			<label class="error" for="userBeans" id="error"></label>
		</div>
		<div class="bs-mm">
		    <span class="rest">您有<s>${customer.credit }</s>积分，本次可用<b>${customer.credit }</b>积分</span><span class="append"><span>
		</div>
		<div class="bs-m">
			<!-- 使用过积分 -->
			<span class="rest" id="usedJdBean">本次使用<s><%=(int)(jd*100)%></s>个积分支付，折合人民币<b>￥<%=jd%></b>元<a onclick="return beanCancal();" class="a-link" href="javascript:void(0);">取消使用</a></span>					    
		</div>		
	    </div>
        </div>
	<!--  -->
		</div>
	 </div>
	<!-- 积分支付结束 -->
	<!-- 礼品卡开始 -->
	 <div class="item" id="orderECardItem">
	    <div class="toggle-title"><a class="toggler" href="javascript:void(0)" onclick="query_giftCards()"><b></b>使用一卡通</a></div>
		<div class="toggle-wrap" id="eCardId" style="display:none;">
		<div class="cbox" id="ecard">
		<div class="inner">
        <div class="tip">提示：一个订单最多能使用5张卡号</div>
	    <div class="gift-item form gift-form">
        <h4>使用卡号支付</h4>
 
        <div class="group">
            <span class="label">请输入您手中&nbsp;&nbsp;卡号：</span>
            <input id="lpkKeyPressFirst-1" class="textbox1" maxlength="12" type="text">
            <span class="label-dashes">-</span>
            
            <span class="label">密码:</span>
            <input id="lpkKeyPressSecond-1" class="textbox" maxlength="6" type="password">
            <span class="label-dashes">-</span>
            <span id="use-1"> </span>
            <input class="btn-add" value="使用" id="btnadd-1"onclick="javascript:userCard(this,1,1);" type="button"/>
            <input class="btn-cancel" value="取消" id="cancel-1" onclick="javascript:userCard(this,1,0);" type="button" style="visibility: hidden;"/>
        </div>
        <div class="group">
            <span class="label">请输入您手中&nbsp;&nbsp;卡号：</span>
            <input id="lpkKeyPressFirst-2" class="textbox1" maxlength="12" type="text">
            <span class="label-dashes">-</span>
            
            <span class="label">密码:</span>
            <input id="lpkKeyPressSecond-2" class="textbox" maxlength="6" type="password"/>
            <span class="label-dashes">-</span>
            <span id="use-2"></span>
            <input class="btn-add" value="使用" id="btnadd-2" onclick="javascript:userCard(this,2,1);" type="button"/>
            <input class="btn-cancel" value="取消" id="cancel-2" onclick="javascript:userCard(this,2,0);" type="button" style="visibility: hidden;"/>
        </div>
        <div class="group">
            <span class="label">请输入您手中&nbsp;&nbsp;卡号：</span>
            <input id="lpkKeyPressFirst-3" class="textbox1" maxlength="12" type="text"/>
            <span class="label-dashes">-</span>
            
            <span class="label">密码:</span>
            <input id="lpkKeyPressSecond-3" class="textbox" maxlength="6" type="password"/>
            <span class="label-dashes">-</span>
            <span id="use-3"></span>
            <input class="btn-add" value="使用" id="btnadd-3" onclick="javascript:userCard(this,3,1);" type="button"/>
            <input class="btn-cancel" value="取消" id="cancel-3" onclick="javascript:userCard(this,3,0);" type="button" style="visibility: hidden;"/>
        </div> 
        <div class="group">
            <span class="label">请输入您手中&nbsp;&nbsp;卡号：</span>
            <input id="lpkKeyPressFirst-4" class="textbox1" maxlength="12" type="text">
            <span class="label-dashes">-</span>
            
            <span class="label">密码:</span>
            <input id="lpkKeyPressSecond-4" class="textbox" maxlength="6" type="password">
            <span class="label-dashes">-</span>
             <span id="use-4"></span>
            <input class="btn-add" value="使用" id="btnadd-4" onclick="javascript:userCard(this,4,1);" type="button"/>
            <input class="btn-cancel" value="取消" id="cancel-4" onclick="javascript:userCard(this,4,0);" type="button" style="visibility: hidden;"/>
        </div>
        <div class="group">
            <span class="label">请输入您手中&nbsp;&nbsp;卡号：</span>
            <input id="lpkKeyPressFirst-5" class="textbox1" maxlength="12" type="text">
            <span class="label-dashes">-</span>
            
            <span class="label">密码:</span>
            <input id="lpkKeyPressSecond-5" class="textbox" maxlength="6" type="password">
            <span class="label-dashes">-</span>
            <span id="use-5" style="display:none;"></span>
            <input class="btn-add" value="使用" id="btnadd-5" onclick="javascript:userCard(this,5,1);" type="button"/>
            <input class="btn-cancel" value="取消" id="cancel-5" onclick="javascript:userCard(this,5,0);" type="button" style="visibility: hidden;"/>
            
            
        </div>
    </div>
    <%if(cards!=null){%>
      <div class="total">共使用了 <strong id="lpk_count"><%=cards.size()%></strong>张卡可以抵扣
         <c:if test="${good.price-jd2-cardmoney2<0}">
        <strong id="lpk_discount">${totalMoney-jd}</strong> 元
         </c:if>
         <c:if test="${good.price-jd2-cardmoney2>=0}">
        <strong id="lpk_discount">${cardmoney2 }</strong> 元
         </c:if>
      </div>
    <%}else{%>  
     <div class="total">共使用了 <strong id="lpk_count">0</strong>张卡可以抵扣
        <strong id="lpk_discount">0</strong> 元
      </div>
    <%}%>
    <div class="">
		<input id="hiddenPayPrice-3" value="1999.00"   type="hidden">
		<input id="hiddenUsedBalance-3" value="0.00"  type="hidden">
		<input id="hiddenGiftCardDiscount-3" value="0.00"  type="hidden">
		<input id="hiddenBindFlag-3" value="false"  type="hidden">
		<input id="hiddenGiftCardType-3" value="3"   type="hidden">
	</div>
	
</div>
</div>
</div>
	 </div>
	 </div>
    <!-- 礼品卡结束 -->
	
	<!--[if !IE]>订单运算结束<![endif]-->
  </div>
	<!-- 订单按钮提交 -->
	<div class="itemList20205">
	 <c:if test="${good.price-jd2-cardmoney2>0}">
	 <div class="itemList20209" id="money2DIV2"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt1"><span>¥</span> ${good.price-jd2-cardmoney2}</h4></div>
	 </c:if>
	 <c:if test="${good.price-jd2-cardmoney2<=0}">
	  <div class="itemList20209" id="money2DIV2"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt1"><span>¥</span> 0.00</h4></div>
	 </c:if>
	  <c:if test="${jd2==0.0&&cardmoney2==0.0}">
	 <div class="itemList20209" id="money2DIV2"><h1>&nbsp;应付总额：</h1><h4 id="surmeryt1"><span>¥</span> ${good.price}</h4></div> 
	  </c:if>
	  <div class="itemList20202btn1">
	     <input name="" type="button" class="itemList20202btn" onclick="sumbitOrder()"/>
	  </div>
	</div>
   <!--[if !IE]>注释<![endif]-->
   <!--  <div style="font-size:30px; font-weight:bold; text-align:center; color:#FF0000;">和确认订单中的加盟店长是一样的(收获信息里没有新地址，下面没有合计和优惠券金额)</div>-->
   <!--[if !IE]>注释完成<![endif]-->
   <!--[if !IE]>中间完成<![endif]-->
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
<!--  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" style="padding-top:0px;"></iframe>-->
  
</div>

</body>
</html>
