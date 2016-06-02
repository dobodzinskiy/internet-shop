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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MailService mailService;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getOrdersList() {
        List<Order> orders = orderDao.getOrdersList();
        return orderMapper.toDtoList(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getOrders(String userLogin) {
        List<Order> orders = orderDao.getOrders(userLogin);
        return orderMapper.toDtoList(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getOrders(int id) {
        return orderMapper.toDtoList(orderDao.getOrders(id));
    }

    @Override
    public OrderDto confirmOrder(OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);
        List<Product> products = new ArrayList<>();

        for (ProductDto productDto : orderDto.getProducts()) {
            products.add(productDao.getProduct(productDto.getId()));
        }

        order.setProducts(products);
        order.setUser(userDao.findByUserLogin(orderDto.getUsername()));

        orderDao.confirmOrder(order);
        mailService.orderConfirmMail(order);
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto changeStatus(int id) {
        Order order = orderDao.getOrder(id);

        switch (order.getOrderState()) {
            case ACCEPTED:
                order.setOrderState(OrderState.IN_PROGRESS);
                break;
            case IN_PROGRESS:
                order.setOrderState(OrderState.SHIPPED);
                break;
            case SHIPPED:
                order.setOrderState(OrderState.DELIVERED);
                break;
            default:
                String message = "Order state is undefined";
                LOGGER.error(message);
                throw new IllegalArgumentException(message);
        }

        orderDao.updateOrder(order);
        return orderMapper.toDto(order);
    }
}
