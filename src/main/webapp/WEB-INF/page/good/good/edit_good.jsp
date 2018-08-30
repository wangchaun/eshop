<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑商品</title>
	<%@ include file="/commons/meta.jsp" %>
	<%@ include file="/commons/taglibs.jsp" %>
	
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/b2bBlue/easyui.css">
<!--	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">	-->
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/good/edit_good.js"></script>
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/common/upload.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/ckeditor/ckeditor.js"></script>
	<script language="JavaScript" type="text/javascript" src="${ctx}/scripts/framework/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
    <table border="0" cellspacing="0" cellpadding="0" class="gdcn-table-E">
    	<tr>
    		<td class="gdcn-table-D">
				<div class="tab-pane" id="tabPane1" style="margin: 10px 10px 10px 10px;">
					<form id="goodForm" method="post" action="">
			    		<s:hidden name="good.id" id="id" />
			    		<s:hidden name="goodExtend.id" />
			    		<s:hidden name="good.creatorId" />
			    		<s:hidden name="good.creatorName" />
			    		<s:hidden name="good.createTime" />
			    		<s:hidden name="good.modifierId" />
			    		<s:hidden name="good.modifierName" />
			    		<s:hidden name="good.modifyTime" />
			    		<s:hidden name="good.state" />
			    		<s:hidden name="good.totalNum" />
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		<input type="hidden" name="good.warehousePositionId" id="warehousePositionId" value=""/>
						<input type="hidden" name="good.warehouseId" id="warehouseId" value=""/>
									
									
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
							<div title="基本信息" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	  <tr></tr>
						    	   <tr>
										<td class='gridtitle' width="15%">商品编号:</td>
										<td class='gridbody'>
											<input name="good.code" id="code" onchange="checkeCode(this.value)" value="${good.code }"/><font color="red">*</font>
										</td>
										<td class='gridtitle'>商品名称:</td>
										<td class='gridbody'>
											<s:textfield name="good.name" id="name"/><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>商品类别:</td>
										<td class='gridbody'>
											<s:textfield name="good.goodTypeName" id="goodTypeName" onclick="selectType(this)" readonly="true"/><font color="red">*</font>
											<s:hidden name="good.goodTypeId" id="goodTypeId" />
										</td>
										<td  class='gridtitle'>商品品牌:</td>
										<td class='gridbody'>
											<s:textfield name="good.brandName" id="brandName" onclick="selectBrand(this)" readonly="true"/><font color="red">*</font>
											<s:hidden name="good.brandId" id="brandId" />
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>销售价:</td>
										<td class='gridbody'>
											<s:textfield name="good.price" id="price" onchange="common.checkNumber(this);" /><font color="red">*</font>
										</td>
										<td  class='gridtitle'>市场价:</td>
										<td class='gridbody'><s:textfield  name="good.priceMarket" id="priceMarket" onchange="common.checkNumber(this);"/><font color="red">*</font></td>
									</tr>
									<tr>
										<td  class='gridtitle'>商品类型:</td>
										<td class='gridbody'>
											<select name="good.isInventory" id="isInventory" onchange="changeValue(this.value)">
								                <option value="0" <c:if test="${good.isInventory == '0'}">selected</c:if> >普通商品</option>
								                 <!--<option value="1" <c:if test="${good.isInventory == '1'}">selected</c:if> >团购商品</option>
								                <option value="2" <c:if test="${good.isInventory == '2'}">selected</c:if> >抢购商品</option>
								                <option value="3" <c:if test="${good.isInventory == '3'}">selected</c:if> >秒杀商品</option>
								              <option value="4" <c:if test="${good.isInventory == '4'}">selected</c:if> >特殊商品</option> -->
								            </select>
										</td>
										<td  class='gridtitle'>是否下期商品:</td>
										<td class='gridbody'>
											&nbsp;&nbsp;
											是<input type="radio" name="good.isNext" id="indexShow" value="1" <c:if test="${good.isNext == '1'}">checked="checked"</c:if> /> 
											&nbsp;&nbsp;									
											否<input type="radio" name="good.isNext" id="indexShow" value="0" <c:if test="${good.isNext == '0'||good.isNext == null}">checked="checked"</c:if>/>
											
										</td>
									</tr>
									<tr>
										<td class='gridtitle'>月销量</td>
										<td class='gridbody'><s:textfield  name="good.initialNum" id="initialNum"  /><font color='red'>*</font></td>		
										<td  class='gridtitle'>是否显示首页:</td>
										<td class='gridbody'>
											&nbsp;&nbsp;
											是<input type="radio" name="good.indexShow" id="indexShow" value="1" <c:if test="${good.indexShow == '1'}">checked="checked"</c:if> /> 
											&nbsp;&nbsp;									
											否<input type="radio" name="good.indexShow" id="indexShow" value="0" <c:if test="${good.indexShow == '0'||good.indexShow == null}">checked="checked"</c:if>/>
										</td>
									</tr>
									<!-- 
									<c:if test="${good.id==null}">
										<tr>	
											<td class='gridtitle'>仓库设置</td>
											<td class='gridbody'><s:textfield  name="good.warehouseName" id="warehouseName" onclick="selectWarehouse()"  /><font color='red'>*</font></td>	
											<td class='gridtitle'>仓位设置</td>
											<td class='gridbody'><s:textfield  name="good.warehousePositionName" id="warehousePositionName" onclick="selectWarehousePosition()"  /><font color='red'>*</font></td>																					
										</tr>
									</c:if>
									-->
									<tr>
									    <td class='gridtitle'>商品属性</td>
										<td class='gridbody' colspan="5">
											<select name="good.property" id="property" onchange="ChekeisQgGood()">
												<option value="">-- 请选择商品属性 --</option>
												<option value="1" <c:if test="${good.property == '1'}">selected</c:if> >热卖商品</option>
												<option value="2" <c:if test="${good.property == '2'}">selected</c:if> >新品上架</option>
												<option value="3" <c:if test="${good.property == '3'}">selected</c:if> >猜您喜欢</option>
												<option value="4" <c:if test="${good.property == '4'}">selected</c:if> >最新降价</option>
												<option value="5" <c:if test="${good.property == '5'}">selected</c:if> >今日推荐</option>
											</select>										
										</td>
									</tr>
									
									
									<tr></tr>
									<c:if test="${good.isInventory=='0' || good.id==''}">
										<tr>
											<td  class='gridtitle'>特价(团购/抢购/秒杀):</td>
											<td class='gridbody' colspan="5">
												<input  name="good.priceGroupBuy" id="priceGroupBuy" onchange="common.checkNumber(this);" disabled="disabled" /><span id="groupBuy" style="display:none;"><font color='red'>*</font></span>
											</td>
										</tr>
										<tr>
										<td  class='gridtitle'>抢购/秒杀数量:</td>
											<td class='gridbody' colspan="5"><input type="text" name="good.activitNumber" id="totalNum" value="${good.activitNumber }" disabled="disabled" /> </td>
										</tr>
										<tr>
											<td  class='gridtitle'>活动开始时间:</td>
											<td class='gridbody'>
										    	<input type="text" name="good.beginTime" id="beginTime" readonly="true" 
										    		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${good.beginTime}" />" disabled="disabled" />
											</td>
											<td  class='gridtitle'>活动结束时间:</td>
											<td class='gridbody' colspan="3">
										    	<input type="text" name="good.endTime" id="endTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${good.endTime}" />" disabled="disabled" />
											</td>
										</tr>
									</c:if>
									<c:if test="${good.isInventory!='0'}">
											<tr>
												<td  class='gridtitle'>特价(团购/抢购/秒杀):</td>
												<td class='gridbody' colspan="5">
													<input  name="good.priceGroupBuy" id="priceGroupBuy" value="${good.priceGroupBuy }" onchange="common.checkNumber(this);" /><font color="red">*</font>
												</td>
											</tr>
											<tr>
											<td  class='gridtitle'>抢购/秒杀数量:</td>
												<td class='gridbody' colspan="5"><input type="text" name="good.activitNumber" id="totalNum" value="${good.activitNumber }" /><font color="red">*</font> </td>
											</tr>
											<tr>
												<td  class='gridtitle'>活动开始时间:</td>
												<td class='gridbody'>
											    	<input type="text" name="good.beginTime" id="beginTime" readonly="true" 
											    		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
											    		 	value="${good.beginTime}" />" /><font color="red">*</font>
												</td>
												<td  class='gridtitle'>活动结束时间:</td>
												<td class='gridbody' colspan="3">
											    	<input type="text" name="good.endTime" id="endTime" readonly="true" 
											    	onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
											    		value="${good.endTime}" />" /><font color="red">*</font>
												</td>
											</tr>
									</c:if>
									
									<tr>
										<td class='gridtitle'>上传商品缩略图:</td>
										<td class='gridbody' colspan="3">
											<a href="javascript:void(0);" onclick="upload.open(this,'Good')">上传</a>
											<c:if test="${good.pic != null && good.pic != ''}">
												<img id="pic" border="0" src="${ctx}${good.pic }" width="130px" height="130px"/>
												&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
											</c:if>
											<input type="hidden" name="picId" id="fileUploadId" value="${good.picId}" /><%-- name必须为fileUploadId --%>
											<input type="hidden" name="pic" id="picPath" value="${good.pic }" class="picPath">
										</td>
									</tr>
									<tr>
										<td class='gridtitle'>备注:</td>
										<td class='gridbody' colspan="3">
											<s:textarea id="remark" name="good.remark" cols="100" rows="3"/>
										</td>
									</tr>
								</table>
							</div>
							
							<div title="详细信息" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	    	
									<tr>
										<td  class='gridtitle'>商品简介:</td>
										<td class='gridbody'>
											<s:textarea name="goodExtend.introBrief" id="introBrief" cols="60" rows="3"/>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>商品详情:</td>
										<td class='gridbody' >
											<textarea id="intro" name="goodExtend.intro" cols="60" rows="10">${goodExtend.intro}&nbsp;</textarea>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>规格参数:</td>
										<td class='gridbody' >
											<textarea id="introWholesale" name="goodExtend.introWholesale" cols="60" rows="10">${goodExtend.introWholesale}&nbsp;</textarea>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>包装清单:</td>
										<td class='gridbody' >
											<textarea id="introDelivery" name="goodExtend.introDelivery" cols="60" rows="10">${goodExtend.introDelivery}&nbsp;</textarea>
										</td>
									</tr>
										<tr>
										<td  class='gridtitle'>售后服务:</td>
										<td class='gridbody' >
											<textarea id="afterSale" name="goodExtend.afterSale" cols="60" rows="10">${goodExtend.afterSale}&nbsp;</textarea>
										</td>
									</tr>
									
										<tr>
										<td  class='gridtitle'>实用指南:</td>
										<td class='gridbody' >
											<textarea id="practiceGuidelinesFAQS" name="goodExtend.practiceGuidelinesFAQS" cols="60" rows="10">${goodExtend.practiceGuidelinesFAQS}&nbsp;</textarea>
										</td>
									</tr>
		
								</table>
							</div>
							
							<div title="商品种类属性设置" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
									<tr>
										<td  class='gridtitle' width="20%">商品种类:</td>
										<td class='gridbody'>
											<s:select name="goodKind" id="goodKind" list="goodKindList"  listValue="name" listKey="id"  
											     value="good.goodKindId" onchange="showAttr(this)" headerKey="00" headerValue="请选择种类"></s:select> 
											<span style="margin-left:50px;" style="display:none;"><a href="javascript:void(0);" onclick="removeProp()"><font color="red">清空属性</font></a></span> 
										</td>
									</tr>
									<tr></tr>
									<input type="hidden" id="goodAttrIdStr" value="${goodAttrIdStr}" size="100"/>
									<input type="hidden" id="goodAttrValStr" />
									<c:forEach items="${goodAttrList}" var="goodAttr" varStatus="i">
										<input type="hidden" name="${goodAttr.id}" id="hidden${goodAttr.id}" value="${goodAttr.attrValue}"/>
									</c:forEach>
								</table>
								<div id="attrList"></div>
							</div>
							
							
								<!-- 
									<div title="区域价格设置" style="padding:10px; display:none;" id="Areaprice" >
										<table id="pricetab" width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
										<tr>
											<td class='gridtitle' colspan="9"><a href="javascript:void(0)" onclick="AreaOfPrice()">新增</a></td>
										</tr>
										<c:forEach items="${goodPriceList}" var="goodPrice" varStatus="i">
											<tr>
												<td  class='gridtitle'  width="10%">区域</td>
												<td class='gridbody'>
													<input type="hidden" name="areaIdArr" value="${goodPrice.areaId }"/>
													<input type="text" name="areaNameArr" value="${goodPrice.areaName }" onclick="selectArea(this)"/>
												</td>
												
												<td  class='gridtitle'  width="10%">价格</td>
												<td class='gridbody'>
													<input type="text" name="priceArr" value="${goodPrice.price }"/>
												</td>
												<td  class='gridtitle'  width="10%">属性</td>
												<td class='gridbody'>
													<select name="propertyArr">
														<option value="">-- 请选择商品属性 --</option>
														<option value="2" <c:if test="${goodPrice.property=='2'}">selected</c:if>>热卖商品</option>
														<option value="3" <c:if test="${goodPrice.property=='3'}">selected</c:if>>热评商品</option>
														<option value="4" <c:if test="${goodPrice.property=='4'}">selected</c:if>>新品上架</option>
														<option value="5" <c:if test="${goodPrice.property=='5'}">selected</c:if>>猜您喜欢</option>
														<option value="7" <c:if test="${goodPrice.property=='7'}">selected</c:if>>自定义商品</option>
														<option value="8" <c:if test="${goodPrice.property=='8'}">selected</c:if>>最新降价</option>
														<option value="9" <c:if test="${goodPrice.property=='9'}">selected</c:if>>今日推荐</option>
													</select>
												</td>
												<td  class='gridtitle'  width="10%">自定义标签</td>
												<td class='gridbody'>
													<input type="text" name="tagArr" value="${goodPrice.tag }"/>
												</td>
												
												<input type="hidden" name="stateArr" value="s"/>
												<td class='gridtitle'  width="10%"><a href="#" onclick="removeRow(this.parentNode.parentNode)">删除</a></td>												
											</tr>
										</c:forEach>    	
										</table>
									</div>
								 -->
							
							
							<div title="商品规格" style="padding:10px;">
								<c:if test="${goodSpecificationList == null}">
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="showSpecification()">选择规格项</a>
								<br><br>
								说明： 1、没有规格则默认生成一个货品;2、编号为空则自动生成编号，以商品的编号+“-”+序号;<br><br>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--3、浮动金额是在商品销售价的基础上增加或减少;-->3、规格一旦设定不可更改，可另建商品。<br><br> 
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、<font color="red">库存总和请与“基本信息”中的‘初始数量’相等;</font>
								</c:if>
								<div id="wareList">
								<c:if test="${goodSpecificationList != null}">
									<table width='80%' border='1' cellpadding='0' cellspacing='1' class='gdcn-table-bgcolor' style='margin-top: 10px;'>
										<thead>
											<!-- <th width='15%'>货号</th> -->
											<c:forEach items="${goodSpecificationList}" var="goodSpecification">
											<th width='10%'>${goodSpecification.name}</th>
											</c:forEach>
											<th width='10%'>库存</th>
											<th width='2%'>商城价</th>
											<th width='2%'>市场价</th> 
											<th width='10%'>图片</th>
											<th width='8%'>操作</th>
										</thead>
										<c:forEach items="${wareList}" var="ware">
											<c:if test="${ware.showwhether}">
												<tr>
													<input type="hidden" name="wareIdStr" value="${ware.id}"/>
												    <input type='hidden' name='wareCodeArr' value="${ware.code}">
													
													<c:if test="${ware.goodSpecificationVal1 != null}">
													<td class='gridbody' style='text-align: center;'>${ware.goodSpecificationVal1}
														<input type='hidden' name='wareSpecificationValId1Arr' value="${ware.goodSpecificationValId1}"></td>
													</c:if>
													<c:if test="${ware.goodSpecificationVal2 != null}">
													<td class='gridbody' style='text-align: center;'>${ware.goodSpecificationVal2}
														<input type='hidden' name='wareSpecificationValId2Arr' value="${ware.goodSpecificationValId2}"></td>
													</c:if>
													<c:if test="${ware.goodSpecificationVal3 != null}">
													<td class='gridbody' style='text-align: center;'>${ware.goodSpecificationVal3}
														<input type='hidden' name='wareSpecificationValId3Arr' value="${ware.goodSpecificationValId3}"></td>
													</c:if>
													<td class='gridbody' style='text-align: center;'><input type='text' name='stockArr' size='10' value="${ware.stock}"></td>
													<td class='gridbody' style='text-align: center;'><input type='text' name='priceShopArr' size='10' value="${ware.priceShop}"></td>
													<td class='gridbody' style='text-align: center;'><input type='text' name='priceMarketArr' size='10' value="${ware.priceMarket}"></td>
													<td class='gridbody' style='text-align: center;'>
														<a href="javascript:void(0);" onclick="upload.open(this,'Ware')">上传</a>
														<c:if test="${ware.pic != null && ware.pic  != ''}">
															<img id="pic" border="0" src="${ctx}${ware.pic}" width="40px" height="50px"/>
															&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
														</c:if>
														<input type='hidden' name='picIdWareArr' id='fileUploadId' value='${ware.picId}' />
														<input type='hidden' name='picWareArr' id='picPath' value='${ware.pic }' class='picPath'>
													</td> 
												
													<td class='gridbody' style='text-align: center;'><a href='javascript:void(0)' class='deleteWare' onclick="deleteWare(this)">删除</a></td>
												</tr>
											</c:if>
										</c:forEach>
										
									</table>
								</c:if>
								</div>
								<c:if test="${goodSpecificationList != null}">
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="showSpecification2()">增加规格项</a>
								&nbsp;&nbsp;<font color="red">要增加的规格项库存需为0,否则可能造成该商品的期初数据不准确</font>
								<div id="wareList2">
												<br><br>
												说明： 1、没有规格则默认生成一个货品;2、编号为空则自动生成编号，以商品的编号+“-”+序号;<br><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、规格一旦设定不可更改，可另建商品。<br><br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、如有选中要上传图片的规格，当规格值出现相同时，可只上传1张图片(也可全部都上传)<br><br>
								</div>
								</c:if>
							</div>
							
								<div title="搜索引擎SEO优化" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	  
									<tr>
										<td  class='gridtitle'>商品页面标题:</td>
										<td class='gridbody'>
											<s:textfield name="goodExtend.seoTitle" id="seoTitle" size="60"/>(留空则默认显示商品名称)
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>META_KEYWORDS(页面关键词):</td>
										<td class='gridbody' >
											<s:textarea name="goodExtend.seoKeywords" id="seoKeywords" cols="60" rows="3"/>(留空则默认继承全局设置的KEYWORDS内容)
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>META_DESCRIPTION(页面描述):</td>
										<td class='gridbody' >
											<s:textarea  name="goodExtend.seoDescription" id="seoDescription" cols="60" rows="3"/>(留空则默认继承全局设置的DESCRIPTION内容)
										</td>
									</tr>
								</table>							
							</div>
							
							<div title="商品相册" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	 
									<c:forEach items="${goodPicList}" var="goodPic" varStatus="m"> 	
									<tr>
										<td  class='gridtitle'  width="10%">上传商品图片${m.index + 1}:</td>
										<td class='gridbody'>
											<a href="javascript:void(0);" onclick="upload.open(this,'GoodAlbum')">上传</a>
											<c:if test="${goodPic.relativePath != null && goodPic.relativePath  != ''}">
												<img id="pic" border="0" src="${ctx}${goodPic.relativePath }" width="130px" height="130px"/>
												&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
											</c:if>
											<input type="hidden" name="picIdArr" id="fileUploadId" value="${goodPic.id}" /><%-- id必须为fileUploadId --%>
											<input type="hidden" name="picArr" id="picPath" value="${goodPic.relativePath }" class="picPath">
										</td>
									</tr>
									</c:forEach>  
								</table>
							</div>	
							
							<div title="相关商品" style="padding:10px;">
								<table width="80%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor" style="margin-top: 10px;">
									<thead>
										<th width="10%">
											<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="addGoodRelate()">添加</a>
										</th>
										<th width="15%">编号</th>
										<th width="15%">品名</th>
										<th width="15%">类别</th>
										<th width="15%">品牌</th>
										<th width="10%">价格</th>
									</thead>
									<input type="hidden" id="goodRelateIdStr" value="${goodRelateIdStr}"/>
									<tbody id="goodRelateList">
										<c:forEach items="${goodRelateList}" var="goodRelate" >
											<tr>
												 <input type="hidden"  name="goodRelateIdArr" value="${goodRelate.relateGoodId}" />
												 <td class="gridbody" style="text-align: center;">
												 	<a href="javascript:void(0);"   onclick="deleteGoodRelate(this)">删除</a>
												 </td>
												 <td class="gridbody" style="text-align: center;">${goodRelate.code}</td>
												 <td class="gridbody" style="text-align: center;">${goodRelate.name}</td>
												 <td class="gridbody" style="text-align: center;">${goodRelate.goodTypeName}</td>
												 <td class="gridbody" style="text-align: center;">${goodRelate.brandName}</td>
												 <td class="gridbody" style="text-align: center;">${goodRelate.price}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>	
							<div title="组合销售设置" style="padding:10px;">
								<table width="80%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
									<thead>
										<th width="10%">
											<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="addGoodCompose()">添加</a>
										</th>
										<th width="10%">编号</th>
										<th width="15%">品名</th>
										<th width="15%">类别</th>
										<th width="15%">品牌</th>
										<th width="10%">价格</th>
										<th width="10%">优惠金额</th>
									</thead>
									<input type="hidden" id="goodComposeIdStr" value="${goodComposeIdStr}"/>
									<tbody id="goodComposeList">
										<c:forEach items="${goodComposeList}" var="goodCompose" >
											<tr>
												 <input type="hidden"  name="goodComposeIdArr" value="${goodCompose.composeGoodId}" />
												 <td class="gridbody" style="text-align: center;">
												 	<a href="javascript:void(0);"   onclick="deleteGoodCompose(this)">删除</a>
												 </td>
												 <td class="gridbody" style="text-align: center;">${goodCompose.code}</td>
												 <td class="gridbody" style="text-align: center;">${goodCompose.name}</td>
												 <td class="gridbody" style="text-align: center;">${goodCompose.goodTypeName}</td>
												 <td class="gridbody" style="text-align: center;">${goodCompose.brandName}</td>
												 <td class="gridbody" style="text-align: center;">${goodCompose.price}</td>
												 <td class="gridbody" >
												 	<input type="text" style="text-align: center;" size="10" name="goodComposePriceDisArr" value="${goodCompose.priceDiscount}"/>
												 </td>
											</tr>
										</c:forEach>
									</tbody>    	
								</table>
							</div>																		
						</div>
						<center>
							<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" onclick="submitSaveForm()">保存</a>
						</center>
					</form>
				</div>
	    	</td>
	    </tr>
	</table>
</body>
</html>

