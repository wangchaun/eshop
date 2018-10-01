<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/results_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/tuihuan.js"></script>
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
<!--[if !IE]>麦芽网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">麦芽网上商城</a></div>
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
              <li><a href="${ctx }/tuihuan.do" id="visited">返修/退换货</a></li>
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
<div class="apply">
<div class="apply_title5">
<span>返修退换货申请/查看</span>
</div>
<!--[if !IE]>订单详情<![endif]-->
<div class="apply_title2">
<div class="apply_title201">
<h1>订单号：${saleReturn.code }</h1>
<h2>状态:<span><c:if test="${saleReturn.returnState=='2'}">已解决</c:if><c:if test="${saleReturn.returnState=='1'}">待客户确认</c:if><c:if test="${saleReturn.returnState=='0'}">未解决</c:if></span></h2>
<h3>申请时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${saleReturn.createTime }" /></h3>
<h3><c:if test="${saleReturn.state=='s' && saleReturn.returnState=='1'}"><input name="" type="button"  class="orderDetails201btn2" value="确认" onclick="updateReturnSate('${saleReturn.id }')"/></c:if></h3>
</div>
<div class="apply_title202">本次返修已处理完毕！希望我们的服务令您满意，感谢您的支持，谢谢！</div>
</div>
<!--[if !IE]>返修申请流程<![endif]-->
<div class="apply_title3">
<!-- 流程状态图 -->
	<c:if test="${saleReturn.state=='c'}"><img src="${ctx }/Images/images/pue1.jpg" /></c:if>
	<c:if test="${saleReturn.state=='s' && saleReturn.returnState=='0'}"><img src="${ctx }/Images/images/pu7.jpg" /></c:if>
	<!-- <c:if test="${saleReturn.state=='s' && saleReturn.returnState=='1'}"><img src="${ctx }/Images/images/pue3.jpg" /></c:if> -->
	<c:if test="${saleReturn.state=='s' && saleReturn.returnState=='1'}"><img src="${ctx }/Images/images/pue4.jpg" /></c:if>
	<c:if test="${saleReturn.returnState=='2' && saleReturn.state=='s'}"><img src="${ctx }/Images/images/pu6.jpg" /></c:if>
</div> 
<div class="apply_title4">
<h1>提交申请</h1>
<h2>客服审核</h2>
<h3>商品处理</h3>
<h4>完成</h4>
<h5>客户确认</h5>
</div> 
<!--[if !IE]>订单跟踪处理<![endif]-->
<div class="apply_title5">
<span>订单跟踪</span>
</div>
<!--[if !IE]>订单跟踪处理列表<![endif]-->
<div class="apply_title6">
<table width="934" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="227" height="30" align="left" valign="middle" class="tableborder">处理时间</td>
    <td width="480" align="left" valign="middle" class="tableborder">处理信息</td>
    <td width="227" align="left" valign="middle" class="tableborder">操作人</td>
  </tr>
  <tr class="tablefont">
    <td  width="227" height="35" align="left" valign="middle"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${saleReturn.createTime }" /></td>
    <td  width="480" height="35" align="left" valign="middle">提交申请成功</td>
    <td  width="227" height="35" align="left" valign="middle">${customer.name }</td>
  </tr>
  <c:if test="${saleReturn.state=='s'}">
  	  <tr class="tablefont">
	    <td  width="227" height="35" align="left" valign="middle"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${saleReturn.orderstateTime }" /></td>
	    <td  width="480" height="35" align="left" valign="middle">客服已审核</td>
	    <td  width="227" height="35" align="left" valign="middle">${saleReturn.modifierName }</td>
	  </tr>
  </c:if>
  <c:if test="${saleReturn.returnTime!=''}">
  	  <tr class="tablefont">
	    <td  width="227" height="35" align="left" valign="middle"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${saleReturn.returnTime }" /></td>
	    <td  width="480" height="35" align="left" valign="middle">商品处理成功</td>
	    <td  width="227" height="35" align="left" valign="middle">${saleReturn.modifierName }</td>
	  </tr>
  </c:if>
  <c:if test="${saleReturn.returnState=='2'}">
  	  <tr class="tablefont">
	    <td  width="227" height="35" align="left" valign="middle"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${saleReturn.receiveTime }" /></td>
	    <td  width="480" height="35" align="left" valign="middle">已确认收货</td>
	    <td  width="227" height="35" align="left" valign="middle">${customer.name }</td>
	  </tr>
  </c:if>

</table>
</div>
<!--[if !IE]>详细信息<![endif]-->
<div class="apply_title5">
<span>详细信息</span>
</div>
<div class="apply_title6">
<table width="934" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="110" height="30" align="left" valign="middle" class="tablefont1">商品名称</td>
    <td width="824" align="left" valign="middle" class="tablefont">
    	<c:forEach items="${saleWareList}" var="good">
    		<span>${good.goodName }</span><br/>
    	</c:forEach>
    </td>
  </tr>
   <tr>
    <td width="110" height="30" align="left" valign="middle" class="tablefont1">问题描述</td>
    <td width="824" align="left" valign="middle" class="tablefont">${saleReturn.returnContent }</td>
  </tr>
    <tr>
    <td width="110" height="30" align="left" valign="middle" class="tablefont1">附件清单</td>
    <td width="824" align="left" valign="middle" class="tablefont">
    	<c:if test="${saleReturn.isinvoice=='0'}">无</c:if><c:if test="${saleReturn.isinvoice=='1'}">有</c:if>
    </td>
  </tr>
     <tr>
    <td width="110" height="30" align="left" valign="middle" class="tablefont1">商品价格及优惠</td>
    <td width="824" align="left" valign="middle" class="tablefont">
    	<c:forEach items="${saleWareList}" var="good">
			<span>商品价格￥${good.goodPrice }元</span>&nbsp;&nbsp;&nbsp;&nbsp;优惠￥0.0元<br/>
    	</c:forEach>
    </td>
  </tr>
</table>
</div>
<!--[if !IE]>详细信息结束<![endif]-->
</div>
<!--[if !IE]>右侧结束<![endif]-->
</div>
</div>
</div>
  <!--[if !IE]>待付款订单完成<![endif]-->
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
