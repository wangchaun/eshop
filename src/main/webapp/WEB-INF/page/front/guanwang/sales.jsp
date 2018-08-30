<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/sales_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/unintHY.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <!--[if !IE]>待付款订单<![endif]-->
  <div class="content">
    <div class="coupon">
      <!--[if !IE]>左侧<![endif]-->
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
	              <li><a href="${ctx }/lianmengSales.do" id="visited">销售/收入</a></li>
	              <li id="bor"><a href="${ctx }/salesAnalysis.do" >销售/收入分析</a></li>
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
<li id="bor"><a href="${ctx }/myCoupon.do" >我的优惠券<span>(<samp>2</samp>)</span></a></li>
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
<span>销售/收入</span>
</div>
<div class="sales">
<h1><samp>累计总销售额：</samp><span>2969.00</span><samp>元</samp></h1>
<h1><samp>累计返点返点收入：</samp><span>2969.00</span><samp>元</samp></h1>
</div>
<div class="sales1"><h2>以下订单销售额总计：</h2><h1>2969.00</h1><h2>元</h2><h3>返点收入金额总计：</h3><h1>2969.00</h1><h2>元</h2></div>
<div class="sales2">
	<div class="sales201">
		<select name="" class="applyfirstselect" id="createTime" onchange="saleUnionOrderJson(this.value)">
			<option value="0">最近一月订单</option>
			<option value="1">所有订单</option>
		</select>
	</div>
<div class="sales202">
<h1>按时间查询：</h1>
	<h3><input type="text" name="" id="createTime1" size="20" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></h3>
<h2>至</h2>
	<h3><input type="text" name="" id="createTime2"  size="20" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></h3>
<h3><input name="" type="button"  class="salesbtn" value="确定" onclick="saleUnionOrderJson()"/></h3>
</div>
</div>
<!--[if !IE]>我的咨询列表<![endif]-->
<div class="courht_text2">
<div class="table">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="140" height="32" align="center" valign="middle">订单号</td>
    <td width="135" align="center" valign="middle">销售额 </td>
    <td width="27" align="center" valign="middle"> </td>
	<td width="135" align="center" valign="middle">时间</td>
	<td width="27" align="center" valign="middle"> </td>
	<td width="100" align="center" valign="middle">返点比例</td>
	<td width="197" align="center" valign="middle">返点收入</td>
	<td width="27" align="center" valign="middle"></td>
    <td width="174"  align="left" valign="middle">返点状态</td>
  </tr>
</table>
</div>
<div class="table1" id="table1">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
<!--[if !IE]>列表1<![endif]-->
   <tr>
    <td width="140"  align="center" valign="middle" class="leftborder" height="45">123456789</td>
    <td width="135" align="center" valign="middle"><span class="font">¥</span>2.00</td>
    <td width="27" align="center" valign="middle"></td>
	<td width="135" align="center" valign="middle"><span class="fys">2012-10-12</span></td>
	<td width="27" align="center" valign="middle"></td>
	<td width="100" align="center" valign="middle">20%</td>
	<td width="197" align="center" valign="middle"><span class="font">¥</span>2.00</td>
	<td width="27" align="center" valign="middle"></td>
    <td width="174"  align="left" valign="middle">返点成功</td>
  </tr>
  <!--[if !IE]>列表1end<![endif]-->
</table>
</div>
</div>
<!--[if !IE]>列表结束<![endif]-->
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
