 package com.sinokj.app.good.favorite.service;
 
 import com.sinokj.app.good.favorite.model.Favorite;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
import java.util.Map;
 
 public class FavoriteService extends BaseService<Favorite>
 {
   public List<Favorite> selectByCreatorId(Favorite favorite)
     throws Exception
   {
     if (favorite == null) {
       throw new Exception("favorite is null!");
     }
     Map param = new HashMap();
     param.put("creatorId", favorite.getCreatorId());
     List list = this.publicDAO.select("Favorite.Favorite", param);
     return list;
   }
 }