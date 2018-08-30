 package com.sinokj.app.baseInfo.area.service;
 
 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.code.service.BaseService;
 
 public class AreaService extends BaseService<Area>
 {
   public Integer count()
   {
     Integer num = (Integer)this.publicDAO.selectOne("Area.Area_count_query", null);
     if ((num == null) || (num.intValue() < 0)) {
       num = Integer.valueOf(0);
     }
     return num;
   }
 
   public Area checkUniqueArea(Area area)
   {
     Area result = null;
     Object obj = this.publicDAO.selectOne("Area.Area", area);
     if (obj != null) {
       result = (Area)obj;
     }
     return result;
   }
 
   public Area checkUniqueAreaByName(String name)
   {
     return (Area)this.publicDAO.selectOne("Area.Area_selByName", name);
   }
 
   public void delete(Area area)
     throws Exception
   {
     if ((area == null) || (StringUtils.isBlank(area.getId()))) {
       throw new Exception("the primary key is null, can not delete area information");
     }
     if (area.getLevel() == 1)
     {
       Map map = new HashMap();
       map.put("parentId", area.getId());
       List list = super.select(map);
       for (int i = 0; i < list.size(); i++)
       {
         map.clear();
         map.put("parentId", ((Area)list.get(i)).getId());
         this.publicDAO.delete("Area.Area", map);
       }
 
       for (int i = 0; i < list.size(); i++) {
         map.clear();
         map.put("id", ((Area)list.get(i)).getId());
         this.publicDAO.delete("Area.Area", map);
       }
     } else if (area.getLevel() == 2) {
       Map map = new HashMap();
       map.put("parentId", area.getId());
 
       this.publicDAO.delete("Area.Area", map);
     }
     this.publicDAO.delete("Area.Area", area);
   }
 }