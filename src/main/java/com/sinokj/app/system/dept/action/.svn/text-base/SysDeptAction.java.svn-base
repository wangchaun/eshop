 package com.sinokj.app.system.dept.action;
 
 import com.sinokj.app.system.dept.model.SysDept;
import com.sinokj.app.system.dept.service.SysDeptService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysDeptAction extends BaseAction
 {
   private static final long serialVersionUID = 5978189455813776425L;
   private static final Logger logger = Logger.getLogger(SysDeptAction.class);
   private SysDeptService sysDeptService;
   private SysDept sysDept;
 
   public void setSysDeptService(SysDeptService sysDeptService)
   {
     this.sysDeptService = sysDeptService;
   }
 
   public String listJson()
   {
     logger.info("start list all data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.sysDeptService.pageList(pageInfo, this.sysDept, true);
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
 
   public String getSysDeptJson()
   {
     this.sysDept = ((SysDept)this.sysDeptService.selectOne(this.sysDept));
     this.jsonMap = new HashMap();
     this.jsonMap.put("data", this.sysDept);
     return "success";
   }
 
   public String list()
   {
     return "list_SysDept";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
 
     if (this.sysDept == null) {
       this.sysDept = new SysDept();
     }
     String id = this.sysDept.getId();
     if (StringUtils.isBlank(id)) {
       super.initModel(true, this.sysDept, loginMan);
     } else {
       this.sysDept = ((SysDept)this.sysDeptService.getModel(id));
       super.initModel(false, this.sysDept, loginMan);
     }
     return "edit_SysDept";
   }
 
   public void save()
   {
     try
     {
       String id = this.sysDept.getId();
       if (StringUtils.isBlank(id))
         this.sysDeptService.insert(this.sysDept);
       else {
         this.sysDeptService.update(this.sysDept);
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
 
     String id = this.sysDept.getId();
     logger.info("delete dept,id:" + id);
     try {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.sysDeptService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete dept,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete dept,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.sysDept.getId();
     String code = this.sysDept.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       SysDept sysDeptResult = (SysDept)this.sysDeptService.selectOne(this.sysDept);
       if (sysDeptResult == null) {
         isCodeExisted = false;
       }
       else if (StringUtils.isNotEmpty(id)) {
         isCodeExisted = !id.equals(sysDeptResult.getId());
       }
 
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public void getDeptCode()
   {
     try
     {
       if (this.sysDept == null) {
         this.sysDept = new SysDept();
       }
       if (StringUtils.isNotBlank(this.sysDept.getId())) {
         this.sysDept = ((SysDept)this.sysDeptService.getModel(this.sysDept.getId()));
         responseFlag(this.sysDept.getCode());
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public SysDeptService getSysDeptService() {
     return this.sysDeptService;
   }
 
   public SysDept getSysDept() {
     return this.sysDept;
   }
 
   public void setSysDept(SysDept sysDept) {
     this.sysDept = sysDept;
   }
 }

/* 
 
 
 */