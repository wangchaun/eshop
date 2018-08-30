package com.sinokj.app.good.good.model;

import com.sinokj.code.bean.Base;

import java.util.Date;

public class Good extends Base {
	private static final long serialVersionUID = 1L;
	private String goodTypeId;
	private String goodTypeName;
	private String goodKindId;
	private String goodKindName;
	private String brandId;
	private String brandName;
	private String supplierId;
	private String supplierName;
	private String unit;
	private Double purchasePrice;
	private Double price;
	private Double priceMarket;
	private Double priceGroupBuy;
	private Integer credits;
	private String picId;
	private String pic;
	private String warehousePositionId;
	private String warehousePositionName;
	private String warehouseId;
	private String warehouseName;
	private Integer commentCount;
	private String tag;
	private Date beginSaleTime;
	private Date endSaleTime;
	private String barcode;
	private String indexShow;
	private Integer orderMultiple;
	private Integer totalSales;
	private Integer dailyNetSales;
	private Integer purchaseNum;
	private Double totalCostInventory;
	private Double averageCostInventory;
	private Integer inventoryMin;
	private Integer inventoryMax;
	private String isInventory;
	private Integer minprice;
	private Integer maxprice;
	private String salesVolume;
	private String registerDate;
	private String indexs;
	private String typeId;
	private Double sumtotalSales;
	private Double sumpurchaseNum;
	private Double initialNum;
	private Integer sortInteger;
	private Double taxRate;
	private Double taxPrice;
	private String property;
	private Integer level;
	private String introBrief;
	private Integer groupNumber;
	private Date beginTime;
	private Date endTime;
	private String isNext;
	private Double returnRate;
	private Double returnPrice;
	private Integer activitNumber;
	private String endDate;
	private String shoptypeName;
	private String parentId;
	private String str;
	private String recommend;
	private String ascPrice;
	private String commentValue;
	private String searchType;
	private int commentLevel;
	private String commentContent;
	private Date begin;
	private Date end;
	private String areasId;
	private Double money;
	private String propt;
	private String files;
	private String brandsea;
	private String[] searpropt;
	private String[] searbrand;
	private String typesId;
	private String searproptbrand;
	private String sortVal;
	private String fzproperty;
	private String fztag;
	private String wareId;
	private String apptypes;
	private String typeidPage3;
	private String[] searproptPage3;
	private String[] searbrandPage3;
	private String filesPage3;
	private String brandseaPage3;
	private String searproptbrandPage3;
	private String typeidPage;
	private String totalNum;
	private String customerId;
	private String endhdTime;
	private String isView;
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public String getEndhdTime() {
		return this.endhdTime;
	}

