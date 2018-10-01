<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/qianggou_Detail_page.css" rel="stylesheet" type="text/css" />
<link href="style/header_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="pro_dropdown_2/pro_dropdown_2.css" />
<script src="js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/index20110925_mini.js"></script>
<script language="javascript" src="js/jquery2.js"></script>
<SCRIPT type=text/javascript src="js/jquery1.js"></SCRIPT>
<script type="text/javascript" src="js/jquery-1.7.min.js" ></script>
<script type="text/javascript" src="js/utility.js" ></script>
<script type="text/javascript" src="js/base.define.js" ></script>
<script type="text/javascript" src="js/jquery-cart.js" ></script>
<script type="text/javascript" src="js/_bind_cart.js" ></script>
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
  <iframe width="100%" height=191 frameborder=0 scrolling=no src="header.htm" style="z-index:1000"></iframe> 
   <!--[if !IE]>中间产品详细<![endif]--> 
  <div class="details">
  <div class="photoRecommend01"><span>限时抢购</span></div>
  <!--[if !IE]>方向<![endif]-->
  <div class="details01">
  <!--[if !IE]>zuoce<![endif]-->
  <div class="details01_left">
  <!--[if !IE]>大图<![endif]-->
  <div class="details01boder"><a href="#"><img src="images/img1.jpg" border="0" /></a><span><img src="images/dw.gif.gif" /></span></div>
  <!--[if !IE]>左右滚动的小图<![endif]-->
  <div class="details01img">
 <ul>
 <li id="back"><input name="" type="button" class="details01imgbtn" /></li>
 <li><a href="#"><img src="images/img2.jpg" border="0" /></a></li>
  <li><a href="#"><img src="images/img2.jpg" border="0" /></a></li>
   <li><a href="#"><img src="images/img2.jpg" border="0" /></a></li>
    <li><a href="#"><img src="images/img2.jpg" border="0" /></a></li>
 <li id="retreat"><input name="" type="button" class="details01imgbtn1" /></li>
 </ul> 
  </div>
  <!--[if !IE]>左右滚动的小图结束<![endif]-->
  </div>
  <!--[if !IE]>右侧<![endif]-->
  <div class="details01_right">
  <div class="details01_text">
   <div class="details01_text01">
   <h1>图美立体声耳机 Zoro(红、黑、白) 特价图美立体声耳机 Zoro(红、黑、白) 特价图美立</h1>
   <h2>动感立体声耳机 耳机头戴式 高保真 随身听耳机、时尚专业</h2>
   <h3>产品编号： CSJDW002612_1</h3>
   <h3><span class="hys1">抢 购 价：</span><span class="hys2">￥2969.00</span><span class="hys3">市场价：</span><span class="text01ys">￥2969.00</span></h3>
   <h5><span class="hys1">剩&nbsp;&nbsp;&nbsp;&nbsp;余：&nbsp;</span><span class="hys4">32</span><span class="hys5">件</span></h5>
    <h5><span class="hys1">距离结束(开始)时间：</span><span class="hys7">5</span><span class="hys1">时</span><span class="hys7">20</span><span class="hys1">分</span><span class="hys7">30</span><span class="hys1">秒</span></h5>
   <h4><samp class="hys1">库&nbsp;&nbsp;&nbsp;&nbsp;存：</samp><span><select name="" class="selectn2"><option>深圳</option><option>上海</option></select></span><samp>有货</samp></h4>
  
   </div>
  <div class="details01_text02">
  <div class="details01_text0201">
  <span>颜&nbsp;&nbsp;&nbsp;&nbsp;色：</span>
  <ul>
  <li><a href="#" id="details01visited">白色移动版</a></li>
  <li><a href="#">白色移动版</a></li>
  </ul>
  </div>
  <div class="details01_text0201">
  <span>服&nbsp;&nbsp;&nbsp;&nbsp;务：</span>
  <ul>
  <li><a href="#" id="details01visited">上门安装</a></li>
  <li><a href="#">不安装</a></li>
  </ul>
  </div>
  <div class="details01_text0202">
  <h1>购买数量：</h1><span><input name="" type="button"  class="subtractionButton"/></span>
  <samp><input name="" type="input"  class="additionInput" value="1"/></samp>
  <span><input name="" type="button"  class="additionButton"/></span>
  <h1>件</h1>
  </div>
  <div class="details01_text0203">
 <h1><input name="" type="button" class="details01_text0203btn" onclick="window.open('confirmOrder.html')"/></h1>
    <h1><input name="" type="button" class="details01_text0203btn1" onclick="window.open('shoppingCart.html')"/></h1>
  </div>
  </div>
  <div class="details01_text0204">提示： 1.此款商品可以使用<a href="#">分期付款</a>进行支付&nbsp;&nbsp;&nbsp;2.此商品支持<a href="#">上门安装</a>服务</div>
  </div>
  </div>
    <!--[if !IE]>右侧结束<![endif]-->
  </div>
  <!--[if !IE]>抢购规则<![endif]-->
  <div class="photoRecommend">
  <div class="photoRecommend01"><span>抢购规则</span></div>
  <div class="photoRecommend02">
  <span>
  1）请您注册成为壹万店用户且登陆成功后再参与抢购活动；<br />
