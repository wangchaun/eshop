<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/information.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css" />
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/hyzx.js"></script>
<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/myinfor.js"></script>

<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/fornt_upload.js"></script>


<script type="text/javascript" src="${ctx }/scripts/front/customer/jquery.provincesCity.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/provincesdata.js"></script>

<script>
/*加载身份数据*/
function load(){ 
  $("#test").ProvinceCity();
}
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>

<body onload="load()">
<div class="box">
 <%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>麦芽网上商城<![endif]-->
<div class="content">
<div class="coupon">
 <div class="coupon_left">
        <div class="couponleft_title"><a href="${ctx }/customersManage.do">麦芽网上商城</a></div>
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

<input type="hidden" id="id" name="customer.id" value="${customer.id }"/>
	<div class="coupon_right">
	<div class="courht">
	<div class="courht_title">
	<span>个人基本信息</span>
	</div>
	<div class="person_content">
	<div class="person">
	<div class="person01">基本信息</div>
	<div class="person02">
	<h1>登录名：</h1>
	<h2>${customer.code }</h2>
	</div>
	<div class="person02">
	<h3>昵&nbsp;&nbsp;称：</h3>
	<h1><input name="" type="text" id="customerName"  class="person04input1" value="${customer.name }"/></h1>
	</div>
	<div class="person03">
	<h1>*</h1>
	<h2>性&nbsp;&nbsp;别：</h2>
	<h3><input name="customer.sex" type="radio" value="m" <c:if test="${customer.sex == 'm'}">checked="checked"</c:if> onclick="checkSex(this.value)"/></h3>
	<input type="hidden" id="sex" value="${customer.sex}" size="3"/>
	<h4>男性</h4>
	<h3><input name="customer.sex" type="radio" value="w" <c:if test="${customer.sex == 'w'}">checked="checked"</c:if> onclick="checkSex(this.value)"/></h3>
	<h4>女性</h4>
	<h3><input name="customer.sex" type="radio" value="b" <c:if test="${customer.sex == 'b'}">checked="checked"</c:if> onclick="checkSex(this.value)"/></h3>
	<h4>保密</h4>
	</div>
	<div class="person04">
	<h1>*</h1>
	<h2>邮&nbsp;&nbsp;箱：</h2>
	<h3><input name="customer.email" type="text" id="email"  class="person04input" value="${customer.email }"/></h3>
	<h4>
		<input name="" type="button"  class="person04btn" value="绑定" onclick="window.open('${ctx }/security.do')"/>
		<c:if test="${customer.isPinlessemail=='1'}">
			<h5><a href="${ctx }/mail.do">修改</a></h5>
		</c:if>
	</h4>
	</div>
	<div class="person04">
	<h1>*</h1>
	<h2>手&nbsp;&nbsp;机：</h2>
	<h6><input name="customer.mobile" id="mobile" type="text" class="person04input" value="${customer.mobile }"  onchange="common.checkIsMobile(this);checkmobile()" /></h6>
	<h4><input name="" type="button"  class="person04btn" value="绑定" onclick="window.open('${ctx }/security.do')"/></h4>
	<c:if test="${customer.isPinlessmobile=='1'}">
		<h5><a href="${ctx }/phone.do">修改</a></h5>
	</c:if>
	</div>
	
	<div class="person05">
      <h2>所在地：</h2>
   		<!-- 
   			<div id="selectTest0" style="font-family: verdana;font-size: 12px;height: 24px;line-height: 28px;overflow: hidden;padding: 0 5px;position: absolute; text-overflow: ellipsis;white-space: nowrap;">${customer.province }</div>
		    <select class="person05select" name="" id="option1" onchange="selectCity(this,'option2',0)">
		    	<option value=""></option>
		        <c:forEach items="${areaList}" var="area">
		            <option value="${area.id }">${area.name }</option>
		     	</c:forEach>
		    </select>
			    <div id="selectTest1" style="font-family: verdana;font-size: 12px;height: 24px;line-height: 28px;overflow: hidden;padding: 0 5px;position: absolute; text-overflow: ellipsis;white-space: nowrap;">${customer.city }</div>
			    <select class="person05select" name="" id="option2" onchange="selectCity(this,'option3',1)">
			</select>
			    <div id="selectTest2" style="font-family: verdana;font-size: 12px;height: 24px;line-height: 28px;overflow: hidden;padding: 0 5px;position: absolute; text-overflow: ellipsis;white-space: nowrap;">${customer.region }</div>
			    <select class="person05select" name="" id="option3" onchange="selectCity(this,'',2)">
		    </select>
   		 -->
   		    <div id="test"></div>
	        <h2>
	          <input type="hidden" name="" id="address1" type="text"  />
              <input type="hidden" name="" id="address2" type="text"  />
              <input type="hidden" name="" id="address3" type="text"  />  
	        </h2>
   </div>
	<div class="person06">
	<input name="customer.street" type="text" id="street" class="person06input" value="<c:if test='${customer.street != null}'>${customer.street}</c:if><c:if test='${customer.street == null }'>请输入详细地址</c:if>" onfocus="if(this.value=='请输入详细地址') {this.value='';}"/>
	</div>
	</div>
	<div class="person07">
	<div class="person0701">
	<h1>更多信息</h1>
	<h2>(填写更多资料,获得我们更贴心服务)</h2>
	</div>
	<div class="person0702">
	<h1>教育程度：</h1>
	<h2>
		<select name="customer.schooling" id="schooling" class="person05select">
			<option value=""></option>
			<option value="小学" <c:if test="${customer.schooling == '小学'}">selected="selected"</c:if>>小学</option>
			<option value="中学" <c:if test="${customer.schooling == '中学'}">selected="selected"</c:if>>中学</option>
			<option value="大学" <c:if test="${customer.schooling == '大学'}">selected="selected"</c:if>>大学</option>
			<option value="硕士" <c:if test="${customer.schooling == '硕士'}">selected="selected"</c:if>>硕士</option>
			<option value="博士" <c:if test="${customer.schooling == '博士'}">selected="selected"</c:if>>博士</option>
		</select>
	</h2>
	
	</div>
	<div class="person0702">
	<h1>月均收入：</h1>
	<h2>
		<select name="customer.salary" id="salary" class="person05select">
			<option value=""></option>
			<option value="无收入" <c:if test="${customer.salary == '无收入'}">selected="selected"</c:if>>无收入</option>
			<option value="2000元以下" <c:if test="${customer.salary == '2000元以下'}">selected="selected"</c:if>>2000元以下</option>
			<option value="2000-3499" <c:if test="${customer.salary == '2000-3499'}">selected="selected"</c:if>>2000-3499</option>
			<option value="3500-4999" <c:if test="${customer.salary == '3500-4999'}">selected="selected"</c:if>>3500-4999</option>
			<option value="5000-6999" <c:if test="${customer.salary == '5000-6999'}">selected="selected"</c:if>>5000-6999</option>
			<option value="7000-7999" <c:if test="${customer.salary == '7000-7999'}">selected="selected"</c:if>>7000-7999</option>
			<option value="8000以上" <c:if test="${customer.salary == '8000以上'}">selected="selected"</c:if>>8000以上</option>
		</select>
	</h2>
	</div>
	<div class="person0702">
	<h1> 婚姻情况：</h1>
	<h2>
		<select name="customer.maritalstatus" id="maritalstatus" class="person05select">
			<option value=""></option>
			<option value="未婚" <c:if test="${customer.maritalstatus == '未婚'}">selected="selected"</c:if>>未婚</option>
			<option value="已婚" <c:if test="${customer.maritalstatus == '已婚'}">selected="selected"</c:if>>已婚</option>
		</select>
	</h2>
	</div>
	<div class="person0703"><input name="" type="button"  class="person0703btn" onclick="saveSubmitForm()"/></div>
	</div>
	</div>
	<div class="person2">
	<h1><a href="#" onclick="xgtx()"><img src="${ctx}${customer.pic }" /></a></h1>
	<h2><a href="javascript:void(0);" onclick="xgtx()">修改头像</a></h2>
	</div>				  <!--[if !IE]>你可能感兴趣的产品结束<![endif]-->
	</div>
	</div><!--[if !IE]>右侧结束<![endif]-->

