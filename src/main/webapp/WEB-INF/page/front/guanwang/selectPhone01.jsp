<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>

<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/shoppingCart_page1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_3.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/selectPhone_files/base.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/selectPhone_files/mobile-trade.css"/>
<script type="text/javascript" src="${ctx}/styles/front/selectPhone_files/info.js"></script>
<script type="text/javascript" src="${ctx}/styles/front/selectPhone_files/base-v1.js"></script>

<script type="text/javascript" src="${ctx}/styles/front/selectPhone_files/base-2011.js"></script>
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/validation_landing.js" ></script>
<script type="text/javascript" src="${ctx }/scripts/front/customer/header.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/cn.global.js"></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
<script type="text/javascript">

$("#selectedSection").change(function () {
  $("select option:selected" ).each(function() {
      alert("hehe");
});
}).change();
 
var PhoueNumBase = {
	InitPhoneNumber : function() {
		register();
		queryPhoneNumber(0);
	}
};

setTimeout("PhoueNumBase.InitPhoneNumber()", 50);	

function register(){
	//为号码文本框注册键盘事件
	$('#cardKeySearch').keydown(function(e){
		if(e.keyCode==13){
			queryPhoneNumber(0);
		}
	}); 
}

//号码搜索
function queryPhoneNumber(){
    var wareId=$('#wareId').val();
    //号码特别提示隐藏
	$("#specialTipsForPhonuNumberHtml").html("");
	$("#step-1-loading").html("<div class='loading-style1'><b></b>加载中，请稍候...</div>");
	$("#step-1-loading").show();
	$("#step-1-0").hide();

	var phoneNumRuleId = $("#selectedPhonenumRule").val();
	if(phoneNumRuleId == null || phoneNumRuleId == undefined ){
		phoneNumRuleId = 0;
	}
	if(typeof String.prototype.trim !== 'function') {
        String.prototype.trim = function() {
            return this.replace(/^\s+|\s+$/g, '');
        }
    }
	var cardKeySearch = $("#cardKeySearch").val().trim();
	var phoneNumSection = $("#selectedSection").val();
	if(phoneNumSection == null || phoneNumSection == undefined ){
		phoneNumSection = 0;
	}
	
	if ((cardKeySearch != '') && (/^\d+$/.test(cardKeySearch) == false)) {
		alert("请输入数字进行自定义查询");
		return false;
	} else {
		$("#cardKeySearch").val(cardKeySearch);
	}
    
	jQuery.getJSON(
		 "phone.do", 
		{"ware.id": wareId,
		 "t": Math.random()},  
		function(data) {
			//检查是否被防刷拦截
			//if(!checkNotRefresh(data)){
				//return;
			//};
			//登录会话校验
			//sessionCheck(data,$("#indexUrl").val()); 
			if(data!=null){
		 
				buildPhoneNumber(data.rows);
			}else{
				$("#step-1-1-left").html("");
				$("#step-1-1-right").html("");
				$("#step-1-loading").html("<div class=\"grid\" style=\"text-align:center;color:red;\"><h3>系统繁忙，请稍后再试！</h3></div>");
				$("#step-1-loading").show();
				$("#step-1-0").hide();
			}
        }
	);
}

//搜索全部号码
function queryAllPhoneNumber(){
	//重置搜索条件
	$("#selectedPhonenumRule").val(0);
	$("#selectedSection").val(0);
	$("#cardKeySearch").val("");
	
	//号码特别提示隐藏
	$("#specialTipsForPhonuNumberHtml").html("");
	
	$("#step-1-loading").html("<div class='loading-style1'><b></b>加载中，请稍候...</div>");
	$("#step-1-loading").show();
	$("#step-1-0").hide();
	
	jQuery.getJSON(
		"phone.do", 
		{"ware.id": wareId,  
		"t": Math.random()},  
		function(data, textStatus) {
			//检查是否被防刷拦截
			if(!checkNotRefresh(data)){
				return;
			};
			if(data.responseState == 1){
				buildPhoneNumber(data.phoneNumList,data.pageModel,data.nencList,data.specialTips);
			}else{
			
				$("#step-1-1-left").html("");
				$("#step-1-1-right").html("");
				$("#step-1-loading").html("<div class=\"grid\" style=\"text-align:center;color:red;\"><h3>系统繁忙，请稍后再试！</h3></div>");
				$("#step-1-loading").show();
				$("#step-1-0").hide();
			}
        }
	);
}

//构造号码列表//
function buildPhoneNumber(phoneNumList){
    
	var cardKeySearch = $("#cardKeySearch").val().trim();
	 
	var leftPhonenum = [];
	var rightPhonenum = [];
	
	if(null != phoneNumList && phoneNumList.length >=1){
		//构造号码上面的特别提示
		//if(null != tips){
			//$("#specialTipsForPhonuNumberHtml").html("【优惠活动】" + tips);
		//}
		jQuery.each(phoneNumList, function(index, item) {
			var wprice = 0;
		    
			if(item.price != null && item.price >= 0){
				wprice = item.price;
			}
		    
			if(index == 0){
				leftPhonenum[leftPhonenum.length] = "<tr class=\"selected hover\">";
				leftPhonenum[leftPhonenum.length] = "<td><input type=\"radio\" name=\"phoneRadio\" checked=\"checked\" cardWid='"+item.id+"' wPrice='"+item.price+"' fee='"+item.phoneFee+"' value='"+item.telphone+"' /></td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"phone-num\">"+item.telphone.replace(cardKeySearch, "<font color='red'>"+ cardKeySearch +"</font>")+"</td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"fc-r\">"+wprice+".00元</td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"fc-fare\">"+item.phoneFee+"元</td>";
				leftPhonenum[leftPhonenum.length] = "</tr>";
				//隐藏域赋值
				$("#cardKey").val(item.telphone);
				$("#cardWid").val(item.id);
				$("#selectedPrice").html(wprice+"");
				$("#step-1-price").html("￥"+wprice+"元");
				$("#selectedFee").html(item.phoneFee+"");
				$("#selectedPhonenum").html(item.telphone);

				//填写用户信息模块-合约信息-号码
				$("#step-3-info-phonenum").html(item.telphone);
				
			}else if(index % 2 == 0){
				leftPhonenum[leftPhonenum.length] = "<tr>";
				leftPhonenum[leftPhonenum.length] = "<td><input type=\"radio\" name=\"phoneRadio\" cardWid='"+item.id+"' wPrice='"+item.price+"' fee='"+item.phoneFee+"' value='"+item.telphone+"' /></td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"phone-num\">"+item.telphone.replace(cardKeySearch, "<font color='red'>"+ cardKeySearch +"</font>")+"</td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"fc-r\">"+((item.price == null || item.price <= 0) ? 0 : item.price)+".00元</td>";
				leftPhonenum[leftPhonenum.length] = "<td class=\"fc-fare\">"+item.phoneFee+"元</td>";
				leftPhonenum[leftPhonenum.length] = "</tr>";
			}else{
				rightPhonenum[rightPhonenum.length] = "<tr>";
				rightPhonenum[rightPhonenum.length] = "<td><input type=\"radio\" name=\"phoneRadio\" cardWid='"+item.id+"' wPrice='"+item.price+"' fee='"+item.phoneFee+"' value='"+item.telphone+"' /></td>";
				rightPhonenum[rightPhonenum.length] = "<td class=\"phone-num\">"+item.telphone.replace(cardKeySearch, "<font color='red'>"+ cardKeySearch +"</font>")+"</td>";
				rightPhonenum[rightPhonenum.length] = "<td class=\"fc-r\">"+((item.price == null || item.wPrice <= 0) ? 0 : item.price)+".00元</td>";
				rightPhonenum[rightPhonenum.length] = "<td class=\"fc-fare\">"+item.phoneFee+"元</td>";
				rightPhonenum[rightPhonenum.length] = "</tr>";
			}
		});
		/** 
		if($("#step-1-page").length>0){
			var pageHtml = "";
			if (pageModel.totalPage > 1){
				var pagePos = 2;
				if(pageModel.previousPageAvailable) {
					pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('"+pageModel.previousPage+"');\");\">上一页</a>";
					pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('1');\">1</a>";
				}
				if(pageModel.index>pagePos+2) {
					pageHtml = pageHtml + "<span style=\"margin-left: 5px;padding: 0 10px; text-align: center;font-weight: bold;\">...</span>";
				}
				for(var i = pagePos;i>=1;i--) {
	    			if(pageModel.index - i > 1){
	    				var pageIndex= pageModel.index - i;
	    				pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('"+pageIndex+"');\">"+pageIndex+"</a>";
	    			}
	    		}
				pageHtml = pageHtml +"<a href=\"javascript:void(0);\" class=\"curr\">"+pageModel.index+"</a>";
	    		for(var i=1;i<=pagePos;i++) {
	    			if(pageModel.totalPage - pageModel.index - i > 0){
	    				var pageIndex= pageModel.index + i;
	    				pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('"+pageIndex+"');\">"+pageIndex+"</a>";
	    			}
	    		}
	    		if(pageModel.totalPage - pageModel.index > pagePos+1) {
	    			pageHtml = pageHtml + "<span style=\"margin-left: 5px;padding: 0 10px; text-align: center;font-weight: bold;\">...</span>";
	    		}
	    		if(pageModel.nextPageAvailable) {
	    			pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('"+pageModel.totalPage+"');\">"+pageModel.totalPage+"</a>";
	    			pageHtml = pageHtml +"<a href=\"javascript:void(0);\" onclick=\"queryPhoneNumber('"+pageModel.nextPage+"');\">下一页</a>";
	    		}
	
			}
			$("#step-1-page").html(pageHtml);
		}**/
		$("#step-1-1-left").html(leftPhonenum.join(""));
		$("#step-1-1-right").html(rightPhonenum.join(""));
		$("#step-1-loading").hide();
		$("#step-1-0").show();
		
		//查询当月资费处理方式
		//queryCurrMonthFee();
		
	}else{
		$("#step-1-1-left").html("");
		$("#step-1-1-right").html("");
		$("#step-1-loading").html("<div class=\"grid\" style=\"text-align:center;\"><img src=\"http://misc.360buyimg.com/contract/img/tips1.jpg\"/></div>");
		$("#step-1-loading").show();
		$("#step-1-0").hide();
	}
    
	//注册号码表格事件
	initPhonenumAction();
	
}

