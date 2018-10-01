<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/detail_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/fdj.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="${ctx}/scripts/front/js/jquery-1.7.2.min.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/cart.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/utility.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/base.define.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/goodxq.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/zoom.lib.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/zoom.js" ></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/pingjia.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/validation_landing.js" ></script>
<script>
function changeDiv(tag,method){
  document.getElementById(tag).style.display = method;
}
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
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/jqPager/Pager.css" /><!-- 分页 -->
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/front/common/common_pager.js"></script><!-- 分页 -->
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jqPager/jquery.pager.js"></script><!-- 分页 -->

<!-- 分页的参数 -->
<input id="count" name="count" value="${pageInfo.count}" type="hidden" /><!-- 记录总数 -->
<input id="pageSize" name="pageSize" value="${pageInfo.pageSize}" type="hidden" /><!-- 每页显示记录数 -->
<input id="pageCount" name="pageCount" value="${pageInfo.pageCount}" type="hidden" /><!-- 总页数 -->
<input id="pageIndex" name="pageIndex" value="${pageInfo.pageIndex}" type="hidden" /><!-- 当前页数 -->
<input id="apptype" name="apptype" value="goodsdetails" type="hidden" /><!--分页参数 -->
<input id="apptypes" name="apptypes" type="hidden" /><!--分页参数 -->
<input id="wareCommenttype" name="wareCommenttype" type="hidden" />
<div class="box">
  <!--[if !IE]>头部<![endif]-->
   <!--[if !IE]>中间产品详细<![endif]-->
  <div class="details">
  <!--[if !IE]>方向<![endif]-->
    <div class="instructions"><a href="${ctx }/index.do" >首页</a>&nbsp; > &nbsp;<a href="${ctx }/getSecondGoods.do?goodType.id=${good.goodTypeId }&good.str=2">${good.goodTypeName }</a>&nbsp; > &nbsp;<span>${good.name }</span></div>
  <div class="details01">
  <!--[if !IE]>zuoce<![endif]-->
  <div class="details01_left">
        <!--[if !IE]>大图<![endif]-->
        <div id="spec-n1" class="jqzoom"><img id="img254035" src="${ctx }${good.pic }" jqimg="${ctx}${good.pic }" width="320" height="320"/></div>
        <!--[if !IE]>左右滚动的小图<![endif]-->
        <div class="details01img" id="spec-n5" >
          <div class="details01imgbtn" id="spec-left"></div>
          <div id="spec-list">
            <ul>
            <c:forEach items="${goodPicList}" var="good" varStatus="i">
    			<c:if test="${i.index<8}">
    				<li><img src="${ctx }${good.relativePath }" border="0" /></li>
    			</c:if>
	  		</c:forEach>
            </ul>
          </div>
          <div id="spec-right" class="details01imgbtn1"></div>
        </div>
        <!--[if !IE]>左右滚动的小图结束<![endif]-->
      </div>
          <!--[if !IE]>产品放大镜效果开始<![endif]-->

      <script type="text/javascript">
	$(function(){
	   $(".jqzoom").jqueryzoom({
			xzoom:330,//放大图显示范围
			yzoom:390,//放大图显示范围
			offset:10,
			position:"right",
			preload:1,
			lens:1
		});
		$("#spec-list").jdMarquee({
			deriction:"left",
			width:440,//小图显示范围
			height:56,//小图高度
			step:2,
			speed:4,//小图滚动速度
			delay:10,
			control:true,
			_front:"#spec-right",//右边按钮容器
			_back:"#spec-left"//左边按钮容器
		});
		$("#spec-list img").bind("mouseover",function(){
			var src=$(this).attr("src");
			$("#spec-n1 img").eq(0).attr({
				src:src.replace("\/n5\/","\/n1\/"),
				jqimg:src.replace("\/n5\/","\/n0\/")
			});
			$(this).css({
				"border":"1px solid #ff6600"//小图鼠标经过时描边
			});
		}).bind("mouseout",function(){
			$(this).css({
				"border":"1px solid #ccc"//小图鼠标离开时描边
			});
		});
	})
	$(function(){
	   var current=$('#monthSaleNumber').html();
	   var temp=current.substring(0,current.length-2);
	   $('#monthSaleNumber').html(temp);
	});
	</script>


    <!--产品放大镜效果end-->

  <!--[if !IE]>右侧<![endif]-->
  <div class="details01_right">
  <div class="details01_text">
   <div class="details01_text01">
   <input type="hidden" id="wareId" />
   <input type="hidden" id="goodPrice" value="${good.money}"/>
   <h1>${good.name }</h1>
   <h2>${good.introBrief }</h2>
   <h3>产品编号：${good.code }</h3>
    <h3>月销量:<span style="color:red;font-size:16px;" id="monthSaleNumber">${good.initialNum}</span>件</h3>
    <h3>市 场 价： <samp class="font" >¥</samp><samp id="priceMarket">${good.priceMarket}</samp></h3>
	 <h3>本 店 价：<span id="priceShop">¥${good.price}</span>
	 	<span id="goodSave" style="display:none;">
	 	<c:if test="${good.priceMarket<good.price}">0</c:if>
	 	<c:if test="${good.priceMarket>good.price}">${good.priceMarket-good.price}</c:if>
	 	</span>
	 元</h3>
   <h4>

   <div class="justify">库 存</div>
   <div class="justify2">
                <samp>:</samp>
   <span id="goodCount">
                <samp style="margin-left: 0px;margin-top:-4px;">
                <c:if test="${warehousecount>0}">有货</c:if>
                <c:if test="${warehousecount<1}">无货</c:if>
                </samp>
   </span>
   </div>
   </h4>
   </div>
  <div class="details01_text02">
  <input type="hidden" id="goodSpecificationnumber" value="${goodSpecificationnumber}"/>
  <input type="hidden" id="selectSpecificationVal"/>
  <input type="hidden" id="goodnumber" value="${warehousecount }"/>
  <input type="hidden" id="wareSpecificationValId"/>
  <input type="hidden" id="wareSpecificationValSort"/>
  <c:forEach items="${list1}" var="goodSpecification" varStatus="i">
  	  <input type="hidden" id="goodSpecification${i.index}" />
	  <div class="details01_text0201">
	  <div class="justify">${goodSpecification.name }</div><div class="justify2"><span>:</span>
	  <ul>
	  <c:forEach items="${list}" var="SpecificationVal" varStatus="j">
	  	<c:if test="${SpecificationVal.goodSpecificationId==goodSpecification.id}">

	  			<!-- <li><a name="SpecificationVal${i.index }" id="" href="javascript:void(0)" onclick="upstyle(this,'${i.index }','${SpecificationVal.value }')">${SpecificationVal.value }</a></li> -->
	  			<c:if test="${goodSpecification.showType == '0'}">
		  		 <li>
		  		        <a name="SpecificationVal${i.index }" id="SpecificationVal${j.index }" href="javascript:void(0)" onclick="upstyle(this,'${good.id }','${i.index }','${SpecificationVal.value }','${SpecificationVal.id }')" >
		  	              ${SpecificationVal.value }
		  	            </a>
		  	     </li>
		  		</c:if>
		  		<c:if test="${goodSpecification.showType == '1'}">
		  		  <li>
			  			<a name="SpecificationVal${i.index }" id="" href="javascript:void(0)" onclick="upstyle(this,'${good.id}','${i.index }','${SpecificationVal.value }','${SpecificationVal.id }')"  title="${SpecificationVal.value }">
			  				<img src="${ctx }${SpecificationVal.pic }" border="0" width="45px" height="40px"/>
			  			</a>
		  		  </li>
		  		</c:if>
	  	</c:if>
	  </c:forEach>
	  </ul>
	  </div>
	  </div>
  </c:forEach>

  <div class="details01_text0202">
  <h1>购买数量：</h1><span><input name="" type="button"  class="subtractionButton" onclick="subtraction('1')"/></span>
  <samp><input name="" id="changeNumber" type="text"  class="additionInput" value="1"/></samp>
  <span><input name="" type="button"  class="additionButton" onclick="subtraction('2')"/></span>
  <h1>件</h1>
  </div>
  <div class="details01_text0203">
  <!-- 判断是否是选号商品 -->

  <h1><a id="254035" class="listcart" href="javascript:;"><input name="" type="button" class="details01_text0203btn" onclick="selectWareId('1')"/></a></h1>
  <h1><input name="" type="button" class="details01_text0203btn1" onclick="selectWareId('2')"/></h1>

  <h2><span><img src="${ctx}/Images/images/img3.jpg" /></span><samp><a href="javascript:addGoodToFavorite('${good.id }')">收藏该商品</a></samp></h2>
  </div>
  </div><!-- 1.此款商品可以使用<a href="javascript:void(0)">分期付款</a>进行支付&nbsp;&nbsp;&nbsp;2.此商品支持<a href="javascript:void(0)">上门安装</a>服务 -->
  <div class="details01_text0204">提示:${good.remark}</div>
  </div>
  </div>
    <!--[if !IE]>右侧结束<![endif]-->
  </div>
  <!--[if !IE]>推荐搭配<![endif]-->
  <div class="photoRecommend">
  <div class="photoRecommend01"><span>推荐搭配</span></div>
  <div class="photoRecommend02">
  <div class="photoRec_text">
  <ul>
  <c:forEach items="${goodComposeList}" var="goodCompose" varStatus="i">
  	<li>
	  	<h1><input id="checkbox${i.index }" type="checkbox" class="checkbox" onclick="collocation(this,'${i.index }')"/></h1>
	  	<h2><a href="${ctx }/cpxq.do?good.id=${goodCompose.composeGoodId }"><img src="${ctx}${goodCompose.pic }" border="0" /></a>
	  	<p><a href="${ctx }/cpxq.do?good.id=${goodCompose.composeGoodId }">${goodCompose.name } <samp>${goodCompose.introBrief }</samp></a></p>
	  	<span>¥${goodCompose.price-goodCompose.priceDiscount }</span></h2>
	  	<input type="hidden" id="goodId${i.index }" value="${goodCompose.composeGoodId }"/>
	  	<input type="hidden" id="price${i.index }" value="${goodCompose.price-goodCompose.priceDiscount}"/>
	  	<input type="hidden" id="priceDiscount${i.index }" value="${goodCompose.priceDiscount }"/>
	</li>
  </c:forEach>
  </ul>
  </div>
   <div class="photoRec_text1">
    <div class="photoRec_text101">
    <input type="hidden" id="totalPrice" value="${good.price}"/>
    <input type="hidden" id="totalPriceDiscount" value="0"/>
    <input type="hidden" id="totalnumber" value="0"/>
	<div id="dptol"><h1>搭配了：0件</h1></div>
    <h2><samp>套餐价:</samp><span id="sp1">¥${good.price}</span></h2>
    <h1>节省了：<span class="font" id="sp2">¥0.00</span ></h1>
   <h3><input name="" type="button" class="details01_text0203btn" onclick="setgoodCompose()"/></h3>
  </div>
   </div>
  </div>
  </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>整体中间<![endif]-->
    <div class="categories">
      <!--[if !IE]>左侧<![endif]-->
      <div class="Categories_left">
        <!--[if !IE]>买了本商品的客户买了<![endif]-->
        <div class="seenProduct">
          <c:if test="${buyList1!=null}">
           <div class="seenProduct01">最近浏览</div>
          </c:if>
          <div class="seenProduct02">
            <!--[if !IE]>第一个产品<![endif]-->
            <c:forEach items="${buyList1}" var="good" begin="0" end="4">
	            <div class="seenProduct02_text">
	              <div class="seenProduct02_text01">
	                <div class="seenProduct02_text01_con1">
	                <a href="${ctx }/cpxq.do?good.id=${good.goodId }"><img src="${ctx}${good.goodPic }" height="50" width="50"/></a>
	                </div>
	              </div>
	              <div class="seenProduct02_text02">
	                <a href="${ctx }/cpxq.do?good.id=${good.goodId }">${good.goodName } <samp></samp></a><span>¥${good.goodPrice }</span>
	              </div>
	            </div>
            </c:forEach>
            <!--[if !IE]>产品循环结束<![endif]-->
          </div>
          <div class="mt">
				<h2>${goodTypeName}排行榜</h2>
		  </div>
		  <div class="seenProduct02">
		   <c:forEach items="${saleRanking}" var="good" begin="0" end="4">
	            <div class="seenProduct02_text">
	              <div class="seenProduct02_text01">
	                <div class="seenProduct02_text01_con1">

	                <a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" height="50" width="50"/></a>
	                </div>
	              </div>
	              <div class="seenProduct02_text02">
	                <a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name } <samp></samp></a><span>¥${good.price }</span>
	              </div>
	            </div>
           </c:forEach>
		  </div>
        </div>

        <!--[if !IE]>end<![endif]-->
      </div>
      <!--[if !IE]>右侧<![endif]-->
      <div class="Categories_right">
	   <!--[if !IE]>产品规格的一些选项卡<![endif]-->
       <div class="Switch">
	   <div id="Tab2">
