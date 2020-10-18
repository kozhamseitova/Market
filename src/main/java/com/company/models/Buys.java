package com.company.models;

public class Buys extends ShoppingCart {
    private long user_id;
    private int id;
    private String img;
    private String name;
    private Double price;

    public Buys() {
    }

    public Buys(long user_id, int id, String img, String name, Double price) {
        this.user_id = user_id;
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
