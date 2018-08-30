 package com.sinokj.app.baseInfo.bankAccount.action;
 
 import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class BankAccountAction extends BaseAction
 {
   private static final long serialVersionUID = -9184587610253799858L;
   private static final Logger logger = Logger.getLogger(BankAccountAction.class);
   private BankAccountService bankAccountService;
   private BankAccount bankAccount;
 
   public void setBankAccountService(BankAccountService bankAccountService)
   {
     this.bankAccountService = bankAccountService;
   }
 
   public String list()
   {
     return "list_bankAccount";
   }
 
   public String listJson()
   {
     logger.info("start list all bankAccount data!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.bankAccountService.pageList(pageInfo, this.bankAccount, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list bankAccount data!", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
 
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
 
     logger.info("finish list all bankAccount data!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.bankAccount == null) {
         this.bankAccount = new BankAccount();
       }
       if (StringUtils.isBlank(this.bankAccount.getId())) {
         initModel(true, this.bankAccount, loginMan);
       } else {
         this.bankAccount = ((BankAccount)this.bankAccountService.getModel(this.bankAccount.getId()));
         initModel(false, this.bankAccount, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when get a bankAccount", e);
     }
     return "edit_bankAccount";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.bankAccount.getId()))
         this.bankAccountService.insert(this.bankAccount);
       else {
         this.bankAccountService.update(this.bankAccount);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save bankAccount", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     String id = this.bankAccount.getId();
     logger.info("delete bankAccount,id:" + id);
     try {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.bankAccountService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete bankAccount,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + 
         " delete bankAccount,id:" + id, e);
     }
   }
 
   public void checkAccount()
   {
     try
     {
       if (this.bankAccount.getAccount() != null) {
         this.bankAccount = ((BankAccount)this.bankAccountService.selectOne(this.bankAccount));
         if (this.bankAccount == null)
           responseFlag(true);
         else
           responseFlag(false);
       }
     }
     catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save bankAccount", e);
     }
   }
 
   public BankAccount getBankAccount()
   {
     return this.bankAccount;
   }
   public void setBankAccount(BankAccount bankAccount) {
     this.bankAccount = bankAccount;
   }
 }