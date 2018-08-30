
$(document).ready(function(){
  vipCountJson();//回调查询商品的方法
  saleReturnJson();
});



//删除收藏商品
function deletefavorites(id){
	if(id!=''){
		if (confirm("您确定要删除吗?")){
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/deleteFavorites.do",
			  data: "favorite.id="+id,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("删除成功！");
						window.location.reload();
					}else if(returnDatas=='false'){
						alert("删除失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});
		}
	}
}

//批量删除
function deleteAll(){
	var idStr=$('#favoriteIdStr').val();
	if(idStr!=''){
		if (confirm("您确定要删除吗?")){
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/deleteFavorites.do",
			  data: "favorite.id="+idStr,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("删除成功！");
						window.location.reload();
					}else if(returnDatas=='false'){
						alert("删除失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});
		}
	}else{
		alert('请选择数据，再进行批量删除操作！');
		return;
	}
}	

//复选框全选
function check(field) {  
	var str='';
    var roomids = document.getElementsByName(field);  
    for (var j = 0; j < roomids.length; j++) {  
        if (roomids.item(j).checked == false) {  
            roomids.item(j).checked = true; 
            str +=roomids.item(j).value+','; 
            $('#favoriteIdStr').val(str);
        } else{
            roomids.item(j).checked = false; 
            $('#favoriteIdStr').val('');
        } 
    }  
}

function vipCountJson(){   
	var time=$('#createTime').val()
	var state=$('#state').val(); 
	var url=ctx+"/vipCountJson.do?1=1"; 
	if(time!=''){ 
		url +="&vipCoupon.data="+time;
	}
	if(state!=''){ 
		url +="&vipCoupon.state="+state;
	}
	var htmlText=""; 
	$('#table1').empty();
	$.ajax({   
			type: "POST",
			async: false,
			cache: false,
			url: url,
			success : function(returnData){    
				rows=eval(returnData).rows;
				htmlText+="<table width='962' border='0' cellspacing='0' cellpadding='0' align='center'>";
				for(i=0;i<rows.length;i++){ 
					var vipCount=rows[i];
					htmlText+="<tr><td width='100' height='45' align='center' valign='middle' class='leftborder'>"+vipCount.code+"</td>";
//					htmlText+="<td width='150' align='center' valign='middle'>";
//					if(vipCount.types=='1'){
//						htmlText+="限品类券";
//					}
//					if(vipCount.types=='2'){
//						htmlText+="不限品类券";
//					}
//					htmlText+="</td>";
					htmlText+="<td width='150' align='center' valign='middle'>"+vipCount.name+"</td>";
					htmlText+="<td width='150' align='center' valign='middle'><span class='font'>¥</span>"+vipCount.money+"</td>";
					htmlText+="<td width='120' align='center' valign='middle'><span class='font'>¥</span>"+vipCount.minBuy+"</td>";
					htmlText+="<td width='220' align='center' valign='middle'>"+vipCount.endTime+"</td>";
//					htmlText+="<td width='282' align='left' valign='middle'>";
//					if(vipCount.types=='1'){
//						htmlText+="限部分商品";
//					}
//					if(vipCount.types=='2'){
//						htmlText+="不限商品";
//					}
//					htmlText+="</td>";
				}
				htmlText+="</table>"; 
				$('#table1').append(htmlText);	
			},
			error : function(){
				alert('系统错误!');
			}
		});
}

//修改我的信息页面中省市Jsion数据
function selectCity(obj,id,ibc){ 
	var areaId = $(obj).val();
	var checkText=$(obj).find("option:selected").text();
	$('#selectTest'+ibc).html(checkText);  
	var url=ctx+"/selectCityJson.do?area.parentId="+areaId;
	var htmlText=""; 
	if(id!=''){
		$.ajax({   
				type: "POST",
				async: false,
				cache: false,
				url: url,
				success : function(returnData){ 
					$("#"+id).empty(); 
					rows=eval(returnData).rows;
					htmlText+="<option value=''></option>";
					for(i=0;i<rows.length;i++){ 
						var city=rows[i];
						htmlText+="<option value='"+city.id+"'>"+city.name+"</option>";
						
					}
					$("#"+id).append(htmlText);	 
				},
				error : function(){
					alert('系统错误!');
				}
			});
	}	
}
//复制上面的
function selectCity2(obj,id,ibc){ 
	var areaId = $(obj).val();
	var checkText=$(obj).find("option:selected").text();
	$('#selectTests'+ibc).html(checkText);  

	var url=ctx+"/selectCityJson.do?area.parentId="+areaId;
	var htmlText=""; 
	if(id!=''){
		$.ajax({   
				type: "POST",
				async: false,
				cache: false,
				url: url,
				success : function(returnData){ 
					$("#"+id).empty(); 
					rows=eval(returnData).rows;
					htmlText+="<option value=''></option>";
					for(i=0;i<rows.length;i++){ 
						var city=rows[i];
						htmlText+="<option value='"+city.id+"'>"+city.name+"</option>";
						
					}
					$("#"+id).append(htmlText);	 
				},
				error : function(){
					alert('系统错误!');
				}
			});
	}	
}


function checkForm(){ 
	var emailObj=$('#email').val();
	var mobileObj=$('#mobile').val();
	if(emailObj==''){
		alert('请输入电子邮箱！');
		emailObj.focus();
		return false;
	}	
	if(mobileObj==''){
		alert('请输入手机号码！');
		mobileObj.focus();
		return false;
	}
	
	return true;
}
function checkmobile()
{
	var mobileObj = $('#mobile');
	if(isMobileExisted())
	{
		alert("手机号码已经存在!");
		mobileObj.focus();
		return false;
	}
	return true;
}

//根据账号，判断手机号码是否已存在
function isMobileExisted(){
	var flag = true;
	var mobile = $("#mobile").val();
	if(''==mobile){
		flag = false;
	}else{
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/customers!checkMobileIsExists.do",
			  data: "?customer.mobile=" + mobile,
			  success : function(returnData){
					if(returnData == 'true'){
						flag = true;
					}else{
						flag = false;
					}
				},
				error : function(){
					alert('Check whether the account is exists failure!');
					flag = true;
			 	} 
		});	
	}
	return flag;
}
function checkSex(value){
	var sex=$('#sex').val();
	if(sex==''){
		$('#sex').val(value);
	}else{
		$('#sex').val('');
		$('#sex').val(value);
	}
}

