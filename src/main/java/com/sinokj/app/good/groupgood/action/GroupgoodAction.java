 package com.sinokj.app.good.groupgood.action;
 
 import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.common.Static;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
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
import com.sinokj.app.good.groupgood.model.Groupgood;
import com.sinokj.app.good.groupgood.service.GroupgoodService;
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
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import jxl.Cell;
 import jxl.Sheet;
 import jxl.Workbook;
 import org.apache.commons.io.FileUtils;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GroupgoodAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(GroupgoodAction.class);
   private GroupgoodService groupgoodService;
   private Groupgood groupgood;
   private GoodExtend goodExtend;
   private List<Groupgood> goodList;
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
   private Double[] priceDiscountArr;
   private Integer[] numberArr;
   private String[] stateArr;
   private String[] specificationValIdArr;
   private String[] wareIdArr;
   private String[] wareCodeArr;
   private Integer[] stockArr;
   private Double[] warePriceDiscountArr;
   private String[] wareSpecificationValId1Arr;
   private String[] wareSpecificationValId2Arr;
   private String[] wareSpecificationValId3Arr;
   private String[] picIdArr;
   private String[] picArr;
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
 
   public String listJson()
   {
     logger.info("start list goods!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.groupgood == null) {
         this.groupgood = new Groupgood();
       }
       resultList = this.groupgoodService.pageList(pageInfo, this.groupgood, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list groupgoods", e);
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
     HttpServletRequest request = getRequest();
     SysUser loginUser = getSessionUserInfo();
     request.setAttribute("loginUser", loginUser);
     return "list_groupGood";
   }
 
   public String edit()
   {
     HttpServletRequest request = getRequest();
     if (this.groupgood == null) {
       this.groupgood = new Groupgood();
     }
     this.goodKindList = this.goodKindService.select(new GoodKind());
     this.goodPriceList = new ArrayList();
     this.goodPicList = new ArrayList();
     Integer picNum = Integer.valueOf(ConfigUtil.getGoodPicNum());
     if (StringUtils.isBlank(this.groupgood.getId())) {
       initModel(true, this.groupgood, getSessionUserInfo());
       this.groupgood.setOrderMultiple(Integer.valueOf(1));
       for (int i = 0; i < 5; i++)
         this.goodPriceList.add(new GoodPrice());
     }
     else {
       this.groupgood = ((Groupgood)this.groupgoodService.getModel(this.groupgood.getId()));
       if (this.groupgood != null) {
         this.wareList = this.wareService.getWareByGoodId(this.groupgood.getId());
         if ((this.wareList != null) && 
           (this.wareList.size() > 0)) {
           this.warehousePositionWare = new WarehousePositionWare();
           this.warehousePositionWare.setWareId(((Ware)this.wareList.get(0)).getId());
           this.warehousePositionWare = ((WarehousePositionWare)this.warehousePositionWareService.selectOne(this.warehousePositionWare));
           if (this.warehousePositionWare != null) {
             this.groupgood.setWarehouseName(this.warehousePositionWare.getWarehouseName());
             this.groupgood.setWarehousePositionName(this.warehousePositionWare.getWarehousePositionName());
           }
         }
       }
 
       initModel(false, this.groupgood, getSessionUserInfo());
       try {
         this.goodExtend = this.goodExtendService.getByGroupGoodId(this.groupgood.getId());
       } catch (Exception e) {
         logger.error("获取扩展信息出现错误", e);
       }
       try
       {
         this.goodPriceList = this.goodPriceService.getGoodPriceByGoodId(this.groupgood.getId());
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
         this.wareList = this.wareService.getWareByGroupGoodId(this.groupgood.getId());
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
         this.goodAttrList = this.goodAttrService.getGoodAttr(this.groupgood.getId());
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
         this.goodPicList = this.fileUploadService.getFileUploadByGoodId(this.groupgood.getId());
       } catch (Exception e) {
         logger.error("获取相册图片出错", e);
       }
       try
       {
         this.goodRelateList = this.goodRelateService.getGoodRelateByGoodId(this.groupgood.getId());
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
 
       this.goodComposeList = this.goodComposeService.getGoodComposeByGoodId(this.groupgood.getId());
       String goodComposeIdStr = "";
       if (this.goodComposeList != null) {
         for (int i = 0; i < this.goodComposeList.size(); i++) {
           goodComposeIdStr = goodComposeIdStr + ((GoodCompose)this.goodComposeList.get(i)).getComposeGoodId() + ",";
         }
       }
       request.setAttribute("goodComposeIdStr", goodComposeIdStr);
     }
 
     if (this.goodPicList.size() < picNum.intValue()) {
       int picSize = this.goodPicList.size();
       for (int i = 0; i < picNum.intValue() - picSize; i++) {
         this.goodPicList.add(new FileUpload());
       }
     }
     return "edit_groupGood";
   }
 
   public void save()
   {
     logger.info("start save a groupgood");
     HttpServletRequest request = getRequest();
     String prefix = "";
     String appType = "Good";
     boolean stop = true;
     String wareidString = this.wareService.makeId();
     try
     {
       String picId = request.getParameter("picId");
       String pic = request.getParameter("pic");
       System.out.println("picId:" + picId + "--" + pic);
       if ("".equals(picId)) {
         if ((StringUtils.isNotBlank(this.groupgood.getId())) && (StringUtils.isNotBlank(pic))) {
           this.fileUploadService.removeAppId(pic, this.groupgood.getId());
         }
         File f = new File("D:\\apache-tomcat-6.0.33\\webapps\\egshops2.0" + pic);
         f.delete();
         pic = "";
       }
 
       this.groupgood.setPicId(picId);
       this.groupgood.setPic(pic);
 
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.groupgood.getGoodTypeId()));
       prefix = this.goodType.getCode();
 
       String goodKindId = request.getParameter("goodKind");
 
       if (StringUtils.isNotBlank(goodKindId)) {
         GoodKind goodKind = (GoodKind)this.goodKindService.getModel(goodKindId);
         if (goodKind != null) {
           this.groupgood.setGoodKindId(goodKind.getId());
           this.groupgood.setGoodKindName(goodKind.getName());
         }
 
       }
 
       if (StringUtils.isNotBlank(this.groupgood.getId())) {
         this.groupgoodService.update(this.groupgood);
         stop = false;
         if (StringUtils.isNotBlank(picId))
           this.fileUploadService.updateAppId(picId, this.groupgood.getId());
       }
       else
       {
         String code = this.serialNumberService.getSerialNumberNoDate(prefix, appType + prefix, 3);
         this.groupgood.setCode(code);
         String id = this.groupgoodService.makeId();
         this.groupgood.setId(id);
         this.groupgoodService.insertGood(this.groupgood);
 
         this.warehouse = new Warehouse();
         this.warehouse.setId(this.groupgood.getWarehouseId());
         this.warehouse = ((Warehouse)this.warehouseService.select(this.warehouse).get(0));
         Double totle = this.warehouse.getTotalCostInventory();
         Double moneyIn = Double.valueOf(this.groupgood.getInitialNum().intValue() * this.groupgood.getPurchasePrice().doubleValue());
         totle = Double.valueOf(totle.doubleValue() + moneyIn.doubleValue());
         this.warehouse.setTotalCostInventory(totle);
         this.warehouseService.update(this.warehouse);
       }
 
       GoodExtend ge = this.goodExtendService.getByGroupGoodId(this.groupgood.getId());
       this.goodExtend.setGroupgoodId(this.groupgood.getId());
       if (ge == null)
         this.goodExtendService.insert(this.goodExtend);
       else {
         this.goodExtendService.updateByGroupGoodId(this.goodExtend);
       }
 
       this.goodAttrValueService.deleteByGoodId(this.groupgood.getId());
       if ((this.goodAttrIdArr != null) && (this.goodAttrIdArr.length != 0)) {
         for (int i = 0; i < this.goodAttrIdArr.length; i++) {
           if (StringUtils.isNotBlank(this.goodAttrIdArr[i])) {
             GoodAttrValue goodAttrValue = new GoodAttrValue();
             goodAttrValue.setGoodId(this.groupgood.getId());
             goodAttrValue.setGoodAttrId(this.goodAttrIdArr[i]);
             goodAttrValue.setAttrValue(this.attrValueArr[i]);
             goodAttrValue.setSort(Integer.valueOf(i));
             this.goodAttrValueService.insert(goodAttrValue);
           }
         }
       }
 
       this.goodPriceService.deleteByGroupGoodId(this.groupgood.getId());
 
       if ((this.priceDiscountArr != null) && (this.priceDiscountArr.length != 0)) {
         for (int i = 0; i < this.priceDiscountArr.length; i++) {
           if (this.priceDiscountArr[i].doubleValue() > 0.0D) {
             GoodPrice goodPrice = new GoodPrice();
             goodPrice.setState(this.stateArr[i]);
             String priceCode = "Wholesale" + String.valueOf(i + 1);
             goodPrice.setCode(priceCode);
             goodPrice.setSort(Integer.valueOf(i));
             this.goodPriceService.insert(goodPrice);
           }
         }
 
       }
 
       if ((this.wareIdArr == null) || (this.wareIdArr.length == 0)) {
         this.wareList = this.wareService.getWareByGroupGoodId(this.groupgood.getId());
 
         if ((this.wareList != null) && (this.wareList.size() != 0)) {
           this.wareIdArr = new String[this.wareList.size()];
           for (int i = 0; i < this.wareList.size(); i++) {
             this.wareIdArr[i] = ((Ware)this.wareList.get(i)).getId();
           }
 
         }
 
       }
 
       if ((this.wareCodeArr != null) && (this.wareCodeArr.length != 0)) {
         for (int i = 0; i < this.wareCodeArr.length; i++)
         {
           if (StringUtils.isBlank(this.wareCodeArr[i])) {
             this.wareCodeArr[i] = (this.groupgood.getCode() + "-" + (i + 1));
           }
           Ware ware = new Ware();
           if ((this.wareIdArr != null) && (this.wareIdArr.length >= i + 1) && (StringUtils.isNotBlank(this.wareIdArr[i])))
             ware.setId(this.wareIdArr[i]);
           else stop = true;
           ware.setGroupgoodId(this.groupgood.getId());
           ware.setCode(this.wareCodeArr[i]);
           ware.setStock(this.stockArr[i]);
           ware.setPriceDiscount(this.warePriceDiscountArr[i]);
           ware.setSort(Integer.valueOf(i));
           this.wareService.insertOrUpdate("Ware.Ware", ware);
 
           ware = (Ware)this.wareService.selectOne(ware);
           if (stop)
           {
             this.warehousePositionWare = new WarehousePositionWare();
             this.warehousePositionWare.setWarehousePositionId(this.groupgood.getWarehousePositionId());
             this.warehousePositionWare.setWarehousePositionName(this.groupgood.getWarehousePositionName());
             this.warehousePositionWare.setWareId(ware.getId());
             this.warehousePositionWare.setWareName(this.groupgood.getName());
             this.warehousePositionWare.setWareCount(ware.getStock().intValue());
             this.warehousePositionWare.setWarehouseId(this.groupgood.getWarehouseId());
             this.warehousePositionWare.setWarehouseName(this.groupgood.getWarehouseName());
             this.warehousePositionWare.setSort(Integer.valueOf(i));
             this.warehousePositionWareService.insert(this.warehousePositionWare);
 
             this.warehouseIntoWare = new WarehouseIntoWare();
             this.warehouseIntoWare.setWarehousePositionId(this.groupgood.getWarehousePositionId());
             this.warehouseIntoWare.setWarehousePositionName(this.groupgood.getWarehousePositionName());
             this.warehouseIntoWare.setWareId(ware.getId());
             this.warehouseIntoWare.setWareName(this.groupgood.getName());
             this.warehouseIntoWare.setIntoNum(ware.getStock().intValue());
             this.warehouseIntoWare.setPriceIn(this.groupgood.getPurchasePrice());
             Double moneyIn = Double.valueOf(this.warehouseIntoWare.getIntoNum() * this.warehouseIntoWare.getPriceIn().doubleValue());
             this.warehouseIntoWare.setMoneyIn(moneyIn);
             this.warehouseIntoWare.setSort(Integer.valueOf(i));
             this.warehouseIntoWareService.insert(this.warehouseIntoWare);
 
             this.warehouseWare = new WarehouseWare();
             this.warehouseWare.setWarehouseId(this.groupgood.getWarehouseId());
             this.warehouseWare.setWarehouseName(this.groupgood.getWarehouseName());
             this.warehouseWare.setWareId(ware.getId());
             this.warehouseWare.setWareName(this.groupgood.getName());
             this.warehouseWare.setWareCount(ware.getStock().intValue());
             this.warehouseWare.setAverageCostInventory(this.groupgood.getPurchasePrice());
             this.warehouseWare.setTotalCostInventory(moneyIn);
             this.warehouseWare.setSort(Integer.valueOf(i));
             this.warehouseWareService.insert(this.warehouseWare);
           }
 
           ware = this.wareService.getWareByCodes(this.groupgood.getId(), ware.getCode());
 
           if ((this.wareSpecificationValId1Arr != null) && (StringUtils.isNotBlank(this.wareSpecificationValId1Arr[i]))) {
             WareSpecificationVal wareSpecificationVal = 
               this.wareSpecificationValService.getSpecificationVal(ware.getId(), this.wareSpecificationValId1Arr[i]);
             if (wareSpecificationVal == null) {
               wareSpecificationVal = new WareSpecificationVal();
               wareSpecificationVal.setWareId(ware.getId());
               wareSpecificationVal.setGoodSpecificationValId(this.wareSpecificationValId1Arr[i]);
               wareSpecificationVal.setSort(Integer.valueOf(1));
               this.wareSpecificationValService.insertOrUpdate("WareSpecificationVal.WareSpecificationVal", wareSpecificationVal);
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
             }
           }
         }
 
         if (this.wareIdArr != null) {
           for (int i = this.wareCodeArr.length; i < this.wareIdArr.length; i++) {
             this.wareSpecificationValService.deleteByWareId(this.wareIdArr[i]);
             this.wareService.delete(this.wareIdArr[i]);
           }
         }
       }
       else
       {
         Ware ware = this.wareService.getWareByGroupId(this.groupgood.getId());
         if (ware == null)
         {
           ware = new Ware();
           ware.setCode(this.groupgood.getCode());
           ware.setGroupgoodId(this.groupgood.getId());
           if (this.groupgood.getInitialNum() != null) ware.setStock(Integer.valueOf(this.groupgood.getInitialNum().intValue()));
           ware.setPriceDiscount(Double.valueOf(0.0D));
           ware.setSort(Integer.valueOf(1));
           this.wareService.insert(ware);
 
           if (stop)
           {
             this.warehousePositionWare = new WarehousePositionWare();
             this.warehousePositionWare.setWarehousePositionId(this.groupgood.getWarehousePositionId());
             this.warehousePositionWare.setWarehousePositionName(this.groupgood.getWarehousePositionName());
             this.warehousePositionWare.setWareId(ware.getId());
             this.warehousePositionWare.setWareName(this.groupgood.getName());
             this.warehousePositionWare.setWareCount(this.groupgood.getInitialNum().intValue());
             this.warehousePositionWare.setWarehouseId(this.groupgood.getWarehouseId());
             this.warehousePositionWare.setWarehouseName(this.groupgood.getWarehouseName());
             this.warehousePositionWare.setSort(Integer.valueOf(1));
             this.warehousePositionWareService.insert(this.warehousePositionWare);
 
             this.warehouseIntoWare = new WarehouseIntoWare();
             this.warehouseIntoWare.setWarehousePositionId(this.groupgood.getWarehousePositionId());
             this.warehouseIntoWare.setWarehousePositionName(this.groupgood.getWarehousePositionName());
             this.warehouseIntoWare.setWareId(ware.getId());
             this.warehouseIntoWare.setWareName(this.groupgood.getName());
             this.warehouseIntoWare.setIntoNum(this.groupgood.getInitialNum().intValue());
             this.warehouseIntoWare.setPriceIn(this.groupgood.getPurchasePrice());
             Double moneyIn = Double.valueOf(this.warehouseIntoWare.getIntoNum() * this.warehouseIntoWare.getPriceIn().doubleValue());
             this.warehouseIntoWare.setMoneyIn(moneyIn);
             this.warehouseIntoWare.setSort(Integer.valueOf(1));
             this.warehouseIntoWareService.insert(this.warehouseIntoWare);
 
             this.warehouseWare = new WarehouseWare();
             this.warehouseWare.setWarehouseId(this.groupgood.getWarehouseId());
             this.warehouseWare.setWarehouseName(this.groupgood.getWarehouseName());
             this.warehouseWare.setWareId(ware.getId());
             this.warehouseWare.setWareName(this.groupgood.getName());
             this.warehouseWare.setWareCount(this.groupgood.getInitialNum().intValue());
             this.warehouseWare.setAverageCostInventory(this.groupgood.getPurchasePrice());
             this.warehouseWare.setTotalCostInventory(moneyIn);
             this.warehouseWare.setSort(Integer.valueOf(1));
             this.warehouseWareService.insert(this.warehouseWare);
           }
         }
 
         if (this.wareIdArr != null) {
           for (int i = 0; i < this.wareIdArr.length; i++) {
             this.wareSpecificationValService.deleteByWareId(this.wareIdArr[i]);
             this.wareService.delete(this.wareIdArr[i]);
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
             this.fileUploadService.updateAppId(this.picIdArr[i], this.groupgood.getId());
           } else if (StringUtils.isNotBlank(this.picArr[i])) {
             File f = new File("D:\\apache-tomcat-6.0.33\\webapps\\allecv2.0" + this.picArr[i]);
             f.delete();
             this.fileUploadService.removeAppId(this.picArr[i], this.groupgood.getId());
           }
 
         }
 
       }
 
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when insert a good!", e);
     }
   }
 
   public void updateState()
   {
     logger.info("start update goods's state");
     try {
       if (this.groupgood == null) {
         this.groupgood = new Groupgood();
       }
       if (StringUtils.isNotBlank(this.groupgood.getId())) {
         this.groupgoodService.updateGoodState(this.groupgood.getId(), this.groupgood.getState());
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
     logger.info("start delete a good:" + this.groupgood.getId());
     try {
       String goodId = this.groupgood.getId();
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
 
           this.groupgoodService.delete(idStr);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a groupgood!", e);
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
 
       html = html + "<thead><th width='15%'>货号</th>";
 
       for (int i = 0; i < goodSpecificationIdArr.length; i++) {
         GoodSpecification goodSpecification = (GoodSpecification)this.goodSpecificationService.getModel(goodSpecificationIdArr[i]);
         html = html + "<th width='10%'>" + goodSpecification.getName() + "</th>";
       }
       html = html + "<th width='10%'>库存</th><th width='10%'>浮动金额</th><th width='8%'>操作</th></thead>";
 
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
     String trEnd = "<td class='gridbody' style='text-align: center;'><input type='text' name='stockArr' size='10' value='0'></td><td class='gridbody' style='text-align: center;'><input type='text' name='warePriceDiscountArr' size='10'></td><td class='gridbody' style='text-align: center;'><a href='javascript:void(0)' class='deleteWare'>删除</a></td></tr>";
 
     if (StringUtils.isNotBlank(goodSpecificationIdArr[0])) {
       String goodSpecificationId = goodSpecificationIdArr[0];
 
       List list = (List)map.get(goodSpecificationId);
       if ((list != null) && (list.size() > 0)) {
         for (int i = 0; i < list.size(); i++) {
           String trStart = "<tr><td class='gridbody' style='text-align: center;'><input type='text' name='wareCodeArr' value=''></td><td class='gridbody' style='text-align: center;'>" + 
             ((GoodSpecificationVal)list.get(i)).getValue() + 
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
 
   public String editExcelDate()
   {
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
         for (int i = 1; i < 10; i++) {
           boolean hasText = false;
           for (int j = 0; j < columns; j++) {
             if ((sheet.getCell(j, i).getContents().length() == 0) || (this.groupgoodService.getGoodByCode(sheet.getCell(0, i).getContents()) != null)) break;
             hasText = true;
 
             if (hasText) {
               try {
                 this.groupgood = new Groupgood();
                 this.groupgood.setId(this.groupgoodService.makeId());
                 this.groupgood.setCode(sheet.getCell(0, i).getContents());
                 this.groupgood.setName(sheet.getCell(1, i).getContents());
 
                 if (sheet.getCell(2, i).getContents().length() != 0) {
                   String brandCode = sheet.getCell(2, i).getContents();
                   this.goodBrand = this.goodBrandService.getByCode(brandCode);
                   if (this.goodBrand != null) {
                     this.groupgood.setBrandId(this.goodBrand.getId());
                   }
                 }
                 this.groupgood.setBrandName(sheet.getCell(3, i).getContents());
 
                 this.groupgood.setUnit(sheet.getCell(4, i).getContents());
 
                 if (sheet.getCell(5, i).getContents().length() != 0) {
                   String supplierCode = sheet.getCell(5, i).getContents();
                   this.supplier = this.supplierService.getByCode(supplierCode);
                   if (this.supplier != null) {
                     this.groupgood.setSupplierId(this.supplier.getId());
                   }
                 }
                 this.groupgood.setSupplierName(sheet.getCell(6, i).getContents());
 
                 Double price = Double.valueOf(0.0D);
                 if (sheet.getCell(7, i).getContents().length() != 0) {
                   price = Double.valueOf(Double.parseDouble(sheet.getCell(7, i).getContents()));
                 }
                 this.groupgood.setPrice(price);
 
                 this.groupgood.setIsInventory(sheet.getCell(8, i).getContents());
 
                 int credits = 0;
                 if (sheet.getCell(9, i).getContents().length() != 0) {
                   credits = Integer.parseInt(sheet.getCell(9, i).getContents());
                 }
                 this.groupgood.setCredits(Integer.valueOf(credits));
 
                 if (sheet.getCell(10, i).getContents().length() != 0) {
                   String typeCode = sheet.getCell(10, i).getContents();
                   this.goodType = this.goodTypeService.getByCode(typeCode);
                   if (this.goodType != null) {
                     this.groupgood.setGoodTypeId(this.goodType.getId());
                     this.groupgood.setGoodTypeName(this.goodType.getName());
                   }
                 }
                 this.groupgood.setCreatorId(loginMan.getCreatorId());
                 this.groupgood.setCreateTime(new Date());
                 this.groupgood.setCreatorName(loginMan.getCreatorName());
                 this.groupgood.setState("s");
                 this.groupgood.setBeginSaleTime(new Date());
                 this.groupgoodService.insert(this.groupgood);
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
 
   public String upload()
     throws Exception
   {
     HttpServletRequest request = getRequest();
     String folderPath = Static.APACHE_CONTEXT_PATH + Static.FILE_PATH;
     Date now = new Date();
     String nowStr = DateUtil.date2Str(now, "yyyyMMdd");
     now = DateUtil.str2Date(nowStr, "yyyyMMdd");
 
     folderPath = folderPath + "/excel/" + nowStr;
 
     logger.info("relativePath:" + folderPath);
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
     if (this.groupgood.getGoodTypeId() != null) {
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.groupgood.getGoodTypeId()));
       GoodType1 = this.goodType;
       if (this.goodType != null) {
         this.goodType = new GoodType();
         this.goodType.setParentId(this.groupgood.getGoodTypeId());
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
     if (this.groupgood == null) {
       this.groupgood = new Groupgood();
     }
     if (this.groupgood.getGoodTypeId() != null) {
       this.goodType = ((GoodType)this.goodTypeService.getModel(this.groupgood.getGoodTypeId()));
       this.groupgood.setLevel(this.goodType.getLevel());
     }
     try {
       this.groupgood.setBeginSaleTime(new Date());
       resultList = this.groupgoodService.select("Good.Good_sel", this.groupgood);
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
 
   public Groupgood getGroupgood() {
     return this.groupgood;
   }
   public void setGroupgood(Groupgood groupgood) {
     this.groupgood = groupgood;
   }
 
   public void setGroupgoodService(GroupgoodService groupgoodService)
   {
     this.groupgoodService = groupgoodService;
   }
 
   public List<Groupgood> getGoodList() {
     return this.goodList;
   }
 
   public void setGoodList(List<Groupgood> goodList) {
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
   public Double[] getPriceDiscountArr() {
     return this.priceDiscountArr;
   }
   public Integer[] getNumberArr() {
     return this.numberArr;
   }
   public String[] getStateArr() {
     return this.stateArr;
   }
   public void setPriceDiscountArr(Double[] priceDiscountArr) {
     this.priceDiscountArr = priceDiscountArr;
   }
   public void setNumberArr(Integer[] numberArr) {
     this.numberArr = numberArr;
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
 }

/* 
 
 
 */