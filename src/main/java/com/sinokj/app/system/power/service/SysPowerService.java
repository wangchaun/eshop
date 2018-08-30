 package com.sinokj.app.system.power.service;
 
 import com.sinokj.app.system.power.model.SysPower;
import com.sinokj.app.system.rolePower.service.SysRolePowerService;
import com.sinokj.code.service.BaseService;

 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysPowerService extends BaseService<SysPower>
 {
   private static final Logger logger = Logger.getLogger(SysPowerService.class);
   private SysRolePowerService sysRolePowerService;
 
   public void setSysRolePowerService(SysRolePowerService sysRolePowerService)
   {
     this.sysRolePowerService = sysRolePowerService;
   }
 
   public void delete(String id)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       logger.warn("sysRoleId isBlank!can not delete!");
       throw new Exception("sysRoleId isBlank!can not delete!");
     }
 
     this.sysRolePowerService.deleteByPowerId(id);
 
     super.delete(id);
   }
 }

/* 
 
 
 */