<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
<head>
      
		<title>一卡通 - 网上支付 安全快速！</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="${ctx}/scripts/front/clients_js/ordersPay.js"></script>
        <script language="javascript" src="${ctx}/scripts/front/js/jquery.js"></script>
        <script language="javascript" src="${ctx}/scripts/front/js/index20110925_mini.js"></script>
        <script language="javascript" src="${ctx}/scripts/front/js/jquery2.js"></script>
        <SCRIPT type="text/javascript" src="${ctx}/scripts/front/js/jquery1.js"></SCRIPT>
		<style>
@font-face {
	font-family: "rei";
	src: url("https://i.alipayobjects.com/common/fonts/rei.eot?20140408");
	/* IE9 */
	src:
		url("https://i.alipayobjects.com/common/fonts/rei.eot?20140408#iefix")
		format("embedded-opentype"), /* IE6-IE8 */ 
     url("https://i.alipayobjects.com/common/fonts/rei.woff?20140408")
		format("woff"), /* chrome 6+、firefox 3.6+、Safari5.1+、Opera 11+ */ 
     url("https://i.alipayobjects.com/common/fonts/rei.ttf?20140408")
		format("truetype"),
		/* chrome、firefox、opera、Safari, Android, iOS 4.2+ */ 
    
		url("https://i.alipayobjects.com/common/fonts/rei.svg?20140408#rei")
		format("svg"); /* iOS 4.1- */
}

.iconfont {
	font-family: "rei";
	font-style: normal;
	font-weight: normal;
	cursor: default;
	-webkit-font-smoothing: antialiased;
}
</style>
		 
		<link charset="utf-8" rel="stylesheet" href="${ctx}/styles/card_files/excashier.css"
			media="all" />
		<link charset="utf-8" rel="stylesheet" href="${ctx}/styles/card_files/alice.css"
			media="all" />

		<style type="text/css">
/**
安全产品样式覆盖
**/
.ui-securitycore .ui-label,.mi-label {
	text-align: left;
	height: auto;
	line-height: 18px;
	padding: 0;
	display: block;
	padding-bottom: 8px;
	margin: 0;
	width: auto;
	float: none;
	font: 14px/ 1.5 tahoma, arial, \5b8b\4f53;
}

.ui-securitycore .ui-form-item {
	position: relative;
	padding: 0 0 10px 0;
	width: 350px;
}

.ui-securitycore .ui-form-explain {
	height: 18px;
	/*display: block;*/
	font-family: tahoma, arial, \5b8b\4f53;
}

.ui-securitycore .edit-link {
	position: absolute;
	top: -3px;
	right: 0;
}

.ui-securitycore .ui-input {
	height: 28px;
	font-size: 14px;
}

.ui-securitycore .standardPwdContainer .ui-input {
	width: 340px;
}

/*安全服务化必将覆盖的样式*/
.mobile-form .ui-securitycore .ui-form-item-mobile {
	display: none;
}

.mobile-form .ui-securitycore .ui-form-item-mobile .ui-label {
	
}

.mobile-form .ui-securitycore .ui-form-item-mobile .ui-form-text {
	display: none;
}

