package com.company.models.interfaces;

import com.company.models.ShoppingCart;

import java.util.List;

public interface IBuyDao {
    void addProductsToBuy(ShoppingCart shoppingCart);
    List getProductsFromBuyByUserId(long user_id);
}
