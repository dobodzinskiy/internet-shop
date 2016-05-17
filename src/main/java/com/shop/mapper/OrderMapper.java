package com.shop.mapper;

import com.shop.dto.OrderDto;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dobodzinskiy on 22.03.2016.
 */
@Component("orderMapper")
public class OrderMapper implements Mapper<Order, OrderDto> {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public Order fromDto(OrderDto orderDto) {
        Order order = new Order();

        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setOrderState(orderDto.getOrderState());
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
        orderDto.setOrderState(order.getOrderState());
        orderDto.setDate(order.getDate());

        return orderDto;
    }

    @Override
    public List<OrderDto> toDtoList(List<Order> orders) {
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        for(Order order : orders) {
            orderDtoList.add(this.toDto(order));
        }
        return orderDtoList;
    }

    @Override
    public List<Order> fromDtoList(List<OrderDto> orderDtos) {
        return null;
    }
}