2）只有在活动时间内通过抢购页面将抢购商品加入购物车并结算方可享受抢购价； <br />
3）如果已经获得抢购资格的顾客没有在规定的时间内完成支付或者将购物车中对应抢购商品删除，视同放弃此抢购商品的购买资格。
  
  </span>
   
  </div>
  </div>
  </div> 
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>整体中间<![endif]-->
    <div class="categories">
      
      <!--[if !IE]>右侧<![endif]-->
      <div class="Categories_right">
	   <!--[if !IE]>产品规格的一些选项卡<![endif]-->
       <div class="Switch">
	   <div id="Tab2">
<div class="Menubox">
<ul>
<li id="one1" onclick="secBoard('one',1,6)"  >商品详情</li>
<li id="one2" onclick="secBoard('one',2,6)" >规格参数</li>
<li id="one3" onclick="secBoard('one',3,6)">包装清单</li>
<li id="one4" onclick="secBoard('one',4,6)"  class="hover">商品评价</li>
<li id="one5" onclick="secBoard('one',5,6)" >商品咨询</li>
<li id="one6" onclick="secBoard('one',6,6)">售后服务</li>
</ul>

</div>
<div class="Contentbox">
<!--[if !IE]>商品详情<![endif]-->
<div id="con_one_1" style="display:none">
<div class="itemDetails">商品详情单页</div>
</div>
<!--[if !IE]>商品详情结束<![endif]-->
<!--[if !IE]>规格参数单页<![endif]-->
<div id="con_one_2" style="display:none">
<div class="itemDetails">规格参数单页</div>
</div>
<!--[if !IE]>规格参数单页结束<![endif]-->
<!--[if !IE]>包装清单<![endif]-->
<div id="con_one_3" style="display:none">
<div class="itemDetails">包装清单</div>
</div>
<!--[if !IE]>包装清单结束<![endif]-->
<!--[if !IE]>商品平价<![endif]-->
<div id="con_one_4"  >
<div class="evaluation">
<div class="evaluation01">
<h1>
<span>平均评分</span>
<samp>5.0</samp>
</h1>
<h2>
<img src="images/img9.jpg" />
</h2>
</div>
<!--[if !IE]>评价分数定位<![endif]-->
<div class="evaluation02">
<div class="evaluation0201">
<h1 class="positon1"><span class="stand">5.0</span></h1>
<h1 class="positon2"><span class="stand">4.5</span></h1>
<h1 class="positon3"><span class="stand">4.0</span></h1>
<h1 class="positon4"><span class="stand">3.5</span></h1>
<h1 class="positon5"><span class="stand">3.0</span></h1>
<h1 class="positon6"><span class="stand">2.5</span></h1>
<h1 class="positon7"><span class="stand">2.0</span></h1>
<h1 class="positon8"><span class="stand">1.5</span></h1>
<h1 class="positon9"><span class="stand">1.0</span></h1>
</div>
<div class="evaluation0202">
<h1>1分</h1>
<h2>2分</h2>
<h2>3分</h2>
<h2>4分</h2>
<h3>5分</h3>
</div>
</div>
<!--[if !IE]>商品平价列表<![endif]-->
<div class="evaluation03">
<h1></h1>
<h2><input name="" type="button"  class="evaluation03btn" onclick="window.open('pingjia.html')"/></h2>
</div>
</div>
<!--[if !IE]>全部评价的选项卡<![endif]-->
<div class="evaluation1">
<div id="Tab3">
<div class="Menubox3">
<ul>
<li id="three1" onclick="secBoard('three',1,4)"  class="hover">全部评价(100)</li>
<li id="three2" onclick="secBoard('three',2,4)" >非常满意</li>
<li id="three3" onclick="secBoard('three',3,4)">一般</li>
<li id="three4" onclick="secBoard('three',4,4)">不满意</li>
</ul>
</div>
<div class="Contentbox3">
<!--[if !IE]>全部评价<![endif]-->
<div id="con_three_1" class="hover">
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价结束<![endif]-->
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>评价循环结束<![endif]-->
</div>
<!--[if !IE]>非常满意<![endif]-->
<div id="con_three_2" style="display:none">
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价结束<![endif]-->
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>评价循环结束<![endif]-->
</div>
<!--[if !IE]>一般<![endif]-->
<div id="con_three_3" style="display:none">
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价结束<![endif]-->
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>评价循环结束<![endif]-->
</div>
<!--[if !IE]>不满意<![endif]-->
<div id="con_three_4" style="display:none">
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价结束<![endif]-->
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>第一个评价<![endif]-->
<div class="evaluationlist">
<div class="evaluationlist01">
<div class="evaluationlist01_img">
<h1><img src="images/img12.jpg" /></h1>
<h2>美丽女孩</h2>
</div>
<div class="evaluationlist01_text">
<div class="evaluationlist01_text01">
<span><img src="images/img9.jpg" /></span>
<samp>5.0</samp>
<h1>评价时间：2012-10-27 18:00</h1>
</div>
<div class="evaluationlist01_text02">时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。时尚，外观漂亮 
几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配苹果手机听，感觉很好，重低音强。</div>
</div>
</div>
</div>
<!--[if !IE]>评价循环结束<![endif]-->
</div>
<!--[if !IE]>不满意结束<![endif]-->
</div>
</div>
</div>
<!--[if !IE]>商品平价列表结束<![endif]-->
 <!--[if !IE]>分页<![endif]-->
          <div class="paging1">
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
<!--[if !IE]>商品咨询<![endif]-->
<div id="con_one_5" style="display:none">
<div class="consulting">
提示:因厂家更改产品包装、产地或者更换随机附件等没有任何提前通知，且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！
若由此给您带来不便请多多谅解，谢谢！
</div>
<!--[if !IE]>商品咨询列表开始<![endif]-->
<div class="consulting1">
<div id="Tab4">
<div class="Menubox4">
<ul>
<li id="four1" onclick="secBoard('four',1,4)"  class="hover">全部咨询</li>
<li id="four2" onclick="secBoard('four',2,4)" >商品咨询</li>
<li id="four3" onclick="secBoard('four',3,4)">配送/支付</li>
<li id="four4" onclick="secBoard('four',4,4)">发票/安装保修</li>
</ul>
<span><a href="#">我要咨询</a></span></div>
<div class="Contentbox4">
<!--[if !IE]>全部咨询列表<![endif]-->
<div id="con_four_1" class="hover">
<div class="consulting1_text">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="" type="radio" value=""/></h1><h2>商品咨询</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>配送/支付</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list">
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>最后一个产品结束<![endif]-->
</div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>商品咨询列表<![endif]-->
<div id="con_four_2" style="display:none">
<div class="consulting1_text">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="" type="radio" value=""/></h1><h2>商品咨询</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>配送/支付</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list">
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>最后一个产品结束<![endif]-->
</div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>配送/支付<![endif]-->
<div id="con_four_3" style="display:none">
<div class="consulting1_text">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="" type="radio" value=""/></h1><h2>商品咨询</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>配送/支付</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list">
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>最后一个产品结束<![endif]-->
</div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>发票/安装保修<![endif]-->
<div id="con_four_4" style="display:none">
<div class="consulting1_text">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="" type="radio" value=""/></h1><h2>商品咨询</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>配送/支付</h2></li>
<li><h1><input name="" type="radio" value=""/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list">
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>咨询列表1<![endif]-->
<div class="consulting1_listtext">
<div class="consulting1_listtext01">
<h1><span>天天天天</span><samp>发布咨询</samp>时尚，外观漂亮 几个颜色都不错，我选的是红色的，最耀眼的一款。音质挺好的，配</h1>
<h2><span><img src="images/img18.jpg" /></span><samp>且每位咨询者购买情况、提问时间等不同，为此以下回复信息仅供参考！若由此给您带来不便请多多谅解，谢谢！</samp></h2>
</div>
<div class="consulting1_listtext02">2012-10-27 18:00</div>
</div>
<!--[if !IE]>最后一个产品结束<![endif]-->
</div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>end<![endif]-->
</div>
</div>
</div>
 <!--[if !IE]>分页<![endif]-->
          <div class="paging1">
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
<!--[if !IE]>商品咨询结束<![endif]-->
<!--[if !IE]>售后服务<![endif]-->
<div id="con_one_6" style="display:none">
<div class="itemDetails">售后服务单页</div>
</div>
<!--[if !IE]>售后服务结束<![endif]-->
</div>
</div>
</div>
	   </div>
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
  </div>
 
  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" ></iframe>

