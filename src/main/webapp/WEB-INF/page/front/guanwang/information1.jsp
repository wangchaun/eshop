<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx }/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/styles/front/style/information1_page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx }/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/information1.js"></script>
</head>
<body onload="onloading()">
<div class="box">
  <!--[if !IE]>头部<![endif]-->
  <div class="ctop">
    <div class="top_con">
     <div class="top_ctext">您好，欢迎您！<span id="top_ctextys">monica</span></div>
      <div class="top_ctext1">
        <input name="" type="button" class="subbmit" value="退出" />
      </div>
      <div class="top_ctext2"><span class="ys1"><a href="myshop.html" target="_parent">麦芽网上商城</a> |</span><span class="ys2"><img src="${ctx}/Images/images/a1.jpg" /></span><span class="ys3"><a href="shoppingCart.html" target="_parent">购物车0件</a> | <a href="${ctx}/infor.do?information.type=7" >帮助中心</a></span></div>
    </div>
    <!--[if !IE]>logo和搜索框<![endif]-->
    <div class="top_logo">
      <div class="topf">
        <div class="logo">
          <div class="logo01"><<a href="${ctx }/index.do"><img src="${ctx}/Images/images/logo2.jpg" /></a></div>
          <ul id="nav">
            <li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">深圳站</span></a>
              <ul  class="sub">
                <iframe frameborder="0" class="b1"></iframe>
                <li>
                  <div id="fy">
                   <c:forEach items="${areaList}" var="area1">
		                   	  <div id="fy1"><span>${area1.name}</span>
				                <c:forEach items="${area1.areaList}" var="area2">
				                  <a href="${ctx }/index.do?area.id=${area2.id }&area.name=${area2.name }">${area2.name}</a>
				                </c:forEach>
		                   	  </div>		
		                   </c:forEach>    
                    <div id="fy2"></div>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <!--[if !IE]>选号入网步骤<![endif]-->
        <div class="shopcart">
          <h1>1、选择号码</h1>
          <h2>2、选择套餐 </h2>
          <h3>3、填写用户信息</h3>
        </div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
  <form id="formID" name="formID">
  <div class="content">
    <!--[if !IE]>号码信息<![endif]-->
    <div class="lookproduct"><samp>签署入网协议</samp></div>
    <div class="fillin">
	<div class="fillin01">中国联通入网协议</div>
	<div class="fillin02">第一条选号及套餐相关资费内容(一)靓号及普号使用规则(请各分公司填写当地靓号规则)分类 尾号类型 首次预存金额(元) 必选套餐 预存话费返还时长第一类 AAAAA 7032 886元 3G基本套餐 12个月第二类 AAAA 4632 586及以上3G基本套餐ABCDE第三类 ABCD 3432 386及以上3G基本套餐AAA第四类 AABB 2712 286及以上3G基本套餐ABAB第五类 ABC 2232 226及以上3G基本套餐A普号 0 66及以上3G基本套餐 /<br />
(二)套餐资费标准<br />
月费 包国内语音拨打分钟数 包国内流量 包国内点对点短信条数 包国内点对点彩信条数 接听免费范围 套餐包外资费第一条选号及套餐相关资费内容一)靓号及普号使用规则(请各分公司填写当地靓号规则)
分类 尾号类型 首次预存金额(元) 必选套餐 预存话费返还时长第一类 AAAAA 7032 886元 3G基本套餐 12个月
第二类 AAAA 4632 586及以上3G基本套餐<br />
(二)套餐资费标准<br />
月费 包国内语音拨打分钟数 包国内流量 包国内点对点短信条数 包国内点对点彩信条数 接听免费范围 套餐包外资费第一条选号及套餐相关资费内容一)靓号及普号使用规则(请各分公司填写当地靓号规则)
分类 尾号类型 首次预存金额(元) 必选套餐 预存话费返还时长第一类 AAAAA 7032 886元 3G基本套餐 12个月
第二类 AAAA 4632 586及以上3G基本套餐
</div>
	</div>
     <div class="fillin1">
	 <h1><input name="" type="checkbox" value="" /></h1>
	 <h2>我已阅读并同意加入《入网协议》</h2>
	 </div>
  <div class="lookproduct"><samp>填写入网资料</samp></div>   
   <div class="fillin2">
   <div class="fillin201">
   <h1><span>*</span>机主姓名：</h1>
   <h2><input name="customer.name" type="text"  class="pickinput" value="${customer.name}"/></h2>
   </div>
   <div class="fillin201">
   <h1><span>*</span>身份证号：</h1>
   <h2><input name="customer.idCard" type="text"  class="pickinput1"/></h2>
   <h3>填写的身份证信息会传送给商家用以开通业务，请正确填写</h3>
   </div>
   <div class="fillin201">
   <h1><span>*</span>证件有效期：</h1>
   <h2>
       <select name="year" id="year" class="pickselect"  onchange="YearMonth(this.value)">
       </select></h2>
   <h2>
       <select name="month" id="month" class="pickselect" onchange="MonthDay(this.value)">
       </select></h2>
   <h2> 
       <select name="day" id="day" class="pickselect">
       </select>
    </h2>
   </div>
   <div class="fillin201">
   <h1><span>*</span>证件地址：</h1>
   <h2>
          <select name="Province" class="pickselect1" onchange="SetCity('City',this.value);AddOption('City','城市','',0,0);" id="Province">
          		<option>请选择省份</option>
          </select></h2>
   <h2>
          <select name="City" id="City" onchange="SetSection('Province', 'Section', this.value);AddOption('Section','地区','',0,0);" class="pickselect1">
          		<option>请选择市</option>
          </select></h2>
   <h2>
   		  <select name="Section" id="Section" class="pickselect1">
   		  		<option>请选择区</option>
   		  </select></h2>
   </div>
   <div class="fillin202"><input name="" type="text"  class="pickinput2"/></div>
   <div class="fillin201">
   <h1><span>*</span>入网当月资费处理方式：</h1>
   <h2><select name="" class="pickselect2"><option>当月开通</option></select></h2>
   </div>
   <div class="fillin203"><input name="" type="button" class="pickbtn1" onclick="window.open('confirmOrder.html')"/></div>
   </div> 
  </div>
  </form>
  <!--[if !IE]>中间完成<![endif]-->
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%>
</div>
</body>
</html>
