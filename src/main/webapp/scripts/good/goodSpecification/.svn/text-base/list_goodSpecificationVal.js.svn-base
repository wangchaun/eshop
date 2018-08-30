var gId = '#dataGrid';
$(document).ready(function(){
	$(gId).datagrid(getGridOpt());//列表
	
	//获取列表参数
	function getGridOpt(){
		var opt = {
			url:getUrlOpt(),
			idField:'id',
			fitColumns:true,
			frozenColumns:[[
	               {field:'ck',checkbox:true}
	        ]],
			columns:[
				getTableHeadOpt(),
				[
					{field:'value',title:'属性值',width:50,align:'left'}
				]
			],
			pageSize:20,
			rownumbers:true,
			pagination:true,
			loadMsg:'数据装载中......',
			onDblClickRow:function(rowIndex,rowData){
				if('' == todo){
					editData(rowData.id);
				}
			},
		    toolbar:getToolBarOpt()
		}
		return opt;
	}
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
   	
    //弹出框
	$('#edit').dialog({
		title:"编辑值",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'保存',
	        iconCls:'icon-save',
	        handler:function(){
	            $('#editDataPage')[0].contentWindow.submitForm('save');
	        }
	    }]
	});
});

//获取url参数
function getUrlOpt(){
	var goodSpecificationId = $('#goodSpecificationId').val();
	var url = ctx+'/GoodSpecificationVal_json!listJson.do?1=1&goodSpecificationVal.goodSpecificationId='+goodSpecificationId;
	return url;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:1});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:30,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						html += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="deleteData(\''+rowData.id+'\');">删除</a>';
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
	var opt = [{
	     text:'新增',
	     iconCls:'icon-add',
	     handler:function(){
	         editData('');
	     }
	 }]; 
	 return opt;
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
	var url = ctx+'/goodSpecificationVal!edit.do?1=1';
	if(id){
		url += '&goodSpecificationVal.id='+id;
	}else{
		var goodSpecificationId = $('#goodSpecificationId').val();
		url += '&goodSpecificationId='+goodSpecificationId;
	}
	
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

//删除数据
function deleteData(id){
	if (confirm("您确定要删除吗？")){
		$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/goodSpecificationVal!delete.do",
		  data: "goodSpecificationVal.id=" + id,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功！');
					reloadDataGrid();
				}else{
					alert('删除失败！');
				}
			},
			error : function(){
				alert('系统错误，删除失败！');
		 	} 
	});
	}
	
}
