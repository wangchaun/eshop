 package com.sinokj.app.order.sale.saleWare.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class SaleWare extends Base
 {
   private static final long serialVersionUID = 1L;
   private String saleId;
   private String wareId;
   private Double orderNumber;
   private Double goodPrice;
   private Double money;
   private Double priceDiscount;
   private String type;
   private String warehousePositionId;
   private String warehousePositionName;
   private Double credits;
   private Double returnRate;
   private Double returnMoney;
   private String wareSpecification;
   private String orderCode;
   private String unit;
   private Double purchasePrice;
   private Double taxRate;
   private Double taxPrice;
   private Double taxDueSum;
   private Double taxMoney;
   private String brandName;
   private String goodTypeName;
   private Double goodStcok;
   private String wareSpecificationVal;
   private Date begin;
   private Date end;
   private Double salesmoney;
   private Double costmoney;
   private Double grossSales;
   private Double grossSalesProportion;
   private Double sumGrossSaleProportion;
   private Double grossMargin;
   private Double salesmoneyProportion;
   private Double sumSalesmoneyProportion;
   private Double totalCostmoney;
   private Double totalSalesmoney;
   private Double totalGrossSales;
   private Double totalOrderNum;
   private String goodCode;
   private String goodName;
   private String goodPic;
   private String goodId;
   private String chestr;
   private String[] checkStrId;
   private String deliveryState;
   private String customerId;
 
   public String getDeliveryState()
   {
     return this.deliveryState;
   }
   public void setDeliveryState(String deliveryState) {
     this.deliveryState = deliveryState;
   }
   public String getCustomerId() {
     return this.customerId;
   }
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }
   public String getChestr() {
     return this.chestr;
   }
   public void setChestr(String chestr) {
     this.chestr = chestr;
   }
   public String getGoodId() {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public String getGoodPic() {
     return this.goodPic;
   }
   public void setGoodPic(String goodPic) {
     this.goodPic = goodPic;
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
   public String getSaleId() {
     return this.saleId;
   }
   public String getWareId() {
     return this.wareId;
   }
   public Double getOrderNumber() {
     return this.orderNumber;
   }
   public Double getGoodPrice() {
     return this.goodPrice;
   }
   public Double getMoney() {
     return this.money;
   }
   public Double getPriceDiscount() {
     return this.priceDiscount;
   }
   public String getType() {
     return this.type;
   }
   public void setSaleId(String saleId) {
     this.saleId = saleId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public void setOrderNumber(Double orderNumber) {
     this.orderNumber = orderNumber;
   }
   public void setGoodPrice(Double goodPrice) {
     this.goodPrice = goodPrice;
   }
   public void setMoney(Double money) {
     this.money = money;
   }
   public void setPriceDiscount(Double priceDiscount) {
     this.priceDiscount = priceDiscount;
   }
   public void setType(String type) {
     this.type = type;
   }
   public String getGoodTypeName() {
     return this.goodTypeName;
   }
   public String getWareSpecificationVal() {
     return this.wareSpecificationVal;
   }
   public void setGoodTypeName(String goodTypeName) {
     this.goodTypeName = goodTypeName;
   }
   public void setWareSpecificationVal(String wareSpecificationVal) {
     this.wareSpecificationVal = wareSpecificationVal;
   }
   public String getWarehousePositionId() {
     return this.warehousePositionId;
   }
   public String getWarehousePositionName() {
     return this.warehousePositionName;
   }
   public void setWarehousePositionId(String warehousePositionId) {
     this.warehousePositionId = warehousePositionId;
   }
   public void setWarehousePositionName(String warehousePositionName) {
     this.warehousePositionName = warehousePositionName;
   }
   public Double getCredits() {
     return this.credits;
   }
   public void setCredits(Double credits) {
     this.credits = credits;
   }
   public String getOrderCode() {
     return this.orderCode;
   }
   public void setOrderCode(String orderCode) {
     this.orderCode = orderCode;
   }
   public String getGoodCode() {
     return this.goodCode;
   }
   public void setGoodCode(String goodCode) {
     this.goodCode = goodCode;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public String getUnit() {
     return this.unit;
   }
   public void setUnit(String unit) {
     this.unit = unit;
   }
   public Double getTotalOrderNum() {
     return this.totalOrderNum;
   }
   public void setTotalOrderNum(Double totalOrderNum) {
     this.totalOrderNum = totalOrderNum;
   }
   public Double getSalesmoney() {
     return this.salesmoney;
   }
   public void setSalesmoney(Double salesmoney) {
     this.salesmoney = salesmoney;
   }
   public Double getCostmoney() {
     return this.costmoney;
   }
   public void setCostmoney(Double costmoney) {
     this.costmoney = costmoney;
   }
   public Double getGrossSales() {
     return this.grossSales;
   }
   public void setGrossSales(Double grossSales) {
     this.grossSales = grossSales;
   }
   public Double getGrossMargin() {
     return this.grossMargin;
   }
   public void setGrossMargin(Double grossMargin) {
     this.grossMargin = grossMargin;
   }
   public Double getSalesmoneyProportion() {
     return this.salesmoneyProportion;
   }
   public void setSalesmoneyProportion(Double salesmoneyProportion) {
     this.salesmoneyProportion = salesmoneyProportion;
   }
   public Double getSumSalesmoneyProportion() {
     return this.sumSalesmoneyProportion;
   }
   public void setSumSalesmoneyProportion(Double sumSalesmoneyProportion) {
     this.sumSalesmoneyProportion = sumSalesmoneyProportion;
   }
   public Double getTotalCostmoney() {
     return this.totalCostmoney;
   }
   public void setTotalCostmoney(Double totalCostmoney) {
     this.totalCostmoney = totalCostmoney;
   }
   public Double getTotalSalesmoney() {
     return this.totalSalesmoney;
   }
   public void setTotalSalesmoney(Double totalSalesmoney) {
     this.totalSalesmoney = totalSalesmoney;
   }
   public Double getPurchasePrice() {
     return this.purchasePrice;
   }
   public void setPurchasePrice(Double purchasePrice) {
     this.purchasePrice = purchasePrice;
   }
   public Double getGrossSalesProportion() {
     return this.grossSalesProportion;
   }
   public void setGrossSalesProportion(Double grossSalesProportion) {
     this.grossSalesProportion = grossSalesProportion;
   }
   public Double getSumGrossSaleProportion() {
     return this.sumGrossSaleProportion;
   }
   public void setSumGrossSaleProportion(Double sumGrossSaleProportion) {
     this.sumGrossSaleProportion = sumGrossSaleProportion;
   }
   public Double getTotalGrossSales() {
     return this.totalGrossSales;
   }
   public void setTotalGrossSales(Double totalGrossSales) {
     this.totalGrossSales = totalGrossSales;
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
   public Double getTaxMoney() {
     return this.taxMoney;
   }
   public void setTaxMoney(Double taxMoney) {
     this.taxMoney = taxMoney;
   }
   public Double getTaxDueSum() {
     return this.taxDueSum;
   }
   public void setTaxDueSum(Double taxDueSum) {
     this.taxDueSum = taxDueSum;
   }
   public Double getGoodStcok() {
     return this.goodStcok;
   }
   public void setGoodStcok(Double goodStcok) {
     this.goodStcok = goodStcok;
   }
   public String getBrandName() {
     return this.brandName;
   }
   public void setBrandName(String brandName) {
     this.brandName = brandName;
   }
   public Double getReturnRate() {
     return this.returnRate;
   }
   public void setReturnRate(Double returnRate) {
     this.returnRate = returnRate;
   }
   public Double getReturnMoney() {
     return this.returnMoney;
   }
   public void setReturnMoney(Double returnMoney) {
     this.returnMoney = returnMoney;
   }
   public String[] getCheckStrId() {
     return this.checkStrId;
   }
   public void setCheckStrId(String[] checkStrId) {
     this.checkStrId = checkStrId;
   }
   public String getWareSpecification() {
     return this.wareSpecification;
   }
   public void setWareSpecification(String wareSpecification) {
     this.wareSpecification = wareSpecification;
   }
 }

/* 
 
 
 */