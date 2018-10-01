<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/shoppingCart_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/clients_js/shoppingCart.js"></SCRIPT>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/validation_landing.js" ></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/header.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/login.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/cn.global.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>
<body>
<!-- 要跳转的url -->
<input type="hidden" id="geturl"/>

<div class="box">
<!--[if !IE]>头部<![endif]-->
  <div class="ctop">
	    <div class="top_con">
		      <div class="top_ctext">
			    	您好 
				    <c:if test="${loginCustomer!=null }">
				      	<a href="${ctx }/customersManage.do" target="_blank">${loginCustomer.code }</a>
				    </c:if>  ，欢迎光临麦芽网上商城！
			    </div>
			    <c:if test="${loginCustomer!=null }">
				    <div id="menu" style="padding-top:4px;">
					    <ul>
						    <li class="solutions"><a href="javascript:void(0);" onclick="loginOut()">退出</a></li>
					    </ul>
				    </div> 
			    </c:if>
			    <c:if test="${loginCustomer==null }">
				    <div class="top_ctext1">
					  	<!--[if !IE]>登录弹出框<![endif]-->
					  	<div id="menu">
					     	<ul>
					       		<li class="solutions"><a href="${ctx }/frontLogin.do">登录</a></li>
					     	</ul>
				    	</div> 
						<div id="menu-popup"  style="display:none;">
				  			<div class="popup solutions">
				    			<div class="menu_content">
									<form action="" id="loginHeadForm" name="loginForm" method="post">
										<div class="login_hole0201">
											<div class="login_hole0201_title">
												<h1>账号：</h1>
												<h2><input name="customer.code" id="codeUser" type="text"  class="logininput"/></h2>
											</div>
											<div class="login_hole0201_title">
												<h1>密码：</h1>
												<h2><input name="customer.pwd" id="pwdUser" type="password"  class="logininput"/></h2>
											</div>
											<div class="login_hole0202">
												<h1><input name="" type="button"  class="loginbtn" onclick="submitHeadForm()"/></h1>
												<h2><a href="#">忘记密码</a></h2>
											</div>
										</div>
									</form>
				    			</div>
				  			</div>
						</div>
				
				 		<!--[if !IE]>注册<![endif]-->
				       	<div class="top_ctext1_text">
				       		<input name="" type="button" class="subbmit" value="注册"  onclick="zhuce()"/>
				       	</div>
					    <!--[if !IE]>注册完成<![endif]-->
				    </div>
			   </c:if>
		      
		      <div class="top_ctext2"><span class="ys1">
		      <c:if test="${loginCustomer!=null }">
      		  <a href="${ctx }/customersManage.do">我的商城</a> |
      	      </c:if>
      	      <c:if test="${loginCustomer==null }">
      		  <a href="javascript:void(0);" onclick="checkUsers()">我的商城</a> |
       	      </c:if>
		      </span>
		      <span class="ys2"><img src="${ctx}/Images/images/a1.jpg" />
      	</span><span class="ys3"><a href="${ctx}/ShoppingCar.do">购物车<c:if test="${shoppingCarSize==null}">0</c:if>${shoppingCarSize }件</a> 
        | <a href="${ctx}/infor.do?information.type=7" >帮助中心</a>
      	</span>
		      </div>
	    </div>
	    <!--  
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
      <div class="topf">
        <div class="logo">
           <c:forEach items="${advertiseList}" var="promotionActivity">
           <c:if test="${promotionActivity.placeId=='LOG'}"> 
	       <a href="${ctx }/index.do"><img src="${ctx}${promotionActivity.pic }" /></a>
	       </c:if>
	       </c:forEach> 
        </div>
		 <!--[if !IE]>购物车步骤<![endif]-->
		<div class="shopcart"><h1>1、我的购物车</h1><h2>2、填写核对订单信息  </h2><h3>3、成功提交订单</h3></div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <div class="content">
   <!--[if !IE]>购物车列表<![endif]-->
   <div class="shopcart1">
   <table width="1200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="20" height="30" valign="middle" class="shopcartys"></td>
    <td width="460" valign="middle" class="shopcartys" align="left">产品</td>
    <td width="120" align="center" valign="middle" class="shopcartys">本店价</td>
    <!-- <td width="120" align="center" valign="middle" class="shopcartys">返现</td> -->
    <td width="120" align="center" valign="middle" class="shopcartys">规格</td>
    <td width="120" align="center" valign="middle" class="shopcartys">数量</td>
    <td width="120" align="center" valign="middle" class="shopcartys">库存</td>
    <td width="120" align="center" valign="middle" class="shopcartys">操作</td>
  </tr> 
  <!-- 总数 总金额 总积分 -->
	<c:set var="totalNum" value="0"/>
	<c:set var="money" value="0" />
	<c:set var="credits" value="0" />
  <c:forEach items="${shoppingCar.goodsInCarList}" var="goodsIncar" varStatus="i">
  	    <c:set var="totalNum" value="${totalNum + goodsIncar.count}" />
		<c:set var="money" value="${money + goodsIncar.totalMoney}" />
		<c:set var="credits" value="${credits + goodsIncar.credits*goodsIncar.count}"/>
		<input type="hidden" name="id${i.index}" id="id${i.index}" value="${goodsIncar.id}" />
		<input type="hidden" name="credits${i.index}" id="credits${i.index}" value="${goodsIncar.credits}" />
		<input type="hidden" name="id${i.index}" id="id${i.index}" value="${goodsIncar.id}" />     
	  <tr>
	    <td width="20"  valign="middle" class="shopcartys1"></td>
	    <td width="460" valign="middle" class="shopcartys1" align="left">
		<div class="phlist">
		
		
		<h1><input name="check111" id="chkb${i.index}" onclick="cutMoney('${i.index}')" type="checkbox" value="${goodsIncar.id}" checked/></h1>
		
		
		<h2><a href="${ctx }/cpxq.do?good.id=${goodsIncar.goodId }"><img src="${ctx }${goodsIncar.pic }" border="0" /></a></h2>
		<h3><a href="${ctx }/cpxq.do?good.id=${goodsIncar.goodId }">${goodsIncar.name }</a></h3>
		</div>
		
		</td>
	    <td width="120" align="center" valign="middle" class="shopcartys1">
		<span class="shopcartys3"><span class="font2">¥</span><span id="price${i.index}"><fmt:formatNumber pattern="0.00">${goodsIncar.price}</fmt:formatNumber></span></span>
		</td>
	    <td width="120" align="center" valign="middle" class="shopcartys1">${goodsIncar.specificationVal }</td>
	    <td width="120" align="center" valign="middle" class="shopcartys1">
		<div class="phlist_click">
		<h1><input name="" type="button" class="phlistbtn" onclick="changeNum(1,'${i.index }')"/></h1>
		<!-- <h2 id="count${i.index}">${goodsIncar.count}</h2> -->
		
		<h2><input id="count${i.index}" value="${goodsIncar.count}" onkeyup="changeNum(3,'${i.index }')" style="border:0px;width:15px;height:17px;padding:1px;margin-top:4px;"/></h2>
		
		<h1><input name="" type="button" class="phlistbtn1" onclick="changeNum(2,'${i.index }')"/></h1>
		</div>
		</td>
	    <td width="120" align="center" valign="middle" class="shopcartys1" id="Whethergoods${i.index }">有货</td>
	    <td width="120" align="center" valign="middle" class="shopcartys1"><span class="shopcartys4"><a href="#" onclick="deleteGood('${goodsIncar.id }')">删除</a></span><span class="shopcartys4"><a href="#" onclick="addGoodToFavorite('${goodsIncar.id }')">移入收藏夹</a></span></td>
	  </tr>
  </c:forEach>
