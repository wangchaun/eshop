<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/qianggou_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/scripts/front/clients_js/qianggou.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<script> 
	d = document.getElementById("nav1"); 
	var aa = d.getElementsByTagName("a"); 
	aa[2].className = "link_on";   //加载默认
	d.l = aa[2]; 
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
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>限时抢购<![endif]-->
  <div class="limitbuy">
   	<div class="limitbuy01"><span>限时抢购</span>
	   	<c:if test="${fn:length(goodList) != 0}">
	   	    <h1>距离结束时间：</h1><div id="endTime1" name="${endTime }"></div>
	   		<input id="endTime" type="hidden" value="<fmt:formatDate  pattern='yyyy-MM-dd HH:mm:ss' value='${endTime}'/>"/>
   		</c:if>
   	</div>
    <div class="limitbuy02">
	<ul>
	<c:forEach items="${goodList}" var="good">
		   <c:if test="${good.isNext == '0'}">
				<li>
				  <a href="${ctx}/cpxq.do?good.id=${good.id }" target="_blank"><img src="${ctx}${good.pic}" border="0" /></a>
				<h1><a href="${ctx}/cpxq.do?good.id=${good.id }" target="_blank">${good.name}<span>${good.introBrief }</span></a></h1>
				<h2><samp>抢购价：</samp><span>¥<fmt:formatNumber value="${good.priceGroupBuy}" pattern="0.00"/></span></h2>
				<h3>市场价：<span>¥<fmt:formatNumber value="${good.priceMarket}" pattern="0.00"/></span></h3>
				<h4>剩余<span>${good.activitNumber }</span>件    <samp>共${good.totalNum}</samp>件  </h4>
				<h5><input name="" type="button" class="limitbuy02btn" onclick="javascript:window.location.href='${ctx }/cpxq.do?good.id=${good.id }'"/></h5>
				</li>
		   </c:if>		   
	</c:forEach>
	<c:if test="${fn:length(goodList) == 0}">
		 <li><h4>暂无抢购商品</h4></li>
	</c:if>
	</ul>
	</div>
  </div>
   <!--[if !IE]>限时抢购完成<![endif]-->
    <!--[if !IE]>下期预告<![endif]-->
   <div class="limitbuy">
   <div class="limitbuy01"><span>下期预告</span>
   	   <c:if test="${fn:length(goodList) != 0}">
	       <h1>距离开始时间：</h1>
	       <div id="beginTime1"></div>
	       <input id="beginTime" type="hidden" value="<fmt:formatDate  pattern=" yyyy-MM-dd HH:mm:ss" value="${beginTime}"/>"/>
       </c:if>
   </div>
    <div class="limitbuy02">
	<ul>
	<c:forEach items="${goodList}" var="good" begin="0" end="3">
		   <c:if test="${good.isNext == '1'}">
				<li>
				  <a href="#"><img src="${ctx}${good.pic}" border="0" /></a>
				<h1><a href="#">${good.name}</a></h1>
				<h2><samp>抢购价：</samp><span>¥${good.priceGroupBuy}</span></h2>
				<h3>市场价：<span>¥${good.priceMarket}</span></h3>
				<h4>剩余<span>${good.activitNumber }</span>件    <samp>共${good.totalNum}</samp>件  </h4>
				<h5><input name="" type="button" class="limitbuy02btn" /></h5>
				</li>
		    </c:if>
		    
	</c:forEach>
	<c:if test="${fn:length(goodList) == 0}">
		<li><h4>暂无抢购商品</h4></li>
	</c:if>
	</ul>
	</div>
  </div>
  <!--[if !IE]>下期预告完成<![endif]-->
  </div>
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>


</body>
</html>
