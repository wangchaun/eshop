 package com.sinokj.app.vip.level.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.level.model.VipLevel;
import com.sinokj.app.vip.level.service.VipLevelService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class VipLevelAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(VipLevelAction.class);
   private VipLevel vipLevel;
   private VipLevelService vipLevelService;
   private SerialNumberService serialNumberService;
 
   public String list()
   {
     return "list_vipLevel";
   }
 
   public String listJosn()
   {
     logger.info("start list vipLevel");
 
     List resultList = null;
 
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.vipLevel == null) {
         this.vipLevel = new VipLevel();
       }
 
       resultList = this.vipLevelService.pageList(pageInfo, this.vipLevel, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list vipLevel", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all vipLevel");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.vipLevel == null) {
       this.vipLevel = new VipLevel();
     }
     try
     {
       if (StringUtils.isBlank(this.vipLevel.getId())) {
         this.vipLevel.setState("c");
         initModel(true, this.vipLevel, loginMan);
         try {
           String code = this.serialNumberService.getSerialNumberByDate("DJ", "prepaid");
           this.vipLevel.setCode(code);
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.vipLevel = ((VipLevel)this.vipLevelService.getModel(this.vipLevel.getId()));
         initModel(false, this.vipLevel, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list vipLevel", e);
     }
     return "edit_vipLevel";
   }
 
   public void save()
   {
     logger.info("start to update prepaid information");
     try {
       if (this.vipLevel == null) {
         this.vipLevel = new VipLevel();
       }
       if (StringUtils.isBlank(this.vipLevel.getId()))
       {
         this.vipLevel.setId(this.vipLevelService.makeId());
         this.vipLevelService.insert(this.vipLevel);
       }
       else {
         this.vipLevelService.update(this.vipLevel);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save vipLevel information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.vipLevel == null) {
         this.vipLevel = new VipLevel();
       }
       this.vipLevelService.delete(this.vipLevel.getId());
       logger.info(loginMan.getCode() + " delete vipLevel,id:" + this.vipLevel.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale vipLevel", e);
     }
   }
 
   public VipLevel getVipLevel() {
     return this.vipLevel;
   }
   public void setVipLevel(VipLevel vipLevel) {
     this.vipLevel = vipLevel;
   }
   public void setVipLevelService(VipLevelService vipLevelService) {
     this.vipLevelService = vipLevelService;
   }
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 }

/* 
 
 
 */