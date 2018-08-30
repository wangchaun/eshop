 package com.sinokj.code.ibatis.impl;
 
 import com.sinokj.code.ibatis.Dialect;
 
 public class MysqlDialect implements Dialect
 {
   public String getLimitString(String sql, int offset, int limit)
   {
     if ((offset < 0) || (limit <= 0))
       return sql;
     sql = sql.trim();
     StringBuffer sb = new StringBuffer(sql.length() + 80);
     sb.append(sql).append(" limit ").append(offset).append(" , ").append(limit);
     return sb.toString();
   }
 
   public boolean supportsLimit() {
     return true;
   }
 }

/* 
 
 
 */