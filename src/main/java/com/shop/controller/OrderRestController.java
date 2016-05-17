package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.UTFDataFormatException;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<OrderDto> getOrders() {
        return orderService.getOrdersList();
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}/change", method = RequestMethod.PUT)
    public ResponseEntity<?> changeOrderStatus(@PathVariable("id") int orderId) {
        return new ResponseEntity<Object>(orderService.changeStatus(orderId), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public List<OrderDto> getOrdersByUser(@PathVariable("id") int userId) {
        return orderService.getOrders(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.confirmOrder(orderDto), HttpStatus.CREATED);
    }
}
