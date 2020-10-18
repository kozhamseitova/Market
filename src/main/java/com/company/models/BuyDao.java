package com.company.models;

import com.company.models.interfaces.IBuyDao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BuyDao implements IBuyDao {

    Connection conn;
    private static BuyDao instance = null;

    public static BuyDao getInstance(){
        if(instance == null){
            instance = new BuyDao();
        }
        return instance;
    }


    private BuyDao(){

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
    public void addProductsToBuy(ShoppingCart shoppingCart) {
        try {
            String sql = "INSERT INTO buy(user_id, id, img, name, price) " +
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
    public List getProductsFromBuyByUserId(long user_id) {
        try {
            String sql = "SELECT * FROM buy WHERE user_id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();
            LinkedList<Buys> buys = new LinkedList<>();
            while (rs.next()) {
                Buys buy = new Buys(
                        rs.getLong("user_id"),
                        rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                buys.add(buy);
            }
            return buys;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
