package com.niit.shop.dao;

import java.io.IOException;

import com.niit.shop.model.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}

