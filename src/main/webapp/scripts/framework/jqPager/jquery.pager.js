(function($) {   
	$.fn.pager = function(options) {
		var opts = $.extend({}, $.fn.pager.defaults, options);  
		return this.each(function() {       // empty out the destination element and then render out the pager with the supplied options    
			$(this).empty().append(renderpager(parseInt(options.pagenumber), parseInt(options.pagecount),parseInt(options.totalcount), options.buttonClickCallback));                        // specify correct cursor activity
			$('.pages li').mouseover(function() { document.body.style.cursor = "pointer"; }).mouseout(function() { document.body.style.cursor = "auto";});  
		});
	};    // render and return the pager with the supplied options
	
	function renderpager(pagenumber, pagecount,totalcount, buttonClickCallback) {        // setup $pager to hold render  
		var $pager = $('<ul class="pages"></ul>');        // add in the previous and next buttons 
		$pager.append(renderButton('上一页', pagenumber, pagecount, buttonClickCallback));        // pager currently only handles 10 viewable pages ( could be easily parameterized, maybe in next version ) so handle edge cases     
		
		var startPoint = 1; 
		var endPoint = 9;
		if(pagecount>9){
			var thpoint="<li class='pageNumber'>...</li>";
		}
		if (pagenumber > 4) {
			startPoint = pagenumber - 4;
			endPoint = pagenumber + 4;
		}
		if (endPoint > pagecount) {
			startPoint = pagecount - 8;
			endPoint = pagecount;
			thpoint = "";
		}
		if (startPoint < 1) {
			startPoint = 1;
		}        // loop thru visible pages and render buttons
		for (var page = startPoint; page <= endPoint; page++) {
			var currentButton = $('<li class="pageNumber">' + (page) + '</li>');
			page == pagenumber ? currentButton.addClass('pgCurrent') : currentButton.click(function() {
				buttonClickCallback(this.firstChild.data);
			});
			currentButton.appendTo($pager);
		}        // render in the next and last buttons before returning the whole rendered control back.
		//页码end
		$pager.append(renderButton('下一页', pagenumber, pagecount, buttonClickCallback));
		$pager.append("<li class='thpoint'>共"+pagecount+"页 ");
		$pager.append("<li class='paging04'>到第</li><li class='paging05'><input id='chinkNows' type='text' size='2'/></li><li class='paging03'>页</li><li class='paging05'><input type='button' class='paging01_btn3' value='确认' onclick='chinkNow()'/></li></li>");
		return $pager;
}    // renders and returns a 'specialized' button, ie 'next', 'previous' etc. rather than a page number button

function changepage(buttonLabel,pagecount,buttonClickCallback){
	var $btngoto = $('<li class="pgNext">'+ buttonLabel+'</li>');
	$btngoto.click(function() {
		var gotoval = $btngoto.siblings().children('.page-number').val();
		var patrn = /^[1-9]{1,20}$/;
		if (!patrn.exec(gotoval)){
			alert("Please enter a non-zero number");
			return false;
		}
		var intval = parseInt(gotoval);
		if(intval > pagecount){
			alert("The page you have entered more than the total number of pages "+pagecount);
			return ;
		}
		buttonClickCallback(intval);
	});
	return $btngoto;
}
function renderButton(buttonLabel, pagenumber, pagecount, buttonClickCallback) {  
	var $Button = $('<li class="pgNext1">' + buttonLabel + '</li>');   
	if(buttonLabel=="下一页")$Button = $('<li class="pgNext">' + buttonLabel + '</li>');;
	var destPage = 1;        // work out destination page for required button type   
	switch (buttonLabel) {
		case "首页":
			destPage = 1;
			break;
		case "上一页":   
			destPage = parseInt(pagenumber) - 1;
			break;
		case "下一页":
			destPage = parseInt(pagenumber) + 1; 
			         
			break;
		case "末页":
			destPage = pagecount;        
			break;     
	}        // disable and 'grey' out buttons if not needed.       
	if (buttonLabel == "首页" || buttonLabel == "上一页") {     
		pagenumber <= 1 ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });     
	}       
	else {     
		pagenumber >= pagecount ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); }); 
	}     
	return $Button;  
 }    // pager defaults. hardly worth bothering with in this case but used as placeholder for expansion in the next version

 $.fn.pager.defaults = {   
	 pagenumber: 1,     
	 pagecount: 1};
 })(jQuery);