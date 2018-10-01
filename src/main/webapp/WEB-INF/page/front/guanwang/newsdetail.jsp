<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/newsdetail.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
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
<!--<iframe width="100%" height=191 frameborder=0 scrolling=no src="header.htm" style="z-index:1000"></iframe> -->
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
  <div class="instructions"><a href="${ctx }/index.do">首页</a>&nbsp; > &nbsp;<span>企业新闻</span></div>
  <div class="newsshow">
  <div class="newsshow_left">
   <!--[if !IE]>单页内容<![endif]-->
  <div class="article">${information.title }</div>
  <div class="article2">文章来源：<a href="#">网</a> <span>发表时间：<fmt:formatDate  pattern=" yyyy-MM-dd hh:mm:ss" value="${information.createTime }"/></span> </div>
  <div class="article3">
  	${information.content }
  </div>
   <!--[if !IE]>单页内容结束<![endif]-->
<!--	   <div class="newsleft_text3">-->
<!--		   <h1>相关推荐</h1>-->
<!--		   <ul>-->
<!--		    <c:forEach items="${inforAllList}" begin="0" end="9" var="infor">-->
<!--		    	<li><span><fmt:formatDate  pattern=" yyyy-MM-dd hh:mm:ss" value="${infor.createTime }"/></span><a href="${ctx }/oneNewsdetail.do?information.id=${infor.id }">${infor.title}</a></li>-->
<!--		    </c:forEach>-->
<!--		  	-->
<!--		   </ul>-->
<!--	   </div>-->
	
  </div>
  <div class="newsshow_right">
  	<!--<div class="newsright_text" style="dispaly:none;"><a href="newsdetail.html"><img src="${ctx }/Images/images/lay11.jpg" border="0" /></a></div> -->
<!--  		-->
<!--  		<div class="newsright_text1">每日推荐<span><a href="newslist.html">更多</a></span></div>-->
<!--   		<div class="newsright_text2">-->
<!--   			<div class="news2_text203">-->
<!--  				<div class="news2_text203_img">-->
<!--    				<a href="newsdetail.html"><img src="${ctx }/Images/images/lay8.jpg" border="0" /></a>-->
<!--    			</div>-->
<!--	  			<div class="news2_text203_text">-->
<!--				   <h1><a href="newsdetail.html">深圳家电网深入</a></h1>-->
<!--				   <h2><a href="#">既“广货网上行”之后，我司又传来喜报，由深圳报业集团举办的“深.......</a></h2>-->
<!--	  			</div>-->
<!--  			</div>-->
<!--	   		<div class="news2_text202">-->
<!--			  <ul>-->
<!--			  <li><a href="newsdetail.html">家电网提醒：冬季燃气热水器使用特别注意..........</a></li>-->
<!--			  <li><a href="#">家电网提醒：冬季燃气热水器使用特别注意</a></li>-->
<!--			  <li><a href="#">家电网提醒：冬季燃气热水器使用特别注意</a></li>-->
<!--			  <li><a href="#">家电网提醒：冬季燃气热水器使用特别注意</a></li>-->
<!--			  <li><a href="#">家电网提醒：冬季燃气热水器使用特别注意</a></li>-->
<!--			  </ul>-->
<!--	  		</div>-->
<!--   		</div>-->
<!--   	-->
<!--	   	<div class="newsright_text1">最新案例展示<span><a href="#">更多</a></span></div>-->
<!--	   		<div class="newsright_text2">-->
<!--	   			<div class="newsright_text201">-->
<!--				   <ul>-->
<!--				   <li><a href="#"><img src="${ctx }/Images/images/lay13.jpg" border="0" /></a><span><a href="#">产品展示</a></span></li>-->
<!--				   <li><a href="#"><img src="${ctx }/Images/images/lay13.jpg" border="0" /></a><span><a href="#">产品展示</a></span></li>-->
<!--				   <li><a href="#"><img src="${ctx }/Images/images/lay13.jpg" border="0" /></a><span><a href="#">产品展示</a></span></li>-->
<!--				   <li><a href="#"><img src="${ctx }/Images/images/lay13.jpg" border="0" /></a><span><a href="#">产品展示</a></span></li>-->
<!--				   </ul>-->
<!--	   		</div>-->
<!--	   	</div>-->
	   	
   		<div class="newsright_text1">相关推荐<span><a href="${ctx }/newnews.do">更多</a></span></div>
   		<div class="newsright_text2">
   			<div class="news2_text202">
			  <ul>
			  	<c:forEach items="${inforAllList}" begin="0" end="9" var="infor">
				  <li><a href="${ctx }/oneNewsdetail.do?information.id=${infor.id }">${infor.title}</a></li>
				</c:forEach> 
			  </ul>
  			</div>
   		</div>
   		
  	</div>
  </div>
  </div>
<!--  <iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm"></iframe>-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>

</body>
</html>
