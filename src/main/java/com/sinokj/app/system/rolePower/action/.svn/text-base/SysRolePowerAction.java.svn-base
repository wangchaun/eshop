 package com.sinokj.app.system.rolePower.action;
 
 import com.sinokj.app.system.role.model.SysRole;
import com.sinokj.app.system.role.service.SysRoleService;
import com.sinokj.app.system.rolePower.model.SysRolePower;
import com.sinokj.app.system.rolePower.service.SysRolePowerService;
import com.sinokj.code.struct.BaseAction;

 import java.util.ArrayList;
 import java.util.List;
import org.apache.log4j.Logger;
 
 public class SysRolePowerAction extends BaseAction
 {
   private static final long serialVersionUID = 5473402799027982794L;
   private static final Logger logger = Logger.getLogger(SysRolePowerAction.class);
   private SysRolePowerService sysRolePowerService;
   private SysRoleService sysRoleService;
   private SysRole sysRole = new SysRole();
   private String[] powerIdArr;
   private String[] inserts;
   private String[] deletes;
   private String[] selects;
   private String[] updates;
   private List<SysRolePower> sysRolePowerList;
 
   public void setSysRolePowerService(SysRolePowerService sysRolePowerService)
   {
     this.sysRolePowerService = sysRolePowerService;
   }
 
   public void setSysRoleService(SysRoleService sysRoleService) {
     this.sysRoleService = sysRoleService;
   }
 
   public String edit()
   {
     try
     {
       this.sysRole = ((SysRole)this.sysRoleService.selectOne(this.sysRole));
       String roleId = this.sysRole.getId();
       this.sysRolePowerList = this.sysRolePowerService.list(roleId);
     } catch (Exception e) {
       logger.warn("error occur when get sysRolePowerList", e);
     }
     return "edit_SysRolePower";
   }
 
   public void save()
   {
     try
     {
       String roleId = this.sysRole.getId();
       String insert = "0";
       String delete = "0";
       String select = "0";
       String update = "0";
       this.sysRolePowerService.delete(roleId);
       if (this.powerIdArr != null) {
         List sysUserRoleList = new ArrayList();
         for (int i = 0; i < this.powerIdArr.length; i++) {
           String powerId = this.powerIdArr[i];
           if (this.inserts != null)
           {
             insert = this.inserts[i];
           }
           if (this.deletes != null)
           {
             delete = this.deletes[i];
           }
           if (this.selects != null)
           {
             select = this.selects[i];
           }
           if (this.updates != null)
           {
             update = this.updates[i];
           }
           SysRolePower o = new SysRolePower();
           o.setRoleId(roleId);
           o.setPowerId(powerId);
           if ("" != insert)
           {
             o.setInserts(insert);
           }
           if ("" != delete)
           {
             o.setDeletes(delete);
           }
           if ("" != select)
           {
             o.setSelects(select);
           }
           if ("" != update)
           {
             o.setUpdates(update);
           }
           o.setSort(Integer.valueOf(i));
 
           sysUserRoleList.add(o);
         }
         this.sysRolePowerService.insert(sysUserRoleList);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.error("error occur when save sysRolePower!", e);
     }
   }
 
   public SysRole getSysRole() {
     return this.sysRole;
   }
   public void setSysRole(SysRole sysRole) {
     this.sysRole = sysRole;
   }
   public String[] getPowerIdArr() {
     return this.powerIdArr;
   }
 
   public void setPowerIdArr(String[] powerIdArr) {
     this.powerIdArr = powerIdArr;
   }
 
   public List<SysRolePower> getSysRolePowerList() {
     return this.sysRolePowerList;
   }
 
   public void setSysRolePowerList(List<SysRolePower> sysRolePowerList) {
     this.sysRolePowerList = sysRolePowerList;
   }
 
   public String[] getInserts() {
     return this.inserts;
   }
 
   public void setInserts(String[] inserts) {
     this.inserts = inserts;
   }
 
   public String[] getDeletes() {
     return this.deletes;
   }
 
   public void setDeletes(String[] deletes) {
     this.deletes = deletes;
   }
 
   public String[] getSelects() {
     return this.selects;
   }
 
   public void setSelects(String[] selects) {
     this.selects = selects;
   }
 
   public String[] getUpdates() {
     return this.updates;
   }
 
   public void setUpdates(String[] updates) {
     this.updates = updates;
   }
 }

/* 
 
 
 */