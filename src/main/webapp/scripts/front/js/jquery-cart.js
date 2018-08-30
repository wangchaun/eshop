var page = $System.Current.Page;
page.Cart.Items = new Hashtable();

(function () {
    var G = {};
//    var carthtmlarr=[];
//    carthtmlarr.push('<div class="floatimg" name="floatimg"><img /></div>');
//    carthtmlarr.push('<div class="floatimgmove" name="floatimgmove"><img /></div>');
//    carthtmlarr.push('<div class="cartproductfluctuate" id="cart_container">');
//    carthtmlarr.push('    <div class="cart_topleft">购物车</div>')
//    carthtmlarr.push('    <div class="cart_coent"><a href="#cartList" id="pop_up_cartlist">查看购物车列表</a></div>');
//    carthtmlarr.push('    <div class="cart_topright"><a href="javascript:" name="cart_hide">隐藏</a></div>');
//    carthtmlarr.push('    <div class="cart_center">');
//    carthtmlarr.push('        <ul name="file_cart">');
//    carthtmlarr.push('        </ul>');
//    carthtmlarr.push('    </div>');
//    carthtmlarr.push('    <span class="cart_bottom">共计：<em><strong><span class="sign_cny">¥</span></strong><font id="goods_cart_total">0.00</font></em></span> <span class="cart_settlement" name="product_settlement"></span>');
//    carthtmlarr.push('</div>');
//    carthtmlarr.push('<div class="cartfluctuate" id="show_cart">');
//    carthtmlarr.push('    <div class="cartfluctuate_bg">');
//    carthtmlarr.push('        <span class="addbg"></span>');
//    carthtmlarr.push('        <div class="addpro">');
//    carthtmlarr.push('            <p>己添加(<em id="cart_item_count">0</em>)件</p>');
//    carthtmlarr.push('            <p>共计<em><strong><span class="sign_cny">¥</span></strong><font id="fluctuate_cart_total">0.00</font></em>元</p>');
//    carthtmlarr.push('        </div>');
//    carthtmlarr.push('    </div>');
//    carthtmlarr.push('</div>');
        var cartItemhtmlarr=[];
        cartItemhtmlarr.push('<li name="odd">');
        cartItemhtmlarr.push('    <div class="cart_center_tip"></div>');
         cartItemhtmlarr.push('   <div class="cart-tip-add-cartItem"><img src="/SiteUI/_Themes/Default/Images/add_cartItem.gif"/></div>');
        cartItemhtmlarr.push('    <div class="cart_goods_img">');
        cartItemhtmlarr.push('        <a class="cartimg" href="" target="_blank"><img src="img/big_img_03.jpg" name="odd_product" /></a>');
        cartItemhtmlarr.push('        <p><strong><span class="sign_cny">¥</span></strong><font name="product_price"></font>×<em name="pro_count">1</em></p>');        
        if ($System.Current.Page.Comparison&&$System.Current.Page.Comparison.GoodsComparison) {
            cartItemhtmlarr.push('        <p class="btn"><a href="javascript:void(0);" GoodsID="0" goodsentityid="0" class="btn-compare" >比较</a></p>');
        }
        cartItemhtmlarr.push('    </div>');
        cartItemhtmlarr.push('    <span name="remover_img" class="remove_img"></span>');
        cartItemhtmlarr.push('</li>');     
      

    G.load = {
        objdefaults: null,
        lihtml: null,
        loadClick: function () {    
            $(document).unbind("mousemove").unbind("mouseup");
            $(G.variables.show_cart).click(function () { G.click_operation.file_cartShowClick(); });
            $(G.variables.cart_hide).click(function () { G.click_operation.cart_hideShowClick(); });
            (G.option.variables.addCartBtnOptionObject).click(function () {
                G.add_cart.addCartBtnOptionObjectClick($(this));
            });           
            (G.option.variables.optionImg).mousedown(function (e) {
                $(document).mousemove(function (e) {
                    G.mosue_operation.docMouseMove(e);
                }).mouseup(function (e) {
                    G.mosue_operation.docMouseUp(e);
                });
                var pos = G.mosue_operation.getMousePosition(e);
                G.variables.ImgMovuserX = pos.x;
                G.variables.ImgMovuserY = pos.y;
                var link = $(this).parent();
                G.variables.ImgHref = link.attr("href");
                G.variables.link = link;
                G.variables.hits++;
                if (e.which == 3) {

                } else {
                    if (e.ctrlKey) {
                        if ($(this).parents("li").attr("name") == "selGoodsItem") {
                            $(this).parents("li").removeAttr("name");
                            $(this).parents("li").css({ "background-color": "white" });
                        } else {
                            $(this).parents("li").attr("name", "selGoodsItem");
                            $(this).parents("li").css({ "background-color": "#78b2f0" });
                        }
                    } else {
                        G.mosue_operation.mousedownClick($(this), e);
                    }
                }

                return false;
            });

            /*******************↓托选事件↓*****************/
            if (G.load.objdefaults.batchOptionCartObject != "" && G.load.objdefaults.batchOptionCartObject!=null) {
                (G.load.objdefaults.batchOptionCartObject).mousedown(function (e) {
                    if (e.which == 3) {
                    } else {
                        G.variables.ojbpd = $("#goodsList>ul>li");
                        G.variables.IsMouseDow = true;
                        G.variables.IsHascHosen = true;
                        var pos = G.mosue_operation.getMousePosition(e);
                        G.variables.spanx = pos.x;
                        G.variables.spany = pos.y;
                        $("body").append('<div name="has_chosen_div" style="border:1px dotted black"></div>')
                        $(G.variables.has_chosen_div).css({ "position": "absolute", "top": G.variables.spany + "px", "left": G.variables.spanx + "px" });
                    }
                    return false;
                });
                G.load.objdefaults.batchOptionCartObject.children().mousedown(function () {
                    return false;
                });
            }

            $(G.variables.product_settlement).click(function () {
                var productId = new Array();
                $(G.variables.cartID + " li").each(function (i) {
                    productId[i] = $(this).attr("id").toString().split("_")[3];
                });
                window.location = G.load.objdefaults.settlementJumpUrl;
            });
        },
        appendCartItemInnerHtml: function (item) {
            $(G.variables.cartID).append(G.load.lihtml);
            $this = $(G.variables.cartID).find("li:last");
            $this.attr("id", "cartItem_Goods_" + item.GoodsID + "_" + item.GoodsEntityID).removeAttr("name");
            $this.find("img").attr({ "src": item.Cover }).removeAttr("name");
            $this.find(G.variables.product_price).html(item.Price);
            $this.find("a").attr("href", G.load.objdefaults.detailedPageUrl + item.GoodsEntityID + ".html");
            /*LXC_Begin*/
            if ($System.Current.Page.Comparison&&$System.Current.Page.Comparison.GoodsComparison) {
                var compareBtn= $this.find("p.btn a");
                compareBtn.attr("href","javascript:void(0);").attr("GoodsID",item.GoodsID).attr("goodsentityid",item.GoodsEntityID);
            }
            /*LXC_End*/
            $this.find(G.variables.pro_count).html(item.Quantity);
            if ($(G.variables.cartID + ">li").length > 9) {
                $this.hide();
            }
        },
        readyCart: function () {    
            $(G.variables.cartID).html("");          
            var cartItemHashtableValue;
            var cartAmount = 0;
            var cartQuantity = 0;         
            for (var key in page.Cart.Items.items) {
                if (parseInt(key)) {                    
                    cartItemHashtableValue = page.Cart.Items.items[key];
                    G.load.appendCartItemInnerHtml(cartItemHashtableValue);
                } else {
                    if (key == "Amount") {
                        cartAmount = page.Cart.Items.items[key];
                    }
                    if (key == "Quantity") {
                        cartQuantity = page.Cart.Items.items[key];
                    }
                }
            }
            $(G.variables.cart_count).html(cartQuantity);
            $(G.variables.fluctuate_cart_total).html(cartAmount);
            $(G.variables.product_cart_total).html(cartAmount);         
            if(G.load.objdefaults!=null && G.load.objdefaults.headCartItemquantity!=null && typeof(G.load.objdefaults.headCartItemquantity)!="undefined"){
                G.load.objdefaults.headCartItemquantity.html(cartQuantity);
            }
            else{             
                $("#goods_qty").html(cartQuantity);
            }
            G.click_operation.remove_img_Click();
        }
    };
    
    G.variables = {
        /*******************↓控件名称变量↓*****************/
        cart_container: "#cart_container",
        floatimg: "div[name=floatimg]",
        floatimgmove: "div[name=floatimgmove]",
        cart_hide: "a[name=cart_hide]",
        cartID: "ul[name=file_cart]",
        cart_count: "#cart_item_count",
        show_cart: "#show_cart",
        items_count: "font[name=items_count]",
        odd: "li[name=odd]",
        remover_img: "span[name=remover_img]",
        odd_product: "img[name=odd_product]",
        has_chosen_div: "div[name = has_chosen_div]",
        selGoodsItem: "li[name=selGoodsItem]",
        product_cart_total: "#goods_cart_total", //共计
        fluctuate_cart_total: "#fluctuate_cart_total", //隐藏之后共计
        product_price: "font[name=product_price]", //价格
        product_settlement: "span[name=product_settlement]", //结算按钮
        pro_count: "em[name=pro_count]",
        /*******************↓局部变量↓*****************/
        pro_Quantity: 0,
        selGoodsItemArrayOffset: new Array(),
        $this_Goods_Price: null,
        imgurl: "",
        imgId: "",
        //光标托动
        lastMouseX: null,
        lastMouseY: null,
        lastElemTop: null,
        lastElemLeft: null,
        //最后放开鼠标的位
        floatimgmoveX: null,
        floatimgmoveY: null,
        floatimgmoveObj: null,

        //获取点击时鼠标位置
        ImgMovuserX: null,
        ImgMovuserY: null,
        ImgHref: null,
        link: null,
        hits: 0,
        //控制点击时获取光标位置
        IsMouseDow: false,
        //控制托选还是直接托动
        IsHascHosen: false,
        spanx: null,
        spany: null,
        ojbpd: null,
        //判断多个div
        Issingle: false,
        //当前选中的div
        $selectGoodsImgOjbect: null,
        //获取浏览器的高度和宽度
        windowobj: $(window),
        browserWidth: $(window).width(), //浏览器的宽
        browserHieght: $(window).height(), //浏览器的高 

        JdW: null,
        JDWGoodsID: 0,
        JDWGoodsEntityID: 0
    };
    G.add_cart = {
        addCartBtnOptionObjectClick: function ($this) {
            $this.unbind("click");
            G.click_operation.file_cartShowClick();
            var $this_parents = $this.parents(G.load.objdefaults.optionCartClass);
            G.variables.$this_Goods_Price = $this_parents.find(G.load.objdefaults.optionCartPriceName).html();
            $(G.variables.cartID).fadeIn("medium");
            var offset = $this.offset();
            if (G.load.objdefaults.Type == 1) {
                G.variables.imgurl = G.load.objdefaults.imgurl;
                G.variables.imgId = G.load.objdefaults.imgId;
            } else if (G.load.objdefaults.Type == 2) {
                G.variables.imgurl = $(G.load.objdefaults.imgobj).eq(i).attr("src");
                G.variables.imgId = $(G.load.objdefaults.imgobj).eq(i).attr("id");
            } else {
                G.variables.imgurl = $this_parents.find(G.load.objdefaults.optionCartImgName).attr("src");
                G.variables.JdW = $this_parents.find(G.load.objdefaults.optionCartImgName).attr("JDWGoodsID").split("-");
                G.variables.JDWGoodsID = G.variables.JdW[0];
                G.variables.JDWGoodsEntityID = G.variables.JdW[1];
            }
            var left;
            var top;
            var $cart_container_offset = $(G.variables.cart_container).offset();
            left = $cart_container_offset.left;
            top = $cart_container_offset.top;
            var $floatimg = $(G.variables.floatimg);
            $floatimg.find("img").attr("src", G.variables.imgurl);
            $floatimg.show().removeClass("floatimgmove").addClass("floatimg")
            .css({ "top": offset.top + "px", "left": offset.left + "px" }).
            animate({ left: left + "px", top: top + "px", opacity: "0.5", fontSize: "0px" }, 700, function () {
                $floatimg.css({ left: "-1000px", top: "-100px", fontSize: "50px" });
            });
            G.option.variables.callback_array_proId = new Array();
            G.option.variables.callback_array_goodsVersionsId = new Array();
            G.option.variables.callback_array_pro_Quantity = new Array();
            var pro_Quantity_value = $this_parents.find(G.load.objdefaults.optionCartQuantity).val();
            if (parseInt(pro_Quantity_value)) {
                if (parseInt(pro_Quantity_value) > 0) {
                    G.option.variables.callback_array_pro_Quantity[0] = pro_Quantity_value;
                } else {
                    pro_Quantity_value = 1;
                }
            } else {
                pro_Quantity_value = 1;
            }
            G.add_cart.addcartshow(0, pro_Quantity_value);
            var priceType=null;
             if(typeof($this.attr("priceType"))!="undefined"){
                priceType=$this.attr("priceType");
            }
            G.option.callback(G.option.variables.callback_array_proId, G.option.variables.callback_array_goodsVersionsId, G.option.variables.callback_array_pro_Quantity,false,priceType);
            var timeOut = null;
            var timeOut=setTimeout(function(){
                $this.click(function(){
                    if(timeOut){
                        clearTimeout(timeOut);
                    }
                    G.add_cart.addCartBtnOptionObjectClick($(this));
                });
            },800);

          }, MoveMouseUpCartClick: function (e) {
            var cart_container_left;
            var cart_container_top;
            var MousetOffset = $(G.variables.$selectGoodsImgOjbect).offset();
            var Mousetop = MousetOffset.top;
            var MousetLeft = MousetOffset.left;
            var pos = G.mosue_operation.getMousePosition(e);
            var $this_floatimgmove = $(G.variables.floatimgmove);
            if ((G.variables.ImgMovuserX - pos.x == 0) || (G.variables.ImgMovuserY - pos.y == 0)) {
                $this_floatimgmove.each(function (i) {
                    $(this).css({ left: "-1000px", top: "-100px", fontSize: "50px", width: "100px", height: "100px" })
                });

                if ($.browser.msie) {
                    G.variables.link[0].click();
                }
                else if ($.browser.mozilla) {
                    window.open(G.variables.ImgHref);
                } else {
                    var evt = document.createEvent("MouseEvents");
                    evt.initEvent("click", true, true);
                    G.variables.link[0].dispatchEvent(evt);
                }

            } else {
                if (((G.variables.floatimgmoveX + $(G.variables.floatimgmoveObj).width()) - (MousetLeft + $(G.variables.$selectGoodsImgOjbect).width()) >= 50) || ((G.variables.floatimgmoveY + $(G.variables.floatimgmoveObj).height()) - (Mousetop + $(G.variables.$selectGoodsImgOjbect).height()) >= 30) || ((Mousetop - G.variables.floatimgmoveY) >= 30) || ((MousetLeft - G.variables.floatimgmoveX) >= 50)) {
                    G.click_operation.file_cartShowClick();
                    $(G.variables.cartID).fadeIn("medium");
                    cart_container_left = $(G.variables.cart_container).offset().left;
                    cart_container_top = $(G.variables.cart_container).offset().top;
                    if (G.variables.Issingle) {
                        G.option.variables.callback_array_proId = new Array();
                        G.option.variables.callback_array_goodsVersionsId = new Array();
                        $this_floatimgmove.each(function (i, o) {
                            if ($.browser.msie && (parseInt($.browser.version) < 7)) {
                                G.variables.imgId = $(o)[0].getElementsByTagName("img")[0].title;
                                G.variables.imgurl = $(o)[0].getElementsByTagName("img")[0].src;
                                G.variables.$this_Goods_Price = $(o)[0].getElementsByTagName("img")[0].price;
                            } else {
                                G.variables.imgId = $(this).find("img").attr("title");
                                G.variables.imgurl = $(this).find("img").attr("src");
                                G.variables.$this_Goods_Price = $(this).find("img").attr("price");
                            }

                            G.add_cart.addcartshow(i, 1);

                            if (i == 0) {
                                $(this).animate({ left: cart_container_left + 50 + "px", top: cart_container_top + 50 + "px", opacity: "0.3", fontSize: "0px", width: "0px", height: "0px" }, "slow", function () {
                                    $(this).css({ left: "-1000px", top: "-100px", fontSize: "50px", width: "100px", height: "100px" })
                                });
                            } else {
                                $(this).animate({ left: cart_container_left + "px", top: cart_container_top + "px", opacity: "0.3", fontSize: "0px", width: "0px", height: "0px" }, "slow", function () {
                                    $(this).remove();
                                });
                            }
                        });
                        $(G.variables.selGoodsItem).each(function () {
                            $(this).removeAttr("name");
                            $(this).css({ "background-color": "white" });
                        });
                    } else {
                        G.option.variables.callback_array_proId = new Array();
                        G.option.variables.callback_array_goodsVersionsId = new Array();
                        G.variables.imgurl = $this_floatimgmove.find("img").attr("src");
                        G.variables.JdW = $this_floatimgmove.find("img").attr("title").split('-');
                        G.variables.JDWGoodsID = G.variables.JdW[0];
                        G.variables.JDWGoodsEntityID = G.variables.JdW[1];
                        G.add_cart.addcartshow(0, 1);
                        cart_container_left = $(G.variables.cart_container).offset().left;
                        cart_container_top = $(G.variables.cart_container).offset().top;
                        $this_floatimgmove.animate({ left: cart_container_left + 50 + "px", top: cart_container_top + 50 + "px", opacity: "0.3", fontSize: "0px", width: "0px", height: "0px" }, "slow", function () {
                            $this_floatimgmove.css({ left: "-1000px", top: "-100px", fontSize: "50px", width: "100px", height: "100px" });
                        });
                    }
                    G.option.variables.callback_array_pro_Quantity = new Array();
                    G.option.callback(G.option.variables.callback_array_proId, G.option.variables.callback_array_goodsVersionsId, G.option.variables.callback_array_pro_Quantity,false);
                    //callback(G.option.variables.callback_array_proId, G.option.variables.callback_array_goodsVersionsId);
                } else {
                    $this_floatimgmove.css({ left: "-1000px", top: "-100px", fontSize: "50px" })
                }
            }
        },
        addcartshow: function (i, $quantity) {
            var goodsID = G.variables.JDWGoodsID;
            var goodsVersionsId = G.variables.JDWGoodsEntityID;
            var cart_item_value = "";
            var IsAddli = true;
            var li_img_id = goodsID + "_" + goodsVersionsId;

            if (page.Cart.Items.containsKey(goodsVersionsId)) {
                IsAddli = false;
            }
           
            if (IsAddli) {             
                $(G.variables.cartID).prepend(G.load.lihtml);
                var $thisodd = $(G.variables.odd).removeAttr("name");
                $thisodd.attr({ "id": "cartItem_Goods_" + li_img_id });
                $thisodd.find("font").html(G.variables.$this_Goods_Price);
                if ($quantity != null) {
                    $thisodd.find(G.variables.pro_count).html($quantity);
                }
                $(G.variables.odd_product).attr({ "src": G.variables.imgurl }).removeAttr("name");
                // $thisodd.find("font").attr("href", G.option.variables.detailedPageUrl + G.variables.imgId.split('_')[2] + ".html");

                if ($(G.variables.cartID + ">li").length > 9) {
                    $(G.variables.cartID + ">li").each(function (j) {
                        if (j > 8) {
                            $(this).hide();
                        }
                    });                   
                }
                $("#cartItem_Goods_" + li_img_id).find(".cart_center_tip").fadeOut(1500).fadeIn(1500).fadeOut(1500);               
            } else {
                $("#cartItem_Goods_" + li_img_id).find(G.variables.pro_count).html(parseInt($("#cartItem_Goods_" + li_img_id).find(G.variables.pro_count).html()) + parseInt($quantity));
                $("#cartItem_Goods_" + li_img_id).find(".cart_center_tip").fadeOut(1500).fadeIn(1500).fadeOut(1500);
            }
            var loading_tip=$("#cartItem_Goods_" + li_img_id).find(".cart-tip-add-cartItem");
            loading_tip.show();
            window.setTimeout(function(){loading_tip.hide();},2000);

            $(G.variables.product_cart_total).html(parseInt($(G.variables.product_cart_total).html()) + (parseInt(G.variables.$this_Goods_Price) * parseInt($quantity)));
            $(G.variables.fluctuate_cart_total).html(parseInt($(G.variables.fluctuate_cart_total).html()) + (parseInt(G.variables.$this_Goods_Price) * parseInt($quantity)));
            G.variables.pro_Quantity = 0;
            $(G.variables.pro_count).each(function () {
                G.variables.pro_Quantity += parseInt($(this).html());
            });
            $(G.variables.cart_count).html(G.variables.pro_Quantity);
            G.load.objdefaults.headCartItemquantity.html(G.variables.pro_Quantity);

            G.option.variables.callback_array_proId[i] = goodsID;
            G.option.variables.callback_array_goodsVersionsId[i] = goodsVersionsId;


            $(G.variables.remover_img).unbind("click");
            G.click_operation.remove_img_Click();
        }
    };
    G.mosue_operation = {
        getMousePosition: function (e) {
            var posx = 0;
            var posy = 0;

            if (!e) var e = window.event;

            if (e.pageX || e.pageY) {
                posx = e.pageX;
                posy = e.pageY;
            }
            else if (e.clientX || e.clientY) {
                posx = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
                posy = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
            }

            return { 'x': posx, 'y': posy };
        },
        getFolatImgMoveOption: function ($this_folatimgmove, $this_GoodsImg, $this, type) {
            imgoffset = $this_GoodsImg.offset();
            $this_folatimgmove.show();
            if (type) {
                $this_folatimgmove.find("img").attr({ "src": $this.find("img").attr("src"), "title": $this.find("img").attr("JDWGoodsID"), "price": $this.find(G.load.objdefaults.optionCartPriceName).html() }).css({ "width": $this_GoodsImg.width(), "height": $this_GoodsImg.height() });
            } else {
                $this_folatimgmove.find("img").attr({ "src": $this_GoodsImg.attr("src"), "title": $this_GoodsImg.attr("JDWGoodsID") }).css({ "width": $this_GoodsImg.width(), "height": $this_GoodsImg.height() });
            }
            $this_folatimgmove.css({ "width": $this_GoodsImg.width(), "height": $this_GoodsImg.height(), "top": imgoffset.top + "px", "left": imgoffset.left + "px" });
            $this_folatimgmove.addClass("floatimgmove");
        },
        mousedownClick: function ($this, e) {
            var $this_folatimgmove;
            var $this_parents = $this.parents(G.load.objdefaults.optionCartClass);
            G.variables.$this_Goods_Price = $this_parents.find(G.load.objdefaults.optionCartPriceName).html();
            G.variables.$selectGoodsImgOjbect = $this;
            var IsselectDiv = true;
            var $selGoodsItemLengt = $(G.variables.selGoodsItem).length;
            G.variables.selGoodsItemArrayOffset = new Array($selGoodsItemLengt);
            var imgoffset;

            if ($selGoodsItemLengt > 0) {
                $(G.variables.selGoodsItem).each(function () {
                    if ($(this).find("img").attr("id") == $this.attr("id")) {
                        IsselectDiv = false;
                    }
                });
            }
            if (IsselectDiv) {
                if ($selGoodsItemLengt > 0) {
                    $(G.variables.selGoodsItem).each(function () {
                        $(this).removeAttr("name");
                        $(this).css({ "background-color": "white" });
                    });
                }
                G.mosue_operation.getFolatImgMoveOption($(G.variables.floatimgmove), $this, $this, false);
                G.variables.Issingle = false;
            } else {
                $(G.variables.selGoodsItem).each(function (i) {
                    if (i == 0) {
                        G.mosue_operation.getFolatImgMoveOption($(G.variables.floatimgmove), $this, $(this), true);
                    } else {
                        $("body").append($(G.variables.floatimgmove).eq(0).clone());
                        G.mosue_operation.getFolatImgMoveOption($(G.variables.floatimgmove).eq(i), $this, $(this), true);
                    }
                    imgoffset = $(this).offset();
                    G.variables.selGoodsItemArrayOffset[i] = imgoffset;
                });
                G.variables.Issingle = true;
            }

            var pos = G.mosue_operation.getMousePosition(e);
            //定位属性
            G.variables.lastMouseX = pos.x;
            G.variables.lastMouseY = pos.y;

            imgoffset = $this.offset();

            G.variables.lastElemTop = imgoffset.top;
            G.variables.lastElemLeft = imgoffset.left;

            G.variables.IsMouseDow = true;
            G.click_operation.updatePosition(e);
        },
        increase: function (e) {
            var pos = G.mosue_operation.getMousePosition(e);
            var posx = pos.x;
            var posy = pos.y;

            var left;
            var top;
            var chiloffset;
            var chilwidth;
            var chilheight;



            var leftwidth = Math.abs(posx - G.variables.spanx);
            var topheight = Math.abs(posy - G.variables.spany);

            var haschosoffset;
            var haschosTop_left;
            var haschosTop_Top;
            var haschosBton_left;
            var haschosBton_Top;

            if (G.variables.spanx > posx && G.variables.spany > posy) {
                $(G.variables.has_chosen_div).css({ "position": "absolute", "top": posy + "px", "left": posx + "px", "width": leftwidth + "px", "height": topheight + "px" });
            } else if (G.variables.spanx > posx) {
                $(G.variables.has_chosen_div).css({ "position": "absolute", "top": G.variables.spany + "px", "left": posx + "px", "width": leftwidth + "px", "height": topheight + "px" });
            } else if (G.variables.spany > posy) {
                $(G.variables.has_chosen_div).css({ "position": "absolute", "top": posy + "px", "left": G.variables.spanx + "px", "width": leftwidth + "px", "height": topheight + "px" });
            } else {
                $(G.variables.has_chosen_div).css({ "position": "absolute", "top": G.variables.spany + "px", "left": G.variables.spanx + "px", "width": leftwidth + "px", "height": topheight + "px" });
            }

            G.variables.ojbpd.each(function () {
                chiloffset = $(this).offset();
                left = chiloffset.left;
                top = chiloffset.top
                chilwidth = $(this).width() + left;
                chilheight = $(this).height() + top;
                haschosoffset = $(G.variables.has_chosen_div).offset();

                haschosTop_left = haschosoffset.left;
                haschosTop_Top = haschosoffset.top;
                haschosBton_left = haschosTop_left + leftwidth;
                haschosBton_Top = haschosTop_Top + topheight;

                if (((haschosTop_left <= left && left <= haschosBton_left) || (haschosTop_left <= chilwidth && chilwidth <= haschosBton_left)) && ((haschosTop_Top <= top && top <= haschosBton_Top) || (haschosTop_Top <= chilheight && chilheight <= haschosBton_Top)) || ((left <= haschosTop_left && haschosTop_left <= chilwidth) || (haschosTop_left <= left && left <= haschosBton_left)) && ((top <= haschosTop_Top && haschosTop_Top <= chilheight) || (haschosTop_Top <= top && top <= haschosBton_Top))) {
                    {

                        $(this).attr("name", "selGoodsItem");
                        $(this).css({ "background-color": "#78b2f0" });

                    }
                } else {
                    $(this).removeAttr("name")
                    $(this).css({ "background-color": "white" });
                }
            });
        },
        docMouseMove: function (e) {
            if (G.variables.IsMouseDow) {
                if (G.variables.IsHascHosen) {
                    G.mosue_operation.increase(e);
                } else {
                    G.click_operation.updatePosition(e);
                }
            }
            e.preventDefault();
            return false;
        },
        docMouseUp: function (e) {
            if (G.variables.IsMouseDow) {
                G.variables.IsMouseDow = false;
                if (G.variables.IsHascHosen) {
                    G.variables.IsHascHosen = false;
                    $(G.variables.has_chosen_div).remove();
                } else {
                    G.add_cart.MoveMouseUpCartClick(e);
                }
                $(document).unbind("mousemove").unbind("mouseup");
            }
            e.preventDefault();
            return false;
        }
    };

    G.click_operation = {
        file_cartShowClick: function () {
            $(G.variables.cart_container).show();
            $(G.variables.show_cart).hide();
        },
        cart_hideShowClick: function () {
            $(G.variables.cart_container).hide();
            $(G.variables.show_cart).show();
        },
        remove_img_Click: function () {
            $(G.variables.remover_img).click(function () {
                var goodsEntityID = $(this).parent("li").attr("id").split('_')[3];
                $System.Current.Page.Cart_Item_Option.del.Del_cart_item(goodsEntityID, null);
            });
        },
        updatePosition: function (e) {
            var pos = G.mosue_operation.getMousePosition(e);
            var spanX = (pos.x - G.variables.lastMouseX);
            var spanY = (pos.y - G.variables.lastMouseY);
            var moveY;
            var movex;
            if (G.variables.Issingle) {
                $(G.variables.floatimgmove).each(function (i) {
                    if (G.variables.selGoodsItemArrayOffset[i].top >= G.variables.lastElemTop)
                        moveY = (G.variables.lastElemTop + spanY) + Math.abs((G.variables.lastElemTop - G.variables.selGoodsItemArrayOffset[i].top));
                    else
                        moveY = (G.variables.lastElemTop + spanY) - Math.abs((G.variables.lastElemTop - G.variables.selGoodsItemArrayOffset[i].top));

                    if (G.variables.selGoodsItemArrayOffset[i].left >= G.variables.lastElemLeft)
                        movex = (G.variables.lastElemLeft + spanX) + Math.abs((G.variables.lastElemLeft - G.variables.selGoodsItemArrayOffset[i].left));
                    else
                        movex = (G.variables.lastElemLeft + spanX) - Math.abs((G.variables.lastElemLeft - G.variables.selGoodsItemArrayOffset[i].left));

                    $(this).css({ "top": moveY + "px", "left": movex + "px" })
                    if ($(this).find("img").attr("title") == $(G.variables.$selectGoodsImgOjbect).attr("id")) {
                        G.variables.floatimgmoveX = movex;
                        G.variables.floatimgmoveX = moveY;
                        G.variables.floatimgmoveObj = this;
                    }
                });
            } else {
                G.variables.floatimgmoveY = (G.variables.lastElemTop + spanY);
                G.variables.floatimgmoveX = (G.variables.lastElemLeft + spanX);
                G.variables.floatimgmoveObj = G.variables.floatimgmove;
                $(G.variables.floatimgmove).css({ "top": G.variables.floatimgmoveY + "px", "left": G.variables.floatimgmoveX + "px" });
            }
        }

    };

    $.fn.addGoodsCart = function (settings, callback) {
        var defaults = {
            imgurl: "",  //图片ul
            imgId: "",   //图片Id
            imgobj: "",  //图片对像
            readyAjaxUrl: "",  //加载时请求ajax
            cartInnerHtmlTemplateUrl: "/SiteUI/_Themes/Default/Parts/Collection_template.htm", //浮动购物车模板
            addCartBtnOptionObject: "",  //添加购物车按钮对像
            batchOptionCartObject: "",     //批量托选购物车对像
            Type: 3,             //传入的是否是对像值
            cartGoodsPrice: "",      //产品价格对像
            settlementUrl: "",    // 结算之后请求url
            settlementJumpUrl: "",         //结算购物车对像
            removeCartItemAjaxUrl: "", //移除购物车项请求Ajax
            optionCart: "",    //所有购物车操作对像
            optionCartClass: "",   //所有购物车操作对像名称
            optionCartImgName: "",        //图片对像名称
            optionCartPriceName: "",       //价格对像名称
            optionCartQuantity: "",      //数量对像名称
            optionCartBtnName: "",    //添加按钮对像名称
            headCartItemquantity: "",  //头部购物车对像Id
            detailedPageUrl: ""   //转入详细页面utl地址

        };
       
        G.load.objdefaults = $.extend(defaults, settings);       
        G.option = {
            variables: {
                /*******************↓传入变量↓*****************/
                callback_array_proId: new Array(),
                callback_array_goodsVersionsId: new Array(),
                callback_array_pro_Quantity: new Array(),
                cartGoodsPrice: G.load.objdefaults.Type == 3 ? $(G.load.objdefaults.optionCart).find(G.load.objdefaults.optionCartPriceName) : G.load.objdefaults.cartGoodsPrice,
                optionImg: G.load.objdefaults.Type == 3 ? $(G.load.objdefaults.optionCart).find(G.load.objdefaults.optionCartImgName) : G.load.objdefaults.optionImg,
                addCartBtnOptionObject: G.load.objdefaults.Type == 3 ? $(G.load.objdefaults.optionCart).find(G.load.objdefaults.optionCartBtnName) : G.load.objdefaults.addCartBtnOptionObject
            },
            callback: function (goodsIDs, goodsEntityIDs, goodsQuantity,isPassive,priceType) {
                callback(goodsIDs, goodsEntityIDs, goodsQuantity,isPassive,priceType);
            }
        };

        G.load.lihtml=cartItemhtmlarr.join('');     
        G.load.readyCart();

        G.load.loadClick();
    }
     
    $.fn.ready_CartItem = function () {  
        G.load.readyCart();
    } 

     $.fn.cart_Callback=function(goodsIDs,goodsEntityIDs,goodsQuantity,isPassive,priceType){       
        G.option.callback(goodsIDs,goodsEntityIDs,goodsQuantity,isPassive,priceType);
    }
})(jQuery);