//注册号码表格点击事件
function initPhonenumAction(){
    
	$("#step-1-0 table tbody tr").click(function(){
		$("#step-1-0 table td :radio").attr("checked",false);
		$("#step-1-0 table tr").removeClass("selected");
		$(this).addClass("selected");
		$(this).find(":radio").attr("checked","checked");
		setPhonenumInfo();
		//查询当月资费处理方式
		//queryCurrMonthFee();
	});
}

//设置号码相关临时值
function setPhonenumInfo(){
	var phonenum = $('input[name=phoneRadio]:checked');
	$("#selectedPhonenum").html(phonenum.val());
	var wprice = parseFloat(phonenum.attr("wPrice"));
	if(wprice == null || wprice <= 0){
		wprice = 0;
	}
	$("#selectedPrice").html(wprice+"");
	$("#step-1-price").html("￥"+wprice+"元");
	$("#step-1-price-num").val(wprice);
	$("#selectedFee").html(phonenum.attr("fee"));
	//隐藏域
	$("#cardKey").val(phonenum.val());
	$("#cardWid").val(phonenum.attr("cardWid"));
	//$("#penc").val(phonenum.attr("enc"));

	//填写用户信息模块-合约信息-号码
	$("#step-3-info-phonenum").html(phonenum.val());
}

//提交或者重选号码
function submitPhoneNumber(type){
    
	if("PhoneNumber" == type){
		//号码预占
		phoneNumberCampOn();
	}else if("Re-PhoneNumber" == type){
	    window.location.reload();
		resetPhoneNumber();
		closeTreatyPlan();
		resetOwnerInfo();
	}
}

function resetPhoneNumber(){
	$("#step-1-choose-num").show();
	$("#step-1-info-newnum").hide();
	$("#step-1-rechoose").hide();
	$("#step-1").removeClass("fd-forbidden");
	$("#step-1").addClass("fd-curr");
}

//号码预占
function phoneNumberCampOn(){
	var cardKey = $("#cardKey").val();
	var fid = $("#fid").val();
	var enc = $("#fenc").val();
	var url=ctx+'/getStateByPhone.do?phone.telphone='+cardKey;
	    $.ajax({
	            url : url,
				async: false,
				cache: false,
				type : 'POST', 
				success : function(returnData){
				  
				 if(returnData=='false'){
				   alert("该号码已被其他用户购买，请重新选择！");
				   queryPhoneNumber(0);
				   return false;
			    }else{
				$("#step-1-choose-num").hide();
        		$("#step-1-info-newnum").show();
        		$("#step-1-rechoose").show();
        		$("#step-1").removeClass("fd-curr");
        		$("#step-2").removeClass("fd-forbidden");
        		$("#step-2").addClass("fd-curr");
        		$("#step-2").show();
				$("#specialTipsForTreatyHtml").show();
        		queryTreaty();//查询套餐
			      }},
				error : function(){
					alert('系统错误!');
				}
	}); 
}

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
						<div id="menu-popup">
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
		      <span class="ys2"><img src="${ctx }/Images/images/a1.jpg" /></span>
		      <span class="ys3"><a href="${ctx }/ShoppingCar.do" target="_parent">购物车<c:if test="${shoppingCarSize==null}">0</c:if>${shoppingCarSize }件</a>
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
		 <!--[if !IE]>选择号码步骤<![endif]-->
		<div class="shopcart"><h1>1.选择套餐和号码</h1><h2>2、填写核对订单信息  </h2><h3>3、成功提交订单</h3></div>
      </div>
    </div>
  </div>
  <!--[if !IE]>中间<![endif]-->
   <div id="container">
	<!-- 加载商城logo和步骤显示条 --><div id="content">
		<!-- 加载小购物车 -->
	  <div class="package-title mb10">您选择了<span>“北京电信”</span>的合约计划</div>
<div class="fieldset mb10">
	<div class="fs-tit">
		<div class="fl"><span class="fz-14">已经选择商品</span></div>
		<div class="fr">号码+话费金额：<span class="fc-r" id="jd-price-sum">￥${good.price }</span></div>
	</div>
	<div class="fs-con">
		<dl class="p-list">
			<dt>
			    <img src="${ctx }${good.pic }" border="0" height="50" width="50" />
			</dt>
			<dd class="p-l-only"> 
			     <a href="${ctx }/cpxq.do?good.id=${good.id}" target="_blank" class="a-link">
					 ${good.name }
				 </a>
              	<span>价：<strong id="jd-price">￥${good.price }</strong></span>              	
            </dd>
       </dl>
	</div>
