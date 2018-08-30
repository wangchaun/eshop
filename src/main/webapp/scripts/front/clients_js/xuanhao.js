//$(document).ready(function(){
//  selectCityJson('');//回调方法
//});




function selectCityJson(idp){ 
	var url=ctx+"/selectCityJson.do?area.parentId="+idp;
	var htmlText="";   
	
	if(idp!=''){
		$.ajax({   
				type: "POST",
				async: false,
				cache: false,
				url: url,
				data : url,
				success : function(returnData){ 
					rows=eval(returnData).rows;  $('#city').empty();
					htmlText+="<h2><select name='' class='pickselect'>";
					for(i=0;i<rows.length;i++){ 
						var city=rows[i];
						htmlText+="<option value='"+city.name+"'>"+city.name+"</option>";
					}
					htmlText+="</select></h2>";
					$('#city').append(htmlText);	
				},
				error : function(){
					alert('系统错误!');
				}
			});
		
	}
		
}

//获取单选框的值
function getRedio(obj){
  var value="";  
  var radio=document.getElementsByName(obj);  
  	for(var i=0;i<radio.length;i++){	
  		if(radio[i].checked==true){	  
	  		value=radio[i].value;	  
	  		break;	
  		}  
  	}  
  return value;
 }


//提交表单数据
function submit(){
     var radios= getRedio("goodChecked"); 
     document.location.href=ctx+"/taocan.do?good.id="+radios;
}       
       