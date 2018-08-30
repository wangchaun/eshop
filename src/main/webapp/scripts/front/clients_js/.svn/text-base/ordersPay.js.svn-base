
//一卡通付款
function paycard(orderId){
 //首先验证支付表单
 $.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: ctx+"/getZfbPayError.do",
		data: "orderId="+orderId,
		success : function(returnData){
					if(returnData == 'true'){
						window.open(ctx + '/paycard.do?orderId='+orderId);
					}else{
						alert("系统错误");
					}
				},
		error : function(){
			alert('系统错误!');
		} 
	});
}
var cTime=3;//这个变量是倒计时的秒数设置为10就是10秒
function TimeClose()
{
     window.setTimeout('TimeClose()',1000);//让程序每秒重复执行当前函数。
     if(cTime<=0)//判断秒数如果为0
       CloseWindow_Click();//执行关闭网页的操作
     this.showFont.innerHTML=cTime+"秒后关闭当前窗口";//显示倒计时时间
     cTime--;//减少秒数
}
function CloseWindow_Click(){
     window.close();
}
var count=0;
//添加一卡通账户
function add(){ 
   count++;
   var cardno1=$('#J_tLoginId1').val();
   var cardno2=$('#J_tLoginId2').val();
   var cardno3=$('#J_tLoginId3').val();
   $("#J_fakePwdContainer1").css("display","block");
   $("#J_commonAccountContainer1").css("display","block");
   $("#add").html("");
   if(cardno1!=''){
   $("#J_fakePwdContainer2").css("display","block");
   $("#J_commonAccountContainer2").css("display","block");
   $("#add").html("");
   }
   if(cardno2!=''){
   $("#J_fakePwdContainer3").css("display","block");
   $("#J_commonAccountContainer3").css("display","block");
   $("#add").html("");
   }
   if(cardno3!=''){
   $("#J_fakePwdContainer4").css("display","block");
   $("#J_commonAccountContainer4").css("display","block");
   $("#add").html("");
   }
}
 
