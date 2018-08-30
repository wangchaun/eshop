(function (a) {
    a.path = {};

    var V = {
        rotate: function (p, degrees) {
            var radians = degrees * Math.PI / 180,
    c = Math.cos(radians),
    s = Math.sin(radians);
            return [c * p[0] - s * p[1], s * p[0] + c * p[1]];
        },
        scale: function (p, n) {
            return [n * p[0], n * p[1]];
        },
        add: function (a, b) {
            return [a[0] + b[0], a[1] + b[1]];
        },
        minus: function (a, b) {
            return [a[0] - b[0], a[1] - b[1]];
        }
    };

    a.path.bezier = function (params, rotate) {
        params.start = a.extend({
            angle: 0,
            length: 0.3333
        }, params.start);
        params.end = a.extend({
            angle: 0,
            length: 0.3333
        }, params.end);

        this.p1 = [params.start.x, params.start.y];
        this.p4 = [params.end.x, params.end.y];

        var v14 = V.minus(this.p4, this.p1),
    v12 = V.scale(v14, params.start.length),
    v41 = V.scale(v14, -1),
    v43 = V.scale(v41, params.end.length);

        v12 = V.rotate(v12, params.start.angle);
        this.p2 = V.add(this.p1, v12);

        v43 = V.rotate(v43, params.end.angle);
        this.p3 = V.add(this.p4, v43);

        this.f1 = function (t) {
            return (t * t * t);
        };
        this.f2 = function (t) {
            return (3 * t * t * (1 - t));
        };
        this.f3 = function (t) {
            return (3 * t * (1 - t) * (1 - t));
        };
        this.f4 = function (t) {
            return ((1 - t) * (1 - t) * (1 - t));
        };

        /* p from 0 to 1 */
        this.css = function (p) {
            var f1 = this.f1(p),
    f2 = this.f2(p),
    f3 = this.f3(p),
    f4 = this.f4(p),
    css = {};
            if (rotate) {
                css.prevX = this.x;
                css.prevY = this.y;
            }
            css.x = this.x = (this.p1[0] * f1 + this.p2[0] * f2 + this.p3[0] * f3 + this.p4[0] * f4 + .5) | 0;
            css.y = this.y = (this.p1[1] * f1 + this.p2[1] * f2 + this.p3[1] * f3 + this.p4[1] * f4 + .5) | 0;
            css.left = css.x + "px";
            css.top = css.y + "px";
            return css;
        };
    };

    a.path.arc = function (params, rotate) {
        for (var i in params) {
            this[i] = params[i];
        }

        this.dir = this.dir || 1;

        while (this.start > this.end && this.dir > 0) {
            this.start -= 360;
        }

        while (this.start < this.end && this.dir < 0) {
            this.start += 360;
        }

        this.css = function (p) {
            var a = (this.start * (p) + this.end * (1 - (p))) * Math.PI / 180,
    css = {};

            if (rotate) {
                css.prevX = this.x;
                css.prevY = this.y;
            }
            css.x = this.x = (Math.sin(a) * this.radius + this.center[0] + .5) | 0;
            css.y = this.y = (Math.cos(a) * this.radius + this.center[1] + .5) | 0;
            css.left = css.x + "px";
            css.top = css.y + "px";
            return css;
        };
    };

    a.fx.step.path = function (fx) {
        var css = fx.end.css(1 - fx.pos);
        if (css.prevX != null) {
            $.cssHooks.transform.set(fx.elem, "rotate(" + Math.atan2(css.prevY - css.y, css.prevX - css.x) + ")");
        }
        fx.elem.style.top = css.top;
        fx.elem.style.left = css.left;
    };
})(jQuery);

