<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网上商城</title>
<link href="${ctx }/styles/front/style/header_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/styles/front/style/base.css" type="text/css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<!--<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>-->
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/lanrentuku.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/cn.global.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/login.js?version=${version}"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/header.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/validation_landing.js" ></script>


<script>
  function changeDiv(tag,method){
   document.getElementById(tag).style.display = method;
  }
  $(document).ready(function(){
       $("body").keydown(function(e) {
          var curKey = e.which; 
          if (curKey == 13){
               $(".Popuploginbtn").click(); 
           }
       });
  });
</script>
</head>
<body>
<!-- 要跳转的url -->
<input type="hidden" id="geturl"/>

<!--[if !IE]>头部<![endif]-->
<div class="ctop">
	<div class="top_con">
    <div class="top_ctext">
    	您好 
	    <c:if test="${loginCustomer!=null }">
	      	<a href="${ctx }/customersManage.do" target="_blank">${loginCustomer.code }</a>
	    </c:if>  ，欢迎光临商城！      
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
			<div id="menu-popup" style="display:none;">
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
									<h2><a href="#" >忘记密码</a></h2>
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
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
    <div class="topf">
    <div class="logo">
    <div class="logo01">
    <c:forEach items="${advertiseList}" var="promotionActivity">
    <c:if test="${promotionActivity.placeId=='LOG'}"> 
	       <a href="${ctx }/index.do"><img src="${ctx}${promotionActivity.pic }" /></a>
	</c:if>
	</c:forEach>
    </div>
    <div class="logo03"  onmouseout="changeDiv('layer1','none')" onmouseover="changeDiv('layer1','block')">
	 
        </div>
		</div>
      <div class="seacher">
          <div class="seacher01">
            <div class="input01"> 
              <!-- onblur="if(this.value=='') {this.value='搜索商品';}" onfocus="if(this.value=='搜索商品') {this.value='';}" -->
              <input name=""  id="shoptypeName" type="text" class="input" />
            </div>
            <div class="btn01">
              <input name="" type="button" class="btn02"  onclick="selectType()"/>
            </div>
            <form action="${ctx }/shoptype.do" method="post" name="SearchNameForm">
				<input id="nameValue" name="good.name" type="text" style="display: none;"/>
			</form> 
            
          </div>
        </div>
        </div>
        </div>
        </div>
