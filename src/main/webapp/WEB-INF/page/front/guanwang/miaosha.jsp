<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/miaosha_page.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/styles/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script language="javascript" type="text/javascript" src="${ctx}/scripts/front/clients_js/miaosha.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
<SCRIPT type=text/javascript>
var sina={$:function(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}},isIE:navigator.appVersion.indexOf("MSIE")!=-1?true:false,addEvent:function(l,i,I){if(l.attachEvent){l.attachEvent("on"+i,I)}else{l.addEventListener(i,I,false)}},delEvent:function(l,i,I){if(l.detachEvent){l.detachEvent("on"+i,I)}else{l.removeEventListener(i,I,false)}},readCookie:function(O){var o="",l=O+"=";if(document.cookie.length>0){var i=document.cookie.indexOf(l);if(i!=-1){i+=l.length;var I=document.cookie.indexOf(";",i);if(I==-1)I=document.cookie.length;o=unescape(document.cookie.substring(i,I))}};return o},writeCookie:function(i,l,o,c){var O="",I="";if(o!=null){O=new Date((new Date).getTime()+o*3600000);O="; expires="+O.toGMTString()};if(c!=null){I=";domain="+c};document.cookie=i+"="+escape(l)+O+I},readStyle:function(I,l){if(I.style[l]){return I.style[l]}else if(I.currentStyle){return I.currentStyle[l]}else if(document.defaultView&&document.defaultView.getComputedStyle){var i=document.defaultView.getComputedStyle(I,null);return i.getPropertyValue(l)}else{return null}}};
function ScrollPic(I,i,l,o,c){var O=this;O.scrollContId=I;O.arrLeftId=i;O.arrRightId=l;O.dotListId=o;O.listType=c;O.dotClassName="dotItem";O.dotOnClassName="dotItemOn";O.dotObjArr=[];O.listEvent="onclick";O.circularly=true;O.frameWidth=O.pageWidth=0;O.space=O.speed=10;O.upright=false;O.pageIndex=0;O.autoPlay=true;O.autoPlayTime=5;O._state="ready";O.stripdiv=document.createElement("div");O.ldiv01=document.createElement("div");O.ldiv02=document.createElement("div")};ScrollPic.prototype={version:"1.30",author:"mengjia",initialize:function(){var o=this,I=o;if(o.scrollContId)if(o.scdiv=sina.$(o.scrollContId)){o.scdiv.style[o.upright?"height":"width"]=o.frameWidth+"px";o.scdiv.style.overflow="hidden";o.ldiv01.innerHTML=o.scdiv.innerHTML;o.scdiv.innerHTML="";o.scdiv.appendChild(o.stripdiv);o.stripdiv.appendChild(o.ldiv01);if(o.circularly){o.stripdiv.appendChild(o.ldiv02);o.ldiv02.innerHTML=o.ldiv01.innerHTML}o.stripdiv.style.overflow="hidden";o.stripdiv.style.zoom="1";o.stripdiv.style[o.upright?"height":"width"]="32766px";if(!o.upright){o.ldiv01.style.cssFloat="left";o.ldiv01.style.styleFloat="left";o.ldiv01.style.overflow="hidden"}o.ldiv01.style.zoom="1";if(o.circularly&&!o.upright){o.ldiv02.style.cssFloat="left";o.ldiv02.style.styleFloat="left";o.ldiv02.style.overflow="hidden"}o.ldiv02.style.zoom="1";sina.addEvent(o.scdiv,"mouseover",function(){I.stop()});sina.addEvent(o.scdiv,"mouseout",function(){I.play()});if(o.arrLeftId)if(o.alObj=sina.$(o.arrLeftId)){sina.addEvent(o.alObj,"mousedown",function(){I.rightMouseDown()});sina.addEvent(o.alObj,"mouseup",function(){I.rightEnd()});sina.addEvent(o.alObj,"mouseout",function(){I.rightEnd()})}if(o.arrRightId)if(o.arObj=sina.$(o.arrRightId)){sina.addEvent(o.arObj,"mousedown",function(){I.leftMouseDown()});sina.addEvent(o.arObj,"mouseup",function(){I.leftEnd()});sina.addEvent(o.arObj,"mouseout",function(){I.leftEnd()})}if(o.dotListId){o.dotListObj=sina.$(o.dotListId);o.dotListObj.innerHTML="";if(o.dotListObj){var i=Math.round(o.ldiv01[o.upright?"offsetHeight":"offsetWidth"]/o.frameWidth+0.4),l,O;for(l=0;l<i;l++){O=document.createElement("span");o.dotListObj.appendChild(O);o.dotObjArr.push(O);O.className=l==o.pageIndex?o.dotOnClassName:o.dotClassName;if(o.listType=="number")O.innerHTML=l+1;O.title="第"+(l+1)+"页";O.num=l;O[o.listEvent]=function(){I.pageTo(this.num)}}}}o.scdiv[o.upright?"scrollTop":"scrollLeft"]=0;o.autoPlay&&o.play();o._scroll=o.upright?"scrollTop":"scrollLeft";o._sWidth=o.upright?"scrollHeight":"scrollWidth";typeof o.onpagechange==="function"&&o.onpagechange()}else throw new Error("scrollContId不是正确的对象.(scrollContId = \""+o.scrollContId+"\")");else throw new Error("必须指定scrollContId.")},leftMouseDown:function(){if(this._state=="ready"){var a=this;this._state="floating";this._scrollTimeObj=setInterval(function(){a.moveLeft()},this.speed)}},rightMouseDown:function(){if(this._state=="ready"){var a=this;this._state="floating";this._scrollTimeObj=setInterval(function(){a.moveRight()},this.speed)}},moveLeft:function(){var i=this;if(i.circularly)if(i.scdiv[i._scroll]+i.space>=i.ldiv01[i._sWidth])i.scdiv[i._scroll]=i.scdiv[i._scroll]+i.space-i.ldiv01[i._sWidth];else i.scdiv[i._scroll]+=i.space;else if(i.scdiv[i._scroll]+i.space>=i.ldiv01[i._sWidth]-i.frameWidth){i.scdiv[i._scroll]=i.ldiv01[i._sWidth]-i.frameWidth;i.leftEnd()}else i.scdiv[i._scroll]+=i.space;i.accountPageIndex()},moveRight:function(){var i=this;if(i.circularly)if(i.scdiv[i._scroll]-i.space<=0)i.scdiv[i._scroll]=i.ldiv01[i._sWidth]+i.scdiv[i._scroll]-i.space;else i.scdiv[i._scroll]-=i.space;else if(i.scdiv[i._scroll]-i.space<=0){i.scdiv[i._scroll]=0;i.rightEnd()}else i.scdiv[i._scroll]-=i.space;i.accountPageIndex()},leftEnd:function(){var i=this;if(i._state=="floating"){i._state="stoping";clearInterval(i._scrollTimeObj);var I=i.pageWidth-i.scdiv[i._scroll]%i.pageWidth;i.move(I)}},rightEnd:function(){var i=this;if(i._state=="floating"){i._state="stoping";clearInterval(i._scrollTimeObj);var I=-i.scdiv[i._scroll]%i.pageWidth;i.move(I)}},move:function(a,d){var c=this,b=a/5;if(!d){if(b>this.space)b=this.space;if(b<-this.space)b=-this.space}b=Math.abs(b)<1&&b!=0?b>=0?1:-1:Math.round(b);if(b>0)if(this.circularly)if(this.scdiv[this._scroll]+b>=this.ldiv01[this._sWidth])this.scdiv[this._scroll]=this.scdiv[this._scroll]+b-this.ldiv01[this._sWidth];else this.scdiv[this._scroll]+=b;else if(this.scdiv[this._scroll]+b>=this.ldiv01[this._sWidth]-this.frameWidth){this.scdiv[this._scroll]=this.ldiv01[this._sWidth]-this.frameWidth;this._state="ready";return}else this.scdiv[this._scroll]+=b;else if(this.circularly)if(this.scdiv[this._scroll]+b<0)this.scdiv[this._scroll]=this.ldiv01[this._sWidth]+this.scdiv[this._scroll]+b;else this.scdiv[this._scroll]+=b;else if(this.scdiv[this._scroll]-b<0){this.scdiv[this._scroll]=0;this._state="ready";return}else this.scdiv[this._scroll]+=b;a-=b;if(Math.abs(a)==0){this._state="ready";this.autoPlay&&this.play();this.accountPageIndex()}else{this.accountPageIndex();this._scrollTimeObj=setTimeout(function(){c.move(a,d)},this.speed)}},pre:function(){var i=this;if(i._state=="ready"){i._state="stoping";i.move(-i.pageWidth,true)}},next:function(I){var i=this;if(i._state=="ready"){i._state="stoping";if(i.circularly)i.move(i.pageWidth,true);else if(i.scdiv[i._scroll]>=i.ldiv01[i._sWidth]-i.frameWidth){i._state="ready";I&&i.pageTo(0)}else i.move(i.pageWidth,true)}},play:function(){var a=this;if(this.autoPlay){clearInterval(this._autoTimeObj);this._autoTimeObj=setInterval(function(){a.next(true)},this.autoPlayTime*1E3)}},stop:function(){clearInterval(this._autoTimeObj)},pageTo:function(I){var i=this;if(i.pageIndex!=I){clearTimeout(i._scrollTimeObj);i._state="stoping";I=I*i.frameWidth-i.scdiv[i._scroll];i.move(I,true)}},accountPageIndex:function(){var i=this,I=Math.round(i.scdiv[i._scroll]/i.frameWidth);if(I!=i.pageIndex){i.pageIndex=I;typeof i.onpagechange==="function"&&i.onpagechange();if(i.pageIndex>Math.round(i.ldiv01[i.upright?"offsetHeight":"offsetWidth"]/i.frameWidth+0.4)-1)i.pageIndex=0;for(I=0;I<i.dotObjArr.length;I++)i.dotObjArr[I].className=I==i.pageIndex?i.dotOnClassName:i.dotClassName}}};
</SCRIPT>



