
function showLoginDIV(){
	var goodId=$('#goodId').val();
	//验证登陆
	var checkLogin=validationLogin();
	if(checkLogin=='false'){
		$("#geturl").val('/pingjia.do?good.id='+goodId);
		ShowDiv('MyDiv','fade');
	}
}


//保存评论
function submitSaveComment(){
	var content = $("#content").val();
	var goodId=$("#goodId").val();
	var code=$("#code").val();
	var level;
	var tolTo;

    var str = document.getElementsByName("level");
    var objarray = str.length;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           level = str[i].value;
      }
    }

	if('' == content){
		alert("请输入评论内容！");
		$("#content").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/wareCommentSave.do",
		  data: "wareComment.wareId="+goodId+"&wareComment.code="+code+"&wareComment.content="+content+"&wareComment.level="+level,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					$("#content").val('');
					alert("保存评论成功！");
					tolTo=true;
					window.close();
				}else if(returnDatas=='errorBuy'){
					$("#content").val('');
					document.getElementById("remakeDIV").innerHTML="<font color='red'>您还未购买此商品，请购买后再进行评论。</font>";
					return false;
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}
	

//保存评论
function submitSaveCommentTwo(){
	var content = $("#content").val(); 
	var goodId=$("#wareCommentWareId").val();
	var wareCommentCode=$('#wareCommentCode').val();
	var level;
	var tolTo;

    var str = document.getElementsByName("level");
    var objarray = str.length;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           level = str[i].value;
      }
    }

	if('' == content){
		alert("请输入评论内容！");
		$("#content").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/wareCommentSaveTwo.do",
		  data: "wareComment.wareId="+goodId+"&wareComment.content="+content+"&wareComment.level="+level+"&wareComment.code="+wareCommentCode,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					$("#content").val('');
					alert("保存评论成功！");
					tolTo=true;
					window.close();
				}else if(returnDatas=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}	
	
//保存咨询1
function submitSaveMessge1(){
	var content = $("#messageContent1").val();
	var goodId=$("#goodId").val();
	var type;

    var str = document.getElementsByName("type1");
    var objarray = str.length;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           type = str[i].value;
      }
    }
    
    if(type=='商品咨询'){
    	type=0;
    }else if(type=='配送/支付'){
    	type=1;
    }else if(type=='发票/安装保修'){
    	type=2;
    }

	if('' == content){
		alert("请输入咨询内容！");
		$("#messageContent1").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/messageSave.do",
		  data: "message.goodId="+goodId+"&message.content="+content+"&message.type="+type,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					alert("保存咨询成功！");
					window.location.reload();
					$("#content").val('');
				}else if(returnDatas=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}
	
	//保存咨询2
function submitSaveMessge2(){
	var content = $("#messageContent2").val();
	var goodId=$("#goodId").val();
	var type;

    var str = document.getElementsByName("type2");
    var objarray = str.length;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           type = str[i].value;
      }
    }
    
    if(type=='商品咨询'){
    	type=0;
    }else if(type=='配送/支付'){
    	type=1;
    }else if(type=='发票/安装保修'){
    	type=2;
    }

	if('' == content){
		alert("请输入咨询内容！");
		$("#messageContent2").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/messageSave.do",
		  data: "message.goodId="+goodId+"&message.content="+content+"&message.type="+type,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					alert("保存咨询成功！");
					window.location.reload();
//					$("#messageContent2").val('');
				}else if(returnDatas=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}
	
	
	//保存咨询3
function submitSaveMessge3(){
	var content = $("#messageContent3").val();
	var goodId=$("#goodId").val();
	var type;

    var str = document.getElementsByName("type3");
    var objarray = str.length;//alert(str);return false;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           type = str[i].value;
      }
    }
    
    if(type=='商品咨询'){
    	type=0;
    }else if(type=='配送/支付'){
    	type=1;
    }else if(type=='发票/安装保修'){
    	type=2;
    }

	if('' == content){
		alert("请输入咨询内容！");
		$("#messageContent3").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/messageSave.do",
		  data: "message.goodId="+goodId+"&message.content="+content+"&message.type="+type,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					alert("保存咨询成功！");
					window.location.reload();
//					$("#content").val('');
				}else if(returnDatas=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}
	
//保存咨询4
function submitSaveMessge4(){
	var content = $("#messageContent4").val();
	var goodId=$("#goodId").val();
	var type;

    var str = document.getElementsByName("type4");
    var objarray = str.length;//alert(str);return false;
    for(i=0;i<objarray;i++){
      if(str[i].checked == true){  
           type = str[i].value;
      }
    }
    
    if(type=='商品咨询'){
    	type=0;
    }else if(type=='配送/支付'){
    	type=1;
    }else if(type=='发票/安装保修'){
    	type=2;
    }

	if('' == content){
		alert("请输入咨询内容！");
		$("#messageContent4").focus();
		return false;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/messageSave.do",
		  data: "message.goodId="+goodId+"&message.content="+content+"&message.type="+type,
		  success : function(returnDatas){
				if(returnDatas == 'true'){
					alert("保存咨询成功！");
					window.location.reload();
				}else if(returnDatas=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnDatas=='false'){
					alert("保存失败！");
				}
			},
			error : function(){
				alert('系统有误');
		 	} 
	});
}	

	
//加入收藏
function addGoodToFavorite(goodId){
    // 商品Id
	if(goodId != ''){
		var url = ctx +"/addGoodToFavorite.do?favorite.goodId="+goodId;
		$.ajax({
			type: "POST",
		  	async: false,
		  	cache: false,
		  	url: url,  
		  	success : function(returnData){ 
				if(returnData=='true'){
					alert("收藏成功");
				}else if(returnData=='frontLogin'){
					alert("请先登录");
					window.location.href = ctx+'/frontLogin.do';
				}else if(returnData=='error'){
					alert("您已经收藏过该商品，不用再收藏了！");
					return;
				}else{
					alert('加入收藏失败!');
				}
			},
			error : function(){
				alert('系统错误，加入收藏失败!');
		 	}
		});
	}else{
		alert('你选择的商品不存在 ');
	}
}	

//评价成功则更新数据	
function selTo(url){
	window.open(url);
}
	

	
function myshops(id){  
	if(id=='1'){
		//验证登陆
		var checkLogin=validationLogin();
		if(checkLogin=='false'){
			$("#geturl").val('/customersManage.do');
			ShowDiv('MyDiv','fade');
		}else{
			window.location.href=ctx+"/customersManage.do";
		}
	}
	if(id=='2'){
		//验证登陆
		var checkLogin=validationLogin();
		if(checkLogin=='false'){
			$("#geturl").val('/pingjiaTwo.do');
			ShowDiv('MyDiv','fade');
		}else{
			window.location.href=ctx+"/pingjiaTwo.do";
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	