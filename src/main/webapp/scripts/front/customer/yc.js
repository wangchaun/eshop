//用户协议书
function MM_showHideLayers(divID,paraA,status){ 
if(status=="show"){ 
document.getElementById(divID).style.display="block"; 
}else if(status=="hidden"){ 
document.getElementById(divID).style.display="none"; 
} 
}
//登录帐号
function dlzh(divID,paraA,status){
	var codeExp = "^[a-zA-Z0-9_]{1,}$";
	var codeObj = $("#usercode").val();
	if(status=="show"){ 
		$("#zcyc11").css({display:'none'});
		$("#zcyc1").empty();
		$("#zcyc1").append("6-24位由字母、数字、下划线组成！");
		document.getElementById(divID).style.display="block"; 
		document.getElementById('usercode').style.border='1px solid #FEA710';
	}else if(status=="hidden"){
		var codeExp = "^[a-zA-Z0-9_]{1,}$";
		var codeObj = $("#usercode").val();
		if(codeObj!=''&&codeObj.match(codeExp)&&codeObj.length >= 4&&codeObj.length<=20){
		$.ajax({	
		  type: "POST", 
		  async: false,
		  cache: false,
		  url: ctx+"/checkUser.do?customer.name="+codeObj+"",
		  success : function(returnData){
		  	if(returnData =='true'){		  		
		  		document.getElementById('usercode').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
				$("#zcyc11").empty();
				$("#zcyc11").append("<span><img src='"+ctx+"/Images/images/pass8.jpg' /></span>");
				$("#zcyc11").css({display:'block'});	
				accountFlag=true;			
				if(checkFlag==true&&verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
					$("#agreeRegister").removeAttr("disabled");
    				$("#agreeRegister").css({cursor:"hand"});
				}
				
		  	}else{	
		  		document.getElementById('usercode').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";	  		
				$("#zcyc11").empty();
				$("#zcyc11").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>用户名已存在");
				$("#zcyc11").css({display:'block'});
				accountFlag=false;	
				$("#agreeRegister").attr("disabled","true");
    			$("#agreeRegister").css({cursor:"text"});		
		  	}		  
		  },
		  error : function(){
			alert('系统繁忙!');
		  }
		});
		}else if(codeObj!=''){
			document.getElementById('usercode').style.border='1px solid #dadada';
			document.getElementById(divID).style.display="none";
			$("#zcyc11").empty();
			$("#zcyc11").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>6-24位由字母、数字、下划线组成！");						
			$("#zcyc11").css({display:'block'});	
			accountFlag=false;	
			$("#agreeRegister").attr("disabled","true");
    		$("#agreeRegister").css({cursor:"text"});
		}else{
			document.getElementById('usercode').style.border='1px solid #dadada';			
			$("#zcyc1").empty();
			$("#zcyc1").append("请输入用户名！");
			accountFlag=false;
		}	
	} 
} 
//帐号密码
function mmzh(divID,paraA,status){ 
	if(status=="show"){ 
		$("#zcyc21").css({display:'none'});
		document.getElementById(divID).style.display="block"; 
		document.getElementById('userpwd').style.border='1px solid #FEA710';
	}else if(status=="hidden"){		
		if(pwd.length >= 5&&pwd.length <= 15){
			document.getElementById('userpwd').style.border='1px solid #dadada';
			document.getElementById(divID).style.display="none";
			$("#zcyc21").empty();
			$("#zcyc21").append("<span><img src='"+ctx+"/Images/images/pass8.jpg' /></span>");
			$("#zcyc21").css({display:'block'});
			mmFlag=true;
			if(checkFlag==true&&verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
				$("#agreeRegister").removeAttr("disabled");
    			$("#agreeRegister").css({cursor:"hand"});
			}
		}else{			
			document.getElementById('userpwd').style.border='1px solid #dadada';
			document.getElementById(divID).style.display="none";
			$("#zcyc21").empty();
			$("#zcyc21").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>");
			$("#zcyc21").css({display:'block'});	
			mmFlag=false;
			$("#agreeRegister").attr("disabled","true");
    		$("#agreeRegister").css({cursor:"text"});
		}
	} 
} 
//重复密码
function ccmm(divID,paraA,status){ 
	if(status=="show"){ 
		$("#zcyc31").css({display:'none'});
		document.getElementById(divID).style.display="block"; 
		document.getElementById('checkPwd').style.border='1px solid #FEA710';
	}else if(status=="hidden"){ 
		var pwd = $('#userpwd').val();
		if(''!=pwd){
			if($('#checkPwd').val() == pwd&&''!=$('#checkPwd').val()){
				document.getElementById('checkPwd').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
				$("#zcyc31").empty();
				$("#zcyc31").append("<span><img src='"+ctx+"/Images/images/pass8.jpg' /></span>");
				$("#zcyc31").css({display:'block'});
				mm1Flag=true;
				if(checkFlag==true&&verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
					$("#agreeRegister").removeAttr("disabled");
	    			$("#agreeRegister").css({cursor:"hand"});
				}			
			}else{
				document.getElementById('checkPwd').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
				$("#zcyc31").empty();
				$("#zcyc31").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>两次输入密码不一致，请重新输入！");
				$("#zcyc31").css({display:'block'});	
				mm1Flag=false;
				$("#agreeRegister").attr("disabled","true");
	    		$("#agreeRegister").css({cursor:"text"});
			}
		}else{
			document.getElementById('checkPwd').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
		}				
	} 
} 
//邮箱地址
function yydz(divID,paraA,status){ 
	if(status=="show"){
		$("#zcyc41").css({display:'none'});
		$("#zcyc4").empty();
		$("#zcyc4").append("请输入常规邮箱用于找回密码！"); 
		document.getElementById(divID).style.display="block"; 
		document.getElementById('email').style.border='1px solid #FEA710';
	}else if(status=="hidden"){
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		var email= document.getElementById('email').value;		
		if(myreg.test(email)&&email!=''){
	      $.ajax({	
		  type: "POST", 
		  async: false,
		  cache: false,
		  url: ctx+"/checkEmai.do?customer.email="+email+"",
		  success : function(returnData){
		  	if(returnData =='true'){		  		
		  		document.getElementById('email').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
				$("#zcyc41").empty();
				$("#zcyc41").append("<span><img src='"+ctx+"/Images/images/pass8.jpg' /></span>");
				$("#zcyc41").css({display:'block'});
				emailFlag=true;
				if(checkFlag==true&&verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
				$("#agreeRegister").removeAttr("disabled");
    			$("#agreeRegister").css({cursor:"hand"});				
		  		}
		  	}else{	
		  		document.getElementById('email').style.border='1px solid #dadada';
				document.getElementById(divID).style.display="none";
				$("#zcyc41").empty();
				$("#zcyc41").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>邮箱已经存在！");
				$("#zcyc41").css({display:'block'});	
				emailFlag=false;
				$("#agreeRegister").attr("disabled","true");
    			$("#agreeRegister").css({cursor:"text"});		
		  	}
		  		  
		  },
		  error : function(){
			alert('系统繁忙!');
		  }
		  
		  });		
		}else if(email!=''){
			document.getElementById('email').style.border='1px solid #dadada';
			document.getElementById(divID).style.display="none";
			$("#zcyc41").empty();
			$("#zcyc41").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>请输入正确的邮箱地址！");						
			$("#zcyc41").css({display:'block'});	
			emailFlag=false;	
			$("#agreeRegister").attr("disabled","true");
    		$("#agreeRegister").css({cursor:"text"});
		}else{
			document.getElementById('email').style.border='1px solid #dadada';			
			$("#zcyc4").empty();
			$("#zcyc4").append("请输入邮箱地址！");
			accountFlag=false; 
		}
	}
} 
//验证码
function yzm(divID,paraA,status){ 
	if(status=="show"){ 
		$("#zcyc51").css({display:'none'});
		document.getElementById(divID).style.display="inline"; 
		document.getElementById('checkA').style.border='1px solid #FEA710';
	}else if(status=="hidden"){
		var verifiString=document.getElementById("checkA").value;
		if(''!=verifiString){
			$.ajax({	
			  type: "POST", 
			  async: false,
			  cache: false,
			  xhrFields: {
				withCredentials: true
			  },
			  crossDomain: true,
			  url: ctxaccount+"/account/checkValidatePicture?verifyCode="+verifiString+"",
			  success : function(returnData){
			  	if(returnData =='true'){		  		
			  		document.getElementById('checkA').style.border='1px solid #dadada';
					document.getElementById(divID).style.display="none";
					$("#zcyc51").empty();
					$("#zcyc51").append("<span><img src='"+ctx+"/Images/images/pass8.jpg' /></span>");
					$("#zcyc51").css({display:'block'});
					verifyFlag=true;				
					if(checkFlag==true&&verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
						$("#agreeRegister").removeAttr("disabled");
	    				$("#agreeRegister").css({cursor:"hand"});
					}
					
			  	  }else{
			  		document.getElementById('checkA').style.border='1px solid #dadada';
					document.getElementById(divID).style.display="none";
					$("#zcyc51").empty();
					$("#zcyc51").append("<span><img src='"+ctx+"/Images/images/pass9.jpg' /></span>");
					$("#zcyc51").css({display:'block'});	
					verifyFlag=false;	
					$("#agreeRegister").attr("disabled","true");
	    			$("#agreeRegister").css({cursor:"text"});		
			  	  }		  
			  	},
		  		error : function(){
					alert('系统繁忙!');
		  		}
			});
		}else{
			document.getElementById('checkA').style.border='1px solid #dadada';
			document.getElementById(divID).style.display="none";
		}		
		
	} 
}
var imageNumber=1;
//改变验证码
function changeImage(){
	var textHtml="<img src='"+ctx+"/verifyKey/verifyKey"+(imageNumber-1)+".jpg' id='Image'  style='cursor:hand'; alt='看不清，换一张'/>";
	$("#verifyImage").empty();
	$.ajax({
		  type: "POST", 
		  async: false,
		  cache: false,
		 url: ctx+"/changeImage.do?imageNumber="+imageNumber+"",
		  success : function(returnData){		  		
		  	$("#verifyImage").append(textHtml);			  
		  },
		  error : function(){
			alert('系统繁忙!');
		  }
	});	
	imageNumber++;
}

