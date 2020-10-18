package com.company.models.interfaces;

import com.company.models.ShoppingCart;
import com.company.models.User;

import java.util.List;

public interface IShopCartDao {
    void addProductsToShopCart(ShoppingCart shoppingCart);
    List getProductsFromShopCartByUserId(long user_id);
    void removeAllFromShop(long user_id);
}
