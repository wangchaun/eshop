(function () {
    $.fn.bindCart = function ($cartItem) {
        if ($cartItem == null && $cartItem == undefined) {
            $cartItem = $(this).find("li[cartname=addcart]");
        }
        cartOpiton.readyGoodsCart($(this), $cartItem);
        $(this).find("li[cartname=addcart]").attr("cartoperation", "true");
    };
    var t;
    var cartOpiton = {
        readyGoodsCart: function ($this, $findCartItem) {
            $this.addGoodsCart({
                optionCart: $findCartItem,
                optionCartClass: "li",
                optionCartImgName: "img[name=g_img]",
                optionCartBtnName: "a[name=sub_addcart]",
                optionCartPriceName: "em[name=g_price]",
                optionCartQuantity: "input[name=pro_quantity]",
                batchOptionCartObject: null,
                settlementJumpUrl: "/Buy/Cart",
                headCartItemquantity: $("#goods_qty"),
                detailedPageUrl: "/Goods/Item/V/"
            }, function (goodsID, goodsEntityID, goodsQuantity, isPassive, priceType) {
                if (typeof (priceType) == "undefined" || priceType == null || priceType == undefined)
                { priceType = "SalePrice"; }
                if (goodsID != "" && goodsID != null && goodsEntityID != "" && goodsEntityID != null) {
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        async: false,
                        url: "/Normal/Service.aspx",
                        data: { "Module": "Cart", "Action": "AddToCart", "goodsEntityID": goodsEntityID.toString(), "goodsQuantity": goodsQuantity <= "" ? 1 : goodsQuantity.toString(), "priceType": priceType },
                        success: function (data) {
                            if (!isPassive && typeof (data) != "undefined" && data != null && typeof (data.Status) != "undefined" && data.Status != 1) {
                                var date = new Date();
                                var funcKey = "AddCart_" + date.valueOf() + "" + parseInt(Math.random() * 100000000);
                                var returnData = data.Data;
                                $.ajax({
                                    type: "get",
                                    dataType: "jsonp",
                                    async: false,
                                    url: $System.Current.Authorization.SSOReAuthDoServiceUrl + "&siteID=" + returnData.SiteID + "&publicKey=" + returnData.PublicKey + "&sessionID=" + returnData.SessionID + "&signText=" + returnData.SignText,
                                    jsonpCallback: funcKey,
                                    success: function () {
                                        $(this).cart_Callback(goodsID, goodsEntityID, goodsQuantity, true);
                                    },
                                    error: function () {
                                        alert("网络连接出错了，请检查您的网络是否正常！");
                                    }
                                });
                            } else {
                                if (typeof (data.success) == "undefined") {
                                    var callback_goodsQuantitys = goodsQuantity.toString().split(',');
                                    var result_cartItem_value = "";
                                    var i = 0;
                                    var cartItem_hasTable_value = "";


                                    $.each(goodsEntityID, function (id, val) {
                                        result_cartItem_value = cartOpiton.IsresultCartItem(data.Data, goodsEntityID[id]);
                                        if (page.Cart.Items.containsKey(goodsEntityID[id])) {
                                            page.Cart_Item_Option.modify.Modify_cart_item(goodsEntityID[id], result_cartItem_value);
                                        } else {
                                            page.Cart_Item_Option.add.Add_cart_item(goodsEntityID[id], result_cartItem_value);
                                            $("#cartItem_Goods_" + result_cartItem_value.GoodsID + "_" + goodsEntityID[id]).find("a").attr("href", "/Goods/Item/V/" + result_cartItem_value.GoodsEntityID + ".html");
                                            /*LXC_Begin*/
                                            if ($System.Current.Page.Comparison && $System.Current.Page.Comparison.GoodsComparison) {
                                                var compareBtn = $("#cartItem_Goods_" + result_cartItem_value.GoodsID + "_" + goodsEntityID[id]).find("p.btn a");
                                                compareBtn.attr("href", "javascript:void(0);").attr("GoodsID", result_cartItem_value.GoodsID).attr("goodsentityid", goodsEntityID[id]).click(function () {
                                                    return $GoodsComparison.AddCompare($(this));
                                                });
                                            }
                                            /*LXC_End*/
                                        }
                                        $("#cartItem_Goods_" + result_cartItem_value.GoodsID + "_" + goodsEntityID[id]).find(".cart-tip-add-cartItem").hide();
                                        if (callback_goodsQuantitys != "" && callback_goodsQuantitys != undefined && callback_goodsQuantitys != null) {
                                            page.Cart_Item_Option.modify.Modify_cart_item_Amount((parseFloat(result_cartItem_value.Price)).toFixed(2) * parseFloat(callback_goodsQuantitys[i]), false);
                                            page.Cart_Item_Option.modify.Modify_cart_item_Quantity(parseInt(callback_goodsQuantitys[i]), false);
                                        } else {
                                            page.Cart_Item_Option.modify.Modify_cart_item_Amount(result_cartItem_value.Price, false);
                                            page.Cart_Item_Option.modify.Modify_cart_item_Quantity(1, false);
                                        }
                                        i++;
                                        cartOpiton.Syncho_Cart_UI(result_cartItem_value);
                                    });
                                } else {
                                    $.each(goodsEntityID, function (id, val) {
                                        $("#cartItem_Goods_" + goodsID[id] + "_" + goodsEntityID[id]).find(".cart-tip-add-cartItem").addClass("error").html("加入失败！");
                                    });
                                }
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $.each(goodsEntityID, function (id, val) {
                                $("#cartItem_Goods_" + goodsID[id] + "_" + goodsEntityID[id]).find(".cart-tip-add-cartItem").addClass("error").html("加入失败！");
                            });
                        }
                    });
                }
            });

        },
        IsresultCartItem: function ($Json_data, goodsVersonId) {
            var result_cart_item_value = null;
            $.each($Json_data, function (i, item) {
                if (item.goodsEntityID = goodsVersonId) {
                    result_cart_item_value = item;
                    return false;
                }
            });
            return result_cart_item_value;
        },
        Syncho_Cart_UI: function ($json_cartItem_Value) {
            if (page.ID = "Item.aspx") {
                $("#buying_pro_quantity").html(page.Cart.Items.get("Quantity"));
                $("#buying_pro_price").html(page.Cart.Items.get("Amount"));
                $("#buying_pannel").fadeIn();
                clearTimeout(t);
                t = setTimeout(function () { $("#buying_pannel").fadeOut(300); clearTimeout(t); }, 3000);
            }
        }
    };

})(jQuery);
