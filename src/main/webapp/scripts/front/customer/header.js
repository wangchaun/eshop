$(document).ready(function(){
	seturl();
});


//插入链接地址
function seturl(){
	var url=document.location.href;
	$("#geturl").val(url);
}

//根据搜索类型进行搜索(默认才、搜索类型为商品)
function selectType(){ 
	var shoptypeName=$('#shoptypeName').val();
	 
	var url = ctx + '/shoptype.do';

	if(shoptypeName != null && shoptypeName != ''){
		url+='?shoptypeName='+shoptypeName;
	} 

	window.location.href = url;
	return true;
}


 //头条热门搜索 
function SearchWhereSubmit(paramrperName){ 
      document.SearchNameForm.nameValue.value=paramrperName;
      document.SearchNameForm.submit();

} 
  
//获取地区信息
function getArea(){
	var url=ctx +"/getArea.do";
	var htmlText="";
	$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
		  		var rows=eval(returnData).rows;
				for(i=0;i<rows.length;i++){
					if(rows.level=='1'){
						var areaName=rows[i].name;
						htmlText+="<div id='fy1'><span>"+areaName+"</span>";
						for(j=0;j<rows.length;j++){
							if(rows[j].parentId==rows[i].id){
								htmlText+="<a href='#'>"+rows[j].name+"</a>";
							}
						} 
						htmlText+="</div>";
					}
				}
			},
			error : function(){
				alert('系统错误，添入如购物车失败!');
		 	}
		});
}
  
  
function myShops(){
  	alert("您还未登陆，请先登陆！");
	window.location.href = ctx+'/frontLogin.do';
}
  

function loginOut(){
	if (confirm("您确定要退出吗?")){
		window.location.href=ctx+"/loginOut.do";
	}
}




//弹出隐藏层
function ShowDiv(show_div,bg_div){
	 
	document.getElementById(show_div).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	
	bgdiv.style.width = document.body.scrollWidth;
	$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div)
{
document.getElementById(show_div).style.display='none';
document.getElementById(bg_div).style.display='none';
};











  