 package com.sinokj.app.baseInfo.dictionary.action;
 
 import com.sinokj.app.baseInfo.dictionary.model.Dictionary;
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
 
 public class DictionaryAction extends BaseAction
 {
   private static final long serialVersionUID = -1820977101888204425L;
   private static final Logger logger = Logger.getLogger(DictionaryAction.class);
   private DictionaryService dictionaryService;
   private DictionaryItemService dictionaryItemService;
   private Dictionary dictionary;
 
   public void setDictionaryService(DictionaryService dictionaryService)
   {
     this.dictionaryService = dictionaryService;
   }
 
   public void setDictionaryItemService(DictionaryItemService dictionaryItemService)
   {
     this.dictionaryItemService = dictionaryItemService;
   }
 
   public Dictionary getDictionary()
   {
     return this.dictionary;
   }
 
   public void setDictionary(Dictionary dictionary) {
     this.dictionary = dictionary;
   }
 
   public String list()
   {
     return "list_dictionary";
   }
 
   public String listJson()
   {
     logger.info("start list all Dictionary Data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.dictionary == null) {
         this.dictionary = new Dictionary();
       }
       resultList = this.dictionaryService.pageList(pageInfo, this.dictionary, true);
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
     if (this.dictionary == null)
       this.dictionary = new Dictionary();
     try
     {
       if (StringUtils.isNotBlank(this.dictionary.getId()))
         this.dictionary = ((Dictionary)this.dictionaryService.getModel(this.dictionary.getId()));
     }
     catch (Exception e) {
       e.printStackTrace();
     }
     return "edit_dictionary";
   }
 
   public void save()
   {
     logger.error("start to save Dictionary Data");
     if (this.dictionary == null)
       this.dictionary = new Dictionary();
     try
     {
       if (StringUtils.isNotBlank(this.dictionary.getId())) {
         this.dictionaryService.update(this.dictionary);
       } else {
         this.dictionary.setState("c");
         this.dictionaryService.insert(this.dictionary);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.error("error occur when saving Dictionary Data");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.error("end of saving Dictionary Data");
   }
 
   public void delete()
   {
     logger.error("start to delete a Dictionary Data.");
     if (this.dictionary == null)
       this.dictionary = new Dictionary();
     try
     {
       if (StringUtils.isNotBlank(this.dictionary.getId())) {
         String[] idArr = this.dictionary.getId().split(",");
         for (int i = 0; i < idArr.length; i++) {
           this.dictionaryService.delete(idArr[i]);
 
           this.dictionaryItemService.deleteObjectByDictionaryId(idArr[i]);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.error("error occur when it is deleting a Dictionary Data", e);
       e.printStackTrace();
     }
     logger.error("end of deleting a Dictionary Data");
   }
 
   public void isCodeExisted()
   {
     logger.error("start to check whther the Dictionary Code is exists.");
     if (this.dictionary == null)
       this.dictionary = new Dictionary();
     try
     {
       String id = this.dictionary.getId();
       this.dictionary = this.dictionaryService.getDictionaryByCode(this.dictionary);
       if (this.dictionary == null) {
         responseFlag(false);
       }
       else if (id.equals(this.dictionary.getId()))
         responseFlag(false);
       else
         responseFlag(true);
     }
     catch (Exception e)
     {
       logger.error("error occur when checking whther the Dictionary Code is exists", e);
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("end of checking whther the Dictionary Code is exists");
   }
 }