</div>		
    <!-- 加载号码模块 -->
	<div class="fieldset fd-curr mb10" id="step-1">
	<div class="fd-index">1</div>
	<div class="fs-n-tit" id="step-1-title-newnum">
		<div class="fl"><span class="fs-t mr10">选择号码</span><a class="a-link" href="javascript:void(0);" id="step-1-rechoose" onclick="return submitPhoneNumber('Re-PhoneNumber');">[重选]</a></div>
	</div>
	<div class="fs-con" id="step-1-all">
		<div class="cho-num" id="step-1-choose-num">
			<div class="cho-n-ser" id="step-1-condition">
				<label for="" style="display:none;">选择：</label>
				<select class="sel-16 mr10" id="selectedSection" onchange="queryPhoneNumber(0);"style="display:none;">
					<option selected="selected" value="0">选择号段</option>
                    <option value="176">176</option>
                    <option value="185">185</option>
			    </select>
			    <input class="txt-17 mr10" id="cardKeySearch" type="text" style="display:none;" />				
				<a href="javascript:void(0);" style="display:none;" class="btn-s-b" onclick="queryPhoneNumber(0);"><span>搜索</span></a>
				<!-- <a href="javascript:void(0);" class="btn-s-b" onclick="queryAllPhoneNumber();"><span>全部号码</span></a> -->
				<a href="javascript:void(0);" class="btn-s-b" onclick="queryPhoneNumber(0);"><span>换一批号码</span></a>
		    </div>
		    <div class="fs-con" id="step-1-loading" style="text-align: center; display: none;"></div>
			<!-- <p class="txt-activity" id="specialTipsForPhonuNumberHtml"></p> -->;
			<div class="t-grid" id="step-1-0" style="display: block;">
				<div class="t-g-l">
					<table>
						<colgroup>
							<col width="50"/>
							<col width="120"/>
							<col width="160"/>
							<col/>
						</colgroup>
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>号码</th>
								<th>商城价</th>
								<th>预存话费</th>
							</tr>
						</thead>
						<tbody id="step-1-1-left"></tbody>
					</table>
            </div>
				<div class="t-g-r">
					<table>
						<colgroup>
							<col width="50"/>
							<col width="120"/>
							<col width="160"/>
							<col/>
						</colgroup>
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>号码</th>
								<th>商城价</th>
								<th>预存话费</th>
							</tr>
						</thead>
						<tbody id="step-1-1-right"></tbody>
					</table>
                </div>
			    <div style="clear:both"></div>

<!-- 隐藏域 -->
<input id="fid" name="fid" value="" type="hidden"/>
<input id="fenc" name="fenc" value="" type="hidden"/>
<input id="feeModeText" name="feeModeText" value="" type="hidden"/>

<script type="text/javascript">
//查询当月资费处理方式
function queryCurrMonthFee(){
	jQuery.getJSON(
		"queryPnCurrMonthFee.action", 
		{"cardWid": "1084862", "serviceOperatorId": "2", "bType": "0", 
		"provinceId": "1", "cityId": "1","ownerInfoFlag":"0","cardKey": $("#cardKey").val(),"enc": $("#penc").val(),
		"t": Math.random()},  
		function(data, textStatus) {
			//检查是否被防刷拦截
			//if(!checkNotRefresh(data)){
				//return;
			//};
			buildCurrMonthFee(data.currMonthFeeList,data.currMonthFeeEncList);
        }
	);
}

function buildCurrMonthFee(currMonthFeeList, currMonthFeeEncList){
	$("#step-1-currmonthfee").show();
	var currMonthFeeHtml = "";
	if(currMonthFeeList==null||currMonthFeeList.length==0){
		currMonthFeeHtml = currMonthFeeHtml + "<h1>对不起，您选择的地区暂无当月资费处理方式。</h1>";
		return;
	}else{
		if(currMonthFeeList.length==1 && currMonthFeeList[0].id==0){
			$("#fid").val(currMonthFeeList[0].id);
			$("#fenc").val(currMonthFeeEncList[0]);
			$("#feeModeText").val(currMonthFeeList[0].title);
			$("#step-1-currmonthfee").hide();
			$("#step-1-info-mf").hide();
		}else{
			jQuery.each(currMonthFeeList, function(index, item) {
				if(index == 0) {
					$("#fid").val(item.id);
					$("#fenc").val(currMonthFeeEncList[index]);
					$("#feeModeText").val(item.title);
					$("#selectedCMF").text(item.title);
					currMonthFeeHtml = currMonthFeeHtml +"<input type=\"radio\" checked='checked' name='feemodec' value=\""+item.id+"\" title='"+item.title+"' fenc='"+currMonthFeeEncList[index]+"'  onclick='chooseFeeMode(this);'/>";
				}else{
					currMonthFeeHtml = currMonthFeeHtml +"<input type=\"radio\"  name='feemodec' value=\""+item.id+"\" title='"+item.title+"' fenc='"+currMonthFeeEncList[index]+"'  onclick='chooseFeeMode(this);'/>";
				}
				currMonthFeeHtml = currMonthFeeHtml +"<strong class='curpoin' onclick='selectFeePrev(this)' >"+item.title+"：</strong>"+item.remark;
				currMonthFeeHtml = currMonthFeeHtml +"<br>";
			});
			$("#step-1-currmonthfee-info").html(currMonthFeeHtml);		
		}
	}
}

function selectFeePrev(obj) {
	$(obj).prev().attr("checked", "checked");
	chooseFeeMode($(obj).prev());
}

//选择套餐资费方式
function chooseFeeMode(obj){
	$("#fid").val($(obj).val());
	$("#fenc").val($(obj).attr("fenc"));
	$("#feeModeText").val($(obj).attr("title"));
	$("#selectedCMF").text($(obj).attr("title"));
}
</script>				
          <!-- currmonthfee end -->
                <div class="mb10">
					<a href="javascript:void(0);" class="btn-m-r" clstag="eve|keycount|treaty|XHRWPhoneNumber" onclick="return submitPhoneNumber('PhoneNumber');"><span>确认手机号码</span></a>
				</div>
			</div>
		</div>
		
		<div class="fk-grid hidden" id="step-1-info-newnum">
			<div class="fk-grid">
				<div class="n-cols">
					<div class="fk-h">选择号码：</div>
					<div class="fk-d">
					  <!--北京  <span class="spe">|</span>-->
						<b class="fc-o fz-14 mr10" id="selectedPhonenum"></b>（商城价：<span id="selectedPrice"></span>元，包括话费：<span id="selectedFee"></span>元）
						<span class="msg-attention">号码选定后只为您保留15分钟。请您15分钟内提交订单</span>
					</div>
					 
				</div>
			</div>
		</div><!-- 新号码选择号码结果显示界面结束 -->
		
	</div>
</div>

<!-- 隐藏域 -->
<input id="cardWid" name="cardWid" type="hidden"/>
<input id="bType" name="bType" value="0" type="hidden"/>
<input id="provinceId" name="provinceId" value="1" type="hidden"/>
<input id="cityId" name="cityId" value="1" type="hidden"/>
<input id="serviceOperatorId" name="serviceOperatorId" value="2" type="hidden"/>
<input id="ownerInfoFlag" name="ownerInfoFlag" value="0" type="hidden"/>
<input id="cardKey" name="cardKey"  type="hidden"/>
<input id="wareId" name="wareId" value="${ware.id}" type="hidden"/>