</table>
   </div>
   <!--[if !IE]>end<![endif]-->
   <div class="shopcart2">
   
   <div class="shopcart2_text101">
   <h1 id="totalNum"><span id="totalNumber">${totalNum }</span>件共计：</h1>
   <h2><span class="font">¥</span><span id="totalMoney">${money }</span></h2>
   </div>
    
   </div>
   <div class="shopcart3">
   <div class="shopcart301"><a href="javascript:void(0)" onclick="clearCar()">清空购物车</a><br/>
     <a href="${ctx}/index.do">继续购物</a></div>
   <div class="shopcart302">
   <div class="shopcart302_text">
   <h1>&nbsp;&nbsp;</h1>
   <h2>总       计：</h2>
   <h3 id="totalMoneys">¥${money }</h3>
   </div>
   <div class="shopcart302_text1"><input name="" type="button" class="shopcartbtn"  onclick="jiesuanJ()"/></div>
   </div>
   </div>
    <!--[if !IE]>浏览本商品的客户还买了<![endif]-->
	<div class="lookproduct">
	<samp>浏览本商品的客户还买了</samp>
	</div>
	<!--[if !IE]>列表<![endif]-->
	<div class="lookproduct1">
		<ul>
		<!--[if !IE]>第一个产品<![endif]-->
			<c:forEach items="${goodList}" var="good" begin="0" end="9">
				<li> <a href="${ctx }/cpxq.do?good.id=${good.id }"><img src="${ctx }${good.pic }" /></a>
					<p><a href="${ctx }/cpxq.do?good.id=${good.id }">${good.name }<span>${good.introBrief }</span></a></p>
	                <h1><span class="lookproduct1ys">¥${good.price }</span><span>市场价：</span><samp>¥${good.priceMarket }</samp></h1>
					<h2><span>
						<c:if test="${good.commentLevel==1 }"><img src="${ctx}/Images/images/pu14.jpg" /></c:if><!-- 1分 -->
				        <c:if test="${good.commentLevel==2 }"><img src="${ctx}/Images/images/pu13.jpg" /></c:if><!-- 2分 -->
				        <c:if test="${good.commentLevel==3 }"><img src="${ctx}/Images/images/pu12.jpg" /></c:if><!-- 3分 -->
				        <c:if test="${good.commentLevel==4 }"><img src="${ctx}/Images/images/pu11.jpg" /></c:if><!-- 4分 -->
			            <c:if test="${good.commentLevel==5 }"><img src="${ctx}/Images/images/pu10.jpg" /></c:if><!-- 5分 -->
					</span><samp><a href="${ctx }/cpxq.do?good.id=${good.id }">(已有<c:if test="${good.commentCount==null }">0</c:if><c:if test="${good.commentCount!=null }">${good.commentCount}</c:if>人评价)</a></samp></h2>
					<h3><span><input name="" type="button" class="lookbtn" onclick="Todetail('${good.id}')"/></span><a href="javascript:addGoodToFavorite('${good.id }')">收藏</a></h3>
				</li>
			</c:forEach>		
		</ul>
	</div>
	<!--[if !IE]>列表完成<![endif]-->
  </div>
  
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
  <!--[if !IE]>中间完成<![endif]
  <iframe width="100%" height="500" frameborder=0 scrolling="no" src="bottom.htm" style="padding-top:0px; overflow:hidden;"></iframe>
	-->
