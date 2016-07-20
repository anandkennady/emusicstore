package com.niit.shop.service;

import com.niit.shop.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
