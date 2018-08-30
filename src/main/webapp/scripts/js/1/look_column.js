var  textHtml="";
$(document).ready(function(){
	promotion1();
	promotion2();
	promotion3();
	promotion4();
	promotion5();
});
//首页第1个栏位设置
function promotion1(){
 $.ajax({
		  type: "POST",
//		  contentType: "application/json;charset=utf-8",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getPromotejson.do?promote.columnNo=SY001",
		  success : function(returnData){ 
		 	var data = eval(returnData);//解析json数据
		 	var datastr1=data.rows[0];
		 	//对栏位名称进行设置
			$('#SY1H1').empty();
			textHtml="<h2>"+datastr1.columnName+"</h2>";
			$('#SY1H1').append(textHtml);			 	
		 	//对第一个层设置
		 	$('#SY1D1').empty();
		    var  textHtml1="<div class='p-img'><a href="+ctx+datastr1.uri+" target='_blank' title="+datastr1.subject+"><img src='"+ctx+datastr1.pic+"' width='100' height='100' /></a></div>";
				 textHtml1+="<div class='p-name'><a href='"+datastr1.uri+"' target='_blank' title="+datastr1.subject+">"+datastr1.subject+"</a><span>首发</span></div>";
				 textHtml1+="<div class='p-detail'>"+datastr1.intro+"</div>";
		    $('#SY1D1').append(textHtml1);
		   
		    //对第二个层设置
		    var datastr2=data.rows[1];	
		    $('#SY1D2').empty();
		    var  textHtml2="<div class='p-img'><a href="+ctx+datastr2.uri+" target='_blank' title="+datastr2.subject+"><img src='"+ctx+datastr2.pic+"' width='100' height='100' /></a></div>";
				 textHtml2+="<div class='p-name'><a href='"+datastr2.uri+"' target='_blank' title="+datastr2.subject+">"+datastr2.subject+"</a><span>首发</span></div>";
				 textHtml2+="<div class='p-detail'>"+datastr2.intro+"</div>";
		    $('#SY1D2').append(textHtml2);
		    	
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}

//首页第2个栏位设置
function promotion2(){
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getPromotejson.do?promote.columnNo=SY002",
		  success : function(returnData){ 
		 	var data = eval(returnData);//解析json数据
		 	var datastr1=data.rows[0];
		 	//对栏位名称进行设置
			$('#SY2H1').empty();
			textHtml="<h2>"+datastr1.columnName+"</h2>";
			$('#SY2H1').append(textHtml);
						 	
		 	//对第一个层设置
		 	$('#SY2D1').empty();
		    var  textHtml1="<div class='p-img'><a href="+ctx+datastr1.uri+" target='_blank' title="+datastr1.subject+"><img src='"+ctx+datastr1.pic+"' width='100' height='100' /></a></div>";
				 textHtml1+="<div>"+datastr1.intro+"</div>";
		    $('#SY2D1').append(textHtml1);
		   
		    //对第二个层设置
		    var datastr2=data.rows[1];	
		    $('#SY2D2').empty();
		    var	textHtml2="<img src='"+ctx+datastr2.pic+"' title="+datastr2.subject+" width='310' height='100'/>";		
		    $('#SY2D2').append(textHtml2);
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}

//首页第3-8个栏位设置
function promotion3(){
var str="";
for(a=3;a<9;a++){
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/getPromotejson.do?promote.columnNo=SY00"+a,
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	var datastr1=data.rows[0];
			 	//对栏位名称进行设置
				$('#SY'+a+'H1').empty();
				textHtml="<h2>"+datastr1.columnName+"</h2>";
				$('#SY'+a+'H1').append(textHtml);
							 	
			 	//对第一个层设置
			 	var datastr="";
			 	var	textHtml1="<ul class='lh'>";
			 	var	textHtml2="";
			 	var textHtml3="";
			 	$('#SY'+a+'D1').empty();
			 	for(i=1;i<=data.rows.length;i++){
			
			 		datastr=data.rows[i-1];	
			 		if(i<10){
				    	textHtml1+="<li><a target='_blank' title="+datastr.subject+" href='"+ctx+datastr.uri+"'><img height='35' width='98' data-img='2' src='"+ctx+datastr.pic+"'></a></li>";	
			 		}
			 		if(10<=i&&i<12){
			 			if(a==3||a==4){
				 			$('#SY'+a+'D'+(i-8)).empty();
				 			textHtml2="<a href="+ctx+datastr.uri+" target='_blank' class='fl' style='background-image: none;' title='"+datastr.subject+"'> <img src='"+ctx+datastr.pic+"' width='150' height='55'/></a>";
				 			$('#SY'+a+'D'+(i-8)).append(textHtml2);
				 		}
				 		if(a==8){
				 			$('#SY8D2').empty();
				 			textHtml2="<a href="+ctx+datastr.uri+" target='_blank' class='fl' style='background-image: none;' title='"+datastr.subject+"'> <img src='"+ctx+datastr.pic+"' width='150' height='55'/></a>";
				 			$('#SY8D2').append(textHtml2);
				 		}
				 	}
				 	if(a==5&&i==11){
			 				$('#SY5D3').empty();
				 			textHtml3="<img src='"+ctx+datastr.pic+"' width='310' height='100'/>";
				 			$('#SY5D3').append(textHtml3);
			 		}
				 	if(a==6&&(i==10||i==11)){
				 			$('#SY'+a+'D'+(i-8)).empty();
				 			textHtml3="<img src='"+ctx+datastr.pic+"' width='310' height='100'/>";
				 			$('#SY'+a+'D'+(i-8)).append(textHtml3);
				 	}
				 	
					if(a==7){
						if(i==9){
							$('#SY7D2').empty();
				 			textHtml3="<img src='"+ctx+datastr.pic+"' width='310' height='55'/>";
				 			$('#SY7D2').append(textHtml3);
						}
						if(i>9){
							$('#SY'+a+'D'+(i-7)).empty();
				 			textHtml3="<img src='"+ctx+datastr.pic+"' width='310' height='100'/>";
				 			$('#SY'+a+'D'+(i-7)).append(textHtml3);
						}
					}
			 		if(12<=i){
			 			if(a==3||a==4){
				 			$('#SY'+a+'D'+(i-8)).empty();
				 			textHtml3="<img src='"+ctx+datastr.pic+"' width='310' height='100'/>";
				 			$('#SY'+a+'D'+(i-8)).append(textHtml3);
			 			}
			 		}
			 		
			 	}
			 	textHtml1+="</ul>";
			 	$('#SY'+a+'D1').append(textHtml1);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
	}	
}

//首页第9-10个栏位设置
function promotion4(){
for(a=9;a<11;a++){
var uri=ctx+"/getPromotejson.do?promote.columnNo=";
	if(a==9){
		uri+="SY009";
	}
	if(a==10){
		uri+="SY010";
	}
	 $.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: uri,
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	var datastr1=data.rows[0];
			 	//对栏位名称进行设置
				$('#SY'+a+'H1').empty();
				var textHtml="<h2>"+datastr1.columnName+"</h2>";
				$('#SY'+a+'H1').append(textHtml);
							 	
			 	//对第一个层设置
			 	$('#SY'+a+'D1').empty();
			    var  textHtml1="<div class='p-img ld'> <a href="+ctx+datastr1.uri+" target='_blank' title="+datastr1.subject+"><img src='"+ctx+datastr1.pic+"' width='50' height='50' /><b class='ci cix1'></b></a> </div>";
          			 textHtml1+="<div class='p-name'><a href="+ctx+datastr1.uri+" target='_blank' title="+datastr1.subject+">"+datastr1.subject+"</a></div>";
          			 textHtml1+="<div class='p-detail'><a href="+ctx+datastr1.uri+" target='_blank'>"+datastr1.intro+"</a></div>";		
			    $('#SY'+a+'D1').append(textHtml1);
			   
			    //对第二个层设置
			    var datastr2=data.rows[1];	
			    $('#SY'+a+'D2').empty();
			    var  textHtml2="<div class='p-img ld'> <a href="+ctx+datastr2.uri+" target='_blank' title="+datastr2.subject+"><img src='"+ctx+datastr2.pic+"' width='50' height='50' /><b class='ci cix1'></b></a> </div>";
          			 textHtml2+="<div class='p-name'><a href="+ctx+datastr2.uri+" target='_blank' title="+datastr2.subject+">"+datastr2.subject+"</a></div>";
          			 textHtml2+="<div class='p-detail'><a href="+ctx+datastr2.uri+" target='_blank'>"+datastr2.intro+"</a></div>";		
			    $('#SY'+a+'D2').append(textHtml2);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
	}
}

//首页第11个栏位设置
function promotion5(){
	$.ajax({
			  type: "POST",
			  dataType:"json",   //返回数据类型是JSON数据格式 
			  async: false,
			  cache: false,
			  url: ctx+"/getPromotejson.do?promote.columnNo=SY011",
			  success : function(returnData){ 
			 	var data = eval(returnData);//解析json数据
			 	var datastr1=data.rows[0];
			 	//对栏位名称进行设置
				$('#SY11H1').empty();
				var textHtml="<h2>"+datastr1.columnName+"</h2>";
				$('#SY'+a+'H1').append(textHtml);
							 	
			 	//对第一个层设置(将第一条数据的图片显示到页面上)
			 	$('#SY11D1').empty();
			    var  textHtml1="<a href="+ctx+datastr1.uri+" target='_blank' title="+datastr1.subject+"><img src="+ctx+datastr1.pic+" width='100' height='100' /></a>";		
			    $('#SY11D1').append(textHtml1);
			   
			    //对第二个层设置
			    var  textHtml2="";
			    var datastr="";	
			    $('#SY11D2').empty();
			    for(i=0;i<data.rows.length;i++){
			    	if(i<4){					//只显示4条
				    	datastr=data.rows[i];
				    	textHtml2+="<li><a href="+ctx+datastr.uri+" target='_blank' title="+datastr.subject+"><b>·</b>"+datastr.subject+"</a></li>";
			   		}
			    }
			    $('#SY11D2').append(textHtml2);
				},
				error : function(){
					alert('系统繁忙!');
			 	}
		},"json");
}




