$(document).ready(function(){
	var goodtypeId1 = $('#goodtypeId1').val();
	var goodtypeId2 = $('#goodtypeId2').val();
	var goodtypeId3 = $('#goodtypeId3').val();
	var goodtypeId4 = $('#goodtypeId4').val();
	var goodtypeId5 = $('#goodtypeId5').val();
	var goodtypeId6 = $('#goodtypeId6').val();
	var goodtypeId7 = $('#goodtypeId7').val();

		loadGood('1',goodtypeId1);
		loadGood('2',goodtypeId2);
		loadGood('3',goodtypeId3);
		loadGood('4',goodtypeId4);
		loadGood('5',goodtypeId5);
		loadGood('6',goodtypeId6);
		loadGood('7',goodtypeId7);     
		loadcurrGood('fkqgShow','1');	  //疯狂抢购商品加载	
		
		loadXSQGgood();   //限时抢购商品加载	

		
		


});

//充值切换
function qut(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("virtuals").getElementsByTagName("ul");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
}
//抢购切换
function curr(identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("hot").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
	show(identifying);
	
	loadcurrGood(identifying,showContent);
	
	
	hide(identifying);

	
}
//电脑数码 特价商品
function tjsp(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tjsp").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
	if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
	$('#Show'+identifying).hide();
}
	
	

//家庭通讯
function jdtx(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("jdtx").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
	
		if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
	
}
//丽人
function lr(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("lr").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
	
			if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
}
//名仕
function ms(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("ms").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
	if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
}
//生活专区
function sh(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("sh").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
		if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
	
}
//食品母婴
function spmy(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("spmy").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
			if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
}
//食品母婴
function tsyx(tags,identifying,showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tsyx").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
	
				if(tags == 'aa'){
	
	CommonGood(identifying,showContent);       //切换商品  带图片
	
	}else{
	
	ChangeCommonGood(identifying,showContent);      //切换商品  不带图片
	
	}
}
//榜单
function bd(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("bd").getElementsByTagName("dl");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "curr";
}

