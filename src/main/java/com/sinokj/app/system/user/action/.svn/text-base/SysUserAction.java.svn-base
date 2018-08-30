 package com.sinokj.app.system.user.action;
 
 import com.sinokj.app.system.dept.model.SysDept;
import com.sinokj.app.system.dept.service.SysDeptService;
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
 
 public class SysUserAction extends BaseAction
 {
   private static final long serialVersionUID = 4245082865703309552L;
   private static final Logger logger = Logger.getLogger(SysUserAction.class);
   private SysUserService sysUserService;
   private SysRoleService sysRoleService;
   private SysDeptService sysDeptService;
   private SysUser sysUser;
   private List<SysRole> sysRoleList;
   private List<SysDept> sysDeptlist;
 
   public void setSysUserService(SysUserService sysUserService)
   {
     this.sysUserService = sysUserService;
   }
 
   public void setSysRoleService(SysRoleService sysRoleService)
   {
     this.sysRoleService = sysRoleService;
   }
 
   public String listJson()
   {
     logger.info("start list all data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
 
       resultList = this.sysUserService.pageList(pageInfo, this.sysUser, true);
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
 
   public String list()
   {
     return "list_SysUser";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
 
     if (this.sysUser == null) {
       this.sysUser = new SysUser();
     }
     String id = this.sysUser.getId();
     if (StringUtils.isBlank(id)) {
       super.initModel(true, this.sysUser, loginMan);
     } else {
       this.sysUser = ((SysUser)this.sysUserService.getModel(id));
 
       super.initModel(false, this.sysUser, loginMan);
     }
 
     this.sysRoleList = this.sysRoleService.select(null);
     this.sysDeptlist = this.sysDeptService.select(null);
     if (this.sysDeptlist == null)
     {
       this.sysDeptlist = new ArrayList();
     }
     else {
       for (int i = 0; i < this.sysDeptlist.size(); i++) {
         if ("admin".equals(((SysDept)this.sysDeptlist.get(i)).getCode())) {
           this.sysDeptlist.remove(i);
           break;
         }
       }
     }
     if (this.sysRoleList == null)
       this.sysRoleList = new ArrayList();
     else {
       for (int i = 0; i < this.sysRoleList.size(); i++) {
         if ("admin".equals(((SysRole)this.sysRoleList.get(i)).getCode())) {
           this.sysRoleList.remove(i);
           break;
         }
       }
     }
 
     return "edit_SysUser";
   }
 
   public String editPassword()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.sysUser == null) {
       this.sysUser = new SysUser();
     }
     this.sysUser = ((SysUser)this.sysUserService.getModel(loginMan.getId()));
     super.initModel(false, this.sysUser, loginMan);
     return "edit_password";
   }
 
   public void save()
   {
     try
     {
       String id = this.sysUser.getId();
 
       String roleId = this.sysUser.getRoleId();
       String deptId = this.sysUser.getDeptId();
       if (StringUtils.isNotBlank(roleId)) {
         SysRole sysRole = (SysRole)this.sysRoleService.getModel(roleId);
         this.sysUser.setRoleCode(sysRole.getCode());
         this.sysUser.setRoleName(sysRole.getName());
       }
       if (StringUtils.isNotBlank(deptId))
       {
         SysDept sysDept = (SysDept)this.sysDeptService.getModel(deptId);
         this.sysUser.setDeptName(sysDept.getName());
       }
       if (StringUtils.isBlank(id))
         this.sysUserService.insert(this.sysUser);
       else {
         this.sysUserService.update(this.sysUser);
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
 
     String id = this.sysUser.getId();
     logger.info("delete user,id:" + id);
     try
     {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.sysUserService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete user,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete user,id:" + id, e);
     }
   }
 
   public void isCodeExisted()
   {
     boolean isCodeExisted = true;
 
     String id = this.sysUser.getId();
     String code = this.sysUser.getCode();
     logger.info("check isCodeExisted,code:" + code + ";id:" + id);
     try {
       SysUser sysUserResult = this.sysUserService.getSysUser(this.sysUser);
       if (sysUserResult == null) {
         isCodeExisted = false;
       }
       else if (StringUtils.isNotEmpty(id)) {
         isCodeExisted = !id.equals(sysUserResult.getId());
       }
 
       logger.info("check isCodeExisted result:" + isCodeExisted);
       responseFlag(isCodeExisted);
     } catch (Exception e) {
       logger.error("error occur when check isCodeExisted!", e);
     }
   }
 
   public void modifyPassword()
   {
     String id = this.sysUser.getId();
     String pwd = this.sysUser.getNewPwd();
     logger.info("modifyPassword,id:" + id + ";pwd:" + pwd);
     try {
       this.sysUserService.updatePassword(id, pwd);
       logger.info("modifyPassword success");
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when modifyPassword!id:" + id, e);
     }
   }
 
   public void isPwdRightInput()
   {
     String id = this.sysUser.getId();
     String pwd = this.sysUser.getPwd();
     logger.info("check password whether it is right input");
     try {
       if (StringUtils.isNotBlank(id)) {
         this.sysUser = ((SysUser)this.sysUserService.getModel(id));
         if (pwd.equals(this.sysUser.getPwd()))
           responseFlag(true);
         else
           responseFlag(false);
       }
       else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.error("error occur when check password is right input!", e);
       e.printStackTrace();
     }
   }
 
   public SysUser getSysUser() {
     return this.sysUser;
   }
 
   public void setSysUser(SysUser sysUser) {
     this.sysUser = sysUser;
   }
 
   public List<SysRole> getSysRoleList() {
     return this.sysRoleList;
   }
 
   public void setSysRoleList(List<SysRole> sysRoleList) {
     this.sysRoleList = sysRoleList;
   }
 
   public List<SysDept> getSysDeptlist() {
     return this.sysDeptlist;
   }
 
   public void setSysDeptlist(List<SysDept> sysDeptlist) {
     this.sysDeptlist = sysDeptlist;
   }
 
   public void setSysDeptService(SysDeptService sysDeptService) {
     this.sysDeptService = sysDeptService;
   }
 }

/* 
 
 
 */