</head>
<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
  <script> 
		d = document.getElementById("nav1"); 
		var aa = d.getElementsByTagName("a"); 
		aa[1].className = "link_on";   //加载默认
		d.l = aa[1]; 
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
   <!--[if !IE]>秒杀开始<![endif]-->
  <div class="limitbuy">
   <div class="limitbuy01"><span>正在进行</span></div>
   
   	<c:forEach items="${goodList}" var="good">
   		<c:if test="${good.isNext == 0}">   	
		   <div class="miaosha">
		   		<div class="miaosha01">
		   			<div class="miao_text">
		   				<span><span>${good.name }</span></span>  
		   				<samp>${good.introBrief }</samp>
		    		</div>
					<div class="miao_text1" id="test">
						<input name="" type="hidden" id="gi" value="${good.id }"/>
						<div class="miao_text101"><span"><img src="${ctx}${good.pic}" border="0" width="695" height="355"/></span></div>
						<div class="miao_text102">
							<div class="miao_text10201" id="countDown" name="<fmt:formatDate  pattern='yyyy-MM-dd HH:mm:ss' value='${good.beginTime}'/>"></div>
							<div id="countDown2" name="<fmt:formatDate  pattern='yyyy-MM-dd HH:mm:ss' value='${good.endTime}'/>"></div>
							<div class="miao_text10202">
								<h1>¥</h1>
								<h2><fmt:formatNumber value="${good.priceGroupBuy }" pattern="0.00"/></h2>
								<h3 id="start"><input name="" type="button"  class="hotmoneybtn"/></h3>
							</div>
							<div class="miao_text10203">
								<h1>原价：<span><fmt:formatNumber value="${good.price }" pattern="0.00"/></span></h1>
								<h2>|</h2>
								<h1>优惠：￥<fmt:formatNumber value="${good.price-good.priceGroupBuy }" pattern="0.00"/> </h1>
							</div>
							<div class="miao_text10204">
								<h1><samp>限量：</samp><span>${good.activitNumber }</span><samp>件</samp></h1>
								<h2 id="nowTime"></h2>
							</div>
						</div>
					</div>
		   		</div>
		   </div>
	   </c:if>
	</c:forEach>
