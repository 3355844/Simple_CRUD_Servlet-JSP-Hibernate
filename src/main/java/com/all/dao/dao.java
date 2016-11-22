package com.all.dao;

import com.all.models.User;

import java.util.ArrayList;

/**
 * Created by user on 21.11.2016.
 */
public interface dao {
    void addUserToDb(User user);
    User returnById(int id);
    void update(User user);
    void deleteUser(int id);
    ArrayList<User> getAllUsers();
}
