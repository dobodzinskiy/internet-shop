package com.shop.controller.rest;

import com.shop.dto.OrderDto;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<OrderDto> getOrders() {
        return orderService.getOrdersList();
    }

    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public OrderDto addOrder(@Valid @RequestBody OrderDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        orderDto.setUsername(authentication.getName());
        return orderService.confirmOrder(orderDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/change", method = RequestMethod.PUT)
    public OrderDto changeOrderStatus(@PathVariable("id") int orderId) {
        return orderService.changeStatus(orderId);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<OrderDto> getOrdersByUser(@PathVariable("id") int userId) {
        return orderService.getOrders(userId);
    }
}
