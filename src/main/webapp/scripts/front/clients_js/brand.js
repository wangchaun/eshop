function secBoard(obj,brandTypeId,first){
	if(!obj==''){
		$("[id=menu]").each(function(){
			$(this).attr("class","");
		});
		obj.className="hover";
	}
	var typeId;
	if(first==''){
		typeId=brandTypeId;
		$("#brandTypeId").val(brandTypeId);
		$("#first").html("#");
	}else{
		typeId=$("#brandTypeId").val();	
		$("#first").html(first);	
	}
	var url=ctx+"/brand_json.do?brandTypeId="+typeId+"&first="+first;
	url = encodeURI(encodeURI(url));
	var htmlText="";
	$.ajax({
		type: "POST",
		async: false,
		cache: false,
		url: url,
		success : function(returnData){
			var brands=eval(returnData).rows;
			for(i=0;i<brands.length;i++){
				brand=brands[i];
				htmlText+="<li><a href='"+ ctx +"/shoptype.do?good.brandId="+ brand.id +"'><img src='"+ctx+brand.pic+"' border='0' /></a></li>";
			}
			$("#brands").html(htmlText);
		},
		error : function(){
			alert('系统错误!');
		}
	});	
}

function changeDiv(tag,method){
	document.getElementById(tag).style.display = method;
}