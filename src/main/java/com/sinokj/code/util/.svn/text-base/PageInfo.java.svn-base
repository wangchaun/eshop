 package com.sinokj.code.util;
 
 public class PageInfo
 {
   private int count = 0;
   private int pageSize = 10;
   private int pageCount = 0;
   private int pageIndex = 1;
 
   public int getFirstPage()
   {
     return 1;
   }
 
   public int getPreviousPage() {
     if (this.pageIndex <= 1) {
       return 1;
     }
 
     return this.pageIndex - 1;
   }
 
   public int getNextPage()
   {
     if (this.pageIndex >= getLastPage()) {
       return getLastPage();
     }
 
     return this.pageIndex + 1;
   }
 
   public int getLastPage()
   {
     int last = (this.count + this.pageSize - 1) / this.pageSize;
     return last;
   }
 
   public int getCount() {
     return this.count;
   }
 
   public void setCount(int count) {
     this.count = count;
   }
 
   public int getPageSize() {
     return this.pageSize;
   }
 
   public void setPageSize(int pageSize) {
     this.pageSize = pageSize;
   }
 
   public int getPageCount() {
     return this.pageCount;
   }
 
   public void setPageCount(int pageCount) {
     this.pageCount = pageCount;
   }
 
   public int getPageIndex() {
     return this.pageIndex;
   }
 
   public void setPageIndex(int pageIndex) {
     this.pageIndex = pageIndex;
   }
 }