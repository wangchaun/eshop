 package com.sinokj.app.good.goodAttr.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodAttr.model.GoodAttr;
import com.sinokj.app.good.goodAttr.service.GoodAttrService;
import com.sinokj.app.good.goodKind.model.GoodKind;
import com.sinokj.app.good.goodKind.model.GoodKingVal;
import com.sinokj.app.good.goodKind.service.GoodKindService;
import com.sinokj.app.good.goodKind.service.GoodKingValService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodAttrAction extends BaseAction
 {
   private static final long serialVersionUID = -4461747682944085241L;
   private static final Logger logger = Logger.getLogger(GoodAttrAction.class);
   private GoodAttr goodAttr;
   private GoodAttrService goodAttrService;
   private String goodKindId;
   private SerialNumberService serialNumberService;
   private GoodKindService goodKindService;
   private List<GoodKingVal> kindvalList;
   private GoodKingValService goodKingValService;
 
   public void setGoodAttrService(GoodAttrService goodAttrService)
   {
     this.goodAttrService = goodAttrService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public void setGoodKindService(GoodKindService goodKindService) {
     this.goodKindService = goodKindService;
   }
 
   public String list()
   {
     this.goodKindId = this.goodAttr.getGoodKindId();
     return "list_goodAttr";
   }
 
   public String listJson()
   {
     logger.info("start list all attr!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodAttr == null) {
         this.goodAttr = new GoodAttr();
       }
       resultList = this.goodAttrService.pageList(pageInfo, this.goodAttr, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list goods", e);
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
 
   public String edit()
   {
     logger.info("start get a goodAttr");
     if (this.goodAttr == null)
       this.goodAttr = new GoodAttr();
     try
     {
       if (StringUtils.isNotBlank(this.goodAttr.getId()))
         this.goodAttr = ((GoodAttr)this.goodAttrService.getModel(this.goodAttr.getId()));
       else
         this.goodAttr.setGoodKindId(this.goodKindId);
     }
     catch (Exception e) {
       logger.error("error occur when get a goodAttr", e);
     }
     return "edit_goodAttr";
   }
 
   public void save()
   {
     logger.info("start saving a attr");
     try {
       if (StringUtils.isNotBlank(this.goodAttr.getId())) {
         this.goodAttrService.update(this.goodAttr);
       } else {
         GoodKind goodKind = (GoodKind)this.goodKindService.getModel(this.goodAttr.getGoodKindId());
         String code = this.serialNumberService.getSerialNumberNoDate("", goodKind.getName(), 3);
         this.goodAttr.setCode(code);
         this.goodAttr.setState("s");
         this.goodAttrService.insert(this.goodAttr);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when saving a attr", e);
     }
   }
 
   public void delete()
   {
     logger.info("start delete a attr");
     try {
       if (StringUtils.isNotBlank(this.goodAttr.getId())) {
         this.goodAttrService.delete(this.goodAttr.getId());
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a attr", e);
     }
   }
 
   public void getAttrList()
   {
     try
     {
       if (this.goodAttr == null) {
         this.goodAttr = new GoodAttr();
       }
       List resultList = this.goodAttrService.select(this.goodAttr);
       String returnText = "<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\" class=\"gdcn-table-bgcolor\">";
       String dateTypeIdStr = "";
       for (int i = 0; i < resultList.size(); i++) {
         this.goodAttr = ((GoodAttr)resultList.get(i));
         this.kindvalList = this.goodKingValService.getKingValByKingId(((GoodAttr)resultList.get(i)).getId());
         returnText = returnText + "<tr><td  class='gridtitle' width=\"20%\">" + this.goodAttr.getName() + ":</td>";
         returnText = returnText + "<td class='gridbody'><input type=\"hidden\" value='" + 
           this.goodAttr.getId() + "' name=\"goodAttrIdArr\"/>" + 
           "<input type=\"hidden\" value='" + this.goodAttr.getName() + "' name=\"goodAttrNameArr\"/>" + 
           "<input type=\"hidden\" value='" + this.goodAttr.getInputType() + "' name=\"inputTypeArr\"/>";
 
         if ("0".equals(this.goodAttr.getInputType()))
         {
           returnText = returnText + "<select name='attrValueArr' id='" + this.goodAttr.getId() + "' onchange='selectattrValueArr(this.value)'> ";
           returnText = returnText + "<option value='0'>--请选择商品属性值--</option>";
           for (int j = 0; j < this.kindvalList.size(); j++) {
             returnText = returnText + "<option value='" + ((GoodKingVal)this.kindvalList.get(j)).getValue();
             if (((GoodKingVal)this.kindvalList.get(j)).getValue().equals(this.goodAttr.getId())) {
               returnText = returnText + "selected";
             }
             returnText = returnText + "'>" + ((GoodKingVal)this.kindvalList.get(j)).getValue() + "</option>";
           }
 
         }
         else if ("1".equals(this.goodAttr.getInputType()))
         {
           returnText = returnText + "<input type='text' name='attrValueArr' id='" + this.goodAttr.getId() + "' readonly='readonly'/>";
           dateTypeIdStr = dateTypeIdStr + this.goodAttr.getId() + ",";
         } else if ("2".equals(this.goodAttr.getInputType()))
         {
           returnText = returnText + "<input name=\"attrValueArr\" id='" + this.goodAttr.getId() + "'/>";
         } else if ("3".equals(this.goodAttr.getInputType()))
         {
           returnText = returnText + "<input name=\"attrValueArr\" id='" + this.goodAttr.getId() + "'/>";
         } else if ("4".equals(this.goodAttr.getInputType())) {
           String[] selectValueArr = this.goodAttr.getValue().split(",");
 
           returnText = returnText + "<select name='attrValueArr' id='" + this.goodAttr.getId() + "'> ";
           for (int j = 0; j < selectValueArr.length; j++) {
             returnText = returnText + "<option value='" + selectValueArr[j] + "'>" + selectValueArr[j] + "</option>";
           }
         }
         returnText = returnText + "</td></tr>";
       }
       returnText = returnText + "</table>";
       responseFlag(returnText + "------" + dateTypeIdStr);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when list attr", e);
     }
   }
 
   public GoodAttr getGoodAttr() {
     return this.goodAttr;
   }
   public void setGoodAttr(GoodAttr goodAttr) {
     this.goodAttr = goodAttr;
   }
   public String getGoodKindId() {
     return this.goodKindId;
   }
   public void setGoodKindId(String goodKindId) {
     this.goodKindId = goodKindId;
   }
   public List<GoodKingVal> getKindvalList() {
     return this.kindvalList;
   }
   public void setKindvalList(List<GoodKingVal> kindvalList) {
     this.kindvalList = kindvalList;
   }
   public GoodKingValService getGoodKingValService() {
     return this.goodKingValService;
   }
   public void setGoodKingValService(GoodKingValService goodKingValService) {
     this.goodKingValService = goodKingValService;
   }
   public GoodAttrService getGoodAttrService() {
     return this.goodAttrService;
   }
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
   public GoodKindService getGoodKindService() {
     return this.goodKindService;
   }
 }

/* 
 
 
 */