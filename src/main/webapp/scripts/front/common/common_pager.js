$(document).ready(function(){
	var pageIndex = $('#pageIndex').val();
	init(pageIndex);
});
/**
 * 分页
 * 默认加载
 * @param {Object} pagenumber
 */
function init(pagenumber){
	var pagecount = $("#pageCount").val();//总页数
	var totalcount = $("#count").val();//记录数

//	var pagecount = 5;//总页数
//	var totalcount = 15;//记录数
	var data = {'pagecount':pagecount,'totalcount':totalcount};
	//alert('pagenumber:==='+pagenumber +'  ,pagecount==='+pagecount +',  totalcount==='+totalcount  );
	//顶部分页
	//$("#pagerTop").pager({ pagenumber: pagenumber, pagecount:data.pagecount,totalcount:data.totalcount, buttonClickCallback: PageClick});
	//底部分页
	$("#pagerBot").pager({ 
		pagenumber: pagenumber, 
		pagecount:data.pagecount,
		totalcount:data.totalcount, 
		buttonClickCallback: PageClick
	});
}

function chinkNow(){
	var Now=$('#chinkNows').val();
	var pagecount = $("#pageCount").val();//总页数
	var apptype = $("#apptype").val();
	if(Now>pagecount||Now=='0'||Now==''){
		alert('请输入正确的页数');
		return;
	}else{
		var apptype = $("#apptype").val();
		var url = ctx+"/"+apptype+".do?page="+Now;	
		if(apptype == 'shoptype'){
			var goodTypeId = $("#goodTypeId").val();
			if(goodTypeId !=''){
				url += "&goodType.id="+goodTypeId;
			}
		}
		if(apptype == 'getSecondGoods'){
			var apptypes = $("#apptypes").val();  
			var proptStr=$('#proptStr').val();
			var brandStr=$('#brandStr').val();
			var proptes=$('#proptes').val();
			if(apptypes=='libiao'){
				selectGoods2(proptStr,brandStr,proptes,Now);
			}else{
				selectGoods(proptStr,brandStr,proptes,Now);
			}
			return;
		}
		if(apptype == 'shoptype'){
			var apptypes = $("#apptypes").val();  
			var proptStr=$('#proptStr').val();
			var brandStr=$('#brandStr').val();
			var proptes=$('#proptes').val();
			if(apptypes=='libiao'){
				shoptypeGoods2(proptStr,brandStr,proptes,Now);
			}else{
				shoptypeGoods(proptStr,brandStr,proptes,Now);
			}
			return;
		}
		
		if(apptype == 'goodsdetails'){
			var apptypes = $("#apptypes").val();
			if(apptypes=='wareComment'){
				var type=$('#wareCommenttype').val();
				goodEvaluation(type,Now);
				
			}
			if(apptypes=='getGoodMessage'){
				var type=$('#wareCommenttype').val();
				goodmession(type,Now);
			}
			return;
		}
		window.location.href = url;
	}
}

/**
 * 上一页下一页
 * @param {Object} pageclickednumber
 */
function pageer(pageIndexTo){
	var pagecounts = $("#pageCount").val();//总页数
	var pageIndex = $("#pageIndex").val();	
	if(pageIndexTo=='1') pageIndex--;
	if(pageIndexTo=='2') pageIndex++;
	if(pageIndex>pagecounts||pageIndex=='0'){
		return;
	}
	$('#chinkNows').val(pageIndex);
	chinkNow();
}



/**
 * 回调函数
 * @param {Object} pageclickednumber
 */
PageClick = function(pageclickednumber) {
	init(pageclickednumber);
	var apptype = $("#apptype").val();
	var url = ctx+"/"+apptype+".do?page="+pageclickednumber;
	if(apptype == 'shoptype'){
			var goodTypeId = $("#goodTypeId").val();
			if(goodTypeId !=''){
				url += "&goodType.id="+goodTypeId;
			}
		}
	if(apptype == 'getSecondGoods'){
			var apptypes = $("#apptypes").val();
			var proptStr=$('#proptStr').val();
			var brandStr=$('#brandStr').val();
			var proptes=$('#proptes').val();
			if(apptypes=='libiao'){
				selectGoods2(proptStr,brandStr,proptes,pageclickednumber);
			}else{
				selectGoods(proptStr,brandStr,proptes,pageclickednumber);
			}
			return;
	}
	if(apptype == 'shoptype'){
			var apptypes = $("#apptypes").val();  
			var proptStr=$('#proptStr').val();
			var brandStr=$('#brandStr').val();
			var proptes=$('#proptes').val();
			if(apptypes=='libiao'){
				shoptypeGoods2(proptStr,brandStr,proptes,pageclickednumber);
			}else{
				shoptypeGoods(proptStr,brandStr,proptes,pageclickednumber);
			}
			return;
		}
	if(apptype == 'goodsdetails'){
		var apptypes = $("#apptypes").val();
		if(apptypes=='wareComment'){
			var type=$('#wareCommenttype').val();
			goodEvaluation(type,pageclickednumber);
			
		}
		if(apptypes=='getGoodMessage'){
			var type=$('#wareCommenttype').val();
			goodmession(type,pageclickednumber);
		}
		return;
	}
	
	window.location.href = url;
}