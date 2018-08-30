
$(document).ready(function () {
	getNowTime();
	dateValid();
});
function getNowTime(){
 
  var time = new Date();
  $('#nowTime').html("<samp>当前时间："+time.getHours()+":"+time.getMinutes()+":"+time.getSeconds()+"</samp>")
  setTimeout("getNowTime()",1000);
}
function changeDateFormat(cellval) {
	return "<span>" + "倒计时:" + "</span>" + "<samp>" + Math.abs(parseInt((cellval) / 1000 / 60 / 60)) + "</samp>" + "<span>" + "&nbsp;\u65f6&nbsp;" + "</span>" + "<samp>" + Math.abs(parseInt((cellval) / 1000 / 60 % 60)) + "</samp><span>&nbsp;\u5206&nbsp;</span><samp>" + Math.abs(parseInt((cellval) / 1000 % 60)) + "</samp><span>&nbsp;\u79d2</span>";
}
function changeDateFormat2(cellval) {
	return "<span>" + "结束时:" + "</span>" + "<samp>" + Math.abs(parseInt((cellval) / 1000 / 60 / 60)) + "</samp>" + "<span>" + "&nbsp;\u65f6&nbsp;" + "</span>" + "<samp>" + Math.abs(parseInt((cellval) / 1000 / 60 % 60)) + "</samp><span>&nbsp;\u5206&nbsp;</span><samp>" + Math.abs(parseInt((cellval) / 1000 % 60)) + "</samp><span>&nbsp;\u79d2</span>";
}
var flag = "true";
function dateValid() {
	var nowDate = new Date();
	var now = nowDate.getTime();
	$("[id=test]").each(function () {
	    
		var beginTime = Date.parse($(this).find("#countDown").attr("name").replace(/-/g, "/"));
		var endTime = Date.parse($(this).find("#countDown2").attr("name").replace(/-/g, "/"));
		 
		if (now >endTime) {
		        $(this).find("#countDown").html("");
	            $(this).find("#start").html("<img src='" + ctx + "/Images/images/miao11.jpg' border='0'></a>");
		} 
		else if(beginTime>now) {
			   
				$(this).find("#countDown").html(changeDateFormat(beginTime - now));	 
		} else {
			    $(this).find("#countDown").html(changeDateFormat2(now-endTime));
				var goodId = $(this).find("#gi").val();
				$(this).find("#start").html("<a href='" + ctx + "/cpxq.do?good.id=" + goodId + "'><img src='" + ctx + "/Images/images/miao10.JPG' border='0'></a>");
		}
		
	});


    //alert(parseInt((cellval)/1000/60/60/24));	
	setTimeout("dateValid()", 1000);
}

