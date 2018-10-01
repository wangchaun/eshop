<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/tuihuan_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
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
<li><a href="${ctx }/orderManage.do">我的订单<span>(<samp>${total }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0">待付款订单<span>(<samp>${payment }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=1">已取消订单<span>(<samp>${cancelOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=1">已发货商品<span>(<samp>${deliveryOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=0">未发货商品<span>(<samp>${deliveryOrder2 }</samp>)</span></a></li>
<li id="bor"><a href="${ctx }/pingjiaTwo.do" >待评价商品<span>(<samp>${commentOrder}</samp>)</span></a></li>
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
              <li><a href="${ctx }/myFavorite.do">我的收藏<span>(<samp>${favolist }</samp>)</span></a></li>
              <li id="bor" style="display:none;"><a href="${ctx }/myCoupon.do" >我的优惠券<span>(<samp>${couponList }</samp>)</span></a></li>
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
<div class="applyright">
<div class="courht_title">
<span>退货</span>
</div>
<div id="Tab2">
<div class="Menubox">
<ul>
<li id="two1" onclick="secBoard('two',1,2)"  class="hover">返修/退换货申请</li>
<li id="two2" onclick="secBoard('two',2,2)" >返修/退换货查询</li>
</ul>
</div>
<div class="Contentbox">
<div id="con_two_1" >
<div class="applyfirst">
	<h1>
		<select name="" class="applyfirstselect" id="createTime" onchange="saleReturnJson()">
			<option value="0">最近一个月订单</option>
			<option value="1">所有订单</option>
		</select>
	</h1>
<h2><span><input name="" type="text" id="search"  class="applyfirstinput" onblur="if(this.value=='') {this.value='商品编号/订单号';}" onfocus="if(this.value=='商品编号/订单号') {this.value='';}" value="商品编号/订单号"/></span><samp><input name="" type="button"  class="applyfirstbtn" onclick="saleReturnJson()"/></samp></h2>
</div>
<!--[if !IE]>申请退换货列表<![endif]-->
<div class="courht_text2">
<div class="table">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="110" height="32" align="center" valign="middle">订单</td>
    <td width="345" align="center" valign="middle">商品</td>
    <td width="302" align="center" valign="middle"></td>
    <td width="90" align="center" valign="middle">下单时间</td>
    <td width="115"  align="center" valign="middle">操作</td>
  </tr>
</table>
</div>
<div class="table1" id="table2">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
<!--[if !IE]>列表1<![endif]-->
 
  <!--[if !IE]>列表1end<![endif]-->
</table>
</div>
<div class="applyfirst2">返修/退换货申请常见问题</div>
<div class="applyfirst3">
1. “申请”按钮若为灰色，可能是因为订单尚未完成或该商品正在翻修/退换货中；<br />
2. 查看<span><a href="#">返修/退换货流程；</a></span><br />
3. 查看<span><a href="#">返修/退换货政策；</a></span></div>
<div class="applyfirst2">退换货须知</div>
<div class="applyfirst3">
1. 7天无理由退换货的：消费者凭发票自开具发票之日起算，商品、外包装及配件完好无损并未使用，不影响二次销售的，需顾客承担商品往返的运费。（不属于7天内 无质  量问题退换货的产品：手机、相机、显示器、内存、主板、显卡、硬盘、CPU等、电池、线缆、光存储、办公设备等附件耗材、空调、厨卫产品）<br />
2. 自开具发票之日起，7天内有质量问题，客户可选择退货、换货、维修；15天内，客户可选择换
货、维修；符合国家“三包”法所规定的其它功能性故障造成的退换货。<br />
3. 商品损坏：A公司配送到客户家，客户签收前发现商品损坏；B快递物流配送的，客户必须当场验
货签收（也可以签收后当场验货，必须与派送员完成验收工作），商品有问题时拒收并及时联系销售员，必须在快递单备注栏注明“物流快递损坏退回”等字样。<br />
4. 商品因质量问题需退换货的，顾客必须提供厂家出具有效的商品质量鉴定单，鉴定商品属质量问题符合退换货条件的方可办理退换货手续；不符合退换货条件的特殊顾客需办理退换货时，将由我公司相关部门进行审核后告知是否可进行退换货。

</div>
</div>
<!--[if !IE]>列表结束<![endif]-->
</div>
<!--[if !IE]>返修/退换货查询<![endif]-->
<div id="con_two_2" style="display:none">
<!--[if !IE]>申请退换货列表<![endif]-->
<div class="courht_text2">
<div class="table">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="160" height="32" align="center" valign="middle">订单</td>
    <td width="340" align="center" valign="middle">商品</td>
    <td width="78" align="center" valign="middle"></td>
    <td width="140" align="center" valign="middle">申请时间</td>
    <td width="125"  align="center" valign="middle">状态</td>
	<td width="119"  align="center" valign="middle">操作</td>
  </tr>
</table>
</div>
<div class="table1">
<table width="962" border="0" cellspacing="0" cellpadding="0" align="center">
<!--[if !IE]>列表1<![endif]-->
	<c:forEach items="${saleReturnList}" var="order">
	  <tr>
	    <td width="160"  align="center" valign="middle" class="leftborder">${order.code }</td>
	    <td width="340" align="left" valign="middle">
	    	<c:forEach items="${order.goodlist}" var="good">
				<div class="phlist">
					<h1></h1>
					<h2><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx }${good.pic }" border="0" /></a></h2>
					<h3><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }</a></h3>
				</div>
			</c:forEach>
		</td>
	      <td width="78" align="center" valign="middle"></td>
	    <td width="140" align="center" valign="middle"><div class="cotrol1"><fmt:formatDate pattern="yyyy-MM-dd" value="${order.createTime }" /></div></td>
	    <td width="125" align="center" valign="middle">
	    	<c:if test="${order.returnState=='2'}">已解决</c:if><c:if test="${order.returnState=='0'}">未解决</c:if>
	    </td>
	    <td width="119" align="center" valign="middle"><span class="cotrolys"><a href="${ctx }/results.do?saleReturn.id=${order.id }">查看</a></span></td>
	  </tr>
	 </c:forEach>
  <!--[if !IE]>列表1end<![endif]-->
</table>
</div>

</div>
<!--[if !IE]>列表结束<![endif]-->
</div>
<!--[if !IE]>返修/退换货查询结束<![endif]-->
</div>
</div>
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
