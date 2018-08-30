 package com.sinokj.app.order.sale.saleOrder.model;
 
 import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.code.bean.Base;

 import java.util.Date;
import java.util.List;
 
 public class SaleOrder extends Base
 {
   private static final long serialVersionUID = -8738255760779509559L;
   private String type;
   private String bankAccountId;
   private String bankAccountName;
   private String warehouseId;
   private String warehouseName;
   private String customerId;
   private String customerName;
   private Double priceDiscount;
   private Double orderMoney;
   private String linkman;
   private String mobile;
   private String address;
   private String telephone;
   private String email;
   private String zipCode;
   private String paymentId;
   private String paymentCode;
   private String paymentName;
   private String deliveryId;
   private String deliveryCode;
   private String deliveryName;
   private String deliveryDate;
   private Double deliveryCost;
   private String orderState;
   private String deliveryState;
   private String paymentState;
   private String remark;
   private String handlerId;
   private String handlerName;
   private String deptId;
   private String deptName;
   private String invoiceType;
   private String invoicePayable;
   private String invoiceContent;
   private double totalCredits;
   private Date oneMonthAgo;
   private Date oneMonthAfter;
   private String zfbTradeNo;
   private int orderStateNum;
   private String iscancel;
   private Date orderstateTime;
   private Date deliveryTime;
   private Date paymentTime;
   private Date cancelTime;
   private String dateTime = "0";
   private String employcouponId;
   private String srachcode;
   private List<Good> goodlist;
   private List<SaleWare> warelist;
   private String data;
   private String search;
   private String begintime;
   private String endtime;
   private String bankCode;
   private String searchOrder;
 
   public String getSearchOrder()
   {
     return this.searchOrder;
   }
   public void setSearchOrder(String searchOrder) {
     this.searchOrder = searchOrder;
   }
   public String getBegintime() {
     return this.begintime;
   }
   public void setBegintime(String begintime) {
     this.begintime = begintime;
   }
   public String getEndtime() {
     return this.endtime;
   }
   public void setEndtime(String endtime) {
     this.endtime = endtime;
   }
   public String getData() {
     return this.data;
   }
   public void setData(String data) {
     this.data = data;
   }
   public String getSearch() {
     return this.search;
   }
   public void setSearch(String search) {
     this.search = search;
   }
   public List<SaleWare> getWarelist() {
     return this.warelist;
   }
   public void setWarelist(List<SaleWare> warelist) {
     this.warelist = warelist;
   }
   public List<Good> getGoodlist() {
     return this.goodlist;
   }
   public void setGoodlist(List<Good> goodlist) {
     this.goodlist = goodlist;
   }
   public String getType() {
     return this.type;
   }
   public String getBankAccountId() {
     return this.bankAccountId;
   }
   public String getBankAccountName() {
     return this.bankAccountName;
   }
   public String getCustomerId() {
     return this.customerId;
   }
   public String getCustomerName() {
     return this.customerName;
   }
   public Double getPriceDiscount() {
     return this.priceDiscount;
   }
   public Double getOrderMoney() {
     return this.orderMoney;
   }
   public String getLinkman() {
     return this.linkman;
   }
   public String getMobile() {
     return this.mobile;
   }
   public String getPaymentId() {
     return this.paymentId;
   }
   public String getPaymentCode() {
     return this.paymentCode;
   }
   public String getPaymentName() {
     return this.paymentName;
   }
   public String getDeliveryId() {
     return this.deliveryId;
   }
   public String getDeliveryCode() {
     return this.deliveryCode;
   }
   public String getDeliveryName() {
     return this.deliveryName;
   }
   public String getDeliveryDate() {
     return this.deliveryDate;
   }
   public Double getDeliveryCost() {
     return this.deliveryCost;
   }
   public String getOrderState() {
     return this.orderState;
   }
   public String getDeliveryState() {
     return this.deliveryState;
   }
   public String getPaymentState() {
     return this.paymentState;
   }
   public String getRemark() {
     return this.remark;
   }
   public String getHandlerId() {
     return this.handlerId;
   }
   public String getHandlerName() {
     return this.handlerName;
   }
   public String getDeptId() {
     return this.deptId;
   }
   public String getDeptName() {
     return this.deptName;
   }
   public void setType(String type) {
     this.type = type;
   }
   public void setBankAccountId(String bankAccountId) {
     this.bankAccountId = bankAccountId;
   }
   public void setBankAccountName(String bankAccountName) {
     this.bankAccountName = bankAccountName;
   }
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }
   public void setCustomerName(String customerName) {
     this.customerName = customerName;
   }
   public void setPriceDiscount(Double priceDiscount) {
     this.priceDiscount = priceDiscount;
   }
   public void setOrderMoney(Double orderMoney) {
     this.orderMoney = orderMoney;
   }
   public void setLinkman(String linkman) {
     this.linkman = linkman;
   }
   public void setMobile(String mobile) {
     this.mobile = mobile;
   }
   public void setPaymentId(String paymentId) {
     this.paymentId = paymentId;
   }
   public void setPaymentCode(String paymentCode) {
     this.paymentCode = paymentCode;
   }
   public void setPaymentName(String paymentName) {
     this.paymentName = paymentName;
   }
   public void setDeliveryId(String deliveryId) {
     this.deliveryId = deliveryId;
   }
   public void setDeliveryCode(String deliveryCode) {
     this.deliveryCode = deliveryCode;
   }
   public void setDeliveryName(String deliveryName) {
     this.deliveryName = deliveryName;
   }
   public void setDeliveryDate(String deliveryDate) {
     this.deliveryDate = deliveryDate;
   }
   public void setDeliveryCost(Double deliveryCost) {
     this.deliveryCost = deliveryCost;
   }
   public void setOrderState(String orderState) {
     this.orderState = orderState;
   }
   public void setDeliveryState(String deliveryState) {
     this.deliveryState = deliveryState;
   }
   public void setPaymentState(String paymentState) {
     this.paymentState = paymentState;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public void setHandlerId(String handlerId) {
     this.handlerId = handlerId;
   }
   public void setHandlerName(String handlerName) {
     this.handlerName = handlerName;
   }
   public void setDeptId(String deptId) {
     this.deptId = deptId;
   }
   public void setDeptName(String deptName) {
     this.deptName = deptName;
   }
   public String getWarehouseId() {
     return this.warehouseId;
   }
   public String getWarehouseName() {
     return this.warehouseName;
   }
   public void setWarehouseId(String warehouseId) {
     this.warehouseId = warehouseId;
   }
   public void setWarehouseName(String warehouseName) {
     this.warehouseName = warehouseName;
   }
   public String getAddress() {
     return this.address;
   }
   public void setAddress(String address) {
     this.address = address;
   }
   public String getTelephone() {
     return this.telephone;
   }
   public void setTelephone(String telephone) {
     this.telephone = telephone;
   }
   public String getEmail() {
     return this.email;
   }
   public void setEmail(String email) {
     this.email = email;
   }
   public String getZipCode() {
     return this.zipCode;
   }
   public void setZipCode(String zipCode) {
     this.zipCode = zipCode;
   }
   public String getDateTime() {
     return this.dateTime;
   }
   public void setDateTime(String dateTime) {
     this.dateTime = dateTime;
   }
   public String getInvoiceType() {
     return this.invoiceType;
   }
   public void setInvoiceType(String invoiceType) {
     this.invoiceType = invoiceType;
   }
   public String getInvoicePayable() {
     return this.invoicePayable;
   }
   public void setInvoicePayable(String invoicePayable) {
     this.invoicePayable = invoicePayable;
   }
   public String getInvoiceContent() {
     return this.invoiceContent;
   }
   public void setInvoiceContent(String invoiceContent) {
     this.invoiceContent = invoiceContent;
   }
   public double getTotalCredits() {
     return this.totalCredits;
   }
   public void setTotalCredits(double totalCredits) {
     this.totalCredits = totalCredits;
   }
   public Date getOneMonthAgo() {
     return this.oneMonthAgo;
   }
   public void setOneMonthAgo(Date oneMonthAgo) {
     this.oneMonthAgo = oneMonthAgo;
   }
   public Date getOneMonthAfter() {
     return this.oneMonthAfter;
   }
   public void setOneMonthAfter(Date oneMonthAfter) {
     this.oneMonthAfter = oneMonthAfter;
   }
   public String getEmploycouponId() {
     return this.employcouponId;
   }
   public void setEmploycouponId(String employcouponId) {
     this.employcouponId = employcouponId;
   }
   public String getZfbTradeNo() {
     return this.zfbTradeNo;
   }
   public void setZfbTradeNo(String zfbTradeNo) {
     this.zfbTradeNo = zfbTradeNo;
   }
   public int getOrderStateNum() {
     return this.orderStateNum;
   }
   public void setOrderStateNum(int orderStateNum) {
     this.orderStateNum = orderStateNum;
   }
   public String getSrachcode() {
     return this.srachcode;
   }
   public void setSrachcode(String srachcode) {
     this.srachcode = srachcode;
   }
   public String getIscancel() {
     return this.iscancel;
   }
   public void setIscancel(String iscancel) {
     this.iscancel = iscancel;
   }
   public String getBankCode() {
     return this.bankCode;
   }
   public void setBankCode(String bankCode) {
     this.bankCode = bankCode;
   }
   public Date getOrderstateTime() {
     return this.orderstateTime;
   }
   public void setOrderstateTime(Date orderstateTime) {
     this.orderstateTime = orderstateTime;
   }
   public Date getDeliveryTime() {
     return this.deliveryTime;
   }
   public void setDeliveryTime(Date deliveryTime) {
     this.deliveryTime = deliveryTime;
   }
   public Date getPaymentTime() {
     return this.paymentTime;
   }
   public void setPaymentTime(Date paymentTime) {
     this.paymentTime = paymentTime;
   }
 
   public Date getCancelTime() {
     return this.cancelTime;
   }
   public void setCancelTime(Date cancelTime) {
     this.cancelTime = cancelTime;
   }
 }

/* 
 
 
 */