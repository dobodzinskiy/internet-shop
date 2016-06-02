package com.shop.mapper;

import com.shop.dto.OrderDto;
import com.shop.entity.Order;
import com.shop.entity.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component("orderMapper")
public class OrderMapper implements Mapper<Order, OrderDto> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Order fromDto(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setDate(new Date(System.currentTimeMillis()));
        order.setOrderState(OrderState.getEnum(orderDto.getOrderState()));
        order.setPrice(orderDto.getPrice());
        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setProducts(productMapper.toDtoList(order.getProducts()));
        orderDto.setUsername(order.getUser().getLogin());
        orderDto.setPrice(order.getPrice());
        orderDto.setOrderState(order.getOrderState().getValue());
        orderDto.setDate(order.getDate().toLocaleString());
        return orderDto;
    }

    @Override
    public List<OrderDto> toDtoList(List<Order> orders) {
        return orders.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Order> fromDtoList(List<OrderDto> orderDtos) {
        return null;
    }
}
