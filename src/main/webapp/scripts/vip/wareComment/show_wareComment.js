$(document).ready(function(){
	saveFormRewrite();
});


//重写form的submit方法
function saveFormRewrite(){
	$('#saveForm').submit(function(){
		return submitForm(false);
	});
}
//提交表单
function submitForm(isConfirm){
	//审核时更新数据状态
	var stateObj = $('#state');
	if('s'==stateObj.val()){
			alert('此信息已被审核,无需再次审核!');
			return;
	}
	stateObj.val('s');
	var options = { 
		url : ctx+'/wareComment!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){
			if(returnData == 'true'){
				alert('审核成功');
				window.parent.location.reload();
				window.close();
			}else{
				alert('审核失败');
			}
		},
		error : function(){
			alert('系统错误');
		} 
	};
	$('#saveForm').ajaxSubmit(options); 
	return false; 
}
// 返回
function backtrack(){
	window.parent.location.reload();
	window.close();
}