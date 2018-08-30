 package com.sinokj.app.system.user.service;
 
 import com.sinokj.app.system.power.model.SysPower;
import com.sinokj.app.system.power.service.SysPowerService;
import com.sinokj.app.system.user.entity.SysUserPower;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysUserPowerService extends BaseService<SysUserPower>
 {
   private static final Logger logger = Logger.getLogger(SysUserPowerService.class);
   private SysUserService sysUserService;
   private SysPowerService sysPowerService;
 
   public void setSysUserService(SysUserService sysUserService)
   {
     this.sysUserService = sysUserService;
   }
 
   public void setSysPowerService(SysPowerService sysPowerService) {
     this.sysPowerService = sysPowerService;
   }
 
   public List<SysUserPower> getSysUserPowerList(String userId)
   {
     List list = null;
 
     SysUser sysUser = (SysUser)this.sysUserService.getModel(userId);
     String roleCode = sysUser.getRoleCode();
 
     if ("admin".equals(roleCode)) {
       List<SysPower> sysPowerList = this.sysPowerService.select(null);
       if ((sysPowerList != null) && (!sysPowerList.isEmpty())) {
         list = new ArrayList();
         for (SysPower sysPower : sysPowerList) {
           String powerCode = sysPower.getCode();
           String powerName = sysPower.getName();
 
           SysUserPower sysUserPower = new SysUserPower();
           sysUserPower.setPowerCode(powerCode);
           sysUserPower.setPowerName(powerName);
           list.add(sysUserPower);
         }
       }
     } else {
       Map objParam = new HashMap();
       objParam.put("userId", userId);
       list = super.select(objParam);
     }
     return list;
   }
 
   public Map<String, SysUserPower> getPowerMap(String userId)
   {
     Map powerMap = new HashMap();
 
     List<SysUserPower> list = getSysUserPowerList(userId);
     if ((list != null) && (!list.isEmpty())) {
       for (SysUserPower o : list) {
         String powerCode = o.getPowerCode();
         powerMap.put(powerCode, o);
       }
     }
     return powerMap;
   }
 
   public Map<String, String> getAllPower(String userId)
     throws Exception
   {
     Map maplist = new HashMap();
     if (StringUtils.isBlank(userId)) {
       throw new Exception("goodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("userId", userId);
     List<SysUserPower> list = this.publicDAO.select("SysUserPower.SysUserPower", param);
     if ((list != null) && (!list.isEmpty()))
     {
       for (SysUserPower o : list)
       {
         String powerCode = o.getPowerCode();
         String inserts = o.getInserts();
         String deletes = o.getDeletes();
         String selects = o.getSelects();
         String updates = o.getUpdates();
         maplist.put("inserts_" + powerCode, inserts);
         maplist.put("deletes_" + powerCode, deletes);
         maplist.put("selects_" + powerCode, selects);
         maplist.put("updates_" + powerCode, updates);
       }
     }
     return maplist;
   }
 }