<!-- 加载号码模块 -->
<div class="fieldset fd-forbidden mb10" id="step-2">
	<div class="fd-index">2</div>
	<div class="fs-n-tit">
		<span class="fs-t mr10">选择套餐</span><a class="a-link" href="javascript:void(0);" id="re-step-2" onclick="return submitTreatyPlan('Re-TreatyPlan');">[重选]</a>
	</div>
	<div class="fs-con" id="step-2-loading" style="text-align:center;">
	</div>
	<div class="fs-con" id="step-2-0" style="display: none">
		<div class="fk-grid fk-g-2 mb15" id="step-2-1">
			<div class="fk-h">合约计划：</div>
			<div class="fk-d">
				北京 <span class="spe">|</span>中国电信<span class="spe">|</span>“选号入网”
			</div>
			<div class="fk-h" id="signMonthsTitle">合约期：</div>
			<div class="fk-d" id="signMonthsContent">
			    <span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="networkphone"></span>
				<div class="choose-type" id="signMonthsHtml"></div>
			</div>
			<div class="fk-h" >套餐类型：</div>
			<div class="fk-d" >
			     <span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="packagetypephone"></span>
			     <b id="selectSpecificationVal"></b>
				<div class="choose-type" id="packageTypeHtml"></div>
			</div>
		</div>
		<!-- 
		<p class="txt-activity" id="specialTipsForTreatyHtml" style="display:none;">
		【优惠活动】选择96元以上套餐，送4G本地流量，每月赠送1G，连续赠送4个月，开户当月有效。（惠通卡/4G不参加）
		</p>
		-->
		<div class="cho-package mb10" id="step-2-2">
				<div class="t-grid mb10" id="treatyPlanHtml">
					<table>
						<colgroup>
							<col width="40"/>
							<col width="100"/>
							<col width="300"/>
							<col/>
							<col/>
							<col width="200"/>
						</colgroup>
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>套餐月费</th>
								<th>返还话费规则</th>
								<th>通话时长(分钟)</th>
								<th>短信条数</th>
								<th>上网流量</th>
							</tr>
						</thead>
						<tbody id="step-2-taocao"></tbody>
					</table>
				</div>
				<div class="mb10">
					<a href="" class="get-more" id="get-more"><b>更多套餐↓</b></a>
				</div>
                <div id="saveGiveDivError" class="cho-f" style="display: none;text-align:center;color:red;"><h3>对不起，该业务暂时不能办理</h3></div>
				<div class="cho-f" style="display: none;" id="saveGiveDiv">
					<div class="cho-f-tit">
						<b>参加“存费送费”优惠活动</b>
					</div>
					<div class="cho-f-con">
						<div class="mb5" id="joinTypeHtml"></div>
						<table class="v-grid" id="sgplanTable">
							<colgroup>
								<col width="100"/>
								<col width="100"/>
								<col width="100"/>
								<col width="100"/>
								<col width="100"/>
							</colgroup>
							<thead>
								<tr>
									<th>合约期</th>
									<th>需存话费</th>
									<th>每月返回话费</th>
									<th>每月赠送话费</th>
									<th>赠送规则</th>
								</tr>
							</thead>
							<tbody id="sgplanCon"></tbody>
						</table>
					</div>
				</div>
				<div align="left"><span id="next_msg_treaty" style="display: none;">正在转向订单信息确认页面</span></div>
				<div>
					<a class="btn-m-r" href="javascript:void(0);" clstag="eve|keycount|treaty|XHRWTreaty" onclick="return submitTreatyPlan('TreatyPlan');" id="submitTreatyButton"><span>确认套餐</span></a>
				</div>
		</div>
		<!-- 确认套餐后显示套餐内容 -->
		<div class="fk-grid hidden" id="step-2-info">
			<div class="n-cols">
				<div class="cols-l">
					<div class="fk-h">合约计划：</div>
					<div class="fk-d">北京  <span class="spe">|</span>中国电信<span class="spe">|</span>“选号入网”</div>
					<div class="fk-h" id="selectedSignMonthsTitle">合约期：</div>
					<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="network"></span>
					<div class="fk-d" id="selectedSignMonths"></div>
				</div>
				<div class="cols-r">
					<div class="fk-h">套餐类型：</div>
					<div class="fk-d">
						<b class="fc-n" id="selectedPackageType"></b>
						<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="packagetype"></span>
						<b class="fc-n">—</b>
						<b class="fc-n"><span class="fc-r" id="selectedMonthPackageFeeRed"></span></b>（每月最低消费<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="selectedMonthPackageFeephone"></span>）
						<p>
							通话：<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="selectedCallphone"></span>
							<span class="spe">|</span>
							短信：<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="selectedMessagephone"></span>
							<span class="spe">|</span>
							上网流量：<span style="color:#FF5500;font-weight:bold; font-size: 14px;" id="selectedTrafficphone"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 套餐资费详情弹出框内容 -->
<div class="accept-dialog" style="display: none;">
	
	<div class="dialog-content" style="text-align: center;">
		<img src="selectPhone01_files/rBEhVFMqX0EIAAAAAAT_YsyeghIAAKaeAEwAAUABP96366.jpg"/>
	</div>
</div>

<!-- 隐藏域 -->
<input id="numPackageId" name="tid" value="15291" type="hidden"/>
<input id="tenc" name="tenc" value="9561D49E625C9F74" type="hidden"/>
<input id="signMonths" name="signMonths" value="12" type="hidden"/>
<input id="packageMonthFee" name="packageMonthFee" value="76" type="hidden"/>
<input id="packageDetailsImage" name="packageDetailsImage" value="http://img30.360buyimg.com/adam/g13/M08/1E/0E/rBEhVFMqX0EIAAAAAAT_YsyeghIAAKaeAEwAAUABP96366.jpg" type="hidden"/>
<input id="indexUrl" name="indexUrl" value="http://passport.jd.com/new/login.aspx?ReturnUrl=http%3a%2f%2feve.jd.com%2fphonenum.action%3fenc%3d0BBAE04700F0F3E5%26bType%3d0%26cityId%3d560%26provinceId%3d8%26cardWid%3d384306%26serviceOperatorId%3d2" type="hidden"/>

<input id="preStoreFeeId" name="preStoreFeeId" value="-1" type="hidden"/>
<input id="preStoreFeeWid" name="preStoreFeeWid" value="0" type="hidden"/>
<input id="networkphone" name="networkphone" value="${phonepackage.networkphone}" type="hidden"/>
<input id="packagetypephone" name="packagetypephone" value="${phonepackage.packagetypephone}" type="hidden"/>

