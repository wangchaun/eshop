//用json包装的公共方法
var common = {
	//根据角色id，获取一个角色json对象
	getSysRoleById: function(id){
		var sysRole;
			$.ajax({
				  type: "POST",
				  async: false,
				  cache: false,
				  url: ctx+"/SysRole_json!getSysRoleJson.do",
				  data: "sysRole.id="+id,
				  success : function(returnData){
						sysRole = returnData.data;
					},
					error : function(){
						alert('获取角色资料失败!');
						flag = true;
				 	} 
			});		
		return sysRole;	
	},
	//获取仓库
	getWarehouse:function(){
		var data;
		var url = ctx+"/warehouse!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('只能选择一个仓库！');
			}else{
				data = dataArr[0];
			}
		}
		return data;
	},
	//获取仓位
	getWarehousePosition:function(){
		var data;
		var warehouseId=$('#warehouseId').val();
		var url = ctx+"/warehousePosition!list.do?todo=show&warehousePosition.warehouseId="+warehouseId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('只能选择一个仓位！');
			}else{
				data = dataArr[0];
			}
		}
		return data;
	},
	//获取供应商
	getSupplier:function(){
		var data;
		var url = ctx+"/supplier!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('只能选择一个供应商！');
			}else{
				data = dataArr[0];
			}
		}
		return data;
	},
	//获取客户
	getCustomer:function(){
		var data;
		var url = ctx+"/customers!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('只能选择一个客户!');
			}else{
				data = dataArr[0];
			}
		}
		return data;
	},
	//根据类型，获取系统用户
	getSysUser:function(roleCode){
		var data;
	
		var url = ctx+"/SysUser!list.do?todo=show&sysUser.roleCode="+roleCode;
		
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			var len = dataArr.length;
			if(len>1){
				alert('最多只能选择一个');
			}else{
				data = dataArr[0];
			}
		}
		return data;
	},
	
	
	//选择商品  ,more表示能否选择多个
	getGoods:function(more){
		var data;
		var url = ctx+"/good!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('最多只能选择一个');
				}else{
					data = dataArr[0];
				}			
			}
		}		
		return data;		
	},
	
	//选择货品  ,more表示能否选择多个
	getWare:function(more){
		var data;
		var url = ctx+"/ware!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('最多只能选择一个');
				}else{
					data = dataArr[0];
				}			
			}
		}		
		return data;		
	},
	//选择仓库货品  ,more表示能否选择多个
	getWarehouseWare:function(more,warehouseId){
		var data;
		var url = ctx+"/warehouseWare!list.do?todo=show&warehouseWare.warehouseId="+warehouseId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('最多只能选择一个');
				}else{
					data = dataArr[0];
				}			
			}
		}		
		return data;		
	},
	
	//选择销售出货单  ,more表示能否选择多个
	//显示还没有完全收款的订单
	getSaleDelivery:function(more,customerId){
		var data;
		var url = ctx+"/saleDelivery!list.do?todo=show&saleDelivery.paymentState=1&saleDelivery.customerId="+customerId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('最多只能选择一个');
				}else{
					data = dataArr[0];
				}			
			}
		}		
		return data;		
	},
	
	//选择采购收货单  ,more表示能否选择多个
	//显示还没有完全付款的订单
	getBuyInto:function(more,supplierId){
		var data;
		var url = ctx+"/buyInto!list.do?todo=show&buyInto.paymentState=1&buyInto.supplierId="+supplierId;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('最多只能选择一个');
				}else{
					data = dataArr[0];
				}			
			}
		}		
		return data;		
	},
	
	//根据商品编码，获取一个商品的json对象
	getOneGoodByCode:function(code){
		var goodJson;
		if(code && ''!=code){
			$.ajax({
				  type: "POST",
				  async: false,
				  cache: false,
				  url: ctx+"/Goods_json!getOneGood.do",
				  data: "goods.code="+code,
				  success : function(returnData){ 
				  		var data = returnData.data;
						if(data){
							goodJson = data;
						}
					},
					error : function(){
						alert('根据商品编码，获取一个商品的json对象失败!');
				 	} 
			});			
		}
		return goodJson;
	},
	//获取地区信息
	getArea:function(){
		var dataArr = window.showModalDialog(ctx+"/area!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr){
			return dataArr;
		}
	},
	//验证只能为数字 
	checkNumber:function(obj){  
	    var reg = /^[0-9]+(\.[0-9]+)?$/; 
	    if(obj.value!=""&&!reg.test(obj.value)){  
	        alert('非法字符，只能输入数字和小数点');  
	        $(obj).val('');
			$(obj).focus(); 
	        return false;  
	    }  
	},
	//验证只能为正整数
	number:function(obj){  
	    var reg = /^[0-9]*[1-9][0-9]*$/ ; 
	    if(obj.value!=""&&!reg.test(obj.value)){  
	        alert('非法字符,只能输入正整数');  
	        $(obj).val('');
			$(obj).focus(); 
	        return false;  
	    }  
	},
	//验证邮件格式
	checkIsEmail:function(obj){
		var email = $(obj).val();
		//对电子邮件的验证
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!myreg.test(email)){
			alert('邮箱地址格式不正确');
			$(obj).val('');
			$(obj).focus();
			return false;
		}
		return true;
	},
	//验证手机格式
	checkIsMobile:function(obj){
		var mobile = $(obj).val();
		//^[1]\d{10}$/
	    var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	   /** if(!reg.test(mobile))
	    {
	    	alert('手机号码格式不正确');
	    	$(obj).val('');
			$(obj).focus();
	        return false;
	    }*/
	    
	    if(mobile.search(reg) == -1){
	    	alert('手机号码格式不正确');
	    	$(obj).val('');
			$(obj).focus();
	        return false;
	    }
	    return true;
	},
	//验证固话格式
	checkIsTelephone:function(obj){
		var telephone = $(obj).val();
	    var reg = /^\d{3}-\d{8}|^\d{4}-\d{7}/;
	    if(!reg.test(telephone))
	    {
	    	alert('固定电话号码格式不正确');
	    	$(obj).val('');
			$(obj).focus();
	        return false;
	    }
	    return true;
	},
	//日期验证
	checkDateFormat:function(dateData){
		var reg = /^\d{4}-((0{0,1}[1-9]{1})|(1[0-2]{1}))-((0{0,1}[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))$/;  
		if(!reg.test(dateData)){
			return false;
		}
		return true;
	},
	//邮编验证--中国
	checkPostCodeFormat:function(obj){
		var postCode = $(obj).val(); 
		var reg = /[1-9]\d{5}(?!\d)/;
		if(!reg.test(postCode)){
			alert('邮编格式不正确');
			$(obj).val('');
			$(obj).focus();
			return false;
		}
		return true;
	},
	//传真验证
	checkFaxFormat:function(fax){
		var reg = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
		if(!reg.test(fax)){
			return false;
		}
		return true;
	},
	//验证网址
	checkUrlFormat:function(website){
		var regExp = /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/;
		if(!regExp.test(website)){
			return false;
		}
		return true;
	},
	getlistDictionaryItem:function(more,code){
		var data;
		var url = ctx+"/DictionaryItem!list.do?todo=show&dictionary.code="+code;
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('只能选择一个费用名称！');
				}else{
					data = dataArr[0];
				}
			}
		}
		return data;
	},
	getlistBlank:function(more){
		var data;
		var url = ctx+"/bankAccount!list.do?todo=show";
		var dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
		if(dataArr && dataArr.length){
			if(more){
				data = dataArr;
			}else{
				var len = dataArr.length;
				if(len>1){
					alert('只能选择一个费用名称！');
				}else{
					data = dataArr[0];
				}
			}
		}
		return data;
	}
};