//高级权限
var gId = '#dataGrid';

$(document).ready(function(){
	
	$(gId).treegrid(getGridOpt());//树
	
	//获取列表参数
	function getGridOpt(){
		var opt = {
			url:getUrlOpt(),
			idField:'id',
			fitColumns:true,
			treeField:'name',
			columns:[
				getTableHeadOpt(),
				[
					{field:'name',title:'功能模块',width:100,align:'left'},
					{field:'code',title:'功能编号',width:100,align:'left'},
					{field:'level',title:'级别',width:100,align:'left',formatter:typeFormatter}
				]
			],
			pageSize:10,
			rownumbers:false,
			pagination:false,
			loadMsg: getLoadMsg(),
			onDblClickRow:function(rowIndex,rowData){
				var powerData = $(gId).treegrid('getSelected');
				var maxLevel = $('#maxLevel').val();//maxLevel=4;
				if(powerData.level==maxLevel && todo=='show'){
					var area3 = $(gId).treegrid('getParent', powerData.id);
					var area2 = $(gId).treegrid('getParent', area3.id);
					var area1 = $(gId).treegrid('getParent', area2.id);
					alert(area1.name);
					powerData.name = area1.name + area2.name + area3.name + powerData.name;
				//	window.returnValue = powerData;
				//	window.close();
				}
				alert(powerData.name);
			},
		    toolbar:getToolBarOpt()
		}
		
		return opt;
	}
	
	//分页区	
//	$(gId).datagrid('getPager').pagination(getPagerOpt());
});

//组织类型格式化
function typeFormatter(value,rowData,rowIndex){
	var result = '';
	
	var state = rowData.type;//组织类型
	var level = rowData.level//组织层级
	if('1' == level){
		result = '一级功能';
	}else if('2' == level){
		result = '二级功能';
	}else if('3' == level){
		result = $(":checkbox");
	}else if('4' == level){
		result = $(":checkbox");
	}
	
	return result;
}

//获取url参数
function getUrlOpt(){
	var url = ctx+'/SysAdvPower_json!listJson.do?1=1';
	return url;
}	

//获取表头参数
function getTableHeadOpt(){
	var opt = [];
	opt.push({title:'基本信息',colspan:3});
	if('' == todo){
		opt.push(
			{field:'opt',title:'操作',width:120,align:'center', rowspan:2,
				formatter:function(value,rowData,rowIndex){
					var html = '&nbsp;'
					if('' == todo){
						var maxLevel = $('#maxLevel').val();
						html = '<a href="javascript:editAreaInfo(\''+rowData.id+'\',\'\','+rowData.level+');">编辑</a>'
							 + '&nbsp;&nbsp;'
							 + '<a href="javascript:deleteAreaInfo(\''+rowData.id+'\','+rowData.level+');">删除</a>';
						if(maxLevel > rowData.level ){
							 html += '&nbsp;&nbsp;' + '<a href="javascript:editAreaInfo(\'\',\''+rowData.id+'\',\''+(rowData.level+1)+'\');">添加子地区</a>';	
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
	var opt = [{
	     text:'添加一级地区',
	     iconCls:'icon-add',
	     handler:function(){
	         editAreaInfo('','','1');
	     }
	 }
	 ];
	 if('show' == todo){
	 	opt = [];
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

//编辑功能信息
function editAreaInfo(typeId,parentId,level){
	var url = ctx+'/area!edit.do?1=1';
	if(typeId){
		url +='&area.id='+typeId;
	}
	if(parentId){
		url += '&area.parentId='+parentId;
	}
	if(level){
		url += '&area.level='+level;
	}
	 //弹出框
	$('#edit').dialog({
		title:"地区信息",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    toolbar:[{
	        text:'保存',
	        iconCls:'icon-ok',
	        handler:function(){
	            $('#editDataPage')[0].contentWindow.submitForm();
	        }
	    }]
	});
	
	$('#editDataPage').attr('src',url);
    $('#edit').window('open');
}

//删除地区信息
function deleteAreaInfo(id,level){
	if(confirm('Are you sure you want to delete it？')){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/area!delete.do",
		  data: "area.id=" + id+'&area.level='+level,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('Deleted successfully!');
					window.location.href = ctx+"list.do";
				}else{
					alert('Deleted failed!');
				}
			},
			error : function(){
				alert('System error,Deleted failed!');
		 	} 
		});
	}
}
//选择地区信息弹出窗
function selectPage(){
	var dataArr = window.showModalDialog(ctx+"/area!list.do?todo=show", '',"status:no;left:yes;scroll:yes;resizable:no;help:no;dialogWidth:800px;dialogHeight:600px");
	if(dataArr!=null){
		$('#id1').val(dataArr.typeId);
		$('#id2').val(dataArr.typeName);
	}
}
//获取选中地区信息
function selectType(typeId,typeName){
	if(todo=='show'){
		window.returnValue = {'typeId':typeId,'typeName':typeName};
		window.close();
	}
}