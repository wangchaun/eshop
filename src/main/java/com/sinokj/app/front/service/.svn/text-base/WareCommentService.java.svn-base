 package com.sinokj.app.front.service;
 
 import com.sinokj.app.front.model.WareComment;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WareCommentService extends BaseService<WareComment>
 {
   public List<WareComment> getCommentByWareId(String wareId)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     List list = this.publicDAO.select("WareComment.WareComment", param);
     return list;
   }
 
   public Integer count(String commentId)
     throws Exception
   {
     if (StringUtils.isBlank(commentId)) {
       throw new Exception("commentId is null");
     }
     Map param = new HashMap();
     param.put("commentId", commentId);
     Integer num = (Integer)this.publicDAO.selectOne("WareComment.WareComment_count_query", param);
     if ((num == null) || (num.intValue() < 0)) {
       num = Integer.valueOf(0);
     }
     return num;
   }
 
   public List<WareComment> getCountComment(String wareId, String type)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     if (!StringUtils.isBlank(type)) {
       param.put("type", type);
     }
     List list = this.publicDAO.select("WareComment.WareComment", param);
     return list;
   }
   public List<WareComment> getRevovery(String commentId) throws Exception {
     if (StringUtils.isBlank(commentId)) {
       throw new Exception("commentId is null");
     }
     Map param = new HashMap();
     param.put("commentId", commentId);
     List list = this.publicDAO.select("WareComment.WareComment", param);
     return list;
   }
 
   public List<WareComment> getWareCommentSum(WareComment wareComment)
   {
     List list = this.publicDAO.select("WareComment.WareComment", wareComment);
     return list;
   }
 
   public WareComment getWareCommentByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("commentId is null");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     WareComment wareComment = (WareComment)this.publicDAO.selectOne("WareComment.WareComment_remen", param);
     return wareComment;
   }
 }