package com.shop.service;

import com.shop.dto.OrderDto;
import com.shop.entity.OrderState;

import java.util.List;

/**
 * Created by dobodzinskiy on 22.03.2016.
 */
public interface OrderService {

    OrderDto getOrder(int id);

    List<OrderDto> getOrdersList();

    List<OrderDto> getOrders(String userLogin);

    List<OrderDto> getOrders(int id);

    OrderDto confirmOrder(OrderDto orderDto);

    void updateOrder(OrderDto orderDto);

    OrderDto changeStatus(int id);
}
