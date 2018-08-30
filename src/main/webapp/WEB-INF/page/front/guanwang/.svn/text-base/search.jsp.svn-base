<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/productSearch_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script type=text/javascript src="${ctx}/scripts/front/js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/lanrentuku.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/search.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/cart.js"></script>

<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
<script>
<!--
/*第一种形式 第二种形式 更换显示样式*/
function secBoard(name,cursel,n,values){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
$('#apptypes').val(values);
}
}
//-->
</script>
<!--[if !IE]>
<script>

/*第一种形式 第二种形式 更换显示样式*/
function pxfs(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
menu.className=i==cursel?"contr":"";
}
}

</script>
<![endif]-->
<script language="javascript"> 
function MM_showHideLayers(divID,paraA,status){ 
if(status=="show"){ 
document.getElementById(divID).style.display="block"; 
$('#button2 ').show();
$('#button1 ').hide();
}else if(status=="hidden"){ 
document.getElementById(divID).style.display="none"; position="relative";
$('#button2 ').hide();
$('#button1 ').show();
} 
} 
</script> 
</head>

<body>
<input type="hidden" name="" id="typeid" size="30" value="${goodtypeid }"/>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/jqPager/Pager.css" /><!-- 分页 -->
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/front/common/common_pager.js"></script><!-- 分页 --> 
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jqPager/jquery.pager.js"></script><!-- 分页 -->

 <!-- 分页的参数 -->
<input id="count" name="count" value="${pageInfo.count}" type="hidden" /><!-- 记录总数 -->
<input id="pageSize" name="pageSize" value="${pageInfo.pageSize}" type="hidden" /><!-- 每页显示记录数 -->
<input id="pageCount" name="pageCount" value="${pageInfo.pageCount}" type="hidden" /><!-- 总页数 -->
<input id="pageIndex" name="pageIndex" value="${pageInfo.pageIndex}" type="hidden" /><!-- 当前页数 -->

<input id="apptype" name="apptype" value="shoptype" type="hidden" /><!--分页参数 -->
<input id="apptypes" name="apptypes" value="tuxing"  type="hidden" />
<input id="proptes" name="proptes" type="hidden" /><!--分页参数 -->
<input type="hidden" value="${typeNames }" id="typeNames" />
<input type="hidden" value="${shoptypeNames }" id="shoptypeNames" />
<input type="hidden" value="${goodBrandId }" id="goodBrandId" />

  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>整体中间<![endif]-->
    <div class="categories">
      <!--[if !IE]>左侧<![endif]-->
      <div class="Categories_left">
        <!--[if !IE]>大家电<![endif]-->
        <div class="Categlf_text"> 
        <div class="Categlf_text01ys">所有品类</div>
         <!--[if !IE]>左侧折叠菜单<![endif]-->
        <div class="Categlf_text01">
       <script language=javascript id=clientEventHandlersJS>
