var gId = '#dataGrid';
var goodInserts='#goodInserts';
var goodDeletes='#goodDeletes';
var goodSelects='#goodSelects';
var goodUpdates='#goodUpdates';
$(document).ready(function(){
	
	//获取列表参数
	function getGridOpt(){
		var maxLevel = parseInt($('#maxLevel').val());
		var opt = {
			url:getUrlOpt(),
			idField:'id',
			fitColumns:true,
			treeField:'name',
			animate:true,
			columns:[
				getTableHeadOpt(),
				[
					{field:'code',title:'编号',width:130,align:'left'},
					{field:'name',title:'名称',width:300,align:'left'}
				]
			],
			pageSize:20,
			rownumbers:false,
			pagination:false,
			loadMsg:'数据装载中......',
			onClickRow:function(){
				var node = $(gId).treegrid('getSelected');
				if(node.isParent == '0'){
					selectType(node.id,node.name);
				}				
			},
			onLoadSuccess:function(){
				$(gId).treegrid('collapseAll');
			},
		    toolbar:getToolBarOpt()
		};
		return opt;
	}
	$(gId).treegrid(getGridOpt());//树
});


function collapseAll(){
          $(gId).treegrid('collapseAll');
        }

//获取url参数
function getUrlOpt(){
	var url = ctx+'/GoodType_json!listJson.do?2=2';
    /**
    var IsInventory =$('#IsInventory').val();
    
    if(IsInventory!=""){
      url+= '&goodType.isInventory='+IsInventory;
    }
    **/
	return url;
}
	
//获取表头参数
function getTableHeadOpt(){
	var maxLevel = parseInt($('#maxLevel').val());
	var opt = [];
	opt.push({title:'基本信息',colspan:2});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:100,align:'left', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;';
					if('' == todo){
						if($(goodUpdates).val()=='1')
						{
						html = '<a href="javascript:void(0)" onclick="editGoodType(\''+rowData.id+'\',\'\','+rowData.level+');">编辑</a>'
							 + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
						}
						if($(goodDeletes).val()=='1')
						{	 
							 html+= '<a href="javascript:deleteGoodsType(\''+rowData.id+'\','+rowData.level+');">删除</a>';
						}
						if(maxLevel > rowData.level && $(goodInserts).val()=='1'){
							 html += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + '<a href="javascript:editGoodType(\'\',\''+rowData.id+'\','+(rowData.level+1)+');">添加子类</a>';	
						}
						//html += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + '<a href="javascript:editGoodType(\'\',\''+rowData.id+'\','+(rowData.level+1)+');">添加子类</a>';
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
	if($(goodInserts).val()=='1')
	{
			 opt = [{
		     text:'新增商品大类',
		     iconCls:'icon-add',
		     handler:function(){
		         editGoodType('','','1');
		     }
		},
		{
		     text:'折叠所有类别',
		     iconCls:'icon-add',
		     handler:function(){
		         collapseAll();
		     }
		}];
		
	}
	 if('show' == todo){
	    	opt = [{
		        text:'选择',
		        iconCls:'icon-ok',
		        handler:function(){
		        	var rowArr = $(gId).treegrid('getSelected');
		        	if(rowArr){
	        			window.returnValue = {'typeId':rowArr.id,'typeName':rowArr.name,'level':rowArr.level}; 
	        			window.close(); 		        		
			        }else{
			        	alert('请选择');
			        }
		        }	    	
	    	},
	    	{
		     text:'折叠所有类别',
		     iconCls:'icon-add',
		     handler:function(){
		         collapseAll();
		     }
		}];
	    }	    	
	 return opt;
}

//重新加载
function reloadGrid(){
	$(gId).treegrid('reload');
}

//关闭弹出窗
function closePopWindow(){
	$('#edit').window('close');
}

//编辑商品类别
function editGoodType(typeId,parentId,level){
	var url = ctx+'/goodType!edit.do?'; 
	if(typeId){
		url +='&goodType.id='+typeId;
	}
	if(parentId){
		url += '&goodType.parentId='+parentId;
	}
	if(level){
		url += '&goodType.level='+level;
	}
	/**
	var IsInventory =$('#IsInventory').val();
    if(IsInventory!=""){
      url+= '&goodType.isInventory='+IsInventory;
    }
	**/
	//弹出框
	$('#edit').dialog({
		title:"商品类别管理",
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
	            $('#editDataPage')[0].contentWindow.saveGoodsType();
	        }
	    }]
	});
	
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//删除商品类别
function deleteGoodsType(id,level){
	if(confirm('您确定要删除吗？')){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/goodType!delete.do",
		  data: "goodType.id=" + id+'&goodType.level='+level,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功');
					window.location.href = ctx+"/goodType!list.do";
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


//获取选中商品的下级分类
function selectType(typeId,typeName){
	if(todo=='show'){
		window.returnValue = {'typeId':typeId,'typeName':typeName};
		window.close();
	}
}
//function selectType(typeId,typeName,typeLevel){
//	if(typeLevel!=3){
//		var queryParams = $(gId).datagrid('options').queryParams;
//			
//			//获取列表参数
//			function getGridOpt(){
//				var maxLevel = parseInt($('#maxLevel').val());		
//			    var IsInventory =$('#IsInventory').val();
//				var opt = {
//					url:ctx+'/GoodType_json!listJson.do?goodType.levelString='+typeLevel+'&goodType.parentId='+typeId+"&goodType.isInventory="+IsInventory,
//					idField:'id',
//					fitColumns:true,
//					frozenColumns:[[
//           			    {field:'ck',checkbox:true}
//      				  ]],
//					treeField:'name',
//					animate:true,
//					columns:[
//						getTableHeadOpt(),
//						[
//							{field:'code',title:'编号',width:130,align:'left'},
//							{field:'name',title:'名称',width:300,align:'left'}
//						]
//					],
//					pageSize:20,
//					rownumbers:false,
//					pagination:false,
//					loadMsg:'数据装载中......',
//					onClickRow:function(){
//						var node = $(gId).treegrid('getSelected');
//							selectType(node.id,node.name,node.level);
//					},
//				    toolbar:getToolBarOpt()
//				};
//				return opt;
//		}
//		$(gId).treegrid(getGridOpt());//树
//	}else if(todo=='show'&&typeLevel==3){
//		window.returnValue = {'typeId':typeId,'typeName':typeName};
//		window.close();
//	}
//}


//搜索框检查用户是否按下‘回车键’，按下则调用搜索方法
function checkKey(){
	if(event.keyCode=='13'){
		searchData();
	}
}

//搜索功能
function searchData(){

	var goodCode = $("#goodCode").val(); 
	var goodName = $('#goodName').val();
	if(goodCode=='' && goodName=='')
	{
		alert('请输入查询条件！');
		return false;
	}
    realoadGrid(goodCode,goodName);
}
//确定搜索时重新加载datagrid
function realoadGrid(goodCode,goodName){
	var url = ctx+'/goodType!findType.do?2=2';
	if(goodCode)
	{
		url+='&goodType.code='+goodCode;
	}
	if(goodName)
	{
		url+='&goodType.name='+goodName;
	}
	url = encodeURI(encodeURI(url));
	 //弹出框
	$('#search').dialog({
		title:"商品类别搜索",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false
	});
    $('#getType').attr('src',url);
    $('#search').window('open');
}
