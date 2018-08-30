//打开资讯也读页面
//op传来的路径 '/News!show.do?news.id='
//title  标题

//订单审核字段 orderState
function showNews(op,id,title){ 
    alert('showNews(op,id,title)');
	var url = ctx+op+id;
	window.parent.addTab(title,url);
}
//打开我的订单
function showOrder(){
	var roleCode = $("#roleCode").val();
	var flowState = 0;
	
	if(roleCode == 'buyer'){
		flowState = 0;	
	}
	//管理员
	if(roleCode == 'operator' || roleCode == 'admin'){
		flowState = 1;
	}
	if(roleCode == 'supplier'){
		flowState = 2;
	}
	var url = ctx+'/Order!list.do?order.flowState='+flowState;
	window.parent.addTab('我的订单',url,'N');
}
//打开我的订单
function showDealOrder(){
	var roleCode = $("#roleCode").val();
	var flowState = 0;
	var title = '';
	if(roleCode == 'supplier'){
		flowState = 3;
		title = '今日送货箱';
	}
	if(roleCode == 'buyer'){
		flowState = 4;	
		title = '今日收货箱';
	}
	var url = ctx+'/Order!list.do?order.flowState='+flowState;
	window.parent.addTab(title,url);
}