function editCart(cartItemId, buyCount) {
    if (buyCount < 1) {
        delCart(cartItemId);
        return;
    }
    window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId + '&buyCount=' + buyCount;
}

function delCart(cartItemId) {
    if (window.confirm("确定删除该购物项吗?")) {
        window.location.href = 'cart.do?operate=delCart&cartItemId=' + cartItemId;
    }
}