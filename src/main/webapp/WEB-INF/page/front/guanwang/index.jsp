<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/index_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/lanrentuku.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/index.js?version=${version}"></script>

<script id='denglu_login_js' type='text/javascript' charset='utf-8'></script>
<script type='text/javascript' charset='utf-8'>
	(function() {
		var _dl_time = new Date().getTime();
		var _dl_login = document.getElementById('denglu_login_js');
		_dl_login.id = _dl_login.id + '_' + _dl_time;
		_dl_login.src = 'http://open.denglu.cc/connect/logincode?appid=97794denR7Az3eQYNT8GDaqAAeflxA&v=1.0.2&widget=1&styletype=1&size=452_132&style=popup&asyn=true&time=' + _dl_time;
	})();
</script>


<style type="text/css">
        /*滚动广告样式*/
        .ad {margin:1px;width:630px; height:250px;overflow:hidden;border:0px solid #AAAAAA;position:relative;}
        .slider,.num{position:absolute;}
        .slider li{ list-style:none;display:inline;}
        .slider img{ width:100%; height:250px;display:block;}
        .num{ right:15px; bottom:5px;}
        .num li{float:left;color: #FF7300;text-align: center;line-height: 16px;width: 16px;height: 16px;font-family: Arial;font-size: 12px;cursor: pointer;overflow: hidden;margin: 4px 1px;border: 1px solid #FF7300;background-color: #fff;}
        .num li.on{color: #fff;line-height: 21px;width: 21px;height: 21px;font-size: 16px;margin: 0 1px;border: 0;background-color: #FF7300;font-weight: bold;}

</style>



</head>
<body>
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<script>
	d = document.getElementById("nav1");
	var aa = d.getElementsByTagName("a");
	aa[0].className = "link_on";   //加载默认
	d.l = aa[0];
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
<div class="box">
<!--<iframe width="100%" height=191 frameborder=0 scrolling=no src="${ctx}/WEB-INF/page/front/guanwang/header.jsp"></iframe>-->

  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <div class="brand">
      <!--[if !IE]>左侧分类<![endif]-->
      <div class="brang01">
        <div id="warp1000">
          <div id="allsort">
            <div id="allsortlist">
            <c:forEach items="${goodTypeList}" var="goodType1" begin="0" end="6">
              <!--[if !IE]>商品类型<![endif]-->
              <div class="navlist icon01">
                <h3>
                  <div id="t_text">
                    <!-- onmouseover="PromotionBrand('${goodType1.id}','${ctx}')" -->
                    <div id="t_text01"><a href="${ctx }/getSecondGoods.do?goodType.id=${goodType1.id}&goodType.searchType=1" >${goodType1.name}</a></div>
                    <div id="t_text02">
                    	<c:forEach items="${goodType1.children}" var="goodType2" begin="0" end="2">
                    		<a href="${ctx }/getSecondGoods.do?goodType.id=${goodType2.id }" id="ta">${goodType2.name}</a> <!-- &goodType.parentId=${goodType1.id }&good.str=1 -->
                    	</c:forEach>
                    </div>
                  </div>
                </h3>
                <div class="navmore">
                  <div class="tv">
                 	 <c:forEach items="${goodType1.children}" var="goodType2" >
                    	<div class="tv01">
                    		<div class="tv01_title"><a href="${ctx }/getSecondGoods.do?goodType.id=${goodType2.id }" style="color:#0a7cd4; font-size:12px; font-family:'宋体'; font-weight:bold;">${goodType2.name}</a></div>
		                    <div class="tv01_title2">
			                    <c:forEach items="${goodType2.children}" var="goodType3">
			                    	<a href="${ctx }/getSecondGoods.do?goodType.id=${goodType3.id }" style="color: #666;text-decoration: none;  -moz-text-decoration-color: -moz-use-text-color -moz-text-decoration-line: none;-moz-text-decoration-style: solid;" >${goodType3.name }</a>
			                    </c:forEach>
		                    </div>
	                	</div>
	                </c:forEach>
                   </div>
                  <div class="tv1">
                    <div class="tv101"> <span>热门品牌</span>
                      <ul id="brand${goodType1.id}"> </ul>
                    </div>
                    <div class="tv102"> <span>促销活动</span>
                      <ul id="promotion${goodType1.id}"> </ul>
                    </div>
                  </div>
                </div>
              </div>
              </c:forEach>
              <!--[if !IE]>end<![endif]-->

          </div>
        </div>
      </div>
      <!--[if !IE]>右侧<![endif]-->
      <div class="brang02">
        <!--[if !IE]>banner<![endif]-->

       <div class="ad" id="advertise" >

        </div>
        <!--[if !IE]>小图<![endif]-->
        <div class="banner1" id="advertisePromotion">

        </div>
        <!--[if !IE]>小图结束<![endif]-->
      </div>
      <!--广告分类-->
      <div class="brand03">
        <div class="brand03_left">
           <c:forEach items="${advertiseList}" var="promotionActivity">
		          <c:if test="${promotionActivity.placeId=='商城用户广告4'}">
		          		<h1 class="brand03left_text"><a href="${promotionActivity.url}" target="_blank"><img src="${ctx}${promotionActivity.pic }" width="308" height="100"/></a></h1>
		          </c:if>
		    </c:forEach>
        </div>
        <div class="brand03_right">
          <div class="tug02_news01"> <samp style="font-size:14px;">麦芽&nbsp;&nbsp;快报</samp> <span><a href="${ctx }/newnews.do"><img src="${ctx}/Images/images/a15.jpg" border="0" /></a></span> </div>
          <div class="tug02_news02">
            <div class="tug02_ntext">
              <ul>
              	<c:forEach items="${inforlist}" var="information" begin="0" end="7" varStatus="i">
              		<c:if test='${i.index==0 }'>
   						<li class="tugys" style="margin: 0;"><a href="${ctx }/oneNewsdetail.do?information.id=${information.id }">${information.title }</a></li>
   					</c:if>
               		<c:if test='${i.index!=0 }'>
   						<li style="margin: 0;"><a href="${ctx }/oneNewsdetail.do?information.id=${information.id }">${information.title }</a></li>
   					</c:if>
               	</c:forEach>
              </ul>
            </div>
          </div>
        </div>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]>下面内容<![endif]-->
  <div class="content1">
    <!--[if !IE]>团购<![endif]-->
    <div class="buy" style="display:none;">
      <div class="buy01">
        <div class="buy01_text"> <samp>秒&nbsp;&nbsp;杀</samp> <span><a href="${ctx }/miaosha.do"><img src="${ctx}/Images/images/a15.jpg" border="0" /></a></span></div>
        <div class="buy01_text2">
          <!--[if !IE]>第一个小图<![endif]-->
          <c:forEach items="${goodArrList1}" begin="0" end="3" var="groupgood" varStatus="i">
	          <div class="tg01">
	            <div class="tg01_text"> <div id="endTime1${i.index}"> <samp>剩余</samp></div><input id="endTime2${i.index}" type="hidden" value="<fmt:formatDate  pattern="yyyy-MM-dd hh:mm:ss" value="${groupgood.endTime}"/>"/> <span>
	              <h1>${groupgood.groupNumber }</h1>人已秒杀</span> </div>
	            <div class="tg01_text2"><a href="${ctx }/cpxq.do?good.id=${groupgood.id }"><img src="${ctx}${groupgood.pic }" border="0" /></a></div>
	            <div class="tg01_text3">
	            <div class="tg01_text301">
	             <div class="tg01_text301_title"><a href="${ctx }/cpxq.do?good.id=${groupgood.id }">${groupgood.name }<span>${groupgood.introBrief }</span></a></div>
	              <div class="tg01_text301_title1"><span>¥${groupgood.priceGroupBuy }</span><samp><a href="${ctx }/cpxq.do?good.id=${groupgood.id }"><img src="${ctx}/Images/images/a58.jpg" border="0" /></a></samp></div>
	              </div>
	            </div>
	          </div>
         </c:forEach>

           <!--[if !IE]>小图循环结束<![endif]-->
        </div>
      </div>
      <!--[if !IE]>公告<![endif]-->
      <div class="tug02">
        <div class="tug02_news">
          <div class="tug02_news01"> <samp>公&nbsp;&nbsp;告</samp> <span><a href="${ctx }/newnews.do"><img src="${ctx}/Images/images/a15.jpg" border="0" /></a></span> </div>
          <div class="tug02_news02">
            <div class="tug02_ntext">
              <ul>
              	<c:forEach items="${inforlist}" var="information" begin="0" end="8" varStatus="i">
              		<c:if test='${i.index==0 }'>
   						<li class="tugys" style="margin: 0;"><a href="${ctx }/oneNewsdetail.do?information.id=${information.id }">${information.title }</a></li>
   					</c:if>
               		<c:if test='${i.index!=0 }'>
   						<li style="margin: 0;"><a href="${ctx }/oneNewsdetail.do?information.id=${information.id }">${information.title }</a></li>
   					</c:if>
               	</c:forEach>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!--[if !IE]>end<![endif]-->
    </div>
    <!--[if !IE]>团购结束<![endif]-->
    <!--[if !IE]>限时抢购<![endif]-->
    <div class="buy" style="display:none;">
      <div class="buy01">
        <div class="xsq"> <samp>限时抢购</samp> <span><a href="${ctx }/qianggou.do"><img src="${ctx}/Images/images/a15.jpg" border="0" /></a></span></div>
        <div class="buy01_text2">
      <!--[if !IE]>第一个小图<![endif]-->
	      <c:forEach items="${goodArrList2}" begin="0" end="3" var="groupgood" varStatus="i">
	          <div class="tg01">
	            <div class="tg01_text" > <div id="endTime3${i.index}"><samp>剩余</samp></div><input id="endTime4${i.index}" type="hidden" value="<fmt:formatDate  pattern=" yyyy-MM-dd hh:mm:ss" value="${groupgood.endTime}"/>"/> <span>
	             优惠<b class="tg01_text_bb">¥${groupgood.priceMarket-groupgood.priceGroupBuy }</b>
	              </span> </div>
	            <div class="tg01_text2"><a href="${ctx }/cpxq.do?good.id=${groupgood.id }"><img src="${ctx}${groupgood.pic }" border="0" /></a></div>
	            <div class="tg01_text3">
	            <div class="tg01_text301">
	              <div class="tg01_text301_title"><a href="${ctx }/cpxq.do?good.id=${groupgood.id }">${groupgood.name }<span>${groupgood.introBrief }</span></a></div>
	              <div class="tg01_text301_title1"><span>¥${groupgood.priceGroupBuy }</span><samp class="look"><a href="${ctx }/cpxq.do?good.id=${groupgood.id }">立即抢购</a></samp></div>
	              </div>
	            </div>
	          </div>
	       </c:forEach>
           <!--[if !IE]>小图循环结束<![endif]-->
        </div>
      </div>
      <!--[if !IE]>图片<![endif]-->
      <div class="tug02">
        <div class="xsq1">
        	 <c:forEach items="${advertiseList}" var="promotionActivity">
        	 	<c:if test="${promotionActivity.placeId=='首页促销4'}">
        			<a href="${promotionActivity.url }"><img src="${ctx}${promotionActivity.pic }" width="278" height="282"/></a>
        		</c:if>
        	 </c:forEach>
        </div>
      </div>
      <!--[if !IE]>end<![endif]-->
    </div>
    <!--[if !IE]>APPLE强势来袭<![endif]-->
    <div class="app" style="display:none;">
      <div class="app_left">
        <div class="app_text">
        	<c:forEach items="${goodArrList3}" begin="0" end="0" var="good" varStatus="i">
        		<samp>${good.fztag }</samp>
        	</c:forEach>
        </div>
        <div class="app_text1">
          <ul>
            <!--[if !IE]>第一个小图<![endif]-->
            <c:forEach items="${goodArrList3}" begin="0" end="3" var="good" varStatus="i">
            	<li>
            		<a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" width="160"  height="160"/></a>
              		<p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<span>${good.introBrief }</span></a></p>
              		<span>¥${good.price }</span>
              	</li>
            </c:forEach>
            <!--[if !IE]>end<![endif]-->
          </ul>
        </div>
      </div>
      <!--[if !IE]>右侧大图<![endif]-->
    </div>
    <!--[if !IE]>人气热卖<![endif]-->
    <div class="Popularhot">
      <div class="Popularhot_left">
        <div class="Popular_text"><samp class="apt">热卖商品</samp></div>
        <div class="app_text1" >
          <ul>
            <!--[if !IE]>产品1<![endif]-->
            <c:forEach items="${goodArrList4}" begin="0" end="7" var="good" varStatus="i">
            	<li>
            		<a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" width="160"  height="160"/></a>
	                <p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<span>${good.introBrief }</span></a></p>
	              <span>¥${good.price }</span>
	            </li>
             </c:forEach>
            <!--[if !IE]>end<![endif]-->
          </ul>
        </div>
      </div>

      <!--[if !IE]>end<![endif]-->
      <!-- 新增的广告位 手机广告-->
      <div class="app_right">
        <div class="xsq1">

        	<c:forEach items="${advertiseList}" var="promotionActivity">
        	 	<c:if test="${promotionActivity.placeId=='首页促销4'}">
        			<a href="${promotionActivity.url }"><img src="${ctx}${promotionActivity.pic }" width="278px" height="250px"/></a>
        		</c:if>
        	 </c:forEach>
      	</div>
      </div>
      <div class="app_right">
        <div class="xsq1">

        	<c:forEach items="${advertiseList}" var="promotionActivity">
        	 	<c:if test="${promotionActivity.placeId=='首页促销5'}">
        			<a href="${promotionActivity.url }"><img src="${ctx}${promotionActivity.pic }" width="278px" height="250px"/></a>
        		</c:if>
        	 </c:forEach>
      	</div>
      </div>
      <!--[if !IE]>公告<![endif]-->
    </div>

    <!--[if !IE]>空调热评开始<![endif]-->
	<div id="recen t-view-track" class="aircond" style="display:none;">
	<div id="right" class="index_left"><a href="javascript:void(0)"></a></div>
    <div id="left" class="index_right"><a href="javascript:void(0)"></a></div>
    <div id="guess-scroll" style="position: relative; width: 1200px; height: 545px; overflow: hidden;">
    <ol class="lh" style="position: absolute; left: 0px; top: 0px; width: 2700px;">
	<c:forEach items="${goodTypeArrList}" begin="0" end="11" var="goodType" varStatus="i">
		<input type="hidden" id="goodtypestyId${i.index }" value="${goodType.id }"/>
        	   <li class="aircond02">
                <div id="Tab2">
                  <div class="Menubox"> <span>${goodType.name}</span>
                    <div class="hll">
                      <span id="two${i.index}" onclick="this.className='hover',document.getElementById('twol${i.index}').className='',selGoodType('salesVolume','${i.index }')"  class="hover">销&nbsp;&nbsp;量</span>
                      <span id="twol${i.index}" onclick="this.className='hover',document.getElementById('two${i.index}').className='',selGoodType('commentValue','${i.index }')" >评论数</span>
                    </div>
                  </div>
                  <div class="Contentbox" id="ll${i.index}">
                    <div id="con_two_1" >
                        <div id="con_tw${i.index }">
                          <!--[if !IE]>第一个产品<![endif]-->
                          <c:forEach items="${goodType.goodlist}" begin="0" end="3" var="good" varStatus="j">
                              <div class="phb01_text">
                                <div class="phb01_te<c:if test="${j.index%4==1}">f</c:if><c:if test="${j.index%4==2}">f1</c:if><c:if test="${j.index%4==3}">f2</c:if>"> <span><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx }${good.pic }" width="74" height="74" /></a></span></div>
                                <div class="phb01_te1">
                                  <div class="phb01_te1con"><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }</a></div>
                                  <div class="phb01_te1con1">￥${good.price }</div>
                                  <div class="phb01_te1con2">降价：${good.priceMarket-good.price }</div>
                                  <div class="phb01_te1con3"><samp>
                                      <c:if test="${good.commentLevel==1 }"><img src="${ctx}/Images/images/pu14.jpg" /></c:if><!-- 1分 -->
                                      <c:if test="${good.commentLevel==2 }"><img src="${ctx}/Images/images/pu13.jpg" /></c:if><!-- 2分 -->
                                      <c:if test="${good.commentLevel==3 }"><img src="${ctx}/Images/images/pu12.jpg" /></c:if><!-- 3分 -->
                                      <c:if test="${good.commentLevel==4 }"><img src="${ctx}/Images/images/pu11.jpg" /></c:if><!-- 4分 -->
                                      <c:if test="${good.commentLevel==5 }"><img src="${ctx}/Images/images/pu10.jpg" /></c:if><!-- 5分 -->
                                  </samp><a href="${ctx }/cpxq.do?good.id=${good.id }">(<c:if test="${good.commentCount==null }">0</c:if>${good.commentCount }人评论)</a></div>
                                </div>
                              </div>
                          </c:forEach>
                          </div>
                        </div>
                  </div>
                </div>
              </li>
             </c:forEach>
      </ol>
	 </div>

    </div>
    <!--[if !IE]>空调热评结束<![endif]-->

    <!--[if !IE]>品牌管<![endif] -->
   <div class="BrandManagement">
      <div class="BrandManagement01"><samp>品牌展示</samp> <span><a href="#"><imgb src="${ctx}/Images/images/a15.jpg" /></a></span></div>
      <div class="BrandManagement02">
          <div class="BrandManagement0201">

              <div class="BManange">
                 <div class="new_ppg2">
                     <c:forEach items="${goodBrandList1}" begin="0" end="15" var="goodBrand" >
                         <a  href="${ctx }/shoptype.do?good.brandId=${goodBrand.id }"><img src="${ctx}${goodBrand.pic }" /></a>
                      </c:forEach>
                  </div>

              </div>
          </div>
          <div class="BrandManagement0202">
              <ul>
                  <c:forEach items="${goodBrandList3}" var="goodBrand" begin="0" end="29">
                      <li><a href="${ctx }/shoptype.do?good.brandId=${goodBrand.id }">${goodBrand.name }</a></li>
                  </c:forEach>
              </ul>
          </div>
      </div>

    </div>

    <!--[if !IE]>你感兴趣的<![endif] -->
    <div class="Interest">
    <div class="Interest01"><samp>猜你喜欢</samp></div>
    <div class="Interest02">

    <ul>

    <!--[if !IE]>第一个产品循环<![endif]-->

	    <c:forEach items="${goodList1}" var="good" begin="0" end="4">
	    <li><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" /></a>
	      <p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<samp>${good.introBrief }</samp></a></p>
	    <span>¥${good.price }</span></li>
	    </c:forEach>
   <!--[if !IE]>第一个产品结束<![endif]-->

    </ul>

    </div>


 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
<!--<iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" ></iframe>-->

</body>

</html>
