<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/photolist_page.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/header_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<link rel="stylesheet" href="${ctx}/styles/front/style/chosen.css" />

<script type=text/javascript src="${ctx}/scripts/front/js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>


<script language="javascript">
   function chgb(){	if(document.getElementById("ph1").className=="contr"){		
	   	document.getElementById("ph1").className="contr2"	
	   }else{		
	   	document.getElementById("ph1").className="contr";	
	   	}
   }
</script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/photoList.js"></script>

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
<input type="hidden" name="typeid" id="typeid" value="${goodtypeid }"/>
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
 <link rel="stylesheet" type="text/css" href="${ctx}/styles/jqPager/Pager.css" /><!-- 分页 -->
 <script language="JavaScript" type="text/javascript" src="${ctx}/scripts/front/common/common_pager.js"></script><!-- 分页 --> 
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jqPager/jquery.pager.js"></script><!-- 分页 -->
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/photoList.js"></script>
<script type=text/javascript src="${ctx}/scripts/front/js/cart.js"></script>

<!-- 分页的参数 -->
<input id="count" name="count" value="${pageInfo.count}" type="hidden" /><!-- 记录总数 -->
<input id="pageSize" name="pageSize" value="${pageInfo.pageSize}" type="hidden" /><!-- 每页显示记录数 -->
<input id="pageCount" name="pageCount" value="${pageInfo.pageCount}" type="hidden" /><!-- 总页数 -->
<input id="pageIndex" name="pageIndex" value="${pageInfo.pageIndex}" type="hidden" /><!-- 当前页数 -->
<input id="apptype" name="apptype" value="getSecondGoods" type="hidden" /><!--分页参数 -->
<input id="apptypes" name="apptypes" value="tuxing"  type="hidden" />
<input id="proptes" name="proptes" type="hidden" /><!--分页参数 -->


