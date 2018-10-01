<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/tuangou_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/styles/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%> 
<script> 
	d = document.getElementById("nav1"); 
	var aa = d.getElementsByTagName("a"); 
	aa[3].className = "link_on";   //加载默认
	d.l = aa[3]; 
	for(var i in aa){ 
		var a = aa[i]; 
			a.onclick = function(){
			if(d.l==this){
				return; 
			}else{
				this.className = d.l.className; 
				d.l.className = ""; 
				d.l = this; 
			}
		}; 
	};
</script>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>热门团购<![endif]-->
  <div class="limitbuy">
   <div class="limitbuy01"><span>秒杀商品</span></div>
    <!--[if !IE]>整个团购<![endif]-->
    <div class="hotbuy">
	 <!--[if !IE]>左侧<![endif]-->
	 <c:forEach items="${goodList}" var="good">
	<div class="hotbuy_left">
	<div class="hotbuy_left01">
	<div class="hotbuy_left02">
	<div class="hotbuy_text">
	<h1><span>${good.name }</span><br />
	  <samp>${good.introBrief}</samp></h1>
	</div>
	<div class="hotbuy_text2">
	<div class="hotbuy_text201"><img src="${ctx}${good.pic }" width="422" height="278" border="0" /></div>
	<div class="hotbuy_text202">
	<div class="hotmoney">
	<h1>¥</h1>
	<h2><fmt:formatNumber value="${good.priceGroupBuy }" pattern="0.00"/></h2>
	<h3><input name="" type="button"  class="hotmoneybtn" onclick="window.location.href='${ctx }/cpxq.do?good.id=${good.id }'"/></h3>
	</div>
	<div class="hotmoney1">
	<h1>原价：<span>￥<fmt:formatNumber value="${good.priceMarket}" pattern="0.00"/></span></h1>
	<h2>|</h2>
	<h1>优惠：￥<fmt:formatNumber value="${good.priceMarket-good.priceGroupBuy }" pattern="0.00"/></h1>
	</div>
	<div class="hotmoney2">
	<h1><span>${good.groupNumber }</span>人已经购买</h1>
	<h2><span><img src="${ctx}/Images/images/hot5.jpg" /></span>数量有限，下单要快呦</h2>
	</div>
	<div class="hotmoney3">
	<h2><span><img src="${ctx}/Images/images/hot6.jpg" /></span><samp>支持7天退款</samp></h2>
	<h2><span><img src="${ctx}/Images/images/hot7.jpg" /></span><samp>支持过期退款</samp></h2>
	</div>
	</div>
	</div>
	</div>
	
	</div>
	
	</div>
	
	<!--[if !IE]>左侧结束<![endif]-->
	<!--[if !IE]>右侧<![endif]-->
	<div class="hotbuy_right"><a href="detail.html"><img src="${ctx}/Images/images/hot8.jpg" border="0" /></a></div>
	</c:forEach>
	<!--[if !IE]>右侧结束<![endif]-->
	</div>
	 <!--[if !IE]>整个团购完成<![endif]-->
	 <!--[if !IE]>整个团购<![endif]-->
    
   <!--[if !IE]>热门团购完成<![endif]-->
  </div>
  
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</div>

</body>
</html>