<div class="cartproductfluctuate" id="cart_container">
	<div class="shoppingCart1">
   <div class="shoppingCart1_title">购物车</div>
   <!--[if !IE]>第一行产品<![endif]-->
  <div class="shoppingCart1_text">
  <div class="shoppingCart1_text01"><a href="#"><img src="images/img22.jpg" border="0" /></a></div>
   <div class="shoppingCart1_text02">
   <h1>￥128</h1>
   <h2><img src="images/img23.jpg" /></h2>
   <h3>2</h3>
   <h4>件</h4>
   </div>
    <div class="shoppingCart1_text03"><a href="#"><img src="images/img21.jpg" border="0" /></a></div>
  </div>
  <!--[if !IE]>第一行产品<![endif]-->
  <div class="shoppingCart1_text">
  <div class="shoppingCart1_text01"><a href="#"><img src="images/img22.jpg" border="0" /></a></div>
   <div class="shoppingCart1_text02">
   <h1>￥128</h1>
   <h2><img src="images/img23.jpg" /></h2>
   <h3>2</h3>
   <h4>件</h4>
   </div>
    <div class="shoppingCart1_text03"><a href="#"><img src="images/img21.jpg" border="0" /></a></div>
  </div>
  <!--[if !IE]>第一行产品<![endif]-->
  <div class="shoppingCart1_text">
  <div class="shoppingCart1_text01"><a href="#"><img src="images/img22.jpg" border="0" /></a></div>
   <div class="shoppingCart1_text02">
   <h1>￥128</h1>
   <h2><img src="images/img23.jpg" /></h2>
   <h3>2</h3>
   <h4>件</h4>
   </div>
    <div class="shoppingCart1_text03"><a href="#"><img src="images/img21.jpg" border="0" /></a></div>
  </div>
  <!--[if !IE]>结算<![endif]-->
  <div class="shoppingCart1_text1">
  <h1><a href="#">更多</a></h1>
  <h2><a href="#">去结算</a></h2>
  </div>
  </div>	
		
	
	</div>
	<div class="cartfluctuate" id="show_cart">
		<div class="shoppingCart" ><h1>已添加<span>(0)</span>件</h1></div>
	</div>
               
    <script type="text/javascript">
        $("#jdw_d_recommendCategory_168").bindCart();
    </script>
    
    
                        

</body>
</html>
