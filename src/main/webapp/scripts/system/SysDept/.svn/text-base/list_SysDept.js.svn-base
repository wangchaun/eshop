var gId = '#dataGrid';
var systemInserts='#systemInserts';
var systemDeletes='#systemDeletes';
var systemSelects='#systemSelects';
var systemUpdates='#systemUpdates';
$(document).ready(function(){ 
	//列表
	$(gId).datagrid({
		url:ctx+'/SysDept_json!listJson.do',
		idField:'id',
		fitColumns:true,
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
			getTableHeadOpt(),
			[
				{field:'code',title:'部门编号',width:80,align:'left'},
				{field:'name',title:'部门名称',width:120,align:'left'},
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
		title:"部门信息",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            editDataPage.submitForm();
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
	        text:'清除',
	        iconCls:'icon-cancel',
	        handler:function(){
	           	$("#deptName").val('');
    			$('#deptCode').val('');
    			realoadGrid('','');
	        }
	    }]
	});	
});

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo && $(systemUpdates).val()=='1'){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>'
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
	       	alert('请选择!');
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
	var deptName = $("#deptName").val(); 
	var deptCode = $('#deptCode').val();
    if(''==deptName && ''==deptCode){
    	alert('查询条件不能为空!');
    }else{
    	realoadGrid(deptName,deptCode);
    }
}
//确定搜索时重新加载datagrid
function realoadGrid(deptName,deptCode){
	var queryParams = $(gId).datagrid('options').queryParams;
	queryParams={"sysDept.name":deptName,"sysDept.code":deptCode};
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
	var url = ctx+'/SysDept!edit.do';
	if(id){
		url += '?sysDept.id='+id;
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
			alert('对不起，不能删除超级管理员!');
			return;
		}		
		if (!confirm("你确定删除吗?")){
			return ;
		}
		var id = ids.join(',');
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/SysDept!delete.do",
			  data: "sysDept.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功!');
						reloadDataGrid();
					}else{
						alert('删除失败!');
					}
				},
				error : function(){
					alert('System error,删除失败!');
			 	} 
		});
	}
}

//选择权限
function selectPower(id){
	var url = ctx+'/SysDeptPower!edit.do';
	if(id){
		url += '?sysDept.id='+id;
	}
	//弹出框
	$('#select').dialog({
		title:"角色权限",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'提交',
	        iconCls:'icon-ok',
	        handler:function(){
	            $('#selectDataPage')[0].contentWindow.submitForm();
	        }
	    }]
	});
    $('#select').window('open');
    $('#selectDataPage').attr('src',url);
}