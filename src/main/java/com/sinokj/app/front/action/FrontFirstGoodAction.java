 package com.sinokj.app.front.action;
 
 import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.front.service.WareCommentService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodExtend.service.GoodExtendService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.code.struct.BaseAction;

 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
 
 public class FrontFirstGoodAction extends BaseAction
 {
   private static final Logger logger = Logger.getLogger(FrontFirstGoodAction.class);
   private List<Advertise> advertiseList;
   private AdvertiseService advertiseService;
   private List<Information> informationList;
   private InformationService informationService;
   private List<GoodType> goodTypeList;
   private GoodTypeService goodTypeService;
   private GoodType goodtype;
   private Good good;
   private List<Good> goodList1;
   private List<Good> goodList2;
   private List<Good> goodList3;
   private List<Good> goodList4;
   private GoodService goodService;
   private WareCommentService wareCommentService;
   private GoodExtendService goodExtendService;
   private Area area;
   private List<Area> areaList;
   private AreaService areaService;
 
   public String getFirstLevel()
     throws Exception
   {
     HttpServletRequest request = getRequest();
 
     if (this.goodtype == null) {
       this.goodtype = new GoodType();
     }
     String areasId = (String)request.getSession().getAttribute("areasId");
     String searchtype = "";
     String typeId = "";
     if (this.goodtype.getId() != null) {
       searchtype = this.goodtype.getSearchType();
       typeId = this.goodtype.getId();
       this.goodtype = ((GoodType)this.goodTypeService.getModel(this.goodtype.getId()));
       GoodType g = new GoodType();
       g.setParentId(this.goodtype.getId());
       g.setLevel(Integer.valueOf(2));
       this.goodTypeList = this.goodTypeService.queryTypeTree(g);
 
       this.good = new Good();
       this.good.setFzproperty("2");
       this.good.setIsInventory("0");
       this.good.setParentId(typeId);
 
       this.good.setSortVal("createTime");
 
       this.goodList1 = this.goodService.select("Good.Good_SYfuleipindao", this.good);
 
       this.good = new Good();
       this.good.setFzproperty("4");
       this.good.setIsInventory("0");
       this.good.setParentId(typeId);
 
       this.good.setSortVal("sort");
 
       this.goodList2 = this.goodService.select("Good.Good_SYfuleipindao", this.good);
 
       this.good = new Good();
       this.good.setFzproperty("5");
       this.good.setIsInventory("0");
       this.good.setParentId(typeId);
 
       this.good.setSortVal("createTime");
 
       this.goodList3 = this.goodService.select("Good.Good_SYfuleipindao", this.good);
     }
 
     Advertise advertise = new Advertise();
     advertise.setIsGoodTypeId(typeId);
 
     this.advertiseList = this.advertiseService.getByPlaceAdvertiseList(advertise);
     this.informationList = this.informationService.select(new Information());
 
     return "first";
   }
 
   public WareCommentService getWareCommentService()
   {
     return this.wareCommentService;
   }
 
   public void setWareCommentService(WareCommentService wareCommentService) {
     this.wareCommentService = wareCommentService;
   }
 
   public GoodService getGoodService() {
     return this.goodService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public List<Advertise> getAdvertiseList() {
     return this.advertiseList;
   }
 
   public void setAdvertiseList(List<Advertise> advertiseList) {
     this.advertiseList = advertiseList;
   }
 
   public AdvertiseService getAdvertiseService() {
     return this.advertiseService;
   }
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 
   public List<Information> getInformationList() {
     return this.informationList;
   }
 
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
 
   public InformationService getInformationService() {
     return this.informationService;
   }
 
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
   public GoodType getGoodtype() {
     return this.goodtype;
   }
 
   public void setGoodtype(GoodType goodtype) {
     this.goodtype = goodtype;
   }
 
   public List<GoodType> getGoodTypeList() {
     return this.goodTypeList;
   }
 
   public void setGoodTypeList(List<GoodType> goodTypeList) {
     this.goodTypeList = goodTypeList;
   }
 
   public GoodTypeService getGoodTypeService() {
     return this.goodTypeService;
   }
 
   public void setGoodTypeService(GoodTypeService goodTypeService) {
     this.goodTypeService = goodTypeService;
   }
 
   public List<Good> getGoodList1() {
     return this.goodList1;
   }
 
   public void setGoodList1(List<Good> goodList1) {
     this.goodList1 = goodList1;
   }
 
   public List<Good> getGoodList2() {
     return this.goodList2;
   }
 
   public void setGoodList2(List<Good> goodList2) {
     this.goodList2 = goodList2;
   }
 
   public Good getGood() {
     return this.good;
   }
 
   public void setGood(Good good) {
     this.good = good;
   }
 
   public List<Good> getGoodList3()
   {
     return this.goodList3;
   }
 
   public void setGoodList3(List<Good> goodList3)
   {
     this.goodList3 = goodList3;
   }
 
   public List<Good> getGoodList4()
   {
     return this.goodList4;
   }
 
   public void setGoodList4(List<Good> goodList4)
   {
     this.goodList4 = goodList4;
   }
 
   public GoodExtendService getGoodExtendService() {
     return this.goodExtendService;
   }
   public void setGoodExtendService(GoodExtendService goodExtendService) {
     this.goodExtendService = goodExtendService;
   }
   public Area getArea() {
     return this.area;
   }
 
   public void setArea(Area area)
   {
     this.area = area;
   }
 
   public List<Area> getAreaList()
   {
     return this.areaList;
   }
 
   public void setAreaList(List<Area> areaList)
   {
     this.areaList = areaList;
   }
 
   public AreaService getAreaService()
   {
     return this.areaService;
   }
 
   public void setAreaService(AreaService areaService)
   {
     this.areaService = areaService;
   }
 }