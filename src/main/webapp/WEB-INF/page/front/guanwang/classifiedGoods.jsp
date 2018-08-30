<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/classifiedGoods_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/header_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/bottom_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<!--<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>-->
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/lanrentuku.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery3.js"></script>
<!--<script type="text/javascript" src="${ctx}/scripts/front/js/cn.global.js"></script>-->
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>

<style type="text/css">  
        /*滚动广告样式*/  
        .ad {margin:1px;width:935px; height:321px;overflow:hidden;border:0px solid #AAAAAA;position:relative;}  
        .slider,.num{position:absolute;}  
        .slider li{ list-style:none;display:inline;}  
        .slider img{ width:935px; height:321px;display:block;}  
        .num{ right:5px; bottom:5px;}  
        .num li{float: left;color: #FF7300;text-align: center;line-height: 16px;width: 16px;height: 16px;font-family: Arial;font-size: 12px;cursor: pointer;overflow: hidden;margin: 3px 1px;border: 1px solid #FF7300;background-color: #fff;}  
        .num li.on{color: #fff;line-height: 21px;width: 21px;height: 21px;font-size: 16px;margin: 0 1px;border: 0;background-color: #FF7300;font-weight: bold;}  
</style>


</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <div class="categories">
      <!--[if !IE]>左侧<![endif]-->
      <div class="Categories_left">
        <!--[if !IE]>大家电<![endif]-->
        <div class="Categlf_text"> <span>${goodtype.name }</span>
          <ul>
            <!--[if !IE]>第一个家电循环<![endif]-->
            <c:forEach items="${goodTypeList}" var="goodType1">
	            <li>
	              <p><a href="${ctx }/shoptype.do" target="_blank">${goodType1.name }</a></p>
	              	 <c:forEach items="${goodType1.children}" var="goodType2">
		            	 <a href="${ctx }/getSecondGoods.do?goodType.id=${goodType1.id }&goodType.parentId=${goodtype.id }&good.str=1">${goodType2.name }</a> 
	            	 </c:forEach>
	            </li>
            </c:forEach>
            <!--[if !IE]>第一个家电循环结束<![endif]-->
          </ul>
        </div>
        <!--[if !IE]>热点评论<![endif]-->
        <div class="hotComments" style="display:none;">
          <div class="hotCom_text"><span>热点评论</span></div>
          <div class="hotCom_text1">
            <div class="comm_title">
              <!--[if !IE]>第一个产品<![endif]-->
              <c:forEach items="${goodList4}" var="good" begin="0" end="2">
	              <div class="comm_title01">
		              <div class="comm_text">
			              <div class="comm_text01"><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" /></a></div>
			              <div class="comm_text02">
			              <div class="comm_text0201"><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }</a></div>
			              <div class="comm_text0202">
			              <samp>
				              <c:if test="${good.commentLevel==1 }"><img src="${ctx}/Images/images/pu14.jpg" /></c:if><!-- 1分 -->
				              <c:if test="${good.commentLevel==2 }"><img src="${ctx}/Images/images/pu13.jpg" /></c:if><!-- 2分 -->
				              <c:if test="${good.commentLevel==3 }"><img src="${ctx}/Images/images/pu12.jpg" /></c:if><!-- 3分 -->
				              <c:if test="${good.commentLevel==4 }"><img src="${ctx}/Images/images/pu11.jpg" /></c:if><!-- 4分 -->
			              	  <c:if test="${good.commentLevel==5 }"><img src="${ctx}/Images/images/pu10.jpg" /></c:if><!-- 5分 -->
			              </samp>
			              <a href="detail.html">(已有<c:if test="${good.commentCount==null }">0</c:if><c:if test="${good.commentCount!=null }">${good.commentCount}</c:if>人评价)</a></div>
			              <div class="comm_text0203">¥${good.price }</div>
			              </div>
		              </div>
		              <div class="comm_text2">${good.commentContent}</div>
	              </div>
              </c:forEach>
              <!--[if !IE]>产品结束<![endif]-->
            </div>
          </div>
        </div>
        <!--[if !IE]>最新降价<![endif]-->
        <div class="hotComments">
          <div class="hotCom_text"><span>最新降价</span></div>
          <div class="hotCom_text1">
            <div class="Latestprices">
               <!--[if !IE]>第一个产品<![endif]-->
              <c:forEach items="${goodList2}" var="good" begin="0" end="7">
              <div class="Latestpr_txt"> <span><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" /></a></span>
                <p><a href="${ctx }/cpxq.do?good.id=${browse.id }">${good.name }<samp>${good.introBrief }</samp></a></p>
                  <h1>¥${good.price }</h1>
              </div>
              </c:forEach>
              <!--[if !IE]>产品循环结束<![endif]-->
            </div>
          </div>
        </div>
      </div>
      <!--[if !IE]>右侧<![endif]-->
      <div class="Categories_right">
        <!--[if !IE]>banner<![endif]-->
<div class="ad" >  
  	<ul class="slider" >
		        <c:forEach items="${advertiseList}" var="promotionActivity">
	           		<c:if test="${promotionActivity.placeId=='分类焦点1'}">
		           		<li><a href="${promotionActivity.url }"><IMG alt="${promotionActivity.subject }" src="${ctx }${promotionActivity.pic }" /></a></li>
					</c:if>
					<c:if test="${promotionActivity.placeId=='分类焦点2'}">
		           		<li><a href="${promotionActivity.url }"><IMG alt="${promotionActivity.subject }" src="${ctx }${promotionActivity.pic }" /></a></li>
					</c:if>
					<c:if test="${promotionActivity.placeId=='分类焦点3'}">
		           		<li><a href="${promotionActivity.url }"><IMG alt="${promotionActivity.subject }" src="${ctx }${promotionActivity.pic }" /></a></li>
					</c:if>
					<c:if test="${promotionActivity.placeId=='分类焦点4'}">
		           		<li><a href="${promotionActivity.url }"><IMG alt="${promotionActivity.subject }" src="${ctx }${promotionActivity.pic }" /></a></li>
					</c:if>
	        	</c:forEach>
	</ul>
  			<ul class="num" >  
        		<li>1</li>  
        		<li>2</li>  
        		<li>3</li>  
        		<li>4</li>     
  			</ul> 
	
</div>
        <!--[if !IE]>今日推荐<![endif]-->
        <div class="newArrivals">
       
       </div>
       <!--[if !IE]>今日推荐完成<![endif]-->
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
  </div>
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>

</body>
</html>
