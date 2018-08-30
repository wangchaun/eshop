<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/header_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/brand_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/styles/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
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
  
<div class="content">
    <!--[if !IE]>品牌管<![endif]-->
	  <!--[if !IE]>品牌管分类<![endif]-->
    <div class="brand">
      <div class="brand1">
        <h1>
          <input name="" type="button" class="brandbtn" value="全部品牌" />
        </h1>
        <h2>
          <input name="" type="button" class="brandbtn1" value="家电" onclick="window.open('${ctx}/brandDetail.do')"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="卫浴"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="手机"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="相机"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="家居"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="办公设备"/>
        </h2>
        <h2>
          <input name="" type="button" class="brandbtn1" value="汽车用品"/>
        </h2>
      </div>
    </div>
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
	<!--[if !IE]>品牌管的分类列表<![endif]-->
	<div class="brand3">
		<div class="brand301"><span>A</span></div>
		<div class="brand302"><ul>
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
			<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
			<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
			</ul>
		</div>
	</div>
	<!--[if !IE]>品牌管的分类列表<![endif]-->
	<div class="brand3">
		<div class="brand301"><span>B</span></div>
		<div class="brand302"><ul>
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
		<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
		<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
		<li><a href="#"><img src="${ctx}/Images/images/brand4.jpg" border="0" /></a></li>
		</ul></div>
	</div>
	<!--[if !IE]>品牌管的分类列表结束<![endif]-->
    <!--[if !IE]>品牌管完成<![endif]-->
  </div>
  
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp" %>
</div>
</body>
</html>