$(function () {
    
    var cartCont = "<div class=\"cartproductfluctuate\" id=\"cart_container\">";
        cartCont+="<div class=\"shoppingCart1\">";
        cartCont+="<div class=\"shoppingCart1_title\">购物车</div>";
        cartCont+="<div id=\"cartItem\"></div>"
        cartCont+="<div class=\"shoppingCart1_text1\"><h1><a href='ShoppingCar.do'>更多</a></h1>";
        cartCont+="<h2><a href='javascript:jiesuan();'>去结算</a></h2>";
        cartCont+="</div></div></div>";
        cartCont += "<div class=\"cartfluctuate\" id=\"show_cart\"><div class=\"shoppingCart\" ><h1><span>看看</span></h1></div></div>";
      
    if ($("#cart_container").length <= 0) {
        $("body").append(cartCont);
    }
     
      
    $("#cartItem .delCartItem").live('click', function () {
        var id =$(this).attr("name");
        
        if (confirm("您确定要删除吗?")){
		$.ajax({
			  type: "POST",
			  async: false,
			  cache: false,
			  url: ctx+"/deleteGoodFromCar.do",
			  data: "id=" + id,
			  success : function(returnData){ 
			    if(returnData == 'true'){
			    
			    var number=$('#rowssize').val();
			    var number2=number-1;
			    $('#rowssize').val(number-1);
			     $('.ys3').html('<a href="'+ctx+'/ShoppingCar.do">购物车'+number2+'件</a>  | <a href="${ctx}/infor.do?information.type=6" >售后服务</a>   | <a href="${ctx}/infor.do?information.type=7">企业采购</a>	| <a href="${ctx}/infor.do?information.type=3">购物指南</a>');
			    $("#cartItem_" + id).remove();
                cartItemDisplay();
				}else{
						alert('删除失败');
					}
				},
				error : function(){
					alert('删除失败');
			 	} 
		});
	}
        
    });
    var listcart = function (obj) {
         
        $(".listcart").unbind("click");
        var id = obj.attr("id");
         
        if ($("#jdwCartAnim").length > 0) {
            $("#jdwCartAnim").html("");
        } else {
            $("body").prepend("<div id=\"jdwCartAnim\" class=\"jdwCartAnim\"></div>");
        }
        $("#show_cart").hide();
        var C = $("#cart_container");
        var S = obj.position(),
            E = C.show().position(),
            bezier_params = {
                start: {
                    x: S.left,
                    y: S.top,
                    angle: -45,
                    length: 0.2
                },
                end: {
                    x: E.left + (Math.floor(C.width() / 2) - 85),
                    y: E.top - 55,
                    angle: -180,
                    length: 0.2
                }
            };
        var clone = $("#jdwCartAnim").append($("#img" + id + "").clone());
        clone.css({ display: "block", top: S.top + "px", left: S.left + "px" });
        clone.animate({ path: new $.path.bezier(bezier_params) }, 1500).animate({ top: (E.top + 55) + "px" }, 2000, function () {
            $("#jdwCartAnim").css("display", "none");
            //if (addCart(id)) {
                $("#cart_container").delay(2000).fadeOut("slow", function () {
                    $("#show_cart").fadeIn(300);
                    $(".listcart").each(function () {
                        $(this).click(function () {
                            listcart($(this));
                        });
                    });
                });
            //}
        });
    }
   
    
    $(".listcart").each(function () {
        $(this).click(function () {
            
            listcart($(this));
        });
    });
    $("#cart_container").mouseenter(function () {
        $(this).mousedown(function (e) {
            e.stopPropagation();
        });
    });
    $("#cart_container").mouseleave(function () {
        $(document).mousedown(function (e) {
            e.stopPropagation();
            $("#cart_container").hide();
            $("#show_cart").show();
        });
    });
    $("#show_cart").click(function () {
        $(this).hide();
        $("#cart_container").show();
    });
});
 //去结算
    function jiesuan(){
	//验证登陆
	var checkLogin=validationLogin();
	if(checkLogin=='false'){
		$("#geturl").val('/jiesuan.do');
		ShowDiv('MyDiv','fade');
	}else{		
		window.location.href=ctx+"/jiesuan.do";
	}
}