<input id="goodStr" name="goodStr" value="${good.str }" type="hidden" /><!--分页参数 -->

  <!--[if !IE]>中间<![endif]-->
  <div class="content">
    <!--[if !IE]>方向<![endif]-->
    <div class="instructions"><a href="${ctx }/index.do">首页</a>&nbsp; > &nbsp;<a href="${ctx }/getFirstLevelPage.do?goodtype.id=${goodTypeOne.id}&goodtype.searchType=1">${goodTypeOne.name }</a>&nbsp; > &nbsp;<span>${goodTypeTwo.name }</span></div>
    <!--[if !IE]>整体中间<![endif]-->
    <div class="categories">
      <!--[if !IE]>左侧<![endif]-->
      <div class="Categories_left">
        <!--[if !IE]>大家电<![endif]-->
        <div class="Categlf_text">
          <div class="Categlf_text01ys">产品分类</div>
          <div class="Categlf_text01"> <span><a href="#">${goodTypeOne.name }</a></span>
            <ul>
              <!--[if !IE]>大家电<![endif]-->
               <c:forEach items="${goodTypeList}" var="goodType">
              	<li><a href="${ctx }/getSecondGoods.do?goodType.id=${goodType.id }">${goodType.name }</a></li>
               </c:forEach>
              <!--[if !IE]>第一个家电循环结束<![endif]-->
            </ul>
          </div>
        </div>
        <!--[if !IE]>浏览本品类的客户看过<![endif]-->
        <div class="seenProduct" style="display:none;">
          <div class="seenProduct01">浏览本品类的客户看过</div>
          <div class="seenProduct02">
            <!--[if !IE]>第一个产品<![endif]-->
            <c:forEach items="${listOthers1}" var="browseOthers" begin="0" end="2">
	            <div class="seenProduct02_text">
	              <div class="seenProduct02_text01">
	                <div class="seenProduct02_text01_con1"><a href="${ctx }/cpxq.do?good.id=${browseOthers.goodId }"><img src="${ctx}${browseOthers.goodPic }" border="0" /></a></div>
	                <div class="seenProduct02_text01_con2"> <span>${browseOthers.clickValue }%</span> <samp>会看</samp> </div>
	              </div>
	             <div class="seenProduct02_text02"><a href="${ctx }/cpxq.do?good.id=${browseOthers.goodId }">${browseOthers.goodName }<samp>${browseOthers.introBrief }</samp></a><span>¥${browseOthers.goodPrice }</span></div>
	            </div>
            </c:forEach>
          </div>
        </div>
        <!--[if !IE]>浏览本品类的客户看过<![endif]-->
        <div class="seenProduct" style="display:none;">
          <div class="seenProduct01">浏览本品类的客户还看过</div>
          <div class="seenProduct02">
            <!--[if !IE]>第一个产品<![endif]-->
            <c:forEach items="${listOthers3}" var="browseOthers" begin="0" end="2">
	            <div class="seenProduct02_text">
	              <div class="seenProduct02_text01">
	                <div class="seenProduct02_text01_con1"><a href="${ctx }/cpxq.do?good.id=${browseOthers.goodId }"><img src="${ctx}${browseOthers.goodPic }" border="0" /></a></div>
	                <div class="seenProduct02_text01_con2"> <span>${browseOthers.clickValue }%</span> <samp>会看</samp> </div>
	              </div>
	            	 <div class="seenProduct02_text02"><a href="${ctx }/cpxq.do?good.id=${browseOthers.goodId }">${browseOthers.goodName }<samp>${browseOthers.introBrief }</samp></a><span>¥${browseOthers.goodPrice }</span></div>
	            </div>
            </c:forEach>
          </div>
        </div>
        <!--[if !IE]>最新降价<![endif]-->
        <div class="hotComments" style="display:none;">
          <div class="seenProduct01">最新浏览过的商品</div>
          <div class="hotCom_text1">
            <div class="Latestprices">
              <!--[if !IE]>第一个产品<![endif]-->
              <c:forEach items="${browseList}" var="browse" begin="0" end="9">
	              <div class="Latestpr_txt"> <span><a href="${ctx }/cpxq.do?good.id=${browse.goodId }"><img src="${ctx}${browse.goodPic }" /></a></span>
	                <p><a href="${ctx }/cpxq.do?good.id=${browse.goodId }">${browse.goodName }</a></p>
	                  <h1>¥${browse.goodPrice }</h1>
	              </div>
              </c:forEach>
              
            </div>
          </div>
        </div>
      </div>
      <!--[if !IE]>右侧<![endif]-->
      <div class="Categories_right">
        <!--[if !IE]>品牌分类<![endif]-->
        <div class="brandList">
          <div class="brandList01">
            <div class="brandList01_text">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</div>
            <div class="brandList01_text1">
              <ul>
				  <li><a href="javascript:void(0);" id="current2" name="brand" onclick="selectAlltype(this,'goodbrand')">全部</a></li>
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
	                 <li><a href="javascript:void(0);" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a> </li>
	                <c:forEach items="${kingvalList}" var="gk0" varStatus="i">
	                	<c:if test="${gk0.goodKingId==ga0.id}">
	                		<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk0.value }','prop${j.index }')">${gk0.value }</a></li>
	                	</c:if>
	                </c:forEach>
	              </ul>
	            </div>
	          </div>
          </c:forEach>
          
          <c:forEach items="${GoodAttrList}" var="ga1" begin="1" end="1"  varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga1.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="javascript:void(0);" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk1" varStatus="i">
	                	<c:if test="${gk1.goodKingId==ga1.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk1.value }','prop${j.index }')">${gk1.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	            </div>
	          </div>
          </c:forEach>
          <c:forEach items="${GoodAttrList}" var="ga2" begin="2" end="2" varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga2.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="javascript:void(0);" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk2" varStatus="i">
	                	<c:if test="${gk2.goodKingId==ga2.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk2.value }','prop${j.index }')">${gk2.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	            </div>
	          </div>
          </c:forEach>
          <c:forEach items="${GoodAttrList}" var="ga3" begin="3" end="3" varStatus="j">
	          <div class="brandList01">
	            <div class="brandList01_text">${ga3.name }：</div>
	            <div class="brandList01_text1">
	              <ul>
	                <li><a href="javascript:void(0);" id="current2" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
	                <c:forEach items="${kingvalList}" var="gk3" varStatus="i">
	                	<c:if test="${gk3.goodKingId==ga3.id}">
		                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk3.value }','prop${j.index }')">${gk3.value }</a></li>
		                </c:if>
					</c:forEach>
	              </ul>
	            </div>
	          </div>
          </c:forEach>
          
          <div style="display: none;" id="szd">
          	  <c:forEach items="${GoodAttrList}" var="ga4" begin="4" varStatus="j">
		          <div class="brandList01">
		            <div class="brandList01_text">${ga4.name }：</div>
		            <div class="brandList01_text1">
		              <ul>
		                <li><a id="current2" href="javascript:void(0);" name="prop${j.index }" onclick="selectAlltype(this,'goodprop')">全部</a></li>
		                <c:forEach items="${kingvalList}" var="gk4" varStatus="i">
		                	<c:if test="${gk4.goodKingId==ga4.id}">
			                	<li><a href="javascript:void(0);" name="goodprop" id=""  onclick="upstyle(this,'${i.index }','${gk4.value }','prop${j.index }')">${gk4.value }</a></li>
			                </c:if>
						</c:forEach>
		              </ul>
		            </div>
		          </div>
	          </c:forEach>	
          </div>
          <div class="brandList02">
          	<input type="hidden" id="proptStr"/>
          	<input type="hidden" id="brandStr"/>
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
                    <select id="checkId"  class="selectn1"  onchange="changeSort(this.value)" >
                      <option value="">--默认排序--</option>
                      <option value="salesVolume" >按销量由高到底</option>
                      <option value="recommend" >按价格由低到高</option>
                      <option value="ascPrice" >按价格由高到低</option>
                      <option value="sort" > 按好评由多到少</option>
                    </select>
                  </div>
                  
                   <form action="${ctx }/getSecondGoods.do?goodType.id=${goodTypeTwo.id }&goodType.parentId=${goodTypeOne.id }" method="post" name="SearchFrom">
					<input id="nameValue" name="good.name" type="text" style="display: none;" />
					<input id="goodTypeNameValue" name="good.brandName" type="text" style="display: none;" />
					<input id="goodCommentCount" name="good.commentCount" type="text" style="display: none;" />
					<input id="checkNameValue" name="checkName" type="text" style="display: none;" />
				  </form>
                  
                  <div class="Tab2_text2">
               		<a id="ph1" href="javascript:void(0);" class="contr" onclick="chgb()" >价格</a> <!-- onclick="checkSortShortcutSecond('${good.name }','价格')"  -->               </div>
                  <div class="Tab2_text1">
               		<a href="javascript:void(0);" class="photolist_btn1" onclick="changeSort('salesVolume')">销量</a>
                  </div>
                  <div class="Tab2_text1">
             		<a href="javascript:void(0);" class="photolist_btn2" onclick="changeSort('sort')">评论数</a>
                  </div>
                  <div class="Tab2_text1">
                 	<a href="javascript:void(0);" class="photolist_btn3" onclick="changeSort('createTime')">上架时间</a>  
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
                    <div class="Tab2_text401" onclick="pageer('${pageInfo.pageIndex-1 }')">
                     <a href="javascript:void(0)" class="Tab2_text402_btn" onclick="pageer(1)">上一页</a>                    </div>
                    <div class="Tab2_text402">
                       <a href="javascript:void(0)" class="Tab2_text402_btn" onclick="pageer(2)">下一页</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="Contentbox">
                <!-- 商品以图片形式展示 -->
                <div id="con_one_1" >
                  <!--[if !IE]>产品图片开始<![endif]-->
                  <div class="photolist02">
                    <ul id="tupian">
                      <!--[if !IE]>第一个产品<![endif]-->
<!--                       <c:forEach items="${GoodListSearch}" var="good">-->
<!--                       	   <li><a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx}${good.pic }" /></a>-->
<!--	                        <p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<span>${good.introBrief }</span></a></p>-->
<!--	                        <h1>¥${good.price }<span>市场价：</span><samp><span class="font">¥</span>${good.priceMarket }</samp></h1>-->
<!--	                        <h2><span><img src="${ctx}/Images/images/photo9.jpg" /></span><samp><a href="${ctx }/cpxq.do?good.id=${good.id }">(已有<c:if test="${good.commentCount==null }">0</c:if><c:if test="${good.commentCount!=null }">${good.commentCount}</c:if>人评价)</a></samp></h2>-->
<!--	                        <h3><span><a href="#">加入购物车</a></span><a href="javascript:void(0);" onclick="addGoodToFavorite('${good.id }')">收藏</a></h3>-->
<!--	                      </li>-->
<!--                       </c:forEach>-->
                    </ul>
                  </div>
                </div>
                 <!-- 商品以列表形式展示 -->
                 <div id="con_one_2" style="display:none">
                  <!--[if !IE]>纵向产品列表第一个产品<![endif]-->
	                 
                </div>
                
              </div>
            </div>
          </div>
          <div style="margin-right: 0px;height: 10px" ></div>
			 <div id="pagerBot" style="margin-right: 0px;height: 30px" ></div><!--分页组件-->
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
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
  </div>

   <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</div>

