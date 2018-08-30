 package com.sinokj.app.system.role.action;
 
 import com.sinokj.app.system.role.model.SysRole;
import com.sinokj.app.system.role.service.SysRoleService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.system.user.service.SysUserService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysRoleAction extends BaseAction
 {
   private static final long serialVersionUID = 5978189455813776425L;
   private static final Logger logger = Logger.getLogger(SysRoleAction.class);
   private SysRoleService sysRoleService;
   private SysUserService sysUserService;
   private SysRole sysRole;
   private List<SysRole> userRolelist;
 
   public void setSysRoleService(SysRoleService sysRoleService)
   {
     this.sysRoleService = sysRoleService;
   }
 
   public void setSysUserService(SysUserService sysUserService) {
     this.sysUserService = sysUserService;
   }
 
   public String listJson()
   {
     logger.info("start list all data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.sysRoleService.pageList(pageInfo, this.sysRole, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list data!", e);
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
 
   public String getSysRoleJson()
   {
     this.sysRole = ((SysRole)this.sysRoleService.selectOne(this.sysRole));
     this.jsonMap = new HashMap();
     this.jsonMap.put("data", this.sysRole);
     return "success";
   }
 
   public String list()
   {
     return "list_SysRole";
   }
 
   public String roleAnduserList()
   {
     try
     {
       this.userRolelist = this.sysRoleService.select(null);
       if (this.userRolelist != null)
       {
         for (int i = 0; i < this.userRolelist.size(); i++)
         {
           SysRole role = new SysRole();
           List userlist = new ArrayList();
           role = (SysRole)this.userRolelist.get(i);
           userlist = this.sysUserService.getsysuerList(role.getId());
           role.setUserlist(userlist);
         }
       }
     }
     catch (Exception e) {
       e.printStackTrace();
     }
     return "list_role_user";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
 
     if (this.sysRole == null) {
       this.sysRole = new SysRole();
     }
     String id = this.sysRole.getId();
     if (StringUtils.isBlank(id)) {
       super.initModel(true, this.sysRole, loginMan);
     } else {
       this.sysRole = ((SysRole)this.sysRoleService.getModel(id));
       super.initModel(false, this.sysRole, loginMan);
     }
     return "edit_SysRole";
   }
 
   public void save()
   {
     try
     {
       String id = this.sysRole.getId();
       if (StringUtils.isBlank(id))
         this.sysRoleService.insert(this.sysRole);
       else {
         this.sysRoleService.update(this.sysRole);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save model!", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
 
     String id = this.sysRole.getId();
     logger.info("delete role,id:" + id);
     try {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.sysRoleService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete role,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete role,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.sysRole.getId();
     String code = this.sysRole.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       SysRole sysRoleResult = (SysRole)this.sysRoleService.selectOne(this.sysRole);
       if (sysRoleResult == null) {
         isCodeExisted = false;
       }
       else if (StringUtils.isNotEmpty(id)) {
         isCodeExisted = !id.equals(sysRoleResult.getId());
       }
 
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public void getRoleCode()
   {
     try
     {
       if (this.sysRole == null) {
         this.sysRole = new SysRole();
       }
       if (StringUtils.isNotBlank(this.sysRole.getId())) {
         this.sysRole = ((SysRole)this.sysRoleService.getModel(this.sysRole.getId()));
         responseFlag(this.sysRole.getCode());
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public SysRole getSysRole() {
     return this.sysRole;
   }
 
   public void setSysRole(SysRole sysRole) {
     this.sysRole = sysRole;
   }
 
   public List<SysRole> getUserRolelist() {
     return this.userRolelist;
   }
 
   public void setUserRolelist(List<SysRole> userRolelist) {
     this.userRolelist = userRolelist;
   }
 
   public SysUserService getSysUserService() {
     return this.sysUserService;
   }
 }

/* 
 
 
 */