



//修改邮箱
function updateEmail(){  
	var newEmail=$('#newEmail').val();
	if(newEmail!=''){
		//对电子邮件的验证
	    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	    if(!myreg.test(newEmail)){
	        alert('请输入有效的E_mail！');
	        newEmail.focus();
	        return false;
   		}
   		var url=ctx+'/updateEmail.do?customer.newEmail='+newEmail;
   		$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'true'){
					document.location=ctx+"/sendEmail.do";
				}
			},
			error : function(){
				alert('系统错误!');
			}
		});	
	}else{
		 alert('请输入E_mail！');
		 return false;
	}
}


//验证帐号唯一
	function checkEmail(emailObj){
		var url=ctx+'/checkEmail.do?1=1';
		if(emailObj!=''){
			url +='&customer.email='+emailObj;
		}
		$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'true'){
					alert('已注册过的邮箱！重新填写');
	//				document.getElementById('zcyc2').innerHTML = '已注册过的用户名或邮箱！重新填写';   //js即时改变div内的文字
					return false;  //修改样式
				}
			},
			error : function(){
				alert('系统错误!');
			}
		});
	}



