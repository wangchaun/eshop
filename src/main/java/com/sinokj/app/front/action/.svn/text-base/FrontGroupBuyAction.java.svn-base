 package com.sinokj.app.front.action;
 
 import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.front.model.GoodsInCar;
import com.sinokj.app.front.model.ShoppingCar;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodExtend.model.GoodExtend;
import com.sinokj.app.good.goodExtend.service.GoodExtendService;
import com.sinokj.app.good.goodSpecification.model.GoodSpecification;
import com.sinokj.app.good.goodSpecification.model.GoodSpecificationVal;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationService;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationValService;
import com.sinokj.app.good.groupgood.model.Groupgood;
import com.sinokj.app.good.groupgood.service.GroupgoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.code.struct.BaseAction;

 import java.net.URLDecoder;
 import java.util.ArrayList;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class FrontGroupBuyAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(FrontGoodAction.class);
   private Groupgood groupgood;
   private GroupgoodService groupgoodService;
   private WarehouseService warehouseService;
   private List<Area> listWarehouse;
   private Integer warehousecount;
   private GoodSpecificationValService goodSpecificationValService;
   private List<GoodSpecification> list1;
   private FileUploadService fileUploadService;
   private GoodSpecificationService goodSpecificationService;
   private List<FileUpload> goodPicList;
   private GoodExtendService goodExtendService;
   private GoodExtend goodExtend;
   private List<Advertise> advertiseList;
   private AdvertiseService advertiseService;
   private InformationService informationService;
   private List<Information> informationList;
   private List list;
   private Good good;
   private GoodService goodService;
   private Ware ware;
   private List<GoodsInCar> goodsInCarList;
   private WareService wareService;
   private GoodsInCar goodInCar;
   private AreaService areaService;
 
   public String getOneGroupgood()
   {
     logger.info("start to query Goods information");
     HttpServletRequest request = getRequest();
     HttpSession session = request.getSession();
 
     if (StringUtils.isNotBlank(this.groupgood.getId())) {
       this.groupgood = ((Groupgood)this.groupgoodService.select("Groupgood.Groupgood_SY", this.groupgood).get(0));
     }
 
     Area areas = new Area();
     areas.setLevel(3);
     this.listWarehouse = this.areaService.select(areas);
 
     this.warehousecount = ((Integer)this.groupgoodService.selectToT("Groupgood.Groupgood_warehousecount_query", this.groupgood));
 
     GoodSpecificationVal goodSpecificationVal = new GoodSpecificationVal();
     goodSpecificationVal.setGoodId(this.groupgood.getId());
     this.list = this.goodSpecificationValService.select("GoodSpecificationVal.GoodSpecificationVal_groupgood_query", goodSpecificationVal);
     List goodSpecificationValList = this.list;
     String[] str = new String[goodSpecificationValList.size()];
     for (int i = 0; i < goodSpecificationValList.size(); i++) {
       str[i] = ((GoodSpecificationVal)goodSpecificationValList.get(i)).getGoodSpecificationId();
     }
     GoodSpecification goodSpecification = new GoodSpecification();
     this.list1 = new ArrayList();
     if (str.length > 0) {
       goodSpecification.setIdArr(str);
       this.list1 = this.goodSpecificationService.select("GoodSpecification.GoodSpecification_specificationVal_query", goodSpecification);
       getRequest().setAttribute("goodSpecificationnumber", Integer.valueOf(this.list1.size()));
     }
     try
     {
       this.goodPicList = this.fileUploadService.getFileUploadByGoodId(this.groupgood.getId());
       getRequest().setAttribute("picSize", Integer.valueOf(this.goodPicList.size()));
     } catch (Exception e) {
       logger.error("获取相册图片出错", e);
     }
     try
     {
       this.goodExtend = this.goodExtendService.getByGoodId(this.groupgood.getId());
     } catch (Exception e) {
       logger.error("商品扩展信息出错", e);
     }
 
     this.advertiseList = this.advertiseService.getAdvertiseList();
     this.informationList = this.informationService.select(new Information());
 
     return "group_good";
   }
 
   public void addGroupGoodToCart() {
     HttpServletRequest request = getRequest();
     try {
       HttpSession session = request.getSession();
       Object obj = session.getAttribute("shoppingCar");
       ShoppingCar shoppingCar = null;
       if (obj == null)
         shoppingCar = new ShoppingCar();
       else {
         shoppingCar = (ShoppingCar)obj;
       }
       if (this.ware == null) {
         this.ware = new Ware();
       }
 
       String goodId = this.good.getId();
 
       String wareId = this.ware.getId();
 
       Integer count = Integer.valueOf(request.getParameter("number"));
 
       String wareSpecificationVal = this.ware.getWareSpecificationVal();
       wareSpecificationVal = URLDecoder.decode(wareSpecificationVal, "UTF-8");
 
       this.goodsInCarList = shoppingCar.getGoodsInCarList();
       if (this.goodsInCarList == null) {
         this.goodsInCarList = new ArrayList();
       }
 
       this.good = new Good();
       this.good = ((Good)this.goodService.getModel(goodId));
       this.ware = ((Ware)this.wareService.getModel(wareId));
 
       if (this.ware != null)
       {
         this.goodInCar = new GoodsInCar();
         this.goodInCar.setId(this.ware.getId());
         this.goodInCar.setCode(this.ware.getCode());
         this.goodInCar.setName(this.good.getName());
         this.goodInCar.setPrice(this.good.getPriceGroupBuy());
         this.goodInCar.setSpecificationVal(wareSpecificationVal);
         this.goodInCar.setCount(count);
         this.goodInCar.setPreferential(Double.valueOf(0.0D));
         this.goodInCar.setCredits(this.good.getCredits());
         this.goodInCar.setPicId(this.good.getPicId());
         this.goodInCar.setPic(this.good.getPic());
         this.goodInCar.setTotalMoney(Double.valueOf(this.good.getPriceGroupBuy().doubleValue() * count.intValue()));
         this.goodInCar.setGoodId(this.good.getId());
         boolean sameFlag = false;
 
         if (this.goodsInCarList.size() > 0) {
           for (int j = 0; j < this.goodsInCarList.size(); j++) {
             GoodsInCar good = (GoodsInCar)this.goodsInCarList.get(j);
             if (good.getId().equals(this.goodInCar.getId()))
             {
               good.setCount(Integer.valueOf(good.getCount().intValue() + count.intValue()));
 
               Double itemMoney = Double.valueOf(good.getCount().intValue() * good.getPrice().doubleValue());
               good.setTotalMoney(itemMoney);
               sameFlag = true;
             }
           }
         }
         if (!sameFlag) {
           this.goodsInCarList.add(this.goodInCar);
         }
       }
       shoppingCar.setGoodsInCarList(this.goodsInCarList);
 
       session.setAttribute("shoppingCar", shoppingCar);
       session.setAttribute("shoppingCarSize", Integer.valueOf(this.goodsInCarList.size()));
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when insert a goodInCar!", e);
     }
   }
 
   public Integer getWarehousecount()
   {
     return this.warehousecount;
   }
 
   public void setWarehousecount(Integer warehousecount) {
     this.warehousecount = warehousecount;
   }
 
   public List<GoodSpecification> getList1() {
     return this.list1;
   }
 
   public void setList1(List<GoodSpecification> list1) {
     this.list1 = list1;
   }
 
   public FileUploadService getFileUploadService() {
     return this.fileUploadService;
   }
 
   public void setFileUploadService(FileUploadService fileUploadService) {
     this.fileUploadService = fileUploadService;
   }
 
   public void setGroupgood(Groupgood groupgood) {
     this.groupgood = groupgood;
   }
 
   public void setGroupgoodService(GroupgoodService groupgoodService) {
     this.groupgoodService = groupgoodService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 
   public void setGoodSpecificationValService(GoodSpecificationValService goodSpecificationValService)
   {
     this.goodSpecificationValService = goodSpecificationValService;
   }
 
   public void setGoodSpecificationService(GoodSpecificationService goodSpecificationService)
   {
     this.goodSpecificationService = goodSpecificationService;
   }
 
   public List<Advertise> getAdvertiseList() {
     return this.advertiseList;
   }
 
   public void setAdvertiseList(List<Advertise> advertiseList) {
     this.advertiseList = advertiseList;
   }
 
   public List<FileUpload> getGoodPicList() {
     return this.goodPicList;
   }
 
   public void setGoodPicList(List<FileUpload> goodPicList) {
     this.goodPicList = goodPicList;
   }
 
   public GoodExtend getGoodExtend() {
     return this.goodExtend;
   }
 
   public void setGoodExtend(GoodExtend goodExtend) {
     this.goodExtend = goodExtend;
   }
 
   public List<Information> getInformationList() {
     return this.informationList;
   }
 
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
 
   public void setGoodExtendService(GoodExtendService goodExtendService) {
     this.goodExtendService = goodExtendService;
   }
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
 
   public List getList() {
     return this.list;
   }
 
   public void setList(List list) {
     this.list = list;
   }
 
   public Groupgood getGroupgood() {
     return this.groupgood;
   }
 
   public Good getGood() {
     return this.good;
   }
 
   public void setGood(Good good) {
     this.good = good;
   }
 
   public GoodService getGoodService() {
     return this.goodService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public Ware getWare() {
     return this.ware;
   }
 
   public void setWare(Ware ware) {
     this.ware = ware;
   }
 
   public List<GoodsInCar> getGoodsInCarList() {
     return this.goodsInCarList;
   }
 
   public void setGoodsInCarList(List<GoodsInCar> goodsInCarList) {
     this.goodsInCarList = goodsInCarList;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public GoodsInCar getGoodInCar() {
     return this.goodInCar;
   }
 
   public void setGoodInCar(GoodsInCar goodInCar) {
     this.goodInCar = goodInCar;
   }
 
   public AreaService getAreaService() {
     return this.areaService;
   }
 
   public void setAreaService(AreaService areaService) {
     this.areaService = areaService;
   }
 
   public List<Area> getListWarehouse() {
     return this.listWarehouse;
   }
 
   public void setListWarehouse(List<Area> listWarehouse) {
     this.listWarehouse = listWarehouse;
   }
 }