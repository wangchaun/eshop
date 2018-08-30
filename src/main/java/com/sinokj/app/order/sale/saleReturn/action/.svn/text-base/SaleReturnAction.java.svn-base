 package com.sinokj.app.order.sale.saleReturn.action;
 
 import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.delivery.model.Delivery;
import com.sinokj.app.baseInfo.delivery.service.DeliveryService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.order.pay.SaleOrderPayService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.order.sale.saleReturn.model.SaleReturn;
import com.sinokj.app.order.sale.saleReturn.service.SaleReturnService;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SaleReturnAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(SaleReturnAction.class);
   private SaleReturn saleReturn;
   private SaleReturnService saleReturnService;
   private GoodService goodService;
   private WarehouseWareService warehouseWareService;
   private WareService wareService;
   private SaleOrder saleOrder;
   private SaleOrderService saleOrderService;
   private SerialNumberService serialNumberService;
   private SaleWareService saleWareService;
   private DeliveryService deliveryService;
   private BankAccountService bankAccountService;
   private List<Delivery> deliveryList;
   private List<BankAccount> bankAccountList;
   private String[] wareIdArr;
   private String[] wareNameArr;
   private Double[] orderNumberArr;
   private Double[] goodPriceArr;
   private Double[] moneyArr;
   private Double[] priceDiscountArr;
   private SaleOrderPayService payService;
   private CustomerService customerService;
   public void setSaleReturnService(SaleReturnService saleReturnService)
   {
     this.saleReturnService = saleReturnService;
   }
 
   public void setSaleOrderService(SaleOrderService saleOrderService)
   {
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
 
   public String list(){
     return "list_saleReturn";
   }
 
   public String listJson(){
     logger.info("start list sale return order!");
     List<SaleReturn> resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.saleReturn == null) {
         this.saleReturn = new SaleReturn();
       }
       resultList = this.saleReturnService.pageList(pageInfo, this.saleReturn, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list sale return order", e);
     }
     if (resultList == null) {
       resultList = new ArrayList<SaleReturn>();
     }
     this.jsonMap = new HashMap<String,Object>();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all sale return order!");
     return "success";
   }
 
   public String edit(){
     SysUser loginMan = getSessionUserInfo();
     if (this.saleReturn == null) {
       this.saleReturn = new SaleReturn();
     }
     if (StringUtils.isBlank(this.saleReturn.getId())){
       if ((this.saleOrder != null) && (StringUtils.isNotBlank(this.saleOrder.getId()))) {
         this.saleOrder = ((SaleOrder)this.saleOrderService.getModel(this.saleOrder.getId()));
         this.saleReturn.setOrderId(this.saleOrder.getId());
         this.saleReturn.setBankAccountId(this.saleOrder.getBankAccountId());
         this.saleReturn.setBankAccountName(this.saleOrder.getBankAccountName());
         this.saleReturn.setCustomerId(this.saleOrder.getCreatorId());
         this.saleReturn.setCustomerName(this.saleOrder.getCustomerName());
         this.saleReturn.setMoneyAccount(this.saleOrder.getOrderMoney());
         this.saleReturn.setDeliveryCost(this.saleOrder.getDeliveryCost());
         this.saleReturn.setLinkman(this.saleOrder.getLinkman());
         this.saleReturn.setMobile(this.saleOrder.getMobile());
         this.saleReturn.setDeliveryId(this.saleOrder.getDeliveryId());
         this.saleReturn.setDeliveryCode(this.saleOrder.getDeliveryCode());
         this.saleReturn.setDeliveryName(this.saleOrder.getDeliveryName());
         this.saleReturn.setState("c");
       }
       if (StringUtils.isBlank(this.saleReturn.getCreatorId())) {
         initModel(true, this.saleReturn, loginMan);
         this.saleReturn.setReturnState("0");
         this.saleReturn.setHandlerId(loginMan.getId());
         this.saleReturn.setHandlerName(loginMan.getName());
         this.saleReturn.setDeptId(loginMan.getDeptId());
         this.saleReturn.setDeptName(loginMan.getDeptName());
        
         try {
           String code = this.serialNumberService.getSerialNumberByDate("STH", "saleReturn");
           this.saleReturn.setCode(code);
         } catch (Exception e) {
           logger.error("error occur when get serialNumber", e);
         }
       }
     } else {
       this.saleReturn = ((SaleReturn)this.saleReturnService.getModel(this.saleReturn.getId()));
       initModel(false, this.saleReturn, loginMan);
     }
 
     this.deliveryList = this.deliveryService.select(new Delivery());
     this.bankAccountList = this.bankAccountService.select(new BankAccount());
     return "edit_saleReturn";
   }
 
   public void save(){
     SysUser loginMan = getSessionUserInfo();
     logger.info("start save a sale delivery order");
 
     BankAccount bankAccount = (BankAccount)this.bankAccountService.getModel(this.saleReturn.getBankAccountId());
     this.saleReturn.setBankAccountName(bankAccount.getName());
 
     Delivery delivery = (Delivery)this.deliveryService.getModel(this.saleReturn.getDeliveryId());
     this.saleReturn.setDeliveryCode(delivery.getCode());
     this.saleReturn.setDeliveryName(delivery.getName());
     this.saleReturn.setDeliveryCost(delivery.getDeliveryFee());
 
     this.saleReturn.setHandlerId(loginMan.getId());
     this.saleReturn.setHandlerName(loginMan.getName());
     this.saleReturn.setDeptId(loginMan.getDeptId());
     this.saleReturn.setDeptName(loginMan.getDeptName());
    
     if (StringUtils.isBlank(this.saleReturn.getId())) {
       String id = this.saleReturnService.makeId();
       this.saleReturn.setId(id);
      
       try {
         this.saleReturnService.insert(this.saleReturn);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when insert a sale delivery", e);
       }
     } else {
       try {
         if ((this.saleReturn.getOrderstateTime() == null) || (this.saleReturn.getOrderstateTime().equals(""))) {
           this.saleReturn.setOrderstateTime(new Date());
         }
         this.saleReturnService.update(this.saleReturn);
         
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update a sale delivery", e);
       }
       try {
         this.saleWareService.deleteBySaleId(this.saleReturn.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete sale ware", e);
       }
       if(this.saleReturn.getReturnState().equals("2")){//在退款单中针对退货商品审核，如审核通过，退回3卡内金额和积分数量。
    	   try {
           SaleOrder saleOrder = ((SaleOrder)this.saleOrderService.getModel(this.saleReturn.getOrderId()));
    	   Customer customer=(Customer)(this.customerService.getModel(saleOrder.getCustomerId()));
    	   
    	   SaleWare saleWare=new SaleWare();
    	   saleWare.setSaleId(saleOrder.getId());
    	   double money=this.saleWareService.select(saleWare).get(0).getMoney();
		   
    	   payService=new SaleOrderPayService();
    	   payService.returnPays(saleOrder.getCode(),customer,money);
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
       }
     }
//     String saleId = this.saleReturn.getId();
//     if ((this.wareIdArr != null) && (this.wareIdArr.length != 0)) {
//       for (int i = 0; i < this.wareIdArr.length; i++) {
//         SaleWare saleWare = new SaleWare();
//         saleWare.setSaleId(saleId);
//         saleWare.setWareId(this.wareIdArr[i]);
//         saleWare.setOrderNumber(this.orderNumberArr[i]);
//         saleWare.setGoodPrice(this.goodPriceArr[i]);
//         saleWare.setMoney(this.moneyArr[i]);
//         saleWare.setPriceDiscount(this.priceDiscountArr[i]);
//         saleWare.setType("2");
//         saleWare.setSort(Integer.valueOf(i));
//         try {
//           this.saleWareService.insert(saleWare);
//         } catch (Exception e) {
//           responseFlag(false);
//           logger.error("error occur when insert a sale ware", e);
//         }
//         Map param = new HashMap();
//         param.put("wareId", this.wareIdArr[i]);
//         param.put("wareName", this.wareNameArr[i]);
//         param.put("warehouseId", this.saleReturn.getWarehouseId());
//         param.put("warehouseName", this.saleReturn.getWarehouseName());
//         double orderNum = this.orderNumberArr[i].doubleValue();
//         int changeNum = (int)orderNum;
//         double warePrice = this.goodPriceArr[i].doubleValue();
//         try
//         {
//           this.warehouseWareService.updateInventory(param, changeNum, Double.valueOf(warePrice));
//         } catch (Exception e) {
//           responseFlag(false);
//           logger.error("error occur when updateInventory", e);
//         }
// 
//         Good good = new Good();
//         try {
//           good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
//         } catch (Exception e) {
//           responseFlag(false);
//           logger.error("error occur when get good by wareId", e);
//         }
// 
//         int purchaseNum = 0;
//         if (good.getPurchaseNum() != null) {
//           purchaseNum = good.getPurchaseNum().intValue();
//         }
//         purchaseNum = (int)(purchaseNum + this.orderNumberArr[i].doubleValue());
//         try {
//           this.goodService.updateGoodInventory(good.getId(), Integer.valueOf(purchaseNum));
//         } catch (Exception e) {
//           responseFlag(false);
//           logger.error("error occur when update good inventory", e);
//         }
// 
//         try
//         {
//           Double numberD = this.orderNumberArr[i];
//           String numberStr = String.valueOf(numberD);
//           int number = Integer.valueOf(numberStr.toString().substring(0, numberStr.toString().indexOf("."))).intValue();
//           this.wareService.updateWareStock(this.wareIdArr[i], number);
//         } catch (Exception e) {
//           logger.error("error occur when update ware stock", e);
//         }
//       }
//     }
     responseFlag(true);
   }
 
   public void delete()
   {
     try
     {
       logger.info("start to delete saleReturn information");
       if (this.saleReturn == null) {
         this.saleReturn = new SaleReturn();
       }
       String id = this.saleReturn.getId();
 
       if (StringUtils.isNotBlank(id)) {
         String[] idArr = id.split(",");
         for (String idStr : idArr) {
           this.saleReturnService.delete(idStr);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.info("error occur when deleting saleReturn information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void updateReturnSate()throws Exception  {
     try
     {
       if (this.saleReturn == null) {
         this.saleReturn = new SaleReturn();
       }
       String id = this.saleReturn.getId();
       if (StringUtils.isNotBlank(id)) {
         this.saleReturn = ((SaleReturn)this.saleReturnService.getModel(id));
         this.saleReturn.setReturnTime(new Date());
         this.saleReturn.setReturnState("2");
         this.saleReturnService.update(this.saleReturn);
         responseFlag(true);
       }
     } catch (RuntimeException e) {
       e.printStackTrace();
       responseFlag(false);
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
   public SaleReturn getSaleReturn() {
     return this.saleReturn;
   }
   public void setSaleReturn(SaleReturn saleReturn) {
     this.saleReturn = saleReturn;
   }
   public List<Delivery> getDeliveryList() {
     return this.deliveryList;
   }
   public List<BankAccount> getBankAccountList() {
     return this.bankAccountList;
   }
   public void setDeliveryList(List<Delivery> deliveryList) {
     this.deliveryList = deliveryList;
   }
   public void setBankAccountList(List<BankAccount> bankAccountList) {
     this.bankAccountList = bankAccountList;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }

public void setCustomerService(CustomerService customerService) {
	this.customerService = customerService;
}
 }