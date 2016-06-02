package com.shop.service;

import com.shop.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOrdersList();

    List<OrderDto> getOrders(String userLogin);

    List<OrderDto> getOrders(int id);

    OrderDto confirmOrder(OrderDto orderDto);

    OrderDto changeStatus(int id);
}