<!--[if !IE]>导航<![endif]-->
 <div class="navMenu">
    <div class="subMenu">
      <div class="subMenu1">
        <div class="subMenu1_title" >
          <div class="topnav" >
            <div class="MNav">
              <h1 class="t1" ><a href="#" target="_parent">全部商品分类</a></h1>
              <h1 class="t2">
                <input name="" type="button" class="tnav_btn" />
              </h1>
              <!--[if !IE]>点击全部商品出现的弹出层<![endif]-->
              <div  id="layer" style="z-index:9999; display:none;">
                  <div id="warp1000">
                  <div id="allsort">
                    <div id="allsortlist">
                      <!--[if !IE]>大家电<![endif]-->
                      <div class="navlist icon01" >
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span><img src="${ctx}/Images/images/m1.jpg" /></span><a href="#">大家电</a></div>
                            <div id="t_text02">
                            <a href="#" id="ta">空调</a> 
                            <a href="#" id="ta">冰箱</a> 
                            <a href="#" id="ta">洗衣机</a> 
                            <a href="#" id="ta">电视机</a> 
                            <a href="#" id="ta">空调</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>end<![endif]-->
                      <!--[if !IE]>厨卫电器-<![endif]-->
                      <div class="navlist icon02">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span style="padding-top:7px;"><img src="${ctx}/Images/images/d1.gif" /></span><a href="#">厨卫电器</a></div>
                            <div id="t_text02"><a href="#" id="ta">热水器</a> <a href="#" id="ta">抽烟机</a> <a href="#" id="ta">消毒柜</a> <a href="#" id="ta">洗碗机</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>生活电器<![endif]-->
                      <div class="navlist icon03">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span style="padding-top:7px;"><img src="${ctx}/Images/images/d2.gif" /></span><a href="#">生活电器</a></div>
                            <div id="t_text02"><a href="#" id="ta">电饭煲</a> <a href="#" id="ta">电炖锅</a> <a href="#" id="ta">电饼铛</a> <a href="#" id="ta">电水壶</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>end<![endif]-->
                      <!--[if !IE]>手机数码<![endif]-->
                      <div class="navlist icon04">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span style=" padding-top:5px;"><img src="${ctx}/Images/images/c4.png" /></span><a href="#">手机数码</a></div>
                            <div id="t_text02"><a href="#" id="ta">手机</a> <a href="#" id="ta">数码相机</a> <a href="#" id="ta">MP3</a> <a href="#" id="ta">MP4</a><a href="#" id="ta">单反相机</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>电脑办公<![endif]-->
                      <div class="navlist  icon05">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span style=" padding-top:5px;"><img src="${ctx}/Images/images/d3.gif" /></span><a href="#">电脑办公</a></div>
                            <div id="t_text02"><a href="#" id="ta">电脑</a> <a href="#" id="ta">笔记本</a> <a href="#" id="ta">鼠标</a> <a href="#" id="ta">键盘</a> <a href="#" id="ta">硬盘</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>运营商<![endif]-->
                      <div class="navlist icon06">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span style=" padding-top:5px;"><img src="${ctx}/Images/images/a9.jpg" /></span><a href="#">运营商</a></div>
                            <div id="t_text02"><a href="#" id="ta">电子词典</a> <a href="#" id="ta">电子书</a> <a href="#" id="ta">复读机</a> <a href="#" id="ta">录音笔 </a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>电子教育<![endif]-->
                      <div class="navlist icon07">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span><img src="${ctx}/Images/images/m1.jpg" /></span><a href="#">电子教育</a></div>
                            <div id="t_text02"><a href="#" id="ta">空调</a> <a href="#" id="ta">冰箱</a> <a href="#" id="ta">洗衣机</a> <a href="#" id="ta">电视机</a> <a href="#" id="ta">空调</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>五金电器<![endif]-->
                      <div class="navlist icon08">
                        <h3>
                          <div id="t_text" >
                            <div id="t_text01"><span><img src="${ctx}/Images/images/m1.jpg" /></span><a href="#">五金电器</a></div>
                            <div id="t_text02"><a href="#" id="ta">空调</a> <a href="#" id="ta">冰箱</a> <a href="#" id="ta">洗衣机</a> <a href="#" id="ta">电视机</a> <a href="#" id="ta">空调</a></div>
                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                        </div>
                      </div>
                      <!--[if !IE]>汽车用品<![endif]-->
                      <div class="navlist icon09">
                        <h3 class="ys">
                          <div id="t_text" >
                            <div id="t_text01"><span><img src="${ctx}/Images/images/m1.jpg" /></span><a href="#">汽车用品</a></div>
                            <div id="t_text02"><a href="#" id="ta" >空调</a> <a href="#" id="ta">冰箱</a> <a href="#" id="ta">洗衣机</a> <a href="#" id="ta">电视机</a> <a href="#" id="ta">空调</a></div>

                          </div>
                        </h3>
                        <div class="navmore">
                          <div class="iframeyaer1">
                            <div class="tv">
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                              <div class="tv01"><span>电视</span><a href="#">液晶电视</a> <a href="#">LED电视</a> <a href="#">3D电视</a> <a href="#">等离子电视</a></div>
                            </div>
                            <div class="tv1">
                              <div class="tv101"> <span>热门品牌</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                              <div class="tv102"> <span>促销活动</span>
                                <ul>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                  <li><a href="#">TCL</a></li>
                                </ul>
                              </div>
                            </div>
                          </div>
                          <!--[if !IE]>解决在IE6下拉菜单挡住弹出层<![endif]-->
                          <iframe frameborder="0" class="iframeyaer"></iframe>
                   </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div> 
                <!--[if !IE]>点击全部商品出现的弹出层结束<![endif]-->
            </div>
          </div>
        
        </div>
        <div id="nav1">
          <ul>
            <li><a href="${ctx }/index.do">首页</a></li>
            <li><a href="${ctx }/miaosha.do">秒杀</a></li>
            <li><a href="${ctx }/qianggou.do">抢购</a></li>
            <li><a href="${ctx }/tuangou.do">团购</a></li>
            <li><a href="${ctx }/brand.do">品牌馆</a></li>
            <li><a href="${ctx }/newnews.do">资讯中心</a></li>
          </ul>
        </div>
        
      </div>        
    </div>
  </div>
<!--[if !IE]>进入收藏夹的弹出层<![endif]-->
<div id="fade" class="black_overlay"></div>
	<div id="MyDiv" class="Popuplogin" style="display: none;">
<div class="Popuplogin01">
<h1>云岗网上商城会员登录</h1>
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
<h2 style="display:none;"><a href="#">忘记密码</a></h2>
</div> 

</div>
</div>
<div class="Popuplogin0202">
 
<div class="Popuplogin0202_text2">
<h1>
<span>还不是云岗网上商城用户？ </span><br />
现在免费注册云岗网上商城会员，便能立即享受便宜又放心的<br />
购物乐趣! <samp><a href="${cx}zhuce.do">会员注册</a></samp></h1>
</div>
</div>
</div>
</div>
<!--[if !IE]>进入收藏夹的弹出层结束<![endif]-->
</body>
</html>
