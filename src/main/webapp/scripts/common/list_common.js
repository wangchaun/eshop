//数据状态格式化，数据状态 c:草稿 s;审核 d:删除
function stateFormatter(value,rowData,rowIndex){
	var state = rowData._state;
	var result = 'Abnormal';
	if('c' == state){
		result = 'Draft';z
	}else if('s' == state){
		result = 'Audited';
	}else if('d' == state){
		result = 'Deleted';
	}
	return result;
}	

//获取分页区域参数
function getPagerOpt(){
	var option = {
		displayMsg:'共{total}条记录,当前显示第{from}至{to}条记录',
	   	onBeforeRefresh:function(pageNumber, pageSize){
	    		$(this).pagination('loading');
	    		//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
	    		$(this).pagination('loaded');
	    }		
	};
	return option;
}

//获取列表数据加载提示
function getLoadMsg(){
	return '数据装载中......';
}