<script type="text/javascript">
var total=0;
function queryTreaty(){
		
		jQuery.getJSON(
		"phonepackage.do", 
		{"wareId": $('#wareId').val(),"t": Math.random()}, 
		function(data) {
	//	step-2-taocao
	    var addtr;
	    total=data.rows.length;
		for(var i=0;i<data.rows.length;i++)
		{
			addtr="";
			addtr="<tr onclick=selectRow("+i+") id='onclick"+i+"'>";
			
			addtr+="<td>";
			addtr+="<input type='radio' id='radio"+i+"'/>";
			addtr+="</td>";
			
			addtr+="<td>";
			addtr+=data.rows[i].packagephone
			addtr+="</td>";
			
			addtr+="<td>";
			addtr+=data.rows[i].prepaid
			addtr+="</td>";
			
			addtr+="<td>";
			addtr+=data.rows[i].calltime
			addtr+="</td>";
			
			addtr+="<td>";
			addtr+=data.rows[i].pmessage
			addtr+="</td>";
			
			addtr+="<td>";
			addtr+=data.rows[i].countryflow
			addtr+="<input type='hidden' id='networkphone"+i+"' value='"+data.rows[i].networkphone+"'/>";
			addtr+="<input type='hidden' id='packagetypephone"+i+"' value='"+data.rows[i].packagetypephone+"'/>";
			addtr+="<input type='hidden' id='selectedCallphone"+i+"' value='"+data.rows[i].calltime+"'/>";
			addtr+="<input type='hidden' id='selectedMessagephone"+i+"' value='"+data.rows[i].pmessage+"'/>";
			addtr+="<input type='hidden' id='selectedTrafficphone"+i+"' value='"+data.rows[i].countryflow+"'/>";
			addtr+="<input type='hidden' id='selectedMonthPackageFeephone"+i+"' value='"+data.rows[i].packagephone+"'/>";
			addtr+="<input type='hidden' id='step-3-info-signMonths"+i+"' value='"+data.rows[i].networkphone+data.rows[i].packagetypephone+"'/>";
			addtr+="<input type='hidden' id='step-3-info-packageType"+i+"' value='"+data.rows[i].packagephone+data.rows[i].countryflow+"'/>";
			addtr+="<input type='hidden' id='step-3-info-packageType-exp"+i+"' value='"+data.rows[i].countryflow+"'/>";
			addtr+="<input type='hidden' id='step-3-info-monthPackageFee"+i+"' value='"+data.rows[i].packagetypephone+"'/>";
			addtr+="</td>";
			
			addtr+="</tr>";
			$('#step-2-taocao').append(addtr);
			
			
		}
		if(data.rows.length>0)selectRow(0);
		}
		);
	//注册“更多套餐”链接点击方法
	$("#get-more").toggle(function(){
		$("#treatyPlanHtml table tr:gt(4)").show();
		$(this).html("<b>收起↑</b>").addClass("get-more");
	},function(){
		$("#treatyPlanHtml table tr:gt(4)").hide();
		$(this).html("<b>更多套餐↓</b>").addClass("get-more");
	});	
	$("#step-2-0").show();
	$("#step-2-1").show();
	$("#step-2-2").show();
	ajaxSignMonth(0);
}
function selectRow(i)
{
	
	for(var j=0;j<total;j++)
	{
		$('#radio'+j).attr("checked",false);
	}
	$('#radio'+i).attr("checked",true);
	$('#networkphone').html($('#networkphone'+i).val());
	$('#network').html($('#networkphone'+i).val());
	$('#packagetype').html($('#packagetypephone'+i).val());
	$('#packagetypephone').html($('#packagetypephone'+i).val());
	$('#selectedCallphone').html($('#selectedCallphone'+i).val());
	$('#selectedMessagephone').html($('#selectedMessagephone'+i).val());
	$('#selectedTrafficphone').html($('#selectedTrafficphone'+i).val());
	$('#selectedMonthPackageFeephone').html($('#selectedMonthPackageFeephone'+i).val());
	$('#step-3-info-signMonths').html($('#step-3-info-signMonths'+i).val());
	$('#step-3-info-monthPackageFee').html($('step-3-info-monthPackageFee'+i).val());
	$('#step-3-info-packageType').html($('#step-3-info-packageType'+i).val());
	$('#step-3-info-packageType-exp').html($('selectedTrafficphone'+i).val());
	
	$('#step-3-info-signMonths').val($('#step-3-info-signMonths'+i).val());
	$('#step-3-info-packageType').val($('#step-3-info-packageType'+i).val());

}
//点击月份
function ajaxSignMonth(signMonths){

	var cardKey = $("#cardKey").val();
	var fid = $("#fid").val();
	var enc = $("#fenc").val();
	
	$("#signMonths").val(signMonths);

	
	
	jQuery.getJSON(
		"queryPhonenumTreaty.action", 
		{"cardWid":"1084862","serviceOperatorId": "2", "bType": "0","provinceId":"1","cityId":"1",
		 "ownerInfoFlag":"0","cardKey":cardKey,"fid":fid,"enc":enc,"t": Math.random() ,"signMonths":signMonths},
		 "phonepackage.do", 
		{"phonepackage.networkphone": networkphone,
		"phonepackage.packagetypephone": packagetypephone,
		"phonepackage.calltime": calltime,
		"phonepackage.pmessage": pmessage,
		 "t": Math.random()},  
		function(data, textStatus) {
			//检查是否被防刷拦截
			if(!checkNotRefresh(data)){
				return;
			};
			//登录会话校验
			sessionCheck(data,$("#indexUrl").val());
			
			//如果是重新选择号码后进来，则清空原先的套餐信息，否则不清空
        	if(signMonths == 0){
        		$("#signMonthsHtml").html("");
        		$("#packageTypeHtml").html("");
        		$("#treatyPlanHtml table tbody").html("");
        		$("#step-2-0").hide();
        		$("#step-2-info").hide();
        		$("#step-2-loading").show();
        	}
        	
        	if(signMonths > 0){
        		jQuery("#signMonthsHtml .selected").removeClass("selected");
        		jQuery("#signMonth_"+signMonths).addClass("selected");
        		jQuery("#selectedSignMonths").html(signMonths+"个月");//填充隐藏DIV所选信息
        		$("#step-3-info-signMonths").html(signMonths);//填写用户信息模块-合约信息-签约期
        	}
	
			if(data.responseState == 1){
				if(data.phoneNumPackageList != ""){
					if(signMonths == 0){
    					initSignMonths(data.signMonthsList);
    				}
    				buildPackageType(data.packageTypeList,signMonths,-1);
    				buildTreatyHtml(data.phoneNumPackageList, data.phoneNumPackageEncList);
				}else{
					$("#step-2-loading").html("<div class=\"grid\" style=\"text-align:center;color:red;\"><h3>该号卡无套餐可供选择，请重新选择号卡！</h3></div>");
				}
				
			}else{
				$("#step-2-loading").html("<div class=\"grid\" style=\"text-align:center;color:red;\"><h3>系统繁忙，请稍后再试！</h3></div>");
			}
		}
	);
}

//初使化月份
function initSignMonths(signMonths){
	var html = "";
	for(var i=0;i<signMonths.length;i++){
		var signMonth = signMonths[i];
		if(i == 0 && i == signMonths.length-1){
			html = html + "<a href=\"javascript:void(0);\" id=\"signMonth_"+signMonth+"\" class=\"type-item selected\" onclick=\"ajaxSignMonth("+signMonth+");\"><b></b>"+signMonth+"个月</a>";
			$("#selectedSignMonths").html(signMonth+"个月");//填充隐藏DIV所选信息
			$("#step-3-info-signMonths").html(signMonth);//填写用户信息模块-合约信息-签约期
			$("#signMonths").val(signMonth);
		}else if(i == 0 && i != signMonths.length-1){
			html = html + "<a href=\"javascript:void(0);\" id=\"signMonth_"+signMonth+"\" class=\"type-item selected\" onclick=\"ajaxSignMonth("+signMonth+");\"><b></b>"+signMonth+"个月</a>";
			$("#selectedSignMonths").html(signMonth+"个月");//填充隐藏DIV所选信息
			$("#step-3-info-signMonths").html(signMonth);//填写用户信息模块-合约信息-签约期
			$("#signMonths").val(signMonth);
		} else if(i == signMonths.length-1) {
			html = html + "<a href=\"javascript:void(0);\" id=\"signMonth_"+signMonth+"\" class=\"type-item\" onclick=\"ajaxSignMonth("+signMonth+");\"><b></b>"+signMonth+"个月</a>"
		} else {
			html = html + "<a href=\"javascript:void(0);\" id=\"signMonth_"+signMonth+"\" class=\"type-item\" onclick=\"ajaxSignMonth("+signMonth+");\"><b></b>"+signMonth+"个月</a>"
		}
	}
	$("#signMonthsHtml").html(html);   
	if(signMonths.length == 1 && signMonths[0] == 0){
		$("#signMonthsTitle").hide();
		$("#signMonthsContent").hide();
		$("#selectedSignMonths").hide();
		$("#selectedSignMonthsTitle").hide();
		
	}else{
		$("#signMonthsTitle").show();
		$("#signMonthsContent").show();
		$("#selectedSignMonths").show();
		$("#selectedSignMonthsTitle").show();
	}
}

