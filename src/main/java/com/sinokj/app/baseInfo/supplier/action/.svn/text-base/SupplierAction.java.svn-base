 package com.sinokj.app.baseInfo.supplier.action;
 
 import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SupplierAction extends BaseAction
 {
   private static final long serialVersionUID = 7519736543727228896L;
   private static final Logger logger = Logger.getLogger(SupplierAction.class);
   private SupplierService supplierService;
   private Supplier supplier;
   private SerialNumberService serialNumberService;
 
   public void setSupplierService(SupplierService supplierService)
   {
     this.supplierService = supplierService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public String listJson()
   {
     logger.info("start list all supplier data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.supplierService.pageList(pageInfo, this.supplier, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list supplier data!", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
 
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
 
     logger.info("finish list all supplier data!");
     return "success";
   }
 
   public String list()
   {
     return "list_supplier";
   }
 
   public String edit()
   {
     try
     {
       logger.info("start to query supplier data!");
       SysUser loginMan = getSessionUserInfo();
       if (this.supplier == null) {
         this.supplier = new Supplier();
       }
       String id = this.supplier.getId();
       if (StringUtils.isBlank(id)) {
         super.initModel(true, this.supplier, loginMan);
       } else {
         this.supplier = ((Supplier)this.supplierService.getModel(id));
         super.initModel(false, this.supplier, loginMan);
       }
     } catch (Exception e) {
       logger.info("error occur when quering supplier data!");
       e.printStackTrace();
     }
     logger.info("finish quering supplier data!");
     return "edit_supplier";
   }
 
   public void save()
   {
     try
     {
       String id = this.supplier.getId();
 
       if (StringUtils.isBlank(id)) {
         String code = this.serialNumberService.getSerialNumberNoDate("", "Supplier", 4);
         this.supplier.setCode(code);
         this.supplierService.insert(this.supplier);
       } else {
         this.supplierService.update(this.supplier);
       }
       responseFlag(true);
     }
     catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save model!", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
 
     String id = this.supplier.getId();
     logger.info("delete Supplier,id:" + id);
     try
     {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.supplierService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete Supplier,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + 
         " delete Supplier,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.supplier.getId();
     String code = this.supplier.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       Supplier sub = this.supplierService.getSupplier(this.supplier);
       if (sub == null) {
         isCodeExisted = false;
       }
       else if (id.equals(sub.getId()))
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
 
   public Supplier getSupplier() {
     return this.supplier;
   }
 
   public void setSupplier(Supplier supplier) {
     this.supplier = supplier;
   }
 }