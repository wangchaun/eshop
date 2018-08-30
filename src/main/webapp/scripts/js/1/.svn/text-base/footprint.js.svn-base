/* ---------- 埋点公用 ---------- */
function log (type1, type2, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10) {
    var data = '';
    for (i = 2; i < arguments.length; i++) {
        data = data + arguments[i] + '|||';
    }
    var pin = decodeURIComponent(escape(getCookie("pin")));
    var loguri = "http://csc.360buy.com/log.ashx?type1=$type1$&type2=$type2$&data=$data$&pin=$pin$&referrer=$referrer$&jinfo=$jinfo$&callback=?";
    var url = loguri.replace(/\$type1\$/, escape(type1));
    url = url.replace(/\$type2\$/, escape(type2));
    url = url.replace(/\$data\$/, escape(data));
    url = url.replace(/\$pin\$/, escape(pin));
    url = url.replace(/\$referrer\$/, escape(document.referrer));
    url = url.replace(/\$jinfo\$/, escape(''));
    $.getJSON(url, function() {});
}
/**
 * 新版-点击流统计-页面pv和显示次数
 * wpid 主商品三级分类，没有为空串''
 * psku 主商品sku，没有为空串''，根据它来判断此商品为pop还是非pop
 * markId 推荐位标记，找张斌要
 * op s:显示、p:pv
 */
function clsPVAndShowLog(wpid, psku, markId, op) {
    var key = wpid + "." + markId + "." + skutype(psku) + "." + op;
    log('d', 'o', key);
}
function clsClickLog(wpid, psku, rsku, markId, num, reCookieName) {
    var key = wpid + "." + markId + "." + skutype(psku);
    appendCookie(reCookieName, rsku, key);
    log('d', 'o', key + ".c");
}
function appendCookie(reCookieName, sku, key) {
    var reWidsCookies = eval('(' + getCookie(reCookieName) + ')');
    if (reWidsCookies == null || reWidsCookies == '') {
        reWidsCookies = new Object();
    }
    if (reWidsCookies[key] == null) {
        reWidsCookies[key] = '';
    }
    var pos = reWidsCookies[key].indexOf(sku);
    if (pos < 0) {
        reWidsCookies[key] = reWidsCookies[key] + "," + sku;
    }
    setCookie(reCookieName, $.toJSON(reWidsCookies), 15);
}
function skutype(sku) {
    if (sku) {
        var len = sku.toString().length;
        return len==10 ? 1 : 0;
    }
    return 0;
}
function setCookie(name, value, date) {
	var Days = date;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/;domain=.360buy.com";
}
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]);
    return null;
}
/* ---------- 埋点公用 end ---------- */

(function(a){a.fn.imgScroll=function(b){return this.each(function(){var d=a.extend({evtType:"click",visible:1,showControl:true,showNavItem:false,navItemEvtType:"click",navItemCurrent:"current",showStatus:false,direction:"x",next:".next",prev:".prev",disableClass:"disabled",speed:300,loop:false,step:1},b);var j=a(this),o=j.find("ul"),n=o.find("li"),s=n.length,c=d.visible,h=d.step,g=parseInt((s-c)/h),t=0,k=j.css("position")=="absolute"?"absolute":"relative",u=n.css("float")!=="none",r=a('<div class="scroll-nav-wrap"></div>'),e=d.direction=="x"?"left":"top",i=d.direction=="x",p=typeof d.prev=="string"?a(d.prev):d.prev,q=typeof d.next=="string"?a(d.next):d.next;d.loop=false;function m(){if(!u){n.css("float","left")}o.css({position:"absolute",left:0,top:0});j.css({position:k,width:d.direction=="x"?c*n.outerWidth():n.outerWidth(),height:d.direction=="x"?n.outerHeight():c*n.outerHeight(),overflow:"hidden"});p.addClass(d.disableClass+" disableIE6");if(d.loop){}else{if((s-c)%h!==0&&s>c){var x=h-(s-c)%h;o.append(n.slice(0,x).clone());s=o.find("li").length;g=parseInt((s-c)/h)}}if(i){o.css("width",s*n.outerWidth())}else{o.css("height",s*n.outerHeight())}if(!d.showControl&&s<=c){a(d.next+","+d.prev).hide()}if(s<=c){a(d.next+","+d.next).addClass(d.disableClass)}else{p.addClass(d.disableClass);q.removeClass(d.disableClass)}if(d.showNavItem){for(var v=0;v<=g;v++){var w=v==0?d.navItemCurrent:"";r.append('<em class="'+w+'">'+(v+1)+"</em>")}j.after(r);r.find("em").bind(d.navItemEvtType,function(){var y=parseInt(this.innerHTML);f((y-1)*h)})}if(d.showStatus){j.after('<span class="scroll-status">'+1+"/"+(g+1)+"</span>")}}function f(v){if(o.is(":animated")){return false}if(v<0){p.addClass(d.disableClass+" disableIE6");return false}if(v+c>s){q.addClass(d.disableClass);return false}t=v;o.animate(d.direction=="x"?{left:-((v)*n.outerWidth())}:{top:-((t)*n.outerHeight())},d.speed,function(){if(v>0){p.removeClass(d.disableClass+" disableIE6")}else{p.addClass(d.disableClass+" disableIE6")}if(v+c<s){q.removeClass(d.disableClass)}else{q.addClass(d.disableClass)}l(v)})}function l(v){r.find("em").removeClass(d.navItemCurrent).eq(v/h).addClass(d.navItemCurrent);if(d.showStatus){a(".scroll-status").html(((v/h)+1)+"/"+(g+1))}}m();if(s>c){q.click(function(){f(t+h)});p.click(function(){f(t-h)})}})}}(jQuery));


