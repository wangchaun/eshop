 package com.sinokj.app.system.power.action;
 
 import com.sinokj.app.system.power.model.SysPower;
import com.sinokj.app.system.power.service.SysPowerService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysPowerAction extends BaseAction
 {
   private static final long serialVersionUID = 649107725905662511L;
   private static final Logger logger = Logger.getLogger(SysPowerAction.class);
   private SysPowerService sysPowerService;
   private SysPower sysPower;
 
   public void setSysPowerService(SysPowerService sysPowerService)
   {
     this.sysPowerService = sysPowerService;
   }
 
   public String listJson()
   {
     logger.info("start list all data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.sysPowerService.pageList(pageInfo, this.sysPower, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list data!", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
 
     logger.info("finish list all data!");
     return "success";
   }
 
   public String list()
   {
     return "list_SysPower";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
 
     if (this.sysPower == null) {
       this.sysPower = new SysPower();
     }
     String id = this.sysPower.getId();
     if (StringUtils.isBlank(id)) {
       super.initModel(true, this.sysPower, loginMan);
     } else {
       this.sysPower = ((SysPower)this.sysPowerService.getModel(id));
       super.initModel(false, this.sysPower, loginMan);
     }
     return "edit_SysPower";
   }
 
   public void save()
   {
     try
     {
       String id = this.sysPower.getId();
       if (StringUtils.isBlank(id))
         this.sysPowerService.insert(this.sysPower);
       else {
         this.sysPowerService.update(this.sysPower);
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
 
     String id = this.sysPower.getId();
     logger.info("delete role,id:" + id);
     try {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.sysPowerService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete role,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete role,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.sysPower.getId();
     String code = this.sysPower.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       SysPower result = (SysPower)this.sysPowerService.selectOne(this.sysPower);
       if (result == null) {
         isCodeExisted = false;
       }
       else if (StringUtils.isNotEmpty(id)) {
         isCodeExisted = !id.equals(result.getId());
       }
 
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public SysPower getSysPower() {
     return this.sysPower;
   }
 
   public void setSysPower(SysPower sysPower) {
     this.sysPower = sysPower;
   }
 
   public SysPowerService getSysPowerService() {
     return this.sysPowerService;
   }
 }

/* 
 
 
 */