//支付
function pay(orderId){
 
 var cardno=$('#J_tLoginId').val().trim();
 var pwd=$('#J_fakePasswordInput').val().trim();
 var cardno1=$('#J_tLoginId1').val().trim();
 var pwd1=$('#J_fakePasswordInput1').val().trim();
 var cardno2=$('#J_tLoginId2').val().trim();
 var pwd2=$('#J_fakePasswordInput2').val().trim();
 var cardno3=$('#J_tLoginId3').val().trim();
 var pwd3=$('#J_fakePasswordInput3').val().trim();
 var cardno4=$('#J_tLoginId4').val().trim();
 var pwd4=$('#J_fakePasswordInput4').val().trim();
 if(cardno==''){
    $('#J_tLoginId').focus();
    return false;
 }
 if(pwd==''){
    $('#J_fakePasswordInput').focus();
    return false;
 }
 if(cardno1!=''&&pwd1!=''){
   cardno=cardno+","+cardno1;
   pwd=pwd+","+pwd1;
 }
 if(cardno2!=''&&pwd2!=''){
   cardno=cardno+","+cardno2;
   pwd=pwd+","+pwd2;
 } 
 if(cardno3!=''&&pwd3!=''){
   cardno=cardno+","+cardno3;
   pwd=pwd+","+pwd3;
 }
 if(cardno4!=''&&pwd4!=''){
   cardno=cardno+","+cardno4;
   pwd=pwd+","+pwd4;
 }
    
 $.ajax({
    type: "POST",
		async: false,
		cache: false,
		url: ctx+"/confirmation.do",
		data: {orderId:orderId,pwd:pwd,cardno:cardno},
		success : function(returnData){
	    //ajax请求过程中，显示加载中图片并显示图层，请求完成隐藏图片  
        $(function () {  
        //注册ajax加载事件  
        $("#loading").ajaxStart(function () {  
            //一个div，用来遮挡页面，请求过程中，不可操作页面  
            var lockwin = $(this);  
            //div占满整个页面  
            lockwin.css("width", "100%");  
            lockwin.css("display", "block");  
            lockwin.css("height", $(window).height() + $(window).scrollTop());  
            //设置图片居中  
            $("#loading img").css("display", "block");  
            $("#loading img").css("left", ($(window).width() - 88) / 2);  
            $("#loading img").css("top", ($(window).height() + $(window).scrollTop()) / 2);  
        });  
      
        $("#loading").ajaxStop(function () {  
            //隐藏div  
            var lockwin = $(this);  
            lockwin.css("width", "0");  
            lockwin.css("display", "none");  
            lockwin.css("height", "0");  
            //设置图片隐藏  
            $("#loading img").css("display", "none");  
          });  
        });
        $("#account-loading-explain").css("display","bolck");   
		if(returnData == 'true'){
		   
		   alert("支付成功");
		   
		   var showtime=$('#ShowTime');
		   showtime.css("width", "100%");  
           showtime.css("display", "block");  
           showtime.css("height", $(window).height() + $(window).scrollTop());
           //设置字体居中  
		   TimeClose();
           $("#ShowTime span").css("display", "block");  
           $("#ShowTime span").css("left", ($(window).width() - 88) / 2);  
           $("#ShowTime span").css("top", ($(window).height() + $(window).scrollTop()) / 2);
	    } 
		if(returnData=='pwd'){
		   alert("账户名或一卡通密码错误"); 
		}
		if(returnData=='money'){
		   
		   if(count!=4){
		   $("#add").html("<span style='color:red;'>总余额不足支付</span>,添加一卡通账户<a href='javascript:void(0);' onclick='add()'>&nbsp;&nbsp;添加</a>");
		   }else{
		   $("#add").html("<span style='color:red;'>总余额不足支付</span>,最多用5个账户来支付");
		   }
		}
		 
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
		    alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
			alert('系统错误!');
		} 
  }); 
}
//支付宝付款
function aliPay(orderId){
	$.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: ctx+"/getZfbPayError.do",
		data: "orderId="+orderId,
		success : function(returnData){
					if(returnData == 'true'){
						window.open(ctx + '/alipayto.do?orderId='+orderId);
					}else{
						alert(returnData);
					}
				},
		error : function(XMLHttpRequest, textStatus, errorThrown){
		    alert(XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
			alert('系统错误!');
		} 
	});
}
//银行付款准备
function bankPayPre(orderId){
	var temp=document.getElementsByName("bank_code");
	var bankCode="qfb";
	for(var i=0;i<temp.length;i++){
		if(temp[i].checked){
			bankCode=temp[i].value;
		}
	}
	if(bankCode=="card"){
	  paycard(orderId);
	}else{
	  bankPay(orderId,bankCode);
	}
}

//银行付款		
function bankPay(orderId,bankCode){
	var url="";
	
	if(bankCode=='qfb'){
		url=ctx+"/getZfbPayError.do";
	}else{
		url=ctx+"/getZfbPayError2.do";
	}
	$.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: url,
		data: "orderId="+orderId+"&bankCode="+bankCode,
		success : function(returnData){
					if(returnData == 'true'){
						if(bankCode=='qfb'){
							window.open(ctx + '/alipayto.do?orderId='+orderId);
						}else{
							window.open(ctx + '/alipayto2.do?orderId='+orderId+"&bankCode="+bankCode);
							
						}
						
					}else{
						alert(returnData);
					}
				},
		error : function(){
			alert('系统错误!');
		} 
	});
}

//弹出隐藏层
function odpy(odpy,bg_div){
	document.getElementById(odpy).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function gbpdpy(odpy,bg_div)
{
	document.getElementById(odpy).style.display='none';
	document.getElementById(bg_div).style.display='none';
};




/**
 window.onbeforeunload = onbeforeunload_handler;   
    window.onunload = onunload_handler;   
    function onbeforeunload_handler(url){ 
//        var warning="确认退出?";
         window.location.href=url;  
    } 
    
    function onunload_handler(){   
//        var warning="谢谢光临";   
//        alert(warning);   
        
        var url="http://localhost:8080/"+ctx+"/ShoppingCar.do";
       
        onbeforeunload_handler(url);

        return true;
    }  

**/