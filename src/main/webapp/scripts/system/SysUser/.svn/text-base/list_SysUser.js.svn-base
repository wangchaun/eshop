var gId = '#dataGrid';
var systemInserts='#systemInserts';
var systemDeletes='#systemDeletes';
var systemSelects='#systemSelects';
var systemUpdates='#systemUpdates';
$(document).ready(function(){ 
	//列表
	var roleCode = $('#roleCode').val();
	$(gId).datagrid({
		url:ctx+'/SysUser_json!listJson.do?sysUser.roleCode='+roleCode,
		idField:'id',
		fitColumns:true,
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
			getTableHeadOpt(),
			[
				{field:'name',title:'用户名',width:80,align:'left'},
				{field:'code',title:'用户编码',width:80,align:'left'},
				{field:'roleName',title:'角色代码',width:80,align:'left'},
				{field:'deptName',title:'组织部门',width:80,align:'left'},
				{field:'creatorName',title:'创建人',width:80,align:'left'},
				{field:'createTime',title:'创建时间',width:130,align:'left'}
			]
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:getLoadMsg(),
		onDblClickRow:function(rowIndex,rowData){
			editData(rowData.id);
		},
	    toolbar:getToolBarOpt()
	});	
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
   
    //弹出框
	$('#edit').dialog({
		title:"用户信息",
		iconCls:'icon-edit',
		closed:true,
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            $('#editDataPage')[0].contentWindow.submitForm();
	        }
	    }]
	});
	//搜索弹出框
	$('#search').dialog({
		title:"搜索",
		iconCls:'icon-search',
		closed:true,
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'OK',
	        iconCls:'icon-ok',
	        handler:function(){
	            searchData();
	        }
	    },'-',{
	        text:'Clean',
	        iconCls:'icon-cancel',
	        handler:function(){
	           	$("#userName").val('');
    			$("#userCode").val('');
    			$("#deptName").val('');
    			realoadGrid('','','');
	        }
	    }]
	});	
});

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:6});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo && 'admin'!=rowData.code && $(systemUpdates).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">Edit</a>';				
					}					
					return html;
				}
			}			
		);		
	}

   return opt;		
}	

//获取工具条参数
function getToolBarOpt(){
  	var opt=[];
	if($(systemInserts).val()=='1' && $(systemDeletes).val()=='1')
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
	  if($(systemInserts).val()=='1' && $(systemDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(systemDeletes).val()=='1' && $(systemInserts).val()!='1')
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
		        	alert('请选择一个!');
		        }
	        }	    	
    	}];	    	
    }
    var searchHtml = {
	 	text:'搜索',
	 	iconCls:'icon-search',
	 	handler:function(){
	 		$('#search').window('open');
	 	}
	 };
	 opt.push(searchHtml);
    return opt;
}
//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}
//搜索功能
function searchData(){
	var userName = $("#userName").val(); 
	var userCode = $("#userCode").val();
	var deptName=$("#deptName").val();
    if(''==userName && ''==userCode && ''==deptName){
    	alert('Query condition can not empty!');
    }else{
    	realoadGrid(userName,userCode,deptName);
    }
}
//确定搜索时重新加载datagrid
function realoadGrid(userName,userCode,deptName){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"sysUser.name":userName,"sysUser.code":userCode,"sysUser.deptName":deptName};
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
	var url = ctx+'/SysUser!edit.do';
	if(id){
		url += '?sysUser.id='+id;
	}
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

//删除数据
function deleteData(){
	var ids = [];
	var rows = $(gId).datagrid('getSelections');
	if(rows &&  rows.length>0){
		var isHasAdmin = false;
		for(var i=0;i<rows.length;i++){
			if('admin'==rows[i].code){
				isHasAdmin = true;
				break;
			}
			ids.push(rows[i].id);
		}
		if(isHasAdmin){
			alert('Sorry, you can delete the administrator!');
			return;
		}
		if (!confirm("Are you sure you want to delete it?")){
			return ;
		}
		var id = ids.join(',');
		
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/SysUser!delete.do",
			  data: "sysUser.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('Deleted Successfully!');
						reloadDataGrid();
					}else{
						alert('Deleted Failed!');
					}
				},
				error : function(){
					alert('System error, Deleted failed!');
			 	} 
		});
	}
}