/**NoPrice**/
(function(){
	var Ip = {
	    iplocation : {"局域网": { id: 1 },"北京": { id: 1 },"上海": { id: 2 },"天津": { id: 3 },"重庆": { id: 4 },"河北": { id: 5 },"山西": { id: 6 },"河南": { id: 7 },"辽宁": { id: 8 },"吉林": { id: 9 },"黑龙江": { id: 10 },"内蒙古": { id: 11 },"江苏": { id: 12 },"山东": { id: 13 },"安徽": { id: 14 },"浙江": { id: 15 },"福建": { id: 16 },"湖北": { id: 17 },"湖南": { id: 18 },"广东": { id: 19 },"广西": { id: 20 },"江西": { id: 21 },"四川": { id: 22 },"海南": { id: 23 },"贵州": { id: 24 },"云南": { id: 25 },"西藏": { id: 26 },"陕西": { id: 27 },"甘肃": { id: 28 },"青海": { id: 29 },"宁夏": { id: 30 },"新疆": { id: 31 },"台湾": { id: 32 },"香港": { id: 42 },"澳门": { id: 43 }},
	    ipServiceUrl : "http://price.360buy.com/ows/GetIPLocation.aspx",
	    name:"",
	    getProvinceIdByName : function(name) {
	         for (var o in this.iplocation) {
	             if (name.indexOf(o, 0) != -1) {this.name = o;return this.iplocation[o].id;}
	         }
	         return 0;
	    }
	};
	var cookieEditer = {
		getCookie:function (name) {
			var start = document.cookie.indexOf(name + "=");
			var len = start + name.length + 1;
			if ((!start) && (name != document.cookie.substring(0, name.length))) return null;
			if (start == -1) return null;
			var end = document.cookie.indexOf(';', len);
			if (end == -1) end = document.cookie.length;
			return unescape(document.cookie.substring(len, end));
		},
		setCookie:function (name, value, expires, path, domain, secure) {
			var today = new Date();
			today.setTime(today.getTime());
			if (expires) {
				expires = expires * 1000 * 60 * 60 * 24;
			}
			var expires_date = new Date(today.getTime() + (expires));
			document.cookie = name + '=' + escape(value) +
		        ((expires) ? ';expires=' + expires_date.toGMTString() : '') + //expires.toGMTString()
		        ((path) ? ';path=' + path : '') +
		        ((domain) ? ';domain=' + domain : '') +
		        ((secure) ? ';secure' : '');
		}
	};
	function djdArea(v){
	    if (arguments&&arguments[0]) this.priceServiceUrl = arguments[0];
	}
	djdArea.prototype = {
	    priceServiceUrl : "",
	    doms : $("div[id^='djd']"),
	    getSkuIds:function(){
	          var wids = "",idattr = "";
	          for (var i=0,j=this.doms.length;i<j;i++){
	            idattr = this.doms[i].getAttribute("id");
	            if (idattr && idattr != "") wids += idattr.replace("djd","") + ",";
	         }
	         return wids;
	    },
	    doReplace:function(r){
			var con = "",o=null,pngsize="2";
			for (var i=0,j=r.length;i<j;i++){
			    o = $("#djd"+r[i].OldSkuId);
			    con = o.html().toLowerCase();
			    if (con){
					if (con.indexOf(",1.png",0) > 0){
						pngsize = "1";
					}else if (con.indexOf(",2.png",0) > 0){
						pngsize = "2";
					}
					o.find("img").attr("src","http://price.360buy.com/gp"+r[i].SkuId+","+pngsize+".png");
			    }
			}
	    },
	    getIpLocation:function(){
	         var o = this;
	         $.ajax({ type: "GET",
	             url: Ip.ipServiceUrl,
	             dataType: "jsonp",
	             success: function(r) {
	                 o.getSkuPrice(r.ip);
	                 cookieEditer.setCookie("ipLocation", Ip.name, 30, "/", "360buy.com", false);
	             }
	         });
	    },
	    getSkuPrice:function(proname){
             var o = this;
             var proid = 0;
	         if (proname) proid = Ip.getProvinceIdByName(proname);
	         if (proid==0) return;
			 o.getHotsale(proid);
             var wids = o.getSkuIds();
             if (wids == "") return;
             $.ajax({ type: "GET", 
                 url: this.priceServiceUrl,
                 data:{IdProvince:proid,skuIds:wids,djdType:"NoPrice"},
                 dataType: "jsonp",
                 success: function(r) {  if (r && r.length > 0) o.doReplace(r); }
             });
	    },
		/**图片随机地址**/
		getRandomImgUrl : function(size,para){
		    var url = para[0]?para[0]:para[2];
			if (url) {
				if (para[1]) return "http://img30.360buyimg.com/n"+size+"/"+url;
				return "http://img"+Math.floor(Math.random()*4+10)+".360buyimg.com/n"+size+"/"+url;
			}
		    return "http://www.360buy.com/images/none/none_"+(size=="5"?"50":"130")+".gif";
		},
		getHotsale:function(proid){
			//热卖推荐
		if(document.referrer&&document.referrer.indexOf(".360buy.com")<0) return;
			var o = this;
			var hotsaledom = $("#hotsale").find("div[class='mc list-h']");
			if (hotsaledom[0]) {
				hotsaledom = $(hotsaledom[0]);
				var rfid = hotsaledom.attr("rfid");
				if (rfid) {
					 var sort = window.location.href.split('-')[2];
					 if (sort) sort = parseInt(sort,10);
					 if (!sort) sort = 798;
					 var para = "[{\"size\":3,\"sizeNation\":2,\"provinecId\":" + proid + ",\"rfid\":"+rfid+",\"categoryId\":"+sort+",\"compare\":1}]" ;/**热卖推荐**/
					 $.ajax({
						 type: "GET",
						 url: "http://pbss.360buy.com/vclist/getVcList.action",
						 dataType: "jsonp",
						 data: { jsonStr: encodeURIComponent(para) },
						 success: function(r) {
							 var strresult = "",partall="",partarea="",partstr="";
							 if (r&&r[rfid]&&r[rfid].length>=3) {
								 var i=0,j=r[rfid].length>3?3:r[rfid].length,v=null;
								 for (i=0;i<j;i++ ) {
									 v = r[rfid][i];
									 partstr = "<dl><dt><a href=\"http://www.360buy.com/product/"+v.wid+".html\" target=\"_blank\">"
											+ "<img height=\"100\" width=\"100\" alt=\""+v.title+"\""
											+ "src=\""+o.getRandomImgUrl(4,[v.imgurl,v.upimgUrl,v.prouductUrl])+"\"></a></dt>"
											+ "<dd><div class=\"p-name\"><a href=\"http://www.360buy.com/product/"+v.wid+".html\" target=\"_blank\">"
											+ v.title + "<font color=\"#ff6600\">"+(v.wareTitle?v.wareTitle:"")+"</font></a></div>"
											+ "<div class=\"p-price\">特价：<img onerror=\"this.src='http://www.360buy.com/images/no2.gif'\" "
											+ "src=\"http://price.360buy.com/gp"+v.wid+",1.png\"></div><div class=\"btns\"><a href=\""
											+ "http://jd2008.360buy.com/purchase/InitCart.aspx?pid="+v.wid+"&pcount=1&ptype=1\" target=\"_blank\">"
											+ "立即抢购</a></div></dd></dl>";
									 if (v.areaId&&v.areaId>0)
										 partarea += partstr;
									 else 
										 partall += partstr;
								 }
								 strresult = partarea+partall;
								 if (strresult){
									 hotsaledom.html(strresult);
								 }
							 }
						 }
					 });
				}
			}
		},
	    init:function() {
	         if (!this.doms&&this.doms.length==0) return;
	         var proname = cookieEditer.getCookie("ipLocation");
	         if (proname) { this.getSkuPrice(proname); }else{ this.getIpLocation(); }
	    }
	};
	new djdArea("http://www.360buy.com/djdService.aspx").init();
})();