//点击套餐类型
function ajaxPackageType(signMonths,packageType){
	var cardKey = $("#cardKey").val();
	var fid = $("#fid").val();
	var enc = $("#fenc").val();
	jQuery.getJSON(
		"queryPhonenumTreaty.action", 
		{"cardWid":"1084862","serviceOperatorId": "2", "bType": "0","provinceId":"1","cityId":"1",
		 "ownerInfoFlag":"0","cardKey":cardKey,"fid":fid,"enc":enc,"t": Math.random() ,"signMonths":signMonths,"packageType":packageType}, 
		function(data, textStatus) {
			//检查是否被防刷拦截
			if(!checkNotRefresh(data)){
				return;
			};
			//登录会话校验
			sessionCheck(data,$("#indexUrl").val());
			if(data.responseState == 1){
				buildPackageType(data.packageTypeList,signMonths,packageType);
				buildTreatyHtml(data.phoneNumPackageList, data.phoneNumPackageEncList);
			}else{
				$("#step-2-loading").html("<div class=\"grid\" style=\"text-align:center;color:red;\"><h3>系统繁忙，请稍后再试！</h3></div>");
			}
		}
	);
}

function buildPackageType(packageTypeList,signMonths,packageType){
	var typeHtml = [];
	jQuery.each(packageTypeList, function(index, item) {
		if(index == 0){
			typeHtml[typeHtml.length] ="<a href=\"javascript:void(0);\" name=\"packageTypeRadio\" id=\"packageType_"+item.id+"\" v='" + item.packageType + "' class=\"type-item selected\" onclick=ajaxPackageType("+signMonths + ","+ item.id+");><b></b>"+item.packageType;
			$("#selectedPackageType").html(item.packageType);//填充隐藏DIV所选信息
			$("#step-3-info-packageType").html(item.packageType);//填写用户信息模块-合约信息-套餐类型
		}else{
			typeHtml[typeHtml.length] ="<a href=\"javascript:void(0);\" name=\"packageTypeRadio\" id=\"packageType_"+item.id+"\" v='" + item.packageType + "' class=\"type-item\" onclick=ajaxPackageType("+signMonths + ","+ item.id+");><b></b>"+item.packageType;
		}
		//如果套餐类型描述为空，则不显示套餐类型后面的括号
		if(item.remark != null && item.remark != "null" && item.remark != ""){
			typeHtml[typeHtml.length] = "<span id=\"packageTypeExp_"+item.id+"\">("+item.remark+")</span></a>";
			if(index == 0){
				$("#step-3-info-packageType-exp").html("(" + item.remark +")");//填写用户信息模块-合约信息-套餐类型描述信息
			};
		}else{
			typeHtml[typeHtml.length] = "<span id=\"packageTypeExp_"+item.id+"\"></span></a>";
			$("#step-3-info-packageType-exp").html("");//填写用户信息模块-合约信息-套餐类型描述信息
		}
	});
	typeHtml[typeHtml.length] ="<a id=\"j-detail\" class=\"a-link\" href=\"javascript:void(0);\" clstag=\"eve|keycount|treaty|PackageDetails\" onclick=\"showPackageDetails();\">套餐资费详情</a>";
	$("#packageTypeHtml").html(typeHtml.join(""));
	if(packageType >= 0){
		$("#packageTypeHtml .selected").removeClass("selected");
		$("#packageType_"+packageType).addClass("selected");
		//填充隐藏DIV所选信息
		$("#selectedPackageType").html($("#packageType_"+packageType).attr("v"));
		$("#step-3-info-packageType").html($("#packageType_"+packageType).attr("v"));//填写用户信息模块-合约信息-套餐类型
		$("#step-3-info-packageType-exp").html($("#packageTypeExp_"+packageType).text());
	}
}

//构造套餐信息
function buildTreatyHtml(phoneNumPackageList,encList){
	var treatyHtml = [];
	if(null != phoneNumPackageList){
		if(phoneNumPackageList.length > 4){
			$("#get-more").html("<b>更多套餐↓</b>").addClass("get-more");
			$(".get-more").show();
		}else{
			$(".get-more").hide();
		}
		jQuery.each(phoneNumPackageList, function(index, item) {
			//单选按钮
			if(index == 0){
				treatyHtml[treatyHtml.length] = "<tr class=\"selected\">";
				treatyHtml[treatyHtml.length] = "<td><input type=\"radio\" name=\"treatyRadio\" checked=\"checked\" value='" + item.id + "' tenc='" + encList[index] + "' saveGiveFlag='" + item.saveGiveFlag + "' monthPackageFee='" + item.monthPackageFee  + "' moneyReturnRule='" + item.moneyReturnRule + "' call='" + item.packageInfo.call + "' message='" + item.packageInfo.message + "' traffic='" + item.packageInfo.traffic + "'></td>";
				//加载存费送费信息
				if(item.saveGiveFlag > 0){
					$("#sgplanTable").hide();
					getSaveGivePlan(item.saveGiveFlag,item.id);
				}
			}else{
				treatyHtml[treatyHtml.length] = "<tr>";
				treatyHtml[treatyHtml.length] = "<td><input type=\"radio\" name=\"treatyRadio\" value='" + item.id + "' tenc='" + encList[index] + "' saveGiveFlag='" + item.saveGiveFlag + "' monthPackageFee='" + item.monthPackageFee + "' moneyReturnRule='" + item.moneyReturnRule + "' call='" + item.packageInfo.call + "' message='" + item.packageInfo.message + "' traffic='" + item.packageInfo.traffic + "'></td>";
			}
			treatyHtml[treatyHtml.length] = "<td><b class=\"fc-price\">"+ item.monthPackageFee +"</b>元/月</td>";
			treatyHtml[treatyHtml.length] = "<td class=\"td-rule\" >"+ item.moneyReturnRule +"</td>";
			if(item.packageInfo.call != null && (item.packageInfo.call.indexOf("<br>") != -1 || item.packageInfo.call.indexOf("</br>") != -1)){
				treatyHtml[treatyHtml.length] = "<td align=\"left\">"+ item.packageInfo.call +"</td>";
			}else{
				treatyHtml[treatyHtml.length] = "<td>"+ item.packageInfo.call +"</td>";
			}
			if(item.packageInfo.message != null && (item.packageInfo.message.indexOf("<br>") != -1 || item.packageInfo.message.indexOf("</br>") != -1)){
				treatyHtml[treatyHtml.length] = "<td align=\"left\">"+ item.packageInfo.message +"</td>";
			}else{
				treatyHtml[treatyHtml.length] = "<td>"+ item.packageInfo.message +"</td>";
			}
			if(item.packageInfo.traffic != null && (item.packageInfo.traffic.indexOf("<br>") != -1 || item.packageInfo.traffic.indexOf("</br>") != -1)){
				treatyHtml[treatyHtml.length] = "<td align=\"left\">"+ item.packageInfo.traffic +"</td>";
			}else{
				treatyHtml[treatyHtml.length] = "<td>"+ item.packageInfo.traffic +"</td>";
			}
			treatyHtml[treatyHtml.length] = "</tr>";
		});
	}
	$("#treatyPlanHtml table tbody").html(treatyHtml.join(""));
	//设置样式，注册事件
	setTreatyplanClass();
	//获取选中的合约，记录相关的值到隐藏域
	setTreatyplanInfo();
	
}

//设置资费列表样式
function setTreatyplanClass(){
	
	//默认只显示前4条
	$("#treatyPlanHtml table tr:gt(4)").hide();
	//设置单选样式
	$("#treatyPlanHtml table tbody tr").hover(function(){
		$(this).addClass("hover");
	},function(){
		$(this).removeClass("hover");
	});
	$("#treatyPlanHtml table tbody tr").click(function(){
		$("#treatyPlanHtml table td :radio").attr("checked",false);
		$(this).addClass("selected").siblings().removeClass("selected");
		$(this).find(":radio").attr("checked","checked");
		setTreatyplanInfo();
	});
	
	//页面去掉“加载中”提示，显示数据
	$("#step-2-loading").hide();
	$("#step-2-0").show();
	
}

