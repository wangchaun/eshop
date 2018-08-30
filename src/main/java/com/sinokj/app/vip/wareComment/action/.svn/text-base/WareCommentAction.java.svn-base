 package com.sinokj.app.vip.wareComment.action;
 
 import com.sinokj.app.front.model.WareComment;
import com.sinokj.app.front.service.WareCommentService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class WareCommentAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WareCommentAction.class);
   private WareComment wareComment;
   private WareCommentService wareCommentService;
   private List<WareComment> wareCommentList;
   private GoodService goodService;
 
   public String list()
   {
     if ((this.wareComment != null) && (StringUtils.isNotBlank(this.wareComment.getState()))) {
       String state = this.wareComment.getState();
       getRequest().setAttribute("state", state);
     }
     return "list_wareComment";
   }
 
   public String listJosn()
   {
     logger.info("start list wareComment");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.wareComment == null) {
         this.wareComment = new WareComment();
       }
       resultList = this.wareCommentService.pageList(pageInfo, this.wareComment, true);
       totalRows = pageInfo.getCount();
 
       for (int i = 0; i < resultList.size(); i++) {
         Good good = new Good();
         good.setId(((WareComment)resultList.get(i)).getWareId());
         good = (Good)this.goodService.selectOne(good);
         if (good != null) {
           ((WareComment)resultList.get(i)).setGoodCode(good.getCode());
           ((WareComment)resultList.get(i)).setGoodName(good.getName());
         }
       }
     } catch (Exception e) {
       logger.error("error occur when list wareComment", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String showWareComment()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       String id = this.wareComment.getId();
       this.wareComment = ((WareComment)this.wareCommentService.getModel(id));
       Good good = new Good();
       good = (Good)this.goodService.getModel(this.wareComment.getWareId());
       this.wareComment.setGoodCode(good.getCode());
       this.wareComment.setGoodName(good.getName());
 
       this.wareCommentList = this.wareCommentService.getRevovery(this.wareComment.getId());
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
     return "show_wareComment";
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.wareComment == null) {
         this.wareComment = new WareComment();
       }
 
       this.wareCommentService.delete(this.wareComment.getId());
       logger.info(loginMan.getCode() + " delete wareComment,id:" + this.wareComment.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale wareComment", e);
     }
   }
 
   public void save()
   {
     logger.info("start to update Customer information");
     try {
       if (this.wareComment == null) {
         this.wareComment = new WareComment();
       }
 
       if (StringUtils.isBlank(this.wareComment.getId()))
       {
         this.wareCommentService.insert(this.wareComment);
       }
       else this.wareCommentService.update(this.wareComment);
 
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save Customer information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save Customer information");
   }
 
   public WareComment getWareComment() {
     return this.wareComment;
   }
 
   public void setWareComment(WareComment wareComment)
   {
     this.wareComment = wareComment;
   }
 
   public WareCommentService getWareCommentService()
   {
     return this.wareCommentService;
   }
 
   public void setWareCommentService(WareCommentService wareCommentService)
   {
     this.wareCommentService = wareCommentService;
   }
 
   public List<WareComment> getWareCommentList()
   {
     return this.wareCommentList;
   }
 
   public void setWareCommentList(List<WareComment> wareCommentList)
   {
     this.wareCommentList = wareCommentList;
   }
 
   public void setGoodService(GoodService goodService)
   {
     this.goodService = goodService;
   }
 }

/* 
 
 
 */