<div class="Menubox">
<ul>
<li id="one1" onclick="secBoard('one',1,6),hiddenDiv()" class="hover">商品详情</li>
<li id="one2" onclick="secBoard('one',2,6),hiddenDiv()" >规格参数</li>
<li id="one3" onclick="secBoard('one',3,6),hiddenDiv()">包装清单</li>
<li id="one4" onclick="secBoard('one',4,6),goodEvaluation(0,1)" >商品评价</li>
<li id="one5" onclick="secBoard('one',5,6),goodmession('all',1)">商品咨询</li>
<li id="one6" onclick="secBoard('one',6,6),hiddenDiv()" style="display:none;">售后服务</li>
</ul>
</div>
<div class="Contentbox">
<!--[if !IE]>商品详情<![endif]-->
<div id="con_one_1">
<div class="itemDetails">${goodExtend.intro }</div>
</div>
<!--[if !IE]>商品详情结束<![endif]-->
<!--[if !IE]>规格参数单页<![endif]-->
<div id="con_one_2" style="display:none">
<div class="itemDetails">${goodExtend.introWholesale }</div>
</div>
<!--[if !IE]>规格参数单页结束<![endif]-->
<!--[if !IE]>包装清单<![endif]-->
<div id="con_one_3" style="display:none">
<div class="itemDetails">${goodExtend.introDelivery }</div>
</div>
<!--[if !IE]>包装清单结束<![endif]-->
<!--[if !IE]>商品平价<![endif]-->
<div id="con_one_4"  style="display:none">
<div class="evaluation">
<div class="evaluation01" id="eval1" style="display:none">
<h1>
<span>平均评分</span>
<samp>0</samp>
</h1>
<h2>
<img src="${ctx}/Images/images/img9.jpg" />
</h2>
</div>
<!--[if !IE]>评价分数定位<![endif]-->
<div class="evaluation02">
<div class="evaluation0201" id="eval2">
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
<h2><input name="" type="button"  class="evaluation03btn" onclick="selTo('${ctx }/pingjia.do?good.id=${good.id }')"/></h2>
</div>
</div>
<!--[if !IE]>全部评价的选项卡<![endif]-->
<div class="evaluation1">
	<div id="Tab3">
		<div class="Menubox3">
			<ul>
				<li id="three1" onclick="secBoard('three',1,4),goodEvaluation(0,1)"  class="hover">全部评价</li>
				<li id="three2" onclick="secBoard('three',2,4),goodEvaluation(1,1)" >非常满意</li>
				<li id="three3" onclick="secBoard('three',3,4),goodEvaluation(2,1)">一般</li>
				<li id="three4" onclick="secBoard('three',4,4),goodEvaluation(3,1)">不满意</li>
			</ul>
		</div>
		<div class="Contentbox3">
			<!--[if !IE]>全部评价<![endif]-->
			<div id="con_three_1" class="hover"></div>
			<!--[if !IE]>非常满意<![endif]-->
			<div id="con_three_2"  ></div>
			<!--[if !IE]>一般<![endif]-->
			<div id="con_three_3"  ></div>
			<!--[if !IE]>不满意<![endif]-->
			<div id="con_three_4"></div>
		</div>
	</div>
