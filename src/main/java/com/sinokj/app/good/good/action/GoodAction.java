 package com.sinokj.app.good.good.action;
 
 import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.common.Static;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodAttr.model.GoodAttr;
import com.sinokj.app.good.goodAttr.model.GoodAttrValue;
import com.sinokj.app.good.goodAttr.service.GoodAttrService;
import com.sinokj.app.good.goodAttr.service.GoodAttrValueService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.good.goodCompose.model.GoodCompose;
import com.sinokj.app.good.goodCompose.service.GoodComposeService;
import com.sinokj.app.good.goodExtend.model.GoodExtend;
import com.sinokj.app.good.goodExtend.service.GoodExtendService;
import com.sinokj.app.good.goodKind.model.GoodKind;
import com.sinokj.app.good.goodKind.service.GoodKindService;
import com.sinokj.app.good.goodPrice.model.GoodPrice;
import com.sinokj.app.good.goodPrice.service.GoodPriceService;
import com.sinokj.app.good.goodRelate.model.GoodRelate;
import com.sinokj.app.good.goodRelate.service.GoodRelateService;
import com.sinokj.app.good.goodSpecification.model.GoodSpecification;
import com.sinokj.app.good.goodSpecification.model.GoodSpecificationVal;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationService;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationValService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.model.Warehouse;
import com.sinokj.app.warehouse.warehouse.model.WarehouseWare;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.app.warehouse.warehouseInto.model.WarehouseIntoWare;
import com.sinokj.app.warehouse.warehouseInto.service.WarehouseIntoWareService;
import com.sinokj.app.warehouse.warehousePosition.model.WarehousePositionWare;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionWareService;
import com.sinokj.code.bean.Base;
import com.sinokj.code.db.DBUtil;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.ConfigUtil;
import com.sinokj.code.util.DateUtil;
import com.sinokj.code.util.PageInfo;

 import java.io.File;
 import java.io.PrintStream;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import jxl.Sheet;
 import jxl.Workbook;
 import org.apache.commons.io.FileUtils;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodAction extends BaseAction{
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(GoodAction.class);
   private GoodService goodService;
   private Good good;
   private GoodExtend goodExtend;
   private List<Good> goodList;
   private GoodType goodType;
   private String imgIdStr;
   private List<GoodPrice> goodPriceList;
   private List<GoodKind> goodKindList;
   private List<GoodAttr> goodAttrList;
   private List<FileUpload> goodPicList;
   private List<GoodRelate> goodRelateList;
   private List<GoodCompose> goodComposeList;
   private List<Ware> wareList;
   private List<GoodSpecification> goodSpecificationList;
   private GoodBrand goodBrand;
   private GoodBrandService goodBrandService;
   private Supplier supplier;
   private SupplierService supplierService;
   private File[] fileupload;
   private String[] fileuploadFileName;
   private GoodTypeService goodTypeService;
   private GoodExtendService goodExtendService;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
   private GoodKindService goodKindService;
   private GoodAttrService goodAttrService;
   private GoodAttrValueService goodAttrValueService;
   private GoodPriceService goodPriceService;
   private GoodRelateService goodRelateService;
   private GoodComposeService goodComposeService;
   private GoodSpecificationService goodSpecificationService;
   private GoodSpecificationValService goodSpecificationValService;
   private WareService wareService;
   private WareSpecificationValService wareSpecificationValService;
   private String[] goodAttrIdArr;
   private String[] attrValueArr;
   private Double[] priceArr;
   private String[] areaIdArr;
   private String[] areaNameArr;
   private String[] stateArr;
   private String[] propertyArr;
   private String[] tagArr;
   private String[] specificationValIdArr;
   private String[] wareIdArr;
   private String[] wareCodeArr;
   private Integer[] stockArr;
   private Double[] warePriceDiscountArr;
   private Double[] priceShopArr;
   private Double[] priceMarketArr;
   private String[] wareSpecificationValId1Arr;
   private String[] wareSpecificationValId2Arr;
   private String[] wareSpecificationValId3Arr;
   private String[] picIdArr;
   private String[] picArr;
   private String[] picIdWareArr;
   private String[] picWareArr;
   private String[] goodRelateIdArr;
   private String[] goodComposeIdArr;
   private Double[] goodComposePriceDisArr;
   private WarehousePositionWare warehousePositionWare;
   private WarehousePositionWareService warehousePositionWareService;
   private WarehouseIntoWare warehouseIntoWare;
   private WarehouseIntoWareService warehouseIntoWareService;
   private Ware ware;
   private WarehouseWare warehouseWare;
   private WarehouseWareService warehouseWareService;
   private Warehouse warehouse;
   private WarehouseService warehouseService;
 
  
 
   public String listJson()
   {
     logger.info("start list goods!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.good == null) {
         this.good = new Good();
       }
       
       this.good.setSortVal("createTime");
       resultList = this.goodService.pageList(pageInfo, this.good, true);
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
 
   public String list(){
     HttpServletRequest request = getRequest();
     SysUser loginUser = getSessionUserInfo();
     request.setAttribute("loginUser", loginUser);
     return "list_good";
   }
   /*编辑商品*/
   public String edit()
   {
     HttpServletRequest request = getRequest();
     if (this.good == null) {
       this.good = new Good();
     }
     this.goodKindList = this.goodKindService.select(new GoodKind());
     this.goodPriceList = new ArrayList();
     this.goodPicList = new ArrayList();
     Integer picNum = Integer.valueOf(ConfigUtil.getGoodPicNum());
     if (StringUtils.isBlank(this.good.getId())) {
       initModel(true, this.good, getSessionUserInfo());
       this.good.setOrderMultiple(Integer.valueOf(1));
       this.good.setIsInventory("0");
 
       for (int i = 0; i < 5; i++)
         this.goodPriceList.add(new GoodPrice());
     }
     else {
       this.good = ((Good)this.goodService.getModel(this.good.getId()));
       this.wareList = this.wareService.getWareByGoodId(this.good.getId());
       this.warehousePositionWare = new WarehousePositionWare();
       if ((this.wareList != null) && 
         (this.wareList.size() > 0)) {
         this.warehousePositionWare.setWareId(((Ware)this.wareList.get(0)).getId());
         this.warehousePositionWare = ((WarehousePositionWare)this.warehousePositionWareService.selectOne(this.warehousePositionWare));
         if (this.warehousePositionWare != null) {
           this.good.setWarehouseName(this.warehousePositionWare.getWarehouseName());
           this.good.setWarehousePositionName(this.warehousePositionWare.getWarehousePositionName());
         }
       }
 
       initModel(false, this.good, getSessionUserInfo());
       try {
         this.goodExtend = this.goodExtendService.getByGoodId(this.good.getId());
       } catch (Exception e) {
         logger.error("获取扩展信息出现错误", e);
       }
       try
       {
         this.goodPriceList = this.goodPriceService.getGoodPriceByGoodId(this.good.getId());
         if (this.goodPriceList.size() < 5) {
           int size = this.goodPriceList.size();
           for (int j = 0; j < 5 - size; j++)
             this.goodPriceList.add(new GoodPrice());
         }
       }
       catch (Exception e) {
         logger.error("获取价格失败", e);
       }
       try
       {
         this.wareList = this.wareService.getWareByGoodId(this.good.getId());
         if (this.wareList.size() > 0) {
           this.goodSpecificationList = this.goodSpecificationService.getWareSpecification(((Ware)this.wareList.get(0)).getId());
           if (this.goodSpecificationList.size() == 0) this.goodSpecificationList = null;
 
           for (int i = 0; i < this.wareList.size(); i++) {
             ((Ware)this.wareList.get(i)).setShowwhether(false);
             List wareSpecificationValList = this.wareSpecificationValService.getByWareId(((Ware)this.wareList.get(i)).getId());
 
             if (this.goodSpecificationList != null) {
               if ((this.goodSpecificationList.size() > 0) && (wareSpecificationValList.size() > 0) && (wareSpecificationValList.get(0) != null)) {
                 ((Ware)this.wareList.get(i)).setShowwhether(true);
                 ((Ware)this.wareList.get(i)).setGoodSpecificationVal1(((WareSpecificationVal)wareSpecificationValList.get(0)).getSpecificationValName());
                 ((Ware)this.wareList.get(i)).setGoodSpecificationValId1(((WareSpecificationVal)wareSpecificationValList.get(0)).getGoodSpecificationValId());
               }
 
               if ((this.goodSpecificationList.size() > 1) && (wareSpecificationValList.size() > 1) && (wareSpecificationValList.get(1) != null)) {
                 ((Ware)this.wareList.get(i)).setShowwhether(true);
                 ((Ware)this.wareList.get(i)).setGoodSpecificationVal2(((WareSpecificationVal)wareSpecificationValList.get(1)).getSpecificationValName());
                 ((Ware)this.wareList.get(i)).setGoodSpecificationValId2(((WareSpecificationVal)wareSpecificationValList.get(1)).getGoodSpecificationValId());
               }
               if ((this.goodSpecificationList.size() > 2) && (wareSpecificationValList.size() > 2) && (wareSpecificationValList.get(2) != null)) {
                 ((Ware)this.wareList.get(i)).setShowwhether(true);
                 ((Ware)this.wareList.get(i)).setGoodSpecificationVal3(((WareSpecificationVal)wareSpecificationValList.get(2)).getSpecificationValName());
                 ((Ware)this.wareList.get(i)).setGoodSpecificationValId3(((WareSpecificationVal)wareSpecificationValList.get(2)).getGoodSpecificationValId());
               }
             }
           }
         }
       }
       catch (Exception e) {
         logger.error("获取货品", e);
       }
       try {
         this.goodAttrList = this.goodAttrService.getGoodAttr(this.good.getId());
         String goodAttrIdStr = "";
         for (int i = 0; i < this.goodAttrList.size(); i++) {
           goodAttrIdStr = goodAttrIdStr + ((GoodAttr)this.goodAttrList.get(i)).getId() + ",";
         }
         getRequest().setAttribute("goodAttrIdStr", goodAttrIdStr);
       } catch (Exception e) {
         logger.error("获取商品属性出错", e);
       }
       try
       {
         this.goodPicList = this.fileUploadService.getFileUploadByGoodId(this.good.getId());
       } catch (Exception e) {
         logger.error("获取相册图片出错", e);
       }
       try
       {
         this.goodRelateList = this.goodRelateService.getGoodRelateByGoodId(this.good.getId());
       } catch (Exception e) {
         logger.error("获取关联商品出错", e);
       }
       String goodRelateIdStr = "";
       if (this.goodRelateList != null) {
         for (int i = 0; i < this.goodRelateList.size(); i++) {
           goodRelateIdStr = goodRelateIdStr + ((GoodRelate)this.goodRelateList.get(i)).getRelateGoodId() + ",";
         }
       }
       request.setAttribute("goodRelateIdStr", goodRelateIdStr);
 
       this.goodComposeList = this.goodComposeService.getGoodComposeByGoodId(this.good.getId());
       String goodComposeIdStr = "";
       if (this.goodComposeList != null) {
         for (int i = 0; i < this.goodComposeList.size(); i++) {
           goodComposeIdStr = goodComposeIdStr + ((GoodCompose)this.goodComposeList.get(i)).getComposeGoodId() + ",";
         }
       }
       request.setAttribute("goodComposeIdStr", goodComposeIdStr);
     }
 
     if (this.goodPicList.size() < 10) {
       int picSize = this.goodPicList.size();
       for (int i = 0; i < 10 - picSize; i++) {
         this.goodPicList.add(new FileUpload());
       }
     }
     return "edit_good";
   }
   /*添加商品*/
   public void save(){
     logger.info("start save a good");
     HttpServletRequest request = getRequest();
     String dir=request.getSession().getServletContext().getRealPath("/");
     boolean stop = true;
    
     try{
       String picId = request.getParameter("picId");
       String pic = request.getParameter("pic");
       if ("".equals(picId)) {
         if ((StringUtils.isNotBlank(this.good.getId())) && (StringUtils.isNotBlank(pic))) {
           this.fileUploadService.removeAppId(pic, this.good.getId());
         }
         
         File f = new File(dir+ pic);
         f.delete();
         pic = "";
       }
       this.good.setPicId(picId);
       this.good.setPic(pic);
       this.good.setIsView("0");//默认添加的商品不是选号商品
       String goodKindId = request.getParameter("goodKind");
       if (StringUtils.isNotBlank(goodKindId)) {
         GoodKind goodKind = (GoodKind)this.goodKindService.getModel(goodKindId);
         if (goodKind != null) {
           this.good.setGoodKindId(goodKind.getId());
           this.good.setGoodKindName(goodKind.getName());
         }
 
       }
       
       String  goodTypeId=this.good.getGoodTypeId();
       if (StringUtils.isNotBlank(goodTypeId)) {
           GoodType goodType=(GoodType)this.goodTypeService.getModel(goodTypeId); 
           if (goodType != null) {
        	   
              this.good.setIsView(goodType.getIsInventories());
           }
         }
       
       if (!this.good.getIsInventory().equals("0")) {
         List<Good> grouplist = this.goodService.selectHDgood(this.good.getIsInventory());
         if (grouplist.size() > 0) {
           Good goods = (Good)grouplist.get(0);
           if (goods.getSort() != null) this.good.setSort(Integer.valueOf(goods.getSort().intValue() + 1)); else
             this.good.setSort(Integer.valueOf(1));
         }
         if (this.good.getGroupNumber() == null) this.good.setGroupNumber(Integer.valueOf(0));
 
       }
       
       if (StringUtils.isNotBlank(this.good.getId())) {
    	  
         this.good.setCreateTime(this.good.getModifyTime());
         this.goodService.update(this.good);
         stop = false;
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.good.getId());
         }
 
       }
       else{
         String id = this.goodService.makeId();
         this.good.setId(id);
         this.good.setTotalNum(String.valueOf((int)this.good.getInitialNum().doubleValue()));
 
         this.goodService.insertGood(this.good);
 
         this.warehouse = new Warehouse();
         this.warehouse.setId(this.good.getWarehouseId());
 
         this.warehouse = ((Warehouse)this.warehouseService.selectOne(this.warehouse));
         if (this.warehouse != null) {
           Double totle = this.warehouse.getTotalCostInventory();
           Double moneyIn = Double.valueOf(0.0D);
           if (this.good.getPurchasePrice() != null)
             moneyIn = Double.valueOf(this.good.getInitialNum().intValue() * this.good.getPurchasePrice().doubleValue());
           else
             moneyIn = this.good.getInitialNum();
           if (totle != null)
             totle = Double.valueOf(totle.doubleValue() + moneyIn.doubleValue());
           else
             totle = moneyIn;
           this.warehouse.setTotalCostInventory(totle);
           this.warehouseService.update(this.warehouse);
         }
       }
 
       this.goodExtend.setGoodId(this.good.getId());
       if (StringUtils.isBlank(this.goodExtend.getId()))
         this.goodExtendService.insert(this.goodExtend);
       else {
         this.goodExtendService.update(this.goodExtend);
       }
 
       this.goodAttrValueService.deleteByGoodId(this.good.getId());
       if ((this.goodAttrIdArr != null) && (this.goodAttrIdArr.length != 0)) {
         for (int i = 0; i < this.goodAttrIdArr.length; i++) {
           if ((StringUtils.isNotBlank(this.goodAttrIdArr[i])) && (!this.attrValueArr[i].equals("0"))) {
             GoodAttrValue goodAttrValue = new GoodAttrValue();
             goodAttrValue.setGoodId(this.good.getId());
             goodAttrValue.setGoodAttrId(this.goodAttrIdArr[i]);
             goodAttrValue.setAttrValue(this.attrValueArr[i]);
             goodAttrValue.setSort(Integer.valueOf(i));
             this.goodAttrValueService.insert(goodAttrValue);
           }
         }
       }
 
       this.goodPriceService.deleteByGoodId(this.good.getId());
 
       if ((this.priceArr != null) && (this.priceArr.length != 0)) {
         for (int i = 0; i < this.priceArr.length; i++) {
           if (this.priceArr[i].doubleValue() > 0.0D) {
             GoodPrice goodPrice = new GoodPrice();
             goodPrice.setGoodId(this.good.getId());
             goodPrice.setGoodName(this.good.getName());
             goodPrice.setPrice(this.priceArr[i]);
             goodPrice.setAreaId(this.areaIdArr[i]);
             goodPrice.setAreaName(this.areaNameArr[i]);
             goodPrice.setState(this.stateArr[i]);
             if ((this.propertyArr[i] != null) && (!this.propertyArr[i].equals(""))) {
               goodPrice.setProperty(this.propertyArr[i]);
             }
             goodPrice.setTag(this.tagArr[i]);
             String priceCode = "Wholesale" + String.valueOf(i + 1);
             goodPrice.setCode(priceCode);
             goodPrice.setSort(Integer.valueOf(i));
             this.goodPriceService.insert(goodPrice);
           }
 
         }
 
       }
 
       this.wareList = this.wareService.getWareByGoodId(this.good.getId());
       if ((this.wareIdArr == null) || (this.wareIdArr.length == 0))
       {
         this.wareIdArr = new String[this.wareList.size()];
         for (int i = 0; i < this.wareList.size(); i++) {
           this.wareSpecificationValService.deleteByWareId(((Ware)this.wareList.get(i)).getId());
           if ((this.wareList != null) && (this.wareList.size() != 0)) {
             this.wareIdArr[i] = ((Ware)this.wareList.get(i)).getId();
           }
         }
       }
       this.wareService.deleteByGoodId(this.good.getId());
 
       if ((this.wareCodeArr != null) && (this.wareCodeArr.length != 0)) {
         for (int i = 0; i < this.wareCodeArr.length; i++)
         {
           if (StringUtils.isBlank(this.wareCodeArr[i])) {
             this.wareCodeArr[i] = (this.good.getCode() + "-" + (i + 1));
           }
           Ware ware = new Ware();
           if ((this.wareIdArr != null) && (this.wareIdArr.length >= i + 1) && (StringUtils.isNotBlank(this.wareIdArr[i])))
             ware.setId(this.wareIdArr[i]);
           else {
             stop = true;
           }
           ware.setGoodId(this.good.getId());
           ware.setCode(this.wareCodeArr[i]);
           ware.setStock(0);//设置加入仓库的数量为0
           //ware.setStock(this.stockArr[i]);
           ware.setPriceShop(this.priceShopArr[i]);
           ware.setPriceMarket(this.priceMarketArr[i]);
           ware.setSort(Integer.valueOf(i));
          
           if ((this.picIdWareArr != null) && (this.picIdWareArr.length > 0)) {
             if ((StringUtils.isNotBlank(this.picWareArr[i])) && (!this.picWareArr[i].equals("${ware.pic }"))) {
               ware.setPic(this.picWareArr[i]);
               ware.setPicId(this.picIdWareArr[i]);
             } else if (StringUtils.isNotBlank(this.picWareArr[i])) {
               File f = new File(dir + this.picWareArr[i]);
               f.delete();
               this.fileUploadService.removeAppId(this.picWareArr[i], ware.getId());
             }
 
           }
 
           this.wareService.insert(ware);
           ware = (Ware)this.wareService.selectOne(ware);
           ware = this.wareService.getWareByCode(this.good.getId(), ware.getCode());
 
           if ((this.wareSpecificationValId1Arr != null) && (StringUtils.isNotBlank(this.wareSpecificationValId1Arr[i]))) {
             WareSpecificationVal wareSpecificationVal = this.wareSpecificationValService.getSpecificationVal(ware.getId(), this.wareSpecificationValId1Arr[i]);
             if (wareSpecificationVal == null) {
               wareSpecificationVal = new WareSpecificationVal();
               wareSpecificationVal.setWareId(ware.getId());
               wareSpecificationVal.setGoodSpecificationValId(this.wareSpecificationValId1Arr[i]);
               wareSpecificationVal.setSort(Integer.valueOf(1));
               this.wareSpecificationValService.insertOrUpdate("WareSpecificationVal.WareSpecificationVal", wareSpecificationVal);
 
               GoodSpecificationVal goodSpecificationVal = (GoodSpecificationVal)this.goodSpecificationValService.getModel(wareSpecificationVal.getGoodSpecificationValId());
               if (goodSpecificationVal != null) {
                 GoodSpecification goodSpecifcation = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationVal.getGoodSpecificationId());
                 if (goodSpecifcation.getShowType().equals("1")) {
                   Ware w = (Ware)this.wareService.getModel(ware.getId());
                   w.setGoodValId(goodSpecificationVal.getId());
                   w.setGoodVal(goodSpecificationVal.getValue());
                   this.wareService.update(w);
                 }
               }
             }
 
           }
 
           if ((this.wareSpecificationValId2Arr != null) && (StringUtils.isNotBlank(this.wareSpecificationValId2Arr[i]))) {
             WareSpecificationVal wareSpecificationVal = 
               this.wareSpecificationValService.getSpecificationVal(ware.getId(), this.wareSpecificationValId2Arr[i]);
             if (wareSpecificationVal == null) {
               wareSpecificationVal = new WareSpecificationVal();
               wareSpecificationVal.setWareId(ware.getId());
               wareSpecificationVal.setGoodSpecificationValId(this.wareSpecificationValId2Arr[i]);
               wareSpecificationVal.setSort(Integer.valueOf(2));
               this.wareSpecificationValService.insertOrUpdate("WareSpecificationVal.WareSpecificationVal", wareSpecificationVal);
 
               GoodSpecificationVal goodSpecificationVal = (GoodSpecificationVal)this.goodSpecificationValService.getModel(wareSpecificationVal.getGoodSpecificationValId());
               if (goodSpecificationVal != null) {
                 GoodSpecification goodSpecifcation = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationVal.getGoodSpecificationId());
                 if (goodSpecifcation.getShowType().equals("1")) {
                   Ware w = (Ware)this.wareService.getModel(ware.getId());
                   w.setGoodValId(goodSpecificationVal.getId());
                   w.setGoodVal(goodSpecificationVal.getValue());
                   this.wareService.update(w);
                 }
               }
             }
           }
 
           if ((this.wareSpecificationValId3Arr != null) && (StringUtils.isNotBlank(this.wareSpecificationValId3Arr[i]))) {
             WareSpecificationVal wareSpecificationVal = 
               this.wareSpecificationValService.getSpecificationVal(ware.getId(), this.wareSpecificationValId3Arr[i]);
             if (wareSpecificationVal == null) {
               wareSpecificationVal = new WareSpecificationVal();
               wareSpecificationVal.setWareId(ware.getId());
               wareSpecificationVal.setGoodSpecificationValId(this.wareSpecificationValId3Arr[i]);
               wareSpecificationVal.setSort(Integer.valueOf(3));
               this.wareSpecificationValService.insertOrUpdate("WareSpecificationVal.WareSpecificationVal", wareSpecificationVal);
 
               GoodSpecificationVal goodSpecificationVal = (GoodSpecificationVal)this.goodSpecificationValService.getModel(wareSpecificationVal.getGoodSpecificationValId());
               if (goodSpecificationVal != null) {
                 GoodSpecification goodSpecifcation = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationVal.getGoodSpecificationId());
                 if (goodSpecifcation.getShowType().equals("1")) {
                   Ware w = (Ware)this.wareService.getModel(ware.getId());
                   w.setGoodValId(goodSpecificationVal.getId());
                   w.setGoodVal(goodSpecificationVal.getValue());
                   this.wareService.update(w);
                 }
 
               }
 
             }
 
           }
 
         }
 
       }/*看是否是有多个规格商品*/
       else{
         Ware ware = this.wareService.getWareById(this.good.getId());
         if (ware == null)
         {
           if ((this.wareList != null) && (this.wareList.size() == 1)) {
             ((Ware)this.wareList.get(0)).setStock(Integer.valueOf(this.good.getInitialNum().intValue()));
             this.wareService.insert((Base)this.wareList.get(0));
             this.goodService.update(this.good);
           } else {
             ware = new Ware();
             ware.setCode(this.good.getCode());
             ware.setGoodId(this.good.getId());
             //ware.setStock(Integer.valueOf(this.good.getInitialNum().intValue()));
             ware.setStock(0);//默认添加到仓库商品的数量
             ware.setPriceDiscount(Double.valueOf(0.0D));
             ware.setSort(Integer.valueOf(1));
             this.wareService.insert(ware);
           }
         }
 
       }
 
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.goodExtend.getId());
         }
       }
 
       if ((this.picIdArr != null) && (this.picIdArr.length > 0)) {
         for (int i = 0; i < this.picIdArr.length; i++) {
           if (StringUtils.isNotBlank(this.picIdArr[i])) {
             this.fileUploadService.updateAppId(this.picIdArr[i], this.good.getId());
           } else if (StringUtils.isNotBlank(this.picArr[i])) {
             File f = new File(dir + this.picArr[i]);
             f.delete();
             this.fileUploadService.removeAppId(this.picArr[i], this.good.getId());
           }
         }
 
       }
 
       this.goodRelateService.deleteByGoodId(this.good.getId());
       if ((this.goodRelateIdArr != null) && (this.goodRelateIdArr.length > 0)) {
         for (int i = 0; i < this.goodRelateIdArr.length; i++) {
           if (StringUtils.isNotBlank(this.goodRelateIdArr[i])) {
             GoodRelate goodRelate = new GoodRelate();
             goodRelate.setGoodId(this.good.getId());
             goodRelate.setRelateGoodId(this.goodRelateIdArr[i]);
             goodRelate.setSort(Integer.valueOf(i));
             this.goodRelateService.insert(goodRelate);
           }
         }
       }
 
       this.goodComposeService.deleteByGoodId(this.good.getId());
       if ((this.goodComposeIdArr != null) && (this.goodComposeIdArr.length > 0)) {
         for (int i = 0; i < this.goodComposeIdArr.length; i++) {
           if (StringUtils.isNotBlank(this.goodComposeIdArr[i])) {
             GoodCompose goodCompose = new GoodCompose();
             goodCompose.setGoodId(this.good.getId());
             goodCompose.setComposeGoodId(this.goodComposeIdArr[i]);
             goodCompose.setPriceDiscount(this.goodComposePriceDisArr[i]);
             goodCompose.setSort(Integer.valueOf(i));
             this.goodComposeService.insert(goodCompose);
           }
         }
       }
       responseFlag(true);
     }
     catch (Exception e)
     {
       responseFlag(false);
       logger.error("error occur when insert a good!", e);
     }
   }
 
   public void updateState(){
     logger.info("start update goods's state");
     try {
       if (this.good == null) {
         this.good = new Good();
       }
       if (StringUtils.isNotBlank(this.good.getId())) {
         this.goodService.updateGoodState(this.good.getId(), this.good.getState());
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.error("error occur when update goods's state", e);
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.good.getId());
     try {
       String goodId = this.good.getId();
       if (StringUtils.isNotBlank(goodId))
       {
         String[] idArr = goodId.split(",");
         for (String idStr : idArr)
         {
           this.fileUploadService.cleanAppId(idStr);
 
           this.goodAttrValueService.deleteByGoodId(idStr);
 
           this.goodComposeService.deleteByGoodId(idStr);
 
           this.goodExtendService.deleteByGoodId(idStr);
 
           this.goodPriceService.deleteByGoodId(idStr);
 
           this.goodRelateService.deleteByGoodId(idStr);
 
           this.wareService.deleteByGoodId(idStr);
 
           this.goodService.delete(idStr);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a good!", e);
     }
   }
 
   public String listSpecification()
   {
     return "list_specification";
   }
 
   public void buildWare()
   {
     try
     {
       String specificationValIdStr = "";
       if ((this.specificationValIdArr != null) && (this.specificationValIdArr.length > 0)) {
         for (int i = 0; i < this.specificationValIdArr.length; i++) {
           if (StringUtils.isNotBlank(this.specificationValIdArr[i])) {
             specificationValIdStr = specificationValIdStr + this.specificationValIdArr[i] + ",";
           }
         }
       }
       specificationValIdStr = specificationValIdStr.replace(",,", ",");
       this.specificationValIdArr = specificationValIdStr.split(",");
       List list = this.goodSpecificationValService.getByIdArr(this.specificationValIdArr);
 
       HashSet hashSet = new HashSet();
       for (int i = 0; i < list.size(); i++) {
         hashSet.add(((GoodSpecificationVal)list.get(i)).getGoodSpecificationId());
       }
       String[] goodSpecificationIdArr = new String[hashSet.size()];
       hashSet.toArray(goodSpecificationIdArr);
 
       Map map = new HashMap();
 
       for (int i = 0; i < goodSpecificationIdArr.length; i++) {
         String goodSpecificationId = goodSpecificationIdArr[i];
         List list2 = new ArrayList();
         for (int j = 0; j < list.size(); j++) {
           if (((GoodSpecificationVal)list.get(j)).getGoodSpecificationId().equals(goodSpecificationId)) {
             list2.add((GoodSpecificationVal)list.get(j));
           }
         }
         map.put(goodSpecificationId, list2);
       }
 
       String html = "<table width='80%' border='0' cellpadding='0' cellspacing='1' class='gdcn-table-bgcolor' style='margin-top: 10px;'>";
 
       html = html + "<thead>";
 
       for (int i = 0; i < goodSpecificationIdArr.length; i++) {
         GoodSpecification goodSpecification = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationIdArr[i]);
         html = html + "<th width='10%'>" + goodSpecification.getName() + "</th>";
       }
       int showType = 1;
       for (int i = 0; i < goodSpecificationIdArr.length; i++) {
         GoodSpecification goodSpecification = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationIdArr[i]);
         if (goodSpecification.getShowType().equals("1")) {
           showType = 1;
           break;
         }
         showType = 0;
       }
 
       if (showType == 1) {
         html = html + "<th width='10%'>库存</th><th width='10%'>上传图片</th><th width='8%'>操作</th></thead>";
       }
       else
       {
         html = html + "<th width='10%'>库存</th><th width='8%'>商城价</th><th width='8%'>市场价</th><th width='8%'>操作</th></thead>";
       }
 
       String tableBody = "";
       tableBody = combineSpecification(goodSpecificationIdArr, map, "");
       html = html + tableBody;
       responseFlag(html);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when build ware", e);
     }
   }
 
   public String combineSpecification(String[] goodSpecificationIdArr, Map<String, List<GoodSpecificationVal>> map, String tableBody)
   {
     int showType = 1;
     for (int i = 0; i < goodSpecificationIdArr.length; i++) {
       GoodSpecification goodSpecification = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationIdArr[i]);
       if (goodSpecification.getShowType().equals("1")) {
         showType = 1;
         break;
       }
       showType = 0;
     }
 
     String trEnd = "";
     if (showType == 1) {
       trEnd = 
         "<td class='gridbody' style='text-align: center;'><input type='text' name='stockArr' size='10' value='0'></td><td class='gridbody' style='text-align: center;'><a href='javascript:void(0);' onclick=upload.open(this,'Ware')>上传</a><input type='hidden' name='picIdWareArr' id='fileUploadId' value='${ware.picId}' /><input type='hidden' name='picWareArr' id='picPath' value='${ware.pic }' class='picPath'></td><td class='gridbody' style='text-align: center;'><a href='javascript:void(0)' class='deleteWare'>删除</a></td></tr>";
     }
     else
     {
       trEnd = 
         "<td class='gridbody' style='text-align: center;'><input type='text' name='stockArr' size='10' value='0'></td>" +
         "<td class='gridbody' style='text-align: center;'><input type='text' name='priceShopArr' size='10' value='0'></td>"+
         "<td class='gridbody' style='text-align: center;'><input type='text' name='priceMarketArr' size='10' value='0'></td>"+
         "<td class='gridbody' style='text-align: center;'><a href='javascript:void(0)' class='deleteWare'>删除</a></td></tr>";
     }
 
     if (StringUtils.isNotBlank(goodSpecificationIdArr[0])) {
       String goodSpecificationId = goodSpecificationIdArr[0];
 
       List list = (List)map.get(goodSpecificationId);
       if ((list != null) && (list.size() > 0)) {
         for (int i = 0; i < list.size(); i++) {
           String trStart = 
             "<td class='gridbody' style='text-align: center;'><input type='hidden' name='wareCodeArr' value=''>" + ((GoodSpecificationVal)list.get(i)).getValue() + 
             "<input type='hidden' name='wareSpecificationValId1Arr' value='" + ((GoodSpecificationVal)list.get(i)).getId() + "'></td>";
           if (map.size() == 1) {
             tableBody = tableBody + trStart;
             tableBody = tableBody + trEnd;
           } else if (map.size() == 2)
           {
             List list2 = (List)map.get(goodSpecificationIdArr[1]);
             for (int j = 0; j < list2.size(); j++) {
               tableBody = tableBody + trStart;
               tableBody = tableBody + "<td class='gridbody' style='text-align: center;'>" + ((GoodSpecificationVal)list2.get(j)).getValue() + 
                 "<input type='hidden' name='wareSpecificationValId2Arr' value='" + ((GoodSpecificationVal)list2.get(j)).getId() + "'></td>";
               tableBody = tableBody + trEnd;
             }
           } else if (map.size() == 3)
           {
             List list2 = (List)map.get(goodSpecificationIdArr[1]);
             for (int j = 0; j < list2.size(); j++)
             {
               List list3 = (List)map.get(goodSpecificationIdArr[2]);
               for (int k = 0; k < list3.size(); k++) {
                 tableBody = tableBody + trStart;
                 tableBody = tableBody + "<td class='gridbody' style='text-align: center;'>" + ((GoodSpecificationVal)list2.get(j)).getValue() + 
                   "<input type='hidden' name='wareSpecificationValId2Arr' value='" + ((GoodSpecificationVal)list2.get(j)).getId() + "'></td>";
                 tableBody = tableBody + "<td class='gridbody' style='text-align: center;'>" + ((GoodSpecificationVal)list3.get(k)).getValue() + 
                   "<input type='hidden' name='wareSpecificationValId3Arr' value='" + ((GoodSpecificationVal)list3.get(k)).getId() + "'></td>";
                 tableBody = tableBody + trEnd;
               }
             }
           }
         }
       }
     }
     return tableBody;
   }
 
   public String editExcelDate(){
     return "upload_excel";
   }
 
   public void getExcelDate()
   {
     HttpServletRequest request = getRequest();
     SysUser loginMan = getSessionUserInfo();
     try {
       String filePaht = request.getParameter("fileBrowser");
       
       File file = new File(filePaht);
       Workbook book = Workbook.getWorkbook(file);
        
       if (book != null)
       {
         Sheet sheet = book.getSheet(0);
 
         int rows = sheet.getRows();
         int columns = sheet.getColumns();
         for (int i = 1; i < rows; i++) {
           boolean hasText = false;
           for (int j = 0; j < columns; j++) {
             if ((sheet.getCell(j, i).getContents().length() == 0) || (this.goodService.getGoodByCode(sheet.getCell(0, i).getContents()) != null)) break;
             hasText = true;
 
             if (hasText) {
               try {
                 this.good = new Good();
                 this.good.setId(this.goodService.makeId());
                 //设置编码
                 this.good.setCode(sheet.getCell(0, i).getContents());
                 //设置名称
                 this.good.setName(sheet.getCell(1, i).getContents());
                 //设置品牌的Id和品牌的名字
                 if (sheet.getCell(2, i).getContents().length() != 0) {
                   String brandCode = sheet.getCell(2, i).getContents();
                   this.goodBrand = this.goodBrandService.getByCode(brandCode);
                   if (this.goodBrand != null) {
                     this.good.setBrandId(this.goodBrand.getId());
                   }
                 }
                 this.good.setBrandName(sheet.getCell(3, i).getContents());
                 
                 //设置销售价和市场价
                 Double price = Double.valueOf(0.0D);
                 if (sheet.getCell(4, i).getContents().length() != 0) {
                   price = Double.valueOf(Double.parseDouble(sheet.getCell(4, i).getContents()));
                 }
                 this.good.setPrice(price);
 
                 Double marketPrice = Double.valueOf(0.0D);
                 if (sheet.getCell(5, i).getContents().length() != 0) {
                	 marketPrice = Double.valueOf(Double.parseDouble(sheet.getCell(5, i).getContents()));
                 }
                 this.good.setPriceMarket(marketPrice);
                 
                 this.good.setIsInventory(sheet.getCell(6, i).getContents());
                 //设置商品类型代码和商品类型名称
                 if (sheet.getCell(7, i).getContents().length() != 0) {
                   String typeCode = sheet.getCell(7, i).getContents();
                   this.goodType = this.goodTypeService.getByCode(typeCode);
                   if (this.goodType != null) {
                     this.good.setGoodTypeId(this.goodType.getId());
                     this.good.setGoodTypeName(this.goodType.getName());
                   }
                 }
                 //设置初始数量
                 Double initialNum = null;
                 if (sheet.getCell(8, i).getContents().length() != 0) {
                   initialNum = Double.valueOf(Double.parseDouble(sheet.getCell(8, i).getContents()));
                 }
                 this.good.setRemark(sheet.getCell(9,i).getContents());
                 this.good.setIndexShow("0");
                 this.good.setTotalNum(sheet.getCell(8,i).getContents());
                 this.good.setInitialNum(initialNum);
                 this.good.setPrice(price);
                 this.good.setCreatorId(loginMan.getCreatorId());
                 this.good.setCreateTime(new Date());
                 this.good.setCreatorName(loginMan.getCreatorName());
                 this.good.setState("s");
                 this.good.setIsNext("0");
                 this.good.setCreatorId("1");
                 this.good.setCreatorName("admin");
                 this.goodService.insert(this.good);
               } catch (Exception e) {
                 e.printStackTrace();
                 responseFlag(false);
               }
             }
           }
         }
         responseFlag(true);
         book.close();
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public String upload()throws Exception{
     HttpServletRequest request = getRequest();
     String folderPath = Static.APACHE_CONTEXT_PATH + Static.FILE_PATH;
     Date now = new Date();
     String nowStr = DateUtil.date2Str(now, "yyyyMMdd");
     now = DateUtil.str2Date(nowStr, "yyyyMMdd");
 
     folderPath = folderPath + "/excel/" + nowStr;
 
     
     String fileName = "";
     String topath = "";
     boolean isOk = true;
     if ((this.fileupload != null) && (this.fileupload.length > 0)) {
       logger.info("fileupload.length:" + this.fileupload.length);
 
       File savedir = new File(folderPath);
       if (!savedir.exists()) {
         savedir.mkdirs();
       }
 
       for (int i = 0; i < this.fileupload.length; i++) {
         fileName = this.fileuploadFileName[i];
         String postfix = fileName.substring(fileName.lastIndexOf(".") + 1);
         logger.info("uploadFileName[" + i + "]=" + fileName);
 
         String id = fileName.substring(0, fileName.lastIndexOf("."));
         String fileNewName = id + "." + postfix;
         File savefile = new File(savedir, fileNewName);
         topath = savedir.getPath() + "/" + fileNewName;
         logger.info("save file:" + fileNewName + " to folder:" + savedir.getPath());
         try {
           FileUtils.copyFile(this.fileupload[i], savefile);
 
           StringBuffer relativePath = new StringBuffer();
           relativePath.append(Static.FILE_PATH)
             .append("/").append(this.appType)
             .append("/").append(nowStr)
             .append("/").append(id).append(".").append(postfix);
         } catch (Exception e) {
           if (isOk) {
             isOk = false;
           }
           logger.error("error when copyFile,savefile:" + savefile, e);
         }
       }
     } else {
       logger.warn("fileupload is null or fileupload.length <=0");
       isOk = false;
     }
     request.setAttribute("topath", topath);
     request.setAttribute("fileName", fileName);
     request.setAttribute("isOk", Boolean.valueOf(isOk));
     return "edit_excelDate";
   }
 
   public String selTypejson()
   {
     List levelLists = null;
     GoodType GoodType1 = new GoodType();
     if (this.good.getGoodTypeId() != null) {
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.good.getGoodTypeId()));
       GoodType1 = this.goodType;
       if (this.goodType != null) {
         this.goodType = new GoodType();
         this.goodType.setParentId(this.good.getGoodTypeId());
       }
       levelLists = this.goodTypeService.select(this.goodType);
     }
     if (levelLists == null) {
       levelLists = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("rows", levelLists);
     this.jsonMap.put("Parent", GoodType1);
     return "success";
   }
 
   public String AllTypeGoodjson()
   {
     logger.info("开始根据类别和类别等级查询商品!");
     List resultList = null;
     if (this.good == null) {
       this.good = new Good();
     }
     if (this.good.getGoodTypeId() != null) {
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.good.getGoodTypeId()));
       this.good.setLevel(this.goodType.getLevel());
     }
     try {
       this.good.setBeginSaleTime(new Date());
       resultList = this.goodService.select("Good.Good_sel", this.good);
     } catch (Exception e) {
       logger.error("根据类别和类别等级查询商品出错", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("rows", resultList);
     logger.info("根据类别和类别等级查询商品成功!");
     return "success";
   }
 
   public String AllTypeNamejson()
   {
     List resultList = null;
     if (this.goodType == null)
       this.goodType = new GoodType();
     try
     {
       resultList = this.goodTypeService.select("GoodType.GoodType", this.goodType);
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.goodType.getParentId()));
     } catch (Exception e) {
       logger.error("根据类别和类别等级查询商品出错", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("rows", resultList);
     this.jsonMap.put("Parent", this.goodType);
     return "success";
   }
 
   public void changeToComm()
     throws Exception
   {
     this.good.setIsInventory("1");
     this.goodList = this.goodService.select(this.good);
     for (Iterator localIterator = this.goodList.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
       this.good = ((Good)object);
       this.good.setEndSaleTime(null);
       this.good.setIsInventory("0");
       this.goodService.update(this.good);
     }
   }
 
   public void checkCode()
   {
     if (this.good == null) {
       this.good = new Good();
     }
     String code = this.good.getCode();
     if (code != null) {
       this.good = ((Good)this.goodService.selectOne(this.good));
       if (this.good == null)
         responseFlag(true);
       else
         responseFlag(false);
     }
   }
 
   public Good getGood()
   {
     return this.good;
   }
   public void setGood(Good good) {
     this.good = good;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
   public List<Good> getGoodList() {
     return this.goodList;
   }
   public GoodType getGoodType() {
     return this.goodType;
   }
   public void setGoodList(List<Good> goodList) {
     this.goodList = goodList;
   }
   public void setGoodType(GoodType goodType) {
     this.goodType = goodType;
   }
   public String getImgIdStr() {
     return this.imgIdStr;
   }
   public void setImgIdStr(String imgIdStr) {
     this.imgIdStr = imgIdStr;
   }
   public GoodExtend getGoodExtend() {
     return this.goodExtend;
   }
   public void setGoodExtend(GoodExtend goodExtend) {
     this.goodExtend = goodExtend;
   }
   public List<GoodKind> getGoodKindList() {
     return this.goodKindList;
   }
   public List<GoodAttr> getGoodAttrList() {
     return this.goodAttrList;
   }
   public void setGoodKindList(List<GoodKind> goodKindList) {
     this.goodKindList = goodKindList;
   }
   public void setGoodAttrList(List<GoodAttr> goodAttrList) {
     this.goodAttrList = goodAttrList;
   }
 
   public void setStateArr(String[] stateArr) {
     this.stateArr = stateArr;
   }
   public List<GoodPrice> getGoodPriceList() {
     return this.goodPriceList;
   }
   public void setGoodPriceList(List<GoodPrice> goodPriceList) {
     this.goodPriceList = goodPriceList;
   }
   public String[] getGoodAttrIdArr() {
     return this.goodAttrIdArr;
   }
   public String[] getAttrValueArr() {
     return this.attrValueArr;
   }
   public void setGoodAttrIdArr(String[] goodAttrIdArr) {
     this.goodAttrIdArr = goodAttrIdArr;
   }
   public void setAttrValueArr(String[] attrValueArr) {
     this.attrValueArr = attrValueArr;
   }
   public List<FileUpload> getGoodPicList() {
     return this.goodPicList;
   }
   public void setGoodPicList(List<FileUpload> goodPicList) {
     this.goodPicList = goodPicList;
   }
   public String[] getPicIdArr() {
     return this.picIdArr;
   }
   public void setPicIdArr(String[] picIdArr) {
     this.picIdArr = picIdArr;
   }
   public String[] getGoodRelateIdArr() {
     return this.goodRelateIdArr;
   }
   public void setGoodRelateIdArr(String[] goodRelateIdArr) {
     this.goodRelateIdArr = goodRelateIdArr;
   }
   public List<GoodRelate> getGoodRelateList() {
     return this.goodRelateList;
   }
   public void setGoodRelateList(List<GoodRelate> goodRelateList) {
     this.goodRelateList = goodRelateList;
   }
   public String[] getGoodComposeIdArr() {
     return this.goodComposeIdArr;
   }
   public Double[] getGoodComposePriceDisArr() {
     return this.goodComposePriceDisArr;
   }
   public void setGoodComposeIdArr(String[] goodComposeIdArr) {
     this.goodComposeIdArr = goodComposeIdArr;
   }
   public void setGoodComposePriceDisArr(Double[] goodComposePriceDisArr) {
     this.goodComposePriceDisArr = goodComposePriceDisArr;
   }
   public List<GoodCompose> getGoodComposeList() {
     return this.goodComposeList;
   }
   public void setGoodComposeList(List<GoodCompose> goodComposeList) {
     this.goodComposeList = goodComposeList;
   }
   public String[] getSpecificationValIdArr() {
     return this.specificationValIdArr;
   }
   public void setSpecificationValIdArr(String[] specificationValIdArr) {
     this.specificationValIdArr = specificationValIdArr;
   }
   public String[] getWareCodeArr() {
     return this.wareCodeArr;
   }
   public Integer[] getStockArr() {
     return this.stockArr;
   }
   public Double[] getWarePriceDiscountArr() {
     return this.warePriceDiscountArr;
   }
   public void setWareCodeArr(String[] wareCodeArr) {
     this.wareCodeArr = wareCodeArr;
   }
   public void setStockArr(Integer[] stockArr) {
     this.stockArr = stockArr;
   }
   public void setWarePriceDiscountArr(Double[] warePriceDiscountArr) {
     this.warePriceDiscountArr = warePriceDiscountArr;
   }
   public String[] getWareSpecificationValId1Arr() {
     return this.wareSpecificationValId1Arr;
   }
   public String[] getWareSpecificationValId2Arr() {
     return this.wareSpecificationValId2Arr;
   }
   public String[] getWareSpecificationValId3Arr() {
     return this.wareSpecificationValId3Arr;
   }
   public void setWareSpecificationValId1Arr(String[] wareSpecificationValId1Arr) {
     this.wareSpecificationValId1Arr = wareSpecificationValId1Arr;
   }
   public void setWareSpecificationValId2Arr(String[] wareSpecificationValId2Arr) {
     this.wareSpecificationValId2Arr = wareSpecificationValId2Arr;
   }
   public void setWareSpecificationValId3Arr(String[] wareSpecificationValId3Arr) {
     this.wareSpecificationValId3Arr = wareSpecificationValId3Arr;
   }
   public List<Ware> getWareList() {
     return this.wareList;
   }
   public void setWareList(List<Ware> wareList) {
     this.wareList = wareList;
   }
   public List<GoodSpecification> getGoodSpecificationList() {
     return this.goodSpecificationList;
   }
 
   public void setGoodSpecificationList(List<GoodSpecification> goodSpecificationList) {
     this.goodSpecificationList = goodSpecificationList;
   }
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
   public String[] getPicArr() {
     return this.picArr;
   }
   public void setPicArr(String[] picArr) {
     this.picArr = picArr;
   }
   public GoodBrand getGoodBrand() {
     return this.goodBrand;
   }
   public void setGoodBrand(GoodBrand goodBrand) {
     this.goodBrand = goodBrand;
   }
   public void setGoodBrandService(GoodBrandService goodBrandService) {
     this.goodBrandService = goodBrandService;
   }
 
   public Supplier getSupplier() {
     return this.supplier;
   }
 
   public void setSupplier(Supplier supplier) {
     this.supplier = supplier;
   }
 
   public void setSupplierService(SupplierService supplierService) {
     this.supplierService = supplierService;
   }
 
   public File[] getFileupload() {
     return this.fileupload;
   }
 
   public void setFileupload(File[] fileupload) {
     this.fileupload = fileupload;
   }
 
   public String[] getFileuploadFileName() {
     return this.fileuploadFileName;
   }
 
   public void setFileuploadFileName(String[] fileuploadFileName) {
     this.fileuploadFileName = fileuploadFileName;
   }
 
   public WarehousePositionWare getWarehousePositionWare() {
     return this.warehousePositionWare;
   }
 
   public void setWarehousePositionWare(WarehousePositionWare warehousePositionWare) {
     this.warehousePositionWare = warehousePositionWare;
   }
 
   public void setWarehousePositionWareService(WarehousePositionWareService warehousePositionWareService)
   {
     this.warehousePositionWareService = warehousePositionWareService;
   }
 
   public WarehouseIntoWare getWarehouseIntoWare() {
     return this.warehouseIntoWare;
   }
 
   public void setWarehouseIntoWare(WarehouseIntoWare warehouseIntoWare) {
     this.warehouseIntoWare = warehouseIntoWare;
   }
 
   public void setWarehouseIntoWareService(WarehouseIntoWareService warehouseIntoWareService)
   {
     this.warehouseIntoWareService = warehouseIntoWareService;
   }
 
   public Ware getWare() {
     return this.ware;
   }
 
   public void setWare(Ware ware) {
     this.ware = ware;
   }
 
   public WarehouseWare getWarehouseWare() {
     return this.warehouseWare;
   }
 
   public void setWarehouseWare(WarehouseWare warehouseWare) {
     this.warehouseWare = warehouseWare;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public Warehouse getWarehouse() {
     return this.warehouse;
   }
 
   public void setWarehouse(Warehouse warehouse) {
     this.warehouse = warehouse;
   }
 
   public WarehouseService getWarehouseService() {
     return this.warehouseService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 
   public Double[] getPriceArr() {
     return this.priceArr;
   }
 
   public void setPriceArr(Double[] priceArr) {
     this.priceArr = priceArr;
   }
 
   public String[] getAreaIdArr() {
     return this.areaIdArr;
   }
 
   public void setAreaIdArr(String[] areaIdArr) {
     this.areaIdArr = areaIdArr;
   }
 
   public String[] getAreaNameArr() {
     return this.areaNameArr;
   }
 
   public void setAreaNameArr(String[] areaNameArr) {
     this.areaNameArr = areaNameArr;
   }
 
   public String[] getStateArr() {
     return this.stateArr;
   }
 
   public String[] getPropertyArr() {
     return this.propertyArr;
   }
 
   public void setPropertyArr(String[] propertyArr) {
     this.propertyArr = propertyArr;
   }
 
   public String[] getTagArr() {
     return this.tagArr;
   }
 
   public void setTagArr(String[] tagArr) {
     this.tagArr = tagArr;
   }
 
   public String[] getPicIdWareArr() {
     return this.picIdWareArr;
   }
 
   public void setPicIdWareArr(String[] picIdWareArr) {
     this.picIdWareArr = picIdWareArr;
   }
 
   public GoodService getGoodService() {
     return this.goodService;
   }
 
   public GoodBrandService getGoodBrandService() {
     return this.goodBrandService;
   }
 
   public SupplierService getSupplierService() {
     return this.supplierService;
   }
 
   public GoodTypeService getGoodTypeService() {
     return this.goodTypeService;
   }
 
   public GoodExtendService getGoodExtendService() {
     return this.goodExtendService;
   }
 
   public FileUploadService getFileUploadService() {
     return this.fileUploadService;
   }
 
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public GoodKindService getGoodKindService() {
     return this.goodKindService;
   }
 
   public GoodAttrService getGoodAttrService() {
     return this.goodAttrService;
   }
 
   public GoodAttrValueService getGoodAttrValueService() {
     return this.goodAttrValueService;
   }
 
   public GoodPriceService getGoodPriceService() {
     return this.goodPriceService;
   }
 
   public GoodRelateService getGoodRelateService() {
     return this.goodRelateService;
   }
 
   public GoodComposeService getGoodComposeService() {
     return this.goodComposeService;
   }
 
   public GoodSpecificationService getGoodSpecificationService() {
     return this.goodSpecificationService;
   }
 
   public GoodSpecificationValService getGoodSpecificationValService() {
     return this.goodSpecificationValService;
   }
 
   public WareService getWareService() {
     return this.wareService;
   }
 
   public WareSpecificationValService getWareSpecificationValService() {
     return this.wareSpecificationValService;
   }
 
   public WarehousePositionWareService getWarehousePositionWareService() {
     return this.warehousePositionWareService;
   }
 
   public WarehouseIntoWareService getWarehouseIntoWareService() {
     return this.warehouseIntoWareService;
   }
 
   public WarehouseWareService getWarehouseWareService() {
     return this.warehouseWareService;
   }
 
   public String[] getPicWareArr() {
     return this.picWareArr;
   }
 
   public void setPicWareArr(String[] picWareArr) {
     this.picWareArr = picWareArr;
   }

public Double[] getPriceShopArr() {
	return priceShopArr;
}

public void setPriceShopArr(Double[] priceShopArr) {
	this.priceShopArr = priceShopArr;
}

public Double[] getPriceMarketArr() {
	return priceMarketArr;
}

public void setPriceMarketArr(Double[] priceMarketArr) {
	this.priceMarketArr = priceMarketArr;
	}
public void setGoodTypeService(GoodTypeService goodTypeService)
{
  this.goodTypeService = goodTypeService;
}

public void setGoodExtendService(GoodExtendService goodExtendService) {
  this.goodExtendService = goodExtendService;
}

public void setFileUploadService(FileUploadService fileUploadService) {
  this.fileUploadService = fileUploadService;
}

public void setSerialNumberService(SerialNumberService serialNumberService) {
  this.serialNumberService = serialNumberService;
}

public void setGoodKindService(GoodKindService goodKindService) {
  this.goodKindService = goodKindService;
}

public void setGoodAttrService(GoodAttrService goodAttrService) {
  this.goodAttrService = goodAttrService;
}

public void setGoodAttrValueService(GoodAttrValueService goodAttrValueService) {
  this.goodAttrValueService = goodAttrValueService;
}

public void setGoodPriceService(GoodPriceService goodPriceService) {
  this.goodPriceService = goodPriceService;
}

public void setGoodRelateService(GoodRelateService goodRelateService) {
  this.goodRelateService = goodRelateService;
}

public void setGoodComposeService(GoodComposeService goodComposeService) {
  this.goodComposeService = goodComposeService;
}

public void setGoodSpecificationService(GoodSpecificationService goodSpecificationService) {
  this.goodSpecificationService = goodSpecificationService;
}

public void setGoodSpecificationValService(GoodSpecificationValService goodSpecificationValService) {
  this.goodSpecificationValService = goodSpecificationValService;
}

public void setWareService(WareService wareService) {
  this.wareService = wareService;
}

public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService) {
  this.wareSpecificationValService = wareSpecificationValService;
}

}