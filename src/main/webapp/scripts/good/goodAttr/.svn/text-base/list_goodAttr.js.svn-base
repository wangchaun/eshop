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
					{field:'code',title:'属性编号',width:130,align:'left'},
					{field:'name',title:'属性名称',width:100,align:'left'},
					{field:'inputType',title:'输入类型',width:100,align:'left',formatter:inputTypeFormat},
					{field:'_state',title:'数据状态',width:100,align:'left',formatter:stateFormat},
					{field:'sort',title:'序号',width:50,align:'left'}
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
		title:"编辑属性",
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
	var goodKindId = $('#goodKindId').val();
	var url = ctx+'/GoodAttr_json!listJson.do?1=1&goodAttr.goodKindId='+goodKindId;
	return url;
}
//格式化输入类型
function inputTypeFormat(value,rowData,rowIndex){
	var inputType = rowData.inputType;
	var result = '';
	if('0'==inputType){
		result = '字符串';
	}
	if('1'==inputType){
		result = '日期';
	}
	if('2'==inputType){
		result = '整型';
	}
	if('3'==inputType){
		result = '双精度';
	}
	if('4'==inputType){
		result = '单选';
	}
	return result;
}
//格式化数据状态
function stateFormat(value,rowData,rowIndex){
	var state = rowData._state;
	var result = '';
	if('c'==state){
		result = '草稿';
	}
	if('s'==state){
		result = '审核';
	}
	return result;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:5});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo){
						html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="listKingVal(\''+rowData.id+'\',\''+rowData.name+'\');">设置属性值</a>';
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
	 },'-',{
	     text:'删除',
	     iconCls:'icon-remove',
	     handler:function(){
	        deleteData();
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
	var url = ctx+'/goodAttr!edit.do?1=1';
	if(id){
		url += '&goodAttr.id='+id;
	}else{
		var goodKindId = $('#goodKindId').val();
		url += '&goodKindId='+goodKindId;
	}
	
    $('#edit').window('open');
    $('#editDataPage').attr('src',url);
}

//删除数据
function deleteData(id){
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
			  url: ctx+"/goodAttr!delete.do",
			  data: "goodAttr.id=" + id,
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

function listKingVal(id,name){
	var url = ctx+'/goodKingVal!list.do?1=1';
	if(id){
		url += '&goodKingVal.goodKingId='+id;
	}
	var title = name +"值";
	 //弹出框
	$('#list').dialog({
		title:title,
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[]
	});
    $('#list').window('open');
    $('#listDataPage').attr('src',url);
}