<!--
var number=0;
var lbmc;
function LMYC() {
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = 'images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval("LM" + i);  
    var treePic = document.getElementById('pic' + i);   
    if (lbmc.style.display == 'none') {  
        //LMYC();
        treePic.src = '${ctx}/Images/images/bit06.gif';
        lbmc.style.display = 'block';
    }
    else {
        treePic.src = '${ctx}/Images/images/bit05.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
<table cellSpacing=0 cellPadding=0 width="246" border=0>
  <tbody>
  	<c:forEach items="${goodTypeList}" var="goodtype1" begin="0" end="0">
	    <tr>
	      <td  height=22 valign="middle"  width="246" id="pulldownMenu">
	      	<a onclick="javascript:ShowFLT(1)" href="javascript:void(null)" >
	      		<span><IMG id="pic1" height=14 src="${ctx}/Images/images/bit06.gif" width=14></span><h1>${goodtype1.name }</h1> 
	      	</a><h2 class="ys">(${goodtype1.warehousecount })</h2>
	      </td>
	    </tr>
		<tr id=LM1>
		   <td>
		     <table cellSpacing=0 cellPadding=0 width="246" border=0>
		        <tbody>
		          <c:forEach items="${goodtype1.children}" var="goodtype2">
		            <tr>
		              <td class="smallClass" height=22><A title="" href="${ctx }/shoptype.do?good.goodTypeId=${goodtype2.id }" target=_parent >${goodtype2.name }</A><span>(${goodtype2.warehousecount })</span> </td>
		            </tr>
		          </c:forEach>
		        </tbody>
		      </table>
		   </td>
		</tr>
    </c:forEach>
    
    <c:forEach items="${goodTypeList}" var="goodtypes1" begin="1" varStatus="i">
	    <tr>
	      <td  height=22 valign="middle"  width="246" id="pulldownMenu">
		      <a onclick="javascript:ShowFLT('${i.index+1 }')" href="javascript:void(null)" >
		      	<span><IMG id="pic${i.index+1 }" height=14 src="${ctx}/Images/images/bit05.gif" width=14></span><h1>${goodtypes1.name }</h1> 
		      </a><h2 class="ys">(${goodtypes1.warehousecount })</h2>
		  </td>
	    </tr>
		<tr id="LM${i.index+1 }" style="DISPLAY: none">
		   <td>
		      <table cellSpacing=0 cellPadding=0 width="246" border=0>
		        <tbody>
		          <c:forEach items="${goodtypes1.children}" var="goodtypes2">
		            <tr>
		              <td class="smallClass" height=22><A title="" href="${ctx }/shoptype.do?good.goodTypeId=${goodtypes2.id }">${goodtypes2.name }</A><span>(${goodtypes2.warehousecount })</span> </td>
		            </tr>
		          </c:forEach>
		        </tbody>
		      </table>
		    </td>
		</tr>
    </c:forEach>
  </tbody>
</table> 
 </div>
          <!--[if !IE]>左侧折叠菜单结束<![endif]-->
        </div> 
       <!--[if !IE]>最新降价<![endif]-->
        <div class="hotComments" style = "display:none">
          <div class="seenProduct01">最近浏览过的商品</div>
          <div class="hotCom_text1">
            <div class="Latestprices">
              <!--[if !IE]>第一个产品<![endif]-->
              <c:forEach items="${browseList}" var="browse" begin="0" end="4">
	              <div class="Latestpr_txt"> <span><a href="${ctx }/cpxq.do?good.id=${browse.goodId }"><img src="${ctx}${browse.goodPic }" /></a></span>
	                <p><a href="${ctx }/cpxq.do?good.id=${browse.goodId }">${browse.goodName }<samp>${browse.introBrief }</samp></a></p>
	                  <h1>¥${browse.goodPrice }</h1>
	              </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
      <!--[if !IE]>右侧<![endif]-->
      <div class="Categories_right">
      <!--[if !IE]>相关搜索<![endif]-->
      <!-- 
      <div class="relatedSearches"><span>相关搜索：</span>
	      <samp>
		      <a href="javascript:void(0);" onclick="SearchWhereSubmit('工作服')">工作服</a> 
	          <a href="javascript:void(0);" onclick="SearchWhereSubmit('安全鞋')">安全鞋</a> 
	          <a href="javascript:void(0);" onclick="SearchWhereSubmit('口罩')">口罩</a> 
	          <a href="javascript:void(0);" onclick="SearchWhereSubmit('手套')">手套</a> 
	      </samp>
      </div>
       -->
        <!--[if !IE]>品牌分类<![endif]-->
         <div class="brandList">
          <div class="brandList01">
            <div class="brandList01_text">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</div>
            <div class="brandList01_text1">
              <ul>
				  <li><a href="#" id="current2" name="brand" onclick="selectAlltype(this,'goodbrand')">全部</a></li>
				  <c:forEach items="${goodBrandList}" var="goodBrand" varStatus="i">
				  	 <li><a href="javascript:void(0);" name="goodbrand" id=""  onclick="upstyle(this,'${i.index }','${goodBrand.name }','brand')">${goodBrand.name }</a></li> 
				  </c:forEach>
			  </ul>
            </div>
          </div>
          	
          <c:forEach items="${GoodAttrList}" var="ga0" begin="0" end="0"  varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga0.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                 <li><a href="#" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a> </li>
	                <c:forEach items="${kingvalList}" var="gk0" varStatus="i">
	                	<c:if test="${gk0.goodKingId==ga0.id}">
	                		<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk0.value }','prop${j.index }')">${gk0.value }</a></li>
	                	</c:if>
	                </c:forEach>
	              </ul>
	              <c:if test="${ga0.name == '价格'}">
	            	 <div class="price02"><h1><input name="" id="salmin" type="text" class="price02_input" title="最低价"/></h1><h2><img src="${ctx}/Images/images/b1.jpg" /></h2><h1><input name="" id="salmax" type="text" class="price02_input"  title="最高价"/></h1><h3><input name="" type="button" class="price02_btn" value="确定" onclick="salPrice();"/></h3></div> 
	            </c:if>
	            </div>
	          </div>
          </c:forEach>
          
          <c:forEach items="${GoodAttrList}" var="ga1" begin="1" end="1"  varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga1.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="#" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk1" varStatus="i">
	                	<c:if test="${gk1.goodKingId==ga1.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk1.value }','prop${j.index }')">${gk1.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	              <c:if test="${ga1.name == '价格'}">
	            	 <div class="price02"><h1><input name="" id="salmin" type="text" class="price02_input" title="最低价"/></h1><h2><img src="${ctx}/Images/images/b1.jpg" /></h2><h1><input name="" id="salmax" type="text" class="price02_input"  title="最高价"/></h1><h3><input name="" type="button" class="price02_btn" value="确定" onclick="salPrice();"/></h3></div> 
	            </c:if>
	            </div>
	          </div>
          </c:forEach>
          <c:forEach items="${GoodAttrList}" var="ga2" begin="2" end="2" varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga2.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="#" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk2" varStatus="i">
	                	<c:if test="${gk2.goodKingId==ga2.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk2.value }','prop${j.index }')">${gk2.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	              <c:if test="${ga2.name == '价格'}">
	            	 <div class="price02"><h1><input name="" id="salmin" type="text" class="price02_input" title="最低价"/></h1><h2><img src="${ctx}/Images/images/b1.jpg" /></h2><h1><input name="" id="salmax" type="text" class="price02_input"  title="最高价"/></h1><h3><input name="" type="button" class="price02_btn" value="确定" onclick="salPrice();"/></h3></div> 
	             </c:if>
	            </div>
	          </div>
          </c:forEach>
          <c:forEach items="${GoodAttrList}" var="ga3" begin="3" end="3" varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga3.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="#" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk3" varStatus="i">
	                	<c:if test="${gk3.goodKingId==ga3.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk3.value }','prop${j.index }')">${gk3.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	              <c:if test="${ga3.name == '价格'}">
	            	 <div class="price02"><h1><input name="" id="salmin" type="text" class="price02_input" title="最低价"/></h1><h2><img src="${ctx}/Images/images/b1.jpg" /></h2><h1><input name="" id="salmax" type="text" class="price02_input"  title="最高价"/></h1><h3><input name="" type="button" class="price02_btn" value="确定" onclick="salPrice();"/></h3></div> 
	            </c:if>
	            </div>
	          </div>
          </c:forEach>
          
          <div style="display: none;" id="szd">
          	  <c:forEach items="${GoodAttrList}" var="ga4" begin="4" varStatus="j">
		          <div class="brandList01">
		            <div class="brandList01_text">${ga4.name }：</div>
		            <div class="brandList01_text1">
		              <ul>
		                <li><a href="#" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
		                <c:forEach items="${kingvalList}" var="gk4" varStatus="i">
		                	<c:if test="${gk4.goodKingId==ga4.id}">
			                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk4.value }','prop${j.index }')">${gk4.value }</a></li>
			                </c:if>
						</c:forEach>
		              </ul>
		              <c:if test="${ga4.name == '价格'}">
	            	 <div class="price02"><h1><input name="" id="salmin" type="text" class="price02_input" title="最低价"/></h1><h2><img src="${ctx}/Images/images/b1.jpg" /></h2><h1><input name="" id="salmax" type="text" class="price02_input"  title="最高价"/></h1><h3><input name="" type="button" class="price02_btn" value="确定" onclick="salPrice();"/></h3></div> 
	            </c:if>
		            </div>
		          </div>
	          </c:forEach>	
          </div>
       	  <input type="hidden" id="proptStr"/>
          <input type="hidden" id="brandStr"/>
          
          <div class="brandList02">
		  <!--[if !IE]>往下拉伸的按钮<![endif]-->
            <input name="" id="button1" type="button" class="brandListbtn" onclick="MM_showHideLayers('szd','','show')" />
			<!--[if !IE]>收起按钮<![endif]-->
			<input name="" id="button2" type="button" class="brandListbtn1" onclick="MM_showHideLayers('szd','','hidden')" />
			<!--[if !IE]>收起按钮<![endif]-->
            </div>
        </div>
        <!--[if !IE]>产品列表选项卡<![endif]-->
        <div class="photolist">
          <div class="photolist01">
            <div class="Tab2">
              <div class="Tab201">
                <div class="Tab201_content">
                  <div class="Tab2_text">排序：</div>
                  <div class="Tab2_text1">
                    <select id="checkSelectId"  class="selectn1"  onchange="changeSort(this.value)" >
                      <option value="">默认排序</option>
                      <option value="recommend" >价格从低到高</option>
                      <option value="ascPrice" >价格从高到低</option>
                      <option value="salesVolume" >销量从高到低</option>
                      <option value="sort" >评论从多到少</option>
                      <option value="createTime" >最新上线</option>
                    </select>
                  </div>
                  
                  <form action="${ctx }/shoptype.do" method="post" name="SearchFromName">
					<input id="nameValue" name="good.name" type="text" style="display: none;" />
					<input id="goodTypeNameValue" name="good.brandName" type="text" style="display: none;" />
					<input id="goodCommentCount" name="good.commentCount" type="text" style="display: none;" />
					<input id="checkNameValue" name="checkName" type="text" style="display: none;" />
				  </form>
				  
                  
                  <div class="photolist_btn">
               		<a id="px1" href="javascript:void(0);"  class="contr" onclick="chgbPrice()" >价格</a></div><!-- checkSortShortcut('${good.name }','价格' -->
                  <div class="photolist_btn1">
               		<a id="px2" href="javascript:void(0);" class="" onclick="changeSort('salesVolume')">销量</a>
                  </div>
                  <div class="photolist_btn2">
             		<a id="px3" href="javascript:void(0);" class="" onclick="changeSort('sort')">评论数</a>
                  </div>
                  <div class="photolist_btn3">
                 	<a id="px4" href="javascript:void(0);" class=""  onclick="changeSort('createTime')">上架时间</a>  
                  </div>
                </div>
                <div class="Tab201_content1">
                  <div class="Tab2_text">显示：</div>
                  <div class="Menubox">
                    <ul>
                      <li id="one1" onclick="secBoard('one',1,2,'tuxing')"  class="hover">图片</li>
                      <li id="one2" onclick="secBoard('one',2,2,'libiao')" >列表</li>
                    </ul>
                  </div>
                  <div class="Tab2_text3"><span id="page1">${pageInfo.pageIndex}</span>/<span id="page2">${pageInfo.pageCount}</span></div>
                  <div class="Tab2_text4">
                    <div class="Tab2_text401">
                     <a href="javascript:void(0)" class="Tab2_text402_btn" onclick="pageer(1)">上一页</a>                    </div>
                    <div class="Tab2_text402">
                       <a href="javascript:void(0)" class="Tab2_text402_btn" onclick="pageer(2)">下一页</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="Contentbox">
                <div id="con_one_1" >
                  <!--[if !IE]>产品图片开始<![endif]-->
                  <div class="photolist02" id="photolist02">
                  </div>
               </div>
                
                
              <div id="con_one_2" style="display:none">
                 <!--[if !IE]>纵向产品列表第一个产品<![endif]-->
                 <!-- 
                 <div class="wantedList">
	                 <div class="wantedList01">
		                 <div class="wantedList01_text"><a href="detail.html"><img src="images/photo8.jpg" /></a></div>
		                 <div class="wantedList01_text1"> 
							 <p><a href="detail.html">苹果平板电脑 iPad 2 MC979CH/A 16G WIFI<span class="wancolor">版 白色 苹果平板电脑</span></a></P>
							 <samp>¥2969.00</samp>
			                 <h1><span><img src="${ctx }/Images/images/photo9.jpg" /></span><samp><a href="#">(已有6人评价)</a></samp></h1>
		                 </div>
	                 </div>
	                 <div class="wantedList02"><a href="shoppingCart.html">加入购物车</a><span><a href="myFavorites.html">收藏</a></span></div>
                 </div>
                 -->
            </div>
              </div>
            </div>
          </div>
			 <div id="pagerBot" class="paging1" ></div><!--分页组件-->
         
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
	
  </div>
   <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>

<!--[if !IE]>预备的按钮开始<![endif]
	<div style="width:1200px; margin:0 auto; text-align:center;" style="display:none;"> 
	<!--[if !IE]>销量点击显示的按钮样式<![endif]
	<table width="1200" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="100"><a href="#" class="photolist_btn1Contrary">销量</a></td>
    <td width="100"><a href="#" class="photolist_btn2Contrary">评论数</a></td>
    <td width="100"><a href="#" class="photolist_btn3Contrary">上架时间</a></td>
    <td width="100"><a href="#" class="photolist_btnContrary">价格</a></td>
    <td width="100"><a href="#" class="photolist_btnContrary1">价格</a></td>
    <td width="100">&nbsp;</td>
    <td width="100">&nbsp;</td>
  </tr>
</table>
	</div>-->
	<!--[if !IE]>预备的按钮结束<![endif]-->

</body>
</html>
