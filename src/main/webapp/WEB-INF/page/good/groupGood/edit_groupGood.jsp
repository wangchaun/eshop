<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>编辑团购/抢购/秒杀商品</title>
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
	<script language="javascript" type="text/javascript" src="${ctx}/scripts/good/groupGood/edit_groupGood.js"></script>
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
			    		<s:hidden name="groupgood.id" id="id" />
			    		<s:hidden name="goodExtend.id" />
			    		<s:hidden name="groupgood.creatorId" />
			    		<s:hidden name="groupgood.creatorName" />
			    		<s:hidden name="groupgood.createTime" />
			    		<s:hidden name="groupgood.modifierId" />
			    		<s:hidden name="groupgood.modifierName" />
			    		<s:hidden name="groupgood.modifyTime" />
			    		<s:hidden name="groupgood.state" />
			    		<s:hidden name="imgIdStr" id="imgIdStr"/>
			    		<input type="hidden" name="" id="isInventory" value="1"/><!-- 商品类型，添加商品是判断商品类型、商品品牌的类型 -->	
			    		<input type="hidden" name="groupgood.warehousePositionId" id="warehousePositionId" value=""/>
						<input type="hidden" name="groupgood.warehouseId" id="warehouseId" value=""/>					
									
			    		<div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:300px;">
							<div title="基本信息" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">
						    	  <tr></tr>
						    	   <tr>
										<td class='gridtitle' width="15%">商品编号:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.code" readonly="true"/>
										</td>
										<td class='gridtitle'>商品名称:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.name" id="name"/><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>商品类别:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.goodTypeName" id="goodTypeName" onclick="selectType(this)" readonly="true"/><font color="red">*</font>
											<s:hidden name="groupgood.goodTypeId" id="goodTypeId" />
										</td>
										<td  class='gridtitle'>商品品牌:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.brandName" id="brandName" onclick="selectBrand(this)" readonly="true"/>
											<s:hidden name="groupgood.brandId" id="brandId" />
										</td>
									</tr>
									<tr>
										<td  class='gridtitle'>单位:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.unit" id="unit" />
										</td>
										<td  class='gridtitle'>标签:</td>
										<td class='gridbody'><s:textfield  name="groupgood.tag" id="tag"/></td>
									</tr>
									<tr>
										<td  class='gridtitle'>条形码:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.barcode" id="barcode" />
										</td>
										<td  class='gridtitle'>是否首页显示:</td>
										<td class='gridbody'>
											&nbsp;&nbsp;
											是<input type="radio" name="groupgood.indexShow" id="indexShow" value="1" <c:if test="${groupgood.indexShow == '1'}">checked="checked"</c:if> /> 
											&nbsp;&nbsp;									
											否<input type="radio" name="groupgood.indexShow" id="indexShow" value="0" <c:if test="${groupgood.indexShow == '0'||groupgood.indexShow == null}">checked="checked"</c:if>/>
										</td>
									</tr>
									
									<tr></tr>
									
										<tr>
								     		<td  class='gridtitle'>商品类型:</td>
											<td class='gridbody'>
												<input type="hidden" id="isInventoryStr" name="groupgood.isInventory" value="${groupgood.isInventory }"/>
										    	<c:if test="${groupgood.id==null}">
										    		<select onchange="changeIsInventory(this.value)">
											    		<option value="请选择商品类型">--请选择商品类型--</option>
											    		<option value="1">团购商品</option>
											    		<option value="2">抢购商品</option>
											    		<option value="3">秒杀商品</option>
											    	</select>
										    	</c:if>
										    	<c:if test="${groupgood.id!=null}">
										    		<c:if test="${groupgood.isInventory=='1'}">
										    			<select onchange="changeIsInventory(this.value)">
												    		<option value="1" selected="selected">团购商品</option>
												    		<option value="2">抢购商品</option>
												    		<option value="3">秒杀商品</option>
												    	</select>
										    		</c:if>
										    		<c:if test="${groupgood.isInventory=='2'}">
										    			<select onchange="changeIsInventory(this.value)">
												    		<option value="1">团购商品</option>
												    		<option value="2" selected="selected">抢购商品</option>
												    		<option value="3">秒杀商品</option>
												    	</select>
										    		</c:if>
										    		<c:if test="${groupgood.isInventory=='3'}">
										    			<select onchange="changeIsInventory(this.value)">
												    		<option value="1">团购商品</option>
												    		<option value="2">抢购商品</option>
												    		<option value="3" selected="selected">秒杀商品</option>
												    	</select>
										    		</c:if>
										    	</c:if>
										`	</td>
											<td  class='gridtitle'>兑换积分:</td>
										<td class='gridbody'><s:textfield  name="groupgood.credits" id="credits" /></td>
										</tr>
									<tr>
										<td  class='gridtitle' id="pricesStr">销售价:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.price" id="price" onchange="common.checkNumber(this);" /><font color="red">*</font>
										</td>
										<td  class='gridtitle'>总销量:</td>
										<td class='gridbody'><s:textfield  name="groupgood.totalSales" id="totalSales" readonly="true"/></td>
									</tr>
									<tr>
										<td  class='gridtitle'>市场价:</td>
										<td class='gridbody'><s:textfield  name="groupgood.priceMarket" id="priceMarket" onchange="common.checkNumber(this);"/></td>
										<td  class='gridtitle'>团购价:</td>
										<td class='gridbody'><s:textfield  name="groupgood.priceGroupBuy" id="priceGroupBuy" onchange="common.checkNumber(this);"/></td>
									</tr>
									<tr>
										<td class='gridtitle'>税率:</td>
										<td class='gridbody'><s:textfield name="groupgood.taxRate" id="taxRate" onblur="taxRateFormmat()"/><font color="red">*</font></td>
										<td  class='gridtitle'>含税价:</td>
										<td class='gridbody'><s:textfield name="groupgood.taxPrice" id="taxPrice" readonly="true"/></td>
									</tr>
									<tr>
										<td  class='gridtitle'>上架时间:</td>
										<td class='gridbody'>
									    	<input type="text" name="groupgood.beginSaleTime" id="beginSaleTime" readonly="true" 
									    		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${groupgood.beginSaleTime}" />"/>
										</td>
										<!-- 
											<td  class='gridtitle'>日均销量(DNS):</td>
											<td class='gridbody'><s:textfield  name="groupgood.dailyNetSales" id="dailyNetSales" readonly="true"/></td>
										 -->
										
										<td  class='gridtitle'>下架时间:</td>
										<td class='gridbody' colspan="3">
										    <input type="text" name="groupgood.endSaleTime" id="endSaleTime" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${groupgood.endSaleTime}" />"/>
										</td>
									</tr>
									
									<tr>
										<td  class='gridtitle'>开始时间:</td>
												<td class='gridbody'>
											    	<input type="text" name="groupgood.beginTime" id="beginTime" readonly="true" 
											    		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${groupgood.beginSaleTime}" />"/>
											</td>
										
										<td  class='gridtitle'>已团购人数:</td>
										<td class='gridbody'><s:textfield name="groupgood.groupNumber" id="groupNumber" readonly="true"/></td>
									</tr>
										
									
									<tr></tr>
									
									<tr>
										<td  class='gridtitle'>参考进价:</td>
										<td class='gridbody'>
											<s:textfield name="groupgood.purchasePrice" id="purchasePrice" onchange="common.checkNumber(this);" /><font color="red">*</font>
										</td>
										<td  class='gridtitle' >进货数量:</td>
										<td class='gridbody'><s:textfield  name="groupgood.purchaseNum" id="purchaseNum" readonly="true"/></td>
									</tr>
									<tr>
										<td  class='gridtitle'>库存成本:</td>
										<td class='gridbody'><s:textfield  name="groupgood.totalCostInventory" id="totalCostInventory" readonly="true"/></td>
										<td  class='gridtitle'>库存平均成本:</td>
										<td class='gridbody'><s:textfield  name="groupgood.averageCostInventory" id="averageCostInventory" readonly="true"/></td>
									</tr>
									<tr>
										<td  class='gridtitle'>库存下限:</td>
										<td class='gridbody'><s:textfield  name="groupgood.inventoryMin" id="inventoryMin" onchange="common.checkNumber(this);"/></td>
										<td  class='gridtitle'>库存上限:</td>
										<td class='gridbody'><s:textfield  name="groupgood.inventoryMax" id="inventoryMax" onchange="common.checkNumber(this);"/></td>
									</tr>
							
								<c:if test="${groupgood.id == null}">
									<tr>
											
										<td class='gridtitle'>初始数量</td>
										<td class='gridbody'><s:textfield  name="groupgood.initialNum" id="initialNum"  /><font color='red'>*</font></td>								
										<td class='gridtitle'>仓库设置</td>
										<td class='gridbody'><s:textfield  name="groupgood.warehouseName" id="warehouseName" onclick="selectWarehouse()"  /><font color='red'>*</font></td>	
									</tr>
									<tr>
										<td class='gridtitle'>仓位设置</td>
										<td class='gridbody' colspan="5"><s:textfield  name="groupgood.warehousePositionName" id="warehousePositionName" onclick="selectWarehousePosition()"  /><font color='red'>*</font></td>																					
									</tr>
									<tr id="hideTr"></tr>
								</c:if>
								<c:if test="${groupgood.id != null}">
									<s:hidden name="groupgood.warehouseName" id="warehouseName"></s:hidden>
									<s:hidden name="groupgood.warehousePositionName" id="warehousePositionName"></s:hidden>
								</c:if>
									<tr>
										<td class='gridtitle'>上传商品缩略图:</td>
										<td class='gridbody' colspan="3">
											<a href="javascript:void(0);" onclick="upload.open(this,'Good')">上传</a>
											<c:if test="${groupgood.pic != null && groupgood.pic != ''}">
												<img id="pic" border="0" src="${ctx}${groupgood.pic }" width="130px" height="130px"/>
												&nbsp;&nbsp;<a href="javascript:void(0);" onclick="deletePic(this)">删除</a>
											</c:if>
											<input type="hidden" name="picId" id="fileUploadId" value="${groupgood.picId}" /><%-- name必须为fileUploadId --%>
											<input type="hidden" name="pic" id="picPath" value="${groupgood.pic }" class="picPath">
										</td>
									</tr>
									<tr>
										<td class='gridtitle'>备注:</td>
										<td class='gridbody' colspan="3">
											<s:textarea id="remark" name="groupgood.remark" cols="100" rows="3"/>
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
											     value="groupgood.goodKindId" onchange="showAttr(this)" headerKey="00" headerValue="请选择种类"></s:select>  
										</td>
									</tr>
									<tr></tr>
									<input type="hidden" id="goodAttrIdStr" value="${goodAttrIdStr}"/>
									<c:forEach items="${goodAttrList}" var="goodAttr" varStatus="i">
										<input type="hidden" name="${goodAttr.id}" id="hidden${goodAttr.id}" value="${goodAttr.attrValue}"/>
									</c:forEach>
								</table>
								<div id="attrList"></div>
							</div>
							
							<div title="其他价格设置" style="padding:10px;">
								<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	
								<c:forEach items="${goodPriceList}" var="goodPrice" varStatus="i">
									<tr>
										<td  class='gridtitle'  width="10%">批发价${i.index + 1}:</td>
										<td class='gridbody'>
											<input type="text" name="priceDiscountArr" value="<fmt:formatNumber value="${goodPrice.priceDiscount}" pattern="0.00"/>"/> 
											 <c:if test="${i.index== '0'}"> &nbsp;&nbsp;<font color="red">优惠的金额</font></c:if>
										</td>
										<td  class='gridtitle'  width="10%">数量:</td>
										<td class='gridbody'>
											<input type="text" name="numberArr" value="${goodPrice.number}"/> 
											 <c:if test="${i.index == '0'}"> &nbsp;&nbsp;<font color="red">数量大于或等于这个数时有效</font></c:if>
										</td>	
										<td  class='gridtitle'  width="15%">前台显示这个批发价:</td>
										<td class='gridbody'>
											<input type="checkbox" onclick="clickBox(this)" <c:if test="${goodPrice.state == '1'}"> checked="checked"</c:if>/>
											<input type="hidden"  name="stateArr" value="${goodPrice.state}"/>
										</td>																			
									</tr>
								</c:forEach>    	
								</table>
							</div>
							
							<div title="商品规格" style="padding:10px;">
								<c:if test="${goodSpecificationList == null}">
								<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="showSpecification()">选择规格项</a>
								<br><br>
								说明： 1、没有规格则默认生成一个货品;2、编号为空则自动生成编号，以商品的编号+“-”+序号;<br><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、浮动金额是在商品销售价的基础上增加或减少;4、规格一旦设定不可更改，可另建商品。<br><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5、<font color="red">库存总和请与“基本信息”中的‘初始数量’相等;</font>
								</c:if>
								<div id="wareList">
								<c:if test="${goodSpecificationList != null}">
									<table width='80%' border='1' cellpadding='0' cellspacing='1' class='gdcn-table-bgcolor' style='margin-top: 10px;'>
										<thead>
											<th width='15%'>货号</th>
											<c:forEach items="${goodSpecificationList}" var="goodSpecification">
											<th width='10%'>${goodSpecification.name}</th>
											</c:forEach>
											<th width='10%'>库存</th>
											<th width='10%'>浮动金额</th>
											<th width='8%'>操作</th>
										</thead>
										<c:forEach items="${wareList}" var="ware">
										<c:if test="${ware.showwhether}">
											<tr>
												
												<input type="hidden" name="wareIdStr" value="${ware.id}"/>
												<td class='gridbody' style='text-align: center;'><input type='text' name='wareCodeArr' value="${ware.code}"></td>
												
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
												<td class='gridbody' style='text-align: center;'><input type='text' name='warePriceDiscountArr' size='10' value="${ware.priceDiscount}"></td>
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
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、浮动金额是在商品销售价的基础上增加或减少;4、规格一旦设定不可更改，可另建商品。<br><br>
												
										
								
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
							
							<!-- 
							
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
							
							 -->
							
																								
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