// 脚印功能
var ProductTrack = function( sRecent, sGuess ) {
	this.sRecent = sRecent;		// a string with css selector, like '#recent-view-track'
	this.sGuess = sGuess;
	
	// this.reBuildJson = function( data, perPageNum ) {
	// 	var totalPage = data.length/perPageNum;
	// 	var resData = [];

	// 	for ( var i = 0; i < totalPage; i++ ) {
	// 		resData.push({ 'tabs': [], 'increment': null, 'count': perPageNum, skuids: []});
	// 	}
		
	// 	var m = 0;
	// 	for ( var k = 0; k < data.length; k++ ) {
	// 		if ( k%perPageNum == 0 ) { m++; }

	// 		resData[(m-1)]['tabs'].push( data[k] );
	// 		resData[(m-1)]['increment'] = m;
	// 		resData[(m-1)]['skuids'].push( data[k].wid );

	// 	}

	// 	return resData
	// };
	var hd = document.getElementsByTagName("head")[0];         
	var style = document.createElement('link');
	style.type = 'text/css';
	style.rel = 'stylesheet';
	style.href = 'http://misc.360buyimg.com/product/skin/2012/footprint.css';
	hd.appendChild(style);
};

ProductTrack.prototype = {
	hide: function() {
		$(this.sRecent).hide();
		$(this.sGuess).hide();
	},
	getCommentData: function( skuids ) {
		var _this = this;
		// 评论数据
		$.ajax({
			url: 'http://club.360buy.com/clubservice.aspx?method=GetCommentsCount&referenceIds=' + skuids,
			dataType: 'jsonp',
			success: function(data) {
				_this.setCommentData(data);
			}
		});		
	},
	setCommentData: function( data ) {

		var len = data.CommentsCount.length;

		for ( var i = 0; i < len; i++ ) {
			$('#g'+data.CommentsCount[i].SkuId).find('.star').removeClass('sa5').addClass('sa' + data.CommentsCount[i].AverageScore);
			$('#g'+data.CommentsCount[i].SkuId).find('.p-comm a').html( '(已有' + data.CommentsCount[i].CommentCount + '人评价)' );
		}
	},
	getData: function( url ) {
		var url = url || 'http://my.360buy.com/global/track.action?jsoncallback=?'
			_this = this;
		
		$.ajax({
			url: url,
			dataType: 'json',
			success: function(data) {
				_this.setContent(data);
			},
			error: function() {
				_this.hide();
			}
		});

			
		return this
	},
	setContent: function( data, recentTPL, guessTPL ) {
		var rTPL = '<ul>'
			+'	{for list in history}'
			+'    <li onclick="clsClickLog(\'\', \'\', \'${list.wid}\', 3, ${list_index}, \'rodGlobalHis\');">'
			+'        <div class="p-img">'
			+'            <a href="${list.productUrl}"><img src="${pageConfig.FN_GetImageDomain(list.wid)}n5/${list.imageUrl}" /></a>'
			+'        </div>'
			+'        <div class="p-name">'
			+'            <a href="${list.productUrl}">${list.wName}</a>'
			+'        </div>'
			+'        <div class="p-price">'
			+'            <img src="http://price.360buyimg.com/gp${list.wid},1.png" onerror="this.src=\'http://misc.360buyimg.com/lib/skin/e/i/error-3.gif\'" />'
			+'        </div>'
			+'    </li>'
			+'    {/for}'
			+'</ul>';
		
		var gTPL = '<span class="guess-control" id="guess-forward">&lt;</span><span class="guess-control" id="guess-backward">&gt;</span><div id="guess-scroll"><ul class="lh">'
			+'{for list in guessyou}'
			+'<li style="width:144px;padding:10px ${pageConfig.wideVersion&&!!pageConfig.compatible ? 20 : 15}px" id="g${list.wid}" onclick="clsClickLog(\'\', \'\', \'${list.wid}\', 2, ${list_index}, \'rodGlobalTrack\');">'
			+'	<div class="p-img">'
			+'		<a target="_blank" title="${list.wName}" href="${list.productUrl}"><img height="130" width="130" alt="${list.wName}" src="${pageConfig.FN_GetImageDomain(list.wid)}n3/${list.imageUrl}"></a>'
			+'	</div>'
			+'	<div class="p-name">'
			+'		<a target="_blank" title="${list.wName}" href="${list.productUrl}">${list.wName}</a>'
			+'	</div>'
			+'	<div class="p-comm">'
			+'		<span class="star sa5"></span><br/>'
			+'		<a target="_blank" href="http://club.360buy.com/review/${list.wid}-1-1.html">(已有0人评价)</a>'
			+'	</div>'
			+'	<div class="p-price">'
			+'			<img src="http://price.360buyimg.com/gp${list.wid},1.png" onerror="this.src=\'http://misc.360buyimg.com/lib/skin/e/i/error-3.gif\'" />'
			+'	</div>'
			+'</li>'
			+'{/for}'
			+'</ul></div>';
		
		var sRecentTPL = recentTPL || rTPL,
			sGuessTPL = guessTPL || gTPL;
			
		// 浏览历史记录
		if ( data.history !== null && data.history.length > 0 ) {

			$(this.sRecent).find('.mc').html( sRecentTPL.process(data) );
			
			clsPVAndShowLog('', '', 3, 's');
		} else {
			$(this.sGuess).find('h2').html('本周热销');
			$(this.sRecent).find('.mc').html( '<div class="no-track"><h4>您还未在E购留下足迹</h4><p>在您的购物旅程中，您可以随时通过这里查看您之前的浏览记录，以便快捷返回您曾经感兴趣的页面。</p></div>' );
		}
		
		// 猜你喜欢
		if ( data.guessyou !== null && data.guessyou.length > 0 ) {
			var resSkuids = [];
			$(this.sGuess).find('.mc').html( gTPL.process(data));

			var num = pageConfig.wideVersion&&!!pageConfig.compatible ? 5 : 4;

			$('#guess-scroll').imgScroll({
				visible: num,
				step: num,
				prev: '#guess-forward',
				next: '#guess-backward'
			});
			// var resJSON = this.reBuildJson( data.guessyou, 5 );	//把返回数据按每个tab 5个商品重组JSON
			// var resSTR = ''
			// var resSkuids = [];
			
			// for ( var k = 0; k < resJSON.length; k++ ) {
			// 	var curr = k == 0 ? 'curr' : '';
			// 	var isFirst = k == 0 ? '' : ' none';

			// 	resSTR += ('<ul class="lh' + isFirst + '" data-widget="tab-content">' + sGuessTPL.process( resJSON[k] ) + '</ul>');
			// 	resSkuids.push( resJSON[k].skuids.join(',') ) ;
				
			// 	$('#maybe-like .extra').append('<span class="' + curr + '" data-widget="tab-item">' + (k+1) + '</span>');
			// }
			
			// $(this.sGuess).find('.mc').attr('data-skuids', resSkuids.join(',')).html( resSTR );
			
			clsPVAndShowLog('', '', 2, 's');
			
			// $('#maybe-like').Jtab({
			// 	compatible: true
			// });
			// 
			var resSKuids = [];
			$('#guess-scroll ul li').each(function() {
				resSKuids.push( $(this).attr('id') ) ;
			});
			this.getCommentData( resSKuids.join(',').replace(/g/g, '') );
			
		} else {
			$(this.sGuess).find('.mc').html( '<div class="nothing">暂无推荐</div>' );
		}
	}
};

(function() {
	var PT = new ProductTrack( '#recent-view-track', '#maybe-like' ).getData('http://my.360buy.com/global/track.action?jsoncallback=?');
})();