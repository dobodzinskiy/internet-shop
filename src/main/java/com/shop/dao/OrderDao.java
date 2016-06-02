package com.shop.dao;

import com.shop.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getOrdersList();

    Order getOrder(int id);

    List<Order> getOrders(String userLogin);

    List<Order> getOrders(int userId);

    void confirmOrder(Order order);

    void updateOrder(Order order);
}
