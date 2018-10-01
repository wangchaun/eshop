<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx }/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/styles/front/style/taocan_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx }/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script>
var curr = 'outter0';
function changeBg(id) {
    
	var cur=document.getElementById(id);
	
	cur.style.background = "#fff5f5";
	
	
}
function changeBg1(id) {
    
    if( id!= curr) {
		var cur=document.getElementById(id);
		
		cur.style.background = "#ffffff";
	}
	
	
}
<!--
/*第一种形式 第二种形式 更换显示样式*/
function secBoard(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+"_"+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
var outter0 = document.getElementById('outter0'),
outter1 = document.getElementById('outter1'),
outter2 = document.getElementById('outter2');

if(name ==0) {
    curr = 'outter0';
	outter0.style.background = "#fff5f5";
	outter1.style.background = "#ffffff";
	outter2.style.background = "#ffffff";
}else if(name ==1) {
    curr = 'outter1';
	outter0.style.background = "#ffffff";
	outter1.style.background = "#fff5f5";
	outter2.style.background = "#ffffff";
}else {
	curr = 'outter2';
	outter0.style.background = "#ffffff";
	outter1.style.background = "#fff5f5";
	outter2.style.background = "#ffffff";
}

}
}
//-->
</script>
</head>
<body>
<div class="box">
<div class="box">
  <!--[if !IE]>头部<![endif]-->
  <div class="ctop">
    <div class="top_con">
     <div class="top_ctext">您好，欢迎您！<span id="top_ctextys">monica</span></div>
      <div class="top_ctext1">
        <input name="" type="button" class="subbmit" value="退出" />
      </div>
      <div class="top_ctext2"><span class="ys1"><a href="myshop.html" target="_parent">麦芽网上商城</a> |</span><span class="ys2"><img src="${ctx}/Images/images/a1.jpg" /></span><span class="ys3"><a href="shoppingCart.html" target="_parent">购物车0件</a> | <a href="#">售后服务</a></span></div>
    </div>
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
      <div class="topf">
        <div class="logo">
          <div class="logo01"><<a href="${ctx }/index.do"><img src="${ctx}/Images/images/logo2.jpg" /></a></div>
          <ul id="nav">
            <li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">深圳站</span></a>
              <ul  class="sub">
                <iframe frameborder="0" class="b1"></iframe>
                <li>
                  <div id="fy">
                    <c:forEach items="${areaList}" var="area1">
		                   	  <div id="fy1"><span>${area1.name}</span>
				                <c:forEach items="${area1.areaList}" var="area2">
				                  <a href="${ctx }/index.do?area.id=${area2.id }&area.name=${area2.name }">${area2.name}</a>
				                </c:forEach>
		                   	  </div>		
		                   </c:forEach>    
		                    <div id="fy2"></div>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <!--[if !IE]>选号入网步骤<![endif]-->
        <div class="shopcart">
          <h1>1、选择号码</h1>
          <h2>2、选择套餐 </h2>
          <h3>3、填写用户信息</h3>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>号码信息<![endif]-->
    <div class="lookproduct"><span>号码信息 </span></div>
    <div class="package">
	<div class="package01">
	<h1>您选择的号码<span class="package02ys">：</span></h1>
	<h2>${good.name }</h2>
	<h3><a href="#">修改</a></h3>
	</div>
	<div class="package02">
	<h1>号码包含话费：</h1>
	<h2>${good.price}元</h2>
	</div>
	<div class="package02">
	<h1>归属地：</h1>
	<h2>${goodPrice.areaName }</h2>
	</div>
	</div>
    <div class="lookproduct"><samp>选择号码套餐</samp></div>
    <div class="packagenumber">
	<h1>合约期：</h1>
	<h2>24个月</h2>
	</div>
	<c:forEach items="${goodAttrList}" var="goodAttr" varStatus="i">
    <div class="packagenumber1" id="outter${i.index}" onmouseover="changeBg('outter${i.index}')" onmouseout="changeBg1('outter${i.index}')">
	<div class="packagenumber101">
	<div class="packagenumber101_text">
	<h1>${goodAttr.name }</h1>
	<h2>${goodAttr.remark}</h2>
	</div>
	<div class="packagenumber101_text1">
	<div id="Tab2">
 <div class="Menubox">
<ul>
<c:forEach items="${goodAttr.goodKingValList}" var="goodKingVal" varStatus="k">
<c:if test="${k.index==0}">
<li id="${i.index}_1" onclick="secBoard('${i.index}',1,2)"  class="hover">${goodKingVal.value }</li>
</c:if>
<c:if test="${k.index==1}">
<li id="${i.index}_2" onclick="secBoard('${i.index}',2,2)" >${goodKingVal.value }</li>
</c:if>
</c:forEach>
</ul>
</div>
<c:forEach items="${goodAttr.goodKingValList}" var="goodKingVal" varStatus="k">
<div class="Contentbox">
<c:if test="${k.index==0}">
<div id="con_${i.index}_1">
<div class="mtable">
  ${goodKingVal.remark }
</div>
</div>
</c:if>
<c:if test="${k.index==1}">
<div id="con_${i.index}_2" style="display:none">${goodKingVal.remark }</div>
</c:if>
</div>
</c:forEach>
</div>
	</div>
	</div>
	</div>
	</c:forEach>

<div class="pick2"><input name="" type="button"  class="pickbtn1" onclick="window.open('${ctx }/information1.do')"/></div>
  </div>
  
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
