$(document).ready(function(){ 
	$('#selectData').focus();
	rewriteSaveForm();
});

//重写saveForm
function rewriteSaveForm(){
	$('#saveForm').submit(function(){
		return submitForm();
	});
}
//表单提交
function submitForm(){
	var options = { 
		url : ctx+'/SysRolePower!save.do',
		async: false,
		cache: false,
		type : 'POST', 
		//timeout : 10000,
		success : function(returnData){ 
			if(returnData == 'true'){
				alert('保存成功!');
				//parent.closePopWindow();
				//parent.reloadDataGrid();
			}else{
				alert('保存失败!');
			}
		},
		error : function(){
			alert('System error,保存失败!');
		} 
	};
	$('#saveForm').ajaxSubmit(options);
return false;
}
/**
 * 删除
 */
function deleteData(obj){
	$(obj).parent().parent().parent().remove();
}

//权限列表弹出框
function showPowerList(){
	var dataArr = window.showModalDialog(ctx+"/SysPower!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr && dataArr.length){
		$(dataArr).each(function(){
			showOnePower(this);
		});
	}	
}

//显示一个权限
function showOnePower(data){
	var powerId = data.id;
	var powerName = data.name;
	//alert(powerId+'|' +powerName);
	
	var listObj = $('#sysRolePowerList');
	
	var existPowerIdArr =listObj.find('input[type=hidden][name=powerIdArr]');
	
	var isExist = false;//记录是否已存在
	if(existPowerIdArr && existPowerIdArr.length>0){
		var isExist = false;
		$(existPowerIdArr).each(function(){
			var obj = $(this);
			if(powerId==obj.val()){
				isExist = true;
				return;
			}
		})
	}	
	
	if(isExist){
		alert(powerName+'is aready exists,Please re-select!');
	}else{
		var html = '<tr>' 
				 + '<td>'
				 + powerName+'&nbsp;<input type="hidden" name="powerIdArr" value="'+powerId+'" />'
				 + '</td>'
				 + '<td>增加:<select name="inserts" ><option  value="0">未赋予</option><option  value="1">赋予</option></select>删除:<select name="deletes" ><option  value="0">未赋予</option><option  value="1">赋予</option></select><br/>查读:<select name="selects" ><option  value="0">未赋予</option><option  value="1">赋予</option></select>修改:<select name="updates" ><option  value="0">未赋予</option><option  value="1">赋予</option></select></td>'
				 +'<td><a href="javascript:void(0)" ><span onclick="deleteData(this)">删除</span></a></td>'
				 + '</tr>';
				
		listObj.append(html);			
	}
}
//全选
function selectAll()
{
	$("#saveForm input[type=checkbox]").each(function(){
		$(this).attr("checked",true);
	});
}
//全不选
function selectnotAll()
{
	$("#saveForm input[type=checkbox]").each(function(){
		$(this).attr("checked",false);
	});
}
//反选
function cancelselect()
{
	$("#saveForm input[type=checkbox]").each(function(){
		if($(this).attr("checked"))
		{
			$(this).attr("checked",false);
		}else
		{
			$(this).attr("checked",true);
		}
	});
}