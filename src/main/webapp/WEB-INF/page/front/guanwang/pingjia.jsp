<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>麦芽网上商城</title>
<link href="${ctx}/styles/front/style/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/styles/front/style/photoComment_pages.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/front/pro_dropdown_2/pro_dropdown_2.css" />
<script src="${ctx}/scripts/front/js/stuHover.js" type="text/javascript"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
<script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></script>
<script type="text/javascript" src="${ctx }/scripts/front/clients_js/pingjia.js"></script>
<script type="text/javascript" src="${ctx}/scripts/front/clients_js/validation_landing.js" ></script>
<script>
function changeDiv(tag,method){document.getElementById(tag).style.display = method;}
</script>
</head>

<body>
<div class="box">
<%@ include file="/WEB-INF/page/front/guanwang/header.jsp"%>
<!--[if !IE]>产品评价<![endif]-->
<form action="" name="saveComment" id="saveComment" method="post">
	<input type="hidden" id="goodId" value="${goodId }"/><!-- request获取对象-->
	<input type="hidden" id="code" value="${code}"/>
	<div class="content">
<div class="coupon">
<div  class="orderDetails">
	<samp>
		<c:if test="${loginCustomer!=null }"><a href="${ctx }/customersManage.do">麦芽网上商城</a></c:if>
		<c:if test="${loginCustomer==null }"><a href="javascript:void(0);" onclick="myshops('1')">麦芽网上商城</a></c:if><!-- ShowDiv('MyDiv','fade') -->
	</samp>
	<span>></span>
	<span class="ordys">
		<c:if test="${loginCustomer!=null }"><a href="${ctx }/customersManage.do">待评价商品</a></c:if>
		<c:if test="${loginCustomer==null }"><a href="javascript:void(0);" onclick="myshops('2')">待评价商品</a></c:if>
	</span>
	<span>></span>
	<span class="ordys"><a href="#">发表评论</a></span>
</div>
<!--[if !IE]>产品评价<![endif]-->
<div class="photocomment">
<h1>欢迎您发表原创，与商品质量有关，对其他用户有参考价值的商品评价!</h1><br/><h2>如果您发表的内容与商品本身质量无关，评价将被删除！</h2>
</div>
<div class="photocomment1">
<h1>*</h1>评论
</div>
<div class="photocomment2">
<h1><input name="level" type="radio" value="5" id="q5" checked="checked"/></h1>
<h2><img src="${ctx}/Images/images/pu10.jpg" /></h2>
<h3>5分</h3>
<h1><input name="level" type="radio" value="4" id="q4" /></h1>
<h2><img src="${ctx}/Images/images/pu11.jpg" /></h2>
<h3>4分</h3>
<h1><input name="level" type="radio" value="3" id="q3" /></h1>
<h2><img src="${ctx}/Images/images/pu12.jpg" /></h2>
<h3>3分</h3>
<h1><input name="level" type="radio" value="2" id="q2" /></h1>
<h2><img src="${ctx}/Images/images/pu13.jpg" /></h2>
<h3>2分</h3>
<h1><input name="level" type="radio" value="1" id="q1" /></h1>
<h2><img src="${ctx}/Images/images/pu14.jpg" /></h2>
<h3>1分</h3>
</div>
<div class="photocomment1">
<h1>*</h1>使用心得
</div>
<div class="photocomment3">
<h1><textarea name="wareComment.content" id="content" cols="" rows="" class="photocomment3textare" onclick="showLoginDIV()"></textarea></h1>
<h2>
<div id="remakeDIV">
	<span>必填，长度在5-200字之间</span>
	<samp>填写您对此商品的使用心得，例如该商品或某功能为您带来的帮助，或使用过程中遇到的问题等，最多可输入200字。</samp>
</div>
</h2>
</div>
<div class="photocomment4"><input name="" type="button" class="photocommentbtn" onclick="submitSaveComment()"/></div>
<!--[if !IE]>产品评价<![endif]-->
</div>
</div>
</form>
  <%@ include file="/WEB-INF/page/front/guanwang/bottom.jsp"%> 
  </div>
</body>
</html>

