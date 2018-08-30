var gId = '#dataGrid';
var baseinfoInserts='#baseinfoInserts';
var baseinfoDeletes='#baseinfoDeletes';
var baseinfoSelects='#baseinfoSelects';
var baseinfoUpdates='#baseinfoUpdates';
$(document).ready(function(){
	
	$(gId).treegrid(getGridOpt());//树
	
	//获取列表参数
	function getGridOpt(){
		var opt = {
			url:getUrlOpt(),
			idField:'id',
			fitColumns:true,
			columns:[
				getTableHeadOpt(),
				[   
				    {field:'minMoney',title:'订单金额范围',width:130,align:'center',formatter:typeFormatterRange},
					{field:'creditNum',title:'积分数',width:100,align:'center'},
					{field:'memo',title:'备注',width:100,align:'center',formatter:typeFormatter}
				]
			],
			rownumbers:false,
			pagination:false,
		    toolbar:getToolBarOpt()
		}
		
		return opt;
	}
});
//格式化范围
function typeFormatterRange(value,rowData,rowIndex){
    
    var max=rowData.maxMoney;
    var min=rowData.minMoney;
    var state = rowData.memo
    if('1' == state){
    return result=min+"元";
    }
    return result=min+"元&nbsp;&nbsp;~&nbsp;&nbsp;"+max+"元&nbsp;";
    
}
//格式化备注信息
function typeFormatter(value,rowData,rowIndex){
	 
	
	var state = rowData.memo;//组织类型
	var max=rowData.maxMoney;
	var min=rowData.minMoney;
	var credit=rowData.creditNum;
	result= "用户&nbsp;可获取"+credit+"积分";
	if('1' == state){
		result = credit+'积分等于'+min+"元";
	} 
	 
	return result;
}
//获取url参数
function getUrlOpt(){
	var url = ctx+'/Credit_json!listJson.do';
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
					html = '<a href="javascript:editAreaInfo(\''+rowData.id+'\');">编辑</a>'
								 + '&nbsp;&nbsp;';
		            if(rowData.memo=='1'){
		            return html;
		            }
		            html += '<a href="javascript:deleteAreaInfo(\''+rowData.id+'\');">删除</a>';
						 	 
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
	if($(baseinfoInserts).val()=='1')
	{
			 opt = [{
		     text:'添加',
		     iconCls:'icon-add',
		     handler:function(){
		         editAreaInfo();
		     }
		 }
		 ];
	 }
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

//编辑地区信息
function editAreaInfo(typeId){
   
	var url = ctx+'/credit!edit.do';
	if(typeId){
		url +='?credit.id='+typeId;
	}
	 //弹出框
	$('#edit').dialog({
		title:"积分配置",
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
function deleteAreaInfo(id){
	if(confirm('确定要删除此配置信息吗？')){
		$.ajax({
		 type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/credit!delete.do",
		  data: "credit.id=" + id,
		  success : function(returnData){ 
				if(returnData == 'true'){
					alert('删除成功!');
					window.location.href = ctx+"/credit!list.do";
				}else{
					alert('删除失败!');
				}
			},
			error : function(){
				alert('系统错误!');
		 	} 
		});
	}
}