</div>
<!--[if !IE]>进入收藏夹的弹出层<![endif]-->
<div id="fade" class="black_overlay"></div>
	<div id="MyDiv" class="Popuplogin" style="display: none;">
<div class="Popuplogin01">
<h1>商城会员登录</h1>
<h2 onclick="CloseDiv('MyDiv','fade')" ><span><a onclick="CloseDiv('MyDiv','fade')" href="javascript:void(0)">关闭</a></span><samp><input name="" type="button"  class="Popuplogin01btn"/></samp></h2>
</div>
<div class="Popuplogin02">
<div class="Popuplogin0201">
<div class="Popuplogin0201_content">
<div class="Popuplogin0202_title" style="padding-top: 15px; height: 55px;">
<h1>账号：</h1>
<h2><input name="customer.customerCode" id="customersCode" type="text"  class="Popuplogininput" onfocus="dlbhDIV()" onblur="sqbhDIV()"  value="昵称/邮箱/已注册手机"/></h2>
<h3 style="display: none;"><span><img src="${ctx}/Images/images/pass9.jpg" /></span>帐号或密码错误，请重新输入</h3>
</div>
<div class="Popuplogin0202_title">
<h1>密码：</h1>
<h2><input name="customer.customerPwd" id="customersPwd" type="password"  class="Popuplogininput" onfocus="this.style.border='1px solid #FEA710'" onblur="this.style.border='1px solid #dadada'"/></h2>
</div>
<div class="Popuplogin0202_title2">
<h1><input name="" type="button"  class="Popuploginbtn" onclick="submitDIVForm()"/></h1>
<h2><a href="#">忘记密码</a></h2>
</div> 

</div>
</div>
<div class="Popuplogin0202">
< 
<div class="Popuplogin0202_text2">
<h1>
<span>还不是商城用户？ </span><br />
现在免费注册商城会员，便能立即享受便宜又放心的<br />
购物乐趣! <samp><a href="javascript:void(0);" onclick="zhuce()">会员注册</a></samp></h1>
</div>
</div>
</div>
</div>
<!--[if !IE]>进入收藏夹的弹出层结束<![endif]-->
</body>
</html>
