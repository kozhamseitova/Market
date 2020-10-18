package com.company.models.interfaces;

import com.company.models.User;

import java.util.HashMap;

public interface IUserDao {
    void addUser(User user);
    User getUserByEmail(String email);
    long getUserIdByEmail(String email);
    HashMap<Long, String> getAllUsers();
}