<!--   <div class="miao3">-->
<!--   <div class=box-163css>-->
<!--	<div id=tabc13>-->
<!--		<div class=al id=LeftArr13></div>-->
<!--		<div class=ashow2>-->
<!--			<UL  id=ISL_Cont_13>-->
<!--			  <c:forEach items="${goodList}" var="good" begin="0" end="14">  -->
<!--			      <c:if test="${good.isNext == 0}">-->
<!--				  <LI><a href="#"><img src="${ctx}${good.pic }" border="0"></a></LI>-->
<!--				  </c:if>-->
<!--		      </c:forEach>-->
<!--		  </UL>-->
<!--		</div>-->
<!--		<div class=ar id=RightArr13></div>-->
<!--	</div>-->
<!--	<SCRIPT type=text/javascript src="${ctx}/scripts/front/js/163css.js"></SCRIPT>-->
<!--</div>-->
<!--   </div>-->
   <div class="limitbuy01"><span>下期预告</span><!-- <samp>每天上午11:30开秒</samp> --></div>
   <div class="miao5" style="height:160px;">
   <div class=box-163css>
	<div id=tabc131>
		<div class=al id=LeftArr131></div>
		<div class=ashow2>
			<UL  id=ISL_Cont_131>
			   <c:forEach items="${goodList}" var="good" begin="0" end="14">
			       <c:if test="${good.isNext == 1}">
			  			<LI><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic}" border="0"></a></LI>
			       </c:if>
			   </c:forEach>
		  </UL>
		</div>
		<div class=ar id=RightArr131></div>
	</div>
	<SCRIPT type=text/javascript>
		var scrollPic_13 = new ScrollPic();
				scrollPic_13.scrollContId   = "ISL_Cont_131"; //内容容器ID
				scrollPic_13.arrLeftId      = "LeftArr131";//左箭头ID
				scrollPic_13.arrRightId     = "RightArr131"; //右箭头ID
				scrollPic_13.frameWidth     = ${nextCount}*222;//显示框宽度 **显示框宽度必须是翻页宽度的倍数
				scrollPic_13.pageWidth      = 222; //翻页宽度
				scrollPic_13.upright        = false; //垂直滚动
				scrollPic_13.listEvent      = "onclick"; //切换事件
				scrollPic_13.speed          = 10; //移动速度(单位毫秒，越小越快)
				scrollPic_13.space          = 10; //每次移动像素(单位px，越大越快)
				scrollPic_13.autoPlay       = false; //自动播放
				scrollPic_13.autoPlayTime   = 5; //自动播放间隔时间(秒)
				scrollPic_13.circularly		= true; //不循环
				scrollPic_13.initialize(); //初始化
	</SCRIPT>
</div>
   </div>
   <div class="limitbuy01"><span>秒杀规则</span></div>
   <div class="miao4">
    ${information.content }
   </div>
    <!--[if !IE]>秒杀结束<![endif]-->
  </div>
   <!--[if !IE]>热门团购完成<![endif]--> 
  </div> 
  
<%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
<!--<iframe width="100%" height="500" frameborder=0 scrolling=no src="bottom.htm" ></iframe>-->
</div>
</body>
</html>
