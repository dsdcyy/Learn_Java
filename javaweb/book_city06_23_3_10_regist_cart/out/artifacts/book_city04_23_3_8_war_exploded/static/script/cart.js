function editCart(cartItemId, buyCount) {
    if (buyCount <= 0) {
        return;
    }
    window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId + '&buyCount=' + buyCount;
}