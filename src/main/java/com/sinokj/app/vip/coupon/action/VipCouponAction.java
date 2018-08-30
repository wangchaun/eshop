 package com.sinokj.app.vip.coupon.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.coupon.model.VipCoupon;
import com.sinokj.app.vip.coupon.model.VipCouponWare;
import com.sinokj.app.vip.coupon.service.VipCouponService;
import com.sinokj.app.vip.coupon.service.VipCouponWareService;
import com.sinokj.app.vip.level.model.VipLevel;
import com.sinokj.app.vip.level.service.VipLevelService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class VipCouponAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(VipCouponAction.class);
   private VipCoupon vipCoupon;
   private VipCouponService vipCouponService;
   private List<VipCoupon> vipCouponList;
   private VipCouponWare vipCouponWare;
   private VipCouponWareService vipCouponWareService;
   private SerialNumberService serialNumberService;
   private VipLevelService vipLevelService;
   private List<VipLevel> vipLevelList;
   private String[] wareIdArr;
   private String[] wareNameArr;
 
   public String list()
   {
     return "list_vipCoupon";
   }
 
   public String listJosn()
   {
     logger.info("start list vipCoupon");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.vipCoupon == null) {
         this.vipCoupon = new VipCoupon();
       }
       resultList = this.vipCouponService.pageList(pageInfo, this.vipCoupon, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list vipCoupon", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.vipCoupon == null) {
       this.vipCoupon = new VipCoupon();
     }
     try
     {
       if (StringUtils.isBlank(this.vipCoupon.getId())) {
         this.vipCoupon.setState("d");
         initModel(true, this.vipCoupon, loginMan);
       }
       else
       {
         this.vipCoupon = ((VipCoupon)this.vipCouponService.getModel(this.vipCoupon.getId()));
         initModel(false, this.vipCoupon, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list vipCoupon", e);
       responseFlag(false);
     }
 
     this.vipLevelList = this.vipLevelService.select(new VipLevel());
     return "edit_vipCoupon";
   }
 
   public void save()
   {
     logger.info("start to update vipCoupon information");
     if (this.vipCoupon == null) {
       this.vipCoupon = new VipCoupon();
     }
     try
     {
       VipLevel vipLevel = (VipLevel)this.vipLevelService.getModel(this.vipCoupon.getVipLevelId());
       if (vipLevel != null) {
         this.vipCoupon.setVipLevelId(vipLevel.getId());
         this.vipCoupon.setVipLevelName(vipLevel.getName());
       }
 
       if (StringUtils.isBlank(this.vipCoupon.getId())) {
         this.vipCoupon.setState("c");
         int number = this.vipCoupon.getCount();
         if (number > 0)
           for (int i = 0; i < number; i++) {
             this.vipCoupon.setCode(this.serialNumberService.getSerialNumberByDate("YHJ", "vipCoupon"));
             this.vipCoupon.setId(this.vipCouponService.makeId());
             this.vipCoupon.setCount(1);
             this.vipCouponService.insert(this.vipCoupon);
           }
       }
       else {
         this.vipCouponService.update(this.vipCoupon);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save vipCoupon information");
       e.printStackTrace();
       responseFlag(false);
     }
 
     try
     {
       this.vipCouponWareService.deleteByIntoId(this.vipCoupon.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete vipCoupon", e);
     }
 
     String vipCouponId = this.vipCoupon.getId();
     String vipCouponName = this.vipCoupon.getName();
     if ((this.wareIdArr != null) && (this.wareIdArr.length != 0))
       for (int i = 0; i < this.wareIdArr.length; i++) {
         VipCouponWare vipCouponWare = new VipCouponWare();
         vipCouponWare.setVipCouponId(vipCouponId);
         vipCouponWare.setVipCouponName(vipCouponName);
         vipCouponWare.setWareId(this.wareIdArr[i]);
         vipCouponWare.setWareName(this.wareNameArr[i]);
         vipCouponWare.setSort(Integer.valueOf(i));
         try {
           this.vipCouponWareService.insert(vipCouponWare);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert a cashItem", e);
         }
       }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.vipCoupon == null) {
         this.vipCoupon = new VipCoupon();
       }
       this.vipCoupon = ((VipCoupon)this.vipCouponService.getModel(this.vipCoupon.getId()));
       this.vipCouponService.delete(this.vipCoupon.getId());
       String code = this.vipCoupon.getCode();
       this.vipCouponList = this.vipCouponService.getListCode(code);
       if (this.vipCouponList.size() < 1) {
         this.vipCouponWareService.deleteByIntoId(code);
       }
       logger.info(loginMan.getCode() + " delete vipCoupon,id:" + this.vipCoupon.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a  vipCoupon", e);
     }
   }
 
   public VipCoupon getVipCoupon() {
     return this.vipCoupon;
   }
   public void setVipCoupon(VipCoupon vipCoupon) {
     this.vipCoupon = vipCoupon;
   }
   public VipCouponWare getVipCouponWare() {
     return this.vipCouponWare;
   }
   public void setVipCouponWare(VipCouponWare vipCouponWare) {
     this.vipCouponWare = vipCouponWare;
   }
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
   public void setVipCouponService(VipCouponService vipCouponService) {
     this.vipCouponService = vipCouponService;
   }
   public void setVipCouponWareService(VipCouponWareService vipCouponWareService) {
     this.vipCouponWareService = vipCouponWareService;
   }
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
   public List<VipCoupon> getVipCouponList() {
     return this.vipCouponList;
   }
   public void setVipCouponList(List<VipCoupon> vipCouponList) {
     this.vipCouponList = vipCouponList;
   }
   public void setVipLevelService(VipLevelService vipLevelService) {
     this.vipLevelService = vipLevelService;
   }
   public List<VipLevel> getVipLevelList() {
     return this.vipLevelList;
   }
   public void setVipLevelList(List<VipLevel> vipLevelList) {
     this.vipLevelList = vipLevelList;
   }
 }

/* 
 
 
 */