	public void setEndhdTime(String endhdTime) {
		this.endhdTime = endhdTime;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String[] getSearproptPage3() {
		return this.searproptPage3;
	}

	public void setSearproptPage3(String[] searproptPage3) {
		this.searproptPage3 = searproptPage3;
	}

	public String[] getSearbrandPage3() {
		return this.searbrandPage3;
	}

	public void setSearbrandPage3(String[] searbrandPage3) {
		this.searbrandPage3 = searbrandPage3;
	}

	public String getApptypes() {
		return this.apptypes;
	}

	public void setApptypes(String apptypes) {
		this.apptypes = apptypes;
	}

	public String getSearproptbrand() {
		return this.searproptbrand;
	}

	public void setSearproptbrand(String searproptbrand) {
		this.searproptbrand = searproptbrand;
	}

	public String getTypesId() {
		return this.typesId;
	}

	public void setTypesId(String typesId) {
		this.typesId = typesId;
	}

	public void setPropt(String propt) {
		this.propt = propt;
	}

	public String[] getSearbrand() {
		return this.searbrand;
	}

	public void setSearbrand(String[] searbrand) {
		this.searbrand = searbrand;
	}

	public String getFiles() {
		return this.files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getSearchType() {
		return this.searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getCommentValue() {
		return this.commentValue;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}

	public String getStr() {
		return this.str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getShoptypeName() {
		return this.shoptypeName;
	}

	public void setShoptypeName(String shoptypeName) {
		this.shoptypeName = shoptypeName;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getGoodTypeId() {
		return this.goodTypeId;
	}

	public String getGoodTypeName() {
		return this.goodTypeName;
	}

	public String getGoodKindId() {
		return this.goodKindId;
	}

	public String getGoodKindName() {
		return this.goodKindName;
	}

	public String getBrandId() {
		return this.brandId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public Double getPrice() {
		return this.price;
	}

	public Double getPriceMarket() {
		return this.priceMarket;
	}

	public String getPicId() {
		return this.picId;
	}

	public String getPic() {
		return this.pic;
	}

	public String getTag() {
		return this.tag;
	}

	public Date getBeginSaleTime() {
		return this.beginSaleTime;
	}

	public void setGoodTypeId(String goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	public void setGoodKindId(String goodKindId) {
		this.goodKindId = goodKindId;
	}

	public void setGoodKindName(String goodKindName) {
		this.goodKindName = goodKindName;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setPriceMarket(Double priceMarket) {
		this.priceMarket = priceMarket;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setBeginSaleTime(Date beginSaleTime) {
		this.beginSaleTime = beginSaleTime;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public String getIndexShow() {
		return this.indexShow;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setIndexShow(String indexShow) {
		this.indexShow = indexShow;
	}

	public Double getPriceGroupBuy() {
		return this.priceGroupBuy;
	}

	public void setPriceGroupBuy(Double priceGroupBuy) {
		this.priceGroupBuy = priceGroupBuy;
	}

	public Integer getOrderMultiple() {
		return this.orderMultiple;
	}

	public Integer getDailyNetSales() {
		return this.dailyNetSales;
	}

	public Double getAverageCostInventory() {
		return this.averageCostInventory;
	}

	public void setOrderMultiple(Integer orderMultiple) {
		this.orderMultiple = orderMultiple;
	}

	public void setDailyNetSales(Integer dailyNetSales) {
		this.dailyNetSales = dailyNetSales;
	}

	public void setAverageCostInventory(Double averageCostInventory) {
		this.averageCostInventory = averageCostInventory;
	}

	public Integer getPurchaseNum() {
		return this.purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public Integer getInventoryMin() {
		return this.inventoryMin;
	}

	public Integer getInventoryMax() {
		return this.inventoryMax;
	}

	public void setInventoryMin(Integer inventoryMin) {
		this.inventoryMin = inventoryMin;
	}

	public void setInventoryMax(Integer inventoryMax) {
		this.inventoryMax = inventoryMax;
	}

	public Integer getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(Integer totalSales) {
		this.totalSales = totalSales;
	}

	public Double getTotalCostInventory() {
		return this.totalCostInventory;
	}

	public void setTotalCostInventory(Double totalCostInventory) {
		this.totalCostInventory = totalCostInventory;
	}

	public String getUnit() {
		return this.unit;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getMinprice() {
		return this.minprice;
	}

	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}

	public Integer getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}

	public String getSalesVolume() {
		return this.salesVolume;
	}

	public void setSalesVolume(String salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getIndexs() {
		return this.indexs;
	}

	public void setIndexs(String indexs) {
		this.indexs = indexs;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getIsInventory() {
		return this.isInventory;
	}

	public void setIsInventory(String isInventory) {
		this.isInventory = isInventory;
	}

	public Double getSumtotalSales() {
		return this.sumtotalSales;
	}

	public void setSumtotalSales(Double sumtotalSales) {
		this.sumtotalSales = sumtotalSales;
	}

	public Double getSumpurchaseNum() {
		return this.sumpurchaseNum;
	}

	public void setSumpurchaseNum(Double sumpurchaseNum) {
		this.sumpurchaseNum = sumpurchaseNum;
	}

	public Double getInitialNum() {
		return this.initialNum;
	}

	public void setInitialNum(Double initialNum) {
		this.initialNum = initialNum;
	}

	public String getWarehousePositionId() {
		return this.warehousePositionId;
	}

	public void setWarehousePositionId(String warehousePositionId) {
		this.warehousePositionId = warehousePositionId;
	}

	public String getWarehousePositionName() {
		return this.warehousePositionName;
	}

	public void setWarehousePositionName(String warehousePositionName) {
		this.warehousePositionName = warehousePositionName;
	}

	public String getWarehouseId() {
		return this.warehouseId;
	}

	public Double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTaxPrice() {
		return this.taxPrice;
	}

	public void setTaxPrice(Double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Integer getSortInteger() {
		return this.sortInteger;
	}

	public void setSortInteger(Integer sortInteger) {
		this.sortInteger = sortInteger;
	}

	public Date getBegin() {
		return this.begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return this.end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getEndSaleTime() {
		return this.endSaleTime;
	}

	public void setEndSaleTime(Date endSaleTime) {
		this.endSaleTime = endSaleTime;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIntroBrief() {
		return this.introBrief;
	}

	public void setIntroBrief(String introBrief) {
		this.introBrief = introBrief;
	}

	public Integer getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getAscPrice() {
		return this.ascPrice;
	}

	public void setAscPrice(String ascPrice) {
		this.ascPrice = ascPrice;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public int getCommentLevel() {
		return this.commentLevel;
	}

	public String getAreasId() {
		return this.areasId;
	}

	public void setAreasId(String areasId) {
		this.areasId = areasId;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getGroupNumber() {
		return this.groupNumber;
	}

	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getIsNext() {
		return this.isNext;
	}

	public void setIsNext(String isNext) {
		this.isNext = isNext;
	}

	public String[] getSearpropt() {
		return this.searpropt;
	}

	public void setSearpropt(String[] searpropt) {
		this.searpropt = searpropt;
	}

	public String getPropt() {
		return this.propt;
	}

	public String getBrandsea() {
		return this.brandsea;
	}

	public void setBrandsea(String brandsea) {
		this.brandsea = brandsea;
	}

	public String getSortVal() {
		return this.sortVal;
	}

	public void setSortVal(String sortVal) {
		this.sortVal = sortVal;
	}

	public Double getReturnRate() {
		return this.returnRate;
	}

	public void setReturnRate(Double returnRate) {
		this.returnRate = returnRate;
	}

	public Double getReturnPrice() {
		return this.returnPrice;
	}

	public void setReturnPrice(Double returnPrice) {
		this.returnPrice = returnPrice;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFzproperty() {
		return this.fzproperty;
	}

	public void setFzproperty(String fzproperty) {
		this.fzproperty = fzproperty;
	}

	public String getFztag() {
		return this.fztag;
	}

	public void setFztag(String fztag) {
		this.fztag = fztag;
	}

	public Integer getActivitNumber() {
		return this.activitNumber;
	}

	public void setActivitNumber(Integer activitNumber) {
		this.activitNumber = activitNumber;
	}

	public String getWareId() {
		return this.wareId;
	}

	public void setWareId(String wareId) {
		this.wareId = wareId;
	}

	public String getTypeidPage3() {
		return this.typeidPage3;
	}

	public void setTypeidPage3(String typeidPage3) {
		this.typeidPage3 = typeidPage3;
	}

	public String getFilesPage3() {
		return this.filesPage3;
	}

	public void setFilesPage3(String filesPage3) {
		this.filesPage3 = filesPage3;
	}

	public String getBrandseaPage3() {
		return this.brandseaPage3;
	}

	public void setBrandseaPage3(String brandseaPage3) {
		this.brandseaPage3 = brandseaPage3;
	}

	public String getSearproptbrandPage3() {
		return this.searproptbrandPage3;
	}

	public void setSearproptbrandPage3(String searproptbrandPage3) {
		this.searproptbrandPage3 = searproptbrandPage3;
	}

	public String getTypeidPage() {
		return this.typeidPage;
	}

	public void setTypeidPage(String typeidPage) {
		this.typeidPage = typeidPage;
	}
}
