var gId = '#dataGrid';
var customerInserts='#customerInserts';
var customerDeletes='#customerDeletes';
var customerSelects='#customerSelects';
var customerUpdates='#customerUpdates';

$(document).ready(function(){ 
	//列表
	$(gId).datagrid({
		url:getUrlOpt(),
		idField:'id',
		fitColumns:true,
		//singleSelect:true,  True 就会只允许选中一行
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
			getTableHeadOpt(),
			[
				{field:'code',title:'编码',width:80,align:'left'},
				{field:'name',title:'名称',width:60,align:'left'},
				{field:'companyName',title:'公司',width:80,align:'left'},
				{field:'areaIds',title:'',width:0,align:'left',hidden:'true'},
				{field:'areaNames',title:'地区',width:100,align:'left'},
				{field:'linkman',title:'联系人',width:60,align:'left'},
				{field:'telephone',title:'电话',width:80,align:'left'},
				{field:'mobile',title:'手机',width:80,align:'left'},
				{field:'createTime',title:'创建时间',width:110,align:'left',formatter:dateFormat}
//				{field:'_state',title:'状态',width:70,formatter:stateFormat,align:'left'}
			]
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:'数据装载中......',
		onDblClickRow:function(rowIndex,rowData){
			//var loginManRole = $('#loginManRole').val();//登陆人角色
			//if('admin'==loginManRole){
				editData(rowData.id);
			//}
		},
	    toolbar:getToolBarOpt()
	});	
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt());
});

//Json加载数据路径
function getUrlOpt(){
	var url = ctx+'/CustomerJson!listJson.do';
	return url;
}

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	var loginManRole = $('#loginManRole').val();//登陆人角色
	opt.push({title:'客户信息',colspan:9});
	if('' == todo && ('admin'==loginManRole || 'region'==loginManRole)){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo && 'admin'==loginManRole){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>&nbsp;&nbsp;';
						if('s'==rowData._state){
							html += '<a href="javascript:void(0)" onclick="editState(\''+rowData.id+'\',\'c\');">冻结</a>';
						}else if('c'==rowData._state){
							html += '<a href="javascript:void(0)" onclick="editState(\''+rowData.id+'\',\'s\');">解冻</a>';
						}
						html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
					}	
					return html;
				}
			}
		);
	}
    return opt;	
    
}
//格式化状态
//function stateFormat(value,rowData,rowIndex){
//	var result = '';
//	var state = rowData._state;
//	if('s'==state){
//		result = '活动';
//	}else if('c'==state){
//		result = '冻结';
//	}
//	return result;
//}
//日期格式化
function dateFormat(value,rowData,rowIndex){
	var createTime = rowData.createTime;
	var result = '';
	if(createTime && ''!=createTime){
		result = createTime.substring(0,10);
	}
	return result;
}
//获取工具条参数
function getToolBarOpt(){
  	var opt = [];
  	if($(customerInserts).val()=='1' && $(customerDeletes).val()=='1')
	{
			 opt = [{
		     text:'新增',
		     iconCls:'icon-add',
		     handler:function(){
		         editData();
		     }
		 },'-',{
		     text:'删除',
		     iconCls:'icon-remove',
		     handler:function(){
		        deleteData();
		     }
		 }];
	 }
	  if($(customerInserts).val()=='1' && $(customerDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(customerDeletes).val()=='1' && $(customerInserts).val()!='1')
	 {
	 	opt=[{
		     text:'删除',
		     iconCls:'icon-remove',
		     handler:function(){
		        deleteData();
		     }
		 }];
	 } 
 	
    if('show' == todo){
    	opt = [{
	        text:'选择',
	        iconCls:'icon-ok',
	        handler:function(){
	        	var rowArr = $(gId).datagrid('getSelections');
	        	if(rowArr && rowArr.length){
        			window.returnValue = rowArr; 
        			window.close(); 		        		
		        }else{
		        	alert('请选择!');
		        }
	        }	    	
    	}];	    	
    }
    return opt;
}

//搜索功能
function searchData(){
	var account = $("#account").val(); 
	var company = $('#company').val();
	var areaName = $('#areaName').val();
	var state = $('#state').val();
    realoadGrid(account,company,areaName,state);
}
//确定搜索时重新加载datagrid
function realoadGrid(account,company,areaName,state){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"customer.code":account,"customer.company":company,"customer.areaName":areaName,"customer.state":state};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//点击行
function clickRow(id,name){ 
	var openObj = window.dialogArguments;
	if('open' == openObj){
		var data = {'id':id ,'name':name}; 		   
		window.returnValue = data; 
		window.close();
	}       
}

//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//关闭弹出窗
function closePopWindow(){
	$('#edit').window('close');
}

//编辑数据
function editData(id){
	var url = ctx+'/customers!edit.do';
	if(id){
		url += '?customer.id='+id;
	}
	
    //弹出框
	$('#edit').dialog({
		title:"客户信息",
		iconCls:'icon-edit',
		closed:true,
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	    	id:'btnSave',
	        text:'保存',
	        iconCls:'icon-save',
	        handler:function(){
	            $('#editDataPage')[0].contentWindow.submitForm(false);
	        }
	    },{
	    	id:'btnAudit',
	    	text:'审核',
	    	iconCls:'icon-ok',
	    	handler:function(){
	    		$('#editDataPage')[0].contentWindow.submitForm(true);
	    	}
	    }]
	});
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}
//搜索功能
function searchData(){
	var customerCode = $("#customerCode").val(); 
	var customerName = $('#customerName').val();
	var linkman = $('#linkman').val();
	var telephone = $('#telephone').val();
	var mobile = $('#mobile').val();
	var companyName = $('#companyName').val();
    realoadGrid(customerCode,customerName,linkman,telephone,mobile,companyName);
}
function cancelSearch(){
	 $("#customerCode").val('');
	 $('#customerName').val('');
	 $('#linkman').val('');
	 $('#telephone').val('');
 	 $('#mobile').val('');
	 $('#companyName').val('');
	 searchData();
}
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//确定搜索时重新加载datagrid
function realoadGrid(customerCode,customerName,linkman,telephone,mobile,companyName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"customer.code":customerCode,"customer.name":customerName,"customer.linkman":linkman,"customer.telephone":telephone,"customer.mobile":mobile,"customer.companyName":companyName};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//冻结客户
function editState(id,state){
	var optInfo = '';
	var succInfo = '';
	var errorInfo = '';
	
	if('c'==state){
		optInfo = '你确定冻结该客户吗';
		succInfo = '冻结成功';
		errorInfo = '冻结失败';
	}else if('s'==state){
		optInfo = '你确定解冻该客户吗';
		succInfo = '解冻成功';
		errorInfo = '解冻失败';
	}
	if(confirm(optInfo)){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/customers!editState.do",
			  data: "customer.id=" + id +'&customer.state='+state,
			  success : function(returnData){
					if(returnData == 'true'){
						alert(succInfo);
						reloadDataGrid();
					}else{
						alert(errorInfo);
					}
				},
				error : function(){
					alert('系统错误');
			 	} 
		});
	}
}
//删除数据
function deleteData(id){
	if(confirm('你确定删除该客户吗')){
		var ids = [];
		var rows = $(gId).datagrid('getSelections');
		if(rows &&  rows.length>0){
			for(var i=0;i<rows.length;i++){
				ids.push(rows[i].id);
			}
			var id = ids.join(',');
			$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/customers!delete.do",
			  data: "customer.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功');
						reloadDataGrid();
					}else{
						alert('删除失败');
					}
				},
				error : function(){
					alert('系统错误');
			 	} 
			});
		}
	}
}