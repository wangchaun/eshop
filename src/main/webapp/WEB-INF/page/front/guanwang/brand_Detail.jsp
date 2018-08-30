<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/brand_Detail.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/brand.js"></script>

</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <script> 
	d = document.getElementById("nav1"); 
	var aa = d.getElementsByTagName("a"); 
	aa[4].className = "link_on";   //加载默认
	d.l = aa[4]; 
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
<div class="content">
   <!--[if !IE]>品牌管<![endif]-->
  <div class="brand">
    <div id="Tab2">
    <input type="hidden" id="brandTypeId"/>
	 <div class="Menubox">
		<ul>
			<li id="menu" onclick="secBoard(this,'','')" class="hover">全部品牌</li>
			<c:forEach items="${brandTypeList}" var="type">
				<li id="menu" onclick="secBoard(this,'${type.id }','')">${type.name }</li>
			</c:forEach>
		</ul>
	</div>
<div class="Contentbox" >
 <!--[if !IE]>全部品牌<![endif]-->
<div id="con_two_1">
<!--[if !IE]>按照字母检索的分类<![endif]-->
    <div class="brand2">
      <h1 onclick="secBoard('','','#')">全部</h1>
      <ul>
        <li onclick="secBoard('','','A')">A</li>
        <li onclick="secBoard('','','B')">B</li>
        <li onclick="secBoard('','','C')">C</li>
        <li onclick="secBoard('','','D')">D</li>
        <li onclick="secBoard('','','E')">E</li>
        <li onclick="secBoard('','','F')">F</li>
        <li onclick="secBoard('','','G')">G</li>
        <li onclick="secBoard('','','H')">H</li>
        <li onclick="secBoard('','','I')">I</li>
        <li onclick="secBoard('','','J')">J</li>
        <li onclick="secBoard('','','K')">K</li>
        <li onclick="secBoard('','','L')">L</li>
        <li onclick="secBoard('','','M')">M</li>
        <li onclick="secBoard('','','N')">N</li>
        <li onclick="secBoard('','','O')">O</li>
		<li onclick="secBoard('','','P')">P</li>
		<li onclick="secBoard('','','Q')">Q</li>
		<li onclick="secBoard('','','R')">R</li>
		<li onclick="secBoard('','','S')">S</li>
		<li onclick="secBoard('','','T')">T</li>
		<li onclick="secBoard('','','U')">U</li>
		<li onclick="secBoard('','','V')">V</li>
		<li onclick="secBoard('','','W')">W</li>
		<li onclick="secBoard('','','X')">X</li>
		<li onclick="secBoard('','','Y')">Y</li>
		<li onclick="secBoard('','','Z')">Z</li>
      </ul>
    </div>
	<!--[if !IE]>品牌管的分类列表<![endif]-->
	<div class="brand3">
		<div class="brand301"><span id="first">#</span></div>
		<div class="brand302">
			<ul id="brands">				
				<c:forEach items="${brandlist}" var="brand">
					<li><a href="${ctx }/shoptype.do?good.brandId=${brand.id }"><img src="${ctx}${brand.pic }" border="0" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

</div>
<!--[if !IE]>家电<![endif]-->
<div id="con_two_2" style="display:none;" >
<!--[if !IE]>按照字母检索的分类<![endif]-->
    <div class="brand2">
      <h1><a href="#">全部</a></h1>
      <ul>
        <li><a href="#">A</a></li>
        <li><a href="#">B</a></li>
        <li><a href="#">C</a></li>
        <li><a href="#">D</a></li>
        <li><a href="#">E</a></li>
        <li><a href="#">F</a></li>
        <li><a href="#">G</a></li>
        <li><a href="#">H</a></li>
        <li><a href="#">I</a></li>
        <li><a href="#">J</a></li>
        <li><a href="#">K</a></li>
        <li><a href="#">L</a></li>
        <li><a href="#">M</a></li>
        <li><a href="#">N</a></li>
        <li><a href="#">O</a></li>
		<li><a href="#">P</a></li>
		<li><a href="#">Q</a></li>
		<li><a href="#">R</a></li>
		<li><a href="#">S</a></li>
		<li><a href="#">T</a></li>
		<li><a href="#">U</a></li>
		<li><a href="#">V</a></li>
		<li><a href="#">W</a></li>
		<li><a href="#">X</a></li>
		<li><a href="#">Y</a></li>
		<li><a href="#">Z</a></li>
      </ul>
    </div>
<!--	[if !IE]>品牌管的分类列表<![endif]-->
	<div class="brand3">
	<ul>
	<li><a href="search.html"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
	</ul>
	</div>

</div>
<!--[if !IE]>卫浴<![endif]-->
<div id="con_two_3" style="display:none">卫浴</div>
<!--[if !IE]>手机<![endif]-->
<div id="con_two_4" style="display:none">新闻列表4</div>
<!--[if !IE]>电脑<![endif]-->
<div id="con_two_5" style="display:none">新闻列表2</div>
<!--[if !IE]>相机<![endif]-->
<div id="con_two_6" style="display:none">新闻列表3</div>
<!--[if !IE]>家具<![endif]-->
<div id="con_two_7" style="display:none">新闻列表4</div>
<!--[if !IE]>办公设备<![endif]-->
<div id="con_two_8" style="display:none">新闻列表3</div>
<!--[if !IE]>汽车用品<![endif]-->
<div id="con_two_9" style="display:none">新闻列表4</div>
<!--[if !IE]>汽车用品结束<![endif]-->
</div>
</div>
<!--    <div class="Menubox2">-->
<!--	<span><a href="detail.html"><img src="${ctx}/Images/images/brand6.jpg" /></a></span>-->
<!--	</div>-->
  </div>
   <!--[if !IE]>限时抢购完成<![endif]-->
    
  </div>
  
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