.mobile-form .ui-securitycore .ui-form-item-counter {
	padding-left: 0;
	padding-right: 0;
	padding-bottom: 20px;
	position: relative;
	height: 87px;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-label {
	display: block;
	float: none;
	margin-left: 0;
	text-align: left;
	line-height: 18px !important;
	padding: 0 0 8px 0;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-form-field {
	/*display: block;*/
	zoom: 1;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-form-field:after
	{
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-checkcode-input
	{
	height: 24px;
	line-height: 24px;
	width: 148px;
	border: 1px solid #ccc;
	padding: 7px 10px;
	float: left;
	display: block;
	font-size: 14px;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-checkcode-input:focus
	{
	color: #4d4d4d;
	border-color: #07f;
	outline: 1px solid #8cddff;
}

.mobile-form .ui-securitycore .ui-form-item-counter .eSend-btn {
	float: left;
	color: #08c;
}

#mobileSend {
	position: absolute;
	right: 0;
	top: 26px;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-checkcode-messagecode-btn
	{
	float: left;
	width: 178px;
	height: 40px;
	_height: 38px;
	line-height: 38px;
	_line-height: 35px;
	color: #676d70;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	border: 1px solid #ccc;
	border-radius: 1px;
	background: #f3f3f3;
	margin-left: 2px;
	padding-left: 0;
	padding-right: 0;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-checkcode-messagecode-disabled-btn
	{
	background: #cacccd;
	border: 1px solid #cacccd;
	color: #aeb1b3;
	font-weight: normal;
	cursor: default;
}

.mobile-form .ui-securitycore .ui-form-item-counter .reSend-btn {
	float: left;
	margin-top: 10px;
	color: #08c;
}

.ui-checkcode-messagecode-disabled-btn {
	
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-form-field {
	display: block;
}

.mobile-form .ui-securitycore .ui-form-item-counter .ui-form-field .fn-hide,.mobile-form .ui-securitycore .ui-form-item-counter .fn-hide .reSend-btn
	{
	display: none;
}

/*安全服务化必将覆盖的样式*/
.alieditContainer object {
	width: 350px;
	height: 38px;
}

#container .alieditContainer {
	width: 350px;
	height: 38px;
}

#container .alieditContainer a.aliedit-install {
	line-height: 38px;
}

/* 安全服务化去控件升级 特木 temu.psc@alipay.com */
#container .alieditContainer .ui-input {
	width: 328px;
	padding: 7px 10px;
	font-size: 14px;
	height: 24px;
	line-height: 24px;
}

#container .alieditContainer .ui-input:focus {
	color: #4D4D4D;
	border-color: #07F;
	outline: 1px solid #8CDDFF; *
	padding: 7px 3px 4px; *
	border: 2px solid #07F;
}

.teBox {
	height: auto;
}

.anti-fishing {
	padding: 15px;
	width: 450px;
}

.anti-fishing h2 {
	display: none;
}

#J_loginPwdMemberT {
	padding: 20px 0 60px 0;
}

#J_loginPwdMemberT #teLogin {
	height: auto;
}

#J_loginPwdMemberT .mi-form-item {
	padding: 0 0 10px 0;
}

#J_loginPwdMemberT .teBox-in {
	padding-top: 0px;
	width: 350px;
	margin: 0 auto;
}

.teForm {
	padding-left: 0;
}

.t-contract-container {
	width: 76%;
}

.contract-container {
	width: 450px;
	margin: 0 auto;
	text-align: left;
	position: relative;
}

.contract-container .contract-container-label {
	width: 450px;
}

.mb-text {
	font-size: 14px;
	padding-top: 10px;
}

.ml5 {
	margin-left: 5px;
}

.user-login-account {
	font-size: 16px;
}

.mi-mobile-button {
	font-weight: bold;
}

.alipay-agreement-link {
	margin-left: 5px;
	color: #999;
}

.alipay-agreement {
	width: 600px;
	height: 270px;
	padding: 10px;
	text-align: center;
}

.alipay-agreement-content {
	height: 230px;
	width: 600px;
	margin-bottom: 5px;
}

#container .order-timeout-notice {
	margin-top: 30px;
	display: none;
}

.login-panel .fn-mb8 {
	margin-bottom: 8px;
}

.login-panel .fn-mt8 {
	margin-top: 8px;
}
</style>

		<style>
#header h1.logo {
	background:
		url(https://i.alipayobjects.com/i/ecmng/png/201405/2dSldbS1hV.png)
		no-repeat left 2px;
}
</style>
		<!-- CMS:外部商户匿名收银台cms/日志入口/全局日志入口开始:excashier/globalLog/log.vm -->
		<style>
body #onlineService {
	display: none
}
</style>
		<!-- CMS:外部商户匿名收银台cms/日志入口/全局日志入口结束:excashier/globalLog/log.vm -->
		<style>
