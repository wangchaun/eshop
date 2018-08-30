/**
 * Garmentcity init js 2012-8-23
 */

(function() {
	// category toggle
	$('#gc-category div.gc-cat-list').hover(function() {
		var that = $(this),
			imgs = that.find('img');
			
		that.addClass('current');
		
		imgs.each(function() {
			if ( !!$(this).attr('src') == true ) {
				return false;
			} else {
				$(this).attr('src', $(this).attr('data-lazy') );
			}
		});
		
	}, function() {
		$(this).removeClass('current');
	});
})(); 

(function($) {
	// switch page version for init
	var isWidth = $('body').hasClass('root61'),
		mequeenWidth = isWidth ? 510 : 380,
		sliderWidth = isWidth ? 670 : 570,
		slideStep = isWidth ? 3 : 2;

	var slideTPL = {
		// main slide template
		main: {
			itemsWrap: '<ul class="slide-items">{innerHTML}</ul>',
			itemsContent: '{for item in json}<li><a clstag="fashion|keycount|fashion|030${parseInt(item_index)+1}" href="${item["href"]}" target="_blank"><img src="${item["src'+perfixComp+'"]}" width="${item["width'+perfixComp+'"]}" height="530" alt="${item["alt"]}" data-img="2" /></a></li>{/for}',
			controlsWrap: '<div class="img-scroll-control slide-controls">{innerHTML}</div>',
			controlsContent: '{for item in json}<span class="{if parseInt(item_index)==0}curr{/if}"><b>¡ø</b><img src="${item.srcS}" alt="${item["alt"]}" width="44px" height="39" /></span>{/for}'
		},
		// side slide template
		side: {
			itemsWrap: '<div class="gc-imgscroll"><ul class="slide-items">{innerHTML}</ul></div>',
			itemsContent: '{for item in json}<li><a href="${item.href}" title="${item.alt}" target="_blank">{if parseInt(item_index)==0}<img src{else}<img data-lazyload{/if}="${item.src}" alt="${item.alt}" width="200" height="430" /></a></li>{/for}',
			controlsWrap: '<div class="gc-sco-control slide-controls">{innerHTML}</div>',
			controlsContent: '{for item in json}<span class="{if parseInt(item_index)==0}curr{/if}">${parseInt(item_index)+1}</span>{/for}'
		}
		
	};

	// brands Tab template
	var brandsTabTpl = '{for item in data}<div class="gc-list-item">'
		+'	<div class="p-img">'
		+'		<a href="${item.url}" title="${item.title}" target="_blank"><img src="${item.ImgDomain}${item.upimgurl}" width="166" height="250" alt="" data-img="1" /></a>'
		+'	</div>'
		+'</div>{/for}';

	// (wo)man Tab template
	var tabListTpl = '<div class="gc-list">'
		+'	{for item in data }'
		+'	<div class="gc-list-item">'
		+'		<div class="p-img">'
		+'			<a href="${item.url}" title="${item.title}" target="_blank"><img src="${item.ImgDomain}${item.upimgurl}" width="160" height="160" data-img="1" /></a>'
		+'		</div>'
		+'		<div class="p-name"><a href="${item.url}"${item.title} target="_blank">${item.title}</a></div>'
		+'		<div class="p-price"><img src="http://price.360buyimg.com/gp${item.skuid},1.png" data-img="3" /></div>'
		+'	</div>'
		+'	{/for}'
		+'</div>';

	var reBuildJson = function( data, perPageNum ) {
		var totalPage = data.length/perPageNum;
		var resData = [];

		for ( var i = 0; i < totalPage; i++ ) {
			resData.push({ 'tabs': [], 'increment': null, 'count': perPageNum, skuids: []});
		}
		
		var m = 0;
		for ( var k = 0; k < data.length; k++ ) {
			if ( k%perPageNum == 0 ) { m++; }

			resData[(m-1)]['tabs'].push( data[k] );
			resData[(m-1)]['increment'] = m;

		}

		return resData
	};

	var slideData = reBuildJson(gcGetData, 3);

	// side slider
	$('.gc-side-sco').each(function(ind) {

		$(this).Jslider({
			defaultIndex: 0,
			slideWidth: 200,
			slideHeight: 430,
			speed: 'fast',
			slideDirection: 1,
			data: slideData[ind]['tabs'],
			template: slideTPL['side']
		}, function(obj) {

			// side slider lazyload
			obj.find('span').mouseover( function() {
				var ind =  $(this).parents('.gc-sco-control').find('span').index( $(this) );
				var currImg = $(this).parents('.gc-side-sco').find('img').eq(ind);

				if ( !!currImg.attr('src') == true ) {
					return false;
				} else {
					currImg.attr('src', currImg.attr('data-lazyload') ).removeAttr('data-lazyload');
				}
			});

		});
	});
	
	// main slider
	$('#img-scroll').Jslider({
		auto: true,
		defaultIndex: 0,
		data: mainSlideData,
		slideWidth: sliderWidth,
		slideHeight:530,
		speed: 'fast',
		template: slideTPL['main'],
		slideDirection: 3
	});
	
	// hot brand tab
	$('#gc-hot').Jtab({
		compatible: true
	}, function( source, obj, n ) {
		if ( n !== 0 ) {
			obj.find('img').each(function() {

				if ( !!$(this).attr('src') == true ) {
					return false;
				} else {
					$(this).attr('src', $(this).attr('data-src') ).removeAttr('data-src');
				}				
			});
		}
	});

	// brands tabs
	$('#gc-brands .gc-tab').Jtab({
		type: 'dynamic',
		currClass: 'gc-tab-curr',
		compatible: true
	}, function( source, obj, n ) {
		if ( n !== 0 ) {
			obj.find('.gc-list').html(brandsTabTpl.process( tabList['16'+n] ));
			pageConfig.FN_ImgError(obj[0]);
			
			var imgs = obj.find('.gc-list-ad img');

			imgs.each(function() {

				if ( !!$(this).attr('src') == true ) {
					return false;
				} else {
					$(this).attr('src', $(this).attr('data-src') ).removeAttr('data-src');
				}
			});
		}
	});

	// tab list 
	$('#gc-women .gc-tab').Jtab({
		currClass: 'gc-tab-curr',
		compatible: true
	}, function( source, obj ,n ) {
		if ( n !== 0 ) {
			if ( obj.find('.gc-list').length < 1 ) {
				obj.html( tabListTpl.process( tabList['17'+(n+3)] ));
				pageConfig.FN_ImgError(obj[0]);
			}
		}
	});
	
	$('#gc-men .gc-tab').Jtab({
		currClass: 'gc-tab-curr',
		compatible: true
	}, function( source, obj ,n ) {
		if ( n !== 0 ) {
			if ( obj.find('.gc-list').length < 1 ) {
				obj.html( tabListTpl.process( tabList['18'+(n-1)] ));
				pageConfig.FN_ImgError(obj[0]);
			}

		}		
	});

	$('#gc-shoes .gc-tab').Jtab({
		currClass: 'gc-tab-curr',
		compatible: true
	}, function( source, obj ,n ) {
		if ( n !== 0 ) {
			if ( obj.find('.gc-list').length < 1 ) {
				obj.html( tabListTpl.process( tabList['22'+(n+3)] ));
				pageConfig.FN_ImgError(obj[0]);
			}
		}		
	});

	$('#gc-sports .gc-tab').Jtab({
		currClass: 'gc-tab-curr',
		compatible: true
	}, function( source, obj ,n ) {
		if ( n !== 0 ) {
			if ( obj.find('.gc-list').length < 1 ) {
				obj.html( tabListTpl.process( tabList['2'+(18+n)] ));
				pageConfig.FN_ImgError(obj[0]);
			}
		}		
	});


	//image wall hover show more info
	$('.gc-box').hover(function() {
		$(this).children('.gc-box-pop').stop().animate({
			bottom: 0
		}, 200);
	}, function() {
		$(this).children('.gc-box-pop').stop().animate({
			bottom: '-42px'
		}, 200);
	});

	//category hover dropdown
	$('.cat-list-item').Jdropdown();

	//top scroll with category
	var catHeight = $('#gc-cat-list').height(),
		fTop = $('#gc-cat-list').offset().top;

	$(window).scroll(function() {
		
		var top = $(document).scrollTop();
 
		if ( top > fTop  && top < fTop+catHeight ) {
			$('#gc-cat-list-inner').addClass('gc-fixed');
		} else {
			$('#gc-cat-list-inner').removeClass('gc-fixed');
		}
	});

	//footer show scroll
	$('.gc-ss-inner').jdMarquee({
		step: slideStep,
		deriction: 'left',
		control: true,
		speed: 6,
		auto: false,
		width: mequeenWidth,
		height: 532,
		_front: '.gc-next',
		_back: '.gc-prev'
	});




	// insert weibo description
	$('.weiboShow_developerDetail_name')

})(jQuery);



