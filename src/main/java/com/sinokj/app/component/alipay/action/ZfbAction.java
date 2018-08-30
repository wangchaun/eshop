 package com.sinokj.app.component.alipay.action;
 
 import com.sinokj.app.component.alipay.service.ZfbService;
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
 import java.io.UnsupportedEncodingException;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class ZfbAction extends BaseAction
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
   private List<Information> informationList;
   private InformationService informationService;
   private ZfbService zfbService;
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public SaleOrder getSaleOrder() {
     return this.saleOrder;
   }
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
   public void setZfbService(ZfbService zfbService) {
     this.zfbService = zfbService;
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
   public void setSaleCollectionService(SaleCollectionService saleCollectionService) {
     this.saleCollectionService = saleCollectionService;
   }
 
   public void setSaleCollectionItemService(SaleCollectionItemService saleCollectionItemService) {
     this.saleCollectionItemService = saleCollectionItemService;
   }
 
   public void getZfbPayError()
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
 
   public void getZfbPayError2()
   {
     HttpServletRequest request = getRequest();
     String orderId = request.getParameter("orderId");
     String bankCode = request.getParameter("bankCode");
 
     if (orderId != null)
     {
       SaleOrder saleOrder = (SaleOrder)this.saleOrderService.getModel(orderId);
       if (saleOrder != null) {
         if ((bankCode != null) && (!bankCode.equals("")))
         {
           responseFlag(true);
         }
         else responseFlag("未获取到银行编码");
       }
       else
         responseFlag("订单为空");
     }
     else {
       responseFlag("订单Id为空");
     }
   }
 
   public String alipayto()
   {
     HttpServletRequest request = getRequest();
 
     String orderId = request.getParameter("orderId");
 
     String zfbForm = this.zfbService.buildPayForm(orderId);
     getRequest().setAttribute("zfbForm", zfbForm);
     return "alipayto";
   }
 
   public String alipayto2()
   {
     HttpServletRequest request = getRequest();
 
     String orderId = request.getParameter("orderId");
 
     String bankCode = request.getParameter("bankCode");
 
     String zfbForm = this.zfbService.buildPayForm2(orderId, bankCode);
     getRequest().setAttribute("zfbForm", zfbForm);
     return "alipayto";
   }
 
   public void alipaynotify()
     throws UnsupportedEncodingException
   {
     System.out.println("-----------------------------异步方法----------------------------------");
     logger.info("-----------------------------异步方法----------------------------------");
     boolean result = false;
 
     HttpServletRequest request = getRequest();
 
     Map aliParams = new HashMap();
     Map requestParams = request.getParameterMap();
     for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
       String name = (String)iter.next();
       String[] values = (String[])requestParams.get(name);
       String valueStr = "";
       for (int i = 0; i < values.length; i++) {
         valueStr = 
           valueStr + values[i] + ",";
       }
 
       aliParams.put(name, valueStr);
     }
     logger.debug("aliParams:" + aliParams);
 
     String trade_status = request.getParameter("trade_status");
     String trade_no = request.getParameter("trade_no");
     String order_no = request.getParameter("out_trade_no");
     String total_fee = request.getParameter("total_fee");
 
     Double totalFee = Double.valueOf(0.0D);
     if (total_fee != null) {
       totalFee = Double.valueOf(Double.parseDouble(total_fee));
     }
     logger.info("alipay notify,trade_status=" + trade_status + ";order_no=" + order_no + ";trade_no=" + trade_no);
     String refund_status = request.getParameter("refund_status");
     if (StringUtils.isNotBlank(refund_status)) {
       logger.info("refund_status=" + refund_status);
     }
 
     boolean verify_result = ZfbService.verify(aliParams);
     logger.info("verify_result:" + verify_result);
 
     if (verify_result) {
       if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS")))
       {
         result = true;
       }
       else result = true;
 
       try
       {
         this.saleOrder = this.saleOrderService.getOrderByZfbTradeNo(trade_no);
       }
       catch (Exception e) {
         e.printStackTrace();
       }
 
       String zfbTradeNo = this.saleOrder.getZfbTradeNo();
       if (StringUtils.isBlank(zfbTradeNo)) {
         this.saleOrder.setZfbTradeNo(trade_no);
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
 
       try
       {
         this.saleOrder.setPaymentState("2");
         this.saleOrderService.update(this.saleOrder);
         result = true;
       } catch (Exception e) {
         logger.error("error when update order!!", e);
       }
     }
     String resultStr = result ? "success" : "fail";
     responseFlag(resultStr);
   }
 
   public String alipayreturn()
     throws UnsupportedEncodingException
   {
     System.out.println("-----------------------------同步方法----------------------------------");
     logger.info("-----------------------------同步方法----------------------------------");
 
     HttpServletRequest request = getRequest();
 
     this.informationList = this.informationService.select(new Information());
     Map aliParams = new HashMap();
 
     Map requestParams = request.getParameterMap();
     for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
       String name = (String)iter.next();
       String[] values = (String[])requestParams.get(name);
       String valueStr = "";
       for (int i = 0; i < values.length; i++) {
         valueStr = 
           valueStr + values[i] + ",";
       }
 
       aliParams.put(name, valueStr);
     }
 
     String trade_status = request.getParameter("trade_status");
     String trade_no = request.getParameter("trade_no");
     String order_no = request.getParameter("out_trade_no");
     String total_fee = request.getParameter("total_fee");
     Double totalFee = Double.valueOf(0.0D);
     if (total_fee != null) {
       totalFee = Double.valueOf(Double.parseDouble(total_fee));
     }
     logger.info("alipay notify,trade_status=" + trade_status + ";order_no=" + order_no + ";trade_no=" + trade_no);
 
     boolean verify_result = ZfbService.verify(aliParams);
     if (verify_result)
     {
       try {
         this.saleOrder = this.saleOrderService.getOrderByOrderCode(order_no);
       } catch (Exception e) {
         e.printStackTrace();
       }
       this.saleOrder.setZfbTradeNo(trade_no);
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
 
       try
       {
         this.saleOrder.setPaymentState("2");
         this.saleOrderService.update(this.saleOrder);
       } catch (Exception e) {
         logger.error("error when update order!!", e);
       }
 
       request.setAttribute("tradeNo", trade_no);
       request.setAttribute("orderNo", order_no);
       request.setAttribute("totalFee", total_fee);
       request.setAttribute("currentTime", new Date());
       request.setAttribute("linkman", this.saleOrder.getLinkman());
       request.setAttribute("paymentName", this.saleOrder.getPaymentName());
       return "success";
     }
     return "error";
   }
 
   public List<Information> getInformationList() {
     return this.informationList;
   }
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
   public InformationService getInformationService() {
     return this.informationService;
   }
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
 }