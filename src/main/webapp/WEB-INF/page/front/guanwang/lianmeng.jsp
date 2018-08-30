<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/lianmeng_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/style/Vizo-style.css" media="all" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery-1.6.2.min.js">
</script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){					   
$(".item1").hover(function(){$("#tit_fc1").slideDown("normal");	}, function() {$("#tit_fc1").slideUp("fast");});				
$(".item2").hover(function(){$("#tit_fc2").slideDown("normal");	}, function() {$("#tit_fc2").slideUp("fast");});
$(".item3").hover(function(){$("#tit_fc3").slideDown("normal");	}, function() {$("#tit_fc3").slideUp("fast");});
$(".item4").hover(function(){$("#tit_fc4").slideDown("normal");	}, function() {$("#tit_fc4").slideUp("fast");});
});			   
var currentindex=1;
$("#flashBg").css("background-color",$("#flash1").attr("name"));
function changeflash(i) {	
currentindex=i;
for (j=1;j<=5;j++){//此处的5代表你想要添加的幻灯片的数量与下面的5相呼应
	if (j==i) 
	{$("#flash"+j).fadeIn("normal");
	$("#flash"+j).css("display","block");
	$("#f"+j).removeClass();
	$("#f"+j).addClass("dq");
	$("#flashBg").css("background-color",$("#flash"+j).attr("name"));
	}
	else
	{$("#flash"+j).css("display","none");
	$("#f"+j).removeClass();
	$("#f"+j).addClass("no");}
}}
function startAm(){
timerID = setInterval("timer_tick()",5000);//8000代表间隔时间设置
}
function stopAm(){
clearInterval(timerID);
}
function timer_tick() {
    currentindex=currentindex>=5?1:currentindex+1;//此处的5代表幻灯片循环遍历的次数
	changeflash(currentindex);}
$(document).ready(function(){
$(".flash_bar div").mouseover(function(){stopAm();}).mouseout(function(){startAm();});
startAm();
});

 //]]>
</script>


<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript">
//<![CDATA[
DD_belatedPNG.fix('.flash_bar,#tit_fc1,#tit_fc2,#tit_fc3,#tit_fc4,#flashLine,#leftIcon1,#leftIcon2,#leftIcon3');
 //]]>
</script>
<![endif]-->
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
  <!--[if !IE]>banner<![endif]-->
   <div id="Slidebox"> 
  <!--flash begin-->
  <div id="flashBg">
    <div id="flashLine">
      <div id="flash"> 
      <a name="#ffffff" style="display:block;" id="flash1" target="_blank" href="#"><img src="${ctx}/Images/images/Slides-1.png" width="1200" height="425"></a>
      <a name="#ffffff" style="display:block" id="flash2" target="_blank" href="Conference.html"><img src="${ctx}/Images/images/Slides-2.png" width="1200" height="425"></a> 
      <a name="#ffffff" id="flash3" target="_blank" href="ProductFeatures.html"><img src="${ctx}/Images/images/Slides-3.png" width="1000" height="425"></a> 
      <a name="#ffffff" id="flash4" target="_blank" href="ProductValue.html"><img src="${ctx}/Images/images/Slides-4.png" width="1000" height="425"></a> 
      <a name="#ffffff" id="flash5" target="_blank" href="#"><img src="${ctx}/Images/images/Slides-5.png" width="1000" height="425"></a>
        <div class="flash_bar">
          <div class="dq"  id="f1" onclick="changeflash(1)"></div>
          <div class="no"  id="f2" onclick="changeflash(2)"></div>
          <div class="no"  id="f3" onclick="changeflash(3)"></div>
          <div class="no"  id="f4" onclick="changeflash(4)"></div>
          <div class="no"  id="f5" onclick="changeflash(5)"></div>
        </div>
      </div>
    </div>
  </div>
  </div>
   <!--[if !IE]>中间<![endif]-->
   <div class="content01">
   <div class="sub">
   <div class="sub01">
   <img src="${ctx}/Images/images/oneshop2.jpg" />
   <img src="${ctx}/Images/images/oneshop3.jpg" />
   <img src="${ctx}/Images/images/oneshop4.jpg" />
   </div>
   </div>
   </div>
   </div>
   <div class="sub02">
   <div class="sub0201">
   <div class="Tab2content">
   <!--[if !IE]>联盟店选项卡<![endif]-->
   <div id="Tab2">
<div class="Menubox">
<span>深圳家电网欢迎您的加盟!</span>
<ul>
<li id="one1" onclick="secBoard('one',1,4)"  class="hover">华南联盟馆 </li>
<li id="one2" onclick="secBoard('one',2,4)" >华北联盟馆</li>
<li id="one3" onclick="secBoard('one',3,4)">华中联盟馆</li>
</ul>
</div>
<div class="Contentbox">
<!--[if !IE]>华南联盟馆<![endif]-->
<div id="con_one_1" style="display:none;">
<div class="Unionshop">
<ul>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li id="tpborder"><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li id="tpborder"><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
</ul>
</div>
</div>
<!--[if !IE]>华北联盟馆<![endif]-->
<div id="con_one_2">
<div class="Unionshop">
<ul>
<li><h1><a href="newsdetail.html"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="newsdetail.html">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
<li><h1><a href="#"><img src="${ctx}/Images/images/oneshop13.jpg" border="0" /></a></h1><h2><span><a href="#">汕头嘉城路店</a></span><samp>电话：0761-3333333</samp></h2></li>
</ul>
</div>
</div>
<!--[if !IE]>华中联盟馆<![endif]-->
<div id="con_one_3" style="display:none">新闻列表3</div>
<!--[if !IE]>华中联盟馆结束<![endif]-->
</div>
 <!--[if !IE]>分页<![endif]-->
          <div class="paging2">
            <div class="paging">
              <div class="paging01">
              <a href="#" class="paging01_btn">上一页</a>              </div>
              <div class="paging02">
               <a class="paging01_btn2visited">1</a>
			   <a class="paging01_btn2">2</a>
			   <a class="paging01_btn2">3</a>
			   <a class="paging01_btn2">4</a>
              </div>
              <div class="paging01">
                <a href="#" class="paging01_btn1">下一页</a> 
              </div>
              <div class="paging03">共4页</div>
              <div class="paging04">到第</div>
              <div class="paging05">&nbsp;
                <input name="" type="text" class="paging01_input" />
                &nbsp;</div>
              <div class="paging03">页</div>
              <div class="paging05">
                <input name="" type="button" class="paging01_btn3" value="确认"/>
              </div>
            </div>
          </div>
		  <!--[if !IE]>分页结束<![endif]-->
</div>
 <!--[if !IE]>联盟店选项卡结束<![endif]--> 
   </div>
   </div>
   </div>
   <!--[if !IE]>尾部<![endif]-->

  
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>

</body>
</html>
