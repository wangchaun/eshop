var  textHtml="";
$(document).ready(function(){
	selBrand();
	selGood();
	seleGood();
	Alltypegood();
});

//查询品牌
function selBrand(){
var goodTypeId=$('#goodTypeId').val();
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/getselBrand.do",
			  data:"goodBrand.goodTypeId="+goodTypeId,
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
//			 	alert(data.rows.length);
			 	var datastr="";
			 	var textHtml="";
			 	$('#brandli').empty();
			 	for(i=0;i<data.rows.length;i++){
			 		if(i<10){
			 			datastr=data.rows[i];
			 			textHtml+="<li><a target='_blank' href='"+ctx+"/goodBrand.do?goodBrand.code="+datastr.code+"'><img height='31' width='88' alt='"+datastr.name+"' src='"+ctx+datastr.pic+"'></a><a target='_blank' href='"+ctx+"/goodBrand.do?goodBrand.code="+datastr.code+"'>"+datastr.name+"</a></li>";
			 		}
			 	}
			 	$('#brandli').append(textHtml);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
}

//查询推荐商品(取疯狂抢购)
function selGood(){
	var goodTypeId=$('#goodTypeId').val();
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/getselGood.do",
			  data:"good.goodTypeId="+goodTypeId+"&good.property=1",
			  charset:"utf-8",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	var datastr="";
			 	var textHtml="";
			 	$('#selgood').empty();
			 	for(i=1;i<=data.rows.length;i++){
			 		if(i<=5){
			 			datastr=data.rows[i-1];
			 			textHtml+="<li class='fore' id='selgood"+i+"'>";
			 			textHtml+="<span>"+i+"</span>";
            			textHtml+="<div class='p-img'><a target='_blank' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'><img src="+ctx+datastr.pic+" width='50' height='50' alt='"+datastr.name+"' data-img='1'/></a></div>";
            			textHtml+="<div class='p-name'><a target='_blank' title='"+datastr.name+"' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'>"+datastr.name+"<font color='ff6600' >"+datastr.remark+"</font></a></div>";
            			textHtml+="<div class='p-price'><strong><font color='red'>￥"+datastr.price+"</font></strong></div>";
			 			textHtml+="</li>"
			 		}
			 	}
			 	$('#selgood').append(textHtml);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
}


//查询最新降价
function seleGood(){
	var goodTypeId=$('#goodTypeId').val();
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/getselGood.do",
			  data:"good.goodTypeId="+goodTypeId+"&good.property=4",
			  charset:"utf-8",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	var datastr="";
			 	var textHtml="";
			 	$('#selegood').empty();
			 	for(i=1;i<=data.rows.length;i++){
			 		if(i<=5){
			 			datastr=data.rows[i-1];
			 			textHtml+="<li class='fore' id='selegood"+i+"'>";
			 			textHtml+="<span>"+i+"</span>";
            			textHtml+="<div class='p-img'><a target='_blank' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'><img src="+ctx+datastr.pic+" width='50' height='50' alt='"+datastr.name+"' data-img='1'/></a></div>";
            			textHtml+="<div class='p-name'><a target='_blank' title='"+datastr.name+"' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'>"+datastr.name+"<font color='ff6600' >"+datastr.name+"</font></a></div>";
            			textHtml+="<div class='p-price'><strong><font color='red'>￥"+datastr.price+"</font></strong></div>";
			 			textHtml+="</li>"
			 		}
			 	}
			 	$('#selegood').append(textHtml);
			},
			error : function(){
				alert('系统繁忙!');
			}
		},"json");
}

//商品展示
function Alltypegood(){
	var goodTypeId=$('#goodTypeId').val();
	var textHtmls="";
	var textHtmlAs="";
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/selType.do",
			  data:"good.goodTypeId="+goodTypeId,
			  charset:"utf-8",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	//第1个商品模块
			 	Lookgood1(data.rows[0].id,data.rows[0].name);
			 	//第2个商品模块
			 	var v='';
			 	$('#EJDH').empty();
			 		var htmls="";
			 	for(v=1;v<data.rows.length;v++){
				 	if(v<5){
						htmls+=Lookgood2(data.rows[v].id,data.rows[v].name,v+1);
					}
				}
				$('#EJDH').append(htmls);
				$('#EJC1').empty();
				for(k=0;k<data.rows.length;k++){
					textHtmls+=LookTypeName(data.rows[k].id);
				}
				$('#EJC1').append(textHtmls);
				$('#EJB1').empty();
					textHtmlAs="<h1 ><a href = '"+ctx+"/selTypeGood.do?good.goodTypeId="+data.Parent.id+"'>"+data.Parent.name+"</a></h1>";
					textHtmlAs+="<span>&nbsp;&nbsp;&nbsp;";
					for(j=0;j<data.rows.length;j++){
						if(j<5){
							textHtmlAs+="<a href='"+ctx+"/selTypeGood.do?good.goodTypeId="+data.rows[j].id+"'>"+data.rows[j].name+"</a>&nbsp;|&nbsp;";
						}
					}
					textHtmlAs+="</span>";
				$('#EJB1').append(textHtmlAs);
				$('#EJA1').empty();
				$('#EJA1').append("<h2>"+data.Parent.name+"</h2>");		
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
}

