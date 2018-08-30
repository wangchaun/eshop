 package com.sinokj.app.order.sale.saleDelivery.service;
 
 import com.sinokj.app.order.sale.saleDelivery.model.SaleDelivery;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class SaleDeliveryService extends BaseService<SaleDelivery>
 {
   private SaleOrderService saleOrderService;
 
   public void setSaleOrderService(SaleOrderService saleOrderService)
   {
     this.saleOrderService = saleOrderService;
   }
 
   public SaleDelivery getSaleDeliveryByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     SaleDelivery saleDelivery = (SaleDelivery)this.publicDAO.selectOne("SaleDelivery.SaleDelivery", param);
     return saleDelivery;
   }
 
   public void updateDeliveryInfo(String id, Double changeMoney)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("id is null");
     }
     SaleDelivery saleDelivery = (SaleDelivery)getModel(id);
     if (saleDelivery != null) {
       Double moneyAccount = saleDelivery.getMoneyAccount();
       Double moneyReceived = Double.valueOf(0.0D);
       if (saleDelivery.getMoneyReceived() != null) {
         moneyReceived = saleDelivery.getMoneyReceived();
       }
 
       moneyReceived = Double.valueOf(moneyReceived.doubleValue() + changeMoney.doubleValue());
       if ((moneyReceived.doubleValue() > 0.0D) && (moneyReceived.doubleValue() < moneyAccount.doubleValue()))
         saleDelivery.setPaymentState("1");
       else if (moneyReceived.equals(moneyAccount)) {
         saleDelivery.setPaymentState("2");
       }
       saleDelivery.setMoneyReceived(moneyReceived);
       update(saleDelivery);
 
       if (StringUtils.isNotBlank(saleDelivery.getOrderId()))
         this.saleOrderService.updataPaymentState(saleDelivery.getOrderId(), saleDelivery.getPaymentState());
     }
   }
 
   public void updateDelivery(String id, Double changeMoney)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("id is null");
     }
     SaleDelivery saleDelivery = (SaleDelivery)getModel(id);
     if (saleDelivery != null) {
       Double moneyAccount = saleDelivery.getMoneyAccount();
       Double moneyReceived = Double.valueOf(0.0D);
       if (saleDelivery.getMoneyReceived() != null) {
         moneyReceived = saleDelivery.getMoneyReceived();
       }
 
       moneyReceived = Double.valueOf(moneyReceived.doubleValue() + changeMoney.doubleValue());
       if ((moneyReceived.doubleValue() > 0.0D) && (moneyReceived.doubleValue() < moneyAccount.doubleValue()))
         saleDelivery.setPaymentState("1");
       else if (moneyReceived.equals(moneyAccount)) {
         saleDelivery.setPaymentState("2");
       }
       saleDelivery.setMoneyReceived(moneyReceived);
       this.publicDAO.update("SaleDelivery.SaleDelivery", saleDelivery);
 
       if (StringUtils.isNotBlank(saleDelivery.getOrderId()))
         this.saleOrderService.updataPaymentState(saleDelivery.getOrderId(), saleDelivery.getPaymentState());
     }
   }
 
   public List<SaleDelivery> getCustomerWlz(SaleDelivery saleDelivery)
   {
     List list = this.publicDAO.select("SaleDelivery.SaleDelivery_CustomerLwz", saleDelivery);
     return list;
   }
 
   public List<SaleDelivery> getSaleDeliveryDSAndPSSum(SaleDelivery saleDelivery)
   {
     List list = this.publicDAO.select("SaleDelivery.SaleDelivery", saleDelivery);
     return list;
   }
 }

/* 
 
 
 */