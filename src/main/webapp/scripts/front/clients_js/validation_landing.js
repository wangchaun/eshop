/*
	*前台验证登陆
	*ly
	*2013-1-26 14:28:35
	*立即购买需要验证登陆，已经登录则跳回原页面，未登录则跳到注册页面
*/
function validationLogin(){
var value="";
	var url=ctx+"/validationLogin.do"
	$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,
		  	success : function(returnData){
		  		value=returnData;
			},
			error : function(){
				alert('系统错误!');
		 	}
	});
	return value;
}

