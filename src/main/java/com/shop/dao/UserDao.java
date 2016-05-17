package com.shop.dao;

import com.shop.entity.Order;
import com.shop.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    User findByUserLogin(String login);

    List<User> getStaff();
}
