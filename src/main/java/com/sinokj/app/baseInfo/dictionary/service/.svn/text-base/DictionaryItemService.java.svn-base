 package com.sinokj.app.baseInfo.dictionary.service;
 
 import com.sinokj.app.baseInfo.dictionary.model.DictionaryItem;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;
import com.sinokj.code.util.PageHelp;
import com.sinokj.code.util.PageInfo;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class DictionaryItemService extends BaseService<DictionaryItem>
 {
   public List<DictionaryItem> list(DictionaryItem model, PageInfo pageInfo)
   {
     List list = this.publicDAO.queryByCache("DictionaryItem.DictionaryItem", model, pageInfo);
     pageInfo.setCount(PageHelp.getTotalElements().intValue());
     PageHelp.clean();
     return list;
   }
 
   public DictionaryItem getDictionaryItemByCode(DictionaryItem model)
     throws Exception
   {
     if (model == null) {
       throw new Exception("Object Dictionary is null,can not query Dictionary Data");
     }
     DictionaryItem dictionaryItem = null;
     Map map = new HashMap();
     map.put("code", model.getCode());
     map.put("dictionaryId", model.getDictionaryId());
     Object obj = super.selectOne(map);
     if (obj != null) {
       dictionaryItem = (DictionaryItem)obj;
     }
     return dictionaryItem;
   }
 
   public void deleteObjectByDictionaryId(String dictionaryId)
     throws Exception
   {
     if (StringUtils.isBlank(dictionaryId)) {
       throw new Exception("dictionaryId is null or empty,can not delete DictionaryItem Data");
     }
     Map map = new HashMap();
     map.put("dictionaryId", dictionaryId);
     this.publicDAO.delete("DictionaryItem.DictionaryItem_by_dictionaryId", map);
   }
 }