//提交验证flag
var verifyFlag=false;
var emailFlag=false;
var mmFlag=false;
var mm1Flag=false;
var accountFlag=false;
var checkFlag=false;

//CharMode函数   
//测试某个字符是属于哪一类.  
$(function () {  
    function CharMode(iN) {  
        if (iN >= 48 && iN <= 57) //数字   
            return 1;  
        if (iN >= 65 && iN <= 90) //大写字母   
			return 2;  
        if (iN >= 97 && iN <= 122) //小写   
            return 4;  
        else  
			return 8; //特殊字符   
    }  
    //bitTotal函数   
    //计算出当前密码当中一共有多少种模式   
    function bitTotal(num) {  
        modes = 0;  
        for (i = 0; i < 4; i++) {  
		if (num & 1) modes++;  
            num >>>= 1;  
        }  
        return modes;  
		}  
    //checkStrong函数   
    //返回密码的强度级别   
    function checkStrong(sPW) {  
        Modes = 0; //输入的字符种类有几种如：a1两种aA_d三种  
        for (i = 0; i < sPW.length; i++) {  
           //测试每一个字符的类别并统计一共有多少种模式.   
            Modes |= CharMode(sPW.charCodeAt(i));  
        }  
        Modes = bitTotal(Modes); //由几种字符组成  
        var pwdLength = sPW.length; //密码长度  
        var level = 0; //密码强度级别  
        if (pwdLength < 8 && Modes <= 2)  
            level = 0;  
        if ((pwdLength < 10 && Modes >= 3) || (pwdLength >= 8 && Modes == 2))  
            level = 1;  
        if (pwdLength >= 10 && Modes >= 3)  
           level = 2;  
		   return level;  
    }  
    //pwStrength函数   
	//根据pwd强度改变css样式  
    function pwStrength(pwd) {  
        var $strength_L = $("#pwd_strength");  
        if (pwd == null || pwd == '') {  
            Lcolor = Mcolor = Hcolor = O_color;  
        }else {  
            $strength_L.removeClass("security3");  
            $strength_L.removeClass("security2");  
            $strength_L.removeClass("security1");  
			S_level = checkStrong(pwd);  
            switch (S_level) {  
                case 0: //低  
                   $strength_L.addClass("forgotpassword02_text03_1");  
                   break;  
               case 1: //中  
                   $strength_L.addClass("forgotpassword02_text03_2");  
                    break;  
				case 2: //高  
                   $strength_L.addClass("forgotpassword02_text03_3");  
                    break;  
                default:  
                    $strength_L.addClass("forgotpassword02_text03");  
           }  
        }  
        return;  
    }  
  
    //pwd事件触发：当用户放开键盘或密码输入框失去焦点时,根据不同的级别显示不同的颜色   
    $("#userpwd").keyup(function () {  
       pwStrength(this.value);  
       $("#pwd_strength").show();
       $('#zcyc2').hide();
   })  
   //失去光标事件  
   $("#userpwd").blur(function () {  
       pwStrength(this.value);  
    })
    //阅读协议
    $("#read").click(function(){    	
    	if($(this).attr("checked")){
    	    checkFlag=true;
    	    if(verifyFlag==true&&emailFlag==true&&mm1Flag==true&&accountFlag==true){
    	        
    	    	$("#agreeRegister").removeAttr("disabled");
    			$("#agreeRegister").css({cursor:"pointer"});
    	    }    		
    	}else{
    	     
    		$("#agreeRegister").attr("disabled","true");
    		$("#agreeRegister").css({cursor:"text"});
    		checkFlag=false;
    	}
    })
      
}) 



//协议弹出与隐藏
   function chgb(){	
   	if(document.getElementById("szd").style.display=="none"){		
	   document.getElementById("szd").style.display="block"	
	}else{
		
	   document.getElementById("szd").style.display="none";	
	}
 }




























