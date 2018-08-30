<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>商品规格</title>
	<%@ include file="/commons/taglibs.jsp" %>
	<%@ include file="/commons/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/scripts/framework/easyui/themes/icon.css">
	<link id="currentCss" name="currentCss" rel="StyleSheet" type="text/css" href="${ctx}/styles/kuquForm/form.css">
	<script language="JavaScript" type="text/javascript" src="${ctx }/scripts/framework/jquery.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx }/scripts/common/list_common.js"></script>
	<script type="text/javascript">
   $(function(){
      $('#code').combobox({
       url:ctx+'/phone!revesion.do',
        valueField:'value',
        textField:'value',
        onSelect:function(){
          var val = $('#code').combobox('getValue');
          $('#code').val(val);
        },
        onLoadSuccess: function () { 
             var data = $('#code').combobox('getData');
             if (data.length > 0) {
                 $('#code').combobox('select', data[0].value);
             } 
        }
       });
       //弹出框
	$('#edit').dialog({
		title:"文件上传",
		iconCls:'icon-edit',
	    modal:true,
	    draggable:true,
	    minimizable:false,
	    maximizable:false,
	    resizable:false
	});
	});
	
	function searchData(){
	 var code=$('#code').val();
	 if(code==''){
	  alert('请选择手机版号');
	  return false;
	 }
	 
	 var url = ctx+'/telphone!editExcelDate.do?code='+code;
     $('#edit').window('open');
     $('#editDataPage').attr('src',url);
	}
	</script>
</head> 

<body>
	 
	<div style="margin-top: 10px; margin-bottom: 5px;margin-left: 10px">
		<table border="0" cellpadding="0"  cellspacing="1" class="gdcn-table-bgcolor" width="50%" style="font-size: 12px;">
			<tr>
				<td class='gridtitle'>选择版号：</td>
				<td class='gridbody'><input id="code" editable="false"/></td>
				<td class='gridtitle'>
					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="searchData()">导入手机号码</a>&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			 
		</table>
	</div>
    <div id="edit" closed="true">
		<iframe frameborder="0" id="editDataPage" width="400px" height="200px"></iframe>
	</div> 
</body>

</html>