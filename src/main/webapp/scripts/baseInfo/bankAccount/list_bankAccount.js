var gId = '#dataGrid';
var baseinfoInserts='#baseinfoInserts';
var baseinfoDeletes='#baseinfoDeletes';
var baseinfoSelects='#baseinfoSelects';
var baseinfoUpdates='#baseinfoUpdates';
$(document).ready(function(){ 
	//列表
	$(gId).datagrid({
		url:ctx+'/BankAccount_json!listJson.do',
		idField:'id',
		fitColumns:true,
		frozenColumns:[[
               {field:'ck',checkbox:true}
        ]],
		columns:[
			getTableHeadOpt(),
			[
				{field:'code',title:'账户编号',width:80,align:'left'},
				{field:'name',title:'账户名称',width:80,align:'left'},
				{field:'account',title:'账号',width:100,align:'left'},
				{field:'money',title:'金额',width:80,align:'left'},
				{field:'accountHolder',title:'开户人',width:60,align:'left'},
				{field:'bank',title:'开户行',width:130,align:'left'},
				{field:'remark',title:'备注',width:80,align:'left'}
			]
		],
		pageSize:20,
		rownumbers:true,
		pagination:true,
		loadMsg:'数据装载中......',
		onDblClickRow:function(rowIndex,rowData){
			editData(rowData.id);
		},
	    toolbar:getToolBarOpt()
	});	
	
	//获取表头参数
	function getTableHeadOpt(){
		var opt = [];
		opt.push({title:'基本信息',colspan:7});
		if('' == todo){
			opt.push(
				{field:'opt',title:'操作',width:80,align:'center', rowspan:2,
					formatter:function(value,rowData,rowIndex){
						var html = '&nbsp;'
						if('' == todo){
							if($(baseinfoDeletes).val()=='1')
							{
								html = '<a href="javascript:void(0)" onclick="deleteData();">删除</a>'+
								'&nbsp;&nbsp;&nbsp;';
							}
							if($(baseinfoUpdates).val()=='1')
							{
								html+='<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
							}				
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
	if($(baseinfoInserts).val()=='1' && $(baseinfoDeletes).val()=='1')
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
	  if($(baseinfoInserts).val()=='1' && $(baseinfoDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(baseinfoDeletes).val()=='1' && $(baseinfoInserts).val()!='1')
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
	       	alert('请选择');
	       }
	      }	    	
	 	}];
	 }
	    return opt;
   	}
		
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
   
    //弹出框
	$('#edit').dialog({
		title:"银行账户",
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
	           $('#editDataPage')[0].contentWindow.submitForm();
	        }
	    }]
	});
});
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
	var url = ctx+'/bankAccount!edit.do';
	if(id){
		url += '?bankAccount.id='+id;
	}
   $('#edit').window('open');
   $('#editDataPage').attr('src',url);
}
//删除数据
function deleteData(){
	if (!confirm("您确定要删除吗？")){
		return;
	}
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
			  url: ctx+"/bankAccount!delete.do",
			  data: "bankAccount.id=" + id,
			  success : function(returnData){ 
					if(returnData == 'true'){
						alert('删除成功');
						reloadDataGrid();
					}else{
						alert('删除失败');
					}
				},
				error : function(){
					alert('删除失败');
			 	} 
		});
	}	
}