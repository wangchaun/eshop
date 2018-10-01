<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/help_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/lanrentuku.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/lrscroll.js"></script>
<script type="text/javascript" src="www.1wandian.com" charset="utf-8" data-callback="true"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
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
<div class="coupon_leftsecond">
<div class="couponleft_titlesecond">帮助中心</div>
<!--[if !IE]>购物指南<![endif]-->
<div class="couponleft_textsecond">
<script language=javascript id=clientEventHandlersJS>
<!--
var number=0;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = 'images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = '${ctx}/Images/images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = '${ctx}/Images/images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
</script>
<div class="couponleft_text01second"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>购物指南</span><samp><IMG id="pic1" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
 
<div class="couponleft_text02second"  id=LM1>
<ul>
<c:forEach items="${informationList}" var="infor">
<c:if test="${infor.type=='3'}">
<li><a href="${ctx}/infor.do?information.id=${infor.id }" id="<c:if test="${information.id==infor.id }">visited</c:if>">${infor.title }</a></li>
</c:if>
</c:forEach>
</ul>
</div>
</div>
<!--[if !IE]>货物配送<![endif]-->
<div class="couponleft_textsecond1">
<div class="couponleft_text01second"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>货物配送</span><samp><IMG id="pic2" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
<div class="couponleft_text02second" id=LM2>
<ul>
<c:forEach items="${informationList}" var="infor">
<c:if test="${infor.type=='4'}">
<li><a href="${ctx}/infor.do?information.id=${infor.id }" id="<c:if test="${information.id==infor.id }">visited</c:if>">${infor.title }</a></li>
</c:if>
</c:forEach>
</ul>
</div>
</div>
<!--[if !IE]>支付方式<![endif]-->
<div class="couponleft_textsecond1">
<div class="couponleft_text01second"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>支付方式</span><samp><IMG id="pic3" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
 
<div class="couponleft_text02second"  id=LM3>
<ul>
<c:forEach items="${informationList}" var="infor">
<c:if test="${infor.type=='5'}">
<li><a href="${ctx}/infor.do?information.id=${infor.id }" id="<c:if test="${information.id==infor.id }">visited</c:if>">${infor.title }</a></li>
</c:if>
</c:forEach>
</ul>
</div>
</div>
<!--[if !IE]>售后服务<![endif]-->
<div class="couponleft_textsecond1">
<div class="couponleft_text01second"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>售后服务</span><samp><IMG id="pic4" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
 
<div class="couponleft_text02second"  id=LM4>
<ul>
<c:forEach items="${informationList}" var="infor">
<c:if test="${infor.type=='6'}">
<li><a href="${ctx}/infor.do?information.id=${infor.id }" id="<c:if test="${information.id==infor.id }">visited</c:if>">${infor.title }</a></li>
</c:if>
</c:forEach>
</ul>
</div>
</div>
<!--[if !IE]>售后服务<![endif]-->
<div class="couponleft_textsecond1">
<div class="couponleft_text01second"><A onclick="javascript:ShowFLT(5)" href="javascript:void(null)" ><span>关于我们</span><samp><IMG id="pic5" 
                  height=14 src="${ctx}/Images/images/bit07.gif" width=14
                 ></samp></A></div>
 
<div class="couponleft_text02second"  id=LM5>
<ul>
<c:forEach items="${informationList}" var="infor">
<c:if test="${infor.type=='7'}">
<li><a href="${ctx}/infor.do?information.id=${infor.id }" id="<c:if test="${information.id==infor.id }">visited</c:if>">${infor.title }</a></li>
</c:if>
</c:forEach>
</ul>
</div>
</div>



<!--[if !IE]>end<![endif]-->
</div>
<!--[if !IE]>右侧<![endif]-->
<div class="coupon_right">
<div class="courht">
<div class="courht_title">
<span>${information.title }</span>
</div>
<!--[if !IE]>订单搜索<![endif]-->
<div class="help">
${information.content }

</div>
</div>
</div><!--[if !IE]>右侧结束<![endif]-->
</div>
</div>
<!--[if !IE]>待付款订单完成<![endif]-->
      <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
  </div>
</body>
</html>

