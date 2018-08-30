 package com.sinokj.app.front.action;
 
 import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.action.InformationAction;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
 
 public class InforAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(InformationAction.class);
   private InformationService informationService;
   private Information information;
   private List<Information> informationList;
   private List<Information> inforAllList;
   private List<Good> goodList;
   private GoodService goodService;
   private AdvertiseService advertiseService;
   private List<Advertise> advertiseList;
   private AreaService areaService;
   private List<Area> areaList;
 
   public String listInfor()
   {
     if (this.information == null) {
       this.information = new Information();
     }
     String type = this.information.getType();
     this.informationList = this.informationService.select(new Information());
     return "listInfor";
   }
 
   public String listNews()
   {
     if (this.information == null) {
       this.information = new Information();
     }
     String type = this.information.getType();
     this.goodList = this.goodService.select(new Good());
     this.informationList = this.informationService.select(new Information());
     return "listNews";
   }
 
   public String newnews()
   {
     HttpServletRequest request = getRequest();
     String pageIndex = request.getParameter("page");
     int pageSize = 10;
     PageInfo pageInfo = createPageInfo();
     pageInfo.setPageSize(pageSize);
     if (pageIndex == null)
       pageInfo.setPageIndex(1);
     else {
       pageInfo.setPageIndex(Integer.parseInt(pageIndex));
     }
     this.goodList = this.goodService.select(new Good());
 
     this.advertiseList = this.advertiseService.getAdvertiseList();
     Information inf = new Information();
     inf.setType("0");
     this.inforAllList = this.informationService.pageList(pageInfo, inf, true);
 
     if ((pageInfo.getCount() > 0) && (pageInfo.getCount() % pageSize != 0))
       pageInfo.setPageCount(pageInfo.getCount() / pageSize + 1);
     else {
       pageInfo.setPageCount(pageInfo.getCount() / pageSize);
     }
     request.setAttribute("pageInfo", pageInfo);
 
     this.informationList = this.informationService.select(new Information());
     return "newnews";
   }
 
   public String getNewsdetail()
   {
     if (this.information == null) {
       this.information = new Information();
     }
     this.information = ((Information)this.informationService.selectOne(this.information));
     Information infor = new Information();
     infor.setType(this.information.getType());
     this.inforAllList = this.informationService.select(infor);
     for (int i = 0; i < this.inforAllList.size(); i++) {
       if (this.information.getId().equals(((Information)this.inforAllList.get(i)).getId())) {
         this.inforAllList.remove(i);
       }
 
     }
 
     this.informationList = this.informationService.select(new Information());
     this.advertiseList = this.advertiseService.getAdvertiseList();
 
     return "news_detail";
   }
 
   public String listAllNews()
   {
     HttpServletRequest request = getRequest();
     String pageIndex = request.getParameter("page");
     int pageSize = 10;
     PageInfo pageInfo = createPageInfo();
     pageInfo.setPageSize(pageSize);
     this.goodList = this.goodService.select(new Good());
     if (pageIndex == null)
       pageInfo.setPageIndex(1);
     else
       pageInfo.setPageIndex(Integer.parseInt(pageIndex));
     try
     {
       if (this.information == null) {
         this.information = new Information();
       }
       this.informationList = this.informationService.select(new Information());
 
       this.information.setEcommunity("1");
       this.inforAllList = this.informationService.pageList(pageInfo, this.information, true);
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     if ((pageInfo.getCount() > 0) && (pageInfo.getCount() % pageSize != 0))
       pageInfo.setPageCount(pageInfo.getCount() / pageSize + 1);
     else {
       pageInfo.setPageCount(pageInfo.getCount() / pageSize);
     }
     request.setAttribute("pageInfo", pageInfo);
     return "listAllNews";
   }
 
   public InformationService getInformationService() {
     return this.informationService;
   }
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
   public Information getInformation() {
     return this.information;
   }
   public void setInformation(Information information) {
     this.information = information;
   }
   public List<Information> getInformationList() {
     return this.informationList;
   }
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
   public List<Information> getInforAllList() {
     return this.inforAllList;
   }
   public void setInforAllList(List<Information> inforAllList) {
     this.inforAllList = inforAllList;
   }
 
   public List<Good> getGoodList() {
     return this.goodList;
   }
 
   public void setGoodList(List<Good> goodList) {
     this.goodList = goodList;
   }
 
   public GoodService getGoodService() {
     return this.goodService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 
   public List<Advertise> getAdvertiseList() {
     return this.advertiseList;
   }
 
   public void setAdvertiseList(List<Advertise> advertiseList) {
     this.advertiseList = advertiseList;
   }
 
   public List<Area> getAreaList() {
     return this.areaList;
   }
 
   public void setAreaList(List<Area> areaList) {
     this.areaList = areaList;
   }
 
   public void setAreaService(AreaService areaService) {
     this.areaService = areaService;
   }
 }