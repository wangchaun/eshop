var gId = '#dataGrid';
var goodInserts='#goodInserts';
var goodDeletes='#goodDeletes';
var goodSelects='#goodSelects';
var goodUpdates='#goodUpdates';
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
					{field:'code',title:'规格编号',width:80,align:'left'},
					{field:'name',title:'规格名称',width:80,align:'left'},
					{field:'showType',title:'显示类型',width:50,align:'left',formatter:showTypeFormat},
//					{field:'showWay',title:'显示方式',width:50,align:'left',formatter:showWayFormat},
//					{field:'sort',title:'序号',width:50,align:'left'},
					{field:'remark',title:'备注',width:80,align:'left'}
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
				if('show' == todo){
					selectKind(rowData.id,rowData.name);
				}
			},
		    toolbar:getToolBarOpt()
		};
		return opt;
	}
	
	//分页区	
	$(gId).datagrid('getPager').pagination(getPagerOpt() );
   	
    //弹出框
	$('#edit').dialog({
		title:"商品规格",
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
	var url = ctx+'/GoodSpecification_json!listJson.do?1=1';
	
	return url;
}

//格式化显示类型
function showTypeFormat(value,rowData,rowIndex){
	var showType = rowData.showType;
	var result = '';
	if('0'==showType){
		result = '文字';
	}
	if('1'==showType){
		result = '图片';
	}
	return result;
}
//格式化显示方式
function showWayFormat(value,rowData,rowIndex){
	var showWay = rowData.showWay;
	var result = '';
	if('0'==showWay){
		result = '平铺';
	}
	if('1'==showWay){
		result = '下拉';
	}
	return result;
}
//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:4});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:60,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if('' == todo){
						if($(goodUpdates).val()=='1')
						{
							html = '<a href="javascript:void(0)" onclick="editData(\''+rowData.id+'\');">编辑</a>';
						}
						if($(goodSelects).val()=='1')
						{
							html += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="listSpecificationVal(\''+rowData.id+'\',\''+rowData.name+'\');">查看规格值</a>';
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
	if($(goodInserts).val()=='1' && $(goodDeletes).val()=='1')
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
	  if($(goodInserts).val()=='1' && $(goodDeletes).val()!='1')
	 {
	 	opt=[{
			     text:'新增',
			     iconCls:'icon-add',
			     handler:function(){
			         editData();
			     }
		     }];
	 }
	 
	 if($(goodDeletes).val()=='1' && $(goodInserts).val()!='1')
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
	      	if(rowArr){
	      		if(rowArr.length > 3){
	      			alert('目前只支持3个规格');
	      		}else{
	      			window.returnValue = rowArr;
	     			window.close();
	      		}
	       }else{
	       	alert('请选择');
	       }
	      }
	 	}];
	 }
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
	var code = $("#code").val();
	var name = $("#name").val();
    realoadGrid(code,name);
}
//取消搜索
function cancelSearch(){
	$("#code").val('');
	$("#name").val('');
	realoadGrid('','');
}
//确定搜索时重新加载datagrid
function realoadGrid(code,name){
	var queryParams = $(gId).datagrid('options').queryParams;
	
	queryParams={"goodSpecification.code":code,"goodSpecification.name":name};
	$(gId).datagrid('options').queryParams = queryParams;
	$(gId).datagrid('reload');
}
//重新加载
function reloadDataGrid(){
	$(gId).datagrid('reload');
}

//关闭弹出窗
function closePopWindow(){
	$('#edit').window('close');
}

//选择
function selectKind(id,name){
	window.returnValue = {'id':id,'name':name};
	window.close();
}
//编辑数据
function editData(id){
	var url = ctx+'/goodSpecification!edit.do?';
	if(id){
		url += 'goodSpecification.id='+id;
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
			  url: ctx+"/goodSpecification!delete.do",
			  data: "goodSpecification.id=" + id,
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
function listSpecificationVal(id,name){
	var url = ctx+'/goodSpecificationVal!list.do?1=1';
	if(id){
		url += '&goodSpecificationVal.goodSpecificationId='+id;
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