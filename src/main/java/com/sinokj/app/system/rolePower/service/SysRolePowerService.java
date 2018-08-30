 package com.sinokj.app.system.rolePower.service;
 
 import com.sinokj.app.system.rolePower.model.SysRolePower;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SysRolePowerService extends BaseService<SysRolePower>
 {
   private static final Logger logger = Logger.getLogger(SysRolePowerService.class);
 
   public List<SysRolePower> list(String roleId)
   {
     List list = null;
     Map map = new HashMap();
     map.put("roleId", roleId);
     list = this.publicDAO.select("SysRolePower.SysRolePower_full", map);
     return list;
   }
 
   public void insert(List<SysRolePower> entityList)
     throws Exception
   {
     if ((entityList != null) && (!entityList.isEmpty()))
       for (SysRolePower entity : entityList)
         super.insert(entity);
   }
 
   public void delete(String roleId)
     throws Exception
   {
     if (StringUtils.isBlank(roleId)) {
       logger.warn("sysRoleId isBlank!can not delete!");
       throw new Exception("sysRoleId isBlank!can not delete!");
     }
     Map objParam = new HashMap();
     objParam.put("roleId", roleId);
     this.publicDAO.delete("SysRolePower.SysRolePower_byRoleId", objParam);
   }
 
   public void deleteByPowerId(String powerId)
     throws Exception
   {
     if (StringUtils.isBlank(powerId)) {
       logger.warn("powerId isBlank!can not delete!");
       throw new Exception("powerId isBlank!can not delete!");
     }
     Map objParam = new HashMap();
     objParam.put("powerId", powerId);
     this.publicDAO.delete("SysRolePower.SysRolePower_byPowerId", objParam);
   }
 
   public SysRolePower selectOne(SysRolePower entity)
     throws Exception
   {
     SysRolePower result = null;
     if ((entity == null) || (StringUtils.isBlank(entity.getId()))) {
       throw new Exception("primary key is null!can not delete!");
     }
     Map map = new HashMap();
     map.put("roleId", entity.getRoleId());
     map.put("userId", entity.getPowerId());
     Object objTemp = this.publicDAO.selectOne("SysRolePower.SysRolePower", map);
     if (objTemp != null) {
       result = (SysRolePower)objTemp;
     }
     return result;
   }
 }

/* 
 
 
 */