function loadGood(number,id){   //加载商品
 
 var num =1;

 if(id!=null){
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getGoodtypeAllGood.do?goodType.id="+id,
		  success : function(returnData){ 
			    $('#goodtypeHtml'+number).empty();
		      $.each(returnData,function(Good,good){
		      
		      var textHtml= "<li class='fore"
		                       +num+"'><div class='p-img'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"' ><img src='"
		                       +ctx+good.pic+"' width='130' height='130'></a></div>  <div class='p-detail'><div class='p-name'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"
		                       +good.name+"</a></div> <div class='p-price'><span>&#65509;"
		                       +good.price+"</span></div> </div></li>";
		                     
		      

		       $('#goodtypeHtml'+number).append(textHtml);
		      
		      num++;
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");

}
}

function CommonGood(identifying,showContent){    //切换商品   带图片
		if(showContent !=""){
	  var num= 1;
	
		$.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getGoodtypeAllGood.do?goodType.id="+showContent,
		  success : function(returnData){ 
			    $('#'+identifying).empty();
		      $.each(returnData,function(Good,good){
		      
		       var textHtml = "<li class='fore"
		                       +num+"'><div class='p-img'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"' ><img src='"
		                       +ctx+good.pic+"' width='130' height='130'></a></div>  <div class='p-detail'><div class='p-name'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"
		                       +good.name+"</a></div> <div class='p-price'><span>&#65509;"
		                       +good.price+"</span></div> </div></li>";
		      

		        $('#'+identifying).append(textHtml);
		      
	      
		      num++;
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");	
	
	}


}

function ChangeCommonGood(identifying,showContent){    //切换商品   不带图片  

		if(showContent !=""){
		
	  var num= 1;
	
		$.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getGoodtypeAllGood.do?goodType.id="+showContent,
		  success : function(returnData){ 
			    $('#'+identifying).empty();
		      $.each(returnData,function(Good,good){
		      
		      var textHtml = "<li class='fore"
		                     +num+"'> <div class='p-img ld'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'><img width='130' height='130' src='"
		                     +ctx+good.pic+"'></a></div> <div class='p-name'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"
		                     +good.name+"</a></div> <div class='p-price'>E购价：<strong>&#65509;"
		                     +good.price+"</strong></div> </li>";
		      

		          $('#'+identifying).append(textHtml);
		      
	      
		      num++;
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");	
	
	}


}
function loadcurrGood(identifying,property){   //加载疯狂抢购，热卖商品，热评商品，新品上架，猜您喜欢
 
 var num =1;

 if(property!=null){
 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getpropertyAllGood.do?good.property="+property,
		  success : function(returnData){ 
			    $('#'+identifying).empty();
		      $.each(returnData,function(Good,good){
		      
		      var textHtml= "<li class='fore"+num+"' onclick='reClick2012('fengkuang2012','1008276818#199.00',1);'><div class='p-img ld'> <a href='"+ctx+"/cpxq.do?good.id="+good.id+"' ><b class='pi pix1'>直降</b><img src='"
		      +ctx+good.pic+"' width='130' height='130' /></a> </div>  <div class='p-name'><a href='"+ctx+"/cpxq.do?good.id="+good.id+"' title='"
		      +good.name+"' >"
		      +good.name+"</a></div><div class='p-price'>E购价：<strong>￥"
		      +good.price+"</strong></div></li>";
		      

		       $('#'+identifying).append(textHtml);
		      
		      num++;
		      })
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
   hide(identifying);
}
}

 function loadXSQGgood(){
 
 
 var num =1;

 $.ajax({
		  type: "POST",
		  dataType:"json",   //返回数据类型是JSON数据格式 
		  async: false,
		  cache: false,
		  url: ctx+"/getpropertyAllGood.do?good.property=6",
		  success : function(returnData){ 
			    $('#XSQGshow').empty();
		      $.each(returnData,function(Good,good){
		      if(num <=5){
	  
		      var textHtml= "<div style='display: none;' id='endTime"+num+"'>"+good.endDate+"</div>  <li clstag='homepage|keycount|home2012|15a' id='timed"+num+"' class='fore"+num+"'> <div id='timer"+num+"' class='countdown'></div> <div class='p-img ld'><a title='"+good.name+"' href='"+ctx+"/cpxq.do?good.id="+good.id+"'><b class='pi pix1'><span>8.6</span><br/>折</b><img width='130' height='130' alt='"+good.name+"'  src='"+ctx+good.pic+"' /></a></div><div class='p-name'><a  title='"+good.name+"' href='"+ctx+"/cpxq.do?good.id="+good.id+"'>"+good.name+"</a></div><div class='p-price'><span>抢购价：</span><strong>￥"+good.price+"</strong></div></li> ";


		       $('#XSQGshow').append(textHtml);
		      
		      num++;
		      }
		      })
		      dateValid();  //限时抢购时间运算
			},
			error : function(){
				alert('系统繁忙!');
		 	}
	},"json");
  
}
 




function show(identifying){
	$('#'+identifying).empty();
	$('#'+identifying+"DIV").show();
}

function hide(identifying){

$('#'+identifying+"DIV").hide();
}

//剩余时间
function dateValid(){ 
    var beginDate =  new Date();
    var beginTime=beginDate.getTime();

    for( i=1; i<6; i++){
     
       var endTime = Date.parse($('#endTime'+i).html().replace(/-/g,"/"));
         
       if(beginTime <= endTime){
       $('#timer'+i).html("<strong>剩余:"+changeDateFormat(endTime-beginTime)+"</strong>");
       }else if(beginTime > endTime){
       $('#timer'+i).html("<strong>抢购期时间已过</strong>");
       }
       
    }

setTimeout("dateValid()",1000);
}
function changeDateFormat(cellval) {
    var date = new Date();
  date.setTime(cellval);
  
  //剩余<b>01</b>小时<b>09</b>分<b>20</b>秒
  return date.getDate()+'天'+date.getHours()+'小时'+date.getMinutes()+'分'+date.getSeconds()+'秒';
}

//格式化日期
function dateFormat(date){

	var dateStr = '';
	if(date!=null){
	//alert('dsadas');
		dateStr = date.substring(0,10);
	}
	return dateStr;
}