<!--[if !IE]>预备的按钮开始<![endif]
	<div style="width:1200px; margin:0 auto; text-align:center;"> 
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
	</div>
	<!--[if !IE]>预备的按钮结束<![endif]-->
	<!--[if !IE]>进入收藏夹的弹出层<![endif]
	<div class="Popuplogin">
<div class="Popuplogin01">
<h1>壹万店会员登录</h1>
<h2><span><a href="#">关闭</a></span><samp><input name="" type="button"  class="Popuplogin01btn"/></samp></h2>
</div>
<div class="Popuplogin02">
<div class="Popuplogin0201">
<div class="Popuplogin0201_content">
<div class="Popuplogin0202_title">
<h1>账号：</h1>
<h2><input name="" type="text"  class="Popuplogininput"/></h2>
</div>
<div class="Popuplogin0202_title">
<h1>密码：</h1>
<h2><input name="" type="text"  class="Popuplogininput"/></h2>
</div>
<div class="Popuplogin0202_title2">
<h1><input name="" type="button"  class="Popuploginbtn"/></h1>
<h2><a href="#">忘记密码</a></h2>
</div> 

</div>
</div>
<div class="Popuplogin0202">
<div class="Popuplogin0202_text">使用其他方式登录：</div>
<div class="Popuplogin0202_text1">
<h1><a href="#"><img src="${ctx}/Images/images/lon1.jpg" border="0" alt="QQ登录" /></a></h1><h1><a href="#"><img src="${ctx}/Images/images/lon3.jpg" border="0"  alt="新浪微博登录"/></a></h1><h1><a href="#"><img src="${ctx}/Images/images/lon2.jpg" border="0"  alt="支付宝登录"/></a></h1>
</div>
<div class="Popuplogin0202_text2">
<h1>
<span>还不是壹万店用户？ </span><br />
现在免费注册壹万店会员，便能立即享受便宜又放心的<br />
购物乐趣! <samp><a href="#">会员注册</a></samp></h1>
</div>
</div>
</div>
</div>

<!--[if !IE]>进入收藏夹的弹出层结束<![endif]-->
 
 
</body>
</html>
