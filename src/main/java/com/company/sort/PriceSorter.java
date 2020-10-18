package com.company.sort;

import com.company.models.Products;

import java.util.Comparator;

public class PriceSorter implements Comparator<Products> {
    @Override
    public int compare(Products o1, Products o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