</div>
<!--[if !IE]>评价循环结束<![endif]-->

<!--[if !IE]>商品平价列表结束<![endif]-->



<!--[if !IE]>分页<![endif]
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
<li id="four1" onclick="secBoard('four',1,4),goodmession('all',1)"  class="hover" style="display:none;">全部咨询</li>
<li id="four2" onclick="secBoard('four',2,4),goodmession(0,1)" >商品咨询</li>
<li id="four3" onclick="secBoard('four',3,4),goodmession(1,1)" style="display:none;">配送/支付</li>
<li id="four4" onclick="secBoard('four',4,4),goodmession(2,1)" style="display:none;">发票/安装保修</li>
</ul>
<span><a href="javascript:void(0)" onclick="HiddenConsulting()">我要咨询</a></span></div>
<div class="Contentbox4">
<input type="hidden" id="goodId" value="${good.id }"/>
<!--[if !IE]>全部咨询列表<![endif]-->

<div id="con_four_1" class="hover">
<div class="consulting1_text" id="four_di_1" style="display:none">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="type1" type="radio" value="商品咨询" checked="checked"/></h1><h2>商品咨询</h2></li>
<li style="display:none;"><h1><input name="type1" type="radio" value="配送/支付"/  ></h1><h2>配送/支付</h2></li>
<li style="display:none;"><h1><input name="type1" type="radio" value="发票/安装保修"  /></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" id="messageContent1" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn" onclick="submitSaveMessge1()"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list" id="consultingall"></div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>商品咨询列表<![endif]-->
<div id="con_four_2">
<div class="consulting1_text" id="four_di_2" style="display:none">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="type2" type="radio" value="商品咨询" checked="checked"/></h1><h2>商品咨询</h2></li>
<li><h1><input name="type2" type="radio" value="配送/支付" /></h1><h2>配送/支付</h2></li>
<li><h1><input name="type2" type="radio" value="发票/安装保修"/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" id="messageContent2" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn" onclick="submitSaveMessge2()"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list" id="consulting0"></div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>配送/支付<![endif]-->
<div id="con_four_3" >
<div class="consulting1_text" id="four_di_3" style="display:none">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="type3" type="radio" value="商品咨询" /></h1><h2>商品咨询</h2></li>
<li><h1><input name="type3" type="radio" value="配送/支付" checked="checked"/></h1><h2>配送/支付</h2></li>
<li><h1><input name="type3" type="radio" value="发票/安装保修" /></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" id="messageContent3" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn" onclick="submitSaveMessge3()"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list" id="consulting1"></div>
<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>发票/安装保修<![endif]-->
<div id="con_four_4" >
<div class="consulting1_text" id="four_di_4" style="display:none">
<div class="consulting1_text01">
<span>咨询分类：</span>
<ul>
<li><h1><input name="type4" type="radio" value="商品咨询" checked="checked"/></h1><h2>商品咨询</h2></li>
<li><h1><input name="type4" type="radio" value="配送/支付"/></h1><h2>配送/支付</h2></li>
<li><h1><input name="type4" type="radio" value="发票/安装保修" checked="checked"/></h1><h2>发票/安装保修</h2></li>
</ul>
</div>
<div class="consulting1_text02">
<h1>咨询内容：</h1>
<h2><textarea name="" cols="" rows="" id="messageContent4" class="textare"></textarea></h2>
</div>
<div class="consulting1_text03"><input name="" type="button"  class="consulting1_text03btn"  onclick="submitSaveMessge4()"/></div>
</div>
<!--[if !IE]>咨询列表<![endif]-->
<div class="consulting1_list" id="consulting2"></div>

<!--[if !IE]>咨询列表结束<![endif]-->
</div>
<!--[if !IE]>end<![endif]-->
</div>
</div>
</div>

<!--[if !IE]>分页<![endif]
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
	<div id="pagerBot" style="margin-right: 0px;height: 30px; display: none" ></div><!--分页组件-->
<!--[if !IE]>售后服务<![endif]-->
<div id="con_one_6" style="display:none">
<div class="itemDetails">${goodExtend.afterSale }</div>
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

 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</body>
</html>