</div>
</div>
</div>
<!--[if !IE]>个人基本信息弹出层<![endif]-->
<div id="xgtx_td" class="xgtx_td" style="display: none;"></div>
<div class="personlayer_dk" style="display:none;" id="xgtx_td1">
<div class="personlayer" >
<div class="personlayer01">
<h1>上传头像</h1>
<h2 onclick="xgtx2()"><span><a href="#">关闭</a></span><samp><input name="" type="button"  class="Popuplogin01btn"/></samp></h2>
</div>
<div class="personlayer02">
<div class="personlayer0201">
    <a href="javascript:void(0);" onclick="upload.open(this,'Customer')">上传头像</a>
	<input type="hidden" name="picId" id="fileUploadId" value="${customer.picId}" /><%-- name必须为fileUploadId --%>
	<input type="hidden" name="pic" id="picPath" value="${customer.pic }" class="picPath" />
<div class="personlayer0202">
<div class="personlayer0202_left"><!-- xxx -->
<h1>仅支持JPG、GIF、PNG图片文件，且文件小于5M</h1>
<div id="picimg">&nbsp;</div>
<c:if test="${customer.pic != null && customer.pic != ''}">
	<img id="pic" border="0" src="${ctx}${customer.pic }" width="130px" height="130px"/>
		&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
</c:if>
</div>
<div class="personlayer0202_right">
<h1>请注意小尺寸的头像是否清晰</h1>
<div id="picimg2">&nbsp;</div>
</div>
</div>
<div class="personlayer0203">
<span><a href="javascript:void(0);"onclick="saveHeadImg()" class="personlayer020301">保存</a></span>
</div>
</div>
</div>
</div>
</div>
<!--[if !IE]>个人基本信息弹出层结束<![endif]-->
 <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
<div id="uploadDiv"><iframe frameborder="0" id="uploadFrame" name="uploadFrame" width="400px" height="200px"></iframe></div>
</body>
</html>

