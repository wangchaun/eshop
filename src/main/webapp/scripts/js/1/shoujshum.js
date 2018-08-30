$(document).ready(function(){

showPic('erjiyexiaofangkuai');    //二级页小方块图片
});

function showPic(parameter){

 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getadvertiseJson.do?advertise.place=" +parameter,
		  success : function(returnData){ 
			    var data = eval(returnData);
			    $('#slidehtml').empty();
			    for(i = 0; i< data.rows.length; i++){
			    if(i <=7){
			    var datastr = data.rows[i];		
			    var textHtml = " <li><a href='"+datastr.url+"'><img width='766' height='240' src='"+ctx+datastr.pic+"'/></a></li>";
			    $('#slidehtml').append(textHtml);	  
                  }
			    }
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
}



 
         