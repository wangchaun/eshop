 package com.sinokj.app.store.promotecolumn.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.promote.model.Promote;
import com.sinokj.app.store.promote.service.PromoteService;
import com.sinokj.app.store.promotecolumn.model.Promotecolumn;
import com.sinokj.app.store.promotecolumn.service.PromotecolumnService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class PromotecolumnAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PromotecolumnAction.class);
   private PromotecolumnService promotecolumnService;
   private Promotecolumn promotecolumn;
   private SerialNumberService serialNumberService;
   private Promote promote;
   private PromoteService promoteService;
 
   public String list()
   {
     logger.info("start to query promotecolumn information");
     return "list_promotecolumn";
   }
 
   public String listJosn()
   {
     logger.info("start list promotecolumn");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.promotecolumn == null) {
         this.promotecolumn = new Promotecolumn();
       }
       resultList = this.promotecolumnService.pageList(pageInfo, this.promotecolumn, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list promotecolumn", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String edit() {
     logger.info("start edit promotecolumn");
     try {
       if (this.promotecolumn == null)
         this.promotecolumn = new Promotecolumn();
       else
         this.promotecolumn = ((Promotecolumn)this.promotecolumnService.getModel(this.promotecolumn.getId()));
     }
     catch (Exception e) {
       logger.error("error occur when list promotecolumn", e);
     }
     return "edit_promotecolumn";
   }
 
   public void save()
   {
     logger.info("start save promotecolumn");
     try {
       if ((this.promotecolumn.getId() != null) && (!this.promotecolumn.getId().equals("")))
       {
         this.promotecolumnService.update(this.promotecolumn);
       } else {
         this.promotecolumn.setId(this.promotecolumnService.makeId());
         String prefix = "";
         String code = this.serialNumberService.getSerialNumberNoDate(prefix, this.appType + prefix, 3);
         this.promotecolumn.setCode(code);
         this.promotecolumnService.insert(this.promotecolumn);
       }
       responseFlag("修改或添加成功");
     } catch (Exception e) {
       responseFlag("系统错误");
       logger.error("error occur when list promotecolumn", e);
     }
   }
 
   public void delete()
   {
     logger.info("start save promotecolumn");
     try {
       if (this.promotecolumn.getId() != null) {
         this.promotecolumnService.delete(this.promotecolumn.getId());
         this.promoteService.delete(this.promotecolumn.getId());
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.error("error occur when list promotecolumn", e);
     }
   }
 
   public void setPromotecolumnService(PromotecolumnService promotecolumnService) {
     this.promotecolumnService = promotecolumnService;
   }
 
   public Promotecolumn getPromotecolumn() {
     return this.promotecolumn;
   }
 
   public void setPromotecolumn(Promotecolumn promotecolumn) {
     this.promotecolumn = promotecolumn;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public Promote getPromote() {
     return this.promote;
   }
 
   public void setPromote(Promote promote) {
     this.promote = promote;
   }
 
   public void setPromoteService(PromoteService promoteService) {
     this.promoteService = promoteService;
   }
 }

/* 
 
 
 */