//获取选中的合约，记录相关的值到隐藏域
function setTreatyplanInfo(){

	$("#saveGiveDivError").hide();
	//$("#sgplanCon").html("");
	$("#submitTreatyButton").show();
	
	var obj = $('input[name=treatyRadio]:checked');
	$("#numPackageId").val(obj.val());
	$("#tenc").val(obj.attr("tenc"));

	$("#selectedMonthPackageFee").html(obj.attr("monthPackageFee"));
	$("#selectedMonthPackageFeeRed").html(obj.attr("monthPackageFee"));
	$("#packageMonthFee").val(obj.attr("monthPackageFee"));

	//用户信息模块数据填充
	$("#step-3-info-monthPackageFee").html(obj.attr("monthPackageFee") + "元/月");
	if(null != obj.attr("moneyReturnRule") && obj.attr("moneyReturnRule") != '' && obj.attr("moneyReturnRule") != 'null'){
		$("#selectedRemark").html("(" + obj.attr("moneyReturnRule") + ")");
	}
	$("#selectedCall").html(obj.attr("call"));
	$("#selectedMessage").html(obj.attr("message"));
	$("#selectedTraffic").html(obj.attr("traffic"));
	
	//加载存费送费信息
	var saveGiveFlag = obj.attr("saveGiveFlag");
	if(saveGiveFlag>0){
		getSaveGivePlan(saveGiveFlag,obj.val());
	}else{
		$("#saveGiveDiv").hide();
	}
}

//确认套餐或者重选套餐/
function submitTreatyPlan(type){
	if('TreatyPlan' == type){
	
		//判断联通存费送费
		if ($("#sgplanCon").html().length >= 100) {
            if ($("input[name='radioSgplan']:checked").length == 0) {
                alert("请选择存费赠费计划");
                return false;
            }
            var preStoreFeeId = $("input[name='radioSgplan']:checked").val();
            $("#preStoreFeeId").val(preStoreFeeId);
            var preStoreFeeWid = $("input[name='radioSgplan']:checked").attr("preStoreFeeWid");
            $("#preStoreFeeWid").val(preStoreFeeWid);
        }
		
		var ownerInfoFlag = $("#ownerInfoFlag").val();
		if(ownerInfoFlag == 1){
			$("#submitTreatyButton").hide();
			redirectOrder();
		}else{
			$("#step-2-loading").hide();
    		$("#step-2-1").hide();
    		$("#step-2-2").hide();
    		$("#step-2-info").show();
    		$("#re-step-2").show();
    		$("#step-3").removeClass("fd-forbidden");
    		$("#step-3").addClass("fd-curr");
    		$("#step-2").removeClass("fd-curr");
			$("#specialTipsForTreatyHtml").hide();
    		queryOwnerInfo();
    		
		}
		
	}else if('Re-TreatyPlan' == type){
		resetTreatyPlan();
		resetOwnerInfo();
	}
	return false;
}

function resetTreatyPlan(){
	$("#step-2-1").show();
	$("#step-2-2").show();
	$("#specialTipsForTreatyHtml").show();
	$("#step-2-info").hide();
	$("#re-step-2").hide();
	$("#step-2").removeClass("fd-forbidden");
	$("#step-2").addClass("fd-curr");
}

function closeTreatyPlan(){
	$("#step-2").removeClass("fd-curr");
	$("#step-2").addClass("fd-forbidden");
	$("#step-2-info").hide();
	$("#re-step-2").hide();
	$("#step-2-0").hide();
}

function showPackageDetails(){
	//套餐资费详情弹出对话框
	jQuery.jdThickBox({ 
		type: "html", 
		width:820, 
		height:700, 
		source:".accept-dialog", 
		title: "套餐资费详情",
		_close_val: "×",
		_titleOn: true,
		_fastClose: true/*是否允许点击边框外边马上关闭*/
	});
}

//根据号码套餐ID查询该套餐绑定的存费送费合约
function getSaveGivePlan(saveGiveFlag,numPackageId){
     
	jQuery.getJSON(
		"querySaveGivePlanByPackId.action", 
		{"numPackageId":numPackageId,"t": Math.random()}, 
		function(data, textStatus) {
			//检查是否被防刷拦截
			if(!checkNotRefresh(data)){
				return;
			};
			//登录会话校验
			sessionCheck(data,$("#indexUrl").val());
			if(data.responseState == 1){
				showSaveGivePlan(saveGiveFlag,data.saveGivePlanList);
			}else{
				if(saveGiveFlag==2){
					$("#saveGiveDivError").show();
					$("#submitTreatyButton").hide();
				}
			}
		}
	);	
}

	
//构造存费送费页面
function showSaveGivePlan(saveGiveFlag,saveGivePlanList){
	if(null == saveGivePlanList || saveGivePlanList.length == 0){
		$("#saveGiveDiv").hide();
		$("#sgplanCon").html("");
		return;
	}
	var planHtml = "";
	var joinTypeHtml = "";
	var id=0;
	var preStoreFeeWid=0;
	jQuery.each(saveGivePlanList, function(index, item) {
		id = item.id;
		preStoreFeeWid = item.prestoreWid;
		planHtml = planHtml + "<tr>";
		planHtml = planHtml + "<td>" + item.signMonths + "个月</td>";
		planHtml = planHtml + "<td>" + item.prestoreFee + "</td>";
		planHtml = planHtml + "<td>" + item.monthReturnFee + "</td>";
		planHtml = planHtml + "<td>" + item.monthGiveFee + "</td>";
		planHtml = planHtml + "<td>" + "<a href=\"javascript:void(0)\" class=\"a-link\" onclick=\"xiangxi()\">详细</a>" + "</td>";
		planHtml = planHtml + "</tr>";
	});

	joinTypeHtml = "<label for=\"ir01ir01\" class=\"mr10\"><input type=\"radio\" class=\"mr5\" name=\"radioSgplan\" checked=\"checked\" onclick=\"changeCFSF(1);\" id=\"plan\" value='"+id+"' preStoreFeeWid='"+preStoreFeeWid+"' ><span onclick='selectPrev(this);'>参加“存费送费”活动</span></label>";
	
	//存费送费标记=1代表该号码套餐绑定了存费送费，但不是必选项
	if(saveGiveFlag==1){
        joinTypeHtml = joinTypeHtml + "<label for=\"ir02ir02\"><input type=\"radio\" class=\"mr5\" name=\"radioSgplan\" onclick=\"changeCFSF(0);\" id=\"plan\" value=\"-1\" preStoreFeeWid=\"0\"><span onclick='selectPrev(this);'>不参加</span></label>";
	}

	if(saveGivePlanList!=null && saveGivePlanList!=''){
		$("#sgplanCon").html(planHtml);
		$("#joinTypeHtml").html(joinTypeHtml);
		$("#step2-sgplan").show();
	}
	$("#sgplanTable").show();
	$("#saveGiveDiv").show();
}					
							
 //查询详细联通存费送费合约
function xiangxi() {
	jQuery.jdThickBox({
        type: "iframe",
        title: "中国电信存费赠费合约计划详情",
        width: 700,
        height: 300,
        source: "tanchuceng.html",
        _autoReposi: true
    });
}

