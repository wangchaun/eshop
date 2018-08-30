 package com.sinokj.app.system.user.service;
 
 import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysUserService extends BaseService<SysUser>
 {
   private static final Logger logger = Logger.getLogger(SysUserService.class);
 
   public boolean isSystemUser(String code, String pwd)
     throws Exception
   {
     if (StringUtils.isBlank(code)) {
       throw new Exception("code is null!");
     }
     if (StringUtils.isBlank(pwd)) {
       throw new Exception("pwd is null!");
     }
 
     Map objParam = new HashMap();
     objParam.put("code", code);
     objParam.put("pwd", pwd);
 
     List userList = this.publicDAO.select("SysUser.SysUser", objParam);
     if ((userList == null) || (userList.isEmpty())) {
       return false;
     }
     SysUser sysUser = (SysUser)userList.get(0);
     logger.info("pwd from input:" + pwd);
     logger.info("pwd from db:" + sysUser.getPwd());
     return pwd.equals(sysUser.getPwd());
   }
 
   public SysUser getSysUser(SysUser model)
   {
     SysUser sysUser = null;
     Object obj = this.publicDAO.selectOne("SysUser.SysUser", model);
     if (obj != null) {
       sysUser = (SysUser)obj;
     }
     return sysUser;
   }
 
   public List<SysUser> getsysuerList(String roleId)
     throws Exception
   {
     if (StringUtils.isBlank(roleId))
     {
       throw new Exception("goodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("roleId", roleId);
     List list = this.publicDAO.select("SysUser.SysUser", param);
     return list;
   }
 
   public SysUser insert(SysUser model)
     throws Exception
   {
     super.insert(model);
     return model;
   }
 
   public SysUser update(SysUser model)
     throws Exception
   {
     if (model == null) {
       throw new Exception("form is null!");
     }
     if (StringUtils.isBlank(model.getId())) {
       throw new Exception("id is null!");
     }
     super.update(model);
     return model;
   }
 
   public void updatePassword(String id, String pwd)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("id is null!");
     }
     if (StringUtils.isBlank(pwd)) {
       throw new Exception("id is null!");
     }
 
     Map objParam = new HashMap();
     objParam.put("id", id);
     objParam.put("pwd", pwd);
     this.publicDAO.update("SysUser.SysUser_pwd", objParam);
   }
 }

/* 
 
 
 */