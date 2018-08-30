 package com.sinokj.app.order.sale.saleOrder.action;
 
 import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.delivery.model.Delivery;
import com.sinokj.app.baseInfo.delivery.service.DeliveryService;
import com.sinokj.app.baseInfo.payment.model.Payment;
import com.sinokj.app.baseInfo.payment.service.PaymentService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.ServletOutputStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SaleOrderAction extends BaseAction
 {
   private static final long serialVersionUID = -3722372855686662025L;
   private static final Logger logger = Logger.getLogger(SaleOrderAction.class);
   private SaleOrder saleOrder;
   private SaleOrderService saleOrderService;
   private SaleWareService saleWareService;
   private SerialNumberService serialNumberService;
   private PaymentService paymentService;
   private DeliveryService deliveryService;
   private BankAccountService bankAccountService;
   private List<Payment> paymentList;
   private List<Delivery> deliveryList;
   private List<BankAccount> bankAccountList;
   private String[] wareIdArr;
   private Double[] orderNumberArr;
   private Double[] goodPriceArr;
   private Double[] moneyArr;
   private Double[] priceDiscountArr;
 
   public void setSaleOrderService(SaleOrderService saleOrderService)
   {
     this.saleOrderService = saleOrderService;
   }
 
   public void setSaleWareService(SaleWareService saleWareService) {
     this.saleWareService = saleWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public void setPaymentService(PaymentService paymentService) {
     this.paymentService = paymentService;
   }
 
   public void setDeliveryService(DeliveryService deliveryService) {
     this.deliveryService = deliveryService;
   }
 
   public void setBankAccountService(BankAccountService bankAccountService) {
     this.bankAccountService = bankAccountService;
   }
 
   public String list()
   {
     SysUser loginMan = getSessionUserInfo();
     getRequest().setAttribute("roleCode", loginMan.getRoleCode());
     return "list_saleOrder";
   }
 
   public String listJson()
   {
     logger.info("start list saleorder!");
 
     SysUser loginMan = getSessionUserInfo();
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.saleOrder == null) {
         this.saleOrder = new SaleOrder();
       }
       String warehouseId = loginMan.getWarehouseId();
       if (warehouseId != null) {
         this.saleOrder.setWarehouseId(warehouseId);
       }
       resultList = this.saleOrderService.pageList(pageInfo, this.saleOrder, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list saleorder", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all saleorder!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.saleOrder == null) {
       this.saleOrder = new SaleOrder();
     }
     if (StringUtils.isBlank(this.saleOrder.getId())) {
       initModel(true, this.saleOrder, loginMan);
       this.saleOrder.setType("1");
       this.saleOrder.setHandlerId(loginMan.getId());
       this.saleOrder.setHandlerName(loginMan.getName());
       this.saleOrder.setDeptId(loginMan.getDeptId());
       this.saleOrder.setDeptName(loginMan.getDeptName());
       this.saleOrder.setOrderState("0");
       this.saleOrder.setDeliveryState("0");
       this.saleOrder.setPaymentState("0");
       try
       {
         String code = this.serialNumberService.getSerialNumberByDate("SDH", "saleOrder");
         this.saleOrder.setCode(code);
       } catch (Exception e) {
         logger.error("error occur when get code", e);
       }
     } else {
       this.saleOrder = ((SaleOrder)this.saleOrderService.getModel(this.saleOrder.getId()));
       initModel(false, this.saleOrder, loginMan);
     }
 
     this.paymentList = this.paymentService.select(new Payment());
     this.deliveryList = this.deliveryService.select(new Delivery());
     this.bankAccountList = this.bankAccountService.select(new BankAccount());
     return "edit_saleOrder";
   }
 
   public void save()
   {
     logger.info("start save a sale order!");
     try {
       if (this.saleOrder == null) this.saleOrder = new SaleOrder();
 
       BankAccount bankAccount = (BankAccount)this.bankAccountService.getModel(this.saleOrder.getBankAccountId());
       this.saleOrder.setBankAccountName(bankAccount.getName());
 
       Payment payment = (Payment)this.paymentService.getModel(this.saleOrder.getPaymentId());
       this.saleOrder.setPaymentCode(payment.getCode());
       this.saleOrder.setPaymentName(payment.getName());
 
       Delivery delivery = (Delivery)this.deliveryService.getModel(this.saleOrder.getDeliveryId());
       this.saleOrder.setDeliveryCode(delivery.getCode());
       this.saleOrder.setDeliveryName(delivery.getName());
       this.saleOrder.setDeliveryCost(delivery.getDeliveryFee());
       if (StringUtils.isBlank(this.saleOrder.getId())) {
         String id = this.saleOrderService.makeId();
         this.saleOrder.setId(id);
         this.saleOrderService.insert(this.saleOrder);
       } else {
         if ((this.saleOrder.getOrderstateTime() == null) || (this.saleOrder.getOrderstateTime().equals(""))) {
           this.saleOrder.setOrderstateTime(new Date());
         }
         this.saleOrderService.update(this.saleOrder);
 
         this.saleWareService.deleteBySaleId(this.saleOrder.getId());
       }
 
       String saleId = this.saleOrder.getId();
       if ((this.wareIdArr != null) && (this.wareIdArr.length != 0)) {
         for (int i = 0; i < this.wareIdArr.length; i++) {
           SaleWare saleWare = new SaleWare();
           saleWare.setSaleId(saleId);
           saleWare.setWareId(this.wareIdArr[i]);
           saleWare.setOrderNumber(this.orderNumberArr[i]);
           saleWare.setGoodPrice(this.goodPriceArr[i]);
           saleWare.setMoney(this.moneyArr[i]);
           saleWare.setPriceDiscount(this.priceDiscountArr[i]);
           saleWare.setType("0");
           saleWare.setSort(Integer.valueOf(i));
           this.saleWareService.insert(saleWare);
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save a saleOrder", e);
     }
   }
 
   public void delete()
   {
     try
     {
       if (this.saleOrder == null) {
         this.saleOrder = new SaleOrder();
       }
       String saleOrderId = this.saleOrder.getId();
       if (StringUtils.isNotBlank(saleOrderId))
       {
         String[] idArr = saleOrderId.split(",");
         for (String idStr : idArr) {
           this.saleWareService.deleteBySaleId(idStr);
           this.saleOrderService.delete(idStr);
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale order", e);
     }
   }
 
   public void downloadPdf()
   {
     HttpServletRequest request = getRequest();
     HttpServletResponse response = getResponse();
     ByteArrayOutputStream os = new ByteArrayOutputStream();
     String type = request.getParameter("type");
     if (this.saleOrder == null)
     {
       this.saleOrder = new SaleOrder();
     }
     String orderId = this.saleOrder.getId();
     this.saleOrder = ((SaleOrder)this.saleOrderService.getModel(orderId));
     String code = this.saleOrder.getCode();
     String downloadFileName = code + ".pdf";
     try {
       if ("CustomInvoice".equals(type)) {
         os = this.saleOrderService.createOrderPdf(this.saleOrder);
       }
       response.setHeader("Content-Disposition", "attachment;filename=\"" + downloadFileName + "\"");
       response.setContentType("application/pdf");
       ServletOutputStream out = response.getOutputStream();
       os.writeTo(out);
       os.close();
       out.flush();
     } catch (IOException e) {
       logger.error("happen Exception when close ByteArrayOutputStream", e);
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
 
   public SaleOrder getSaleOrder() {
     return this.saleOrder;
   }
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
   public Double[] getOrderNumberArr() {
     return this.orderNumberArr;
   }
   public Double[] getGoodPriceArr() {
     return this.goodPriceArr;
   }
   public Double[] getMoneyArr() {
     return this.moneyArr;
   }
   public Double[] getPriceDiscountArr() {
     return this.priceDiscountArr;
   }
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
   public void setOrderNumberArr(Double[] orderNumberArr) {
     this.orderNumberArr = orderNumberArr;
   }
   public void setGoodPriceArr(Double[] goodPriceArr) {
     this.goodPriceArr = goodPriceArr;
   }
   public void setMoneyArr(Double[] moneyArr) {
     this.moneyArr = moneyArr;
   }
   public void setPriceDiscountArr(Double[] priceDiscountArr) {
     this.priceDiscountArr = priceDiscountArr;
   }
   public List<Payment> getPaymentList() {
     return this.paymentList;
   }
   public void setPaymentList(List<Payment> paymentList) {
     this.paymentList = paymentList;
   }
   public List<BankAccount> getBankAccountList() {
     return this.bankAccountList;
   }
   public void setBankAccountList(List<BankAccount> bankAccountList) {
     this.bankAccountList = bankAccountList;
   }
   public List<Delivery> getDeliveryList() {
     return this.deliveryList;
   }
   public void setDeliveryList(List<Delivery> deliveryList) {
     this.deliveryList = deliveryList;
   }
 }