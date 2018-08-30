 package com.sinokj.app.component.serialNumber.service;
 
 import com.sinokj.app.component.serialNumber.model.SerialNumber;
import com.sinokj.code.service.BaseService;
import com.sinokj.code.util.DateUtil;
import com.sinokj.code.util.NumberUtil;

 import java.util.Calendar;
 import java.util.Date;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SerialNumberService extends BaseService<SerialNumber>
 {
   private static final Logger logger = Logger.getLogger(SerialNumber.class);
 
   public String getSerialNumberByDate(String prefix, String appType)
     throws Exception
   {
     if (StringUtils.isBlank(prefix)) {
       logger.error("prefix is empty");
       throw new Exception("prefix is empty");
     }
     if (StringUtils.isBlank(appType)) {
       logger.error("appType is empty");
       throw new Exception("appType is empty");
     }
     logger.info("prefix:" + prefix + ";appType:" + appType);
 
     StringBuffer resultSerialNumber = new StringBuffer(prefix);
 
     Calendar calendar = Calendar.getInstance();
 
     Date nowDate = calendar.getTime();
     String nowDateStr = DateUtil.date2Str(nowDate, "yyyyMMdd");
     nowDate = DateUtil.str2Date(nowDateStr, "yyyyMMdd");
     int number = 0;
 
     SerialNumber objParam = new SerialNumber();
     objParam.setAppType(appType);
     SerialNumber serialNumber = (SerialNumber)super.selectOne(objParam);
     if (serialNumber == null) {
       logger.info("serialNumber is null");
       number = 1;
 
       serialNumber = new SerialNumber();
       serialNumber.setId(super.makeId());
       serialNumber.setAppType(appType);
       serialNumber.setSerialDate(nowDate);
       serialNumber.setNumber(Integer.valueOf(number));
 
       logger.info("insert a serialNumber");
       super.insert(serialNumber);
       logger.info("insert a serialNumber successd");
     } else {
       logger.info("serialNumber is exist");
       if (nowDate.after(serialNumber.getSerialDate())) {
         logger.info("nowDate is later than serialDate,so update nowDate to serialDate,and reset number");
         serialNumber.setSerialDate(nowDate);
         number = 1;
       } else {
         logger.info("nowDate is not later than serialDate,so number plus one");
         number = serialNumber.getNumber().intValue() + 1;
       }
       serialNumber.setNumber(Integer.valueOf(number));
 
       logger.info("update a serialNumber");
       super.update(serialNumber);
       logger.info("update a serialNumber successd");
     }
 
     resultSerialNumber.append(nowDateStr);
     String numberStr = NumberUtil.formatNumber(number, 4);
     resultSerialNumber.append(numberStr);
 
     logger.info("resultSerialNumber:" + resultSerialNumber);
     return resultSerialNumber.toString();
   }
 
   public String getSerialNumberNoDate(String prefix, String appType, int bit)
     throws Exception
   {
     if (StringUtils.isBlank(appType)) {
       logger.error("appType is empty");
       throw new Exception("appType is empty");
     }
     logger.info("appType:" + appType);
 
     StringBuffer resultSerialNumber = new StringBuffer(prefix);
 
     SerialNumber objParam = new SerialNumber();
     objParam.setAppType(appType);
     SerialNumber serialNumber = (SerialNumber)super.selectOne(objParam);
     int number;
     if (serialNumber == null) {
       logger.info("serialNumber is null");
       number = 1;
 
       serialNumber = new SerialNumber();
       serialNumber.setId(super.makeId());
       serialNumber.setAppType(appType);
       serialNumber.setNumber(Integer.valueOf(number));
 
       logger.info("insert a serialNumber");
       super.insert(serialNumber);
       logger.info("insert a serialNumber successd");
     } else {
       logger.info("serialNumber is exist");
       number = serialNumber.getNumber().intValue() + 1;
       serialNumber.setNumber(Integer.valueOf(number));
       logger.info("update a serialNumber");
       super.update(serialNumber);
       logger.info("update a serialNumber successd");
     }
     String numberStr = NumberUtil.formatNumber(number, bit);
     resultSerialNumber.append(numberStr);
     logger.info("resultSerialNumber:" + resultSerialNumber);
     return resultSerialNumber.toString();
   }
 }