//提交表单
function saveSubmitForm(){
	if(!checkForm()){
		return false;
	}else{
		var sexs = $('#sex').val(); 
		var sex='';
		if(sexs==''){
			alert('性别不能为空！');
			return false;
		}
		if(sexs != ''){
			sex=sexs;
		}
		var id=$('#id').val();
		var url="customer.id="+id;
		if(sex!=''){
			url+="&customer.sex="+sex;
		}
		var emailObj=$('#email').val();
		if(emailObj!=''){
			url+="&customer.email="+emailObj;
		}
		var mobileObj=$('#mobile').val();
		if(mobileObj!=''){
			url+="&customer.mobile="+mobileObj;
		}
		var schooling=$('#schooling').val();
		if(schooling!='' && schooling!=null){
			url+="&customer.schooling="+schooling;
		}
		var maritalstatus=$('#maritalstatus').val();
		if(maritalstatus!='' && maritalstatus!=null){
			url+="&customer.maritalstatus="+maritalstatus;
		}
		var salary=$('#salary').val();
		if(salary!='' && salary!=null){
			url+="&customer.salary="+salary;
		}
		if($('#customerName').val()!=''){
			url+="&customer.name="+$('#customerName').val();
		}
		
		var arearName='';
		var selectTest0=$('#address1').val();
		var selectTest1=$('#address2').val();
		var selectTest2=$('#address3').val();
		 
		if(selectTest0!='' && selectTest0!='请选择'){
			arearName +=selectTest0+'-';
		}
		if(selectTest1!='' && selectTest1!='请选择'){
			arearName +=selectTest1+'-';
		}
		if(selectTest2!='' && selectTest2!='请选择'){
			arearName +=selectTest2+'-';
		}

		if(arearName!=''){
			url+="&customer.areaNames="+arearName;
		}
		if($('#street').val()!=''){
			url+="&customer.street="+$('#street').val();
		}
		
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/customerSave.do",
			  data : url,
			  success : function(returnDatas){
					if(returnDatas == 'true'){
						alert("保存成功！");
						window.location.reload();
					}else if(returnDatas=='false'){
						alert("保存失败！");
					}
				},
				error : function(){
					alert('系统有误');
			 	} 
			});



	}
}