.arale-tip-1_2_1 .ui-poptip {
	color: #DB7C22;
	z-index: 101;
	font-size: 12px;
	line-height: 1.5;
	zoom: 1
}

.arale-tip-1_2_1 .ui-poptip-shadow {
	background-color: rgba(229, 169, 107, .15);
	FILTER: progid : DXImageTransform . Microsoft .
		Gradient(startColorstr = #26e5a96b, endColorstr = #26e5a96b);
	border-radius: 2px;
	padding: 2px;
	zoom: 1;
	_display: inline
}

.arale-tip-1_2_1 .ui-poptip-container {
	position: relative;
	background-color: #FFFCEF;
	border: 1px solid #ffbb76;
	border-radius: 2px;
	padding: 5px 15px;
	zoom: 1;
	_display: inline
}

.arale-tip-1_2_1 .ui-poptip:after,.arale-tip-1_2_1 .ui-poptip-shadow:after,.arale-tip-1_2_1 .ui-poptip-container:after
	{
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0
}

.arale-tip-1_2_1 a.ui-poptip-close {
	position: absolute;
	right: 3px;
	top: 3px;
	border: 1px solid #ffc891;
	text-decoration: none;
	border-radius: 3px;
	width: 12px;
	height: 12px;
	font-family: tahoma;
	color: #dd7e00;
	line-height: 10px; *
	line-height: 12px;
	text-align: center;
	font-size: 14px;
	background: #ffd7af;
	background: -webkit-gradient(linear, left top, left bottom, from(#FFF0E1),
		to(#FFE7CD) );
	background: -moz-linear-gradient(top, #FFF0E1, #FFE7CD);
	filter: progid : DXImageTransform . Microsoft .
		gradient(startColorstr = '#FFF0E1', endColorstr = '#FFE7CD');
	background: -o-linear-gradient(top, #FFF0E1, #FFE7CD);
	background: linear-gradient(top, #FFF0E1, #FFE7CD);
	overflow: hidden
}

.arale-tip-1_2_1 a.ui-poptip-close:hover {
	border: 1px solid #ffb24c;
	text-decoration: none;
	color: #dd7e00;
	background: #ffd7af;
	background: -webkit-gradient(linear, left top, left bottom, from(#FFE5CA),
		to(#FFCC98) );
	background: -moz-linear-gradient(top, #FFE5CA, #FFCC98);
	filter: progid : DXImageTransform . Microsoft .
		gradient(startColorstr = '#FFE5CA', endColorstr = '#FFCC98');
	background: -o-linear-gradient(top, #FFE5CA, #FFCC98);
	background: linear-gradient(top, #FFE5CA, #FFCC98)
}

.arale-tip-1_2_1 .ui-poptip-arrow {
	position: absolute;
	z-index: 10; *
	zoom: 1
}

.arale-tip-1_2_1 .ui-poptip-arrow em,.arale-tip-1_2_1 .ui-poptip-arrow span
	{
	position: absolute; *
	zoom: 1;
	width: 0;
	height: 0;
	border-color: rgba(255, 255, 255, 0);
	border-color: transparent\0; *
	border-color: transparent;
	_border-color: tomato;
	_filter: chroma(color = tomato);
	border-style: solid;
	overflow: hidden;
	top: 0;
	left: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-10 {
	left: -6px;
	top: 10px
}

.arale-tip-1_2_1 .ui-poptip-arrow-10 em {
	top: 0;
	left: -1px;
	border-right-color: #ffbb76;
	border-width: 6px 6px 6px 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-10 span {
	border-right-color: #FFFCEF;
	border-width: 6px 6px 6px 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-9 {
	left: -6px;
	top: 50%
}

.arale-tip-1_2_1 .ui-poptip-arrow-9 em {
	top: -6px;
	left: -1px;
	border-right-color: #ffbb76;
	border-width: 6px 6px 6px 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-9 span {
	top: -6px;
	border-right-color: #FFFCEF;
	border-width: 6px 6px 6px 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-2 {
	top: 10px;
	right: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-2 em {
	top: 0;
	left: 1px;
	border-left-color: #ffbb76;
	border-width: 6px 0 6px 6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-2 span {
	border-left-color: #FFFCEF;
	border-width: 6px 0 6px 6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-3 {
	top: 50%;
	right: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-3 em {
	top: -6px;
	left: 1px;
	border-left-color: #ffbb76;
	border-width: 6px 0 6px 6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-3 span {
	top: -6px;
	border-left-color: #FFFCEF;
	border-width: 6px 0 6px 6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-11 em,.arale-tip-1_2_1 .ui-poptip-arrow-12 em,.arale-tip-1_2_1 .ui-poptip-arrow-1 em
	{
	border-width: 0 6px 6px;
	border-bottom-color: #ffbb76;
	top: -1px;
	left: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-11 span,.arale-tip-1_2_1 .ui-poptip-arrow-12 span,.arale-tip-1_2_1 .ui-poptip-arrow-1 span
	{
	border-width: 0 6px 6px;
	border-bottom-color: #FFFCEF
}

.arale-tip-1_2_1 .ui-poptip-arrow-11 {
	left: 14px;
	top: -6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-1 {
	right: 28px;
	top: -6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-12 {
	left: 50%;
	top: -6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-12 em,.arale-tip-1_2_1 .ui-poptip-arrow-12 span
	{
	left: -6px
}

.arale-tip-1_2_1 .ui-poptip-arrow-5 em,.arale-tip-1_2_1 .ui-poptip-arrow-6 em,.arale-tip-1_2_1 .ui-poptip-arrow-7 em
	{
	border-width: 6px 6px 0;
	border-top-color: #ffbb76;
	top: 1px;
	left: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-5 span,.arale-tip-1_2_1 .ui-poptip-arrow-6 span,.arale-tip-1_2_1 .ui-poptip-arrow-7 span
	{
	border-width: 6px 6px 0;
	border-top-color: #FFFCEF
}

.arale-tip-1_2_1 .ui-poptip-arrow-5 {
	right: 28px;
	bottom: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-6 {
	left: 50%;
	bottom: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-7 {
	left: 14px;
	bottom: 0
}

.arale-tip-1_2_1 .ui-poptip-arrow-6 em,.arale-tip-1_2_1 .ui-poptip-arrow-6 span
	{
	left: -6px
}

:root .arale-tip-1_2_1 .ui-poptip-shadow {
	FILTER: none\9
}

.arale-tip-1_2_1 .ui-poptip-blue {
	color: #4d4d4d
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-shadow {
	background-color: rgba(0, 0, 0, .05);
	FILTER: progid : DXImageTransform . Microsoft .
		Gradient(startColorstr = #0c000000, endColorstr = #0c000000)
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-container {
	background-color: #F8FCFF;
	border: 1px solid #B9C8D3
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-10 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-9 em
	{
	border-right-color: #B9C8D3
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-11 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-12 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-1 em
	{
	border-bottom-color: #B9C8D3
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-2 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-3 em
	{
	border-left-color: #B9C8D3
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-5 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-6 em,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-7 em
	{
	border-top-color: #B9C8D3
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-10 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-9 span
	{
	border-right-color: #F8FCFF
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-11 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-12 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-1 span
	{
	border-bottom-color: #F8FCFF
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-2 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-3 span
	{
	border-left-color: #F8FCFF
}

.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-5 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-6 span,.arale-tip-1_2_1 .ui-poptip-blue .ui-poptip-arrow-7 span
	{
	border-top-color: #F8FCFF
}

.arale-tip-1_2_1 .ui-poptip-white {
	color: #333
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-shadow {
	background-color: rgba(0, 0, 0, .05);
	FILTER: progid : DXImageTransform . Microsoft .
		Gradient(startColorstr = #0c000000, endColorstr = #0c000000)
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-container {
	background-color: #fff;
	border: 1px solid #b1b1b1
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-10 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-9 em
	{
	border-right-color: #b1b1b1
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-11 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-12 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-1 em
	{
	border-bottom-color: #b1b1b1
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-2 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-3 em
	{
	border-left-color: #b1b1b1
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-5 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-6 em,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-7 em
	{
	border-top-color: #b1b1b1
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-10 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-9 span
	{
	border-right-color: #fff
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-11 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-12 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-1 span
	{
	border-bottom-color: #fff
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-2 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-3 span
	{
	border-left-color: #fff
}

.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-5 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-6 span,.arale-tip-1_2_1 .ui-poptip-white .ui-poptip-arrow-7 span
	{
	border-top-color: #fff
}

.arale-tip-1_2_1 .ui-poptip {
	top: 0;
	left: 0
}
/*图片加载中div图层，用于遮挡页面*/  
.loadingdiv  
{  
        position:absolute;  
        text-align:center;  
        left:0px;  
        top:0px;  
        z-index:70;  
        background-color:#cccccc;  
        opacity: 0.7;/*透明#CCCCCC*/  
        display:none;  
}
.showTime{
        position:absolute;  
        text-align:center;
        text-size:30px;
        text-color:30px; 
        left:0px;  
        top:0px;  
        z-index:70;  
        background-color:#cccccc;  
        opacity: 0.7;/*透明#CCCCCC*/  
        display:none;  
}
.showTime span{
   position:absolute;
   text-size:30px;
   text-color:white;  
   left:0px;  
   top:0px;  
   z-index:80;  
}     
/*加载中图片*/  
.loadingdiv img  
{  
        position:absolute;  
        left:0px;  
        top:0px;  
        z-index:80;  
}  
</style>
<script>
//确定输入一卡通帐号的唯一性
$(document).ready(function(){
   
  $("#J_tLoginId").focusout(function(){
   var cardno=$('#J_tLoginId').val().trim();
      if(cardno==''){
	   $('#J_tLoginId').focus();    
	   return false;
      }
  });
  $("#J_tLoginId1").focusout(function(){
  
   var cardno=$('#J_tLoginId').val().trim();
   var cardno1=$('#J_tLoginId1').val().trim();
      if(cardno1==''){
	   $("#J_tLoginId1").focus(); 
	   return false;
      }
      if(cardno1==cardno){
       alert("帐号重复,请重新输入");
       $("#J_tLoginId1").val(" ");
        $('#this').focus(); 
       return false;
      }
  });
  $("#J_tLoginId2").focusout(function(){
   var cardno=$('#J_tLoginId').val().trim();
   var cardno1=$('#J_tLoginId1').val().trim();
   var cardno2=$('#J_tLoginId2').val().trim();
   
      if(cardno2==''){
	  $(this).focus();  
	   return false;
      }
      if(cardno2==cardno||cardno2==cardno1){
       alert("帐号重复,请重新输入");
       $("#J_tLoginId2").val(" ");
       return false;
      }
      
  });
  $("#J_tLoginId3").focusout(function(){
   var cardno=$('#J_tLoginId').val().trim();
   var cardno1=$('#J_tLoginId1').val().trim();
   var cardno2=$('#J_tLoginId2').val().trim();
   var cardno3=$('#J_tLoginId3').val().trim();
      if(cardno3==''){
	   $(this).focus();    
	   return false;
      }
      if(cardno3==cardno||cardno2==cardno1||cardno3==cardno2){
       alert("帐号重复,请重新输入");
       $("#J_tLoginId3").val(" ");
       return false;
      }
  });
  $("#J_tLoginId4").focusout(function(){
   var cardno=$('#J_tLoginId').val().trim();
   var cardno1=$('#J_tLoginId1').val().trim();
   var cardno2=$('#J_tLoginId2').val().trim();
   var cardno3=$('#J_tLoginId3').val().trim();
   var cardno4=$('#J_tLoginId4').val().trim();
      if(cardno4==''){
	   $(this).focus(); 
	   return false;
      }
      if(cardno4==cardno||cardno4==cardno1||cardno4==cardno2||cardno4==cardno3){
       alert("帐号重复,请重新输入");
       $("#J_tLoginId4").val(" ");
       return false;
      }
  });
});
 
</script>
<link href="${ctx}/styles/card_files/2ACTshL8Vh.css" rel="stylesheet"			charset="utf-8" />
	</head>
	<body>
		<embed id="umDcp" type="application/alidcp" class="umidWrapper"
			height="1" width="1">
		<div class="topbar">
			<div class="topbar-wrap fn-clear">
				<span class="topbar-link-first">你好，欢迎使用一卡通付款！</span>
			</div>
		</div>
		<div id="loading" class="loadingdiv">  
            <img src="${ctx}/styles/card_files/07.gif" alt="图片加载中···" />  
        </div> 
        <div id="ShowTime" class="showTime">
            <span id="showFont"></span>
        </div> 
		<div id="container">


			<div class="mi-notice mi-notice-success mi-notice-titleonly order-timeout-notice"
				id="J_orderPaySuccessNotice">
				<div class="mi-notice-cnt">
					<div class="mi-notice-title">
						<i class="iconfont" title="支付成功">&#61513;</i>

					</div>
				</div>
			</div>

			<div
				class="mi-notice mi-notice-error mi-notice-titleonly order-timeout-notice"
				id="J_orderDeadlineNotice">
				<div class="mi-notice-cnt">
					<div class="mi-notice-title">
						<i class="iconfont" title="交易超时">&#61509;</i>

						<h3>
							抱歉，您的交易因超时已失败。
						</h3>

						<p class="mi-notice-explain-other">
							您订单的最晚付款时间为：
							<span id="J_orderDeadline"></span>，目前已过期，交易关闭。
						</p>
					</div>
				</div>
			</div>
			<style type="text/css">
.umidWrapper {
	display: block;
	height: 1px;
}
</style>
			 
			<!-- CMS:cms/监控埋点/um结束:tracker/um.vm -->
			<div id="content" class="fn-clear">
				<div id="J_order"
					data-module="excashier/login/1.0.20140801/orderDetail"
					data-mode="SYNC" data-url="">

					<div id="order" data-role="order" class="order order-bow">
						<div class="orderDetail-base" data-role="J_orderDetailBase">
							<div class="order-extand-explain fn-clear">
								<span class="fn-left explain-trigger-area order-type-navigator"
									style="cursor: auto" data-role="J_orderTypeQuestion"> <span
									data-role="J_questionIcon" seed="order-type-detail"
									style="cursor: pointer"></span> </span>
							</div>
							<span style="display: block;" class="payAmount-area"
								id="J_basePriceArea"> <strong class=" amount-font-22 ">${saleOrder.orderMoney}</strong>
								元 </span>
						</div>
						<span style="display: block;" class="orderDetail-more-link"
							data-role="J_oderDetailMore"> <em class="more-arrow"></em>
							<a href="#orderList" class="j-orderDetail-more"
							seed="order-detail-more">订单详情</a> </span>
						<div style="display: none; top: 44.5px; left: 0px;"
							class="ui-detail fn-hide" data-role="J_orderDetailCnt"
							id="J-orderDetail">
							<div class="ajax-Account od-more-cnt fn-clear">
								<div class="first  long-content">
									DH201409150748
								</div>
								<ul class="order-detail-container">
									<li class="order-item">
										<table>
											<tbody>
												<tr>
													<th class="sub-th">
														收款方：
													</th>
													<td>
														航天通信专用有限公司
													</td>
												</tr>
												<tr>
													<th class="sub-th">
														订单号：
													</th>
													<td>
														DH201409150748
													</td>
												</tr>
												<tr>
													<th class="sub-th">
														商品名称：
													</th>
													<td>
														<a smartracker="on" seed="orderItem-DH201409150748"
															href="http://www.sinokj.com/" target="_blank">DH201409150748</a>
													</td>
												</tr>
												<tr>
													<th class="sub-th">
														商品描述：
													</th>
													<td>
														DH201409150748
													</td>
												</tr>
												<tr>
													<th class="sub-th">
														交易金额：
													</th>
													<td>
													   ${saleOrder.orderMoney}
													</td>
												</tr>
											</tbody>
										</table>


									</li>
								</ul>
							</div>
							<span class="payAmount-area"> <strong
								class=" amount-font-22 ">${saleOrder.orderMoney}</strong>元 </span>
							<iframe style="height: 169px; width: 950px;" src="javascript:''"
								class="ui-detail-iframe-fix" data-role="J_orderDetailFrameFix"></iframe>
						</div>
						 
					</div>



				</div>

				<div class="login-switchable-container">
					<ul style="width: 1888px;" class="login-switchable fn-clear" id="J_Switchable">
						<li style="width: 944px;" class="login-switchable-item"
							id="J_loginPwdMemberT">
								<div id="teLogin" class="fn-clear">
									<div id="teLogin-left" class="teBox">

										<div class="teBox-in">
											<div class="login-title-area">
												<div class="login-title">
													<div class="login-title-left">
														<p class="lt-text ft-yh">
															一卡通账户付款
														</p>														
													</div>
												</div>
											</div>
                                            <div id="add">
                                                    
											</div>  
											<div class="teForm">
												<div class="login-panel" id="login-panel">

										          <!-- -----------------1个 -->
                                                  <div class="mi-form-item commonAccountContainer quick-empty-parent"
														id="J_commonAccountContainer">
														<label class="mi-label">
															账户名：
														</label>
														<span class="user-login-account fn-hide"></span>
														<input data-explain="" autocomplete="off" name="loginId"
															class="mi-input mi-input-account" id="J_tLoginId"
															seed="tAccountInput" placeholder="一卡通号" type="text" />
														 
													</div>
													<div class="mi-form-item" id="J_fakePwdContainer">
														<label class="mi-label">
															支付密码：
														</label>
														<span> <input name="pwd"
																class="mi-input mi-input-account fake-pwd-input"
																id="J_fakePasswordInput" seed="fakePwdInput"
																type="password" /> </span>

														<div class="mi-form-explain">
															<p>
																请输入
																<span class="ft-red">一卡通密码</span>，不是登录密码。
															</p>
														</div>
													</div>
													<!-- -----------------2个 -->
													<div class="mi-form-item commonAccountContainer quick-empty-parent"
														id="J_commonAccountContainer1" style="display:none;">
														<label class="mi-label">
															账户名：
														</label>
														<span class="user-login-account fn-hide"></span>
														<input data-explain="" autocomplete="off" name="loginId"
															class="mi-input mi-input-account" id="J_tLoginId1"
															seed="tAccountInput" placeholder="一卡通号" type="text" />
														 
													</div>
													<div class="mi-form-item" id="J_fakePwdContainer1" style="display:none;">
														<label class="mi-label">
															支付密码：
														</label>
														<span> <input name="pwd"
																class="mi-input mi-input-account fake-pwd-input"
																id="J_fakePasswordInput1" seed="fakePwdInput"
																type="password" /> </span>

														<div class="mi-form-explain">
															<p>
																请输入
																<span class="ft-red">一卡通密码</span>，不是登录密码。
															</p>
														</div>
													</div>

													<!-- -----------------3个 -->
													<div class="mi-form-item commonAccountContainer quick-empty-parent"
														id="J_commonAccountContainer2" style="display:none;">
														<label class="mi-label">
															账户名：
														</label>
														<span class="user-login-account fn-hide"></span>
														<input data-explain="" autocomplete="off" name="loginId"
															class="mi-input mi-input-account" id="J_tLoginId2"
															seed="tAccountInput" placeholder="一卡通号" type="text" />
														 
													</div>
													<div class="mi-form-item" id="J_fakePwdContainer2" style="display:none;">
														<label class="mi-label">
															支付密码：
														</label>
														<span> <input name="pwd"
																class="mi-input mi-input-account fake-pwd-input"
																id="J_fakePasswordInput2" seed="fakePwdInput"
																type="password" /> </span>

														<div class="mi-form-explain">
															<p>
																请输入
																<span class="ft-red">一卡通密码</span>，不是登录密码。
															</p>
														</div>
													</div>
													<!-- -----------------4个 -->
													<div class="mi-form-item commonAccountContainer quick-empty-parent"
														id="J_commonAccountContainer3" style="display:none;">
														<label class="mi-label">
															账户名：
														</label>
														<span class="user-login-account fn-hide"></span>
														<input data-explain="" autocomplete="off" name="loginId"
															class="mi-input mi-input-account" id="J_tLoginId3"
															seed="tAccountInput" placeholder="一卡通号" type="text" />
														 
													</div>
													<div class="mi-form-item" id="J_fakePwdContainer3" style="display:none;">
														<label class="mi-label">
															支付密码：
														</label>
														<span> <input name="pwd"
																class="mi-input mi-input-account fake-pwd-input"
																id="J_fakePasswordInput3" seed="fakePwdInput"
																type="password" /> </span>

														<div class="mi-form-explain">
															<p>
																请输入
																<span class="ft-red">一卡通密码</span>，不是登录密码。
															</p>
														</div>
													</div>
													<!-- -----------------5个 -->
													<div class="mi-form-item commonAccountContainer quick-empty-parent"
														id="J_commonAccountContainer4" style="display:none;">
														<label class="mi-label">
															账户名：
														</label>
														<span class="user-login-account fn-hide"></span>
														<input data-explain="" autocomplete="off" name="loginId"
															class="mi-input mi-input-account" id="J_tLoginId4"
															seed="tAccountInput" placeholder="一卡通号" type="text" />
														 
													</div>
													<div class="mi-form-item" id="J_fakePwdContainer4" style="display:none;">
														<label class="mi-label">
															支付密码：
														</label>
														<span> <input name="pwd"
																class="mi-input mi-input-account fake-pwd-input"
																id="J_fakePasswordInput4" seed="fakePwdInput"
																type="password" /> </span>

														<div class="mi-form-explain">
															<p>
																请输入
																<span class="ft-red">一卡通密码</span>，不是登录密码。
															</p>
														</div>
													</div> 

													<div class="submitContainer fn-clear">
														<div class="t-contract-container fn-left">

														</div>

														<div class="left-submitContainer fn-left">
															<a href="javascript:void(0);"
																class="newBtn-orange newBtn-long" id="J_newBtn"
																data-role="submitBtn" seed="tAccountSubmit"
																data-defaulttext="支付" data-submittext="支付中..."
																onclick="pay('${saleOrder.id}')"> <span>支付</span>
															</a>
														</div>
													</div>


												</div>

											</div>
										</div>
									</div>

								</div>
							</div>
				</div>
			</div>


			<!-- teLogin -->


		 

		<li style="width: 944px;" class="login-switchable-item"></li>
		<!-- CMS:安全核心/API入口/rds开始:securitycore/entrance/rds.vm -->


		<script type="text/javascript">
    var form_tk = "gUBMybLicPHmk16vzEa8OWl2doyjTEDS";
    var json_ua = null;
  </script>
		<!-- CMS:全站公共 cms/全站底部/在线客服新埋点区块开始:alipay/foot/cliveService.vm -->
		<div style="display: none">
			onlineServer
		</div>


		<div id="footer">
			<!-- CMS:cms/全站底部/alipay_foot_copyright_vm开始:foot/copyright.vm -->
<style>
.copyright,.copyright a,.copyright a:hover {
	color: #808080;
}
</style>
			<div class="copyright">
				航天通信专用版权所有 2004-2014
				<a smartracker="on" seed="copyright-link"
					href="www.hao123.com" target="_blank">ICP证：京B2-20120045</a>
			</div>
			<div class="server" id="ServerNum">
				excashier-70-35 &nbsp;
			</div>
			<!-- CMS:cms/全站底部/alipay_foot_copyright_vm结束:foot/copyright.vm -->
		</div>
		<!-- /container -->

	</body>
</html>
