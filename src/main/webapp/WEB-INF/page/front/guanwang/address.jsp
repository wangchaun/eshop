<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云岗网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/address_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />

<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/hyzx.js"></script>

<script type="text/javascript" src="${ctx }/scripts/front/customer/jquery.provincesCity.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/provincesdata.js"></script>
<script type="text/javascript">
//$(document).ready(function(){  
 // $("#test").ProvinceCity();
   //$("#test1").ProvinceCity();
//});


function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
function load(){$("#test").ProvinceCity();$("#test1").ProvinceCity();}
</script>
</head>
<body onload="load()">
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>云岗网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">云岗网上商城</a></div>
        <!--[if !IE]>订单中心<![endif]-->
        <script language=javascript id=clientEventHandlersJS>
<!--
var number=0;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = '${ctx }/Images/images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    var treePic = document.getElementById('pic' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        treePic.src = '${ctx }/Images/images/bit07.gif';
        lbmc.style.display = '';
    }
    else {
        treePic.src = '${ctx }/Images/images/bit08.gif';
        lbmc.style.display = 'none';
    }
}
//-->
      </script>
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(1)" href="javascript:void(null)" ><span>订单中心</span><samp><IMG id="pic1" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM1>
            <ul>
<li><a href="${ctx }/orderManage.do">我的订单<span>(<samp>${total }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=0">待付款订单<span>(<samp>${payment }</samp>)</span></a></li>
<li><a href="${ctx }/paymentOrder.do?saleOrder.iscancel=1">已取消订单<span>(<samp>${cancelOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=1">已发货商品<span>(<samp>${deliveryOrder }</samp>)</span></a></li>
<li><a href="${ctx }/shippedGoods.do?saleOrder.deliveryState=0">未发货商品<span>(<samp>${deliveryOrder2 }</samp>)</span></a></li>
<li id="bor"><a href="${ctx }/pingjiaTwo.do" >待评价商品<span>(<samp>${commentOrder}</samp>)</span></a></li>
</ul>
          </div>
        </div>
		 <!--[if !IE]>交易中心<![endif]-->
         <c:if test="${customer.type == '1'}">
         	 <div class="couponleft_text">
	          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(2)" href="javascript:void(null)" ><span>销售中心</span><samp><IMG id="pic2" 
	                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
	                 ></samp></A></div>
	          <div class="couponleft_text02" id=LM2 >
	            <ul>
	              <li><a href="sales.html">销售/收入</a></li>
	              <li id="bor"><a href="salesAnalysis.html" >销售/收入分析</a></li>
	            </ul>
	          </div>
	        </div>
         </c:if>
        <!--[if !IE]>交易中心<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(3)" href="javascript:void(null)" ><span>交易中心</span><samp><IMG id="pic3" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM3 >
            <ul>
              <li><a href="${ctx }/myFavorite.do">我的收藏<span>(<samp>${favolist }</samp>)</span></a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>客户服务<![endif]-->
        <div class="couponleft_text">
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(4)" href="javascript:void(null)" ><span>客户服务</span><samp><IMG id="pic4" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM4>
            <ul>
              <li><a href="${ctx }/tuihuan.do">退货</a></li>
              <li><a href="${ctx }/myMessage.do">我的咨询</a></li>
              <li id="bor"><a href="${ctx }/myComment.do">我的评价</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>个人中心<![endif]-->
        <div class="couponleft_text" >
          <div class="couponleft_text01"><A onclick="javascript:ShowFLT(5)" href="javascript:void(null)" ><span>个人中心</span><samp><IMG id="pic5" 
                  height=14 src="${ctx }/Images/images/bit07.gif" width=14
                 ></samp></A></div>
          <div class="couponleft_text02" id=LM5>
            <ul>
              <li><a href="${ctx }/myinfor.do">个人信息</a></li>
              <li><a href="${ctx }/security.do" id="visited">安全设置</a></li>
              <li id="bor"><a href="${ctx }/myaddress.do" >地址管理</a></li>
            </ul>
          </div>
        </div>
        <!--[if !IE]>end<![endif]-->
      </div>  
<!--[if !IE]>右侧<![endif]-->
      <div class="coupon_right">
        <div class="courht">
          <div class="courht_title"> <span>地址管理</span> </div>
          <div class="confirm_text">新增地址</div>
          
          <div class="confirm_text1">
            <h1><span>*</span>收件人姓名：</h1>
            <h2>
              <input name="customerAddress.name" id="name" type="text"  class="confirminput" />
            </h2>
          </div>
          <div class="confirm_text1">
           <h3><span>*</span>省市区：</h3>
           <!--
            <div class="sb w_50">
              <div class="b" id="selectTest0">请选择</div>
    			<select name="RegAndLoginInPublishPage1:dpSex" id="option1" onchange="selectCity(this,'option2',0)">
    				<option value=''>请选择</option>
           			<c:forEach items="${areaList}" var="area">
            			<option value="${area.id }">${area.name }</option>
     				</c:forEach>
    			</select>
    		</div>
    	<h2><span>-</span></h2>
		    <div class="sb w_50">
			     <div class="b" id="selectTest1">请选择</div>
			    	<select name="RegAndLoginInPublishPage1:dpSex" id="option2" onchange="selectCity(this,'option3',1)"></select>
		    </div>
		<h2><span>-</span></h2>
		  <div class="sb w_50">
		     <div class="b" id="selectTest2">请选择</div>
		     <select name="RegAndLoginInPublishPage1:dpSex" id="option3" onchange="selectCity(this,'',2)"></select>
         </div>
             -->
            <div id="test"></div>
	        <h2>
	          <input type="hidden" name="" id="address1" type="text"  />
              <input type="hidden" name="" id="address2" type="text"  />
              <input type="hidden" name="" id="address3" type="text"  />  
	        </h2>
          </div>
          <div class="confirm_text1">
            <h1></h1>
            <h2>
              <input name="customerAddress.address" id="street" type="text"  class="confirminput1" /><span>详细街道地址</span>
            </h2>
          </div>
          <div class="confirm_text1">
            <h1><span>*</span>邮政编码：</h1>
            <h2>
              <input name="customerAddress.zipCode" id="zipCode" type="text"  class="confirminput"/>
            </h2>
          </div>
          <div class="confirm_text1">
            <h1><span>*</span>手机号码：</h1>
            <h2>
              <input name="customerAddress.mobile" id="mobile" type="text"  class="confirminput"/>
            </h2>
          </div>
          <div class="confirm_text1">
            <h4>
              <!--[if !IE]>收获信息确认按钮<![endif]-->
              <input name="" type="button"  class="confirmbtn" onclick="addAddress()"/>
            </h4>
          </div>
          <!--[if !IE]>以保存的有效地址<![endif]-->
		  <div class="confirm_text2">
		  <h1>已保存的有效地址</h1>
		  <h2>（最多保存有10个有效地址）</h2>
		  </div>
		  <div class="confirm_text3">
		  <div class="table">
<table width="917" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="27" align="left" valign="top"></td>
    <td width="150" height="32" align="left" valign="middle">收货人</td>
    <td width="15" height="32" align="center" valign="middle"></td>
    <td width="160" align="left" valign="middle">联系电话</td>
    <td width="271" align="left" valign="middle">详细地址</td>
    <td width="170" align="center" valign="middle">邮编</td>
	 <td width="124" align="center" valign="middle">操作</td>
  </tr>
</table>
</div>
<div class="table1">
<table width="917" border="0" cellspacing="0" cellpadding="0" align="center">
   <c:forEach items="${addressList}" var="address">
	  <tr>
	     <td width="10" align="left" valign="top"></td>
	    <td width="167" align="left" valign="top" class="ju1">
		<div class="moren">
		<div class="moren01"><span>${address.name }</span></div>
		<div class="moren02">
			<c:if test="${address.isDefault== '0' }"><h1><img src="${ctx }/Images/images/wan5.jpg" /></h1><h2>默认地址</h2></c:if>
		</div>
		</div>
		</td>
	  <td width="15"  align="center" valign="top"><br /><br /></td>
	    <td width="160" align="left" valign="top" class="ju">${address.mobile }</td>
	    <td width="271" align="left" valign="top" class="ju">${address.address }${address.street }</td>
	    <td width="170" align="center" valign="top" class="ju">${address.zipCode }</td>
		 <td width="124" align="center" valign="top" class="ju">
		 <div class="ys3"><a href="javascript:void(0);" onclick="add_personlayer('${address.id }')">修改</a><span class="middlesev">|</span><a href="javascript:void(0);" onclick="delAddress('${address.id}')">删除</a>
		 	<c:if test="${address.isDefault== '1' }"><br /><a href="javascript:void(0);" onclick="updateAddress('${address.id}')">设为默认地址</a></c:if>
		 </div>
		 </td>
	  </tr>
    </c:forEach>
</table>
</div>  
		  </div>
        </div>
      </div>
      <!--[if !IE]>右侧结束<![endif]-->
    </div>
  </div>
  <!--[if !IE]>待付款订单完成<![endif]-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
<!--[if !IE]>地址弹出层<![endif]-->
<div id="add_personlayer2" style="display: none;"></div>
<div class="personlayer_dk" style="display:none;" id="add_personlayer">
<div class="personlayer" >
<div class="personlayer01">
<h1>修改收货地址</h1>
<h2 onclick="personlayer1()"><span><a href="javascript:void(0);">关闭</a></span><samp><input name="" type="button"  class="Popuplogin01btn"/></samp></h2>
</div>
<div class="courht">
                    <div class="confirm_text">新增地址</div>
          
          <div class="confirm_text1">
            <h1><span>*</span>收件人姓名：</h1>
            <h2>
              <input type="hidden" id="addressId" size="50"/>
              <input name="" id="names" type="text"  class="confirminput" />
            </h2>
          </div>
          <div class="confirm_text1">
            <h3><span>*</span>省市区：</h3>
            <!-- 
            	<div class="sb w_50">
	              <div class="b" id="selectTests0">请选择</div>
	    			<select name="RegAndLoginInPublishPage1:dpSex" id="options1" onchange="selectCity2(this,'options2',0)">
	    				<option value=''>请选择</option>
	           			<c:forEach items="${areaList}" var="area">
	            			<option value="${area.id }">${area.name }</option>
	     				</c:forEach>
	    			</select>
	    		</div>
	    	<h2><span>-</span></h2>
			    <div class="sb w_50">
				     <div class="b" id="selectTests1">请选择</div>
				    	<select name="RegAndLoginInPublishPage1:dpSex" id="options2" onchange="selectCity2(this,'options3',1)"></select>
			    </div>
			<h2><span>-</span></h2>
			  <div class="sb w_50">
			     <div class="b" id="selectTests2">请选择</div>
		     <select name="RegAndLoginInPublishPage1:dpSex" id="options3" onchange="selectCity2(this,'',2)"></select>
          </div>
             -->
            <div id="test1"></div>
            <h1></h1>
            <h2></h2>
          </div>
          <div class="confirm_text1">
            <h1></h1>
            <h2>
              <input name="" id="streets" type="text"  class="confirminput1" /><span>详细街道地址</span>
            </h2>
          </div>
          <div class="confirm_text1">
            <h1><span>*</span>邮政编码：</h1>
            <h2>
              <input name="" id="zipCodes" type="text"  class="confirminput"/>
            </h2>
          </div>
          <div class="confirm_text1">
            <h1><span>*</span>手机号码：</h1>
            <h2>
              <input name="" id="mobiles" type="text"  class="confirminput"/>
            </h2>
          </div>
          <div class="confirm_text1">
            <h4>
              <!--[if !IE]>收获信息确认按钮<![endif]-->
              <input name="" type="button"  class="confirmbtn" onclick="updatemyAddress()"/>
            </h4>
          </div>
          
          
          
 
        </div>
</div></div>
<!--[if !IE]>地址弹出结束<![endif]-->

</body>
</html>
