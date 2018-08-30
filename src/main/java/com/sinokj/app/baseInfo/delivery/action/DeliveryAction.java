 package com.sinokj.app.baseInfo.delivery.action;
 
 import com.sinokj.app.baseInfo.delivery.model.Delivery;
import com.sinokj.app.baseInfo.delivery.service.DeliveryService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class DeliveryAction extends BaseAction
 {
   private static final long serialVersionUID = -8707540811928038122L;
   private static final Logger logger = Logger.getLogger(DeliveryAction.class);
   private DeliveryService deliveryService;
   private Delivery delivery;
 
   public void setDeliveryService(DeliveryService deliveryService)
   {
     this.deliveryService = deliveryService;
   }
 
   public String listJson()
   {
     logger.info("start list all DeliveryWay data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
 
       resultList = this.deliveryService.pageList(pageInfo, this.delivery, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list DeliveryWay data!", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
 
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
 
     logger.info("finish list all DeliveryWay data!");
     return "success";
   }
 
   public String list()
   {
     return "list_delivery";
   }
 
   public String edit()
   {
     try
     {
       SysUser loginMan = getSessionUserInfo();
       if (this.delivery == null) {
         this.delivery = new Delivery();
       }
       String id = this.delivery.getId();
       if (StringUtils.isBlank(id)) {
         super.initModel(true, this.delivery, loginMan);
       } else {
         this.delivery = ((Delivery)this.deliveryService.getModel(id));
         super.initModel(false, this.delivery, loginMan);
       }
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     return "edit_delivery";
   }
 
   public void save()
   {
     try
     {
       String id = this.delivery.getId();
 
       if (StringUtils.isBlank(id))
         this.deliveryService.insert(this.delivery);
       else {
         this.deliveryService.update(this.delivery);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save model!", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
 
     String id = this.delivery.getId();
     logger.info("delete DeliveryWay,id:" + id);
     try
     {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.deliveryService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete DeliveryWay,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete DeliveryWay,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.delivery.getId();
     String code = this.delivery.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       Delivery way = this.deliveryService.getDelivery(this.delivery);
       if (way == null) {
         isCodeExisted = false;
       }
       else if (id.equals(way.getId()))
         isCodeExisted = false;
       else {
         isCodeExisted = true;
       }
 
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public void isNameExisted()
   {
     boolean isCodeExisted = true;
 
     String name = this.delivery.getName();
     logger.info("check isCodeExisted,code:" + name);
     try {
       Delivery way = (Delivery)this.deliveryService.selectOne(this.delivery);
       if (way == null)
         isCodeExisted = true;
       else {
         isCodeExisted = false;
       }
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public Delivery getDelivery()
   {
     return this.delivery;
   }
   public void setDelivery(Delivery delivery) {
     this.delivery = delivery;
   }
 }