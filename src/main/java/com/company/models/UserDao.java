package com.company.models;


import com.company.models.interfaces.IUserDao;

import java.sql.*;
import java.util.HashMap;

public class UserDao implements IUserDao {

    Connection conn;
    private static UserDao instance = null;

    public static UserDao getInstance(){
        if(instance == null){
            instance = new UserDao();
        }
        return instance;
    }


    private UserDao(){

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
    public void addUser(User user){
        try {
            String sql = "INSERT INTO users(email, password) " +
                    "VALUES(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            String sql = "SELECT * FROM users WHERE email = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public long getUserIdByEmail(String email) {
        try {
            String sql = "SELECT id FROM users WHERE email = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public HashMap<Long, String> getAllUsers() {
        try {
            String sql = "SELECT user_id, email FROM users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            HashMap<Long, String> users = new HashMap<>();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("email")
                );
                users.put(user.getId(), user.getEmail());
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