function changeCFSF(type){
	if(1==type){
		$("#sgplanTable").show();
	}else{
		$("#sgplanTable").hide();
	}
}
function selectPrev(obj) {
	$(obj).prev().attr("checked", "checked");
	$(obj).prev().click();
}
</script>		<!-- 加载用户信息模块 -->
		<div class="fieldset fd-forbidden mb10" id="step-3">
	<div class="fd-index">3</div>
	<div class="fs-n-tit">
		<span class="fs-t">填写个人信息</span><a class="a-link" href="javascript:void(0);">[重选]</a>
	</div>
	<div class="fs-con">
		<div class="fk-grid fk-g-2">
			<div class="n-cols" id="step-3-0">
				<form name="ownerInfoForm" method="post" action="" id="ownerInfoForm">
					<div class="fk-h">机主姓名：</div>
					<div class="fk-d">
						<label for="">
							<input name="userName" id="UserName" class="txt-17 mr10" placeholder="请填写真实姓名" type="text"/>
							<span id="UserNameError" style="color:red"></span>
						</label>
					</div>
					<div class="fk-h">身份证号：</div>
					<div class="fk-d">
						<label for="">
							<input name="certNumber" id="CertNumber" class="txt-25 mr10" placeholder="请填写18位身份证号码" type="text"/>
							<span id="CertNumberError" style="color:red"></span>
                        </label>
					</div>
					<div class="fk-d"><input class="mr10" name="" id="accept-hookbox" type="checkbox"><span class="mr5">我已阅读并同意</span>
						<a class="a-link" href="javascript:void(0);" onclick="showAgreementDialog();">《入网协议》</a>
						<a class="a-link" href="javascript:void(0);" onclick="showSpAgreementDialog();" id="showSpAgreementTitle" style="display:none;"></a>
						<span id="AgreemenError" style="color:red"></span>
					</div>
				</form>
			</div>
		</div>
		<div class="msg-attention dis-b mb10" id="specialTipsHtml" style="display:none;"></div>
		<div class="msg-result" id="step-3-info">
			<div>
				您已选择：
									<b id="step-3-info-cityName">北京</b>;
								在网<b id="step-3-info-signMonths"></b>
								<b id="step-3-info-monthPackageFee"></b>合约;
				每月套餐<b id="step-3-info-packageType"></b><span id="step-3-info-packageType-exp">上网流量</span>
				手机号码为：<b id="step-3-info-phonenum"></b>
			</div>
			<div>
				合约总金额：<b id="step-3-info-price"></b>
			</div>
		</div>
		<div align="right"><span id="next_msg" style="display: none;">正在转向订单信息确认页面</span></div>
		<div class="txt-r" id="step-3-submit">
			<a href="javascript:void(0);" class="btn-m-r" clstag="eve|keycount|treaty|XHRWOwnerInfo" onclick="return submitOwnerInfo();"><span>去结算</span></a>
		</div>
	</div>
</div>

<iframe scrolling="no" marginheight="0" marginwidth="0" id="" class="thickframe" style="display: none;" frameborder="0"></iframe>
<div id="G-StringDiv" class=""></div>
		    
<!-- 入网协议弹出框内容 -->
<div class="accept-dialog-1" style="display: none;">
	<div class="dialog-content" style="text-align: center;">
		<img id="showImageNew" src="${ctx}/imgas/53b619c1N7d03be93.jpg"/>
	</div>
</div>
<!-- 运营商入网协议弹出框内容 -->
<div class="accept-dialog-2" style="display: none;">
	<div class="dialog-content" style="text-align: center;">
		<img id="showSpImage" src=""/>
	</div>
</div>

<script type="text/javascript">
//重置用户信息模块初始状态
function resetOwnerInfo(){
	$("#step-3").removeClass("fd-curr");
	$("#step-3").addClass("fd-forbidden");
}

//查询机主信息
function queryOwnerInfo(){
   
	$("#step-3-info-price").html($("#jd-price-sum").html());
	jQuery.ajax({
		url:"queryPhoneNumOwnerInfo.action", 
		data:"&bType=0"+
			"&provinceId="+$("#provinceId").val()+
			"&serviceOperatorId=2"+
			"&t="+Math.random(), 
		async:false,
		dataType:"json",
		success:function(data, textStatus) {
			if(null != data){
				//检查是否被防刷拦截
    			if(!checkNotRefresh(data)){
    				return;
    			};
				//登录会话校验
				//sessionCheck(data,$("#indexUrl").val());
				//初始化机主信息、证件号码
				var customerInfo = data.customerInfo;
				if(null != customerInfo){
					$("#UserName").val(customerInfo.customerName);
					$("#CertNumber").val(customerInfo.certNumber);
				}
				
				//初始化入网协议
				$("#showImageNew").attr("src",data.imagePath);
				
				//运营商协议
				var spAgreementTitle = data.spAgreementTitle;
				if(null != spAgreementTitle){
					$("#showSpAgreementTitle").html("《" + spAgreementTitle + "》");
					$("#showSpAgreementTitle").show();
					$("#showSpImage").attr("src",data.spAgreementImagePath);
				}
				
				//特别提示
				var specialTips = data.specialTips;
				if(null != specialTips){
					$("#specialTipsHtml").html(specialTips.details);
					$("#specialTipsHtml").show();
				}
			}else{
				$("#step-3-0").html("<b></b>加载信息失败...");
    		}
		}
	});
}

function showAgreementDialog(){
   
	jQuery.jdThickBox({ 
		type: "html", 
		width:900, 
		height:1000, 
		source:".accept-dialog-1", 
		title: "入网协议",
		_close_val: "×",
		_titleOn: true,
		_fastClose: true/*是否允许点击边框外边马上关闭*/
	});
}

function showSpAgreementDialog(){
	jQuery.jdThickBox({ 
		type: "html", 
		width:900, 
		height:1000, 
		source:".accept-dialog-2", 
		title: "运营商入网协议",
		_close_val: "×",
		_titleOn: true,
		_fastClose: true/*是否允许点击边框外边马上关闭*/
	});
}

function submitOwnerInfo(){
	$("#UserNameError").html("");
	$("#CertNumberError").html("");
	$("#AgreemenError").html("");
	if ($("#UserName").val() == "") {
	   
        $("#UserNameError").html("请填写机主姓名");
        return false;
    }else {
        
        if ($("#UserName").val().length > 10) {
            $("#UserNameError").html("机主姓名字符数不能超过10个");
            return false;
        }
    }
    if ($("#CertNumber").val() == "") {
        $("#CertNumberError").html("请填写证件号");
        return false;
    }
    
    var msg = checkCardNotAlert();
    if (msg != "") {
		$("#CertNumberError").html(msg);
        return false;
    }
	if ($("#accept-hookbox").attr("checked") == false) {
    	$("#AgreemenError").html("请同意入网协议");
        return false;
    }
   
	$("#step-3-submit").hide();
	//重定向订单页
	redirectOrder();
}

//只能输入数字和字母
function check(el, reg) {
    var regu = reg;
    var re = new RegExp(regu);
    if (el.search(re) == -1) {
        return true; //非法 
    }
    else
        return false;
};

//跳转订单页
function redirectOrder(){
		$("#next_msg").show().attr("style", "border:#01B703 1px solid;padding:4px 20px 4px 20px;background:#F1FDE5;font-size:12px;color:#01B703;height:23px;");
		$("#G-StringDiv").addClass("thickdiv");
	    var wareId=$('#wareId').val();
	    var cardWid=$('#cardWid').val();
	    var username=$("#UserName").val();
	    var cardNo=$("#CertNumber").val();
	    var cardKey=$("#cardKey").val();
	    var packageType=$("#step-3-info-packageType").val();
	    var month=$("#step-3-info-signMonths").val();
	    
	    var url="jiesuan2.do?"+
	            "ware.id="+wareId+
				"&phone.id="+cardWid+
				"&phone.telphone="+cardKey+  
				"&username="+username+
				"&packageType="+packageType+  
				"&month="+month+
				"&cardNo="+cardNo;
	            $("#ownerInfoForm").attr("action",url);
	            $("#ownerInfoForm").submit();
}
</script>
<script type="text/javascript" src="${ctx}/styles/front/selectPhone_files/lib-v1.js"></script>
	</div>
</div>
</div>
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
</body>
</html>
