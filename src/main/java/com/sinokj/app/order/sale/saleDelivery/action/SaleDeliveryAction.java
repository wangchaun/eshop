 package com.sinokj.app.order.sale.saleDelivery.action;
 
 import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.delivery.model.Delivery;
import com.sinokj.app.baseInfo.delivery.service.DeliveryService;
import com.sinokj.app.baseInfo.payment.model.Payment;
import com.sinokj.app.baseInfo.payment.service.PaymentService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.order.sale.saleDelivery.model.SaleDelivery;
import com.sinokj.app.order.sale.saleDelivery.service.SaleDeliveryService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SaleDeliveryAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(SaleDeliveryAction.class);
   private SaleDelivery saleDelivery;
   private SaleOrder saleOrder;
   private SaleDeliveryService saleDeliveryService;
   private GoodService goodService;
   private PaymentService paymentService;
   private List<Payment> paymentList;
   private List<Delivery> deliveryList;
   private List<BankAccount> bankAccountList;
   private String[] wareIdArr;
   private Double[] orderNumberArr;
   private Double[] goodPriceArr;
   private Double[] moneyArr;
   private Double[] priceDiscountArr;
   private String[] warehousePositionIdArr;
   private String[] warehousePositionNameArr;
   private SaleOrderService saleOrderService;
   private SerialNumberService serialNumberService;
   private SaleWareService saleWareService;
   private DeliveryService deliveryService;
   private BankAccountService bankAccountService;
   private WarehouseWareService warehouseWareService;
   private WarehousePositionWareService warehousePositionWareService;
   private WareService wareService;
   private WarehouseService warehouseService;
 
   public String list()
   {
     SysUser loginMan = getSessionUserInfo();
     getRequest().setAttribute("roleCode", loginMan.getRoleCode());
     return "list_saleDelivery";
   }
 
   public String listJson()
   {
     logger.info("start list sale delivery order!");
     SysUser loginMan = getSessionUserInfo();
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.saleDelivery == null) {
         this.saleDelivery = new SaleDelivery();
       }
       String warehouseId = loginMan.getWarehouseId();
       if (warehouseId != null) {
         this.saleDelivery.setWarehouseId(warehouseId);
       }
       resultList = this.saleDeliveryService.pageList(pageInfo, this.saleDelivery, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list sale delivery order", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all sale delivery order!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.saleDelivery == null) {
       this.saleDelivery = new SaleDelivery();
     }
     if (StringUtils.isBlank(this.saleDelivery.getId())) {
       if ((this.saleOrder != null) && (StringUtils.isNotBlank(this.saleOrder.getId()))) {
         try {
           this.saleDelivery = this.saleDeliveryService.getSaleDeliveryByOrderId(this.saleOrder.getId());
         } catch (Exception e) {
           logger.error("error occur when get saleDelivery by order id");
         }
         if (this.saleDelivery == null)
         {
           this.saleDelivery = new SaleDelivery();
           this.saleOrder = ((SaleOrder)this.saleOrderService.getModel(this.saleOrder.getId()));
 
           this.saleDelivery.setOrderId(this.saleOrder.getId());
           this.saleDelivery.setBankAccountId(this.saleOrder.getBankAccountId());
           this.saleDelivery.setBankAccountName(this.saleOrder.getBankAccountName());
           this.saleDelivery.setCustomerId(this.saleOrder.getCreatorId());
           this.saleDelivery.setCustomerName(this.saleOrder.getCustomerName());
           this.saleDelivery.setMoneyAccount(this.saleOrder.getOrderMoney());
           this.saleDelivery.setDeliveryCost(this.saleOrder.getDeliveryCost());
           this.saleDelivery.setLinkman(this.saleOrder.getLinkman());
           this.saleDelivery.setMobile(this.saleOrder.getMobile());
           this.saleDelivery.setDeliveryId(this.saleOrder.getDeliveryId());
           this.saleDelivery.setDeliveryCode(this.saleOrder.getDeliveryCode());
           this.saleDelivery.setDeliveryName(this.saleOrder.getDeliveryName());
           this.saleDelivery.setWarehouseId(this.saleOrder.getWarehouseId());
           this.saleDelivery.setWarehouseName(this.saleOrder.getWarehouseName());
           this.saleDelivery.setPaymentState(this.saleOrder.getPaymentState());
         }
       }
 
       if (StringUtils.isBlank(this.saleDelivery.getCreatorId())) {
         initModel(true, this.saleDelivery, loginMan);
         this.saleDelivery.setDeliveryState("0");
         this.saleDelivery.setHandlerId(loginMan.getId());
         this.saleDelivery.setHandlerName(loginMan.getName());
         this.saleDelivery.setDeptId(loginMan.getDeptId());
         this.saleDelivery.setDeptName(loginMan.getDeptName());
         if (StringUtils.isBlank(this.saleDelivery.getPaymentState()))
           this.saleDelivery.setPaymentState("0");
         try
         {
           String code = this.serialNumberService.getSerialNumberByDate("SCH", "saleDelivery");
           this.saleDelivery.setCode(code);
         } catch (Exception e) {
           logger.error("error occur when get serialNumber", e);
         }
       }
     } else {
       this.saleDelivery = ((SaleDelivery)this.saleDeliveryService.getModel(this.saleDelivery.getId()));
       initModel(false, this.saleDelivery, loginMan);
     }
     this.paymentList = this.paymentService.select(new Payment());
     this.deliveryList = this.deliveryService.select(new Delivery());
     this.bankAccountList = this.bankAccountService.select(new BankAccount());
     return "edit_saleDelivery";
   }
 
   public void save()
   {
     logger.info("start save a sale delivery order");
 
     if (StringUtils.isBlank(this.saleDelivery.getBankAccountName())) {
       BankAccount bankAccount = (BankAccount)this.bankAccountService.getModel(this.saleDelivery.getBankAccountId());
       this.saleDelivery.setBankAccountName(bankAccount.getName());
     }
 
     if (StringUtils.isBlank(this.saleDelivery.getDeliveryCode())) {
       Delivery delivery = (Delivery)this.deliveryService.getModel(this.saleDelivery.getDeliveryId());
       this.saleDelivery.setDeliveryCode(delivery.getCode());
       this.saleDelivery.setDeliveryName(delivery.getName());
       this.saleDelivery.setCreateTime(new Date());
     }
     if (StringUtils.isBlank(this.saleDelivery.getId()))
     {
       String id = this.saleDeliveryService.makeId();
       this.saleDelivery.setId(id);
       try {
         this.saleDeliveryService.insert(this.saleDelivery);
         this.saleOrderService.updataDeliveryStateTime(this.saleDelivery.getOrderId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when insert a sale delivery", e);
       }
     } else {
       try {
         this.saleDeliveryService.update(this.saleDelivery);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update a sale delivery", e);
       }
       try {
         this.saleWareService.deleteBySaleId(this.saleDelivery.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete sale ware", e);
       }
 
     }
 
     if ((this.saleDelivery.getDeliveryState().equals("1")) && (StringUtils.isNotBlank(this.saleDelivery.getOrderId()))) {
       try {
         this.saleOrderService.updataDeliveryState(this.saleDelivery.getOrderId(), this.saleDelivery.getDeliveryState());
       } catch (Exception e) {
         logger.error("error occur when update sale order deliveyState", e);
       }
     }
 
     String saleId = this.saleDelivery.getId();
     if ((this.wareIdArr != null) && (this.wareIdArr.length != 0)) {
       for (int i = 0; i < this.wareIdArr.length; i++) {
         SaleWare saleWare = new SaleWare();
         saleWare.setSaleId(saleId);
         saleWare.setWareId(this.wareIdArr[i]);
         saleWare.setOrderNumber(this.orderNumberArr[i]);
         saleWare.setGoodPrice(this.goodPriceArr[i]);
         saleWare.setMoney(this.moneyArr[i]);
         saleWare.setPriceDiscount(this.priceDiscountArr[i]);
         saleWare.setWarehousePositionId(this.warehousePositionIdArr[i]);
         saleWare.setWarehousePositionName(this.warehousePositionNameArr[i]);
         saleWare.setType("1");
         saleWare.setSort(Integer.valueOf(i));
         try {
           this.saleWareService.insert(saleWare);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert a sale ware", e);
         }
 
         Map param = new HashMap();
         param.put("wareId", this.wareIdArr[i]);
         param.put("warehouseId", this.saleDelivery.getWarehouseId());
         param.put("warehouseName", this.saleDelivery.getWarehouseName());
         param.put("warehousePositionId", this.warehousePositionIdArr[i]);
         param.put("warehousePositionName", this.warehousePositionNameArr[i]);
         double orderNum = this.orderNumberArr[i].doubleValue();
         int changeNum = (int)orderNum;
 
         Good good = new Good();
         try {
           good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
         } catch (Exception e) {
           logger.error("error occur when get good by wareId", e);
         }
 
         int purchaseNum = 0;
         if (good.getPurchaseNum() != null) {
           purchaseNum = good.getPurchaseNum().intValue();
         }
 
         double total = 0.0D;
         if (good.getTotalCostInventory() != null) {
           total = good.getTotalCostInventory().doubleValue();
         }
 
         purchaseNum = (int)(purchaseNum - this.orderNumberArr[i].doubleValue());
         total -= this.moneyArr[i].doubleValue();
         int totalSales = 0;
 
         if ((good.getTotalSales() != null) && (good.getTotalSales().intValue() > 0))
           totalSales = good.getTotalSales().intValue() + this.orderNumberArr[i].intValue();
         else
           totalSales = this.orderNumberArr[i].intValue();
         try
         {
           this.goodService.updateGoodInventoryInfo(good.getId(), Double.valueOf(total), Integer.valueOf(purchaseNum));
 
           Good goodsale = new Good();
           goodsale.setTotalSales(Integer.valueOf(totalSales));
           this.goodService.update("Good.Good_info", goodsale);
         } catch (Exception e) {
           logger.error("error occur when update good", e);
         }
         try
         {
           this.warehouseWareService.updateInventory(param, 0 - changeNum, Double.valueOf(-1.0D));
         } catch (Exception e) {
           logger.error("error occur when update inventory", e);
         }
         try
         {
           this.warehousePositionWareService.updateWareNum(param, 0 - changeNum);
         } catch (Exception e) {
           logger.error("error occur when update ware number", e);
         }
 
       }
 
     }
 
     responseFlag(true);
   }
 
   public void delete()
   {
     try
     {
       logger.info("start to delete saleDelivery information");
       if (this.saleDelivery == null) {
         this.saleDelivery = new SaleDelivery();
       }
       String id = this.saleDelivery.getId();
 
       if (StringUtils.isNotBlank(id)) {
         String[] idArr = id.split(",");
         for (String idStr : idArr) {
           this.saleDeliveryService.delete(idStr);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.info("error occur when deleting saleDelivery information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public SaleDelivery getSaleDelivery() {
     return this.saleDelivery;
   }
   public void setSaleDelivery(SaleDelivery saleDelivery) {
     this.saleDelivery = saleDelivery;
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
   public List<Delivery> getDeliveryList() {
     return this.deliveryList;
   }
   public void setDeliveryList(List<Delivery> deliveryList) {
     this.deliveryList = deliveryList;
   }
   public List<BankAccount> getBankAccountList() {
     return this.bankAccountList;
   }
   public void setBankAccountList(List<BankAccount> bankAccountList) {
     this.bankAccountList = bankAccountList;
   }
   public String[] getWarehousePositionIdArr() {
     return this.warehousePositionIdArr;
   }
   public String[] getWarehousePositionNameArr() {
     return this.warehousePositionNameArr;
   }
   public void setWarehousePositionIdArr(String[] warehousePositionIdArr) {
     this.warehousePositionIdArr = warehousePositionIdArr;
   }
   public void setWarehousePositionNameArr(String[] warehousePositionNameArr) {
     this.warehousePositionNameArr = warehousePositionNameArr;
   }
   public GoodService getGoodService() {
     return this.goodService;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public PaymentService getPaymentService()
   {
     return this.paymentService;
   }
   public void setPaymentService(PaymentService paymentService) {
     this.paymentService = paymentService;
   }
   public List<Payment> getPaymentList() {
     return this.paymentList;
   }
   public void setPaymentList(List<Payment> paymentList) {
     this.paymentList = paymentList;
   }
   public SaleDeliveryService getSaleDeliveryService() {
     return this.saleDeliveryService;
   }
   public SaleOrderService getSaleOrderService() {
     return this.saleOrderService;
   }
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
   public SaleWareService getSaleWareService() {
     return this.saleWareService;
   }
   public DeliveryService getDeliveryService() {
     return this.deliveryService;
   }
   public BankAccountService getBankAccountService() {
     return this.bankAccountService;
   }
   public WarehouseWareService getWarehouseWareService() {
     return this.warehouseWareService;
   }
   public WarehousePositionWareService getWarehousePositionWareService() {
     return this.warehousePositionWareService;
   }
   public WareService getWareService() {
     return this.wareService;
   }
   public WarehouseService getWarehouseService() {
     return this.warehouseService;
   }
   public void setSaleDeliveryService(SaleDeliveryService saleDeliveryService) {
     this.saleDeliveryService = saleDeliveryService;
   }
 
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public void setSaleWareService(SaleWareService saleWareService) {
     this.saleWareService = saleWareService;
   }
 
   public void setDeliveryService(DeliveryService deliveryService) {
     this.deliveryService = deliveryService;
   }
 
   public void setBankAccountService(BankAccountService bankAccountService) {
     this.bankAccountService = bankAccountService;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setWarehousePositionWareService(WarehousePositionWareService warehousePositionWareService)
   {
     this.warehousePositionWareService = warehousePositionWareService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 }

/* 
 
 
 */