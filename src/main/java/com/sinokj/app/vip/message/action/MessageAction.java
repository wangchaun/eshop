 package com.sinokj.app.vip.message.action;
 
 import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.message.model.Message;
import com.sinokj.app.vip.message.service.MessageService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class MessageAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(MessageAction.class);
   private Message message;
   private MessageService messageService;
   private List<Message> messageList;
   private GoodService goodService;
 
   public String list()
   {
     if ((this.message != null) && (StringUtils.isNotBlank(this.message.getState()))) {
       String state = this.message.getState();
       getRequest().setAttribute("state", state);
     }
     return "list_message";
   }
 
   public String revoveryList()
   {
     String messageId = this.message.getId();
     getRequest().setAttribute("messageId", messageId);
     return "list_revovery";
   }
 
   public String listJosn()
   {
     logger.info("start list message");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.message == null) {
         this.message = new Message();
       }
       resultList = this.messageService.pageList(pageInfo, this.message, true);
       totalRows = pageInfo.getCount();
 
       for (int i = 0; i < resultList.size(); i++) {
         Good good = new Good();
         good = (Good)this.goodService.getModel(((Message)resultList.get(i)).getGoodId());
         if (good != null) {
           ((Message)resultList.get(i)).setGoodCode(good.getCode());
           ((Message)resultList.get(i)).setGoodName(good.getName());
         }
       }
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.message == null) {
       this.message = new Message();
     }
     try
     {
       if (StringUtils.isBlank(this.message.getId())) {
         this.message.setReplyState("0");
         this.message.setState("c");
         initModel(true, this.message, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
     return "edit_message";
   }
 
   public String showMessage()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.message == null)
       this.message = new Message();
     try
     {
       this.message = ((Message)this.messageService.getModel(this.message.getId()));
       Good good = new Good();
       good = (Good)this.goodService.getModel(this.message.getGoodId());
       this.message.setGoodCode(good.getCode());
       this.message.setGoodName(good.getName());
       initModel(false, this.message, loginMan);
 
       this.messageList = this.messageService.getRevovery(this.message.getId());
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
     return "show_message";
   }
 
   public String revoveryEdit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.message == null)
       this.message = new Message();
     try
     {
       this.message.setReplyState("1");
       this.message.setState("s");
       this.message.setMessageId(this.message.getId());
       this.message.setGoodId(this.message.getGoodId());
       initModel(true, this.message, loginMan);
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
     return "edit_revovery";
   }
 
   public String viewRevoveryEdit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.message == null)
       this.message = new Message();
     try
     {
       this.message = ((Message)this.messageService.getModel(this.message.getId()));
       initModel(false, this.message, loginMan);
     } catch (Exception e) {
       logger.error("error occur when list message", e);
     }
     return "edit_revovery";
   }
 
   public void save()
   {
     logger.info("start to update message information");
     try {
       if (this.message == null) {
         this.message = new Message();
       }
       if (StringUtils.isBlank(this.message.getId()))
       {
         this.message.setId(this.messageService.makeId());
         this.messageService.insert(this.message);
       } else {
         this.messageService.update(this.message);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save message information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void revoverySave()
   {
     logger.info("start to update message information");
     try {
       if (this.message == null) {
         this.message = new Message();
       }
       String messageId = this.message.getMessageId();
 
       this.messageService.updatReplyState(messageId);
       this.message.setId(this.messageService.makeId());
 
       this.messageService.insert(this.message);
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save message information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.message == null) {
         this.message = new Message();
       }
 
       this.messageService.deleteByMessageId(this.message.getId());
 
       this.messageService.delete(this.message.getId());
       logger.info(loginMan.getCode() + " delete message,id:" + this.message.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale message", e);
     }
   }
 
   public Message getMessage() {
     return this.message;
   }
   public void setMessage(Message message) {
     this.message = message;
   }
   public void setMessageService(MessageService messageService) {
     this.messageService = messageService;
   }
   public MessageService getMessageService() {
     return this.messageService;
   }
   public List<Message> getMessageList() {
     return this.messageList;
   }
   public void setMessageList(List<Message> messageList) {
     this.messageList = messageList;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 }

/* 
 
 
 */