window.onload = function () {
    var vue = new Vue({
        el: "#cart_div",
        data: {
            cart: {}
        },
        methods: {
            getCart: function () {
                axios({
                    // 给服务器发送请求
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: 'cartInfo'
                    }
                })
                    .then(function (value) {
                        // 获取服务器返回的信息
                        var cart = value.data;
                        vue.cart = cart;
                    })
                    .catch(function (reason) {
                    });
            },
            editCart: function (cartItemId, buyCount) {
                if (buyCount < 1) {
                    vue.delCart(cartItemId);
                    return;
                }
                axios({
                    // 给服务器发送请求
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: 'editCart',
                        cartItemId: cartItemId,
                        buyCount: buyCount
                    }
                })
                    .then(function (value) {
                        vue.getCart();
                    })
                    .catch(function (reason) {
                    });
            },
            delCart: function (cartItemId) {
                if (!window.confirm("你确定删除该项吗?")) {
                    return;
                }
                axios({
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: 'delCart',
                        cartItemId: cartItemId
                    }

                })
                    .then(function (value) {
                        vue.getCart()
                    })
                    .catch(function (reason) {
                    });

            }
        },
        mounted: function () {
            this.getCart();
        }
    });


}