$(document).ready(function(){
	$('#buildWare').submit(function(){
		submitBuildWare();
		return false; 
	});
});
function submitBuildWare(){
	var options = {
		url : ctx+'/good!buildWare.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'false'){
				alert('生成货品失败!');
			}else{
				window.returnValue = returnData;
				window.close();
			}
		},
		error : function(){
			alert('系统错误!');
		} 
	};
	$('#buildWare').ajaxSubmit(options); 
	return false;
}
//选择规格项
function selectSpecification(){
	url = ctx + '/goodSpecification!list.do?todo=show';
	var dataArr = new Array();
	dataArr = window.showModalDialog(url, '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:500px");
	if(dataArr){
		for(var i=0;i<dataArr.length;i++){
			var id = dataArr[i].id;
			var code = dataArr[i].code;
			var name = dataArr[i].name;
			var html = '<div title="'+name+'" style="padding:10px;">' +
						'<table width="90%"  border="0" cellpadding="0" cellspacing="1" class="gdcn-table-bgcolor">	' +
						'<input type="hidden" id="'+id+'" value="'+id+'"/>' +
						'<tr>' +
						'<td class="gridtitle" style="text-align: left;">请点击下面的值,添加本商品需要的'+name+'</td>' +
						'</tr>' +
						'<tr><td class="gridbody">';
			
			//加载规格值			
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/goodSpecificationVal!getSpecificationVal.do",
			  data: "goodSpecificationVal.goodSpecificationId=" + id,
			  success : function(returnData){ 
					if(returnData == 'false'){
						alert('加载规格值列表错误');
					}else{
						html += returnData;
					}
				},
				error : function(){
					alert('系统错误!');
			 	} 
			});
			html += '</td></tr><tr></tr>' +
					'<tr>' +
					'<td class="gridtitle" style="text-align: left;">已选择的'+name+'</td>' +
					'</tr>' +
					'<tr><td class="gridbody" id="selectValue"><input type="hidden" name="specificationValIdArr" value=""><td>' +
					'</tr></table></div>';
			addTab(name,html);
			closeTab('规格');
		}
		//绑定事件
		$('.specificationVal').bind('click', function() {
		  	selectValue(this);
		});
	}
}

function closeTab(title){
	$('#tabs').tabs('close',title);
}

function addTab(name,html){
	var isExist = $('#tabs').tabs('exists',name);
	if(!isExist){
		$('#tabs').tabs('add',{
			title:name,
			content:html,
			closable:true
		});
	}
}
//选择值
function selectValue(obj){
	var parentObj =$(obj).parent().parent().parent();
	//现在选择的规格值id
	var specificationValId = $(obj).find('input[class="specificationValId"]').val();
	
	//已选择的规格值id
	var valIdStr = $(parentObj).find('td[id="selectValue"]').find('input[name="specificationValIdArr"]').val();
	if(valIdStr.indexOf(specificationValId) >= 0){
		alert('该规格值已选择');
	}else{
		var html = $(parentObj).find('td[id="selectValue"]').html();
		html += "<span><span class='selectVal' style='border:1px solid #8DB2E3;font-size: 18px;'>"+ $(obj).html()+
					"</span><input value='删除' class='deleteVal' style='height:20px;width:40px;' type='button'/>&nbsp;&nbsp;" +
					"<input type='hidden' class='specificationValId' value='"+specificationValId+"'/></span>"
		$(parentObj).find('td[id="selectValue"]').html(html);
		valIdStr += specificationValId + ',';
		$(parentObj).find('td[id="selectValue"]').find('input[name="specificationValIdArr"]').val(valIdStr);
		//绑定事件
		$('.deleteVal').bind('click', function() {
		  	deleteValue(this);
		});
	}
}
//删除值
function deleteValue(obj){
	var parentObj =	$(obj).parent();
	//已选择的规格值id
	var valIdStr = $(obj).parent().parent().find('input[name="specificationValIdArr"]').val();
	//去掉删除值的id
	var specificationValId = $(obj).parent().find('input[class="specificationValId"]').val();
	valIdStr = valIdStr.replace(specificationValId,'');
	$(obj).parent().parent().find('input[name="specificationValIdArr"]').val(valIdStr);
	
	$(parentObj).remove();
}