//显示修改头像层
function xgtx(){
	$('#xgtx_td').show();
	$('#xgtx_td1').show();
}

function xgtx2(){
	$('#xgtx_td').hide();
	$('#xgtx_td1').hide();
}

function add_personlayer(id){
	if(id!=''){
		var url=ctx+'/selectAdddress.do?customerAddress.id='+id;
			$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'false'){
					alert('系统错误！');
					return;
				}else{
					var str = returnData;
			  		var arr = new Array();
			  		var vipcodes="";
					arr = str.split(",");
					if(arr.length > 1){
						var id = arr[0];
						var nameObj=arr[1];
						var selectTest0=arr[2];
						var selectTest1=arr[3];
						var selectTest2=arr[4];
						var street=arr[5];
						var zipCodeObj=arr[6];
						var mobile=arr[7];
					}
						$('#addressId').val(id);
						$('#names').val(nameObj);
						$('#selectTests0').html(selectTest0);
						$('#selectTests1').html(selectTest1);
						$('#selectTests2').html(selectTest2);
						$('#streets').val(street);
						$('#zipCodes').val(zipCodeObj);
						$('#mobiles').val(mobile);
					
					$('#add_personlayer').show();
					$('#add_personlayer2').show();
				}
			},
			error : function(){
				alert('系统错误!');
			}
		});
	}
}

function personlayer1(){
	$('#add_personlayer').hide();
	$('#add_personlayer2').hide();
}

//会员中心客户增加联系地址
function addAddress(){
	var nameObj=$('#name').val();
	var zipCodeObj=$('#zipCode').val();
	var mobileObj=$('#mobile').val();
	var arearName='';
	
	var selectTest0=$('#address1').val();
	var selectTest1=$('#address2').val();
	var selectTest2=$('#address3').val();
	
	if(selectTest0!='' && selectTest0!='请选择'){
		arearName +=selectTest0+'-';
	}
	if(selectTest1!='' && selectTest1!='请选择'){
		arearName +=selectTest1+'-';
	}
	if(selectTest2!='' && selectTest2!='请选择'){
		arearName +=selectTest2+'-';
	}
	if(nameObj==''){
		alert("请输入收件人姓名！");
		nameObj.focus();
		return false;
	}else if(zipCodeObj==''){
		alert("请输入邮政编码！");
		zipCodeObj.focus();
		return false;
	}else if(mobileObj==''){
		alert("请输入手机号码！");
		mobileObj.focus();
		return false;
	}else if(arearName==''){
		alert('请填写详细的收货地址！');
		return false;
	}else{
		var url='customerAddress.name='+nameObj+'&customerAddress.zipCode='+zipCodeObj+'&customerAddress.mobile='+mobileObj+'&customerAddress.address='+arearName;
		var street=$('#street').val();
		if(street!=null){
			url +='&customerAddress.street='+street;
		}
		
//		alert(url);
		$.ajax({ 
		url : ctx+'/saveAddress.do',
		data : url,
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				window.location.reload();
			}else if(returnData == 'error'){
				alert('您已保存有10个地址，不能再继续保存！');
				return false;
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('System error,Registered Failed!');
		}
	});
	}
}
//复制上面的，修改收货地址
function updatemyAddress(){
	var nameObj=$('#names').val();
	var zipCodeObj=$('#zipCodes').val();
	var mobileObj=$('#mobiles').val();
	var arearName='';
	
	var selectTest0=$('#address1').val();
	var selectTest1=$('#address2').val();
	var selectTest2=$('#address3').val();
	
	if(selectTest0!='' && selectTest0!='请选择'){
		arearName +=selectTest0+'-';
	}
	if(selectTest1!='' && selectTest1!='请选择'){
		arearName +=selectTest1+'-';
	}
	if(selectTest2!='' && selectTest2!='请选择'){
		arearName +=selectTest2+'-';
	}
	if(nameObj==''){
		alert("请输入收件人姓名！");
		nameObj.focus();
		return false;
	}else if(zipCodeObj==''){
		alert("请输入邮政编码！");
		zipCodeObj.focus();
		return false;
	}else if(mobileObj==''){
		alert("请输入手机号码！");
		mobileObj.focus();
		return false;
	}else if(arearName==''){
		alert('请填写详细的收货地址！');
		return false;
	}else{
		var id=$('#addressId').val();  
		var url='customerAddress.id='+id+'&customerAddress.name='+nameObj+'&customerAddress.zipCode='+zipCodeObj+'&customerAddress.mobile='+mobileObj+'&customerAddress.address='+arearName;	
		var street=$('#streets').val();
		if(street!=null){
			url +='&customerAddress.street='+street;
		}
		
		$.ajax({ 
		url : ctx+'/saveAddress.do',
		data : url,
		async: false,
		cache: false,
		type : 'POST', 
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				window.location.reload();
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('System error,Registered Failed!');
		}
	});
	}
}