//编辑第一个商品模块
function Lookgood1(goodTypeId,goodTypeName){
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/AllTypeGood.do",
			  data:"good.goodTypeId="+goodTypeId,
			  charset:"utf-8",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 		$('#EJ1H1').empty();
			 		var textHtml1="<h2>"+goodTypeName+"</h2>";
					$('#EJ1H1').append(textHtml1);
					data = data.rows;
					$('#EJ1D1').empty();
					var textHtml="";
					var datastr="";
					for(i=1;i<=data.length;i++){
						if(i<7){
							datastr=data[i-1];
							textHtml+="<li class='fore'>";
							textHtml+="<div class='p-img'><a target='_blank' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'><img src='"+ctx+datastr.pic+"' width='100' height='100' alt='"+datastr.name+"' data-img='1' /></a></div>";
							textHtml+="<div class='p-name'><a target='_blank' title='"+datastr.name+"' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'>"+datastr.name+"<font color='#ff6600'></font></a></div>";
							textHtml+="<div  class='p-price'>E购价：<strong>"+datastr.price+"</strong></div>";
							textHtml+='</li>';
						}
					}
					$('#EJ1D1').append(textHtml);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
}

//编辑第二个商品模块
function Lookgood2(goodTypeId,goodTypeName,a){
var textHtml="";
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/AllTypeGood.do",
			  data:"good.goodTypeId="+goodTypeId,
			  charset:"utf-8",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 		textHtml="<div class='mt'>";
         			textHtml+="<div id='EJ2H1'><h2>"+goodTypeName+"</h2></div>";
       				textHtml+="<div class='extra'></div>";
      				textHtml+="</div>";
					data = data.rows;
					textHtml+="<div class='mc'>";
					if(data.length>0){
						textHtml+="<div class='da da180x348'><a target='_blank' href='"+ctx+"/cpxq.do?good.id="+data[0].id+"'><img height='348' width='180' src='"+ctx+data[0].pic+"' app='image:poster' alt='"+data[0].name+"'/></a> </div>";
						textHtml+="<ul class='list-h'>";
						var datastr="";
						for(i=1;i<data.length;i++){
							if(i<7){
								datastr=data[i];
								textHtml+="<li class='fore'>";
								textHtml+="<div class='p-img'><a target='_blank' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'><img src='"+ctx+datastr.pic+"' width='100' height='100' alt='"+datastr.name+"' data-img='1' /></a></div>";
								textHtml+="<div class='p-name'><a target='_blank' title='"+datastr.name+"' href='"+ctx+"/cpxq.do?good.id="+datastr.id+"'>"+datastr.name+"<font color='#ff6600'></font></a></div>";
								textHtml+="<div  class='p-price'>E购价：<strong>"+datastr.price+"</strong></div>";
								textHtml+='</li>';
							}
						}
						textHtml+="</ul>";
//						$('#EJ'+a+'D1').append(textHtml);
					}	
					textHtml+="</div>";
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
	return textHtml;	
}

//加载类别名称
function LookTypeName(Id){
	var textHtml='';
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/AllTypeName.do",
			  data:"goodType.parentId="+Id,
			  charset:"utf-8",
			  success:function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	textHtml="<div class='item current'><h3><b></b><a href = '"+ctx+"/selTypeGood.do?good.goodTypeId="+Id+"'>"+data.Parent.name+"</a></h3><ul>";
			 	for(i=0;i<data.rows.length;i++){
			 		if(data.rows[i].level==2){
			 			textHtml+="<li><a href="+ctx+"/selTypeGood.do?good.goodTypeId="+data.rows[i].id+">"+data.rows[i].name+"</a></li>";
			 		}
			 		if(data.rows[i].level==3){
			 			textHtml+="<li><a href="+ctx+"/getLeve_3Page.do?goodType.id="+data.rows[i].id+">"+data.rows[i].name+"</a></li>";
			 		}
			 	}
			 	textHtml+="</ul></div>";
			  },
			  error : function(){
				alert('系统繁忙!');
			  }
		},"json");
	return textHtml;	
}
