// 推荐商品
function tabChange(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("dl"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "mc";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "none";
  }
 }
}
// 商品详情
function spxq(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("dl"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "mc";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "hide";
  }
 }
}
// 评价
function pjsp(obj,id,showid,type,Totalid,pageid)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ol"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "mc";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "none";
  }
 }
     
     getWareComment(showid,type,Totalid,pageid);
 
 
 
 
}
// 商品资讯
function spzx(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ol"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "mc";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "none";
  }
 }
}
// 讨论圈
function taolq(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ol"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "mc";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "none";
  }
 }
}
// 排行榜
function paihb(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ul"); //获取ul数组
 for(i=0;i<arrayul.length;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "curr";
   arrayul[i].className = "tabcon";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "hide";
  }
 }
}
