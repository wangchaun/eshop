 package com.sinokj.app.system.login.action;
 
 import com.sinokj.app.common.Static;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.front.model.WareComment;
import com.sinokj.app.front.service.WareCommentService;
import com.sinokj.app.order.sale.saleDelivery.model.SaleDelivery;
import com.sinokj.app.order.sale.saleDelivery.service.SaleDeliveryService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.system.user.entity.SysUserPower;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.system.user.service.SysUserPowerService;
import com.sinokj.app.system.user.service.SysUserService;
import com.sinokj.app.vip.message.model.Message;
import com.sinokj.app.vip.message.service.MessageService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.DateConverter;
import com.sinokj.code.util.DateUtil;

 import java.io.PrintStream;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
 
 public class SysLoginAction extends BaseAction
 {
   private static final long serialVersionUID = 2242763885608573292L;
   private static final Logger logger = Logger.getLogger(SysLoginAction.class);
   private SysUserService sysUserService;
   private SysUserPowerService sysUserPowerService;
   private Map<String, SysUserPower> powerMap;
   private Map<String, String> maplist;
   private SysUser sysUser;
   private String errorInfo;
   private SaleOrder saleOrder;
   private SaleOrderService saleOrderService;
   private List<SaleOrder> resultList;
   private Customer customer;
   private CustomerService customerService;
   private List<Customer> customerList;
   private SaleDelivery saleDelivery;
   private SaleDeliveryService saleDeliveryService;
   private Message message;
   private MessageService messageService;
   private WareComment wareComment;
   private WareCommentService wareCommentService;
 
   public Customer getCustomer()
   {
     return this.customer;
   }
 
   public List<Customer> getCustomerList() {
     return this.customerList;
   }
 
   public String getErrorInfo() {
     return this.errorInfo;
   }
 
   public Map<String, String> getMaplist() {
     return this.maplist;
   }
 
   public Message getMessage() {
     return this.message;
   }
 
   public Map<String, SysUserPower> getPowerMap() {
     return this.powerMap;
   }
 
   public List<SaleOrder> getResultList() {
     return this.resultList;
   }
 
   public SaleDelivery getSaleDelivery() {
     return this.saleDelivery;
   }
 
   public SaleOrder getSaleOrder() {
     return this.saleOrder;
   }
 
   public SysUser getSysUser() {
     return this.sysUser;
   }
 
   public WareComment getWareComment() {
     return this.wareComment;
   }
 
   public String index()
   {
     HttpServletRequest request = getRequest();
     request.getSession().removeAttribute("loginUser");
     return "index";
   }
 
   public String initBgIndex()
   {
     try
     {
       if (this.saleOrder == null) {
         this.saleOrder = new SaleOrder();
       }
       if (this.saleDelivery == null) {
         this.saleDelivery = new SaleDelivery();
       }
       if (this.message == null) {
         this.message = new Message();
       }
       if (this.wareComment == null) {
         this.wareComment = new WareComment();
       }
       this.resultList = this.saleOrderService.getSumSaleOrderList(this.saleOrder);
 
       this.saleOrder.setOrderState("0");
 
       this.saleOrder.setOrderStateNum(
         this.saleOrderService.getSumSaleOrderList(this.saleOrder).size());
       this.customerList = this.customerService.getSumCustomerList(this.customer);
       this.saleDelivery.setDeliveryState("0");
       if (this.saleDeliveryService.getSaleDeliveryDSAndPSSum(this.saleDelivery).size() > 0)
         this.saleDelivery.setDeliveryStateNum(this.saleDeliveryService.getSaleDeliveryDSAndPSSum(this.saleDelivery).size());
       else {
         this.saleDelivery.setDeliveryStateNum(0);
       }
       this.saleDelivery.setDeliveryState(null);
       this.saleDelivery.setPaymentState("0");
       if (this.saleDeliveryService.getSaleDeliveryDSAndPSSum(this.saleDelivery).size() > 0)
         this.saleDelivery.setPaymentStateNum(this.saleDeliveryService.getSaleDeliveryDSAndPSSum(this.saleDelivery).size());
       else {
         this.saleDelivery.setPaymentStateNum(0);
       }
       this.message.setReplyState("0");
 
       if (this.messageService.getMessageReplyStateSum(
         this.message).size() > 0) {
         this.message.setMessageNum(
           this.messageService.getMessageReplyStateSum(this.message).size());
       }
 
       this.wareComment.setType("0");
 
       if (this.wareCommentService.getWareCommentSum(
         this.wareComment).size() > 0)
         this.wareComment.setWareCommentNum(
           this.wareCommentService.getWareCommentSum(this.wareComment).size());
       else
         this.wareComment.setWareCommentNum(0);
     }
     catch (Exception e) {
       e.printStackTrace();
       System.out.println(e.getMessage());
     }
     return "bgIndex";
   }
 
   public String login()throws Exception{
     SysUser loginUser = getSessionUserInfo();
     HttpServletRequest request = getRequest();
     Map<String,Object> session=getSession();
     String viewDate=DateConverter.viewDate();
     if (loginUser != null) {
       request.setAttribute("loginUser", loginUser);
       request.setAttribute("ADMIN_LOGIN_USER_SUM", Integer.valueOf(Static.ADMIN_LOGIN_USER_SUM));
       this.powerMap = this.sysUserPowerService.getPowerMap(loginUser.getId());
       this.maplist = this.sysUserPowerService.getAllPower(loginUser.getId());
       return "main";
     }
     if (this.sysUser == null) {
       return "index";
     }
     String code = this.sysUser.getCode();
     String pwd = this.sysUser.getPwd();

     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     String id = "1";
     SysUser sysUser1 = (SysUser)this.sysUserService.getModel(id);
     System.out.println("============================================");
     System.out.println(sysUser1.getName());
     System.out.println(sysUser1.getBegin());
     String date1 = dateFormat.format(new Date());
     String date2 = dateFormat.format(sysUser1.getEnd());
 
     Date dt1 = dateFormat.parse(date1);
     Date dt2 = dateFormat.parse(date2);
 
     long diff = dt2.getTime() - dt1.getTime();
     long days = diff / 86400000L;
     System.out.println(days + "天++++++++++++++++++++++++++++++++");
 

     try{
       boolean isValid = this.sysUserService.isSystemUser(code, pwd);
       if (isValid) {
         
    	 this.sysUser = this.sysUserService.getSysUser(this.sysUser);
         logger.info("user:" + code + ",login successed!");
         loginUser = this.sysUser;
         session.put("viewDate",viewDate);
         request.setAttribute("loginUser", loginUser);
         request.getSession().setAttribute("loginUser", loginUser);
         this.powerMap = this.sysUserPowerService.getPowerMap(loginUser.getId());
         this.maplist = this.sysUserPowerService.getAllPower(loginUser.getId());
         request.getSession().setAttribute("userpowermap", this.maplist);
 
         if ((sysUser1 != null) && 
           (dateFormat.format(sysUser1.getBegin()).equals("2013-10-01")))
         {
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(sysUser1.getBegin());
           calendar.add(5, 90);
           Date newDate = calendar.getTime();
 
           sysUser1.setBegin(new Date());
 
           sysUser1.setEnd(newDate);
           this.sysUserService.update(sysUser1);
         }
 
         return "main";
       }
       this.errorInfo = "账号或密码错误";
       logger.info("user:" + code + ",login failed!");
 
       return "index";
     }
     catch (Exception e) {
       if (this.sysUser != null)
         logger.error("error occur when user login !account:" + code, e);
       else {
         logger.error("error occur when user login !systemUser is null", e);
       }
       String tips = "系统错误，请重试！";
       request.setAttribute("error_info", tips);
     }return "index";
   }
 
   public String logout(){
     SysUser loginUser = getSessionUserInfo();
     if (loginUser != null) {
       logger.info(loginUser.getCode() + " logout!");
       HttpServletRequest request = getRequest();
       request.getSession().removeAttribute("loginUser");
       request.getSession().removeAttribute("userpowermap");
       request.getSession().removeAttribute("viewDate");
     }
 
     return "logout";
   }
 
   public String mainInfo()
   {
     return "mainInfo";
   }
 
   public void setCustomer(Customer customer) {
     this.customer = customer;
   }
 
   public void setCustomerList(List<Customer> customerList) {
     this.customerList = customerList;
   }
 
   public void setCustomerService(CustomerService customerService) {
     this.customerService = customerService;
   }
 
   public void setErrorInfo(String errorInfo) {
     this.errorInfo = errorInfo;
   }
 
   public void setMaplist(Map<String, String> maplist) {
     this.maplist = maplist;
   }
 
   public void setMessage(Message message) {
     this.message = message;
   }
 
   public void setMessageService(MessageService messageService) {
     this.messageService = messageService;
   }
 
   public void setPowerMap(Map<String, SysUserPower> powerMap) {
     this.powerMap = powerMap;
   }
 
   public void setResultList(List<SaleOrder> resultList) {
     this.resultList = resultList;
   }
 
   public void setSaleDelivery(SaleDelivery saleDelivery) {
     this.saleDelivery = saleDelivery;
   }
 
   public void setSaleDeliveryService(SaleDeliveryService saleDeliveryService) {
     this.saleDeliveryService = saleDeliveryService;
   }
 
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
 
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
 
   public void setSysUser(SysUser sysUser) {
     this.sysUser = sysUser;
   }
 
   public void setSysUserPowerService(SysUserPowerService sysUserPowerService) {
     this.sysUserPowerService = sysUserPowerService;
   }
 
   public void setSysUserService(SysUserService sysUserService) {
     this.sysUserService = sysUserService;
   }
 
   public void setWareComment(WareComment wareComment) {
     this.wareComment = wareComment;
   }
 
   public void setWareCommentService(WareCommentService wareCommentService) {
     this.wareCommentService = wareCommentService;
   }
 }

/* 
 
 
 */