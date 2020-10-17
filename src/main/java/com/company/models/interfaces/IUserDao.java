package com.company.models.interfaces;

import com.company.models.User;

public interface IUserDao {
    void addUser(User user);
    User getUserByEmail(String email);
    long getUserIdByEmail(String email);
}
