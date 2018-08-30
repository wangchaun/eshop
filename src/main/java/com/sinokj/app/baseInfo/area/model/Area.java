 package com.sinokj.app.baseInfo.area.model;
 
 import com.sinokj.code.bean.Base;

import java.util.List;
 
 public class Area extends Base
 {
   private static final long serialVersionUID = -7200521962194994802L;
   private int level;
   private List<Area> areaList;
 
   public int getLevel()
   {
     return this.level;
   }
   public void setLevel(int level) {
     this.level = level;
   }
   public List<Area> getAreaList() {
     return this.areaList;
   }
   public void setAreaList(List<Area> areaList) {
     this.areaList = areaList;
   }
 }