//设置默认收货地址
function updateAddress(id){
	if (confirm("您确定要设此地址为默认收货地址吗?")){
		var url=ctx+'/updateAddress.do?customerAddress.id='+id+'&customerAddress.isDefault=0';
			$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'true'){
					alert('保存成功!');
					window.location.reload();
				}else{
					alert('保存失败!');
				}
			},
			error : function(){
				alert('System error,Registered Failed!');
			}
		});
	}
}

//删除收货地址
function delAddress(id){
	if (confirm("您确定要删除此地址吗?")){
		var url=ctx+'/deleteAddress.do?customerAddress.id='+id;
			$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功!');
					window.location.reload();
				}else{
					alert('删除失败!');
				}
			},
			error : function(){
				alert('System error,Registered Failed!');
			}
		});
	}
}
//验证旧密码是否正确
function checkOldPwd(value){
	var idObj=$('#id').val();
	var url=ctx+'/isPwdRightInput.do?customer.id='+idObj+'&customer.pwd='+value;
			$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'false'){
					alert('旧密码输入不正确，请重新输入!');
					$('#pwd').val('');
				}
			},
			error : function(){
				alert('System error,Registered Failed!');
			}
		});
}

//保存密码
function saveModifierPwd(){
	var idObj=$('#id').val();
	var pwdObj=$('#pwd').val();
	var newpwdObj=$('#newpwd').val();
	var newpwd2Obj=$('#newpwd2').val();
	if(pwdObj==''){
		alert('请输入旧密码！');
		return;
	}else if(newpwdObj==''){
		alert('请输入新密码！');
		return;
	}else if(newpwd2Obj==''){
		alert('请确认密码！');
		return;
	}else if(newpwd2Obj!=newpwdObj){
		alert('两次输入密码不正确，请重新输入！');
		return;
	}else{
		var url=ctx+'/saveModifierPwds.do?customer.id='+idObj+'&customer.newPwd='+newpwdObj;
			$.ajax({ 
			url : url,
			async: false,
			cache: false,
			type : 'POST', 
			success : function(returnData){ 
				if(returnData == 'true'){
					alert('修改成功!');
//					window.open('');
					window.parent.location.href=ctx+'/passwordSuccess.do';
				}else{
					alert('修改失败!');
				}
			},
			error : function(){
				alert('System error,Registered Failed!');
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

//	验证修改数量
function checkNumber(obj){ 
	var reg =  /^\d+$/;
	if(obj!="" && !reg.test(obj)){
		return false;
    }
    return true;
}

//保存退换货申请
function saveApplication(){
	if (confirm("您确定要进行此操作吗?")){
		//订单id
		var saleorderid=$('#saleorderid').val();
		//原因
		var returnContent=$('#returnContent').val();
		//期望处理方式
		var returntype=getRedio("returntype");
		//期望商品返回方式
 		var returngoodtype=getRedio("returngoodtype");
 		//收货地址
 		var returnAddress=getRedio("returnAddress");
 		//附件，商品清单
 		var introDelivery=getRedio("introDelivery");
 		
 		if(returnContent==null){
 			if(returntype=='0'){
 				alert('请输入返修原因！');
 				return false;
 			}else if(returntype=='1'){
 				alert('请输入换货原因！');
 				return false;
 			}else if(returntype=='2'){
 				alert('请输入退货原因！');
 				return false;
 			}
 		}
 		
 		var url="saleReturn.orderId="+saleorderid+"&saleReturn.returnContent="+returnContent+"&saleReturn.returntype="+returntype+"&saleReturn.returngoodtype="+returngoodtype+"&saleReturn.introDelivery="+introDelivery;
 		if(returnAddress=='0'){
 			url += "&saleReturn.returnAddress="+returnAddress;
 		}else{
 			var arearName='';
			var selectTest0=$('#selectTest0').html();
			var selectTest1=$('#selectTest1').html();
			var selectTest2=$('#selectTest2').html(); 
			if(selectTest0!=''){
				arearName += selectTest0+'-';
			}
			if(selectTest1!=''){
				arearName += selectTest1+'-';
			}
			if(selectTest2!=''){
				arearName += selectTest2+'-';
			}
			
			url += "&saleReturn.deliveryAddress="+arearName;
			
			var street=$('#street').val();
			if(street==''){
				alert('街道地址不能空！');
				return false;
			}else{
				url += "&saleReturn.street="+street;
			}
 		}
 		
 		var size=$('#size').val();
 		var wareId='';
 		var number='';  
 		for(i=0;i<size;i++){  
 			var goodId = $("#id"+i).val();			// 获取商品Id
 			var count = $("#count"+i).html();
 			if(goodId!=''){
 				wareId += goodId+',';
 			}
 			if(count!=''){
 				number += count+',';
 			}
 		}
 		
 		if(wareId != ''){
 			url +="&saleReturn.wareId="+wareId;
 		}
 		if(number != ''){
 			url +="&saleReturn.number="+number;
 		}
 		//附件清单
		var chk = document.getElementById("checkbox");
		var reValue='';
		if(chk){                   
			if(chk.checked=='true'){                         
				url +="&saleReturn.isinvoice=1";                           
			}else{
				url +="&saleReturn.isinvoice=0"; 
			}                 
		}   
 	
 		$.ajax({
				type: "POST",
			  	async: false,
			  	cache: false,
			  	url: ctx+"/saveApplication.do",
			  	data:url,
			  	success : function(returnData){ 
					if(returnData=='true'){
						alert("提交成功");
						window.location.reload();
					}
				},
				error : function(){
					alert('系统错误，请联系管理员!');
			 	}
			});
 		
 		
 		
	}
}

//修改返退商品数量
function changeNum(obj,i){
	//订单id
	var saleorderid=$('#saleorderid').val();
	var count = $("#count"+i).html();
	if(obj=='1'&&count>1){
		count=Number(count)-1;
	}	
	if(obj=='2'){
		count=Number(count)+1;
	}
	if(checkNumber(count)){
		goodId = $("#id"+i).val();			// 获取商品Id
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/changeReturnNumber.do?goodId="+goodId+"&count="+count+"&saleorderid="+saleorderid,
		  success : function(returnData){
				if(returnData=='true'){
					$("#count"+i).html(count);
//					recount(obj);
				}else if(returnData=='false'){
					alert('输入数量大于购买数量，输入有误！');
					return false;
				}
			}
		});
		recount();
	}else{
		alert("请输入合理数字!");
		$("#count"+i).val('1');
	}
}







































