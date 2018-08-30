$(document).ready(function(){
	initMenu();
	initTab();
	initBgIndex();
	document.onkeydown = rewriteKeydown;//重写键盘事件，防止退格退回到登陆页
	changeLastLiCss();//修改submenu里面的最后一个li的css为li1
	//tab绑定右键菜单
	tabClose();
	//右键菜单选项事件处理
	tabCloseEven();
	// 释放内存
	$.fn.panel.defaults = $.extend({}, $.fn.panel.defaults, {
		onBeforeDestroy : function() {
			var frame = $('iframe', this);
			if (frame.length > 0) {
				frame[0].contentWindow.document.write('');
				frame[0].contentWindow.close();
				frame.remove();
			}
			if ($.browser.msie) {
				CollectGarbage();
			}
		}
	});
});

//修改submenu里面的最后一个li的css为li1
function changeLastLiCss(){
	$(".submenu").each(function(){
		var menuObj = $(this);
		var lastLiObj = menuObj.find("ul > li").last();
		lastLiObj.attr('class','li1');
	})
}

//重写键盘事件，防止退格退回到登陆页
function rewriteKeydown(e) {
    var code;   
    if (!e) var e = window.event;   
    if (e.keyCode) code = e.keyCode;
    else if (e.which) code = e.which;   
    if (((event.keyCode == 8) &&                                                    //BackSpace    
         ((event.srcElement.type != "text" &&    
         event.srcElement.type != "textarea" &&    
         event.srcElement.type != "password") ||    
         event.srcElement.readOnly == true))) {
        event.keyCode = 0;    
        event.returnValue = false;
    }
    //alert(e.keyCode);
    return true;   
}
//流量统计连接
function flowmeter()
{
	var siteId="80975231";
	var password="4235808620";
	var url="http://wss.cnzz.com/user/companion/phpcms_login.php?site_id="+siteId+"&password="+password;
	addTab('流量分析',url);
}
//初始化菜单
function initMenu(){
	$(".ban1:visible:first").next(".submenu").slideToggle("slow");
	
	$(".ban1").click(function(){
		//$(this).next(".submenu").siblings(".submenu").hide();
		$(this).next(".submenu").slideToggle("normal");
	});		
						
}

//tab初始化
function initTab(){ 
	$('#tab_area').tabs({
		fit:true,
		border:false,
	    onSelect:function(title){
 			updateTab(title,true);	
	    } 		
	});
}
//初始化后台页面 bgIndex
function initBgIndex(){
	var url=ctx+"/SysLogin!initBgIndex.do";
    addTab('主页面',url);

}

//添加tab
function addTab(title,url,closable){
	var tabArea = $('#tab_area');
	if('N'==closable){
		closable = false;
	}else{
		closable = true;
	}
	var isExist = tabArea.tabs('exists',title);//tab是否已存在
	if(isExist){
		tabArea.tabs('select', title);
//		updateTab(title);//更新tab
	}else{
//      var content = '<iframe scrolling="auto" id="'+url+'" src="'+url+'" frameborder="0" style="width:100%;height:100%;"></iframe>';
        tabArea.tabs('add',{
        	iframeUrl:url,
            title:title,
            closable:closable,
            selected:false
        });
	}
	
	//关闭其他tab
	$('.tabs-inner span').each(function(i,n){
        var t = $(n).text();
        if(t != title && t!='主页面' && t!='库存报表'){
    	   closeTab(t);
        }
     }); 
}

//更新tab
function updateTab(title,closable){
	var tabArea = $('#tab_area');
	var isExist = tabArea.tabs('exists',title);//tab是否已存在
	if(isExist){
	    var tab = $('#tab_area').tabs('getTab', title);
	    var url = tab.panel('options').iframeUrl;
	    var content = '<iframe scrolling="auto" src="'+url+'" frameborder="0" style="width:100%;height:100%;"></iframe>';
		$('#tab_area').tabs('update', {
			tab: tab,
			options:{
				title:title,
				closable:closable,
				content:content
			}
		});		
	}
}

//关闭tab
function closeTab(title){
	var tabArea = $('#tab_area');
	tabArea.tabs('close', title);
} 		

//退出系统
function logout(){
	if (confirm("您确定要退出吗？")){
		window.parent.location.href= ctx+'/SysLogin!logout.do';
	}
}
//备份数据
function backupData(){
	if (!confirm("你确定备份数据吗?")){
		return;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/databaseBackup!backUp.do?1=1",
		  success : function(returnData){ 
				var data = returnData.split(",");
				var flag = data[0];
				if(flag == 'true'){
					alert('数据备份成功!\r 备份文件的位置:\r'+data[1]);
				}else{
					alert('数据备份失败');
				}
			},
			error : function(){
				alert('数据备份失败');
		 	} 
	});
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tab_area').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();
		$('#mm').data("currtab", subtitle);
		return false;
	});
}

// 绑定右键菜单事件
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tab_area').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tab_area').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		})
	})
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tab_area').tabs('close', currtab_title);
	})
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tab_area').tabs('close', t);
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		closeRight();
		closeLeft();
	});
	// 关闭当前右侧的TAB
	function closeRight() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			//alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tab_area').tabs('close', t);
		});
		return false;
	};
	// 关闭当前左侧的TAB
	function closeLeft() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			//alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tab_area').tabs('close', t);
		});
		return false;
	};

	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});
}
