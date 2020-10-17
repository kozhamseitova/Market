package com.company.services;

import com.company.models.Products;

import java.util.LinkedList;

public class ProductsService {

    public static LinkedList<Products> getAllRings(){

        LinkedList<Products> ringsList = new LinkedList<>();

        ringsList.add(new Products(1,"jsp/img/gold.png", "Gold ring", 200000.00));
        ringsList.add(new Products(2,"jsp/img/silver.png", "Silver ring", 150000.00));
        ringsList.add(new Products(3,"jsp/img/weddingRing1.png", "Wedding rings", 400000.00));

        return ringsList;
    }

    public static LinkedList<Products> getAllBracelets(){

        LinkedList<Products> bracelets = new LinkedList<>();

        bracelets.add(new Products(1,"jsp/img/goldBracelet.png", "Gold bracelet", 200000.00));
        bracelets.add(new Products(2,"jsp/img/goldRollBr.png", "Gold diamond roll", 150000.00));
        bracelets.add(new Products(3,"jsp/img/coupleBr.png", "Couple bracelets", 400000.00));

        return bracelets;
    }

    public static LinkedList<Products> getAllNecklacesEarrings(){

        LinkedList<Products> neckEar = new LinkedList<>();

        neckEar.add(new Products(1,"jsp/img/diamondNE.png", "Diamond", 200000.00));
        neckEar.add(new Products(2,"jsp/img/goldNE.png", "Gold jewelry", 150000.00));
        neckEar.add(new Products(3,"jsp/img/BlackNE.png", "Jewelry with black stones", 400000.00));

        return neckEar;
    }
}
