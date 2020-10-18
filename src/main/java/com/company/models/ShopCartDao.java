package com.company.models;

import com.company.models.interfaces.IShopCartDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShopCartDao implements IShopCartDao {
    Connection conn;
    private static ShopCartDao instance = null;

    public static ShopCartDao getInstance(){
        if(instance == null){
            instance = new ShopCartDao();
        }
        return instance;
    }


    private ShopCartDao(){

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market", "postgres","1234");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addProductsToShopCart(ShoppingCart shoppingCart) {
        try {
            String sql = "INSERT INTO shopcart(user_id, id, img, name, price) " +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, shoppingCart.getUser_id());
            stmt.setInt(2, shoppingCart.getId());
            stmt.setString(3, shoppingCart.getImg());
            stmt.setString(4, shoppingCart.getName());
            stmt.setDouble(5, shoppingCart.getPrice());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List getProductsFromShopCartByUserId(long user_id) {
        try {
            String sql = "SELECT * FROM shopcart WHERE user_id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();
            LinkedList<ShoppingCart> shoppingCarts = new LinkedList<>();
            while (rs.next()) {
                ShoppingCart shoppingCart = new ShoppingCart(
                        rs.getLong("user_id"),
                        rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                shoppingCarts.add(shoppingCart);
            }
            return shoppingCarts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List removeFromShop(int id, long user_id) {
        try {
            String sql = "DELETE FROM shopcart WHERE id = ? and user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, user_id);
            return getProductsFromShopCartByUserId(user_id);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
