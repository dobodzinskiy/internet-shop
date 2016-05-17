package com.shop.service;

import com.shop.dao.OrderDao;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.OrderDto;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.OrderState;
import com.shop.entity.Product;
import com.shop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MailService mailService;

    @Override
    public OrderDto getOrder(int id) {
        return orderMapper.toDto(orderDao.getOrder(id));
    }

    @Override
    public List<OrderDto> getOrdersList() {
        List<Order> orders = orderDao.getOrdersList();
        return orderMapper.toDtoList(orders);
    }

    @Override
    public List<OrderDto> getOrders(String userLogin) {
        List<Order> orders = orderDao.getOrders(userLogin);
        return orderMapper.toDtoList(orders);
    }

    @Override
    public List<OrderDto> getOrders(int id) {
        return orderMapper.toDtoList(orderDao.getOrders(id));
    }

    @Override
    public OrderDto confirmOrder(OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);

        List<Product> products = new ArrayList<>();
        for(ProductDto productDto : orderDto.getProducts()) {
            products.add(productDao.getProduct(productDto.getId()));
        }
        order.setProducts(products);

        order.setUser(userDao.findByUserLogin(orderDto.getUsername()));
        order.setOrderState(OrderState.ACCEPTED);
        order.setDate(new Date(System.currentTimeMillis()));


        orderDao.confirmOrder(order);
        mailService.orderConfirmMail(order);

        return orderMapper.toDto(order);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderDao.updateOrder(orderMapper.fromDto(orderDto));
    }

    @Override
    public OrderDto changeStatus(int id) {
        Order order = orderDao.getOrder(id);
        switch(order.getOrderState()) {
            case ACCEPTED:
                order.setOrderState(OrderState.IN_PROGRESS);
                break;
            case IN_PROGRESS:
                order.setOrderState(OrderState.SHIPPED);
                break;
            case SHIPPED:
                order.setOrderState(OrderState.DELIVERED);
                break;
            default: break;
        }
        orderDao.updateOrder(order);
        return orderMapper.toDto(order);
    }
}
