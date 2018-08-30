 package com.sinokj.app.component.chinaBank.action;
 
 import beartool.MD5;

import com.sinokj.app.component.chinaBank.service.ChinaBankService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.order.sale.saleCollection.model.SaleCollection;
import com.sinokj.app.order.sale.saleCollection.model.SaleCollectionItem;
import com.sinokj.app.order.sale.saleCollection.service.SaleCollectionItemService;
import com.sinokj.app.order.sale.saleCollection.service.SaleCollectionService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.code.struct.BaseAction;

 import java.io.PrintStream;
 import java.util.Date;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
 
 public class ChinaBankAction extends BaseAction
 {
   private static final long serialVersionUID = -4374982338674524722L;
   private static final Logger logger = Logger.getLogger(BaseAction.class);
   private SaleOrderService saleOrderService;
   private SaleOrder saleOrder;
   private SaleCollection saleCollection;
   private SaleCollectionService saleCollectionService;
   private SaleCollectionItem saleCollectionItem;
   private SaleCollectionItemService saleCollectionItemService;
   private SerialNumberService serialNumberService;
   private ChinaBankService chinaBankService;
   private List<Information> informationList;
   private InformationService informationService;
 
   public List<Information> getInformationList()
   {
     return this.informationList;
   }
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
   public SaleOrder getSaleOrder() {
     return this.saleOrder;
   }
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
   public SaleCollection getSaleCollection() {
     return this.saleCollection;
   }
   public void setSaleCollection(SaleCollection saleCollection) {
     this.saleCollection = saleCollection;
   }
   public SaleCollectionItem getSaleCollectionItem() {
     return this.saleCollectionItem;
   }
   public void setSaleCollectionItem(SaleCollectionItem saleCollectionItem) {
     this.saleCollectionItem = saleCollectionItem;
   }
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
   public void setSaleCollectionService(SaleCollectionService saleCollectionService) {
     this.saleCollectionService = saleCollectionService;
   }
 
   public void setSaleCollectionItemService(SaleCollectionItemService saleCollectionItemService) {
     this.saleCollectionItemService = saleCollectionItemService;
   }
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
   public void setChinaBankService(ChinaBankService chinaBankService) {
     this.chinaBankService = chinaBankService;
   }
 
   public void getChinaBankError()
   {
     HttpServletRequest request = getRequest();
     String orderId = request.getParameter("orderId");
     if (orderId != null) {
       SaleOrder saleOrder = (SaleOrder)this.saleOrderService.getModel(orderId);
       if (saleOrder != null)
         responseFlag(true);
       else
         responseFlag("订单为空");
     }
     else {
       responseFlag("订单Id为空");
     }
   }
 
   public String chinaBankto()
   {
     HttpServletRequest request = getRequest();
     String orderId = request.getParameter("orderId");
 
     String chinaBankForm = this.chinaBankService.buildchinaBanktoForm(orderId);
 
     getRequest().setAttribute("chinaBankForm", chinaBankForm);
     return "chinaBankto";
   }
 
   public String receive()
   {
     HttpServletRequest request = getRequest();
     this.informationList = this.informationService.select(new Information());
 
     String v_oid = request.getParameter("v_oid");
     String v_pmode = request.getParameter("v_pmode");
     String v_pstatus = request.getParameter("v_pstatus");
     String v_pstring = request.getParameter("v_pstring");
     String v_amount = request.getParameter("v_amount");
     String v_moneytype = request.getParameter("v_moneytype");
     String v_md5str = request.getParameter("v_md5str");
     String key = "quanshetongxingdu202400";
     String text = v_oid + v_pstatus + v_amount + v_moneytype + key;
     MD5 md5 = new MD5();
     String v_md5text = md5.getMD5ofStr(text).toUpperCase();
 
     Double totalFee = Double.valueOf(0.0D);
     if (v_amount != null) {
       totalFee = Double.valueOf(Double.parseDouble(v_amount));
     }
     if (v_md5str.equals(v_md5text))
     {
       if ("20".equals(v_pstatus))
       {
         try {
           this.saleOrder = this.saleOrderService.getOrderByZfbTradeNo(v_oid);
         } catch (Exception e) {
           e.printStackTrace();
         }
         String orderId = this.saleOrder.getId();
         Double alreadyMoney = Double.valueOf(0.0D);
         try {
           this.saleCollection = this.saleCollectionService.getSaleCollectionByOrderId(orderId);
           if (this.saleCollection != null)
           {
             SaleCollectionItem saleCollectionItem = this.saleCollectionItemService.getSaleCollectionBycollectionId(this.saleCollection.getId());
             if (saleCollectionItem != null) {
               alreadyMoney = saleCollectionItem.getMoneyCurrentReceived();
             }
             this.saleCollection.setMoneyAccount(Double.valueOf(this.saleCollection.getMoneyAccount().doubleValue() + totalFee.doubleValue()));
             this.saleCollectionService.update(this.saleCollection);
 
             saleCollectionItem.setMoneyCurrentReceived(Double.valueOf(saleCollectionItem.getMoneyCurrentReceived().doubleValue() + totalFee.doubleValue()));
             this.saleCollectionItemService.update(saleCollectionItem);
           } else {
             this.saleCollection = new SaleCollection();
             String id = this.saleCollectionService.makeId();
             this.saleCollection.setId(id);
             String code = this.serialNumberService.getSerialNumberByDate("SSK", "saleCollection");
             this.saleCollection.setCode(code);
             this.saleCollection.setOrderId(orderId);
             this.saleCollection.setCustomerId(this.saleOrder.getCustomerId());
             this.saleCollection.setCustomerName(this.saleOrder.getCustomerName());
             this.saleCollection.setLinkman(this.saleOrder.getLinkman());
             this.saleCollection.setMobile(this.saleOrder.getMobile());
             this.saleCollection.setPaymentId(this.saleOrder.getPaymentId());
             this.saleCollection.setPaymentName(this.saleOrder.getPaymentName());
             this.saleCollection.setPaymentCode(this.saleOrder.getPaymentCode());
             this.saleCollection.setPaymentState("1");
             this.saleCollection.setMoneyAccount(totalFee);
             this.saleCollectionService.insert(this.saleCollection);
 
             this.saleCollectionItem = new SaleCollectionItem();
             this.saleCollectionItem.setId(this.saleCollectionItemService.makeId());
             this.saleCollectionItem.setCollectionId(id);
             this.saleCollectionItem.setOrderId(orderId);
             this.saleCollectionItem.setMoneyAccount(this.saleOrder.getOrderMoney());
             this.saleCollectionItem.setMoneyAlreadyReceived(Double.valueOf(0.0D));
             this.saleCollectionItem.setMoneyCurrentReceived(totalFee);
             this.saleCollectionItem.setSort(Integer.valueOf(0));
             this.saleCollectionItemService.insert(this.saleCollectionItem);
           }
         } catch (Exception e) {
           e.printStackTrace();
         }
 
         Double orderMoney = this.saleOrder.getOrderMoney();
 
         Double mustMoney = Double.valueOf(orderMoney.doubleValue() - alreadyMoney.doubleValue());
         if (totalFee.doubleValue() >= mustMoney.doubleValue())
           this.saleOrder.setPaymentState("2");
         else if ((totalFee.doubleValue() < mustMoney.doubleValue()) && (totalFee.doubleValue() > 0.0D))
           this.saleOrder.setPaymentState("1");
         else {
           this.saleOrder.setPaymentState("0");
         }
         try
         {
           this.saleOrderService.update(this.saleOrder);
         } catch (Exception e) {
           logger.error("error when update order!!", e);
         }
 
         request.setAttribute("orderNo", v_oid);
         request.setAttribute("totalFee", v_amount);
         request.setAttribute("currentTime", new Date());
         request.setAttribute("linkman", this.saleOrder.getLinkman());
         request.setAttribute("paymentName", this.saleOrder.getPaymentName());
 
         return "success";
       }
       return "error";
     }
 
     System.out.print("校验失败,数据可疑");
     return "error";
   }
 }