$(document).ready(function(){
   	dateValid();
   	dateValid1();
});

function changeDateFormat(cellval) {
  var date = new Date();
  date.setTime(cellval);
  return "<h2>"+parseInt((cellval)/1000/60/60/24)+"</h2>"+"<h3>"+'天'+"</h3>"+"<h2>"+parseInt((cellval)/1000/60/60%24)+"</h2>"+"<h3>"+'时'+"</h3>"+"<h2>"+parseInt((cellval)/1000/60%60)+"</h2>"+"<h3>"+'分'+"</h3>"+"<h2>"+parseInt((cellval)/1000%60)+"</h2>"+"<h3>"+'秒'+"</h3>";
}
//本期抢购距离结束时间
function dateValid(){ 	
	var beginDate =  new Date();
	var beginTime=beginDate.getTime();
	var endTime = Date.parse(document.getElementById("endTime").value.replace(/-/g,"/"));
	
//	alert(new Date(beginTime)+"-"+new Date(endTime)+"="+(beginTime-endTime));
		
	if(beginTime>=endTime){
		$('#endTime1').html(changeDateFormat(0));
		window.location.href=""+ctx+"/qianggou.do?doWhat=over";		
	}else{
		$('#endTime1').html(changeDateFormat(endTime-beginTime));
	}
	setTimeout("dateValid()",1000);
}
//下期抢购距离开始时间
function dateValid1(){ 	
	var beginDate =  new Date();
	var beginTime=beginDate.getTime();
	var endTime = Date.parse(document.getElementById("beginTime").value.replace(/-/g,"/"));
	
//	alert(new Date(beginTime)+"-"+new Date(endTime)+"="+(beginTime-endTime));
	
	if(beginTime>=endTime){  
	   	$('#beginTime1').html("<samp>"+changeDateFormat(0)+"</samp>");
	   	window.location.href=""+ctx+"/qianggou.do?doWhat=begin";	
	}else{
		$('#beginTime1').html("<samp>"+changeDateFormat(endTime-beginTime)+"</samp>");
	}
	setTimeout("dateValid1()",1000);
}