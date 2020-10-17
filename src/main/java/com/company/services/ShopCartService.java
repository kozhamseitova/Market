package com.company.services;

import com.company.models.Products;
import com.company.models.ShoppingCart;

import java.util.LinkedList;

public class ShopCartService {

    LinkedList<ShoppingCart> shopCartServices = new LinkedList<>();

    public void addToSC(long user_id, int id, String img, String name, Double price){
        shopCartServices.add(new ShoppingCart(user_id,id,img,name,price));
    }

    public LinkedList<ShoppingCart> getAllShopCartProducts(){
        return shopCartServices;
    }
}

