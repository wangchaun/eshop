 package com.sinokj.app.baseInfo.dictionary.action;
 
 import com.sinokj.app.baseInfo.dictionary.model.Dictionary;
import com.sinokj.app.baseInfo.dictionary.model.DictionaryItem;
import com.sinokj.app.baseInfo.dictionary.service.DictionaryItemService;
import com.sinokj.app.baseInfo.dictionary.service.DictionaryService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class DictionaryItemAction extends BaseAction
 {
   private static final long serialVersionUID = -4734207543758545845L;
   private static final Logger logger = Logger.getLogger(DictionaryItemAction.class);
   private DictionaryItemService dictionaryItemService;
   private DictionaryService dictionaryService;
   private DictionaryItem dictionaryItem;
   private Dictionary dictionary;
 
   public void setDictionaryItemService(DictionaryItemService dictionaryItemService)
   {
     this.dictionaryItemService = dictionaryItemService;
   }
 
   public void setDictionaryService(DictionaryService dictionaryService)
   {
     this.dictionaryService = dictionaryService;
   }
 
   public String list()
   {
     try
     {
       this.dictionary = this.dictionaryService.getDictionaryByCode(this.dictionary);
     } catch (Exception e) {
       e.printStackTrace();
     }
     return "list_dictionaryItem";
   }
 
   public String listJson()
   {
     logger.info("start list all Dictionary Data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.dictionaryItem == null) {
         this.dictionaryItem = new DictionaryItem();
       }
       resultList = this.dictionaryItemService.list(this.dictionaryItem, pageInfo);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list Dictionary Data", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all Dictionary Data!");
     return "success";
   }
 
   public String edit()
   {
     if (this.dictionaryItem == null)
       this.dictionaryItem = new DictionaryItem();
     try
     {
       if (StringUtils.isNotBlank(this.dictionaryItem.getId())) {
         this.dictionaryItem = ((DictionaryItem)this.dictionaryItemService.getModel(this.dictionaryItem.getId()));
       }
       this.dictionary = ((Dictionary)this.dictionaryService.getModel(this.dictionaryItem.getDictionaryId()));
     } catch (Exception e) {
       e.printStackTrace();
     }
     return "edit_dictionaryItem";
   }
 
   public void save()
   {
     logger.error("start to save DictionaryItem Data");
     if (this.dictionaryItem == null)
       this.dictionaryItem = new DictionaryItem();
     try
     {
       if (StringUtils.isNotBlank(this.dictionaryItem.getId()))
         this.dictionaryItemService.update(this.dictionaryItem);
       else {
         this.dictionaryItemService.insert(this.dictionaryItem);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.error("error occur when saving DictionaryItem Data");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.error("end of saving DictionaryItem Data");
   }
 
   public void delete()
   {
     logger.error("start to delete a DictionaryItem Data.");
     if (this.dictionaryItem == null)
       this.dictionaryItem = new DictionaryItem();
     try
     {
       if (StringUtils.isNotBlank(this.dictionaryItem.getId())) {
         String[] idArr = this.dictionaryItem.getId().split(",");
         for (int i = 0; i < idArr.length; i++) {
           this.dictionaryItemService.delete(idArr[i]);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.error("error occur when it is deleting a DictionaryItem Data", e);
       e.printStackTrace();
     }
     logger.error("end of deleting a DictionaryItem Data");
   }
 
   public void isCodeExisted()
   {
     logger.error("start to check whther the DictionaryItem Code is exists.");
     if (this.dictionaryItem == null)
       this.dictionaryItem = new DictionaryItem();
     try
     {
       String id = this.dictionaryItem.getId();
       String dictionaryId = this.dictionaryItem.getDictionaryId();
 
       this.dictionaryItem = this.dictionaryItemService.getDictionaryItemByCode(this.dictionaryItem);
       if (this.dictionaryItem == null) {
         responseFlag(false);
       }
       else if ((id.equals(this.dictionaryItem.getId())) && (dictionaryId.equals(this.dictionaryItem.getDictionaryId())))
         responseFlag(false);
       else
         responseFlag(true);
     }
     catch (Exception e)
     {
       logger.error("error occur when checking whther the DictionaryItem Code is exists", e);
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("end of checking whther the DictionaryItem Code is exists");
   }
 
   public DictionaryItem getDictionaryItem() {
     return this.dictionaryItem;
   }
 
   public void setDictionaryItem(DictionaryItem dictionaryItem) {
     this.dictionaryItem = dictionaryItem;
   }
 
   public Dictionary getDictionary() {
     return this.dictionary;
   }
 
   public void setDictionary(Dictionary dictionary) {
     this.dictionary = dictionary;
   }
 }