<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/application_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />

<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/hyzx.js"></script>


<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
<script>
<!--
/*第一种形式 第二种形式 更换显示样式*/
function secBoard(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";

}
}
//-->

</script>
</head>
<body>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>云岗网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">云岗网上商城</a></div>
        <!--[if !IE]>订单中心<![endif]-->
        <script language=javascript id=clientEventHandlersJS>
<!--
var number=0;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = '${ctx }/Images/images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = '${ctx }/Images/images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = '${ctx }/Images/images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>订单中心</span><samp><IMG id="pic1" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM1>
            <ul>
<li><a href="${ctx }/orderManage.do">我的订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0">待付款订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=1">已取消订单<span>(<samp>2</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=1">已发货商品<span>(<samp>2</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=0">未发货商品<span>(<samp>2</samp>)</span></a></li>
<li id="bor"><a href="${ctx }/pingjiaTwo.do" >待评价商品<span>(<samp>2</samp>)</span></a></li>
</ul>
          </div>
        </div>
		 <!--[if !IE]>交易中心<![endif]-->
         <c:if test="${customer.type == '1'}">
         	 <div class="couponleft_text">
	          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>销售中心</span><samp><IMG id="pic2" 
	                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
	                 ></samp></A></div>
	          <div class="couponleft_text02" id=LM2 >
	            <ul>
	              <li><a href="sales.html">销售/收入</a></li>
	              <li id="bor"><a href="salesAnalysis.html" >销售/收入分析</a></li>
	            </ul>
	          </div>
	        </div>
         </c:if>
        <!--[if !IE]>交易中心<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>交易中心</span><samp><IMG id="pic3" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM3 >
            <ul>
              <li><a href="${ctx }/myFavorite.do">我的收藏<span>(<samp>2</samp>)</span></a></li>
<li id="bor"><a href="${ctx }/myCoupon.do">我的优惠券<span>(<samp>2</samp>)</span></a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>客户服务<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>客户服务</span><samp><IMG id="pic4" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM4>
            <ul>
              <li><a href="${ctx }/tuihuan.do">返修/退换货</a></li>
<li><a href="${ctx }/myMessage.do">我的咨询</a></li>
<li id="bor"><a href="${ctx }/myComment.do" >我的评价</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>个人中心<![endif]-->
        <div class="couponleft_text" >
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(5)" href="javascript:void(null)" ><span>个人中心</span><samp><IMG id="pic5" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM5>
            <ul>
            <li><a href="${ctx }/myinfor.do">个人信息</a></li>
<li><a href="${ctx }/security.do">安全设置</a></li>
<li id="bor"><a href="${ctx }/myaddress.do" >地址管理</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>end<![endif]-->
      </div>  
<!--[if !IE]>右侧<![endif]-->
   <div class="applyReturn_right">
<div class="applyright">
<div class="courht_title">
<span>申请返修/退换货</span>
</div>


<!--[if !IE]>申请退换货列表<![endif]-->
<input type="hidden" id="saleorderid" value="${saleOrder.id }"/>
<div class="courht_text2">
<div class="table">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="94" height="32" align="center" valign="middle">订单</td>
    <td width="320" align="center" valign="middle">商品</td>
    <td width="137" align="center" valign="middle">退换数量</td>
    <td width="137" align="center" valign="middle">商品价格</td>
    <td width="174" align="center" valign="middle">商品优惠</td>
    <td width="100"  align="center" valign="middle">赠送清单</td>
  </tr>
</table>
</div>
<div class="table1">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
<!--[if !IE]>列表1<![endif]-->
	<input type="hidden" id="size" value="${size }"/>
   <c:forEach items="${saleWareList}" var="ware" varStatus="i">
   	<input type="hidden" name="id${i.index}" id="id${i.index}" value="${ware.wareId}" />
	  <tr>
	    <td width="94"  align="center" valign="middle" class="borde">${saleOrder.code }</td>
	    <td width="320" align="left" valign="middle">
		<div class="phlist">
		<h1><a href="${ctx }/cpxq.do?good.id=${ware.goodId }"><img src="${ctx }${ware.goodPic }" border="0" /></a></h1>
		<h2><a href="${ctx }/cpxq.do?good.id=${ware.goodId }">${ware.goodName }</a></h2>
		</div>
		</td>
	    <td width="137" align="center" valign="middle">
		<div class="phlist_click">
		<h1><input name="" type="button" class="phlistbtn" onclick="changeNum(1,'${i.index }')"/></h1>
		<h2 id="count${i.index}">1</h2>
		<h1><input name="" type="button" class="phlistbtn1" onclick="changeNum(2,'${i.index }')"/></h1>
		</div>
		</td>
	    <td width="137" align="center" valign="middle"><span class="phlistys"><span class="bordefont">¥</span>${ware.goodPrice }</span></td>
	    <td width="174" align="center" valign="middle">单品促销优惠：<span class="bordefont">¥</span>0.0</td>
	    <td width="100" align="center" valign="middle">xx</td>
	  </tr>
   </c:forEach>
  <!--[if !IE]>列表1end<![endif]-->
</table>
</div>

</div>
<!--[if !IE]>列表结束<![endif]-->
<div class="courht_title1">
<h1>期望处理方式：</h1>
<h2><input name="returntype" type="radio" value="0" checked="checked" /></h2>
<h3>返修</h3>
<h2><input name="returntype" type="radio" value="1" /></h2>
<h3>换货</h3>
<h2><input name="returntype" type="radio" value="2" /></h2>
<h3>退货</h3>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
<span>*</span>问题描述：
</div>
<div class="applyReturn1_text"><textarea name="returnContent" id="returnContent" cols="" rows="" class="applyReturn1textera">请填写详细的商品问题信息，以使我们的售后人员及时判断并处理您的商品</textarea></div>
</div>
<div class="applyReturn2">
<h1>为了帮助我们更好的解决问题，欢迎您！</h1>
<h2><input name="" type="button"  class="applyReturn2btn" value="上传图片" /></h2>
</div>
<div class="applyReturn3">
最多可上传3张图片，支持bmp,gif,png,,jpeg格式文件,文件小于800KB
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
<span>*</span>返修凭据：
</div>
<div class="applyReturn1_text">
<h4><input name="isinvoice" type="checkbox" id="checkbox" value="1" checked/></h4>
<h2>有发票</h2>
</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
<span>*</span>商品附件：
</div>
<div class="applyReturn1_text">
<h4><input name="introDelivery" type="radio" value="0" checked="checked"/></h4><h2>有</h2>
<h4><input name="introDelivery" type="radio" value="1"/></h4><h2>无</h2>
</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
<span>*</span>期望商品返回方式：
</div>
<div class="applyReturn1_text1">
<h1><input name="returngoodtype" type="radio" value="0" checked="checked"/></h1>
<h2>客户送货</h2>
<h3><a href="#">周边自提点</a></h3>
</div>
</div>
<div class="applyReturnf1">
<div class="applyReturn1_title">

</div>
<div class="applyReturn1_text1">
<h1><input name="returngoodtype" type="radio" value="1" /></h1>
<h2>客户邮寄商品</h2>
<h3><a href="#">查询售后地址</a></h3>
</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
<span>*</span>收货地址：
</div>
<div class="applyReturn1_text1">
<h1><input name="returnAddress" type="radio" value="0"  checked="checked"/></h1>
<h2>与取货地址相同</h2>
<h4>换/修玩抽将发回该地址</h4>
</div>
</div>
<div class="applyReturnf1">
<div class="applyReturn1_title">
</div>
<div class="applyReturn1_text1">
<h1><input name="returnAddress" type="radio" value="1" /></h1>
<h2>与取货地址不同</h2>
</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
</div>
	<div class="applyReturn1_text2">
	    <h1>
	    	<div id="selectTest0" style="display:none;"></div>
		    <select class="applyReturn1_text2select" name="" id="option1" onchange="selectCity(this,'option2',0)">
		    	<option value=""></option>
		        <c:forEach items="${areaList}" var="area">
		            <option value="${area.id }">${area.name }</option>
		     	</c:forEach>
		    </select>
	    </h1>
		<h1><div id="selectTest1" style="display:none;"></div><select class="applyReturn1_text2select" name="" id="option2" onchange="selectCity(this,'option3',1)"></select></h1>
		<h1><div id="selectTest2" style="display:none;"></div><select class="applyReturn1_text2select" name="" id="option3" onchange="selectCity(this,'',2)"></select></h1>
	</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
</div>
<div class="applyReturn1_text2">
<h1><input name="street" id="street" type="text"  class="applyReturn1_text2input"/></h1>
</div>
</div>
<div style="height:10px; width:600px; float:left;"></div>
<div class="applyReturn1">
<div class="applyReturn1_titlen1">
<span>*</span>姓名：
</div>
<div class="applyReturn1_text3">
<h1><input name="customerName" value="${customer.name }" type="text"  class="applyReturn1_text2input1"/></h1>
<h2><span>*</span>手机号：</h2>
<h1><input name="customerMobile" value="${customer.mobile }" type="text"  class="applyReturn1_text2input1"/></h1>
</div>
</div>
<div class="applyReturn1">
<div class="applyReturn1_title">
</div>
<div class="applyReturn1_text4">
<h1><input name="" type="button" class="applyReturn2btn1" onclick="saveApplication()" /></h1><!-- window.open('results.html') -->
<h1><input name="" type="button" class="applyReturn2btn2" /></h1>
</div>
</div>
</div><!--[if !IE]>右侧结束<![endif]-->
</div>   
    <!--[if !IE]>右侧结束<![endif]-->
</div>
</div>
  <!--[if !IE]>待付款订单完成<![endif]-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
